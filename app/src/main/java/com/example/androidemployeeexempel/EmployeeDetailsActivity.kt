package com.example.androidemployeeexempel

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidemployeeexempel.databinding.ActivityEmployeeDetailsBinding

class EmployeeDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityEmployeeDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityEmployeeDetailsBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

      


        setTextViews()

        binding.btnBack.setOnClickListener {
            finish()
        }



    }

    fun setTextViews(){
        val employee: Employee?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            employee = intent.extras?.getSerializable("employee", Employee::class.java)
        }else{
            employee = intent.extras?.getSerializable("employee") as Employee
        }

        binding.tvName.text = employee?.name
        binding.tvId.text = employee?.id.toString()
        binding.tvSalary.text = employee?.salary.toString()

    }



}