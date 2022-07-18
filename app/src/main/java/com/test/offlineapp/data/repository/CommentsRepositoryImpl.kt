package com.test.offlineapp.data.repository

import com.test.offlineapp.data.entities.coments.Comments
import com.test.offlineapp.data.remote.CommentsRemoteData
import com.test.offlineapp.utils.Resource
import retrofit2.Response
import javax.inject.Inject

class CommentsRepositoryImpl
 @Inject constructor( private val remoteData: CommentsRemoteData) : CommentsRepository
{
    override suspend fun getListOfComments(number: Int): Response<Comments> {
        return remoteData.getListOfComments(number)
    }
}