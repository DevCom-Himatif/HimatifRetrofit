package com.rz.himatifretrofit.fragment.delphi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.rz.himatifretrofit.R
import com.rz.himatifretrofit.model.AnggotaHimatif
import com.rz.himatifretrofit.util.DelphiRvAdapter

class DelphiFragment : Fragment(), DelphiContract.View {

    lateinit var rv : RecyclerView
    lateinit var adapter: DelphiRvAdapter
    lateinit var mPresenter: DelphiContract.Presenter

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

        mPresenter = DelphiPresenter(this)
        mPresenter.retrieveDelphi()
    }

    override fun setList(list: List<AnggotaHimatif>) {
        adapter.setList(list)
    }
}
