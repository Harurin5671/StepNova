package com.crowns.stepnova.core.ui.components

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

class BottomBarCutoutShape(
    private val cutoutRadius: Dp, private val cornerRadius: Dp = 28.dp
) : Shape {
    override fun createOutline(
        size: Size, layoutDirection: LayoutDirection, density: Density
    ): Outline {
        val radiusSize = with(density) { cutoutRadius.toPx() }
        val corner = with(density) { cornerRadius.toPx() }
        val innerCorner =
            with(density) { 20.dp.toPx() }
        val centerX = size.width / 2f
        val depth = radiusSize * 0.95f
        val spread = radiusSize * 1.5f

        val path = Path().apply {
            moveTo(0f, corner)
            arcTo(Rect(0f, 0f, corner * 2, corner * 2), 180f, 90f, false)

            // Notch Central
            val notchStart = centerX - spread
            lineTo(notchStart, 0f)

            cubicTo(
                centerX - radiusSize, 0f,
                centerX - radiusSize, depth * 0.15f,
                centerX - radiusSize, depth - innerCorner
            )

            arcTo(
                Rect(
                    centerX - radiusSize,
                    depth - innerCorner * 2,
                    centerX - radiusSize + innerCorner * 2,
                    depth
                ),
                180f, -90f, false
            )

            lineTo(centerX + radiusSize - innerCorner, depth)

            arcTo(
                Rect(
                    centerX + radiusSize - innerCorner * 2,
                    depth - innerCorner * 2,
                    centerX + radiusSize,
                    depth
                ),
                90f, -90f, false
            )

            cubicTo(
                centerX + radiusSize, depth * 0.15f,
                centerX + radiusSize, 0f,
                centerX + spread, 0f
            )

            lineTo(size.width - corner, 0f)
            arcTo(Rect(size.width - corner * 2, 0f, size.width, corner * 2), 270f, 90f, false)

            lineTo(size.width, size.height)
            lineTo(0f, size.height)

            close()
        }

        return Outline.Generic(path)
    }
}