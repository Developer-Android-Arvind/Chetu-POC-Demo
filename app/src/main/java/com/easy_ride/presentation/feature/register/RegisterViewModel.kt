package com.easy_ride.presentation.feature.register

import androidx.lifecycle.ViewModel
import com.easy_ride.data.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class RegisterViewModel :ViewModel() {

    private val _registerUIState = MutableStateFlow(User())
    var registerUIState: StateFlow<User> = _registerUIState.asStateFlow()

    fun onUserRegister(user: User) {
        _registerUIState.value = user

    }



}