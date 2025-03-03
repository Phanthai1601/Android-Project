package com.example.movie.base.dialog

import android.content.Context
import android.os.Bundle
import com.example.movie.R

class LoadingDialog(context: Context) : BaseDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCanceledOnTouchOutside(false)
        setCancelable(false);
        window?.setBackgroundDrawableResource(R.color.transparent)
    }

    override fun getLayoutResId(): Int {
        return R.layout.dialog_loading
    }
}