package com.aura.app.core.action;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0086@\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/aura/app/core/action/MacroExecutor;", "", "actionExecutor", "Lcom/aura/app/core/action/ActionExecutor;", "nodeFinder", "Lcom/aura/app/core/action/NodeFinder;", "service", "Landroid/accessibilityservice/AccessibilityService;", "(Lcom/aura/app/core/action/ActionExecutor;Lcom/aura/app/core/action/NodeFinder;Landroid/accessibilityservice/AccessibilityService;)V", "executeMacro", "", "actions", "", "Lcom/aura/app/core/action/Action;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MacroExecutor {
    @org.jetbrains.annotations.NotNull()
    private final com.aura.app.core.action.ActionExecutor actionExecutor = null;
    @org.jetbrains.annotations.NotNull()
    private final com.aura.app.core.action.NodeFinder nodeFinder = null;
    @org.jetbrains.annotations.NotNull()
    private final android.accessibilityservice.AccessibilityService service = null;
    
    public MacroExecutor(@org.jetbrains.annotations.NotNull()
    com.aura.app.core.action.ActionExecutor actionExecutor, @org.jetbrains.annotations.NotNull()
    com.aura.app.core.action.NodeFinder nodeFinder, @org.jetbrains.annotations.NotNull()
    android.accessibilityservice.AccessibilityService service) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object executeMacro(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.aura.app.core.action.Action> actions, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}