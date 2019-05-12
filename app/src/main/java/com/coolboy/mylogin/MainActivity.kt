package com.coolboy.mylogin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var usernameInput : String = ""
    var passwordInput : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDaftar.setOnClickListener{
            CekData()
        }

    }

    private fun CekData (){
        usernameInput = edtUser.text.toString()
        passwordInput = edtPass.text.toString()

        when{
            usernameInput.isEmpty() -> edtUser.error ="Mohon masukkan username"
            passwordInput.isEmpty() -> edtPass.error ="Mohon masukkan password"

            else -> {
                ToastNotif("Berhasil")

                NavigasiPage2()
            }
        }
    }


    private fun NavigasiPage2(){
        val intent = Intent (this,SecondActivity::class.java)

        val bundle = Bundle ()
        bundle.putString("Username", usernameInput)
        bundle.putString("Password", passwordInput)

        intent.putExtras(bundle)

        startActivity(intent)

    }

    private fun ToastNotif(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}