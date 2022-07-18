package com.test.offlineapp.ui.navigation

sealed class Screen(val route : String){
    object IssueScreen : Screen("issue_screen")
    object CommentScreen : Screen("comment_screen")
}
