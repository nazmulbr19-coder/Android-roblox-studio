package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import androidx.core.location.LocationManagerCompat;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.concurrent.Executor;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/location/LocationManagerCompat$GnssMeasurementsTransport;", method = "lambda$onGnssMeasurementsReceived$0", proto = "(Ljava/util/concurrent/Executor;Landroid/location/GnssMeasurementsEvent;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class LocationManagerCompat$GnssMeasurementsTransport$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ LocationManagerCompat.GnssMeasurementsTransport f$0;
    public final /* synthetic */ Executor f$1;
    public final /* synthetic */ GnssMeasurementsEvent f$2;

    public /* synthetic */ LocationManagerCompat$GnssMeasurementsTransport$$ExternalSyntheticLambda0(LocationManagerCompat.GnssMeasurementsTransport gnssMeasurementsTransport, Executor executor, GnssMeasurementsEvent gnssMeasurementsEvent) {
        this.f$0 = gnssMeasurementsTransport;
        this.f$1 = executor;
        this.f$2 = gnssMeasurementsEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m81xb1484c70(this.f$1, this.f$2);
    }
}
