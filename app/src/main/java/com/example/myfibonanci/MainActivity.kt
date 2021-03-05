package com.example.myfibonanci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_fibonacci.setOnClickListener {
            val intent = Intent(applicationContext, FibonacciActivity::class.java)
            startActivity(intent)
        }
        btn_anagram.setOnClickListener {
            val intent = Intent(applicationContext, AnagramActivity::class.java)
            startActivity(intent)
        }
        btn_calculate.setOnClickListener {
            val intent = Intent(applicationContext, CalculationActivity::class.java)
            startActivity(intent)
        }
    }
}