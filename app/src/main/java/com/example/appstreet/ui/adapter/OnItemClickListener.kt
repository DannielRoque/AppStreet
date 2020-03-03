package com.example.appstreet.ui.adapter

interface OnItemClickListener {
    fun onItemClick(
        view: String,
        position: Int
    )
}
interface OnLongClickListener{
    fun onLongCLick(
        view: String,
        position: Int
    ): Boolean
}

