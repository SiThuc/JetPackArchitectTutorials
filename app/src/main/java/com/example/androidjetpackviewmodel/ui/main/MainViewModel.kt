package com.example.androidjetpackviewmodel.ui.main

import android.text.Editable
import android.util.Log
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

    fun onTextChange(edit: Editable?){
        if (!edit.isNullOrEmpty())
            result.value = dollarValue.value!!.toDouble().times(euro2usd_rate)
        else
            result.value = 0.0
    }
}