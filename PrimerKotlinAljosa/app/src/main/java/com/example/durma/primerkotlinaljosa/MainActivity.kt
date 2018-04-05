package com.example.durma.primerkotlinaljosa

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    textv

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun changeActivity1(view: View){
        val intent = Intent(applicationContext,Main2Activity::class.java)
        startActivity(intent)

    }
}
