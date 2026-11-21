package androidx.core.view;

import android.view.KeyEvent;
import android.view.View;
import android.view.View$OnUnhandledKeyEventListener;
import androidx.core.view.ViewCompat;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/view/ViewCompat$OnUnhandledKeyEventListenerCompat;", method = "onUnhandledKeyEvent", proto = "(Landroid/view/View;Landroid/view/KeyEvent;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ViewCompat$Api28Impl$$ExternalSyntheticLambda0 implements View$OnUnhandledKeyEventListener {
    public final /* synthetic */ ViewCompat.OnUnhandledKeyEventListenerCompat f$0;

    public /* synthetic */ ViewCompat$Api28Impl$$ExternalSyntheticLambda0(ViewCompat.OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        this.f$0 = onUnhandledKeyEventListenerCompat;
    }

    public final boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        return this.f$0.onUnhandledKeyEvent(view, keyEvent);
    }
}
