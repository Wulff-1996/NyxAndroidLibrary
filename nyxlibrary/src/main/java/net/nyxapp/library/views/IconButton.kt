package net.nyxapp.library.views

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import net.nyxapp.library.R

open class IconButton : AppCompatButton {

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        getAttributes(attrs)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        getAttributes(attrs)
    }

    constructor(context: Context) : super(context)

    private fun getAttributes(attrSet: AttributeSet) {
        context.theme.obtainStyledAttributes(
                attrSet,
                R.styleable.IconButton,
                0, 0).apply {
            try {
                setType(context, getInt(R.styleable.IconButton_button_type, IconTextView.ICON_TYPE_LIGHT))
            } finally {
                recycle()
            }
        }
    }

    private fun setType(context: Context, type: Int) {
        when (type) {
            IconTextView.ICON_TYPE_LIGHT -> this.typeface = Typeface.createFromAsset(context.assets, "Font-Awesome-5-Pro-Light-300.otf")
            IconTextView.ICON_TYPE_BRAND -> this.typeface = Typeface.createFromAsset(context.assets, "Font-Awesome-5-Brands-Regular-400.otf")
            IconTextView.ICON_TYPE_SOLID -> this.typeface = Typeface.createFromAsset(context.assets, "Font-Awesome-5-Pro-Solid-900.otf")
            IconTextView.ICON_TYPE_REGULAR -> this.typeface = Typeface.createFromAsset(context.assets, "Font-Awesome-5-Pro-Regular-400.otf")
            IconTextView.ICON_TYPE_MATERIAL -> this.typeface = Typeface.createFromAsset(context.assets, "Material-Design-Iconic-Font.ttf")
        }
    }
}

