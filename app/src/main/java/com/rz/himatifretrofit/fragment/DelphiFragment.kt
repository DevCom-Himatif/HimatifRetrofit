package com.rz.himatifretrofit.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.rz.himatifretrofit.R
import com.rz.himatifretrofit.api.Repository
import com.rz.himatifretrofit.model.AnggotaHimatif
import com.rz.himatifretrofit.model.HimatifResponse
import com.rz.himatifretrofit.util.DelphiRvAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DelphiFragment : Fragment() {

    var list : ArrayList<AnggotaHimatif> = arrayListOf()
    lateinit var rv : RecyclerView
    lateinit var adapter: DelphiRvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_delphi, container, false)
        rv = view.findViewById(R.id.rv_delphi)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = DelphiRvAdapter(activity!!.applicationContext)
        rv.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        rv.adapter = adapter
        retrieveData()
    }

    private fun retrieveData(){
        val himatifService = Repository.create()
        himatifService.getDelphi().enqueue(object : Callback<HimatifResponse> {
            override fun onResponse(
                call: Call<HimatifResponse>,
                response: Response<HimatifResponse>
            ) {
                val data = response.body()
                Log.d("Success", data!!.status)
                list.addAll(data.response)
                adapter.setList(list)
                Log.d("Success", list.toString())
            }

            override fun onFailure(call: Call<HimatifResponse>, t: Throwable) {
                Log.d("Failure", t.message.toString())
            }
        })
    }
}
