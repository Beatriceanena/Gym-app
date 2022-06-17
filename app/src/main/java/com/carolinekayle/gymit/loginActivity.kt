package com.carolinekayle.gymit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.Button
import android.widget.TextView
import androidx.core.util.PatternsCompat.EMAIL_ADDRESS
import com.carolinekayle.gymit.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class loginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.tvSignup.setOnClickListener {
            validateLogin()
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)

        }
        binding.btnLogin.setOnClickListener {
            validateLogin()
            startActivity(Intent(this, HomeActivity::class.java))

        }
    }

        fun validateLogin() {
            var error = false
            binding.tilEmail3.error = null
            binding.tilPassword.error = null
            var email = binding.etEmail.text.toString()
            if (email.isBlank()) {
                binding.tilEmail3.error = "Email is required"
                error = true
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.tilEmail3.error = "Not a valid email adddress"
                error = true
            }


            var password = binding.etPassword.text.toString()
            if (password.isBlank()) {
               binding.tilPassword.error = "Password is required"
                error = true

            }
            if (!error) {


            }
        }
    }
