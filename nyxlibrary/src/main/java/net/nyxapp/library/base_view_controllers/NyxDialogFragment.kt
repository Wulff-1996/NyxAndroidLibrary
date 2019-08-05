package net.nyxapp.library.base_view_controllers

import androidx.fragment.app.DialogFragment

abstract class NyxDialogFragment : DialogFragment(), NyxViewController {

   // override var cancellableCall: NyxCall<Void>? = null
    override var cacheTag: String? = null


    override fun showErrorDialog(message: Pair<String?, String?>) {
        (activity as NyxActivity?)?.showErrorDialog(message)
    }

    override fun showWarningDialog(message: Pair<String?, String?>) {
        (activity as NyxActivity?)?.showErrorDialog(message)
    }

}