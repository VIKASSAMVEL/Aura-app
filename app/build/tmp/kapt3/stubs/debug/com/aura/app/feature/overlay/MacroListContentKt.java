package com.aura.app.feature.overlay;

import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.*;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import com.aura.app.core.data.local.entity.MacroEntity;
import com.aura.app.ui.theme.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001aL\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007\u00a8\u0006\f"}, d2 = {"MacroItem", "", "macro", "Lcom/aura/app/core/data/local/entity/MacroEntity;", "onPlay", "Lkotlin/Function1;", "onDelete", "MacroListContent", "macros", "", "onClose", "Lkotlin/Function0;", "app_debug"})
public final class MacroListContentKt {
    
    @androidx.compose.runtime.Composable()
    public static final void MacroListContent(@org.jetbrains.annotations.NotNull()
    java.util.List<com.aura.app.core.data.local.entity.MacroEntity> macros, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.aura.app.core.data.local.entity.MacroEntity, kotlin.Unit> onPlay, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.aura.app.core.data.local.entity.MacroEntity, kotlin.Unit> onDelete, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClose) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void MacroItem(@org.jetbrains.annotations.NotNull()
    com.aura.app.core.data.local.entity.MacroEntity macro, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.aura.app.core.data.local.entity.MacroEntity, kotlin.Unit> onPlay, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.aura.app.core.data.local.entity.MacroEntity, kotlin.Unit> onDelete) {
    }
}