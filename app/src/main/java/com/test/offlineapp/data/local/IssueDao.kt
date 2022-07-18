package com.test.offlineapp.data.local

import androidx.room.*
import com.test.offlineapp.data.entities.issue.Issue
import kotlinx.coroutines.flow.Flow

@Dao
interface IssueDao {

    @Query("SELECT * FROM ISSUE")
    fun getListOfIssueFormDatabase(): Flow<MutableList<Issue>>

    @Insert
    fun insert(issue: Issue)

    @Update
    fun update(issue: Issue)

    @Delete
    fun delete(issue: Issue)
}
