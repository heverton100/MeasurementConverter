package com.example.measurementconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import java.util.*
import kotlin.Double as Double1

class TempConverter : AppCompatActivity() {

    var units = arrayOf("Celsius", "Kelvin", "Fahrenheit")
    var selected = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp_converter)

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
            val valor = txtValor.text.toString()
            if(valor != ""){
                if(selected == 0){
                    var text1 = " Kelvin = "
                    text1 +=  valueFormat(Double.parseDouble(valor) + 273.15)
                    text1 += "K \n Fahrenheit = "
                    text1 += valueFormat((Double.parseDouble(valor) * 9/5)+ 32f)
                    text1 += "°F"
                    txtResult.text = text1

                }else if(selected == 1){
                    var text1 = " Celsius = "
                    text1 +=  valueFormat(Double.parseDouble(valor) - 273.15)
                    text1 += "°C \n Fahrenheit = "
                    text1 += valueFormat((Double.parseDouble(valor) - 273.15)* 9/5 + 32f)
                    text1 += "°F \n"

                    txtResult.text = text1

                }else if(selected == 2){
                    var text1 = " Celsius = "
                    text1 +=  valueFormat((Double.parseDouble(valor) - 32) * 5/9 )
                    text1 += "°C \n Kelvin = "
                    text1 += valueFormat((Double.parseDouble(valor) - 32) * 5/9 + 273.15)
                    text1 += "K"


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

    private fun valueFormat(valor: kotlin.Double): Any? {
        return String.format(Locale.FRANCE,"%.2f",valor)
    }
}