package com.exampletest.mobilestudiotest.format;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.exampletest.mobilestudiotest.model.Axes;
import com.exampletest.mobilestudiotest.model.BrickColorV;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Color3;
import com.exampletest.mobilestudiotest.model.ColorKey;
import com.exampletest.mobilestudiotest.model.ColorSequence;
import com.exampletest.mobilestudiotest.model.ContentValue;
import com.exampletest.mobilestudiotest.model.EnumValue;
import com.exampletest.mobilestudiotest.model.Faces;
import com.exampletest.mobilestudiotest.model.FontValue;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.NumberKey;
import com.exampletest.mobilestudiotest.model.NumberRange;
import com.exampletest.mobilestudiotest.model.NumberSequence;
import com.exampletest.mobilestudiotest.model.OptionalCFrame;
import com.exampletest.mobilestudiotest.model.PhysicalProps;
import com.exampletest.mobilestudiotest.model.RawPropValue;
import com.exampletest.mobilestudiotest.model.Ray;
import com.exampletest.mobilestudiotest.model.Rect;
import com.exampletest.mobilestudiotest.model.SecurityCaps;
import com.exampletest.mobilestudiotest.model.SharedStr;
import com.exampletest.mobilestudiotest.model.UDim;
import com.exampletest.mobilestudiotest.model.UDim2;
import com.exampletest.mobilestudiotest.model.UniqueId;
import com.exampletest.mobilestudiotest.model.Vector2;
import com.exampletest.mobilestudiotest.model.Vector3;
import com.exampletest.mobilestudiotest.model.Vector3int16;
import com.github.luben.zstd.Zstd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;

/* compiled from: RbxBinary.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u000212B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0017\u001a\u00020\u0018J(\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003H\u0002J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003H\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003H\u0002J\u001e\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0%H\u0002J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003H\u0002J\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\fH\u0002J>\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010(2\u0006\u0010*\u001a\u00020+2\u0006\u0010.\u001a\u00020\f2\u0006\u0010,\u001a\u00020\f2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0(2\u0006\u00100\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0010`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\tX\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u0012\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u00130\u0007j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u0013`\tX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0015j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/exampletest/mobilestudiotest/format/RbxBinaryReader;", "", "data", "", "<init>", "([B)V", "warnings", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "instances", "Ljava/util/HashMap;", "", "Lcom/exampletest/mobilestudiotest/model/Instance;", "Lkotlin/collections/HashMap;", "classes", "Lcom/exampletest/mobilestudiotest/format/RbxBinaryReader$ClassInfo;", "sharedStrings", "pendingRefs", "Lkotlin/Triple;", "meta", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "read", "Lcom/exampletest/mobilestudiotest/format/RbxDocument;", "decompress", "src", DebugKt.DEBUG_PROPERTY_VALUE_OFF, "len", "out", "readMeta", "", "d", "readSstr", "readInst", "readPrnt", "roots", "", "readProp", "readCFrames", "", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "r", "Lcom/exampletest/mobilestudiotest/format/ByteReader;", "n", "readValues", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "insts", "name", "Chunk", "ClassInfo", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RbxBinaryReader {
    private final HashMap<Integer, ClassInfo> classes;
    private final byte[] data;
    private final HashMap<Integer, Instance> instances;
    private final LinkedHashMap<String, String> meta;
    private final ArrayList<Triple<Instance, String, Integer>> pendingRefs;
    private final ArrayList<byte[]> sharedStrings;
    private final ArrayList<String> warnings;

    /* compiled from: RbxBinary.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/exampletest/mobilestudiotest/format/RbxBinaryReader$Chunk;", "", "name", "", "data", "", "<init>", "(Ljava/lang/String;[B)V", "getName", "()Ljava/lang/String;", "getData", "()[B", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Chunk {
        private final byte[] data;
        private final String name;

        public Chunk(String name, byte[] data) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(data, "data");
            this.name = name;
            this.data = data;
        }

        public final byte[] getData() {
            return this.data;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* compiled from: RbxBinary.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/exampletest/mobilestudiotest/format/RbxBinaryReader$ClassInfo;", "", "name", "", "refs", "", "<init>", "(Ljava/lang/String;[I)V", "getName", "()Ljava/lang/String;", "getRefs", "()[I", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class ClassInfo {
        private final String name;
        private final int[] refs;

        public ClassInfo(String name, int[] refs) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(refs, "refs");
            this.name = name;
            this.refs = refs;
        }

        public final String getName() {
            return this.name;
        }

        public final int[] getRefs() {
            return this.refs;
        }
    }

    public RbxBinaryReader(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.warnings = new ArrayList<>();
        this.instances = new HashMap<>();
        this.classes = new HashMap<>();
        this.sharedStrings = new ArrayList<>();
        this.pendingRefs = new ArrayList<>();
        this.meta = new LinkedHashMap<>();
    }

    private final byte[] decompress(byte[] src, int off, int len, int out) {
        if (!(len >= 4 && src[off] == 40 && src[off + 1] == -75 && src[off + 2] == 47 && src[off + 3] == -3)) {
            return Lz4.INSTANCE.decompress(src, off, len, out);
        }
        try {
            byte[] decompress = Zstd.decompress(ArraysKt.copyOfRange(src, off, off + len), out);
            Intrinsics.checkNotNull(decompress);
            return decompress;
        } catch (Throwable th) {
            throw new RbxFormatException("Could not decompress ZSTD chunk: " + th.getMessage());
        }
    }

    private final List<CFrame> readCFrames(ByteReader r, int n) {
        ArrayList arrayList = new ArrayList(n);
        for (int i = 0; i < n; i++) {
            int u8 = r.u8();
            if (u8 == 0) {
                float[] fArr = new float[9];
                for (int i2 = 0; i2 < 9; i2++) {
                    fArr[i2] = r.f32();
                }
                arrayList.add(new CFrame(0.0f, 0.0f, 0.0f, fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7], fArr[8]));
            } else {
                arrayList.add(RbxBinaryKt.access$rotationFromId(u8));
            }
        }
        float[] f32Array = r.f32Array(n);
        float[] f32Array2 = r.f32Array(n);
        float[] f32Array3 = r.f32Array(n);
        ArrayList arrayList2 = new ArrayList(n);
        for (int i3 = 0; i3 < n; i3++) {
            int i4 = i3;
            arrayList2.add(((CFrame) arrayList.get(i4)).withPosition(new Vector3(f32Array[i4], f32Array2[i4], f32Array3[i4])));
        }
        return arrayList2;
    }

    private final void readInst(byte[] d) {
        ByteReader byteReader = new ByteReader(d, 0, 0, 6, null);
        int i32 = byteReader.i32();
        String string = byteReader.string();
        int u8 = byteReader.u8();
        int i322 = byteReader.i32();
        int[] refArray = byteReader.refArray(i322);
        boolean z = u8 == 1;
        if (z) {
            byteReader.bytes(i322);
        }
        this.classes.put(Integer.valueOf(i32), new ClassInfo(string, refArray));
        for (int i : refArray) {
            Instance instance = new Instance(string);
            instance.setService(z);
            instance.setLoadedRef(i);
            this.instances.put(Integer.valueOf(i), instance);
        }
    }

    private final void readMeta(byte[] d) {
        ByteReader byteReader = new ByteReader(d, 0, 0, 6, null);
        int i32 = byteReader.i32();
        for (int i = 0; i < i32; i++) {
            this.meta.put(byteReader.string(), byteReader.string());
        }
    }

    private final void readPrnt(byte[] d, List<Instance> roots) {
        ByteReader byteReader = new ByteReader(d, 0, 0, 6, null);
        byteReader.u8();
        int i32 = byteReader.i32();
        int[] refArray = byteReader.refArray(i32);
        int[] refArray2 = byteReader.refArray(i32);
        for (int i = 0; i < i32; i++) {
            Instance instance = this.instances.get(Integer.valueOf(refArray[i]));
            if (instance != null) {
                Instance instance2 = refArray2[i] < 0 ? null : this.instances.get(Integer.valueOf(refArray2[i]));
                if (instance2 == null) {
                    roots.add(instance);
                } else {
                    instance.attachRaw(instance2);
                }
            }
        }
    }

    private final void readProp(byte[] d) {
        RbxBinaryReader rbxBinaryReader = this;
        ByteReader byteReader = new ByteReader(d, 0, 0, 6, null);
        int i32 = byteReader.i32();
        String string = byteReader.string();
        int u8 = byteReader.u8();
        ClassInfo classInfo = rbxBinaryReader.classes.get(Integer.valueOf(i32));
        if (classInfo == null) {
            return;
        }
        int[] refs = classInfo.getRefs();
        ArrayList arrayList = new ArrayList(refs.length);
        int length = refs.length;
        int i = 0;
        while (i < length) {
            int[] iArr = refs;
            Instance instance = rbxBinaryReader.instances.get(Integer.valueOf(refs[i]));
            Intrinsics.checkNotNull(instance);
            arrayList.add(instance);
            i++;
            rbxBinaryReader = this;
            refs = iArr;
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int pos = byteReader.getPos();
        try {
            List<Object> readValues = readValues(byteReader, u8, size, arrayList2, string);
            for (int i2 = 0; i2 < size; i2++) {
                if (u8 != 19) {
                    ((Instance) arrayList2.get(i2)).getProps().put(string, readValues.get(i2));
                }
                ((Instance) arrayList2.get(i2)).getPropTypes().put(string, Integer.valueOf(u8));
            }
        } catch (Exception e) {
            byte[] copyOfRange = ArraysKt.copyOfRange(d, pos, d.length);
            this.warnings.add("Preserved " + classInfo.getName() + "." + string + " (unsupported type 0x" + Integer.toHexString(u8) + ")");
            for (int i3 = 0; i3 < size; i3++) {
                ((Instance) arrayList2.get(i3)).getProps().put(string, new RawPropValue(u8, copyOfRange, i3, size));
                ((Instance) arrayList2.get(i3)).getPropTypes().put(string, Integer.valueOf(u8));
            }
        }
    }

    private final void readSstr(byte[] d) {
        ByteReader byteReader = new ByteReader(d, 0, 0, 6, null);
        byteReader.i32();
        int i32 = byteReader.i32();
        for (int i = 0; i < i32; i++) {
            byteReader.bytes(16);
            this.sharedStrings.add(byteReader.stringBytes());
        }
    }

    private final List<Object> readValues(ByteReader r, int type, int n, List<? extends Instance> insts, String name) {
        PhysicalProps physicalProps;
        int[] iArr;
        byte[] bArr;
        int i;
        ContentValue contentValue;
        switch (type) {
            case 1:
                ArrayList arrayList = new ArrayList(n);
                for (int i2 = 0; i2 < n; i2++) {
                    arrayList.add(RbxBinaryKt.access$bytesToStringValue(r.stringBytes()));
                }
                return arrayList;
            case 2:
                ArrayList arrayList2 = new ArrayList(n);
                for (int i3 = 0; i3 < n; i3++) {
                    arrayList2.add(Boolean.valueOf(r.u8() != 0));
                }
                return arrayList2;
            case 3:
                return ArraysKt.toList(r.i32Array(n));
            case 4:
                return ArraysKt.toList(r.f32Array(n));
            case 5:
                ArrayList arrayList3 = new ArrayList(n);
                for (int i4 = 0; i4 < n; i4++) {
                    arrayList3.add(Double.valueOf(r.f64()));
                }
                return arrayList3;
            case 6:
                float[] f32Array = r.f32Array(n);
                int[] i32Array = r.i32Array(n);
                ArrayList arrayList4 = new ArrayList(n);
                for (int i5 = 0; i5 < n; i5++) {
                    int i6 = i5;
                    arrayList4.add(new UDim(f32Array[i6], i32Array[i6]));
                }
                return arrayList4;
            case 7:
                float[] f32Array2 = r.f32Array(n);
                float[] f32Array3 = r.f32Array(n);
                int[] i32Array2 = r.i32Array(n);
                int[] i32Array3 = r.i32Array(n);
                ArrayList arrayList5 = new ArrayList(n);
                int i7 = 0;
                while (i7 < n) {
                    int i8 = i7;
                    arrayList5.add(new UDim2(f32Array2[i8], i32Array2[i8], f32Array3[i8], i32Array3[i8]));
                    i7++;
                    f32Array2 = f32Array2;
                }
                return arrayList5;
            case 8:
                ArrayList arrayList6 = new ArrayList(n);
                for (int i9 = 0; i9 < n; i9++) {
                    arrayList6.add(new Ray(new Vector3(r.f32(), r.f32(), r.f32()), new Vector3(r.f32(), r.f32(), r.f32())));
                }
                return arrayList6;
            case 9:
                ArrayList arrayList7 = new ArrayList(n);
                for (int i10 = 0; i10 < n; i10++) {
                    arrayList7.add(new Faces(r.u8()));
                }
                return arrayList7;
            case 10:
                ArrayList arrayList8 = new ArrayList(n);
                for (int i11 = 0; i11 < n; i11++) {
                    arrayList8.add(new Axes(r.u8()));
                }
                return arrayList8;
            case 11:
                int[] u32Array = r.u32Array(n);
                ArrayList arrayList9 = new ArrayList(u32Array.length);
                for (int i12 : u32Array) {
                    arrayList9.add(new BrickColorV(i12));
                }
                return arrayList9;
            case 12:
                float[] f32Array4 = r.f32Array(n);
                float[] f32Array5 = r.f32Array(n);
                float[] f32Array6 = r.f32Array(n);
                ArrayList arrayList10 = new ArrayList(n);
                for (int i13 = 0; i13 < n; i13++) {
                    int i14 = i13;
                    arrayList10.add(new Color3(f32Array4[i14], f32Array5[i14], f32Array6[i14]));
                }
                return arrayList10;
            case 13:
                float[] f32Array7 = r.f32Array(n);
                float[] f32Array8 = r.f32Array(n);
                ArrayList arrayList11 = new ArrayList(n);
                for (int i15 = 0; i15 < n; i15++) {
                    int i16 = i15;
                    arrayList11.add(new Vector2(f32Array7[i16], f32Array8[i16]));
                }
                return arrayList11;
            case 14:
                float[] f32Array9 = r.f32Array(n);
                float[] f32Array10 = r.f32Array(n);
                float[] f32Array11 = r.f32Array(n);
                ArrayList arrayList12 = new ArrayList(n);
                for (int i17 = 0; i17 < n; i17++) {
                    int i18 = i17;
                    arrayList12.add(new Vector3(f32Array9[i18], f32Array10[i18], f32Array11[i18]));
                }
                return arrayList12;
            case 15:
            case 17:
            case 29:
            default:
                throw new RbxFormatException("unsupported type 0x" + Integer.toHexString(type) + " for '" + name + "'");
            case 16:
                return readCFrames(r, n);
            case 18:
                int[] u32Array2 = r.u32Array(n);
                ArrayList arrayList13 = new ArrayList(u32Array2.length);
                for (int i19 : u32Array2) {
                    arrayList13.add(new EnumValue(i19));
                }
                return arrayList13;
            case 19:
                int[] refArray = r.refArray(n);
                for (int i20 = 0; i20 < n; i20++) {
                    this.pendingRefs.add(new Triple<>(insts.get(i20), name, Integer.valueOf(refArray[i20])));
                }
                ArrayList arrayList14 = new ArrayList(n);
                for (int i21 = 0; i21 < n; i21++) {
                    arrayList14.add(null);
                }
                return arrayList14;
            case 20:
                ArrayList arrayList15 = new ArrayList(n);
                for (int i22 = 0; i22 < n; i22++) {
                    arrayList15.add(new Vector3int16(readValues$lambda$19$s16(r), readValues$lambda$19$s16(r), readValues$lambda$19$s16(r)));
                }
                return arrayList15;
            case 21:
                ArrayList arrayList16 = new ArrayList(n);
                int i23 = 0;
                while (i23 < n) {
                    int i32 = r.i32();
                    ArrayList arrayList17 = new ArrayList(i32);
                    int i24 = 0;
                    while (i24 < i32) {
                        arrayList17.add(new NumberKey(r.f32(), r.f32(), r.f32()));
                        i24++;
                        i23 = i23;
                    }
                    arrayList16.add(new NumberSequence(arrayList17));
                    i23++;
                }
                return arrayList16;
            case 22:
                int i25 = 0;
                ArrayList arrayList18 = new ArrayList(n);
                int i26 = 0;
                while (i26 < n) {
                    int i27 = i26;
                    int i322 = r.i32();
                    ArrayList arrayList19 = new ArrayList(i322);
                    int i28 = i25;
                    while (i28 < i322) {
                        arrayList19.add(new ColorKey(r.f32(), new Color3(r.f32(), r.f32(), r.f32()), r.f32()));
                        i28++;
                        i26 = i26;
                        i27 = i27;
                    }
                    arrayList18.add(new ColorSequence(arrayList19));
                    i26++;
                    i25 = 0;
                }
                return arrayList18;
            case 23:
                ArrayList arrayList20 = new ArrayList(n);
                for (int i29 = 0; i29 < n; i29++) {
                    arrayList20.add(new NumberRange(r.f32(), r.f32()));
                }
                return arrayList20;
            case 24:
                float[] f32Array12 = r.f32Array(n);
                float[] f32Array13 = r.f32Array(n);
                float[] f32Array14 = r.f32Array(n);
                float[] f32Array15 = r.f32Array(n);
                ArrayList arrayList21 = new ArrayList(n);
                for (int i30 = 0; i30 < n; i30++) {
                    int i31 = i30;
                    arrayList21.add(new Rect(f32Array12[i31], f32Array13[i31], f32Array14[i31], f32Array15[i31]));
                }
                return arrayList21;
            case 25:
                ArrayList arrayList22 = new ArrayList(n);
                for (int i33 = 0; i33 < n; i33++) {
                    int u8 = r.u8();
                    if ((u8 & 1) != 0) {
                        physicalProps = new PhysicalProps(u8, r.f32(), r.f32(), r.f32(), r.f32(), r.f32(), 0.0f, 64, null);
                        if ((u8 & 2) != 0) {
                            physicalProps = PhysicalProps.copy$default(physicalProps, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, r.f32(), 63, null);
                        }
                    } else {
                        physicalProps = new PhysicalProps(u8, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 126, null);
                    }
                    arrayList22.add(physicalProps);
                }
                return arrayList22;
            case 26:
                byte[] bytes = r.bytes(n);
                byte[] bytes2 = r.bytes(n);
                byte[] bytes3 = r.bytes(n);
                ArrayList arrayList23 = new ArrayList(n);
                for (int i34 = 0; i34 < n; i34++) {
                    int i35 = i34;
                    arrayList23.add(Color3.INSTANCE.fromRGB(bytes[i35] & UByte.MAX_VALUE, bytes2[i35] & UByte.MAX_VALUE, bytes3[i35] & UByte.MAX_VALUE));
                }
                return arrayList23;
            case 27:
                return ArraysKt.toList(r.i64Array(n));
            case 28:
                int[] u32Array3 = r.u32Array(n);
                ArrayList arrayList24 = new ArrayList(u32Array3.length);
                int length = u32Array3.length;
                int i36 = 0;
                while (i36 < length) {
                    int i37 = u32Array3[i36];
                    ArrayList<byte[]> arrayList25 = this.sharedStrings;
                    if (i37 >= 0 && i37 < arrayList25.size()) {
                        bArr = arrayList25.get(i37);
                        iArr = u32Array3;
                    } else {
                        iArr = u32Array3;
                        bArr = new byte[0];
                    }
                    arrayList24.add(new SharedStr(bArr));
                    i36++;
                    u32Array3 = iArr;
                }
                return arrayList24;
            case 30:
                r.u8();
                List<CFrame> readCFrames = readCFrames(r, n);
                r.u8();
                ArrayList arrayList26 = new ArrayList(n);
                for (int i38 = 0; i38 < n; i38++) {
                    arrayList26.add(Boolean.valueOf(r.u8() != 0));
                }
                ArrayList arrayList27 = arrayList26;
                ArrayList arrayList28 = new ArrayList(n);
                for (int i39 = 0; i39 < n; i39++) {
                    int i40 = i39;
                    arrayList28.add(new OptionalCFrame(((Boolean) arrayList27.get(i40)).booleanValue() ? readCFrames.get(i40) : null));
                }
                return arrayList28;
            case 31:
                byte[] interleaved = r.interleaved(n, 16);
                ArrayList arrayList29 = new ArrayList(n);
                for (int i41 = 0; i41 < n; i41++) {
                    int i42 = i41;
                    arrayList29.add(new UniqueId(ArraysKt.copyOfRange(interleaved, i42 * 16, (i42 * 16) + 16)));
                }
                return arrayList29;
            case 32:
                ArrayList arrayList30 = new ArrayList(n);
                for (int i43 = 0; i43 < n; i43++) {
                    arrayList30.add(new FontValue(r.string(), r.u16(), r.u8(), r.string()));
                }
                return arrayList30;
            case 33:
                int i44 = 8;
                byte[] interleaved2 = r.interleaved(n, 8);
                ArrayList arrayList31 = new ArrayList(n);
                int i45 = 0;
                while (i45 < n) {
                    int i46 = i45;
                    long j = 0;
                    int i47 = 0;
                    while (i47 < i44) {
                        j = (j << i44) | (interleaved2[(i46 * 8) + i47] & 255);
                        i47++;
                        interleaved2 = interleaved2;
                        i44 = 8;
                    }
                    arrayList31.add(new SecurityCaps(j));
                    i45++;
                    i44 = 8;
                }
                return arrayList31;
            case 34:
                int[] i32Array4 = r.i32Array(n);
                int i323 = r.i32();
                ArrayList arrayList32 = new ArrayList(i323);
                for (int i48 = 0; i48 < i323; i48++) {
                    arrayList32.add(r.string());
                }
                ArrayList arrayList33 = arrayList32;
                int[] refArray2 = r.refArray(r.i32());
                int i324 = r.i32();
                if (i324 != 0) {
                    r.refArray(i324);
                }
                int i49 = 0;
                int i50 = 0;
                ArrayList arrayList34 = new ArrayList(n);
                int i51 = 0;
                while (i51 < n) {
                    Object obj = "";
                    switch (i32Array4[i51]) {
                        case 1:
                            int i52 = i49 + 1;
                            if (i49 >= 0 && i49 < arrayList33.size()) {
                                obj = arrayList33.get(i49);
                            }
                            i49 = i52;
                            i = i50;
                            contentValue = new ContentValue(1, (String) obj, null, 4, null);
                            break;
                        case 2:
                            i = i50 + 1;
                            int i53 = i50 >= 0 && i50 < refArray2.length ? refArray2[i50] : -1;
                            contentValue = new ContentValue(2, "", i53 < 0 ? null : this.instances.get(Integer.valueOf(i53)));
                            break;
                        default:
                            i = i50;
                            contentValue = new ContentValue(0, null, null, 6, null);
                            break;
                    }
                    arrayList34.add(contentValue);
                    i51++;
                    i50 = i;
                }
                return arrayList34;
        }
    }

    private static final int readValues$lambda$19$s16(ByteReader byteReader) {
        int u16 = byteReader.u16();
        return u16 >= 32768 ? u16 - 65536 : u16;
    }

    public final RbxDocument read() {
        boolean z;
        char c;
        boolean z2;
        Iterator<Triple<Instance, String, Integer>> it;
        ByteReader byteReader;
        Instance instance;
        String trimEnd;
        byte[] decompress;
        ByteReader byteReader2 = new ByteReader(this.data, 0, 0, 6, null);
        byteReader2.setPos(14);
        int u16 = byteReader2.u16();
        if (u16 != 0) {
            this.warnings.add("Unknown file version " + u16);
        }
        byteReader2.i32();
        byteReader2.i32();
        byteReader2.bytes(8);
        ArrayList arrayList = new ArrayList();
        do {
            z = true;
            c = 4;
            z2 = false;
            if (byteReader2.remaining() < 16) {
                break;
            }
            trimEnd = StringsKt.trimEnd(new String(byteReader2.bytes(4), Charsets.ISO_8859_1), 0);
            int i32 = byteReader2.i32();
            int i322 = byteReader2.i32();
            byteReader2.i32();
            if (i32 == 0) {
                decompress = byteReader2.bytes(i322);
            } else {
                int pos = byteReader2.getPos();
                byteReader2.bytes(i32);
                decompress = decompress(this.data, pos, i32, i322);
            }
            arrayList.add(new Chunk(trimEnd, decompress));
        } while (!Intrinsics.areEqual(trimEnd, "END"));
        Iterator it2 = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            Object next = it2.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            Chunk chunk = (Chunk) next;
            if (Intrinsics.areEqual(chunk.getName(), "META")) {
                readMeta(chunk.getData());
            }
        }
        Iterator it3 = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
        while (it3.hasNext()) {
            Object next2 = it3.next();
            Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
            Chunk chunk2 = (Chunk) next2;
            if (Intrinsics.areEqual(chunk2.getName(), "SSTR")) {
                readSstr(chunk2.getData());
            }
        }
        Iterator it4 = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it4, "iterator(...)");
        while (it4.hasNext()) {
            Object next3 = it4.next();
            Intrinsics.checkNotNullExpressionValue(next3, "next(...)");
            Chunk chunk3 = (Chunk) next3;
            if (Intrinsics.areEqual(chunk3.getName(), "INST")) {
                readInst(chunk3.getData());
            }
        }
        Iterator it5 = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it5, "iterator(...)");
        while (it5.hasNext()) {
            Object next4 = it5.next();
            Intrinsics.checkNotNullExpressionValue(next4, "next(...)");
            Chunk chunk4 = (Chunk) next4;
            if (Intrinsics.areEqual(chunk4.getName(), "PROP")) {
                try {
                    readProp(chunk4.getData());
                } catch (Exception e) {
                    this.warnings.add("Skipped a property: " + e.getMessage());
                    z = z;
                    c = c;
                    z2 = z2;
                }
            }
        }
        boolean z3 = z;
        char c2 = c;
        boolean z4 = z2;
        Iterator<Triple<Instance, String, Integer>> it6 = this.pendingRefs.iterator();
        Intrinsics.checkNotNullExpressionValue(it6, "iterator(...)");
        while (it6.hasNext()) {
            Triple<Instance, String, Integer> next5 = it6.next();
            Intrinsics.checkNotNullExpressionValue(next5, "next(...)");
            Triple<Instance, String, Integer> triple = next5;
            Instance component1 = triple.component1();
            String component2 = triple.component2();
            int intValue = triple.component3().intValue();
            LinkedHashMap<String, Object> props = component1.getProps();
            if (intValue < 0) {
                it = it6;
                instance = null;
                byteReader = byteReader2;
            } else {
                it = it6;
                byteReader = byteReader2;
                instance = this.instances.get(Integer.valueOf(intValue));
            }
            props.put(component2, instance);
            it6 = it;
            byteReader2 = byteReader;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it7 = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it7, "iterator(...)");
        while (it7.hasNext()) {
            Object next6 = it7.next();
            Intrinsics.checkNotNullExpressionValue(next6, "next(...)");
            Chunk chunk5 = (Chunk) next6;
            if (Intrinsics.areEqual(chunk5.getName(), "PRNT")) {
                readPrnt(chunk5.getData(), arrayList2);
            }
        }
        Iterator it8 = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it8, "iterator(...)");
        while (it8.hasNext()) {
            Object next7 = it8.next();
            Intrinsics.checkNotNullExpressionValue(next7, "next(...)");
            Chunk chunk6 = (Chunk) next7;
            String[] strArr = new String[7];
            strArr[z4 ? 1 : 0] = "META";
            strArr[z3 ? 1 : 0] = "SSTR";
            strArr[2] = "INST";
            strArr[3] = "PROP";
            strArr[c2] = "PRNT";
            strArr[5] = "END";
            strArr[6] = "SIGN";
            if (!SetsKt.setOf((Object[]) strArr).contains(chunk6.getName())) {
                this.warnings.add("Ignored unknown chunk " + chunk6.getName());
                arrayList2 = arrayList2;
            }
        }
        return new RbxDocument(arrayList2, this.meta, this.warnings);
    }
}
