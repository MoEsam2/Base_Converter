package com.example.convertercalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var binaryEditText: EditText
    private lateinit var decimalEditText: EditText
    private lateinit var octalEditText: EditText
    private lateinit var hexEditText: EditText
    private lateinit var clearButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         setId()
        clearButton.setOnClickListener{
            clearData()
            showMessage()
        }
        converters()
    }
    private fun showMessage()
    {
        Toast.makeText(this , "Clear",Toast.LENGTH_SHORT).show()
    }

    private fun converters() {
        binaryConverter()
        decimalConverter()
        octalConverter()
        hexConverter()
    }
    private fun setId()
    {
        binaryEditText = findViewById(R.id.binaryEditText)
        decimalEditText = findViewById(R.id.decimalEditText)
        octalEditText = findViewById(R.id.octalEditText)
        hexEditText = findViewById(R.id.hexEditText)
        clearButton = findViewById(R.id.clearButton)
    }
    private fun clearData() {
       decimalEditText.text?.clear()
       binaryEditText.text?.clear()
       octalEditText.text?.clear()
       hexEditText.text?.clear()
    }
    private fun binaryConverter() {
        binaryEditText.addTextChangedListener( object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binaryEditText.hasFocus())
                {
                    val binary = s.toString().toULongOrNull(2) ?: return
                    decimalEditText.setText(binary.toString(10))
                    octalEditText.setText(binary.toString(8))
                    hexEditText.setText(binary.toString(16).uppercase())
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
    }
    private fun decimalConverter() {
        decimalEditText.addTextChangedListener( object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(decimalEditText.hasFocus())
                {
                    val decimal = s.toString().toULongOrNull(10) ?: return
                    binaryEditText.setText(decimal.toString(2))
                    octalEditText.setText(decimal.toString(8))
                    hexEditText.setText(decimal.toString(16).uppercase())
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
    }
    private fun octalConverter() {
        octalEditText.addTextChangedListener( object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(octalEditText.hasFocus())
                {
                    val octal = s.toString().toULongOrNull(8) ?: return
                    binaryEditText.setText(octal.toString(2))
                    decimalEditText.setText(octal.toString(10))
                    hexEditText.setText(octal.toString(16).uppercase())
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
    }
    private fun hexConverter() {
        hexEditText.addTextChangedListener( object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(hexEditText.hasFocus())
                {
                    val hex = s.toString().toULongOrNull(16) ?: return
                    binaryEditText.setText(hex.toString(2))
                    decimalEditText.setText(hex.toString(10))
                    octalEditText.setText(hex.toString(8))
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
    }


}