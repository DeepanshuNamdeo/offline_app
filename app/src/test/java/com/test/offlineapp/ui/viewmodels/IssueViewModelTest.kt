package com.test.offlineapp.ui.viewmodels

import com.test.offlineapp.data.entities.issue.Issue
import com.test.offlineapp.data.remote.ApiService
import com.test.offlineapp.ui.navigation.screens.State
import com.test.offlineapp.utils.AppDispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.lang.RuntimeException


internal class IssueViewModelTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private val apiService  = mock<ApiService>()
    lateinit var issueViewMode : IssueViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = AppDispatchers(
        IO = TestCoroutineDispatcher()
    )

    @Test
    fun `Issue loading state`()=
        runBlocking {
        whenever(apiService.getListOfIssue()).thenReturn(emptyList<Issue>())
            issueViewMode = IssueViewModel(apiService,testDispatcher)
            Assert.assertEquals(State.SUCCESS(emptyList<Issue>()), issueViewMode.issueState.value)
    }

    @Test
    fun `Issue error state`()=  runBlocking {
        whenever(apiService.getListOfIssue()).thenThrow(RuntimeException("Error"))
        issueViewMode = IssueViewModel(apiService,testDispatcher)
        Assert.assertEquals(State.FAILURE("Error"), issueViewMode.issueState.value)
    }


}