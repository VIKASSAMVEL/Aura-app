package com.aura.app.core.ai;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayDeque;
import javax.inject.Inject;
import javax.inject.Singleton;
import dagger.hilt.android.qualifiers.ApplicationContext;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/aura/app/core/ai/ScreenAnalyzer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_analysisResult", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/aura/app/core/ai/ScreenAnalysisResult;", "analysisResult", "Lkotlinx/coroutines/flow/StateFlow;", "getAnalysisResult", "()Lkotlinx/coroutines/flow/StateFlow;", "analyze", "", "rootNode", "Landroid/view/accessibility/AccessibilityNodeInfo;", "screenshot", "Landroid/graphics/Bitmap;", "(Landroid/view/accessibility/AccessibilityNodeInfo;Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "classifyByStructure", "Lcom/aura/app/core/ai/ScreenType;", "root", "app_debug"})
public final class ScreenAnalyzer {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.aura.app.core.ai.ScreenAnalysisResult> _analysisResult = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.aura.app.core.ai.ScreenAnalysisResult> analysisResult = null;
    
    @javax.inject.Inject()
    public ScreenAnalyzer(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.aura.app.core.ai.ScreenAnalysisResult> getAnalysisResult() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object analyze(@org.jetbrains.annotations.Nullable()
    android.view.accessibility.AccessibilityNodeInfo rootNode, @org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap screenshot, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final com.aura.app.core.ai.ScreenType classifyByStructure(android.view.accessibility.AccessibilityNodeInfo root) {
        return null;
    }
}