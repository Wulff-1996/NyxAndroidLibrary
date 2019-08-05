package net.nyxapp.extensions

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.nyxapp.library.base_view_controllers.NyxActivity

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
    }
}
