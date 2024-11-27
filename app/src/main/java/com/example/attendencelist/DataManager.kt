package com.example.attendencelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.text.FieldPosition

object DataManager {

    private val _students = MutableLiveData( mutableListOf<Student>())

    val students : LiveData<MutableList<Student>> get() = _students

    init {
        createMockData()
    }

    fun createMockData() {
        _students.value?.add(Student("David", "APP22" , true))
        _students.value?.add(Student("Lois", "APP22"))
        _students.value?.add(Student("Laura", "APP22"))
        _students.value?.add(Student("Susan", "APP22"))
        _students.value?.add(Student("Jacob", "APP22", true))
        _students.value?.add(Student("Per", "APP22"))
    }

    fun removeStudent(student: Student){
        val currentList = _students.value ?: mutableListOf()
        currentList.remove(student)
        _students.value = currentList


    }

    fun editStudent(position: Int, name: String, className: String){
        val currentList = _students.value ?: mutableListOf()
        currentList[position].name = name
        currentList[position].className = className
        _students.value = currentList
    }

    fun addStudent(student: Student){
        val currentList = _students.value ?: mutableListOf()
        currentList.add(student)
        _students.value = currentList
    }

    fun checkPresent(position: Int, isPresent: Boolean){
        val currentList = _students.value ?: mutableListOf()
       currentList[position].present = isPresent
        _students.value = currentList
    }
}