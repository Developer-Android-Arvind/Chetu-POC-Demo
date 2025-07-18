package com.easy_ride.presentation.feature.login

import androidx.lifecycle.ViewModel
import com.easy_ride.data.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private val _loginUIState = MutableStateFlow(LoginUIState())
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
        _loginUIState.update {
            it.copy(error = true)
        }
        if (_loginUIState.value.data.userName.isNotEmpty() && _loginUIState.value.data.password.isNotEmpty()) {
            _loginUIState.value = _loginUIState.value.copy(error = false)
            return true
        } else if (_loginUIState.value.data.userName.isEmpty()) {
            _loginUIState.value = _loginUIState.value.copy(isUserNameEmpty = true)
        } else if (loginUIState.value.data.password.isEmpty()) {
            _loginUIState.value = _loginUIState.value.copy(isUserPasswordEmpty = true)
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

