package com.aura.app.core.ai;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayDeque;
import javax.inject.Inject;
import javax.inject.Singleton;
import dagger.hilt.android.qualifiers.ApplicationContext;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/aura/app/core/ai/ScreenType;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "HOME_SCREEN", "LOGIN_SCREEN", "SETTINGS_SCREEN", "FEED_SCREEN", "app_debug"})
public enum ScreenType {
    /*public static final*/ UNKNOWN /* = new UNKNOWN() */,
    /*public static final*/ HOME_SCREEN /* = new HOME_SCREEN() */,
    /*public static final*/ LOGIN_SCREEN /* = new LOGIN_SCREEN() */,
    /*public static final*/ SETTINGS_SCREEN /* = new SETTINGS_SCREEN() */,
    /*public static final*/ FEED_SCREEN /* = new FEED_SCREEN() */;
    
    ScreenType() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.aura.app.core.ai.ScreenType> getEntries() {
        return null;
    }
}