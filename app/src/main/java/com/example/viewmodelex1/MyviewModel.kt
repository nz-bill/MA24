package com.example.viewmodelex1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyviewModel : ViewModel(){

//------------------------------------
    // LiveData är ett sätt för oss att 'lyssna' på förändringar i variabler.
    // på motsvarande sätt som en clickListener 'lyssnar' efter knapptryckningar så kan vi 'lyssna' efter förändringar i en LiveData

    //vi lägger in en variabel i en LiveData 'container'
    //vanligtvis så vill man ha en privat del (_counter) för att uppdatera innehållet och en publik del (counter) för att läsa innehållet

    private val _counter = MutableLiveData(0)       //_counter kan bara ändras innifrån klassen

    val counter: LiveData<Int> get() = _counter         //counter får sitt värde från _counter med get(),

    //----------------------------------


    //uppdaterar vår _counter, då kommer automatiskt counter att uppdatera sig själv (med get() )
    fun incrementCounter(){

        _counter.value = _counter.value?.plus(1)
    }



}
