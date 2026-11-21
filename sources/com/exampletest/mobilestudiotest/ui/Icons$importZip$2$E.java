package com.exampletest.mobilestudiotest.ui;

import java.util.zip.ZipEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Icons.kt */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"com/exampletest/mobilestudiotest/ui/Icons$importZip$2$E", "", "palette", "", "theme", "kind", "res", "name", "entry", "Ljava/util/zip/ZipEntry;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/zip/ZipEntry;)V", "getPalette", "()Ljava/lang/String;", "getTheme", "getKind", "getRes", "getName", "getEntry", "()Ljava/util/zip/ZipEntry;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Icons$importZip$2$E {
    private final ZipEntry entry;
    private final String kind;
    private final String name;
    private final String palette;
    private final String res;
    private final String theme;

    public Icons$importZip$2$E(String palette, String theme, String kind, String res, String name, ZipEntry entry) {
        Intrinsics.checkNotNullParameter(palette, "palette");
        Intrinsics.checkNotNullParameter(theme, "theme");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(entry, "entry");
        this.palette = palette;
        this.theme = theme;
        this.kind = kind;
        this.res = res;
        this.name = name;
        this.entry = entry;
    }

    public final ZipEntry getEntry() {
        return this.entry;
    }

    public final String getKind() {
        return this.kind;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPalette() {
        return this.palette;
    }

    public final String getRes() {
        return this.res;
    }

    public final String getTheme() {
        return this.theme;
    }
}
