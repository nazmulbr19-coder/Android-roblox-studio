package com.exampletest.mobilestudiotest.render;

import com.exampletest.mobilestudiotest.format.RbxFile;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.PartData;
import com.exampletest.mobilestudiotest.net.AssetFetcher;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: RbxMesh.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0012\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u0006J\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0006J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010\b\u001aB\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000b0\u000b \n* \u0012\f\u0012\n \n*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010\f\u001aB\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000b0\u000b \n* \u0012\f\u0012\n \n*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \n*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/MeshLoader;", "", "<init>", "()V", "ready", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/exampletest/mobilestudiotest/render/MeshData;", "bad", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "", "pending", "pool", "Ljava/util/concurrent/ExecutorService;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function1;", "", "getListeners", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "value", "", "epoch", "getEpoch", "()I", "get", "id", "waiting", "isBad", "meshInsideModel", "bytes", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MeshLoader {
    private static volatile int epoch;
    private static volatile boolean waiting;
    public static final MeshLoader INSTANCE = new MeshLoader();
    private static final ConcurrentHashMap<Long, MeshData> ready = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap.KeySetView<Long, Boolean> bad = ConcurrentHashMap.newKeySet();
    private static final ConcurrentHashMap.KeySetView<Long, Boolean> pending = ConcurrentHashMap.newKeySet();
    private static final ExecutorService pool = Executors.newSingleThreadExecutor();
    private static final CopyOnWriteArrayList<Function1<Long, Unit>> listeners = new CopyOnWriteArrayList<>();

    private MeshLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit get$lambda$1(long j) {
        if (!ready.containsKey(Long.valueOf(j)) && !bad.contains(Long.valueOf(j))) {
            MeshLoader meshLoader = INSTANCE;
            int i = epoch;
            MeshLoader meshLoader2 = INSTANCE;
            epoch = i + 1;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0075, code lost:
    
        if (kotlin.text.StringsKt.startsWith$default(r1, "not a", false, 2, (java.lang.Object) null) == false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void get$lambda$3(long r8, byte[] r10) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.render.MeshLoader.get$lambda$3(long, byte[]):void");
    }

    private final MeshData meshInsideModel(long id, byte[] bytes) {
        try {
            for (Instance instance : RbxFile.INSTANCE.read(bytes).getRoots()) {
                Iterator it = CollectionsKt.plus((Collection) CollectionsKt.listOf(instance), (Iterable) Instance.descendants$default(instance, null, 1, null)).iterator();
                while (it.hasNext()) {
                    Long idOf = AssetFetcher.INSTANCE.idOf(PartData.INSTANCE.meshContent((Instance) it.next()));
                    if (idOf != null) {
                        long longValue = idOf.longValue();
                        if (longValue != id) {
                            try {
                                return RbxMesh.INSTANCE.parse(AssetFetcher.INSTANCE.load(longValue));
                            } catch (Exception e) {
                                return null;
                            }
                        }
                    }
                }
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public final MeshData get(long id) {
        MeshData meshData = ready.get(Long.valueOf(id));
        if (meshData != null) {
            return meshData;
        }
        if (bad.contains(Long.valueOf(id)) || !pending.add(Long.valueOf(id))) {
            return null;
        }
        byte[] request = AssetFetcher.INSTANCE.request(id);
        if (request != null) {
            pool.execute(new MeshLoader$$ExternalSyntheticLambda1(id, request));
            return null;
        }
        pending.remove(Long.valueOf(id));
        if (!waiting) {
            waiting = true;
            AssetFetcher.INSTANCE.getListeners().add(new MeshLoader$$ExternalSyntheticLambda0());
        }
        return null;
    }

    public final int getEpoch() {
        return epoch;
    }

    public final CopyOnWriteArrayList<Function1<Long, Unit>> getListeners() {
        return listeners;
    }

    public final boolean isBad(long id) {
        return bad.contains(Long.valueOf(id));
    }
}
