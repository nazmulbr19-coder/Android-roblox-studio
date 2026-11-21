package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* loaded from: classes.dex */
public class MatrixEvaluator implements TypeEvaluator<Matrix> {
    private final float[] tempStartValues = new float[9];
    private final float[] tempEndValues = new float[9];
    private final Matrix tempMatrix = new Matrix();

    /* renamed from: evaluate, reason: avoid collision after fix types in other method */
    public Matrix evaluate2(float f, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.tempStartValues);
        matrix2.getValues(this.tempEndValues);
        for (int i = 0; i < 9; i++) {
            this.tempEndValues[i] = this.tempStartValues[i] + (f * (this.tempEndValues[i] - this.tempStartValues[i]));
        }
        this.tempMatrix.setValues(this.tempEndValues);
        return this.tempMatrix;
    }

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
        return evaluate2(f, matrix, matrix2);
    }
}
