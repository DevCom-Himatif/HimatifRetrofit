package com.rz.himatifretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rz.himatifretrofit.fragment.delphi.DelphiFragment
import com.rz.himatifretrofit.fragment.SecondFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        bottombar.selectedItemId = R.id.menu1
    }
}
