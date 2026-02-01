package com.aura.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.activity.ComponentActivity;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.Lifecycle;
import dagger.hilt.android.AndroidEntryPoint;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u00a8\u0006\t"}, d2 = {"PermissionScreen", "", "isAccessibilityServiceEnabled", "", "context", "Landroid/content/Context;", "service", "Ljava/lang/Class;", "Landroid/accessibilityservice/AccessibilityService;", "app_debug"})
public final class MainActivityKt {
    
    @androidx.compose.runtime.Composable()
    public static final void PermissionScreen() {
    }
    
    public static final boolean isAccessibilityServiceEnabled(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.Class<? extends android.accessibilityservice.AccessibilityService> service) {
        return false;
    }
}