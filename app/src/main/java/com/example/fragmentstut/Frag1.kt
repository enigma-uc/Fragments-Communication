package com.example.fragmentstut

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class Frag1 : Fragment() {
    lateinit var passData: PassDataToActivityFrag1
    lateinit var sendData: PassDataToActivityForFrag2
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var editData: EditText
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.frag2, container, false)
        btn1 = view.findViewById(R.id.btn1)
        btn2 = view.findViewById(R.id.btn2)
        editData = view.findViewById(R.id.frag2_editText)
        btn1.setOnClickListener { passData.dataFromFrag1(editData.text) }
        btn2.setOnClickListener { sendData.sendDataFrag2(editData.text) }
        return view
    }

    fun updateData(str: Editable) {
        editData.text = str
    }

    override fun onAttach(context: Context) {
        passData = context as PassDataToActivityFrag1
        sendData = context as PassDataToActivityForFrag2
        super.onAttach(context)
    }
}

interface PassDataToActivityFrag1 {
    fun dataFromFrag1(str: Editable)
}

interface PassDataToActivityForFrag2 {
    fun sendDataFrag2(str: Editable)
}