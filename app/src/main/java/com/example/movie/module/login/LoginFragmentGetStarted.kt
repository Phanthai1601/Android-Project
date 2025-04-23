package com.example.movie.module.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.movie.base.fragment.BaseBindingFragment
import com.example.movie.databinding.FragmentGetStartedBinding
import com.example.movie.databinding.FragmentLoginBinding
import com.example.movie.module.home.HomeActivity
import com.example.movie.module.movie.MovieActivity

class LoginFragmentGetStarted : BaseBindingFragment<FragmentGetStartedBinding>() {
    companion object{
        fun newInstance(): LoginFragmentGetStarted{
            val fragment = LoginFragmentGetStarted()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentGetStartedBinding
        get() = FragmentGetStartedBinding::inflate

    override fun init() {
        binding.tvSignIn.setOnClickListener{
            pushFragment(LoginFragment.newInstance(),"Test")
        }
        val homeActivity = HomeActivity.makeIntent(requireContext())
        binding.btnGetStart.setOnClickListener{
            startActivity(homeActivity)
        }
    }
}