package kotlin.io;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/io/FilesKt__FileReadWriteKt;", method = "readLines$lambda$9$FilesKt__FileReadWriteKt", proto = "(Ljava/util/ArrayList;Ljava/lang/String;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class FilesKt__FileReadWriteKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ ArrayList f$0;

    public /* synthetic */ FilesKt__FileReadWriteKt$$ExternalSyntheticLambda0(ArrayList arrayList) {
        this.f$0 = arrayList;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return FilesKt__FileReadWriteKt.$r8$lambda$4EcuRhbBdJT1OYuEKwTrZ40dPsY(this.f$0, (String) obj);
    }
}
