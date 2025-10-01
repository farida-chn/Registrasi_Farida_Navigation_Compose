package com.example.registrasi_farida.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController, nim: String, nama: String, email: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Detail Mahasiswa",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(top = 40.dp, bottom = 16.dp)
        )

        Spacer(Modifier.height(20.dp))
        Text("NIM: $nim", style = MaterialTheme.typography.titleMedium)
        Text("Nama: $nama", style = MaterialTheme.typography.titleMedium)
        Text("Email: $email", style = MaterialTheme.typography.titleMedium)

        Spacer(Modifier.height(30.dp))

        Button(
            onClick = {
                navController.navigate("login") {
                    popUpTo("login") { inclusive = true }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("KEMBALI KE LOGIN")
        }
    }
}
