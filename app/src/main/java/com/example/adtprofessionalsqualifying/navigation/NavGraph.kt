package com.example.adtprofessionalsqualifying.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.adtprofessionalsqualifying.ui.screen.AfsarScreen
import com.example.adtprofessionalsqualifying.ui.screen.HomeScreen
import com.example.adtprofessionalsqualifying.ui.screen.MediateScreen
import com.example.adtprofessionalsqualifying.ui.screen.MusicScreen
import com.example.adtprofessionalsqualifying.ui.screen.SleepScreen
import com.example.adtprofessionalsqualifying.ui.screen.WelcomeScreen

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navHostController,
        startDestination = NavRoutes.WELCOME_SCREEN.route
    ) {
        composable(NavRoutes.WELCOME_SCREEN.route) {
            WelcomeScreen(
                nextScreen = {
                    navHostController.navigate(NavRoutes.SLEEP_SCREEN.route)
                }
            )
        }
        composable(NavRoutes.SLEEP_SCREEN.route) {
            SleepScreen(
                nextScreen = { route ->
                    navHostController.navigate(route)
                }
            )
        }
        composable(NavRoutes.HOME_SCREEN.route) {
            HomeScreen()
        }
        composable(NavRoutes.MEDIATE_SCREEN.route) {
            MediateScreen()
        }
        composable(NavRoutes.MUSIC_SCREEN.route) {
            MusicScreen()
        }
        composable(NavRoutes.AFSAR_SCREEN.route) {
            AfsarScreen()
        }
    }
}