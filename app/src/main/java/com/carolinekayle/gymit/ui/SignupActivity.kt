package com.carolinekayle.gymit.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.carolinekayle.gymit.api.ApiInterface
import com.carolinekayle.gymit.api.apiclient
import com.carolinekayle.gymit.databinding.ActivitySignupBinding
import com.carolinekayle.gymit.models.RegisterRequest
import com.carolinekayle.gymit.models.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvLogin2.setOnClickListener {
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignup2.setOnClickListener {
            validateSignUp2()

        }

    }

    fun validateSignUp2() {
        var error = false
        binding.tilEmail3.error = null
        binding.tilPassword2.error = null
        binding.tilFirstname.error = null
        binding.tilLastName.error = null
        binding.tilConfirm.error = null

        var email = binding.etEmail2.text.toString()
        if (email.isBlank()) {
            binding.tilEmail3.error = "Email is required"
            error = true
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail3.error = "Not a valid email adddress"
            error = true
        }
        var phoneNumber = binding.etPhoneNumber.text.toString()
        if (phoneNumber.isBlank()) {
            binding.tilPhoneNumber.error = "Password is required"
            error = true

        }

        var password = binding.etPassword2.text.toString()
        if (password.isBlank()) {
            binding.tilPassword2.error = "Password is required"
            error = true

        }
        var firstname = binding.etFirstName.text.toString()
        if (firstname.isBlank()) {
            binding.tilFirstname.error = "First name is required"
            error = true
        }
        var lastname = binding.etLastName.text.toString()
        if (lastname.isBlank()) {
            binding.tilLastName.error = "Last name is required"
            error = true
        }
        var confirm = binding.etConfirm.text.toString()
        if (confirm.isBlank()) {
            binding.tilConfirm.error = "Confirm your password"
            error = true
        }
        if (!error) {

        }
        if (password != confirm)
            binding.tilConfirm.error = "Wrong Password"

        if (!error) {
            val registerRequest = RegisterRequest(firstname, lastname, phoneNumber, password, email)
            makeRegisterRequest(registerRequest)
            startActivity(Intent(this,loginActivity::class.java))
        }

    }

    fun makeRegisterRequest(registerRequest: RegisterRequest) {
        val apiClient = apiclient.ApiClient.buildApiClient(ApiInterface::class.java)
        val request = apiClient.registerUser(registerRequest)
        request.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>
            )
            {
                if(response.isSuccessful){
                    Toast.makeText(baseContext,response.body()?.message,Toast.LENGTH_LONG).show()
                    //Navigate to login

                }
                else{
                    val error= response.errorBody()?.string()
                    Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

        }
        )
    }
}




