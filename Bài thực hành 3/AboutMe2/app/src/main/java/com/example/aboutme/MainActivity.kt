package com.example.aboutme

import android.content.Context
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        done_button.setOnClickListener { addNickName(it) }
        nickname_text.setOnClickListener {
            updateNickname (it)
        }

    }
    private fun addNickName(view: View) {
        if(TextPersonName.text.isNotEmpty()){
            nickname_text.text = TextPersonName.text
            TextPersonName.visibility = View.GONE
            view.visibility = View.GONE
            nickname_text.visibility = View.VISIBLE
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }else
            Toast.makeText(this, "Bạn chưa nhập tên?", Toast.LENGTH_SHORT).show()

    }
    private fun updateNickname (view: View) {
        TextPersonName.visibility = View.VISIBLE
        done_button.visibility = View.VISIBLE
        view.visibility = View.GONE
        TextPersonName.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(TextPersonName,0)
    }
}