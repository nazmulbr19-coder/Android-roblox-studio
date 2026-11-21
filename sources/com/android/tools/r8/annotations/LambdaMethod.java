package com.android.tools.r8.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: D8$$SyntheticClass */
@SynthesizedClassV2(apiLevel = 24, kind = 5, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes9.dex */
public /* synthetic */ @interface LambdaMethod {
    String holder();

    String method();

    String proto();
}
