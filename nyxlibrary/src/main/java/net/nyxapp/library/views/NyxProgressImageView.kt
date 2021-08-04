package net.nyxapp.library.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.nyx_progress_image_view.view.*
import net.nyxapp.library.R

/**
 * Wrapper for [NyxImageView] specific for loading facebook images
 *      image available -> show image, fetched with dimensions needed for image size
 *      no image -> shows placeholder icon for image
 */
class NyxProgressImageView : ConstraintLayout, NyxImageViewProgressDelegate {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    override var processing: Boolean = false // shows progress bar while loading, hides placeholder icon meantime
        set(value) {
            field = value
            if (value) {
                progressBar.visibility = View.VISIBLE
                placeholderIcon.visibility = View.GONE
            } else {
                progressBar.visibility = View.GONE
                placeholderIcon.visibility = View.VISIBLE
            }
        }

    private var image: NyxImageView
    private var progressBar: ProgressBar
    private var placeholderIcon: ImageView
    private var imageDimension: Int? = null // variable to request image size on profile images facebook

    var imageResource: String? = null
        set(value) {
            field = value
            image.imageResource = value
        }

    var fbId: String? = null
        set(value) {
            field = value
            if (field == null) {
                // no image hide loading and show placeholder icon
                imageResource = null
                processing = false
            } else if (imageDimension != null) {
                setImageResource()
            }
        }

    init {
        LayoutInflater.from(context).inflate(R.layout.nyx_progress_image_view, this, true)
        image = nyx_progress_image_image
        image.delegate = this
        progressBar = nyx_progress_image_progress
        placeholderIcon = nyx_progress_image_view_placeholder_icon

        // check if dimension of the image has been set
        if (imageDimension == null) {
            this.post { // wait for view to get size before deciding image size needed
                // set the image dimension
                imageDimension = this.measuredHeight

                if (fbId == null) {
                    // no image available/unassigned task -> show placeholder without loading etc.
                    imageResource = null
                    processing = false
                } else {
                    setImageResource()
                }
            }
        }
    }

    // requests the image from facebook and set the image
    private fun setImageResource() {
        imageResource = "https://graph.facebook.com/$fbId/picture?type=square&width=$imageDimension&height=$imageDimension"
    }
}