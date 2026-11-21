package androidx.core.location;

import android.os.Bundle;
import androidx.core.location.LocationManagerCompat;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/location/LocationManagerCompat$LocationListenerTransport;", method = "lambda$onStatusChanged$3", proto = "(Ljava/lang/String;ILandroid/os/Bundle;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ Bundle f$3;

    public /* synthetic */ LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda5(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str, int i, Bundle bundle) {
        this.f$0 = locationListenerTransport;
        this.f$1 = str;
        this.f$2 = i;
        this.f$3 = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m92xdbe6a717(this.f$1, this.f$2, this.f$3);
    }
}
