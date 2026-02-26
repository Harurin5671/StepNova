package com.crowns.stepnova.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.crowns.stepnova.R
import com.crowns.stepnova.core.ui.theme.sandowGrayWhite
import com.crowns.stepnova.feature.onboarding.ui.theme.OnboardingTheme

@Composable
fun PrimaryActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = OnboardingTheme.colors.nextButton,
    contentColor: Color = sandowGrayWhite,
    iconRes: Int? = R.drawable.ic_arrow_right,
    iconTint: Color? = sandowGrayWhite,
) {
    ElevatedButton(
        onClick = onClick,
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        shape = RoundedCornerShape(19.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(top = 8.dp)
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.titleMedium
        )
        if (iconRes != null) {
            Spacer(modifier = Modifier.width(12.dp))
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                colorFilter = iconTint?.let { ColorFilter.tint(it) }
            )
        }
    }
}