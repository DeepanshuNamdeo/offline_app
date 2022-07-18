package com.test.offlineapp.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CommentScreenViewModelFactory(private val issueNumber: Int?) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = CommentScreenViewModelFactory(issueNumber) as T
}