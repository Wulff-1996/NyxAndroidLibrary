package net.nyxapp.library.views

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView
import net.nyxapp.library.R

open class IconTextView : TextView {

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        getAttributeSet(attrs)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        getAttributeSet(attrs)
    }

    var textColor: Int? = null
        set(value) {
            field = value
            if (value != null) {
                setTextColor(value)
            }
        }

    constructor(context: Context) : super(context)

    private fun getAttributeSet(attrSet: AttributeSet) {
        context.theme.obtainStyledAttributes(
                attrSet,
                R.styleable.IconTextView,
                0, 0).apply {
            try {
                setType(context, getInt(R.styleable.IconTextView_type, ICON_TYPE_LIGHT))
            } finally {
                recycle()
            }
        }
    }

    fun setType(context: Context, type: Int) {
        when (type) {
            ICON_TYPE_LIGHT -> this.typeface = Typeface.createFromAsset(context.assets, "Font-Awesome-5-Pro-Light-300.otf")
            ICON_TYPE_BRAND -> this.typeface = Typeface.createFromAsset(context.assets, "Font-Awesome-5-Brands-Regular-400.otf")
            ICON_TYPE_SOLID -> this.typeface = Typeface.createFromAsset(context.assets, "Font-Awesome-5-Pro-Solid-900.otf")
            ICON_TYPE_REGULAR -> this.typeface = Typeface.createFromAsset(context.assets, "Font-Awesome-5-Pro-Regular-400.otf")
            ICON_TYPE_MATERIAL -> this.typeface = Typeface.createFromAsset(context.assets, "Material-Design-Iconic-Font.ttf")
            ICON_TYPE_MIXED -> this.typeface = Typeface.createFromAsset(context.assets, "nyx-mixed-icons.ttf")
        }
    }

    companion object {
        const val ICON_TYPE_LIGHT = 0
        const val ICON_TYPE_BRAND = 1
        const val ICON_TYPE_SOLID = 2
        const val ICON_TYPE_REGULAR = 3
        const val ICON_TYPE_MATERIAL = 4
        const val ICON_TYPE_MIXED = 5
    }
}

