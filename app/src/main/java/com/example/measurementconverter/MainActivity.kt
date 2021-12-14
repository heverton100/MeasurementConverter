package com.example.measurementconverter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLen = findViewById<ImageButton>(R.id.btnLen)
        val btnData = findViewById<ImageButton>(R.id.btnData)
        val btnTemp = findViewById<ImageButton>(R.id.btnTemp)
        val btnMass = findViewById<ImageButton>(R.id.btnMass)

        btnLen.setOnClickListener {
            val intent = Intent(this, LengthConverter::class.java)
            startActivity(intent)
        }

        btnData.setOnClickListener {
            val intent = Intent(this, DataConverter::class.java)
            startActivity(intent)
        }

        btnTemp.setOnClickListener {
            val intent = Intent(this, TempConverter::class.java)
            startActivity(intent)
        }

        btnMass.setOnClickListener {
            val intent = Intent(this, MassConverter::class.java)
            startActivity(intent)
        }
    }
}