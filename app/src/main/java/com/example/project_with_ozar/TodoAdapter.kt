package com.example.project_with_ozar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter: RecyclerView.Adapter<TodoAdapter.MyViewHolder>() {
    var listData : List<ToDo> = emptyList()

    fun submitList(newList: List<ToDo>){
        listData = newList
    }
    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.name)
        val descrip = view.findViewById<TextView>(R.id.description)
        val checkBox = view.findViewById<CheckBox>(R.id.checkbox)
        val priority = view.findViewById<ImageView>(R.id.priority_color)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_screen,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = listData[position].title
        holder.descrip.text = listData[position].description
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}