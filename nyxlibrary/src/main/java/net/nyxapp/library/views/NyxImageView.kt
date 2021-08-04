package net.nyxapp.library.views

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import net.nyxapp.library.R

class NyxImageView : AppCompatImageView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrSet: AttributeSet) : super(context, attrSet) { getAttributes(attrSet) }
    constructor(context: Context, attrSet: AttributeSet, defStyleAttr: Int) : super(context, attrSet, defStyleAttr) { getAttributes(attrSet) }

    var delegate: NyxImageViewProgressDelegate? = null
    var imageType: NyxImageType = NyxImageType.ROUNDED
    var imageResource: String? = null
        set(value) {
            field = value
            Picasso.with(context).cancelRequest(this)
            if (value != null) {
                delegate?.processing = true
                Picasso.with(context).load(value).fit().centerCrop()
                        .into(this, object : Callback {
                            override fun onSuccess() {
                                delegate?.processing = false
                                val imageBitmap = (drawable as BitmapDrawable).bitmap
                                val imageDrawable = RoundedBitmapDrawableFactory.create(resources, imageBitmap)
                                imageDrawable.cornerRadius = when (imageType) {
                                    NyxImageType.CIRCLE -> (Int.MAX_VALUE) * 1f
                                    NyxImageType.ROUNDED -> (context.resources.getDimension(R.dimen.image_corner_radius) / Resources.getSystem().displayMetrics.density)
                                    NyxImageType.SQUARE -> 0f
                                }
                                setImageDrawable(imageDrawable)
                            }

                        override fun onError() {
                            delegate?.processing = false
                        }
                    })
            } else {
                this.setImageResource(R.color.transparent)
            }
        }

    private fun getAttributes(attrSet: AttributeSet) {
        context.theme.obtainStyledAttributes(attrSet, R.styleable.NyxImageView, 0, 0).apply {
            try {
                imageResource = getString(R.styleable.NyxImageView_image)
                imageType = when (getInt(R.styleable.NyxImageView_imageType, 0)) {
                    1 -> NyxImageType.CIRCLE
                    2 -> NyxImageType.SQUARE
                    else -> NyxImageType.ROUNDED
                }
            } finally {
                recycle()
            }
        }
    }

    enum class NyxImageType {
        ROUNDED,
        CIRCLE,
        SQUARE
    }
}

interface NyxImageViewProgressDelegate {
    var processing: Boolean
}

