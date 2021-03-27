package com.example.fragmentstut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), PassDataToActivityFrag2, PassDataToActivityFrag1,
    PassDataToActivityForFrag1, PassDataToActivityForFrag2 {
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var frag1: Frag1
    lateinit var frag2: Frag2
    lateinit var fragManager: FragmentManager
    lateinit var fragTransaction: FragmentTransaction
    lateinit var editData: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        editData = findViewById(R.id.acitivityEdit)
        frag1 = Frag1()
        frag2 = Frag2()
        fragManager = supportFragmentManager
        fragTransaction = fragManager.beginTransaction()
        fragTransaction.add(R.id.frame_frag1, frag1)
        fragTransaction.add(R.id.frame_frag2, frag2)
        fragTransaction.commit()
        btn1.setOnClickListener { frag1.updateData(editData.text) }
        btn2.setOnClickListener { frag2.updateData(editData.text) }
    }

    override fun dataFromFrag2(str: Editable) {
        editData.text = str
    }

    override fun dataFromFrag1(str: Editable) {
        editData.text = str
    }

    override fun sendData(str: Editable) {
        frag1.updateData(str)
    }

    override fun sendDataFrag2(str: Editable) {
        frag2.updateData(str)
    }
}