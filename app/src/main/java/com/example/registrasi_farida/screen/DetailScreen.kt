package com.example.registrasi_farida.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController, nim: String, nama: String, email: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text("Detail Mahasiswa", style = MaterialTheme.typography.headlineSmall)

        Spacer(Modifier.height(20.dp))
        Text("NIM: $nim", style = MaterialTheme.typography.titleMedium)
        Text("Nama: $nama", style = MaterialTheme.typography.titleMedium)
        Text("Email: $email", style = MaterialTheme.typography.titleMedium)

        Spacer(Modifier.height(30.dp))

        Button(
            onClick = { navController.navigate("daftar") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("DAFTAR")
        }
    }
}
