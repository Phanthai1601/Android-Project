package com.example.movie.module.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.movie.base.fragment.BaseBindingFragment
import com.example.movie.databinding.FragmentLoginEmailBinding

class LoginFragmentEmail: BaseBindingFragment<FragmentLoginEmailBinding>() {
    companion object{
        fun newInstance(): LoginFragmentEmail{
            val fragment = LoginFragmentEmail()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLoginEmailBinding
        get() = FragmentLoginEmailBinding::inflate

    override fun init() {}
}