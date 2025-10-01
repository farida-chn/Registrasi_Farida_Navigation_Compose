package com.example.registrasi_farida

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.registrasi_farida.screen.LoginScreen
import com.example.registrasi_farida.screen.DaftarScreen
import com.example.registrasi_farida.screen.DetailScreen
import com.example.registrasi_farida.ui.theme.Registrasi_FaridaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Registrasi_FaridaTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable("login") { LoginScreen(navController) }
                        composable("daftar") { DaftarScreen(navController) }
                        composable("detail/{nim}/{nama}/{email}") { backStackEntry ->
                            val nim = backStackEntry.arguments?.getString("nim") ?: ""
                            val nama = backStackEntry.arguments?.getString("nama") ?: ""
                            val email = backStackEntry.arguments?.getString("email") ?: ""
                            DetailScreen(navController, nim, nama, email)
                        }
                    }
                }
            }
        }
    }
}
