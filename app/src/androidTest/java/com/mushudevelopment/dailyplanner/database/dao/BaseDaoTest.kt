package com.mushudevelopment.dailyplanner.database.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.mushudevelopment.dailyplanner.database.DailyTaskDatabase
import com.mushudevelopment.dailyplanner.database.model.DailyTask
import java.util.Calendar

open class BaseDaoTest {

    protected lateinit var database: DailyTaskDatabase
    open fun setupDatabase() {

        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(), DailyTaskDatabase::class.java
        ).build()

    }

    open fun closeDatabase() {
        database.close()
    }

    fun generateDailyTask(): DailyTask {
        return DailyTask(
            name = "Take the garbage out",
            description = "Task example",
            date = Calendar.getInstance().time
        )
    }

    fun generateDailyTaskWithId(id: Int): DailyTask {
        return DailyTask(
            id = id,
            name = "Take the garbage out",
            description = "Task example",
            date = Calendar.getInstance().time
        )
    }
}
