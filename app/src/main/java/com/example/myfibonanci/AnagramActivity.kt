package com.example.myfibonanci

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_anagram.*
import java.util.*

class AnagramActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anagram)
        btn_submit_anagram.setOnClickListener {
            if (isAnagrams()) {
                tv_anagram_result.text = "True"
            } else tv_anagram_result.text = "False"
        }


        et_first_text.doAfterTextChanged {
            checkFormForEmpty()
        }

        et_second_text.doAfterTextChanged {
            checkFormForEmpty()
        }


    }

    private fun checkFormForEmpty() {


        val obsList = arrayOf(
            et_first_text.text,
            et_second_text.text
        )

        val result = obsList.filter {
            (it?.isNotEmpty() ?: false)
        }

        btn_submit_anagram.isEnabled = result.size == obsList.size

    }


    private fun isAnagrams(): Boolean {
        val firstText = et_first_text.text.toString()
        val secondText = et_second_text.text.toString()

        if (firstText.length != secondText.length) {
            return false
        }

        val strArray1 = firstText.toCharArray()
        val strArray2 = secondText.toCharArray()

        Arrays.sort(strArray1)
        Arrays.sort(strArray2)

        val sortedStr1 = String(strArray1)
        val sortedStr2 = String(strArray2)

        return sortedStr1 == sortedStr2
    }
}