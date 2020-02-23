package com.example.appstreet.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.example.appstreet.R
import com.example.appstreet.extension.setupFullScreenLayout

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupHandler()
        setupFullScreenLayout()
    }

    private fun setupHandler(){
        Handler().postDelayed({
            goNextScreen()
        }, 1000)
    }

    private fun goNextScreen() {
        startActivity(getIntentScreen(), getAnimationScreen())
        finish()
    }

    private fun getIntentScreen(): Intent {
        return Intent(this, MainActivity::class.java)
    }

    private fun getAnimationScreen(): Bundle? = ActivityOptionsCompat.makeCustomAnimation(
        this, R.anim.fade_in, R.anim.fade_out
    ).toBundle()

}
