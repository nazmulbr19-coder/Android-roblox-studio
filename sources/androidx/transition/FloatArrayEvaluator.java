package androidx.transition;

import android.animation.TypeEvaluator;

/* loaded from: classes.dex */
class FloatArrayEvaluator implements TypeEvaluator<float[]> {
    private float[] mArray;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatArrayEvaluator(float[] fArr) {
        this.mArray = fArr;
    }

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ float[] evaluate(float f, float[] fArr, float[] fArr2) {
        return evaluate2(f, fArr, fArr2);
    }

    /* renamed from: evaluate, reason: avoid collision after fix types in other method */
    public float[] evaluate2(float f, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.mArray;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i = 0; i < fArr3.length; i++) {
            float f2 = fArr[i];
            fArr3[i] = ((fArr2[i] - f2) * f) + f2;
        }
        return fArr3;
    }
}
