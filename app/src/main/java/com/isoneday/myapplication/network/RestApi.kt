package com.isoneday.myapplication.network

import com.isoneday.myapplication.mvp.model.ResponseRegister
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RestApi {

//    @FormUrlEncoded
//    @POST("login.php")
//    fun loginuser(@Field("username") username:String,@Field("password") password:String,@Field("level") level:String?): Call<ResponseLogin>
//
   @FormUrlEncoded
    @POST("register.php")
    fun registeruser(
    @Field("username") username:String,
    @Field("password") password:String,
    @Field("level") level:String?)
        : Call<ResponseRegister>

//    @FormUrlEncoded
//    @POST("add_mahasiswa.php")
//    fun insertMahasiswa(@Field("nim") nim:String,@Field("nama") nama:String,@Field("alamat") alamat:String?,@Field("jurusan") jurusan:String?): Call<ResponseLogin>
//
//    @GET("get_mahasiswa.php")
//    fun getListMahasiswa(): Call<ResponseListMahasiswa>

//    @FormUrlEncoded
//   @GET("api/v1/json/1/eventsnextleague.php")
//    fun getNextMatch(@Query("id") leagueid:Int): Call<ResponseLogin>

}
