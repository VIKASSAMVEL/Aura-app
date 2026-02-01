package com.aura.app.core.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import android.graphics.Rect;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/aura/app/core/accessibility/NodeInfoParser;", "", "()V", "parse", "Lcom/aura/app/core/accessibility/UiNode;", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "app_debug"})
public final class NodeInfoParser {
    @org.jetbrains.annotations.NotNull()
    public static final com.aura.app.core.accessibility.NodeInfoParser INSTANCE = null;
    
    private NodeInfoParser() {
        super();
    }
    
    /**
     * Converts an AccessibilityNodeInfo tree into a UiNode tree.
     * Note: This can be expensive. Run on background thread.
     */
    @org.jetbrains.annotations.Nullable()
    public final com.aura.app.core.accessibility.UiNode parse(@org.jetbrains.annotations.Nullable()
    android.view.accessibility.AccessibilityNodeInfo info) {
        return null;
    }
}