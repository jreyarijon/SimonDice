package com.example.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.Observer
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val simonDice by viewModels<ViewModel>()

        val red: Button = findViewById(R.id.bRed)
        red.setOnClickListener{
            simonDice.añadirjugador(1)
        }
        val yellow:Button = findViewById(R.id.bYellow)
        yellow.setOnClickListener{
            simonDice.añadirjugador(2)
        }
        val blue:Button = findViewById(R.id.bBlue)
        blue.setOnClickListener{
            simonDice.añadirjugador(3)
        }
        val green:Button = findViewById(R.id.bGreen)
        green.setOnClickListener{
            simonDice.añadirjugador(4)
        }

        val check:Button = findViewById(R.id.bCheck)
        check.setOnClickListener{
            val toast = Toast.makeText(applicationContext,"Game Over", Toast.LENGTH_SHORT)
            if(!simonDice.comprobar()){
                toast.show()
            }
        }

        val start:Button = findViewById(R.id.bStart)
        start.setOnClickListener{
            val toast = Toast.makeText(applicationContext,"Empieza el juego!", Toast.LENGTH_SHORT)
            toast.show()
            simonDice.comenzar()
        }

        simonDice.juego.observe(this, Observer{
            val botones = listOf(red,yellow,blue,green)
            simonDice.mostrar(botones)
        })


    }

}




