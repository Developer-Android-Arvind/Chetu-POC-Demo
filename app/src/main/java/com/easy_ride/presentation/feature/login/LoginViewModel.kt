package com.easy_ride.presentation.feature.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.easy_ride.data.model.User
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _loginUIState = MutableStateFlow(LoginUIState())
    val loginUIState: StateFlow<LoginUIState> = _loginUIState.asStateFlow()

    private val _loginUiEvent = MutableSharedFlow<LoginUiEvent>()
    val loginUiEvent: SharedFlow<LoginUiEvent> = _loginUiEvent.asSharedFlow()

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

    fun onLoginClick() {
        viewModelScope.launch {
            _loginUIState.update {
                it.copy(isLoading = true)
            }
            if (_loginUIState.value.data.userName == "arvinds" && _loginUIState.value.data.password == "chetu@123") {
                Log.d("TAG", "OnLoginUserInput: " + _loginUIState.value.data.toString())
                // Todo This is to test with update
                /* _loginUIState.update {
                     it.copy(data = it.data.copy(id = 123))
                 }*/
                // Todo this is to test with Copy
                /*  _loginUIState.value=_loginUIState.value.copy(data = User(id = 12345, userName =_loginUIState.value.data.userName ))
                  Log.d("TAG", "AfterAddingID: "+_loginUIState.value.data.toString())*/
                _loginUiEvent.emit(LoginUiEvent.Success)
                _loginUIState.update {
                    it.copy(isLoading = false)
                }
            } else {
                _loginUiEvent.emit(LoginUiEvent.Failure("Invalid Credentials: Check Your Email or Password"))
                _loginUIState.update {
                    it.copy(isLoading = false)
                }
            }
        }

    }

    fun clearUserInput() {
        // _loginUIState.value.data.userName=""
        // _loginUIState.value.data.password=""
        Log.d("TAG", "clearUserInput: " + _loginUIState.value.data.toString())
    }

    data class LoginUIState(
        val data: User = User(),
        val isUserNameEmpty: Boolean = false,
        val isUserPasswordEmpty: Boolean = false,
        val isLoading: Boolean = false,
    )

    sealed interface LoginUiEvent {
        data object Success : LoginUiEvent
        data class Failure(val message: String?) : LoginUiEvent
    }

}

