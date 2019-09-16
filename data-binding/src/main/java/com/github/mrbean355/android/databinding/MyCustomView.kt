package com.github.mrbean355.android.databinding

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

class MyCustomView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : TextView(context, attrs, defStyleAttr) {

    fun setMyText(text: CharSequence?) {
        setText(context.getString(R.string.custom_view_prefix, text))
    }
}