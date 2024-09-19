package com.kamau.viewmodeltutorial

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var number = 0
    fun  inCount(){
        number++
    }
}