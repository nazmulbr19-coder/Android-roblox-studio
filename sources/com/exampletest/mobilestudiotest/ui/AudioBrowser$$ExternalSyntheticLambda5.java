package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AudioBrowser;", method = "loadMore$lambda$46$lambda$45", proto = "(ILcom/exampletest/mobilestudiotest/ui/AudioBrowser;Lkotlin/jvm/internal/Ref$ObjectRef;Lkotlin/jvm/internal/Ref$ObjectRef;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AudioBrowser$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ AudioBrowser f$1;
    public final /* synthetic */ Ref.ObjectRef f$2;
    public final /* synthetic */ Ref.ObjectRef f$3;

    public /* synthetic */ AudioBrowser$$ExternalSyntheticLambda5(int i, AudioBrowser audioBrowser, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
        this.f$0 = i;
        this.f$1 = audioBrowser;
        this.f$2 = objectRef;
        this.f$3 = objectRef2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioBrowser.loadMore$lambda$46$lambda$45(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
