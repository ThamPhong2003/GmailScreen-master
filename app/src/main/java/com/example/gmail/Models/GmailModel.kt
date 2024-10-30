package com.example.gmail.Models

import android.graphics.Color
import kotlin.random.Random

data class GmailModel(
    var name: String,
    var content: String,
    var time: String,
    var avatarResId: Int
) {
    var selected: Boolean = false

    // Tạo màu ngẫu nhiên
    var color: Int = generateRandomColor()

    fun toggleSelected() {
        selected = !selected
    }

    // Hàm sinh màu ngẫu nhiên
    private fun generateRandomColor(): Int {
        val random = Random.Default
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256))
    }
}
