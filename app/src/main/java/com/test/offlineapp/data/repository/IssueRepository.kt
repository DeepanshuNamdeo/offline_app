package com.test.offlineapp.data.repository

import androidx.lifecycle.LiveData
import com.test.offlineapp.data.entities.issue.Issue
import com.test.offlineapp.data.entities.issue.IssueResponse
import com.test.offlineapp.utils.Resource
import retrofit2.Response

interface IssueRepository {
    suspend fun getListOfIssue() : List<Issue>
}