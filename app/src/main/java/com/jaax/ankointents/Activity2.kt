package com.jaax.ankointents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity2 : AppCompatActivity() {
    private lateinit var txt: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        txt = findViewById(R.id.msjRecibido)
    }

    override fun onStart() {
        super.onStart()
        val bundle = intent.extras
        val mensaje = bundle?.getString( "message" )

        txt.setText( mensaje )

    }
}