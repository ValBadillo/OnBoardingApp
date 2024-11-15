package com.example.onboardingapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.onboardingapp.onBoardViews.MainOnBoarding
import com.example.onboardingapp.views.HomeView
import com.example.onboardingapp.views.SplashScreen
import com.example.onboardingapp.dataStore.StoreBoarding

@Composable
fun NavManager() {
    val context = LocalContext.current
    val dataStore = StoreBoarding(context)
    val store = dataStore.getStoreBoarding.collectAsState(initial = false)

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Splash"
    ) {
        composable(route = "Splash") {
            SplashScreen(navController, store.value)
        }
        composable(route = "onBoarding") {
            MainOnBoarding(navController, dataStore)
        }
        composable(route = "home") {
            HomeView(navController)
        }
    }
}
