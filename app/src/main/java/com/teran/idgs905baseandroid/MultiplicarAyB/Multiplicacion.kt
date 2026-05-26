package com.teran.idgs905baseandroid.MultiplicarAyB

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.teran.idgs905baseandroid.R

class Multiplicacion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_multiplicacion)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtA = findViewById<EditText>(R.id.edtA)
        val edtB = findViewById<EditText>(R.id.edtB)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener {

            if (edtA.text.isEmpty() || edtB.text.isEmpty()) {
                Toast.makeText(this, "Ingresa ambos números", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val a = edtA.text.toString().toInt()
            val b = edtB.text.toString().toInt()

            val intent = Intent(this, ResultadoMulti::class.java)
            intent.putExtra("A", a)
            intent.putExtra("B", b)
            startActivity(intent)
        }
    }
}