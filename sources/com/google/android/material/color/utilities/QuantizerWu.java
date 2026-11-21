package com.google.android.material.color.utilities;

import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class QuantizerWu implements Quantizer {
    private static final int INDEX_BITS = 5;
    private static final int INDEX_COUNT = 33;
    private static final int TOTAL_SIZE = 35937;
    Box[] cubes;
    double[] moments;
    int[] momentsB;
    int[] momentsG;
    int[] momentsR;
    int[] weights;

    /* loaded from: classes.dex */
    private static final class Box {
        int b0;
        int b1;
        int g0;
        int g1;
        int r0;
        int r1;
        int vol;

        private Box() {
            this.r0 = 0;
            this.r1 = 0;
            this.g0 = 0;
            this.g1 = 0;
            this.b0 = 0;
            this.b1 = 0;
            this.vol = 0;
        }

        /* synthetic */ Box(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private static final class CreateBoxesResult {
        int resultCount;

        CreateBoxesResult(int i, int i2) {
            this.resultCount = i2;
        }
    }

    /* loaded from: classes.dex */
    private enum Direction {
        RED,
        GREEN,
        BLUE
    }

    /* loaded from: classes.dex */
    private static final class MaximizeResult {
        int cutLocation;
        double maximum;

        MaximizeResult(int i, double d) {
            this.cutLocation = i;
            this.maximum = d;
        }
    }

    static int bottom(Box box, Direction direction, int[] iArr) {
        switch (direction) {
            case RED:
                return (((-iArr[getIndex(box.r0, box.g1, box.b1)]) + iArr[getIndex(box.r0, box.g1, box.b0)]) + iArr[getIndex(box.r0, box.g0, box.b1)]) - iArr[getIndex(box.r0, box.g0, box.b0)];
            case GREEN:
                return (((-iArr[getIndex(box.r1, box.g0, box.b1)]) + iArr[getIndex(box.r1, box.g0, box.b0)]) + iArr[getIndex(box.r0, box.g0, box.b1)]) - iArr[getIndex(box.r0, box.g0, box.b0)];
            case BLUE:
                return (((-iArr[getIndex(box.r1, box.g1, box.b0)]) + iArr[getIndex(box.r1, box.g0, box.b0)]) + iArr[getIndex(box.r0, box.g1, box.b0)]) - iArr[getIndex(box.r0, box.g0, box.b0)];
            default:
                throw new IllegalArgumentException("unexpected direction " + direction);
        }
    }

    static int getIndex(int i, int i2, int i3) {
        return (i << 10) + (i << 6) + i + (i2 << 5) + i2 + i3;
    }

    static int top(Box box, Direction direction, int i, int[] iArr) {
        switch (direction) {
            case RED:
                return ((iArr[getIndex(i, box.g1, box.b1)] - iArr[getIndex(i, box.g1, box.b0)]) - iArr[getIndex(i, box.g0, box.b1)]) + iArr[getIndex(i, box.g0, box.b0)];
            case GREEN:
                return ((iArr[getIndex(box.r1, i, box.b1)] - iArr[getIndex(box.r1, i, box.b0)]) - iArr[getIndex(box.r0, i, box.b1)]) + iArr[getIndex(box.r0, i, box.b0)];
            case BLUE:
                return ((iArr[getIndex(box.r1, box.g1, i)] - iArr[getIndex(box.r1, box.g0, i)]) - iArr[getIndex(box.r0, box.g1, i)]) + iArr[getIndex(box.r0, box.g0, i)];
            default:
                throw new IllegalArgumentException("unexpected direction " + direction);
        }
    }

    static int volume(Box box, int[] iArr) {
        return ((((((iArr[getIndex(box.r1, box.g1, box.b1)] - iArr[getIndex(box.r1, box.g1, box.b0)]) - iArr[getIndex(box.r1, box.g0, box.b1)]) + iArr[getIndex(box.r1, box.g0, box.b0)]) - iArr[getIndex(box.r0, box.g1, box.b1)]) + iArr[getIndex(box.r0, box.g1, box.b0)]) + iArr[getIndex(box.r0, box.g0, box.b1)]) - iArr[getIndex(box.r0, box.g0, box.b0)];
    }

    void constructHistogram(Map<Integer, Integer> map) {
        QuantizerWu quantizerWu = this;
        quantizerWu.weights = new int[TOTAL_SIZE];
        quantizerWu.momentsR = new int[TOTAL_SIZE];
        quantizerWu.momentsG = new int[TOTAL_SIZE];
        quantizerWu.momentsB = new int[TOTAL_SIZE];
        quantizerWu.moments = new double[TOTAL_SIZE];
        for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator(); it.hasNext(); it = it) {
            Map.Entry<Integer, Integer> next = it.next();
            int intValue = next.getKey().intValue();
            int intValue2 = next.getValue().intValue();
            int redFromArgb = ColorUtils.redFromArgb(intValue);
            int greenFromArgb = ColorUtils.greenFromArgb(intValue);
            int blueFromArgb = ColorUtils.blueFromArgb(intValue);
            int index = getIndex((redFromArgb >> 3) + 1, (greenFromArgb >> 3) + 1, (blueFromArgb >> 3) + 1);
            int[] iArr = quantizerWu.weights;
            iArr[index] = iArr[index] + intValue2;
            int[] iArr2 = quantizerWu.momentsR;
            iArr2[index] = iArr2[index] + (redFromArgb * intValue2);
            int[] iArr3 = quantizerWu.momentsG;
            iArr3[index] = iArr3[index] + (greenFromArgb * intValue2);
            int[] iArr4 = quantizerWu.momentsB;
            iArr4[index] = iArr4[index] + (blueFromArgb * intValue2);
            double[] dArr = quantizerWu.moments;
            dArr[index] = dArr[index] + (intValue2 * ((redFromArgb * redFromArgb) + (greenFromArgb * greenFromArgb) + (blueFromArgb * blueFromArgb)));
            quantizerWu = this;
        }
    }

    CreateBoxesResult createBoxes(int i) {
        this.cubes = new Box[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.cubes[i2] = new Box(null);
        }
        double[] dArr = new double[i];
        Box box = this.cubes[0];
        box.r1 = 32;
        box.g1 = 32;
        box.b1 = 32;
        int i3 = i;
        int i4 = 0;
        int i5 = 1;
        while (true) {
            if (i5 >= i) {
                break;
            }
            if (cut(this.cubes[i4], this.cubes[i5]).booleanValue()) {
                dArr[i4] = this.cubes[i4].vol > 1 ? variance(this.cubes[i4]) : 0.0d;
                dArr[i5] = this.cubes[i5].vol > 1 ? variance(this.cubes[i5]) : 0.0d;
            } else {
                dArr[i4] = 0.0d;
                i5--;
            }
            i4 = 0;
            double d = dArr[0];
            for (int i6 = 1; i6 <= i5; i6++) {
                if (dArr[i6] > d) {
                    d = dArr[i6];
                    i4 = i6;
                }
            }
            if (d <= 0.0d) {
                i3 = i5 + 1;
                break;
            }
            i5++;
        }
        return new CreateBoxesResult(i, i3);
    }

    void createMoments() {
        int i = 1;
        while (true) {
            int i2 = 33;
            if (i >= 33) {
                return;
            }
            int[] iArr = new int[33];
            int[] iArr2 = new int[33];
            int[] iArr3 = new int[33];
            int[] iArr4 = new int[33];
            double[] dArr = new double[33];
            int i3 = 1;
            while (i3 < i2) {
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                double d = 0.0d;
                int i8 = 1;
                while (i8 < i2) {
                    int index = getIndex(i, i3, i8);
                    i4 += this.weights[index];
                    i5 += this.momentsR[index];
                    i6 += this.momentsG[index];
                    i7 += this.momentsB[index];
                    d += this.moments[index];
                    iArr[i8] = iArr[i8] + i4;
                    iArr2[i8] = iArr2[i8] + i5;
                    iArr3[i8] = iArr3[i8] + i6;
                    iArr4[i8] = iArr4[i8] + i7;
                    dArr[i8] = dArr[i8] + d;
                    int index2 = getIndex(i - 1, i3, i8);
                    this.weights[index] = this.weights[index2] + iArr[i8];
                    this.momentsR[index] = this.momentsR[index2] + iArr2[i8];
                    this.momentsG[index] = this.momentsG[index2] + iArr3[i8];
                    this.momentsB[index] = this.momentsB[index2] + iArr4[i8];
                    this.moments[index] = this.moments[index2] + dArr[i8];
                    i8++;
                    i = i;
                    i2 = 33;
                }
                i3++;
                i2 = 33;
            }
            i++;
        }
    }

    List<Integer> createResult(int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            Box box = this.cubes[i2];
            int volume = volume(box, this.weights);
            if (volume > 0) {
                arrayList.add(Integer.valueOf((((volume(box, this.momentsR) / volume) & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | (((volume(box, this.momentsG) / volume) & 255) << 8) | ((volume(box, this.momentsB) / volume) & 255)));
            }
        }
        return arrayList;
    }

    Boolean cut(Box box, Box box2) {
        boolean z;
        Direction direction;
        int volume = volume(box, this.momentsR);
        int volume2 = volume(box, this.momentsG);
        int volume3 = volume(box, this.momentsB);
        int volume4 = volume(box, this.weights);
        MaximizeResult maximize = maximize(box, Direction.RED, box.r0 + 1, box.r1, volume, volume2, volume3, volume4);
        MaximizeResult maximize2 = maximize(box, Direction.GREEN, box.g0 + 1, box.g1, volume, volume2, volume3, volume4);
        MaximizeResult maximize3 = maximize(box, Direction.BLUE, box.b0 + 1, box.b1, volume, volume2, volume3, volume4);
        double d = maximize.maximum;
        double d2 = maximize2.maximum;
        double d3 = maximize3.maximum;
        if (d < d2 || d < d3) {
            z = true;
            direction = (d2 < d || d2 < d3) ? Direction.BLUE : Direction.GREEN;
        } else {
            z = true;
            if (maximize.cutLocation < 0) {
                return false;
            }
            direction = Direction.RED;
        }
        Direction direction2 = direction;
        box2.r1 = box.r1;
        box2.g1 = box.g1;
        box2.b1 = box.b1;
        switch (direction2) {
            case RED:
                box.r1 = maximize.cutLocation;
                box2.r0 = box.r1;
                box2.g0 = box.g0;
                box2.b0 = box.b0;
                break;
            case GREEN:
                box.g1 = maximize2.cutLocation;
                box2.r0 = box.r0;
                box2.g0 = box.g1;
                box2.b0 = box.b0;
                break;
            case BLUE:
                box.b1 = maximize3.cutLocation;
                box2.r0 = box.r0;
                box2.g0 = box.g0;
                box2.b0 = box.b1;
                break;
        }
        box.vol = (box.b1 - box.b0) * (box.g1 - box.g0) * (box.r1 - box.r0);
        box2.vol = (box2.b1 - box2.b0) * (box2.g1 - box2.g0) * (box2.r1 - box2.r0);
        return Boolean.valueOf(z);
    }

    MaximizeResult maximize(Box box, Direction direction, int i, int i2, int i3, int i4, int i5, int i6) {
        QuantizerWu quantizerWu = this;
        Box box2 = box;
        int bottom = bottom(box2, direction, quantizerWu.momentsR);
        int bottom2 = bottom(box2, direction, quantizerWu.momentsG);
        int bottom3 = bottom(box2, direction, quantizerWu.momentsB);
        int bottom4 = bottom(box2, direction, quantizerWu.weights);
        double d = 0.0d;
        int i7 = -1;
        int i8 = i;
        while (i8 < i2) {
            int i9 = bottom;
            int pVar = i9 + top(box2, direction, i8, quantizerWu.momentsR);
            int pVar2 = top(box2, direction, i8, quantizerWu.momentsG) + bottom2;
            int pVar3 = top(box2, direction, i8, quantizerWu.momentsB) + bottom3;
            int pVar4 = top(box2, direction, i8, quantizerWu.weights) + bottom4;
            if (pVar4 != 0) {
                double d2 = (((pVar * pVar) + (pVar2 * pVar2)) + (pVar3 * pVar3)) / pVar4;
                pVar = i3 - pVar;
                pVar2 = i4 - pVar2;
                pVar3 = i5 - pVar3;
                pVar4 = i6 - pVar4;
                if (pVar4 != 0) {
                    double d3 = d2 + ((((pVar * pVar) + (pVar2 * pVar2)) + (pVar3 * pVar3)) / pVar4);
                    if (d3 > d) {
                        d = d3;
                        i7 = i8;
                    }
                }
            }
            i8++;
            quantizerWu = this;
            box2 = box;
            bottom = i9;
        }
        return new MaximizeResult(i7, d);
    }

    @Override // com.google.android.material.color.utilities.Quantizer
    public QuantizerResult quantize(int[] iArr, int i) {
        constructHistogram(new QuantizerMap().quantize(iArr, i).colorToCount);
        createMoments();
        List<Integer> createResult = createResult(createBoxes(i).resultCount);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Integer> it = createResult.iterator();
        while (it.hasNext()) {
            linkedHashMap.put(Integer.valueOf(it.next().intValue()), 0);
        }
        return new QuantizerResult(linkedHashMap);
    }

    double variance(Box box) {
        int volume = volume(box, this.momentsR);
        int volume2 = volume(box, this.momentsG);
        int volume3 = volume(box, this.momentsB);
        return (((((((this.moments[getIndex(box.r1, box.g1, box.b1)] - this.moments[getIndex(box.r1, box.g1, box.b0)]) - this.moments[getIndex(box.r1, box.g0, box.b1)]) + this.moments[getIndex(box.r1, box.g0, box.b0)]) - this.moments[getIndex(box.r0, box.g1, box.b1)]) + this.moments[getIndex(box.r0, box.g1, box.b0)]) + this.moments[getIndex(box.r0, box.g0, box.b1)]) - this.moments[getIndex(box.r0, box.g0, box.b0)]) - ((((volume * volume) + (volume2 * volume2)) + (volume3 * volume3)) / volume(box, this.weights));
    }
}
