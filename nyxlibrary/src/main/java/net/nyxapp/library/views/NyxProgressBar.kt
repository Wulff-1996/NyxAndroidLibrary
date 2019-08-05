package net.nyxapp.library.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.nyx_progress_bar_layout.view.*
import net.nyxapp.library.R
import java.lang.Math.sqrt

class NyxProgressBar : ConstraintLayout {

    constructor(context: Context, showText: Boolean) : super(context) {
        processTextVisible = showText
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrSet: AttributeSet) : super(context, attrSet) {
        getAttributeSet(attrSet)
    }
    constructor(context: Context, attrSet: AttributeSet, defStyleAttr: Int) : super(context, attrSet, defStyleAttr) {
        getAttributeSet(attrSet)
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.nyx_progress_bar_layout, this, true)
        val calculatedPaddingHeight = nyx_progress_bar.minimumHeight - (nyx_progress_bar.minimumHeight / sqrt(2.0)).toInt()
        val calculatedPaddingWidth = nyx_progress_bar.minimumWidth - (nyx_progress_bar.minimumWidth / sqrt(2.0)).toInt()
        nyx_progress_bar.setPadding(calculatedPaddingWidth, calculatedPaddingHeight, calculatedPaddingWidth, calculatedPaddingHeight)
    }

    private var processTextVisible: Boolean = true
        set(value) {
            field = value
            this.nyx_progress_text.visibility = if (field) View.VISIBLE else View.GONE
        }

    private fun getAttributeSet(attrSet: AttributeSet) {
        context.theme.obtainStyledAttributes(
                attrSet,
                R.styleable.NyxProgressBar,
                0, 0).apply {
            try {
                processTextVisible = getBoolean(R.styleable.NyxProgressBar_textVisible, true)
            } finally {
                recycle()
            }
        }
        context.theme.obtainStyledAttributes(
            attrSet,
            R.styleable.Accent,
            0, 0).apply {
            try {
                 when (getInt(R.styleable.Accent_accent, 0)) {
                     0 -> nyx_progress_bar.indeterminateDrawable = context.getDrawable(R.drawable.nyx_spinning_logo_member)
                     1 -> nyx_progress_bar.indeterminateDrawable = context.getDrawable(R.drawable.nyx_spinning_logo_employee)
                 }
            } finally {
                recycle()
            }
        }
    }
}