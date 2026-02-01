package com.aura.app.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.aura.app.core.action.Action
import com.aura.app.core.action.Selector
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.UUID

@Entity(tableName = "macros")
data class MacroEntity(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val name: String,
    val description: String? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val stepsJson: String // Serialized List<Action>
)

class MacroTypeConverters {
    private val gson = Gson()

    @TypeConverter
    fun fromActionList(actions: List<Action>): String {
        return gson.toJson(actions)
    }

    @TypeConverter
    fun toActionList(data: String): List<Action> {
        val listType = object : TypeToken<List<Action>>() {}.type
        return gson.fromJson(data, listType)
    }
}
