package androidx.core.view;

import android.view.MotionEvent;
import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/view/DragStartHelper;", method = "onTouch", proto = "(Landroid/view/View;Landroid/view/MotionEvent;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class DragStartHelper$$ExternalSyntheticLambda1 implements View.OnTouchListener {
    public final /* synthetic */ DragStartHelper f$0;

    public /* synthetic */ DragStartHelper$$ExternalSyntheticLambda1(DragStartHelper dragStartHelper) {
        this.f$0 = dragStartHelper;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f$0.onTouch(view, motionEvent);
    }
}
