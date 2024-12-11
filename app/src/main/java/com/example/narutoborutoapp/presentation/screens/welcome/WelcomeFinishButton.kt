package com.example.narutoborutoapp.presentation.screens.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.narutoborutoapp.Constants.LAST_ON_BOARDING_PAGE
import com.example.narutoborutoapp.ui.theme.EXTRA_LARGE_PADDING
import com.example.narutoborutoapp.ui.theme.buttonBackgroundColor

@Composable
fun WelcomeFinishButton(
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = EXTRA_LARGE_PADDING),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {

        AnimatedVisibility(
            visible = pagerState.currentPage == LAST_ON_BOARDING_PAGE,
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onClick() }, shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.buttonBackgroundColor,
                    contentColor = Color.White
                )) {
                Text(text = "Finish")
            }
        }

    }
}