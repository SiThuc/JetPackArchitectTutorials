package com.example.androidjetpackviewmodel.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val euro2usd_rate = 1.25
    //private var dollarText = ""
    private var result: MutableLiveData<Double> = MutableLiveData()

    fun setAmount(value: String){
        //this.dollarText = value
        result.setValue(value.toDouble() * euro2usd_rate)
    }

    fun getResult(): MutableLiveData<Double>{
        return result
    }
}