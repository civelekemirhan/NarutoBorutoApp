package com.example.narutoborutoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.narutoborutoapp.Constants.DETAILS_SCREEN
import com.example.narutoborutoapp.Constants.HOME_SCREEN
import com.example.narutoborutoapp.Constants.Hero_ID_ARGUMENT_KEY
import com.example.narutoborutoapp.Constants.SEARCH_SCREEN
import com.example.narutoborutoapp.Constants.SPLASH_SCREEN
import com.example.narutoborutoapp.Constants.WELCOME_SCREEN
import com.example.narutoborutoapp.presentation.screens.home.HomeScreen
import com.example.narutoborutoapp.presentation.screens.splash.SplashScreen
import com.example.narutoborutoapp.presentation.screens.welcome.WelcomeScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = SPLASH_SCREEN) {
        composable(route = SPLASH_SCREEN) {
            SplashScreen(navController = navController)
        }
        composable(route = WELCOME_SCREEN) {
            WelcomeScreen(navController = navController)
        }
        composable(route = HOME_SCREEN) {
            HomeScreen()
        }
        composable(route = SEARCH_SCREEN) {

        }
    //      composable(
    //            route = DETAILS_SCREEN,
    //            arguments = listOf(navArgument(Hero_ID_ARGUMENT_KEY) {
    //                type = NavType.IntType
    //            })
    //        ) {
    //
    //        }


    }
}