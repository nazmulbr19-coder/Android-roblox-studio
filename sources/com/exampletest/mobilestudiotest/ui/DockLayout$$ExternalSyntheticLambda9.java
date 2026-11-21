package com.exampletest.mobilestudiotest.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.ui.DockLayout;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/DockLayout;", method = "decorateHeader$lambda$36", proto = "(Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$BooleanRef;Lkotlin/jvm/internal/Ref$IntRef;Lcom/exampletest/mobilestudiotest/ui/DockLayout$Panel;Lkotlin/jvm/internal/Ref$IntRef;Landroid/view/ViewGroup;Lcom/exampletest/mobilestudiotest/ui/DockLayout;Lkotlin/jvm/internal/Ref$LongRef;Landroid/view/View;Landroid/view/MotionEvent;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class DockLayout$$ExternalSyntheticLambda9 implements View.OnTouchListener {
    public final /* synthetic */ Ref.FloatRef f$0;
    public final /* synthetic */ Ref.FloatRef f$1;
    public final /* synthetic */ Ref.BooleanRef f$2;
    public final /* synthetic */ Ref.IntRef f$3;
    public final /* synthetic */ DockLayout.Panel f$4;
    public final /* synthetic */ Ref.IntRef f$5;
    public final /* synthetic */ ViewGroup f$6;
    public final /* synthetic */ DockLayout f$7;
    public final /* synthetic */ Ref.LongRef f$8;

    public /* synthetic */ DockLayout$$ExternalSyntheticLambda9(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.BooleanRef booleanRef, Ref.IntRef intRef, DockLayout.Panel panel, Ref.IntRef intRef2, ViewGroup viewGroup, DockLayout dockLayout, Ref.LongRef longRef) {
        this.f$0 = floatRef;
        this.f$1 = floatRef2;
        this.f$2 = booleanRef;
        this.f$3 = intRef;
        this.f$4 = panel;
        this.f$5 = intRef2;
        this.f$6 = viewGroup;
        this.f$7 = dockLayout;
        this.f$8 = longRef;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return DockLayout.decorateHeader$lambda$36(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, view, motionEvent);
    }
}
