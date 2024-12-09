package com.example.firebaseexempel1

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class PersonViewModel: ViewModel() {

    val firebaseManager = FirebaseManager()

    val persons: LiveData<MutableList<Person>> get() = firebaseManager.persons


    fun addPerson(name: String, phone: String){

        firebaseManager.addPerson(name,phone)
    }
}