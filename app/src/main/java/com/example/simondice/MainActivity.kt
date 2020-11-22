package com.example.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var juego: MutableList<Int> = mutableListOf()
        var jugador: MutableList<Int> = mutableListOf()

        val red: Button = findViewById(R.id.bRed)
        red.setOnClickListener{
            jugador.add(1)
        }
        val yellow:Button = findViewById(R.id.bYellow)
        yellow.setOnClickListener{
            jugador.add(2)
        }
        val blue:Button = findViewById(R.id.bBlue)
        blue.setOnClickListener{
            jugador.add(3)
        }
        val green:Button = findViewById(R.id.bGreen)
        green.setOnClickListener{
            jugador.add(4)
        }

        fun rand(start: Int, end: Int): Int {
            require(start <= end) { "Illegal Argument"}
            return (start..end).random()
        }
        fun añadirColor()  {
            val numb= Random.nextInt(4) + 1
            juego.add(numb)
        }

        fun colores(){
           //CoroutineScope(Dispatchers.Main).launch {
                for(color in juego){
                    when (color) {
                        1 -> {
                            red.setPressed(true)
                            //delay(500)
                            red.setPressed(false)
                        }
                        2 -> {
                            yellow.setPressed(true)
                            //delay(500)
                            yellow.setPressed(false)
                        }
                        3 -> {
                            blue.setPressed(true)
                            //delay(500)
                            blue.setPressed(false)
                        }
                        else -> {
                            green.setPressed(true)
                            //delay(500)
                            green.setPressed(false)
                        }
                   // }
                }
            }
        }

        val check:Button = findViewById(R.id.bCheck)
        check.setOnClickListener{
            val toast = Toast.makeText(applicationContext,"Game Over", Toast.LENGTH_SHORT)
            if(juego == jugador){
                juego.add(rand(1,4))
                jugador.clear()
                colores()
            }else{
                toast.show()
                jugador.clear()
                juego.clear()
            }
        }

        val start:Button = findViewById(R.id.bStart)
        start.setOnClickListener{
            val toast = Toast.makeText(applicationContext,"Empieza el juego!", Toast.LENGTH_SHORT)
            jugador.clear()
            juego.clear()
            toast.show()
            juego.add(rand(1,4))
            colores()
        }
    }


}

