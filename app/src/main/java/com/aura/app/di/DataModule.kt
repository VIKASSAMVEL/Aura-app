package com.aura.app.di

import android.content.Context
import androidx.room.Room
import com.aura.app.core.data.local.dao.MacroDao
import com.aura.app.core.data.local.database.AuraDatabase
import com.aura.app.core.data.local.entity.MacroTypeConverters
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.aura.app.core.action.Action
import com.aura.app.core.action.Action.* // Import subtypes if needed for polymorphic deserialization

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
             // Future: register type adapters for Action sealed class
            .create()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AuraDatabase {
        return Room.databaseBuilder(
            context,
            AuraDatabase::class.java,
            "aura_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMacroDao(database: AuraDatabase): MacroDao {
        return database.macroDao()
    }
}
