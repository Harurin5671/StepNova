package com.crowns.stepnova.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.crowns.stepnova.core.ui.theme.pulseOrange50
import com.crowns.stepnova.core.ui.theme.sandowGray20
import com.crowns.stepnova.core.ui.theme.sandowGray30
import com.crowns.stepnova.core.ui.theme.sandowGray80
import com.crowns.stepnova.navigation.BottomNavItem

@Composable
fun BarItem(
    item: BottomNavItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val isDark = isSystemInDarkTheme()

    val selectedBg = if (isDark) sandowGray80 else sandowGray30

    Box(
        modifier = Modifier
            .size(60.dp)
            .clip(RoundedCornerShape(24.dp))
            .clickable(onClick = onClick)
            .background(if (isSelected) selectedBg else Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        val iconToShow = when {
            isSelected && isDark -> item.iconSelectDarkRes
            isSelected -> item.iconSelectRes
            else -> item.iconRes
        }

        Image(
            painter = painterResource(id = iconToShow),
            contentDescription = item.label,
            modifier = Modifier.size(24.dp),
            colorFilter = if (!isSelected && isDark) {
                ColorFilter.tint(sandowGray20)
            } else null
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .width(16.dp)
                .height(4.dp)
                .clip(CircleShape)
                .background(if (isSelected) pulseOrange50 else Color.Transparent)
        )
    }
}