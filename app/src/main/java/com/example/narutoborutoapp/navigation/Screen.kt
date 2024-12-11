package com.example.narutoborutoapp.navigation

import com.example.narutoborutoapp.Constants.DETAILS_SCREEN
import com.example.narutoborutoapp.Constants.HOME_SCREEN
import com.example.narutoborutoapp.Constants.Hero_ID_ARGUMENT_KEY
import com.example.narutoborutoapp.Constants.SEARCH_SCREEN
import com.example.narutoborutoapp.Constants.SPLASH_SCREEN
import com.example.narutoborutoapp.Constants.WELCOME_SCREEN

sealed class Screen(val route:String) {
    object Splash : Screen(SPLASH_SCREEN)
    object Welcome : Screen(WELCOME_SCREEN)
    object Home : Screen(HOME_SCREEN)
    object Search : Screen(SEARCH_SCREEN)
    object Details : Screen("${DETAILS_SCREEN}/{$Hero_ID_ARGUMENT_KEY}"){
        fun passHeroId(heroId:Int):String{
            return "${DETAILS_SCREEN}/$heroId"
        }
    }
}