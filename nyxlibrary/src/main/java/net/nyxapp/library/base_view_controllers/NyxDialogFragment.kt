package net.nyxapp.library.base_view_controllers

import androidx.fragment.app.DialogFragment
import net.nyxapp.library.views.NyxInfoDialog

abstract class NyxDialogFragment : DialogFragment(), NyxViewController {

    override val cacheTag: String? = null
    override fun showNyxDialog(type: NyxInfoDialog.NyxInfoDialogType, message: Pair<String?, String>) {
        (activity as NyxActivity?)?.showNyxDialog(type, message)
    }
    override fun showToast(message: String) {
        (activity as NyxActivity?)?.showToast(message)
    }

}