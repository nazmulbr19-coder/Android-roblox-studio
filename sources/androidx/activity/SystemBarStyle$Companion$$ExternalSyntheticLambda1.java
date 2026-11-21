package androidx.activity;

import android.content.res.Resources;
import androidx.activity.SystemBarStyle;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/activity/SystemBarStyle$Companion;", method = "dark$lambda$0", proto = "(Landroid/content/res/Resources;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class SystemBarStyle$Companion$$ExternalSyntheticLambda1 implements Function1 {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Boolean.valueOf(SystemBarStyle.Companion.dark$lambda$0((Resources) obj));
    }
}
