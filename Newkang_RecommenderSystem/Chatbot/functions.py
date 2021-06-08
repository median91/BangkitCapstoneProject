import tensorflow as tf
import json
import random
import pandas as pd
import nltk
from Sastrawi.Stemmer.StemmerFactory import StemmerFactory
import numpy as np
from keras.models import Sequential
from keras.layers import Dense, Activation, Dropout
from keras.optimizers import SGD
from keras.models import load_model
from keras.models import model_from_json

factory = StemmerFactory()
stemmer = factory.create_stemmer()
nltk.download('punkt')
with open('intents2.json') as file:
    data = json.load(file)

df = pd.read_csv('capsdata.csv')
order = []

words = []
classes = []
documents = []
ignore_words = ['?']
# loop through each sentence in our intents patterns
for intent in data['intents']:
    for pattern in intent['patterns']:
        # tokenize each word in the sentence
        w = nltk.word_tokenize(pattern)
        # add to our words list
        words.extend(w)
        # add to documents in our corpus
        documents.append((w, intent['tag']))
        # add to our classes list
        if intent['tag'] not in classes:
            classes.append(intent['tag'])
# stem and lower each word and remove duplicates
words = [stemmer.stem(w.lower()) for w in words if w not in ignore_words]
words = sorted(list(set(words)))
# sort classes
classes = sorted(list(set(classes)))

# create our training data
training = []
# create an empty array for our output
output_empty = [0] * len(classes)
# training set, bag of words for each sentence
for doc in documents:
    # initialize our bag of words
    bag = []
    # list of tokenized words for the pattern
    pattern_words = doc[0]
    # stem each word - create base word, in attempt to represent related words
    pattern_words = [stemmer.stem(word.lower()) for word in pattern_words]
    # create our bag of words array with 1, if word match found in current pattern
    for w in words:
        bag.append(1) if w in pattern_words else bag.append(0)

    # output is a '0' for each tag and '1' for current tag (for each pattern)
    output_row = list(output_empty)
    output_row[classes.index(doc[1])] = 1

    training.append([bag, output_row])
# shuffle our features and turn into np.array
random.shuffle(training)
training = np.array(training)
# create train and test lists. X - patterns, Y - intents
train_x = list(training[:, 0])
train_y = list(training[:, 1])

try:
    converter = tf.lite.TFLiteConverter.from_saved_model('saved_model')
    tflite_model = converter.convert()

    with open('model.tflite', 'wb') as f:
        f.write(tflite_model)

    model = load_model("saved_model")
    json_file = open('model.json', 'r')
    loaded_model_json = json_file.read()
    json_file.close()
    model = model_from_json(loaded_model_json)
    model.load_weights("model.h5")

except:
    tf.compat.v1.reset_default_graph()
    model = Sequential()
    model.add(Dense(128, input_shape=(len(train_x[0]),), activation='relu'))
    model.add(Dropout(0.5))
    model.add(Dense(64, activation='relu'))
    model.add(Dropout(0.5))
    model.add(Dense(len(train_y[0]), activation='softmax'))

    sgd = SGD(lr=0.01, decay=1e-6, momentum=0.9, nesterov=True)
    model.compile(loss='categorical_crossentropy',
                  optimizer=sgd, metrics=['accuracy'])

    model.fit(np.array(train_x), np.array(train_y),
              epochs=200, batch_size=5, verbose=1)
    model.save("saved_model")
    model_json = model.to_json()
    with open("model.json", "w") as json_file:
        json_file.write(model_json)
    # serialize weights to HDF5
    model.save_weights("model.h5")

    converter = tf.lite.TFLiteConverter.from_saved_model('saved_model')
    tflite_model = converter.convert()

    with open('model.tflite', 'wb') as f:
        f.write(tflite_model)


def clean_up_sentence(sentence):
    # tokenize the pattern - split words into array
    sentence_words = nltk.word_tokenize(sentence)
    # stem each word - create short form for word
    sentence_words = [stemmer.stem(word.lower()) for word in sentence_words]
    return sentence_words
# return bag of words array: 0 or 1 for each word in the bag that exists in the sentence


def bow(sentence, words, show_details=True):
    # tokenize the pattern
    sentence_words = clean_up_sentence(sentence)
    # bag of words - matrix of N words, vocabulary matrix
    bag = [0]*len(words)
    for s in sentence_words:
        for i, w in enumerate(words):
            if w == s:
                # assign 1 if current word is in the vocabulary position
                bag[i] = 1
    return(np.array(bag))


def classify_local(sentence):
    ERROR_THRESHOLD = 0.25

    # generate probabilities from the model
    input_data = pd.DataFrame([bow(sentence, words)],
                              dtype=float, index=['input'])
    results = model.predict([input_data])[0]
    # filter out predictions below a threshold, and provide intent index
    results = [[i, r] for i, r in enumerate(results) if r > ERROR_THRESHOLD]
    # sort by strength of probability
    results.sort(key=lambda x: x[1], reverse=True)
    return_list = []
    for r in results:
        return_list.append((classes[r[0]], str(r[1])))
    # return tuple of intent and probability

    return classes[r[0]]


def recommend():
    print("Ceritakan permasalahan Anda")
    while True:
        inp = input("Anda: ")

        tag = classify_local(inp)
        if tag == 'cat dinding' and 'Cat Dinding' not in order:
            order.append('Cat Dinding')
        if tag == 'cat atap' and 'Cat Seng' not in order:
            order.append('Cat Seng')

        if tag == 'atap' and 'Atap' not in order:
            order.append('Atap')

        if tag == 'tembok' and 'Tembok' not in order:
            order.append('Tembok')

        if tag == 'pintu' and 'Pintu' not in order:
            order.append('Pintu')

        if tag == 'jendela' and 'Jendela' not in order:
            order.append('Jendela')

        if tag == 'wc' and 'WC' not in order:
            order.append('WC')

        if tag == 'lantai' and 'Lantai' not in order:
            order.append('Lantai')
        try:
            print(filter(order, df))
        except:
            break
        break


def filter(order, df):
    for i in order:
        df_filtered = df[df['layanan'].str.contains(
            i, regex=False, case=False, na=False)]
    return df_filtered.where(df['Rating'] > 4.0).dropna().loc[:, 'KODE':].head(10)
