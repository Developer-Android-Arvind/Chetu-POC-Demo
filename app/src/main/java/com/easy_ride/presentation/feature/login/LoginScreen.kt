package com.easy_ride.presentation.feature.login

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.easy_ride.presentation.feature.login.LoginViewModel.LoginUIState
import com.easy_ride.util.BackgroundImage
import com.easy_ride.util.CircularProgress
import com.easy_ride.util.CustomButton
import com.easy_ride.util.CustomOutlineInputBox
import com.easy_ride.util.CustomTextButton
import com.easy_ride.util.TopHeaderImage
import com.easy_ride.util.TopHeaderMessage
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LoginScreen(
    onLoginClicked: () -> Unit,
    onRegisterClicked: () -> Unit,
    loginViewModel: LoginViewModel,
    onForgotPasswordClicked: () -> Unit
) {
    val uiState by loginViewModel.loginUIState.collectAsState()
    val context = LocalContext.current

    DisposableEffect(Unit) {
        onDispose {
            loginViewModel.clearUserInput()
        }

    }

    LaunchedEffect(key1 = Unit) {
        loginViewModel.loginUiEvent.collectLatest {
            when (it) {
                is LoginViewModel.LoginUiEvent.Failure -> {
                    Log.d("TAG", "LoginScreen:failure $it")
                    Toast.makeText(context,"${it.message}",Toast.LENGTH_LONG).show()
                }
                is LoginViewModel.LoginUiEvent.Success -> {
                    Log.d("TAG", "LoginScreen:Success$it")
                    onLoginClicked()
                }
            }
        }
    }
    LoginScreenContent(
        uiState = uiState,
        onLoginClicked = {
            loginViewModel.onLoginClick()
        },
        onPasswordChange = {
            loginViewModel.updatePassword(it)
        },
        onEmailChange = {
            loginViewModel.updateUserName(it)
        },
        onRegisterClicked = { onRegisterClicked() },
        onForgotPasswordClicked = { onForgotPasswordClicked() }
    )

}

@Composable
fun LoginScreenContent(
    uiState: LoginUIState,
    onLoginClicked: () -> Unit,
    onPasswordChange: (password: String) -> Unit,
    onRegisterClicked: () -> Unit,
    onEmailChange: (email: String) -> Unit,
    onForgotPasswordClicked: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center
    ) {
        BackgroundImage()
        Column(modifier = Modifier.wrapContentSize()) {
            Column(
                modifier = Modifier
                    .weight(.4f)
                    .fillMaxWidth()
                    .padding(top = 50.dp), horizontalAlignment = CenterHorizontally
            ) {
                TopHeaderImage()
                TopHeaderMessage(title = "Welcome to Easy Ride!!")
            }
            Column(
                modifier = Modifier
                    .weight(.5f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = CenterHorizontally
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
                            onEmailChange(it)
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
                        trailingIcon = {

                        },
                    )
                    CustomOutlineInputBox(
                        inputValue = uiState.data.password,
                        onValueChange = {
                            onPasswordChange(it)
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
                    Spacer(Modifier.height(10.dp))
                    ConstraintLayout {
                        val (row, forgot) = createRefs()
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 25.dp)
                                .constrainAs(row) {
                                    bottom
                                }, horizontalArrangement = Arrangement.Center
                        ) {
                            CustomButton(
                                modifier = Modifier,
                                "Login",
                                isEnabled = !(uiState.isUserNameEmpty || uiState.isUserPasswordEmpty),
                                onClick = {
                                    onLoginClicked()
                                })

                            Spacer(Modifier.width(20.dp))
                            CustomButton(
                                modifier = Modifier,
                                "Register"
                            ) {
                                onRegisterClicked()
                            }
                        }
                        Spacer(Modifier.height(10.dp))
                        Column(
                            horizontalAlignment = Alignment.End,
                            modifier = Modifier
                                .fillMaxWidth()
                                .constrainAs(forgot) {
                                    top.linkTo(row.bottom)
                                }
                        ) {
                            CustomTextButton(label = "Forgot Password ?") {
                                onForgotPasswordClicked()
                            }
                        }
                    }
                }
            }

        }
    }
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.Transparent)
            .clickable {
                !uiState.isLoading
            },
        contentAlignment = Alignment.Center
    ) {
        if (uiState.isLoading) {
            CircularProgress()
        }
    }
}


@Preview
@Composable
fun LoginScreenContentPreview() {

    LoginScreenContent(
        uiState = LoginUIState(),
        onLoginClicked = {},
        onRegisterClicked = {},
        onPasswordChange = {},
        onEmailChange = {},
        onForgotPasswordClicked = {})


}