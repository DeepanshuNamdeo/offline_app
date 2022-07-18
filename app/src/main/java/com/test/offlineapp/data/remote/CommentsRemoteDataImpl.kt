package com.test.offlineapp.data.remote

import com.test.offlineapp.data.entities.coments.Comments
import com.test.offlineapp.utils.Resource
import retrofit2.Response
import javax.inject.Inject

class CommentsRemoteDataImpl
@Inject constructor(
    private val apiService: ApiService
) : CommentsRemoteData {
    override suspend fun getListOfComments(number: Int): Response<Comments> = apiService.getListOfComments(number)
}