package com.dicoding.capstonenewkang.ui.activity

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.dicoding.capstonenewkang.R
import com.dicoding.capstonenewkang.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity(){

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var text: TextView
    private var title = "Payment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityPaymentBinding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(activityPaymentBinding.root)
        setActionBarTitle(title)

        text = findViewById(R.id.va_number)
        activityPaymentBinding.btnCopy
        activityPaymentBinding.expandTextView.setText(getString(R.string.dummy_text))
        activityPaymentBinding.btnCopy.setOnClickListener {
            copyTextToClipboard()
        }
    }

    private fun copyTextToClipboard() {
        val text = text.text
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", text)
        clipboardManager.setPrimaryClip(clipData)
        Toast.makeText(this, "Text copied to clipboard", Toast.LENGTH_LONG).show()
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }
}