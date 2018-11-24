package com.isoneday.myapplication.mvp

import android.app.Dialog

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showMessage(isipesan : String?)
    fun hideDialog(d :Dialog)
}