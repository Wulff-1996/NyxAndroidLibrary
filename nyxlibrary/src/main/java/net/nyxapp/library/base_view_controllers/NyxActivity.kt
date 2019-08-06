package net.nyxapp.library.base_view_controllers

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.nyx_custom_toast.*
import kotlinx.android.synthetic.main.nyx_custom_toast.view.*
import net.nyxapp.library.R
import net.nyxapp.library.views.NyxInfoDialog


abstract class NyxActivity : AppCompatActivity(), NyxViewController {

    override var cacheTag: String? = null

    private var toast: Toast? = null

    var infoDialogOpen: Boolean = false

    override fun showNyxDialog(type: NyxInfoDialog.NyxInfoDialogType, message: Pair<String?, String>) {
        if (!isDestroyed && !isFinishing && !infoDialogOpen) {
            infoDialogOpen = true
            val dialog = NyxInfoDialog(this, message, type)
            dialog.delegate = this
            dialog.show()
        }
    }

    override fun showToast(message: String) {
        val layout = layoutInflater.inflate(R.layout.nyx_custom_toast, nyx_custom_toast)

        layout.nyx_toast_text.text = message

        toast = Toast(this)

        toast!!.duration = Toast.LENGTH_LONG

        toast!!.view = layout
        toast!!.show()
    }

    fun hideToast() {
        toast?.cancel()
    }

}
