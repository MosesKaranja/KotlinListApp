package com.example.kotlinlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdapter

    private lateinit var rvTodoItems: RecyclerView

    private lateinit var btnAddTodo: Button

    private lateinit var btnDeleteDoneTodos: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())
        btnAddTodo = findViewById<Button>(R.id.btnAddTodo)
        btnDeleteDoneTodos = findViewById<Button>(R.id.btnDeleteDoneTodos)
        rvTodoItems = findViewById<RecyclerView>(R.id.rvTodoItems)

        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val todoTitle = findViewById<EditText>(R.id.etTodoTitle)
            if (todoTitle.text.isNotEmpty()){
                val todo = Todo(todoTitle.text.toString())
                todoAdapter.addTodo(todo)
                todoTitle.text.clear()

            }
        }

        btnDeleteDoneTodos.setOnClickListener {
            todoAdapter.deleteDoneTodos()

        }

    }
}