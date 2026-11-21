package androidx.core.content.res;

import androidx.core.graphics.ColorUtils;

/* loaded from: classes.dex */
public class CamColor {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;
    private final float mJ;
    private final float mJstar;
    private final float mM;
    private final float mQ;
    private final float mS;

    CamColor(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.mHue = f;
        this.mChroma = f2;
        this.mJ = f3;
        this.mQ = f4;
        this.mM = f5;
        this.mS = f6;
        this.mJstar = f7;
        this.mAstar = f8;
        this.mBstar = f9;
    }

    private static CamColor findCamByJ(float f, float f2, float f3) {
        float f4 = 0.0f;
        float f5 = 100.0f;
        float f6 = 1000.0f;
        float f7 = 1000.0f;
        CamColor camColor = null;
        while (Math.abs(f4 - f5) > LIGHTNESS_SEARCH_ENDPOINT) {
            float f8 = f4 + ((f5 - f4) / 2.0f);
            int viewedInSrgb = fromJch(f8, f2, f).viewedInSrgb();
            float lStarFromInt = CamUtils.lStarFromInt(viewedInSrgb);
            float abs = Math.abs(f3 - lStarFromInt);
            if (abs < 0.2f) {
                CamColor fromColor = fromColor(viewedInSrgb);
                float distance = fromColor.distance(fromJch(fromColor.getJ(), fromColor.getChroma(), f));
                if (distance <= 1.0f) {
                    f6 = abs;
                    f7 = distance;
                    camColor = fromColor;
                }
            }
            if (f6 == 0.0f && f7 == 0.0f) {
                break;
            }
            if (lStarFromInt < f3) {
                f4 = f8;
            } else {
                f5 = f8;
            }
        }
        return camColor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CamColor fromColor(int i) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        fromColorInViewingConditions(i, ViewingConditions.DEFAULT, fArr, fArr2);
        return new CamColor(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    static void fromColorInViewingConditions(int i, ViewingConditions viewingConditions, float[] fArr, float[] fArr2) {
        CamUtils.xyzFromInt(i, fArr2);
        float[][] fArr3 = CamUtils.XYZ_TO_CAM16RGB;
        float f = (fArr2[0] * fArr3[0][0]) + (fArr2[1] * fArr3[0][1]) + (fArr2[2] * fArr3[0][2]);
        float f2 = (fArr2[0] * fArr3[1][0]) + (fArr2[1] * fArr3[1][1]) + (fArr2[2] * fArr3[1][2]);
        float f3 = (fArr2[0] * fArr3[2][0]) + (fArr2[1] * fArr3[2][1]) + (fArr2[2] * fArr3[2][2]);
        float f4 = viewingConditions.getRgbD()[0] * f;
        float f5 = viewingConditions.getRgbD()[1] * f2;
        float f6 = viewingConditions.getRgbD()[2] * f3;
        float pow = (float) Math.pow((viewingConditions.getFl() * Math.abs(f4)) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow((viewingConditions.getFl() * Math.abs(f5)) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((viewingConditions.getFl() * Math.abs(f6)) / 100.0d, 0.42d);
        float signum = ((Math.signum(f4) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f5) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f6) * 400.0f) * pow3) / (27.13f + pow3);
        float f7 = ((float) (((signum * 11.0d) + (signum2 * (-12.0d))) + signum3)) / 11.0f;
        float f8 = (((signum * 20.0f) + (signum2 * 20.0f)) + (21.0f * signum3)) / 20.0f;
        float f9 = (((40.0f * signum) + (signum2 * 20.0f)) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(((float) ((signum + signum2) - (signum3 * 2.0d))) / 9.0f, f7)) * 180.0f) / 3.1415927f;
        float f10 = atan2 < 0.0f ? atan2 + 360.0f : atan2 >= 360.0f ? atan2 - 360.0f : atan2;
        float f11 = (3.1415927f * f10) / 180.0f;
        float pow4 = ((float) Math.pow((viewingConditions.getNbb() * f9) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ())) * 100.0f;
        float c = (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(pow4 / 100.0f)) * (viewingConditions.getAw() + 4.0f) * viewingConditions.getFlRoot();
        float sqrt = ((float) Math.sqrt(pow4 / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d)) * ((float) Math.pow(((((3846.1538f * (((float) (Math.cos((((((double) f10) < 20.14d ? f10 + 360.0f : f10) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f)) * viewingConditions.getNc()) * viewingConditions.getNcb()) * ((float) Math.sqrt((f7 * f7) + (r1 * r1)))) / (f8 + 0.305f), 0.9d));
        float flRoot = viewingConditions.getFlRoot() * sqrt;
        float sqrt2 = ((float) Math.sqrt((viewingConditions.getC() * r3) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f12 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((0.0228f * flRoot) + 1.0f)) * 43.85965f;
        float cos = ((float) Math.cos(f11)) * log;
        float sin = ((float) Math.sin(f11)) * log;
        fArr2[0] = f10;
        fArr2[1] = sqrt;
        if (fArr != null) {
            fArr[0] = pow4;
            fArr[1] = c;
            fArr[2] = flRoot;
            fArr[3] = sqrt2;
            fArr[4] = f12;
            fArr[5] = cos;
            fArr[6] = sin;
        }
    }

    private static CamColor fromJch(float f, float f2, float f3) {
        return fromJchInFrame(f, f2, f3, ViewingConditions.DEFAULT);
    }

    private static CamColor fromJchInFrame(float f, float f2, float f3, ViewingConditions viewingConditions) {
        float c = (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(f / 100.0d)) * (viewingConditions.getAw() + 4.0f) * viewingConditions.getFlRoot();
        float flRoot = f2 * viewingConditions.getFlRoot();
        float sqrt = ((float) Math.sqrt((viewingConditions.getC() * (f2 / ((float) Math.sqrt(f / 100.0d)))) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f4 = (3.1415927f * f3) / 180.0f;
        float f5 = (1.7f * f) / ((0.007f * f) + 1.0f);
        float log = ((float) Math.log((flRoot * 0.0228d) + 1.0d)) * 43.85965f;
        return new CamColor(f3, f2, f, c, flRoot, sqrt, f5, log * ((float) Math.cos(f4)), log * ((float) Math.sin(f4)));
    }

    public static void getM3HCTfromColor(int i, float[] fArr) {
        fromColorInViewingConditions(i, ViewingConditions.DEFAULT, null, fArr);
        fArr[2] = CamUtils.lStarFromInt(i);
    }

    public static int toColor(float f, float f2, float f3) {
        return toColor(f, f2, f3, ViewingConditions.DEFAULT);
    }

    static int toColor(float f, float f2, float f3, ViewingConditions viewingConditions) {
        if (f2 < 1.0d || Math.round(f3) <= 0.0d || Math.round(f3) >= 100.0d) {
            return CamUtils.intFromLStar(f3);
        }
        float min = f >= 0.0f ? Math.min(360.0f, f) : 0.0f;
        float f4 = f2;
        float f5 = f2;
        float f6 = 0.0f;
        boolean z = true;
        CamColor camColor = null;
        while (Math.abs(f6 - f4) >= CHROMA_SEARCH_ENDPOINT) {
            CamColor findCamByJ = findCamByJ(min, f5, f3);
            if (!z) {
                if (findCamByJ == null) {
                    f4 = f5;
                } else {
                    camColor = findCamByJ;
                    f6 = f5;
                }
                f5 = f6 + ((f4 - f6) / 2.0f);
            } else {
                if (findCamByJ != null) {
                    return findCamByJ.viewed(viewingConditions);
                }
                z = false;
                f5 = f6 + ((f4 - f6) / 2.0f);
            }
        }
        return camColor == null ? CamUtils.intFromLStar(f3) : camColor.viewed(viewingConditions);
    }

    float distance(CamColor camColor) {
        float jStar = getJStar() - camColor.getJStar();
        float aStar = getAStar() - camColor.getAStar();
        float bStar = getBStar() - camColor.getBStar();
        return (float) (Math.pow(Math.sqrt((jStar * jStar) + (aStar * aStar) + (bStar * bStar)), 0.63d) * 1.41d);
    }

    float getAStar() {
        return this.mAstar;
    }

    float getBStar() {
        return this.mBstar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getChroma() {
        return this.mChroma;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getHue() {
        return this.mHue;
    }

    float getJ() {
        return this.mJ;
    }

    float getJStar() {
        return this.mJstar;
    }

    float getM() {
        return this.mM;
    }

    float getQ() {
        return this.mQ;
    }

    float getS() {
        return this.mS;
    }

    int viewed(ViewingConditions viewingConditions) {
        float pow = (float) Math.pow(((((double) getChroma()) == 0.0d || ((double) getJ()) == 0.0d) ? 0.0f : getChroma() / ((float) Math.sqrt(getJ() / 100.0d))) / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        float hue = (getHue() * 3.1415927f) / 180.0f;
        float cos = ((float) (Math.cos(hue + 2.0d) + 3.8d)) * 0.25f;
        float aw = viewingConditions.getAw() * ((float) Math.pow(getJ() / 100.0d, (1.0d / viewingConditions.getC()) / viewingConditions.getZ()));
        float nc = 3846.1538f * cos * viewingConditions.getNc() * viewingConditions.getNcb();
        float nbb = aw / viewingConditions.getNbb();
        float sin = (float) Math.sin(hue);
        float cos2 = (float) Math.cos(hue);
        float f = (((0.305f + nbb) * 23.0f) * pow) / (((23.0f * nc) + ((11.0f * pow) * cos2)) + ((108.0f * pow) * sin));
        float f2 = f * cos2;
        float f3 = f * sin;
        float pow2 = ((float) Math.pow((float) Math.max(0.0d, (Math.abs(r15) * 27.13d) / (400.0d - Math.abs(r15))), 2.380952380952381d)) * Math.signum((((nbb * 460.0f) + (451.0f * f2)) + (288.0f * f3)) / 1403.0f) * (100.0f / viewingConditions.getFl());
        float signum = Math.signum((((nbb * 460.0f) - (891.0f * f2)) - (261.0f * f3)) / 1403.0f) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(r17) * 27.13d) / (400.0d - Math.abs(r17))), 2.380952380952381d));
        float signum2 = Math.signum((((460.0f * nbb) - (220.0f * f2)) - (6300.0f * f3)) / 1403.0f) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(r14) * 27.13d) / (400.0d - Math.abs(r14))), 2.380952380952381d));
        float f4 = pow2 / viewingConditions.getRgbD()[0];
        float f5 = signum / viewingConditions.getRgbD()[1];
        float f6 = signum2 / viewingConditions.getRgbD()[2];
        float[][] fArr = CamUtils.CAM16RGB_TO_XYZ;
        return ColorUtils.XYZToColor((fArr[0][0] * f4) + (fArr[0][1] * f5) + (fArr[0][2] * f6), (fArr[1][0] * f4) + (fArr[1][1] * f5) + (fArr[1][2] * f6), (fArr[2][0] * f4) + (fArr[2][1] * f5) + (fArr[2][2] * f6));
    }

    int viewedInSrgb() {
        return viewed(ViewingConditions.DEFAULT);
    }
}
