package com.carolinekayle.gymit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var btnSignup2: Button
    lateinit var tilEmail: TextInputLayout
    lateinit var etEmail: TextInputEditText
    lateinit var tilPassword2: TextInputLayout
    lateinit var etPassword2: TextInputEditText
    lateinit var tilFirstname:TextInputLayout
    lateinit var tilLastName:TextInputLayout
    lateinit var etFirstName:TextInputEditText
    lateinit var etLastName:TextInputEditText
    lateinit var etConfirm:TextInputEditText
    lateinit var tilConfirm:TextInputLayout
    lateinit var tvLogin2:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        btnSignup2 = findViewById(R.id.btnSignup2)
        tilEmail = findViewById(R.id.tilEmail)
        etEmail = findViewById(R.id.etEmail2)
        tilPassword2 = findViewById(R.id.tilPassword2)
        etPassword2 = findViewById(R.id.etPassword2)
        tilFirstname = findViewById(R.id.tilFirstname)
        tilLastName = findViewById(R.id.tilLastName)
        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        etConfirm = findViewById(R.id.etConfirm)
        tilConfirm = findViewById(R.id.tilConfirm)
        tvLogin2 = findViewById(R.id.tvLogin2)

        tvLogin2.setOnClickListener {
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }
        btnSignup2.setOnClickListener {
            validateSignUp2()

            }

        }
    fun validateSignUp2(){
        var error=false
        tilEmail.error=null
        tilPassword2.error=null
        tilFirstname.error=null
        tilLastName.error=null
        tilConfirm.error=null
        var email=etEmail.text.toString()
        if(email.isBlank()){
            tilEmail.error="Email is required"
            error=true
        }

        var password=etPassword2.text.toString()
        if(password.isBlank()){
            tilPassword2.error="Password is required"
            error=true

        }
        var firstname=etFirstName.text.toString()
        if(firstname.isBlank()){
          tilFirstname.error  ="First name is required"
            error=true
        }
        var lastname=etLastName.text.toString()
        if(lastname.isBlank()){
            tilLastName.error="Last name is required"
            error=true
        }
        var confirm=etConfirm.text.toString()
        if(confirm.isBlank()){
            tilConfirm.error="Confirm your password"
            error=true
        }
        if(!error){

        }
    }


        }



