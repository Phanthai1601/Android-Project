package com.example.movie.base.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window

abstract class BaseDialog(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window!!.requestFeature(Window.FEATURE_NO_TITLE)
        setContentView(getLayoutResId())
    }

    protected abstract fun getLayoutResId(): Int
}