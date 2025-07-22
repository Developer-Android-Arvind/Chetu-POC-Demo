package com.easy_ride.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
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
    Box(
        modifier = Modifier
            .size(280.dp)
            .clip(shape = CircleShape)

    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_ecr), // Replace with your image resource
            contentDescription = "Background Image",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun TopHeaderMessage(title: String) {
    Text(
        modifier = Modifier
            .wrapContentSize()
            .padding(top = 20.dp),
        text = title,
        fontSize = 30.sp,
        fontStyle = FontStyle.Italic
    )
}

@Composable
fun CustomOutlineInputBox(
    modifier: Modifier = Modifier,
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
        trailingIcon = trailingIcon,
        isError = isError,
        placeholder = placeholder,
        maxLines = maxLines

    )
}

@Composable
fun CustomButton(modifier: Modifier = Modifier, label: String, isEnabled: Boolean = true, onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        modifier = modifier
            .height(50.dp)
            .width(140.dp),
        enabled = isEnabled
    ) {
        Text(label)
    }
}

@Composable
fun CustomTextButton(modifier: Modifier = Modifier, label: String, onClick: () -> Unit) {

    TextButton(onClick=onClick,
        modifier=modifier
            .wrapContentSize()
            .padding(top = 10.dp)) {
        Text(text = label, style = TextStyle(color = androidx.compose.ui.graphics.Color.Black), fontStyle = FontStyle.Italic, fontSize = 20.sp)
    }

}

@Composable
fun CircularProgress() {
    Column(modifier = Modifier.fillMaxSize().background(Color.Transparent), Arrangement.Center, Alignment.CenterHorizontally) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(100.dp),// Optional: Add padding, size, etc.
            color = Color.Black, // Optional: Customize color
            strokeWidth = 4.dp // Optional: Customize thickness
        )
    }
}

@Composable
fun ConstraintLayoutDemo() {
    ConstraintLayout(modifier = Modifier.size(200.dp)) {
        val (redBox, blueBox, yellowBox, text) = createRefs()


        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Blue)
            .constrainAs(blueBox) {
                top.linkTo(redBox.bottom)
                start.linkTo(redBox.end)
            })

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Yellow)
            .constrainAs(yellowBox) {
                bottom.linkTo(blueBox.bottom)
                start.linkTo(blueBox.end, 20.dp)
            })

        Text("Hello World", modifier = Modifier.constrainAs(text) {
            top.linkTo(parent.top)
            start.linkTo(yellowBox.start)
        })

    }
}

@Composable
fun CustomBottomConstrainLayout(modifier: Modifier = Modifier) {

    val (login, register, forgot) = createRefs()



}
