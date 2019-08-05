package net.nyxapp.library.base_view_controllers

import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class NyxFragment : Fragment(), NyxViewController {

    private val savable = Bundle()

    private var lastFetch: Long? = null
    override val cacheTag: String? = null

    override fun showErrorDialog(message: Pair<String?, String?>) {
        (activity as NyxActivity?)?.showErrorDialog(message)
    }

    fun showSuccessDialog(message: Pair<String?, String?>) {
        (activity as NyxActivity?)?.showSuccessDialog(message)
    }

    override fun showWarningDialog(message: Pair<String?, String?>) {
        (activity as NyxActivity?)?.showWarningDialog(message)
    }

    fun showToast(message: String) {
        (activity as NyxActivity?)?.showToast(message)
    }

    fun hideToast() {
        (activity as NyxActivity?)?.hideToast()
    }
}

