package kotlin.io.path;

import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PathRecursiveFunctions.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
final class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$3 implements Function3 {
    public static final PathsKt__PathRecursiveFunctionsKt$copyToRecursively$3 INSTANCE = new PathsKt__PathRecursiveFunctionsKt$copyToRecursively$3();

    PathsKt__PathRecursiveFunctionsKt$copyToRecursively$3() {
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Path) obj, (Path) obj2, (Exception) obj3);
    }

    public final Void invoke(Path path, Path path2, Exception exception) {
        Intrinsics.checkNotNullParameter(path, "<unused var>");
        Intrinsics.checkNotNullParameter(path2, "<unused var>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        throw exception;
    }
}
