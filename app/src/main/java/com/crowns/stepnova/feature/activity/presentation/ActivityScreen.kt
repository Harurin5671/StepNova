package com.crowns.stepnova.feature.activity.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.crowns.stepnova.feature.activity.presentation.components.ActivityAppBar
import com.crowns.stepnova.navigation.Nutrition

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivityScreen(backStack: NavBackStack<NavKey>) {
    Scaffold(
        topBar = { ActivityAppBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
                .padding(bottom = 72.dp)
        ) {
            Text(text = "Hello")
            Button(onClick = {
                backStack.add(Nutrition)
            }) {
                Text(text = "Go to Nutrition")
            }
        }
    }
}

@Preview
@Composable
fun ActivityScreenPreview() {
    val backStack = NavBackStack<NavKey>()
    ActivityScreen(backStack = backStack)
}