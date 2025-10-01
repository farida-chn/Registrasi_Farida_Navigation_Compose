package com.example.registrasi_farida.screen

import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Halaman Login",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)
        )

        Button(
            onClick = {
                val route = "detail/${Uri.encode("123456")}/${Uri.encode("Guest")}/${Uri.encode(email)}"
                navController.navigate(route)
            },
            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)
        ) {
            Text("LOGIN")
        }

        Button(
            onClick = { navController.navigate("daftar") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 0.dp)
        ) {
            Text("DAFTAR")
        }
    }
}
