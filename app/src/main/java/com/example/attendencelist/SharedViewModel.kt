package com.example.attendencelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    val students: LiveData<MutableList<Student>> get() = DataManager.students


    fun removeStudent(student: Student){
        DataManager.removeStudent(student)
    }

    fun checkIsPresent(position: Int, isPresent: Boolean){
        DataManager.checkPresent(position, isPresent)
    }
    fun addStudent(student: Student){
        DataManager.addStudent(student)
    }

    fun editStudent(position: Int, name: String, className:String){
        DataManager.editStudent(position, name, className)
    }




}