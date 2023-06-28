package com.mushudevelopment.dailyplanner.database.dao

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.mushudevelopment.dailyplanner.dispatcher.TestDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class DailyTasksDaoTest : BaseDaoTest() {

    private lateinit var dailyTaskDao: DailyTaskDao

    @get: Rule
    val dispatcherRule = TestDispatcherRule()

    @Before
    override fun setupDatabase() {
        super.setupDatabase();
        dailyTaskDao = database.dailyTaskDao
    }

    @After
    override fun closeDatabase() {
        super.closeDatabase()
    }

    @Test
    fun insertDailyTask_returnsTrue() = runTest {
        val task = generateDailyTaskWithId(1)
        dailyTaskDao.insert(task)
        dailyTaskDao.getAll().test {
            val taskList = awaitItem()
            assert(taskList.contains(task))
        }
    }

    @Test
    fun insertDailyTask_idGeneratedTrue() = runTest {
        val task = generateDailyTask()
        dailyTaskDao.insert(task)
        dailyTaskDao.getAll().test {
            val taskList = awaitItem()
            val tempTask = taskList[0]
            Log.d(TAG, "insertDailyTask_idGeneratedTrue: id:" + taskList[0])
            assert(tempTask.id != 0)
        }
    }

    @Test
    fun updateDailyTask_returnTrue() = runTest {
        val task = generateDailyTaskWithId(2)
        dailyTaskDao.insert(task)
        task.name = "Test"

        dailyTaskDao.insert(task)

        assert(dailyTaskDao.getDailyTasksById(2).name == "Test")
    }

    @Test
    fun deleteTask_returnTrue() = runTest {
        val task = generateDailyTask()
        val secondTask = generateDailyTask()
        dailyTaskDao.insert(task)
        dailyTaskDao.insert(secondTask)
        dailyTaskDao.delete(task)
        dailyTaskDao.getAll().test {
            val taskList = awaitItem()
            assertThat(taskList).doesNotContain(task)
        }
    }

    @Test
    fun getAll_returnsTrue() = runTest {
        val task = generateDailyTask()
        val secondTask = generateDailyTask()

        dailyTaskDao.insert(task)
        dailyTaskDao.insert(secondTask)

        dailyTaskDao.getAll().test {
            val taskList = awaitItem()
            assert(taskList.size == 2)
        }
    }

    companion object {
        private const val TAG = "DailyTasksDaoTest"
    }
}