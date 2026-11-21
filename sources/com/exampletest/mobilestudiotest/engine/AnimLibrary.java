package com.exampletest.mobilestudiotest.engine;

import com.exampletest.mobilestudiotest.format.RbxFile;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.net.AssetFetcher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyframeAnim.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u0013R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010\b\u001aB\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000b0\u000b \n* \u0012\f\u0012\n \n*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010\f\u001aB\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000b0\u000b \n* \u0012\f\u0012\n \n*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \n*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/AnimLibrary;", "", "<init>", "()V", "clips", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/exampletest/mobilestudiotest/engine/AnimClip;", "failed", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "", "pending", "pool", "Ljava/util/concurrent/ExecutorService;", "get", "id", "fromInstance", "seq", "Lcom/exampletest/mobilestudiotest/model/Instance;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AnimLibrary {
    public static final AnimLibrary INSTANCE = new AnimLibrary();
    private static final ConcurrentHashMap<Long, AnimClip> clips = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap.KeySetView<Long, Boolean> failed = ConcurrentHashMap.newKeySet();
    private static final ConcurrentHashMap.KeySetView<Long, Boolean> pending = ConcurrentHashMap.newKeySet();
    private static final ExecutorService pool = Executors.newSingleThreadExecutor();

    private AnimLibrary() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void get$lambda$4(long j) {
        Object obj;
        try {
            try {
                List<Instance> roots = RbxFile.INSTANCE.read(AssetFetcher.INSTANCE.load(j)).getRoots();
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = roots.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Instance instance = (Instance) it.next();
                    CollectionsKt.addAll(arrayList, CollectionsKt.plus((Collection) CollectionsKt.listOf(instance), (Iterable) Instance.descendants$default(instance, null, 1, null)));
                }
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it2.next();
                        if (Intrinsics.areEqual(((Instance) obj).getClassName(), "KeyframeSequence")) {
                            break;
                        }
                    }
                }
                Instance instance2 = (Instance) obj;
                AnimClip from = instance2 != null ? AnimClip.INSTANCE.from(instance2) : null;
                if (from != null) {
                    clips.put(Long.valueOf(j), from);
                } else {
                    failed.add(Long.valueOf(j));
                }
            } catch (Exception e) {
                failed.add(Long.valueOf(j));
            }
        } finally {
            pending.remove(Long.valueOf(j));
        }
    }

    public final boolean failed(long id) {
        return failed.contains(Long.valueOf(id));
    }

    public final AnimClip fromInstance(Instance seq) {
        Intrinsics.checkNotNullParameter(seq, "seq");
        return AnimClip.INSTANCE.from(seq);
    }

    public final AnimClip get(long id) {
        AnimClip animClip = clips.get(Long.valueOf(id));
        if (animClip != null) {
            return animClip;
        }
        if (failed.contains(Long.valueOf(id)) || !pending.add(Long.valueOf(id))) {
            return null;
        }
        pool.execute(new AnimLibrary$$ExternalSyntheticLambda0(id));
        return null;
    }
}
