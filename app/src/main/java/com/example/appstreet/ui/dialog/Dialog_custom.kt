package com.example.appstreet.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import com.example.appstreet.R
import kotlinx.android.synthetic.main.custom_alert_dialog.*

class Dialog_custom(context: Context) : Dialog(context) {
    private var labelPositiveButtom: String? = null
    private var labelNegativeButtom: String? = null
    private var message: String? = null
    private var title: String? = null
    private var activePosiitiveButtom: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.custom_alert_dialog)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setupNegativeButtom()
        setupPositiveButtom()
        setupMessage()
        setupTitle()
    }

    fun setLabelPositiveButtom(title: String): Dialog_custom {
        labelPositiveButtom = title
        return this
    }

    fun setNegativeButtom(title: String): Dialog_custom {
        labelNegativeButtom = title
        return this
    }

    fun setMessage(message: String): Dialog_custom {
        this.message = message
        return this
    }

    fun setTitle(title: String): Dialog_custom {
        this.title = title
        return this
    }

    fun setActivePositiveButtom(): Dialog_custom {
        activePosiitiveButtom = true
        return this
    }

    private fun setupNegativeButtom() {
        dialog_custom_canelar.apply {
            text = labelNegativeButtom
            setOnClickListener {
                dismiss()
            }
        }
    }

    private fun setupPositiveButtom() {
        dialog_buttom_ok.apply {
            alpha = if (this@Dialog_custom.activePosiitiveButtom) 1F else 0.3F
            isEnabled = this@Dialog_custom.activePosiitiveButtom
            text = labelPositiveButtom
            setOnClickListener {
                dismiss()
            }
        }
    }

    private fun setupMessage() {
        if (message.isNullOrBlank()) {
            custom_dialog_message.apply {
                visibility = View.GONE
            }
        } else {
            custom_dialog_message.apply {
                visibility = View.VISIBLE
                text = message
            }
        }
    }

    private fun setupTitle(): Dialog_custom {
        custom_dialog_title?.text = title
        return this
    }
}