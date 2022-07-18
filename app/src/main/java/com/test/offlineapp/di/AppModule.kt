package com.test.offlineapp.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.test.offlineapp.data.entities.issue.Issue
import com.test.offlineapp.data.local.AppDatabase
import com.test.offlineapp.data.local.IssueDao
import com.test.offlineapp.data.remote.*
import com.test.offlineapp.data.repository.CommentsRepository
import com.test.offlineapp.data.repository.CommentsRepositoryImpl
import com.test.offlineapp.data.repository.IssueRepository
import com.test.offlineapp.data.repository.IssueRepositoryImpl
import com.test.offlineapp.utils.AppDispatchers
import com.test.offlineapp.utils.Constants
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.assisted.Assisted
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideBaseUrl(): String = Constants.BASE_URL

    @Provides
    fun provideGson(): Gson = GsonBuilder().setLenient().create();

    @Provides
    @Singleton
    fun provideRetrofit(baseURL: String , gson: Gson): Retrofit {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(baseURL)
            .build()
    }


    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    fun provideAppDispatcher( ) : AppDispatchers = AppDispatchers()

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(appContext, AppDatabase::class.java, "App_database").build()
    }

    //locale dependencies
    @Provides
    fun provideUserDao(appDatabase: AppDatabase): IssueDao = appDatabase.issueDao()


    @Provides
    fun provideIssueRemoteData(issueRemoteDataImpl: IssueRemoteDataImpl): IssueRemoteData = issueRemoteDataImpl

    @Provides
    fun provideIssueRepository( issueRepository: IssueRepositoryImpl ) : IssueRepository = issueRepository

    @Provides
    fun provideCommentRemoteData(commentsRemoteDataImpl: CommentsRemoteDataImpl): CommentsRemoteData = commentsRemoteDataImpl

    @Provides
    fun provideCommentRepository( commentsRepository: CommentsRepositoryImpl ) : CommentsRepository = commentsRepository

}