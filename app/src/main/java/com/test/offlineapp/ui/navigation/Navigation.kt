package com.test.offlineapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.test.offlineapp.ui.navigation.screens.CommentScreen
import com.test.offlineapp.ui.navigation.screens.IssueListScreen

@Composable
fun Navigation() {

    val navController  = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.IssueScreen.route
    ){
        composable(route = Screen.IssueScreen.route){
            IssueListScreen(navController)
        }
        composable(route = Screen.CommentScreen.route + "/{issue_number}",
            arguments = listOf(
                navArgument(
                    "issue_number"){
                        type = NavType.IntType
                    }
                )

            ){
            CommentScreen(navController = navController, issueNumber = it.arguments?.getInt("issue_number"))
        }
    }
}

