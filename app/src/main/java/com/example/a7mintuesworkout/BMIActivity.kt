package com.example.a7mintuesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.a7mintuesworkout.databinding.ActivityBmiBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {
    companion object{
        private const val METRIC_UNITS_VIEW = "METRIC_UNIT_VIEW"
        private const val US_UNITS_VIEW = "US_UNIT_VIEW"
    }
    private var currentVisibleView: String = METRIC_UNITS_VIEW
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
        makeVisibleMetricUnitsView()

        binding?.rgUnits?.setOnCheckedChangeListener { _, checkedId: Int ->
            if (checkedId == R.id.rbMetricUnits){
                makeVisibleMetricUnitsView()
            }else{
                makeVisibleUsUnitsView()
            }
        }
        binding?.btnCalculateUnits?.setOnClickListener {
            calculateUnits()
        }
    }

    private fun makeVisibleMetricUnitsView(){
        currentVisibleView = METRIC_UNITS_VIEW
        binding?.tilMetricUnitWeight?.visibility = View.VISIBLE
        binding?.tilMetricUnitHeight?.visibility = View.VISIBLE
        binding?.tilUsMetricUnitWeight?.visibility = View.GONE
        binding?.tilMetricUnitHeightFeet?.visibility = View.GONE
        binding?.tilMetricUnitHeightInch?.visibility = View.GONE

        binding?.etMetricUnitHeight?.text!!.clear()
        binding?.etMetricUnitWeight?.text!!.clear()
        binding?.llDisplayBMIResult?.visibility = View.INVISIBLE
    }
    private fun makeVisibleUsUnitsView(){
        currentVisibleView = US_UNITS_VIEW
        binding?.tilMetricUnitHeight?.visibility = View.INVISIBLE
        binding?.tilMetricUnitWeight?.visibility = View.INVISIBLE
        binding?.tilUsMetricUnitWeight?.visibility = View.VISIBLE
        binding?.tilMetricUnitHeightFeet?.visibility = View.VISIBLE
        binding?.tilMetricUnitHeightInch?.visibility = View.VISIBLE
        binding?.etUsMetricUnitWeight?.text!!.clear()
        binding?.etUsMetricUnitHeightFeet?.text!!.clear()
        binding?.etUsMetricUnitHeightInch?.text!!.clear()
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
            bmiDescription = "Oops! You really need to take better care of yourself!"
        }
        else if (bmi.compareTo(16f) > 0 && bmi.compareTo(18.5f) <= 0
        ){
            bmilebel = "Underweight"
            bmiDescription = "Oops! You really need to take better care of yourself!"
        }
        else if (bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f) <= 0
        ){
            bmilebel = "Normal"
            bmiDescription = "Congratulations! You are in a good shape!"
        }
        else if (bmi.compareTo(25f) > 0 && bmi.compareTo(30f) <= 0
        ){
            bmilebel = "Obese Class | (Moderately obase)"
            bmiDescription = "Oops! You really need to take care of your yourself! Workout"
        }else if (bmi.compareTo(30f) > 0 && bmi.compareTo(35f) <=0
        ){
            bmilebel = "Obese Class | (Moderately obase)"
            bmiDescription = "Oops! You really need to take care of your yourself! Workout"
        }
        else if (bmi.compareTo(35f) > 0 && bmi.compareTo(40f) <=0
        ){
            bmilebel = "Obese Class | (Moderately obase)"
            bmiDescription = "OMG! You are in a very dangerous condition! Act now"
        }else{
            bmilebel = "Obese Class ||| (Very Severely obese)"
            bmiDescription = "OMG! You are in a very dangerous condition! Act now!"
        }
        val bmiValue = BigDecimal(bmi.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()

        binding?.llDisplayBMIResult?.visibility = View.VISIBLE
        binding?.tvBMIValue?.text = bmiValue
        binding?.tvBMIType?.text = bmilebel
        binding?.tvBMIDescription?.text = bmiDescription


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
    private fun calculateUnits(){
        if (currentVisibleView == METRIC_UNITS_VIEW){
            if (validMetricUnits()){
                val heightValue : Float = binding?.etMetricUnitHeight?.text.toString().toFloat() / 100
                val weightValue : Float = binding?.etMetricUnitWeight?.text.toString().toFloat()
                val bmi = weightValue / (heightValue*heightValue)
                displayBMIResult(bmi)
            }else{
                Toast.makeText(this@BMIActivity,"Please enter valid value.",
                Toast.LENGTH_LONG).show()
            }
        }else{
            if (validateUsUnits()){
                val usUnitHeightValueFeet: String =
                    binding?.etUsMetricUnitHeightFeet?.text.toString()
                val usUnitHeightValueInch: String =
                    binding?.etUsMetricUnitHeightInch?.text.toString()
                val usUnitWeightValue: Float =
                    binding?.etUsMetricUnitWeight?.text.toString().toFloat()
                val heightValue =
                    usUnitHeightValueInch.toFloat() + usUnitHeightValueFeet.toFloat() * 12
                val bmi = 703 * (usUnitWeightValue / (heightValue + heightValue))
                displayBMIResult(bmi)
            }else{
                Toast.makeText(this@BMIActivity,
                "Please enter valid values.", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun validateUsUnits(): Boolean {
        var isValid = true
        when{
            binding?.etUsMetricUnitWeight?.text.toString().isEmpty() ->{
                isValid = false
            }
            binding?.etUsMetricUnitHeightFeet?.text.toString().isEmpty() ->{
                isValid = false
            }
            binding?.etUsMetricUnitHeightInch?.text.toString().isEmpty() ->{
                isValid = false
            }
        }
       return isValid
    }

}