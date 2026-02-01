package com.aura.app.core.accessibility;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.util.Log;
import dagger.hilt.android.AndroidEntryPoint;
import kotlinx.coroutines.Dispatchers;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0014J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/aura/app/core/accessibility/AuraAccessibilityService;", "Landroid/accessibilityservice/AccessibilityService;", "()V", "actionExecutor", "Lcom/aura/app/core/action/ActionExecutor;", "overlayManager", "Lcom/aura/app/feature/overlay/OverlayManager;", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "onAccessibilityEvent", "", "event", "Landroid/view/accessibility/AccessibilityEvent;", "onDestroy", "onInterrupt", "onServiceConnected", "onUnbind", "", "intent", "Landroid/content/Intent;", "app_debug"})
public final class AuraAccessibilityService extends android.accessibilityservice.AccessibilityService {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope serviceScope = null;
    private com.aura.app.core.action.ActionExecutor actionExecutor;
    private com.aura.app.feature.overlay.OverlayManager overlayManager;
    
    public AuraAccessibilityService() {
        super();
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