package com.rz.himatifretrofit.api

import com.rz.himatifretrofit.model.AnggotaHimatif
import com.rz.himatifretrofit.model.HimatifResponse
import retrofit2.Call
import retrofit2.http.GET

interface HimatifAPI {
    @GET("data/v1/anggota/search?type=angkatan&q=2017")
    fun getDelphi(): Call<HimatifResponse>
}