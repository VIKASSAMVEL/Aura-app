package com.aura.app.feature.overlay;

import com.aura.app.core.record.MacroRecorder;
import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import com.aura.app.core.data.repository.MacroRepository;
import kotlinx.coroutines.Dispatchers;
import com.aura.app.core.data.local.entity.MacroEntity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u00a2\u0006\u0002\u0010\u0010J\u0006\u0010*\u001a\u00020\u000fJ\u0010\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020-H\u0002J\u0006\u0010.\u001a\u00020\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010\'R\u000e\u0010(\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/aura/app/feature/overlay/OverlayManager;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/savedstate/SavedStateRegistryOwner;", "context", "Landroid/content/Context;", "macroRecorder", "Lcom/aura/app/core/record/MacroRecorder;", "macroRepository", "Lcom/aura/app/core/data/repository/MacroRepository;", "screenAnalyzer", "Lcom/aura/app/core/ai/ScreenAnalyzer;", "onPlayMacro", "Lkotlin/Function1;", "Lcom/aura/app/core/data/local/entity/MacroEntity;", "", "(Landroid/content/Context;Lcom/aura/app/core/record/MacroRecorder;Lcom/aura/app/core/data/repository/MacroRepository;Lcom/aura/app/core/ai/ScreenAnalyzer;Lkotlin/jvm/functions/Function1;)V", "_viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "overlayView", "Landroid/view/View;", "params", "Landroid/view/WindowManager$LayoutParams;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "savedStateRegistryController", "Landroidx/savedstate/SavedStateRegistryController;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "viewModelStore", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "windowManager", "Landroid/view/WindowManager;", "hide", "setFocusable", "focusable", "", "show", "app_debug"})
public final class OverlayManager implements androidx.lifecycle.LifecycleOwner, androidx.lifecycle.ViewModelStoreOwner, androidx.savedstate.SavedStateRegistryOwner {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.aura.app.core.record.MacroRecorder macroRecorder = null;
    @org.jetbrains.annotations.NotNull()
    private final com.aura.app.core.data.repository.MacroRepository macroRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.aura.app.core.ai.ScreenAnalyzer screenAnalyzer = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.aura.app.core.data.local.entity.MacroEntity, kotlin.Unit> onPlayMacro = null;
    @org.jetbrains.annotations.NotNull()
    private final android.view.WindowManager windowManager = null;
    @org.jetbrains.annotations.Nullable()
    private android.view.View overlayView;
    @org.jetbrains.annotations.Nullable()
    private android.view.WindowManager.LayoutParams params;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LifecycleRegistry lifecycleRegistry = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.savedstate.SavedStateRegistryController savedStateRegistryController = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.ViewModelStore _viewModelStore = null;
    
    public OverlayManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.aura.app.core.record.MacroRecorder macroRecorder, @org.jetbrains.annotations.NotNull()
    com.aura.app.core.data.repository.MacroRepository macroRepository, @org.jetbrains.annotations.NotNull()
    com.aura.app.core.ai.ScreenAnalyzer screenAnalyzer, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.aura.app.core.data.local.entity.MacroEntity, kotlin.Unit> onPlayMacro) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public androidx.lifecycle.Lifecycle getLifecycle() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public androidx.savedstate.SavedStateRegistry getSavedStateRegistry() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public androidx.lifecycle.ViewModelStore getViewModelStore() {
        return null;
    }
    
    public final void show() {
    }
    
    public final void hide() {
    }
    
    private final void setFocusable(boolean focusable) {
    }
}