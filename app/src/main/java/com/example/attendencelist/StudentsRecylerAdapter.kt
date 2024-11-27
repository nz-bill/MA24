package com.example.attendencelist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class StudentsRecylerAdapter(
    val context: Context,
    val students: MutableList<Student>,
    val onCheckPressed: (Int, Boolean) -> Unit,
    val onDeleteClicked: (Student) -> Unit
) :
    RecyclerView.Adapter<StudentsRecylerAdapter.ViewHolder>() {

    val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.list_item, parent, false )

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students[position]

        holder.nameTextView.text = student.name
        holder.classTextView.text = student.className
        holder.presentButton.isChecked = student.present
        holder.studentPosition = position

    }

    override fun getItemCount() = students.size

    fun updateStudenList(newList: List<Student>){
        students.clear()
        students.addAll(newList)
        notifyDataSetChanged()
    }

    fun removeStudent(position: Int) {
//        DataManager.students.removeAt(position)
//        notifyDataSetChanged()
        onDeleteClicked(students[position])

    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)
        val classTextView = itemView.findViewById<TextView>(R.id.classTextView)
        val presentButton = itemView.findViewById<CheckBox>(R.id.checkBox)
        val deleteButton = itemView.findViewById<ImageButton>(R.id.deleteButton)
        var studentPosition = 0


        init {
            itemView.setOnClickListener {
                val intent = Intent(context, CreateAndEditStudentActivity::class.java)
                intent.putExtra(STUDENT_POSITION_KEY, studentPosition)
                context.startActivity(intent)
            }


            presentButton.setOnClickListener {
//                DataManager.students[studentPosition].present = presentButton.isChecked
                onCheckPressed(studentPosition, presentButton.isChecked)
            }

            deleteButton.setOnClickListener{
                removeStudent(studentPosition)
            }

        }



    }
}