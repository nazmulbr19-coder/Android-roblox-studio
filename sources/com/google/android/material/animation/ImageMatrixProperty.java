package com.google.android.material.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class ImageMatrixProperty extends Property<ImageView, Matrix> {
    private final Matrix matrix;

    public ImageMatrixProperty() {
        super(Matrix.class, "imageMatrixProperty");
        this.matrix = new Matrix();
    }

    /* renamed from: get, reason: avoid collision after fix types in other method */
    public Matrix get2(ImageView imageView) {
        this.matrix.set(imageView.getImageMatrix());
        return this.matrix;
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Matrix get(ImageView imageView) {
        return get2(imageView);
    }

    /* renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(ImageView imageView, Matrix matrix) {
        set2(imageView, matrix);
    }
}
