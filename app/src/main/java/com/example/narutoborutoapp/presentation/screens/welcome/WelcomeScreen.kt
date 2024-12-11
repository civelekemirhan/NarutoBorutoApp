package com.example.narutoborutoapp.presentation.screens.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.narutoborutoapp.Constants.HOME_SCREEN
import com.example.narutoborutoapp.navigation.Screen
import com.example.narutoborutoapp.ui.theme.EXTRA_LARGE_PADDING
import com.example.narutoborutoapp.ui.theme.SMALL_PADDING
import com.example.narutoborutoapp.ui.theme.activeIndicatorColor
import com.example.narutoborutoapp.ui.theme.inactiveIndicatorColor
import com.example.narutoborutoapp.ui.theme.welcomeScreenBackgroundColor

@Composable
fun WelcomeScreen(navController: NavController, welcomeViewModel: WelcomeViewModel = hiltViewModel()) {
    val pages = listOf(
        OnBoardingPage.FirstPage,
        OnBoardingPage.SecondPage,
        OnBoardingPage.ThirdPage
    )
    val pagerState = rememberPagerState() {
        pages.size
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.welcomeScreenBackgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {


        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }

        Row(
            Modifier
                .weight(2f)
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .padding(top = EXTRA_LARGE_PADDING),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) MaterialTheme.colorScheme.activeIndicatorColor else MaterialTheme.colorScheme.inactiveIndicatorColor
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(16.dp)
                )
            }
        }

        Row(modifier = Modifier
            .weight(2f)
            .padding(top = SMALL_PADDING)) {
            WelcomeFinishButton(pagerState = pagerState) {
                navController.popBackStack()
                navController.navigate(HOME_SCREEN)
                welcomeViewModel.saveOnBoardingState(true)
            }
        }


    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(navController = rememberNavController())
}