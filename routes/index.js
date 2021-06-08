const express = require('express');
const router = express.Router();
const tf = require('@tensorflow/tfjs-node');
const path = require('path');
let model = null;

function paddingArray(sequence, padding) {
    const insertPadding = padding - sequence.length;
    for (let i = 0; i < insertPadding; i++) {
        sequence.push(0);
    }
    return sequence;
}

function processOutput(output) {
    return output.reduce(function (result, current) {
        result.push(current[0]);
        return result;
    }, []);
}

router.get('/', async function (req, res) {
    try {
        if (!model) model = await tf.node.loadSavedModel(path.join(__dirname, '..', 'Newkang_RecommenderSystem', 'Chatbot', 'saved_model'));
        const input = textToSequence(req.query.input);
        const result = model.predict(tf.tensor(input));
        return res.json(processOutput(await result.array()));
    } catch (e) {
        console.log(e);
        return res.send('error');
    }
});

module.exports = router;
