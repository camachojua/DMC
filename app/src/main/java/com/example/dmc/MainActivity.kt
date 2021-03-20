package com.example.dmc

import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.login_fragment.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_fragment)

        next_button.setOnClickListener {
            if (!isPasswordValid(password_edit_text.text!!)) {
                password_text_input.error = "Password demasiado corto."
            } else {
                password_text_input.error = null;
            }
        }

        password_edit_text.addTextChangedListener {
            if (isPasswordValid(password_edit_text.text!!))
                password_text_input.error = null
        }
    }

    private fun isPasswordValid(text: Editable?): Boolean{
        return text != null && text.length >= 8;
    }
}