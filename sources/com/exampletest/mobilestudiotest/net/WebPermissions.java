package com.exampletest.mobilestudiotest.net;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: WebPermissions.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0005J\u001d\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u001c2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016J\u001e\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000RB\u0010\u0006\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\b\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/exampletest/mobilestudiotest/net/WebPermissions;", "", "<init>", "()V", "PREFS", "", "asker", "Lkotlin/Function3;", "Lkotlin/Function1;", "", "", "getAsker", "()Lkotlin/jvm/functions/Function3;", "setAsker", "(Lkotlin/jvm/functions/Function3;)V", "pending", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CountDownLatch;", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "ctx", "Landroid/content/Context;", "isRobloxHost", "host", "decision", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Boolean;", "remembered", "", "forgetAll", "allow", "who", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WebPermissions {
    private static final String PREFS = "web_permissions";
    private static volatile Function3<? super String, ? super String, ? super Function1<? super Boolean, Unit>, Unit> asker;
    public static final WebPermissions INSTANCE = new WebPermissions();
    private static final ConcurrentHashMap<String, CountDownLatch> pending = new ConcurrentHashMap<>();

    private WebPermissions() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CountDownLatch allow$lambda$4(Ref.BooleanRef booleanRef, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        booleanRef.element = true;
        return new CountDownLatch(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CountDownLatch allow$lambda$5(Function1 function1, Object obj) {
        return (CountDownLatch) function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit allow$lambda$6(Context context, String str, CountDownLatch countDownLatch, Boolean bool) {
        if (bool != null) {
            INSTANCE.prefs(context).edit().putBoolean(str, bool.booleanValue()).commit();
        }
        countDownLatch.countDown();
        return Unit.INSTANCE;
    }

    private final SharedPreferences prefs(Context ctx) {
        return ctx.getApplicationContext().getSharedPreferences(PREFS, 0);
    }

    public final boolean allow(Context ctx, String host, String who) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(who, "who");
        if (isRobloxHost(host)) {
            return false;
        }
        Boolean decision = decision(ctx, host);
        if (decision != null) {
            return decision.booleanValue();
        }
        Function3<? super String, ? super String, ? super Function1<? super Boolean, Unit>, Unit> function3 = asker;
        if (function3 == null) {
            return false;
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        CountDownLatch computeIfAbsent = pending.computeIfAbsent(host, new WebPermissions$$ExternalSyntheticLambda1(new WebPermissions$$ExternalSyntheticLambda0(booleanRef)));
        Intrinsics.checkNotNullExpressionValue(computeIfAbsent, "computeIfAbsent(...)");
        CountDownLatch countDownLatch = computeIfAbsent;
        if (booleanRef.element) {
            try {
                function3.invoke(host, who, new WebPermissions$$ExternalSyntheticLambda2(ctx, host, countDownLatch));
            } catch (Exception e) {
                countDownLatch.countDown();
            }
        }
        countDownLatch.await(2L, TimeUnit.MINUTES);
        if (booleanRef.element) {
            pending.remove(host);
        }
        return Intrinsics.areEqual((Object) decision(ctx, host), (Object) true);
    }

    public final Boolean decision(Context ctx, String host) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(host, "host");
        SharedPreferences prefs = prefs(ctx);
        if (prefs.contains(host)) {
            return Boolean.valueOf(prefs.getBoolean(host, false));
        }
        return null;
    }

    public final void forgetAll(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        prefs(ctx).edit().clear().apply();
    }

    public final Function3<String, String, Function1<? super Boolean, Unit>, Unit> getAsker() {
        return asker;
    }

    public final boolean isRobloxHost(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        String lowerCase = host.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String trimEnd = StringsKt.trimEnd(lowerCase, '.');
        List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{"roblox.com", "rbxcdn.com", "robloxlabs.com", "rbx.com", "roblox.cn", "roblox.qq.com", "robloxdev.com"});
        if ((listOf instanceof Collection) && listOf.isEmpty()) {
            return false;
        }
        for (String str : listOf) {
            if (Intrinsics.areEqual(trimEnd, str) || StringsKt.endsWith$default(trimEnd, new StringBuilder().append(".").append(str).toString(), false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public final Map<String, Boolean> remembered(Context ctx) {
        Map<String, ?> map;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Map<String, ?> all = prefs(ctx).getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Pair pair = null;
            Boolean bool = value instanceof Boolean ? (Boolean) value : null;
            if (bool != null) {
                map = all;
                pair = TuplesKt.to(key, Boolean.valueOf(bool.booleanValue()));
            } else {
                map = all;
            }
            if (pair != null) {
                arrayList.add(pair);
            }
            all = map;
        }
        return MapsKt.toMap(arrayList);
    }

    public final void setAsker(Function3<? super String, ? super String, ? super Function1<? super Boolean, Unit>, Unit> function3) {
        asker = function3;
    }
}
