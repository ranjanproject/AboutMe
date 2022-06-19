package com.example.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.DataBindingUtil.bind
import android.databinding.DataBindingUtil.setContentView
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.aboutme.databinding.ActivityMainBinding
import java.sql.DatabaseMetaData

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Pratik Ranjan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        init()
    }

    private fun init(){
        setName()
        doneButton()
        nickNameTV()
    }

    private fun setName(){

        binding.myName = myName
    }


    private fun doneButton(){

        binding.doneBtn.setOnClickListener {
            addNickName()
        }
    }

    private fun nickNameTV(){

        binding.nickNameTv.setOnClickListener {
            updateNickName()
        }

    }

    private fun addNickName(){

        binding.apply {
            yourNameEt.visibility = View.GONE
            myName?.nickName = yourNameEt.text.toString()
            nickNameTv.text = yourNameEt.text.toString()
            nickNameTv.visibility = View.VISIBLE
            doneBtn.visibility = View.GONE
        }

    }

    private fun updateNickName(){

        val edt = binding.yourNameEt

        binding.apply {
            nickNameTv.visibility = View.GONE
            doneBtn.visibility = View.VISIBLE
            yourNameEt.visibility = View.VISIBLE
        }

        edt.requestFocus()
        // Show the keyboard.

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(edt, 0)
    }

}