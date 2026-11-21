package com.exampletest.mobilestudiotest.core;

import androidx.core.app.NotificationCompat;
import com.exampletest.mobilestudiotest.lua.LuaRuntime;
import com.exampletest.mobilestudiotest.model.DataModel;
import com.exampletest.mobilestudiotest.model.Instance;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;

/* compiled from: UndoManager.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0002)*B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000fJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\fJ\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\bH\u0002J\u0006\u0010\"\u001a\u00020\u001bJ\u0006\u0010#\u001a\u00020\u001bJ\u0006\u0010$\u001a\u00020\u001bJ\u0018\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0018\u0010'\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013¨\u0006+"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/UndoManager;", "", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "<init>", "(Lcom/exampletest/mobilestudiotest/core/Studio;)V", "undoStack", "Lkotlin/collections/ArrayDeque;", "Lcom/exampletest/mobilestudiotest/core/UndoManager$Step;", "redoStack", "batch", "Ljava/util/ArrayList;", "Lcom/exampletest/mobilestudiotest/core/UndoManager$Op;", "Lkotlin/collections/ArrayList;", "batchLabel", "", "suspended", "", "getSuspended", "()Z", "setSuspended", "(Z)V", "canUndo", "getCanUndo", "canRedo", "getCanRedo", "begin", "", "label", "commit", "record", "op", "push", "s", "clear", "undo", "redo", "notifyPlugins", NotificationCompat.CATEGORY_EVENT, "apply", "reverse", "Op", "Step", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UndoManager {
    private ArrayList<Op> batch;
    private String batchLabel;
    private final ArrayDeque<Step> redoStack;
    private final Studio studio;
    private boolean suspended;
    private final ArrayDeque<Step> undoStack;

    /* compiled from: UndoManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/UndoManager$Op;", "", "<init>", "()V", "Prop", "Parent", "Lcom/exampletest/mobilestudiotest/core/UndoManager$Op$Parent;", "Lcom/exampletest/mobilestudiotest/core/UndoManager$Op$Prop;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static abstract class Op {

        /* compiled from: UndoManager.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/UndoManager$Op$Parent;", "Lcom/exampletest/mobilestudiotest/core/UndoManager$Op;", "inst", "Lcom/exampletest/mobilestudiotest/model/Instance;", "oldParent", "oldIndex", "", "newParent", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Instance;Lcom/exampletest/mobilestudiotest/model/Instance;ILcom/exampletest/mobilestudiotest/model/Instance;)V", "getInst", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "getOldParent", "getOldIndex", "()I", "getNewParent", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Parent extends Op {
            private final Instance inst;
            private final Instance newParent;
            private final int oldIndex;
            private final Instance oldParent;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Parent(Instance inst, Instance instance, int i, Instance instance2) {
                super(null);
                Intrinsics.checkNotNullParameter(inst, "inst");
                this.inst = inst;
                this.oldParent = instance;
                this.oldIndex = i;
                this.newParent = instance2;
            }

            public final Instance getInst() {
                return this.inst;
            }

            public final Instance getNewParent() {
                return this.newParent;
            }

            public final int getOldIndex() {
                return this.oldIndex;
            }

            public final Instance getOldParent() {
                return this.oldParent;
            }
        }

        /* compiled from: UndoManager.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/UndoManager$Op$Prop;", "Lcom/exampletest/mobilestudiotest/core/UndoManager$Op;", "inst", "Lcom/exampletest/mobilestudiotest/model/Instance;", "name", "", "old", "", "new", "hadOld", "", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Instance;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Z)V", "getInst", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "getName", "()Ljava/lang/String;", "getOld", "()Ljava/lang/Object;", "getNew", "getHadOld", "()Z", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Prop extends Op {
            private final boolean hadOld;
            private final Instance inst;
            private final String name;
            private final Object new;
            private final Object old;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Prop(Instance inst, String name, Object obj, Object obj2, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(inst, "inst");
                Intrinsics.checkNotNullParameter(name, "name");
                this.inst = inst;
                this.name = name;
                this.old = obj;
                this.new = obj2;
                this.hadOld = z;
            }

            public final boolean getHadOld() {
                return this.hadOld;
            }

            public final Instance getInst() {
                return this.inst;
            }

            public final String getName() {
                return this.name;
            }

            public final Object getNew() {
                return this.new;
            }

            public final Object getOld() {
                return this.old;
            }
        }

        private Op() {
        }

        public /* synthetic */ Op(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: UndoManager.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/UndoManager$Step;", "", "label", "", "ops", "", "Lcom/exampletest/mobilestudiotest/core/UndoManager$Op;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getLabel", "()Ljava/lang/String;", "getOps", "()Ljava/util/List;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    private static final class Step {
        private final String label;
        private final List<Op> ops;

        /* JADX WARN: Multi-variable type inference failed */
        public Step(String label, List<? extends Op> ops) {
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(ops, "ops");
            this.label = label;
            this.ops = ops;
        }

        public final String getLabel() {
            return this.label;
        }

        public final List<Op> getOps() {
            return this.ops;
        }
    }

    public UndoManager(Studio studio) {
        Intrinsics.checkNotNullParameter(studio, "studio");
        this.studio = studio;
        this.undoStack = new ArrayDeque<>();
        this.redoStack = new ArrayDeque<>();
        this.batchLabel = "";
    }

    private final void apply(Step s, boolean reverse) {
        synchronized (this.studio.getLock()) {
            this.suspended = true;
            try {
                for (Op op : reverse ? CollectionsKt.asReversed(s.getOps()) : s.getOps()) {
                    if (!(op instanceof Op.Prop)) {
                        if (!(op instanceof Op.Parent)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (reverse) {
                            ((Op.Parent) op).getInst().setDestroyed(false);
                            ((Op.Parent) op).getInst().setParent(((Op.Parent) op).getOldParent(), ((Op.Parent) op).getOldIndex());
                        } else {
                            Instance.setParent$default(((Op.Parent) op).getInst(), ((Op.Parent) op).getNewParent(), 0, 2, null);
                        }
                    } else if (!reverse) {
                        Instance.set$default(((Op.Prop) op).getInst(), ((Op.Prop) op).getName(), ((Op.Prop) op).getNew(), false, 4, null);
                    } else if (((Op.Prop) op).getHadOld()) {
                        Instance.set$default(((Op.Prop) op).getInst(), ((Op.Prop) op).getName(), ((Op.Prop) op).getOld(), false, 4, null);
                    } else {
                        ((Op.Prop) op).getInst().getProps().remove(((Op.Prop) op).getName());
                        DataModel root = ((Op.Prop) op).getInst().root();
                        if (root != null) {
                            root.firePropChanged(((Op.Prop) op).getInst(), ((Op.Prop) op).getName());
                        }
                    }
                }
                this.suspended = false;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                this.suspended = false;
                throw th;
            }
        }
        this.studio.markDirty();
        this.studio.pruneSelection();
    }

    private final void notifyPlugins(String event, String label) {
        synchronized (this.studio.getLock()) {
            Instance findService = this.studio.getEditModel().findService("ChangeHistoryService");
            if (findService == null) {
                return;
            }
            try {
                LuaRuntime editRuntime = this.studio.getEditRuntime();
                LuaString valueOf = LuaValue.valueOf(label);
                Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
                editRuntime.fire(findService, event, valueOf);
            } catch (Exception e) {
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void push(Step s) {
        this.undoStack.addLast(s);
        if (this.undoStack.size() > 200) {
            this.undoStack.removeFirst();
        }
        this.redoStack.clear();
        this.studio.markDirty();
    }

    public final void begin(String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        if (this.batch == null) {
            this.batch = new ArrayList<>();
            this.batchLabel = label;
        }
    }

    public final void clear() {
        this.undoStack.clear();
        this.redoStack.clear();
        this.batch = null;
    }

    public final void commit() {
        ArrayList<Op> arrayList = this.batch;
        if (arrayList == null) {
            return;
        }
        this.batch = null;
        if (arrayList.isEmpty()) {
            return;
        }
        push(new Step(this.batchLabel, arrayList));
    }

    public final boolean getCanRedo() {
        return !this.redoStack.isEmpty();
    }

    public final boolean getCanUndo() {
        return !this.undoStack.isEmpty();
    }

    public final boolean getSuspended() {
        return this.suspended;
    }

    public final void record(Op op) {
        Intrinsics.checkNotNullParameter(op, "op");
        if (this.suspended || this.studio.isPlaying()) {
            return;
        }
        ArrayList<Op> arrayList = this.batch;
        if (arrayList != null) {
            arrayList.add(op);
        } else {
            push(new Step("Edit", CollectionsKt.listOf(op)));
        }
    }

    public final void redo() {
        Step removeLastOrNull;
        synchronized (this.studio.getLock()) {
            removeLastOrNull = this.redoStack.removeLastOrNull();
        }
        if (removeLastOrNull == null) {
            return;
        }
        apply(removeLastOrNull, false);
        this.undoStack.addLast(removeLastOrNull);
        OutputLog.INSTANCE.info("Redo: " + removeLastOrNull.getLabel());
        notifyPlugins("OnRedo", removeLastOrNull.getLabel());
    }

    public final void setSuspended(boolean z) {
        this.suspended = z;
    }

    public final void undo() {
        Step removeLastOrNull;
        synchronized (this.studio.getLock()) {
            removeLastOrNull = this.undoStack.removeLastOrNull();
        }
        if (removeLastOrNull == null) {
            return;
        }
        apply(removeLastOrNull, true);
        this.redoStack.addLast(removeLastOrNull);
        OutputLog.INSTANCE.info("Undo: " + removeLastOrNull.getLabel());
        notifyPlugins("OnUndo", removeLastOrNull.getLabel());
    }
}
