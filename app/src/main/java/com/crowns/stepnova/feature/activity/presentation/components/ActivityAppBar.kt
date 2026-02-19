package com.crowns.stepnova.feature.activity.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.crowns.stepnova.R
import com.crowns.stepnova.core.ui.theme.sandowGray10
import com.crowns.stepnova.core.ui.theme.sandowGray100
import com.crowns.stepnova.core.ui.theme.sandowGray40
import com.crowns.stepnova.core.ui.theme.sandowGray80
import com.crowns.stepnova.core.ui.theme.tabataBlue50

@Composable
fun ActivityAppBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = sandowGray100, shape = RoundedCornerShape(
                    bottomEnd = 45.dp,
                    bottomStart = 45.dp
                )
            )
            .padding(horizontal = 24.dp, vertical = 20.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_calendar),
                        contentDescription = "Calendar Icon",
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = "JUN 25, 2026",
                        style = MaterialTheme.typography.bodySmall,
                        color = sandowGray10
                    )
                }
                IconButton(
                    onClick = {},
                    colors = IconButtonDefaults.iconButtonColors(containerColor = sandowGray80),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_notification),
                        contentDescription = "Notification Icon",
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .background(
                                color = Color.White, shape = RoundedCornerShape(
                                    CornerSize(20.dp)
                                )
                            )
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Column {
                        Text(
                            text = "Hello, Marise!",
                            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                            color = sandowGray10
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painterResource(id = R.drawable.ic_score),
                                    contentDescription = null,
                                    modifier = Modifier.size(12.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "88% Healthy",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = sandowGray10
                                )
                            }
                            Spacer(modifier = Modifier.width(4.dp))
                            Spacer(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(sandowGray40)
                                    .size(4.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painterResource(id = R.drawable.ic_star),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(
                                        tabataBlue50
                                    ),
                                    modifier = Modifier.size(14.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Pro",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = sandowGray10
                                )
                            }
                        }
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.ic_chevrom_right),
                    contentDescription = "Chevron Right Icon",
                    colorFilter = ColorFilter.tint(sandowGray10)
                )
            }
        }
    }
}

@Preview
@Composable
fun ActivityAppBarPreview() {
    ActivityAppBar()
}