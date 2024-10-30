package com.example.gmail.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gmail.ItemClickListener
import com.example.gmail.Models.GmailModel
import com.example.gmail.R

class ItemAdapter(val gmails: List<GmailModel>, val listener: ItemClickListener? = null) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return ItemViewHolder(itemView, listener)
    }

    override fun getItemCount(): Int = gmails.size

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val gmail = gmails[position]

        // Đặt chữ cái đầu của tên và màu nền ngẫu nhiên
        holder.textAvatar.text = gmail.name.first().toString()
        holder.textAvatar.setBackgroundColor(gmail.color)

        // Đặt tên người gửi và màu chữ ngẫu nhiên
        holder.textName.text = gmail.name

        holder.textContent.text = gmail.content
        holder.textTime.text = gmail.time
        holder.selected.setImageResource(if (gmail.selected) R.drawable.star1 else R.drawable.star0)

        holder.selected.setOnClickListener {
            gmail.toggleSelected()
            notifyItemChanged(position)
        }
    }

    class ItemViewHolder(itemView: View, val listener: ItemClickListener?) : RecyclerView.ViewHolder(itemView) {
        val textAvatar: TextView = itemView.findViewById(R.id.avatarText)
        val textName: TextView = itemView.findViewById(R.id.textViewName)
        val textContent: TextView = itemView.findViewById(R.id.textViewContent)
        val textTime: TextView = itemView.findViewById(R.id.textViewTime)
        val selected: ImageButton = itemView.findViewById(R.id.imageButton)

        init {
            itemView.setOnClickListener {
                listener?.OnItemClicked(adapterPosition)
            }
        }
    }
}
