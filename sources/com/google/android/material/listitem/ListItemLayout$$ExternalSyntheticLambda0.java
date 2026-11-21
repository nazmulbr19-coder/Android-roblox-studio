package com.google.android.material.listitem;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/listitem/ListItemLayout;", method = "lambda$setSwipeState$0", proto = "(ZII)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ListItemLayout$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ListItemLayout f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ ListItemLayout$$ExternalSyntheticLambda0(ListItemLayout listItemLayout, boolean z, int i, int i2) {
        this.f$0 = listItemLayout;
        this.f$1 = z;
        this.f$2 = i;
        this.f$3 = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m387x6b76121b(this.f$1, this.f$2, this.f$3);
    }
}
