package com.example.registrasi_farida.screen

import android.app.DatePickerDialog
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import java.util.*

@Composable
fun DaftarScreen(navController: NavController) {
    var nim by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tglLahir by remember { mutableStateOf("") }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, day ->
            val bulan = (month + 1).toString().padStart(2, '0')
            val hari = day.toString().padStart(2, '0')
            tglLahir = "$hari/$bulan/$year"
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }) { inner ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(inner)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Halaman Registrasi",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = nim, onValueChange = { nim = it },
                label = { Text("NIM") },
                modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)
            )
            OutlinedTextField(
                value = nama, onValueChange = { nama = it },
                label = { Text("Nama") },
                modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)
            )
            OutlinedTextField(
                value = email, onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)
            )
            OutlinedTextField(
                value = tglLahir, onValueChange = {},
                label = { Text("Tanggal Lahir") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                trailingIcon = {
                    IconButton(onClick = { datePickerDialog.show() }) {
                        Icon(Icons.Default.DateRange, contentDescription = "Pilih tanggal")
                    }
                }
            )

            Button(
                onClick = {
                    if (nim.isBlank() || nama.isBlank() || email.isBlank()) {
                        scope.launch { snackbarHostState.showSnackbar("Isi semua field!") }
                        return@Button
                    }
                    val route = "detail/${Uri.encode(nim)}/${Uri.encode(nama)}/${Uri.encode(email)}"
                    navController.navigate(route)
                },
                modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)
            ) {
                Text("DAFTAR")
            }
        }
    }
}
