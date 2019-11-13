package com.rz.himatifretrofit.fragment.delphi

import com.rz.himatifretrofit.model.AnggotaHimatif

interface DelphiContract {
    interface View{
        fun setList(list: List<AnggotaHimatif>)
    }
    interface Presenter{
        fun retrieveDelphi()
    }
}