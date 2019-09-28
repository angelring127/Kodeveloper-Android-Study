package com.kodeveloper.mymemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

/*
* Start Activity
* */

class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val handler = Handler()

        handler.postDelayed({
        //s1.5초후 메인 화면으로 이동
            this.goMainActivity()
        }, 1500)

    }

    /*
    * 인텐트를 이용해서 메인 엑티비티로 이동
    * */
    private fun goMainActivity() {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}