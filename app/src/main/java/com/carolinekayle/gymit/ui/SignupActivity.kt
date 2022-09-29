package com.carolinekayle.gymit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.carolinekayle.gymit.databinding.ActivitySignupBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
   lateinit var binding:ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


       binding.tvLogin2.setOnClickListener {
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignup2.setOnClickListener {
            validateSignUp2()

            }

        }
    fun validateSignUp2(){
        var error=false
        binding.tilEmail3.error=null
        binding.tilPassword2.error=null
       binding.tilFirstname.error=null
        binding.tilLastName.error=null
        binding.tilConfirm.error=null

        var email=binding.etEmail2.text.toString()
        if(email.isBlank()){
            binding.tilEmail3.error="Email is required"
            error=true
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.tilEmail3.error="Not a valid email adddress"
            error=true
        }

        var password=binding.etPassword2.text.toString()
        if(password.isBlank()){
            binding.tilPassword2.error="Password is required"
            error=true

        }
        var firstname=binding.etFirstName.text.toString()
        if(firstname.isBlank()){
          binding.tilFirstname.error  ="First name is required"
            error=true
        }
        var lastname=binding.etLastName.text.toString()
        if(lastname.isBlank()){
            binding.tilLastName.error="Last name is required"
            error=true
        }
        var confirm=binding.etConfirm.text.toString()
        if(confirm.isBlank()){
            binding.tilConfirm.error="Confirm your password"
            error=true
        }
        if(!error){

        }
        if(password!=confirm)
            binding.tilConfirm.error="Wrong Password"


    }



        }



