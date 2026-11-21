package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.app.Dialog;
import android.webkit.CookieManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* compiled from: AccountUi.kt */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/exampletest/mobilestudiotest/ui/AccountUi$signIn$poll$1", "Ljava/lang/Runnable;", "run", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AccountUi$signIn$poll$1 implements Runnable {
    final /* synthetic */ Activity $act;
    final /* synthetic */ CookieManager $cm;
    final /* synthetic */ Dialog $dlg;
    final /* synthetic */ Ref.BooleanRef $done;
    final /* synthetic */ String $previous;
    final /* synthetic */ Function0<Unit> $then;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountUi$signIn$poll$1(Ref.BooleanRef booleanRef, Dialog dialog, CookieManager cookieManager, String str, Activity activity, Function0<Unit> function0) {
        this.$done = booleanRef;
        this.$dlg = dialog;
        this.$cm = cookieManager;
        this.$previous = str;
        this.$act = activity;
        this.$then = function0;
    }

    @Override // java.lang.Runnable
    public void run() {
        AccountUi.access$signIn$check(this.$done, this.$cm, this.$previous, this.$act, this.$dlg, this.$then);
        if (this.$done.element || !this.$dlg.isShowing()) {
            return;
        }
        AccountUi.access$getMain$p().postDelayed(this, 800L);
    }
}
