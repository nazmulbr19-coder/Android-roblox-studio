package com.exampletest.mobilestudiotest.render;

import android.opengl.GLES20;
import com.exampletest.mobilestudiotest.model.Vector3;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Meshes.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001%B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0005J\u001a\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\tJ\u0010\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\tJ*\u0010\u001a\u001a\u00020\u00052\u0018\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c2\u0006\u0010\u0018\u001a\u00020\tH\u0002J\u0010\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\tJ\u0010\u0010 \u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\tJ\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0005R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/Meshes;", "", "<init>", "()V", "upload", "Lcom/exampletest/mobilestudiotest/render/Mesh;", "arr", "", "stride", "", "mode", "cpu", "v", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "x", "", "y", "z", "H", "cube", "wedge", "cornerWedge", "sphere", "rings", "segs", "cylinder", "revolve", "segments", "", "Lkotlin/Pair;", "Lcom/exampletest/mobilestudiotest/render/Meshes$Prof;", "head", "cylinderY", "headFace", "quad", "screenQuad", "boxLines", "Prof", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class Meshes {
    private static final float H = 0.5f;
    public static final Meshes INSTANCE = new Meshes();

    /* compiled from: Meshes.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/Meshes$Prof;", "", "r", "", "y", "nr", "ny", "<init>", "(FFFF)V", "getR", "()F", "getY", "getNr", "getNy", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    private static final class Prof {
        private final float nr;
        private final float ny;
        private final float r;
        private final float y;

        public Prof(float f, float f2, float f3, float f4) {
            this.r = f;
            this.y = f2;
            this.nr = f3;
            this.ny = f4;
        }

        public final float getNr() {
            return this.nr;
        }

        public final float getNy() {
            return this.ny;
        }

        public final float getR() {
            return this.r;
        }

        public final float getY() {
            return this.y;
        }
    }

    private Meshes() {
    }

    public static /* synthetic */ Mesh cylinder$default(Meshes meshes, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 24;
        }
        return meshes.cylinder(i);
    }

    private static final Pair<Float, Float> cylinder$ring(int i, int i2) {
        double d = (i2 * 6.283185307179586d) / i;
        return TuplesKt.to(Float.valueOf((float) (Math.cos(d) * 0.5d)), Float.valueOf((float) (Math.sin(d) * 0.5d)));
    }

    public static /* synthetic */ Mesh cylinderY$default(Meshes meshes, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 24;
        }
        return meshes.cylinderY(i);
    }

    public static /* synthetic */ Mesh head$default(Meshes meshes, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 28;
        }
        return meshes.head(i);
    }

    private static final void headFace$put(int i, int i2, double d, ArrayList<Float> arrayList, float f, float f2, float f3, int i3, int i4) {
        float f4 = i3 / i;
        float f5 = i4 / i2;
        double d2 = ((-1.5707963267948966d) - (d / 2.0d)) + (f4 * d);
        arrayList.add(Float.valueOf((float) (Math.cos(d2) * f)));
        arrayList.add(Float.valueOf(f2 + ((f3 - f2) * f5)));
        arrayList.add(Float.valueOf((float) (Math.sin(d2) * f)));
        arrayList.add(Float.valueOf(1.0f - f4));
        arrayList.add(Float.valueOf((0.76f * f5) + 0.12f));
    }

    private final Mesh revolve(List<Pair<Prof, Prof>> segments, int segs) {
        Vector3 vector3;
        Vector3 vector32;
        MeshBuilder meshBuilder = new MeshBuilder(null, 1, null);
        for (Pair<Prof, Prof> pair : segments) {
            Prof component1 = pair.component1();
            Prof component2 = pair.component2();
            for (int i = 0; i < segs; i++) {
                double d = (i * 6.283185307179586d) / segs;
                double d2 = ((i + 1) * 6.283185307179586d) / segs;
                Vector3 revolve$p3 = revolve$p3(component1, d);
                Vector3 revolve$p32 = revolve$p3(component1, d2);
                Vector3 revolve$p33 = revolve$p3(component2, d);
                Vector3 revolve$p34 = revolve$p3(component2, d2);
                Vector3 revolve$n3 = revolve$n3(component1, d);
                Vector3 revolve$n32 = revolve$n3(component1, d2);
                Vector3 revolve$n33 = revolve$n3(component2, d);
                Vector3 revolve$n34 = revolve$n3(component2, d2);
                if (component1.getR() > 1.0E-4f) {
                    meshBuilder.smoothTri(revolve$p3, revolve$n3, revolve$p32, revolve$n32, revolve$p34, revolve$n34);
                    vector3 = revolve$p34;
                    vector32 = revolve$n34;
                } else {
                    vector3 = revolve$p34;
                    vector32 = revolve$n34;
                }
                if (component2.getR() > 1.0E-4f) {
                    meshBuilder.smoothTri(revolve$p3, revolve$n3, vector3, vector32, revolve$p33, revolve$n33);
                }
            }
        }
        return meshBuilder.upload();
    }

    private static final Vector3 revolve$n3(Prof prof, double d) {
        return INSTANCE.v((float) (Math.cos(d) * prof.getNr()), prof.getNy(), (float) (Math.sin(d) * prof.getNr())).getUnit();
    }

    private static final Vector3 revolve$p3(Prof prof, double d) {
        return INSTANCE.v((float) (Math.cos(d) * prof.getR()), prof.getY(), (float) (Math.sin(d) * prof.getR()));
    }

    public static /* synthetic */ Mesh sphere$default(Meshes meshes, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 14;
        }
        if ((i3 & 2) != 0) {
            i2 = 24;
        }
        return meshes.sphere(i, i2);
    }

    private static final Vector3 sphere$pt(int i, int i2, int i3, int i4) {
        double d = (i3 * 3.141592653589793d) / i;
        double d2 = (i4 * 6.283185307179586d) / i2;
        return INSTANCE.v(((float) (Math.sin(d) * Math.cos(d2))) * 0.5f, ((float) Math.cos(d)) * 0.5f, ((float) (Math.sin(d) * Math.sin(d2))) * 0.5f);
    }

    public static /* synthetic */ Mesh upload$default(Meshes meshes, float[] fArr, int i, int i2, float[] fArr2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            fArr2 = null;
        }
        return meshes.upload(fArr, i, i2, fArr2);
    }

    private final Vector3 v(float x, float y, float z) {
        return new Vector3(x, y, z);
    }

    public final Mesh boxLines() {
        float[][] fArr = new float[8];
        int i = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            float f = 0.5f;
            float f2 = (i2 & 1) != 0 ? 0.5f : -0.5f;
            float f3 = (i2 & 2) != 0 ? 0.5f : -0.5f;
            if ((i2 & 4) == 0) {
                f = -0.5f;
            }
            float[] fArr2 = new float[3];
            fArr2[0] = f2;
            fArr2[1] = f3;
            fArr2[2] = f;
            fArr[i2] = fArr2;
        }
        int[] iArr = {0, 1, 2, 3, 4, 5, 6, 7, 0, 2, 1, 3, 4, 6, 5, 7, 0, 4, 1, 5, 2, 6, 3, 7};
        float[] fArr3 = new float[iArr.length * 3];
        int i3 = 0;
        int length = iArr.length;
        while (i < length) {
            ArraysKt.copyInto$default(fArr[iArr[i]], fArr3, i3 * 3, 0, 0, 12, (Object) null);
            i++;
            i3++;
        }
        return upload$default(this, fArr3, 3, 1, null, 8, null);
    }

    public final Mesh cornerWedge() {
        MeshBuilder meshBuilder = new MeshBuilder(v(0.2f, -0.25f, -0.2f));
        Vector3 v = v(0.5f, 0.5f, -0.5f);
        Vector3 v2 = v(-0.5f, -0.5f, -0.5f);
        Vector3 v3 = v(0.5f, -0.5f, -0.5f);
        Vector3 v4 = v(0.5f, -0.5f, 0.5f);
        Vector3 v5 = v(-0.5f, -0.5f, 0.5f);
        meshBuilder.quad(v2, v3, v4, v5);
        meshBuilder.tri(v3, v4, v);
        meshBuilder.tri(v2, v3, v);
        meshBuilder.tri(v2, v5, v);
        meshBuilder.tri(v5, v4, v);
        return meshBuilder.upload();
    }

    public final Mesh cube() {
        MeshBuilder meshBuilder = new MeshBuilder(null, 1, null);
        Vector3[] vector3Arr = new Vector3[8];
        for (int i = 0; i < 8; i++) {
            Meshes meshes = INSTANCE;
            float f = 0.5f;
            float f2 = (i & 1) != 0 ? 0.5f : -0.5f;
            float f3 = (i & 2) != 0 ? 0.5f : -0.5f;
            if ((i & 4) == 0) {
                f = -0.5f;
            }
            vector3Arr[i] = meshes.v(f2, f3, f);
        }
        meshBuilder.quad(vector3Arr[0], vector3Arr[1], vector3Arr[3], vector3Arr[2]);
        meshBuilder.quad(vector3Arr[4], vector3Arr[5], vector3Arr[7], vector3Arr[6]);
        meshBuilder.quad(vector3Arr[0], vector3Arr[1], vector3Arr[5], vector3Arr[4]);
        meshBuilder.quad(vector3Arr[2], vector3Arr[3], vector3Arr[7], vector3Arr[6]);
        meshBuilder.quad(vector3Arr[0], vector3Arr[2], vector3Arr[6], vector3Arr[4]);
        meshBuilder.quad(vector3Arr[1], vector3Arr[3], vector3Arr[7], vector3Arr[5]);
        return meshBuilder.upload();
    }

    public final Mesh cylinder(int segs) {
        MeshBuilder meshBuilder = new MeshBuilder(null, 1, null);
        for (int i = 0; i < segs; i++) {
            Pair<Float, Float> cylinder$ring = cylinder$ring(segs, i);
            float floatValue = cylinder$ring.component1().floatValue();
            float floatValue2 = cylinder$ring.component2().floatValue();
            Pair<Float, Float> cylinder$ring2 = cylinder$ring(segs, i + 1);
            float floatValue3 = cylinder$ring2.component1().floatValue();
            float floatValue4 = cylinder$ring2.component2().floatValue();
            Vector3 unit = v(0.0f, floatValue, floatValue2).getUnit();
            Vector3 unit2 = v(0.0f, floatValue3, floatValue4).getUnit();
            Vector3 v = v(-0.5f, floatValue, floatValue2);
            Vector3 v2 = v(0.5f, floatValue, floatValue2);
            Vector3 v3 = v(0.5f, floatValue3, floatValue4);
            Vector3 v4 = v(-0.5f, floatValue3, floatValue4);
            meshBuilder.smoothTri(v, unit, v2, unit, v3, unit2);
            meshBuilder.smoothTri(v, unit, v3, unit2, v4, unit2);
            meshBuilder.tri(v(0.5f, 0.0f, 0.0f), v(0.5f, floatValue, floatValue2), v(0.5f, floatValue3, floatValue4));
            meshBuilder.tri(v(-0.5f, 0.0f, 0.0f), v(-0.5f, floatValue3, floatValue4), v(-0.5f, floatValue, floatValue2));
        }
        return meshBuilder.upload();
    }

    public final Mesh cylinderY(int segs) {
        return revolve(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(new Prof(0.0f, -0.5f, 0.0f, -1.0f), new Prof(0.5f, -0.5f, 0.0f, -1.0f)), TuplesKt.to(new Prof(0.5f, -0.5f, 1.0f, 0.0f), new Prof(0.5f, 0.5f, 1.0f, 0.0f)), TuplesKt.to(new Prof(0.5f, 0.5f, 0.0f, 1.0f), new Prof(0.0f, 0.5f, 0.0f, 1.0f))}), segs);
    }

    public final Mesh head(int segs) {
        double d;
        ArrayList arrayList = new ArrayList();
        float f = -0.5f;
        arrayList.add(new Prof(0.0f, -0.5f, 0.0f, -1.0f));
        int i = 0;
        while (true) {
            d = 1.5707963267948966d;
            double d2 = ((i * 1.5707963267948966d) / 6) - 1.5707963267948966d;
            float f2 = f;
            arrayList.add(new Prof((0.5f - 0.2f) + ((float) (Math.cos(d2) * 0.2f)), 0.2f + f2 + ((float) (Math.sin(d2) * 0.2f)), (float) Math.cos(d2), (float) Math.sin(d2)));
            if (i == 6) {
                break;
            }
            i++;
            f = f2;
        }
        int i2 = 0;
        while (true) {
            double d3 = (i2 * d) / 6;
            arrayList.add(new Prof((0.5f - 0.2f) + ((float) (Math.cos(d3) * 0.2f)), (0.5f - 0.2f) + ((float) (Math.sin(d3) * 0.2f)), (float) Math.cos(d3), (float) Math.sin(d3)));
            if (i2 == 6) {
                arrayList.add(new Prof(0.0f, 0.5f, 0.0f, 1.0f));
                return revolve(CollectionsKt.zipWithNext(arrayList), segs);
            }
            i2++;
            d = 1.5707963267948966d;
        }
    }

    public final Mesh headFace() {
        double radians = Math.toRadians(150.0d);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < 16) {
            int i2 = 0;
            while (i2 < 8) {
                headFace$put(16, 8, radians, arrayList, 0.506f, 0.36f, -0.36f, i, i2);
                int i3 = i2;
                headFace$put(16, 8, radians, arrayList, 0.506f, 0.36f, -0.36f, i, i3 + 1);
                int i4 = i;
                headFace$put(16, 8, radians, arrayList, 0.506f, 0.36f, -0.36f, i4 + 1, i3 + 1);
                headFace$put(16, 8, radians, arrayList, 0.506f, 0.36f, -0.36f, i4, i3);
                headFace$put(16, 8, radians, arrayList, 0.506f, 0.36f, -0.36f, i4 + 1, i3 + 1);
                headFace$put(16, 8, radians, arrayList, 0.506f, 0.36f, -0.36f, i4 + 1, i3);
                i2 = i3 + 1;
                i = i4;
            }
            i++;
        }
        return upload$default(this, CollectionsKt.toFloatArray(arrayList), 5, 4, null, 8, null);
    }

    public final Mesh quad() {
        return upload$default(this, new float[]{-0.5f, -0.5f, 0.0f, 0.0f, 1.0f, 0.5f, -0.5f, 0.0f, 1.0f, 1.0f, 0.5f, 0.5f, 0.0f, 1.0f, 0.0f, -0.5f, -0.5f, 0.0f, 0.0f, 1.0f, 0.5f, 0.5f, 0.0f, 1.0f, 0.0f, -0.5f, 0.5f, 0.0f, 0.0f, 0.0f}, 5, 4, null, 8, null);
    }

    public final Mesh screenQuad() {
        return upload$default(this, new float[]{-1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f}, 2, 4, null, 8, null);
    }

    public final Mesh sphere(int rings, int segs) {
        Vector3 vector3;
        MeshBuilder meshBuilder = new MeshBuilder(null, 1, null);
        for (int i = 0; i < rings; i++) {
            for (int i2 = 0; i2 < segs; i2++) {
                Vector3 sphere$pt = sphere$pt(rings, segs, i, i2);
                Vector3 sphere$pt2 = sphere$pt(rings, segs, i + 1, i2);
                Vector3 sphere$pt3 = sphere$pt(rings, segs, i + 1, i2 + 1);
                Vector3 sphere$pt4 = sphere$pt(rings, segs, i, i2 + 1);
                if (i != 0) {
                    meshBuilder.smoothTri(sphere$pt, sphere$pt.getUnit(), sphere$pt2, sphere$pt2.getUnit(), sphere$pt4, sphere$pt4.getUnit());
                    vector3 = sphere$pt2;
                } else {
                    vector3 = sphere$pt2;
                }
                if (i != rings - 1) {
                    meshBuilder.smoothTri(vector3, vector3.getUnit(), sphere$pt3, sphere$pt3.getUnit(), sphere$pt4, sphere$pt4.getUnit());
                }
            }
        }
        return meshBuilder.upload();
    }

    public final Mesh upload(float[] arr, int stride, int mode, float[] cpu) {
        Intrinsics.checkNotNullParameter(arr, "arr");
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(arr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(arr).position(0);
        int[] iArr = new int[1];
        GLES20.glGenBuffers(1, iArr, 0);
        GLES20.glBindBuffer(34962, iArr[0]);
        GLES20.glBufferData(34962, arr.length * 4, asFloatBuffer, 35044);
        GLES20.glBindBuffer(34962, 0);
        return new Mesh(iArr[0], arr.length / stride, mode, stride, cpu);
    }

    public final Mesh wedge() {
        MeshBuilder meshBuilder = new MeshBuilder(v(0.0f, -0.2f, 0.2f));
        Vector3 v = v(-0.5f, -0.5f, -0.5f);
        Vector3 v2 = v(0.5f, -0.5f, -0.5f);
        Vector3 v3 = v(-0.5f, -0.5f, 0.5f);
        Vector3 v4 = v(0.5f, -0.5f, 0.5f);
        Vector3 v5 = v(-0.5f, 0.5f, 0.5f);
        Vector3 v6 = v(0.5f, 0.5f, 0.5f);
        meshBuilder.quad(v, v2, v4, v3);
        meshBuilder.quad(v3, v4, v6, v5);
        meshBuilder.quad(v, v2, v6, v5);
        meshBuilder.tri(v, v3, v5);
        meshBuilder.tri(v2, v4, v6);
        return meshBuilder.upload();
    }
}
