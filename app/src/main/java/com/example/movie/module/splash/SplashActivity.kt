package com.example.movie.module.splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.movie.MainActivity
import com.example.movie.R
import com.example.movie.base.activity.BaseActivity
import com.example.movie.databinding.SplashActivityBinding

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {
    private lateinit var binding: SplashActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            delay(2000)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }

    override fun changeStatusBarTextColor(): Boolean = false

    override fun getLayoutResId(): Int {
        return R.layout.splash_activity
    }
}
