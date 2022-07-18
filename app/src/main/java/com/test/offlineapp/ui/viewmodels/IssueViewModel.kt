package com.test.offlineapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.offlineapp.data.remote.ApiService
import com.test.offlineapp.ui.navigation.screens.State
import com.test.offlineapp.utils.AppDispatchers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class IssueViewModel
@Inject constructor(private val issueRepository: ApiService,
                    private val appDispatchers: AppDispatchers,
                    ) : ViewModel() {

    private val _issueState = MutableStateFlow<State>(State.START)
    val issueState : StateFlow<State>
        get() {
            return _issueState
        }

    init {
        getIssueListFromRepo()
    }

    private fun getIssueListFromRepo()  = viewModelScope.launch {
        _issueState.value = State.LOADING

        try {
            val issueList = withContext(appDispatchers.IO){
                issueRepository.getListOfIssue()
            }
            _issueState.value = State.SUCCESS(issueList)
        }catch (e: Exception){
            _issueState.value = e.localizedMessage?.let { State.FAILURE(it) }!!
        }

    }

}

