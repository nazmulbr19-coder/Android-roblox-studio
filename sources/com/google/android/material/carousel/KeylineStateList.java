package com.google.android.material.carousel;

import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.CarouselStrategy;
import com.google.android.material.carousel.KeylineState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class KeylineStateList {
    private static final int NO_INDEX = -1;
    private final KeylineState defaultState;
    private final float endShiftRange;
    private final List<KeylineState> endStateSteps;
    private final float[] endStateStepsInterpolationPoints;
    private final float startShiftRange;
    private final List<KeylineState> startStateSteps;
    private final float[] startStateStepsInterpolationPoints;

    private KeylineStateList(KeylineState keylineState, List<KeylineState> list, List<KeylineState> list2) {
        this.defaultState = keylineState;
        this.startStateSteps = Collections.unmodifiableList(list);
        this.endStateSteps = Collections.unmodifiableList(list2);
        this.startShiftRange = list.get(list.size() - 1).getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
        this.endShiftRange = keylineState.getLastKeyline().loc - list2.get(list2.size() - 1).getLastKeyline().loc;
        this.startStateStepsInterpolationPoints = getStateStepInterpolationPoints(this.startShiftRange, list, true);
        this.endStateStepsInterpolationPoints = getStateStepInterpolationPoints(this.endShiftRange, list2, false);
    }

    private KeylineState closestStateStepFromInterpolation(List<KeylineState> list, float f, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f, fArr);
        return stateStepsRange[0] >= 0.5f ? list.get((int) stateStepsRange[2]) : list.get((int) stateStepsRange[1]);
    }

    private static int findFirstIndexAfterLastFocalKeylineWithMask(KeylineState keylineState, float f) {
        for (int lastFocalKeylineIndex = keylineState.getLastFocalKeylineIndex(); lastFocalKeylineIndex < keylineState.getKeylines().size(); lastFocalKeylineIndex++) {
            if (f == keylineState.getKeylines().get(lastFocalKeylineIndex).mask) {
                return lastFocalKeylineIndex;
            }
        }
        return keylineState.getKeylines().size() - 1;
    }

    private static int findFirstNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int i = 0; i < keylineState.getKeylines().size(); i++) {
            if (!keylineState.getKeylines().get(i).isAnchor) {
                return i;
            }
        }
        return -1;
    }

    private static int findLastIndexBeforeFirstFocalKeylineWithMask(KeylineState keylineState, float f) {
        for (int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - 1; firstFocalKeylineIndex >= 0; firstFocalKeylineIndex--) {
            if (f == keylineState.getKeylines().get(firstFocalKeylineIndex).mask) {
                return firstFocalKeylineIndex;
            }
        }
        return 0;
    }

    private static int findLastNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int size = keylineState.getKeylines().size() - 1; size >= 0; size--) {
            if (!keylineState.getKeylines().get(size).isAnchor) {
                return size;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static KeylineStateList from(Carousel carousel, KeylineState keylineState, float f, float f2, float f3, CarouselStrategy.StrategyType strategyType) {
        return new KeylineStateList(keylineState, getStateStepsStart(carousel, keylineState, f, f2, strategyType), getStateStepsEnd(carousel, keylineState, f, f3, strategyType));
    }

    private static float[] getStateStepInterpolationPoints(float f, List<KeylineState> list, boolean z) {
        int size = list.size();
        float[] fArr = new float[size];
        int i = 1;
        while (i < size) {
            KeylineState keylineState = list.get(i - 1);
            KeylineState keylineState2 = list.get(i);
            fArr[i] = i == size + (-1) ? 1.0f : fArr[i - 1] + ((z ? keylineState2.getFirstKeyline().loc - keylineState.getFirstKeyline().loc : keylineState.getLastKeyline().loc - keylineState2.getLastKeyline().loc) / f);
            i++;
        }
        return fArr;
    }

    private static List<KeylineState> getStateStepsEnd(Carousel carousel, KeylineState keylineState, float f, float f2, CarouselStrategy.StrategyType strategyType) {
        float f3;
        int i;
        int i2;
        int i3;
        KeylineState keylineState2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int findLastNonAnchorKeylineIndex = findLastNonAnchorKeylineIndex(keylineState);
        int containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        float f4 = 0.0f;
        if (isLastFocalItemVisibleAtRightOfContainer(carousel, keylineState)) {
            f3 = 0.0f;
            i = containerWidth;
        } else {
            if (findLastNonAnchorKeylineIndex != -1) {
                int lastFocalKeylineIndex = findLastNonAnchorKeylineIndex - keylineState.getLastFocalKeylineIndex();
                float f5 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
                if (lastFocalKeylineIndex <= 0 && keylineState.getLastFocalKeyline().cutoff > 0.0f) {
                    arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState, (f5 - keylineState.getLastFocalKeyline().cutoff) - f2, containerWidth));
                    return arrayList;
                }
                float f6 = 0.0f;
                int i4 = 0;
                while (i4 < lastFocalKeylineIndex) {
                    KeylineState keylineState3 = (KeylineState) arrayList.get(arrayList.size() - 1);
                    int i5 = findLastNonAnchorKeylineIndex - i4;
                    float f7 = f6 + keylineState.getKeylines().get(i5).cutoff;
                    KeylineState moveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState3, findLastNonAnchorKeylineIndex, i5 + 1 < keylineState.getKeylines().size() ? findLastIndexBeforeFirstFocalKeylineWithMask(keylineState3, keylineState.getKeylines().get(i5 + 1).mask) + 1 : 0, f5 - f7, keylineState.getFirstFocalKeylineIndex() + i4 + 1, keylineState.getLastFocalKeylineIndex() + i4 + 1, containerWidth);
                    float f8 = f4;
                    if (i4 != lastFocalKeylineIndex - 1 || f2 <= f8) {
                        i2 = containerWidth;
                        i3 = i4;
                        keylineState2 = moveKeylineAndCreateKeylineState;
                    } else {
                        i2 = containerWidth;
                        i3 = i4;
                        keylineState2 = shiftKeylineStateForPadding(moveKeylineAndCreateKeylineState, f2, i2, false, f, strategyType);
                    }
                    arrayList.add(keylineState2);
                    i4 = i3 + 1;
                    containerWidth = i2;
                    f6 = f7;
                    f4 = f8;
                }
                return arrayList;
            }
            f3 = 0.0f;
            i = containerWidth;
        }
        if (f2 > f3) {
            arrayList.add(shiftKeylineStateForPadding(keylineState, f2, i, false, f, strategyType));
        }
        return arrayList;
    }

    private static float[] getStateStepsRange(List<KeylineState> list, float f, float[] fArr) {
        int size = list.size();
        float f2 = fArr[0];
        for (int i = 1; i < size; i++) {
            float f3 = fArr[i];
            if (f <= f3) {
                return new float[]{AnimationUtils.lerp(0.0f, 1.0f, f2, f3, f), i - 1, i};
            }
            f2 = f3;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private static List<KeylineState> getStateStepsStart(Carousel carousel, KeylineState keylineState, float f, float f2, CarouselStrategy.StrategyType strategyType) {
        float f3;
        int i;
        int i2;
        int i3;
        KeylineState keylineState2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int findFirstNonAnchorKeylineIndex = findFirstNonAnchorKeylineIndex(keylineState);
        int containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        float f4 = 0.0f;
        if (isFirstFocalItemAtLeftOfContainer(keylineState)) {
            f3 = 0.0f;
            i = containerWidth;
        } else {
            if (findFirstNonAnchorKeylineIndex != -1) {
                int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - findFirstNonAnchorKeylineIndex;
                float f5 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
                if (firstFocalKeylineIndex <= 0 && keylineState.getFirstFocalKeyline().cutoff > 0.0f) {
                    arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState, f5 + keylineState.getFirstFocalKeyline().cutoff + f2, containerWidth));
                    return arrayList;
                }
                float f6 = 0.0f;
                int i4 = 0;
                while (i4 < firstFocalKeylineIndex) {
                    KeylineState keylineState3 = (KeylineState) arrayList.get(arrayList.size() - 1);
                    int i5 = findFirstNonAnchorKeylineIndex + i4;
                    int size = keylineState.getKeylines().size() - 1;
                    float f7 = f6 + keylineState.getKeylines().get(i5).cutoff;
                    if (i5 - 1 >= 0) {
                        size = findFirstIndexAfterLastFocalKeylineWithMask(keylineState3, keylineState.getKeylines().get(i5 - 1).mask) - 1;
                    }
                    KeylineState moveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState3, findFirstNonAnchorKeylineIndex, size, f5 + f7, (keylineState.getFirstFocalKeylineIndex() - i4) - 1, (keylineState.getLastFocalKeylineIndex() - i4) - 1, containerWidth);
                    float f8 = f4;
                    if (i4 != firstFocalKeylineIndex - 1 || f2 <= f8) {
                        i2 = containerWidth;
                        i3 = i4;
                        keylineState2 = moveKeylineAndCreateKeylineState;
                    } else {
                        i2 = containerWidth;
                        i3 = i4;
                        keylineState2 = shiftKeylineStateForPadding(moveKeylineAndCreateKeylineState, f2, i2, true, f, strategyType);
                    }
                    arrayList.add(keylineState2);
                    i4 = i3 + 1;
                    containerWidth = i2;
                    f6 = f7;
                    f4 = f8;
                }
                return arrayList;
            }
            f3 = 0.0f;
            i = containerWidth;
        }
        if (f2 > f3) {
            arrayList.add(shiftKeylineStateForPadding(keylineState, f2, i, true, f, strategyType));
        }
        return arrayList;
    }

    private static boolean isFirstFocalItemAtLeftOfContainer(KeylineState keylineState) {
        return keylineState.getFirstFocalKeyline().locOffset - (keylineState.getFirstFocalKeyline().maskedItemSize / 2.0f) >= 0.0f && keylineState.getFirstFocalKeyline() == keylineState.getFirstNonAnchorKeyline();
    }

    private static boolean isLastFocalItemVisibleAtRightOfContainer(Carousel carousel, KeylineState keylineState) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        return keylineState.getLastFocalKeyline().locOffset + (keylineState.getLastFocalKeyline().maskedItemSize / 2.0f) <= ((float) containerHeight) && keylineState.getLastFocalKeyline() == keylineState.getLastNonAnchorKeyline();
    }

    private static KeylineState lerp(List<KeylineState> list, float f, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f, fArr);
        return KeylineState.lerp(list.get((int) stateStepsRange[1]), list.get((int) stateStepsRange[2]), stateStepsRange[0]);
    }

    private static KeylineState moveKeylineAndCreateKeylineState(KeylineState keylineState, int i, int i2, float f, int i3, int i4, int i5) {
        boolean z;
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        arrayList.add(i2, (KeylineState.Keyline) arrayList.remove(i));
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), i5);
        float f2 = f;
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i6);
            float f3 = (keyline.maskedItemSize / 2.0f) + f2;
            if (i6 >= i3 && i6 <= i4) {
                z = true;
                builder.addKeyline(f3, keyline.mask, keyline.maskedItemSize, z, keyline.isAnchor, keyline.cutoff);
                f2 += keyline.maskedItemSize;
            }
            z = false;
            builder.addKeyline(f3, keyline.mask, keyline.maskedItemSize, z, keyline.isAnchor, keyline.cutoff);
            f2 += keyline.maskedItemSize;
        }
        return builder.build();
    }

    private static KeylineState shiftKeylineStateForPadding(KeylineState keylineState, float f, int i, boolean z, float f2, CarouselStrategy.StrategyType strategyType) {
        switch (strategyType) {
            case CONTAINED:
                return shiftKeylineStateForPaddingContained(keylineState, f, i, z, f2);
            default:
                return shiftKeylineStateForPaddingUncontained(keylineState, f, i, z);
        }
    }

    private static KeylineState shiftKeylineStateForPaddingContained(KeylineState keylineState, float f, int i, boolean z, float f2) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), i);
        float numberOfNonAnchorKeylines = f / keylineState.getNumberOfNonAnchorKeylines();
        float f3 = z ? f : 0.0f;
        int i2 = 0;
        while (i2 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i2);
            if (keyline.isAnchor) {
                builder.addKeyline(keyline.locOffset, keyline.mask, keyline.maskedItemSize, false, true, keyline.cutoff);
            } else {
                boolean z2 = i2 >= keylineState.getFirstFocalKeylineIndex() && i2 <= keylineState.getLastFocalKeylineIndex();
                float f4 = keyline.maskedItemSize - numberOfNonAnchorKeylines;
                float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(f4, keylineState.getItemSize(), f2);
                float f5 = (f4 / 2.0f) + f3;
                float abs = Math.abs(f5 - keyline.locOffset);
                float f6 = keyline.cutoff;
                float f7 = 0.0f;
                float f8 = z ? abs : 0.0f;
                if (!z) {
                    f7 = abs;
                }
                builder.addKeyline(f5, childMaskPercentage, f4, z2, false, f6, f8, f7);
                f3 += f4;
            }
            i2++;
        }
        return builder.build();
    }

    private static KeylineState shiftKeylineStateForPaddingUncontained(KeylineState keylineState, float f, int i, boolean z) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), i);
        boolean z2 = true;
        int size = z ? 0 : arrayList.size() - 1;
        int i2 = 0;
        while (i2 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i2);
            if (keyline.isAnchor && i2 == size) {
                builder.addKeyline(keyline.locOffset, keyline.mask, keyline.maskedItemSize, false, true, keyline.cutoff);
            } else {
                float f2 = keyline.locOffset;
                float f3 = z ? f2 + f : f2 - f;
                builder.addKeyline(f3, keyline.mask, keyline.maskedItemSize, (i2 < keylineState.getFirstFocalKeylineIndex() || i2 > keylineState.getLastFocalKeylineIndex()) ? false : z2, keyline.isAnchor, Math.abs(z ? Math.max(0.0f, ((keyline.maskedItemSize / 2.0f) + f3) - i) : Math.min(0.0f, f3 - (keyline.maskedItemSize / 2.0f))), z ? f : 0.0f, z ? 0.0f : f);
            }
            i2++;
            z2 = true;
        }
        return builder.build();
    }

    private static KeylineState shiftKeylinesAndCreateKeylineState(KeylineState keylineState, float f, int i) {
        return moveKeylineAndCreateKeylineState(keylineState, 0, 0, f, keylineState.getFirstFocalKeylineIndex(), keylineState.getLastFocalKeylineIndex(), i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeylineState getDefaultState() {
        return this.defaultState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeylineState getEndState() {
        return this.endStateSteps.get(this.endStateSteps.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<Integer, KeylineState> getKeylineStateForPositionMap(int i, int i2, int i3, boolean z) {
        float itemSize = this.defaultState.getItemSize();
        HashMap hashMap = new HashMap();
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            int i7 = z ? (i - i6) - 1 : i6;
            if (i7 * itemSize * (z ? -1 : 1) > i3 - this.endShiftRange || i6 >= i - this.endStateSteps.size()) {
                hashMap.put(Integer.valueOf(i7), this.endStateSteps.get(MathUtils.clamp(i4, 0, this.endStateSteps.size() - 1)));
                i4++;
            }
        }
        for (int i8 = i - 1; i8 >= 0; i8--) {
            int i9 = z ? (i - i8) - 1 : i8;
            if (i9 * itemSize * (z ? -1 : 1) < i2 + this.startShiftRange || i8 < this.startStateSteps.size()) {
                hashMap.put(Integer.valueOf(i9), this.startStateSteps.get(MathUtils.clamp(i5, 0, this.startStateSteps.size() - 1)));
                i5++;
            }
        }
        return hashMap;
    }

    public KeylineState getShiftedState(float f, float f2, float f3) {
        return getShiftedState(f, f2, f3, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeylineState getShiftedState(float f, float f2, float f3, boolean z) {
        float lerp;
        List<KeylineState> list;
        float[] fArr;
        float f4 = this.startShiftRange + f2;
        float f5 = f3 - this.endShiftRange;
        float f6 = getStartState().getFirstFocalKeyline().leftOrTopPaddingShift;
        float f7 = getEndState().getFirstFocalKeyline().rightOrBottomPaddingShift;
        if (this.startShiftRange == f6) {
            f4 += f6;
        }
        if (this.endShiftRange == f7) {
            f5 -= f7;
        }
        if (f < f4) {
            lerp = AnimationUtils.lerp(1.0f, 0.0f, f2, f4, f);
            list = this.startStateSteps;
            fArr = this.startStateStepsInterpolationPoints;
        } else {
            if (f <= f5) {
                return this.defaultState;
            }
            lerp = AnimationUtils.lerp(0.0f, 1.0f, f5, f3, f);
            list = this.endStateSteps;
            fArr = this.endStateStepsInterpolationPoints;
        }
        return z ? closestStateStepFromInterpolation(list, lerp, fArr) : lerp(list, lerp, fArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeylineState getStartState() {
        return this.startStateSteps.get(this.startStateSteps.size() - 1);
    }
}
