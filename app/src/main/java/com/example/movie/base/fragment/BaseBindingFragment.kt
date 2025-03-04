package com.example.movie.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding


abstract class BaseBindingFragment<V : ViewBinding> : BaseFragment() {
    private var _binding: V? = null
    val binding: V
        get() = _binding
            ?: throw RuntimeException("Binding only valid between onCreateView and onDestroyView. Check ${this::class.java.name}")

    override fun getLayoutResId(): Int = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> V
    abstract fun init()
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}