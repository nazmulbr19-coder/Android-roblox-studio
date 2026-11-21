package com.exampletest.mobilestudiotest.core;

import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.TreeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Studio.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/exampletest/mobilestudiotest/core/Studio$treeListener$1", "Lcom/exampletest/mobilestudiotest/model/TreeListener;", "childAdded", "", "parent", "Lcom/exampletest/mobilestudiotest/model/Instance;", "child", "childRemoved", "propChanged", "inst", "name", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Studio$treeListener$1 implements TreeListener {
    final /* synthetic */ Studio this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Studio$treeListener$1(Studio studio) {
        this.this$0 = studio;
    }

    @Override // com.exampletest.mobilestudiotest.model.TreeListener
    public void childAdded(Instance parent, Instance child) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (Studio.access$renderRelevant(this.this$0, child)) {
            Studio.access$setPartsDirty$p(this.this$0, true);
        }
        Studio.access$postTree(this.this$0);
    }

    @Override // com.exampletest.mobilestudiotest.model.TreeListener
    public void childRemoved(Instance parent, Instance child) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (Studio.access$renderRelevant(this.this$0, child)) {
            Studio.access$setPartsDirty$p(this.this$0, true);
        }
        Studio.access$postTree(this.this$0);
    }

    @Override // com.exampletest.mobilestudiotest.model.TreeListener
    public void propChanged(Instance inst, String name) {
        Intrinsics.checkNotNullParameter(inst, "inst");
        Intrinsics.checkNotNullParameter(name, "name");
        if (Intrinsics.areEqual(name, "Name")) {
            Studio.access$postTree(this.this$0);
        }
        if (this.this$0.getSelection().isEmpty()) {
            return;
        }
        ArrayList<Instance> selection = this.this$0.getSelection();
        boolean z = false;
        if (!(selection instanceof Collection) || !selection.isEmpty()) {
            Iterator<T> it = selection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((Instance) it.next()) == inst) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            Studio.access$postProps(this.this$0);
        }
    }
}
