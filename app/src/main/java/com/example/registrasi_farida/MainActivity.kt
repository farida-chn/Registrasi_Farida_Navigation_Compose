package com.example.registrasi_farida

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.registrasi_farida.ui.theme.Registrasi_FaridaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Registrasi_FaridaTheme {
                Hal1Screen()
            }
        }
    }
}
