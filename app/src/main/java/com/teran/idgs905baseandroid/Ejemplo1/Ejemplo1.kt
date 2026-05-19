package com.teran.idgs905baseandroid.Ejemplo1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.teran.idgs905baseandroid.R
import android.content.Intent
import com.teran.idgs905baseandroid.Distancia.DistanciaEntreDosPuntos

class Ejemplo1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var edtNumero1: EditText
        lateinit var edtNumero2: EditText
        lateinit var btnSumar: Button
        lateinit var txtResultado: TextView
        lateinit var btnIrDistancia: Button

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        edtNumero1=findViewById(R.id.edtNumero1)
        edtNumero2=findViewById(R.id.edtNumero2)
        btnSumar=findViewById(R.id.btnSumar)
        txtResultado=findViewById(R.id.txtResultado)
        btnIrDistancia=findViewById(R.id.btnIrDistancia)

        btnSumar.setOnClickListener {
            val num1 = Integer.parseInt(edtNumero1.text.toString())
            val num2 = Integer.parseInt(edtNumero2.text.toString())
            txtResultado.setText("resultado: "+sumar(num1, num2))
        }

        btnIrDistancia.setOnClickListener {

            val intent = Intent(this, DistanciaEntreDosPuntos::class.java)
            startActivity(
                intent
            )

        }
    }

    fun sumar(numero1:Int, numero2:Int):Int{
        return numero1+numero2
    }

}