package com.crowns.stepnova.core.di

import android.content.Context
import androidx.room.Room
import com.crowns.stepnova.core.database.StepNovaDatabase
import com.crowns.stepnova.core.database.dao.UserDao
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
    fun provideDatabase(@ApplicationContext context: Context): StepNovaDatabase {
        return Room.databaseBuilder(
            context,
            StepNovaDatabase::class.java,
            "stepnova_database"
        ).build()
    }

    @Provides
    fun provideUserDao(database: StepNovaDatabase): UserDao {
        return database.userDao()
    }
}