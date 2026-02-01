package com.aura.app.core.data.local.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.aura.app.core.data.local.dao.MacroDao;
import com.aura.app.core.data.local.entity.MacroEntity;
import com.aura.app.core.data.local.entity.MacroTypeConverters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/aura/app/core/data/local/database/AuraDatabase;", "Landroidx/room/RoomDatabase;", "()V", "macroDao", "Lcom/aura/app/core/data/local/dao/MacroDao;", "app_debug"})
@androidx.room.Database(entities = {com.aura.app.core.data.local.entity.MacroEntity.class}, version = 1, exportSchema = false)
@androidx.room.TypeConverters(value = {com.aura.app.core.data.local.entity.MacroTypeConverters.class})
public abstract class AuraDatabase extends androidx.room.RoomDatabase {
    
    public AuraDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.aura.app.core.data.local.dao.MacroDao macroDao();
}