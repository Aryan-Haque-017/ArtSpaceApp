package org.example.artspaceapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.test.runComposeUiTest
import androidx.compose.ui.unit.dp
import kotlin.test.Test

// I think it is bad or inappropriate to use hardcodes string, yeah I'll consider them later

class UIAppKtTest {

    // To test the UI mainly for the button
    @Test
    @ExperimentalTestApi
    fun testGeneralScreenLayoutButtons() = runComposeUiTest {
        setContent {
            GeneralScreenLayout(
                modifier = Modifier
                    .safeDrawingPadding()
                    .fillMaxSize()
                    .padding(horizontal = 32.dp)
                    .verticalScroll(state = rememberScrollState())
            )
        }
        // To justify that the message for the use of the textField exists
        onNodeWithText("Enter the image number below to view its corresponding image.").assertExists()
        // To justify that the textField exists
        onNodeWithText("Image Number").assertExists()

        // Sequential upward starts from here

        // For the first slide number
        onNodeWithText("1").assertExists()
        onNodeWithContentDescription("Emerald Valley Serenade").assertExists()
        onNodeWithText("Emerald Valley Serenade").assertExists()
        onNodeWithText("Ethan Caldwell").assertExists()
        onNodeWithText("(2015)").assertExists()

        // Performing Click operation
        onNodeWithText("Next").performClick()

        // For the second slide number
        onNodeWithText("2").assertExists()
        onNodeWithContentDescription("Floating Floral Beauty").assertExists()
        onNodeWithText("Floating Floral Beauty").assertExists()
        onNodeWithText("Eleanor Rosewood").assertExists()
        onNodeWithText("(2023)").assertExists()

        // Performing Click operation
        onNodeWithText("Next").performClick()

        // For the second slide number
        onNodeWithText("3").assertExists()
        onNodeWithContentDescription("Golden Lake Reflections").assertExists()
        onNodeWithText("Golden Lake Reflections").assertExists()
        onNodeWithText("Olivia Hawthorne").assertExists()
        onNodeWithText("(2019)").assertExists()

        // Performing Click operation
        onNodeWithText("Next").performClick()

        // For the second slide number
        onNodeWithText("4").assertExists()
        onNodeWithContentDescription("Painted Meadow Dreams").assertExists()
        onNodeWithText("Painted Meadow Dreams").assertExists()
        onNodeWithText("Clara Hemlock").assertExists()
        onNodeWithText("(2021)").assertExists()

        // Performing Click operation
        onNodeWithText("Next").performClick()

        // For the second slide number
        onNodeWithText("5").assertExists()
        onNodeWithContentDescription("Sunlit Sanctuary").assertExists()
        onNodeWithText("Sunlit Sanctuary").assertExists()
        onNodeWithText("Sophia Greenwood").assertExists()
        onNodeWithText("(2012)").assertExists()

        // Performing Click operation
        onNodeWithText("Next").performClick()

        // For the second slide number
        onNodeWithText("6").assertExists()
        onNodeWithContentDescription("Whispers of the Savannah Grove").assertExists()
        onNodeWithText("Whispers of the Savannah Grove").assertExists()
        onNodeWithText("James Abernathy").assertExists()
        onNodeWithText("(2018)").assertExists()


        // Sequential downward test starts from here

        // For the sixth slide number
        onNodeWithText("6").assertExists()
        onNodeWithContentDescription("Whispers of the Savannah Grove").assertExists()
        onNodeWithText("Whispers of the Savannah Grove").assertExists()
        onNodeWithText("James Abernathy").assertExists()
        onNodeWithText("(2018)").assertExists()

        // Performing Click operation
        onNodeWithText("Previous").performClick()

        // For the fifth slide number
        onNodeWithText("5").assertExists()
        onNodeWithContentDescription("Sunlit Sanctuary").assertExists()
        onNodeWithText("Sunlit Sanctuary").assertExists()
        onNodeWithText("Sophia Greenwood").assertExists()
        onNodeWithText("(2012)").assertExists()

        // Performing Click operation
        onNodeWithText("Previous").performClick()

        // For the fourth slide number
        onNodeWithText("4").assertExists()
        onNodeWithContentDescription("Painted Meadow Dreams").assertExists()
        onNodeWithText("Painted Meadow Dreams").assertExists()
        onNodeWithText("Clara Hemlock").assertExists()
        onNodeWithText("(2021)").assertExists()

        // Performing Click operation
        onNodeWithText("Previous").performClick()

        // For the third slide number
        onNodeWithText("3").assertExists()
        onNodeWithContentDescription("Golden Lake Reflections").assertExists()
        onNodeWithText("Golden Lake Reflections").assertExists()
        onNodeWithText("Olivia Hawthorne").assertExists()
        onNodeWithText("(2019)").assertExists()

        // Performing Click operation
        onNodeWithText("Previous").performClick()

        // For the second slide number
        onNodeWithText("2").assertExists()
        onNodeWithContentDescription("Floating Floral Beauty").assertExists()
        onNodeWithText("Floating Floral Beauty").assertExists()
        onNodeWithText("Eleanor Rosewood").assertExists()
        onNodeWithText("(2023)").assertExists()

        // Performing Click operation
        onNodeWithText("Previous").performClick()

        // For the first slide number
        onNodeWithText("1").assertExists()
        onNodeWithContentDescription("Emerald Valley Serenade").assertExists()
        onNodeWithText("Emerald Valley Serenade").assertExists()
        onNodeWithText("Ethan Caldwell").assertExists()
        onNodeWithText("(2015)").assertExists()
    }

    // FIX THE TEST CASES
    // I THINK TESTING FOR COMPOSE MULTIPLATFORM IS NOT STABLE YET
    @ExperimentalTestApi
    @Test
    fun generalScreenLayoutTextField() = runComposeUiTest {
        setContent {
            GeneralScreenLayout(
                modifier = Modifier
                    .safeDrawingPadding()
                    .fillMaxSize()
                    .padding(horizontal = 32.dp)
                    .verticalScroll(state = rememberScrollState())
            )
        }
        // For the 1st slide number
        onNodeWithText("1").assertExists()
        onNodeWithContentDescription("Emerald Valley Serenade").assertExists()
        onNodeWithText("Emerald Valley Serenade").assertExists()
        onNodeWithText("Ethan Caldwell").assertExists()
        onNodeWithText("(2015)").assertExists()

        onNodeWithText("Please enter a valid number between 1 and 6").assertDoesNotExist()

        // For the 2nd slide number
        onNodeWithText("1").performTextReplacement("2")
        onNodeWithText("2").assertExists()
        onNodeWithContentDescription("Floating Floral Beauty").assertExists()
        onNodeWithText("Floating Floral Beauty").assertExists()
        onNodeWithText("Eleanor Rosewood").assertExists()
        onNodeWithText("(2023)").assertExists()

        onNodeWithText("Please enter a valid number between 1 and 6").assertDoesNotExist()

        // For the 3rd slide number
        onNodeWithText("2").performTextReplacement("3")
        onNodeWithText("3").assertExists()
        onNodeWithContentDescription("Golden Lake Reflections").assertExists()
        onNodeWithText("Golden Lake Reflections").assertExists()
        onNodeWithText("Olivia Hawthorne").assertExists()
        onNodeWithText("(2019)").assertExists()

        onNodeWithText("Please enter a valid number between 1 and 6").assertDoesNotExist()

        // For the 4th slide number
        onNodeWithText("3").performTextReplacement("4")
        onNodeWithText("4").assertExists()
        onNodeWithContentDescription("Painted Meadow Dreams").assertExists()
        onNodeWithText("Painted Meadow Dreams").assertExists()
        onNodeWithText("Clara Hemlock").assertExists()
        onNodeWithText("(2021)").assertExists()

        onNodeWithText("Please enter a valid number between 1 and 6").assertDoesNotExist()

        // For the 5th slide number
        onNodeWithText("4").performTextReplacement("5")
        onNodeWithText("5").assertExists()
        onNodeWithContentDescription("Sunlit Sanctuary").assertExists()
        onNodeWithText("Sunlit Sanctuary").assertExists()
        onNodeWithText("Sophia Greenwood").assertExists()
        onNodeWithText("(2012)").assertExists()

        onNodeWithText("Please enter a valid number between 1 and 6").assertDoesNotExist()

        // For the 6th slide number
        onNodeWithText("5").performTextReplacement("6")
        onNodeWithText("6").assertExists()
        onNodeWithContentDescription("Whispers of the Savannah Grove").assertExists()
        onNodeWithText("Whispers of the Savannah Grove").assertExists()
        onNodeWithText("James Abernathy").assertExists()
        onNodeWithText("(2018)").assertExists()

        onNodeWithText("6").performTextReplacement("7")

        onNodeWithText("Please enter a valid number between 1 and 6").assertExists()
    }
}