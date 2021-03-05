package com.example.myfibonanci

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_calculation.*

class CalculationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculation)
        btn_submit_calculation.setOnClickListener {
            calculatePermutation()
        }
        et_first_number.doAfterTextChanged {
            checkFormForEmpty()
        }
        et_second_number.doAfterTextChanged {
            checkFormForEmpty()
        }
    }

    private fun checkFormForEmpty() {


        val obsList = arrayOf(
            et_first_number.text,
            et_second_number.text
        )

        val result = obsList.filter {
            (it?.isNotEmpty() ?: false)
        }

        btn_submit_calculation.isEnabled = result.size == obsList.size

    }

    private fun calculatePermutation() {
        var r = et_first_number.text.toString().toLong()
        var n = et_second_number.text.toString().toLong()
        var min = n - r
        n = factorial(n)
        r = factorial(r)
        min = factorial(min)
        val result = n / (min * r)
        tv_calculation_result.text = result.toString()
    }

    private fun factorial(x: Long): Long {
        return if (x == 0L) 1 else
            x * factorial(x - 1)
    }
}