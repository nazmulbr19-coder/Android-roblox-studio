package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import com.exampletest.mobilestudiotest.core.PlaceFactory;
import com.exampletest.mobilestudiotest.core.Recents;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.net.Accounts;
import com.exampletest.mobilestudiotest.net.AuthRequiredException;
import com.exampletest.mobilestudiotest.net.ImageLoader;
import com.exampletest.mobilestudiotest.net.RobloxApi;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: StartScreen.kt */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\b\b\u0007\u0018\u0000 x2\u00020\u0001:\u0004uvwxB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u00101\u001a\u00020$H\u0014J\b\u00102\u001a\u00020$H\u0014J\u0010\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020$H\u0002J\b\u00107\u001a\u00020$H\u0002J\u0010\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020\u0015H\u0002J\b\u0010:\u001a\u00020\u0001H\u0002J$\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u00152\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0015H\u0002J8\u0010?\u001a\u00020$2\u0006\u0010<\u001a\u00020\u00012\u0006\u0010@\u001a\u00020\u00152\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u00182\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010&H\u0002J\b\u0010D\u001a\u00020$H\u0002J@\u0010E\u001a\u00020$2\u0006\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u00152\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010G\u001a\u00020\u00152\u0010\b\u0002\u0010H\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010&H\u0002J\u0018\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020 2\u0006\u0010K\u001a\u00020LH\u0002J\"\u0010M\u001a\u00020$2\u0006\u0010J\u001a\u00020 2\b\u0010N\u001a\u0004\u0018\u00010\u00152\u0006\u0010O\u001a\u00020\u0015H\u0002J[\u0010P\u001a\u00020\u00012\u0006\u0010@\u001a\u00020\u00152\u0006\u0010A\u001a\u00020\u00152\b\u0010Q\u001a\u0004\u0018\u00010\u00152\u0006\u0010O\u001a\u00020\u00152\f\u0010H\u001a\b\u0012\u0004\u0012\u00020$0&2\u0010\b\u0002\u0010R\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010&2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010TJ\u0010\u0010U\u001a\u00020)2\u0006\u0010<\u001a\u00020\u0001H\u0002J\u0010\u0010V\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u0001H\u0002J\u0018\u0010W\u001a\u00020$2\u0006\u0010X\u001a\u00020\u00012\u0006\u00104\u001a\u00020YH\u0002J\u0010\u0010Z\u001a\u00020Y2\u0006\u0010<\u001a\u00020\u0001H\u0002J\b\u0010[\u001a\u00020$H\u0002J\u0010\u0010\\\u001a\u00020$2\u0006\u0010<\u001a\u00020\u0001H\u0002J\u0010\u0010]\u001a\u00020$2\u0006\u0010<\u001a\u00020\u0001H\u0002J\u0016\u0010^\u001a\b\u0012\u0004\u0012\u00020`0_2\u0006\u0010a\u001a\u00020\u001aH\u0002J\b\u0010b\u001a\u00020$H\u0002J(\u0010c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\u00010d0_2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020`0_H\u0002J\u0010\u0010f\u001a\u00020$2\u0006\u0010g\u001a\u00020`H\u0002J\u0016\u0010h\u001a\b\u0012\u0004\u0012\u00020i0_2\u0006\u0010j\u001a\u00020kH\u0002J\u001a\u0010l\u001a\u00020\u00012\u0006\u0010m\u001a\u00020i2\b\b\u0002\u0010n\u001a\u00020\u0018H\u0002J\u0010\u0010o\u001a\u00020$2\u0006\u0010j\u001a\u00020kH\u0002J\u0018\u0010p\u001a\u00020$2\u0006\u0010<\u001a\u00020\u00012\u0006\u0010g\u001a\u00020qH\u0002J0\u0010r\u001a\u00020$2\u0006\u0010<\u001a\u00020\u00012\f\u0010e\u001a\b\u0012\u0004\u0012\u00020i0_2\u0006\u0010s\u001a\u00020\u00152\b\b\u0002\u0010n\u001a\u00020\u0018H\u0002J\b\u0010t\u001a\u00020$H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010\u001d\u001a*\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001ej\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f`!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020$0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010'\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u0010.¨\u0006y"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/StartScreen;", "Landroid/widget/LinearLayout;", "act", "Landroid/app/Activity;", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "actions", "Lcom/exampletest/mobilestudiotest/ui/MainActions;", "host", "Lcom/exampletest/mobilestudiotest/ui/StartScreen$Host;", "<init>", "(Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/core/Studio;Lcom/exampletest/mobilestudiotest/ui/MainActions;Lcom/exampletest/mobilestudiotest/ui/StartScreen$Host;)V", "net", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "main", "Landroid/os/Handler;", "content", "Landroid/widget/FrameLayout;", "nav", "page", "", "accountChip", "phone", "", "gen", "", "selectedGroup", "", "iconViews", "Ljava/util/HashMap;", "", "Landroid/widget/ImageView;", "Lkotlin/collections/HashMap;", "imgListener", "Lkotlin/Function1;", "", "accountListener", "Lkotlin/Function0;", "grids", "Ljava/util/ArrayList;", "Lcom/exampletest/mobilestudiotest/ui/FlowLayout;", "Lkotlin/collections/ArrayList;", "query", "linkColor", "getLinkColor", "()I", "sideColor", "getSideColor", "onAttachedToWindow", "onDetachedFromWindow", "dp", "v", "", "buildNav", "refreshAccount", "show", "p", "scrollColumn", "heading", "col", "text", "seeAll", "pageHeader", "title", "sub", "search", "onRefresh", "applyFilter", "message", "button", "icon", "onClick", "showBitmap", "img", "b", "Landroid/graphics/Bitmap;", "bindIcon", "url", "fallback", "card", "iconUrl", "onLong", "tint", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/Integer;)Landroid/widget/LinearLayout;", "grid", "row", "addToRow", "r", "Landroid/view/View;", "loading", "home", "greeting", "tip", "recentEntries", "", "Lcom/exampletest/mobilestudiotest/core/Recents$Entry;", "limit", "recent", "recentCards", "Lkotlin/Pair;", "list", "openRecent", "e", "loadGames", "Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Game;", "kind", "Lcom/exampletest/mobilestudiotest/ui/StartScreen$Kind;", "gameCard", "game", "showOwner", "games", "error", "", "showGames", "empty", "groupGames", "Host", "Kind", "GroupsView", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StartScreen extends LinearLayout {
    public static final String GROUPS = "Group Games";
    public static final String HOME = "Home";
    public static final String MY_GAMES = "My Games";
    public static final String RECENT = "Recent";
    public static final String SHARED = "Shared With Me";
    private final LinearLayout accountChip;
    private final Function0<Unit> accountListener;
    private final Activity act;
    private final MainActions actions;
    private final FrameLayout content;
    private int gen;
    private final ArrayList<FlowLayout> grids;
    private final Host host;
    private final HashMap<String, List<ImageView>> iconViews;
    private final Function1<String, Unit> imgListener;
    private final Handler main;
    private final LinearLayout nav;
    private final ExecutorService net;
    private String page;
    private final boolean phone;
    private String query;
    private long selectedGroup;
    private final Studio studio;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StartScreen.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001dJ6\u0010\u001e\u001a\u00020\u00172\u001e\u0010\u001f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000e0 0\u000e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001bJ\u0006\u0010$\u001a\u00020\u0017J\b\u0010%\u001a\u00020\u0017H\u0002J\u000e\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000e0\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/StartScreen$GroupsView;", "", "col", "Landroid/widget/LinearLayout;", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/StartScreen;Landroid/widget/LinearLayout;)V", "statusRow", "statusText", "Landroid/widget/TextView;", "statusSpin", "Landroid/widget/ProgressBar;", "chips", "area", "groups", "", "Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Group;", "gamesOf", "", "", "Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Game;", "shownGroup", "shownGames", NotificationCompat.CATEGORY_STATUS, "", "text", "", "spin", "", "onTap", "Lkotlin/Function0;", "set", "editable", "Lkotlin/Pair;", "inGroups", "", "done", "redrawChips", "drawChips", "select", "gp", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class GroupsView {
        private final LinearLayout area;
        private final LinearLayout chips;
        private Map<Long, ? extends List<RobloxCloud.Game>> gamesOf;
        private List<RobloxCloud.Group> groups;
        private List<Long> shownGames;
        private long shownGroup;
        private final LinearLayout statusRow;
        private final ProgressBar statusSpin;
        private final TextView statusText;
        final /* synthetic */ StartScreen this$0;

        public GroupsView(StartScreen startScreen, LinearLayout col) {
            Intrinsics.checkNotNullParameter(col, "col");
            this.this$0 = startScreen;
            LinearLayout linearLayout = new LinearLayout(StartScreen.access$getAct$p(this.this$0));
            StartScreen startScreen2 = this.this$0;
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            linearLayout.setPadding(0, StartScreen.access$dp(startScreen2, 6.0f), 0, StartScreen.access$dp(startScreen2, 6.0f));
            this.statusRow = linearLayout;
            TextView text$default = Ui.text$default(Ui.INSTANCE, StartScreen.access$getAct$p(this.this$0), "", 12.0f, Ui.INSTANCE.getDIM(), false, 16, null);
            text$default.setSingleLine(false);
            this.statusText = text$default;
            ProgressBar progressBar = new ProgressBar(StartScreen.access$getAct$p(this.this$0));
            progressBar.setIndeterminate(true);
            this.statusSpin = progressBar;
            LinearLayout linearLayout2 = new LinearLayout(StartScreen.access$getAct$p(this.this$0));
            linearLayout2.setOrientation(0);
            this.chips = linearLayout2;
            LinearLayout linearLayout3 = new LinearLayout(StartScreen.access$getAct$p(this.this$0));
            linearLayout3.setOrientation(1);
            this.area = linearLayout3;
            this.groups = CollectionsKt.emptyList();
            this.gamesOf = MapsKt.emptyMap();
            this.shownGames = CollectionsKt.emptyList();
            LinearLayout linearLayout4 = this.statusRow;
            ProgressBar progressBar2 = this.statusSpin;
            LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, StartScreen.access$dp(this.this$0, 16.0f), StartScreen.access$dp(this.this$0, 16.0f), 0.0f, 4, null);
            lp$default.rightMargin = StartScreen.access$dp(this.this$0, 8.0f);
            Unit unit = Unit.INSTANCE;
            linearLayout4.addView(progressBar2, lp$default);
            this.statusRow.addView(this.statusText, Ui.INSTANCE.lp(0, -2, 1.0f));
            col.addView(this.statusRow, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
            HorizontalScrollView horizontalScrollView = new HorizontalScrollView(StartScreen.access$getAct$p(this.this$0));
            horizontalScrollView.setHorizontalScrollBarEnabled(false);
            horizontalScrollView.addView(this.chips);
            LinearLayout.LayoutParams lp$default2 = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
            lp$default2.topMargin = StartScreen.access$dp(this.this$0, 4.0f);
            Unit unit2 = Unit.INSTANCE;
            col.addView(horizontalScrollView, lp$default2);
            col.addView(this.area, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
            status$default(this, null, false, null, 4, null);
        }

        private final void drawChips() {
            ArrayList arrayList;
            this.chips.removeAllViews();
            for (RobloxCloud.Group group : this.groups) {
                boolean z = group.getId() == StartScreen.access$getSelectedGroup$p(this.this$0);
                LinearLayout linearLayout = new LinearLayout(StartScreen.access$getAct$p(this.this$0));
                StartScreen startScreen = this.this$0;
                linearLayout.setOrientation(0);
                linearLayout.setGravity(16);
                linearLayout.setPadding(StartScreen.access$dp(startScreen, 5.0f), StartScreen.access$dp(startScreen, 5.0f), StartScreen.access$dp(startScreen, 14.0f), StartScreen.access$dp(startScreen, 5.0f));
                Ui ui = Ui.INSTANCE;
                Activity access$getAct$p = StartScreen.access$getAct$p(startScreen);
                Ui ui2 = Ui.INSTANCE;
                linearLayout.setBackground(ui.rippleBg(access$getAct$p, z ? ui2.getACCENT() : ui2.getCARD(), 18.0f));
                linearLayout.setClickable(true);
                linearLayout.setOnClickListener(new StartScreen$GroupsView$$ExternalSyntheticLambda2(this, group));
                ImageView imageView = new ImageView(StartScreen.access$getAct$p(this.this$0));
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(1);
                gradientDrawable.setColor(Ui.INSTANCE.getHOVER());
                imageView.setBackground(gradientDrawable);
                imageView.setClipToOutline(true);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                String str = StartCache.INSTANCE.getGroupIcons().get(Long.valueOf(group.getId()));
                Bitmap key = str != null ? ImageLoader.INSTANCE.getKey("url:" + str) : null;
                if (key != null) {
                    imageView.setImageBitmap(key);
                } else {
                    imageView.setImageDrawable(Icons.general$default(Icons.INSTANCE, StartScreen.access$getAct$p(this.this$0), "Group", null, 4, null));
                    imageView.setPadding(StartScreen.access$dp(this.this$0, 4.0f), StartScreen.access$dp(this.this$0, 4.0f), StartScreen.access$dp(this.this$0, 4.0f), StartScreen.access$dp(this.this$0, 4.0f));
                    if (str != null) {
                        HashMap access$getIconViews$p = StartScreen.access$getIconViews$p(this.this$0);
                        String str2 = "url:" + str;
                        Object obj = access$getIconViews$p.get(str2);
                        if (obj == null) {
                            arrayList = new ArrayList();
                            access$getIconViews$p.put(str2, arrayList);
                        } else {
                            arrayList = obj;
                        }
                        ((List) arrayList).add(imageView);
                    }
                }
                LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, StartScreen.access$dp(this.this$0, 26.0f), StartScreen.access$dp(this.this$0, 26.0f), 0.0f, 4, null);
                lp$default.rightMargin = StartScreen.access$dp(this.this$0, 8.0f);
                Unit unit = Unit.INSTANCE;
                linearLayout.addView(imageView, lp$default);
                linearLayout.addView(Ui.INSTANCE.text(StartScreen.access$getAct$p(this.this$0), group.getName(), 13.0f, z ? -1 : Ui.INSTANCE.getTEXT(), z));
                LinearLayout.LayoutParams lp$default2 = Ui.lp$default(Ui.INSTANCE, -2, -2, 0.0f, 4, null);
                StartScreen startScreen2 = this.this$0;
                lp$default2.rightMargin = StartScreen.access$dp(startScreen2, 8.0f);
                lp$default2.bottomMargin = StartScreen.access$dp(startScreen2, 6.0f);
                Unit unit2 = Unit.INSTANCE;
                this.chips.addView(linearLayout, lp$default2);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void drawChips$lambda$15$lambda$14(GroupsView groupsView, RobloxCloud.Group group, View view) {
            groupsView.select(group);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void select$lambda$28(List list, StartScreen startScreen, int i, RobloxCloud.Group group, LinearLayout linearLayout, List list2) {
            Map<Long, String> emptyMap;
            try {
                emptyMap = RobloxCloud.INSTANCE.gameIcons(list);
            } catch (Exception e) {
                emptyMap = MapsKt.emptyMap();
            }
            Map<Long, String> map = emptyMap;
            StartCache.INSTANCE.getIcons().putAll(map);
            StartScreen.access$getMain$p(startScreen).post(new StartScreen$GroupsView$$ExternalSyntheticLambda3(i, startScreen, group, map, linearLayout, list2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void select$lambda$28$lambda$27(int i, StartScreen startScreen, RobloxCloud.Group group, Map map, LinearLayout linearLayout, List list) {
            if (i == StartScreen.access$getGen$p(startScreen) && StartScreen.access$getSelectedGroup$p(startScreen) == group.getId()) {
                if (map.isEmpty()) {
                    return;
                }
                linearLayout.removeAllViews();
                StartScreen.access$getGrids$p(startScreen).clear();
                StartScreen.showGames$default(startScreen, linearLayout, list, "This group has no experiences you can edit.", false, 8, null);
                StartScreen.access$applyFilter(startScreen);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void status$default(GroupsView groupsView, String str, boolean z, Function0 function0, int i, Object obj) {
            if ((i & 4) != 0) {
                function0 = null;
            }
            groupsView.status(str, z, function0);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void status$lambda$8(Function0 function0, View view) {
            function0.invoke();
        }

        public final void redrawChips() {
            if (this.groups.isEmpty()) {
                return;
            }
            drawChips();
        }

        public final void select(RobloxCloud.Group gp) {
            Intrinsics.checkNotNullParameter(gp, "gp");
            StartScreen.access$setSelectedGroup$p(this.this$0, gp.getId());
            this.shownGroup = gp.getId();
            List<RobloxCloud.Game> list = this.gamesOf.get(Long.valueOf(gp.getId()));
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            List<RobloxCloud.Game> list2 = list;
            List<RobloxCloud.Game> list3 = list2;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((RobloxCloud.Game) it.next()).getUniverseId()));
            }
            this.shownGames = arrayList;
            drawChips();
            this.area.removeAllViews();
            StartScreen.access$getGrids$p(this.this$0).clear();
            LinearLayout linearLayout = this.area;
            TextView text$default = Ui.text$default(Ui.INSTANCE, StartScreen.access$getAct$p(this.this$0), (gp.getRole().length() > 0 ? "Your role: " + gp.getRole() + "  ·  " : "") + list2.size() + " experience" + (list2.size() != 1 ? "s" : ""), 12.0f, Ui.INSTANCE.getDIM(), false, 16, null);
            StartScreen startScreen = this.this$0;
            text$default.setPadding(0, StartScreen.access$dp(startScreen, 6.0f), 0, StartScreen.access$dp(startScreen, 10.0f));
            linearLayout.addView(text$default);
            LinearLayout linearLayout2 = new LinearLayout(StartScreen.access$getAct$p(this.this$0));
            linearLayout2.setOrientation(1);
            this.area.addView(linearLayout2, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
            StartScreen.showGames$default(this.this$0, linearLayout2, list2, "This group has no experiences you can edit.", false, 8, null);
            StartScreen.access$applyFilter(this.this$0);
            List<RobloxCloud.Game> list4 = list2;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
            Iterator<T> it2 = list4.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Long.valueOf(((RobloxCloud.Game) it2.next()).getUniverseId()));
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : arrayList2) {
                if (!StartCache.INSTANCE.getIcons().containsKey(Long.valueOf(((Number) obj).longValue()))) {
                    arrayList3.add(obj);
                }
            }
            ArrayList arrayList4 = arrayList3;
            if (arrayList4.isEmpty()) {
                return;
            }
            StartScreen.access$getNet$p(this.this$0).execute(new StartScreen$GroupsView$$ExternalSyntheticLambda0(arrayList4, this.this$0, StartScreen.access$getGen$p(this.this$0), gp, linearLayout2, list2));
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x010f, code lost:
        
            if (r1 == false) goto L43;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void set(java.util.List<? extends kotlin.Pair<com.exampletest.mobilestudiotest.net.RobloxCloud.Group, ? extends java.util.List<com.exampletest.mobilestudiotest.net.RobloxCloud.Game>>> r17, int r18, boolean r19) {
            /*
                Method dump skipped, instructions count: 447
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.StartScreen.GroupsView.set(java.util.List, int, boolean):void");
        }

        public final void status(String text, boolean spin, Function0<Unit> onTap) {
            this.statusRow.setVisibility(text == null ? 8 : 0);
            this.statusText.setText(text != null ? text : "");
            this.statusText.setTextColor(onTap != null ? StartScreen.access$getLinkColor(this.this$0) : Ui.INSTANCE.getDIM());
            LinearLayout linearLayout = this.statusRow;
            if (onTap != null) {
                linearLayout.setOnClickListener(new StartScreen$GroupsView$$ExternalSyntheticLambda1(onTap));
            } else {
                linearLayout.setOnClickListener(null);
                this.statusRow.setClickable(false);
            }
            this.statusSpin.setVisibility(spin ? 0 : 8);
        }
    }

    /* compiled from: StartScreen.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/StartScreen$Host;", "", "newFromTemplate", "", "t", "Lcom/exampletest/mobilestudiotest/core/PlaceFactory$Template;", "openFileFromStart", "openRecentFile", "e", "Lcom/exampletest/mobilestudiotest/core/Recents$Entry;", "closeStart", "hasOpenPlace", "", "showStudioSettings", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Host {
        void closeStart();

        boolean hasOpenPlace();

        void newFromTemplate(PlaceFactory.Template t);

        void openFileFromStart();

        void openRecentFile(Recents.Entry e);

        void showStudioSettings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StartScreen.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/StartScreen$Kind;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "MINE", "SHARED", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum Kind {
        MINE("games"),
        SHARED("shared");

        private final String key;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        Kind(String str) {
            this.key = str;
        }

        public static EnumEntries<Kind> getEntries() {
            return $ENTRIES;
        }

        public final String getKey() {
            return this.key;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartScreen(Activity act, Studio studio, MainActions actions, Host host) {
        super(act);
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(studio, "studio");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(host, "host");
        this.act = act;
        this.studio = studio;
        this.actions = actions;
        this.host = host;
        this.net = Executors.newFixedThreadPool(2);
        this.main = new Handler(Looper.getMainLooper());
        this.content = new FrameLayout(this.act);
        this.nav = new LinearLayout(this.act);
        this.page = HOME;
        this.accountChip = new LinearLayout(this.act);
        this.phone = this.act.getResources().getConfiguration().smallestScreenWidthDp < 600;
        this.iconViews = new HashMap<>();
        this.imgListener = new StartScreen$$ExternalSyntheticLambda44(this);
        this.accountListener = new StartScreen$$ExternalSyntheticLambda45(this);
        this.grids = new ArrayList<>();
        this.query = "";
        setOrientation(1);
        setBackgroundColor(Ui.INSTANCE.getBG());
        setClickable(true);
        LinearLayout linearLayout = new LinearLayout(this.act);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackgroundColor(Ui.INSTANCE.getTOPBAR());
        linearLayout.setPadding(dp(10.0f), dp(6.0f), dp(8.0f), dp(6.0f));
        ImageView imageView = new ImageView(this.act);
        imageView.setImageDrawable(Icons.general$default(Icons.INSTANCE, this.act, "Place", null, 4, null));
        imageView.setPadding(dp(4.0f), dp(4.0f), dp(4.0f), dp(4.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Ui.INSTANCE.blend(Ui.INSTANCE.getTOPBAR(), Ui.INSTANCE.getACCENT(), 0.3f));
        gradientDrawable.setCornerRadius(dp(8.0f));
        imageView.setBackground(gradientDrawable);
        LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, dp(30.0f), dp(30.0f), 0.0f, 4, null);
        lp$default.rightMargin = dp(10.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(imageView, lp$default);
        linearLayout.addView(Ui.INSTANCE.text(this.act, "Mobile Studio", 16.0f, Ui.INSTANCE.getTEXT(), true));
        TextView text$default = Ui.text$default(Ui.INSTANCE, this.act, "v" + ((Object) AboutDialog.INSTANCE.version(this.act).getFirst()), 11.0f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default.setPadding(dp(7.0f), dp(1.0f), dp(7.0f), dp(1.0f));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Ui.INSTANCE.getHOVER());
        gradientDrawable2.setCornerRadius(dp(9.0f));
        text$default.setBackground(gradientDrawable2);
        LinearLayout.LayoutParams lp$default2 = Ui.lp$default(Ui.INSTANCE, -2, -2, 0.0f, 4, null);
        lp$default2.leftMargin = dp(8.0f);
        Unit unit2 = Unit.INSTANCE;
        linearLayout.addView(text$default, lp$default2);
        linearLayout.addView(new View(this.act), Ui.INSTANCE.lp(0, 1, 1.0f));
        if (this.host.hasOpenPlace()) {
            TextView iconTextButton$default = Ui.iconTextButton$default(Ui.INSTANCE, this.act, Icons.general$default(Icons.INSTANCE, this.act, "Back", null, 4, null), this.phone ? "Place" : "Back to place", 0, new StartScreen$$ExternalSyntheticLambda46(this), 8, null);
            LinearLayout.LayoutParams lp$default3 = Ui.lp$default(Ui.INSTANCE, -2, -2, 0.0f, 4, null);
            lp$default3.rightMargin = dp(6.0f);
            Unit unit3 = Unit.INSTANCE;
            linearLayout.addView(iconTextButton$default, lp$default3);
        }
        ImageView iconButton$default = Ui.iconButton$default(Ui.INSTANCE, this.act, Icons.general$default(Icons.INSTANCE, this.act, "Info", null, 4, null), 0.0f, new StartScreen$$ExternalSyntheticLambda47(this), 4, null);
        iconButton$default.setContentDescription("About Mobile Studio");
        linearLayout.addView(iconButton$default);
        ImageView iconButton$default2 = Ui.iconButton$default(Ui.INSTANCE, this.act, Icons.general$default(Icons.INSTANCE, this.act, "Settings", null, 4, null), 0.0f, new StartScreen$$ExternalSyntheticLambda48(this), 4, null);
        iconButton$default2.setContentDescription("Studio settings");
        linearLayout.addView(iconButton$default2);
        LinearLayout linearLayout2 = this.accountChip;
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setPadding(dp(4.0f), dp(3.0f), dp(10.0f), dp(3.0f));
        linearLayout2.setBackground(Ui.INSTANCE.rippleBg(this.act, Ui.INSTANCE.getHOVER(), 16.0f));
        linearLayout2.setOnClickListener(new StartScreen$$ExternalSyntheticLambda49(this));
        LinearLayout linearLayout3 = this.accountChip;
        LinearLayout.LayoutParams lp$default4 = Ui.lp$default(Ui.INSTANCE, -2, -2, 0.0f, 4, null);
        lp$default4.leftMargin = dp(6.0f);
        Unit unit4 = Unit.INSTANCE;
        linearLayout.addView(linearLayout3, lp$default4);
        addView(linearLayout, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        addView(Ui.divider$default(Ui.INSTANCE, this.act, false, 2, null));
        LinearLayout linearLayout4 = new LinearLayout(this.act);
        linearLayout4.setOrientation(this.phone ? 1 : 0);
        this.nav.setOrientation(!this.phone ? 1 : 0);
        if (this.phone) {
            this.nav.setPadding(dp(8.0f), dp(6.0f), dp(8.0f), dp(6.0f));
            HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this.act);
            horizontalScrollView.setHorizontalScrollBarEnabled(false);
            horizontalScrollView.setBackgroundColor(getSideColor());
            horizontalScrollView.addView(this.nav);
            linearLayout4.addView(horizontalScrollView, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
            linearLayout4.addView(Ui.divider$default(Ui.INSTANCE, this.act, false, 2, null));
        } else {
            this.nav.setPadding(dp(10.0f), dp(10.0f), dp(10.0f), dp(10.0f));
            ScrollView scrollView = new ScrollView(this.act);
            scrollView.setFillViewport(true);
            scrollView.setBackgroundColor(getSideColor());
            scrollView.addView(this.nav, new FrameLayout.LayoutParams(-1, -1));
            linearLayout4.addView(scrollView, Ui.lp$default(Ui.INSTANCE, dp(214.0f), -1, 0.0f, 4, null));
            linearLayout4.addView(Ui.INSTANCE.divider(this.act, true));
        }
        linearLayout4.addView(this.content, Ui.INSTANCE.lp(this.phone ? -1 : 0, this.phone ? 0 : -1, 1.0f));
        addView(linearLayout4, Ui.INSTANCE.lp(-1, 0, 1.0f));
        refreshAccount();
        show(HOME);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$13(StartScreen startScreen, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        startScreen.host.closeStart();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$15(StartScreen startScreen, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AboutDialog.INSTANCE.show(startScreen.act);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$17(StartScreen startScreen, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        startScreen.host.showStudioSettings();
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$applyFilter(StartScreen startScreen) {
        startScreen.applyFilter();
    }

    public static final /* synthetic */ int access$dp(StartScreen startScreen, float f) {
        return startScreen.dp(f);
    }

    public static final /* synthetic */ Activity access$getAct$p(StartScreen startScreen) {
        return startScreen.act;
    }

    public static final /* synthetic */ int access$getGen$p(StartScreen startScreen) {
        return startScreen.gen;
    }

    public static final /* synthetic */ ArrayList access$getGrids$p(StartScreen startScreen) {
        return startScreen.grids;
    }

    public static final /* synthetic */ HashMap access$getIconViews$p(StartScreen startScreen) {
        return startScreen.iconViews;
    }

    public static final /* synthetic */ int access$getLinkColor(StartScreen startScreen) {
        return startScreen.getLinkColor();
    }

    public static final /* synthetic */ Handler access$getMain$p(StartScreen startScreen) {
        return startScreen.main;
    }

    public static final /* synthetic */ ExecutorService access$getNet$p(StartScreen startScreen) {
        return startScreen.net;
    }

    public static final /* synthetic */ long access$getSelectedGroup$p(StartScreen startScreen) {
        return startScreen.selectedGroup;
    }

    public static final /* synthetic */ void access$setQuery$p(StartScreen startScreen, String str) {
        startScreen.query = str;
    }

    public static final /* synthetic */ void access$setSelectedGroup$p(StartScreen startScreen, long j) {
        startScreen.selectedGroup = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit accountListener$lambda$5(StartScreen startScreen) {
        startScreen.main.post(new StartScreen$$ExternalSyntheticLambda15(startScreen));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void accountListener$lambda$5$lambda$4(StartScreen startScreen) {
        startScreen.refreshAccount();
        if (Intrinsics.areEqual(startScreen.page, RECENT)) {
            return;
        }
        startScreen.show(startScreen.page);
    }

    private final void addToRow(LinearLayout r, View v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(layoutParams != null ? layoutParams.width : -2, -2);
        layoutParams2.rightMargin = dp(12.0f);
        Unit unit = Unit.INSTANCE;
        r.addView(v, layoutParams2);
    }

    private final void applyFilter() {
        String lowerCase = this.query.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Iterator<FlowLayout> it = this.grids.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            FlowLayout next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            FlowLayout flowLayout = next;
            int childCount = flowLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = flowLayout.getChildAt(i);
                Object tag = childAt.getTag();
                String str = tag instanceof String ? (String) tag : null;
                if (str != null) {
                    String lowerCase2 = str.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (lowerCase2 != null) {
                        int i2 = 0;
                        if (!(lowerCase.length() == 0) && !StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) lowerCase, false, 2, (Object) null)) {
                            i2 = 8;
                        }
                        childAt.setVisibility(i2);
                    }
                }
            }
        }
    }

    private final void bindIcon(ImageView img, String url, String fallback) {
        ArrayList arrayList;
        int dp = dp(this.phone ? 30.0f : 36.0f);
        if (url == null) {
            bindIcon$placeholder(img, dp, this, fallback);
            return;
        }
        String str = "url:" + url;
        Bitmap key = ImageLoader.INSTANCE.getKey(str);
        if (key != null) {
            showBitmap(img, key);
            return;
        }
        bindIcon$placeholder(img, dp, this, fallback);
        HashMap<String, List<ImageView>> hashMap = this.iconViews;
        List<ImageView> list = hashMap.get(str);
        if (list == null) {
            arrayList = new ArrayList();
            hashMap.put(str, arrayList);
        } else {
            arrayList = list;
        }
        arrayList.add(img);
    }

    private static final void bindIcon$placeholder(ImageView imageView, int i, StartScreen startScreen, String str) {
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(i, i, i, i);
        imageView.setImageDrawable(Icons.general$default(Icons.INSTANCE, startScreen.act, str, null, 4, null));
    }

    private final void buildNav() {
        this.nav.removeAllViews();
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(HOME, HOME), TuplesKt.to(RECENT, "History")})) {
            String str = (String) pair.component1();
            buildNav$item(this, str, (String) pair.component2(), Intrinsics.areEqual(this.page, str), new StartScreen$$ExternalSyntheticLambda21(this, str));
        }
        buildNav$label(this, "Creations");
        for (Pair pair2 : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(MY_GAMES, "Account"), TuplesKt.to(SHARED, "Shared"), TuplesKt.to(GROUPS, "Group")})) {
            String str2 = (String) pair2.component1();
            buildNav$item(this, str2, (String) pair2.component2(), Intrinsics.areEqual(this.page, str2), new StartScreen$$ExternalSyntheticLambda22(this, str2));
        }
        buildNav$label(this, "Open");
        buildNav$item(this, "Open File…", "Open", false, new StartScreen$$ExternalSyntheticLambda23(this));
        buildNav$item(this, "Open by Place ID…", "Download", false, new StartScreen$$ExternalSyntheticLambda24(this));
        if (!this.phone) {
            this.nav.addView(new View(this.act), Ui.INSTANCE.lp(-1, 0, 1.0f));
        }
        buildNav$item(this, this.phone ? "About" : "About  ·  v" + ((Object) AboutDialog.INSTANCE.version(this.act).getFirst()), "Info", false, new StartScreen$$ExternalSyntheticLambda25(this));
    }

    private static final void buildNav$item(StartScreen startScreen, String str, String str2, boolean z, Function0<Unit> function0) {
        int sideColor;
        LinearLayout.LayoutParams lp$default;
        LinearLayout linearLayout = new LinearLayout(startScreen.act);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(startScreen.dp(10.0f), startScreen.dp(startScreen.phone ? 7.0f : 9.0f), startScreen.dp(14.0f), startScreen.dp(startScreen.phone ? 7.0f : 9.0f));
        Ui ui = Ui.INSTANCE;
        Activity activity = startScreen.act;
        if (z) {
            sideColor = Ui.INSTANCE.blend(startScreen.getSideColor(), Ui.INSTANCE.getACCENT(), Ui.INSTANCE.getLIGHT() ? 0.16f : 0.32f);
        } else {
            sideColor = startScreen.getSideColor();
        }
        linearLayout.setBackground(ui.rippleBg(activity, sideColor, startScreen.phone ? 18.0f : 9.0f));
        linearLayout.setClickable(true);
        linearLayout.setOnClickListener(new StartScreen$$ExternalSyntheticLambda18(function0));
        linearLayout.setContentDescription(str);
        ImageView imageView = new ImageView(startScreen.act);
        imageView.setImageDrawable(Icons.general$default(Icons.INSTANCE, startScreen.act, str2, null, 4, null));
        LinearLayout.LayoutParams lp$default2 = Ui.lp$default(Ui.INSTANCE, startScreen.dp(20.0f), startScreen.dp(20.0f), 0.0f, 4, null);
        lp$default2.rightMargin = startScreen.dp(10.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(imageView, lp$default2);
        linearLayout.addView(Ui.INSTANCE.text(startScreen.act, str, 13.5f, Ui.INSTANCE.getTEXT(), z));
        LinearLayout linearLayout2 = startScreen.nav;
        LinearLayout linearLayout3 = linearLayout;
        boolean z2 = startScreen.phone;
        Ui ui2 = Ui.INSTANCE;
        if (z2) {
            lp$default = Ui.lp$default(ui2, -2, -2, 0.0f, 4, null);
            lp$default.rightMargin = startScreen.dp(4.0f);
        } else {
            lp$default = Ui.lp$default(ui2, -1, -2, 0.0f, 4, null);
            lp$default.bottomMargin = startScreen.dp(2.0f);
        }
        Unit unit2 = Unit.INSTANCE;
        linearLayout2.addView(linearLayout3, lp$default);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void buildNav$item$lambda$26$lambda$25(Function0 function0, View view) {
        function0.invoke();
    }

    private static final void buildNav$label(StartScreen startScreen, String str) {
        if (startScreen.phone) {
            return;
        }
        LinearLayout linearLayout = startScreen.nav;
        Ui ui = Ui.INSTANCE;
        Activity activity = startScreen.act;
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        TextView text = ui.text(activity, upperCase, 10.5f, Ui.INSTANCE.getDIM(), true);
        text.setLetterSpacing(0.08f);
        text.setPadding(startScreen.dp(12.0f), startScreen.dp(14.0f), 0, startScreen.dp(6.0f));
        linearLayout.addView(text);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildNav$lambda$32(StartScreen startScreen, String str) {
        startScreen.show(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildNav$lambda$33(StartScreen startScreen, String str) {
        startScreen.show(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildNav$lambda$34(StartScreen startScreen) {
        startScreen.host.openFileFromStart();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildNav$lambda$35(StartScreen startScreen) {
        AccountUi.INSTANCE.openById(startScreen.act, startScreen.studio, startScreen.actions);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildNav$lambda$36(StartScreen startScreen) {
        AboutDialog.INSTANCE.show(startScreen.act);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v3 */
    private final LinearLayout card(String title, String sub, String iconUrl, String fallback, Function0<Unit> onClick, Function0<Unit> onLong, Integer tint) {
        int blend;
        boolean z;
        int i;
        int dp = dp(this.phone ? 140.0f : 168.0f);
        float dp2 = dp(12.0f);
        LinearLayout linearLayout = new LinearLayout(this.act);
        linearLayout.setOrientation(1);
        linearLayout.setBackground(Ui.INSTANCE.rippleBg(this.act, Ui.INSTANCE.getCARD(), 12.0f));
        linearLayout.setClickable(true);
        linearLayout.setOnClickListener(new StartScreen$$ExternalSyntheticLambda13(onClick));
        if (onLong != null) {
            linearLayout.setOnLongClickListener(new StartScreen$$ExternalSyntheticLambda14(onLong));
        }
        linearLayout.setTag(title);
        linearLayout.setContentDescription(title);
        if (tint != null) {
            blend = tint.intValue();
        } else {
            blend = Ui.INSTANCE.blend(Ui.INSTANCE.getCARD(), ViewCompat.MEASURED_STATE_MASK, Ui.INSTANCE.getLIGHT() ? 0.06f : 0.22f);
        }
        int i2 = blend;
        FrameLayout frameLayout = new FrameLayout(this.act);
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TL_BR;
        if (tint != null) {
            z = 1;
            i = Ui.INSTANCE.blend(tint.intValue(), -1, 0.18f);
        } else {
            z = 1;
            i = i2;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, new int[]{i, tint != null ? Ui.INSTANCE.blend(tint.intValue(), ViewCompat.MEASURED_STATE_MASK, 0.22f) : i2});
        float[] fArr = new float[8];
        fArr[0] = dp2;
        fArr[z] = dp2;
        fArr[2] = dp2;
        fArr[3] = dp2;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        gradientDrawable.setCornerRadii(fArr);
        frameLayout.setBackground(gradientDrawable);
        frameLayout.setClipToOutline(z);
        ImageView imageView = new ImageView(this.act);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        bindIcon(imageView, iconUrl, fallback);
        linearLayout.addView(frameLayout, Ui.lp$default(Ui.INSTANCE, dp, dp, 0.0f, 4, null));
        LinearLayout linearLayout2 = new LinearLayout(this.act);
        linearLayout2.setOrientation(1);
        linearLayout2.setPadding(dp(10.0f), dp(8.0f), dp(10.0f), dp(10.0f));
        TextView text = Ui.INSTANCE.text(this.act, title, 13.0f, Ui.INSTANCE.getTEXT(), true);
        text.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout2.addView(text);
        TextView text$default = Ui.text$default(Ui.INSTANCE, this.act, sub, 11.0f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default.setEllipsize(TextUtils.TruncateAt.END);
        text$default.setPadding(0, dp(2.0f), 0, 0);
        linearLayout2.addView(text$default);
        linearLayout.addView(linearLayout2, Ui.lp$default(Ui.INSTANCE, dp, -2, 0.0f, 4, null));
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(dp, -2));
        return linearLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ LinearLayout card$default(StartScreen startScreen, String str, String str2, String str3, String str4, Function0 function0, Function0 function02, Integer num, int i, Object obj) {
        if ((i & 32) != 0) {
            function02 = null;
        }
        if ((i & 64) != 0) {
            num = null;
        }
        return startScreen.card(str, str2, str3, str4, function0, function02, num);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void card$lambda$62$lambda$60(Function0 function0, View view) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean card$lambda$62$lambda$61(Function0 function0, View view) {
        function0.invoke();
        return true;
    }

    private final int dp(float v) {
        return Ui.INSTANCE.dp(this.act, v);
    }

    private final void error(LinearLayout col, Throwable e) {
        if (!(e instanceof AuthRequiredException)) {
            String message = e.getMessage();
            message(col, "Couldn't load this from Roblox.\n" + (message != null ? message : e), "Try again", "PluginsFolder", new StartScreen$$ExternalSyntheticLambda31(this));
        } else {
            String message2 = e.getMessage();
            if (message2 == null) {
                message2 = "Sign in again.";
            }
            message$default(this, col, message2, "Sign in", null, new StartScreen$$ExternalSyntheticLambda30(this), 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit error$lambda$130(StartScreen startScreen) {
        AccountUi.signIn$default(AccountUi.INSTANCE, startScreen.act, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit error$lambda$131(StartScreen startScreen) {
        startScreen.show(startScreen.page);
        return Unit.INSTANCE;
    }

    private final LinearLayout gameCard(RobloxCloud.Game game, boolean showOwner) {
        String str;
        if (showOwner) {
            if (game.getOwner().length() > 0) {
                str = "by " + game.getOwner();
                return card$default(this, game.getName(), str, StartCache.INSTANCE.getIcons().get(Long.valueOf(game.getUniverseId())), "Place", new StartScreen$$ExternalSyntheticLambda37(this, game), new StartScreen$$ExternalSyntheticLambda38(this, game), null, 64, null);
            }
        }
        str = game.getUpdated().length() > 0 ? "Updated " + StringsKt.substringBefore$default(AccountUi.INSTANCE.prettyDate(game.getUpdated()), "  ", (String) null, 2, (Object) null) : game.getOwner();
        return card$default(this, game.getName(), str, StartCache.INSTANCE.getIcons().get(Long.valueOf(game.getUniverseId())), "Place", new StartScreen$$ExternalSyntheticLambda37(this, game), new StartScreen$$ExternalSyntheticLambda38(this, game), null, 64, null);
    }

    static /* synthetic */ LinearLayout gameCard$default(StartScreen startScreen, RobloxCloud.Game game, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startScreen.gameCard(game, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit gameCard$lambda$119(StartScreen startScreen, RobloxCloud.Game game) {
        AccountUi.INSTANCE.places(startScreen.act, startScreen.studio, startScreen.actions, game, new StartScreen$$ExternalSyntheticLambda3(startScreen));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit gameCard$lambda$119$lambda$118(StartScreen startScreen, RobloxCloud.Game gm, RobloxCloud.Place p) {
        Intrinsics.checkNotNullParameter(gm, "gm");
        Intrinsics.checkNotNullParameter(p, "p");
        AccountUi.INSTANCE.openPlace(startScreen.act, startScreen.actions, gm, p, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit gameCard$lambda$120(StartScreen startScreen, RobloxCloud.Game game) {
        AccountUi.INSTANCE.places(startScreen.act, startScreen.studio, startScreen.actions, game, null);
        return Unit.INSTANCE;
    }

    private final void games(Kind kind) {
        LinearLayout scrollColumn = scrollColumn();
        boolean z = kind == Kind.MINE;
        pageHeader(scrollColumn, z ? MY_GAMES : SHARED, z ? "Experiences you own. Tap one to edit it; long-press for downloads and version history." : "Experiences other creators added you to as a collaborator.", true, new StartScreen$$ExternalSyntheticLambda5(this));
        if (RobloxApi.INSTANCE.isGuest(this.act)) {
            message$default(this, scrollColumn, "You're using Mobile Studio as a guest. Sign in to see " + (z ? "the experiences you own." : "the experiences shared with you."), "Sign in with Roblox", null, new StartScreen$$ExternalSyntheticLambda6(this), 8, null);
            return;
        }
        int i = this.gen;
        List<RobloxCloud.Game> games = StartCache.INSTANCE.games(this.act, RobloxApi.INSTANCE.userId(this.act), kind.getKey());
        LinearLayout linearLayout = new LinearLayout(this.act);
        linearLayout.setOrientation(1);
        scrollColumn.addView(linearLayout, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        String str = z ? "You don't own any experiences yet. Create one on create.roblox.com (or File → Publish to Roblox As → Create new game) and it will show up here." : "Nothing has been shared with you yet. When someone adds you as a collaborator on their experience (Game Settings → Permissions / Collaborators), it shows up here.";
        if (games != null) {
            showGames(linearLayout, games, str, z ? false : true);
        }
        this.net.execute(new StartScreen$$ExternalSyntheticLambda7(this, kind, i, games == null ? loading(scrollColumn) : null, scrollColumn, linearLayout, str, z, games));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit games$lambda$121(StartScreen startScreen) {
        startScreen.show(startScreen.page);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit games$lambda$122(StartScreen startScreen) {
        AccountUi.signIn$default(AccountUi.INSTANCE, startScreen.act, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void games$lambda$129(StartScreen startScreen, Kind kind, int i, View view, LinearLayout linearLayout, LinearLayout linearLayout2, String str, boolean z, List list) {
        Object m457constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m457constructorimpl = Result.m457constructorimpl(startScreen.loadGames(kind));
        } catch (Exception e) {
            Result.Companion companion2 = Result.INSTANCE;
            m457constructorimpl = Result.m457constructorimpl(ResultKt.createFailure(e));
        }
        startScreen.main.post(new StartScreen$$ExternalSyntheticLambda16(i, startScreen, view, m457constructorimpl, linearLayout, linearLayout2, str, z, list));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void games$lambda$129$lambda$128(int i, StartScreen startScreen, View view, Object obj, LinearLayout linearLayout, LinearLayout linearLayout2, String str, boolean z, List list) {
        if (i != startScreen.gen) {
            return;
        }
        if (view != null) {
            linearLayout.removeView(view);
        }
        Throwable m460exceptionOrNullimpl = Result.m460exceptionOrNullimpl(obj);
        if (m460exceptionOrNullimpl != null) {
            if (list == null) {
                startScreen.error(linearLayout, m460exceptionOrNullimpl);
            }
        } else {
            linearLayout2.removeAllViews();
            CollectionsKt.removeAll((List) startScreen.grids, (Function1) new StartScreen$$ExternalSyntheticLambda32(linearLayout2));
            startScreen.showGames(linearLayout2, (List) obj, str, !z);
            startScreen.applyFilter();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean games$lambda$129$lambda$128$lambda$126$lambda$125(LinearLayout linearLayout, FlowLayout it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getParent() == null || it.getParent() == linearLayout;
    }

    private final int getLinkColor() {
        return Ui.INSTANCE.getLIGHT() ? Ui.INSTANCE.getACCENT() : Ui.INSTANCE.blend(Ui.INSTANCE.getACCENT(), -1, 0.45f);
    }

    private final int getSideColor() {
        Ui ui;
        int bg;
        float f;
        if (Ui.INSTANCE.getLIGHT()) {
            ui = Ui.INSTANCE;
            bg = Ui.INSTANCE.getBG();
            f = 0.035f;
        } else {
            ui = Ui.INSTANCE;
            bg = Ui.INSTANCE.getBG();
            f = 0.18f;
        }
        return ui.blend(bg, ViewCompat.MEASURED_STATE_MASK, f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x01ac, code lost:
    
        if (r9 != null) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void greeting(android.widget.LinearLayout r30) {
        /*
            Method dump skipped, instructions count: 992
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.StartScreen.greeting(android.widget.LinearLayout):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit greeting$lambda$90(StartScreen startScreen, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        startScreen.host.newFromTemplate(PlaceFactory.Template.BASEPLATE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit greeting$lambda$92(StartScreen startScreen, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        startScreen.host.openFileFromStart();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit greeting$lambda$94(StartScreen startScreen, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AccountUi.signIn$default(AccountUi.INSTANCE, startScreen.act, null, 2, null);
        return Unit.INSTANCE;
    }

    private final FlowLayout grid(LinearLayout col) {
        FlowLayout flowLayout = new FlowLayout(this.act);
        flowLayout.setGap(dp(12.0f));
        col.addView(flowLayout, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        this.grids.add(flowLayout);
        return flowLayout;
    }

    private final void groupGames() {
        LinearLayout scrollColumn = scrollColumn();
        pageHeader(scrollColumn, GROUPS, "Experiences in your groups that you can edit.", true, new StartScreen$$ExternalSyntheticLambda39(this));
        if (RobloxApi.INSTANCE.isGuest(this.act)) {
            message$default(this, scrollColumn, "You're using Mobile Studio as a guest. Sign in to see the group experiences you can edit.", "Sign in with Roblox", null, new StartScreen$$ExternalSyntheticLambda40(this), 8, null);
            return;
        }
        int i = this.gen;
        RobloxCloud.User cachedUser = RobloxCloud.INSTANCE.cachedUser(this.act);
        long userId = RobloxApi.INSTANCE.userId(this.act);
        GroupsView groupsView = new GroupsView(this, scrollColumn);
        Pair<Integer, List<Pair<RobloxCloud.Group, List<RobloxCloud.Game>>>> groups = StartCache.INSTANCE.groups(this.act, userId);
        if (groups != null) {
            groupsView.set(groups.getSecond(), groups.getFirst().intValue(), false);
        } else {
            GroupsView.status$default(groupsView, "Loading your groups…", true, null, 4, null);
        }
        this.net.execute(new StartScreen$$ExternalSyntheticLambda41(this, cachedUser, groups, userId, i, groupsView, scrollColumn));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit groupGames$lambda$132(StartScreen startScreen) {
        startScreen.show(startScreen.page);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit groupGames$lambda$133(StartScreen startScreen) {
        AccountUi.signIn$default(AccountUi.INSTANCE, startScreen.act, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void groupGames$lambda$150(StartScreen startScreen, RobloxCloud.User user, Pair pair, long j, int i, GroupsView groupsView, LinearLayout linearLayout) {
        int i2;
        StartScreen startScreen2 = startScreen;
        try {
            RobloxCloud.GroupList allGroups = RobloxCloud.INSTANCE.allGroups(startScreen2.act, user == null ? RobloxCloud.INSTANCE.currentUser(startScreen2.act) : user);
            List take = CollectionsKt.take(allGroups.getGroups(), 150);
            int i3 = i;
            GroupsView groupsView2 = groupsView;
            startScreen2.net.execute(new StartScreen$$ExternalSyntheticLambda26(take, startScreen2, i3, groupsView2));
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            ConcurrentHashMap.KeySetView newKeySet = ConcurrentHashMap.newKeySet();
            AtomicInteger atomicInteger = new AtomicInteger();
            AtomicReference atomicReference = new AtomicReference();
            ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(4);
            List list = pair != null ? (List) pair.getSecond() : null;
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            List<Pair> list2 = list;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
            for (Pair pair2 : list2) {
                List list3 = list2;
                Pair pair3 = TuplesKt.to(Long.valueOf(((RobloxCloud.Group) pair2.getFirst()).getId()), pair2.getSecond());
                linkedHashMap.put(pair3.getFirst(), pair3.getSecond());
                atomicReference = atomicReference;
                list2 = list3;
            }
            AtomicReference atomicReference2 = atomicReference;
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            Iterator it = take.iterator();
            while (it.hasNext()) {
                int i4 = i3;
                StartScreen startScreen3 = startScreen2;
                try {
                    StartScreen$$ExternalSyntheticLambda27 startScreen$$ExternalSyntheticLambda27 = new StartScreen$$ExternalSyntheticLambda27(atomicReference2, i4, startScreen3, concurrentHashMap, (RobloxCloud.Group) it.next(), allGroups, newKeySet, atomicInteger, take, linkedHashMap2, pair, groupsView2);
                    startScreen2 = startScreen3;
                    AtomicInteger atomicInteger2 = atomicInteger;
                    LinkedHashMap linkedHashMap3 = linkedHashMap2;
                    ConcurrentHashMap concurrentHashMap2 = concurrentHashMap;
                    ConcurrentHashMap.KeySetView keySetView = newKeySet;
                    RobloxCloud.GroupList groupList = allGroups;
                    newFixedThreadPool.execute(startScreen$$ExternalSyntheticLambda27);
                    i3 = i;
                    allGroups = groupList;
                    concurrentHashMap = concurrentHashMap2;
                    newKeySet = keySetView;
                    atomicInteger = atomicInteger2;
                    linkedHashMap2 = linkedHashMap3;
                    groupsView2 = groupsView;
                } catch (Exception e) {
                    e = e;
                    startScreen2 = startScreen3;
                    startScreen2.main.post(new StartScreen$$ExternalSyntheticLambda29(i, startScreen2, groupsView, pair, linearLayout, e));
                    return;
                }
            }
            LinkedHashMap linkedHashMap4 = linkedHashMap2;
            ConcurrentHashMap concurrentHashMap3 = concurrentHashMap;
            ConcurrentHashMap.KeySetView keySetView2 = newKeySet;
            newFixedThreadPool.shutdown();
            newFixedThreadPool.awaitTermination(4L, TimeUnit.MINUTES);
            Exception exc = (Exception) atomicReference2.get();
            if (exc != null) {
                throw exc;
            }
            List<Pair<RobloxCloud.Group, List<RobloxCloud.Game>>> groupGames$lambda$150$snapshot = groupGames$lambda$150$snapshot(take, concurrentHashMap3, linkedHashMap4, keySetView2);
            StartCache.INSTANCE.putGroups(startScreen2.act, j, take.size(), groupGames$lambda$150$snapshot);
            Iterable indices = CollectionsKt.getIndices(take);
            if ((indices instanceof Collection) && ((Collection) indices).isEmpty()) {
                i2 = 0;
            } else {
                int i5 = 0;
                Iterator it2 = indices.iterator();
                while (it2.hasNext()) {
                    int nextInt = ((IntIterator) it2).nextInt();
                    if ((keySetView2.contains(Long.valueOf(((RobloxCloud.Group) take.get(nextInt)).getId())) && concurrentHashMap3.get(Long.valueOf(((RobloxCloud.Group) take.get(nextInt)).getId())) == null) && (i5 = i5 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
                i2 = i5;
            }
            startScreen2.main.post(new StartScreen$$ExternalSyntheticLambda28(i, startScreen2, groupsView, groupGames$lambda$150$snapshot, take, i2));
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void groupGames$lambda$150$lambda$137(List list, StartScreen startScreen, int i, GroupsView groupsView) {
        Map<Long, String> emptyMap;
        try {
            RobloxCloud robloxCloud = RobloxCloud.INSTANCE;
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((RobloxCloud.Group) it.next()).getId()));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (!StartCache.INSTANCE.getGroupIcons().containsKey(Long.valueOf(((Number) obj).longValue()))) {
                    arrayList2.add(obj);
                }
            }
            emptyMap = robloxCloud.groupIcons(CollectionsKt.take(arrayList2, 100));
        } catch (Exception e) {
            emptyMap = MapsKt.emptyMap();
        }
        StartCache.INSTANCE.getGroupIcons().putAll(emptyMap);
        if (emptyMap.isEmpty()) {
            return;
        }
        startScreen.main.post(new StartScreen$$ExternalSyntheticLambda17(i, startScreen, groupsView));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void groupGames$lambda$150$lambda$137$lambda$136(int i, StartScreen startScreen, GroupsView groupsView) {
        if (i == startScreen.gen) {
            groupsView.redrawChips();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void groupGames$lambda$150$lambda$144(AtomicReference atomicReference, int i, StartScreen startScreen, ConcurrentHashMap concurrentHashMap, RobloxCloud.Group group, RobloxCloud.GroupList groupList, ConcurrentHashMap.KeySetView keySetView, AtomicInteger atomicInteger, List list, Map map, Pair pair, GroupsView groupsView) {
        RobloxCloud.Group group2;
        if (atomicReference.get() == null && i == startScreen.gen) {
            try {
                group2 = group;
                try {
                    concurrentHashMap.put(Long.valueOf(group.getId()), RobloxCloud.INSTANCE.editableGroupGames(startScreen.act, group2, groupList.getStudioListed().contains(Long.valueOf(group.getId()))));
                } catch (AuthRequiredException e) {
                    e = e;
                    atomicReference.set(e);
                    int incrementAndGet = atomicInteger.incrementAndGet();
                    startScreen.main.post(new StartScreen$$ExternalSyntheticLambda12(i, startScreen, pair, groupsView, groupGames$lambda$150$snapshot(list, concurrentHashMap, map, keySetView), list, incrementAndGet));
                } catch (Exception e2) {
                    keySetView.add(Long.valueOf(group2.getId()));
                    int incrementAndGet2 = atomicInteger.incrementAndGet();
                    startScreen.main.post(new StartScreen$$ExternalSyntheticLambda12(i, startScreen, pair, groupsView, groupGames$lambda$150$snapshot(list, concurrentHashMap, map, keySetView), list, incrementAndGet2));
                }
            } catch (AuthRequiredException e3) {
                e = e3;
            } catch (Exception e4) {
                group2 = group;
            }
            int incrementAndGet22 = atomicInteger.incrementAndGet();
            startScreen.main.post(new StartScreen$$ExternalSyntheticLambda12(i, startScreen, pair, groupsView, groupGames$lambda$150$snapshot(list, concurrentHashMap, map, keySetView), list, incrementAndGet22));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void groupGames$lambda$150$lambda$144$lambda$143(int i, StartScreen startScreen, Pair pair, GroupsView groupsView, List list, List list2, int i2) {
        if (i != startScreen.gen) {
            return;
        }
        if (pair == null) {
            groupsView.set(list, list2.size(), false);
        }
        if (i2 < list2.size()) {
            GroupsView.status$default(groupsView, "Checked " + i2 + " of " + list2.size() + " groups…", true, null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void groupGames$lambda$150$lambda$148(int i, StartScreen startScreen, GroupsView groupsView, List list, List list2, int i2) {
        if (i != startScreen.gen) {
            return;
        }
        groupsView.set(list, list2.size(), true);
        if (i2 > 0) {
            groupsView.status("Couldn't check " + i2 + " group" + (i2 == 1 ? "" : "s") + " — Roblox was busy. Tap to try again.", false, new StartScreen$$ExternalSyntheticLambda50(startScreen));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit groupGames$lambda$150$lambda$148$lambda$147(StartScreen startScreen) {
        startScreen.show(startScreen.page);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void groupGames$lambda$150$lambda$149(int i, StartScreen startScreen, GroupsView groupsView, Pair pair, LinearLayout linearLayout, Exception exc) {
        if (i == startScreen.gen) {
            GroupsView.status$default(groupsView, null, false, null, 4, null);
            if (pair == null) {
                startScreen.error(linearLayout, exc);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0096 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.util.List<kotlin.Pair<com.exampletest.mobilestudiotest.net.RobloxCloud.Group, java.util.List<com.exampletest.mobilestudiotest.net.RobloxCloud.Game>>> groupGames$lambda$150$snapshot(java.util.List<com.exampletest.mobilestudiotest.net.RobloxCloud.Group> r22, java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.List<com.exampletest.mobilestudiotest.net.RobloxCloud.Game>> r23, java.util.Map<java.lang.Long, ? extends java.util.List<com.exampletest.mobilestudiotest.net.RobloxCloud.Game>> r24, java.util.concurrent.ConcurrentHashMap.KeySetView<java.lang.Long, java.lang.Boolean> r25) {
        /*
            r0 = r22
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r1 = 0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            r3 = r0
            r4 = 0
            r5 = r3
            r6 = 0
            java.util.Iterator r7 = r5.iterator()
        L14:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L9c
            java.lang.Object r8 = r7.next()
            r9 = r8
            r10 = 0
            r11 = r9
            com.exampletest.mobilestudiotest.net.RobloxCloud$Group r11 = (com.exampletest.mobilestudiotest.net.RobloxCloud.Group) r11
            r12 = 0
            long r13 = r11.getId()
            java.lang.Long r13 = java.lang.Long.valueOf(r13)
            r14 = r23
            java.lang.Object r13 = r14.get(r13)
            java.util.List r13 = (java.util.List) r13
            if (r13 != 0) goto L6a
            long r16 = r11.getId()
            java.lang.Long r13 = java.lang.Long.valueOf(r16)
            r15 = r24
            java.lang.Object r13 = r15.get(r13)
            java.util.List r13 = (java.util.List) r13
            if (r13 == 0) goto L62
            r17 = r13
            r18 = 0
            long r19 = r11.getId()
            r21 = r0
            java.lang.Long r0 = java.lang.Long.valueOf(r19)
            r19 = r1
            r1 = r25
            boolean r0 = r1.contains(r0)
            if (r0 != 0) goto L72
            r13 = 0
            goto L72
        L62:
            r21 = r0
            r19 = r1
            r1 = r25
            r13 = 0
            goto L72
        L6a:
            r15 = r24
            r21 = r0
            r19 = r1
            r1 = r25
        L72:
            if (r13 == 0) goto L8c
            r0 = r13
            r17 = 0
            r18 = r0
            java.util.Collection r18 = (java.util.Collection) r18
            boolean r18 = r18.isEmpty()
            if (r18 == 0) goto L82
            r13 = 0
        L82:
            if (r13 == 0) goto L8c
            r0 = 0
            kotlin.Pair r0 = kotlin.TuplesKt.to(r11, r13)
            r16 = r0
            goto L8e
        L8c:
            r16 = 0
        L8e:
            if (r16 == 0) goto L96
            r0 = r16
            r11 = 0
            r2.add(r0)
        L96:
            r1 = r19
            r0 = r21
            goto L14
        L9c:
            r21 = r0
            r0 = r2
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.StartScreen.groupGames$lambda$150$snapshot(java.util.List, java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentHashMap$KeySetView):java.util.List");
    }

    private final void heading(LinearLayout col, String text, String seeAll) {
        LinearLayout linearLayout = new LinearLayout(this.act);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(0, dp(20.0f), 0, dp(10.0f));
        linearLayout.addView(Ui.INSTANCE.text(this.act, text, 17.0f, Ui.INSTANCE.getTEXT(), true), Ui.INSTANCE.lp(0, -2, 1.0f));
        if (seeAll != null) {
            TextView text2 = Ui.INSTANCE.text(this.act, "See all  ›", 13.0f, getLinkColor(), true);
            text2.setPadding(dp(10.0f), dp(4.0f), dp(6.0f), dp(4.0f));
            text2.setBackground(Ui.INSTANCE.rippleBg(this.act, 0, 12.0f));
            text2.setOnClickListener(new StartScreen$$ExternalSyntheticLambda11(this, seeAll));
            linearLayout.addView(text2);
        }
        col.addView(linearLayout, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
    }

    static /* synthetic */ void heading$default(StartScreen startScreen, LinearLayout linearLayout, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        startScreen.heading(linearLayout, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void heading$lambda$43$lambda$42(StartScreen startScreen, String str, View view) {
        startScreen.show(str);
    }

    private final void home() {
        LinearLayout linearLayout;
        LinearLayout scrollColumn = scrollColumn();
        greeting(scrollColumn);
        heading$default(this, scrollColumn, "Start creating", null, 4, null);
        LinearLayout row = row(scrollColumn);
        Map mapOf = MapsKt.mapOf(TuplesKt.to(PlaceFactory.Template.BASEPLATE, TuplesKt.to(-11764775, "Part_Block")), TuplesKt.to(PlaceFactory.Template.CLASSIC, TuplesKt.to(-11625902, "Surface")), TuplesKt.to(PlaceFactory.Template.EMPTY, TuplesKt.to(-7704623, "Place")));
        PlaceFactory.Template[] values = PlaceFactory.Template.values();
        int i = 0;
        for (int length = values.length; i < length; length = length) {
            PlaceFactory.Template template = values[i];
            Pair pair = (Pair) mapOf.get(template);
            if (pair == null) {
                pair = TuplesKt.to(-9737365, "Place");
            }
            addToRow(row, card$default(this, template.getTitle(), template.getSubtitle(), null, (String) pair.component2(), new StartScreen$$ExternalSyntheticLambda42(this, template), null, Integer.valueOf(((Number) pair.component1()).intValue()), 32, null));
            i++;
        }
        heading(scrollColumn, RECENT, RECENT);
        List<Recents.Entry> recentEntries = recentEntries(12);
        if (recentEntries.isEmpty()) {
            linearLayout = scrollColumn;
            message$default(this, linearLayout, "Places and files you open show up here, so you can jump right back in.", null, null, null, 28, null);
        } else {
            linearLayout = scrollColumn;
            LinearLayout row2 = row(linearLayout);
            Iterator<Pair<Recents.Entry, LinearLayout>> it = recentCards(recentEntries).iterator();
            while (it.hasNext()) {
                addToRow(row2, it.next().component2());
            }
        }
        if (!RobloxApi.INSTANCE.isGuest(this.act)) {
            heading(linearLayout, MY_GAMES, MY_GAMES);
            LinearLayout linearLayout2 = new LinearLayout(this.act);
            linearLayout2.setOrientation(1);
            linearLayout.addView(linearLayout2, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
            List<RobloxCloud.Game> games = StartCache.INSTANCE.games(this.act, RobloxApi.INSTANCE.userId(this.act), Kind.MINE.getKey());
            if (games != null) {
                home$fill(linearLayout2, this, games);
            } else {
                this.net.execute(new StartScreen$$ExternalSyntheticLambda43(this, this.gen, linearLayout2, loading(linearLayout2)));
            }
        }
        tip(linearLayout);
    }

    private static final void home$fill(LinearLayout linearLayout, StartScreen startScreen, List<RobloxCloud.Game> list) {
        linearLayout.removeAllViews();
        if (list.isEmpty()) {
            message$default(startScreen, linearLayout, "You don't own any experiences yet. Make one here and publish it with File → Publish to Roblox As.", null, null, null, 28, null);
            return;
        }
        LinearLayout row = startScreen.row(linearLayout);
        Iterator it = CollectionsKt.take(list, 12).iterator();
        while (it.hasNext()) {
            startScreen.addToRow(row, gameCard$default(startScreen, (RobloxCloud.Game) it.next(), false, 2, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit home$lambda$74(StartScreen startScreen, PlaceFactory.Template template) {
        startScreen.host.newFromTemplate(template);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void home$lambda$77(StartScreen startScreen, int i, LinearLayout linearLayout, View view) {
        List<RobloxCloud.Game> list;
        try {
            list = startScreen.loadGames(Kind.MINE);
        } catch (Exception e) {
            list = null;
        }
        startScreen.main.post(new StartScreen$$ExternalSyntheticLambda20(i, startScreen, linearLayout, view, list));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void home$lambda$77$lambda$76(int i, StartScreen startScreen, LinearLayout linearLayout, View view, List list) {
        if (i == startScreen.gen) {
            linearLayout.removeView(view);
            if (list != null) {
                home$fill(linearLayout, startScreen, list);
            } else {
                message$default(startScreen, linearLayout, "Couldn't load your games right now. Open My Games to try again.", null, null, null, 28, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit imgListener$lambda$3(StartScreen startScreen, String k) {
        Intrinsics.checkNotNullParameter(k, "k");
        if (StringsKt.startsWith$default(k, "url:", false, 2, (Object) null)) {
            startScreen.main.post(new StartScreen$$ExternalSyntheticLambda2(startScreen, k));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void imgListener$lambda$3$lambda$2(StartScreen startScreen, String str) {
        List<ImageView> list = startScreen.iconViews.get(str);
        if (list != null) {
            for (ImageView imageView : list) {
                Bitmap peekKey = ImageLoader.INSTANCE.peekKey(str);
                if (peekKey != null) {
                    startScreen.showBitmap(imageView, peekKey);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$20$lambda$19(StartScreen startScreen, View view) {
        AccountUi.INSTANCE.show(startScreen.act, startScreen.studio, startScreen.actions);
    }

    private final List<RobloxCloud.Game> loadGames(Kind kind) {
        RobloxCloud.User cachedUser = RobloxCloud.INSTANCE.cachedUser(this.act);
        if (cachedUser == null) {
            cachedUser = RobloxCloud.INSTANCE.currentUser(this.act);
        }
        List<RobloxCloud.Game> userGames = kind == Kind.MINE ? RobloxCloud.INSTANCE.userGames(this.act, cachedUser) : RobloxCloud.INSTANCE.sharedGames(this.act, cachedUser);
        Map<Long, String> icons = StartCache.INSTANCE.getIcons();
        RobloxCloud robloxCloud = RobloxCloud.INSTANCE;
        List<RobloxCloud.Game> list = userGames;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((RobloxCloud.Game) it.next()).getUniverseId()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            RobloxCloud.User user = cachedUser;
            if (!StartCache.INSTANCE.getIcons().containsKey(Long.valueOf(((Number) obj).longValue()))) {
                arrayList2.add(obj);
            }
            cachedUser = user;
        }
        icons.putAll(robloxCloud.gameIcons(arrayList2));
        StartCache.INSTANCE.putGames(this.act, RobloxApi.INSTANCE.userId(this.act), userGames, kind.getKey());
        return userGames;
    }

    private final View loading(LinearLayout col) {
        ProgressBar progressBar = new ProgressBar(this.act);
        progressBar.setIndeterminate(true);
        LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, dp(36.0f), dp(36.0f), 0.0f, 4, null);
        lp$default.topMargin = dp(20.0f);
        lp$default.gravity = 1;
        Unit unit = Unit.INSTANCE;
        col.addView(progressBar, lp$default);
        return progressBar;
    }

    private final void message(LinearLayout col, String text, String button, String icon, Function0<Unit> onClick) {
        LinearLayout linearLayout = new LinearLayout(this.act);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(dp(16.0f), dp(14.0f), dp(16.0f), dp(14.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Ui.INSTANCE.getCARD());
        gradientDrawable.setCornerRadius(dp(12.0f));
        linearLayout.setBackground(gradientDrawable);
        TextView text$default = Ui.text$default(Ui.INSTANCE, this.act, text, 13.5f, Ui.INSTANCE.getTEXT(), false, 16, null);
        text$default.setSingleLine(false);
        text$default.setLineSpacing(dp(2.0f), 1.0f);
        linearLayout.addView(text$default);
        if (button != null && onClick != null) {
            TextView iconTextButton = Ui.INSTANCE.iconTextButton(this.act, Icons.general$default(Icons.INSTANCE, this.act, icon, null, 4, null), button, Ui.INSTANCE.getACCENT(), new StartScreen$$ExternalSyntheticLambda4(onClick));
            iconTextButton.setTextColor(-1);
            LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, -2, -2, 0.0f, 4, null);
            lp$default.topMargin = dp(10.0f);
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(iconTextButton, lp$default);
        }
        LinearLayout.LayoutParams lp$default2 = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
        lp$default2.topMargin = dp(6.0f);
        lp$default2.bottomMargin = dp(6.0f);
        Unit unit2 = Unit.INSTANCE;
        col.addView(linearLayout, lp$default2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void message$default(StartScreen startScreen, LinearLayout linearLayout, String str, String str2, String str3, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = "Account";
        }
        if ((i & 16) != 0) {
            function0 = null;
        }
        startScreen.message(linearLayout, str, str2, str3, function0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit message$lambda$55(Function0 function0, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function0.invoke();
        return Unit.INSTANCE;
    }

    private final void openRecent(Recents.Entry e) {
        if (!e.isCloud()) {
            this.host.openRecentFile(e);
        } else if (RobloxApi.INSTANCE.isGuest(this.act)) {
            AccountUi.INSTANCE.signIn(this.act, new StartScreen$$ExternalSyntheticLambda36(this, e));
        } else {
            AccountUi.INSTANCE.openPlace(this.act, this.actions, null, new RobloxCloud.Place(e.getPlaceId(), e.getName(), e.getUniverseId()), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit openRecent$lambda$115(StartScreen startScreen, Recents.Entry entry) {
        startScreen.openRecent(entry);
        return Unit.INSTANCE;
    }

    private final void pageHeader(LinearLayout col, String title, String sub, boolean search, Function0<Unit> onRefresh) {
        LinearLayout linearLayout = new LinearLayout(this.act);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(0, dp(12.0f), 0, dp(4.0f));
        LinearLayout linearLayout2 = new LinearLayout(this.act);
        linearLayout2.setOrientation(1);
        linearLayout2.addView(Ui.INSTANCE.text(this.act, title, 22.0f, Ui.INSTANCE.getTEXT(), true));
        TextView text$default = Ui.text$default(Ui.INSTANCE, this.act, sub, 12.5f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default.setSingleLine(false);
        text$default.setPadding(0, dp(2.0f), 0, 0);
        linearLayout2.addView(text$default);
        linearLayout.addView(linearLayout2, Ui.INSTANCE.lp(0, -2, 1.0f));
        if (onRefresh != null) {
            ImageView iconButton = Ui.INSTANCE.iconButton(this.act, Icons.general$default(Icons.INSTANCE, this.act, "PluginsFolder", null, 4, null), 36.0f, new StartScreen$$ExternalSyntheticLambda1(onRefresh));
            iconButton.setContentDescription("Refresh");
            linearLayout.addView(iconButton);
        }
        col.addView(linearLayout, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        if (search) {
            EditText input$default = Ui.input$default(Ui.INSTANCE, this.act, "", "Search", false, false, 24, null);
            Drawable general$default = Icons.general$default(Icons.INSTANCE, this.act, "FindAll", null, 4, null);
            general$default.setBounds(0, 0, dp(16.0f), dp(16.0f));
            input$default.setCompoundDrawables(general$default, null, null, null);
            input$default.setCompoundDrawablePadding(dp(8.0f));
            input$default.setPadding(dp(12.0f), dp(8.0f), dp(12.0f), dp(8.0f));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(Ui.INSTANCE.getINPUT());
            gradientDrawable.setStroke(dp(1.0f), Ui.INSTANCE.blend(Ui.INSTANCE.getINPUT(), Ui.INSTANCE.getTEXT(), 0.18f));
            gradientDrawable.setCornerRadius(dp(20.0f));
            input$default.setBackground(gradientDrawable);
            input$default.addTextChangedListener(new StartScreen$pageHeader$box$1$2(this));
            EditText editText = input$default;
            LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, this.phone ? -1 : dp(340.0f), -2, 0.0f, 4, null);
            lp$default.topMargin = dp(10.0f);
            lp$default.bottomMargin = dp(6.0f);
            Unit unit = Unit.INSTANCE;
            col.addView(editText, lp$default);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit pageHeader$lambda$47(Function0 function0, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function0.invoke();
        return Unit.INSTANCE;
    }

    private final void recent() {
        LinearLayout scrollColumn = scrollColumn();
        pageHeader(scrollColumn, RECENT, "Places and files you opened lately. Long-press one to remove it.", true, null);
        List<Recents.Entry> recentEntries = recentEntries(60);
        if (recentEntries.isEmpty()) {
            message$default(this, scrollColumn, "Places and files you open show up here.", null, null, null, 28, null);
            return;
        }
        FlowLayout grid = grid(scrollColumn);
        Iterator<T> it = recentCards(recentEntries).iterator();
        while (it.hasNext()) {
            grid.addView((View) ((Pair) it.next()).getSecond());
        }
    }

    private final List<Pair<Recents.Entry, LinearLayout>> recentCards(List<Recents.Entry> list) {
        List<Recents.Entry> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Recents.Entry entry : list2) {
            String str = (entry.isCloud() ? "Roblox place" : "On this device") + "  ·  " + ((Object) DateUtils.getRelativeTimeSpanString(entry.getTime()));
            String removeSuffix = StringsKt.removeSuffix(StringsKt.removeSuffix(entry.getName(), (CharSequence) ".rbxl"), (CharSequence) ".rbxlx");
            String str2 = StartCache.INSTANCE.getIcons().get(Long.valueOf(entry.getUniverseId()));
            if (!entry.isCloud()) {
                str2 = null;
            }
            arrayList.add(TuplesKt.to(entry, card$default(this, removeSuffix, str, str2, entry.isCloud() ? "Place" : "Open", new StartScreen$$ExternalSyntheticLambda33(this, entry), new StartScreen$$ExternalSyntheticLambda34(this, entry), null, 64, null)));
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : list) {
            Recents.Entry entry2 = (Recents.Entry) obj;
            if ((!entry2.isCloud() || entry2.getUniverseId() == 0 || StartCache.INSTANCE.getIcons().containsKey(Long.valueOf(entry2.getUniverseId()))) ? false : true) {
                arrayList3.add(obj);
            }
        }
        ArrayList arrayList4 = arrayList3;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
        Iterator it = arrayList4.iterator();
        while (it.hasNext()) {
            arrayList5.add(Long.valueOf(((Recents.Entry) it.next()).getUniverseId()));
        }
        List distinct = CollectionsKt.distinct(arrayList5);
        if (!distinct.isEmpty()) {
            this.net.execute(new StartScreen$$ExternalSyntheticLambda35(distinct, this, this.gen, arrayList2));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit recentCards$lambda$110$lambda$107(StartScreen startScreen, Recents.Entry entry) {
        startScreen.openRecent(entry);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit recentCards$lambda$110$lambda$109(StartScreen startScreen, Recents.Entry entry) {
        Dialogs.INSTANCE.themed(startScreen.act).setTitle(entry.getName()).setItems(new String[]{"Open", "Remove from Recent"}, new StartScreen$$ExternalSyntheticLambda0(startScreen, entry)).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void recentCards$lambda$110$lambda$109$lambda$108(StartScreen startScreen, Recents.Entry entry, DialogInterface dialogInterface, int i) {
        if (i == 0) {
            startScreen.openRecent(entry);
        } else {
            Recents.INSTANCE.remove(startScreen.act, entry);
            startScreen.show(startScreen.page);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void recentCards$lambda$114(List list, StartScreen startScreen, int i, List list2) {
        Map<Long, String> emptyMap;
        try {
            emptyMap = RobloxCloud.INSTANCE.gameIcons(list);
        } catch (Exception e) {
            emptyMap = MapsKt.emptyMap();
        }
        StartCache.INSTANCE.getIcons().putAll(emptyMap);
        startScreen.main.post(new StartScreen$$ExternalSyntheticLambda19(i, startScreen, list2, emptyMap));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void recentCards$lambda$114$lambda$113(int i, StartScreen startScreen, List list, Map map) {
        if (i != startScreen.gen) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            Recents.Entry entry = (Recents.Entry) pair.component1();
            LinearLayout linearLayout = (LinearLayout) pair.component2();
            String str = (String) map.get(Long.valueOf(entry.getUniverseId()));
            if (str != null) {
                View childAt = linearLayout.getChildAt(0);
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.FrameLayout");
                View childAt2 = ((FrameLayout) childAt).getChildAt(0);
                Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.widget.ImageView");
                startScreen.bindIcon((ImageView) childAt2, str, "Place");
            }
        }
    }

    private final List<Recents.Entry> recentEntries(int limit) {
        long userId = RobloxApi.INSTANCE.userId(this.act);
        List<Recents.Entry> list = Recents.INSTANCE.list(this.act);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            Recents.Entry entry = (Recents.Entry) obj;
            if (!entry.isCloud() || entry.getUserId() == 0 || entry.getUserId() == userId || RobloxApi.INSTANCE.isGuest(this.act)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.take(arrayList, limit);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x007d, code lost:
    
        if (r2 != null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void refreshAccount() {
        /*
            r12 = this;
            android.widget.LinearLayout r0 = r12.accountChip
            r0.removeAllViews()
            android.widget.ImageView r0 = new android.widget.ImageView
            android.app.Activity r1 = r12.act
            android.content.Context r1 = (android.content.Context) r1
            r0.<init>(r1)
            android.widget.LinearLayout r1 = r12.accountChip
            r2 = r0
            android.view.View r2 = (android.view.View) r2
            com.exampletest.mobilestudiotest.ui.Ui r3 = com.exampletest.mobilestudiotest.ui.Ui.INSTANCE
            r4 = 1104150528(0x41d00000, float:26.0)
            r5 = r4
            int r4 = r12.dp(r5)
            int r5 = r12.dp(r5)
            r7 = 4
            r8 = 0
            r6 = 0
            android.widget.LinearLayout$LayoutParams r3 = com.exampletest.mobilestudiotest.ui.Ui.lp$default(r3, r4, r5, r6, r7, r8)
            r4 = r3
            r5 = 0
            r6 = 1086324736(0x40c00000, float:6.0)
            int r6 = r12.dp(r6)
            r4.rightMargin = r6
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            android.view.ViewGroup$LayoutParams r3 = (android.view.ViewGroup.LayoutParams) r3
            r1.addView(r2, r3)
            com.exampletest.mobilestudiotest.net.Accounts r1 = com.exampletest.mobilestudiotest.net.Accounts.INSTANCE
            android.app.Activity r2 = r12.act
            android.content.Context r2 = (android.content.Context) r2
            com.exampletest.mobilestudiotest.net.Accounts$Account r1 = r1.active(r2)
            if (r1 == 0) goto L4e
            com.exampletest.mobilestudiotest.ui.AccountUi r2 = com.exampletest.mobilestudiotest.ui.AccountUi.INSTANCE
            long r3 = r1.getUserId()
            r2.loadHeadshot(r0, r3)
            goto L61
        L4e:
            com.exampletest.mobilestudiotest.ui.Icons r5 = com.exampletest.mobilestudiotest.ui.Icons.INSTANCE
            android.app.Activity r2 = r12.act
            r6 = r2
            android.content.Context r6 = (android.content.Context) r6
            r9 = 4
            r10 = 0
            java.lang.String r7 = "Account"
            r8 = 0
            android.graphics.drawable.Drawable r2 = com.exampletest.mobilestudiotest.ui.Icons.general$default(r5, r6, r7, r8, r9, r10)
            r0.setImageDrawable(r2)
        L61:
            if (r1 == 0) goto L80
            java.lang.String r2 = r1.getDisplayName()
            if (r2 == 0) goto L80
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r3 = r2.length()
            if (r3 != 0) goto L73
            r3 = 1
            goto L74
        L73:
            r3 = 0
        L74:
            if (r3 == 0) goto L7b
            r2 = 0
            java.lang.String r2 = r1.getName()
        L7b:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L80
            goto L82
        L80:
            java.lang.String r2 = "Guest"
        L82:
            android.widget.LinearLayout r3 = r12.accountChip
            com.exampletest.mobilestudiotest.ui.Ui r4 = com.exampletest.mobilestudiotest.ui.Ui.INSTANCE
            android.app.Activity r5 = r12.act
            android.content.Context r5 = (android.content.Context) r5
            boolean r6 = r12.phone
            if (r6 == 0) goto L95
            r6 = 10
            java.lang.String r6 = kotlin.text.StringsKt.take(r2, r6)
            goto L96
        L95:
            r6 = r2
        L96:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.StringBuilder r6 = r7.append(r6)
            java.lang.String r7 = "  ▾"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.exampletest.mobilestudiotest.ui.Ui r7 = com.exampletest.mobilestudiotest.ui.Ui.INSTANCE
            int r8 = r7.getTEXT()
            r10 = 16
            r11 = 0
            r7 = 1095761920(0x41500000, float:13.0)
            r9 = 0
            android.widget.TextView r4 = com.exampletest.mobilestudiotest.ui.Ui.text$default(r4, r5, r6, r7, r8, r9, r10, r11)
            android.view.View r4 = (android.view.View) r4
            r3.addView(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.StartScreen.refreshAccount():void");
    }

    private final LinearLayout row(LinearLayout col) {
        LinearLayout linearLayout = new LinearLayout(this.act);
        linearLayout.setOrientation(0);
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this.act);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.addView(linearLayout);
        col.addView(horizontalScrollView, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        return linearLayout;
    }

    private final LinearLayout scrollColumn() {
        LinearLayout linearLayout = new LinearLayout(this.act);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(dp(this.phone ? 14.0f : 22.0f), dp(10.0f), dp(this.phone ? 14.0f : 22.0f), dp(28.0f));
        FrameLayout frameLayout = this.content;
        ScrollView scrollView = new ScrollView(this.act);
        scrollView.addView(linearLayout);
        frameLayout.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
        return linearLayout;
    }

    private final void show(String p) {
        this.page = p;
        this.gen++;
        this.grids.clear();
        this.query = "";
        buildNav();
        this.content.removeAllViews();
        this.iconViews.clear();
        switch (p.hashCode()) {
            case -1851051397:
                if (p.equals(RECENT)) {
                    recent();
                    return;
                }
                return;
            case 2255103:
                if (p.equals(HOME)) {
                    home();
                    return;
                }
                return;
            case 925030816:
                if (p.equals(GROUPS)) {
                    groupGames();
                    return;
                }
                return;
            case 1411533463:
                if (p.equals(SHARED)) {
                    games(Kind.SHARED);
                    return;
                }
                return;
            case 2050873165:
                if (p.equals(MY_GAMES)) {
                    games(Kind.MINE);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void showBitmap(ImageView img, Bitmap b) {
        img.setPadding(0, 0, 0, 0);
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img.setImageBitmap(b);
    }

    private final void showGames(LinearLayout col, List<RobloxCloud.Game> list, String empty, boolean showOwner) {
        if (list.isEmpty()) {
            message$default(this, col, empty, null, null, null, 28, null);
            return;
        }
        FlowLayout grid = grid(col);
        Iterator<RobloxCloud.Game> it = list.iterator();
        while (it.hasNext()) {
            grid.addView(gameCard(it.next(), showOwner));
        }
    }

    static /* synthetic */ void showGames$default(StartScreen startScreen, LinearLayout linearLayout, List list, String str, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        startScreen.showGames(linearLayout, list, str, z);
    }

    private final void tip(LinearLayout col) {
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"Long-press an object in the Explorer to drag it into another parent or the Toolbox.", "File → Playtest Avatar lets you play as R6, R15, your own avatar or any model you save.", "Double-tap a panel's header to float it, or drag it to dock it on another side.", "Hold Ctrl or Shift (on a keyboard) and tap to select more than one part.", "Test → Play Here starts the playtest right where the camera is looking.", "The Toolbox's Creator Store tab can insert free models, meshes, audio and plugins."});
        LinearLayout linearLayout = new LinearLayout(this.act);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(dp(14.0f), dp(12.0f), dp(14.0f), dp(12.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Ui.INSTANCE.getCARD());
        gradientDrawable.setCornerRadius(dp(12.0f));
        linearLayout.setBackground(gradientDrawable);
        ImageView imageView = new ImageView(this.act);
        imageView.setImageDrawable(Icons.general$default(Icons.INSTANCE, this.act, "Info", null, 4, null));
        LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, dp(22.0f), dp(22.0f), 0.0f, 4, null);
        lp$default.rightMargin = dp(12.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(imageView, lp$default);
        TextView text$default = Ui.text$default(Ui.INSTANCE, this.act, "Tip: " + listOf.get((int) ((System.currentTimeMillis() / 60000) % listOf.size())), 12.5f, Ui.INSTANCE.getTEXT(), false, 16, null);
        text$default.setSingleLine(false);
        linearLayout.addView(text$default, Ui.INSTANCE.lp(0, -2, 1.0f));
        LinearLayout.LayoutParams lp$default2 = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
        lp$default2.topMargin = dp(24.0f);
        Unit unit2 = Unit.INSTANCE;
        col.addView(linearLayout, lp$default2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ImageLoader.INSTANCE.getListeners().add(this.imgListener);
        Accounts.INSTANCE.getListeners().add(this.accountListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ImageLoader.INSTANCE.getListeners().remove(this.imgListener);
        Accounts.INSTANCE.getListeners().remove(this.accountListener);
        this.gen++;
        this.net.shutdown();
        super.onDetachedFromWindow();
    }
}
