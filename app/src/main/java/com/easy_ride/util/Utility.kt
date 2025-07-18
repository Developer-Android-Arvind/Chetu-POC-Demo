package com.easy_ride.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CircularProgress() {
    Column(modifier = Modifier.fillMaxSize().background(Color.Blue), Arrangement.Center, Alignment.CenterHorizontally) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(100.dp),// Optional: Add padding, size, etc.
            color = Color.Black, // Optional: Customize color
            strokeWidth = 4.dp // Optional: Customize thickness
        )
    }
}

