package com.example.calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Listener and Add Value - Button Cancel
        button_cancel.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        //Listener and Add Value - Button Left
        button_left.setOnClickListener {
            input.text = addToInputText("(")
        }
        //Listener and Add Value - Button Right
        button_right.setOnClickListener {
            input.text = addToInputText(")")
        }
        //Listener and Add Value - Button 0
        button_number0.setOnClickListener {
            input.text = addToInputText("0")
        }
        //Listener and Add Value - Button 1
        button_number1.setOnClickListener {
            input.text = addToInputText("1")
        }
        //Listener and Add Value - Button 2
        button_number2.setOnClickListener {
            input.text = addToInputText("2")
        }
        //Listener and Add Value - Button 3
        button_number3.setOnClickListener {
            input.text = addToInputText("3")
        }
        //Listener and Add Value - Button 4
        button_number4.setOnClickListener {
            input.text = addToInputText("4")
        }
        //Listener and Add Value - Button 5
        button_number5.setOnClickListener {
            input.text = addToInputText("5")
        }
        //Listener and Add Value - Button 6
        button_number6.setOnClickListener {
            input.text = addToInputText("6")
        }
        //Listener and Add Value - Button 7
        button_number7.setOnClickListener {
            input.text = addToInputText("7")
        }
        //Listener and Add Value - Button 8
        button_number8.setOnClickListener {
            input.text = addToInputText("8")
        }
        //Listener and Add Value - Button 9
        button_number9.setOnClickListener {
            input.text = addToInputText("9")
        }
        //Listener and Add Value - Button Point
        button_point.setOnClickListener {
            input.text = addToInputText(".")
        }
        //Listener and Add Value - Button Division
        button_division.setOnClickListener {
            input.text = addToInputText("÷")
        }
        //Listener and Add Value - Button Multiplication
        button_multiplication.setOnClickListener {
            input.text = addToInputText("×")
        }
        //Listener and Add Value - Button Diminution
        button_diminition.setOnClickListener {
            input.text = addToInputText("-")
        }
        //Listener and Add Value - Button Addition
        button_addition.setOnClickListener {
            input.text = addToInputText("+")
        }
        //Listener and Display - Button Equal
        button_equal.setOnClickListener {
            showResult()
        }
    }
    //
    private fun addToInputText(buttonValue: String): String {
        return "${input.text}$buttonValue"
    }

    //Replacement for Visual
    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    //Function showResult and Error !
    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.result))
            }
        } catch (e: Exception) {
            // Show Error Message
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}