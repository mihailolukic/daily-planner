package com.mushudevelopment.dailyplanner.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mushudevelopment.dailyplanner.database.converters.Converters
import com.mushudevelopment.dailyplanner.database.dao.DailyTaskDao
import com.mushudevelopment.dailyplanner.database.model.DailyTask

@Database(entities = [DailyTask::class], version = 1)
@TypeConverters(Converters::class)
abstract class DailyTaskDatabase : RoomDatabase() {

    abstract val dailyTaskDao: DailyTaskDao
}