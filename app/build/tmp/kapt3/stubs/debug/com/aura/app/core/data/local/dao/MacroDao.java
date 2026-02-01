package com.aura.app.core.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.aura.app.core.data.local.entity.MacroEntity;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/aura/app/core/data/local/dao/MacroDao;", "", "deleteMacro", "", "macro", "Lcom/aura/app/core/data/local/entity/MacroEntity;", "(Lcom/aura/app/core/data/local/entity/MacroEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllMacros", "Lkotlinx/coroutines/flow/Flow;", "", "getMacroById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertMacro", "app_debug"})
@androidx.room.Dao()
public abstract interface MacroDao {
    
    @androidx.room.Query(value = "SELECT * FROM macros ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.aura.app.core.data.local.entity.MacroEntity>> getAllMacros();
    
    @androidx.room.Query(value = "SELECT * FROM macros WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMacroById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.aura.app.core.data.local.entity.MacroEntity> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertMacro(@org.jetbrains.annotations.NotNull()
    com.aura.app.core.data.local.entity.MacroEntity macro, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteMacro(@org.jetbrains.annotations.NotNull()
    com.aura.app.core.data.local.entity.MacroEntity macro, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}