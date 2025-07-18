package com.easy_ride.presentation.feature.login

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.easy_ride.navigation.AppDestinations


fun NavGraphBuilder.loginComposable(navController: NavHostController) {

    composable<AppDestinations.Login> {
        BackHandler {
            Log.d("TAG", "loginComposable: BackHandler")
            navController.popBackStack()
        }
        val loginViewModel = viewModel<LoginViewModel>()

        LoginScreen(
            loginViewModel = loginViewModel,
            onLoginClicked = {

            },
            onRegisterClicked = {
                navController.navigate(AppDestinations.Register)
            })

    }
}