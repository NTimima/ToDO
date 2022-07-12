package com.example.project_with_ozar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.project_with_ozar.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: TodoAdapter

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = TodoAdapter()
        binding.addButton.setOnClickListener{
            val intent = Intent(this,AddTodo::class.java)
            startActivity(intent)
        }
        lifecycleScope.launch(Dispatchers.IO){
            val db = DB.getInstance(this)
            val dao = db.getMyDao()
            adapter.submitList(dao.getTodos())
        }



    }
}