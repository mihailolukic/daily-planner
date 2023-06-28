package com.mushudevelopment.dailyplanner.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.mushudevelopment.dailyplanner.database.model.DailyTask
import kotlinx.coroutines.flow.Flow
import java.sql.Date

@Dao
interface DailyTaskDao {

    @Upsert //update or insert
    suspend fun insert(task: DailyTask)

    @Delete
    suspend fun delete(task: DailyTask)

    @Query("SELECT * FROM dailytask ORDER BY date ASC")
    fun getAll(): Flow<List<DailyTask>>

    @Query("SELECT * FROM dailytask where id = :taskId")
    suspend fun getDailyTasksById(taskId: Int): DailyTask

}