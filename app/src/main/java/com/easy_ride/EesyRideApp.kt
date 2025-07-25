package com.easy_ride

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.platform.LocalContext

@Composable
fun EasyRideAppState(
        appState: State<MainActivityUIState>
   ) {
    val context = LocalContext.current

    when (appState.value) {
        MainActivityUIState.Loading -> {
            Log.d("TAG", "EasyRideAppState: Loading")
            //CircularProgress()
        }
        is MainActivityUIState.Success -> {
            Log.d("TAG", "EasyRideAppState: Success")
            //LoginScreen()
        }
    }
}