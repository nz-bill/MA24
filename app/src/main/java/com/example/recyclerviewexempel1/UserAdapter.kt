package com.example.recyclerviewexempel1

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val users: MutableList<String>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    // en ViewHolder håller referenser till vyerna i varje 'rad'
   class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
       val nameTextView: TextView = itemView.findViewById(R.id.tv_name)

   }

    // Skapar en ny 'rad' i vår recyclerview (ViewHolder)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return UserViewHolder(view)
    }

    // Returnerar antal objekt i listan
    override fun getItemCount(): Int {
        return users.size
    }

    // Binder data till varje ViewHolder. Varje element position i listan har samma position i recyclerview

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
       holder.nameTextView.text = users[position]

        holder.itemView.setOnLongClickListener {
            users.removeAt(position)

            notifyItemRemoved(position)
            notifyItemRangeChanged(position,users.size)

            true
        }
    }


}