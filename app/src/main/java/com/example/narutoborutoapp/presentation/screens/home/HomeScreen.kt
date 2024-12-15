package com.example.narutoborutoapp.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            HomeTopBar{

            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) {

        }
    }

}