package com.easy_ride

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.navigation.compose.rememberNavController
import com.easy_ride.presentation.ui.LoginScreen
import com.easy_ride.presentation.util.CircularProgress

@Composable
fun EasyRideAppState(
        appState: State<MainActivityUIState>,
   ) {
    val navController = rememberNavController()

    when (appState.value) {
        MainActivityUIState.Loading -> {
            Log.d("TAG", "EasyRideAppState: Loading")
            CircularProgress()
        }
        is MainActivityUIState.Success -> {
            Log.d("TAG", "EasyRideAppState: Success")
            LoginScreen()
        }
    }
}