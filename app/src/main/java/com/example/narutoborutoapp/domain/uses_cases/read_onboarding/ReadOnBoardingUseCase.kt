package com.example.narutoborutoapp.domain.uses_cases.read_onboarding

import com.example.narutoborutoapp.data.local.pref.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(private val repository: Repository) {
    operator fun invoke() : Flow<Boolean> {
        return repository.readOnBoardingState()
    }
}