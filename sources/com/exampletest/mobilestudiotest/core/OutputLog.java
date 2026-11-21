package com.exampletest.mobilestudiotest.core;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OutputLog.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fJ\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u000bJ\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0014J\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0014R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u000b0\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/OutputLog;", "", "<init>", "()V", "entries", "Ljava/util/ArrayList;", "Lcom/exampletest/mobilestudiotest/core/OutputLog$Entry;", "Lkotlin/collections/ArrayList;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function1;", "", "getListeners", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "snapshot", "", "add", "level", "Lcom/exampletest/mobilestudiotest/core/OutputLog$Level;", "text", "", "clear", "print", "s", "info", "warn", "error", "Level", "Entry", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OutputLog {
    public static final OutputLog INSTANCE = new OutputLog();
    private static final ArrayList<Entry> entries = new ArrayList<>();
    private static final CopyOnWriteArrayList<Function1<Entry, Unit>> listeners = new CopyOnWriteArrayList<>();

    /* compiled from: OutputLog.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/OutputLog$Entry;", "", "time", "", "level", "Lcom/exampletest/mobilestudiotest/core/OutputLog$Level;", "text", "", "<init>", "(JLcom/exampletest/mobilestudiotest/core/OutputLog$Level;Ljava/lang/String;)V", "getTime", "()J", "getLevel", "()Lcom/exampletest/mobilestudiotest/core/OutputLog$Level;", "getText", "()Ljava/lang/String;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Entry {
        private final Level level;
        private final String text;
        private final long time;

        public Entry(long j, Level level, String text) {
            Intrinsics.checkNotNullParameter(level, "level");
            Intrinsics.checkNotNullParameter(text, "text");
            this.time = j;
            this.level = level;
            this.text = text;
        }

        public final Level getLevel() {
            return this.level;
        }

        public final String getText() {
            return this.text;
        }

        public final long getTime() {
            return this.time;
        }
    }

    /* compiled from: OutputLog.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/OutputLog$Level;", "", "<init>", "(Ljava/lang/String;I)V", "PRINT", "INFO", "WARN", "ERROR", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public enum Level {
        PRINT,
        INFO,
        WARN,
        ERROR;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Level> getEntries() {
            return $ENTRIES;
        }
    }

    private OutputLog() {
    }

    public final void add(Level level, String text) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(text, "text");
        Entry entry = new Entry(System.currentTimeMillis(), level, text);
        synchronized (entries) {
            entries.add(entry);
            if (entries.size() > 3000) {
                entries.subList(0, 500).clear();
            }
            Unit unit = Unit.INSTANCE;
        }
        try {
            Log.i("MobileStudio", "[" + level + "] " + text);
        } catch (Throwable th) {
        }
        Iterator<Function1<Entry, Unit>> it = listeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().invoke(entry);
        }
    }

    public final void clear() {
        synchronized (entries) {
            entries.clear();
            Unit unit = Unit.INSTANCE;
        }
        Iterator<Function1<Entry, Unit>> it = listeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().invoke(null);
        }
    }

    public final void error(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        add(Level.ERROR, s);
    }

    public final CopyOnWriteArrayList<Function1<Entry, Unit>> getListeners() {
        return listeners;
    }

    public final void info(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        add(Level.INFO, s);
    }

    public final void print(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        add(Level.PRINT, s);
    }

    public final List<Entry> snapshot() {
        List<Entry> list;
        synchronized (entries) {
            list = CollectionsKt.toList(entries);
        }
        return list;
    }

    public final void warn(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        add(Level.WARN, s);
    }
}
