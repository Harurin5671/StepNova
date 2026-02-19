package com.crowns.stepnova

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.navigation.RootNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StepNovaTheme {
                RootNavigation()
            }
        }
    }
}