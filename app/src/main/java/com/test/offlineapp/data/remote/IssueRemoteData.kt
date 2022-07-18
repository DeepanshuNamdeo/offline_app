package com.test.offlineapp.data.remote

import androidx.lifecycle.LiveData
import com.test.offlineapp.data.entities.issue.Issue
import com.test.offlineapp.data.entities.issue.IssueResponse
import com.test.offlineapp.utils.Resource
import retrofit2.Response

interface IssueRemoteData {
    suspend fun getListOfIssue() : List<Issue>
}