package com.test.offlineapp.ui.navigation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.test.offlineapp.data.entities.coments.CommentsItem
import com.test.offlineapp.data.entities.coments.User
import com.test.offlineapp.data.entities.issue.Issue
import com.test.offlineapp.ui.navigation.Screen
import com.test.offlineapp.ui.viewmodels.CommentsViewModel
import com.test.offlineapp.utils.CommentScreenViewModelFactory
import javax.inject.Inject

@Composable
fun CommentScreen(
    issueNumber: Int?,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    commentsViewModel: CommentsViewModel = hiltViewModel()
) {
   val commentState by commentsViewModel.commentState.collectAsState()

    issueNumber?.let { commentsViewModel.getListOfComments(it) }

    if (commentState.isEmpty()) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column {
                CircularProgressIndicator()
            }
        }
    } else {
        LazyColumn() {
            items(commentState) { item: CommentsItem ->
                CommentListItem(
                    modifier = modifier,
                    comment = item)
            }
        }
    }
}

@Composable
fun CommentListItem(
    comment: CommentsItem ,
    modifier: Modifier
) {

    Card(
        modifier = modifier.padding(5.dp),
        elevation = 5.dp
    ) {
        Column() {
            Text(text = comment.user.login ,
                modifier = modifier.padding(4.dp),
                fontSize = 18.sp
            )
            Text(text = comment.body ,
                modifier = modifier.padding(4.dp),
                fontSize = 15.sp
            )
        }
    }
}
