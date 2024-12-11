package com.example.narutoborutoapp.di

import android.content.Context
import androidx.room.Room
import com.example.narutoborutoapp.Constants.BORUTO_DATABASE
import com.example.narutoborutoapp.data.local.NarutoBorutoDatabase
import com.example.narutoborutoapp.data.local.dao.HeroDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    )= Room.databaseBuilder(
        context,
        NarutoBorutoDatabase::class.java,
        BORUTO_DATABASE
    ).build()

}