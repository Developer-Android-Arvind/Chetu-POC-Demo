package com.easy_ride.presentation.feature.login

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.easy_ride.util.BackgroundImage
import com.easy_ride.util.CustomButton
import com.easy_ride.util.CustomOutlineInputBox
import com.easy_ride.util.TopHeaderImage

@Composable
fun LoginScreen(
    onLoginClicked: () -> Unit,
    onRegisterClicked: () -> Unit,
    loginViewModel: LoginViewModel
) {
    val uiState by loginViewModel.loginUIState.collectAsState()

    LoginScreenContent(
        uiState = uiState,
        onLoginClicked = onLoginClicked,
        onRegisterClicked = onRegisterClicked,
        loginViewModel = loginViewModel
    )
}

@Composable
fun LoginScreenContent(
    uiState: LoginUIState,
    loginViewModel: LoginViewModel,
    onLoginClicked: () -> Unit,
    onRegisterClicked: () -> Unit
) {

    Box(
        modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center
    ) {
        BackgroundImage()
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .weight(.5f)
                    .fillMaxSize()
            ) {
                TopHeaderImage()
            }
            Column(
                modifier = Modifier
                    .weight(.5f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(horizontal = 25.dp)
                ) {

                    CustomOutlineInputBox(
                        modifier = Modifier,
                        inputValue = uiState.data.userName,
                        onValueChange = {
                            loginViewModel.updateUserName(it)
                        },
                        isError = uiState.isUserNameEmpty,
                        placeholder = {
                            Text("Enter username or email ")
                        },
                        label = {
                            Text("Enter username or email ")
                        },
                        maxLines = 2,
                        leadingIcon = {

                        },
                        trailingIcon = {},
                    )
                    CustomOutlineInputBox(
                        inputValue = uiState.data.password,
                        onValueChange = {
                            loginViewModel.updatePassword(it)
                        },
                        isError = uiState.isUserPasswordEmpty,
                        placeholder = {
                            Text("Enter your password ")
                        },
                        label = {
                            Text("Enter your password")
                        },
                        maxLines = 2,
                        leadingIcon = {

                        },
                        trailingIcon = {},
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 25.dp), horizontalArrangement = Arrangement.Center
                    ) {
                        CustomButton(modifier = Modifier, "Login") {
                            if (loginViewModel.onLoginClick()) {
                                Log.d("TAG", "LoginClick:" + loginViewModel.onLoginClick())
                            }
                        }
                        Spacer(Modifier.width(8.dp))
                        CustomButton(modifier = Modifier, "Register") {
                            onRegisterClicked()
                        }
                    }
                }
            }

        }


    }
}


@Preview
@Composable
fun LoginScreenContentPreview() {

    Box(
        modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center
    ) {
        BackgroundImage()

        Column(modifier = Modifier.fillMaxSize())
        {
            Column(
                modifier = Modifier
                    .weight(.5f)
                    .fillMaxSize()
            )
            {
                TopHeaderImage()
            }

            Column(
                modifier = Modifier
                    .weight(.5f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {

                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(horizontal = 25.dp)
                )
                {

                    CustomOutlineInputBox(
                        inputValue = "",
                        onValueChange = {

                        },
                        isError = true,
                        placeholder = {

                        },
                        label = {
                            "Enter your username"
                        },
                        maxLines = 2,
                        leadingIcon = {

                        },
                        trailingIcon = {},
                    )


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 25.dp), horizontalArrangement = Arrangement.Center
                    ) {
                        CustomButton(modifier = Modifier, "Login") {

                        }
                        Spacer(Modifier.width(8.dp))
                        CustomButton(modifier = Modifier, "Register") {

                        }
                    }
                }
            }

        }


    }
}