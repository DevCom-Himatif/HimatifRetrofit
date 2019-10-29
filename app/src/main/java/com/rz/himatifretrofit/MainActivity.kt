package com.rz.himatifretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rz.himatifretrofit.api.Repository
import com.rz.himatifretrofit.fragment.DelphiFragment
import com.rz.himatifretrofit.fragment.SecondFragment
import com.rz.himatifretrofit.model.AnggotaHimatif
import com.rz.himatifretrofit.model.HimatifResponse
import kotlinx.android.synthetic.main.activity_main.*
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

        bottombar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu1 -> {
                    val fragment = DelphiFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main_container, fragment, fragment.javaClass.simpleName)
                        .commit()
                }
                R.id.menu2 -> {
                    val fragment = SecondFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main_container, fragment, fragment.javaClass.simpleName)
                        .commit()
                }
            }
            false
        }
    }
}
