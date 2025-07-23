package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MensajeConBoton(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MensajeConBoton(modifier: Modifier = Modifier) {
    var mensaje by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            mensaje = "¡Hola! Esta es mi primera aplicación Android."
        }) {
            Text("Presionar")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = mensaje)
    }
}

@Preview(showBackground = true)
@Composable
fun VistaPrevia() {
    MyApplicationTheme {
        MensajeConBoton()
    }
}
