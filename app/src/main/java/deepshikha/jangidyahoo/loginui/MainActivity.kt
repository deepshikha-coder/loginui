package deepshikha.jangidyahoo.loginui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {
    lateinit var log_in: Button
    lateinit var log_name: EditText
    lateinit var log_password: EditText

    lateinit var handler: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        log_in = findViewById(R.id.log_in)
        log_name = findViewById(R.id.login_name)
        log_password = findViewById(R.id.login_password)

        handler = DatabaseHelper(this)
        show_login()
        signing.setOnClickListener {
            show_registration()
        }

        save.setOnClickListener {
            handler.insertUserData(
                name.text.toString(),
                email.text.toString(),
                register_password.text.toString()
            )
            show_login()
        }
        log_in.isEnabled = false

        login_password.addTextChangedListener(TextWatcher)

        log_in.setOnClickListener {
            if (handler.userPresent(login_name.text.toString(), login_password.text.toString())) {
                if (checkBox.isChecked) {

                    val intent = Intent(this, activity2::class.java)
                    startActivity(intent)
                } else
                    Toast.makeText(this, "Agree to the terms", Toast.LENGTH_SHORT).show()
            } else
                Toast.makeText(this, "username or password is incorrect", Toast.LENGTH_SHORT).show()
        }


    }

    private fun show_registration() {
        registration_layout.visibility = View.VISIBLE
        login_layout.visibility = View.GONE
    }

    private fun show_login() {
        registration_layout.visibility = View.GONE
        login_layout.visibility = View.VISIBLE

    }

    private val TextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(
            s: CharSequence?,
            start: Int,
            count: Int,
            after: Int
        ) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            log_in.isEnabled = true

        }
    }
}









