package com.google.android.material.color.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class TemperatureCache {
    private final Hct input;
    private Hct precomputedComplement;
    private List<Hct> precomputedHctsByHue;
    private List<Hct> precomputedHctsByTemp;
    private Map<Hct, Double> precomputedTempsByHct;

    /* renamed from: $r8$lambda$hQjdIIwNZ3zUpaMt273Bn5gwl-w, reason: not valid java name */
    public static /* synthetic */ int m378$r8$lambda$hQjdIIwNZ3zUpaMt273Bn5gwlw(Double d, Double d2) {
        return d.compareTo(d2);
    }

    private TemperatureCache() {
        throw new UnsupportedOperationException();
    }

    public TemperatureCache(Hct hct) {
        this.input = hct;
    }

    private Hct getColdest() {
        return getHctsByTemp().get(0);
    }

    private List<Hct> getHctsByHue() {
        if (this.precomputedHctsByHue != null) {
            return this.precomputedHctsByHue;
        }
        ArrayList arrayList = new ArrayList();
        for (double d = 0.0d; d <= 360.0d; d += 1.0d) {
            arrayList.add(Hct.from(d, this.input.getChroma(), this.input.getTone()));
        }
        this.precomputedHctsByHue = Collections.unmodifiableList(arrayList);
        return this.precomputedHctsByHue;
    }

    private List<Hct> getHctsByTemp() {
        if (this.precomputedHctsByTemp != null) {
            return this.precomputedHctsByTemp;
        }
        ArrayList arrayList = new ArrayList(getHctsByHue());
        arrayList.add(this.input);
        Collections.sort(arrayList, Comparator.comparing(new TemperatureCache$$ExternalSyntheticLambda0(this), new TemperatureCache$$ExternalSyntheticLambda1()));
        this.precomputedHctsByTemp = arrayList;
        return this.precomputedHctsByTemp;
    }

    private Map<Hct, Double> getTempsByHct() {
        if (this.precomputedTempsByHct != null) {
            return this.precomputedTempsByHct;
        }
        ArrayList<Hct> arrayList = new ArrayList(getHctsByHue());
        arrayList.add(this.input);
        HashMap hashMap = new HashMap();
        for (Hct hct : arrayList) {
            hashMap.put(hct, Double.valueOf(rawTemperature(hct)));
        }
        this.precomputedTempsByHct = hashMap;
        return this.precomputedTempsByHct;
    }

    private Hct getWarmest() {
        return getHctsByTemp().get(getHctsByTemp().size() - 1);
    }

    private static boolean isBetween(double d, double d2, double d3) {
        return d2 < d3 ? d2 <= d && d <= d3 : d2 <= d || d <= d3;
    }

    public static double rawTemperature(Hct hct) {
        double[] labFromArgb = ColorUtils.labFromArgb(hct.toInt());
        return ((Math.pow(Math.hypot(labFromArgb[1], labFromArgb[2]), 1.07d) * 0.02d) * Math.cos(Math.toRadians(MathUtils.sanitizeDegreesDouble(MathUtils.sanitizeDegreesDouble(Math.toDegrees(Math.atan2(labFromArgb[2], labFromArgb[1]))) - 50.0d)))) - 0.5d;
    }

    public List<Hct> getAnalogousColors() {
        return getAnalogousColors(5, 12);
    }

    public List<Hct> getAnalogousColors(int i, int i2) {
        int round = (int) Math.round(this.input.getHue());
        Hct hct = getHctsByHue().get(round);
        double relativeTemperature = getRelativeTemperature(hct);
        ArrayList arrayList = new ArrayList();
        arrayList.add(hct);
        double d = 0.0d;
        for (int i3 = 0; i3 < 360; i3++) {
            double relativeTemperature2 = getRelativeTemperature(getHctsByHue().get(MathUtils.sanitizeDegreesInt(round + i3)));
            double abs = Math.abs(relativeTemperature2 - relativeTemperature);
            relativeTemperature = relativeTemperature2;
            d += abs;
        }
        int i4 = 1;
        double d2 = d / i2;
        double d3 = 0.0d;
        double relativeTemperature3 = getRelativeTemperature(hct);
        while (true) {
            int i5 = round;
            if (arrayList.size() >= i2) {
                break;
            }
            Hct hct2 = getHctsByHue().get(MathUtils.sanitizeDegreesInt(i5 + i4));
            double relativeTemperature4 = getRelativeTemperature(hct2);
            d3 += Math.abs(relativeTemperature4 - relativeTemperature3);
            Hct hct3 = hct;
            double size = arrayList.size() * d2;
            boolean z = d3 >= size;
            int i6 = 1;
            while (z && arrayList.size() < i2) {
                arrayList.add(hct2);
                size = (arrayList.size() + i6) * d2;
                z = d3 >= size;
                i6++;
            }
            i4++;
            if (i4 > 360) {
                while (arrayList.size() < i2) {
                    arrayList.add(hct2);
                }
                relativeTemperature3 = relativeTemperature4;
            } else {
                round = i5;
                hct = hct3;
                relativeTemperature3 = relativeTemperature4;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.input);
        int floor = (int) Math.floor((i - 1.0d) / 2.0d);
        for (int i7 = 1; i7 < floor + 1; i7++) {
            int i8 = 0 - i7;
            while (i8 < 0) {
                i8 += arrayList.size();
            }
            if (i8 >= arrayList.size()) {
                i8 %= arrayList.size();
            }
            arrayList2.add(0, (Hct) arrayList.get(i8));
        }
        int i9 = (i - floor) - 1;
        for (int i10 = 1; i10 < i9 + 1; i10++) {
            int i11 = i10;
            while (i11 < 0) {
                i11 += arrayList.size();
            }
            if (i11 >= arrayList.size()) {
                i11 %= arrayList.size();
            }
            arrayList2.add((Hct) arrayList.get(i11));
        }
        return arrayList2;
    }

    public Hct getComplement() {
        double d;
        double d2;
        if (this.precomputedComplement != null) {
            return this.precomputedComplement;
        }
        double hue = getColdest().getHue();
        double doubleValue = getTempsByHct().get(getColdest()).doubleValue();
        double hue2 = getWarmest().getHue();
        double doubleValue2 = getTempsByHct().get(getWarmest()).doubleValue() - doubleValue;
        boolean isBetween = isBetween(this.input.getHue(), hue, hue2);
        double d3 = isBetween ? hue2 : hue;
        double d4 = isBetween ? hue : hue2;
        Hct hct = getHctsByHue().get((int) Math.round(this.input.getHue()));
        double relativeTemperature = 1.0d - getRelativeTemperature(this.input);
        double d5 = 0.0d;
        double d6 = 1000.0d;
        while (d5 <= 360.0d) {
            double sanitizeDegreesDouble = MathUtils.sanitizeDegreesDouble(d3 + (1.0d * d5));
            if (isBetween(sanitizeDegreesDouble, d3, d4)) {
                d = relativeTemperature;
                d2 = hue;
                Hct hct2 = getHctsByHue().get((int) Math.round(sanitizeDegreesDouble));
                double abs = Math.abs(d - ((getTempsByHct().get(hct2).doubleValue() - doubleValue) / doubleValue2));
                if (abs < d6) {
                    d6 = abs;
                    hct = hct2;
                }
            } else {
                d = relativeTemperature;
                d2 = hue;
            }
            d5 += 1.0d;
            relativeTemperature = d;
            hue = d2;
        }
        this.precomputedComplement = hct;
        return this.precomputedComplement;
    }

    public double getRelativeTemperature(Hct hct) {
        double doubleValue = getTempsByHct().get(getWarmest()).doubleValue() - getTempsByHct().get(getColdest()).doubleValue();
        double doubleValue2 = getTempsByHct().get(hct).doubleValue() - getTempsByHct().get(getColdest()).doubleValue();
        if (doubleValue == 0.0d) {
            return 0.5d;
        }
        return doubleValue2 / doubleValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getHctsByTemp$0$com-google-android-material-color-utilities-TemperatureCache, reason: not valid java name */
    public /* synthetic */ Double m379xb7a75f35(Hct hct) {
        return getTempsByHct().get(hct);
    }
}
