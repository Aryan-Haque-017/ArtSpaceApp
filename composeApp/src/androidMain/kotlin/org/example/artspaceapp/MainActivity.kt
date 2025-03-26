package org.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppAndroidPreview() {
    App()
}




// Best for having knowledge about Testing in KMP + CMP

//@Composable
//fun App() {
//    Surface(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        TipTimeLayout(
//            modifier = Modifier
//                .statusBarsPadding()
//                .padding(horizontal = 40.dp)
//                .verticalScroll(state = rememberScrollState())
//                .safeDrawingPadding()
//        )
//    }
//}
//@Composable
//fun TipTimeLayout(modifier: Modifier = Modifier) {
//
//    var amountInput by remember { mutableStateOf("") }
//    var tipInput by remember { mutableStateOf("") }
//    var roundUp by remember { mutableStateOf(false) }
//
//    val amount = amountInput.toDoubleOrNull() ?: 0.0
//    val tipPercent = tipInput.toDoubleOrNull() ?:0.0
//
//    val tip = calculateTip(amount, tipPercent, roundUp)
//
//    Column (
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = modifier
//    ) {
//        Text(
//            text = stringResource(resource = Res.string.calculate_tip),
//            modifier = Modifier
//                .padding(bottom = 16.dp, top = 40.dp)
//                .align(alignment = Alignment.Start)
//        )
//        EditNumberField(
//            label = Res.string.bill_amount,
//            leadingIcon = Res.drawable.money,
//            keyboardOptions = KeyboardOptions.Default.copy(
//                keyboardType = KeyboardType.Number,
//                imeAction = ImeAction.Next
//            ),
//            value = amountInput,
//            onValueChange = { amountInput = it },
//            modifier = Modifier
//                .padding(bottom = 32.dp)
//                .fillMaxWidth()
//        )
//        EditNumberField(
//            label = Res.string.how_was_the_service,
//            leadingIcon = Res.drawable.percent,
//            keyboardOptions = KeyboardOptions.Default.copy(
//                keyboardType = KeyboardType.Number,
//                imeAction = ImeAction.Done
//            ),
//            value = tipInput,
//            onValueChange = { tipInput = it },
//            modifier = Modifier
//                .padding(bottom = 32.dp)
//                .fillMaxWidth()
//        )
//        RoundTheTipRow(
//            roundUp = roundUp,
//            onRoundUpChanged = { roundUp = it },
//            modifier = Modifier.padding(bottom = 32.dp)
//        )
//        Text(
//            text = stringResource(resource = Res.string.tip_amount) + tip,
//            fontWeight = FontWeight.Bold,
//            fontSize = 34.sp
//        )
//        Spacer(modifier = Modifier.height(150.dp))
//    }
//}
//
//fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundUp: Boolean): String {
//    var tip = tipPercent / 100 * amount
//    if (roundUp) {
//        tip = kotlin.math.ceil(tip)
//    }
//    return "$${tip}"
//}
//@Composable
//fun EditNumberField(
//    label: StringResource,
//    leadingIcon: DrawableResource,
//    keyboardOptions: KeyboardOptions,
//    value: String,
//    onValueChange:(String) -> Unit,
//    modifier: Modifier = Modifier
//) {
//    TextField(
//        value = value,
//        leadingIcon = { Icon(painter = painterResource(resource = leadingIcon), contentDescription = null) },
//        onValueChange =  onValueChange,
//        label = { Text(stringResource(resource = label))},
//        singleLine = true,
//        keyboardOptions = keyboardOptions,
//        modifier = modifier
//    )
//}
//@Composable
//fun RoundTheTipRow(
//    roundUp: Boolean,
//    onRoundUpChanged: (Boolean) -> Unit,
//    modifier: Modifier = Modifier
//) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier
//            .fillMaxWidth()
//            .size(48.dp)
//    ) {
//        Text(
//            text = stringResource(resource = Res.string.round_up_tip)
//        )
//        Switch(
//            checked = roundUp,
//            onCheckedChange = onRoundUpChanged,
//            modifier = modifier
//                .fillMaxWidth()
//                .wrapContentWidth(align = Alignment.End)
//        )
//    }
//
//}
//// Just doing same random change only for new git.