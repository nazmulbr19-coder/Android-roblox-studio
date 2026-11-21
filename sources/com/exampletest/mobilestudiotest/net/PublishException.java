package com.exampletest.mobilestudiotest.net;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RobloxCloud.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/PublishException;", "Ljava/io/IOException;", NotificationCompat.CATEGORY_MESSAGE, "", "needsApiKey", "", "<init>", "(Ljava/lang/String;Z)V", "getNeedsApiKey", "()Z", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PublishException extends IOException {
    private final boolean needsApiKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishException(String msg, boolean z) {
        super(msg);
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.needsApiKey = z;
    }

    public final boolean getNeedsApiKey() {
        return this.needsApiKey;
    }
}
