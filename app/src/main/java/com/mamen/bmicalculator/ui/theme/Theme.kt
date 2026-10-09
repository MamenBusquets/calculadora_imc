package com.mamen.bmicalculator.ui.theme

import android.app.Activity
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
    primary = PinkPrimaryDark,
    secondary = PinkSecondaryDark,
    tertiary = PinkTertiary,
    background = BackgroundDark,
    surface = SurfaceDark,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color(0xFFFCE4EC),
    onSurface = Color(0xFFFCE4EC)
)

private val LightColorScheme = lightColorScheme(
    primary = PinkPrimary,
    onPrimary = OnPrimary,
    primaryContainer = PinkPrimaryContainer,
    onPrimaryContainer = Color(0xFF3E1422),
    secondary = PinkSecondary,
    onSecondary = Color.White,
    secondaryContainer = PinkSecondaryContainer,
    onSecondaryContainer = Color(0xFF2E1528),
    tertiary = PinkTertiary,
    background = BackgroundSoft,
    surface = SurfaceSoft,
    surfaceVariant = SurfaceVariantSoft,
    onBackground = OnBackground,
    onSurface = OnSurface
)

@Composable
fun BMICalculatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is disabled by default to ensure the sweet feminine pastel theme is always gorgeous
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
