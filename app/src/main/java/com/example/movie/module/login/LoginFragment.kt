package com.example.movie.module.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.movie.R
import com.example.movie.base.fragment.BaseBindingFragment
import com.example.movie.databinding.FragmentLoginBinding

class LoginFragment : BaseBindingFragment<FragmentLoginBinding>() {
    private lateinit var loginViewModel : LoginViewModel
    companion object{
            fun newInstance(): LoginFragment {
                val fragment = LoginFragment()
                val args = Bundle()
                fragment.arguments = args
                return fragment
            }
    }
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLoginBinding
        get() = FragmentLoginBinding::inflate

    override fun getLayoutResId(): Int  = R.layout.fragment_login
    override fun init() {
        loginViewModel =LoginViewModel()
        binding.btnLogin.setOnClickListener{
            val userName = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()
            loginViewModel.login(userName, password)
        }

        loginViewModel.loginResult.observe(viewLifecycleOwner) { success ->
            if (success) {
                showToast("Đăng nhập thành công!")
            } else {
                showToast("Đăng nhập thất bại!")
            }
        }
    }
    private fun showToast(message: String) {
        requireContext().let {
            android.widget.Toast.makeText(it, message, android.widget.Toast.LENGTH_SHORT).show()
        }
    }
}