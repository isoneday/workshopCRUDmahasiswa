package com.isoneday.myapplication

import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import com.isoneday.myapplication.mvp.MainView
import com.isoneday.myapplication.mvp.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.layout_register.view.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.sdk27.coroutines.onClick

class LoginRegisterActivity : AppCompatActivity(), MainView {


    private var strlevel: String? = null

    var mainPresenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //aksi ketika tombol btn register diklik
        mainPresenter = MainPresenter(this)
        btnRegister.onClick {
            registeruser()
        }
        btnSignIn.onClick {

        }

    }

    private fun registeruser() {
        val dialogregis = Dialog(this, R.style.MyAlertDialogTheme)
        val tampilanregis = layoutInflater.inflate(R.layout.layout_register, null)
        //setlayout ke dialog
        dialogregis.setContentView(tampilanregis)
        if (tampilanregis.regAdmin.isChecked) {
            strlevel = "admin"
        } else {
            strlevel = "mahasiswa"
        }

        tampilanregis.register.onClick {
            //cek validasi
            if (TextUtils.isEmpty(tampilanregis.edtEmail.text.toString())) {
                tampilanregis.edtEmail.error = "nama tidak boleh kosong"
            } else if (TextUtils.isEmpty(tampilanregis.edtPassword.text.toString())) {
                tampilanregis.edtPassword.error = "password tidak boleh kosong"
            } else if (tampilanregis.edtPassword.text.toString().length < 6) {
                tampilanregis.edtPassword.error = "password tidak boleh kurang dari 6 karakter"
            } else {
                prosesregister(tampilanregis, dialogregis)
            }
        }
        dialogregis.show()
    }

    private fun prosesregister(tampilanregis: View?, dialogregis: Dialog) {
        mainPresenter?.register(
            tampilanregis?.edtEmail?.text.toString(),
            tampilanregis?.edtPassword?.text.toString(),
            strlevel, dialogregis
        )
    }


    override fun showLoading() {
        //untuk menampilkan progresbaar
        pb.visibility = View.VISIBLE
    }

    override fun hideLoading() {

        pb.visibility = View.GONE
    }

    override fun showMessage(isipesan: String?) {
        longToast(isipesan.toString())
    }

    override fun hideDialog(d: Dialog) {
        d.dismiss()
    }
}
