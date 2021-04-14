package com.com.calculator

import androidx.room.Database
import androidx.room.RoomDatabase
import com.com.calculator.dao.HistoryDao
import com.com.calculator.model.History

@Database(entities = [History::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}