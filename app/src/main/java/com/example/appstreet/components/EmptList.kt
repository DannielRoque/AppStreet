package com.example.appstreet.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.appstreet.R
import kotlinx.android.synthetic.main.component_empty_list.view.*

class EmptList @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    init {
        LayoutInflater.from(context).inflate(R.layout.component_empty_list, this, true)
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.EmptyList, 0, 0)
            emptyListExpression.text = typedArray.getString(R.styleable.EmptyList_title)
            emptyListMessage.text = typedArray.getString(R.styleable.EmptyList_message)
        }
    }
}