package com.example.durma.primerkotlinaljosa

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun changeActivity2(view: View){
        val intent = Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)

    }
}
