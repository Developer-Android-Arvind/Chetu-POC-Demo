package com.easy_ride

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

import androidx.navigation.NavController
import com.easy_ride.navigation.AppNavHost
import com.easy_ride.ui.theme.EasyRideTheme

class MainActivity : ComponentActivity() {

    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    @SuppressLint("ViewModelConstructorInComposable")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val shouldKeepSplashScree = mainActivityViewModel.state.value.shouldKeepSplashScree()
        Log.d("TAG", "onCreate:$shouldKeepSplashScree")
        mainActivityViewModel.showLoader()
        setContent {

            EasyRideTheme {
                AppNavHost()
                //AppContent()
            }
        }
    }

    @Composable
    fun AppContent() {
        val appState = mainActivityViewModel.state.collectAsState()
        EasyRideAppState(appState)
    }

}


data class ThemeSetting(
    val darkTheme: Boolean, val androidTheme: Boolean, val disableDynamicTheming: Boolean
)

