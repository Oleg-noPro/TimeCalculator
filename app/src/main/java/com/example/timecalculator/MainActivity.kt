package com.example.timecalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var firstOperandET: EditText
    private lateinit var secondOperandET: EditText

    private lateinit var buttonSumBTN: Button
    private lateinit var buttonDifBTN: Button

    private lateinit var buttonResetBTN: Button
    private lateinit var buttonExitBTN: Button

    private lateinit var resultTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        firstOperandET = findViewById(R.id.firstOperandET)
        secondOperandET = findViewById(R.id.secondOperandET)

        buttonSumBTN = findViewById(R.id.buttonSumBTN)
        buttonDifBTN = findViewById(R.id.buttonDifBTN)
        buttonResetBTN = findViewById(R.id.buttonResetBTN)
        buttonExitBTN = findViewById(R.id.buttonExitBTN)



        resultTV = findViewById(R.id.resultTV)

        buttonSumBTN.setOnClickListener(this)
        buttonDifBTN.setOnClickListener(this)
        buttonResetBTN.setOnClickListener(this)
        buttonExitBTN.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        var check = true

        if (firstOperandET.text.isEmpty() || secondOperandET.text.isEmpty()) return

        val first = firstOperandET.text.toString()
        val second = secondOperandET.text.toString()

        var result = when(v.id) {
            R.id.buttonSumBTN -> Operation(first, second).sum()
            R.id.buttonDifBTN -> Operation(first, second).dif()
            R.id.buttonResetBTN -> {
                firstOperandET.text.clear()
                secondOperandET.text.clear()
                check = false
            }
            R.id.buttonExitBTN -> finish()
            else -> "0s"
        }
        if (!check) resultTV.text = "Результат" else resultTV.text = result.toString()
    }
}