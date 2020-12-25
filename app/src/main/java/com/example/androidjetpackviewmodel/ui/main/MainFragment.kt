package com.example.androidjetpackviewmodel.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import com.example.androidjetpackviewmodel.R

class MainFragment : Fragment() {

    private lateinit var convertButton: Button
    private lateinit var resultText: TextView
    private lateinit var edt_input: EditText

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view =  inflater.inflate(R.layout.main_fragment, container, false)

        convertButton = view.findViewById(R.id.btn_convert) as Button
        resultText = view.findViewById(R.id.result) as TextView
        edt_input = view.findViewById(R.id.edt_input) as EditText

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val resultObserver = Observer<Double>{
            result -> resultText.text = result.toString()
        }

        viewModel.getResult().observe(viewLifecycleOwner, resultObserver)


        convertButton.setOnClickListener{
            if(edt_input.text.isNotEmpty()){
                viewModel.setAmount(edt_input.text.toString())
            }else{
                resultText.text = "No value"
            }
        }

        edt_input.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }


            override fun afterTextChanged(s: Editable?) {
                if(edt_input.text.isNullOrEmpty())
                    resultText.text = "No Value"
                else
                    viewModel.setAmount(edt_input.text.toString())
            }
        })

    }

}