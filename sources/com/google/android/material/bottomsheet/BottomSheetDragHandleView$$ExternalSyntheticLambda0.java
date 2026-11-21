package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/bottomsheet/BottomSheetDragHandleView;", method = "lambda$onBottomSheetStateChanged$0", proto = "(Landroid/view/View;Landroidx/core/view/accessibility/AccessibilityViewCommand$CommandArguments;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class BottomSheetDragHandleView$$ExternalSyntheticLambda0 implements AccessibilityViewCommand {
    public final /* synthetic */ BottomSheetDragHandleView f$0;

    public /* synthetic */ BottomSheetDragHandleView$$ExternalSyntheticLambda0(BottomSheetDragHandleView bottomSheetDragHandleView) {
        this.f$0 = bottomSheetDragHandleView;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return this.f$0.m321xa7b4c95f(view, commandArguments);
    }
}
