package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class PathParser {
    private static final String LOGTAG = "PathParser";

    /* loaded from: classes.dex */
    private static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        ExtractFloatResult() {
        }
    }

    /* loaded from: classes.dex */
    public static class PathDataNode {
        private final float[] mParams;
        private char mType;

        /* renamed from: -$$Nest$fgetmParams, reason: not valid java name */
        static /* bridge */ /* synthetic */ float[] m76$$Nest$fgetmParams(PathDataNode pathDataNode) {
            return pathDataNode.mParams;
        }

        /* renamed from: -$$Nest$fgetmType, reason: not valid java name */
        static /* bridge */ /* synthetic */ char m77$$Nest$fgetmType(PathDataNode pathDataNode) {
            return pathDataNode.mType;
        }

        /* renamed from: -$$Nest$fputmType, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m78$$Nest$fputmType(PathDataNode pathDataNode, char c) {
            pathDataNode.mType = c;
        }

        /* renamed from: -$$Nest$smaddCommand, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m79$$Nest$smaddCommand(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            addCommand(path, fArr, c, c2, fArr2);
        }

        PathDataNode(char c, float[] fArr) {
            this.mType = c;
            this.mParams = fArr;
        }

        PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            this.mParams = PathParser.copyOfRange(pathDataNode.mParams, 0, pathDataNode.mParams.length);
        }

        private static void addCommand(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            int i2;
            float f;
            float f2;
            int i3;
            boolean z;
            int i4;
            float f3;
            boolean z2;
            float f4;
            Path path2 = path;
            boolean z3 = false;
            float f5 = fArr[0];
            boolean z4 = true;
            float f6 = fArr[1];
            char c3 = 2;
            float f7 = fArr[2];
            float f8 = fArr[3];
            float f9 = fArr[4];
            float f10 = fArr[5];
            switch (c2) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case LocationRequestCompat.QUALITY_LOW_POWER /* 104 */:
                case 'v':
                    i = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
                case 't':
                    i = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    f5 = f9;
                    f6 = f10;
                    f7 = f9;
                    f8 = f10;
                    path2.moveTo(f5, f6);
                    i = 2;
                    break;
                default:
                    i = 2;
                    break;
            }
            int i5 = 0;
            float f11 = f5;
            float f12 = f6;
            float f13 = f7;
            float f14 = f8;
            float f15 = f9;
            float f16 = f10;
            char c4 = c;
            while (i5 < fArr2.length) {
                boolean z5 = z3;
                boolean z6 = z4;
                char c5 = c3;
                switch (c2) {
                    case 'A':
                        float f17 = f12;
                        i2 = i5;
                        drawArc(path, f11, f17, fArr2[i2 + 5], fArr2[i2 + 6], fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f ? z6 : z5, fArr2[i2 + 4] != 0.0f ? z6 : z5);
                        float f18 = fArr2[i2 + 5];
                        f = fArr2[i2 + 6];
                        f11 = f18;
                        f13 = f18;
                        f14 = f;
                        break;
                    case 'C':
                        i2 = i5;
                        path2.cubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3], fArr2[i2 + 4], fArr2[i2 + 5]);
                        float f19 = fArr2[i2 + 4];
                        f = fArr2[i2 + 5];
                        f11 = f19;
                        f13 = fArr2[i2 + 2];
                        f14 = fArr2[i2 + 3];
                        break;
                    case 'H':
                        float f20 = f12;
                        i2 = i5;
                        path2.lineTo(fArr2[i2 + 0], f20);
                        f11 = fArr2[i2 + 0];
                        f = f20;
                        break;
                    case 'L':
                        i2 = i5;
                        path2.lineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                        f11 = fArr2[i2 + 0];
                        f = fArr2[i2 + 1];
                        break;
                    case 'M':
                        i2 = i5;
                        float f21 = fArr2[i2 + 0];
                        float f22 = fArr2[i2 + 1];
                        if (i2 <= 0) {
                            path2.moveTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                            f11 = f21;
                            f = f22;
                            f15 = f21;
                            f16 = f22;
                            break;
                        } else {
                            path2.lineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                            f11 = f21;
                            f = f22;
                            break;
                        }
                    case 'Q':
                        i2 = i5;
                        path2.quadTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        f13 = fArr2[i2 + 0];
                        f14 = fArr2[i2 + 1];
                        f11 = fArr2[i2 + 2];
                        f = fArr2[i2 + 3];
                        break;
                    case 'S':
                        float f23 = f12;
                        i2 = i5;
                        char c6 = c4;
                        float f24 = f11;
                        float f25 = f24;
                        if (c6 == 'c' || c6 == 's' || c6 == 'C' || c6 == 'S') {
                            f25 = (f24 * 2.0f) - f13;
                            f2 = (f23 * 2.0f) - f14;
                        } else {
                            f2 = f23;
                        }
                        path2.cubicTo(f25, f2, fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        f13 = fArr2[i2 + 0];
                        f14 = fArr2[i2 + 1];
                        f11 = fArr2[i2 + 2];
                        f = fArr2[i2 + 3];
                        break;
                    case 'T':
                        float f26 = f12;
                        i2 = i5;
                        char c7 = c4;
                        float f27 = f11;
                        float f28 = f27;
                        float f29 = f26;
                        if (c7 == 'q' || c7 == 't' || c7 == 'Q' || c7 == 'T') {
                            f28 = (f27 * 2.0f) - f13;
                            f29 = (f26 * 2.0f) - f14;
                        }
                        path2.quadTo(f28, f29, fArr2[i2 + 0], fArr2[i2 + 1]);
                        f13 = f28;
                        f14 = f29;
                        f11 = fArr2[i2 + 0];
                        f = fArr2[i2 + 1];
                        break;
                    case 'V':
                        i2 = i5;
                        path2.lineTo(f11, fArr2[i2 + 0]);
                        f = fArr2[i2 + 0];
                        break;
                    case 'a':
                        float f30 = fArr2[i5 + 5] + f11;
                        float f31 = fArr2[i5 + 6] + f12;
                        float f32 = fArr2[i5 + 0];
                        float f33 = fArr2[i5 + 1];
                        float f34 = fArr2[i5 + 2];
                        if (fArr2[i5 + 3] != 0.0f) {
                            i3 = i5;
                            z = z6;
                        } else {
                            i3 = i5;
                            z = z5;
                        }
                        if (fArr2[i3 + 4] != 0.0f) {
                            i4 = i3;
                            f3 = f11;
                            z2 = z6;
                        } else {
                            i4 = i3;
                            f3 = f11;
                            z2 = z5;
                        }
                        float f35 = f12;
                        i2 = i4;
                        drawArc(path, f3, f35, f30, f31, f32, f33, f34, z, z2);
                        f11 = f3 + fArr2[i2 + 5];
                        f = fArr2[i2 + 6] + f35;
                        f13 = f11;
                        f14 = f;
                        break;
                    case 'c':
                        path2.rCubicTo(fArr2[i5 + 0], fArr2[i5 + 1], fArr2[i5 + 2], fArr2[i5 + 3], fArr2[i5 + 4], fArr2[i5 + 5]);
                        float f36 = fArr2[i5 + 2] + f11;
                        float f37 = f12 + fArr2[i5 + 3];
                        f11 += fArr2[i5 + 4];
                        f13 = f36;
                        f14 = f37;
                        f = f12 + fArr2[i5 + 5];
                        i2 = i5;
                        break;
                    case LocationRequestCompat.QUALITY_LOW_POWER /* 104 */:
                        path2.rLineTo(fArr2[i5 + 0], 0.0f);
                        f11 += fArr2[i5 + 0];
                        f = f12;
                        i2 = i5;
                        break;
                    case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                        path2.rLineTo(fArr2[i5 + 0], fArr2[i5 + 1]);
                        f11 += fArr2[i5 + 0];
                        f = f12 + fArr2[i5 + 1];
                        i2 = i5;
                        break;
                    case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
                        f11 += fArr2[i5 + 0];
                        float f38 = f12 + fArr2[i5 + 1];
                        if (i5 <= 0) {
                            path2.rMoveTo(fArr2[i5 + 0], fArr2[i5 + 1]);
                            f15 = f11;
                            f16 = f38;
                            f = f38;
                            i2 = i5;
                            break;
                        } else {
                            path2.rLineTo(fArr2[i5 + 0], fArr2[i5 + 1]);
                            f = f38;
                            i2 = i5;
                            break;
                        }
                    case 'q':
                        path2.rQuadTo(fArr2[i5 + 0], fArr2[i5 + 1], fArr2[i5 + 2], fArr2[i5 + 3]);
                        float f39 = fArr2[i5 + 0] + f11;
                        float f40 = f12 + fArr2[i5 + 1];
                        f11 += fArr2[i5 + 2];
                        f13 = f39;
                        f14 = f40;
                        f = f12 + fArr2[i5 + 3];
                        i2 = i5;
                        break;
                    case 's':
                        float f41 = 0.0f;
                        if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                            f41 = f11 - f13;
                            f4 = f12 - f14;
                        } else {
                            f4 = 0.0f;
                        }
                        path2.rCubicTo(f41, f4, fArr2[i5 + 0], fArr2[i5 + 1], fArr2[i5 + 2], fArr2[i5 + 3]);
                        float f42 = fArr2[i5 + 0] + f11;
                        float f43 = f12 + fArr2[i5 + 1];
                        f11 += fArr2[i5 + 2];
                        f13 = f42;
                        f14 = f43;
                        f = f12 + fArr2[i5 + 3];
                        i2 = i5;
                        break;
                    case 't':
                        float f44 = 0.0f;
                        float f45 = 0.0f;
                        if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                            f44 = f11 - f13;
                            f45 = f12 - f14;
                        }
                        path2.rQuadTo(f44, f45, fArr2[i5 + 0], fArr2[i5 + 1]);
                        float f46 = f11 + f44;
                        f11 += fArr2[i5 + 0];
                        f13 = f46;
                        f14 = f12 + f45;
                        f = f12 + fArr2[i5 + 1];
                        i2 = i5;
                        break;
                    case 'v':
                        path2.rLineTo(0.0f, fArr2[i5 + 0]);
                        f = f12 + fArr2[i5 + 0];
                        i2 = i5;
                        break;
                    default:
                        float f47 = f12;
                        i2 = i5;
                        f = f47;
                        break;
                }
                c4 = c2;
                i5 = i2 + i;
                path2 = path;
                f12 = f;
                z3 = z5;
                z4 = z6;
                c3 = c5;
            }
            fArr[z3 ? 1 : 0] = f11;
            fArr[z4 ? 1 : 0] = f12;
            fArr[c3] = f13;
            fArr[3] = f14;
            fArr[4] = f15;
            fArr[5] = f16;
        }

        private static void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int ceil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            double d11 = ((-d10) * sin * sin2) + (d4 * cos * cos2);
            double d12 = d9 / ceil;
            double d13 = d8;
            int i = 0;
            double d14 = d5;
            double d15 = (((-d10) * cos) * sin2) - ((d4 * sin) * cos2);
            double d16 = d6;
            while (i < ceil) {
                double d17 = d13 + d12;
                double sin3 = Math.sin(d17);
                double cos3 = Math.cos(d17);
                double d18 = d12;
                double d19 = (d + ((d10 * cos) * cos3)) - ((d4 * sin) * sin3);
                int i2 = ceil;
                double d20 = d2 + (d10 * sin * cos3) + (d4 * cos * sin3);
                double d21 = cos;
                double d22 = (((-d10) * d21) * sin3) - ((d4 * sin) * cos3);
                double d23 = ((-d10) * sin * sin3) + (d4 * d21 * cos3);
                double tan = Math.tan((d17 - d13) / 2.0d);
                double sin4 = (Math.sin(d17 - d13) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) (d14 + (sin4 * d15)), (float) (d16 + (sin4 * d11)), (float) (d19 - (sin4 * d22)), (float) (d20 - (sin4 * d23)), (float) d19, (float) d20);
                d13 = d17;
                d16 = d20;
                d15 = d22;
                d11 = d23;
                i++;
                d14 = d19;
                ceil = i2;
                cos = d21;
                d12 = d18;
                sin2 = sin2;
                sin = sin;
                cos2 = cos2;
                d10 = d3;
            }
        }

        private static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            double radians = Math.toRadians(f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = ((f * cos) + (f2 * sin)) / f5;
            double d4 = (((-f) * sin) + (f2 * cos)) / f6;
            double d5 = ((f3 * cos) + (f4 * sin)) / f5;
            double d6 = (((-f3) * sin) + (f4 * cos)) / f6;
            double d7 = d3 - d5;
            double d8 = d4 - d6;
            double d9 = (d3 + d5) / 2.0d;
            double d10 = (d4 + d6) / 2.0d;
            double d11 = (d7 * d7) + (d8 * d8);
            if (d11 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d12 = (1.0d / d11) - 0.25d;
            if (d12 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d11);
                float sqrt = (float) (Math.sqrt(d11) / 1.99999d);
                drawArc(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d12);
            double d13 = sqrt2 * d7;
            double d14 = sqrt2 * d8;
            if (z == z2) {
                d = d9 - d14;
                d2 = d10 + d13;
            } else {
                d = d9 + d14;
                d2 = d10 - d13;
            }
            double atan2 = Math.atan2(d4 - d2, d3 - d);
            double atan22 = Math.atan2(d6 - d2, d5 - d) - atan2;
            double d15 = d * f5;
            double d16 = d2 * f6;
            arcToBezier(path, (d15 * cos) - (d16 * sin), (d15 * sin) + (d16 * cos), f5, f6, f, f2, radians, atan2, z2 != ((atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1)) >= 0) ? atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d : atan22);
        }

        @Deprecated
        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            PathParser.nodesToPath(pathDataNodeArr, path);
        }

        public float[] getParams() {
            return this.mParams;
        }

        public char getType() {
            return this.mType;
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f) {
            this.mType = pathDataNode.mType;
            for (int i = 0; i < pathDataNode.mParams.length; i++) {
                this.mParams[i] = (pathDataNode.mParams[i] * (1.0f - f)) + (pathDataNode2.mParams[i] * f);
            }
        }
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c, float[] fArr) {
        arrayList.add(new PathDataNode(c, fArr));
    }

    public static boolean canMorph(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            if (PathDataNode.m77$$Nest$fgetmType(pathDataNodeArr[i]) != PathDataNode.m77$$Nest$fgetmType(pathDataNodeArr2[i]) || PathDataNode.m76$$Nest$fgetmParams(pathDataNodeArr[i]).length != PathDataNode.m76$$Nest$fgetmParams(pathDataNodeArr2[i]).length) {
                return false;
            }
        }
        return true;
    }

    static float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, Math.min(i3, length - i));
        return fArr2;
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        int i = 0;
        int i2 = 1;
        ArrayList arrayList = new ArrayList();
        while (i2 < str.length()) {
            int nextStart = nextStart(str, i2);
            String trim = str.substring(i, nextStart).trim();
            if (!trim.isEmpty()) {
                addNode(arrayList, trim.charAt(0), getFloats(trim));
            }
            i = nextStart;
            i2 = nextStart + 1;
        }
        if (i2 - i == 1 && i < str.length()) {
            addNode(arrayList, str.charAt(i), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[0]);
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        try {
            PathDataNode.nodesToPath(createNodesFromPathData(str), path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error in parsing " + str, e);
        }
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0014. Please report as an issue. */
    private static void extract(String str, int i, ExtractFloatResult extractFloatResult) {
        boolean z = false;
        extractFloatResult.mEndWithNegOrDot = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = i; i2 < str.length(); i2++) {
            boolean z4 = z3;
            z3 = false;
            switch (str.charAt(i2)) {
                case ' ':
                case ',':
                    z = true;
                    break;
                case '-':
                    if (i2 != i && !z4) {
                        z = true;
                        extractFloatResult.mEndWithNegOrDot = true;
                        break;
                    }
                    break;
                case '.':
                    if (z2) {
                        z = true;
                        extractFloatResult.mEndWithNegOrDot = true;
                        break;
                    } else {
                        z2 = true;
                        break;
                    }
                case 'E':
                case TypedValues.TYPE_TARGET /* 101 */:
                    z3 = true;
                    break;
            }
            if (z) {
                extractFloatResult.mEndPosition = i2;
            }
        }
        extractFloatResult.mEndPosition = i2;
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            int i = 0;
            int i2 = 1;
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            while (i2 < length) {
                extract(str, i2, extractFloatResult);
                int i3 = extractFloatResult.mEndPosition;
                if (i2 < i3) {
                    fArr[i] = Float.parseFloat(str.substring(i2, i3));
                    i++;
                }
                i2 = extractFloatResult.mEndWithNegOrDot ? i3 : i3 + 1;
            }
            return copyOfRange(fArr, 0, i);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }

    public static void interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, float f, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3) {
        if (!interpolatePathDataNodes(pathDataNodeArr, pathDataNodeArr2, pathDataNodeArr3, f)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    @Deprecated
    public static boolean interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3, float f) {
        if (pathDataNodeArr.length != pathDataNodeArr2.length || pathDataNodeArr2.length != pathDataNodeArr3.length) {
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
        }
        if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr[i].interpolatePathDataNode(pathDataNodeArr2[i], pathDataNodeArr3[i], f);
        }
        return true;
    }

    private static int nextStart(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
        float[] fArr = new float[6];
        char c = 'm';
        for (PathDataNode pathDataNode : pathDataNodeArr) {
            PathDataNode.m79$$Nest$smaddCommand(path, fArr, c, PathDataNode.m77$$Nest$fgetmType(pathDataNode), PathDataNode.m76$$Nest$fgetmParams(pathDataNode));
            c = PathDataNode.m77$$Nest$fgetmType(pathDataNode);
        }
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            PathDataNode.m78$$Nest$fputmType(pathDataNodeArr[i], PathDataNode.m77$$Nest$fgetmType(pathDataNodeArr2[i]));
            for (int i2 = 0; i2 < PathDataNode.m76$$Nest$fgetmParams(pathDataNodeArr2[i]).length; i2++) {
                PathDataNode.m76$$Nest$fgetmParams(pathDataNodeArr[i])[i2] = PathDataNode.m76$$Nest$fgetmParams(pathDataNodeArr2[i])[i2];
            }
        }
    }
}
