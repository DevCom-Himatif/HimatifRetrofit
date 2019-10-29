package com.rz.himatifretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rz.himatifretrofit.api.Repository
import com.rz.himatifretrofit.model.AnggotaHimatif
import com.rz.himatifretrofit.model.HimatifResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val himatifService = Repository.create()
        himatifService.getDelphi().enqueue(object : Callback<HimatifResponse>{
            override fun onResponse(
                call: Call<HimatifResponse>,
                response: Response<HimatifResponse>
            ) {
                val data = response.body()
                Log.d("Success", data!!.status)
            }

            override fun onFailure(call: Call<HimatifResponse>, t: Throwable) {
                Log.d("Failure", t.message.toString())
            }
        })

    }
}
