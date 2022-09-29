package com.carolinekayle.gymit.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.carolinekayle.gymit.LoginResponse
import com.carolinekayle.gymit.api.ApiInterface
import com.carolinekayle.gymit.api.apiclient
import com.carolinekayle.gymit.databinding.ActivityLoginBinding
import com.carolinekayle.gymit.models.loginRequest
import com.carolinekayle.gymit.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class loginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPrefs:SharedPreferences
    val userViewModel:UserViewModel by viewModels ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()
        sharedPrefs=getSharedPreferences("WORKOUT_LOG_PREFS", MODE_PRIVATE)
    }
    override fun onResume() {
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this, Observer { loginResponse->
            Toast.makeText(baseContext,loginResponse?.message,Toast.LENGTH_LONG).show()
            saveLoginDetails(loginResponse!!)
            startActivity(Intent(baseContext,HomeActivity::class.java))

        })
    userViewModel.errorLiveData.observe(this, Observer { errorMessage->
        Toast.makeText(this,errorMessage,Toast.LENGTH_LONG).show()

    })
    }

        fun castViews() {
            binding.btnLogin.setOnClickListener {
                validateLogin()


            }
            binding.tvSignup.setOnClickListener {
                validateLogin()
                val intent = Intent(this, SignupActivity::class.java)
                startActivity(intent)
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
            if (!error){
                val loginRequest = loginRequest(email,password)
                binding.pbLogin.visibility= View.VISIBLE
                userViewModel.loginUser(loginRequest)
            }
        }

    fun saveLoginDetails(loginResponse: LoginResponse){
        val editor=sharedPrefs.edit()
        editor.putString("ACCESS_TOKEN",loginResponse.accessToken)
        editor.putString("USER_ID",loginResponse.userId)
        editor.putString("PROFILE_ID",loginResponse.profileId)
        editor.apply()


    }
}
