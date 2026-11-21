package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AboutDialog.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/AboutDialog;", "", "<init>", "()V", "YOUTUBE_URL", "", "DOWNLOAD_URL", "version", "Lkotlin/Pair;", "", "ctx", "Landroid/content/Context;", "open", "", "act", "Landroid/app/Activity;", "url", "show", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AboutDialog {
    public static final String DOWNLOAD_URL = "https://www.mediafire.com/folder/33xwlczg9fxs1/mobile+studio";
    public static final AboutDialog INSTANCE = new AboutDialog();
    public static final String YOUTUBE_URL = "https://www.youtube.com/@fiowwwys/featured";

    private AboutDialog() {
    }

    private static final int show$dp(Activity activity, float f) {
        return Ui.INSTANCE.dp(activity, f);
    }

    private static final void show$linkButton(Activity activity, LinearLayout linearLayout, String str, String str2, String str3, String str4) {
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setPadding(show$dp(activity, 10.0f), show$dp(activity, 9.0f), show$dp(activity, 12.0f), show$dp(activity, 9.0f));
        linearLayout2.setBackground(Ui.INSTANCE.rippleBg(activity, Ui.INSTANCE.getCARD(), 10.0f));
        linearLayout2.setClickable(true);
        linearLayout2.setOnClickListener(new AboutDialog$$ExternalSyntheticLambda0(activity, str4));
        ImageView imageView = new ImageView(activity);
        imageView.setImageDrawable(Icons.general$default(Icons.INSTANCE, activity, str, null, 4, null));
        LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, show$dp(activity, 26.0f), show$dp(activity, 26.0f), 0.0f, 4, null);
        lp$default.rightMargin = show$dp(activity, 12.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout2.addView(imageView, lp$default);
        LinearLayout linearLayout3 = new LinearLayout(activity);
        linearLayout3.setOrientation(1);
        linearLayout3.addView(Ui.INSTANCE.text(activity, str2, 14.0f, Ui.INSTANCE.getTEXT(), true));
        TextView text$default = Ui.text$default(Ui.INSTANCE, activity, str3, 11.5f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout3.addView(text$default);
        linearLayout2.addView(linearLayout3, Ui.INSTANCE.lp(0, -2, 1.0f));
        linearLayout2.addView(Ui.text$default(Ui.INSTANCE, activity, "›", 20.0f, Ui.INSTANCE.getDIM(), false, 16, null));
        LinearLayout.LayoutParams lp$default2 = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
        lp$default2.bottomMargin = show$dp(activity, 6.0f);
        Unit unit2 = Unit.INSTANCE;
        linearLayout.addView(linearLayout2, lp$default2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void show$linkButton$lambda$9$lambda$8(Activity activity, String str, View view) {
        INSTANCE.open(activity, str);
    }

    private static final void show$section(LinearLayout linearLayout, Activity activity, String str) {
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        TextView text = Ui.INSTANCE.text(activity, upperCase, 11.0f, Ui.INSTANCE.getDIM(), true);
        text.setLetterSpacing(0.08f);
        text.setPadding(0, show$dp(activity, 16.0f), 0, show$dp(activity, 6.0f));
        linearLayout.addView(text);
    }

    public final void open(Activity act, String url) {
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            act.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
        } catch (Exception e) {
            Toast.makeText(act, "No browser found to open " + url, 1).show();
        }
    }

    public final void show(Activity act) {
        Intrinsics.checkNotNullParameter(act, "act");
        Pair<String, Long> version = version(act);
        String component1 = version.component1();
        long longValue = version.component2().longValue();
        LinearLayout linearLayout = new LinearLayout(act);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(show$dp(act, 20.0f), show$dp(act, 18.0f), show$dp(act, 20.0f), show$dp(act, 6.0f));
        LinearLayout linearLayout2 = new LinearLayout(act);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        ImageView imageView = new ImageView(act);
        imageView.setImageDrawable(Icons.general$default(Icons.INSTANCE, act, "Place", null, 4, null));
        imageView.setPadding(show$dp(act, 8.0f), show$dp(act, 8.0f), show$dp(act, 8.0f), show$dp(act, 8.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Ui.INSTANCE.blend(Ui.INSTANCE.getPANEL(), Ui.INSTANCE.getACCENT(), 0.22f));
        gradientDrawable.setCornerRadius(show$dp(act, 12.0f));
        imageView.setBackground(gradientDrawable);
        LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, show$dp(act, 52.0f), show$dp(act, 52.0f), 0.0f, 4, null);
        lp$default.rightMargin = show$dp(act, 14.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout2.addView(imageView, lp$default);
        LinearLayout linearLayout3 = new LinearLayout(act);
        linearLayout3.setOrientation(1);
        linearLayout3.addView(Ui.INSTANCE.text(act, "Mobile Studio", 20.0f, Ui.INSTANCE.getTEXT(), true));
        linearLayout3.addView(Ui.text$default(Ui.INSTANCE, act, "Version " + component1 + "  (build " + longValue + ")", 13.0f, Ui.INSTANCE.getDIM(), false, 16, null));
        linearLayout2.addView(linearLayout3, Ui.INSTANCE.lp(0, -2, 1.0f));
        linearLayout.addView(linearLayout2);
        TextView text$default = Ui.text$default(Ui.INSTANCE, act, "A Roblox-Studio-style editor for Android: open, build, script, playtest and publish your places on the go.", 13.0f, Ui.INSTANCE.getTEXT(), false, 16, null);
        text$default.setSingleLine(false);
        text$default.setPadding(0, show$dp(act, 14.0f), 0, show$dp(act, 4.0f));
        linearLayout.addView(text$default);
        show$section(linearLayout, act, "Credits");
        show$linkButton(act, linearLayout, "Video", "Made by fiowwwys", "YouTube · youtube.com/@fiowwwys", YOUTUBE_URL);
        show$section(linearLayout, act, "Updates");
        show$linkButton(act, linearLayout, "Download", "Get the latest version", "Download from MediaFire", DOWNLOAD_URL);
        TextView text$default2 = Ui.text$default(Ui.INSTANCE, act, "You have version " + component1 + ". Check the download folder for newer builds.", 11.5f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default2.setSingleLine(false);
        text$default2.setPadding(show$dp(act, 2.0f), show$dp(act, 2.0f), 0, 0);
        linearLayout.addView(text$default2);
        show$section(linearLayout, act, "Tips");
        TextView text$default3 = Ui.text$default(Ui.INSTANCE, act, "• Windows: drag a panel's header to dock it left, right or under the viewport, or let it float. Double-tap a header to float/dock it.\n• Controls: left stick to fly/walk, drag to look, pinch to zoom/move, tap to select. Long-press Explorer items to drag them into the Toolbox or another parent.\n• File → Playtest Avatar picks who you play as (your avatar, R6/R15, or any model you save).", 12.0f, Ui.INSTANCE.getTEXT(), false, 16, null);
        text$default3.setSingleLine(false);
        linearLayout.addView(text$default3);
        show$section(linearLayout, act, "Acknowledgements");
        TextView text$default4 = Ui.text$default(Ui.INSTANCE, act, "Icons are drawn by this app. Fonts: Montserrat, Source Sans 3, Fredoka One and other SIL Open Font License fonts. Toolbox content comes from the Roblox Creator Store. Not affiliated with Roblox Corporation.", 11.5f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default4.setSingleLine(false);
        text$default4.setPadding(0, 0, 0, show$dp(act, 6.0f));
        linearLayout.addView(text$default4);
        AlertDialog.Builder themed = Dialogs.INSTANCE.themed(act);
        ScrollView scrollView = new ScrollView(act);
        scrollView.addView(linearLayout);
        themed.setView(scrollView).setPositiveButton("Close", (DialogInterface.OnClickListener) null).show();
    }

    public final Pair<String, Long> version(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        try {
            PackageInfo packageInfo = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0);
            long longVersionCode = Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
            String str = packageInfo.versionName;
            if (str == null) {
                str = "?";
            }
            return TuplesKt.to(str, Long.valueOf(longVersionCode));
        } catch (Exception e) {
            return TuplesKt.to("?", 0L);
        }
    }
}
