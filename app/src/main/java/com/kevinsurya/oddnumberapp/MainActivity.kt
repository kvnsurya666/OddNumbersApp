package com.kevinsurya.oddnumberapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etInput = findViewById<EditText>(R.id.etInput)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)
        val btnUbah = findViewById<Button>(R.id.btnUbah)

        btnUbah.setOnClickListener {
            val inputText = etInput.text.toString()
            if (inputText.isEmpty()) {
                Toast.makeText(this, "Please enter numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val numbers = inputText.split(",").mapNotNull { it.trim().toIntOrNull() }
            val sortedOddNumbers = numbers.filter { it % 2 != 0 }.sorted()
            tvHasil.text = "Odd Numbers: ${sortedOddNumbers.joinToString(", ")}"
        }
    }
}