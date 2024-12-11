package com.example.narutoborutoapp.presentation.screens.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.narutoborutoapp.Constants.HOME_SCREEN
import com.example.narutoborutoapp.Constants.WELCOME_SCREEN
import com.example.narutoborutoapp.R
import com.example.narutoborutoapp.navigation.Screen
import com.example.narutoborutoapp.ui.theme.Purple500
import com.example.narutoborutoapp.ui.theme.Purple700

@Composable
fun SplashScreen(navController: NavController,splashViewModel: SplashViewModel= hiltViewModel()) {

    val degrees = remember { Animatable(0f) }
    val onBoardingCompleted by splashViewModel.onBoardingCompleted.collectAsState()


    LaunchedEffect(true) {
        degrees.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200
            )
        )
        navController.popBackStack()
        if (onBoardingCompleted) {
            navController.navigate(HOME_SCREEN)
        } else {
            navController.navigate(WELCOME_SCREEN)
        }
    }

        if (isSystemInDarkTheme()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color.Black
                    ),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    modifier = Modifier.rotate(degrees.value),
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = stringResource(
                        R.string.app_logo
                    )
                )

            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Purple700,
                                Purple500
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    modifier = Modifier.rotate(degrees.value),
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = stringResource(
                        R.string.app_logo
                    )
                )

            }
        }


    }



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(rememberNavController())
}

@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SplashScreenDarkPreview() {
    SplashScreen(rememberNavController())
}

