package com.example.recyclerviewexempel1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val users: MutableList<String>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

   class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
       val nameTextView: TextView = itemView.findViewById(R.id.tv_name)

   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
       holder.nameTextView.text = users[position]
    }


}