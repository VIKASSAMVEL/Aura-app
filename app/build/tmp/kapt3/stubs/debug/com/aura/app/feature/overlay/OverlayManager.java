package com.aura.app.feature.overlay;

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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/aura/app/feature/overlay/OverlayManager;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/savedstate/SavedStateRegistryOwner;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "overlayView", "Landroid/view/View;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "savedStateRegistryController", "Landroidx/savedstate/SavedStateRegistryController;", "viewModelStore", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "windowManager", "Landroid/view/WindowManager;", "hide", "", "show", "app_debug"})
public final class OverlayManager implements androidx.lifecycle.LifecycleOwner, androidx.lifecycle.ViewModelStoreOwner, androidx.savedstate.SavedStateRegistryOwner {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final android.view.WindowManager windowManager = null;
    @org.jetbrains.annotations.Nullable()
    private android.view.View overlayView;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LifecycleRegistry lifecycleRegistry = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.savedstate.SavedStateRegistryController savedStateRegistryController = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.ViewModelStore _viewModelStore = null;
    
    public OverlayManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
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
}