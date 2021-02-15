package com.example.eserciziodimodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel () {
    private lateinit var secretCode: MutableLiveData<String>
    fun getSecretCode (): MutableLiveData<String> {
        if (!::secretCode.isInitialized) {
            secretCode= MutableLiveData()
            createSecretCode()
        }
        return secretCode
    }
    fun createSecretCode () {
        Log.i ("app", "creo codice segreto")
        secretCode.value= "numero estratto: " + generaCodice(3)
    }
    fun generaCodice (n: Int): String {
        val arrayLettere= arrayOf ('a', 'b', 'c')
        var codice= ""
        for (i in 0 until n) {
            codice += arrayLettere[(0..(arrayLettere.size-1)).random()]
        }
        return codice
    }

    override fun onCleared() {
        super.onCleared()
        Log.i ("app", "activity distrutta")
    }
}