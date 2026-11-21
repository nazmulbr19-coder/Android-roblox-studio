package androidx.graphics.shapes;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/graphics/shapes/AngleMeasurer;", method = "findCubicCutPoint$lambda$1", proto = "(Landroidx/graphics/shapes/Cubic;Landroidx/graphics/shapes/AngleMeasurer;FFF)F")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class AngleMeasurer$$ExternalSyntheticLambda0 implements FindMinimumFunction {
    public final /* synthetic */ Cubic f$0;
    public final /* synthetic */ AngleMeasurer f$1;
    public final /* synthetic */ float f$2;
    public final /* synthetic */ float f$3;

    public /* synthetic */ AngleMeasurer$$ExternalSyntheticLambda0(Cubic cubic, AngleMeasurer angleMeasurer, float f, float f2) {
        this.f$0 = cubic;
        this.f$1 = angleMeasurer;
        this.f$2 = f;
        this.f$3 = f2;
    }

    @Override // androidx.graphics.shapes.FindMinimumFunction
    public final float invoke(float f) {
        return AngleMeasurer.findCubicCutPoint$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, f);
    }
}
