package com.example.firebaseexempel1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.firebaseexempel1.databinding.ActivityLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var auth: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = ViewModelProvider(this).get(AuthViewModel::class.java)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.btnRegister.setOnClickListener {
            if (checkValidInput()){
                register()
            }

        }

        binding.btnLogin.setOnClickListener {
            if (checkValidInput()){
                login()
            }

        }


    }

    fun login(){
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        auth.login(email, password, onSuccess = {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }, onFailure = {
            Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT).show()
        })

    }

    fun register(){

        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        auth.register(email,password) {
            if (it.isSuccessful) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun checkValidInput(): Boolean{
        var check = true
        if(binding.etEmail.text.isBlank()){
            check = false
            Toast.makeText(this,"Email cannot be blank", Toast.LENGTH_SHORT).show()
        }
        if(binding.etPassword.text.isBlank()){
            check = false
            Toast.makeText(this,"Password cannot be blank", Toast.LENGTH_SHORT).show()
        }
        if(binding.etPassword.text.toString().length < 6){
            check = false
            Toast.makeText(this,"Password must be at least 6 characters long", Toast.LENGTH_SHORT).show()
        }


        return check
    }
}