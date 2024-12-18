package com.example.roommvvmexempel1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView

class ItemAdapter(context: Context, itemList: List<Item>): ArrayAdapter<Item>(context, R.layout.layout_item, itemList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false)

        val item = getItem(position)

        val name = view.findViewById<TextView>(R.id.tv_name)
        val category = view.findViewById<TextView>(R.id.tv_category)
        val checkbox = view.findViewById<CheckBox>(R.id.cb_done)

        name.text = item?.name
        category.text = item?.category
        checkbox.isChecked = item?.done == true

        checkbox.setOnClickListener {
            item?.done = checkbox.isChecked
        }


        return view
    }
}