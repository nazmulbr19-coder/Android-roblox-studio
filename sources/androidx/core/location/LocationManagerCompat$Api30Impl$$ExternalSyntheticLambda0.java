package androidx.core.location;

import android.location.Location;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.function.Consumer;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/util/Consumer;", method = "accept", proto = "(Ljava/lang/Object;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class LocationManagerCompat$Api30Impl$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ androidx.core.util.Consumer f$0;

    public /* synthetic */ LocationManagerCompat$Api30Impl$$ExternalSyntheticLambda0(androidx.core.util.Consumer consumer) {
        this.f$0 = consumer;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.accept((Location) obj);
    }
}
