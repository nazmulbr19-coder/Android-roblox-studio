package androidx.appcompat.app;

import android.view.KeyEvent;
import androidx.core.view.KeyEventDispatcher;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/appcompat/app/AppCompatDialog;", method = "superDispatchKeyEvent", proto = "(Landroid/view/KeyEvent;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class AppCompatDialog$$ExternalSyntheticLambda0 implements KeyEventDispatcher.Component {
    public final /* synthetic */ AppCompatDialog f$0;

    public /* synthetic */ AppCompatDialog$$ExternalSyntheticLambda0(AppCompatDialog appCompatDialog) {
        this.f$0 = appCompatDialog;
    }

    @Override // androidx.core.view.KeyEventDispatcher.Component
    public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.f$0.superDispatchKeyEvent(keyEvent);
    }
}
