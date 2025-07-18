package com.easy_ride.util

import android.text.InputType
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.unit.dp
import com.easy_ride.R

@Composable
fun BackgroundImage() {
    Image(
        painter = painterResource(id = R.drawable.background), // Replace with your image resource
        contentDescription = "Background Image",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun TopHeaderImage() {
    Image(
        painter = painterResource(id = R.drawable.splash_ecr), // Replace with your image resource
        contentDescription = "Background Image",
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentScale = ContentScale.FillBounds // Or ContentScale.FillBounds, ContentScale.Fit, etc.
    )
}

@Composable
fun CustomOutlineInputBox(
    modifier: Modifier = Modifier,
    type: Int = InputType.TYPE_TEXT_VARIATION_PASSWORD,
    inputValue: String,
    isError: Boolean,
    label: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
    placeholder: @Composable (() -> Unit)? = null,
    maxLines: Int = Int.MAX_VALUE,
) {

    OutlinedTextField(
        value = inputValue,
        onValueChange = onValueChange,
        label = label,
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon ,
        isError = isError,
        placeholder = placeholder ,
        maxLines = maxLines

    )
}

@Composable
fun CustomButton(modifier: Modifier = Modifier, label: String, onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        modifier = modifier
            .height(50.dp)
            .width(140.dp)
    ) {
        Text(label)
    }
}