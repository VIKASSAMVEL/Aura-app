package com.aura.app.core.data.repository;

import com.aura.app.core.action.Action;
import com.aura.app.core.data.local.dao.MacroDao;
import com.aura.app.core.data.local.entity.MacroEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0015J$\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\tH\u0086@\u00a2\u0006\u0002\u0010\u0019R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/aura/app/core/data/repository/MacroRepository;", "", "macroDao", "Lcom/aura/app/core/data/local/dao/MacroDao;", "gson", "Lcom/google/gson/Gson;", "(Lcom/aura/app/core/data/local/dao/MacroDao;Lcom/google/gson/Gson;)V", "allMacros", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/aura/app/core/data/local/entity/MacroEntity;", "getAllMacros", "()Lkotlinx/coroutines/flow/Flow;", "deleteMacro", "", "macro", "(Lcom/aura/app/core/data/local/entity/MacroEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActionsForMacro", "Lcom/aura/app/core/action/Action;", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveMacro", "name", "actions", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MacroRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.aura.app.core.data.local.dao.MacroDao macroDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.aura.app.core.data.local.entity.MacroEntity>> allMacros = null;
    
    @javax.inject.Inject()
    public MacroRepository(@org.jetbrains.annotations.NotNull()
    com.aura.app.core.data.local.dao.MacroDao macroDao, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.aura.app.core.data.local.entity.MacroEntity>> getAllMacros() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getActionsForMacro(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<? extends com.aura.app.core.action.Action>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveMacro(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.aura.app.core.action.Action> actions, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteMacro(@org.jetbrains.annotations.NotNull()
    com.aura.app.core.data.local.entity.MacroEntity macro, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}