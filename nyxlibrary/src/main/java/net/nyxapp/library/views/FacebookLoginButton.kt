package net.nyxapp.library.views

import android.content.Context

import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout

import net.nyxapp.library.R

class FacebookLoginButton : ConstraintLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrSet: AttributeSet) : super(context, attrSet)
    constructor(context: Context, attrSet: AttributeSet, defStyleAttr: Int) : super(context, attrSet, defStyleAttr)

    init {
        LayoutInflater.from(context).inflate(R.layout.facebook_login_button, this, true)
    }

}