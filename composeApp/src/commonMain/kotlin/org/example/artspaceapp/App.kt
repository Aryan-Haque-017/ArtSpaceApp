package org.example.artspaceapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import artspaceapp.composeapp.generated.resources.Res
import artspaceapp.composeapp.generated.resources.author_1
import artspaceapp.composeapp.generated.resources.button_1
import artspaceapp.composeapp.generated.resources.button_2
import artspaceapp.composeapp.generated.resources.emerald_valley_serenade
import artspaceapp.composeapp.generated.resources.image_1
import artspaceapp.composeapp.generated.resources.year_1
import artspaceapp.composeapp.generated.resources.text_field_instruction
import artspaceapp.composeapp.generated.resources.text_field_label
import org.jetbrains.compose.resources.stringResource


//The main common composable that will invoked by other composable mainly for platform specific execution.
@Composable
@Preview
fun App() {
    GeneralScreenLayout(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
            .padding(horizontal = 32.dp)
    )
}


//The composable for forming the general universal screen for all different images and so on.
@Composable
fun GeneralScreenLayout(modifier: Modifier = Modifier) {
    // For majority of the use case
    var slideNumber: Int? by remember { mutableStateOf(1) }
    // Only user input
    var userEnteredSlideNumber by remember { mutableStateOf("") }
    // Only for user case, to update the value of slideNumber accordingly
    slideNumber = userEnteredSlideNumber.toIntOrNull()
    userEnteredSlideNumber = slideNumber.toString()

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        // Instruction for what is the use of the TextField Composable
        Text(
            text = stringResource(resource = Res.string.text_field_instruction),
            fontSize = 20.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
        // To find the image quickly by using reference number
        TextField(
            value = userEnteredSlideNumber,
            onValueChange = { userEnteredSlideNumber = it },
            label = { Text(text = stringResource(resource = Res.string.text_field_label)) }
        )
        // For the image
        Image(
            painter = painterResource(resource = Res.drawable.emerald_valley_serenade),
            contentDescription = null
        )
        // For the description bar of the image
        Column(
            modifier = Modifier.fillMaxWidth().background(color = Color(0xFFE0E0E0))
        ) {
            Text(
                text = stringResource(resource = Res.string.image_1),
                fontWeight = FontWeight.Light,
                fontSize = 28.sp,
                modifier = Modifier.padding(12.dp)
            )
            //Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(resource = Res.string.author_1),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 12.dp, bottom = 12.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "(" + stringResource(resource = Res.string.year_1) + ")"
                )
            }

        }
        // For the 2 buttons at the bottom of the screen
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            // The Previous button
            Button(
                onClick = { if ((slideNumber ?: 0) > 1) slideNumber = (slideNumber ?: 0) - 1  },
                modifier = Modifier.size(width = 140.dp, height = 48.dp),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(text = stringResource(resource = Res.string.button_1))
            }
            // The Next button
            Button(
                onClick = { if ((slideNumber ?: 0) < 7) slideNumber = (slideNumber ?: 0) + 1 else slideNumber = 1 },
                modifier = Modifier.size(width = 140.dp, height = 48.dp),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(text = stringResource(resource = Res.string.button_2))
            }
        }
    }
}
//if (slideNumber < 6) slideNumber += 1 else slideNumber = 1