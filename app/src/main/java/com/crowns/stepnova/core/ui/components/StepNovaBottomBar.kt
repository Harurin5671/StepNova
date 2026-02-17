package com.crowns.stepnova.core.ui.components

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.crowns.stepnova.navigation.bottomNavItems

@Composable
fun StepNovaBottomBar(backStack: NavBackStack<NavKey>) {
    val current = backStack.lastOrNull()
    NavigationBar {
        bottomNavItems.forEach { item ->
            NavigationBarItem(
                selected = current == item.destination,
                onClick = {
                    if (current != item.destination) {
                        backStack.add(item.destination)
                    }
                },
                label = { Text(item.label) },
                icon = {}
            )
        }
    }
}