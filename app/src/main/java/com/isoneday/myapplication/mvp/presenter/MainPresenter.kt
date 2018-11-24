package com.isoneday.myapplication.mvp.presenter

import android.app.Dialog
import com.isoneday.myapplication.mvp.MainView
import com.isoneday.myapplication.mvp.model.ResponseRegister
import com.isoneday.myapplication.network.InitRetrofit
import com.isoneday.myapplication.network.RestApi
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import retrofit2.Call
import retrofit2.Response

class MainPresenter(private val view: MainView) {

    //fungsi register data ke server / api
    fun register(username: String, password: String, level: String?, dialog: Dialog) {
        //progressbar tampil
        view.showLoading()
        val api: RestApi = InitRetrofit.getInstance()
        //panggil endpoint
        api.registeruser(username, password, level).enqueue(
            object : retrofit2.Callback<ResponseRegister> {
                override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                    //untuk menghilangkan progresbar
                    view.hideLoading()
                    //untuk menangkap infomasi detail error
                    view.showMessage(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResponseRegister>, response: Response<ResponseRegister>) {
                    //untuk menghilangkan progresbar
                    view.hideLoading()
                    async(UI) {
                        val hasil = bg {
                            response.body()?.result
                        }
                        val pesan = response.body()?.msg
                        view.hideDialog(dialog)
                        if (hasil.equals(1)) {
                            view.showMessage(pesan)
                        } else {
                            view.showMessage(pesan)
                        }
                    }

                }
            }
        )


    }
}