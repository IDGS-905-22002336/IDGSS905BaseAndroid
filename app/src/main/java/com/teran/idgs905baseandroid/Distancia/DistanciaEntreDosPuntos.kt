package com.teran.idgs905baseandroid.Distancia

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.teran.idgs905baseandroid.R
import kotlin.math.pow
import kotlin.math.sqrt

class DistanciaEntreDosPuntos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var edtX1: EditText
        lateinit var edtY1: EditText
        lateinit var edtX2: EditText
        lateinit var edtY2: EditText
        lateinit var btnCalcular: Button
        lateinit var txtResultado: TextView

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distancia_entre_dos_puntos)

        edtX1 = findViewById(R.id.edtX1)
        edtY1 = findViewById(R.id.edtY1)
        edtX2 = findViewById(R.id.edtX2)
        edtY2 = findViewById(R.id.edtY2)

        btnCalcular = findViewById(R.id.btnCalcular)
        txtResultado = findViewById(R.id.txtResultado)

        btnCalcular.setOnClickListener {

            val x1 = edtX1.text.toString().toDouble()
            val y1 = edtY1.text.toString().toDouble()
            val x2 = edtX2.text.toString().toDouble()
            val y2 = edtY2.text.toString().toDouble()

            val distancia = sqrt(
                (x2 - x1).pow(2) +
                        (y2 - y1).pow(2)
            )

            txtResultado.text = "Resultado: $distancia"
        }
    }
}