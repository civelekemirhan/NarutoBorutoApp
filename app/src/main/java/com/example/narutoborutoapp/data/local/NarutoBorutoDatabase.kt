package com.example.narutoborutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.narutoborutoapp.data.local.dao.HeroDao
import com.example.narutoborutoapp.data.local.dao.HeroRemoteKeyDao
import com.example.narutoborutoapp.domain.model.Hero
import com.example.narutoborutoapp.domain.model.HeroRemoteKey


@Database(entities = [Hero::class , HeroRemoteKey::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class NarutoBorutoDatabase :RoomDatabase(){

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao

}