package com.aura.app.core.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import com.aura.app.core.action.Action;
import com.aura.app.core.action.Selector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.UUID;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/aura/app/core/data/local/entity/MacroTypeConverters;", "", "()V", "gson", "Lcom/google/gson/Gson;", "fromActionList", "", "actions", "", "Lcom/aura/app/core/action/Action;", "toActionList", "data", "app_debug"})
public final class MacroTypeConverters {
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    
    public MacroTypeConverters() {
        super();
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fromActionList(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.aura.app.core.action.Action> actions) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.aura.app.core.action.Action> toActionList(@org.jetbrains.annotations.NotNull()
    java.lang.String data) {
        return null;
    }
}