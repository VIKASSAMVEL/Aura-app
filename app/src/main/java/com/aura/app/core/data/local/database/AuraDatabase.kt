package com.aura.app.core.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aura.app.core.data.local.dao.MacroDao
import com.aura.app.core.data.local.entity.MacroEntity
import com.aura.app.core.data.local.entity.MacroTypeConverters

@Database(entities = [MacroEntity::class], version = 1, exportSchema = false)
@TypeConverters(MacroTypeConverters::class)
abstract class AuraDatabase : RoomDatabase() {
    abstract fun macroDao(): MacroDao
}
