package com.example.aboutme

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        doneButton()
        nickNameTV()
    }


    private fun doneButton(){

        findViewById<Button>(R.id.done_btn).setOnClickListener {
            addNickName()
        }
    }

    private fun nickNameTV(){

        findViewById<TextView>(R.id.nick_name_tv).setOnClickListener {
            updateNickName()
        }
    }

    private fun addNickName(){
        val edt = findViewById<EditText>(R.id.your_name_et)
        val nickName = findViewById<TextView>(R.id.nick_name_tv)
        val btn = findViewById<Button>(R.id.done_btn)
        edt.visibility = View.GONE
        nickName.text = edt.text.toString()
        nickName.visibility = View.VISIBLE
        btn.visibility = View.GONE

    }

    private fun updateNickName(){
        val edt = findViewById<EditText>(R.id.your_name_et)
        val nickName = findViewById<TextView>(R.id.nick_name_tv)
        val btn = findViewById<Button>(R.id.done_btn)
        nickName.visibility = View.GONE
        btn.visibility = View.VISIBLE
        edt.visibility = View.VISIBLE
        edt.requestFocus()
        // Show the keyboard.

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(edt, 0)
    }

}