package com.example.recyclerviewexempel1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexempel1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val users = mutableListOf<String>("Bill","Boll","Bull", "Arne")

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.rvList.layoutManager = LinearLayoutManager(this)
        binding.rvList.adapter = UserAdapter(users)

        binding.btnAdd.setOnClickListener {
            addUser()
        }


    }

    fun addUser(){

        if(binding.etName.text.isNotBlank()){
            val name = binding.etName.text.toString()

            users.add(name)
            binding.rvList.adapter?.notifyItemInserted(users.lastIndex)
        }

    }
}