package com.aura.app.core.action;

/**
 * Represents an atomic action the Agent can perform on the screen.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/aura/app/core/action/Action;", "", "()V", "Click", "Direction", "GlobalBack", "GlobalHome", "InputText", "LongClick", "Scroll", "Lcom/aura/app/core/action/Action$Click;", "Lcom/aura/app/core/action/Action$GlobalBack;", "Lcom/aura/app/core/action/Action$GlobalHome;", "Lcom/aura/app/core/action/Action$InputText;", "Lcom/aura/app/core/action/Action$LongClick;", "Lcom/aura/app/core/action/Action$Scroll;", "app_debug"})
public abstract class Action {
    
    private Action() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/aura/app/core/action/Action$Click;", "Lcom/aura/app/core/action/Action;", "selector", "Lcom/aura/app/core/action/Selector;", "(Lcom/aura/app/core/action/Selector;)V", "getSelector", "()Lcom/aura/app/core/action/Selector;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class Click extends com.aura.app.core.action.Action {
        @org.jetbrains.annotations.NotNull()
        private final com.aura.app.core.action.Selector selector = null;
        
        public Click(@org.jetbrains.annotations.NotNull()
        com.aura.app.core.action.Selector selector) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aura.app.core.action.Selector getSelector() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aura.app.core.action.Selector component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aura.app.core.action.Action.Click copy(@org.jetbrains.annotations.NotNull()
        com.aura.app.core.action.Selector selector) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/aura/app/core/action/Action$Direction;", "", "(Ljava/lang/String;I)V", "UP", "DOWN", "LEFT", "RIGHT", "app_debug"})
    public static enum Direction {
        /*public static final*/ UP /* = new UP() */,
        /*public static final*/ DOWN /* = new DOWN() */,
        /*public static final*/ LEFT /* = new LEFT() */,
        /*public static final*/ RIGHT /* = new RIGHT() */;
        
        Direction() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.aura.app.core.action.Action.Direction> getEntries() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/aura/app/core/action/Action$GlobalBack;", "Lcom/aura/app/core/action/Action;", "()V", "app_debug"})
    public static final class GlobalBack extends com.aura.app.core.action.Action {
        @org.jetbrains.annotations.NotNull()
        public static final com.aura.app.core.action.Action.GlobalBack INSTANCE = null;
        
        private GlobalBack() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/aura/app/core/action/Action$GlobalHome;", "Lcom/aura/app/core/action/Action;", "()V", "app_debug"})
    public static final class GlobalHome extends com.aura.app.core.action.Action {
        @org.jetbrains.annotations.NotNull()
        public static final com.aura.app.core.action.Action.GlobalHome INSTANCE = null;
        
        private GlobalHome() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/aura/app/core/action/Action$InputText;", "Lcom/aura/app/core/action/Action;", "selector", "Lcom/aura/app/core/action/Selector;", "text", "", "(Lcom/aura/app/core/action/Selector;Ljava/lang/String;)V", "getSelector", "()Lcom/aura/app/core/action/Selector;", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class InputText extends com.aura.app.core.action.Action {
        @org.jetbrains.annotations.NotNull()
        private final com.aura.app.core.action.Selector selector = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String text = null;
        
        public InputText(@org.jetbrains.annotations.NotNull()
        com.aura.app.core.action.Selector selector, @org.jetbrains.annotations.NotNull()
        java.lang.String text) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aura.app.core.action.Selector getSelector() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getText() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aura.app.core.action.Selector component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aura.app.core.action.Action.InputText copy(@org.jetbrains.annotations.NotNull()
        com.aura.app.core.action.Selector selector, @org.jetbrains.annotations.NotNull()
        java.lang.String text) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/aura/app/core/action/Action$LongClick;", "Lcom/aura/app/core/action/Action;", "selector", "Lcom/aura/app/core/action/Selector;", "(Lcom/aura/app/core/action/Selector;)V", "getSelector", "()Lcom/aura/app/core/action/Selector;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class LongClick extends com.aura.app.core.action.Action {
        @org.jetbrains.annotations.NotNull()
        private final com.aura.app.core.action.Selector selector = null;
        
        public LongClick(@org.jetbrains.annotations.NotNull()
        com.aura.app.core.action.Selector selector) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aura.app.core.action.Selector getSelector() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aura.app.core.action.Selector component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aura.app.core.action.Action.LongClick copy(@org.jetbrains.annotations.NotNull()
        com.aura.app.core.action.Selector selector) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/aura/app/core/action/Action$Scroll;", "Lcom/aura/app/core/action/Action;", "selector", "Lcom/aura/app/core/action/Selector;", "direction", "Lcom/aura/app/core/action/Action$Direction;", "(Lcom/aura/app/core/action/Selector;Lcom/aura/app/core/action/Action$Direction;)V", "getDirection", "()Lcom/aura/app/core/action/Action$Direction;", "getSelector", "()Lcom/aura/app/core/action/Selector;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class Scroll extends com.aura.app.core.action.Action {
        @org.jetbrains.annotations.NotNull()
        private final com.aura.app.core.action.Selector selector = null;
        @org.jetbrains.annotations.NotNull()
        private final com.aura.app.core.action.Action.Direction direction = null;
        
        public Scroll(@org.jetbrains.annotations.NotNull()
        com.aura.app.core.action.Selector selector, @org.jetbrains.annotations.NotNull()
        com.aura.app.core.action.Action.Direction direction) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aura.app.core.action.Selector getSelector() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aura.app.core.action.Action.Direction getDirection() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aura.app.core.action.Selector component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aura.app.core.action.Action.Direction component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aura.app.core.action.Action.Scroll copy(@org.jetbrains.annotations.NotNull()
        com.aura.app.core.action.Selector selector, @org.jetbrains.annotations.NotNull()
        com.aura.app.core.action.Action.Direction direction) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}