package com.example.narutoborutoapp.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val ColorScheme.welcomeScreenBackgroundColor
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black else Color.White

val ColorScheme.titleColor
    @Composable
    get() = if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray

val ColorScheme.descriptionColor
    @Composable
    get() = if (isSystemInDarkTheme()) Color.LightGray.copy(alpha = 0.5f) else Color.DarkGray.copy(
        alpha = 0.5f
    )

val ColorScheme.activeIndicatorColor
    @Composable
    get() = if (isSystemInDarkTheme()) Purple700 else Purple500

val ColorScheme.inactiveIndicatorColor
    @Composable
    get() = if (isSystemInDarkTheme()) Color.DarkGray else Color.LightGray

val ColorScheme.buttonBackgroundColor
    @Composable
    get() = if (isSystemInDarkTheme()) Purple700 else Purple500

val ColorScheme.topAppBarContentColor
    @Composable
    get() = if(isSystemInDarkTheme()) Color.LightGray else Color.White

val ColorScheme.topAppBarBackgroundColor
    @Composable
    get() = if(isSystemInDarkTheme()) Color.Black else Purple500