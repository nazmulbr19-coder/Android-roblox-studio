package kotlin.io;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/io/FilesKt__UtilsKt;", method = "copyRecursively$lambda$4$FilesKt__UtilsKt", proto = "(Lkotlin/jvm/functions/Function2;Ljava/io/File;Ljava/io/IOException;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class FilesKt__UtilsKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ Function2 f$0;

    public /* synthetic */ FilesKt__UtilsKt$$ExternalSyntheticLambda0(Function2 function2) {
        this.f$0 = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return FilesKt__UtilsKt.$r8$lambda$b184Hv2lLSyaIabDgjGNkJ5ATf4(this.f$0, (File) obj, (IOException) obj2);
    }
}
