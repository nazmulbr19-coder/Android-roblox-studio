package com.exampletest.mobilestudiotest;

import androidx.activity.OnBackPressedCallback;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.ui.DockLayout;
import com.exampletest.mobilestudiotest.ui.ViewportView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/exampletest/mobilestudiotest/MainActivity$onCreate$5", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class MainActivity$onCreate$5 extends OnBackPressedCallback {
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$onCreate$5(MainActivity mainActivity) {
        super(true);
        this.this$0 = mainActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit handleOnBackPressed$lambda$0(MainActivity mainActivity) {
        mainActivity.finish();
        return Unit.INSTANCE;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackPressed() {
        if (MainActivity.access$getStartScreen$p(this.this$0) != null) {
            if (this.this$0.hasOpenPlace()) {
                this.this$0.closeStart();
                return;
            } else {
                this.this$0.finish();
                return;
            }
        }
        Studio access$getStudio$p = MainActivity.access$getStudio$p(this.this$0);
        DockLayout dockLayout = null;
        Studio studio = null;
        if (access$getStudio$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            access$getStudio$p = null;
        }
        if (access$getStudio$p.isPlaying()) {
            ViewportView access$getViewport$p = MainActivity.access$getViewport$p(this.this$0);
            if (access$getViewport$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewport");
                access$getViewport$p = null;
            }
            if (access$getViewport$p.getHud().handleBack()) {
                return;
            }
        }
        if (MainActivity.access$getActiveScript$p(this.this$0) != null) {
            MainActivity.access$showPlace(this.this$0);
            return;
        }
        Studio access$getStudio$p2 = MainActivity.access$getStudio$p(this.this$0);
        if (access$getStudio$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            access$getStudio$p2 = null;
        }
        if (access$getStudio$p2.isPlaying()) {
            Studio access$getStudio$p3 = MainActivity.access$getStudio$p(this.this$0);
            if (access$getStudio$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
            } else {
                studio = access$getStudio$p3;
            }
            studio.stopPlay();
            return;
        }
        DockLayout access$getDock$p = MainActivity.access$getDock$p(this.this$0);
        if (access$getDock$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
        } else {
            dockLayout = access$getDock$p;
        }
        if (dockLayout.getAllHidden()) {
            MainActivity.access$setAllHidden(this.this$0, false);
        } else {
            MainActivity.access$confirmDiscard(this.this$0, new MainActivity$onCreate$5$$ExternalSyntheticLambda0(this.this$0));
        }
    }
}
