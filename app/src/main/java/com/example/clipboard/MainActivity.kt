package com.example.clipboard

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val clipboardLabel = "CLIPBOARD_LABEL"
    private var clipboardManager: ClipboardManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        btnCopyData.setOnClickListener {
            val data: String = tilData.editText?.text.toString()

            if (!TextUtils.isEmpty(data)) {
                val clip = ClipData.newPlainText(clipboardLabel, data)
                clipboardManager?.setPrimaryClip(clip)

                txtResult.text = clipboardManager?.primaryClip?.getItemAt(0)?.text.toString()
            } else {
                Toast.makeText(this@MainActivity,
                    "Filed is empty.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}