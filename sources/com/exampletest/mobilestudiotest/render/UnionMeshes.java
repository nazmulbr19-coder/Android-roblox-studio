package com.exampletest.mobilestudiotest.render;

import androidx.core.view.ViewCompat;
import com.exampletest.mobilestudiotest.core.OutputLog;
import com.exampletest.mobilestudiotest.format.CsgMesh;
import com.exampletest.mobilestudiotest.format.RbxFile;
import com.exampletest.mobilestudiotest.model.BinaryString;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.SharedStr;
import com.exampletest.mobilestudiotest.model.Vector3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: UnionMeshes.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001*B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0002J&\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00190&H\u0002J\u0018\u0010'\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010\b\u001aB\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000b0\u000b \n* \u0012\f\u0012\n \n*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010\f\u001aB\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000b0\u000b \n* \u0012\f\u0012\n \n*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \n*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010\u000f\u001aB\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00060\u0006 \n* \u0012\f\u0012\n \n*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/UnionMeshes;", "", "<init>", "()V", "ready", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/exampletest/mobilestudiotest/render/UnionMeshes$Data;", "bad", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "", "pending", "pool", "Ljava/util/concurrent/ExecutorService;", "inlineKeys", "", "", "value", "", "epoch", "getEpoch", "()I", "listening", "bytesOf", "", "v", "isStored", "p", "Lcom/exampletest/mobilestudiotest/model/Instance;", "get", "meshDataFromAsset", "bytes", "build", "", "key", "name", "source", "Lkotlin/Function0;", "toData", "m", "Lcom/exampletest/mobilestudiotest/format/CsgMesh$Decoded;", "Data", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class UnionMeshes {
    private static volatile int epoch;
    private static volatile boolean listening;
    public static final UnionMeshes INSTANCE = new UnionMeshes();
    private static final ConcurrentHashMap<String, Data> ready = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> bad = ConcurrentHashMap.newKeySet();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> pending = ConcurrentHashMap.newKeySet();
    private static final ExecutorService pool = Executors.newSingleThreadExecutor();
    private static final Map<Object, String> inlineKeys = Collections.synchronizedMap(new WeakHashMap());

    /* compiled from: UnionMeshes.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/UnionMeshes$Data;", "", "key", "", "groups", "", "Lkotlin/Pair;", "", "", "center", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "size", "triangles", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/exampletest/mobilestudiotest/model/Vector3;Lcom/exampletest/mobilestudiotest/model/Vector3;Ljava/util/List;)V", "getKey", "()Ljava/lang/String;", "getGroups", "()Ljava/util/List;", "getCenter", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "getSize", "getTriangles", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Data {
        private final Vector3 center;
        private final List<Pair<Integer, float[]>> groups;
        private final String key;
        private final Vector3 size;
        private final List<float[]> triangles;

        public Data(String key, List<Pair<Integer, float[]>> groups, Vector3 center, Vector3 size, List<float[]> triangles) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(groups, "groups");
            Intrinsics.checkNotNullParameter(center, "center");
            Intrinsics.checkNotNullParameter(size, "size");
            Intrinsics.checkNotNullParameter(triangles, "triangles");
            this.key = key;
            this.groups = groups;
            this.center = center;
            this.size = size;
            this.triangles = triangles;
        }

        public final Vector3 getCenter() {
            return this.center;
        }

        public final List<Pair<Integer, float[]>> getGroups() {
            return this.groups;
        }

        public final String getKey() {
            return this.key;
        }

        public final Vector3 getSize() {
            return this.size;
        }

        public final List<float[]> getTriangles() {
            return this.triangles;
        }
    }

    private UnionMeshes() {
    }

    private final void build(String key, String name, Function0<byte[]> source) {
        try {
            try {
                ready.put(key, toData(key, CsgMesh.INSTANCE.decode(source.invoke())));
            } catch (Exception e) {
                bad.add(key);
                OutputLog outputLog = OutputLog.INSTANCE;
                String message = e.getMessage();
                outputLog.warn("Union '" + name + "' can't be shown (" + (message != null ? message : e) + "); it is drawn as a box.");
            }
        } finally {
            pending.remove(key);
            epoch++;
        }
    }

    private final byte[] bytesOf(Object v) {
        byte[] bArr;
        if (v instanceof BinaryString) {
            bArr = ((BinaryString) v).getBytes();
        } else if (v instanceof SharedStr) {
            bArr = ((SharedStr) v).getBytes();
        } else if (!(v instanceof String)) {
            bArr = null;
        } else if (((String) v).length() > 16) {
            bArr = ((String) v).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bArr, "getBytes(...)");
        } else {
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        if (bArr.length > 16) {
            return bArr;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit get$lambda$10(long j) {
        if (!ready.containsKey("asset:" + j)) {
            UnionMeshes unionMeshes = INSTANCE;
            int i = epoch;
            UnionMeshes unionMeshes2 = INSTANCE;
            epoch = i + 1;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void get$lambda$12(String str, Instance instance, byte[] bArr) {
        INSTANCE.build(str, instance.getName(), new UnionMeshes$$ExternalSyntheticLambda0(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final byte[] get$lambda$12$lambda$11(byte[] bArr) {
        return INSTANCE.meshDataFromAsset(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void get$lambda$8(String str, Instance instance, byte[] bArr) {
        INSTANCE.build(str, instance.getName(), new UnionMeshes$$ExternalSyntheticLambda1(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final byte[] get$lambda$8$lambda$7(byte[] bArr) {
        return bArr;
    }

    private final byte[] meshDataFromAsset(byte[] bytes) {
        if (CsgMesh.INSTANCE.isCsgMesh(bytes)) {
            return bytes;
        }
        for (Instance instance : RbxFile.INSTANCE.read(bytes).getRoots()) {
            for (Instance instance2 : CollectionsKt.plus((Collection) CollectionsKt.listOf(instance), (Iterable) Instance.descendants$default(instance, null, 1, null))) {
                byte[] bytesOf = bytesOf(instance2.getProps().get("MeshData"));
                if (bytesOf != null) {
                    return bytesOf;
                }
                byte[] bytesOf2 = bytesOf(instance2.getProps().get("MeshData2"));
                if (bytesOf2 != null) {
                    return bytesOf2;
                }
            }
        }
        throw new CsgMesh.CsgException("the union asset has no mesh");
    }

    private final Data toData(String key, CsgMesh.Decoded m) {
        float[] fArr;
        int i;
        Object obj;
        float f;
        float f2;
        float f3;
        float[] pos = m.getPos();
        float[] nrm = m.getNrm();
        int i2 = 3;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE};
        float[] fArr3 = {-3.4028235E38f, -3.4028235E38f, -3.4028235E38f};
        int i3 = 0;
        for (int i4 : m.getIndices()) {
            for (int i5 = 0; i5 < 3; i5++) {
                float f4 = pos[(i4 * 3) + i5];
                if (f4 < fArr2[i5]) {
                    fArr2[i5] = f4;
                }
                if (f4 > fArr3[i5]) {
                    fArr3[i5] = f4;
                }
            }
        }
        if (fArr2[0] > fArr3[0]) {
            ArraysKt.fill$default(fArr2, 0.0f, 0, 0, 6, (Object) null);
            fArr = fArr3;
            ArraysKt.fill$default(fArr, 0.0f, 0, 0, 6, (Object) null);
        } else {
            fArr = fArr3;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        while (i6 + 2 < m.getIndices().length) {
            int i7 = m.getIndices()[i6];
            int i8 = m.getIndices()[i6 + 1];
            int i9 = m.getIndices()[i6 + 2];
            i6 += 3;
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            Integer valueOf = Integer.valueOf(m.getColors()[i7] | ViewCompat.MEASURED_STATE_MASK);
            Object obj2 = linkedHashMap2.get(valueOf);
            if (obj2 == null) {
                obj = new ArrayList();
                i = i3;
                linkedHashMap2.put(valueOf, obj);
            } else {
                i = i3;
                obj = obj2;
            }
            ArrayList arrayList2 = (ArrayList) obj;
            float[] fArr4 = new float[9];
            int i10 = 0;
            int[] iArr = {i7, i8, i9};
            int i11 = i;
            while (i11 < i2) {
                int i12 = iArr[i11];
                float[] fArr5 = pos;
                int i13 = 0;
                while (i13 < i2) {
                    arrayList2.add(Float.valueOf(fArr5[(i12 * 3) + i13]));
                    fArr4[i10] = fArr5[(i12 * 3) + i13];
                    i13++;
                    i10++;
                    i2 = 3;
                }
                float f5 = nrm[i12 * 3];
                float f6 = nrm[(i12 * 3) + 1];
                float f7 = nrm[(i12 * 3) + 2];
                float[] fArr6 = nrm;
                float sqrt = (float) Math.sqrt((f5 * f5) + (f6 * f6) + (f7 * f7));
                if (sqrt > 1.0E-6f) {
                    f = f5 / sqrt;
                    f2 = f6 / sqrt;
                    f3 = f7 / sqrt;
                } else {
                    f = 0.0f;
                    f2 = 1.0f;
                    f3 = 0.0f;
                }
                arrayList2.add(Float.valueOf(f));
                arrayList2.add(Float.valueOf(f2));
                arrayList2.add(Float.valueOf(f3));
                arrayList2.add(Float.valueOf(0.0f));
                arrayList2.add(Float.valueOf(0.0f));
                i11++;
                pos = fArr5;
                nrm = fArr6;
                i2 = 3;
            }
            arrayList.add(fArr4);
            i3 = i;
            i2 = 3;
        }
        int i14 = i3;
        LinkedHashMap linkedHashMap3 = linkedHashMap;
        ArrayList arrayList3 = new ArrayList(linkedHashMap3.size());
        for (Map.Entry entry : linkedHashMap3.entrySet()) {
            arrayList3.add(TuplesKt.to(Integer.valueOf(((Number) entry.getKey()).intValue()), CollectionsKt.toFloatArray((ArrayList) entry.getValue())));
            linkedHashMap3 = linkedHashMap3;
        }
        return new Data(key, arrayList3, new Vector3((fArr2[i14] + fArr[i14]) / 2.0f, (fArr2[1] + fArr[1]) / 2.0f, (fArr2[2] + fArr[2]) / 2.0f), new Vector3(fArr[i14] - fArr2[i14], fArr[1] - fArr2[1], fArr[2] - fArr2[2]), arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x003d, code lost:
    
        if ((com.exampletest.mobilestudiotest.render.UnionMeshes.INSTANCE.bytesOf(r0) != null) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
    
        if (r0 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.exampletest.mobilestudiotest.render.UnionMeshes.Data get(com.exampletest.mobilestudiotest.model.Instance r11) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.render.UnionMeshes.get(com.exampletest.mobilestudiotest.model.Instance):com.exampletest.mobilestudiotest.render.UnionMeshes$Data");
    }

    public final int getEpoch() {
        return epoch;
    }

    public final boolean isStored(Instance p) {
        boolean z;
        Intrinsics.checkNotNullParameter(p, "p");
        if (!p.isA("PartOperation") || Intrinsics.areEqual(p.getClassName(), "NegateOperation")) {
            return false;
        }
        ArrayList<Instance> children = p.getChildren();
        if (!(children instanceof Collection) || !children.isEmpty()) {
            Iterator<T> it = children.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (((Instance) it.next()).isA("BasePart")) {
                    z = false;
                    break;
                }
            }
        } else {
            z = true;
        }
        return z;
    }
}
