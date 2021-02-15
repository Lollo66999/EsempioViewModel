package com.example.eserciziodimodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {
    lateinit var changeButton: Button
    lateinit var codeText: TextView
    lateinit var model: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        codeText= findViewById(R.id.valoredaOsservareTxt)
        //model= ViewModelProviders.of(this).get(MainActivityViewModel::class.java
        model=  ViewModelProvider(this).get(MainActivityViewModel::class.java)
        val codiceSegreto = model.getSecretCode()
        codiceSegreto.observe(this,{
            c -> codeText.text= c
        })
        changeButton= findViewById(R.id.changeValorBtn)
        changeButton.setOnClickListener {
            model.createSecretCode()
        }
    }
}