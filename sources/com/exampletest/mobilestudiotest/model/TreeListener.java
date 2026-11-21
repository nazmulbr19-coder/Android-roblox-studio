package com.exampletest.mobilestudiotest.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Instance.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/TreeListener;", "", "childAdded", "", "parent", "Lcom/exampletest/mobilestudiotest/model/Instance;", "child", "childRemoved", "propChanged", "inst", "name", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface TreeListener {

    /* compiled from: Instance.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static void childAdded(TreeListener treeListener, Instance parent, Instance child) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(child, "child");
            TreeListener.access$childAdded$jd(treeListener, parent, child);
        }

        @Deprecated
        public static void childRemoved(TreeListener treeListener, Instance parent, Instance child) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(child, "child");
            TreeListener.access$childRemoved$jd(treeListener, parent, child);
        }

        @Deprecated
        public static void propChanged(TreeListener treeListener, Instance inst, String name) {
            Intrinsics.checkNotNullParameter(inst, "inst");
            Intrinsics.checkNotNullParameter(name, "name");
            TreeListener.access$propChanged$jd(treeListener, inst, name);
        }
    }

    static /* synthetic */ void access$childAdded$jd(TreeListener treeListener, Instance instance, Instance instance2) {
        super.childAdded(instance, instance2);
    }

    static /* synthetic */ void access$childRemoved$jd(TreeListener treeListener, Instance instance, Instance instance2) {
        super.childRemoved(instance, instance2);
    }

    static /* synthetic */ void access$propChanged$jd(TreeListener treeListener, Instance instance, String str) {
        super.propChanged(instance, str);
    }

    default void childAdded(Instance parent, Instance child) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
    }

    default void childRemoved(Instance parent, Instance child) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
    }

    default void propChanged(Instance inst, String name) {
        Intrinsics.checkNotNullParameter(inst, "inst");
        Intrinsics.checkNotNullParameter(name, "name");
    }
}
