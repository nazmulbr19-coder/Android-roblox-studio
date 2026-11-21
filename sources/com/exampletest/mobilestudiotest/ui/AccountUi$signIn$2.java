package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* compiled from: AccountUi.kt */
@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/exampletest/mobilestudiotest/ui/AccountUi$signIn$2", "Landroid/webkit/WebViewClient;", "shouldOverrideUrlLoading", "", "view", "Landroid/webkit/WebView;", "req", "Landroid/webkit/WebResourceRequest;", "onPageFinished", "", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AccountUi$signIn$2 extends WebViewClient {
    final /* synthetic */ Activity $act;
    final /* synthetic */ CookieManager $cm;
    final /* synthetic */ Dialog $dlg;
    final /* synthetic */ Ref.BooleanRef $done;
    final /* synthetic */ String $previous;
    final /* synthetic */ ProgressBar $progress;
    final /* synthetic */ Function0<Unit> $then;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountUi$signIn$2(ProgressBar progressBar, Ref.BooleanRef booleanRef, CookieManager cookieManager, String str, Activity activity, Dialog dialog, Function0<Unit> function0) {
        this.$progress = progressBar;
        this.$done = booleanRef;
        this.$cm = cookieManager;
        this.$previous = str;
        this.$act = activity;
        this.$dlg = dialog;
        this.$then = function0;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        this.$progress.setVisibility(8);
        AccountUi.access$signIn$check(this.$done, this.$cm, this.$previous, this.$act, this.$dlg, this.$then);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        this.$progress.setVisibility(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x001f, code lost:
    
        if (r1 != null) goto L8;
     */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean shouldOverrideUrlLoading(android.webkit.WebView r8, android.webkit.WebResourceRequest r9) {
        /*
            r7 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "req"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            android.net.Uri r0 = r9.getUrl()
            java.lang.String r1 = r0.getHost()
            if (r1 == 0) goto L22
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toLowerCase(r2)
            java.lang.String r2 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            if (r1 == 0) goto L22
            goto L24
        L22:
            java.lang.String r1 = ""
        L24:
            java.lang.String r2 = r0.getScheme()
            java.lang.String r3 = "https"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L46
            java.lang.String r2 = "roblox.com"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r2 != 0) goto L44
            r2 = 2
            r5 = 0
            java.lang.String r6 = ".roblox.com"
            boolean r2 = kotlin.text.StringsKt.endsWith$default(r1, r6, r4, r2, r5)
            if (r2 == 0) goto L46
        L44:
            r2 = r3
            goto L47
        L46:
            r2 = r4
        L47:
            if (r2 == 0) goto L4a
            r3 = r4
        L4a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.AccountUi$signIn$2.shouldOverrideUrlLoading(android.webkit.WebView, android.webkit.WebResourceRequest):boolean");
    }
}
