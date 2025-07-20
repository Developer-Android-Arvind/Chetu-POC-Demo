package com.easy_ride.presentation.feature.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.easy_ride.data.model.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _loginUIState = MutableStateFlow(LoginUIState(loading =false))
    var loginUIState: StateFlow<LoginUIState> = _loginUIState.asStateFlow()

    fun updateUserName(userName: String) {
        _loginUIState.value = _loginUIState.value.copy(
            isUserNameEmpty = userName.isEmpty(),
            data = _loginUIState.value.data.copy(userName = userName)
        )
    }

    fun updatePassword(password: String) {
        _loginUIState.update {
            it.copy(
                isUserPasswordEmpty = password.isEmpty(),
                data = it.data.copy(password = password)
            )
        }
    }

    fun onLoginClick(): Boolean {
        _loginUIState.value=_loginUIState.value.copy(loading = true)
        viewModelScope.launch {
            delay(5000)
            _loginUIState.value=_loginUIState.value.copy(loading = false)
            _loginUIState.value=_loginUIState.value.copy(success = true)
        }
        return false
    }
}

data class LoginUIState(
    val data: User = User(),
    val isValidUser: Boolean = false,
    val isUserNameEmpty: Boolean = false,
    val isUserPasswordEmpty: Boolean = false,
    var error: Boolean = false,
)

