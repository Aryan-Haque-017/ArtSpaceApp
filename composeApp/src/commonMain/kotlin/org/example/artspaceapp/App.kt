package org.example.artspaceapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import artspaceapp.composeapp.generated.resources.Res
import artspaceapp.composeapp.generated.resources.author_1
import artspaceapp.composeapp.generated.resources.author_2
import artspaceapp.composeapp.generated.resources.author_3
import artspaceapp.composeapp.generated.resources.author_4
import artspaceapp.composeapp.generated.resources.author_5
import artspaceapp.composeapp.generated.resources.author_6
import artspaceapp.composeapp.generated.resources.button_1
import artspaceapp.composeapp.generated.resources.button_2
import artspaceapp.composeapp.generated.resources.emerald_valley_serenade
import artspaceapp.composeapp.generated.resources.floating_floral_beauty
import artspaceapp.composeapp.generated.resources.golden_lake_reflections
import artspaceapp.composeapp.generated.resources.image_1
import artspaceapp.composeapp.generated.resources.image_2
import artspaceapp.composeapp.generated.resources.image_3
import artspaceapp.composeapp.generated.resources.image_4
import artspaceapp.composeapp.generated.resources.image_5
import artspaceapp.composeapp.generated.resources.image_6
import artspaceapp.composeapp.generated.resources.painted_meadow_dreams
import artspaceapp.composeapp.generated.resources.sunlit_sanctuary
import artspaceapp.composeapp.generated.resources.year_1
import artspaceapp.composeapp.generated.resources.text_field_instruction
import artspaceapp.composeapp.generated.resources.text_field_label
import artspaceapp.composeapp.generated.resources.whispers_of_the_savannah_grove
import artspaceapp.composeapp.generated.resources.year_2
import artspaceapp.composeapp.generated.resources.year_3
import artspaceapp.composeapp.generated.resources.year_4
import artspaceapp.composeapp.generated.resources.year_5
import artspaceapp.composeapp.generated.resources.year_6
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
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
// For returning the image according to the corresponding slideNumber
fun returnImage(imageNumber: Int?): DrawableResource {
    return when (imageNumber) {
        1 -> Res.drawable.emerald_valley_serenade
        2 -> Res.drawable.floating_floral_beauty
        3 -> Res.drawable.golden_lake_reflections
        4 -> Res.drawable.painted_meadow_dreams
        5 -> Res.drawable.sunlit_sanctuary
        else -> Res.drawable.whispers_of_the_savannah_grove
    }
}
// For returning the image title according to the corresponding slideNumber
fun returnTitle(imageNumber: Int?): StringResource {
    return when (imageNumber) {
        1 -> Res.string.image_1
        2 -> Res.string.image_2
        3 -> Res.string.image_3
        4 -> Res.string.image_4
        5 -> Res.string.image_5
        else -> Res.string.image_6
    }
}
// For returning the author name according to the corresponding slideNumber
fun returnAuthor(imageNumber: Int?): StringResource {
    return when (imageNumber) {
        1 -> Res.string.author_1
        2 -> Res.string.author_2
        3 -> Res.string.author_3
        4 -> Res.string.author_4
        5 -> Res.string.author_5
        else -> Res.string.author_6
    }
}
// For returning the year according to the corresponding slideNumber
fun returnYear(imageNumber: Int?): StringResource {
    return when (imageNumber) {
        1 -> Res.string.year_1
        2 -> Res.string.year_2
        3 -> Res.string.year_3
        4 -> Res.string.year_4
        5 -> Res.string.year_5
        else -> Res.string.year_6
    }
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
            painter = painterResource(resource = returnImage(imageNumber = slideNumber)),
            contentDescription = null,
            modifier = Modifier
                .border(
                    border = BorderStroke(20.dp, color = Color(0xFFE0E0E0)),
                )

        )
        // For the description bar of the image
        Column(
            modifier = Modifier.fillMaxWidth().background(color = Color(0xFFE0E0E0))
        ) {
            // For the image title
            Text(
                text = stringResource(resource = returnTitle(imageNumber = slideNumber)),
                fontWeight = FontWeight.Light,
                fontSize = 28.sp,
                modifier = Modifier.padding(12.dp)
            )
            //Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                // For the artist name
                Text(
                    text = stringResource(resource = returnAuthor(imageNumber = slideNumber)),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 12.dp, bottom = 12.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                // For the name of the year published
                Text(
                    text = "(" + stringResource(resource = returnYear(imageNumber = slideNumber)) + ")"
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