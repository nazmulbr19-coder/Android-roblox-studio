package com.exampletest.mobilestudiotest.ui;

import android.view.MotionEvent;
import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.ui.DockLayout;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/DockLayout$FloatFrame;", method = "_init_$lambda$1", proto = "(Lcom/exampletest/mobilestudiotest/ui/DockLayout$FloatFrame;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$IntRef;Lkotlin/jvm/internal/Ref$IntRef;Lcom/exampletest/mobilestudiotest/ui/DockLayout;Landroid/view/View;Landroid/view/MotionEvent;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class DockLayout$FloatFrame$$ExternalSyntheticLambda0 implements View.OnTouchListener {
    public final /* synthetic */ DockLayout.FloatFrame f$0;
    public final /* synthetic */ Ref.FloatRef f$1;
    public final /* synthetic */ Ref.FloatRef f$2;
    public final /* synthetic */ Ref.IntRef f$3;
    public final /* synthetic */ Ref.IntRef f$4;
    public final /* synthetic */ DockLayout f$5;

    public /* synthetic */ DockLayout$FloatFrame$$ExternalSyntheticLambda0(DockLayout.FloatFrame floatFrame, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.IntRef intRef, Ref.IntRef intRef2, DockLayout dockLayout) {
        this.f$0 = floatFrame;
        this.f$1 = floatRef;
        this.f$2 = floatRef2;
        this.f$3 = intRef;
        this.f$4 = intRef2;
        this.f$5 = dockLayout;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return DockLayout.FloatFrame._init_$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, view, motionEvent);
    }
}
