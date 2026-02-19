package com.crowns.stepnova.core.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    // === COLORES PRINCIPALES ===
    primary = pulseOrange50,              // Botones principales, FAB, switches activos, sliders
    onPrimary = Color.White,              // Texto/iconos sobre botones primarios
    primaryContainer = pulseOrange80,     // Contenedores destacados (chips seleccionados, fondos de secciones importantes)
    onPrimaryContainer = pulseOrange10,   // Texto sobre primaryContainer
    inversePrimary = pulseOrange30,       // Primary en contextos invertidos (snackbars)

    // === COLORES SECUNDARIOS ===
    secondary = sandowGray60,             // Botones secundarios, elementos menos prominentes
    onSecondary = Color.White,            // Texto sobre elementos secundarios
    secondaryContainer = sandowGray70,    // Fondos de elementos secundarios (badges, tags)
    onSecondaryContainer = sandowGray20,  // Texto sobre secondaryContainer

    // === COLORES TERCIARIOS ===
    tertiary = tabataBlue50,              // Acento adicional (estadísticas de agua, enlaces, highlights especiales)
    onTertiary = Color.White,             // Texto sobre tertiary
    tertiaryContainer = tabataBlue80,     // Fondos con acento tertiary
    onTertiaryContainer = tabataBlue20,   // Texto sobre tertiaryContainer

    // === FONDOS Y SUPERFICIES ===
    background = sandowGray100,           // Fondo principal de todas las pantallas
    onBackground = sandowGray10,          // Texto principal sobre el fondo
    surface = sandowGray90,               // Cards, bottom bar, dialogs, sheets
    onSurface = sandowGray10,             // Texto sobre cards y superficies
    surfaceVariant = sandowGray80,        // Superficies alternativas (inputs, chips no seleccionados)
    onSurfaceVariant = sandowGray20,      // Texto sobre surfaceVariant (labels, placeholders)

    // === CONTAINERS DE SUPERFICIE (jerarquía de elevación) ===
    surfaceContainer = sandowGray85,           // Contenedores neutros (elevation 1)
    surfaceContainerHigh = sandowGray80,       // Contenedores medios (elevation 2)
    surfaceContainerHighest = sandowGray70,    // Contenedores altos (elevation 3) - modals, menus
    surfaceContainerLow = sandowGray90,        // Contenedores bajos (subtle backgrounds)
    surfaceContainerLowest = sandowGray95,     // Contenedores más bajos (casi invisible)
    surfaceBright = sandowGray80,              // Superficie "brillante" en dark mode
    surfaceDim = sandowGray100,                // Superficie "dim" en dark mode

    // === BORDES Y DIVISORES ===
    outline = sandowGray60,               // Bordes normales (TextFields, Cards, Dividers)
    outlineVariant = sandowGray70,        // Bordes sutiles (menos contraste)

    // === ERRORES ===
    error = enduranceRed50,               // Estados de error, alertas críticas
    onError = Color.White,                // Texto sobre elementos de error
    errorContainer = enduranceRed80,      // Fondos de mensajes de error
    onErrorContainer = enduranceRed20,    // Texto sobre errorContainer

    // === INVERSOS (para snackbars, tooltips con fondo claro en dark mode) ===
    inverseSurface = sandowGray10,        // Superficie invertida
    inverseOnSurface = sandowGray90,      // Texto sobre superficie invertida

    // === COLORES FIXED (para navegación, siempre el mismo color sin importar tema) ===
    primaryFixed = pulseOrange30,              // Primary fijo para navigation bar
    primaryFixedDim = pulseOrange40,           // Versión dim del primary fijo
    onPrimaryFixed = pulseOrange90,            // Texto sobre primaryFixed
    onPrimaryFixedVariant = pulseOrange80,     // Variante de texto sobre primaryFixed

    secondaryFixed = sandowGray30,             // Secondary fijo
    secondaryFixedDim = sandowGray40,          // Secondary dim
    onSecondaryFixed = sandowGray90,           // Texto sobre secondaryFixed
    onSecondaryFixedVariant = sandowGray80,    // Variante

    tertiaryFixed = tabataBlue30,              // Tertiary fijo
    tertiaryFixedDim = tabataBlue40,           // Tertiary dim
    onTertiaryFixed = tabataBlue90,            // Texto sobre tertiaryFixed
    onTertiaryFixedVariant = tabataBlue80,     // Variante

    // === OTROS ===
    surfaceTint = pulseOrange50,          // Tinte que se aplica a superficies elevadas
    scrim = Color.Black.copy(alpha = 0.5f) // Overlay oscuro para modals/dialogs
)

private val LightColorScheme = lightColorScheme(
    // === COLORES PRINCIPALES ===
    primary = pulseOrange50,              // Botones principales, FAB, switches activos, sliders
    onPrimary = Color.White,              // Texto/iconos sobre botones primarios
    primaryContainer = pulseOrange20,     // Contenedores destacados (chips seleccionados, fondos de secciones importantes)
    onPrimaryContainer = pulseOrange80,   // Texto sobre primaryContainer
    inversePrimary = pulseOrange70,       // Primary en contextos invertidos

    // === COLORES SECUNDARIOS ===
    secondary = sandowGray60,             // Botones secundarios, elementos menos prominentes
    onSecondary = Color.White,            // Texto sobre elementos secundarios
    secondaryContainer = sandowGray20,    // Fondos de elementos secundarios (badges, tags)
    onSecondaryContainer = sandowGray80,  // Texto sobre secondaryContainer

    // === COLORES TERCIARIOS ===
    tertiary = tabataBlue50,              // Acento adicional (estadísticas de agua, enlaces, highlights especiales)
    onTertiary = Color.White,             // Texto sobre tertiary
    tertiaryContainer = tabataBlue20,     // Fondos con acento tertiary
    onTertiaryContainer = tabataBlue80,   // Texto sobre tertiaryContainer

    // === FONDOS Y SUPERFICIES ===
    background = sandowGray10,            // Fondo principal de todas las pantallas
    onBackground = sandowGray90,          // Texto principal sobre el fondo
    surface = Color.White,                // Cards, bottom bar, dialogs, sheets (más claro que background)
    onSurface = sandowGray90,             // Texto sobre cards y superficies
    surfaceVariant = sandowGray20,        // Superficies alternativas (inputs, chips no seleccionados)
    onSurfaceVariant = sandowGray70,      // Texto sobre surfaceVariant (labels, placeholders)

    // === CONTAINERS DE SUPERFICIE (jerarquía de elevación) ===
    surfaceContainer = sandowGray15,           // Contenedores neutros (elevation 1)
    surfaceContainerHigh = sandowGray20,       // Contenedores medios (elevation 2)
    surfaceContainerHighest = sandowGray30,    // Contenedores altos (elevation 3) - modals, menus
    surfaceContainerLow = sandowGray10,        // Contenedores bajos (subtle backgrounds)
    surfaceContainerLowest = Color.White,      // Contenedores más bajos (más blanco que white)
    surfaceBright = Color.White,               // Superficie "brillante" en light mode
    surfaceDim = sandowGray20,                 // Superficie "dim" en light mode

    // === BORDES Y DIVISORES ===
    outline = sandowGray50,               // Bordes normales (TextFields, Cards, Dividers)
    outlineVariant = sandowGray30,        // Bordes sutiles (menos contraste)

    // === ERRORES ===
    error = enduranceRed50,               // Estados de error, alertas críticas
    onError = Color.White,                // Texto sobre elementos de error
    errorContainer = enduranceRed20,      // Fondos de mensajes de error
    onErrorContainer = enduranceRed80,    // Texto sobre errorContainer

    // === INVERSOS (para snackbars, tooltips con fondo oscuro en light mode) ===
    inverseSurface = sandowGray90,        // Superficie invertida
    inverseOnSurface = sandowGray10,      // Texto sobre superficie invertida

    // === COLORES FIXED (para navegación, siempre el mismo color sin importar tema) ===
    primaryFixed = pulseOrange30,              // Primary fijo para navigation bar
    primaryFixedDim = pulseOrange40,           // Versión dim del primary fijo
    onPrimaryFixed = pulseOrange90,            // Texto sobre primaryFixed
    onPrimaryFixedVariant = pulseOrange70,     // Variante de texto sobre primaryFixed

    secondaryFixed = sandowGray30,             // Secondary fijo
    secondaryFixedDim = sandowGray40,          // Secondary dim
    onSecondaryFixed = sandowGray90,           // Texto sobre secondaryFixed
    onSecondaryFixedVariant = sandowGray70,    // Variante

    tertiaryFixed = tabataBlue30,              // Tertiary fijo
    tertiaryFixedDim = tabataBlue40,           // Tertiary dim
    onTertiaryFixed = tabataBlue90,            // Texto sobre tertiaryFixed
    onTertiaryFixedVariant = tabataBlue70,     // Variante

    // === OTROS ===
    surfaceTint = pulseOrange50,          // Tinte que se aplica a superficies elevadas
    scrim = Color.Black.copy(alpha = 0.5f) // Overlay oscuro para modals/dialogs
)

// ## Guía rápida de uso:
// ```
// primary/onPrimary → FAB naranja, botón "Guardar", indicadores activos
// secondary/onSecondary → botones "Cancelar", iconos secundarios
// tertiary/onTertiary → estadísticas especiales, agua/hidratación, links
// background/onBackground → fondo de pantallas + texto normal
// surface/onSurface → cards de comida, bottom bar, dialogs
// surfaceVariant → inputs, chips no seleccionados
// outline → bordes de TextFields, divisores
// error → mensajes de error, validaciones
// surfaceContainer → elevation 1 (cards sutiles)
// surfaceContainerHigh → elevation 2 (modales)

@Composable
fun StepNovaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}