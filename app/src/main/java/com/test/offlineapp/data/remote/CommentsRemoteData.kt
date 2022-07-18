package com.test.offlineapp.data.remote

import com.test.offlineapp.data.entities.coments.Comments
import com.test.offlineapp.utils.Resource
import retrofit2.Response
import retrofit2.http.Path

interface CommentsRemoteData {
    suspend fun getListOfComments(number: Int) : Response<Comments>
}