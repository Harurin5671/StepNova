package com.crowns.stepnova.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.crowns.stepnova.core.ui.theme.pulseOrange50
import com.crowns.stepnova.navigation.bottomNavItems

private val FabSize = 56.dp
private val CutoutRadius = 32.dp

@Composable
fun StepNovaBottomBar(
    backStack: NavBackStack<NavKey>, modifier: Modifier = Modifier
) {
    val current = backStack.lastOrNull()
    val half = bottomNavItems.size / 2

    Box(
        modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp),
            shape = BottomBarCutoutShape(cutoutRadius = CutoutRadius),
//            color = sandowGray90,
            shadowElevation = 8.dp
        ) {
            Row(
                modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    bottomNavItems.take(half).forEach { item ->
                        BarItem(
                            item = item,
                            isSelected = current == item.destination,
                            onClick = {
                                if (current != item.destination) {
                                    backStack.add(item.destination)
                                }
                            })
                    }
                }

//                Spacer(modifier = Modifier.width(FabSize + 16.dp))

                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    bottomNavItems.drop(half).forEach { item ->
                        BarItem(
                            item = item,
                            isSelected = current == item.destination,
                            onClick = {
                                if (current != item.destination) {
                                    backStack.add(item.destination)
                                }
                            })
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = { /* Action */ },
            modifier = Modifier
//                .size(FabSize)
                .offset(y = (-28).dp),
            shape = RoundedCornerShape(20.dp),
            containerColor = pulseOrange50,
            elevation = FloatingActionButtonDefaults.elevation(
                defaultElevation = 8.dp, pressedElevation = 2.dp
            )
        ) {
            Text(text = "+")
        }
    }
}