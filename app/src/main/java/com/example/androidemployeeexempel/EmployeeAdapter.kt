package com.example.androidemployeeexempel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class EmployeeAdapter(context: Context, employees: List<Employee> ) : ArrayAdapter<Employee>(context, R.layout.list_item_employee, employees){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_employee, parent,false)

        val employee = getItem(position)

        val nameView: TextView = view.findViewById(R.id.tv_name)
        val salaryView: TextView = view.findViewById(R.id.tv_salary)

        nameView.text = employee?.name
        salaryView.text = employee?.salary.toString()

        return view
    }
}


