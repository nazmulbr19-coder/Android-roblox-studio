package com.exampletest.mobilestudiotest.ui;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.exampletest.mobilestudiotest.core.OutputLog;
import com.exampletest.mobilestudiotest.core.Recents;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.engine.Avatar;
import com.exampletest.mobilestudiotest.format.RbxFile;
import com.exampletest.mobilestudiotest.model.Color3;
import com.exampletest.mobilestudiotest.net.Accounts;
import com.exampletest.mobilestudiotest.net.AuthRequiredException;
import com.exampletest.mobilestudiotest.net.CloudPlace;
import com.exampletest.mobilestudiotest.net.Http;
import com.exampletest.mobilestudiotest.net.ImageLoader;
import com.exampletest.mobilestudiotest.net.PublishException;
import com.exampletest.mobilestudiotest.net.RobloxApi;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import com.google.android.material.navigation.NavigationBarView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AccountUi.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\\B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\n0\u0013JT\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\n0\u00132\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0013J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000fH\u0002J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fJ\u0016\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u001e\u0010%\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J \u0010*\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0011J\"\u0010,\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0011H\u0007J\u000e\u0010-\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010.\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\u0011H\u0002J\u001a\u0010/\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'J\u000e\u00100\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJF\u00101\u001a\u0002022\u0006\u0010\f\u001a\u00020\r2\u0006\u00103\u001a\u00020\u000f2\f\u00104\u001a\b\u0012\u0004\u0012\u000206052\u0006\u00107\u001a\u00020\u000f2\u0016\b\u0002\u00108\u001a\u0010\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013H\u0002J<\u0010:\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u001c\b\u0002\u0010;\u001a\u0016\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\n\u0018\u00010<JB\u0010?\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010@\u001a\u00020=2\u001a\u0010;\u001a\u0016\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\n\u0018\u00010<J\u0010\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000fH\u0002J.\u0010C\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010@\u001a\u00020=2\u0006\u0010D\u001a\u00020>J7\u0010E\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010(\u001a\u00020)2\b\u0010@\u001a\u0004\u0018\u00010=2\u0006\u0010D\u001a\u00020>2\b\u0010F\u001a\u0004\u0018\u00010G¢\u0006\u0002\u0010HJ/\u0010I\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010(\u001a\u00020)2\u0006\u0010D\u001a\u00020>2\b\u0010F\u001a\u0004\u0018\u00010GH\u0002¢\u0006\u0002\u0010JJ0\u0010K\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010@\u001a\u00020=2\u0006\u0010D\u001a\u00020>H\u0002J\u001e\u0010L\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u001e\u0010M\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u001e\u0010N\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u001e\u0010O\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u001e\u0010P\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J(\u0010Q\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\u0010\b\u0002\u0010R\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0011J8\u0010S\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010T\u001a\u00020U2\u0006\u0010M\u001a\u00020\u00162\u0010\b\u0002\u0010V\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0011J\u001e\u0010W\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\u0011H\u0002J(\u0010X\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010Y\u001a\u00020\u000fJ.\u0010Z\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010[\u001a\u00020$2\u0006\u0010B\u001a\u00020\u000fR\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/AccountUi;", "", "<init>", "()V", "net", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "main", "Landroid/os/Handler;", "background", "", "T", "act", "Landroid/app/Activity;", "message", "", "work", "Lkotlin/Function0;", "done", "Lkotlin/Function1;", "failed", "", "", "showError", "e", "toast", "s", "signedIn", "dateIn", "Ljava/text/SimpleDateFormat;", "dateOut", "prettyDate", "loadHeadshot", "img", "Landroid/widget/ImageView;", "userId", "", "show", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "actions", "Lcom/exampletest/mobilestudiotest/ui/MainActions;", "advanced", "then", "signIn", "signOut", "requireSignIn", "avatarDialog", "customAvatar", "listDialog", "Landroid/app/AlertDialog;", "title", "rows", "", "Lcom/exampletest/mobilestudiotest/ui/AccountUi$Row;", "empty", "extra", "Landroid/app/AlertDialog$Builder;", "myGames", "pick", "Lkotlin/Function2;", "Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Game;", "Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Place;", "places", "g", "safeFile", "name", "placeActions", "p", "openPlace", "version", "", "(Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/ui/MainActions;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Game;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Place;Ljava/lang/Integer;)V", "downloadPlace", "(Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/ui/MainActions;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Place;Ljava/lang/Integer;)V", "versionHistory", "openById", "publish", "publishAs", "createNewGame", "currentPlaceHistory", "saveToRoblox", "onSaved", "upload", "c", "Lcom/exampletest/mobilestudiotest/net/CloudPlace;", "onDone", "requireSignInOrKey", "installPluginFromRoblox", "initial", "installPluginId", "id", "Row", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AccountUi {
    private static final SimpleDateFormat dateIn;
    private static final SimpleDateFormat dateOut;
    public static final AccountUi INSTANCE = new AccountUi();
    private static final ExecutorService net = Executors.newSingleThreadExecutor();
    private static final Handler main = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AccountUi.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/AccountUi$Row;", "", "title", "", "sub", "iconUrl", "iconFallback", "Landroid/graphics/drawable/Drawable;", "onClick", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;Lkotlin/jvm/functions/Function0;)V", "getTitle", "()Ljava/lang/String;", "getSub", "getIconUrl", "getIconFallback", "()Landroid/graphics/drawable/Drawable;", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Row {
        private final Drawable iconFallback;
        private final String iconUrl;
        private final Function0<Unit> onClick;
        private final String sub;
        private final String title;

        public Row(String title, String sub, String str, Drawable drawable, Function0<Unit> onClick) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(sub, "sub");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.title = title;
            this.sub = sub;
            this.iconUrl = str;
            this.iconFallback = drawable;
            this.onClick = onClick;
        }

        public final Drawable getIconFallback() {
            return this.iconFallback;
        }

        public final String getIconUrl() {
            return this.iconUrl;
        }

        public final Function0<Unit> getOnClick() {
            return this.onClick;
        }

        public final String getSub() {
            return this.sub;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        dateIn = simpleDateFormat;
        dateOut = new SimpleDateFormat("MMM d, yyyy  h:mm a", Locale.getDefault());
    }

    private AccountUi() {
    }

    public static final /* synthetic */ Handler access$getMain$p() {
        return main;
    }

    public static final /* synthetic */ void access$signIn$check(Ref.BooleanRef booleanRef, CookieManager cookieManager, String str, Activity activity, Dialog dialog, Function0 function0) {
        signIn$check(booleanRef, cookieManager, str, activity, dialog, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void advanced$default(AccountUi accountUi, Activity activity, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        accountUi.advanced(activity, function0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit advanced$lambda$44(Activity activity, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://create.roblox.com/dashboard/credentials")));
        } catch (Exception e) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void advanced$lambda$54(Activity activity, EditText editText, EditText editText2, Function0 function0, DialogInterface dialogInterface, int i) {
        RobloxApi.INSTANCE.setApiKey(activity, editText.getText().toString());
        String obj = StringsKt.trim((CharSequence) editText2.getText().toString()).toString();
        if (obj.length() > 0) {
            RobloxApi.INSTANCE.setCookie(activity, obj);
            INSTANCE.background(activity, "Checking your account…", new AccountUi$$ExternalSyntheticLambda41(activity), new AccountUi$$ExternalSyntheticLambda42(activity, function0));
        } else if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final RobloxCloud.User advanced$lambda$54$lambda$52(Activity activity) {
        return RobloxCloud.INSTANCE.currentUser(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit advanced$lambda$54$lambda$53(Activity activity, Function0 function0, RobloxCloud.User u) {
        Intrinsics.checkNotNullParameter(u, "u");
        INSTANCE.toast(activity, "Signed in as @" + u.getName());
        Avatar.INSTANCE.refresh(activity);
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void avatarDialog$default(AccountUi accountUi, Activity activity, Studio studio, int i, Object obj) {
        if ((i & 2) != 0) {
            studio = null;
        }
        accountUi.avatarDialog(activity, studio);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void background$lambda$3(Ref.BooleanRef booleanRef, DialogInterface dialogInterface, int i) {
        booleanRef.element = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void background$lambda$4(Ref.BooleanRef booleanRef, DialogInterface dialogInterface) {
        booleanRef.element = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void background$lambda$7(Function0 function0, Activity activity, AlertDialog alertDialog, Ref.BooleanRef booleanRef, Function1 function1, Function1 function12) {
        Object m457constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m457constructorimpl = Result.m457constructorimpl(function0.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m457constructorimpl = Result.m457constructorimpl(ResultKt.createFailure(th));
        }
        main.post(new AccountUi$$ExternalSyntheticLambda74(activity, alertDialog, booleanRef, m457constructorimpl, function1, function12));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void background$lambda$7$lambda$6(Activity activity, AlertDialog alertDialog, Ref.BooleanRef booleanRef, Object obj, Function1 function1, Function1 function12) {
        if (activity.isFinishing()) {
            return;
        }
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
        }
        if (booleanRef.element) {
            return;
        }
        Throwable m460exceptionOrNullimpl = Result.m460exceptionOrNullimpl(obj);
        if (m460exceptionOrNullimpl == null) {
            function1.invoke(obj);
            return;
        }
        boolean z = false;
        if (function12 != null && ((Boolean) function12.invoke(m460exceptionOrNullimpl)).booleanValue()) {
            z = true;
        }
        if (z) {
            return;
        }
        INSTANCE.showError(activity, m460exceptionOrNullimpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit createNewGame$lambda$161(Activity activity, Studio studio) {
        INSTANCE.background(activity, "Loading your groups…", new AccountUi$$ExternalSyntheticLambda35(activity), new AccountUi$$ExternalSyntheticLambda36(activity, studio));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List createNewGame$lambda$161$lambda$148(Activity activity) {
        RobloxCloud.User cachedUser = RobloxCloud.INSTANCE.cachedUser(activity);
        if (cachedUser == null) {
            cachedUser = RobloxCloud.INSTANCE.currentUser(activity);
        }
        try {
            return RobloxCloud.INSTANCE.groups(activity, cachedUser);
        } catch (AuthRequiredException e) {
            throw e;
        } catch (Exception e2) {
            return CollectionsKt.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit createNewGame$lambda$161$lambda$160(Activity activity, Studio studio, List groups) {
        String str;
        Intrinsics.checkNotNullParameter(groups, "groups");
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(Ui.INSTANCE.dp(activity, 18.0f), Ui.INSTANCE.dp(activity, 8.0f), Ui.INSTANCE.dp(activity, 18.0f), 0);
        createNewGame$lambda$161$lambda$160$label(linearLayout, activity, "Name");
        Ui ui = Ui.INSTANCE;
        Activity activity2 = activity;
        CloudPlace cloud = studio.getCloud();
        if (cloud == null || (str = cloud.getName()) == null) {
            String substringBeforeLast$default = StringsKt.substringBeforeLast$default(studio.getFileName(), '.', (String) null, 2, (Object) null);
            if (StringsKt.isBlank(substringBeforeLast$default)) {
                substringBeforeLast$default = "My Game";
            }
            str = substringBeforeLast$default;
        }
        EditText input$default = Ui.input$default(ui, activity2, str, "Game name", false, false, 24, null);
        linearLayout.addView(input$default, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        createNewGame$lambda$161$lambda$160$label(linearLayout, activity, "Description");
        EditText input$default2 = Ui.input$default(Ui.INSTANCE, activity, "", "Optional", false, false, 24, null);
        linearLayout.addView(input$default2, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        createNewGame$lambda$161$lambda$160$label(linearLayout, activity, "Creator");
        List listOf = CollectionsKt.listOf(TuplesKt.to("Me (@" + RobloxApi.INSTANCE.userName(activity) + ")", 0L));
        List<RobloxCloud.Group> list = groups;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (RobloxCloud.Group group : list) {
            arrayList.add(TuplesKt.to(group.getName(), Long.valueOf(group.getId())));
        }
        List plus = CollectionsKt.plus((Collection) listOf, (Iterable) arrayList);
        Spinner spinner = new Spinner(activity);
        Activity activity3 = activity;
        List list2 = plus;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add((String) ((Pair) it.next()).getFirst());
        }
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(activity3, R.layout.simple_spinner_dropdown_item, arrayList2));
        linearLayout.addView(spinner, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        TextView text$default = Ui.text$default(Ui.INSTANCE, activity, "The new game is private until you make it public on create.roblox.com. Publishing the place into it uses your Open Cloud API key if you've added one (it needs access to the new game).", 11.0f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default.setSingleLine(false);
        text$default.setPadding(0, Ui.INSTANCE.dp(activity, 10.0f), 0, 0);
        linearLayout.addView(text$default);
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(activity).setTitle("Create new game");
        ScrollView scrollView = new ScrollView(activity);
        scrollView.addView(linearLayout);
        title.setView(scrollView).setPositiveButton("Create", new AccountUi$$ExternalSyntheticLambda13(input$default, plus, spinner, activity, input$default2, studio)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
        return Unit.INSTANCE;
    }

    private static final void createNewGame$lambda$161$lambda$160$label(LinearLayout linearLayout, Activity activity, String str) {
        TextView text = Ui.INSTANCE.text(activity, str, 12.0f, Ui.INSTANCE.getDIM(), true);
        text.setPadding(0, Ui.INSTANCE.dp(activity, 8.0f), 0, Ui.INSTANCE.dp(activity, 3.0f));
        linearLayout.addView(text);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void createNewGame$lambda$161$lambda$160$lambda$159(EditText editText, List list, Spinner spinner, Activity activity, EditText editText2, Studio studio, DialogInterface dialogInterface, int i) {
        String obj = StringsKt.trim((CharSequence) editText.getText().toString()).toString();
        if (obj.length() == 0) {
            obj = "My Game";
        }
        String take = StringsKt.take(obj, 50);
        Pair pair = (Pair) CollectionsKt.getOrNull(list, spinner.getSelectedItemPosition());
        INSTANCE.background(activity, "Creating “" + take + "” on Roblox…", new AccountUi$$ExternalSyntheticLambda44(activity, take, pair != null ? ((Number) pair.getSecond()).longValue() : 0L, editText2), new AccountUi$$ExternalSyntheticLambda45(activity, studio));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Pair createNewGame$lambda$161$lambda$160$lambda$159$lambda$157(Activity activity, String str, long j, EditText editText) {
        return RobloxCloud.INSTANCE.createGame(activity, str, j, StringsKt.trim((CharSequence) editText.getText().toString()).toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit createNewGame$lambda$161$lambda$160$lambda$159$lambda$158(Activity activity, Studio studio, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        RobloxCloud.Game game = (RobloxCloud.Game) pair.component1();
        RobloxCloud.Place place = (RobloxCloud.Place) pair.component2();
        OutputLog.INSTANCE.info("Created game “" + game.getName() + "” (place " + place.getId() + ") on Roblox");
        StartCache.INSTANCE.forget(activity);
        upload$default(INSTANCE, activity, studio, new CloudPlace(game.getUniverseId(), place.getId(), game.getName()), true, null, 16, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit currentPlaceHistory$lambda$168(CloudPlace cloudPlace, Activity activity, MainActions mainActions, Studio studio) {
        RobloxCloud.Game game = new RobloxCloud.Game(cloudPlace.getUniverseId(), cloudPlace.getName(), cloudPlace.getPlaceId(), "", "", 0L, 32, null);
        RobloxCloud.Place place = new RobloxCloud.Place(cloudPlace.getPlaceId(), cloudPlace.getName(), cloudPlace.getUniverseId());
        List listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("Download this place (latest saved version)…", new AccountUi$$ExternalSyntheticLambda105(activity, mainActions, place)), TuplesKt.to("Version history…", new AccountUi$$ExternalSyntheticLambda106(activity, studio, mainActions, game, place)), TuplesKt.to("Other games…", new AccountUi$$ExternalSyntheticLambda107(activity, studio, mainActions))});
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(activity).setTitle("“" + cloudPlace.getName() + "” (place " + cloudPlace.getPlaceId() + ")");
        List list = listOf;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Pair) it.next()).getFirst());
        }
        title.setItems((CharSequence[]) arrayList.toArray(new String[0]), new AccountUi$$ExternalSyntheticLambda108(listOf)).setNegativeButton("Close", (DialogInterface.OnClickListener) null).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit currentPlaceHistory$lambda$168$lambda$163(Activity activity, MainActions mainActions, RobloxCloud.Place place) {
        INSTANCE.downloadPlace(activity, mainActions, place, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit currentPlaceHistory$lambda$168$lambda$164(Activity activity, Studio studio, MainActions mainActions, RobloxCloud.Game game, RobloxCloud.Place place) {
        INSTANCE.versionHistory(activity, studio, mainActions, game, place);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit currentPlaceHistory$lambda$168$lambda$165(Activity activity, Studio studio, MainActions mainActions) {
        myGames$default(INSTANCE, activity, studio, mainActions, null, 8, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void currentPlaceHistory$lambda$168$lambda$167(List list, DialogInterface dialogInterface, int i) {
        ((Function0) ((Pair) list.get(i)).getSecond()).invoke();
    }

    private static final EditText customAvatar$field(LinearLayout linearLayout, Activity activity, JSONObject jSONObject, String str, String str2, String str3) {
        TextView text = Ui.INSTANCE.text(activity, str, 13.0f, Ui.INSTANCE.getTEXT(), true);
        text.setPadding(0, Ui.INSTANCE.dp(activity, 10.0f), 0, Ui.INSTANCE.dp(activity, 3.0f));
        linearLayout.addView(text);
        String optString = jSONObject.optString(str2);
        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
        EditText input$default = Ui.input$default(Ui.INSTANCE, activity, optString, str3, false, false, 24, null);
        linearLayout.addView(input$default, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        return input$default;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void customAvatar$lambda$70(Activity activity, String str, HashMap hashMap, String str2, View view, View view2) {
        Object obj = hashMap.get(str2);
        Intrinsics.checkNotNull(obj);
        Dialogs.INSTANCE.colorPicker(activity, str, (Color3) obj, new AccountUi$$ExternalSyntheticLambda11(hashMap, str2, view, activity));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit customAvatar$lambda$70$lambda$69(HashMap hashMap, String str, View view, Activity activity, Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.exampletest.mobilestudiotest.model.Color3");
        hashMap.put(str, (Color3) obj);
        customAvatar$paint(view, hashMap, str, activity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void customAvatar$lambda$74(HashMap hashMap, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, Activity activity, DialogInterface dialogInterface, int i) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : hashMap.entrySet()) {
            jSONObject.put((String) entry.getKey(), ((Color3) entry.getValue()).toHex());
        }
        JSONObject put = new JSONObject().put("colors", jSONObject).put("shirt", StringsKt.trim((CharSequence) editText.getText().toString()).toString()).put("pants", StringsKt.trim((CharSequence) editText2.getText().toString()).toString()).put("tshirt", StringsKt.trim((CharSequence) editText3.getText().toString()).toString()).put("face", StringsKt.trim((CharSequence) editText4.getText().toString()).toString()).put("accessories", StringsKt.trim((CharSequence) editText5.getText().toString()).toString());
        Intrinsics.checkNotNull(put);
        Avatar.INSTANCE.setCustom(activity, put);
        INSTANCE.toast(activity, "Custom avatar saved");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void customAvatar$lambda$81(Activity activity, List list, DialogInterface dialogInterface, int i) {
        Dialogs.INSTANCE.prompt(activity, "Copy colors from which username?", "", new AccountUi$$ExternalSyntheticLambda46(activity, list));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit customAvatar$lambda$81$lambda$80(Activity activity, List list, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        INSTANCE.background(activity, "Loading @" + name + "…", new AccountUi$$ExternalSyntheticLambda5(name), new AccountUi$$ExternalSyntheticLambda6(list, activity));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final JSONObject customAvatar$lambda$81$lambda$80$lambda$75(String str) {
        RobloxCloud.User userByName = RobloxCloud.INSTANCE.userByName(str);
        if (userByName == null) {
            throw new Exception("No Roblox user named \"" + str + "\".");
        }
        return Http.json$default(Http.INSTANCE, "https://avatar.roblox.com/v2/avatar/users/" + userByName.getId() + "/avatar", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit customAvatar$lambda$81$lambda$80$lambda$79(List list, Activity activity, JSONObject j) {
        String str;
        Intrinsics.checkNotNullParameter(j, "j");
        JSONObject optJSONObject = j.optJSONObject("bodyColor3s");
        JSONObject jSONObject = new JSONObject();
        if (optJSONObject != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str2 = (String) ((Pair) it.next()).component1();
                String optString = optJSONObject.optString(str2 + "Color3");
                Intrinsics.checkNotNull(optString);
                if (!(optString.length() > 0)) {
                    optString = null;
                }
                if (optString != null) {
                    jSONObject.put(str2, optString);
                }
            }
        }
        JSONArray optJSONArray = j.optJSONArray("assets");
        JSONObject put = new JSONObject().put("colors", jSONObject);
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                JSONObject optJSONObject2 = jSONObject2.optJSONObject("assetType");
                int optInt = optJSONObject2 != null ? optJSONObject2.optInt("id") : 0;
                String valueOf = String.valueOf(jSONObject2.optLong("id"));
                switch (optInt) {
                    case 2:
                        str = "tshirt";
                        break;
                    case 8:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                        arrayList.add(valueOf);
                        continue;
                    case 11:
                        str = "shirt";
                        break;
                    case 12:
                        str = "pants";
                        break;
                    case 18:
                        str = "face";
                        break;
                }
                put.put(str, valueOf);
            }
        }
        put.put("accessories", CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null));
        main.post(new AccountUi$$ExternalSyntheticLambda102(activity, put));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void customAvatar$lambda$81$lambda$80$lambda$79$lambda$78(Activity activity, JSONObject jSONObject) {
        activity.getSharedPreferences("avatar", 0).edit().putString("custom", jSONObject.toString()).apply();
        INSTANCE.customAvatar(activity);
    }

    private static final void customAvatar$paint(View view, HashMap<String, Color3> hashMap, String str, Activity activity) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        Color3 color3 = hashMap.get(str);
        Intrinsics.checkNotNull(color3);
        gradientDrawable.setColor(color3.toArgb());
        gradientDrawable.setCornerRadius(Ui.INSTANCE.dp(activity, 4.0f));
        gradientDrawable.setStroke(1, -7829368);
        view.setBackground(gradientDrawable);
    }

    private final void downloadPlace(Activity act, MainActions actions, RobloxCloud.Place p, Integer version) {
        background(act, "Downloading " + p.getName() + "…", new AccountUi$$ExternalSyntheticLambda67(act, p, version), new AccountUi$$ExternalSyntheticLambda68(actions, p, version));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final byte[] downloadPlace$lambda$114(Activity activity, RobloxCloud.Place place, Integer num) {
        return RobloxCloud.INSTANCE.downloadPlace(activity, place.getId(), num);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x002d, code lost:
    
        if (r1 != null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit downloadPlace$lambda$117(com.exampletest.mobilestudiotest.ui.MainActions r5, com.exampletest.mobilestudiotest.net.RobloxCloud.Place r6, java.lang.Integer r7, byte[] r8) {
        /*
            java.lang.String r0 = "bytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.exampletest.mobilestudiotest.ui.AccountUi r0 = com.exampletest.mobilestudiotest.ui.AccountUi.INSTANCE
            java.lang.String r1 = r6.getName()
            java.lang.String r0 = r0.safeFile(r1)
            if (r7 == 0) goto L30
            r1 = r7
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "_v"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r1)
            java.lang.String r1 = r3.toString()
            if (r1 == 0) goto L30
            goto L32
        L30:
            java.lang.String r1 = ""
        L32:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ".rbxl"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.exampletest.mobilestudiotest.ui.AccountUi$$ExternalSyntheticLambda90 r1 = new com.exampletest.mobilestudiotest.ui.AccountUi$$ExternalSyntheticLambda90
            r1.<init>(r8)
            r5.saveBytesAs(r0, r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.AccountUi.downloadPlace$lambda$117(com.exampletest.mobilestudiotest.ui.MainActions, com.exampletest.mobilestudiotest.net.RobloxCloud$Place, java.lang.Integer, byte[]):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final byte[] downloadPlace$lambda$117$lambda$116(byte[] bArr) {
        return bArr;
    }

    public static /* synthetic */ void installPluginFromRoblox$default(AccountUi accountUi, Activity activity, Studio studio, MainActions mainActions, String str, int i, Object obj) {
        if ((i & 8) != 0) {
            str = "";
        }
        accountUi.installPluginFromRoblox(activity, studio, mainActions, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit installPluginFromRoblox$lambda$178(Activity activity, Studio studio, MainActions mainActions, String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        Long parseAssetId = RobloxApi.INSTANCE.parseAssetId(s);
        if (parseAssetId == null) {
            INSTANCE.toast(activity, "Paste a plugin ID or a link containing one");
            return Unit.INSTANCE;
        }
        long longValue = parseAssetId.longValue();
        INSTANCE.installPluginId(activity, studio, mainActions, longValue, "Plugin_" + longValue);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final File installPluginId$lambda$179(Activity activity, long j, Studio studio, String str) {
        return studio.getPlugins().install(str, RobloxApi.downloadAsset$default(RobloxApi.INSTANCE, activity, j, null, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit installPluginId$lambda$180(Studio studio, MainActions mainActions, Activity activity, File f) {
        Intrinsics.checkNotNullParameter(f, "f");
        studio.getPlugins().load(f);
        studio.notifyPluginButtons();
        mainActions.pluginsChanged();
        INSTANCE.toast(activity, "Installed " + FilesKt.getNameWithoutExtension(f));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v6, types: [android.app.AlertDialog, T, java.lang.Object] */
    private final AlertDialog listDialog(Activity act, String title, List<Row> rows, String empty, Function1<? super AlertDialog.Builder, Unit> extra) {
        ListView listView;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        ListView listView2 = new ListView(act);
        ArrayList arrayList = new ArrayList();
        AccountUi$listDialog$adapter$1 accountUi$listDialog$adapter$1 = new AccountUi$listDialog$adapter$1(rows, act);
        listView2.setAdapter((ListAdapter) accountUi$listDialog$adapter$1);
        AccountUi$$ExternalSyntheticLambda16 accountUi$$ExternalSyntheticLambda16 = new AccountUi$$ExternalSyntheticLambda16(accountUi$listDialog$adapter$1);
        arrayList.add(accountUi$$ExternalSyntheticLambda16);
        ImageLoader.INSTANCE.getListeners().add(accountUi$$ExternalSyntheticLambda16);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        listView2.setOnItemClickListener(new AccountUi$$ExternalSyntheticLambda17(objectRef, rows));
        if (rows.isEmpty()) {
            TextView text$default = Ui.text$default(Ui.INSTANCE, act, empty, 14.0f, Ui.INSTANCE.getDIM(), false, 16, null);
            text$default.setSingleLine(false);
            text$default.setPadding(Ui.INSTANCE.dp(act, 20.0f), Ui.INSTANCE.dp(act, 16.0f), Ui.INSTANCE.dp(act, 20.0f), Ui.INSTANCE.dp(act, 16.0f));
            listView = text$default;
        } else {
            listView = listView2;
        }
        AlertDialog.Builder negativeButton = Dialogs.INSTANCE.themed(act).setTitle(title).setView(listView).setNegativeButton("Close", (DialogInterface.OnClickListener) null);
        if (extra != null) {
            Intrinsics.checkNotNull(negativeButton);
            extra.invoke(negativeButton);
        }
        ?? create = negativeButton.create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        objectRef.element = create;
        if (objectRef.element == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("dlg");
            alertDialog = null;
        } else {
            alertDialog = (AlertDialog) objectRef.element;
        }
        alertDialog.setOnDismissListener(new AccountUi$$ExternalSyntheticLambda18(arrayList));
        if (objectRef.element == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("dlg");
            alertDialog2 = null;
        } else {
            alertDialog2 = (AlertDialog) objectRef.element;
        }
        alertDialog2.show();
        if (objectRef.element != 0) {
            return (AlertDialog) objectRef.element;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dlg");
        return null;
    }

    static /* synthetic */ AlertDialog listDialog$default(AccountUi accountUi, Activity activity, String str, List list, String str2, Function1 function1, int i, Object obj) {
        if ((i & 16) != 0) {
            function1 = null;
        }
        return accountUi.listDialog(activity, str, list, str2, function1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit listDialog$lambda$83(AccountUi$listDialog$adapter$1 accountUi$listDialog$adapter$1, String k) {
        Intrinsics.checkNotNullParameter(k, "k");
        if (StringsKt.startsWith$default(k, "url:", false, 2, (Object) null)) {
            main.post(new AccountUi$$ExternalSyntheticLambda32(accountUi$listDialog$adapter$1));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void listDialog$lambda$83$lambda$82(AccountUi$listDialog$adapter$1 accountUi$listDialog$adapter$1) {
        accountUi$listDialog$adapter$1.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void listDialog$lambda$84(Ref.ObjectRef objectRef, List list, AdapterView adapterView, View view, int i, long j) {
        AlertDialog alertDialog;
        if (objectRef.element == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("dlg");
            alertDialog = null;
        } else {
            alertDialog = (AlertDialog) objectRef.element;
        }
        alertDialog.dismiss();
        ((Row) list.get(i)).getOnClick().invoke();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void listDialog$lambda$87(ArrayList arrayList, DialogInterface dialogInterface) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ImageLoader.INSTANCE.getListeners().remove((Function1) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void loadHeadshot$lambda$13(long j, ImageView imageView) {
        String headshot = RobloxCloud.INSTANCE.headshot(j);
        if (headshot == null) {
            return;
        }
        String str = "url:" + headshot;
        imageView.setTag(Long.valueOf(j));
        loadHeadshot$lambda$13$apply(str, imageView, j);
        ImageLoader.INSTANCE.getListeners().add(new AccountUi$$ExternalSyntheticLambda4(str, imageView, j));
    }

    private static final void loadHeadshot$lambda$13$apply(String str, ImageView imageView, long j) {
        Bitmap key = ImageLoader.INSTANCE.getKey(str);
        if (key != null) {
            main.post(new AccountUi$$ExternalSyntheticLambda33(imageView, j, key));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void loadHeadshot$lambda$13$apply$lambda$11$lambda$10(ImageView imageView, long j, Bitmap bitmap) {
        if (Intrinsics.areEqual(imageView.getTag(), Long.valueOf(j))) {
            imageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit loadHeadshot$lambda$13$lambda$12(String str, ImageView imageView, long j, String k) {
        Intrinsics.checkNotNullParameter(k, "k");
        if (Intrinsics.areEqual(k, str)) {
            loadHeadshot$lambda$13$apply(str, imageView, j);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void myGames$default(AccountUi accountUi, Activity activity, Studio studio, MainActions mainActions, Function2 function2, int i, Object obj) {
        if ((i & 8) != 0) {
            function2 = null;
        }
        accountUi.myGames(activity, studio, mainActions, function2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit myGames$lambda$96(Activity activity, Function2 function2, Studio studio, MainActions mainActions) {
        INSTANCE.background(activity, "Loading your games…", new AccountUi$$ExternalSyntheticLambda109(activity), new AccountUi$$ExternalSyntheticLambda110(activity, function2, studio, mainActions));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Pair myGames$lambda$96$lambda$89(Activity activity) {
        List games$default = RobloxCloud.games$default(RobloxCloud.INSTANCE, activity, RobloxCloud.INSTANCE.currentUser(activity), false, 4, null);
        RobloxCloud robloxCloud = RobloxCloud.INSTANCE;
        List list = games$default;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((RobloxCloud.Game) it.next()).getUniverseId()));
        }
        return TuplesKt.to(games$default, robloxCloud.gameIcons(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit myGames$lambda$96$lambda$95(Activity activity, Function2 function2, Studio studio, MainActions mainActions, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        List list = (List) pair.component1();
        Map map = (Map) pair.component2();
        List<RobloxCloud.Game> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (RobloxCloud.Game game : list2) {
            arrayList.add(new Row(game.getName(), game.getOwner() + (game.getUpdated().length() > 0 ? "  ·  updated " + INSTANCE.prettyDate(game.getUpdated()) : ""), (String) map.get(Long.valueOf(game.getUniverseId())), Icons.general$default(Icons.INSTANCE, activity, "Place", null, 4, null), new AccountUi$$ExternalSyntheticLambda19(activity, studio, mainActions, game, function2)));
        }
        INSTANCE.listDialog(activity, function2 != null ? "Publish to which game?" : StartScreen.MY_GAMES, arrayList, function2 != null ? "No games yet. Tap “Create new game…” to make one from the place you're editing." : "No games found on this account. Use File → Publish to Roblox As → Create new game, or create one on create.roblox.com.", new AccountUi$$ExternalSyntheticLambda20(function2, activity, studio, mainActions));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit myGames$lambda$96$lambda$95$lambda$91$lambda$90(Activity activity, Studio studio, MainActions mainActions, RobloxCloud.Game game, Function2 function2) {
        INSTANCE.places(activity, studio, mainActions, game, function2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit myGames$lambda$96$lambda$95$lambda$94(Function2 function2, Activity activity, Studio studio, MainActions mainActions, AlertDialog.Builder b) {
        Intrinsics.checkNotNullParameter(b, "b");
        if (function2 == null) {
            b.setNeutralButton("Open by place ID…", new AccountUi$$ExternalSyntheticLambda14(activity, studio, mainActions));
        } else {
            b.setNeutralButton("Create new game…", new AccountUi$$ExternalSyntheticLambda15(activity, studio, mainActions));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void myGames$lambda$96$lambda$95$lambda$94$lambda$92(Activity activity, Studio studio, MainActions mainActions, DialogInterface dialogInterface, int i) {
        INSTANCE.openById(activity, studio, mainActions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void myGames$lambda$96$lambda$95$lambda$94$lambda$93(Activity activity, Studio studio, MainActions mainActions, DialogInterface dialogInterface, int i) {
        INSTANCE.createNewGame(activity, studio, mainActions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit openById$lambda$134(Activity activity, MainActions mainActions, String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        Long parseAssetId = RobloxApi.INSTANCE.parseAssetId(s);
        if (parseAssetId == null) {
            INSTANCE.toast(activity, "That doesn't look like a place ID");
            return Unit.INSTANCE;
        }
        long longValue = parseAssetId.longValue();
        RobloxCloud.Place place = new RobloxCloud.Place(longValue, "Place " + longValue, 0L);
        List listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("Open (save goes back to Roblox)", new AccountUi$$ExternalSyntheticLambda37(activity, mainActions, place)), TuplesKt.to("Download as .rbxl…", new AccountUi$$ExternalSyntheticLambda38(activity, mainActions, place))});
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(activity).setTitle("Place " + longValue);
        List list = listOf;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Pair) it.next()).getFirst());
        }
        title.setItems((CharSequence[]) arrayList.toArray(new String[0]), new AccountUi$$ExternalSyntheticLambda39(listOf)).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit openById$lambda$134$lambda$130(Activity activity, MainActions mainActions, RobloxCloud.Place place) {
        INSTANCE.openPlace(activity, mainActions, null, place, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit openById$lambda$134$lambda$131(Activity activity, MainActions mainActions, RobloxCloud.Place place) {
        INSTANCE.downloadPlace(activity, mainActions, place, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void openById$lambda$134$lambda$133(List list, DialogInterface dialogInterface, int i) {
        ((Function0) ((Pair) list.get(i)).getSecond()).invoke();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Pair openPlace$lambda$110(Activity activity, RobloxCloud.Place place, Integer num, RobloxCloud.Game game) {
        long longValue;
        byte[] downloadPlace = RobloxCloud.INSTANCE.downloadPlace(activity, place.getId(), num);
        if (!RbxFile.INSTANCE.isPlace(RbxFile.INSTANCE.read(downloadPlace))) {
            throw new Exception("That asset isn't a place file.");
        }
        if (game != null) {
            longValue = game.getUniverseId();
        } else {
            Long valueOf = Long.valueOf(place.getUniverseId());
            if (!(valueOf.longValue() != 0)) {
                valueOf = null;
            }
            longValue = valueOf != null ? valueOf.longValue() : RobloxCloud.INSTANCE.universeOf(place.getId());
        }
        return TuplesKt.to(downloadPlace, Long.valueOf(longValue));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0085, code lost:
    
        if (r2 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0040, code lost:
    
        if (r2 != null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit openPlace$lambda$113(com.exampletest.mobilestudiotest.net.RobloxCloud.Place r20, java.lang.Integer r21, com.exampletest.mobilestudiotest.net.RobloxCloud.Game r22, com.exampletest.mobilestudiotest.ui.MainActions r23, android.app.Activity r24, kotlin.Pair r25) {
        /*
            java.lang.String r0 = "<destruct>"
            r1 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.Object r0 = r1.component1()
            byte[] r0 = (byte[]) r0
            java.lang.Object r1 = r1.component2()
            java.lang.Number r1 = (java.lang.Number) r1
            long r3 = r1.longValue()
            com.exampletest.mobilestudiotest.ui.AccountUi r1 = com.exampletest.mobilestudiotest.ui.AccountUi.INSTANCE
            java.lang.String r2 = r20.getName()
            java.lang.String r1 = r1.safeFile(r2)
            if (r21 == 0) goto L43
            r2 = r21
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            r5 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "_v"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r2)
            java.lang.String r2 = r6.toString()
            if (r2 == 0) goto L43
            goto L45
        L43:
            java.lang.String r2 = ""
        L45:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.StringBuilder r1 = r5.append(r1)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = ".rbxl"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            if (r21 != 0) goto L92
            r5 = 0
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 == 0) goto L92
            long r5 = r20.getId()
            if (r22 == 0) goto L88
            java.lang.String r7 = r22.getName()
            if (r7 == 0) goto L88
            r8 = r7
            r9 = 0
            long r10 = r20.getId()
            long r12 = r22.getRootPlaceId()
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 != 0) goto L81
            r10 = 1
            goto L82
        L81:
            r10 = 0
        L82:
            if (r10 == 0) goto L85
            r2 = r7
        L85:
            if (r2 == 0) goto L88
            goto L8c
        L88:
            java.lang.String r2 = r20.getName()
        L8c:
            r7 = r2
            com.exampletest.mobilestudiotest.net.CloudPlace r2 = new com.exampletest.mobilestudiotest.net.CloudPlace
            r2.<init>(r3, r5, r7)
        L92:
            r15 = r2
            r2 = r23
            r2.openPlaceBytes(r1, r0, r15)
            if (r15 == 0) goto Ld8
            com.exampletest.mobilestudiotest.core.Recents r5 = com.exampletest.mobilestudiotest.core.Recents.INSTANCE
            r6 = r24
            android.content.Context r6 = (android.content.Context) r6
            com.exampletest.mobilestudiotest.core.Recents$Entry r2 = new com.exampletest.mobilestudiotest.core.Recents$Entry
            r18 = r3
            r4 = r6
            r6 = r18
            java.lang.String r3 = r15.getName()
            r9 = r4
            r8 = r5
            long r4 = r20.getId()
            com.exampletest.mobilestudiotest.net.RobloxApi r10 = com.exampletest.mobilestudiotest.net.RobloxApi.INSTANCE
            r11 = r24
            android.content.Context r11 = (android.content.Context) r11
            long r11 = r10.userId(r11)
            r13 = 24
            r14 = 0
            r10 = r8
            r8 = 0
            r17 = r9
            r16 = r10
            r9 = 0
            r25 = r16
            r16 = r0
            r0 = r25
            r25 = r1
            r1 = r17
            r2.<init>(r3, r4, r6, r8, r9, r11, r13, r14)
            r3 = r6
            r0.add(r1, r2)
            goto Ldc
        Ld8:
            r16 = r0
            r25 = r1
        Ldc:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.AccountUi.openPlace$lambda$113(com.exampletest.mobilestudiotest.net.RobloxCloud$Place, java.lang.Integer, com.exampletest.mobilestudiotest.net.RobloxCloud$Game, com.exampletest.mobilestudiotest.ui.MainActions, android.app.Activity, kotlin.Pair):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit placeActions$lambda$102(Activity activity, MainActions mainActions, RobloxCloud.Game game, RobloxCloud.Place place) {
        INSTANCE.openPlace(activity, mainActions, game, place, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit placeActions$lambda$103(Activity activity, MainActions mainActions, RobloxCloud.Place place) {
        INSTANCE.downloadPlace(activity, mainActions, place, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit placeActions$lambda$104(Activity activity, Studio studio, MainActions mainActions, RobloxCloud.Game game, RobloxCloud.Place place) {
        INSTANCE.versionHistory(activity, studio, mainActions, game, place);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit placeActions$lambda$105(Activity activity, RobloxCloud.Place place) {
        Object systemService = activity.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Place ID", String.valueOf(place.getId())));
        INSTANCE.toast(activity, "Copied " + place.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void placeActions$lambda$107(List list, DialogInterface dialogInterface, int i) {
        ((Function0) ((Pair) list.get(i)).getSecond()).invoke();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit places$lambda$100(Function2 function2, RobloxCloud.Game game, Activity activity, Studio studio, MainActions mainActions, List list) {
        Function2 function22 = function2;
        Intrinsics.checkNotNullParameter(list, "list");
        if (list.size() == 1) {
            if (function22 != null) {
                function22.invoke(game, list.get(0));
            } else {
                INSTANCE.placeActions(activity, studio, mainActions, game, (RobloxCloud.Place) list.get(0));
            }
            return Unit.INSTANCE;
        }
        AccountUi accountUi = INSTANCE;
        String name = game.getName();
        List<RobloxCloud.Place> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (RobloxCloud.Place place : list2) {
            arrayList.add(new Row(place.getName(), "Place " + place.getId() + (place.getId() == game.getRootPlaceId() ? "  ·  start place" : ""), null, Icons.general$default(Icons.INSTANCE, activity, "Place", null, 4, null), new AccountUi$$ExternalSyntheticLambda53(function22, game, place, activity, studio, mainActions)));
            function22 = function2;
        }
        listDialog$default(accountUi, activity, name, arrayList, "This experience has no places.", null, 16, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit places$lambda$100$lambda$99$lambda$98(Function2 function2, RobloxCloud.Game game, RobloxCloud.Place place, Activity activity, Studio studio, MainActions mainActions) {
        if (function2 != null) {
            function2.invoke(game, place);
        } else {
            INSTANCE.placeActions(activity, studio, mainActions, game, place);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List places$lambda$97(Activity activity, RobloxCloud.Game game) {
        return RobloxCloud.INSTANCE.places(activity, game);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit publish$lambda$136(Activity activity, Studio studio, CloudPlace cloudPlace) {
        upload$default(INSTANCE, activity, studio, cloudPlace, true, null, 16, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit publish$lambda$137(Activity activity, Studio studio, CloudPlace cloudPlace) {
        upload$default(INSTANCE, activity, studio, cloudPlace, false, null, 16, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit publish$lambda$138(Activity activity, Studio studio, MainActions mainActions) {
        INSTANCE.publishAs(activity, studio, mainActions);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void publish$lambda$140(ArrayList arrayList, DialogInterface dialogInterface, int i) {
        ((Function0) ((Pair) arrayList.get(i)).getSecond()).invoke();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit publishAs$lambda$147(Activity activity, Studio studio, MainActions mainActions) {
        List listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("Create new game…", new AccountUi$$ExternalSyntheticLambda80(activity, studio, mainActions)), TuplesKt.to("Update an existing game…", new AccountUi$$ExternalSyntheticLambda81(activity, studio, mainActions))});
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(activity).setTitle("Publish to Roblox As");
        List list = listOf;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Pair) it.next()).getFirst());
        }
        title.setItems((CharSequence[]) arrayList.toArray(new String[0]), new AccountUi$$ExternalSyntheticLambda82(listOf)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit publishAs$lambda$147$lambda$141(Activity activity, Studio studio, MainActions mainActions) {
        INSTANCE.createNewGame(activity, studio, mainActions);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit publishAs$lambda$147$lambda$144(Activity activity, Studio studio, MainActions mainActions) {
        INSTANCE.myGames(activity, studio, mainActions, new AccountUi$$ExternalSyntheticLambda103(activity, studio));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit publishAs$lambda$147$lambda$144$lambda$143(Activity activity, Studio studio, RobloxCloud.Game g, RobloxCloud.Place p) {
        Intrinsics.checkNotNullParameter(g, "g");
        Intrinsics.checkNotNullParameter(p, "p");
        Dialogs.INSTANCE.confirm(activity, "Overwrite " + p.getName() + "?", "This replaces “" + p.getName() + "” in “" + g.getName() + "” with the place you're editing and publishes it.", "Publish", new AccountUi$$ExternalSyntheticLambda7(activity, studio, g, p));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit publishAs$lambda$147$lambda$144$lambda$143$lambda$142(Activity activity, Studio studio, RobloxCloud.Game game, RobloxCloud.Place place) {
        upload$default(INSTANCE, activity, studio, new CloudPlace(game.getUniverseId(), place.getId(), place.getName()), true, null, 16, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void publishAs$lambda$147$lambda$146(List list, DialogInterface dialogInterface, int i) {
        ((Function0) ((Pair) list.get(i)).getSecond()).invoke();
    }

    private final void requireSignIn(Activity act, Function0<Unit> then) {
        if (signedIn(act)) {
            then.invoke();
        } else {
            signIn(act, then);
        }
    }

    private final void requireSignInOrKey(Activity act, Function0<Unit> then) {
        if (!signedIn(act)) {
            if (!(RobloxApi.INSTANCE.apiKey(act).length() > 0)) {
                signIn(act, then);
                return;
            }
        }
        then.invoke();
    }

    private final String safeFile(String name) {
        String obj = StringsKt.trim((CharSequence) new Regex("[^A-Za-z0-9._ -]").replace(name, "_")).toString();
        if (StringsKt.isBlank(obj)) {
            obj = "Place";
        }
        return StringsKt.take(obj, 60);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void saveToRoblox$default(AccountUi accountUi, Activity activity, Studio studio, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        accountUi.saveToRoblox(activity, studio, function0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00fa, code lost:
    
        if (r4 != null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final android.view.View show$accountRow(android.app.Activity r14, com.exampletest.mobilestudiotest.net.Accounts.Account r15, boolean r16, kotlin.jvm.functions.Function0<kotlin.Unit> r17) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.AccountUi.show$accountRow(android.app.Activity, com.exampletest.mobilestudiotest.net.Accounts$Account, boolean, kotlin.jvm.functions.Function0):android.view.View");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void show$accountRow$lambda$16$lambda$15(Function0 function0, View view) {
        function0.invoke();
    }

    private static final void show$action(LinearLayout linearLayout, Activity activity, Ref.ObjectRef<AlertDialog> objectRef, String str, Function0<Unit> function0) {
        TextView button$default = Ui.button$default(Ui.INSTANCE, activity, str, 0, new AccountUi$$ExternalSyntheticLambda34(objectRef, function0), 4, null);
        button$default.setGravity(NavigationBarView.ITEM_GRAVITY_START_CENTER);
        LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
        lp$default.topMargin = Ui.INSTANCE.dp(activity, 6.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(button$default, lp$default);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit show$action$lambda$30(Ref.ObjectRef objectRef, Function0 function0, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AlertDialog alertDialog = (AlertDialog) objectRef.element;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$20() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit show$lambda$26(Ref.ObjectRef objectRef, Activity activity, Accounts.Account account) {
        AlertDialog alertDialog = (AlertDialog) objectRef.element;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        Accounts.INSTANCE.switchTo(activity, account);
        Avatar.INSTANCE.refresh(activity);
        INSTANCE.toast(activity, "Switched to @" + account.getName());
        INSTANCE.background(activity, "Checking @" + account.getName() + "…", new AccountUi$$ExternalSyntheticLambda91(activity), new AccountUi$$ExternalSyntheticLambda92(), new AccountUi$$ExternalSyntheticLambda93(activity, account));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final RobloxCloud.User show$lambda$26$lambda$22(Activity activity) {
        return RobloxCloud.INSTANCE.currentUser(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$26$lambda$23(RobloxCloud.User it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean show$lambda$26$lambda$25(Activity activity, Accounts.Account account, Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (!(e instanceof AuthRequiredException)) {
            return true;
        }
        Dialogs.INSTANCE.themed(activity).setTitle("Sign in again").setMessage("The saved sign-in for @" + account.getName() + " has expired.").setPositiveButton("Sign in", new AccountUi$$ExternalSyntheticLambda89(activity)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void show$lambda$26$lambda$25$lambda$24(Activity activity, DialogInterface dialogInterface, int i) {
        signIn$default(INSTANCE, activity, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit show$lambda$28(Ref.ObjectRef objectRef, Activity activity) {
        AlertDialog alertDialog = (AlertDialog) objectRef.element;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        Accounts.INSTANCE.useGuest(activity);
        Avatar.INSTANCE.refresh(activity);
        INSTANCE.toast(activity, "Using Mobile Studio as a guest");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$34(Activity activity) {
        signIn$default(INSTANCE, activity, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$35(Activity activity, Studio studio) {
        INSTANCE.avatarDialog(activity, studio);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$36(Activity activity, Studio studio, MainActions mainActions) {
        myGames$default(INSTANCE, activity, studio, mainActions, null, 8, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$37(Activity activity) {
        INSTANCE.signOut(activity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$38(Activity activity) {
        advanced$default(INSTANCE, activity, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void show$lambda$41(Activity activity) {
        try {
            RobloxCloud.INSTANCE.currentUser(activity);
        } catch (Exception e) {
        }
    }

    private final void showError(Activity act, Throwable e) {
        if (e instanceof AuthRequiredException) {
            Dialogs.INSTANCE.themed(act).setTitle("Sign in needed").setMessage(e.getMessage()).setPositiveButton("Sign in", new AccountUi$$ExternalSyntheticLambda12(act)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
            return;
        }
        OutputLog.INSTANCE.error("Roblox: " + e.getMessage());
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(act).setTitle("Something went wrong");
        String message = e.getMessage();
        if (message == null) {
            message = e.toString();
        }
        title.setMessage(message).setPositiveButton("OK", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showError$lambda$8(Activity activity, DialogInterface dialogInterface, int i) {
        signIn$default(INSTANCE, activity, null, 2, null);
    }

    private static final void signIn$check(Ref.BooleanRef booleanRef, CookieManager cookieManager, String str, Activity activity, Dialog dialog, Function0<Unit> function0) {
        String cookie;
        MatchResult find$default;
        if (booleanRef.element || (cookie = cookieManager.getCookie("https://www.roblox.com")) == null || (find$default = Regex.find$default(new Regex("(?:^|;\\s*)\\.ROBLOSECURITY=([^;]+)"), cookie, 0, 2, null)) == null || Intrinsics.areEqual(find$default.getGroupValues().get(1), str)) {
            return;
        }
        booleanRef.element = true;
        RobloxApi.INSTANCE.setCookie(activity, find$default.getGroupValues().get(1));
        RobloxCloud.INSTANCE.resetSession();
        cookieManager.removeAllCookies(null);
        cookieManager.flush();
        dialog.dismiss();
        INSTANCE.background(activity, "Signing in…", new AccountUi$$ExternalSyntheticLambda56(activity), new AccountUi$$ExternalSyntheticLambda57(activity, function0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final RobloxCloud.User signIn$check$lambda$59(Activity activity) {
        return RobloxCloud.INSTANCE.currentUser(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit signIn$check$lambda$60(Activity activity, Function0 function0, RobloxCloud.User u) {
        Intrinsics.checkNotNullParameter(u, "u");
        INSTANCE.toast(activity, "Signed in as @" + u.getName());
        OutputLog.INSTANCE.info("Signed in to Roblox as @" + u.getName());
        Avatar.INSTANCE.refresh(activity);
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void signIn$default(AccountUi accountUi, Activity activity, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        accountUi.signIn(activity, function0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit signIn$lambda$57(Dialog dialog, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void signIn$lambda$61(Ref.BooleanRef booleanRef, WebView webView, DialogInterface dialogInterface) {
        booleanRef.element = true;
        webView.stopLoading();
        webView.destroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit signOut$lambda$65(Activity activity) {
        INSTANCE.background(activity, "Signing out…", new AccountUi$$ExternalSyntheticLambda72(activity), new AccountUi$$ExternalSyntheticLambda73(activity, RobloxApi.INSTANCE.userId(activity)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit signOut$lambda$65$lambda$63(Activity activity) {
        RobloxCloud.INSTANCE.logout(activity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit signOut$lambda$65$lambda$64(Activity activity, long j, Unit it) {
        String str;
        Intrinsics.checkNotNullParameter(it, "it");
        Accounts.INSTANCE.remove(activity, j);
        Accounts.Account account = (Accounts.Account) CollectionsKt.firstOrNull((List) Accounts.INSTANCE.list(activity));
        Accounts accounts = Accounts.INSTANCE;
        Activity activity2 = activity;
        if (account != null) {
            accounts.switchTo(activity2, account);
        } else {
            accounts.useGuest(activity2);
        }
        CookieManager.getInstance().removeAllCookies(null);
        Avatar.INSTANCE.refresh(activity);
        AccountUi accountUi = INSTANCE;
        if (account != null) {
            str = "Signed out. Now using @" + account.getName();
        } else {
            str = "Signed out";
        }
        accountUi.toast(activity, str);
        return Unit.INSTANCE;
    }

    private final void toast(Activity act, String s) {
        Toast.makeText(act, s, 0).show();
    }

    public static /* synthetic */ void upload$default(AccountUi accountUi, Activity activity, Studio studio, CloudPlace cloudPlace, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 16) != 0) {
            function0 = null;
        }
        accountUi.upload(activity, studio, cloudPlace, z, function0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit upload$lambda$176(Activity activity, boolean z, Studio studio, CloudPlace cloudPlace, Function0 function0) {
        INSTANCE.background(activity, z ? "Publishing to Roblox…" : "Saving to Roblox…", new AccountUi$$ExternalSyntheticLambda8(studio, activity, cloudPlace, z), new AccountUi$$ExternalSyntheticLambda9(studio, cloudPlace, z, activity, function0), new AccountUi$$ExternalSyntheticLambda10(activity, z, studio, cloudPlace, function0));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Pair upload$lambda$176$lambda$169(Studio studio, Activity activity, CloudPlace cloudPlace, boolean z) {
        byte[] serializePlace = studio.serializePlace();
        return TuplesKt.to(RobloxCloud.INSTANCE.publish(activity, cloudPlace.getUniverseId(), cloudPlace.getPlaceId(), serializePlace, z), Integer.valueOf(serializePlace.length));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit upload$lambda$176$lambda$170(Studio studio, CloudPlace cloudPlace, boolean z, Activity activity, Function0 function0, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        String str = (String) pair.component1();
        int intValue = ((Number) pair.component2()).intValue();
        studio.setCloud(cloudPlace);
        studio.markSavedToCloud();
        OutputLog.INSTANCE.info((z ? "Published" : "Saved") + " " + cloudPlace.getName() + " to Roblox (" + str + ", " + (intValue / 1024) + " KB)");
        INSTANCE.toast(activity, z ? "Published to Roblox" : "Saved to Roblox");
        Recents.INSTANCE.add(activity, new Recents.Entry(cloudPlace.getName(), cloudPlace.getPlaceId(), cloudPlace.getUniverseId(), null, 0L, RobloxApi.INSTANCE.userId(activity), 24, null));
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean upload$lambda$176$lambda$175(Activity activity, boolean z, Studio studio, CloudPlace cloudPlace, Function0 function0, Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (!(e instanceof PublishException) || !((PublishException) e).getNeedsApiKey()) {
            return false;
        }
        OutputLog.INSTANCE.warn("Roblox: " + e.getMessage());
        Dialogs.INSTANCE.themed(activity).setTitle(z ? "Publishing needs an API key" : "Saving to Roblox needs an API key").setMessage(e.getMessage()).setPositiveButton("Set up API key", new AccountUi$$ExternalSyntheticLambda21(activity, studio, cloudPlace, z, function0)).setNeutralButton("Save a copy to this device", new AccountUi$$ExternalSyntheticLambda22(activity, cloudPlace, studio)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void upload$lambda$176$lambda$175$lambda$172(Activity activity, Studio studio, CloudPlace cloudPlace, boolean z, Function0 function0, DialogInterface dialogInterface, int i) {
        INSTANCE.advanced(activity, new AccountUi$$ExternalSyntheticLambda54(activity, studio, cloudPlace, z, function0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit upload$lambda$176$lambda$175$lambda$172$lambda$171(Activity activity, Studio studio, CloudPlace cloudPlace, boolean z, Function0 function0) {
        INSTANCE.upload(activity, studio, cloudPlace, z, function0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void upload$lambda$176$lambda$175$lambda$174(Activity activity, CloudPlace cloudPlace, Studio studio, DialogInterface dialogInterface, int i) {
        MainActions mainActions = activity instanceof MainActions ? (MainActions) activity : null;
        if (mainActions != null) {
            mainActions.saveBytesAs(INSTANCE.safeFile(cloudPlace.getName()) + ".rbxl", new AccountUi$$ExternalSyntheticLambda43(studio));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final byte[] upload$lambda$176$lambda$175$lambda$174$lambda$173(Studio studio) {
        return studio.serializePlace();
    }

    private final void versionHistory(Activity act, Studio studio, MainActions actions, RobloxCloud.Game g, RobloxCloud.Place p) {
        background(act, "Loading version history…", new AccountUi$$ExternalSyntheticLambda49(act, p), new AccountUi$$ExternalSyntheticLambda50(act, p, actions, g));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List versionHistory$lambda$118(Activity activity, RobloxCloud.Place place) {
        return RobloxCloud.INSTANCE.versions(activity, place.getId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit versionHistory$lambda$128(Activity activity, RobloxCloud.Place place, MainActions mainActions, RobloxCloud.Game game, List versions) {
        Intrinsics.checkNotNullParameter(versions, "versions");
        List<RobloxCloud.Version> list = versions;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (RobloxCloud.Version version : list) {
            arrayList.add(new Row("Version " + version.getNumber() + (version.getPublished() ? "  (published)" : ""), INSTANCE.prettyDate(version.getCreated()), null, Icons.general$default(Icons.INSTANCE, activity, "History", null, 4, null), new AccountUi$$ExternalSyntheticLambda29(activity, place, version, mainActions, game)));
        }
        INSTANCE.listDialog(activity, place.getName() + " — versions", arrayList, "No versions found (you may not have edit access to this place).", new AccountUi$$ExternalSyntheticLambda30(activity, mainActions, place));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit versionHistory$lambda$128$lambda$124$lambda$123(Activity activity, RobloxCloud.Place place, RobloxCloud.Version version, MainActions mainActions, RobloxCloud.Game game) {
        List listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("Open this version", new AccountUi$$ExternalSyntheticLambda26(activity, mainActions, game, place, version)), TuplesKt.to("Download this version (.rbxl)…", new AccountUi$$ExternalSyntheticLambda27(activity, mainActions, place, version))});
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(activity).setTitle(place.getName() + " — version " + version.getNumber());
        List list = listOf;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Pair) it.next()).getFirst());
        }
        title.setItems((CharSequence[]) arrayList.toArray(new String[0]), new AccountUi$$ExternalSyntheticLambda28(listOf)).setNegativeButton("Close", (DialogInterface.OnClickListener) null).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit versionHistory$lambda$128$lambda$124$lambda$123$lambda$119(Activity activity, MainActions mainActions, RobloxCloud.Game game, RobloxCloud.Place place, RobloxCloud.Version version) {
        INSTANCE.openPlace(activity, mainActions, game, place, Integer.valueOf(version.getNumber()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit versionHistory$lambda$128$lambda$124$lambda$123$lambda$120(Activity activity, MainActions mainActions, RobloxCloud.Place place, RobloxCloud.Version version) {
        INSTANCE.downloadPlace(activity, mainActions, place, Integer.valueOf(version.getNumber()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void versionHistory$lambda$128$lambda$124$lambda$123$lambda$122(List list, DialogInterface dialogInterface, int i) {
        ((Function0) ((Pair) list.get(i)).getSecond()).invoke();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit versionHistory$lambda$128$lambda$127(Activity activity, MainActions mainActions, RobloxCloud.Place place, AlertDialog.Builder b) {
        Intrinsics.checkNotNullParameter(b, "b");
        b.setNeutralButton("Version number…", new AccountUi$$ExternalSyntheticLambda75(activity, mainActions, place));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void versionHistory$lambda$128$lambda$127$lambda$126(Activity activity, MainActions mainActions, RobloxCloud.Place place, DialogInterface dialogInterface, int i) {
        Dialogs.INSTANCE.prompt(activity, "Download which version number?", "", new AccountUi$$ExternalSyntheticLambda94(activity, mainActions, place));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit versionHistory$lambda$128$lambda$127$lambda$126$lambda$125(Activity activity, MainActions mainActions, RobloxCloud.Place place, String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        Integer intOrNull = StringsKt.toIntOrNull(StringsKt.trim((CharSequence) s).toString());
        if (intOrNull == null) {
            return Unit.INSTANCE;
        }
        INSTANCE.downloadPlace(activity, mainActions, place, Integer.valueOf(intOrNull.intValue()));
        return Unit.INSTANCE;
    }

    public final void advanced(Activity act, Function0<Unit> then) {
        Intrinsics.checkNotNullParameter(act, "act");
        LinearLayout linearLayout = new LinearLayout(act);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(Ui.INSTANCE.dp(act, 18.0f), Ui.INSTANCE.dp(act, 8.0f), Ui.INSTANCE.dp(act, 18.0f), 0);
        TextView text$default = Ui.text$default(Ui.INSTANCE, act, "Roblox now only accepts place uploads (Publish / Save to Roblox) through Open Cloud. Create a key once:\n\n1. Open create.roblox.com → Open Cloud → API Keys → Create API Key.\n2. Under Access Permissions add \"universe-places\" (Write) and pick your experiences (or allow all). Add \"legacy-asset\" read access too if you want key-based downloads.\n3. Add IP address 0.0.0.0/0 (or leave restrictions off), save, and copy the key here.", 12.0f, 0, false, 24, null);
        text$default.setSingleLine(false);
        linearLayout.addView(text$default);
        TextView button$default = Ui.button$default(Ui.INSTANCE, act, "Open the API Keys page", 0, new AccountUi$$ExternalSyntheticLambda2(act), 4, null);
        LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
        lp$default.topMargin = Ui.INSTANCE.dp(act, 8.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(button$default, lp$default);
        EditText input$default = Ui.input$default(Ui.INSTANCE, act, RobloxApi.INSTANCE.apiKey(act), "Open Cloud API key", false, false, 24, null);
        input$default.setInputType(129);
        LinearLayout.LayoutParams lp$default2 = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
        lp$default2.topMargin = Ui.INSTANCE.dp(act, 8.0f);
        Unit unit2 = Unit.INSTANCE;
        linearLayout.addView(input$default, lp$default2);
        TextView text$default2 = Ui.text$default(Ui.INSTANCE, act, "Or paste a .ROBLOSECURITY cookie instead of signing in. Anyone with it can use your account, so only do this on your own device.", 12.0f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default2.setSingleLine(false);
        text$default2.setPadding(0, Ui.INSTANCE.dp(act, 12.0f), 0, 0);
        linearLayout.addView(text$default2);
        EditText input$default2 = Ui.input$default(Ui.INSTANCE, act, "", signedIn(act) ? "(signed in — leave empty to keep)" : ".ROBLOSECURITY cookie", false, false, 24, null);
        input$default2.setInputType(129);
        LinearLayout.LayoutParams lp$default3 = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
        lp$default3.topMargin = Ui.INSTANCE.dp(act, 8.0f);
        Unit unit3 = Unit.INSTANCE;
        linearLayout.addView(input$default2, lp$default3);
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(act).setTitle("Open Cloud API key");
        ScrollView scrollView = new ScrollView(act);
        scrollView.addView(linearLayout);
        title.setView(scrollView).setPositiveButton("Save", new AccountUi$$ExternalSyntheticLambda3(act, input$default, input$default2, then)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    public final void avatarDialog(Activity act, Studio studio) {
        Intrinsics.checkNotNullParameter(act, "act");
        AvatarUi.INSTANCE.playtestAvatar(act, studio);
    }

    public final <T> void background(Activity act, String message, Function0<? extends T> work, Function1<? super T, Unit> done) {
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(work, "work");
        Intrinsics.checkNotNullParameter(done, "done");
        background(act, message, work, done, null);
    }

    public final <T> void background(Activity act, String message, Function0<? extends T> work, Function1<? super T, Unit> done, Function1<? super Throwable, Boolean> failed) {
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(work, "work");
        Intrinsics.checkNotNullParameter(done, "done");
        LinearLayout linearLayout = new LinearLayout(act);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(Ui.INSTANCE.dp(act, 20.0f), Ui.INSTANCE.dp(act, 18.0f), Ui.INSTANCE.dp(act, 20.0f), Ui.INSTANCE.dp(act, 18.0f));
        ProgressBar progressBar = new ProgressBar(act);
        progressBar.setIndeterminate(true);
        linearLayout.addView(progressBar, Ui.lp$default(Ui.INSTANCE, Ui.INSTANCE.dp(act, 32.0f), Ui.INSTANCE.dp(act, 32.0f), 0.0f, 4, null));
        TextView text$default = Ui.text$default(Ui.INSTANCE, act, message, 14.0f, 0, false, 24, null);
        text$default.setSingleLine(false);
        text$default.setPadding(Ui.INSTANCE.dp(act, 14.0f), 0, 0, 0);
        linearLayout.addView(text$default);
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        AlertDialog create = Dialogs.INSTANCE.themed(act).setView(linearLayout).setNegativeButton("Cancel", new AccountUi$$ExternalSyntheticLambda84(booleanRef)).create();
        create.setOnCancelListener(new AccountUi$$ExternalSyntheticLambda85(booleanRef));
        create.show();
        net.execute(new AccountUi$$ExternalSyntheticLambda86(work, act, create, booleanRef, done, failed));
    }

    public final void createNewGame(Activity act, Studio studio, MainActions actions) {
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(studio, "studio");
        Intrinsics.checkNotNullParameter(actions, "actions");
        requireSignIn(act, new AccountUi$$ExternalSyntheticLambda51(act, studio));
    }

    public final void currentPlaceHistory(Activity act, Studio studio, MainActions actions) {
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(studio, "studio");
        Intrinsics.checkNotNullParameter(actions, "actions");
        CloudPlace cloud = studio.getCloud();
        if (cloud == null) {
            myGames$default(this, act, studio, actions, null, 8, null);
        } else {
            requireSignIn(act, new AccountUi$$ExternalSyntheticLambda52(cloud, act, actions, studio));
        }
    }

    public final void customAvatar(Activity act) {
        Activity act2 = act;
        Intrinsics.checkNotNullParameter(act2, "act");
        JSONObject custom = Avatar.INSTANCE.custom(act2);
        JSONObject optJSONObject = custom.optJSONObject("colors");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        JSONObject jSONObject = optJSONObject;
        LinearLayout linearLayout = new LinearLayout(act2);
        linearLayout.setOrientation(1);
        int i = 0;
        linearLayout.setPadding(Ui.INSTANCE.dp(act2, 16.0f), Ui.INSTANCE.dp(act2, 6.0f), Ui.INSTANCE.dp(act2, 16.0f), 0);
        linearLayout.addView(Ui.INSTANCE.text(act2, "Body colors", 13.0f, Ui.INSTANCE.getTEXT(), true));
        List<Pair> listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("head", "Head"), TuplesKt.to("torso", "Torso"), TuplesKt.to("leftArm", "Left Arm"), TuplesKt.to("rightArm", "Right Arm"), TuplesKt.to("leftLeg", "Left Leg"), TuplesKt.to("rightLeg", "Right Leg")});
        HashMap hashMap = new HashMap();
        for (Pair pair : listOf) {
            String str = (String) pair.component1();
            String str2 = (String) pair.component2();
            Color3.Companion companion = Color3.INSTANCE;
            String optString = jSONObject.optString(str);
            Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
            Color3 fromHex = companion.fromHex(optString);
            if (fromHex == null) {
                Color3 color3 = Avatar.INSTANCE.getCLASSIC_COLORS().get(str2);
                Intrinsics.checkNotNull(color3);
                fromHex = color3;
            }
            hashMap.put(str, fromHex);
            LinearLayout linearLayout2 = new LinearLayout(act2);
            linearLayout2.setOrientation(i);
            linearLayout2.setGravity(16);
            linearLayout2.setPadding(0, Ui.INSTANCE.dp(act2, 3.0f), 0, Ui.INSTANCE.dp(act2, 3.0f));
            linearLayout2.addView(Ui.text$default(Ui.INSTANCE, act2, str2, 13.0f, 0, false, 24, null), Ui.INSTANCE.lp(0, -2, 1.0f));
            View view = new View(act2);
            customAvatar$paint(view, hashMap, str, act2);
            view.setOnClickListener(new AccountUi$$ExternalSyntheticLambda69(act2, str2, hashMap, str, view));
            linearLayout2.addView(view, Ui.lp$default(Ui.INSTANCE, Ui.INSTANCE.dp(act, 44.0f), Ui.INSTANCE.dp(act, 26.0f), 0.0f, 4, null));
            linearLayout.addView(linearLayout2);
            act2 = act;
            i = 0;
        }
        EditText customAvatar$field = customAvatar$field(linearLayout, act, custom, "Shirt", "shirt", "Shirt ID or catalog link");
        EditText customAvatar$field2 = customAvatar$field(linearLayout, act, custom, "Pants", "pants", "Pants ID or catalog link");
        EditText customAvatar$field3 = customAvatar$field(linearLayout, act, custom, "T-Shirt", "tshirt", "T-Shirt ID or link");
        EditText customAvatar$field4 = customAvatar$field(linearLayout, act, custom, "Face", "face", "Face ID or link");
        EditText customAvatar$field5 = customAvatar$field(linearLayout, act, custom, "Accessories (hats, hair…)", "accessories", "IDs or links, separated by commas");
        TextView text$default = Ui.text$default(Ui.INSTANCE, act, "Clothing and accessories are downloaded from Roblox, so they need a signed-in account.", 11.0f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default.setSingleLine(false);
        text$default.setPadding(0, Ui.INSTANCE.dp(act, 8.0f), 0, 0);
        linearLayout.addView(text$default);
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(act).setTitle("Create an avatar");
        ScrollView scrollView = new ScrollView(act);
        scrollView.addView(linearLayout);
        title.setView(scrollView).setPositiveButton("Wear it", new AccountUi$$ExternalSyntheticLambda70(hashMap, customAvatar$field, customAvatar$field2, customAvatar$field3, customAvatar$field4, customAvatar$field5, act)).setNeutralButton("Start from a user…", new AccountUi$$ExternalSyntheticLambda71(act, listOf)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    public final void installPluginFromRoblox(Activity act, Studio studio, MainActions actions, String initial) {
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(studio, "studio");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(initial, "initial");
        Dialogs.INSTANCE.prompt(act, "Plugin asset ID or link", initial, new AccountUi$$ExternalSyntheticLambda23(act, studio, actions));
    }

    public final void installPluginId(Activity act, Studio studio, MainActions actions, long id, String name) {
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(studio, "studio");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(name, "name");
        background(act, "Downloading plugin…", new AccountUi$$ExternalSyntheticLambda0(act, id, studio, name), new AccountUi$$ExternalSyntheticLambda1(studio, actions, act));
    }

    public final void loadHeadshot(ImageView img, long userId) {
        Intrinsics.checkNotNullParameter(img, "img");
        Icons icons = Icons.INSTANCE;
        Context context = img.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        img.setImageDrawable(Icons.general$default(icons, context, "Account", null, 4, null));
        if (userId == 0) {
            return;
        }
        net.execute(new AccountUi$$ExternalSyntheticLambda55(userId, img));
    }

    public final void myGames(Activity act, Studio studio, MainActions actions, Function2<? super RobloxCloud.Game, ? super RobloxCloud.Place, Unit> pick) {
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(studio, "studio");
        Intrinsics.checkNotNullParameter(actions, "actions");
        requireSignIn(act, new AccountUi$$ExternalSyntheticLambda40(act, pick, studio, actions));
    }

    public final void openById(Activity act, Studio studio, MainActions actions) {
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(studio, "studio");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Dialogs.INSTANCE.prompt(act, "Place ID or link", "", new AccountUi$$ExternalSyntheticLambda31(act, actions));
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0037, code lost:
    
        if (r1 != null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void openPlace(android.app.Activity r9, com.exampletest.mobilestudiotest.ui.MainActions r10, com.exampletest.mobilestudiotest.net.RobloxCloud.Game r11, com.exampletest.mobilestudiotest.net.RobloxCloud.Place r12, java.lang.Integer r13) {
        /*
            r8 = this;
            java.lang.String r0 = "act"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "actions"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "p"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = r12.getName()
            if (r13 == 0) goto L3a
            r1 = r13
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = " (version "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r1)
            java.lang.String r4 = ")"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r1 = r3.toString()
            if (r1 == 0) goto L3a
            goto L3c
        L3a:
            java.lang.String r1 = ""
        L3c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Downloading "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = "…"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.exampletest.mobilestudiotest.ui.AccountUi$$ExternalSyntheticLambda87 r1 = new com.exampletest.mobilestudiotest.ui.AccountUi$$ExternalSyntheticLambda87
            r1.<init>(r9, r12, r13, r11)
            com.exampletest.mobilestudiotest.ui.AccountUi$$ExternalSyntheticLambda88 r2 = new com.exampletest.mobilestudiotest.ui.AccountUi$$ExternalSyntheticLambda88
            r7 = r9
            r6 = r10
            r5 = r11
            r3 = r12
            r4 = r13
            r2.<init>(r3, r4, r5, r6, r7)
            r8.background(r7, r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.AccountUi.openPlace(android.app.Activity, com.exampletest.mobilestudiotest.ui.MainActions, com.exampletest.mobilestudiotest.net.RobloxCloud$Game, com.exampletest.mobilestudiotest.net.RobloxCloud$Place, java.lang.Integer):void");
    }

    public final void placeActions(Activity act, Studio studio, MainActions actions, RobloxCloud.Game g, RobloxCloud.Place p) {
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(studio, "studio");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(g, "g");
        Intrinsics.checkNotNullParameter(p, "p");
        List listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("Open (edit this place)", new AccountUi$$ExternalSyntheticLambda96(act, actions, g, p)), TuplesKt.to("Download as .rbxl…", new AccountUi$$ExternalSyntheticLambda97(act, actions, p)), TuplesKt.to("Version history…", new AccountUi$$ExternalSyntheticLambda98(act, studio, actions, g, p)), TuplesKt.to("Copy place ID", new AccountUi$$ExternalSyntheticLambda99(act, p))});
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(act).setTitle(p.getName());
        List list = listOf;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Pair) it.next()).getFirst());
        }
        title.setItems((CharSequence[]) arrayList.toArray(new String[0]), new AccountUi$$ExternalSyntheticLambda100(listOf)).setNegativeButton("Close", (DialogInterface.OnClickListener) null).show();
    }

    public final void places(Activity act, Studio studio, MainActions actions, RobloxCloud.Game g, Function2<? super RobloxCloud.Game, ? super RobloxCloud.Place, Unit> pick) {
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(studio, "studio");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(g, "g");
        background(act, "Loading places…", new AccountUi$$ExternalSyntheticLambda24(act, g), new AccountUi$$ExternalSyntheticLambda25(pick, g, act, studio, actions));
    }

    public final String prettyDate(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        try {
            SimpleDateFormat simpleDateFormat = dateOut;
            Date parse = dateIn.parse(StringsKt.take(s, 19));
            Intrinsics.checkNotNull(parse);
            String format = simpleDateFormat.format(parse);
            Intrinsics.checkNotNull(format);
            return format;
        } catch (Exception e) {
            return s;
        }
    }

    public final void publish(Activity act, Studio studio, MainActions actions) {
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(studio, "studio");
        Intrinsics.checkNotNullParameter(actions, "actions");
        CloudPlace cloud = studio.getCloud();
        if (cloud == null) {
            publishAs(act, studio, actions);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(TuplesKt.to("Publish (players get this version)", new AccountUi$$ExternalSyntheticLambda76(act, studio, cloud)));
        arrayList.add(TuplesKt.to("Save to Roblox (new version, not published)", new AccountUi$$ExternalSyntheticLambda77(act, studio, cloud)));
        arrayList.add(TuplesKt.to("Publish to a different place…", new AccountUi$$ExternalSyntheticLambda78(act, studio, actions)));
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(act).setTitle("“" + cloud.getName() + "” (place " + cloud.getPlaceId() + ")");
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add((String) ((Pair) it.next()).getFirst());
        }
        title.setItems((CharSequence[]) arrayList3.toArray(new String[0]), new AccountUi$$ExternalSyntheticLambda79(arrayList)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    public final void publishAs(Activity act, Studio studio, MainActions actions) {
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(studio, "studio");
        Intrinsics.checkNotNullParameter(actions, "actions");
        requireSignIn(act, new AccountUi$$ExternalSyntheticLambda95(act, studio, actions));
    }

    public final void saveToRoblox(Activity act, Studio studio, Function0<Unit> onSaved) {
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(studio, "studio");
        CloudPlace cloud = studio.getCloud();
        if (cloud == null) {
            return;
        }
        upload(act, studio, cloud, false, onSaved);
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [android.app.AlertDialog, T] */
    public final void show(Activity act, Studio studio, MainActions actions) {
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(studio, "studio");
        Intrinsics.checkNotNullParameter(actions, "actions");
        LinearLayout linearLayout = new LinearLayout(act);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(Ui.INSTANCE.dp(act, 16.0f), Ui.INSTANCE.dp(act, 8.0f), Ui.INSTANCE.dp(act, 16.0f), Ui.INSTANCE.dp(act, 4.0f));
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Accounts.Account active = Accounts.INSTANCE.active(act);
        linearLayout.addView(show$accountRow(act, active, true, new AccountUi$$ExternalSyntheticLambda58()));
        List<Accounts.Account> list = Accounts.INSTANCE.list(act);
        ArrayList<Accounts.Account> arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Accounts.Account account = (Accounts.Account) next;
            if (active != null && account.getUserId() == active.getUserId()) {
                z = true;
            }
            if (!z) {
                arrayList.add(next);
            }
        }
        for (Accounts.Account account2 : arrayList) {
            View show$accountRow = show$accountRow(act, account2, false, new AccountUi$$ExternalSyntheticLambda59(objectRef, act, account2));
            LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
            lp$default.topMargin = Ui.INSTANCE.dp(act, 4.0f);
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(show$accountRow, lp$default);
        }
        if (active != null) {
            View show$accountRow2 = show$accountRow(act, null, false, new AccountUi$$ExternalSyntheticLambda60(objectRef, act));
            LinearLayout.LayoutParams lp$default2 = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
            lp$default2.topMargin = Ui.INSTANCE.dp(act, 4.0f);
            Unit unit2 = Unit.INSTANCE;
            linearLayout.addView(show$accountRow2, lp$default2);
        }
        View divider$default = Ui.divider$default(Ui.INSTANCE, act, false, 2, null);
        LinearLayout.LayoutParams lp$default3 = Ui.lp$default(Ui.INSTANCE, -1, Ui.INSTANCE.dp(act, 1.0f), 0.0f, 4, null);
        lp$default3.topMargin = Ui.INSTANCE.dp(act, 10.0f);
        lp$default3.bottomMargin = Ui.INSTANCE.dp(act, 4.0f);
        Unit unit3 = Unit.INSTANCE;
        linearLayout.addView(divider$default, lp$default3);
        show$action(linearLayout, act, objectRef, active == null ? "Sign in with Roblox…" : "Add another account…", new AccountUi$$ExternalSyntheticLambda61(act));
        show$action(linearLayout, act, objectRef, "Playtest avatar: " + Avatar.INSTANCE.describe(act) + "…", new AccountUi$$ExternalSyntheticLambda62(act, studio));
        if (active != null) {
            show$action(linearLayout, act, objectRef, "My Games…", new AccountUi$$ExternalSyntheticLambda63(act, studio, actions));
            show$action(linearLayout, act, objectRef, "Sign out of @" + active.getName(), new AccountUi$$ExternalSyntheticLambda64(act));
        }
        show$action(linearLayout, act, objectRef, "Open Cloud API key (for publishing)…", new AccountUi$$ExternalSyntheticLambda65(act));
        TextView text$default = Ui.text$default(Ui.INSTANCE, act, "Sign-ins are stored only in this app's private storage on this device.", 11.0f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default.setSingleLine(false);
        text$default.setPadding(0, Ui.INSTANCE.dp(act, 10.0f), 0, 0);
        linearLayout.addView(text$default);
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(act).setTitle("Roblox Account");
        ScrollView scrollView = new ScrollView(act);
        scrollView.addView(linearLayout);
        Unit unit4 = Unit.INSTANCE;
        objectRef.element = title.setView(scrollView).setPositiveButton("Close", (DialogInterface.OnClickListener) null).show();
        if (active != null) {
            if (active.getName().length() == 0) {
                net.execute(new AccountUi$$ExternalSyntheticLambda66(act));
            }
        }
    }

    public final void signIn(Activity act, Function0<Unit> then) {
        Intrinsics.checkNotNullParameter(act, "act");
        Dialog dialog = new Dialog(act, Ui.INSTANCE.getLIGHT() ? R.style.Theme.Material.Light.NoActionBar.Fullscreen : R.style.Theme.Material.NoActionBar.Fullscreen);
        LinearLayout linearLayout = new LinearLayout(act);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(Ui.INSTANCE.getPANEL());
        LinearLayout linearLayout2 = new LinearLayout(act);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setBackgroundColor(Ui.INSTANCE.getTOPBAR());
        linearLayout2.setPadding(Ui.INSTANCE.dp(act, 12.0f), Ui.INSTANCE.dp(act, 6.0f), Ui.INSTANCE.dp(act, 6.0f), Ui.INSTANCE.dp(act, 6.0f));
        linearLayout2.addView(Ui.INSTANCE.text(act, "Sign in to Roblox", 15.0f, Ui.INSTANCE.getTEXT(), true), Ui.INSTANCE.lp(0, -2, 1.0f));
        linearLayout2.addView(Ui.button$default(Ui.INSTANCE, act, "Cancel", 0, new AccountUi$$ExternalSyntheticLambda47(dialog), 4, null));
        linearLayout.addView(linearLayout2, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        ProgressBar progressBar = new ProgressBar(act, null, R.attr.progressBarStyleHorizontal);
        progressBar.setIndeterminate(true);
        linearLayout.addView(progressBar, Ui.lp$default(Ui.INSTANCE, -1, Ui.INSTANCE.dp(act, 4.0f), 0.0f, 4, null));
        WebView webView = new WebView(act);
        linearLayout.addView(webView, Ui.INSTANCE.lp(-1, 0, 1.0f));
        dialog.setContentView(linearLayout);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setAcceptThirdPartyCookies(webView, true);
        cookieManager.removeAllCookies(null);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        String cookie = RobloxApi.INSTANCE.cookie(act);
        AccountUi$signIn$poll$1 accountUi$signIn$poll$1 = new AccountUi$signIn$poll$1(booleanRef, dialog, cookieManager, cookie, act, then);
        webView.setWebViewClient(new AccountUi$signIn$2(progressBar, booleanRef, cookieManager, cookie, act, dialog, then));
        dialog.setOnDismissListener(new AccountUi$$ExternalSyntheticLambda48(booleanRef, webView));
        dialog.show();
        webView.loadUrl("https://www.roblox.com/login");
        main.postDelayed(accountUi$signIn$poll$1, 800L);
    }

    public final void signOut(Activity act) {
        Intrinsics.checkNotNullParameter(act, "act");
        String userName = RobloxApi.INSTANCE.userName(act);
        if (userName.length() == 0) {
            userName = "your account";
        }
        Dialogs.INSTANCE.confirm(act, "Sign out", "Sign out of @" + userName + "? This also ends that session on Roblox.", "Sign out", new AccountUi$$ExternalSyntheticLambda101(act));
    }

    public final boolean signedIn(Activity act) {
        Intrinsics.checkNotNullParameter(act, "act");
        return RobloxApi.INSTANCE.cookie(act).length() > 0;
    }

    public final void upload(Activity act, Studio studio, CloudPlace c, boolean publish, Function0<Unit> onDone) {
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(studio, "studio");
        Intrinsics.checkNotNullParameter(c, "c");
        requireSignInOrKey(act, new AccountUi$$ExternalSyntheticLambda83(act, publish, studio, c, onDone));
    }
}
