package com.teran.idgs905baseandroid.ExamenResistencia

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.teran.idgs905baseandroid.R

class Examen1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_examen1)

        val spBanda1 = findViewById<Spinner>(R.id.spBanda1)
        val spBanda2 = findViewById<Spinner>(R.id.spBanda2)
        val spMultiplicador = findViewById<Spinner>(R.id.spMultiplicador)
        val txtColorBanda1 = findViewById<TextView>(R.id.txtColorBanda1)
        val txtColorBanda2 = findViewById<TextView>(R.id.txtColorBanda2)
        val txtColorMultiplicador = findViewById<TextView>(R.id.txtColorMultiplicador)
        val rbOro = findViewById<RadioButton>(R.id.rbOro)
        val rbPlata = findViewById<RadioButton>(R.id.rbPlata)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtResultado = findViewById<TextView>(R.id.txtResultados)
        val txtToleranciaColor = findViewById<TextView>(R.id.txtToleranciaColor)

        val colores = arrayOf(
            "Negro", "Cafe", "Rojo", "Naranja", "Amarillo",
            "Verde", "Azul", "Violeta", "Gris", "Blanco"
        )

        val coloresHex = arrayOf(
            Color.parseColor("#000000"), // Negro
            Color.parseColor("#8B4513"), // Cafe
            Color.parseColor("#FF0000"), // Rojo
            Color.parseColor("#FFA500"), // Naranja
            Color.parseColor("#FFFF00"), // Amarillo
            Color.parseColor("#008000"), // Verde
            Color.parseColor("#0000FF"), // Azul
            Color.parseColor("#EE82EE"), // Violeta
            Color.parseColor("#808080"), // Gris
            Color.parseColor("#FFFFFF")  // Blanco
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colores)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spBanda1.adapter = adapter
        spBanda2.adapter = adapter
        spMultiplicador.adapter = adapter

        spBanda1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                txtColorBanda1.setBackgroundColor(coloresHex[position])
                txtColorBanda1.text = position.toString()
                if (position == 4 || position == 9) {
                    txtColorBanda1.setTextColor(Color.BLACK)
                } else {
                    txtColorBanda1.setTextColor(Color.WHITE)
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spBanda2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                txtColorBanda2.setBackgroundColor(coloresHex[position])
                txtColorBanda2.text = position.toString()
                if (position == 4 || position == 9) {
                    txtColorBanda2.setTextColor(Color.BLACK)
                } else {
                    txtColorBanda2.setTextColor(Color.WHITE)
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spMultiplicador.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                txtColorMultiplicador.setBackgroundColor(coloresHex[position])
                val valorMultiplicativo = Math.pow(10.0, position.toDouble()).toInt()
                txtColorMultiplicador.text = "x$valorMultiplicativo"
                if (position == 4 || position == 9) {
                    txtColorMultiplicador.setTextColor(Color.BLACK)
                } else {
                    txtColorMultiplicador.setTextColor(Color.WHITE)
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        rbOro.setOnClickListener {
            txtToleranciaColor.text = "Oro"
            txtToleranciaColor.setBackgroundColor(Color.parseColor("#FFD700"))
            txtToleranciaColor.setTextColor(Color.BLACK)
        }

        rbPlata.setOnClickListener {
            txtToleranciaColor.text = "Plata"
            txtToleranciaColor.setBackgroundColor(Color.parseColor("#C0C0C0"))
            txtToleranciaColor.setTextColor(Color.BLACK)
        }

        btnCalcular.setOnClickListener {
            val banda1 = spBanda1.selectedItemPosition
            val banda2 = spBanda2.selectedItemPosition
            val multiplicador = spMultiplicador.selectedItemPosition
            val valorOhm = ((banda1 * 10) + banda2) * Math.pow(10.0, multiplicador.toDouble()).toLong()
            var tolerancia = 0.0

            if (rbOro.isChecked) {
                tolerancia = 0.05
                btnCalcular.setBackgroundColor(Color.parseColor("#FFD700")) // Color Oro
                btnCalcular.setTextColor(Color.BLACK)
            }

            if (rbPlata.isChecked) {
                tolerancia = 0.10
                btnCalcular.setBackgroundColor(Color.parseColor("#C0C0C0")) // Color Plata
                btnCalcular.setTextColor(Color.BLACK)
            }

            val valorMaximo = valorOhm + (valorOhm * tolerancia)
            val valorMinimo = valorOhm - (valorOhm * tolerancia)

            txtResultado.text = "Valor Ohm: " + valorOhm + "\n\n" +
                    "Valor Maximo: " + valorMaximo + "\n\n" +
                    "Valor Minimo: " + valorMinimo
        }
    }
}