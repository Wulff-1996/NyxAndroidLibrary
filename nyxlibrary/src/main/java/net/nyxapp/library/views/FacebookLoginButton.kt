package net.nyxapp.library.views

import android.content.Context

import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.facebook_login_button.view.*
import net.nyxapp.library.R


class FacebookLoginButton : ConstraintLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrSet: AttributeSet) : super(context, attrSet) {
        getAttributSet(attrSet)
    }
    constructor(context: Context, attrSet: AttributeSet, defStyleAttr: Int) : super(context, attrSet, defStyleAttr) {
        getAttributSet(attrSet)
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.facebook_login_button, this, true)
    }

    fun getAttributSet(attrSet: AttributeSet) {
        val set = intArrayOf(
            android.R.attr.text
        )
        val styledAttributes = context.obtainStyledAttributes(attrSet, set)
        text = styledAttributes.getString(0)
        styledAttributes.recycle()
    }

    var text: String? = null
        set(value) {
            field = value
            facebook_button_text.text = value
        }

}