package com.example.android4a.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android4a.R
import com.example.android4a.domain.entity.User
import kotlinx.android.synthetic.main.activity_main2.*
import org.koin.android.ext.android.inject

class MainActivity2 : AppCompatActivity() {



    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        Create_account.setOnClickListener(){
            val monIntentRetour =  Intent(this,MainActivity::class.java)
            val user = User((loginAccount_edit.text.toString().trim()))
            mainViewModel.onClickedLoginAccount(user)
            startActivity(monIntentRetour)
        }
    }
}