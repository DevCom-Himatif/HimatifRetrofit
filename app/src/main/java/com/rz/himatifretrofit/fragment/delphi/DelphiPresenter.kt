package com.rz.himatifretrofit.fragment.delphi

import android.util.Log
import com.rz.himatifretrofit.api.Repository
import com.rz.himatifretrofit.model.HimatifResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DelphiPresenter(private val view: DelphiContract.View) :
    DelphiContract.Presenter {

    override fun retrieveDelphi() {
        val himatifService = Repository.create()
        // HimatifAPI himatifService = Repository.create()
        himatifService.getDelphi().enqueue(object : Callback<HimatifResponse> {
            override fun onResponse(
                call: Call<HimatifResponse>,
                response: Response<HimatifResponse>
            ) {
                val data = response.body()
                // String data = response.body()
                Log.d("Success", data!!.status)
                // view.setList(data.response)
                view.setList(data.response)
                Log.d("Success", data.response.toString())
            }

            override fun onFailure(call: Call<HimatifResponse>, t: Throwable) {
                Log.d("Failure", t.message.toString())
            }
        })
    }

}