package com.example.movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.movie.module.login.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.btn)
        /*btn.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }
*/
        val loginActivity = LoginActivity.makeIntent(this)
        btn.setOnClickListener{
            startActivity(loginActivity)
        }

    }

}