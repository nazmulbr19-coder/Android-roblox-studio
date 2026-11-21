package com.google.android.material.shape;

/* loaded from: classes.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float f, boolean z) {
        this.size = f;
        this.inside = z;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        if (!this.inside) {
            shapePath.lineTo(f2 - (this.size * f3), 0.0f, f2, (-this.size) * f3);
            shapePath.lineTo((this.size * f3) + f2, 0.0f, f, 0.0f);
        } else {
            shapePath.lineTo(f2 - (this.size * f3), 0.0f);
            shapePath.lineTo(f2, this.size * f3, (this.size * f3) + f2, 0.0f);
            shapePath.lineTo(f, 0.0f);
        }
    }
}
