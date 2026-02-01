package com.aura.app.core.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aura.app.core.data.local.entity.MacroEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MacroDao {
    @Query("SELECT * FROM macros ORDER BY createdAt DESC")
    fun getAllMacros(): Flow<List<MacroEntity>>

    @Query("SELECT * FROM macros WHERE id = :id")
    suspend fun getMacroById(id: String): MacroEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMacro(macro: MacroEntity)

    @Delete
    suspend fun deleteMacro(macro: MacroEntity)
}
