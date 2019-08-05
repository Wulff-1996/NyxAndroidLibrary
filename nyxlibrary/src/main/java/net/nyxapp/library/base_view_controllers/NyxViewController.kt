package net.nyxapp.library.base_view_controllers

/** An interface implemented by both [NyxActivity] and [NyxFragment] */
interface NyxViewController {

    /**Is used from ViewControllers to show feedback, mainly from async operations as API calls. Takes a pair so the [NyxExceptionParser] can return a single object and pass directly to this method
     * First index of pair is header, second is bodytext. Both are nullable and will be replaced by generic texts if null.
     * */
    fun showErrorDialog(message: Pair<String?, String?>)
    fun showWarningDialog(message: Pair<String?, String?>)
    val cacheTag: String?

}