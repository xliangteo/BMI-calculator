package com.example.bmicalculator


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculateActivity : AppCompatActivity() {
    var bmiIndex: Double = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        val personName = intent.getStringExtra("personName")

        val iv = findViewById<TextView>(R.id.pastName)
        iv.setText(personName)

        val btn = findViewById<Button>(R.id.calculateButton)

        if(savedInstanceState != null){
            bmiIndex = savedInstanceState.getDouble("bmiIndex")

            if(bmiIndex != 0.0){
                val tvStatus = findViewById<TextView>(R.id.statusAns)
                tvStatus.setText(getStatus())
            }
        }
        btn.setOnClickListener(){
            val weight = findViewById<TextView>(R.id.weightInput).text.toString()
            val height = findViewById<TextView>(R.id.heightInput).text.toString()
            val status = findViewById<TextView>(R.id.statusAns)

            bmiIndex = weight.toDouble() / (height.toDouble() * height.toDouble())

            status.setText(getStatus())

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("bmiIndex", bmiIndex)
    }

    fun getStatus():String {

        if (bmiIndex < 18.5)
            return "Underweight"
        else if (bmiIndex <= 24.9)
            return "Normal weight"
        else if (bmiIndex <= 29.9)
            return "Overweight"
        else if (bmiIndex <= 34.9)
            return "Obesity class 1"
        else if (bmiIndex <= 39.9)
            return "Obesity class 2"
        else return "Obesity class 3"

    }
}