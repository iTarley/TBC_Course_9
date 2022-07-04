package com.example.tbc_course_9

import android.os.Bundle
import android.text.InputType
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.example.tbc_course_9.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.addBtn.setOnClickListener {
            addBtn()
        }
    }

    private fun addBtn() {
        if (binding.fieldNameEditText.text.toString().isNotEmpty()) {
            val layoutScroll = binding.mainActivityLayout
            val compatEditText = AppCompatEditText(this)
            val layoutSetter = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            val hint = binding.fieldNameEditText.text.toString()
            val checker = binding.checkBox

            if (checker.isChecked) {
                compatEditText.inputType = InputType.TYPE_CLASS_NUMBER
                compatEditText.hint = "$hint (Numeric)"
                layoutScroll.addView(compatEditText, layoutSetter)
            } else {
                compatEditText.inputType = InputType.TYPE_CLASS_TEXT
                compatEditText.hint = hint
                layoutScroll.addView(compatEditText, layoutSetter)
            }
        } else {
            Toast.makeText(
                this,
                getString(R.string.empty_field),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}