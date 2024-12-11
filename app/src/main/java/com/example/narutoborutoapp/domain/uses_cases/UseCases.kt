package com.example.narutoborutoapp.domain.uses_cases

import com.example.narutoborutoapp.domain.uses_cases.read_onboarding.ReadOnBoardingUseCase
import com.example.narutoborutoapp.domain.uses_cases.save_onboarding.SaveOnBoardingUseCase

data class UseCases(
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val saveOnBoardingUseCase: SaveOnBoardingUseCase
)