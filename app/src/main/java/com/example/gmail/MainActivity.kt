package com.example.gmail

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gmail.Adapters.ItemAdapter
import com.example.gmail.Models.GmailModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import kotlin.random.Random

class MainActivity : AppCompatActivity(), ItemClickListener {
    lateinit var gmails: MutableList<GmailModel>

    // Danh sách tên có sẵn
    private val names = listOf("Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Hannah", "Ian", "Judy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun getTime(before: Int): String {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.MINUTE, -before)
            val formatter = SimpleDateFormat("hh:mm a", Locale.getDefault())
            return formatter.format(calendar.time)
        }

        gmails = mutableListOf()
        repeat(14) {
            // Chọn ngẫu nhiên một tên từ danh sách
            val randomName = names[Random.nextInt(names.size)]
            gmails.add(
                GmailModel(randomName, "Content email content email content email ${it + 1}",
                    getTime(it * 10),
                    resources.getIdentifier("avatar${it + 1}", "drawable", packageName))
            )
        }

        val adapter = ItemAdapter(gmails, this)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, LinearLayoutManager.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
    }

    override fun OnItemClicked(position: Int) {
        Log.v("TAG", "${gmails[position]}")
    }
}
