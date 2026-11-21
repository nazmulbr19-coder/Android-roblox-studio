package com.exampletest.mobilestudiotest.format;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.exampletest.mobilestudiotest.model.Axes;
import com.exampletest.mobilestudiotest.model.BinaryString;
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
import com.exampletest.mobilestudiotest.model.PropType;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

/* compiled from: RbxBinary.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0007H\u0002J\\\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00102\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\u001b2\u001e\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u001d0\nH\u0002¨\u0006\u001e"}, d2 = {"Lcom/exampletest/mobilestudiotest/format/RbxBinaryWriter;", "", "<init>", "()V", "write", "", "roots", "", "Lcom/exampletest/mobilestudiotest/model/Instance;", "meta", "", "", "f", "", "v", "i", "", "writeCFrames", "", "w", "Lcom/exampletest/mobilestudiotest/format/ByteWriter;", "cfs", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "writeValues", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "vals", "ref", "Ljava/util/IdentityHashMap;", "sstr", "Lkotlin/Pair;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RbxBinaryWriter {
    public static final RbxBinaryWriter INSTANCE = new RbxBinaryWriter();

    private RbxBinaryWriter() {
    }

    private final float f(Object v) {
        Number number = v instanceof Number ? (Number) v : null;
        if (number != null) {
            return number.floatValue();
        }
        return 0.0f;
    }

    private final int i(Object v) {
        if (v instanceof Number) {
            return ((Number) v).intValue();
        }
        if (v instanceof EnumValue) {
            return ((EnumValue) v).getValue();
        }
        if (v instanceof BrickColorV) {
            return ((BrickColorV) v).getNumber();
        }
        return 0;
    }

    private static final void write$chunk(ByteWriter byteWriter, String str, byte[] bArr) {
        byte[] bytes = str.getBytes(Charsets.ISO_8859_1);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] copyOf = Arrays.copyOf(bytes, 4);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        byteWriter.bytes(copyOf);
        byteWriter.i32(0);
        byteWriter.i32(bArr.length);
        byteWriter.i32(0);
        byteWriter.bytes(bArr);
    }

    private static final void write$collect(ArrayList<Instance> arrayList, Instance instance) {
        if (instance.getArchivable()) {
            arrayList.add(instance);
            Iterator<Instance> it = instance.getChildren().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                write$collect(arrayList, it.next());
            }
        }
    }

    private final void writeCFrames(ByteWriter w, List<CFrame> cfs) {
        int i;
        Iterator<CFrame> it = cfs.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            CFrame next = it.next();
            w.u8(0);
            w.f32(next.getR00());
            w.f32(next.getR01());
            w.f32(next.getR02());
            w.f32(next.getR10());
            w.f32(next.getR11());
            w.f32(next.getR12());
            w.f32(next.getR20());
            w.f32(next.getR21());
            w.f32(next.getR22());
        }
        int size = cfs.size();
        float[] fArr = new float[size];
        for (int i2 = 0; i2 < size; i2++) {
            fArr[i2] = cfs.get(i2).getX();
        }
        w.f32Array(fArr);
        int size2 = cfs.size();
        float[] fArr2 = new float[size2];
        for (int i3 = 0; i3 < size2; i3++) {
            fArr2[i3] = cfs.get(i3).getY();
        }
        w.f32Array(fArr2);
        int size3 = cfs.size();
        float[] fArr3 = new float[size3];
        for (i = 0; i < size3; i++) {
            fArr3[i] = cfs.get(i).getZ();
        }
        w.f32Array(fArr3);
    }

    private final void writeValues(ByteWriter w, int type, List<? extends Object> vals, IdentityHashMap<Instance, Integer> ref, Map<String, Pair<Integer, byte[]>> sstr) {
        String str;
        List<? extends Object> list;
        List<? extends Object> list2;
        int i;
        Integer num;
        boolean z;
        List<? extends Object> list3;
        Pair<Integer, byte[]> pair;
        int intValue;
        List<? extends Object> list4;
        boolean z2;
        byte[] bytes;
        List<? extends Object> list5;
        String str2;
        int size = vals.size();
        boolean z3 = true;
        switch (type) {
            case 1:
                for (Object obj : vals) {
                    if (obj instanceof BinaryString) {
                        w.string(((BinaryString) obj).getBytes());
                    } else if (obj instanceof ContentValue) {
                        w.string(((ContentValue) obj).getUri());
                    } else {
                        if (obj == null || (str = obj.toString()) == null) {
                            str = "";
                        }
                        w.string(str);
                    }
                }
                Unit unit = Unit.INSTANCE;
                return;
            case 2:
                Iterator<? extends Object> it = vals.iterator();
                while (it.hasNext()) {
                    w.u8(Intrinsics.areEqual(it.next(), (Object) true) ? 1 : 0);
                }
                Unit unit2 = Unit.INSTANCE;
                return;
            case 3:
                int[] iArr = new int[size];
                for (int i2 = 0; i2 < size; i2++) {
                    iArr[i2] = INSTANCE.i(vals.get(i2));
                }
                w.i32Array(iArr);
                Unit unit3 = Unit.INSTANCE;
                return;
            case 4:
                float[] fArr = new float[size];
                for (int i3 = 0; i3 < size; i3++) {
                    fArr[i3] = INSTANCE.f(vals.get(i3));
                }
                w.f32Array(fArr);
                Unit unit4 = Unit.INSTANCE;
                return;
            case 5:
                for (Object obj2 : vals) {
                    Number number = obj2 instanceof Number ? (Number) obj2 : null;
                    w.f64(number != null ? number.doubleValue() : 0.0d);
                }
                Unit unit5 = Unit.INSTANCE;
                return;
            case 6:
                List<? extends Object> list6 = vals;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                for (Object obj3 : list6) {
                    UDim uDim = obj3 instanceof UDim ? (UDim) obj3 : null;
                    if (uDim == null) {
                        list = list6;
                        uDim = new UDim(0.0f, 0);
                    } else {
                        list = list6;
                    }
                    arrayList.add(uDim);
                    list6 = list;
                }
                ArrayList arrayList2 = arrayList;
                float[] fArr2 = new float[size];
                for (int i4 = 0; i4 < size; i4++) {
                    fArr2[i4] = ((UDim) arrayList2.get(i4)).getScale();
                }
                w.f32Array(fArr2);
                int[] iArr2 = new int[size];
                for (int i5 = 0; i5 < size; i5++) {
                    iArr2[i5] = ((UDim) arrayList2.get(i5)).getOffset();
                }
                w.i32Array(iArr2);
                Unit unit6 = Unit.INSTANCE;
                return;
            case 7:
                List<? extends Object> list7 = vals;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                for (Object obj4 : list7) {
                    UDim2 uDim2 = obj4 instanceof UDim2 ? (UDim2) obj4 : null;
                    if (uDim2 == null) {
                        list2 = list7;
                        uDim2 = new UDim2(0.0f, 0, 0.0f, 0);
                    } else {
                        list2 = list7;
                    }
                    arrayList3.add(uDim2);
                    list7 = list2;
                }
                ArrayList arrayList4 = arrayList3;
                float[] fArr3 = new float[size];
                for (int i6 = 0; i6 < size; i6++) {
                    fArr3[i6] = ((UDim2) arrayList4.get(i6)).getXs();
                }
                w.f32Array(fArr3);
                float[] fArr4 = new float[size];
                for (int i7 = 0; i7 < size; i7++) {
                    fArr4[i7] = ((UDim2) arrayList4.get(i7)).getYs();
                }
                w.f32Array(fArr4);
                int[] iArr3 = new int[size];
                for (int i8 = 0; i8 < size; i8++) {
                    iArr3[i8] = ((UDim2) arrayList4.get(i8)).getXo();
                }
                w.i32Array(iArr3);
                int[] iArr4 = new int[size];
                for (int i9 = 0; i9 < size; i9++) {
                    iArr4[i9] = ((UDim2) arrayList4.get(i9)).getYo();
                }
                w.i32Array(iArr4);
                Unit unit7 = Unit.INSTANCE;
                return;
            case 8:
                for (Object obj5 : vals) {
                    Ray ray = obj5 instanceof Ray ? (Ray) obj5 : null;
                    if (ray == null) {
                        ray = new Ray(Vector3.INSTANCE.getZERO(), Vector3.INSTANCE.getZERO());
                    }
                    w.f32(ray.getOrigin().getX());
                    w.f32(ray.getOrigin().getY());
                    w.f32(ray.getOrigin().getZ());
                    w.f32(ray.getDirection().getX());
                    w.f32(ray.getDirection().getY());
                    w.f32(ray.getDirection().getZ());
                }
                Unit unit8 = Unit.INSTANCE;
                return;
            case 9:
                for (Object obj6 : vals) {
                    Faces faces = obj6 instanceof Faces ? (Faces) obj6 : null;
                    w.u8(faces != null ? faces.getMask() : 0);
                }
                Unit unit9 = Unit.INSTANCE;
                return;
            case 10:
                for (Object obj7 : vals) {
                    Axes axes = obj7 instanceof Axes ? (Axes) obj7 : null;
                    w.u8(axes != null ? axes.getMask() : 0);
                }
                Unit unit10 = Unit.INSTANCE;
                return;
            case 11:
                int[] iArr5 = new int[size];
                for (int i10 = 0; i10 < size; i10++) {
                    Object obj8 = vals.get(i10);
                    BrickColorV brickColorV = obj8 instanceof BrickColorV ? (BrickColorV) obj8 : null;
                    if (brickColorV != null) {
                        i = brickColorV.getNumber();
                    } else {
                        i = INSTANCE.i(vals.get(i10));
                        if (i == 0) {
                            i = 194;
                        }
                    }
                    iArr5[i10] = i;
                }
                w.u32Array(iArr5);
                Unit unit11 = Unit.INSTANCE;
                return;
            case 12:
                List<? extends Object> list8 = vals;
                ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list8, 10));
                for (Object obj9 : list8) {
                    Color3 color3 = obj9 instanceof Color3 ? (Color3) obj9 : null;
                    if (color3 == null) {
                        color3 = new Color3(0.0f, 0.0f, 0.0f);
                    }
                    arrayList5.add(color3);
                }
                ArrayList arrayList6 = arrayList5;
                float[] fArr5 = new float[size];
                for (int i11 = 0; i11 < size; i11++) {
                    fArr5[i11] = ((Color3) arrayList6.get(i11)).getR();
                }
                w.f32Array(fArr5);
                float[] fArr6 = new float[size];
                for (int i12 = 0; i12 < size; i12++) {
                    fArr6[i12] = ((Color3) arrayList6.get(i12)).getG();
                }
                w.f32Array(fArr6);
                float[] fArr7 = new float[size];
                for (int i13 = 0; i13 < size; i13++) {
                    fArr7[i13] = ((Color3) arrayList6.get(i13)).getB();
                }
                w.f32Array(fArr7);
                Unit unit12 = Unit.INSTANCE;
                return;
            case 13:
                List<? extends Object> list9 = vals;
                ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list9, 10));
                for (Object obj10 : list9) {
                    Vector2 vector2 = obj10 instanceof Vector2 ? (Vector2) obj10 : null;
                    if (vector2 == null) {
                        vector2 = new Vector2(0.0f, 0.0f);
                    }
                    arrayList7.add(vector2);
                }
                ArrayList arrayList8 = arrayList7;
                float[] fArr8 = new float[size];
                for (int i14 = 0; i14 < size; i14++) {
                    fArr8[i14] = ((Vector2) arrayList8.get(i14)).getX();
                }
                w.f32Array(fArr8);
                float[] fArr9 = new float[size];
                for (int i15 = 0; i15 < size; i15++) {
                    fArr9[i15] = ((Vector2) arrayList8.get(i15)).getY();
                }
                w.f32Array(fArr9);
                Unit unit13 = Unit.INSTANCE;
                return;
            case 14:
                List<? extends Object> list10 = vals;
                ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list10, 10));
                for (Object obj11 : list10) {
                    Vector3 vector3 = obj11 instanceof Vector3 ? (Vector3) obj11 : null;
                    if (vector3 == null) {
                        vector3 = Vector3.INSTANCE.getZERO();
                    }
                    arrayList9.add(vector3);
                }
                ArrayList arrayList10 = arrayList9;
                float[] fArr10 = new float[size];
                for (int i16 = 0; i16 < size; i16++) {
                    fArr10[i16] = ((Vector3) arrayList10.get(i16)).getX();
                }
                w.f32Array(fArr10);
                float[] fArr11 = new float[size];
                for (int i17 = 0; i17 < size; i17++) {
                    fArr11[i17] = ((Vector3) arrayList10.get(i17)).getY();
                }
                w.f32Array(fArr11);
                float[] fArr12 = new float[size];
                for (int i18 = 0; i18 < size; i18++) {
                    fArr12[i18] = ((Vector3) arrayList10.get(i18)).getZ();
                }
                w.f32Array(fArr12);
                Unit unit14 = Unit.INSTANCE;
                return;
            case 15:
            case 17:
            case 29:
            default:
                for (Object obj12 : vals) {
                    if (obj12 == null || (str2 = obj12.toString()) == null) {
                        str2 = "";
                    }
                    w.string(str2);
                }
                Unit unit15 = Unit.INSTANCE;
                return;
            case 16:
                List<? extends Object> list11 = vals;
                ArrayList arrayList11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list11, 10));
                for (Object obj13 : list11) {
                    CFrame cFrame = obj13 instanceof CFrame ? (CFrame) obj13 : null;
                    if (cFrame == null) {
                        cFrame = CFrame.INSTANCE.getIDENTITY();
                    }
                    arrayList11.add(cFrame);
                }
                writeCFrames(w, arrayList11);
                Unit unit16 = Unit.INSTANCE;
                return;
            case 18:
                int[] iArr6 = new int[size];
                for (int i19 = 0; i19 < size; i19++) {
                    iArr6[i19] = INSTANCE.i(vals.get(i19));
                }
                w.u32Array(iArr6);
                Unit unit17 = Unit.INSTANCE;
                return;
            case 19:
                int[] iArr7 = new int[size];
                for (int i20 = 0; i20 < size; i20++) {
                    Object obj14 = vals.get(i20);
                    Instance instance = obj14 instanceof Instance ? (Instance) obj14 : null;
                    iArr7[i20] = (instance == null || (num = ref.get(instance)) == null) ? -1 : num.intValue();
                }
                w.refArray(iArr7);
                Unit unit18 = Unit.INSTANCE;
                return;
            case 20:
                for (Object obj15 : vals) {
                    Vector3int16 vector3int16 = obj15 instanceof Vector3int16 ? (Vector3int16) obj15 : null;
                    if (vector3int16 == null) {
                        vector3int16 = new Vector3int16(0, 0, 0);
                    }
                    w.u16(vector3int16.getX());
                    w.u16(vector3int16.getY());
                    w.u16(vector3int16.getZ());
                }
                Unit unit19 = Unit.INSTANCE;
                return;
            case 21:
                for (Object obj16 : vals) {
                    NumberSequence numberSequence = obj16 instanceof NumberSequence ? (NumberSequence) obj16 : null;
                    if (numberSequence == null) {
                        Object m315default = PropType.INSTANCE.m315default(type);
                        Intrinsics.checkNotNull(m315default, "null cannot be cast to non-null type com.exampletest.mobilestudiotest.model.NumberSequence");
                        numberSequence = (NumberSequence) m315default;
                    }
                    w.i32(numberSequence.getKeys().size());
                    for (NumberKey numberKey : numberSequence.getKeys()) {
                        w.f32(numberKey.getTime());
                        w.f32(numberKey.getValue());
                        w.f32(numberKey.getEnvelope());
                    }
                }
                Unit unit20 = Unit.INSTANCE;
                return;
            case 22:
                for (Object obj17 : vals) {
                    ColorSequence colorSequence = obj17 instanceof ColorSequence ? (ColorSequence) obj17 : null;
                    if (colorSequence == null) {
                        Object m315default2 = PropType.INSTANCE.m315default(type);
                        Intrinsics.checkNotNull(m315default2, "null cannot be cast to non-null type com.exampletest.mobilestudiotest.model.ColorSequence");
                        colorSequence = (ColorSequence) m315default2;
                    }
                    w.i32(colorSequence.getKeys().size());
                    for (ColorKey colorKey : colorSequence.getKeys()) {
                        w.f32(colorKey.getTime());
                        w.f32(colorKey.getColor().getR());
                        w.f32(colorKey.getColor().getG());
                        w.f32(colorKey.getColor().getB());
                        w.f32(colorKey.getEnvelope());
                    }
                }
                Unit unit21 = Unit.INSTANCE;
                return;
            case 23:
                for (Object obj18 : vals) {
                    NumberRange numberRange = obj18 instanceof NumberRange ? (NumberRange) obj18 : null;
                    if (numberRange == null) {
                        numberRange = new NumberRange(0.0f, 0.0f);
                    }
                    w.f32(numberRange.getMin());
                    w.f32(numberRange.getMax());
                }
                Unit unit22 = Unit.INSTANCE;
                return;
            case 24:
                List<? extends Object> list12 = vals;
                boolean z4 = false;
                ArrayList arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list12, 10));
                for (Object obj19 : list12) {
                    List<? extends Object> list13 = list12;
                    Rect rect = obj19 instanceof Rect ? (Rect) obj19 : null;
                    if (rect == null) {
                        z = z4;
                        rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
                    } else {
                        z = z4;
                    }
                    arrayList12.add(rect);
                    list12 = list13;
                    z4 = z;
                }
                ArrayList arrayList13 = arrayList12;
                float[] fArr13 = new float[size];
                for (int i21 = 0; i21 < size; i21++) {
                    fArr13[i21] = ((Rect) arrayList13.get(i21)).getMinX();
                }
                w.f32Array(fArr13);
                float[] fArr14 = new float[size];
                for (int i22 = 0; i22 < size; i22++) {
                    fArr14[i22] = ((Rect) arrayList13.get(i22)).getMinY();
                }
                w.f32Array(fArr14);
                float[] fArr15 = new float[size];
                for (int i23 = 0; i23 < size; i23++) {
                    fArr15[i23] = ((Rect) arrayList13.get(i23)).getMaxX();
                }
                w.f32Array(fArr15);
                float[] fArr16 = new float[size];
                for (int i24 = 0; i24 < size; i24++) {
                    fArr16[i24] = ((Rect) arrayList13.get(i24)).getMaxY();
                }
                w.f32Array(fArr16);
                Unit unit23 = Unit.INSTANCE;
                return;
            case 25:
                for (Object obj20 : vals) {
                    PhysicalProps physicalProps = obj20 instanceof PhysicalProps ? (PhysicalProps) obj20 : null;
                    if (physicalProps == null) {
                        physicalProps = new PhysicalProps(0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 126, null);
                    }
                    w.u8(physicalProps.getFlags());
                    if ((physicalProps.getFlags() & 1) != 0) {
                        w.f32(physicalProps.getDensity());
                        w.f32(physicalProps.getFriction());
                        w.f32(physicalProps.getElasticity());
                        w.f32(physicalProps.getFrictionWeight());
                        w.f32(physicalProps.getElasticityWeight());
                        if ((physicalProps.getFlags() & 2) != 0) {
                            w.f32(physicalProps.getAcoustic());
                        }
                    }
                }
                Unit unit24 = Unit.INSTANCE;
                return;
            case 26:
                List<? extends Object> list14 = vals;
                ArrayList arrayList14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list14, 10));
                for (Object obj21 : list14) {
                    Color3 color32 = obj21 instanceof Color3 ? (Color3) obj21 : null;
                    if (color32 == null) {
                        list3 = list14;
                        color32 = new Color3(0.0f, 0.0f, 0.0f);
                    } else {
                        list3 = list14;
                    }
                    arrayList14.add(color32);
                    list14 = list3;
                }
                ArrayList arrayList15 = arrayList14;
                byte[] bArr = new byte[size];
                for (int i25 = 0; i25 < size; i25++) {
                    bArr[i25] = writeValues$b(((Color3) arrayList15.get(i25)).getR());
                }
                w.bytes(bArr);
                byte[] bArr2 = new byte[size];
                for (int i26 = 0; i26 < size; i26++) {
                    bArr2[i26] = writeValues$b(((Color3) arrayList15.get(i26)).getG());
                }
                w.bytes(bArr2);
                byte[] bArr3 = new byte[size];
                for (int i27 = 0; i27 < size; i27++) {
                    bArr3[i27] = writeValues$b(((Color3) arrayList15.get(i27)).getB());
                }
                w.bytes(bArr3);
                Unit unit25 = Unit.INSTANCE;
                return;
            case 27:
                long[] jArr = new long[size];
                for (int i28 = 0; i28 < size; i28++) {
                    Object obj22 = vals.get(i28);
                    Number number2 = obj22 instanceof Number ? (Number) obj22 : null;
                    jArr[i28] = number2 != null ? number2.longValue() : 0L;
                }
                w.i64Array(jArr);
                Unit unit26 = Unit.INSTANCE;
                return;
            case 28:
                int[] iArr8 = new int[size];
                for (int i29 = 0; i29 < size; i29++) {
                    Object obj23 = vals.get(i29);
                    SharedStr sharedStr = obj23 instanceof SharedStr ? (SharedStr) obj23 : null;
                    if (sharedStr != null && (pair = sstr.get(Base64.getEncoder().encodeToString(sharedStr.getBytes()))) != null) {
                        intValue = pair.getFirst().intValue();
                        iArr8[i29] = intValue;
                    }
                    intValue = 0;
                    iArr8[i29] = intValue;
                }
                w.u32Array(iArr8);
                Unit unit27 = Unit.INSTANCE;
                return;
            case 30:
                List<? extends Object> list15 = vals;
                ArrayList arrayList16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list15, 10));
                for (Object obj24 : list15) {
                    OptionalCFrame optionalCFrame = obj24 instanceof OptionalCFrame ? (OptionalCFrame) obj24 : null;
                    if (optionalCFrame == null) {
                        optionalCFrame = new OptionalCFrame(null);
                    }
                    arrayList16.add(optionalCFrame);
                }
                ArrayList arrayList17 = arrayList16;
                w.u8(16);
                ArrayList arrayList18 = arrayList17;
                ArrayList arrayList19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList18, 10));
                Iterator it2 = arrayList18.iterator();
                while (it2.hasNext()) {
                    CFrame cframe = ((OptionalCFrame) it2.next()).getCframe();
                    if (cframe == null) {
                        cframe = CFrame.INSTANCE.getIDENTITY();
                    }
                    arrayList19.add(cframe);
                }
                writeCFrames(w, arrayList19);
                w.u8(2);
                Iterator it3 = arrayList17.iterator();
                while (it3.hasNext()) {
                    w.u8(((OptionalCFrame) it3.next()).getCframe() != null ? 1 : 0);
                }
                Unit unit28 = Unit.INSTANCE;
                return;
            case 31:
                byte[] bArr4 = new byte[size * 16];
                List<? extends Object> list16 = vals;
                boolean z5 = false;
                int i30 = 0;
                for (Object obj25 : list16) {
                    int i31 = i30 + 1;
                    if (i30 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    UniqueId uniqueId = obj25 instanceof UniqueId ? (UniqueId) obj25 : null;
                    if (uniqueId == null || (bytes = uniqueId.getBytes()) == null) {
                        list4 = list16;
                        z2 = z5;
                    } else {
                        list4 = list16;
                        z2 = z5;
                        ArraysKt.copyInto(bytes, bArr4, i30 * 16, 0, 16);
                    }
                    i30 = i31;
                    list16 = list4;
                    z5 = z2;
                }
                w.interleaved(bArr4, size, 16);
                Unit unit29 = Unit.INSTANCE;
                return;
            case 32:
                for (Object obj26 : vals) {
                    FontValue fontValue = obj26 instanceof FontValue ? (FontValue) obj26 : null;
                    if (fontValue == null) {
                        Object m315default3 = PropType.INSTANCE.m315default(type);
                        Intrinsics.checkNotNull(m315default3, "null cannot be cast to non-null type com.exampletest.mobilestudiotest.model.FontValue");
                        fontValue = (FontValue) m315default3;
                    }
                    w.string(fontValue.getFamily());
                    w.u16(fontValue.getWeight());
                    w.u8(fontValue.getStyle());
                    w.string(fontValue.getCachedFaceId());
                }
                Unit unit30 = Unit.INSTANCE;
                return;
            case 33:
                byte[] bArr5 = new byte[size * 8];
                List<? extends Object> list17 = vals;
                boolean z6 = false;
                int i32 = 0;
                for (Object obj27 : list17) {
                    int i33 = i32 + 1;
                    if (i32 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    SecurityCaps securityCaps = obj27 instanceof SecurityCaps ? (SecurityCaps) obj27 : null;
                    long value = securityCaps != null ? securityCaps.getValue() : 0L;
                    int i34 = 0;
                    while (true) {
                        list5 = list17;
                        if (i34 < 8) {
                            bArr5[(i32 * 8) + i34] = (byte) (value >>> (56 - (i34 * 8)));
                            i34++;
                            list17 = list5;
                            z6 = z6;
                        }
                    }
                    i32 = i33;
                    list17 = list5;
                }
                w.interleaved(bArr5, size, 8);
                Unit unit31 = Unit.INSTANCE;
                return;
            case 34:
                List<? extends Object> list18 = vals;
                ArrayList arrayList20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list18, 10));
                for (Object obj28 : list18) {
                    ContentValue contentValue = obj28 instanceof ContentValue ? (ContentValue) obj28 : null;
                    if (contentValue == null) {
                        String str3 = obj28 instanceof String ? (String) obj28 : null;
                        if (str3 != null) {
                            String str4 = str3;
                            contentValue = str4.length() == 0 ? new ContentValue(0, null, null, 6, null) : new ContentValue(1, str4, null, 4, null);
                        } else {
                            contentValue = null;
                        }
                        if (contentValue == null) {
                            contentValue = new ContentValue(0, null, null, 6, null);
                        }
                    }
                    arrayList20.add(contentValue);
                }
                ArrayList arrayList21 = arrayList20;
                int[] iArr9 = new int[size];
                for (int i35 = 0; i35 < size; i35++) {
                    iArr9[i35] = (((ContentValue) arrayList21.get(i35)).getSourceType() == 2 && ((ContentValue) arrayList21.get(i35)).getObj() == null) ? 0 : ((ContentValue) arrayList21.get(i35)).getSourceType();
                }
                w.i32Array(iArr9);
                ArrayList arrayList22 = new ArrayList();
                for (Object obj29 : arrayList21) {
                    if (((ContentValue) obj29).getSourceType() == 1) {
                        arrayList22.add(obj29);
                    }
                }
                ArrayList arrayList23 = arrayList22;
                w.i32(arrayList23.size());
                Iterator it4 = arrayList23.iterator();
                while (it4.hasNext()) {
                    w.string(((ContentValue) it4.next()).getUri());
                }
                ArrayList arrayList24 = new ArrayList();
                for (Object obj30 : arrayList21) {
                    ContentValue contentValue2 = (ContentValue) obj30;
                    boolean z7 = z3;
                    ArrayList arrayList25 = arrayList23;
                    if ((contentValue2.getSourceType() != 2 || contentValue2.getObj() == null) ? false : z7) {
                        arrayList24.add(obj30);
                    }
                    arrayList23 = arrayList25;
                    z3 = z7;
                }
                ArrayList arrayList26 = arrayList24;
                w.i32(arrayList26.size());
                int size2 = arrayList26.size();
                int[] iArr10 = new int[size2];
                for (int i36 = 0; i36 < size2; i36++) {
                    Instance obj31 = ((ContentValue) arrayList26.get(i36)).getObj();
                    Intrinsics.checkNotNull(obj31);
                    Integer num2 = ref.get(obj31);
                    iArr10[i36] = num2 != null ? num2.intValue() : -1;
                }
                w.refArray(iArr10);
                w.i32(0);
                Unit unit32 = Unit.INSTANCE;
                return;
        }
    }

    private static final byte writeValues$b(float f) {
        return (byte) ((RangesKt.coerceIn(f, 0.0f, 1.0f) * 255.0f) + 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x046f A[LOOP:19: B:207:0x0421->B:219:0x046f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x046d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] write(java.util.List<? extends com.exampletest.mobilestudiotest.model.Instance> r40, java.util.Map<java.lang.String, java.lang.String> r41) {
        /*
            Method dump skipped, instructions count: 1639
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.format.RbxBinaryWriter.write(java.util.List, java.util.Map):byte[]");
    }
}
