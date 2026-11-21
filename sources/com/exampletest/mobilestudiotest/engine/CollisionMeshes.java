package com.exampletest.mobilestudiotest.engine;

import com.exampletest.mobilestudiotest.core.SolidModeling;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.EnumValue;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.PartData;
import com.exampletest.mobilestudiotest.model.Vector3;
import com.exampletest.mobilestudiotest.net.AssetFetcher;
import com.exampletest.mobilestudiotest.render.MeshData;
import com.exampletest.mobilestudiotest.render.MeshLoader;
import com.exampletest.mobilestudiotest.render.UnionMeshes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* compiled from: CollisionMeshes.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u00015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000bJ\u001a\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u0010J>\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0010H\u0002J \u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J4\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020&\u0018\u00010%2\u0006\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001aJ0\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u001aH\u0002J4\u00101\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u001a\u0018\u00010%2\u0006\u0010'\u001a\u00020\f2\u0006\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/CollisionMeshes;", "", "<init>", "()V", "DEFAULT", "", "HULL", "BOX", "PRECISE", "cache", "Ljava/util/WeakHashMap;", "Lcom/exampletest/mobilestudiotest/model/Instance;", "Lcom/exampletest/mobilestudiotest/engine/CollisionMeshes$Mesh;", "fidelity", "p", "hasGeometry", "", "forPart", "forRays", "build", "key", "", "src", "", "", "center", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "scale", "cf", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "hull", "DIRS", "hullOf", "Lcom/exampletest/mobilestudiotest/engine/ConvexShape;", "pos", "count", "push", "Lkotlin/Pair;", "", "m", "shape", "lo", "hi", "overlaps", "s", "a", "b", "c", "n", "ray", "o", "d", "maxDist", "Mesh", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class CollisionMeshes {
    public static final int BOX = 2;
    public static final int DEFAULT = 0;
    private static final List<Vector3> DIRS;
    public static final int HULL = 1;
    public static final int PRECISE = 3;
    public static final CollisionMeshes INSTANCE = new CollisionMeshes();
    private static final WeakHashMap<Instance, Mesh> cache = new WeakHashMap<>();

    /* compiled from: CollisionMeshes.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\bH\u0002J \u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\bH\u0002J0\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\n2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002080<H\u0086\bø\u0001\u0000J\u0016\u0010=\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\bJ\u0006\u0010>\u001a\u00020\bJ\u0016\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u001e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010 \u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u001b\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0#¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u000e\u0010(\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006C"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/CollisionMeshes$Mesh;", "", "key", "", "pos", "", "nrm", "count", "", "min", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "max", "<init>", "(J[F[FILcom/exampletest/mobilestudiotest/model/Vector3;Lcom/exampletest/mobilestudiotest/model/Vector3;)V", "getKey", "()J", "getPos", "()[F", "getNrm", "getCount", "()I", "getMin", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "getMax", "cell", "", "getCell", "()F", "nx", "getNx", "ny", "getNy", "nz", "getNz", "cells", "", "", "getCells", "()[[I", "[[I", "stamp", "stampGen", "hull", "Lcom/exampletest/mobilestudiotest/engine/ConvexShape;", "getHull", "()Lcom/exampletest/mobilestudiotest/engine/ConvexShape;", "setHull", "(Lcom/exampletest/mobilestudiotest/engine/ConvexShape;)V", "ci", "v", "axis", "idx", "i", "j", "k", "forTris", "", "lo", "hi", "f", "Lkotlin/Function1;", "cellIndex", "nextStamp", "mark", "", "t", "g", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Mesh {
        private final float cell;
        private final int[][] cells;
        private final int count;
        private ConvexShape hull;
        private final long key;
        private final Vector3 max;
        private final Vector3 min;
        private final float[] nrm;
        private final int nx;
        private final int ny;
        private final int nz;
        private final float[] pos;
        private final int[] stamp;
        private int stampGen;

        public Mesh(long j, float[] pos, float[] nrm, int i, Vector3 min, Vector3 max) {
            float f;
            float f2;
            float f3;
            Object obj;
            Intrinsics.checkNotNullParameter(pos, "pos");
            Intrinsics.checkNotNullParameter(nrm, "nrm");
            Intrinsics.checkNotNullParameter(min, "min");
            Intrinsics.checkNotNullParameter(max, "max");
            this.key = j;
            this.pos = pos;
            this.nrm = nrm;
            this.count = i;
            this.min = min;
            this.max = max;
            this.stamp = new int[this.count];
            Vector3 minus = this.max.minus(this.min);
            this.cell = RangesKt.coerceAtLeast(Math.max(minus.getX(), Math.max(minus.getY(), minus.getZ())) / 24.0f, 1.0f);
            this.nx = ((int) (minus.getX() / this.cell)) + 1;
            this.ny = ((int) (minus.getY() / this.cell)) + 1;
            this.nz = ((int) (minus.getZ() / this.cell)) + 1;
            HashMap hashMap = new HashMap();
            int i2 = this.count;
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = i3 * 9;
                float min2 = Math.min(this.pos[i4], Math.min(this.pos[i4 + 3], this.pos[i4 + 6]));
                float max2 = Math.max(this.pos[i4], Math.max(this.pos[i4 + 3], this.pos[i4 + 6]));
                float min3 = Math.min(this.pos[i4 + 1], Math.min(this.pos[i4 + 4], this.pos[i4 + 7]));
                float max3 = Math.max(this.pos[i4 + 1], Math.max(this.pos[i4 + 4], this.pos[i4 + 7]));
                float min4 = Math.min(this.pos[i4 + 2], Math.min(this.pos[i4 + 5], this.pos[i4 + 8]));
                float max4 = Math.max(this.pos[i4 + 2], Math.max(this.pos[i4 + 5], this.pos[i4 + 8]));
                int ci = ci(min2, 0);
                int ci2 = ci(max2, 0);
                if (ci <= ci2) {
                    while (true) {
                        float f4 = max2;
                        int ci3 = ci(min3, 1);
                        float f5 = min3;
                        int ci4 = ci(max3, 1);
                        if (ci3 <= ci4) {
                            while (true) {
                                f = max3;
                                int ci5 = ci(min4, 2);
                                int ci6 = ci(max4, 2);
                                if (ci5 <= ci6) {
                                    while (true) {
                                        f2 = min4;
                                        HashMap hashMap2 = hashMap;
                                        Integer valueOf = Integer.valueOf(idx(ci, ci3, ci5));
                                        f3 = max4;
                                        Object obj2 = hashMap2.get(valueOf);
                                        if (obj2 == null) {
                                            obj = new ArrayList();
                                            hashMap2.put(valueOf, obj);
                                        } else {
                                            obj = obj2;
                                        }
                                        ((ArrayList) obj).add(Integer.valueOf(i3));
                                        if (ci5 == ci6) {
                                            break;
                                        }
                                        ci5++;
                                        min4 = f2;
                                        max4 = f3;
                                    }
                                } else {
                                    f2 = min4;
                                    f3 = max4;
                                }
                                if (ci3 == ci4) {
                                    break;
                                }
                                ci3++;
                                max3 = f;
                                min4 = f2;
                                max4 = f3;
                            }
                        } else {
                            f = max3;
                            f2 = min4;
                            f3 = max4;
                        }
                        if (ci != ci2) {
                            ci++;
                            max2 = f4;
                            min3 = f5;
                            max3 = f;
                            min4 = f2;
                            max4 = f3;
                        }
                    }
                }
            }
            this.cells = new int[this.nx * this.ny * this.nz];
            for (Map.Entry entry : hashMap.entrySet()) {
                this.cells[((Number) entry.getKey()).intValue()] = CollectionsKt.toIntArray((ArrayList) entry.getValue());
            }
        }

        private final int ci(float v, int axis) {
            Float valueOf;
            int i;
            Vector3 vector3 = this.min;
            switch (axis) {
                case 0:
                    valueOf = Float.valueOf(vector3.getX());
                    i = this.nx;
                    break;
                case 1:
                    valueOf = Float.valueOf(vector3.getY());
                    i = this.ny;
                    break;
                default:
                    valueOf = Float.valueOf(vector3.getZ());
                    i = this.nz;
                    break;
            }
            return RangesKt.coerceIn((int) ((v - ((Number) TuplesKt.to(valueOf, Integer.valueOf(i)).component1()).floatValue()) / this.cell), 0, ((Number) r0.component2()).intValue() - 1);
        }

        private final int idx(int i, int j, int k) {
            return (((this.ny * i) + j) * this.nz) + k;
        }

        public final int cellIndex(float v, int axis) {
            return ci(v, axis);
        }

        public final void forTris(Vector3 lo, Vector3 hi, Function1<? super Integer, Unit> f) {
            Mesh mesh = this;
            Intrinsics.checkNotNullParameter(lo, "lo");
            Intrinsics.checkNotNullParameter(hi, "hi");
            Intrinsics.checkNotNullParameter(f, "f");
            if (hi.getX() < mesh.getMin().getX() || lo.getX() > mesh.getMax().getX() || hi.getY() < mesh.getMin().getY() || lo.getY() > mesh.getMax().getY() || hi.getZ() < mesh.getMin().getZ() || lo.getZ() > mesh.getMax().getZ()) {
                return;
            }
            int nextStamp = mesh.nextStamp();
            int i = 0;
            int cellIndex = mesh.cellIndex(lo.getX(), 0);
            int cellIndex2 = mesh.cellIndex(hi.getX(), 0);
            if (cellIndex > cellIndex2) {
                return;
            }
            while (true) {
                int cellIndex3 = mesh.cellIndex(lo.getY(), 1);
                int cellIndex4 = mesh.cellIndex(hi.getY(), 1);
                if (cellIndex3 <= cellIndex4) {
                    while (true) {
                        int cellIndex5 = mesh.cellIndex(lo.getZ(), 2);
                        int cellIndex6 = mesh.cellIndex(hi.getZ(), 2);
                        if (cellIndex5 <= cellIndex6) {
                            while (true) {
                                int[] iArr = mesh.getCells()[(((mesh.getNy() * cellIndex) + cellIndex3) * mesh.getNz()) + cellIndex5];
                                if (iArr != null) {
                                    int length = iArr.length;
                                    int i2 = i;
                                    while (i2 < length) {
                                        int i3 = iArr[i2];
                                        if (mesh.mark(i3, nextStamp)) {
                                            f.invoke(Integer.valueOf(i3));
                                        }
                                        i2++;
                                        mesh = this;
                                    }
                                }
                                if (cellIndex5 == cellIndex6) {
                                    break;
                                }
                                cellIndex5++;
                                i = 0;
                                mesh = this;
                            }
                        }
                        if (cellIndex3 == cellIndex4) {
                            break;
                        }
                        cellIndex3++;
                        i = 0;
                        mesh = this;
                    }
                }
                if (cellIndex == cellIndex2) {
                    return;
                }
                cellIndex++;
                i = 0;
                mesh = this;
            }
        }

        public final float getCell() {
            return this.cell;
        }

        public final int[][] getCells() {
            return this.cells;
        }

        public final int getCount() {
            return this.count;
        }

        public final ConvexShape getHull() {
            return this.hull;
        }

        public final long getKey() {
            return this.key;
        }

        public final Vector3 getMax() {
            return this.max;
        }

        public final Vector3 getMin() {
            return this.min;
        }

        public final float[] getNrm() {
            return this.nrm;
        }

        public final int getNx() {
            return this.nx;
        }

        public final int getNy() {
            return this.ny;
        }

        public final int getNz() {
            return this.nz;
        }

        public final float[] getPos() {
            return this.pos;
        }

        public final boolean mark(int t, int g) {
            if (this.stamp[t] == g) {
                return false;
            }
            this.stamp[t] = g;
            return true;
        }

        public final int nextStamp() {
            this.stampGen++;
            if (this.stampGen == Integer.MAX_VALUE) {
                ArraysKt.fill$default(this.stamp, 0, 0, 0, 6, (Object) null);
                this.stampGen = 1;
            }
            return this.stampGen;
        }

        public final void setHull(ConvexShape convexShape) {
            this.hull = convexShape;
        }
    }

    static {
        List listOf = CollectionsKt.listOf((Object[]) new Vector3[]{new Vector3(1.0f, 0.0f, 0.0f), new Vector3(0.0f, 1.0f, 0.0f), new Vector3(0.0f, 0.0f, 1.0f), new Vector3(1.0f, 1.0f, 0.0f), new Vector3(1.0f, -1.0f, 0.0f), new Vector3(1.0f, 0.0f, 1.0f), new Vector3(1.0f, 0.0f, -1.0f), new Vector3(0.0f, 1.0f, 1.0f), new Vector3(0.0f, 1.0f, -1.0f), new Vector3(1.0f, 1.0f, 1.0f), new Vector3(1.0f, 1.0f, -1.0f), new Vector3(1.0f, -1.0f, 1.0f), new Vector3(-1.0f, 1.0f, 1.0f)});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            arrayList.add(((Vector3) it.next()).getUnit());
        }
        DIRS = arrayList;
    }

    private CollisionMeshes() {
    }

    private final Mesh build(long key, List<float[]> src, Vector3 center, Vector3 scale, CFrame cf, boolean hull) {
        Iterator<T> it = src.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((float[]) it.next()).length / 24;
        }
        float[] fArr = new float[i * 9];
        float[] fArr2 = new float[i * 3];
        Vector3 vector3 = new Vector3(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE);
        Vector3 unaryMinus = vector3.unaryMinus();
        int i2 = 0;
        for (float[] fArr3 : src) {
            int i3 = 0;
            while (i3 + 24 <= fArr3.length) {
                Vector3[] vector3Arr = new Vector3[3];
                int i4 = 0;
                for (int i5 = 3; i4 < i5; i5 = 3) {
                    int i6 = (i4 * 8) + i3;
                    vector3Arr[i4] = cf.times(new Vector3((fArr3[i6] - center.getX()) * scale.getX(), (fArr3[i6 + 1] - center.getY()) * scale.getY(), (fArr3[i6 + 2] - center.getZ()) * scale.getZ()));
                    i4++;
                    vector3 = vector3;
                }
                Vector3 vector32 = vector3;
                char c = 2;
                Vector3 cross = vector3Arr[1].minus(vector3Arr[0]).cross(vector3Arr[2].minus(vector3Arr[0]));
                if (cross.dot(cf.vectorToWorld(new Vector3(fArr3[i3 + 3] + fArr3[i3 + 11] + fArr3[i3 + 19], fArr3[i3 + 4] + fArr3[i3 + 12] + fArr3[i3 + 20], fArr3[i3 + 5] + fArr3[i3 + 13] + fArr3[i3 + 21]))) < 0.0f) {
                    cross = cross.unaryMinus();
                }
                float magnitude = cross.getMagnitude();
                i3 += 24;
                if (magnitude >= 1.0E-9f) {
                    Vector3 div = cross.div(magnitude);
                    int i7 = 0;
                    Vector3 vector33 = unaryMinus;
                    Vector3 vector34 = vector32;
                    while (true) {
                        char c2 = c;
                        if (i7 >= 3) {
                            break;
                        }
                        fArr[(i2 * 9) + (i7 * 3)] = vector3Arr[i7].getX();
                        fArr[(i2 * 9) + (i7 * 3) + 1] = vector3Arr[i7].getY();
                        fArr[(i2 * 9) + (i7 * 3) + 2] = vector3Arr[i7].getZ();
                        vector34 = vector34.min(vector3Arr[i7]);
                        vector33 = vector33.max(vector3Arr[i7]);
                        i7++;
                        c = c2;
                    }
                    fArr2[i2 * 3] = div.getX();
                    fArr2[(i2 * 3) + 1] = div.getY();
                    fArr2[(i2 * 3) + 2] = div.getZ();
                    i2++;
                    vector3 = vector34;
                    unaryMinus = vector33;
                } else {
                    vector3 = vector32;
                }
            }
        }
        if (i2 == 0) {
            vector3 = cf.getPosition();
            unaryMinus = cf.getPosition();
        }
        Mesh mesh = new Mesh(key, fArr, fArr2, i2, vector3, unaryMinus);
        if (hull && i2 > 0) {
            mesh.setHull(hullOf(fArr, i2, cf));
        }
        return mesh;
    }

    public static /* synthetic */ Mesh forPart$default(CollisionMeshes collisionMeshes, Instance instance, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return collisionMeshes.forPart(instance, z);
    }

    private static final float forPart$k(float f, float f2) {
        if (f2 > 1.0E-5f) {
            return f / f2;
        }
        return 1.0f;
    }

    private final ConvexShape hullOf(float[] pos, int count, CFrame cf) {
        List<Vector3> list = DIRS;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(cf.vectorToWorld((Vector3) it.next()));
        }
        ArrayList<Vector3> arrayList2 = arrayList;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Vector3 vector3 : arrayList2) {
            float f = Float.MAX_VALUE;
            float f2 = -3.4028235E38f;
            Vector3 zero = Vector3.INSTANCE.getZERO();
            Vector3 zero2 = Vector3.INSTANCE.getZERO();
            int i = count * 3;
            for (int i2 = 0; i2 < i; i2++) {
                Vector3 vector32 = new Vector3(pos[i2 * 3], pos[(i2 * 3) + 1], pos[(i2 * 3) + 2]);
                float dot = vector32.dot(vector3);
                if (dot < f) {
                    f = dot;
                    zero = vector32;
                }
                if (dot > f2) {
                    f2 = dot;
                    zero2 = vector32;
                }
            }
            linkedHashSet.add(zero);
            linkedHashSet.add(zero2);
        }
        return new ConvexShape(CollectionsKt.toList(linkedHashSet), arrayList2, arrayList2);
    }

    private final boolean overlaps(ConvexShape s, Vector3 a, Vector3 b, Vector3 c, Vector3 n) {
        if (overlaps$sep(s, a, b, c, n)) {
            return false;
        }
        Iterator<Vector3> it = s.getNormals().iterator();
        while (it.hasNext()) {
            if (overlaps$sep(s, a, b, c, it.next())) {
                return false;
            }
        }
        Vector3[] vector3Arr = {b.minus(a), c.minus(b), a.minus(c)};
        for (Vector3 vector3 : s.getEdges()) {
            for (Vector3 vector32 : vector3Arr) {
                if (overlaps$sep(s, a, b, c, vector3.cross(vector32))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static final boolean overlaps$sep(ConvexShape convexShape, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34) {
        if (vector34.getMagnitude() < 1.0E-6f) {
            return false;
        }
        Pair<Float, Float> project = convexShape.project(vector34);
        float floatValue = project.component1().floatValue();
        float floatValue2 = project.component2().floatValue();
        float dot = vector3.dot(vector34);
        float dot2 = vector32.dot(vector34);
        float dot3 = vector33.dot(vector34);
        return floatValue2 < Math.min(dot, Math.min(dot2, dot3)) || floatValue > Math.max(dot, Math.max(dot2, dot3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, com.exampletest.mobilestudiotest.model.Vector3] */
    public static final Unit ray$lambda$9(float[] fArr, Vector3 vector3, Vector3 vector32, Ref.FloatRef floatRef, float f, Ref.ObjectRef objectRef, Mesh mesh, int i) {
        int i2 = i * 9;
        float f2 = fArr[i2];
        float f3 = fArr[i2 + 1];
        float f4 = fArr[i2 + 2];
        float f5 = fArr[i2 + 3] - f2;
        float f6 = fArr[i2 + 4] - f3;
        float f7 = fArr[i2 + 5] - f4;
        float f8 = fArr[i2 + 6] - f2;
        float f9 = fArr[i2 + 7] - f3;
        float f10 = fArr[i2 + 8] - f4;
        float y = (vector3.getY() * f10) - (vector3.getZ() * f9);
        float z = (vector3.getZ() * f8) - (vector3.getX() * f10);
        float x = (vector3.getX() * f9) - (vector3.getY() * f8);
        float f11 = (f5 * y) + (f6 * z) + (f7 * x);
        if (Math.abs(f11) > 1.0E-9f) {
            float f12 = 1.0f / f11;
            float x2 = vector32.getX() - f2;
            float y2 = vector32.getY() - f3;
            float z2 = vector32.getZ() - f4;
            float f13 = ((x2 * y) + (y2 * z) + (z2 * x)) * f12;
            boolean z3 = false;
            if (0.0f <= f13 && f13 <= 1.0f) {
                z3 = true;
            }
            if (z3) {
                float f14 = (y2 * f7) - (z2 * f6);
                float f15 = (z2 * f5) - (x2 * f7);
                float f16 = (x2 * f6) - (y2 * f5);
                float x3 = ((vector3.getX() * f14) + (vector3.getY() * f15) + (vector3.getZ() * f16)) * f12;
                if (x3 >= 0.0f && f13 + x3 <= 1.0f) {
                    float f17 = ((f8 * f14) + (f9 * f15) + (f10 * f16)) * f12;
                    if (f17 >= 0.0f) {
                        if (f17 < floatRef.element && f17 <= f) {
                            floatRef.element = f17;
                            objectRef.element = new Vector3(mesh.getNrm()[i * 3], mesh.getNrm()[(i * 3) + 1], mesh.getNrm()[(i * 3) + 2]);
                        }
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    public final int fidelity(Instance p) {
        Intrinsics.checkNotNullParameter(p, "p");
        Object obj = p.get("CollisionFidelity");
        EnumValue enumValue = obj instanceof EnumValue ? (EnumValue) obj : null;
        if (enumValue != null) {
            return enumValue.getValue();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.List] */
    public final Mesh forPart(Instance p, boolean forRays) {
        UnionMeshes.Data data;
        long hashCode;
        ArrayList arrayList;
        Vector3 vector3;
        Vector3 vector32;
        MeshData meshData;
        Intrinsics.checkNotNullParameter(p, "p");
        if (!hasGeometry(p)) {
            return null;
        }
        if (!forRays && fidelity(p) == 2) {
            return null;
        }
        CFrame cframe = PartData.INSTANCE.cframe(p);
        Vector3 size = PartData.INSTANCE.size(p);
        if (Intrinsics.areEqual(p.getClassName(), "MeshPart")) {
            Long idOf = AssetFetcher.INSTANCE.idOf(PartData.INSTANCE.meshContent(p));
            if (idOf == null || (meshData = MeshLoader.INSTANCE.get((hashCode = idOf.longValue()))) == null || meshData.getTriangles() == 0) {
                return null;
            }
            arrayList = CollectionsKt.listOf(meshData.getVerts());
            vector3 = new Vector3(meshData.center(0), meshData.center(1), meshData.center(2));
            vector32 = new Vector3(forPart$k(size.getX(), meshData.size(0)), forPart$k(size.getY(), meshData.size(1)), forPart$k(size.getZ(), meshData.size(2)));
        } else {
            SolidModeling.Result result = SolidModeling.INSTANCE.result(p);
            if (result != null) {
                ?? list = CollectionsKt.toList(result.getTris().values());
                Vector3 zero = Vector3.INSTANCE.getZERO();
                Vector3 scaleOf = SolidModeling.INSTANCE.scaleOf(p, result);
                hashCode = result.getSig();
                arrayList = list;
                vector3 = zero;
                vector32 = scaleOf;
            } else {
                if (!UnionMeshes.INSTANCE.isStored(p) || (data = UnionMeshes.INSTANCE.get(p)) == null) {
                    return null;
                }
                List<Pair<Integer, float[]>> groups = data.getGroups();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(groups, 10));
                Iterator it = groups.iterator();
                while (it.hasNext()) {
                    arrayList2.add((float[]) ((Pair) it.next()).getSecond());
                    result = result;
                }
                Vector3 center = data.getCenter();
                Vector3 vector33 = new Vector3(forPart$k(size.getX(), data.getSize().getX()), forPart$k(size.getY(), data.getSize().getY()), forPart$k(size.getZ(), data.getSize().getZ()));
                hashCode = data.getKey().hashCode();
                arrayList = arrayList2;
                vector3 = center;
                vector32 = vector33;
            }
        }
        long hashCode2 = (((((hashCode * 31) + cframe.hashCode()) * 31) + size.hashCode()) * 31) + fidelity(p);
        synchronized (cache) {
            Mesh mesh = cache.get(p);
            if (mesh != null && mesh.getKey() == hashCode2) {
                return mesh;
            }
            Mesh build = INSTANCE.build(hashCode2, arrayList, vector3, vector32, cframe, INSTANCE.fidelity(p) == 1);
            cache.put(p, build);
            return build;
        }
    }

    public final boolean hasGeometry(Instance p) {
        Intrinsics.checkNotNullParameter(p, "p");
        return (p.isA("PartOperation") && !Intrinsics.areEqual(p.getClassName(), "NegateOperation")) || Intrinsics.areEqual(p.getClassName(), "MeshPart");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x045f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0460  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.Pair<com.exampletest.mobilestudiotest.model.Vector3, java.lang.Float> push(com.exampletest.mobilestudiotest.engine.CollisionMeshes.Mesh r40, com.exampletest.mobilestudiotest.engine.ConvexShape r41, com.exampletest.mobilestudiotest.model.Vector3 r42, com.exampletest.mobilestudiotest.model.Vector3 r43) {
        /*
            Method dump skipped, instructions count: 1130
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.engine.CollisionMeshes.push(com.exampletest.mobilestudiotest.engine.CollisionMeshes$Mesh, com.exampletest.mobilestudiotest.engine.ConvexShape, com.exampletest.mobilestudiotest.model.Vector3, com.exampletest.mobilestudiotest.model.Vector3):kotlin.Pair");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Pair<Float, Vector3> ray(Mesh m, Vector3 o, Vector3 d, float maxDist) {
        Pair<Float, Vector3> pair;
        Mesh mesh;
        Vector3 vector3;
        Vector3 vector32;
        Vector3 vector33;
        Mesh mesh2;
        Intrinsics.checkNotNullParameter(m, "m");
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(d, "d");
        Vector3 plus = o.plus(d.times(RangesKt.coerceAtMost(maxDist, 100000.0f)));
        Vector3 max = o.min(plus).max(m.getMin());
        Vector3 min = o.max(plus).min(m.getMax());
        if (max.getX() > min.getX() || max.getY() > min.getY()) {
            return null;
        }
        if (max.getZ() > min.getZ()) {
            return null;
        }
        Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = Float.MAX_VALUE;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        float[] pos = m.getPos();
        CollisionMeshes$$ExternalSyntheticLambda0 collisionMeshes$$ExternalSyntheticLambda0 = new CollisionMeshes$$ExternalSyntheticLambda0(pos, d, o, floatRef, maxDist, objectRef, m);
        if (min.minus(max).getMagnitude() > m.getCell() * 12.0f) {
            int count = m.getCount();
            for (int i = 0; i < count; i++) {
                collisionMeshes$$ExternalSyntheticLambda0.invoke(Integer.valueOf(i));
            }
            pair = null;
        } else {
            Vector3 vector34 = min;
            Mesh mesh3 = m;
            Vector3 vector35 = max;
            if (vector34.getX() < mesh3.getMin().getX() || vector35.getX() > mesh3.getMax().getX() || vector34.getY() < mesh3.getMin().getY() || vector35.getY() > mesh3.getMax().getY() || vector34.getZ() < mesh3.getMin().getZ()) {
                pair = null;
            } else if (vector35.getZ() > mesh3.getMax().getZ()) {
                pair = null;
            } else {
                int nextStamp = mesh3.nextStamp();
                int cellIndex = mesh3.cellIndex(vector35.getX(), 0);
                pair = null;
                int cellIndex2 = mesh3.cellIndex(vector34.getX(), 0);
                if (cellIndex <= cellIndex2) {
                    while (true) {
                        float[] fArr = pos;
                        int cellIndex3 = mesh3.cellIndex(vector35.getY(), 1);
                        Vector3 vector36 = vector34;
                        int cellIndex4 = mesh3.cellIndex(vector36.getY(), 1);
                        if (cellIndex3 <= cellIndex4) {
                            while (true) {
                                vector3 = vector35;
                                int cellIndex5 = mesh3.cellIndex(vector35.getZ(), 2);
                                vector32 = plus;
                                int cellIndex6 = mesh3.cellIndex(vector36.getZ(), 2);
                                if (cellIndex5 <= cellIndex6) {
                                    while (true) {
                                        int[] iArr = mesh3.getCells()[(((mesh3.getNy() * cellIndex) + cellIndex3) * mesh3.getNz()) + cellIndex5];
                                        if (iArr == null) {
                                            mesh = mesh3;
                                            vector33 = max;
                                        } else {
                                            vector33 = max;
                                            int length = iArr.length;
                                            int i2 = 0;
                                            while (i2 < length) {
                                                int i3 = i2;
                                                int i4 = iArr[i3];
                                                if (mesh3.mark(i4, nextStamp)) {
                                                    mesh2 = mesh3;
                                                    collisionMeshes$$ExternalSyntheticLambda0.invoke(Integer.valueOf(i4));
                                                } else {
                                                    mesh2 = mesh3;
                                                }
                                                i2 = i3 + 1;
                                                mesh3 = mesh2;
                                            }
                                            mesh = mesh3;
                                        }
                                        if (cellIndex5 == cellIndex6) {
                                            break;
                                        }
                                        cellIndex5++;
                                        max = vector33;
                                        mesh3 = mesh;
                                    }
                                } else {
                                    mesh = mesh3;
                                    vector33 = max;
                                }
                                if (cellIndex3 == cellIndex4) {
                                    break;
                                }
                                cellIndex3++;
                                vector35 = vector3;
                                plus = vector32;
                                max = vector33;
                                mesh3 = mesh;
                            }
                        } else {
                            mesh = mesh3;
                            vector3 = vector35;
                            vector32 = plus;
                            vector33 = max;
                        }
                        if (cellIndex == cellIndex2) {
                            break;
                        }
                        cellIndex++;
                        pos = fArr;
                        vector34 = vector36;
                        vector35 = vector3;
                        plus = vector32;
                        max = vector33;
                        mesh3 = mesh;
                    }
                }
            }
        }
        Vector3 vector37 = (Vector3) objectRef.element;
        if (vector37 == null) {
            return pair;
        }
        return TuplesKt.to(Float.valueOf(floatRef.element), vector37.dot(d) > 0.0f ? vector37.unaryMinus() : vector37);
    }
}
