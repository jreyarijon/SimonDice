package com.example.simondice

import android.widget.Button
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ViewModel: ViewModel() {
    val juego = MutableLiveData<MutableList<Int>>()
    val jugador = MutableLiveData<MutableList<Int>>()

    init {
        jugador.value = mutableListOf()
        juego.value= mutableListOf()
    }

    fun añadirjugador(color: Int){
        when(color){
            1 -> jugador.value?.add(1)
            2 -> jugador.value?.add(2)
            3 -> jugador.value?.add(3)
            else -> jugador.value?.add(4)
        }
    }


    fun rand(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument"}
        return (start..end).random()
    }

    fun comenzar(){
        juego.value?.clear()
        jugador.value?.clear()
        juego.value?.add(rand(1,4))
        juego.postValue(juego.value)
    }

    fun comprobar(): Boolean{
        var perder = false
        if(juego.value == jugador.value){
            juego.value?.add(rand(1,4))
            juego.postValue(juego.value)
            jugador.value?.clear()
            perder = true
        }
        return perder
    }

    fun mostrar(botones: List<Button>){
        CoroutineScope(Dispatchers.Main).launch {
            for (colors in juego.value!!) {
                botones.get(colors - 1).setPressed(true)
                delay(1500)
                botones.get(colors - 1).setPressed(false)
            }
        }
    }
}