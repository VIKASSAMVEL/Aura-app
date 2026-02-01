package com.aura.app.core.accessibility;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.aura.app.core.action.ActionExecutor;
import com.aura.app.core.record.MacroRecorder;
import com.aura.app.feature.overlay.OverlayManager;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlinx.coroutines.Dispatchers;
import com.aura.app.core.data.repository.MacroRepository;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0016J\b\u0010&\u001a\u00020!H\u0014J\u0012\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/aura/app/core/accessibility/AuraAccessibilityService;", "Landroid/accessibilityservice/AccessibilityService;", "()V", "ANALYSIS_INTERVAL_MS", "", "actionExecutor", "Lcom/aura/app/core/action/ActionExecutor;", "lastAnalysisTime", "macroExecutor", "Lcom/aura/app/core/action/MacroExecutor;", "macroRecorder", "Lcom/aura/app/core/record/MacroRecorder;", "getMacroRecorder", "()Lcom/aura/app/core/record/MacroRecorder;", "setMacroRecorder", "(Lcom/aura/app/core/record/MacroRecorder;)V", "macroRepository", "Lcom/aura/app/core/data/repository/MacroRepository;", "getMacroRepository", "()Lcom/aura/app/core/data/repository/MacroRepository;", "setMacroRepository", "(Lcom/aura/app/core/data/repository/MacroRepository;)V", "overlayManager", "Lcom/aura/app/feature/overlay/OverlayManager;", "screenAnalyzer", "Lcom/aura/app/core/ai/ScreenAnalyzer;", "getScreenAnalyzer", "()Lcom/aura/app/core/ai/ScreenAnalyzer;", "setScreenAnalyzer", "(Lcom/aura/app/core/ai/ScreenAnalyzer;)V", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "onAccessibilityEvent", "", "event", "Landroid/view/accessibility/AccessibilityEvent;", "onDestroy", "onInterrupt", "onServiceConnected", "onUnbind", "", "intent", "Landroid/content/Intent;", "app_debug"})
public final class AuraAccessibilityService extends android.accessibilityservice.AccessibilityService {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope serviceScope = null;
    private com.aura.app.core.action.ActionExecutor actionExecutor;
    private com.aura.app.feature.overlay.OverlayManager overlayManager;
    @javax.inject.Inject()
    public com.aura.app.core.record.MacroRecorder macroRecorder;
    @javax.inject.Inject()
    public com.aura.app.core.data.repository.MacroRepository macroRepository;
    @javax.inject.Inject()
    public com.aura.app.core.ai.ScreenAnalyzer screenAnalyzer;
    private com.aura.app.core.action.MacroExecutor macroExecutor;
    private long lastAnalysisTime = 0L;
    private final long ANALYSIS_INTERVAL_MS = 1000L;
    
    public AuraAccessibilityService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.aura.app.core.record.MacroRecorder getMacroRecorder() {
        return null;
    }
    
    public final void setMacroRecorder(@org.jetbrains.annotations.NotNull()
    com.aura.app.core.record.MacroRecorder p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.aura.app.core.data.repository.MacroRepository getMacroRepository() {
        return null;
    }
    
    public final void setMacroRepository(@org.jetbrains.annotations.NotNull()
    com.aura.app.core.data.repository.MacroRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.aura.app.core.ai.ScreenAnalyzer getScreenAnalyzer() {
        return null;
    }
    
    public final void setScreenAnalyzer(@org.jetbrains.annotations.NotNull()
    com.aura.app.core.ai.ScreenAnalyzer p0) {
    }
    
    @java.lang.Override()
    protected void onServiceConnected() {
    }
    
    @java.lang.Override()
    public boolean onUnbind(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
        return false;
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void onAccessibilityEvent(@org.jetbrains.annotations.Nullable()
    android.view.accessibility.AccessibilityEvent event) {
    }
    
    @java.lang.Override()
    public void onInterrupt() {
    }
}