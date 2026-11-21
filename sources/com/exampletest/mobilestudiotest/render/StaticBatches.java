package com.exampletest.mobilestudiotest.render;

import android.opengl.GLES20;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.PartData;
import com.exampletest.mobilestudiotest.model.Vector3;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: StaticBatches.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 W2\u00020\u0001:\u0007QRSTUVWB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0002J\u0016\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020#J \u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020#H\u0002J^\u0010+\u001a\u00020\u001e2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0-2\u0006\u0010.\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u0010&\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u0001002\u0006\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\bJ\u0018\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020\tH\u0002J \u0010=\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u001aH\u0002J(\u0010D\u001a\u00020\u001a2\u0006\u0010E\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020\u001aH\u0002J\u0010\u0010H\u001a\u00020\u001a2\u0006\u0010I\u001a\u00020#H\u0002J\u0010\u0010J\u001a\u00020\u001a2\u0006\u0010I\u001a\u00020#H\u0002J \u0010K\u001a\u00020\u001a2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020@2\u0006\u0010O\u001a\u00020\u001aH\u0002J \u0010P\u001a\u00020\u001a2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020@2\u0006\u0010O\u001a\u00020\u001aH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000ej\b\u0012\u0004\u0012\u00020\t`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/StaticBatches;", "", "host", "Lcom/exampletest/mobilestudiotest/render/StaticBatches$Host;", "<init>", "(Lcom/exampletest/mobilestudiotest/render/StaticBatches$Host;)V", "chunks", "Ljava/util/HashMap;", "", "Lcom/exampletest/mobilestudiotest/render/StaticBatches$Chunk;", "Lkotlin/collections/HashMap;", "getChunks", "()Ljava/util/HashMap;", "loose", "Ljava/util/ArrayList;", "Lcom/exampletest/mobilestudiotest/model/Instance;", "Lkotlin/collections/ArrayList;", "getLoose", "()Ljava/util/ArrayList;", "visible", "getVisible", "value", "totalBytes", "getTotalBytes", "()J", "gen", "", "lastListVersion", TypedValues.AttributesType.S_FRAME, "reset", "", "deleteBuffers", "", "tierOf", "r", "", "tierRange", "tier", "detail", "keyOf", "x", "y", "z", "update", "parts", "", "listVersion", "cam", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "fr", "Lcom/exampletest/mobilestudiotest/render/Frustum;", "shadowAt", "shadowR", "budgetNs", "maxBytes", "join", "p", "rec", "Lcom/exampletest/mobilestudiotest/render/StaticBatches$PartRec;", "free", "c", "build", "texEpoch", "scratch", "", "direct", "Ljava/nio/ByteBuffer;", "little", "b4", "a", "b", "d", "sb", "v", "ub", "pack", "s", "Lcom/exampletest/mobilestudiotest/render/BatchSpec;", "out", "start", "packMesh", "Host", "PartRec", "Batch", "Chunk", "Group", "GroupKey", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class StaticBatches {
    public static final float CELL = 64.0f;
    public static final int COOL = 45;
    public static final int MESH_STRIDE_BYTES = 28;
    public static final int MESH_STRIDE_INTS = 7;
    public static final int STRIDE_BYTES = 40;
    public static final int STRIDE_INTS = 10;
    public static final int UNLOAD_FRAMES = 900;
    private final HashMap<Long, Chunk> chunks;
    private ByteBuffer direct;
    private int frame;
    private int gen;
    private final Host host;
    private int lastListVersion;
    private final boolean little;
    private final ArrayList<Instance> loose;
    private int[] scratch;
    private long totalBytes;
    private final ArrayList<Chunk> visible;

    /* compiled from: StaticBatches.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/StaticBatches$Batch;", "", "vbo", "", "count", "tier", "kind", "tex", "Lcom/exampletest/mobilestudiotest/render/TexBind;", "bytes", "<init>", "(IIIILcom/exampletest/mobilestudiotest/render/TexBind;I)V", "getVbo", "()I", "getCount", "getTier", "getKind", "getTex", "()Lcom/exampletest/mobilestudiotest/render/TexBind;", "getBytes", "strideBytes", "getStrideBytes", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Batch {
        private final int bytes;
        private final int count;
        private final int kind;
        private final TexBind tex;
        private final int tier;
        private final int vbo;

        public Batch(int i, int i2, int i3, int i4, TexBind texBind, int i5) {
            this.vbo = i;
            this.count = i2;
            this.tier = i3;
            this.kind = i4;
            this.tex = texBind;
            this.bytes = i5;
        }

        public final int getBytes() {
            return this.bytes;
        }

        public final int getCount() {
            return this.count;
        }

        public final int getKind() {
            return this.kind;
        }

        public final int getStrideBytes() {
            return this.kind == 3 ? 28 : 40;
        }

        public final TexBind getTex() {
            return this.tex;
        }

        public final int getTier() {
            return this.tier;
        }

        public final int getVbo() {
            return this.vbo;
        }
    }

    /* compiled from: StaticBatches.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020!2\u0006\u0010M\u001a\u00020!2\u0006\u0010N\u001a\u00020!2\u0006\u0010O\u001a\u00020!J\u000e\u0010P\u001a\u00020!2\u0006\u0010Q\u001a\u00020RR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001a\u0010)\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001a\u0010,\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%R\u001a\u0010/\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R\u001a\u00102\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R\u001a\u0010>\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0013\"\u0004\b@\u0010\u0015R\u001a\u0010A\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00108\"\u0004\bC\u0010:R\u001a\u0010D\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010#\"\u0004\bF\u0010%R\u001a\u0010G\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0007\"\u0004\bI\u0010\u0005¨\u0006S"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/StaticBatches$Chunk;", "", "key", "", "<init>", "(J)V", "getKey", "()J", "parts", "Ljava/util/ArrayList;", "Lcom/exampletest/mobilestudiotest/model/Instance;", "Lkotlin/collections/ArrayList;", "getParts", "()Ljava/util/ArrayList;", "setParts", "(Ljava/util/ArrayList;)V", "dirty", "", "getDirty", "()Z", "setDirty", "(Z)V", "built", "getBuilt", "setBuilt", "batches", "", "Lcom/exampletest/mobilestudiotest/render/StaticBatches$Batch;", "getBatches", "()Ljava/util/List;", "setBatches", "(Ljava/util/List;)V", "x0", "", "getX0", "()F", "setX0", "(F)V", "y0", "getY0", "setY0", "z0", "getZ0", "setZ0", "x1", "getX1", "setX1", "y1", "getY1", "setY1", "z1", "getZ1", "setZ1", "maxTier", "", "getMaxTier", "()I", "setMaxTier", "(I)V", "texEpoch", "getTexEpoch", "setTexEpoch", "pendingTex", "getPendingTex", "setPendingTex", "lastInRange", "getLastInRange", "setLastInRange", "dist", "getDist", "setDist", "bytes", "getBytes", "setBytes", "grow", "", "cx", "cy", "cz", "r", "distTo", "p", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Chunk {
        private boolean built;
        private long bytes;
        private float dist;
        private final long key;
        private int lastInRange;
        private int maxTier;
        private boolean pendingTex;
        private ArrayList<Instance> parts = new ArrayList<>();
        private boolean dirty = true;
        private List<Batch> batches = CollectionsKt.emptyList();
        private float x0 = Float.MAX_VALUE;
        private float y0 = Float.MAX_VALUE;
        private float z0 = Float.MAX_VALUE;
        private float x1 = -3.4028235E38f;
        private float y1 = -3.4028235E38f;
        private float z1 = -3.4028235E38f;
        private int texEpoch = -1;

        public Chunk(long j) {
            this.key = j;
        }

        public final float distTo(Vector3 p) {
            Intrinsics.checkNotNullParameter(p, "p");
            float max = Math.max(Math.max(this.x0 - p.getX(), 0.0f), p.getX() - this.x1);
            float max2 = Math.max(Math.max(this.y0 - p.getY(), 0.0f), p.getY() - this.y1);
            float max3 = Math.max(Math.max(this.z0 - p.getZ(), 0.0f), p.getZ() - this.z1);
            return (float) Math.sqrt((max * max) + (max2 * max2) + (max3 * max3));
        }

        public final List<Batch> getBatches() {
            return this.batches;
        }

        public final boolean getBuilt() {
            return this.built;
        }

        public final long getBytes() {
            return this.bytes;
        }

        public final boolean getDirty() {
            return this.dirty;
        }

        public final float getDist() {
            return this.dist;
        }

        public final long getKey() {
            return this.key;
        }

        public final int getLastInRange() {
            return this.lastInRange;
        }

        public final int getMaxTier() {
            return this.maxTier;
        }

        public final ArrayList<Instance> getParts() {
            return this.parts;
        }

        public final boolean getPendingTex() {
            return this.pendingTex;
        }

        public final int getTexEpoch() {
            return this.texEpoch;
        }

        public final float getX0() {
            return this.x0;
        }

        public final float getX1() {
            return this.x1;
        }

        public final float getY0() {
            return this.y0;
        }

        public final float getY1() {
            return this.y1;
        }

        public final float getZ0() {
            return this.z0;
        }

        public final float getZ1() {
            return this.z1;
        }

        public final void grow(float cx, float cy, float cz, float r) {
            this.x0 = Math.min(this.x0, cx - r);
            this.y0 = Math.min(this.y0, cy - r);
            this.z0 = Math.min(this.z0, cz - r);
            this.x1 = Math.max(this.x1, cx + r);
            this.y1 = Math.max(this.y1, cy + r);
            this.z1 = Math.max(this.z1, cz + r);
        }

        public final void setBatches(List<Batch> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.batches = list;
        }

        public final void setBuilt(boolean z) {
            this.built = z;
        }

        public final void setBytes(long j) {
            this.bytes = j;
        }

        public final void setDirty(boolean z) {
            this.dirty = z;
        }

        public final void setDist(float f) {
            this.dist = f;
        }

        public final void setLastInRange(int i) {
            this.lastInRange = i;
        }

        public final void setMaxTier(int i) {
            this.maxTier = i;
        }

        public final void setParts(ArrayList<Instance> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.parts = arrayList;
        }

        public final void setPendingTex(boolean z) {
            this.pendingTex = z;
        }

        public final void setTexEpoch(int i) {
            this.texEpoch = i;
        }

        public final void setX0(float f) {
            this.x0 = f;
        }

        public final void setX1(float f) {
            this.x1 = f;
        }

        public final void setY0(float f) {
            this.y0 = f;
        }

        public final void setY1(float f) {
            this.y1 = f;
        }

        public final void setZ0(float f) {
            this.z0 = f;
        }

        public final void setZ1(float f) {
            this.z1 = f;
        }
    }

    /* compiled from: StaticBatches.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/StaticBatches$Group;", "", "tier", "", "kind", "tex", "Lcom/exampletest/mobilestudiotest/render/TexBind;", "<init>", "(IILcom/exampletest/mobilestudiotest/render/TexBind;)V", "getTier", "()I", "getKind", "getTex", "()Lcom/exampletest/mobilestudiotest/render/TexBind;", "specs", "Ljava/util/ArrayList;", "Lcom/exampletest/mobilestudiotest/render/BatchSpec;", "Lkotlin/collections/ArrayList;", "getSpecs", "()Ljava/util/ArrayList;", "verts", "getVerts", "setVerts", "(I)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    private static final class Group {
        private final int kind;
        private final ArrayList<BatchSpec> specs = new ArrayList<>();
        private final TexBind tex;
        private final int tier;
        private int verts;

        public Group(int i, int i2, TexBind texBind) {
            this.tier = i;
            this.kind = i2;
            this.tex = texBind;
        }

        public final int getKind() {
            return this.kind;
        }

        public final ArrayList<BatchSpec> getSpecs() {
            return this.specs;
        }

        public final TexBind getTex() {
            return this.tex;
        }

        public final int getTier() {
            return this.tier;
        }

        public final int getVerts() {
            return this.verts;
        }

        public final void setVerts(int i) {
            this.verts = i;
        }
    }

    /* compiled from: StaticBatches.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/StaticBatches$GroupKey;", "", "tier", "", "kind", "tex", "Lcom/exampletest/mobilestudiotest/render/TexBind;", "<init>", "(IILcom/exampletest/mobilestudiotest/render/TexBind;)V", "getTier", "()I", "getKind", "getTex", "()Lcom/exampletest/mobilestudiotest/render/TexBind;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    private static final /* data */ class GroupKey {
        private final int kind;
        private final TexBind tex;
        private final int tier;

        public GroupKey(int i, int i2, TexBind texBind) {
            this.tier = i;
            this.kind = i2;
            this.tex = texBind;
        }

        public static /* synthetic */ GroupKey copy$default(GroupKey groupKey, int i, int i2, TexBind texBind, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = groupKey.tier;
            }
            if ((i3 & 2) != 0) {
                i2 = groupKey.kind;
            }
            if ((i3 & 4) != 0) {
                texBind = groupKey.tex;
            }
            return groupKey.copy(i, i2, texBind);
        }

        /* renamed from: component1, reason: from getter */
        public final int getTier() {
            return this.tier;
        }

        /* renamed from: component2, reason: from getter */
        public final int getKind() {
            return this.kind;
        }

        /* renamed from: component3, reason: from getter */
        public final TexBind getTex() {
            return this.tex;
        }

        public final GroupKey copy(int tier, int kind, TexBind tex) {
            return new GroupKey(tier, kind, tex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GroupKey)) {
                return false;
            }
            GroupKey groupKey = (GroupKey) other;
            return this.tier == groupKey.tier && this.kind == groupKey.kind && Intrinsics.areEqual(this.tex, groupKey.tex);
        }

        public final int getKind() {
            return this.kind;
        }

        public final TexBind getTex() {
            return this.tex;
        }

        public final int getTier() {
            return this.tier;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.tier) * 31) + Integer.hashCode(this.kind)) * 31) + (this.tex == null ? 0 : this.tex.hashCode());
        }

        public String toString() {
            return "GroupKey(tier=" + this.tier + ", kind=" + this.kind + ", tex=" + this.tex + ")";
        }
    }

    /* compiled from: StaticBatches.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\nH&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/StaticBatches$Host;", "", "batchable", "", "p", "Lcom/exampletest/mobilestudiotest/model/Instance;", "spec", "", "Lcom/exampletest/mobilestudiotest/render/BatchSpec;", "loadSignature", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public interface Host {
        boolean batchable(Instance p);

        int loadSignature();

        List<BatchSpec> spec(Instance p);
    }

    /* compiled from: StaticBatches.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\u0005R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\u0005R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\u0005R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c¨\u0006 "}, d2 = {"Lcom/exampletest/mobilestudiotest/render/StaticBatches$PartRec;", "", "gen", "", "<init>", "(I)V", "getGen", "()I", "ver", "getVer", "setVer", "changedFrame", "getChangedFrame", "setChangedFrame", "seen", "getSeen", "setSeen", "chunk", "Lcom/exampletest/mobilestudiotest/render/StaticBatches$Chunk;", "getChunk", "()Lcom/exampletest/mobilestudiotest/render/StaticBatches$Chunk;", "setChunk", "(Lcom/exampletest/mobilestudiotest/render/StaticBatches$Chunk;)V", "known", "", "getKnown", "()Z", "setKnown", "(Z)V", "batchable", "getBatchable", "setBatchable", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class PartRec {
        private boolean batchable;
        private int changedFrame = -1073741824;
        private Chunk chunk;
        private final int gen;
        private boolean known;
        private int seen;
        private int ver;

        public PartRec(int i) {
            this.gen = i;
        }

        public final boolean getBatchable() {
            return this.batchable;
        }

        public final int getChangedFrame() {
            return this.changedFrame;
        }

        public final Chunk getChunk() {
            return this.chunk;
        }

        public final int getGen() {
            return this.gen;
        }

        public final boolean getKnown() {
            return this.known;
        }

        public final int getSeen() {
            return this.seen;
        }

        public final int getVer() {
            return this.ver;
        }

        public final void setBatchable(boolean z) {
            this.batchable = z;
        }

        public final void setChangedFrame(int i) {
            this.changedFrame = i;
        }

        public final void setChunk(Chunk chunk) {
            this.chunk = chunk;
        }

        public final void setKnown(boolean z) {
            this.known = z;
        }

        public final void setSeen(int i) {
            this.seen = i;
        }

        public final void setVer(int i) {
            this.ver = i;
        }
    }

    public StaticBatches(Host host) {
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
        this.chunks = new HashMap<>();
        this.loose = new ArrayList<>();
        this.visible = new ArrayList<>();
        this.gen = 1;
        this.lastListVersion = -1;
        this.scratch = new int[92160];
        this.little = Intrinsics.areEqual(ByteOrder.nativeOrder(), ByteOrder.LITTLE_ENDIAN);
    }

    private final int b4(int a, int b, int c, int d) {
        return this.little ? (a & 255) | ((b & 255) << 8) | ((c & 255) << 16) | ((d & 255) << 24) : ((a & 255) << 24) | ((b & 255) << 16) | ((c & 255) << 8) | (d & 255);
    }

    /* JADX WARN: Code restructure failed: missing block: B:96:0x0239, code lost:
    
        if (r12.capacity() >= r9) goto L73;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v1, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void build(com.exampletest.mobilestudiotest.render.StaticBatches.Chunk r32, int r33, int r34) {
        /*
            Method dump skipped, instructions count: 768
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.render.StaticBatches.build(com.exampletest.mobilestudiotest.render.StaticBatches$Chunk, int, int):void");
    }

    private final void free(Chunk c) {
        if (!c.getBatches().isEmpty()) {
            int size = c.getBatches().size();
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                iArr[i] = c.getBatches().get(i).getVbo();
            }
            GLES20.glDeleteBuffers(iArr.length, iArr, 0);
        }
        this.totalBytes -= c.getBytes();
        c.setBytes(0L);
        c.setBatches(CollectionsKt.emptyList());
        c.setBuilt(false);
    }

    private final void join(Instance p, PartRec rec) {
        Chunk chunk;
        CFrame cframe = PartData.INSTANCE.cframe(p);
        float magnitude = PartData.INSTANCE.size(p).getMagnitude() * 0.5f;
        HashMap<Long, Chunk> hashMap = this.chunks;
        Long valueOf = Long.valueOf(keyOf(cframe.getX(), cframe.getY(), cframe.getZ()));
        Chunk chunk2 = hashMap.get(valueOf);
        if (chunk2 == null) {
            chunk = new Chunk(keyOf(cframe.getX(), cframe.getY(), cframe.getZ()));
            hashMap.put(valueOf, chunk);
        } else {
            chunk = chunk2;
        }
        Chunk chunk3 = chunk;
        chunk3.getParts().add(p);
        chunk3.grow(cframe.getX(), cframe.getY(), cframe.getZ(), magnitude);
        chunk3.setMaxTier(Math.max(chunk3.getMaxTier(), tierOf(magnitude)));
        chunk3.setDirty(true);
        rec.setChunk(chunk3);
    }

    private final long keyOf(float x, float y, float z) {
        return ((((float) Math.floor(x / 64.0f)) & 2097151) << 42) | ((((float) Math.floor(y / 64.0f)) & 2097151) << 21) | (((float) Math.floor(z / 64.0f)) & 2097151);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0287  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int pack(com.exampletest.mobilestudiotest.render.BatchSpec r65, int[] r66, int r67) {
        /*
            Method dump skipped, instructions count: 1018
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.render.StaticBatches.pack(com.exampletest.mobilestudiotest.render.BatchSpec, int[], int):int");
    }

    private final int packMesh(BatchSpec s, int[] out, int start) {
        int i = start;
        CFrame cf = s.getCf();
        float x = s.getScale().getX();
        float y = s.getScale().getY();
        float z = s.getScale().getZ();
        float f = !((x > 0.0f ? 1 : (x == 0.0f ? 0 : -1)) == 0) ? 1.0f / x : 0.0f;
        float f2 = !((y > 0.0f ? 1 : (y == 0.0f ? 0 : -1)) == 0) ? 1.0f / y : 0.0f;
        float f3 = !(z == 0.0f) ? 1.0f / z : 0.0f;
        int b4 = b4(ub(s.getR()), ub(s.getG()), ub(s.getB()), s.getEmissive() ? 255 : 0);
        float[] mesh = s.getMesh();
        int stride = s.getStride();
        float x2 = s.getOffset().getX();
        float y2 = s.getOffset().getY();
        float z2 = s.getOffset().getZ();
        int i2 = 0;
        while (i2 + stride <= mesh.length) {
            float f4 = (mesh[i2] - x2) * x;
            float f5 = (mesh[i2 + 1] - y2) * y;
            float f6 = (mesh[i2 + 2] - z2) * z;
            out[i] = Float.floatToRawIntBits((cf.getR00() * f4) + (cf.getR01() * f5) + (cf.getR02() * f6) + cf.getX());
            out[i + 1] = Float.floatToRawIntBits((cf.getR10() * f4) + (cf.getR11() * f5) + (cf.getR12() * f6) + cf.getY());
            out[i + 2] = Float.floatToRawIntBits((cf.getR20() * f4) + (cf.getR21() * f5) + (cf.getR22() * f6) + cf.getZ());
            int i3 = i;
            out[i + 3] = Float.floatToRawIntBits(stride >= 8 ? mesh[i2 + 6] : 0.0f);
            out[i3 + 4] = Float.floatToRawIntBits(stride >= 8 ? mesh[i2 + 7] : 0.0f);
            float f7 = mesh[i2 + 3] * f;
            float f8 = mesh[i2 + 4] * f2;
            float f9 = mesh[i2 + 5] * f3;
            float r00 = (cf.getR00() * f7) + (cf.getR01() * f8) + (cf.getR02() * f9);
            float r10 = (cf.getR10() * f7) + (cf.getR11() * f8) + (cf.getR12() * f9);
            float r20 = (cf.getR20() * f7) + (cf.getR21() * f8) + (cf.getR22() * f9);
            float coerceAtLeast = RangesKt.coerceAtLeast((float) Math.sqrt((r00 * r00) + (r10 * r10) + (r20 * r20)), 1.0E-9f);
            out[i3 + 5] = b4(sb(r00 / coerceAtLeast), sb(r10 / coerceAtLeast), sb(r20 / coerceAtLeast), 0);
            out[i3 + 6] = b4;
            i = i3 + 7;
            i2 += stride;
            x = x;
            cf = cf;
            y = y;
        }
        return i;
    }

    private final int sb(float v) {
        float coerceIn = RangesKt.coerceIn(v, -1.0f, 1.0f) * 127.0f;
        return coerceIn >= 0.0f ? (int) (0.5f + coerceIn) : (int) (coerceIn - 0.5f);
    }

    private final int tierOf(float r) {
        if (r < 1.2f) {
            return 0;
        }
        return r < 5.0f ? 1 : 2;
    }

    private final int ub(float v) {
        return (int) ((RangesKt.coerceIn(v, 0.0f, 1.0f) * 255.0f) + 0.5f);
    }

    public final HashMap<Long, Chunk> getChunks() {
        return this.chunks;
    }

    public final ArrayList<Instance> getLoose() {
        return this.loose;
    }

    public final long getTotalBytes() {
        return this.totalBytes;
    }

    public final ArrayList<Chunk> getVisible() {
        return this.visible;
    }

    public final void reset(boolean deleteBuffers) {
        if (deleteBuffers) {
            for (Chunk chunk : this.chunks.values()) {
                Intrinsics.checkNotNullExpressionValue(chunk, "next(...)");
                free(chunk);
            }
        }
        this.chunks.clear();
        this.visible.clear();
        this.loose.clear();
        this.totalBytes = 0L;
        this.gen++;
    }

    public final float tierRange(int tier, float detail) {
        float f;
        float f2;
        switch (tier) {
            case 0:
                f = 1.2f * detail;
                f2 = 150.0f;
                break;
            case 1:
                f = 5.0f * detail;
                f2 = 900.0f;
                break;
            default:
                return Float.MAX_VALUE;
        }
        return Math.max(f, f2);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0201  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void update(java.util.List<? extends com.exampletest.mobilestudiotest.model.Instance> r24, int r25, int r26, com.exampletest.mobilestudiotest.model.Vector3 r27, com.exampletest.mobilestudiotest.render.Frustum r28, float r29, com.exampletest.mobilestudiotest.model.Vector3 r30, float r31, long r32, long r34) {
        /*
            Method dump skipped, instructions count: 912
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.render.StaticBatches.update(java.util.List, int, int, com.exampletest.mobilestudiotest.model.Vector3, com.exampletest.mobilestudiotest.render.Frustum, float, com.exampletest.mobilestudiotest.model.Vector3, float, long, long):void");
    }
}
