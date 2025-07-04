package com.easy_ride

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel()
{
    private val _state= MutableStateFlow<MainActivityUIState>(MainActivityUIState.Loading)
            val state:StateFlow<MainActivityUIState> = _state.asStateFlow()

    fun showLoader(){
        viewModelScope.launch {
            delay(5000)
            _state.value=MainActivityUIState.Success("Timer Completed")

        }
    }
}

sealed interface MainActivityUIState
{
    data object Loading: MainActivityUIState
    data class Success(val data:String):MainActivityUIState

    fun shouldKeepSplashScree()= this is Loading


}