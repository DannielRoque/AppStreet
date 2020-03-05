package com.example.appstreet.extension

import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

fun EditText.debounce(delegate: (text: String) -> Unit) {
    val timedebounce: Long = 1000
    var textTyped = ""
    val runnable = Runnable {
        delegate(textTyped)
    }

    val handler = Handler()

    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            handler.removeCallbacks(runnable)
            textTyped = text.toString()
            if (text != null) {
                handler.postDelayed(runnable, timedebounce)
            }
        }
    })
}

fun EditText.onChangeText(delegate: (text: String) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(
            textTyped: CharSequence?,
            start: Int,
            before: Int,
            count: Int
        ) {
            delegate(textTyped.toString())
        }
    })
}