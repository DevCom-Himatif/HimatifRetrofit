package com.rz.himatifretrofit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Repository {
    fun create(): HimatifAPI {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://api.himatif.org/")
            .build()
        return retrofit.create(HimatifAPI::class.java)
    }
}