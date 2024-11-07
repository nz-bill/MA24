package com.example.androidemployeeexempel

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var etName: EditText
    lateinit var etSalary: EditText
    lateinit var lvEmloyees: ListView
    lateinit var adapter: EmployeeAdapter
    var employeeList = mutableListOf<Employee>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        etName = findViewById(R.id.et_name)
        etSalary = findViewById(R.id.et_salary)
        lvEmloyees = findViewById(R.id.lv_employees)

        val btnAdd: Button = findViewById(R.id.btn_add)
        btnAdd.setOnClickListener {
            createEmployee()
        }

        //this.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,employeeList)
        this.adapter = EmployeeAdapter(this,employeeList)
       // Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()

        lvEmloyees.adapter = this.adapter;

        lvEmloyees.setOnItemLongClickListener { parent, view, position, _ ->
            employeeList.removeAt(position)

            adapter.notifyDataSetChanged()

            true
        }

    }

    fun createEmployee(){

        if (etName.text.isNotBlank() && etSalary.text.isNotBlank()){
            val name = etName.text.toString()
            val salary = etSalary.text.toString().toDouble()

            val e = Employee(name,salary)
            employeeList.add(e)
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
            etName.text.clear()
            etSalary.text.clear()
            adapter.notifyDataSetChanged()
        } else{
            Toast.makeText(this, "no fields should be empty", Toast.LENGTH_SHORT).show()
        }

    }
}