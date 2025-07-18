package com.easy_ride.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.easy_ride.presentation.feature.login.loginComposable
import com.easy_ride.presentation.feature.register.registerComposable

@Composable
internal fun AppNavHost(navHostController: NavHostController = rememberNavController()) {
    NavHost(navController = navHostController, startDestination = AppDestinations.Login)
    {
        loginComposable(navHostController)
        registerComposable(navHostController)

    }
}


