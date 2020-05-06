package com.jawad.aboutme

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import com.jawad.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.doneButton.setOnClickListener { displayNiceName(it) }

    }

    @SuppressLint("SetTextI18n")
    private fun displayNiceName(view: View)
    {
        val editText=binding.nickName
        val nicknameText=binding.nicknameText
        nicknameText.text=getString(R.string.nick_name_info)+" "+editText.text.toString()
        nicknameText.visibility=View.VISIBLE
        editText.visibility=View.GONE
        binding.doneButton.visibility=View.GONE
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
