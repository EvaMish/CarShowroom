package com.example.port.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = PrimDark,
    secondary = SecondaryDark,
    tertiary = TertiaryDark,
    error = ErrorDark,
    background = BackgroundDark,
    primaryContainer = PrimContainerDark,
    secondaryContainer = SecondContainerDark,
    tertiaryContainer = TertiaryContainerDark,
    errorContainer = ErrorContainerDark,
    surface = SurfaceDark,
    surfaceVariant = SurfaceVariantDark,
    onBackground = OnBackgroundDark,
    onPrimary = OnPrimDark,
    onSecondary = OnSecondaryDark,
    onTertiary = OnTertiaryDark,
    onError = OnErrorDark,
    onPrimaryContainer = OnPrimContainerDark,
    onSecondaryContainer = OnSecondaryContainerDark,
    onTertiaryContainer = OnTertiaryContainerDark,
    onErrorContainer = OnErrorContainerDark,
    onSurface = OnSurfaceDark,
    outline = OutlineDark,
    outlineVariant = OnSurfaceVariantDark



)

private val LightColorScheme = lightColorScheme(
    primary = PrimLight,
    secondary = SecondaryLight,
    tertiary = TertiaryLight,
    error = ErrorLight,
    background = BackgroundLight,
    primaryContainer = PrimContainerLight,
    secondaryContainer = SecondContainerLight,
    tertiaryContainer = TertiaryContainerLight,
    errorContainer = ErrorContainerLight,
    surface = SurfaceLight,
    surfaceVariant = SurfaceVariantLight,
    onPrimary = OnPrimLight,
    onSecondary = OnSecondaryLight,
    onTertiary = OnTertiaryLight,
    onError = OnErrorLight,
    onBackground = OnBackgroundLight,
    onPrimaryContainer = OnPrimContainerLight,
    onSecondaryContainer = OnSecondaryContainerLight,
    onTertiaryContainer = OnTertiaryContainerLight,
    onErrorContainer = OnErrorContainerLight,
    onSurface = OnSurfaceLight,
    outline = OutlineLight,
    outlineVariant = OnSurfaceVariantLight

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun PortTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) DarkColorScheme else LightColorScheme
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}