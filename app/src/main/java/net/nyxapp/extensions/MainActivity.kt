package net.nyxapp.extensions

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.nyxapp.library.base_view_controllers.NyxActivity
import net.nyxapp.library.views.NyxInfoDialog

class MainActivity : NyxActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        facebook_login_button.setOnClickListener {
            showToast("Facebook login clicked")
        }
        rounded_button_employee.setOnClickListener {
            showToast("Employee button clicked")
        }
        rounded_button_member.setOnClickListener {
            showToast("Member button clicked")
        }

        functions_show_toast.setOnClickListener {
            showToast("Showing custom Toast")
        }
        functions_show_error_dialog.setOnClickListener {
            showNyxDialog(NyxInfoDialog.NyxInfoDialogType.ERROR, Pair(null, "Error dialog message"))
        }
        functions_show_warning_dialog.setOnClickListener {
            showNyxDialog(NyxInfoDialog.NyxInfoDialogType.WARNING, Pair(null, "Warning dialog message"))
        }
        functions_show_success_dialog.setOnClickListener {
            showNyxDialog(NyxInfoDialog.NyxInfoDialogType.SUCCESS, Pair(null, "Success dialog message"))
        }
        functions_show_info_dialog.setOnClickListener {
            showNyxDialog(NyxInfoDialog.NyxInfoDialogType.INFO, Pair(null, "Info dialog message"))
        }

    }
}
