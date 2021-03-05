package com.example.myfibonanci

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_fibonacci.*

class FibonacciActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fibonacci)

        btn_submit_fibonacci.setOnClickListener {
            val inputNumber = et_input_fibonacci.text.toString()
            val result = generateFibonacci(input = inputNumber.toInt()).joinToString(",")
            tv_result_fibonacci.text = result

        }
        et_input_fibonacci.doAfterTextChanged {
            checkFormForEmpty()
        }
    }


    private fun checkFormForEmpty() {

        btn_submit_fibonacci.isEnabled = !et_input_fibonacci.text.isNullOrEmpty()

    }

    private fun generateFibonacci(input: Int): ArrayList<Int> {
        val mData = ArrayList<Int>()
        var i = 1
        var t1 = 0
        var t2 = 1


        while (i <= input) {
            mData.add(t1)
            val sum = t1 + t2
            t1 = t2
            t2 = sum
            i++
        }
        return mData
    }


}