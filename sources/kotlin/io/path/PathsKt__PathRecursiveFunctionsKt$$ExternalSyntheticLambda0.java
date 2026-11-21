package kotlin.io.path;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.nio.file.Path;
import kotlin.jvm.functions.Function3;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/io/path/PathsKt__PathRecursiveFunctionsKt;", method = "copyToRecursively$lambda$1$PathsKt__PathRecursiveFunctionsKt", proto = "(ZLkotlin/io/path/CopyActionContext;Ljava/nio/file/Path;Ljava/nio/file/Path;)Lkotlin/io/path/CopyActionResult;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda0 implements Function3 {
    public final /* synthetic */ boolean f$0;

    public /* synthetic */ PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda0(boolean z) {
        this.f$0 = z;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return PathsKt__PathRecursiveFunctionsKt.$r8$lambda$3VYkoVP17knpGuiVw5BoXBQ_zc8(this.f$0, (CopyActionContext) obj, (Path) obj2, (Path) obj3);
    }
}
