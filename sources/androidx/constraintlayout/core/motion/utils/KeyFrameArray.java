package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import java.util.Arrays;

/* loaded from: classes.dex */
public class KeyFrameArray {

    /* loaded from: classes.dex */
    public static class CustomArray {
        private static final int EMPTY = 999;
        int mCount;
        int[] mKeys = new int[TypedValues.TYPE_TARGET];
        CustomAttribute[] mValues = new CustomAttribute[TypedValues.TYPE_TARGET];

        public CustomArray() {
            clear();
        }

        public void append(int i, CustomAttribute customAttribute) {
            if (this.mValues[i] != null) {
                remove(i);
            }
            this.mValues[i] = customAttribute;
            int[] iArr = this.mKeys;
            int i2 = this.mCount;
            this.mCount = i2 + 1;
            iArr[i2] = i;
            Arrays.sort(this.mKeys);
        }

        public void clear() {
            Arrays.fill(this.mKeys, EMPTY);
            Arrays.fill(this.mValues, (Object) null);
            this.mCount = 0;
        }

        public void dump() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.mKeys, this.mCount)));
            System.out.print("K: [");
            int i = 0;
            while (i < this.mCount) {
                System.out.print((i == 0 ? "" : ", ") + valueAt(i));
                i++;
            }
            System.out.println("]");
        }

        public int keyAt(int i) {
            return this.mKeys[i];
        }

        public void remove(int i) {
            this.mValues[i] = null;
            int i2 = 0;
            for (int i3 = 0; i3 < this.mCount; i3++) {
                if (i == this.mKeys[i3]) {
                    this.mKeys[i3] = EMPTY;
                    i2++;
                }
                if (i3 != i2) {
                    this.mKeys[i3] = this.mKeys[i2];
                }
                i2++;
            }
            this.mCount--;
        }

        public int size() {
            return this.mCount;
        }

        public CustomAttribute valueAt(int i) {
            return this.mValues[this.mKeys[i]];
        }
    }

    /* loaded from: classes.dex */
    public static class CustomVar {
        private static final int EMPTY = 999;
        int mCount;
        int[] mKeys = new int[TypedValues.TYPE_TARGET];
        CustomVariable[] mValues = new CustomVariable[TypedValues.TYPE_TARGET];

        public CustomVar() {
            clear();
        }

        public void append(int i, CustomVariable customVariable) {
            if (this.mValues[i] != null) {
                remove(i);
            }
            this.mValues[i] = customVariable;
            int[] iArr = this.mKeys;
            int i2 = this.mCount;
            this.mCount = i2 + 1;
            iArr[i2] = i;
            Arrays.sort(this.mKeys);
        }

        public void clear() {
            Arrays.fill(this.mKeys, EMPTY);
            Arrays.fill(this.mValues, (Object) null);
            this.mCount = 0;
        }

        public void dump() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.mKeys, this.mCount)));
            System.out.print("K: [");
            int i = 0;
            while (i < this.mCount) {
                System.out.print((i == 0 ? "" : ", ") + valueAt(i));
                i++;
            }
            System.out.println("]");
        }

        public int keyAt(int i) {
            return this.mKeys[i];
        }

        public void remove(int i) {
            this.mValues[i] = null;
            int i2 = 0;
            for (int i3 = 0; i3 < this.mCount; i3++) {
                if (i == this.mKeys[i3]) {
                    this.mKeys[i3] = EMPTY;
                    i2++;
                }
                if (i3 != i2) {
                    this.mKeys[i3] = this.mKeys[i2];
                }
                i2++;
            }
            this.mCount--;
        }

        public int size() {
            return this.mCount;
        }

        public CustomVariable valueAt(int i) {
            return this.mValues[this.mKeys[i]];
        }
    }

    /* loaded from: classes.dex */
    static class FloatArray {
        private static final int EMPTY = 999;
        int mCount;
        int[] mKeys = new int[TypedValues.TYPE_TARGET];
        float[][] mValues = new float[TypedValues.TYPE_TARGET];

        /* JADX INFO: Access modifiers changed from: package-private */
        public FloatArray() {
            clear();
        }

        public void append(int i, float[] fArr) {
            if (this.mValues[i] != null) {
                remove(i);
            }
            this.mValues[i] = fArr;
            int[] iArr = this.mKeys;
            int i2 = this.mCount;
            this.mCount = i2 + 1;
            iArr[i2] = i;
            Arrays.sort(this.mKeys);
        }

        public void clear() {
            Arrays.fill(this.mKeys, EMPTY);
            Arrays.fill(this.mValues, (Object) null);
            this.mCount = 0;
        }

        public void dump() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.mKeys, this.mCount)));
            System.out.print("K: [");
            int i = 0;
            while (i < this.mCount) {
                System.out.print((i == 0 ? "" : ", ") + Arrays.toString(valueAt(i)));
                i++;
            }
            System.out.println("]");
        }

        public int keyAt(int i) {
            return this.mKeys[i];
        }

        public void remove(int i) {
            this.mValues[i] = null;
            int i2 = 0;
            for (int i3 = 0; i3 < this.mCount; i3++) {
                if (i == this.mKeys[i3]) {
                    this.mKeys[i3] = EMPTY;
                    i2++;
                }
                if (i3 != i2) {
                    this.mKeys[i3] = this.mKeys[i2];
                }
                i2++;
            }
            this.mCount--;
        }

        public int size() {
            return this.mCount;
        }

        public float[] valueAt(int i) {
            return this.mValues[this.mKeys[i]];
        }
    }
}
