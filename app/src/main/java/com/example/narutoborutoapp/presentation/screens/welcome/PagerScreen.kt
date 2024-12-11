package com.example.narutoborutoapp.presentation.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.narutoborutoapp.ui.theme.EXTRA_LARGE_PADDING
import com.example.narutoborutoapp.ui.theme.LARGE_PADDING
import com.example.narutoborutoapp.ui.theme.SMALL_PADDING
import com.example.narutoborutoapp.ui.theme.descriptionColor
import com.example.narutoborutoapp.ui.theme.titleColor

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxSize(0.7f),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "Image"
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = LARGE_PADDING),
            text = onBoardingPage.title,
            color = MaterialTheme.colorScheme.titleColor,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top = SMALL_PADDING),
            text = onBoardingPage.description,
            color = MaterialTheme.colorScheme.descriptionColor,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.bodySmall.fontSize,
            textAlign = TextAlign.Center
        )


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PagerScreenPreview() {
    PagerScreen(onBoardingPage = OnBoardingPage.FirstPage)
}
