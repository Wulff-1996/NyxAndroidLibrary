package net.nyxapp.library.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.nyx_progress_bar_layout.view.*
import net.nyxapp.library.R

class NyxProgressBarSmall : ConstraintLayout {


    constructor(context: Context) : super(context)
    constructor(context: Context, attrSet: AttributeSet) : super(context, attrSet)
    constructor(context: Context, attrSet: AttributeSet, defStyleAttr: Int) : super(context, attrSet, defStyleAttr)

    init {
        LayoutInflater.from(context).inflate(R.layout.nyx_progress_bar_small_layout, this, true)
        val calculatedPadding =
            nyx_progress_bar.minimumHeight - (nyx_progress_bar.minimumHeight / Math.sqrt(2.0)).toInt()
        nyx_progress_bar.setPadding(calculatedPadding, calculatedPadding, calculatedPadding, calculatedPadding)
    }


}