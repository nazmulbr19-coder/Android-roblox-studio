package com.exampletest.mobilestudiotest.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.exampletest.mobilestudiotest.audio.AudioEngine;
import com.exampletest.mobilestudiotest.net.RobloxApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;

/* compiled from: AudioBrowser.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0002VWB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\t\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010:\u001a\u00020\u0007H\u0014J\b\u0010;\u001a\u00020\u0007H\u0014J\u0010\u0010<\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020>H\u0002J6\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\u001a2\b\b\u0002\u0010B\u001a\u00020\u001a2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00070\u0005H\u0002J\b\u0010D\u001a\u00020\u0007H\u0002J\u0010\u0010E\u001a\u00020\u00182\u0006\u0010F\u001a\u00020\u0018H\u0002J2\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020$2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u0018002\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00070\u0005H\u0002J\u000e\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u0018J\b\u0010M\u001a\u00020\u0007H\u0002J\b\u0010N\u001a\u00020\u0007H\u0002J\b\u0010O\u001a\u00020$H\u0002J\b\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020\u0007H\u0002J\u0010\u0010S\u001a\u00020\u00182\u0006\u0010T\u001a\u00020\u001dH\u0002J\u0010\u0010U\u001a\u00020\u00182\u0006\u0010T\u001a\u00020>H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\t\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0013j\b\u0012\u0004\u0012\u00020\u0006`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00060\u0016R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180100X\u0082\u0004¢\u0006\u0002\n\u0000R.\u00102\u001a\"\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001d010100X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u001800X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\u001800X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u001800X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0004\n\u0002\u00108R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/AudioBrowser;", "Landroid/widget/LinearLayout;", "ctx", "Landroid/content/Context;", "onInsert", "Lkotlin/Function1;", "Lcom/exampletest/mobilestudiotest/net/RobloxApi$AudioItem;", "", "needSignIn", "Lkotlin/Function0;", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "net", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "content", "Landroid/widget/FrameLayout;", "filterBar", "items", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "adapter", "Lcom/exampletest/mobilestudiotest/ui/AudioBrowser$Adapter;", "token", "", "loading", "", "ended", "gen", "", "useLegacy", NotificationCompat.CATEGORY_STATUS, "Landroid/widget/TextView;", "progress", "Landroid/widget/ProgressBar;", "results", "Landroid/view/View;", "value", "keyword", "getKeyword", "()Ljava/lang/String;", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "sort", "lengthIdx", "tag", "chart", "discover", "sorts", "", "Lkotlin/Pair;", "lengths", "genres", "vibes", "sfx", "draggingId", "", "Ljava/lang/Long;", "previewListener", "onAttachedToWindow", "onDetachedFromWindow", "dp", "v", "", "chip", "label", DebugKt.DEBUG_PROPERTY_VALUE_ON, "dropdown", "onClick", "buildFilters", "chartLabel", "c", "menu", "anchor", "labels", "pick", "search", "q", "showDiscover", "showResults", "buildResults", "query", "Lcom/exampletest/mobilestudiotest/net/RobloxApi$AudioQuery;", "loadMore", "fmtTime", "sec", "fmtClock", "VH", "Adapter", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AudioBrowser extends LinearLayout {
    private final Adapter adapter;
    private String chart;
    private final FrameLayout content;
    private boolean discover;
    private Long draggingId;
    private boolean ended;
    private final LinearLayout filterBar;
    private int gen;
    private final List<String> genres;
    private final ArrayList<RobloxApi.AudioItem> items;
    private String keyword;
    private int lengthIdx;
    private final List<Pair<String, Pair<Integer, Integer>>> lengths;
    private boolean loading;
    private final Function1<Function0<Unit>, Unit> needSignIn;
    private final ExecutorService net;
    private final Function1<RobloxApi.AudioItem, Unit> onInsert;
    private final Function0<Unit> previewListener;
    private ProgressBar progress;
    private View results;
    private final List<String> sfx;
    private String sort;
    private final List<Pair<String, String>> sorts;
    private TextView status;
    private String tag;
    private String token;
    private String type;
    private boolean useLegacy;
    private final List<String> vibes;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AudioBrowser.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/AudioBrowser$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/exampletest/mobilestudiotest/ui/AudioBrowser$VH;", "Lcom/exampletest/mobilestudiotest/ui/AudioBrowser;", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/AudioBrowser;)V", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "h", "position", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class Adapter extends RecyclerView.Adapter<VH> {
        public Adapter() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void onBindViewHolder$lambda$18(AudioBrowser audioBrowser, RobloxApi.AudioItem audioItem, View view) {
            AudioBrowser.access$getNeedSignIn$p(audioBrowser).invoke(new AudioBrowser$Adapter$$ExternalSyntheticLambda2(audioItem));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit onBindViewHolder$lambda$18$lambda$17(RobloxApi.AudioItem audioItem) {
            AudioEngine.togglePreview$default(AudioEngine.INSTANCE, audioItem.getId(), 0.0f, 2, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void onBindViewHolder$lambda$19(AudioBrowser audioBrowser, RobloxApi.AudioItem audioItem, View view) {
            AudioBrowser.access$getOnInsert$p(audioBrowser).invoke(audioItem);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void onBindViewHolder$lambda$21(AudioBrowser audioBrowser, RobloxApi.AudioItem audioItem, View view) {
            AudioBrowser.access$getNeedSignIn$p(audioBrowser).invoke(new AudioBrowser$Adapter$$ExternalSyntheticLambda0(audioItem));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit onBindViewHolder$lambda$21$lambda$20(RobloxApi.AudioItem audioItem) {
            AudioEngine.togglePreview$default(AudioEngine.INSTANCE, audioItem.getId(), 0.0f, 2, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final boolean onBindViewHolder$lambda$26(AudioBrowser audioBrowser, String str, String str2, String str3, RobloxApi.AudioItem audioItem, View view) {
            Dialogs dialogs = Dialogs.INSTANCE;
            Context context = audioBrowser.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            AlertDialog.Builder title = dialogs.themed(context).setTitle(str);
            String str4 = str2;
            if (StringsKt.isBlank(str4)) {
                str4 = "Unknown";
            }
            String str5 = str3;
            if (StringsKt.isBlank(str5)) {
                str5 = "Audio";
            }
            String access$fmtTime = AudioBrowser.access$fmtTime(audioBrowser, audioItem.getSeconds());
            if (access$fmtTime.length() == 0) {
                access$fmtTime = "?";
            }
            title.setMessage("Artist: " + ((Object) str4) + "\nType: " + ((Object) str5) + "\nLength: " + ((Object) access$fmtTime) + "\nCreator: " + audioItem.getCreator() + (audioItem.getVerified() ? " (verified)" : "") + "\nAsset ID: " + audioItem.getId()).setPositiveButton("Insert", new AudioBrowser$Adapter$$ExternalSyntheticLambda7(audioBrowser, audioItem)).setNegativeButton("Close", (DialogInterface.OnClickListener) null).show();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void onBindViewHolder$lambda$26$lambda$25(AudioBrowser audioBrowser, RobloxApi.AudioItem audioItem, DialogInterface dialogInterface, int i) {
            AudioBrowser.access$getOnInsert$p(audioBrowser).invoke(audioItem);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit onCreateViewHolder$lambda$8(View it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return AudioBrowser.access$getItems$p(AudioBrowser.this).size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(VH vh, int i) {
            onBindViewHolder2(vh, i);
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0122  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0141  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x01f9  */
        /* renamed from: onBindViewHolder, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder2(com.exampletest.mobilestudiotest.ui.AudioBrowser.VH r27, int r28) {
            /*
                Method dump skipped, instructions count: 590
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.AudioBrowser.Adapter.onBindViewHolder2(com.exampletest.mobilestudiotest.ui.AudioBrowser$VH, int):void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ VH onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder2(viewGroup, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: onCreateViewHolder, reason: avoid collision after fix types in other method */
        public VH onCreateViewHolder2(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Context context = parent.getContext();
            LinearLayout linearLayout = new LinearLayout(context);
            AudioBrowser audioBrowser = AudioBrowser.this;
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            linearLayout.setPadding(AudioBrowser.access$dp(audioBrowser, 8.0f), AudioBrowser.access$dp(audioBrowser, 6.0f), AudioBrowser.access$dp(audioBrowser, 8.0f), AudioBrowser.access$dp(audioBrowser, 4.0f));
            Ui ui = Ui.INSTANCE;
            Intrinsics.checkNotNull(context);
            linearLayout.setBackground(ui.rippleBg(context, Ui.INSTANCE.getPANEL(), 0.0f));
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(16);
            PlayGlyph playGlyph = new PlayGlyph(false, false, 2, null);
            ImageView imageView = new ImageView(context);
            AudioBrowser audioBrowser2 = AudioBrowser.this;
            imageView.setImageDrawable(playGlyph);
            imageView.setPadding(AudioBrowser.access$dp(audioBrowser2, 2.0f), AudioBrowser.access$dp(audioBrowser2, 2.0f), AudioBrowser.access$dp(audioBrowser2, 2.0f), AudioBrowser.access$dp(audioBrowser2, 2.0f));
            LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, AudioBrowser.access$dp(AudioBrowser.this, 34.0f), AudioBrowser.access$dp(AudioBrowser.this, 34.0f), 0.0f, 4, null);
            lp$default.rightMargin = AudioBrowser.access$dp(AudioBrowser.this, 10.0f);
            Unit unit = Unit.INSTANCE;
            linearLayout2.addView(imageView, lp$default);
            LinearLayout linearLayout3 = new LinearLayout(context);
            linearLayout3.setOrientation(1);
            TextView text = Ui.INSTANCE.text(context, "", 13.0f, Ui.INSTANCE.getTEXT(), true);
            text.setEllipsize(TextUtils.TruncateAt.END);
            TextView text$default = Ui.text$default(Ui.INSTANCE, context, "", 11.0f, Ui.INSTANCE.getDIM(), false, 16, null);
            text$default.setEllipsize(TextUtils.TruncateAt.END);
            linearLayout3.addView(text);
            linearLayout3.addView(text$default);
            linearLayout2.addView(linearLayout3, Ui.INSTANCE.lp(0, -2, 1.0f));
            TextView text$default2 = Ui.text$default(Ui.INSTANCE, context, "", 11.0f, Ui.INSTANCE.getDIM(), false, 16, null);
            AudioBrowser audioBrowser3 = AudioBrowser.this;
            text$default2.setPadding(AudioBrowser.access$dp(audioBrowser3, 6.0f), 0, AudioBrowser.access$dp(audioBrowser3, 6.0f), 0);
            linearLayout2.addView(text$default2);
            TextView button = Ui.INSTANCE.button(context, "Insert", Ui.INSTANCE.getACCENT(), new AudioBrowser$Adapter$$ExternalSyntheticLambda1());
            AudioBrowser audioBrowser4 = AudioBrowser.this;
            button.setTextColor(-1);
            button.setTextSize(12.0f);
            button.setPadding(AudioBrowser.access$dp(audioBrowser4, 10.0f), AudioBrowser.access$dp(audioBrowser4, 4.0f), AudioBrowser.access$dp(audioBrowser4, 10.0f), AudioBrowser.access$dp(audioBrowser4, 4.0f));
            linearLayout2.addView(button);
            linearLayout.addView(linearLayout2, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
            LinearLayout linearLayout4 = new LinearLayout(context);
            linearLayout4.setOrientation(0);
            linearLayout4.setGravity(16);
            linearLayout4.setVisibility(8);
            TextView text$default3 = Ui.text$default(Ui.INSTANCE, context, "0:00", 11.0f, Ui.INSTANCE.getDIM(), false, 16, null);
            text$default3.setGravity(GravityCompat.END);
            SeekBar seekBar = new SeekBar(context);
            AudioBrowser audioBrowser5 = AudioBrowser.this;
            seekBar.setMax(1000);
            seekBar.setProgressTintList(ColorStateList.valueOf(Ui.INSTANCE.getACCENT()));
            seekBar.setThumbTintList(ColorStateList.valueOf(Ui.INSTANCE.getACCENT()));
            seekBar.setPadding(AudioBrowser.access$dp(audioBrowser5, 12.0f), 0, AudioBrowser.access$dp(audioBrowser5, 12.0f), 0);
            TextView text$default4 = Ui.text$default(Ui.INSTANCE, context, "", 11.0f, Ui.INSTANCE.getDIM(), false, 16, null);
            linearLayout4.addView(text$default3, Ui.lp$default(Ui.INSTANCE, AudioBrowser.access$dp(AudioBrowser.this, 38.0f), -2, 0.0f, 4, null));
            linearLayout4.addView(seekBar, Ui.INSTANCE.lp(0, AudioBrowser.access$dp(AudioBrowser.this, 30.0f), 1.0f));
            linearLayout4.addView(text$default4, Ui.lp$default(Ui.INSTANCE, AudioBrowser.access$dp(AudioBrowser.this, 38.0f), -2, 0.0f, 4, null));
            LinearLayout.LayoutParams lp$default2 = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
            AudioBrowser audioBrowser6 = AudioBrowser.this;
            lp$default2.topMargin = AudioBrowser.access$dp(audioBrowser6, 2.0f);
            lp$default2.leftMargin = AudioBrowser.access$dp(audioBrowser6, 36.0f);
            Unit unit2 = Unit.INSTANCE;
            linearLayout.addView(linearLayout4, lp$default2);
            return new VH(AudioBrowser.this, linearLayout, imageView, playGlyph, text, text$default, text$default2, linearLayout4, seekBar, text$default3, text$default4, button);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AudioBrowser.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0082\u0004\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001b¨\u0006$"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/AudioBrowser$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "row", "Landroid/widget/LinearLayout;", "play", "Landroid/widget/ImageView;", "glyph", "Lcom/exampletest/mobilestudiotest/ui/PlayGlyph;", "title", "Landroid/widget/TextView;", "sub", "dur", "seekRow", "seek", "Landroid/widget/SeekBar;", "elapsed", "total", "insert", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/AudioBrowser;Landroid/widget/LinearLayout;Landroid/widget/ImageView;Lcom/exampletest/mobilestudiotest/ui/PlayGlyph;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/LinearLayout;Landroid/widget/SeekBar;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;)V", "getRow", "()Landroid/widget/LinearLayout;", "getPlay", "()Landroid/widget/ImageView;", "getGlyph", "()Lcom/exampletest/mobilestudiotest/ui/PlayGlyph;", "getTitle", "()Landroid/widget/TextView;", "getSub", "getDur", "getSeekRow", "getSeek", "()Landroid/widget/SeekBar;", "getElapsed", "getTotal", "getInsert", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class VH extends RecyclerView.ViewHolder {
        private final TextView dur;
        private final TextView elapsed;
        private final PlayGlyph glyph;
        private final TextView insert;
        private final ImageView play;
        private final LinearLayout row;
        private final SeekBar seek;
        private final LinearLayout seekRow;
        private final TextView sub;
        final /* synthetic */ AudioBrowser this$0;
        private final TextView title;
        private final TextView total;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VH(AudioBrowser audioBrowser, LinearLayout row, ImageView play, PlayGlyph glyph, TextView title, TextView sub, TextView dur, LinearLayout seekRow, SeekBar seek, TextView elapsed, TextView total, TextView insert) {
            super(row);
            Intrinsics.checkNotNullParameter(row, "row");
            Intrinsics.checkNotNullParameter(play, "play");
            Intrinsics.checkNotNullParameter(glyph, "glyph");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(sub, "sub");
            Intrinsics.checkNotNullParameter(dur, "dur");
            Intrinsics.checkNotNullParameter(seekRow, "seekRow");
            Intrinsics.checkNotNullParameter(seek, "seek");
            Intrinsics.checkNotNullParameter(elapsed, "elapsed");
            Intrinsics.checkNotNullParameter(total, "total");
            Intrinsics.checkNotNullParameter(insert, "insert");
            this.this$0 = audioBrowser;
            this.row = row;
            this.play = play;
            this.glyph = glyph;
            this.title = title;
            this.sub = sub;
            this.dur = dur;
            this.seekRow = seekRow;
            this.seek = seek;
            this.elapsed = elapsed;
            this.total = total;
            this.insert = insert;
        }

        public final TextView getDur() {
            return this.dur;
        }

        public final TextView getElapsed() {
            return this.elapsed;
        }

        public final PlayGlyph getGlyph() {
            return this.glyph;
        }

        public final TextView getInsert() {
            return this.insert;
        }

        public final ImageView getPlay() {
            return this.play;
        }

        public final LinearLayout getRow() {
            return this.row;
        }

        public final SeekBar getSeek() {
            return this.seek;
        }

        public final LinearLayout getSeekRow() {
            return this.seekRow;
        }

        public final TextView getSub() {
            return this.sub;
        }

        public final TextView getTitle() {
            return this.title;
        }

        public final TextView getTotal() {
            return this.total;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AudioBrowser(Context ctx, Function1<? super RobloxApi.AudioItem, Unit> onInsert, Function1<? super Function0<Unit>, Unit> needSignIn) {
        super(ctx);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(onInsert, "onInsert");
        Intrinsics.checkNotNullParameter(needSignIn, "needSignIn");
        this.onInsert = onInsert;
        this.needSignIn = needSignIn;
        this.net = Executors.newSingleThreadExecutor();
        this.content = new FrameLayout(ctx);
        LinearLayout linearLayout = new LinearLayout(ctx);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        this.filterBar = linearLayout;
        this.items = new ArrayList<>();
        this.adapter = new Adapter();
        this.keyword = "";
        this.sort = "Relevance";
        this.chart = "None";
        this.discover = true;
        this.sorts = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("Relevance", "Relevance"), TuplesKt.to("Trending", "Trending"), TuplesKt.to("Top", "Top rated"), TuplesKt.to("UpdatedTime", "Most recent"), TuplesKt.to("AudioDuration", "Length")});
        this.lengths = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("Any length", TuplesKt.to(0, null)), TuplesKt.to("Under 10s", TuplesKt.to(0, 10)), TuplesKt.to("10s – 1 min", TuplesKt.to(10, 60)), TuplesKt.to("1 – 3 min", TuplesKt.to(60, 180)), TuplesKt.to("Over 3 min", TuplesKt.to(180, null))});
        this.genres = CollectionsKt.listOf((Object[]) new String[]{"Ambient", "Classical", "Country", "Electronic", "Funk", "Hip Hop", "Jazz", "Latin", "Lo-fi", "Metal", "Orchestral", "Pop", "R&B", "Reggae", "Rock", "Synthwave", "World"});
        this.vibes = CollectionsKt.listOf((Object[]) new String[]{"Calm", "Chill", "Dark", "Epic", "Funny", "Happy", "Intense", "Mysterious", "Romantic", "Sad", "Scary", "Upbeat"});
        this.sfx = CollectionsKt.listOf((Object[]) new String[]{"UI", "Footsteps", "Explosions", "Weapons", "Impacts", "Whooshes", "Magic", "Nature", "Ambience", "Vehicles", "Animals", "Voices", "Sci-fi", "Horror", "Cartoon", "Water", "Fire", "Doors", "Coins", "Alarms"});
        this.previewListener = new AudioBrowser$$ExternalSyntheticLambda0(this);
        setOrientation(1);
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(ctx);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.addView(this.filterBar);
        addView(horizontalScrollView, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        addView(this.content, Ui.INSTANCE.lp(-1, 0, 1.0f));
        showDiscover();
    }

    public static final /* synthetic */ int access$dp(AudioBrowser audioBrowser, float f) {
        return audioBrowser.dp(f);
    }

    public static final /* synthetic */ String access$fmtClock(AudioBrowser audioBrowser, float f) {
        return audioBrowser.fmtClock(f);
    }

    public static final /* synthetic */ String access$fmtTime(AudioBrowser audioBrowser, int i) {
        return audioBrowser.fmtTime(i);
    }

    public static final /* synthetic */ Long access$getDraggingId$p(AudioBrowser audioBrowser) {
        return audioBrowser.draggingId;
    }

    public static final /* synthetic */ ArrayList access$getItems$p(AudioBrowser audioBrowser) {
        return audioBrowser.items;
    }

    public static final /* synthetic */ Function1 access$getNeedSignIn$p(AudioBrowser audioBrowser) {
        return audioBrowser.needSignIn;
    }

    public static final /* synthetic */ Function1 access$getOnInsert$p(AudioBrowser audioBrowser) {
        return audioBrowser.onInsert;
    }

    public static final /* synthetic */ void access$loadMore(AudioBrowser audioBrowser) {
        audioBrowser.loadMore();
    }

    public static final /* synthetic */ void access$setDraggingId$p(AudioBrowser audioBrowser, Long l) {
        audioBrowser.draggingId = l;
    }

    private final void buildFilters() {
        this.filterBar.removeAllViews();
        this.filterBar.setPadding(dp(6.0f), dp(4.0f), dp(6.0f), dp(4.0f));
        buildFilters$add(this, chip$default(this, "Discover", this.discover, false, new AudioBrowser$$ExternalSyntheticLambda6(this), 4, null));
        String str = this.type;
        buildFilters$add(this, chip(Intrinsics.areEqual(str, "Music") ? "Music" : Intrinsics.areEqual(str, "SoundEffect") ? "Sound Effects" : "Type", this.type != null, true, new AudioBrowser$$ExternalSyntheticLambda7(this)));
        for (Object obj : this.sorts) {
            if (Intrinsics.areEqual(((Pair) obj).getFirst(), this.sort)) {
                buildFilters$add(this, chip("Sort: " + ((Pair) obj).getSecond(), !Intrinsics.areEqual(this.sort, "Relevance"), true, new AudioBrowser$$ExternalSyntheticLambda8(this)));
                buildFilters$add(this, chip(this.lengths.get(this.lengthIdx).getFirst(), this.lengthIdx != 0, true, new AudioBrowser$$ExternalSyntheticLambda9(this)));
                String str2 = this.tag;
                if (str2 != null) {
                    buildFilters$add(this, chip$default(this, str2 + "  ✕", true, false, new AudioBrowser$$ExternalSyntheticLambda10(this), 4, null));
                }
                if (Intrinsics.areEqual(this.chart, "None")) {
                    return;
                }
                buildFilters$add(this, chip$default(this, "Top charts: " + chartLabel(this.chart) + "  ✕", true, false, new AudioBrowser$$ExternalSyntheticLambda11(this), 4, null));
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private static final void buildFilters$add(AudioBrowser audioBrowser, View view) {
        LinearLayout linearLayout = audioBrowser.filterBar;
        LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, -2, -2, 0.0f, 4, null);
        lp$default.rightMargin = audioBrowser.dp(6.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(view, lp$default);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildFilters$lambda$10(AudioBrowser audioBrowser, View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        audioBrowser.menu(v, CollectionsKt.listOf((Object[]) new String[]{"All audio", "Music", "Sound Effects"}), new AudioBrowser$$ExternalSyntheticLambda13(audioBrowser));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildFilters$lambda$10$lambda$9(AudioBrowser audioBrowser, int i) {
        String str;
        switch (i) {
            case 1:
                str = "Music";
                break;
            case 2:
                str = "SoundEffect";
                break;
            default:
                str = null;
                break;
        }
        audioBrowser.type = str;
        audioBrowser.showResults();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildFilters$lambda$14(AudioBrowser audioBrowser, View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        List<Pair<String, String>> list = audioBrowser.sorts;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Pair) it.next()).getSecond());
        }
        audioBrowser.menu(v, arrayList, new AudioBrowser$$ExternalSyntheticLambda22(audioBrowser));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildFilters$lambda$14$lambda$13(AudioBrowser audioBrowser, int i) {
        audioBrowser.sort = audioBrowser.sorts.get(i).getFirst();
        audioBrowser.showResults();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildFilters$lambda$17(AudioBrowser audioBrowser, View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        List<Pair<String, Pair<Integer, Integer>>> list = audioBrowser.lengths;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Pair) it.next()).getFirst());
        }
        audioBrowser.menu(v, arrayList, new AudioBrowser$$ExternalSyntheticLambda12(audioBrowser));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildFilters$lambda$17$lambda$16(AudioBrowser audioBrowser, int i) {
        audioBrowser.lengthIdx = i;
        audioBrowser.showResults();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildFilters$lambda$19$lambda$18(AudioBrowser audioBrowser, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        audioBrowser.tag = null;
        if (StringsKt.isBlank(audioBrowser.keyword) && Intrinsics.areEqual(audioBrowser.chart, "None")) {
            audioBrowser.showDiscover();
        } else {
            audioBrowser.showResults();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildFilters$lambda$20(AudioBrowser audioBrowser, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        audioBrowser.chart = "None";
        if (StringsKt.isBlank(audioBrowser.keyword) && audioBrowser.tag == null) {
            audioBrowser.showDiscover();
        } else {
            audioBrowser.showResults();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildFilters$lambda$8(AudioBrowser audioBrowser, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        audioBrowser.tag = null;
        audioBrowser.chart = "None";
        audioBrowser.keyword = "";
        audioBrowser.showDiscover();
        return Unit.INSTANCE;
    }

    private final View buildResults() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        RecyclerView recyclerView = new RecyclerView(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(this.adapter);
        TextView textView = null;
        recyclerView.setItemAnimator(null);
        recyclerView.addOnScrollListener(new AudioBrowser$buildResults$1(linearLayoutManager, this));
        frameLayout.addView(recyclerView, new FrameLayout.LayoutParams(-1, -1));
        ProgressBar progressBar = new ProgressBar(getContext());
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(8);
        this.progress = progressBar;
        ProgressBar progressBar2 = this.progress;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progress");
            progressBar2 = null;
        }
        frameLayout.addView(progressBar2, new FrameLayout.LayoutParams(dp(34.0f), dp(34.0f), 17));
        Ui ui = Ui.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        TextView text$default = Ui.text$default(ui, context, "", 12.0f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default.setSingleLine(false);
        text$default.setGravity(17);
        text$default.setPadding(dp(16.0f), 0, dp(16.0f), 0);
        this.status = text$default;
        TextView textView2 = this.status;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_STATUS);
        } else {
            textView = textView2;
        }
        frameLayout.addView(textView, new FrameLayout.LayoutParams(-1, -2, 17));
        return frameLayout;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
    private final String chartLabel(String c) {
        switch (c.hashCode()) {
            case -1503373991:
                if (c.equals("Current")) {
                    return "Now";
                }
                return c;
            case 2692116:
                if (c.equals("Week")) {
                    return "This week";
                }
                return c;
            case 2751581:
                if (c.equals("Year")) {
                    return "This year";
                }
                return c;
            case 74527328:
                if (c.equals("Month")) {
                    return "This month";
                }
                return c;
            default:
                return c;
        }
    }

    private final TextView chip(String label, boolean on, boolean dropdown, Function1<? super View, Unit> onClick) {
        int blend;
        Ui ui = Ui.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        TextView text$default = Ui.text$default(ui, context, label + (dropdown ? "  ▾" : ""), 12.0f, on ? -1 : Ui.INSTANCE.getTEXT(), false, 16, null);
        text$default.setPadding(dp(11.0f), dp(5.0f), dp(11.0f), dp(5.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        Ui ui2 = Ui.INSTANCE;
        if (on) {
            blend = ui2.getACCENT();
        } else {
            blend = ui2.blend(Ui.INSTANCE.getPANEL(), Ui.INSTANCE.getLIGHT() ? -16777216 : -1, 0.08f);
        }
        gradientDrawable.setColor(blend);
        gradientDrawable.setCornerRadius(dp(14.0f));
        if (!on) {
            gradientDrawable.setStroke(dp(1.0f), Ui.INSTANCE.blend(Ui.INSTANCE.getPANEL(), Ui.INSTANCE.getLIGHT() ? -16777216 : -1, 0.18f));
        }
        text$default.setBackground(gradientDrawable);
        text$default.setOnClickListener(new AudioBrowser$$ExternalSyntheticLambda14(onClick));
        return text$default;
    }

    static /* synthetic */ TextView chip$default(AudioBrowser audioBrowser, String str, boolean z, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return audioBrowser.chip(str, z, z2, function1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void chip$lambda$6$lambda$5(Function1 function1, View view) {
        function1.invoke(view);
    }

    private final int dp(float v) {
        Ui ui = Ui.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return ui.dp(context, v);
    }

    private final String fmtClock(float sec) {
        int coerceAtLeast = RangesKt.coerceAtLeast((int) sec, 0);
        String format = String.format("%d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(coerceAtLeast / 60), Integer.valueOf(coerceAtLeast % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private final String fmtTime(int sec) {
        if (sec <= 0) {
            return "";
        }
        String format = String.format("%d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(sec / 60), Integer.valueOf(sec % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private final void loadMore() {
        if (this.loading || this.ended) {
            return;
        }
        this.loading = true;
        int i = this.gen;
        RobloxApi.AudioQuery query = query();
        String str = this.token;
        ProgressBar progressBar = this.progress;
        TextView textView = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progress");
            progressBar = null;
        }
        progressBar.setVisibility(this.items.isEmpty() ? 0 : 8);
        TextView textView2 = this.status;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_STATUS);
        } else {
            textView = textView2;
        }
        textView.setText("");
        this.net.execute(new AudioBrowser$$ExternalSyntheticLambda4(this, query, str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v3, types: [T, com.exampletest.mobilestudiotest.net.RobloxApi$AudioPage] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void loadMore$lambda$46(com.exampletest.mobilestudiotest.ui.AudioBrowser r10, com.exampletest.mobilestudiotest.net.RobloxApi.AudioQuery r11, java.lang.String r12, int r13) {
        /*
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r1 = r0
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r2 = r0
            boolean r0 = r10.useLegacy     // Catch: java.lang.Exception -> L37
            if (r0 == 0) goto L22
            com.exampletest.mobilestudiotest.net.RobloxApi r0 = com.exampletest.mobilestudiotest.net.RobloxApi.INSTANCE     // Catch: java.lang.Exception -> L1e
            java.lang.String r3 = r11.getKeyword()     // Catch: java.lang.Exception -> L1e
            com.exampletest.mobilestudiotest.net.RobloxApi$AudioPage r0 = r0.searchAudioLegacy(r3, r12)     // Catch: java.lang.Exception -> L1e
            r5 = r11
            r6 = r12
            goto L32
        L1e:
            r0 = move-exception
            r5 = r11
            r6 = r12
            goto L3a
        L22:
            com.exampletest.mobilestudiotest.net.RobloxApi r3 = com.exampletest.mobilestudiotest.net.RobloxApi.INSTANCE     // Catch: java.lang.Exception -> L37
            android.content.Context r4 = r10.getContext()     // Catch: java.lang.Exception -> L37
            r8 = 8
            r9 = 0
            r7 = 0
            r5 = r11
            r6 = r12
            com.exampletest.mobilestudiotest.net.RobloxApi$AudioPage r0 = com.exampletest.mobilestudiotest.net.RobloxApi.searchAudio$default(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L35
        L32:
            r1.element = r0     // Catch: java.lang.Exception -> L35
            goto L52
        L35:
            r0 = move-exception
            goto L3a
        L37:
            r0 = move-exception
            r5 = r11
            r6 = r12
        L3a:
            r11 = r0
            r2.element = r11
            boolean r12 = r10.useLegacy
            if (r12 != 0) goto L52
            com.exampletest.mobilestudiotest.net.RobloxApi r12 = com.exampletest.mobilestudiotest.net.RobloxApi.INSTANCE     // Catch: java.lang.Exception -> L51
            java.lang.String r0 = r5.getKeyword()     // Catch: java.lang.Exception -> L51
            com.exampletest.mobilestudiotest.net.RobloxApi$AudioPage r12 = r12.searchAudioLegacy(r0, r6)     // Catch: java.lang.Exception -> L51
            r1.element = r12     // Catch: java.lang.Exception -> L51
            r12 = 1
            r10.useLegacy = r12     // Catch: java.lang.Exception -> L51
            goto L52
        L51:
            r0 = move-exception
        L52:
            com.exampletest.mobilestudiotest.ui.AudioBrowser$$ExternalSyntheticLambda5 r11 = new com.exampletest.mobilestudiotest.ui.AudioBrowser$$ExternalSyntheticLambda5
            r11.<init>(r13, r10, r1, r2)
            r10.post(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.AudioBrowser.loadMore$lambda$46(com.exampletest.mobilestudiotest.ui.AudioBrowser, com.exampletest.mobilestudiotest.net.RobloxApi$AudioQuery, java.lang.String, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void loadMore$lambda$46$lambda$45(int i, AudioBrowser audioBrowser, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
        String str;
        String message;
        if (i != audioBrowser.gen) {
            return;
        }
        TextView textView = null;
        if (objectRef.element == 0) {
            audioBrowser.loading = false;
            ProgressBar progressBar = audioBrowser.progress;
            if (progressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progress");
                progressBar = null;
            }
            progressBar.setVisibility(8);
            if (audioBrowser.items.isEmpty()) {
                TextView textView2 = audioBrowser.status;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_STATUS);
                } else {
                    textView = textView2;
                }
                Exception exc = (Exception) objectRef2.element;
                if (exc != null && (message = exc.getMessage()) != null) {
                    str = message;
                }
                textView.setText("Couldn't reach the Creator Store.\n" + str);
                return;
            }
            return;
        }
        T t = objectRef.element;
        Intrinsics.checkNotNull(t);
        RobloxApi.AudioPage audioPage = (RobloxApi.AudioPage) t;
        int size = audioBrowser.items.size();
        audioBrowser.items.addAll(audioPage.getItems());
        audioBrowser.adapter.notifyItemRangeInserted(size, audioPage.getItems().size());
        audioBrowser.token = audioPage.getNextToken();
        audioBrowser.ended = audioPage.getNextToken() == null || audioPage.getItems().isEmpty();
        audioBrowser.loading = false;
        ProgressBar progressBar2 = audioBrowser.progress;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progress");
            progressBar2 = null;
        }
        progressBar2.setVisibility(8);
        if (audioBrowser.items.isEmpty()) {
            TextView textView3 = audioBrowser.status;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_STATUS);
            } else {
                textView = textView3;
            }
            textView.setText("No audio found." + ((audioBrowser.lengthIdx == 0 && audioBrowser.type == null) ? "" : "\nTry removing a filter."));
        }
    }

    private final void menu(View anchor, List<String> labels, Function1<? super Integer, Unit> pick) {
        Ui ui = Ui.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        PopupMenu popupMenu = new PopupMenu(ui.popupContext(context), anchor);
        int i = 0;
        for (Object obj : labels) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            popupMenu.getMenu().add(0, i, i, (String) obj);
            i = i2;
        }
        popupMenu.setOnMenuItemClickListener(new AudioBrowser$$ExternalSyntheticLambda21(pick));
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean menu$lambda$22(Function1 function1, MenuItem menuItem) {
        function1.invoke(Integer.valueOf(menuItem.getItemId()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit previewListener$lambda$2(AudioBrowser audioBrowser) {
        audioBrowser.post(new AudioBrowser$$ExternalSyntheticLambda3(audioBrowser));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void previewListener$lambda$2$lambda$1(AudioBrowser audioBrowser) {
        if (audioBrowser.draggingId == null) {
            audioBrowser.adapter.notifyDataSetChanged();
        }
    }

    private final RobloxApi.AudioQuery query() {
        Pair<Integer, Integer> second = this.lengths.get(this.lengthIdx).getSecond();
        int intValue = second.component1().intValue();
        Integer component2 = second.component2();
        String[] strArr = new String[2];
        String str = this.keyword;
        if (StringsKt.isBlank(str)) {
            str = null;
        }
        strArr[0] = str;
        strArr[1] = this.tag;
        return new RobloxApi.AudioQuery(CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) strArr), " ", null, null, 0, null, null, 62, null), this.type, this.sort, intValue, component2, this.chart, null, 64, null);
    }

    private final void showDiscover() {
        this.discover = true;
        buildFilters();
        this.content.removeAllViews();
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setPadding(dp(10.0f), dp(4.0f), dp(10.0f), dp(16.0f));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        showDiscover$card(this, linearLayout2, "Music", "Licensed tracks for your experience", -8699932, new AudioBrowser$$ExternalSyntheticLambda15(this));
        showDiscover$card(this, linearLayout2, "Sound Effects", "UI, impacts, ambience and more", -15954066, new AudioBrowser$$ExternalSyntheticLambda16(this));
        LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
        lp$default.topMargin = dp(6.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(linearLayout2, lp$default);
        showDiscover$section(linearLayout, this, "Top charts");
        showDiscover$flow(this, linearLayout, CollectionsKt.listOf((Object[]) new String[]{"Now", "This week", "This month", "This year"}), new AudioBrowser$$ExternalSyntheticLambda17(this));
        showDiscover$section(linearLayout, this, "Genres");
        showDiscover$flow(this, linearLayout, this.genres, new AudioBrowser$$ExternalSyntheticLambda18(this));
        showDiscover$section(linearLayout, this, "Vibes");
        showDiscover$flow(this, linearLayout, this.vibes, new AudioBrowser$$ExternalSyntheticLambda19(this));
        showDiscover$section(linearLayout, this, "Sound effects");
        showDiscover$flow(this, linearLayout, this.sfx, new AudioBrowser$$ExternalSyntheticLambda20(this));
        Ui ui = Ui.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        TextView text$default = Ui.text$default(ui, context, "Audio comes from the Roblox Creator Store. Previewing and playing audio needs a signed-in account (Roblox only serves audio files to signed-in users).", 11.0f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default.setSingleLine(false);
        text$default.setPadding(0, dp(14.0f), 0, 0);
        linearLayout.addView(text$default);
        FrameLayout frameLayout = this.content;
        ScrollView scrollView = new ScrollView(getContext());
        scrollView.addView(linearLayout);
        frameLayout.addView(scrollView);
    }

    private static final void showDiscover$card(AudioBrowser audioBrowser, LinearLayout linearLayout, String str, String str2, int i, Function0<Unit> function0) {
        LinearLayout linearLayout2 = new LinearLayout(audioBrowser.getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setPadding(audioBrowser.dp(12.0f), audioBrowser.dp(12.0f), audioBrowser.dp(12.0f), audioBrowser.dp(12.0f));
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{i, Ui.INSTANCE.blend(i, ViewCompat.MEASURED_STATE_MASK, 0.35f)});
        gradientDrawable.setCornerRadius(audioBrowser.dp(8.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOnClickListener(new AudioBrowser$$ExternalSyntheticLambda2(function0));
        Ui ui = Ui.INSTANCE;
        Context context = audioBrowser.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        linearLayout2.addView(ui.text(context, str, 15.0f, -1, true));
        Ui ui2 = Ui.INSTANCE;
        Context context2 = audioBrowser.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        TextView text$default = Ui.text$default(ui2, context2, str2, 11.0f, -570425345, false, 16, null);
        text$default.setSingleLine(false);
        linearLayout2.addView(text$default);
        LinearLayout.LayoutParams lp = Ui.INSTANCE.lp(0, -2, 1.0f);
        lp.rightMargin = audioBrowser.dp(8.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(linearLayout2, lp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showDiscover$card$lambda$29$lambda$28(Function0 function0, View view) {
        function0.invoke();
    }

    private static final void showDiscover$flow(AudioBrowser audioBrowser, LinearLayout linearLayout, List<String> list, Function1<? super String, Unit> function1) {
        Context context = audioBrowser.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        FlowLayout flowLayout = new FlowLayout(context);
        for (String str : list) {
            AudioBrowser audioBrowser2 = audioBrowser;
            flowLayout.addView(chip$default(audioBrowser2, str, false, false, new AudioBrowser$$ExternalSyntheticLambda1(function1, str), 4, null));
            audioBrowser = audioBrowser2;
        }
        linearLayout.addView(flowLayout, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showDiscover$flow$lambda$25(Function1 function1, String str, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showDiscover$lambda$32(AudioBrowser audioBrowser) {
        audioBrowser.type = "Music";
        audioBrowser.tag = null;
        audioBrowser.showResults();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showDiscover$lambda$33(AudioBrowser audioBrowser) {
        audioBrowser.type = "SoundEffect";
        audioBrowser.tag = null;
        audioBrowser.showResults();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final Unit showDiscover$lambda$35(AudioBrowser audioBrowser, String l) {
        String str;
        Intrinsics.checkNotNullParameter(l, "l");
        switch (l.hashCode()) {
            case -8555874:
                if (l.equals("This month")) {
                    str = "Month";
                    break;
                }
                str = "Year";
                break;
            case 78518:
                if (l.equals("Now")) {
                    str = "Current";
                    break;
                }
                str = "Year";
                break;
            case 1385485334:
                if (l.equals("This week")) {
                    str = "Week";
                    break;
                }
                str = "Year";
                break;
            default:
                str = "Year";
                break;
        }
        audioBrowser.chart = str;
        audioBrowser.type = "Music";
        audioBrowser.tag = null;
        audioBrowser.showResults();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showDiscover$lambda$36(AudioBrowser audioBrowser, String g) {
        Intrinsics.checkNotNullParameter(g, "g");
        audioBrowser.tag = g;
        audioBrowser.type = "Music";
        audioBrowser.showResults();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showDiscover$lambda$37(AudioBrowser audioBrowser, String v) {
        Intrinsics.checkNotNullParameter(v, "v");
        audioBrowser.tag = v;
        audioBrowser.type = "Music";
        audioBrowser.showResults();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showDiscover$lambda$38(AudioBrowser audioBrowser, String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        audioBrowser.tag = s;
        audioBrowser.type = "SoundEffect";
        audioBrowser.showResults();
        return Unit.INSTANCE;
    }

    private static final void showDiscover$section(LinearLayout linearLayout, AudioBrowser audioBrowser, String str) {
        Ui ui = Ui.INSTANCE;
        Context context = audioBrowser.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        TextView text = ui.text(context, str, 13.0f, Ui.INSTANCE.getTEXT(), true);
        text.setPadding(0, audioBrowser.dp(12.0f), 0, audioBrowser.dp(6.0f));
        linearLayout.addView(text);
    }

    private final void showResults() {
        this.discover = false;
        buildFilters();
        this.content.removeAllViews();
        View view = this.results;
        if (view == null) {
            view = buildResults();
            this.results = view;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        this.content.addView(view);
        this.gen++;
        this.items.clear();
        this.token = null;
        this.ended = false;
        this.loading = false;
        this.adapter.notifyDataSetChanged();
        loadMore();
    }

    public final String getKeyword() {
        return this.keyword;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        AudioEngine.INSTANCE.getPreviewListeners().add(this.previewListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        AudioEngine.INSTANCE.getPreviewListeners().remove(this.previewListener);
        super.onDetachedFromWindow();
    }

    public final void search(String q) {
        Intrinsics.checkNotNullParameter(q, "q");
        this.keyword = StringsKt.trim((CharSequence) q).toString();
        if ((this.keyword.length() == 0) && this.tag == null && Intrinsics.areEqual(this.chart, "None") && this.type == null) {
            showDiscover();
        } else {
            showResults();
        }
    }
}
