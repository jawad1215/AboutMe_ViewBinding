package com.jawad.aboutme

import android.annotation.SuppressLint
import android.content.Context
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.jawad.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Jawad Yousaf")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneButton.setOnClickListener { displayNiceName(it) }
    }

    @SuppressLint("SetTextI18n")
    private fun displayNiceName(view: View)
    {

        binding.apply {
            myName?.nickname = nick_name.text.toString()
            nicknameText.text = getString(R.string.nick_name_info) + " " + myName?.nickname
            invalidateAll()
            nicknameText.visibility = View.VISIBLE
            nickName.visibility = View.GONE
            doneButton.visibility = View.GONE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
