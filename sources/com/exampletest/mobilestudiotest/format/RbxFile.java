package com.exampletest.mobilestudiotest.format;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.exampletest.mobilestudiotest.model.Instance;
import java.io.ByteArrayInputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPInputStream;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: RbxBinary.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000b¨\u0006\u0011"}, d2 = {"Lcom/exampletest/mobilestudiotest/format/RbxFile;", "", "<init>", "()V", "isBinary", "", "b", "", "isXml", "unwrap", "read", "Lcom/exampletest/mobilestudiotest/format/RbxDocument;", "b0", "normalize", "", "doc", "isPlace", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RbxFile {
    public static final RbxFile INSTANCE = new RbxFile();

    private RbxFile() {
    }

    private final void normalize(RbxDocument doc) {
        for (Instance instance : doc.getRoots()) {
            if (Intrinsics.areEqual(instance.getClassName(), "MaterialService")) {
                Object obj = instance.getProps().get("Use2022Materials");
                if (instance.getProps().containsKey("Use2022Materials")) {
                    instance.getProps().remove("Use2022Materials");
                    instance.getPropTypes().remove("Use2022Materials");
                    if (!instance.getProps().containsKey("Use2022MaterialsXml") && (obj instanceof Boolean)) {
                        instance.getProps().put("Use2022MaterialsXml", obj);
                        instance.getPropTypes().put("Use2022MaterialsXml", 2);
                    }
                }
            }
        }
    }

    public final boolean isBinary(byte[] b) {
        Intrinsics.checkNotNullParameter(b, "b");
        return b.length > 14 && Intrinsics.areEqual(new String(b, 0, 8, Charsets.ISO_8859_1), "<roblox!");
    }

    public final boolean isPlace(RbxDocument doc) {
        Intrinsics.checkNotNullParameter(doc, "doc");
        List<Instance> roots = doc.getRoots();
        if ((roots instanceof Collection) && roots.isEmpty()) {
            return false;
        }
        Iterator<T> it = roots.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((Instance) it.next()).getClassName(), "Workspace")) {
                return true;
            }
        }
        return false;
    }

    public final boolean isXml(byte[] b) {
        Intrinsics.checkNotNullParameter(b, "b");
        String trimStart = StringsKt.trimStart(new String(b, 0, Math.min(b.length, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION), Charsets.ISO_8859_1), 65279, ' ', '\n', '\r', '\t', 239, 187, 191);
        return StringsKt.startsWith$default(trimStart, "<roblox", false, 2, (Object) null) || StringsKt.startsWith$default(trimStart, "<?xml", false, 2, (Object) null);
    }

    public final RbxDocument read(byte[] b0) {
        RbxDocument read;
        Intrinsics.checkNotNullParameter(b0, "b0");
        byte[] unwrap = unwrap(b0);
        if (isBinary(unwrap)) {
            read = new RbxBinaryReader(unwrap).read();
        } else {
            if (!isXml(unwrap)) {
                throw new RbxFormatException("Not a Roblox place or model file");
            }
            read = RbxXmlReader.INSTANCE.read(unwrap);
        }
        normalize(read);
        return read;
    }

    public final byte[] unwrap(byte[] b) {
        Intrinsics.checkNotNullParameter(b, "b");
        if (b.length <= 2 || b[0] != 31 || b[1] != -117) {
            return b;
        }
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(b));
        try {
            byte[] readBytes = ByteStreamsKt.readBytes(gZIPInputStream);
            CloseableKt.closeFinally(gZIPInputStream, null);
            return readBytes;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(gZIPInputStream, th);
                throw th2;
            }
        }
    }
}
