package com.example.narutoborutoapp.di

import android.content.Context
import com.example.narutoborutoapp.data.local.pref.DataStoreOperationsImpl
import com.example.narutoborutoapp.data.local.pref.Repository
import com.example.narutoborutoapp.domain.repository.DataStoreOperations
import com.example.narutoborutoapp.domain.uses_cases.UseCases
import com.example.narutoborutoapp.domain.uses_cases.read_onboarding.ReadOnBoardingUseCase
import com.example.narutoborutoapp.domain.uses_cases.save_onboarding.SaveOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(@ApplicationContext context: Context): DataStoreOperations {
        return DataStoreOperationsImpl(context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository)
        )
    }

}