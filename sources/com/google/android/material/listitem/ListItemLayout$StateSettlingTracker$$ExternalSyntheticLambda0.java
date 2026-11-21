package com.google.android.material.listitem;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.material.listitem.ListItemLayout;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/listitem/ListItemLayout$StateSettlingTracker;", method = "lambda$new$0", proto = "()V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ListItemLayout$StateSettlingTracker$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ListItemLayout.StateSettlingTracker f$0;

    public /* synthetic */ ListItemLayout$StateSettlingTracker$$ExternalSyntheticLambda0(ListItemLayout.StateSettlingTracker stateSettlingTracker) {
        this.f$0 = stateSettlingTracker;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m388x75cf24c1();
    }
}
