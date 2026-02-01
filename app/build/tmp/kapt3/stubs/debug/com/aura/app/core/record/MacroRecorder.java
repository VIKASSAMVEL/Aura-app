package com.aura.app.core.record;

import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.aura.app.core.action.Action;
import com.aura.app.core.action.Selector;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0017\u001a\u00020\u0013J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0019"}, d2 = {"Lcom/aura/app/core/record/MacroRecorder;", "", "()V", "_isRecording", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_recordedActions", "", "Lcom/aura/app/core/action/Action;", "isRecording", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "recordedActions", "getRecordedActions", "createSelectorFromNode", "Lcom/aura/app/core/action/Selector;", "node", "Landroid/view/accessibility/AccessibilityNodeInfo;", "onAccessibilityEvent", "", "event", "Landroid/view/accessibility/AccessibilityEvent;", "rootNode", "startRecording", "stopRecording", "app_debug"})
public final class MacroRecorder {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isRecording = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRecording = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.aura.app.core.action.Action>> _recordedActions = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.aura.app.core.action.Action>> recordedActions = null;
    
    @javax.inject.Inject()
    public MacroRecorder() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRecording() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.aura.app.core.action.Action>> getRecordedActions() {
        return null;
    }
    
    public final void startRecording() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.aura.app.core.action.Action> stopRecording() {
        return null;
    }
    
    public final void onAccessibilityEvent(@org.jetbrains.annotations.NotNull()
    android.view.accessibility.AccessibilityEvent event, @org.jetbrains.annotations.Nullable()
    android.view.accessibility.AccessibilityNodeInfo rootNode) {
    }
    
    private final com.aura.app.core.action.Selector createSelectorFromNode(android.view.accessibility.AccessibilityNodeInfo node) {
        return null;
    }
}