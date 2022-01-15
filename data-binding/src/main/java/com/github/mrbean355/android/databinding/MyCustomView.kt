package com.github.mrbean355.android.databinding

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class MyCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    fun setMyText(text: CharSequence?) {
        setText(context.getString(R.string.custom_view_prefix, text))
    }
}