package com.example.firebaseexempel1

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class FirebaseManager {

    private val db = Firebase.firestore

    private val _persons = MutableLiveData(mutableListOf<Person>())

    lateinit var currentUser: FirebaseUser

    val persons: LiveData<MutableList<Person>> get() = _persons


    init {
        addSnapShotListener()
    }

    fun addSnapShotListener(){

        currentUser = Firebase.auth.currentUser ?: return

        db.collection("users").document(currentUser.uid).collection("persons").addSnapshotListener { snapshot, error ->

            if(snapshot != null){
                val currentList = mutableListOf<Person>()

                for (doc in snapshot.documents){
                    val person = doc.toObject(Person::class.java)
                    if (person != null){
                        currentList.add(person)
                    }
                }

                _persons.value = currentList
            }
        }
    }

    fun addPerson(name: String, phone: String){
        val person = Person(name, phone)

        currentUser = Firebase.auth.currentUser ?: return




        db.collection("users").document(currentUser.uid).collection("persons")
            .add(person)
            .addOnSuccessListener {
                Log.i("SOUT", "added person to Firestore")
            }.addOnFailureListener {
                Log.e("SOUT", "Failed to add person to Firestore")
            }


    }


}