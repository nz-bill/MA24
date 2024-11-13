package com.example.androidemployeeexempel

import java.io.Serializable

data class Employee(val name: String, val salary: Double): Serializable {

    val id: Int = generateId()


    companion object{
        private var idCounter = 0

        private fun generateId():Int{
            idCounter++

            return idCounter
        }

    }

    override fun toString(): String {
        return "$name', salary=$salary"
    }


}