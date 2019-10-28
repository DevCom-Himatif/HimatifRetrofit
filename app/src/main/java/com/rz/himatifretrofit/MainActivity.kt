package com.rz.himatifretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rz.himatifretrofit.api.Repository
import com.rz.himatifretrofit.model.AnggotaHimatif
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val himatifService = Repository.create()
        himatifService.getDelphi().enqueue(object : Callback<List<AnggotaHimatif>>{
            override fun onResponse(
                call: Call<List<AnggotaHimatif>>,
                response: Response<List<AnggotaHimatif>>
            ) {
                val data = response.body()
                data?.map {
                    Log.d("Success", "Datanya : ${it.nama}")
                }
            }

            override fun onFailure(call: Call<List<AnggotaHimatif>>, t: Throwable) {
                Log.d("Failure", "Failure to fetch")
            }
        })

    }
}
