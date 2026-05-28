package com.teran.idgs905baseandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.teran.idgs905baseandroid.Ejemplo1.Ejemplo1
import com.teran.idgs905baseandroid.Ejemplo2.Ejemplo2Activity
import com.teran.idgs905baseandroid.Distancia.DistanciaEntreDosPuntos
import com.teran.idgs905baseandroid.MultiplicarAyB.Multiplicacion
import com.teran.idgs905baseandroid.ExamenResistencia.Examen1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnEjemplo1 = findViewById<Button>(R.id.btn1)
        val btnEjemplo2 = findViewById<Button>(R.id.btnEjemplo2)
        val btnDistancia = findViewById<Button>(R.id.btnDistancia)
        val btnMultiplicacion = findViewById<Button>(R.id.btnMultiplicacion)
        val btnExamen1 = findViewById<Button>(R.id.btnExamen1)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnEjemplo1.setOnClickListener { navigateToEjemplo1() }
        btnEjemplo2.setOnClickListener { navigateToEjemplo2() }
        btnDistancia.setOnClickListener { navigateToDistancia() }
        btnMultiplicacion.setOnClickListener { navigateToMultiplicacion() }
        btnExamen1.setOnClickListener { navigateToExamen1() }
    }

    fun navigateToEjemplo1() {
        val intent = Intent(this, Ejemplo1::class.java)
        startActivity(intent)
    }

    fun navigateToEjemplo2() {
        val intent = Intent(this, Ejemplo2Activity::class.java)
        startActivity(intent)
    }

    fun navigateToDistancia() {
        val intent = Intent(this, DistanciaEntreDosPuntos::class.java)
        startActivity(intent)
    }

    fun navigateToMultiplicacion() {
        val intent = Intent(this, Multiplicacion::class.java)
        startActivity(intent)
    }

    fun navigateToExamen1(){
        val intent = Intent(this, Examen1::class.java)
        startActivity(intent)
    }
}