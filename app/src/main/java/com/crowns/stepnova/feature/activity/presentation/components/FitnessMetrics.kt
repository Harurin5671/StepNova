package com.crowns.stepnova.feature.activity.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.crowns.stepnova.R
import com.crowns.stepnova.core.ui.components.HorizontalSection
import com.crowns.stepnova.core.ui.theme.pulseOrange50
import com.crowns.stepnova.core.ui.theme.sandowGray10
import com.crowns.stepnova.core.ui.theme.sandowGray60
import com.crowns.stepnova.core.ui.theme.sandowGrayWhite
import com.crowns.stepnova.core.ui.theme.spinachGreen50
import com.crowns.stepnova.core.ui.theme.tabataBlue50

data class FitnessStat(
    val title: String,
    val backgroundColor: Color = sandowGrayWhite,
    @param:DrawableRes val iconRes: Int,
)

val stats = listOf(
    FitnessStat(
        title = "Score",
        backgroundColor = pulseOrange50,
        iconRes = R.drawable.ic_score
    ),
    FitnessStat(
        title = "Hydration",
        backgroundColor = tabataBlue50,
        iconRes = R.drawable.ic_hydration
    ),
    FitnessStat(
        title = "Calories",
        backgroundColor = sandowGray60,
        iconRes = R.drawable.ic_hydration
    ),
    FitnessStat(
        title = "Steps",
        backgroundColor = spinachGreen50,
        iconRes = R.drawable.ic_hydration
    )
)

@Composable
fun FitnessMetrics() {
    HorizontalSection(
        title = "Fitness Metrics",
        action = {
            TextButton(onClick = { }) {
                Text(
                    text = "See All",
                    color = pulseOrange50,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    ) {
        items(stats) { stat ->
            FitnessMetricsCard(stat)
        }
    }
}

@Composable
fun FitnessMetricsCard(stat: FitnessStat) {
    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = stat.backgroundColor
        ),
        shape = RoundedCornerShape(45.dp),
        modifier = Modifier
            .width(150.dp)
            .height(180.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = stat.title,
                color = sandowGray10,
                style = MaterialTheme.typography.labelMedium
            )
            Image(
                painter = painterResource(id = stat.iconRes),
                contentDescription = stat.title,
                colorFilter = ColorFilter.tint(sandowGray10)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FitnessMetricsPreview() {
    FitnessMetrics()
}