package org.example.artspaceapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
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
import artspaceapp.composeapp.generated.resources.invalid_number_error
import artspaceapp.composeapp.generated.resources.painted_meadow_dreams
import artspaceapp.composeapp.generated.resources.sunlit_sanctuary
import artspaceapp.composeapp.generated.resources.whispers_of_the_savannah_grove
import artspaceapp.composeapp.generated.resources.year_1
import artspaceapp.composeapp.generated.resources.text_field_instruction
import artspaceapp.composeapp.generated.resources.text_field_label
import artspaceapp.composeapp.generated.resources.year_2
import artspaceapp.composeapp.generated.resources.year_3
import artspaceapp.composeapp.generated.resources.year_4
import artspaceapp.composeapp.generated.resources.year_5
import artspaceapp.composeapp.generated.resources.year_6
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource


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

// Return the image corresponding to the given slide number
fun returnImage(imageNumber: Int): DrawableResource {
    return when (imageNumber) {
        1 -> Res.drawable.emerald_valley_serenade
        2 -> Res.drawable.floating_floral_beauty
        3 -> Res.drawable.golden_lake_reflections
        4 -> Res.drawable.painted_meadow_dreams
        5 -> Res.drawable.sunlit_sanctuary
        6 -> Res.drawable.whispers_of_the_savannah_grove
        else -> Res.drawable.emerald_valley_serenade  // Fallback (should not occur)
    }
}

// Return the image title corresponding to the given slide number
fun returnTitle(imageNumber: Int): StringResource {
    return when (imageNumber) {
        1 -> Res.string.image_1
        2 -> Res.string.image_2
        3 -> Res.string.image_3
        4 -> Res.string.image_4
        5 -> Res.string.image_5
        6 -> Res.string.image_6
        else -> Res.string.image_1
    }
}

// Return the author corresponding to the given slide number
fun returnAuthor(imageNumber: Int): StringResource {
    return when (imageNumber) {
        1 -> Res.string.author_1
        2 -> Res.string.author_2
        3 -> Res.string.author_3
        4 -> Res.string.author_4
        5 -> Res.string.author_5
        6 -> Res.string.author_6
        else -> Res.string.author_1
    }
}

// Return the year corresponding to the given slide number
fun returnYear(imageNumber: Int): StringResource {
    return when (imageNumber) {
        1 -> Res.string.year_1
        2 -> Res.string.year_2
        3 -> Res.string.year_3
        4 -> Res.string.year_4
        5 -> Res.string.year_5
        6 -> Res.string.year_6
        else -> Res.string.year_1
    }
}

// Main composable that forms the general screen layout
@Composable
fun GeneralScreenLayout(modifier: Modifier = Modifier) {
    // Define allowed range constants for 6 photos
    val MIN_SLIDE = 1
    val MAX_SLIDE = 6

    // State for the validated slide number and the raw text input
    var slideNumber by remember { mutableStateOf(MIN_SLIDE) }
    var rawInput by remember { mutableStateOf(slideNumber.toString()) }
    var inputError by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        // Instruction text for the TextField
        Text(
            text = stringResource(resource = Res.string.text_field_instruction),
            fontSize = 20.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        // TextField for user input
        TextField(
            value = rawInput,
            onValueChange = {
                rawInput = it
                val parsed = it.toIntOrNull()
                if (parsed == null || parsed !in MIN_SLIDE..MAX_SLIDE) {
                    inputError = true
                } else {
                    inputError = false
                    slideNumber = parsed
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            label = { Text(text = stringResource(resource = Res.string.text_field_label)) },
            isError = inputError
        )
        // Error message for invalid input
        AnimatedVisibility(visible = inputError) {
            Text(
                text = stringResource(resource = Res.string.invalid_number_error, MIN_SLIDE, MAX_SLIDE),
                color = Color.Red,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
        // Display image based on the current slide number
        Image(
            painter = painterResource(resource = returnImage(slideNumber)),
            contentDescription = null,
            modifier = Modifier
                .size(280.dp)
                .border(
                border = BorderStroke(20.dp, color = Color(0xFFE0E0E0))
            )
        )
        // Description bar for the image
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFE0E0E0))
        ) {
            Text(
                text = stringResource(resource = returnTitle(slideNumber)),
                fontWeight = FontWeight.Light,
                fontSize = 28.sp,
                modifier = Modifier.padding(12.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(resource = returnAuthor(slideNumber)),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 12.dp, bottom = 12.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "(" + stringResource(resource = returnYear(slideNumber)) + ")"
                )
            }
        }
        // Navigation buttons: Previous and Next
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Previous button: decrement if possible, else wrap to MAX_SLIDE (optional behavior)
            Button(
                onClick = {
                    slideNumber = if (slideNumber > MIN_SLIDE) slideNumber - 1 else MAX_SLIDE
                    rawInput = slideNumber.toString()
                    inputError = false
                },
                modifier = Modifier.size(width = 140.dp, height = 48.dp),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(text = stringResource(resource = Res.string.button_1))
            }
            // Next button: increment if possible, else wrap to MIN_SLIDE
            Button(
                onClick = {
                    slideNumber = if (slideNumber < MAX_SLIDE) slideNumber + 1 else MIN_SLIDE
                    rawInput = slideNumber.toString()
                    inputError = false
                },
                modifier = Modifier.size(width = 140.dp, height = 48.dp),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(text = stringResource(resource = Res.string.button_2))
            }
        }
    }
}