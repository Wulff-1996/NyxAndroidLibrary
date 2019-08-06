package net.nyxapp.library.base_view_controllers

import net.nyxapp.library.views.NyxInfoDialog

/** An interface implemented by both [NyxActivity] and [NyxFragment] */
interface NyxViewController {

    /**Is used from ViewControllers to show feedback, mainly from async operations as API calls. Takes a pair so the [NyxExceptionParser] can return a single object and pass directly to this method
     * First index of pair is header, second is bodytext. Both are nullable and will be replaced by generic texts if null.
     * */
    fun showNyxDialog(type: NyxInfoDialog.NyxInfoDialogType, message: Pair<String?, String>)
    fun showToast(message: String)
    val cacheTag: String?

}