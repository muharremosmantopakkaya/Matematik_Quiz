package com.example.mathmagic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val score:Int = intent.getIntExtra("score",0)
        val data:ArrayList<Question> = intent.getSerializableExtra("dataSet") as ArrayList<Question>

        val btnHome = findViewById<Button>(R.id.btnHome)
        btnHome.setOnClickListener { finish() }
        val tvScore = findViewById<TextView>(R.id.tvScore)
        tvScore.text = "Senin Skorun\n$score/10"
        setAdapterRecyclerView(data)
    }

    private fun setAdapterRecyclerView(data:ArrayList<Question>)
    {
        val recyclerView:RecyclerView = findViewById(R.id.rvQuestionList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = QuestionAdapter(data)
        recyclerView.adapter = adapter
    }
}

