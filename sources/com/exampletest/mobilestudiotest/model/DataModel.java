package com.exampletest.mobilestudiotest.model;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Instance.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0018\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u000bJ\u0006\u0010\u001d\u001a\u00020\u0000R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR-\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u001a\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/DataModel;", "Lcom/exampletest/mobilestudiotest/model/Instance;", "<init>", "()V", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/exampletest/mobilestudiotest/model/TreeListener;", "getListeners", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "meta", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "getMeta", "()Ljava/util/LinkedHashMap;", "fireChildAdded", "", "p", "c", "fireChildRemoved", "firePropChanged", "i", "n", "findService", "cls", "getService", "workspace", "getWorkspace", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "cloneModel", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DataModel extends Instance {
    private final CopyOnWriteArrayList<TreeListener> listeners;
    private final LinkedHashMap<String, String> meta;

    public DataModel() {
        super("DataModel");
        this.listeners = new CopyOnWriteArrayList<>();
        this.meta = new LinkedHashMap<>();
        getProps().put("Name", "Game");
    }

    public final DataModel cloneModel() {
        IdentityHashMap<Instance, Instance> identityHashMap = new IdentityHashMap<>();
        DataModel dataModel = new DataModel();
        dataModel.meta.putAll(this.meta);
        Instance.INSTANCE.copyInto$app(this, identityHashMap, dataModel);
        Instance.INSTANCE.remapRefs$app(identityHashMap);
        return dataModel;
    }

    public final Instance findService(String cls) {
        Object obj;
        Intrinsics.checkNotNullParameter(cls, "cls");
        Iterator<T> it = getChildren().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Instance) obj).getClassName(), cls)) {
                break;
            }
        }
        return (Instance) obj;
    }

    public final void fireChildAdded(Instance p, Instance c) {
        Intrinsics.checkNotNullParameter(p, "p");
        Intrinsics.checkNotNullParameter(c, "c");
        Iterator<TreeListener> it = this.listeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().childAdded(p, c);
        }
    }

    public final void fireChildRemoved(Instance p, Instance c) {
        Intrinsics.checkNotNullParameter(p, "p");
        Intrinsics.checkNotNullParameter(c, "c");
        Iterator<TreeListener> it = this.listeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().childRemoved(p, c);
        }
    }

    public final void firePropChanged(Instance i, String n) {
        Intrinsics.checkNotNullParameter(i, "i");
        Intrinsics.checkNotNullParameter(n, "n");
        Iterator<TreeListener> it = this.listeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().propChanged(i, n);
        }
    }

    public final CopyOnWriteArrayList<TreeListener> getListeners() {
        return this.listeners;
    }

    public final LinkedHashMap<String, String> getMeta() {
        return this.meta;
    }

    public final Instance getService(String cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        Instance findService = findService(cls);
        if (findService != null) {
            return findService;
        }
        Instance create = InstanceFactory.INSTANCE.create(cls);
        create.setService(true);
        Instance.setParent$default(create, this, 0, 2, null);
        return create;
    }

    public final Instance getWorkspace() {
        return getService("Workspace");
    }
}
