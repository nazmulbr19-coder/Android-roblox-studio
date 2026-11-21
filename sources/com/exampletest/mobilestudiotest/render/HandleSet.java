package com.exampletest.mobilestudiotest.render;

import com.exampletest.mobilestudiotest.core.Tool;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Vector3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SceneRenderer.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/HandleSet;", "", "tool", "Lcom/exampletest/mobilestudiotest/core/Tool;", "center", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "handles", "", "Lcom/exampletest/mobilestudiotest/render/Handle;", "local", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "<init>", "(Lcom/exampletest/mobilestudiotest/core/Tool;Lcom/exampletest/mobilestudiotest/model/Vector3;Ljava/util/List;Lcom/exampletest/mobilestudiotest/model/CFrame;)V", "getTool", "()Lcom/exampletest/mobilestudiotest/core/Tool;", "getCenter", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "getHandles", "()Ljava/util/List;", "getLocal", "()Lcom/exampletest/mobilestudiotest/model/CFrame;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class HandleSet {
    private final Vector3 center;
    private final List<Handle> handles;
    private final CFrame local;
    private final Tool tool;

    public HandleSet(Tool tool, Vector3 center, List<Handle> handles, CFrame cFrame) {
        Intrinsics.checkNotNullParameter(tool, "tool");
        Intrinsics.checkNotNullParameter(center, "center");
        Intrinsics.checkNotNullParameter(handles, "handles");
        this.tool = tool;
        this.center = center;
        this.handles = handles;
        this.local = cFrame;
    }

    public final Vector3 getCenter() {
        return this.center;
    }

    public final List<Handle> getHandles() {
        return this.handles;
    }

    public final CFrame getLocal() {
        return this.local;
    }

    public final Tool getTool() {
        return this.tool;
    }
}
