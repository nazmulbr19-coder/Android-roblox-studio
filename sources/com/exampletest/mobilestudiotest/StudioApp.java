package com.exampletest.mobilestudiotest;

import android.app.Application;
import com.exampletest.mobilestudiotest.core.Settings;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.ui.Ui;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* compiled from: StudioApp.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/exampletest/mobilestudiotest/StudioApp;", "Landroid/app/Application;", "<init>", "()V", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "getStudio", "()Lcom/exampletest/mobilestudiotest/core/Studio;", "studio$delegate", "Lkotlin/Lazy;", "started", "", "getStarted", "()Z", "setStarted", "(Z)V", "placeOpened", "getPlaceOpened", "setPlaceOpened", "onCreate", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class StudioApp extends Application {
    private boolean placeOpened;
    private boolean started;

    /* renamed from: studio$delegate, reason: from kotlin metadata */
    private final Lazy studio = LazyKt.lazy(new StudioApp$$ExternalSyntheticLambda0(this));

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Studio studio_delegate$lambda$0(StudioApp studioApp) {
        return new Studio(studioApp);
    }

    public final boolean getPlaceOpened() {
        return this.placeOpened;
    }

    public final boolean getStarted() {
        return this.started;
    }

    public final Studio getStudio() {
        return (Studio) this.studio.getValue();
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        Settings.INSTANCE.init(this);
        Ui.INSTANCE.applyTheme(Settings.INSTANCE.getTheme());
    }

    public final void setPlaceOpened(boolean z) {
        this.placeOpened = z;
    }

    public final void setStarted(boolean z) {
        this.started = z;
    }
}
