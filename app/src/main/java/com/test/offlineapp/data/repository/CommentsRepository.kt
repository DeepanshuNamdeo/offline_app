package com.test.offlineapp.data.repository

import com.test.offlineapp.data.entities.coments.Comments
import com.test.offlineapp.utils.Resource
import retrofit2.Response

interface CommentsRepository {
    suspend fun getListOfComments(number: Int) : Response<Comments>
}