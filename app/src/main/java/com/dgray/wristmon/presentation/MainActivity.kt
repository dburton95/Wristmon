/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter to find the
 * most up to date changes to the libraries and their usages.
 */

package com.dgray.wristmon.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.wear.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val initialPet = loadPetFromConfig(this)

        setContent {
            MaterialTheme {
                WristmonApp(initialPet)
            }
        }
    }
}

data class Pet(
    val name: Pet,
    var hunger: Int,
    var happiness: Int
)

@Composable
fun WristmonApp(initialPet: Pet) {
    var pet by remember { val mutableStateOf = mutableStateOf(
        Pet(
            initialPet,
            hunger = TODO(),
            happiness = TODO()
        )
    )
        mutableStateOf
    }

    Column {
        Text("Meet your pet: ${pet.name}")
        Text("Experience Points: ${pet.hunger}")
        Text("Happiness: ${pet.happiness}")

        Button(onClick = {
            pet = pet.copy(
                hunger = (pet.hunger - 10).coerceAtLeast(0),
                happiness = (pet.happiness + 5).coerceAtMost(100)
            )
        }) {
            Text("Feed ${pet.name}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWristmonApp() {
    MaterialTheme {
        WristmonApp(
            initialPet = TODO()
        )
    }
}