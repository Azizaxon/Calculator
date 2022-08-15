package uz.aziza.homework_kalkulyatorr1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button_clear.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        button_breacket_left.setOnClickListener {
            input.text = addToInputText("(")
        }
        button_breacket_right.setOnClickListener {
            input.text = addToInputText(")")
        }
        button_0.setOnClickListener {
            input.text = addToInputText("0")
        }
        button_1.setOnClickListener {
            input.text = addToInputText("1")
        }
        button_2.setOnClickListener {
            input.text = addToInputText("2")
        }
        button_3.setOnClickListener {
            input.text = addToInputText("3")
        }
        button_4.setOnClickListener {
            input.text = addToInputText("4")
        }
        button_5.setOnClickListener {
            input.text = addToInputText("5")
        }
        button_6.setOnClickListener {
            input.text = addToInputText("6")
        }
        button_7.setOnClickListener {
            input.text = addToInputText("7")
        }
        button_8.setOnClickListener {
            input.text = addToInputText("8")
        }
        button_9.setOnClickListener {
            input.text = addToInputText("9")
        }
//        button_dot.setOnClickListener {
//            input.text = addToInputText(".")
//        }
//        button_division.setOnClickListener {
//            input.text = addToInputText(":")
//        }
//        button_multiply.setOnClickListener {
//            input.text = addToInputText("x")
//        }
//        button_subtraction.setOnClickListener {
//            input.text = addToInputText("-")
//        }
//        button_addition.setOnClickListener {
//            input.text = addToInputText("+")
//        }

        button_dot.setOnClickListener {raqamYoz(".")}
        button_division.setOnClickListener{raqamYoz(":")}
        button_multiply.setOnClickListener{raqamYoz("x")}
        button_subtraction.setOnClickListener{raqamYoz("-")}
        button_addition.setOnClickListener{raqamYoz("+")}

        button_dot.setOnClickListener {amalYoz(".")}
        button_division.setOnClickListener{amalYoz(":")}
        button_multiply.setOnClickListener{amalYoz("x")}
        button_subtraction.setOnClickListener{amalYoz("-")}
        button_addition.setOnClickListener{amalYoz("+")}

        button_equals.setOnClickListener {
            showResult()
        }


    }

    private fun addToInputText(buttonValue: String): String {
        return "${input.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var excpression = input.text.replace(Regex(":"), "/")
        excpression = excpression.replace(Regex("x"), "*")
        return excpression
    }


    @SuppressLint("SetTextI18n")
    private fun showResult() {

        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()


            if (result.isNaN()) {
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
            

        } catch (e: Exception) {
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }

    }

    private fun raqamYoz(raqam:String){
        if (input.text.toString() == "0"){
            input.text = raqam
        }else{
            input.text = input.text.toString() + raqam
        }
    }

//    private fun dot(nuqta:String){
//        if (button_dot.text.indices == 1){
//            true
//        }else{
//            false
//        }
//    }

    private fun amalYoz(amal:String){
        val inputVal = input.text.toString()
        if (inputVal.last() == '+' || inputVal.last() == '-' || inputVal.last() == ':' || inputVal.last() == '*' || inputVal.last() == '.'){
            input.text = inputVal.substring(0, inputVal.length-1) + amal
        }else{
            input.text = inputVal+amal
        }
    }
}

