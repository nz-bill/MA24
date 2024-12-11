package com.example.firebaseexempel1

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.auth

class AuthViewModel: ViewModel() {

    fun register(email: String, password: String, callback: (Task<AuthResult>) -> Unit){

        Firebase.auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
               callback(it)
            }
    }

    fun login(email:String, password:String, onSuccess: () -> Unit, onFailure: (Exception) -> Unit){

        Firebase.auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {
            onSuccess()
        }.addOnFailureListener {
            onFailure(it)

        }
    }
}