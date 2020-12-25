package com.example.androidjetpackviewmodel.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val euro2usd_rate = 1.25
    var dollarValue: MutableLiveData<String> = MutableLiveData()
    var result: MutableLiveData<Double> = MutableLiveData()

    fun onClickToConvert() {

        if (!dollarValue.value.equals(""))
            result.value = dollarValue.value!!.toDouble().times(euro2usd_rate)
        else
            result.value = 0.0
    }

    fun onTextChanged(){
        if (!dollarValue.value.equals(""))
            result.value = dollarValue.value!!.toDouble().times(euro2usd_rate)
        else
            result.value = 0.0
    }
}