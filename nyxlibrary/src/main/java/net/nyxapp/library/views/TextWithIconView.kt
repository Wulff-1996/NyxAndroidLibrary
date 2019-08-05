package net.nyxapp.library.views

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.textview_with_icon.view.*
import net.nyxapp.library.R
import net.nyxapp.library.views.IconTextView.Companion.ICON_TYPE_LIGHT

/**
 * A simple layout containing a TextView and two IconViews - one on each side of the TextView, choose which one to populate with the "icon_placement" attribute. When setting an icon remember to use the icon variable.
 */

class TextWithIconView : ConstraintLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrSet: AttributeSet) : super(context, attrSet) {
        getAttributes(attrSet)
    }

    constructor(context: Context, attrSet: AttributeSet, defStyleAttr: Int) : super(context, attrSet, defStyleAttr) {
        getAttributes(attrSet)
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.textview_with_icon, this, true)
    }

    var textView: TextView = text_with_icon_text
    var iconView: IconTextView = text_with_icon_icon_after

    private fun getAttributes(attrSet: AttributeSet) {
        context.theme.obtainStyledAttributes(
            attrSet,
            R.styleable.TextWithIconView,
            0, 0
        ).apply {
            try {
                if ("0" == getString(R.styleable.TextWithIconView_icon_placement)) {
                    iconView = text_with_icon_icon_before
                }
                color = getColor(R.styleable.TextWithIconView_text_and_icon_color, context.getColor(R.color.text))
                textView.setTextColor(getColor(R.styleable.TextWithIconView_text_color, color))
                text = getString(R.styleable.TextWithIconView_text)
                icon = getString(R.styleable.TextWithIconView_nyx_icon)
                iconView.setTextColor(getColor(R.styleable.TextWithIconView_icon_color, color))
                iconView.setType(context, getInt(R.styleable.TextWithIconView_icon_type, ICON_TYPE_LIGHT))
                if (getDimension(
                        R.styleable.TextWithIconView_icon_size,
                        0f
                    ) != 0f
                ) iconView.setTextSize(
                    TypedValue.COMPLEX_UNIT_PX,
                    getDimension(R.styleable.TextWithIconView_icon_size, 0f)
                )
                setAlignment(getString(R.styleable.TextWithIconView_text_alignment) ?: "0")
                if (getDimension(R.styleable.TextWithIconView_icon_width, -1f) != -1f) {
                    iconView.width = (getDimension(R.styleable.TextWithIconView_icon_width, -1f)).toInt()
                    iconView.gravity = Gravity.CENTER_HORIZONTAL
                }
                if (getDimension(R.styleable.TextWithIconView_text_width, -1f) != -1f) {
                    textView.width = (getDimension(R.styleable.TextWithIconView_text_width, -1f)).toInt()
                }
                if (getDimension(
                        R.styleable.TextWithIconView_text_size,
                        0f
                    ) != 0f
                ) textView.setTextSize(
                    TypedValue.COMPLEX_UNIT_PX,
                    getDimension(R.styleable.TextWithIconView_text_size, 0f)
                )

            } finally {
                recycle()
            }
        }
    }

    private fun setAlignment(value: String?) {
        val set = ConstraintSet()
        set.clone(this)
        when (value) {
            "1" -> set.setHorizontalBias(R.id.text_with_icon_text, 0.5f)
            "2" -> set.setHorizontalBias(R.id.text_with_icon_text, 1f)
            else -> set.setHorizontalBias(R.id.text_with_icon_text, 0f)
        }
        set.applyTo(this)
    }

    fun clear() {
        textView.text = null
        iconView.text = null
    }

    var color: Int = context.getColor(R.color.text)
        set(value) {
            field = value
            textView.setTextColor(value)
            iconView.setTextColor(value)
        }

    var icon: String? = null
        set(value) {
            field = value
            if (value == "" || value == null) {
                iconView.visibility = View.GONE
            } else {
                iconView.text = value
                iconView.visibility = View.VISIBLE
            }
        }

    var text: String? = null
        set(value) {
            field = value
            textView.text = value
        }


}