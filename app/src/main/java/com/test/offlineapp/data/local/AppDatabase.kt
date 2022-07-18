package com.test.offlineapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.test.offlineapp.data.entities.converters.IssueTypeConverter
import com.test.offlineapp.data.entities.issue.Issue


abstract class AppDatabase : RoomDatabase() {
    abstract fun issueDao() : IssueDao
}