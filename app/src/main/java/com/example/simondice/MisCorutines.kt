package com.example.simondice

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers


object MisCorutines {
    fun salidaLog(){
        CoroutineScope(Dispatchers.Main).launch{
            suspendFun("Start")
            delay(5000)
            suspendFun("Stop")
        }
    }

    private fun suspendFun(message: String){
        Log.d("mensaje corutina", message)
    }
}