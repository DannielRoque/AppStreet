package com.example.appstreet.ui.dialog

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.example.appstreet.R

class LoadingDialog(context: Context) :Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_loading_dialog)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
    }
}
