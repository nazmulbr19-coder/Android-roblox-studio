package androidx.core.view;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/view/DragStartHelper;", method = "onLongClick", proto = "(Landroid/view/View;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class DragStartHelper$$ExternalSyntheticLambda0 implements View.OnLongClickListener {
    public final /* synthetic */ DragStartHelper f$0;

    public /* synthetic */ DragStartHelper$$ExternalSyntheticLambda0(DragStartHelper dragStartHelper) {
        this.f$0 = dragStartHelper;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        return this.f$0.onLongClick(view);
    }
}
