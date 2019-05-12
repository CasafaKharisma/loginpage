package com.coolboy.mylogin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    var username: String? = null
    var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        ambilData()
    }


    private fun ambilData(){
        val bundle : Bundle? = intent.extras

        username = bundle?.getString("Username")
        password = bundle?.getString("Password")

        txtWellcome.text= username


    }
}