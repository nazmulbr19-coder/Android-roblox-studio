package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;
import androidx.core.util.Consumer;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/location/LocationManagerCompat$CancellableLocationListener;", method = "lambda$onLocationChanged$1", proto = "(Landroidx/core/util/Consumer;Landroid/location/Location;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class LocationManagerCompat$CancellableLocationListener$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Consumer f$0;
    public final /* synthetic */ Location f$1;

    public /* synthetic */ LocationManagerCompat$CancellableLocationListener$$ExternalSyntheticLambda1(Consumer consumer, Location location) {
        this.f$0 = consumer;
        this.f$1 = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LocationManagerCompat.CancellableLocationListener.lambda$onLocationChanged$1(this.f$0, this.f$1);
    }
}
