package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buNumberEvent(view: View) {

        val buSelected = view as Button

        var buValue: String = showNumber.text.toString()

        if (buValue == "0" && buValue.length == 1)
            buValue = ""


        when (buSelected.id) {
            bu0.id -> buValue += "0"
            bu1.id -> buValue += "1"
            bu2.id -> buValue += "2"
            bu3.id -> buValue += "3"
            bu4.id -> buValue += "4"
            bu5.id -> buValue += "5"
            bu6.id -> buValue += "6"
            bu7.id -> buValue += "7"
            bu8.id -> buValue += "8"
            bu9.id -> buValue += "9"
            buDot.id -> buValue += "."
            buEqual.id -> buValue += "="
            buPlus.id -> buValue += "+"
            buMinus.id -> buValue += "-"
            buMultiply.id -> buValue += "*"
            buDivide.id -> buValue += "/"
            buAC.id -> buValue = "0"
            else -> buValue += "NA"
        }

        showNumber.text = buValue
    }
}