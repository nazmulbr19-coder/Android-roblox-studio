package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* loaded from: classes.dex */
public class TypedBundle {
    private static final int INITIAL_BOOLEAN = 4;
    private static final int INITIAL_FLOAT = 10;
    private static final int INITIAL_INT = 10;
    private static final int INITIAL_STRING = 5;
    int[] mTypeInt = new int[10];
    int[] mValueInt = new int[10];
    int mCountInt = 0;
    int[] mTypeFloat = new int[10];
    float[] mValueFloat = new float[10];
    int mCountFloat = 0;
    int[] mTypeString = new int[5];
    String[] mValueString = new String[5];
    int mCountString = 0;
    int[] mTypeBoolean = new int[4];
    boolean[] mValueBoolean = new boolean[4];
    int mCountBoolean = 0;

    public void add(int i, float f) {
        if (this.mCountFloat >= this.mTypeFloat.length) {
            this.mTypeFloat = Arrays.copyOf(this.mTypeFloat, this.mTypeFloat.length * 2);
            this.mValueFloat = Arrays.copyOf(this.mValueFloat, this.mValueFloat.length * 2);
        }
        this.mTypeFloat[this.mCountFloat] = i;
        float[] fArr = this.mValueFloat;
        int i2 = this.mCountFloat;
        this.mCountFloat = i2 + 1;
        fArr[i2] = f;
    }

    public void add(int i, int i2) {
        if (this.mCountInt >= this.mTypeInt.length) {
            this.mTypeInt = Arrays.copyOf(this.mTypeInt, this.mTypeInt.length * 2);
            this.mValueInt = Arrays.copyOf(this.mValueInt, this.mValueInt.length * 2);
        }
        this.mTypeInt[this.mCountInt] = i;
        int[] iArr = this.mValueInt;
        int i3 = this.mCountInt;
        this.mCountInt = i3 + 1;
        iArr[i3] = i2;
    }

    public void add(int i, String str) {
        if (this.mCountString >= this.mTypeString.length) {
            this.mTypeString = Arrays.copyOf(this.mTypeString, this.mTypeString.length * 2);
            this.mValueString = (String[]) Arrays.copyOf(this.mValueString, this.mValueString.length * 2);
        }
        this.mTypeString[this.mCountString] = i;
        String[] strArr = this.mValueString;
        int i2 = this.mCountString;
        this.mCountString = i2 + 1;
        strArr[i2] = str;
    }

    public void add(int i, boolean z) {
        if (this.mCountBoolean >= this.mTypeBoolean.length) {
            this.mTypeBoolean = Arrays.copyOf(this.mTypeBoolean, this.mTypeBoolean.length * 2);
            this.mValueBoolean = Arrays.copyOf(this.mValueBoolean, this.mValueBoolean.length * 2);
        }
        this.mTypeBoolean[this.mCountBoolean] = i;
        boolean[] zArr = this.mValueBoolean;
        int i2 = this.mCountBoolean;
        this.mCountBoolean = i2 + 1;
        zArr[i2] = z;
    }

    public void addIfNotNull(int i, String str) {
        if (str != null) {
            add(i, str);
        }
    }

    public void applyDelta(TypedBundle typedBundle) {
        for (int i = 0; i < this.mCountInt; i++) {
            typedBundle.add(this.mTypeInt[i], this.mValueInt[i]);
        }
        for (int i2 = 0; i2 < this.mCountFloat; i2++) {
            typedBundle.add(this.mTypeFloat[i2], this.mValueFloat[i2]);
        }
        for (int i3 = 0; i3 < this.mCountString; i3++) {
            typedBundle.add(this.mTypeString[i3], this.mValueString[i3]);
        }
        for (int i4 = 0; i4 < this.mCountBoolean; i4++) {
            typedBundle.add(this.mTypeBoolean[i4], this.mValueBoolean[i4]);
        }
    }

    public void applyDelta(TypedValues typedValues) {
        for (int i = 0; i < this.mCountInt; i++) {
            typedValues.setValue(this.mTypeInt[i], this.mValueInt[i]);
        }
        for (int i2 = 0; i2 < this.mCountFloat; i2++) {
            typedValues.setValue(this.mTypeFloat[i2], this.mValueFloat[i2]);
        }
        for (int i3 = 0; i3 < this.mCountString; i3++) {
            typedValues.setValue(this.mTypeString[i3], this.mValueString[i3]);
        }
        for (int i4 = 0; i4 < this.mCountBoolean; i4++) {
            typedValues.setValue(this.mTypeBoolean[i4], this.mValueBoolean[i4]);
        }
    }

    public void clear() {
        this.mCountBoolean = 0;
        this.mCountString = 0;
        this.mCountFloat = 0;
        this.mCountInt = 0;
    }

    public int getInteger(int i) {
        for (int i2 = 0; i2 < this.mCountInt; i2++) {
            if (this.mTypeInt[i2] == i) {
                return this.mValueInt[i2];
            }
        }
        return -1;
    }

    public String toString() {
        return "TypedBundle{mCountInt=" + this.mCountInt + ", mCountFloat=" + this.mCountFloat + ", mCountString=" + this.mCountString + ", mCountBoolean=" + this.mCountBoolean + '}';
    }
}
