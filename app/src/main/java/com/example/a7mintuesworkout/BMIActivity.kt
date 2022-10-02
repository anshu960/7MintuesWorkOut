package com.example.a7mintuesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.a7mintuesworkout.databinding.ActivityBmiBinding

class BMIActivity : AppCompatActivity() {
    private var binding: ActivityBmiBinding?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarBmiActivity)
        if (supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "BMI Calculator"
        }
        binding?.toolbarBmiActivity?.setNavigationOnClickListener {
            onBackPressed()
        }
        binding?.btnCalculateUnits?.setOnClickListener {
            if (validMetricUnits()){
                val heightValue :Float = binding?.etMetricUnitHeight?.text.toString().toFloat() / 100
                val weightValue :Float = binding?.etMetricUnitWeight?.text.toString().toFloat()
                val bmi = weightValue / (heightValue*heightValue)

            }else{
                Toast.makeText(this@BMIActivity, "Please enter valid values.",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun displayBMIResult(bmi: Float){
        val bmilebel : String
        val bmiDescription: String
        if (bmi.compareTo(15f) <= 0){
            bmilebel = "Very severely underweight"
            bmiDescription = "Oops! you really need to take better care of yourself!"
        }else if (bmi.compareTo(15f) > 0 && bmi.compareTo(16f) <= 0
        ){
            bmilebel = "Severely Underweight"

        }
        binding?.llDisplayBMIResult?.visibility = View.VISIBLE

    }
    private fun validMetricUnits(): Boolean{
        var isValid = true
        if (binding?.etMetricUnitWeight?.text.toString().isEmpty()){
            isValid = false
        } else if (binding?.etMetricUnitHeight?.text.toString().isEmpty()){
            isValid = false
        }

        return isValid
    }
}