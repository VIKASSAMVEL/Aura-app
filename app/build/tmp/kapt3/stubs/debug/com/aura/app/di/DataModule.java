package com.aura.app.di;

import android.content.Context;
import androidx.room.Room;
import com.aura.app.core.data.local.dao.MacroDao;
import com.aura.app.core.data.local.database.AuraDatabase;
import com.aura.app.core.data.local.entity.MacroTypeConverters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.aura.app.core.action.Action;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/aura/app/di/DataModule;", "", "()V", "provideDatabase", "Lcom/aura/app/core/data/local/database/AuraDatabase;", "context", "Landroid/content/Context;", "provideGson", "Lcom/google/gson/Gson;", "provideMacroDao", "Lcom/aura/app/core/data/local/dao/MacroDao;", "database", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DataModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.aura.app.di.DataModule INSTANCE = null;
    
    private DataModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson provideGson() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.aura.app.core.data.local.database.AuraDatabase provideDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.aura.app.core.data.local.dao.MacroDao provideMacroDao(@org.jetbrains.annotations.NotNull()
    com.aura.app.core.data.local.database.AuraDatabase database) {
        return null;
    }
}