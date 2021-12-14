package com.example.measurementconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlin.Double as Double1

class LengthConverter : AppCompatActivity() {

    var units = arrayOf("Millimeters", "Centimeters", "Meters", "Kilometers")
    var selected = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_length_converter)

        val spinner = findViewById<Spinner>(R.id.select)
        val txtResult = findViewById<TextView>(R.id.txtResult)
        val txtValor = findViewById<EditText>(R.id.txtValor)
        val btnCalc = findViewById<Button>(R.id.btnConverter)

        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,units)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selected = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

        btnCalc.setOnClickListener {
            val valor  = txtValor.text.toString()
            if (valor != ""){
                if(selected == 0){
                    //Millimeter
                    var text1 = " Centimeter = "
                    text1 += Double.parseDouble(valor)/ 10f
                    text1 += "cm \n Meter = "
                    text1 += Double.parseDouble(valor) / 1000f
                    text1 += "m \n Kilometer = "
                    text1 += Double.parseDouble(valor) / 1000000f
                    text1 += "km"

                    txtResult.text = text1

                }else if(selected == 1){
                    //Centimeter
                    var text1 = " Millimeter = "
                    text1 += Double.parseDouble(valor)* 10f
                    text1 += "mm \n Meter = "
                    text1 += Double.parseDouble(valor) / 100f
                    text1 += "m \n Kilometer = "
                    text1 += Double.parseDouble(valor) / 100000f
                    text1 += "km"

                    txtResult.text = text1

                }else if(selected == 2){
                    //Meter
                    var text1 = " Millimeter = "
                    text1 +=  Double.parseDouble(valor)* 1000f
                    text1 += "mm \n Centimeter = "
                    text1 += Double.parseDouble(valor) * 100f
                    text1 += "cm \n Kilometer = "
                    text1 += Double.parseDouble(valor) / 1000f
                    text1 += "km"

                    txtResult.text = text1

                }else if(selected == 3){
                    //Kilometer

                    var text1 = " Millimeter = "
                    text1 +=  Double.parseDouble(valor)* 1000000f
                    text1 += "mm \n Centimeter = "
                    text1 += Double.parseDouble(valor) * 100000f
                    text1 += "cm \n Meter = "
                    text1 += Double.parseDouble(valor) * 1000f
                    text1 += "m"

                    txtResult.text = text1
                }
            }else{
                txtResult.text = "Add a value to converter."
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item?.itemId == android.R.id.home){
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}