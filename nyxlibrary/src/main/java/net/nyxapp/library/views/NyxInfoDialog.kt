package net.nyxapp.library.views

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import kotlinx.android.synthetic.main.nyx_dialog.*
import net.nyxapp.library.R
import net.nyxapp.library.base_view_controllers.NyxActivity


class NyxInfoDialog(var context: Activity, private val message: Pair<String?, String>, val type: NyxInfoDialogType)
    : Dialog(context) {

    var delegate: NyxActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.nyx_dialog)

        setupHeader()
        setupMessage()
        setTapToClose()
    }

    private fun setupHeader() {
        when (type) {
            NyxInfoDialogType.SUCCESS -> {
                nyx_dialog_icon.setTextColor(context.getColor(R.color.success))
                nyx_dialog_icon.text = context.getString(R.string.icon_checked_circle)
                nyx_dialog_header.text = context.getString(R.string.success_dialog_generic_header)
            }
            NyxInfoDialogType.ERROR -> {
                nyx_dialog_icon.setTextColor(context.getColor(R.color.danger))
                nyx_dialog_icon.text = context.getString(R.string.icon_circle_cross)
                nyx_dialog_header.text = context.getString(R.string.error_dialog_generic_header)
            }
            NyxInfoDialogType.WARNING -> {
                nyx_dialog_icon.setTextColor(context.getColor(R.color.warning))
                nyx_dialog_icon.setType(context, IconTextView.ICON_TYPE_SOLID)
                nyx_dialog_icon.text = context.getString(R.string.icon_warning)
                nyx_dialog_header.text = context.getString(R.string.warning_dialog_generic_header)
            }
            NyxInfoDialogType.FLAG -> {
                nyx_dialog_icon.setTextColor(context.getColor(R.color.danger))
                nyx_dialog_icon.text = context.getString(R.string.icon_flag)
                nyx_dialog_icon.setType(context, IconTextView.ICON_TYPE_SOLID)
                nyx_dialog_header.text = context.getString(R.string.member_flagged_dialog_header)
            }
            NyxInfoDialogType.INFO -> {
                nyx_dialog_icon.setTextColor(context.getColor(R.color.text))
                nyx_dialog_icon.text = context.getString(R.string.icon_info_circle)
                nyx_dialog_header.text = context.getString(R.string.info_dialog_generic_header)
            }
        }
        if (message.first != null) nyx_dialog_header.text = message.first
    }

    private fun setupMessage() {
        nyx_dialog_message.text = message.second

    }

    private fun setTapToClose() {
        nyx_dialog_layout.setOnClickListener {
            dismiss()
        }
    }

    override fun dismiss() {
        delegate?.infoDialogOpen = false
        delegate = null
        super.dismiss()
    }

    enum class NyxInfoDialogType {
        ERROR,
        WARNING,
        SUCCESS,
        FLAG,
        INFO
    }
}