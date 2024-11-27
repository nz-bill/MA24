package com.example.attendencelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    lateinit var vm: SharedViewModel

    lateinit var studentAdapter: StudentsRecylerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        vm = ViewModelProvider(this).get(SharedViewModel::class.java)


        recyclerView.layoutManager = LinearLayoutManager(this)
       // recyclerView.adapter = StudentsRecylerAdapter(this, DataManager.students)

        studentAdapter = StudentsRecylerAdapter(
            this,
            mutableListOf(),
            {position, check ->
                vm.checkIsPresent(position,check)
            } ,
        { student ->
            vm.removeStudent(student)
        })

        vm.students.observe(this){students ->
            studentAdapter.updateStudenList(students)
        }


        recyclerView.adapter = studentAdapter

        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, CreateAndEditStudentActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()

        recyclerView.adapter?.notifyDataSetChanged()

    }


}