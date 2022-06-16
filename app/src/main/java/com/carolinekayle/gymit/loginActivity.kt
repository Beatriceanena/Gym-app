package com.carolinekayle.gymit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.Button
import android.widget.TextView
import androidx.core.util.PatternsCompat.EMAIL_ADDRESS
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class loginActivity : AppCompatActivity() {
    lateinit var btnLogin:Button
    lateinit var tilEmail:TextInputLayout
    lateinit var etEmail: TextInputEditText
    lateinit var tilPassword:TextInputLayout
    lateinit var etPassword:TextInputEditText
    lateinit var tvSignup:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin=findViewById(R.id.btnLogin)
        tilEmail=findViewById(R.id.tilEmail)
        etEmail=findViewById(R.id.etEmail)
        tilPassword=findViewById(R.id.tilPassword)
        etPassword=findViewById(R.id.etPassword)
        tvSignup=findViewById(R.id.tvSignup)
        tvSignup.setOnClickListener { validateLogin()
           val intent= Intent(this,SignupActivity::class.java)
            startActivity(intent)

        }
      btnLogin.setOnClickListener {
          validateLogin()
          startActivity(Intent(this,HomeActivity::class.java))

      }

    }
    fun validateLogin(){
        var error=false
        tilEmail.error=null
        tilPassword.error=null
        var email=etEmail.text.toString()
        if(email.isBlank()){
            tilEmail.error="Email is required"
            error=true
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            tilEmail.error="Not a valid email adddress"
                error=true
            }


        var password=etPassword.text.toString()
        if(password.isBlank()){
            tilPassword.error="Password is required"
            error=true

        }
        if(!error){


        }
    }
}