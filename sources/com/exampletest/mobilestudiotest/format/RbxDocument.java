package com.exampletest.mobilestudiotest.format;

import com.exampletest.mobilestudiotest.model.Instance;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RbxBinary.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B7\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/format/RbxDocument;", "", "roots", "", "Lcom/exampletest/mobilestudiotest/model/Instance;", "meta", "", "", "warnings", "<init>", "(Ljava/util/List;Ljava/util/Map;Ljava/util/List;)V", "getRoots", "()Ljava/util/List;", "getMeta", "()Ljava/util/Map;", "getWarnings", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RbxDocument {
    private final Map<String, String> meta;
    private final List<Instance> roots;
    private final List<String> warnings;

    /* JADX WARN: Multi-variable type inference failed */
    public RbxDocument(List<? extends Instance> roots, Map<String, String> meta, List<String> warnings) {
        Intrinsics.checkNotNullParameter(roots, "roots");
        Intrinsics.checkNotNullParameter(meta, "meta");
        Intrinsics.checkNotNullParameter(warnings, "warnings");
        this.roots = roots;
        this.meta = meta;
        this.warnings = warnings;
    }

    public final Map<String, String> getMeta() {
        return this.meta;
    }

    public final List<Instance> getRoots() {
        return this.roots;
    }

    public final List<String> getWarnings() {
        return this.warnings;
    }
}
