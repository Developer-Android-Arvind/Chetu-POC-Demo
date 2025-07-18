package com.easy_ride.presentation.feature.register

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UserRegisterScreen() {
    RegisterScreenContent(userRegisterViewModel = viewModel())

}

@Composable
fun RegisterScreenContent(userRegisterViewModel: RegisterViewModel) {
    val uiState by userRegisterViewModel.registerUIState.collectAsState()
}
