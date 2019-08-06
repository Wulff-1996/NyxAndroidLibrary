package net.nyxapp.library.views

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.nyx_progress_image_view.view.*
import net.nyxapp.library.R

class NyxProgressImageView : ConstraintLayout, NyxImageViewProgressDelegate {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrSet: AttributeSet) : super(context, attrSet) {
        getAttributeSet(attrSet)
    }

    constructor(context: Context, attrSet: AttributeSet, defStyleAttr: Int) : super(context, attrSet, defStyleAttr) {
        getAttributeSet(attrSet)
    } //TODO: Implement variable border thickness

    override var processing: Boolean = false
        set(value) {
            field = value
            if (value) {
                progressBar.visibility = View.VISIBLE
                icon.text = null
            } else {
                progressBar.visibility = View.GONE
                icon.text = context.getString(R.string.icon_brand_instagram)
            }
        }

    private var image: NyxImageView

    init {
        LayoutInflater.from(context).inflate(R.layout.nyx_progress_image_view, this, true)
        image = nyx_progress_image_image
        image.delegate = this
    }

    var imageResource: String? = null
        set(value) {
            field = value
            image.imageResource = value
        }

    var fbId: String? = null
        set(value) {
            field = value
            if (value == null) {
                imageResource = null
            } else {
                imageResource = "https://graph.facebook.com/$value/picture?width=400&height=400" //TODO: Implement variable image size
            }
        }
    var icon: IconTextView = nyx_progress_image_icon
    private var progressBar: ProgressBar = nyx_progress_image_progress

    private fun getAttributeSet(attrSet: AttributeSet) {
        context.theme.obtainStyledAttributes(attrSet, R.styleable.NyxProgressImage, 0, 0).apply {
            try {
                getDimension(R.styleable.NyxProgressImage_size, 12f)
            } finally {
                recycle()
            }
        }
    }

    var size: Float = context.resources.getDimension(R.dimen.body_text_font_size)
        set(value) {
            field = value
            icon.setTextSize(TypedValue.COMPLEX_UNIT_DIP, value)
        }
}