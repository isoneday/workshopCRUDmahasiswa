package com.isoneday.myapplication.mvp.model

import com.google.gson.annotations.SerializedName


data class ResponseRegister(

	@field:SerializedName("result")
	val result: Int? = null,

	@field:SerializedName("msg")
	val msg: String? = null
)