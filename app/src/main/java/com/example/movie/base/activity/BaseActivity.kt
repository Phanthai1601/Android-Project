package com.example.movie.base.activity

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.movie.base.dialog.LoadingDialog

abstract class BaseActivity : AppCompatActivity() {
    private lateinit var mLoadingDialog: LoadingDialog
    private var mToast: Toast? = null

    abstract fun changeStatusBarTextColor(): Boolean
    abstract fun getLayoutResId(): Int
    protected open fun pressTwiceToExit(): Boolean {
        return false
    }

    open fun showLoading() {
        if (!this::mLoadingDialog.isInitialized) {
            mLoadingDialog = LoadingDialog(this)
        }
        if (mLoadingDialog.isShowing) {
            return
        } else {
            mLoadingDialog.show()
        }
    }

    open fun hideLoading() {
        if (this::mLoadingDialog.isInitialized) {
            if (mLoadingDialog.isShowing) {
                mLoadingDialog.dismiss()
            }
        }
    }

    open fun showMessage(message: String) {
        if (message.isNotBlank()) {
            if (mToast != null) {
                mToast!!.cancel()
            }
            mToast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
            mToast!!.show()
        }
    }

}