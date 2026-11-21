package com.exampletest.mobilestudiotest.net;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Accounts.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u000f\u001a\u00020\u0010J\u001e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0016\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0013J\u0016\u0010\u0017\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0013J\u000e\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u001d\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/Accounts;", "", "<init>", "()V", "PREFS", "", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function0;", "", "getListeners", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "ctx", "Landroid/content/Context;", "list", "", "Lcom/exampletest/mobilestudiotest/net/Accounts$Account;", "save", "upsert", "acc", "remove", "userId", "", "active", "switchTo", "useGuest", "notifyChanged", "Account", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Accounts {
    private static final String PREFS = "roblox_auth";
    public static final Accounts INSTANCE = new Accounts();
    private static final CopyOnWriteArrayList<Function0<Unit>> listeners = new CopyOnWriteArrayList<>();

    /* compiled from: Accounts.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/Accounts$Account;", "", "userId", "", "name", "", "displayName", "cookie", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()J", "getName", "()Ljava/lang/String;", "getDisplayName", "getCookie", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Account {
        private final String cookie;
        private final String displayName;
        private final String name;
        private final long userId;

        public Account(long j, String name, String displayName, String cookie) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(displayName, "displayName");
            Intrinsics.checkNotNullParameter(cookie, "cookie");
            this.userId = j;
            this.name = name;
            this.displayName = displayName;
            this.cookie = cookie;
        }

        public final String getCookie() {
            return this.cookie;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final String getName() {
            return this.name;
        }

        public final long getUserId() {
            return this.userId;
        }
    }

    private Accounts() {
    }

    private final SharedPreferences prefs(Context ctx) {
        return ctx.getApplicationContext().getSharedPreferences(PREFS, 0);
    }

    private final void save(Context ctx, List<Account> list) {
        JSONArray jSONArray = new JSONArray();
        for (Account account : list) {
            jSONArray.put(new JSONObject().put("id", account.getUserId()).put("name", account.getName()).put("displayName", account.getDisplayName()).put("cookie", account.getCookie()));
        }
        prefs(ctx).edit().putString("accounts", jSONArray.toString()).apply();
    }

    public final Account active(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String cookie = RobloxApi.INSTANCE.cookie(ctx);
        Object obj = null;
        if (cookie.length() == 0) {
            return null;
        }
        long userId = RobloxApi.INSTANCE.userId(ctx);
        Iterator<T> it = list(ctx).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Account) next).getUserId() == userId) {
                obj = next;
                break;
            }
        }
        Account account = (Account) obj;
        return account == null ? new Account(userId, RobloxApi.INSTANCE.userName(ctx), RobloxApi.INSTANCE.displayName(ctx), cookie) : account;
    }

    public final CopyOnWriteArrayList<Function0<Unit>> getListeners() {
        return listeners;
    }

    public final List<Account> list(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String string = prefs(ctx).getString("accounts", null);
        ArrayList arrayList = new ArrayList();
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    long optLong = jSONObject.optLong("id");
                    String optString = jSONObject.optString("name");
                    Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                    String optString2 = jSONObject.optString("displayName");
                    Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
                    String optString3 = jSONObject.optString("cookie");
                    Intrinsics.checkNotNullExpressionValue(optString3, "optString(...)");
                    arrayList.add(new Account(optLong, optString, optString2, optString3));
                }
            } catch (Exception e) {
            }
        }
        String cookie = RobloxApi.INSTANCE.cookie(ctx);
        long userId = RobloxApi.INSTANCE.userId(ctx);
        boolean z = true;
        if ((cookie.length() > 0) && userId != 0) {
            ArrayList arrayList2 = arrayList;
            if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                Iterator it = arrayList2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((Account) it.next()).getUserId() == userId) {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                arrayList.add(0, new Account(userId, RobloxApi.INSTANCE.userName(ctx), RobloxApi.INSTANCE.displayName(ctx), cookie));
                save(ctx, arrayList);
                return arrayList;
            }
        }
        return arrayList;
    }

    public final void notifyChanged() {
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
    }

    public final void remove(Context ctx, long userId) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        List<Account> list = list(ctx);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((Account) obj).getUserId() != userId) {
                arrayList.add(obj);
            }
        }
        save(ctx, arrayList);
        notifyChanged();
    }

    public final void switchTo(Context ctx, Account acc) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(acc, "acc");
        RobloxApi.INSTANCE.setCookie(ctx, acc.getCookie());
        RobloxApi.INSTANCE.setUser(ctx, acc.getUserId(), acc.getName(), acc.getDisplayName());
        RobloxCloud.INSTANCE.resetSession();
        notifyChanged();
    }

    public final void upsert(Context ctx, Account acc) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(acc, "acc");
        List<Account> list = list(ctx);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                List<Account> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
                mutableList.add(0, acc);
                save(ctx, mutableList);
                notifyChanged();
                return;
            }
            Object next = it.next();
            if (((Account) next).getUserId() != acc.getUserId()) {
                arrayList.add(next);
            }
        }
    }

    public final void useGuest(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        RobloxApi.INSTANCE.setCookie(ctx, "");
        RobloxApi.INSTANCE.setUser(ctx, 0L, "", "");
        RobloxCloud.INSTANCE.resetSession();
        notifyChanged();
    }
}
