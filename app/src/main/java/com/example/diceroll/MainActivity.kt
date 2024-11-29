package com.example.diceroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroll.ui.theme.DiceRollTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollApp()
        }
    }
}

@Composable
fun DiceRollApp() {
    var diceRoll by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Image for the dice
        Image(
            painter = painterResource(id = getDiceImage(diceRoll)),
            contentDescription = "Dice",
            modifier = Modifier.size(150.dp),
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Roll button
        Button(
            onClick = {
                diceRoll = Random.nextInt(1, 7)
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.size(width = 100.dp, height = 50.dp)
        ) {
            Text(text = "Roll")
        }
    }
}

// Function to get the dice image based on the dice roll
fun getDiceImage(diceRoll: Int): Int {
    return when (diceRoll) {
        1 -> R.drawable.ic_dice_1
        2 -> R.drawable.ic_dice_2
        3 -> R.drawable.ic_dice_3
        4 -> R.drawable.ic_dice_4
        5 -> R.drawable.ic_dice_5
        else -> R.drawable.ic_dice_6
    }
}

// Preview for Jetpack Compose
@Preview(showBackground = true)
@Composable
fun DiceRollPreview() {
    DiceRollTheme {
        DiceRollApp()
    }
}
