package com.example.project_with_ozar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.project_with_ozar.databinding.ActivityAddTodoBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddTodo : AppCompatActivity() {

    private var _binding: ActivityAddTodoBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAddTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var title = binding.addTodo.text.toString()
        var description = binding.addDescription.text.toString()
        var priority = binding.addPriority.text.toString()

        binding.doneButton.setOnClickListener{
            lifecycleScope.launch(Dispatchers.IO){
                val db = DB.getInstance(this)
                val dao = db.getMyDao()
                dao.insertTodo(ToDo(0,title,description,priority))
            }
        }
    }
}