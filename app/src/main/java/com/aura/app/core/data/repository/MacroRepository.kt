package com.aura.app.core.data.repository

import com.aura.app.core.action.Action
import com.aura.app.core.data.local.dao.MacroDao
import com.aura.app.core.data.local.entity.MacroEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MacroRepository @Inject constructor(
    private val macroDao: MacroDao,
    private val gson: Gson
) {
    val allMacros: Flow<List<MacroEntity>> = macroDao.getAllMacros()

    suspend fun getActionsForMacro(id: String): List<Action> {
        val entity = macroDao.getMacroById(id) ?: return emptyList()
        val type = object : TypeToken<List<Action>>() {}.type
        return try {
            gson.fromJson(entity.stepsJson, type) ?: emptyList()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    suspend fun saveMacro(name: String, actions: List<Action>) {
        val json = gson.toJson(actions)
        val entity = MacroEntity(
            id = java.util.UUID.randomUUID().toString(),
            name = name,
            stepsJson = json,
            createdAt = System.currentTimeMillis()
        )
        macroDao.insertMacro(entity)
    }

    
    suspend fun deleteMacro(macro: MacroEntity) {
        macroDao.deleteMacro(macro)
    }
}
