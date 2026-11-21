package com.exampletest.mobilestudiotest.net;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RobloxApi.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/HttpException;", "Ljava/io/IOException;", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "<init>", "(ILjava/lang/String;)V", "getCode", "()I", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HttpException extends IOException {
    private final int code;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpException(int i, String msg) {
        super(msg);
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }
}
