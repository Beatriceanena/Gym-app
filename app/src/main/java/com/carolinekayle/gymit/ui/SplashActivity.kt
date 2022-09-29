package com.carolinekayle.gymit.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    lateinit var sharePrefs:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharePrefs=getSharedPreferences("WORKOUT_LOG_PREFS", MODE_PRIVATE)

        val accessToken=sharePrefs.getString("ACCESS_TOKEN","")
        if (accessToken!!.isBlank()){
            startActivity(Intent( this, loginActivity::class.java))

        }
        else{
            startActivity(Intent( this, HomeActivity::class.java))


        }

    }
}










