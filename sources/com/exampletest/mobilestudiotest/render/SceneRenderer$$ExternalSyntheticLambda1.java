package com.exampletest.mobilestudiotest.render;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.engine.Avatar;
import com.exampletest.mobilestudiotest.model.Instance;
import java.util.HashMap;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/render/SceneRenderer;", method = "r15Clothing$lambda$87", proto = "(Lcom/exampletest/mobilestudiotest/render/SceneRenderer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/exampletest/mobilestudiotest/engine/Avatar;Ljava/util/HashMap;Lcom/exampletest/mobilestudiotest/model/Instance;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes8.dex */
public final /* synthetic */ class SceneRenderer$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ SceneRenderer f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ String f$4;
    public final /* synthetic */ Avatar f$5;
    public final /* synthetic */ HashMap f$6;
    public final /* synthetic */ Instance f$7;

    public /* synthetic */ SceneRenderer$$ExternalSyntheticLambda1(SceneRenderer sceneRenderer, String str, String str2, String str3, String str4, Avatar avatar, HashMap hashMap, Instance instance) {
        this.f$0 = sceneRenderer;
        this.f$1 = str;
        this.f$2 = str2;
        this.f$3 = str3;
        this.f$4 = str4;
        this.f$5 = avatar;
        this.f$6 = hashMap;
        this.f$7 = instance;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SceneRenderer.r15Clothing$lambda$87(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7);
    }
}
