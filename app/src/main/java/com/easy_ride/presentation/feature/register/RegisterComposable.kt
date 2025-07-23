package com.easy_ride.presentation.feature.register

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.easy_ride.navigation.AppDestinations

fun NavGraphBuilder.registerComposable(navController: NavHostController) {

    composable<AppDestinations.Register> {
        val context = LocalContext.current as ComponentActivity
        BackHandler {
            Log.d("TAG", "RegisterComposable: BackHandler")
            context.finish()
        }
    }
}