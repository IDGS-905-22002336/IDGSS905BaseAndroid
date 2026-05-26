package com.teran.idgs905baseandroid.MultiplicarAyB

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.teran.idgs905baseandroid.R

class ResultadoMulti : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado_multi)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtOperacion = findViewById<TextView>(R.id.txtOperacion)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        val a = intent.getIntExtra("A", 0)
        val b = intent.getIntExtra("B", 0)

        var operacion = ""
        for (i in 1..b) {
            operacion += a.toString()
            if (i < b) {
                operacion += " * "
            }
        }

        val resultado = a * b
        txtOperacion.text = operacion
        txtResultado.text = "= $resultado"
    }
}