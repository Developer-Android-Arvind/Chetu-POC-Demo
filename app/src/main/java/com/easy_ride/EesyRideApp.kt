package com.easy_ride

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.platform.LocalContext
import com.easy_ride.presentation.feature.login.LoginScreen
import com.easy_ride.util.CircularProgress
import java.io.InputStream

@Composable
fun EasyRideAppState(
        appState: State<MainActivityUIState>
   ) {
    val context = LocalContext.current
    val inputStream: InputStream = context.resources.openRawResource(R.raw.basichouse)
    Log.d("TAG", "inputStream${inputStream}")
    when (appState.value) {
        MainActivityUIState.Loading -> {
            Log.d("TAG", "EasyRideAppState: Loading")
            CircularProgress()
        }
        is MainActivityUIState.Success -> {
            Log.d("TAG", "EasyRideAppState: Success")
            //LoginScreen()
        }
    }
}