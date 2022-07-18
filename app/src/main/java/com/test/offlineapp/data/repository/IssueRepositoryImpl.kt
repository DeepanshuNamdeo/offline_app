package com.test.offlineapp.data.repository

import androidx.lifecycle.LiveData
import com.test.offlineapp.data.entities.issue.Issue
import com.test.offlineapp.data.entities.issue.IssueResponse
import com.test.offlineapp.data.local.IssueDao
import com.test.offlineapp.data.remote.IssueRemoteData
import com.test.offlineapp.utils.Resource
import retrofit2.Response
import javax.inject.Inject

class IssueRepositoryImpl
@Inject constructor(
    private val issueDao: IssueDao,
    private val remoteData: IssueRemoteData
    ) : IssueRepository {
    override suspend fun getListOfIssue(): List<Issue> {
        return remoteData.getListOfIssue()
    }
}