package com.example.measurementconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlin.Double as Double1

class DataConverter : AppCompatActivity() {

    var units = arrayOf("Bytes", "Kilobytes", "Megabytes", "Gigabytes")
    var selected = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_converter)

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
                    var text1 = " Kilobyte = "
                    text1 +=  Double.parseDouble(valor)/ 1000f
                    text1 += "kb \n MegaByte = "
                    text1 += Double.parseDouble(valor) / 1000000f
                    text1 += "mb \n Gigabyte = "
                    text1 += Double.parseDouble(valor) / 1000000000f
                    text1 += "gb"

                    txtResult.text = text1

                }else if(selected == 1){
                    var text1 = " Byte = "
                    text1 +=  Double.parseDouble(valor)* 1000f
                    text1 += "b \n MegaByte = "
                    text1 += Double.parseDouble(valor) / 1000f
                    text1 += "mb \n GigaByte = "
                    text1 += Double.parseDouble(valor) / 1000000f
                    text1 += "gb"

                    txtResult.text = text1

                }else if(selected == 2){
                    var text1 = " Byte = "
                    text1 +=  Double.parseDouble(valor)* 1000000f
                    text1 += "b \n KiloByte = "
                    text1 += Double.parseDouble(valor) * 1000f
                    text1 += "kb \n GigaByte = "
                    text1 += Double.parseDouble(valor) / 1000f
                    text1 += "gb"

                    txtResult.text = text1

                }else if(selected == 3){
                    var text1 = " Byte = "
                    text1 +=  Double.parseDouble(valor)* 1000000000f
                    text1 += "b \n KiloByte = "
                    text1 += Double.parseDouble(valor) * 1000000f
                    text1 += "kb \n MegaByte = "
                    text1 += Double.parseDouble(valor) * 1000f
                    text1 += "mb"

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