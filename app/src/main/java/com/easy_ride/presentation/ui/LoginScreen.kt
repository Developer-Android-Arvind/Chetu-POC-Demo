package com.easy_ride.presentation.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.easy_ride.R

@Composable
fun LoginScreen() {

    Box(
        modifier = Modifier
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {

        var count = remember { mutableIntStateOf(5) }
        var userName = ""
        var password = ""

        LaunchedEffect(key1 = count.intValue) {
            Log.d("TAG", "sideEffectTest: ${count.intValue}")
        }

        Image(
            painter = painterResource(id = R.drawable.background), // Replace with your image resource
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Or ContentScale.FillBounds, ContentScale.Fit, etc.
        )
        Column(modifier = Modifier.fillMaxSize())
        {
            Column(
                modifier = Modifier
                    .weight(.5f)
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.splash_ecr), // Replace with your image resource
                    contentDescription = "Background Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.FillBounds // Or ContentScale.FillBounds, ContentScale.Fit, etc.
                )
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
                    OutlinedTextField(
                        value = userName,
                        onValueChange = { userName = it },
                        label = { Text("Enter your name") })
                    OutlinedTextField(
                        value = password,
                        onValueChange = { },
                        label = { Text("Enter your password") },
                        visualTransformation = PasswordVisualTransformation()
                    )
                    Row(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(top = 25.dp)
                    ) {
                        Button(
                            onClick = { }, modifier = Modifier
                                .height(50.dp)
                                .width(140.dp)
                        ) {
                            Text("Login")
                        }
                        Spacer(Modifier.width(8.dp))
                        Button(
                            onClick = { }, modifier = Modifier
                                .height(50.dp)
                                .width(140.dp)
                        ) {
                            Text("Register")
                        }
                    }
                }
            }

        }


    }
}

@SuppressLint("UnusedBoxWithConstraintsScope")
@Preview
@Composable
private fun LoginScreenPreview() {

    Box(
        modifier = Modifier
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {

        var count = remember { mutableIntStateOf(5) }
        var userName = ""
        var password = ""

        LaunchedEffect(key1 = count.intValue) {
            Log.d("TAG", "sideEffectTest: ${count.intValue}")
        }

        Image(
            painter = painterResource(id = R.drawable.background), // Replace with your image resource
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Or ContentScale.FillBounds, ContentScale.Fit, etc.
        )
        Column(modifier = Modifier.fillMaxSize())
        {
            Column(
                modifier = Modifier
                    .weight(.5f)
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.splash_ecr), // Replace with your image resource
                    contentDescription = "Background Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.FillBounds // Or ContentScale.FillBounds, ContentScale.Fit, etc.
                )
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
                    OutlinedTextField(
                        value = userName,
                        onValueChange = { userName = it },
                        label = { Text("Enter your name") })
                    OutlinedTextField(
                        value = password,
                        onValueChange = { },
                        label = { Text("Enter your password") },
                        visualTransformation = PasswordVisualTransformation()
                    )
                    Row(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(top = 25.dp)
                    ) {
                        Button(
                            onClick = { }, modifier = Modifier
                                .height(50.dp)
                                .width(140.dp)
                        ) {
                            Text("Login")
                        }
                        Spacer(Modifier.width(8.dp))
                        Button(
                            onClick = { }, modifier = Modifier
                                .height(50.dp)
                                .width(140.dp)
                        ) {
                            Text("Register")
                        }
                    }
                }
            }

        }


    }
}