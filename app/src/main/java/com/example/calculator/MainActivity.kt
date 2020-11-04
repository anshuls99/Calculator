package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isNewOp = true
    private var op: String? = null
    var oldNumber = ""
    var buValue: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buNumberEvent(view: View) {

        if (isNewOp)
            showNumber.text = ""

        isNewOp = false

        val buSelected = view as Button

        buValue= showNumber.text.toString()

        if (buValue == "0" && buValue!!.length == 1)
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
            buAC.id -> buValue = "0"
            else -> buValue += "NA"
        }


        showNumber.text = buValue

    }

    fun buOpEvent(view: View) {

        val buSelected = view as Button

        when (buSelected.id) {
            buPlus.id -> {
                buValue += "+"
                op = "+"
            }
            buMinus.id -> {
                buValue += "-"
                op = "-"
            }
            buMultiply.id -> {
                buValue += "*"
                op = "*"
            }
            buDivide.id -> {
                buValue += "/"
                op = "/"
            }
        }

        oldNumber = showNumber.text.toString()
        showNumber.text = buValue
        isNewOp = true
    }

    fun buEqualEvent(view: View) {

        val newNumber = showNumber.text.toString()
        val finalNumber = when (op) {

            "+" -> oldNumber.toDouble() + newNumber.toDouble()
            "-" -> oldNumber.toDouble() - newNumber.toDouble()
            "*" -> oldNumber.toDouble() * newNumber.toDouble()
            else -> oldNumber.toDouble() / newNumber.toDouble()
        }

        buValue = finalNumber.toString()
        showNumber.text = buValue
        isNewOp = true
    }


}