package com.isoneday.myapplication.mvp.model

class ModelRegister {

  private  var nama: String? = null
    var nim: String
    var alamat: String
    var jurusan: String

    constructor(nama: String, nim: String, alamat: String, jurusan: String) {
        this.nama = nama
        this.nim = nim
        this.alamat = alamat
        this.jurusan = jurusan
    }
}
