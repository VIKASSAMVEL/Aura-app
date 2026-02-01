package com.aura.app.core.action;

import android.view.accessibility.AccessibilityNodeInfo;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/aura/app/core/action/NodeFinder;", "", "()V", "containsIgnoreCase", "", "charSequence", "", "text", "", "findNode", "Landroid/view/accessibility/AccessibilityNodeInfo;", "root", "selector", "Lcom/aura/app/core/action/Selector;", "matches", "node", "app_debug"})
public final class NodeFinder {
    @org.jetbrains.annotations.NotNull()
    public static final com.aura.app.core.action.NodeFinder INSTANCE = null;
    
    private NodeFinder() {
        super();
    }
    
    /**
     * breadth-first search to find a node matching the selector.
     * We use BFS to find the "shallowest" (most likely visible/relevant) match first, or strictly by index.
     */
    @org.jetbrains.annotations.Nullable()
    public final android.view.accessibility.AccessibilityNodeInfo findNode(@org.jetbrains.annotations.Nullable()
    android.view.accessibility.AccessibilityNodeInfo root, @org.jetbrains.annotations.NotNull()
    com.aura.app.core.action.Selector selector) {
        return null;
    }
    
    private final boolean matches(android.view.accessibility.AccessibilityNodeInfo node, com.aura.app.core.action.Selector selector) {
        return false;
    }
    
    private final boolean containsIgnoreCase(java.lang.CharSequence charSequence, java.lang.String text) {
        return false;
    }
}