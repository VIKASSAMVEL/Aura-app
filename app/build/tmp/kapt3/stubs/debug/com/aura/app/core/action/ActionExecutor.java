package com.aura.app.core.action;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.util.Log;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/aura/app/core/action/ActionExecutor;", "", "service", "Landroid/accessibilityservice/AccessibilityService;", "(Landroid/accessibilityservice/AccessibilityService;)V", "dispatchGestureClick", "", "node", "Landroid/view/accessibility/AccessibilityNodeInfo;", "execute", "action", "Lcom/aura/app/core/action/Action;", "performClick", "root", "selector", "Lcom/aura/app/core/action/Selector;", "performInput", "text", "", "app_debug"})
public final class ActionExecutor {
    @org.jetbrains.annotations.NotNull()
    private final android.accessibilityservice.AccessibilityService service = null;
    
    public ActionExecutor(@org.jetbrains.annotations.NotNull()
    android.accessibilityservice.AccessibilityService service) {
        super();
    }
    
    public final boolean execute(@org.jetbrains.annotations.NotNull()
    com.aura.app.core.action.Action action) {
        return false;
    }
    
    private final boolean performClick(android.view.accessibility.AccessibilityNodeInfo root, com.aura.app.core.action.Selector selector) {
        return false;
    }
    
    private final boolean performInput(android.view.accessibility.AccessibilityNodeInfo root, com.aura.app.core.action.Selector selector, java.lang.String text) {
        return false;
    }
    
    private final boolean dispatchGestureClick(android.view.accessibility.AccessibilityNodeInfo node) {
        return false;
    }
}