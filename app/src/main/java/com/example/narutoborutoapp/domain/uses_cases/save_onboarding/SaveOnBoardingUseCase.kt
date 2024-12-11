package com.example.narutoborutoapp.domain.uses_cases.save_onboarding

import com.example.narutoborutoapp.data.local.pref.Repository

class SaveOnBoardingUseCase(private val repository: Repository) {

    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed)
    }


}