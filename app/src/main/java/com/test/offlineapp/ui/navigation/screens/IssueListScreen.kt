package com.test.offlineapp.ui.navigation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.test.offlineapp.data.entities.coments.Reactions
import com.test.offlineapp.data.entities.coments.User
import com.test.offlineapp.data.entities.issue.Issue
import com.test.offlineapp.ui.navigation.Screen
import com.test.offlineapp.ui.viewmodels.IssueViewModel

@Composable
fun IssueListScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    issueViewModel: IssueViewModel = hiltViewModel()
) {

    val issueState by issueViewModel.issueState.collectAsState()

    when (issueState) {
        State.START -> {
        }
        State.LOADING -> {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator()
            }
        }
        is State.FAILURE -> {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Text(text = "Something went wrong...", fontSize = 16.sp)
            }
        }
        is State.SUCCESS -> {
            val issues = (issueState as State.SUCCESS).issue
            LazyColumn() {
                items(issues) { item: Issue ->
                    IssueListItem(
                        modifier = modifier,
                        issue = item,
                        OnClickIssue = {
                            navController.navigate(Screen.CommentScreen.route + "/${item.number}")
                        })
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun IssueListItem(
    issue: Issue,
    modifier: Modifier = Modifier,
    OnClickIssue: (Issue) -> Unit
) {

    Card(
        onClick = { OnClickIssue(issue) },
        modifier = modifier.padding(5.dp),
        elevation = 5.dp
    ) {
        Column(modifier.padding(16.dp)) {
            Text(
                text = issue.title.toString(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold, modifier = modifier.fillMaxWidth()
            )
            Spacer(modifier = modifier.padding(5.dp))
            Text(
                text = issue.body ?: "N.A",
                maxLines = 5
            )
            Spacer(modifier = modifier.padding(10.dp))
            Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = rememberAsyncImagePainter(issue.user?.avatarUrl),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = modifier.padding(4.dp))
                Box(
                    modifier = modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = issue.user?.login ?: "N.A",
                        modifier = modifier
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}



sealed class State {
    object START : State()
    object LOADING : State()
    data class SUCCESS(val issue: List<Issue>) : State()
    data class FAILURE(val message: String) : State()
}








