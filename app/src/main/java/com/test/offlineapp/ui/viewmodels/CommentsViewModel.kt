package com.test.offlineapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.test.offlineapp.data.entities.coments.Comments
import com.test.offlineapp.data.entities.coments.CommentsItem
import com.test.offlineapp.data.entities.coments.User
import com.test.offlineapp.data.entities.issue.Issue
import com.test.offlineapp.data.repository.CommentsRepository
import com.test.offlineapp.utils.Resource
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentsViewModel
@Inject
constructor(private val commentsRepository: CommentsRepository) : ViewModel() {

    private val _commentState = MutableStateFlow(emptyList<CommentsItem>())
    val commentState: StateFlow<List<CommentsItem>>
        get() {
            return _commentState
        }


    fun getListOfComments(issueNumber : Int) = viewModelScope.launch {
        commentsRepository.getListOfComments(issueNumber).let {
            if (it.isSuccessful){
                _commentState.value = Resource.success(it.body()).data!!
            }
        }
    }

}



