package com.mamen.bmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mamen.bmicalculator.ui.theme.BMICalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMICalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BMIScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun BMIScreen() {
    // Column: Pone un texto debajo del otro, para que no se pisen
    Column() {
    var nom: String by remember { mutableStateOf("") }
    var pes: Int by remember { mutableStateOf(80) }
    var alsada: Int by remember { mutableStateOf(180) }
    var imc: Float by remember { mutableStateOf(0f) }

    // Es como el Text View de los títulos
    Text(text = "Calculadora IMC")
    // Es como la caja de Edit Text para escribir
    TextField(
        value = nom ,
        onValueChange = {
            nom = it // Guarda el valor de la caja de texto
        },
        label = {Text(text = "Nom") }
    )
        // Pone un texto al lado del otro, para que no se pisen
        Row()  {
            Text(text = "Pes: $pes Kg")

            // Botones para aumentar y disminuir el peso
            Button(
                onClick = { pes-- }
            ) { Text(text = "-")
            }
            Button(
                onClick = { pes++ }
            ) { Text(text = "+")
            }
        }
        Text(text = "Alçada: $alsada cm")
        Slider(
            value = alsada.toFloat(),
            onValueChange = { alsada = it.toInt() },
            valueRange = 100f..250f, // Es el rango mín y máx de altura
        )
        Button(onClick = {
            val alsadaMetres = alsada / 100f
            imc = (pes / (alsadaMetres  * alsadaMetres )).toFloat()
        }) {
            Text(text = "Calcular IMC")
        }
        if(imc != 0f) {
            Text(text = "IMC: $imc")
        }
}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BMICalculatorTheme {
        BMIScreen()
    }
}