package com.test.offlineapp.data.remote

import androidx.lifecycle.LiveData
import com.test.offlineapp.data.entities.coments.Comments
import com.test.offlineapp.data.entities.issue.Issue
import com.test.offlineapp.data.entities.issue.IssueResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("issues")
    suspend fun getListOfIssue() : List<Issue>

    @GET("issues/{number}/comments")
    suspend fun getListOfComments(@Path("number") number: Int) :Response<Comments>

}