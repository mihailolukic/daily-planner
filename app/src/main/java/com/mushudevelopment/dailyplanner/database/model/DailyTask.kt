package com.mushudevelopment.dailyplanner.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class DailyTask(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var name: String,
    val description: String,
    val date: Date
)