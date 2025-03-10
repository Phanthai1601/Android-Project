package com.example.movie.module.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.movie.base.fragment.BaseBindingFragment
import com.example.movie.databinding.FragmentGetStartedBinding
import com.example.movie.databinding.FragmentLoginBinding

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
        binding.btnGetStart.setOnClickListener{
            pushFragment(LoginFragmentEmail.newInstance(), "Demo")
        }
    }
}