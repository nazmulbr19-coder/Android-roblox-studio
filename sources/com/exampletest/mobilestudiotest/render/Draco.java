package com.exampletest.mobilestudiotest.render;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: Draco.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\t456789:;<B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0005H\u0002J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0002J\u0018\u0010'\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0005H\u0002J \u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010,\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010-\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u001a\u0010.\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010/\u001a\u00020\u0005H\u0002J\"\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u00103\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/exampletest/mobilestudiotest/render/Draco;", "", "<init>", "()V", "POSITION", "", "NORMAL", "COLOR", "TEX_COORD", "GENERIC", "isDraco", "", "b", "", DebugKt.DEBUG_PROPERTY_VALUE_OFF, "precisionFor", "bits", "createSymbolDecoder", "Lcom/exampletest/mobilestudiotest/render/Draco$SymbolDecoder;", "r", "Lcom/exampletest/mobilestudiotest/render/Draco$Reader;", "uniqueSymbolBits", "decodeSymbols", "", "n", "comps", "rotationCount", "x", "y", "rotate", "", "p", "count", "KIND_GENERIC", "KIND_INTEGER", "KIND_QUANTIZED", "KIND_NORMALS", "typeLength", "dt", "readTyped", "", "decodePortable", "d", "Lcom/exampletest/mobilestudiotest/render/Draco$AttDecoder;", "decodeTransformData", "finish", "skipMetadata", "depth", "decode", "Lcom/exampletest/mobilestudiotest/render/Draco$Mesh;", "bytes", "len", "DracoException", "Attribute", "Mesh", "Reader", "BitReader", "RAns", "SymbolDecoder", "Octa", "AttDecoder", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class Draco {
    public static final int COLOR = 2;
    public static final int GENERIC = 4;
    public static final Draco INSTANCE = new Draco();
    private static final int KIND_GENERIC = 0;
    private static final int KIND_INTEGER = 1;
    private static final int KIND_NORMALS = 3;
    private static final int KIND_QUANTIZED = 2;
    public static final int NORMAL = 1;
    public static final int POSITION = 0;
    public static final int TEX_COORD = 3;

    /* compiled from: Draco.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000b\"\u0004\b$\u0010!¨\u0006%"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/Draco$AttDecoder;", "", "att", "Lcom/exampletest/mobilestudiotest/render/Draco$Attribute;", "kind", "", "<init>", "(Lcom/exampletest/mobilestudiotest/render/Draco$Attribute;I)V", "getAtt", "()Lcom/exampletest/mobilestudiotest/render/Draco$Attribute;", "getKind", "()I", "portable", "", "getPortable", "()[I", "setPortable", "([I)V", "minValues", "", "getMinValues", "()[F", "setMinValues", "([F)V", "range", "", "getRange", "()F", "setRange", "(F)V", "qBits", "getQBits", "setQBits", "(I)V", "octBits", "getOctBits", "setOctBits", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    private static final class AttDecoder {
        private final Attribute att;
        private final int kind;
        private float[] minValues;
        private int octBits;
        private int[] portable;
        private int qBits;
        private float range;

        public AttDecoder(Attribute att, int i) {
            Intrinsics.checkNotNullParameter(att, "att");
            this.att = att;
            this.kind = i;
            this.portable = new int[0];
            this.minValues = new float[0];
        }

        public final Attribute getAtt() {
            return this.att;
        }

        public final int getKind() {
            return this.kind;
        }

        public final float[] getMinValues() {
            return this.minValues;
        }

        public final int getOctBits() {
            return this.octBits;
        }

        public final int[] getPortable() {
            return this.portable;
        }

        public final int getQBits() {
            return this.qBits;
        }

        public final float getRange() {
            return this.range;
        }

        public final void setMinValues(float[] fArr) {
            Intrinsics.checkNotNullParameter(fArr, "<set-?>");
            this.minValues = fArr;
        }

        public final void setOctBits(int i) {
            this.octBits = i;
        }

        public final void setPortable(int[] iArr) {
            Intrinsics.checkNotNullParameter(iArr, "<set-?>");
            this.portable = iArr;
        }

        public final void setQBits(int i) {
            this.qBits = i;
        }

        public final void setRange(float f) {
            this.range = f;
        }
    }

    /* compiled from: Draco.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/Draco$Attribute;", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "", "dataType", "components", "normalized", "", "uniqueId", "", "<init>", "(IIIZJ)V", "getType", "()I", "getDataType", "getComponents", "getNormalized", "()Z", "getUniqueId", "()J", "values", "", "getValues", "()[F", "setValues", "([F)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Attribute {
        private final int components;
        private final int dataType;
        private final boolean normalized;
        private final int type;
        private final long uniqueId;
        private float[] values = new float[0];

        public Attribute(int i, int i2, int i3, boolean z, long j) {
            this.type = i;
            this.dataType = i2;
            this.components = i3;
            this.normalized = z;
            this.uniqueId = j;
        }

        public final int getComponents() {
            return this.components;
        }

        public final int getDataType() {
            return this.dataType;
        }

        public final boolean getNormalized() {
            return this.normalized;
        }

        public final int getType() {
            return this.type;
        }

        public final long getUniqueId() {
            return this.uniqueId;
        }

        public final float[] getValues() {
            return this.values;
        }

        public final void setValues(float[] fArr) {
            Intrinsics.checkNotNullParameter(fArr, "<set-?>");
            this.values = fArr;
        }
    }

    /* compiled from: Draco.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/Draco$BitReader;", "", "b", "", "start", "", "end", "<init>", "([BII)V", "getB", "()[B", "getStart", "()I", "getEnd", "bit", "", "getBit", "()J", "setBit", "(J)V", "get", "n", "bytesUsed", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    private static final class BitReader {
        private final byte[] b;
        private long bit;
        private final int end;
        private final int start;

        public BitReader(byte[] b, int i, int i2) {
            Intrinsics.checkNotNullParameter(b, "b");
            this.b = b;
            this.start = i;
            this.end = i2;
        }

        public final int bytesUsed() {
            return (int) ((this.bit + 7) / 8);
        }

        public final int get(int n) {
            int i = 0;
            for (int i2 = 0; i2 < n; i2++) {
                int i3 = this.start + ((int) (this.bit >>> 3));
                int i4 = i3 < this.end ? (this.b[i3] >>> ((int) (this.bit & 7))) & 1 : 0;
                this.bit++;
                i |= i4 << i2;
            }
            return i;
        }

        public final byte[] getB() {
            return this.b;
        }

        public final long getBit() {
            return this.bit;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public final void setBit(long j) {
            this.bit = j;
        }
    }

    /* compiled from: Draco.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/Draco$DracoException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", NotificationCompat.CATEGORY_MESSAGE, "", "<init>", "(Ljava/lang/String;)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class DracoException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DracoException(String msg) {
            super(msg);
            Intrinsics.checkNotNullParameter(msg, "msg");
        }
    }

    /* compiled from: Draco.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/Draco$Mesh;", "", "numPoints", "", "faces", "", "attributes", "", "Lcom/exampletest/mobilestudiotest/render/Draco$Attribute;", "<init>", "(I[ILjava/util/List;)V", "getNumPoints", "()I", "getFaces", "()[I", "getAttributes", "()Ljava/util/List;", "attribute", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Mesh {
        private final List<Attribute> attributes;
        private final int[] faces;
        private final int numPoints;

        public Mesh(int i, int[] faces, List<Attribute> attributes) {
            Intrinsics.checkNotNullParameter(faces, "faces");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            this.numPoints = i;
            this.faces = faces;
            this.attributes = attributes;
        }

        public final Attribute attribute(int type) {
            Object obj;
            Iterator<T> it = this.attributes.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((Attribute) obj).getType() == type) {
                    break;
                }
            }
            return (Attribute) obj;
        }

        public final List<Attribute> getAttributes() {
            return this.attributes;
        }

        public final int[] getFaces() {
            return this.faces;
        }

        public final int getNumPoints() {
            return this.numPoints;
        }
    }

    /* compiled from: Draco.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003J&\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006!"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/Draco$Octa;", "", "bits", "", "<init>", "(I)V", "maxQ", "getMaxQ", "()I", "maxValue", "getMaxValue", "center", "getCenter", "scale", "", "getScale", "()F", "isInDiamond", "", "s", "t", "invertDiamond", "", "p", "", "modMax", "x", "toUnit", "si", "ti", "out", "", "o", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    private static final class Octa {
        private final int center;
        private final int maxQ;
        private final int maxValue;
        private final float scale;

        public Octa(int i) {
            if (i < 2 || i > 30) {
                throw new DracoException("bad normal quantization");
            }
            this.maxQ = (1 << i) - 1;
            this.maxValue = this.maxQ - 1;
            this.center = this.maxValue / 2;
            this.scale = 2.0f / this.maxValue;
        }

        public final int getCenter() {
            return this.center;
        }

        public final int getMaxQ() {
            return this.maxQ;
        }

        public final int getMaxValue() {
            return this.maxValue;
        }

        public final float getScale() {
            return this.scale;
        }

        public final void invertDiamond(int[] p) {
            int i;
            int i2;
            int i3;
            int i4;
            Intrinsics.checkNotNullParameter(p, "p");
            int i5 = p[0];
            int i6 = p[1];
            if (i5 >= 0 && i6 >= 0) {
                i = 1;
                i2 = 1;
            } else if (i5 > 0 || i6 > 0) {
                i = i5 > 0 ? 1 : -1;
                i2 = i6 > 0 ? 1 : -1;
            } else {
                i = -1;
                i2 = -1;
            }
            int i7 = this.center * i;
            int i8 = this.center * i2;
            int i9 = (i5 + i5) - i7;
            int i10 = (i6 + i6) - i8;
            if (i * i2 >= 0) {
                i3 = -i10;
                i4 = -i9;
            } else {
                i3 = i10;
                i4 = i9;
            }
            p[0] = (i3 + i7) / 2;
            p[1] = (i4 + i8) / 2;
        }

        public final boolean isInDiamond(int s, int t) {
            return ((long) Math.abs(s)) + ((long) Math.abs(t)) <= ((long) this.center);
        }

        public final int modMax(int x) {
            return x > this.center ? x - this.maxQ : x < (-this.center) ? this.maxQ + x : x;
        }

        public final void toUnit(int si, int ti, float[] out, int o) {
            Intrinsics.checkNotNullParameter(out, "out");
            float f = (si * this.scale) - 1.0f;
            float f2 = (ti * this.scale) - 1.0f;
            float abs = (1.0f - Math.abs(f)) - Math.abs(f2);
            float f3 = (-abs) < 0.0f ? 0.0f : -abs;
            float f4 = f + (f < 0.0f ? f3 : -f3);
            float f5 = f2 + (f2 < 0.0f ? f3 : -f3);
            float f6 = (abs * abs) + (f4 * f4) + (f5 * f5);
            if (f6 < 1.0E-6f) {
                out[o] = 0.0f;
                out[o + 1] = 0.0f;
                out[o + 2] = 0.0f;
            } else {
                float sqrt = 1.0f / ((float) Math.sqrt(f6));
                out[o] = abs * sqrt;
                out[o + 1] = f4 * sqrt;
                out[o + 2] = f5 * sqrt;
            }
        }
    }

    /* compiled from: Draco.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0003R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/Draco$RAns;", "", "precisionBits", "", "probs", "", "<init>", "(I[I)V", "precision", "lBase", "", "lut", "prob", "cum", "buf", "", "start", TypedValues.CycleType.S_WAVE_OFFSET, "state", "init", "", "b", "s", "len", "read", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    private static final class RAns {
        private byte[] buf;
        private final int[] cum;
        private final long lBase;
        private final int[] lut;
        private int offset;
        private final int precision;
        private final int[] prob;
        private int start;
        private long state;

        public RAns(int i, int[] probs) {
            Intrinsics.checkNotNullParameter(probs, "probs");
            this.precision = 1 << i;
            this.lBase = this.precision * 4;
            this.lut = new int[this.precision];
            int[] copyOf = Arrays.copyOf(probs, probs.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.prob = copyOf;
            this.cum = new int[probs.length];
            this.buf = new byte[0];
            long j = 0;
            int i2 = 0;
            int length = probs.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.cum[i3] = (int) j;
                j += probs[i3] & 4294967295L;
                if (j > this.precision) {
                    throw new DracoException("bad probability table");
                }
                int i4 = (int) j;
                for (int i5 = i2; i5 < i4; i5++) {
                    this.lut[i5] = i3;
                }
                i2 = (int) j;
            }
            if (j != this.precision) {
                throw new DracoException("bad probability table");
            }
        }

        private static final long init$le(byte[] bArr, int i, int i2, int i3) {
            long j = 0;
            for (int i4 = 0; i4 < i3; i4++) {
                j |= (bArr[(i + i2) + i4] & 255) << (i4 * 8);
            }
            return j;
        }

        public final void init(byte[] b, int s, int len) {
            Intrinsics.checkNotNullParameter(b, "b");
            if (len < 1) {
                throw new DracoException("empty rANS data");
            }
            this.buf = b;
            this.start = s;
            switch ((b[(s + len) - 1] & UByte.MAX_VALUE) >>> 6) {
                case 0:
                    this.offset = len - 1;
                    this.state = r0 & 63;
                    break;
                case 1:
                    if (len < 2) {
                        throw new DracoException("bad rANS data");
                    }
                    this.offset = len - 2;
                    this.state = init$le(b, s, len - 2, 2) & 16383;
                    break;
                case 2:
                    if (len < 3) {
                        throw new DracoException("bad rANS data");
                    }
                    this.offset = len - 3;
                    this.state = init$le(b, s, len - 3, 3) & 4194303;
                    break;
                default:
                    if (len < 4) {
                        throw new DracoException("bad rANS data");
                    }
                    this.offset = len - 4;
                    this.state = init$le(b, s, len - 4, 4) & LockFreeTaskQueueCore.HEAD_MASK;
                    break;
            }
            this.state += this.lBase;
            if (this.state >= this.lBase * 256) {
                throw new DracoException("bad rANS state");
            }
        }

        public final int read() {
            while (this.state < this.lBase && this.offset > 0) {
                long j = this.state * 256;
                byte[] bArr = this.buf;
                int i = this.start;
                this.offset--;
                this.state = j + (bArr[i + this.offset] & 255);
            }
            long j2 = this.state / this.precision;
            int i2 = (int) (this.state % this.precision);
            int i3 = this.lut[i2];
            this.state = (((this.prob[i3] & 4294967295L) * j2) + i2) - this.cum[i3];
            return i3;
        }
    }

    /* compiled from: Draco.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/Draco$Reader;", "", "b", "", "pos", "", "end", "<init>", "([BII)V", "getB", "()[B", "getPos", "()I", "setPos", "(I)V", "getEnd", "remaining", "getRemaining", "need", "", "n", "u8", "i8", "u16", "i32", "f32", "", "varint", "", "varintInt", "skip", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    private static final class Reader {
        private final byte[] b;
        private final int end;
        private int pos;

        public Reader(byte[] b, int i, int i2) {
            Intrinsics.checkNotNullParameter(b, "b");
            this.b = b;
            this.pos = i;
            this.end = i2;
        }

        public final float f32() {
            return Float.intBitsToFloat(i32());
        }

        public final byte[] getB() {
            return this.b;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getPos() {
            return this.pos;
        }

        public final int getRemaining() {
            return this.end - this.pos;
        }

        public final int i32() {
            need(4);
            int i = (this.b[this.pos] & UByte.MAX_VALUE) | ((this.b[this.pos + 1] & UByte.MAX_VALUE) << 8) | ((this.b[this.pos + 2] & UByte.MAX_VALUE) << 16) | ((this.b[this.pos + 3] & UByte.MAX_VALUE) << 24);
            this.pos += 4;
            return i;
        }

        public final int i8() {
            need(1);
            byte[] bArr = this.b;
            int i = this.pos;
            this.pos = i + 1;
            return bArr[i];
        }

        public final void need(int n) {
            if (n < 0 || this.pos + n > this.end) {
                throw new DracoException("unexpected end of data");
            }
        }

        public final void setPos(int i) {
            this.pos = i;
        }

        public final void skip(int n) {
            need(n);
            this.pos += n;
        }

        public final int u16() {
            need(2);
            int i = (this.b[this.pos] & UByte.MAX_VALUE) | ((this.b[this.pos + 1] & UByte.MAX_VALUE) << 8);
            this.pos += 2;
            return i;
        }

        public final int u8() {
            need(1);
            byte[] bArr = this.b;
            int i = this.pos;
            this.pos = i + 1;
            return bArr[i] & UByte.MAX_VALUE;
        }

        public final long varint() {
            long j = 0;
            int i = 0;
            do {
                j |= (r3 & WorkQueueKt.MASK) << i;
                if ((u8() & 128) == 0) {
                    return j;
                }
                i += 7;
            } while (i <= 63);
            throw new DracoException("bad varint");
        }

        public final int varintInt() {
            long varint = varint();
            if (varint < 0 || varint > 2147483647L) {
                throw new DracoException("value out of range");
            }
            return (int) varint;
        }
    }

    /* compiled from: Draco.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/Draco$SymbolDecoder;", "", "numSymbols", "", "ans", "Lcom/exampletest/mobilestudiotest/render/Draco$RAns;", "<init>", "(ILcom/exampletest/mobilestudiotest/render/Draco$RAns;)V", "getNumSymbols", "()I", "getAns", "()Lcom/exampletest/mobilestudiotest/render/Draco$RAns;", "start", "", "r", "Lcom/exampletest/mobilestudiotest/render/Draco$Reader;", "read", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    private static final class SymbolDecoder {
        private final RAns ans;
        private final int numSymbols;

        public SymbolDecoder(int i, RAns rAns) {
            this.numSymbols = i;
            this.ans = rAns;
        }

        public final RAns getAns() {
            return this.ans;
        }

        public final int getNumSymbols() {
            return this.numSymbols;
        }

        public final int read() {
            RAns rAns = this.ans;
            Intrinsics.checkNotNull(rAns);
            return rAns.read();
        }

        public final void start(Reader r) {
            Intrinsics.checkNotNullParameter(r, "r");
            long varint = r.varint();
            if (varint < 0 || varint > r.getRemaining()) {
                throw new DracoException("bad rANS size");
            }
            int i = (int) varint;
            RAns rAns = this.ans;
            if (rAns == null) {
                throw new DracoException("no symbols");
            }
            rAns.init(r.getB(), r.getPos(), i);
            r.setPos(r.getPos() + i);
        }
    }

    private Draco() {
    }

    private final SymbolDecoder createSymbolDecoder(Reader r, int uniqueSymbolBits) {
        int varintInt = r.varintInt();
        if (varintInt / 64 > r.getRemaining()) {
            throw new DracoException("too many symbols");
        }
        if (varintInt == 0) {
            return new SymbolDecoder(0, null);
        }
        int[] iArr = new int[varintInt];
        int i = 0;
        while (i < varintInt) {
            int u8 = r.u8();
            int i2 = u8 & 3;
            if (i2 == 3) {
                int i3 = u8 >>> 2;
                if (i + i3 >= varintInt) {
                    throw new DracoException("bad probability run");
                }
                i += i3 + 1;
            } else {
                int i4 = u8 >>> 2;
                for (int i5 = 0; i5 < i2; i5++) {
                    i4 |= r.u8() << (((i5 + 1) * 8) - 2);
                }
                iArr[i] = i4;
                i++;
            }
        }
        return new SymbolDecoder(varintInt, new RAns(precisionFor(uniqueSymbolBits), iArr));
    }

    public static /* synthetic */ Mesh decode$default(Draco draco, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        return draco.decode(bArr, i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x0093, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010b  */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void decodePortable(com.exampletest.mobilestudiotest.render.Draco.AttDecoder r27, int r28, com.exampletest.mobilestudiotest.render.Draco.Reader r29) {
        /*
            Method dump skipped, instructions count: 649
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.render.Draco.decodePortable(com.exampletest.mobilestudiotest.render.Draco$AttDecoder, int, com.exampletest.mobilestudiotest.render.Draco$Reader):void");
    }

    private final int[] decodeSymbols(int n, int comps, Reader r) {
        int[] iArr = new int[n];
        if (n == 0) {
            return iArr;
        }
        switch (r.u8()) {
            case 0:
                SymbolDecoder createSymbolDecoder = createSymbolDecoder(r, 5);
                createSymbolDecoder.start(r);
                if (createSymbolDecoder.getNumSymbols() == 0) {
                    throw new DracoException("no tag symbols");
                }
                BitReader bitReader = new BitReader(r.getB(), r.getPos(), r.getEnd());
                int i = 0;
                int i2 = 0;
                while (i2 < n) {
                    int read = createSymbolDecoder.read();
                    if (read > 32) {
                        throw new DracoException("bad tag");
                    }
                    int i3 = 0;
                    while (i3 < comps && i < n) {
                        iArr[i] = bitReader.get(read);
                        i3++;
                        i++;
                    }
                    i2 += comps;
                }
                r.setPos(r.getPos() + bitReader.bytesUsed());
                if (r.getPos() > r.getEnd()) {
                    throw new DracoException("unexpected end of data");
                }
                return iArr;
            case 1:
                int u8 = r.u8();
                if (u8 < 1 || u8 > 18) {
                    throw new DracoException("bad symbol bit length " + u8);
                }
                SymbolDecoder createSymbolDecoder2 = createSymbolDecoder(r, u8);
                if (createSymbolDecoder2.getNumSymbols() == 0) {
                    throw new DracoException("no symbols");
                }
                createSymbolDecoder2.start(r);
                for (int i4 = 0; i4 < n; i4++) {
                    iArr[i4] = createSymbolDecoder2.read();
                }
                return iArr;
            default:
                throw new DracoException("unknown symbol coding");
        }
    }

    private final void decodeTransformData(AttDecoder d, Reader r) {
        switch (d.getKind()) {
            case 2:
                int components = d.getAtt().getComponents();
                float[] fArr = new float[components];
                for (int i = 0; i < components; i++) {
                    fArr[i] = r.f32();
                }
                d.setMinValues(fArr);
                d.setRange(r.f32());
                d.setQBits(r.u8());
                if (d.getQBits() < 1 || d.getQBits() > 30) {
                    throw new DracoException("bad quantization");
                }
                return;
            case 3:
                d.setOctBits(r.u8());
                return;
            default:
                return;
        }
    }

    private final void finish(AttDecoder d, int n) {
        Attribute att = d.getAtt();
        int i = 0;
        switch (d.getKind()) {
            case 1:
                int length = d.getPortable().length;
                float[] fArr = new float[length];
                while (i < length) {
                    fArr[i] = d.getPortable()[i];
                    i++;
                }
                att.setValues(fArr);
                return;
            case 2:
                float range = d.getRange() / ((1 << d.getQBits()) - 1);
                int components = att.getComponents();
                int i2 = n * components;
                float[] fArr2 = new float[i2];
                while (i < i2) {
                    fArr2[i] = (d.getPortable()[i] * range) + d.getMinValues()[i % components];
                    i++;
                }
                att.setValues(fArr2);
                return;
            case 3:
                Octa octa = new Octa(d.getOctBits());
                float[] fArr3 = new float[n * 3];
                for (int i3 = 0; i3 < n; i3++) {
                    octa.toUnit(d.getPortable()[i3 * 2], d.getPortable()[(i3 * 2) + 1], fArr3, i3 * 3);
                }
                att.setValues(fArr3);
                return;
            default:
                return;
        }
    }

    private final int precisionFor(int bits) {
        return RangesKt.coerceIn((bits * 3) / 2, 12, 20);
    }

    private final float readTyped(Reader r, int dt) {
        switch (dt) {
            case 1:
                return r.i8();
            case 2:
            case 11:
                return r.u8();
            case 3:
                return (short) r.u16();
            case 4:
                return r.u16();
            case 5:
                return r.i32();
            case 6:
                return (float) (r.i32() & 4294967295L);
            case 7:
            case 8:
                return (float) ((r.i32() << 32) | (r.i32() & 4294967295L));
            case 9:
                return r.f32();
            case 10:
                return (float) Double.longBitsToDouble((r.i32() << 32) | (r.i32() & 4294967295L));
            default:
                throw new DracoException("bad data type " + dt);
        }
    }

    private final void rotate(int[] p, int count) {
        int i = p[0];
        int i2 = p[1];
        switch (count) {
            case 1:
                p[0] = i2;
                p[1] = -i;
                return;
            case 2:
                p[0] = -i;
                p[1] = -i2;
                return;
            case 3:
                p[0] = -i2;
                p[1] = i;
                return;
            default:
                return;
        }
    }

    private final int rotationCount(int x, int y) {
        if (x != 0) {
            return x > 0 ? y >= 0 ? 2 : 1 : y <= 0 ? 0 : 3;
        }
        if (y == 0) {
            return 0;
        }
        return y > 0 ? 3 : 1;
    }

    private final void skipMetadata(Reader r, int depth) {
        if (depth > 32) {
            throw new DracoException("metadata too deep");
        }
        int varintInt = r.varintInt();
        for (int i = 0; i < varintInt; i++) {
            r.skip(r.u8());
            r.skip(r.varintInt());
        }
        int varintInt2 = r.varintInt();
        for (int i2 = 0; i2 < varintInt2; i2++) {
            r.skip(r.u8());
            INSTANCE.skipMetadata(r, depth + 1);
        }
    }

    static /* synthetic */ void skipMetadata$default(Draco draco, Reader reader, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        draco.skipMetadata(reader, i);
    }

    private final int typeLength(int dt) {
        switch (dt) {
            case 1:
            case 2:
            case 11:
                return 1;
            case 3:
            case 4:
                return 2;
            case 5:
            case 6:
            case 9:
                return 4;
            case 7:
            case 8:
            case 10:
                return 8;
            default:
                throw new DracoException("bad data type " + dt);
        }
    }

    public final Mesh decode(byte[] bytes, int off, int len) {
        int varintInt;
        int varintInt2;
        int i;
        int i2;
        int i3;
        long varint;
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Reader reader = new Reader(bytes, off, off + len);
        if (!isDraco(bytes, off)) {
            throw new DracoException("not Draco data");
        }
        char c = 5;
        reader.skip(5);
        int u8 = reader.u8();
        int u82 = reader.u8();
        int i4 = (u8 * 256) + u82;
        if (u8 != 2) {
            throw new DracoException("Draco version " + u8 + "." + u82 + " isn't supported");
        }
        if (reader.u8() != 1) {
            throw new DracoException("not a triangle mesh");
        }
        int u83 = reader.u8();
        if (u83 != 0) {
            throw new DracoException("Draco edgebreaker meshes aren't supported");
        }
        if ((32768 & reader.u16()) != 0) {
            int varintInt3 = reader.varintInt();
            int i5 = 0;
            while (i5 < varintInt3) {
                reader.varint();
                skipMetadata$default(INSTANCE, reader, 0, 2, null);
                i5++;
                c = c;
            }
            skipMetadata$default(this, reader, 0, 2, null);
        }
        if (i4 < 514) {
            varintInt = reader.i32();
            varintInt2 = reader.i32();
        } else {
            varintInt = reader.varintInt();
            varintInt2 = reader.varintInt();
        }
        if (varintInt < 0 || varintInt > 20000000) {
            throw new DracoException("bad face count");
        }
        if (varintInt2 < 0) {
            throw new DracoException("bad point count");
        }
        int[] iArr = new int[varintInt * 3];
        if (reader.u8() == 0) {
            int[] decodeSymbols = decodeSymbols(varintInt * 3, 1, reader);
            int length = decodeSymbols.length;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = decodeSymbols[i7];
                int i9 = i8 >>> 1;
                if ((i8 & 1) != 0) {
                    if (i9 > i6) {
                        throw new DracoException("bad index");
                    }
                    i9 = -i9;
                }
                i6 += i9;
                iArr[i7] = i6;
            }
        } else {
            int length2 = iArr.length;
            for (int i10 = 0; i10 < length2; i10++) {
                iArr[i10] = varintInt2 < 256 ? reader.u8() : varintInt2 < 65536 ? reader.u16() : (varintInt2 >= 2097152 || i4 < 514) ? reader.i32() : reader.varintInt();
            }
        }
        for (int i11 : iArr) {
            if (i11 < 0 || i11 >= varintInt2) {
                throw new DracoException("face index out of range");
            }
        }
        ArrayList arrayList = new ArrayList();
        int u84 = reader.u8();
        int i12 = 0;
        while (i12 < u84) {
            int i32 = i4 < 512 ? reader.i32() : reader.varintInt();
            if (i32 <= 0 || i32 > reader.getRemaining() * 5) {
                throw new DracoException("bad attribute count");
            }
            ArrayList arrayList2 = new ArrayList();
            int i13 = 0;
            while (i13 < i32) {
                int u85 = reader.u8();
                int i14 = i13;
                int u86 = reader.u8();
                int u87 = reader.u8();
                int u88 = reader.u8();
                if (u86 != 0) {
                    int i15 = varintInt;
                    if (u86 <= 11 && u87 != 0) {
                        if (i4 < 259) {
                            i2 = i4;
                            i3 = u84;
                            varint = reader.u16();
                        } else {
                            i2 = i4;
                            i3 = u84;
                            varint = reader.varint();
                        }
                        arrayList2.add(new Attribute(u85, u86, u87, u88 > 0, varint));
                        i13 = i14 + 1;
                        varintInt = i15;
                        i4 = i2;
                        u84 = i3;
                    }
                }
                throw new DracoException("bad attribute");
            }
            int i16 = varintInt;
            int i17 = i4;
            int i18 = u84;
            ArrayList arrayList3 = arrayList2;
            boolean z = false;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            ArrayList<Attribute> arrayList5 = arrayList3;
            for (Attribute attribute : arrayList5) {
                ArrayList arrayList6 = arrayList3;
                boolean z2 = z;
                int u89 = reader.u8();
                ArrayList arrayList7 = arrayList5;
                if (u89 > 3) {
                    throw new DracoException("unknown attribute decoder " + u89);
                }
                if (u89 == 2 || u89 == 3) {
                    i = u83;
                    if (attribute.getDataType() != 9) {
                        throw new DracoException("bad attribute type");
                    }
                } else {
                    i = u83;
                }
                if (u89 == 3 && attribute.getComponents() != 3) {
                    throw new DracoException("bad normal attribute");
                }
                arrayList4.add(new AttDecoder(attribute, u89));
                arrayList3 = arrayList6;
                z = z2;
                arrayList5 = arrayList7;
                u83 = i;
            }
            arrayList.add(arrayList4);
            i12++;
            varintInt = i16;
            i4 = i17;
            u84 = i18;
        }
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            List list = (List) next;
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                decodePortable((AttDecoder) it2.next(), varintInt2, reader);
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                decodeTransformData((AttDecoder) it3.next(), reader);
            }
            Iterator it4 = list.iterator();
            while (it4.hasNext()) {
                finish((AttDecoder) it4.next(), varintInt2);
            }
        }
        List flatten = CollectionsKt.flatten(arrayList);
        ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(flatten, 10));
        Iterator it5 = flatten.iterator();
        while (it5.hasNext()) {
            arrayList8.add(((AttDecoder) it5.next()).getAtt());
        }
        return new Mesh(varintInt2, iArr, arrayList8);
    }

    public final boolean isDraco(byte[] b, int off) {
        Intrinsics.checkNotNullParameter(b, "b");
        return b.length >= off + 5 && b[off] == 68 && b[off + 1] == 82 && b[off + 2] == 65 && b[off + 3] == 67 && b[off + 4] == 79;
    }
}
