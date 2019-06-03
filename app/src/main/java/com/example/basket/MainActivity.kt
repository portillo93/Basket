package com.example.basket

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.basket.Repository.Repository
import com.example.basket.ViewModel.DBViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var jugador1: Int? = 0
        var jugador2: Int? = 0
        lateinit var editnombrejugador1 : EditText
        lateinit var editnombrejugador2 : EditText
        lateinit var  puntaje1 : String
        lateinit var puntaje2 : String
        lateinit var viewModel: DBViewModel
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editnombrejugador1 = findViewById(R.id.et_Jugador1)
        editnombrejugador2 = findViewById(R.id.et_Jugador2)
        val txtpunt1 = findViewById<TextView>(R.id.score1)
        val txtpunt2 = findViewById<TextView>(R.id.score2)
        val pnt1_j1 = findViewById<Button>(R.id.addunoteama)
        val pnt2_j1 = findViewById<Button>(R.id.adddosteama)
        val pnt3_j1 = findViewById<Button>(R.id.addtresteama)
        val pnt1_j2 = findViewById<Button>(R.id.addunoteamb)
        val pnt2_j2 = findViewById<Button>(R.id.adddosteamb)
        val pnt3_j2 = findViewById<Button>(R.id.addtresteamb)
        val guardar = findViewById<Button>(R.id.btn_reset)
        viewModel = ViewModelProviders.of(this).get(DBViewModel::class.java)
        pnt1_j1.setOnClickListener { jugador1 = jugador1?.plus(1)
            txtpunt1.text = jugador1.toString()}
        pnt2_j1.setOnClickListener { jugador1 =jugador1?.plus(2)
            txtpunt1.text = jugador1.toString() }
        pnt3_j1.setOnClickListener { jugador1 =jugador1?.plus(3)
            txtpunt1.text = jugador1.toString() }
        pnt1_j2.setOnClickListener { jugador2 =jugador2?.plus(1)
            puntaje2 = jugador2.toString()
            txtpunt2.text = puntaje2 }
        pnt2_j2.setOnClickListener { jugador2 =jugador2?.plus(2)
            puntaje2 = jugador2.toString()
            txtpunt2.text = puntaje2 }
        pnt3_j2.setOnClickListener { jugador2 =jugador2?.plus(3)
            puntaje2 = jugador2.toString()
            txtpunt2.text = puntaje2 }
        guardar.setOnClickListener {
            val nombre = editnombrejugador1.text.toString()+ " vs " +editnombrejugador2.text.toString()
            viewModel.insertPartido(Repository(nombre,et_Jugador1.text.toString(), jugador1.toString(), et_Jugador2.text.toString(), jugador2.toString(), editnombrejugador1.text.toString() ))       }
    }
}
