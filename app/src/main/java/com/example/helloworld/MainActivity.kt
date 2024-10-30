package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.AlertDialog
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.helloworld.ui.theme.HelloWorldTheme
import androidx.compose.runtime.*



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorldTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Dear User",
                        modifier = Modifier.padding(innerPadding)
                            .background(Color(0x1C2744FC))
                    )
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(false)}
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.technician),
            contentDescription = "Bash Tech Logo", // html alt alternative
            modifier = Modifier.size(300.dp) //Get Image Size
        )
        Text(
            text = "BashTech",
            fontWeight = FontWeight.Bold, // Make text bold
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp) // Top padding
        )
        Text(
            text = "Hello $name!, Welcome to BashTech!. We are here to help you in what you need",
            modifier = Modifier.padding(horizontal = 20.dp) // horizontal padding
        )
        Button(
            onClick = { showDialog = true },
            modifier = Modifier.padding(horizontal = 20.dp )
                .padding(vertical = 10.dp)
        ) {
            Text( text = "Call us!", fontSize = 20.sp)
        }

    }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false }, // Dismiss the dialog when tapped outside
            title = { Text(text = "Contact Information") },
            text = { Text("For inquiries, please call: 123-456-7890") }, // Fictional phone number
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("OK") // Button to dismiss the dialog
                }
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloWorldTheme {
        Greeting("Android")
    }
}

