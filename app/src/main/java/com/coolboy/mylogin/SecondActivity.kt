package com.coolboy.mylogin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    var usernameInput : String = ""
    var passwordInput : String = ""
    var username: String? = null
    var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btnLogin.setOnClickListener{
            validasi()
        }
    }

    private fun validasi(){
        usernameInput = edtUserLog.text.toString()
        passwordInput = edtPassLog.text.toString()
        ambilData()

        when{
            usernameInput.isEmpty() -> edtUserLog.error ="Harap masukkan username"
            passwordInput.isEmpty() -> edtPassLog.error ="Harap masukkan password"


            else -> {
                if (usernameInput.equals(username) && passwordInput.equals(password)) {
                    navigasiPage3()
                }
            }
        }
    }

    private fun ambilData(){
        val bundle : Bundle? = intent.extras

        username = bundle?.getString("Username")
        password = bundle?.getString("Password")

    }

    private fun navigasiPage3(){
        val intent = Intent(this,ThirdActivity::class.java)

        val bundle = Bundle ()
        bundle.putString("Username", usernameInput)
        bundle.putString("Password", passwordInput)

        intent.putExtras(bundle)

        startActivity(intent)

    }
}