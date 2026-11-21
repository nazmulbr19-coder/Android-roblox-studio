package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.exampletest.mobilestudiotest.core.Settings;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.engine.PlaySession;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.PartData;
import com.exampletest.mobilestudiotest.model.Vector3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

/* compiled from: PlayHud.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001:\u0003DEFB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\u0006\u0010'\u001a\u00020%J\b\u0010(\u001a\u00020%H\u0002J\u0006\u0010)\u001a\u00020%J\u0006\u0010*\u001a\u00020%J\u0006\u0010+\u001a\u00020%J\u0006\u0010,\u001a\u00020\u001fJ\u0006\u0010-\u001a\u00020%J\b\u0010.\u001a\u00020%H\u0002J,\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\t2\b\b\u0002\u00104\u001a\u00020\u000b2\b\b\u0002\u00105\u001a\u00020\u001fH\u0002J&\u00106\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00107\u001a\u00020\u001f2\f\u00108\u001a\b\u0012\u0004\u0012\u00020%09H\u0002J\b\u0010:\u001a\u00020%H\u0002J6\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u0002022\u0006\u0010>\u001a\u0002022\u0006\u0010?\u001a\u0002022\f\u0010@\u001a\b\u0012\u0004\u0012\u00020%09H\u0002J\b\u0010A\u001a\u00020\u001dH\u0002J\b\u0010B\u001a\u00020\u001dH\u0002J\b\u0010C\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00060\u0011R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00060\u0013R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00060\u0013R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00060\u0013R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00060\u0019R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/PlayHud;", "Landroid/widget/FrameLayout;", "ctx", "Landroid/content/Context;", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "<init>", "(Landroid/content/Context;Lcom/exampletest/mobilestudiotest/core/Studio;)V", "d", "", "dp", "", "v", "bold", "Landroid/graphics/Typeface;", "regular", "layer", "Lcom/exampletest/mobilestudiotest/ui/PlayHud$Layer;", "menuBtn", "Lcom/exampletest/mobilestudiotest/ui/PlayHud$TopButton;", "chatBtn", "listBtn", "chatBox", "Landroid/widget/LinearLayout;", "chatLog", "Lcom/exampletest/mobilestudiotest/ui/PlayHud$ChatLog;", "chatBar", "Landroid/widget/EditText;", "menu", "Landroid/view/View;", "chatOpen", "", "playerListOpen", "lastChatActivity", "", "seenChat", "send", "", "hideKeyboard", "onPlayStateChanged", "updateChatVisibility", "onFrame", "togglePlayerList", "focusChat", "handleBack", "toggleMenu", "closeMenu", "label", "Landroid/widget/TextView;", "s", "", "size", TypedValues.Custom.S_COLOR, "b", "pill", "primary", "onClick", "Lkotlin/Function0;", "openMenu", "confirmPage", "root", "title", NotificationCompat.CATEGORY_MESSAGE, "ok", "onOk", "peoplePage", "settingsPage", "helpPage", "TopButton", "ChatLog", "Layer", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PlayHud extends FrameLayout {
    private final Typeface bold;
    private final EditText chatBar;
    private final LinearLayout chatBox;
    private final TopButton chatBtn;
    private final ChatLog chatLog;
    private boolean chatOpen;
    private final float d;
    private long lastChatActivity;
    private final Layer layer;
    private final TopButton listBtn;
    private View menu;
    private final TopButton menuBtn;
    private boolean playerListOpen;
    private final Typeface regular;
    private int seenChat;
    private final Studio studio;

    /* compiled from: PlayHud.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0083\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/PlayHud$ChatLog;", "Landroid/view/View;", "ctx", "Landroid/content/Context;", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/PlayHud;Landroid/content/Context;)V", "tp", "Landroid/text/TextPaint;", "shadow", "layouts", "", "Landroid/text/StaticLayout;", "lines", "Lcom/exampletest/mobilestudiotest/engine/PlaySession$ChatLine;", "lastW", "", "reload", "", "build", "onDraw", "c", "Landroid/graphics/Canvas;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private final class ChatLog extends View {
        private int lastW;
        private List<? extends StaticLayout> layouts;
        private List<PlaySession.ChatLine> lines;
        private final TextPaint shadow;
        final /* synthetic */ PlayHud this$0;
        private final TextPaint tp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChatLog(PlayHud playHud, Context ctx) {
            super(ctx);
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            this.this$0 = playHud;
            TextPaint textPaint = new TextPaint(1);
            PlayHud playHud2 = this.this$0;
            textPaint.setColor(-1);
            textPaint.setTextSize(PlayHud.access$getD$p(playHud2) * 14.0f);
            textPaint.setTypeface(PlayHud.access$getRegular$p(playHud2));
            this.tp = textPaint;
            TextPaint textPaint2 = new TextPaint(this.tp);
            textPaint2.setColor(-872415232);
            this.shadow = textPaint2;
            this.layouts = CollectionsKt.emptyList();
            this.lines = CollectionsKt.emptyList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v0 */
        /* JADX WARN: Type inference failed for: r14v1, types: [int, boolean] */
        /* JADX WARN: Type inference failed for: r14v8 */
        private final void build() {
            ?? r14;
            int width = getWidth() - PlayHud.access$dp(this.this$0, 4.0f);
            if (width <= 0) {
                this.layouts = CollectionsKt.emptyList();
                return;
            }
            this.lastW = getWidth();
            List<PlaySession.ChatLine> list = this.lines;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (PlaySession.ChatLine chatLine : list) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (chatLine.getFrom() != null) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) ("[" + chatLine.getFrom() + "]: "));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(chatLine.getColor()), length, spannableStringBuilder.length(), 33);
                    spannableStringBuilder.setSpan(new StyleSpan(1), length, spannableStringBuilder.length(), 33);
                    spannableStringBuilder.append((CharSequence) chatLine.getText());
                    r14 = 0;
                } else {
                    spannableStringBuilder.append((CharSequence) chatLine.getText());
                    r14 = 0;
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(chatLine.getColor()), 0, spannableStringBuilder.length(), 33);
                }
                arrayList.add(StaticLayout.Builder.obtain(spannableStringBuilder, r14, spannableStringBuilder.length(), this.tp, width).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(r14).build());
            }
            this.layouts = arrayList;
        }

        @Override // android.view.View
        protected void onDraw(Canvas c) {
            Intrinsics.checkNotNullParameter(c, "c");
            if (getWidth() != this.lastW) {
                build();
            }
            float height = getHeight();
            c.save();
            c.clipRect(0, 0, getWidth(), getHeight());
            for (StaticLayout staticLayout : CollectionsKt.asReversed(this.layouts)) {
                height -= staticLayout.getHeight() + PlayHud.access$dp(this.this$0, 2.0f);
                if (staticLayout.getHeight() + height < 0.0f) {
                    break;
                }
                c.save();
                c.translate(PlayHud.access$dp(this.this$0, 2.0f), height);
                staticLayout.draw(c);
                c.restore();
            }
            c.restore();
        }

        public final void reload() {
            List<PlaySession.ChatLine> list;
            ArrayList<PlaySession.ChatLine> chatLines;
            List takeLast;
            Object lock = PlayHud.access$getStudio$p(this.this$0).getLock();
            PlayHud playHud = this.this$0;
            synchronized (lock) {
                PlaySession play = PlayHud.access$getStudio$p(playHud).getPlay();
                list = (play == null || (chatLines = play.getChatLines()) == null || (takeLast = CollectionsKt.takeLast(chatLines, 60)) == null) ? null : CollectionsKt.toList(takeLast);
            }
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            this.lines = list;
            build();
            invalidate();
        }
    }

    /* compiled from: PlayHud.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0083\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/PlayHud$Layer;", "Landroid/view/View;", "ctx", "Landroid/content/Context;", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/PlayHud;Landroid/content/Context;)V", "fill", "Landroid/graphics/Paint;", "tp", "Landroid/text/TextPaint;", "bp", "onDraw", "", "c", "Landroid/graphics/Canvas;", "drawBubbles", "p", "Lcom/exampletest/mobilestudiotest/engine/PlaySession;", "drawPlayerList", "drawHealth", "drawCursor", "drawDot", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private final class Layer extends View {
        private final Paint bp;
        private final Paint fill;
        final /* synthetic */ PlayHud this$0;
        private final TextPaint tp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Layer(PlayHud playHud, Context ctx) {
            super(ctx);
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            this.this$0 = playHud;
            this.fill = new Paint(1);
            TextPaint textPaint = new TextPaint(1);
            PlayHud playHud2 = this.this$0;
            textPaint.setTextSize(PlayHud.access$getD$p(playHud2) * 14.0f);
            textPaint.setTypeface(PlayHud.access$getRegular$p(playHud2));
            this.tp = textPaint;
            Paint paint = new Paint(1);
            PlayHud playHud3 = this.this$0;
            paint.setTextSize(PlayHud.access$getD$p(playHud3) * 13.0f);
            paint.setTypeface(PlayHud.access$getBold$p(playHud3));
            paint.setColor(-1);
            this.bp = paint;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v10 */
        /* JADX WARN: Type inference failed for: r13v3 */
        /* JADX WARN: Type inference failed for: r13v4, types: [int, boolean] */
        private final void drawBubbles(Canvas c, PlaySession p) {
            ArrayList arrayList;
            if (p.getBubbles().isEmpty()) {
                return;
            }
            int access$dp = PlayHud.access$dp(this.this$0, 220.0f);
            ArrayList<PlaySession.Bubble> bubbles = p.getBubbles();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : bubbles) {
                Instance part = ((PlaySession.Bubble) obj).getPart();
                Object obj2 = linkedHashMap.get(part);
                if (obj2 == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(part, arrayList);
                } else {
                    arrayList = obj2;
                }
                ((List) arrayList).add(obj);
            }
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Instance instance = (Instance) entry.getKey();
                List list = (List) entry.getValue();
                float f = 2.0f;
                float f2 = 0.0f;
                Vector3 plus = PartData.INSTANCE.cframe(instance).getPosition().plus(new Vector3(0.0f, (PartData.INSTANCE.size(instance).getY() / 2.0f) + 1.6f, 0.0f));
                float[] project = PlayHud.access$getStudio$p(this.this$0).getView().project(plus);
                if (project != null) {
                    float f3 = 1.0f;
                    if (project[2] <= 1.0f) {
                        float distTo = PlayHud.access$getStudio$p(this.this$0).getView().distTo(plus);
                        if (distTo <= 100.0f) {
                            float f4 = project[1];
                            ?? r13 = 0;
                            int i = 0;
                            for (PlaySession.Bubble bubble : CollectionsKt.asReversed(list)) {
                                int i2 = i;
                                i++;
                                float f5 = f;
                                float coerceIn = RangesKt.coerceIn(bubble.getAge() > 11.0f ? 12.0f - bubble.getAge() : f3, f2, f3) * (i2 == 0 ? f3 : 0.8f);
                                float f6 = f3;
                                this.tp.setColor((((int) (coerceIn * 255.0f)) << 24) | 3750717);
                                Iterator it2 = it;
                                StaticLayout build = StaticLayout.Builder.obtain(bubble.getText(), r13, bubble.getText().length(), this.tp, access$dp).setAlignment(Layout.Alignment.ALIGN_CENTER).setIncludePad(r13).build();
                                Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                                float f7 = 0.0f;
                                int i3 = 0;
                                char c2 = r13;
                                int lineCount = build.getLineCount();
                                while (i3 < lineCount) {
                                    f7 = Math.max(f7, build.getLineWidth(i3));
                                    i3++;
                                    list = list;
                                }
                                List list2 = list;
                                int access$dp2 = PlayHud.access$dp(this.this$0, 10.0f);
                                int access$dp3 = PlayHud.access$dp(this.this$0, 6.0f);
                                float f8 = (access$dp2 * 2) + f7;
                                LinkedHashMap linkedHashMap2 = linkedHashMap;
                                Instance instance2 = instance;
                                Vector3 vector3 = plus;
                                float[] fArr = project;
                                float f9 = distTo;
                                RectF rectF = new RectF(project[c2] - (f8 / f5), (f4 - (build.getHeight() + (access$dp3 * f5))) - PlayHud.access$dp(this.this$0, 10.0f), project[c2] + (f8 / f5), f4 - PlayHud.access$dp(this.this$0, 10.0f));
                                this.fill.setColor((((int) ((0.92f * coerceIn) * 255.0f)) << 24) | ViewCompat.MEASURED_SIZE_MASK);
                                c.drawRoundRect(rectF, PlayHud.access$dp(this.this$0, 12.0f), PlayHud.access$dp(this.this$0, 12.0f), this.fill);
                                if (i2 == 0) {
                                    Path path = new Path();
                                    PlayHud playHud = this.this$0;
                                    path.moveTo(fArr[c2] - PlayHud.access$dp(playHud, 7.0f), rectF.bottom - f6);
                                    path.lineTo(fArr[c2], rectF.bottom + PlayHud.access$dp(playHud, 8.0f));
                                    path.lineTo(fArr[c2] + PlayHud.access$dp(playHud, 7.0f), rectF.bottom - f6);
                                    path.close();
                                    c.drawPath(path, this.fill);
                                }
                                c.save();
                                c.translate(fArr[c2] - (access$dp / f5), rectF.top + access$dp3);
                                build.draw(c);
                                c.restore();
                                f4 = rectF.top - PlayHud.access$dp(this.this$0, f5);
                                f = f5;
                                f3 = f6;
                                it = it2;
                                r13 = c2;
                                list = list2;
                                distTo = f9;
                                instance = instance2;
                                linkedHashMap = linkedHashMap2;
                                plus = vector3;
                                project = fArr;
                                f2 = 0.0f;
                            }
                        }
                    }
                }
            }
        }

        private final void drawCursor(Canvas c) {
            float width = (getWidth() / 2.0f) + 0.0f;
            float height = getHeight() / 2.0f;
            this.fill.setStyle(Paint.Style.STROKE);
            this.fill.setStrokeWidth(PlayHud.access$getD$p(this.this$0) * 2.0f);
            this.fill.setColor(-419430401);
            c.drawCircle(width, height, PlayHud.access$getD$p(this.this$0) * 9.0f, this.fill);
            this.fill.setStyle(Paint.Style.FILL);
            c.drawCircle(width, height, PlayHud.access$getD$p(this.this$0) * 2.0f, this.fill);
        }

        private final void drawDot(Canvas c) {
            this.fill.setStyle(Paint.Style.FILL);
            this.fill.setColor(-855638017);
            c.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, PlayHud.access$getD$p(this.this$0) * 2.5f, this.fill);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0065 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void drawHealth(android.graphics.Canvas r19, com.exampletest.mobilestudiotest.engine.PlaySession r20) {
            /*
                Method dump skipped, instructions count: 234
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.PlayHud.Layer.drawHealth(android.graphics.Canvas, com.exampletest.mobilestudiotest.engine.PlaySession):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x01dc, code lost:
        
            if (r2 != null) goto L30;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void drawPlayerList(android.graphics.Canvas r29, com.exampletest.mobilestudiotest.engine.PlaySession r30) {
            /*
                Method dump skipped, instructions count: 606
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.PlayHud.Layer.drawPlayerList(android.graphics.Canvas, com.exampletest.mobilestudiotest.engine.PlaySession):void");
        }

        @Override // android.view.View
        protected void onDraw(Canvas c) {
            Intrinsics.checkNotNullParameter(c, "c");
            Object lock = PlayHud.access$getStudio$p(this.this$0).getLock();
            PlayHud playHud = this.this$0;
            synchronized (lock) {
                PlaySession play = PlayHud.access$getStudio$p(playHud).getPlay();
                if (play == null) {
                    return;
                }
                drawBubbles(c, play);
                if (play.getCorePlayerList() && PlayHud.access$getPlayerListOpen$p(playHud)) {
                    drawPlayerList(c, play);
                }
                if (play.getCoreHealth()) {
                    drawHealth(c, play);
                }
                if (play.getShiftLock() && !play.getFirstPerson()) {
                    drawCursor(c);
                } else if (play.getFirstPerson()) {
                    drawDot(c);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* compiled from: PlayHud.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0083\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000bH\u0014J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/PlayHud$TopButton;", "Landroid/view/View;", "ctx", "Landroid/content/Context;", "kind", "", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/PlayHud;Landroid/content/Context;I)V", "getKind", "()I", "active", "", "getActive", "()Z", "setActive", "(Z)V", "p", "Landroid/graphics/Paint;", "onDraw", "", "c", "Landroid/graphics/Canvas;", "dispatchSetPressed", "pressed", "onTouchEvent", "e", "Landroid/view/MotionEvent;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private final class TopButton extends View {
        private boolean active;
        private final int kind;
        private final Paint p;
        final /* synthetic */ PlayHud this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TopButton(PlayHud playHud, Context ctx, int i) {
            super(ctx);
            String str;
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            this.this$0 = playHud;
            this.kind = i;
            this.active = true;
            this.p = new Paint(1);
            setClickable(true);
            switch (this.kind) {
                case 0:
                    str = "Roblox menu";
                    break;
                case 1:
                    str = "Chat";
                    break;
                default:
                    str = "Leaderboard";
                    break;
            }
            setContentDescription(str);
        }

        @Override // android.view.View
        protected void dispatchSetPressed(boolean pressed) {
            invalidate();
        }

        public final boolean getActive() {
            return this.active;
        }

        public final int getKind() {
            return this.kind;
        }

        @Override // android.view.View
        protected void onDraw(Canvas c) {
            Intrinsics.checkNotNullParameter(c, "c");
            float width = getWidth() / 2.0f;
            float height = getHeight() / 2.0f;
            float width2 = getWidth() / 2.0f;
            this.p.setStyle(Paint.Style.FILL);
            this.p.setColor(isPressed() ? -1291845632 : -1946157056);
            c.drawCircle(width, height, width2, this.p);
            this.p.setColor(-1);
            switch (this.kind) {
                case 0:
                    this.p.setStyle(Paint.Style.STROKE);
                    this.p.setStrokeWidth(PlayHud.access$getD$p(this.this$0) * 2.6f);
                    c.save();
                    c.rotate(15.0f, width, height);
                    float access$getD$p = PlayHud.access$getD$p(this.this$0) * 8.0f;
                    c.drawRoundRect(width - access$getD$p, height - access$getD$p, width + access$getD$p, height + access$getD$p, PlayHud.access$getD$p(this.this$0) * 2.0f, PlayHud.access$getD$p(this.this$0) * 2.0f, this.p);
                    this.p.setStyle(Paint.Style.FILL);
                    c.drawRect(width - (PlayHud.access$getD$p(this.this$0) * 2.2f), height - (PlayHud.access$getD$p(this.this$0) * 2.2f), (PlayHud.access$getD$p(this.this$0) * 2.2f) + width, (PlayHud.access$getD$p(this.this$0) * 2.2f) + height, this.p);
                    c.restore();
                    return;
                case 1:
                    if (!this.active) {
                        this.p.setAlpha(150);
                    }
                    c.drawRoundRect(width - (PlayHud.access$getD$p(this.this$0) * 9.0f), height - (PlayHud.access$getD$p(this.this$0) * 7.0f), (PlayHud.access$getD$p(this.this$0) * 9.0f) + width, (PlayHud.access$getD$p(this.this$0) * 5.0f) + height, PlayHud.access$getD$p(this.this$0) * 4.0f, PlayHud.access$getD$p(this.this$0) * 4.0f, this.p);
                    Path path = new Path();
                    PlayHud playHud = this.this$0;
                    path.moveTo(width - (PlayHud.access$getD$p(playHud) * 4.0f), (PlayHud.access$getD$p(playHud) * 4.0f) + height);
                    path.lineTo(width - (PlayHud.access$getD$p(playHud) * 6.0f), (PlayHud.access$getD$p(playHud) * 10.0f) + height);
                    path.lineTo((PlayHud.access$getD$p(playHud) * 1.0f) + width, (PlayHud.access$getD$p(playHud) * 4.0f) + height);
                    path.close();
                    c.drawPath(path, this.p);
                    this.p.setAlpha(255);
                    return;
                default:
                    if (!this.active) {
                        this.p.setAlpha(150);
                    }
                    c.drawCircle(width - (PlayHud.access$getD$p(this.this$0) * 4.0f), height - (PlayHud.access$getD$p(this.this$0) * 4.0f), PlayHud.access$getD$p(this.this$0) * 3.2f, this.p);
                    c.drawCircle((PlayHud.access$getD$p(this.this$0) * 4.5f) + width, height - (PlayHud.access$getD$p(this.this$0) * 3.0f), PlayHud.access$getD$p(this.this$0) * 2.8f, this.p);
                    c.drawRoundRect(width - (PlayHud.access$getD$p(this.this$0) * 10.0f), (PlayHud.access$getD$p(this.this$0) * 0.5f) + height, (PlayHud.access$getD$p(this.this$0) * 2.0f) + width, height + (PlayHud.access$getD$p(this.this$0) * 9.0f), PlayHud.access$getD$p(this.this$0) * 4.0f, PlayHud.access$getD$p(this.this$0) * 4.0f, this.p);
                    c.drawRoundRect(width + (PlayHud.access$getD$p(this.this$0) * 0.0f), height + (PlayHud.access$getD$p(this.this$0) * 1.5f), width + (PlayHud.access$getD$p(this.this$0) * 10.0f), height + (PlayHud.access$getD$p(this.this$0) * 8.0f), PlayHud.access$getD$p(this.this$0) * 3.5f, PlayHud.access$getD$p(this.this$0) * 3.5f, this.p);
                    this.p.setAlpha(255);
                    return;
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            boolean onTouchEvent = super.onTouchEvent(e);
            invalidate();
            return onTouchEvent;
        }

        public final void setActive(boolean z) {
            this.active = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayHud(Context ctx, Studio studio) {
        super(ctx);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(studio, "studio");
        this.studio = studio;
        this.d = getResources().getDisplayMetrics().density;
        this.bold = Fonts.INSTANCE.forFamily("BuilderSans", TypedValues.TransitionType.TYPE_DURATION, false).getTypeface();
        this.regular = Fonts.INSTANCE.forFamily("BuilderSans", 400, false).getTypeface();
        this.layer = new Layer(this, ctx);
        this.menuBtn = new TopButton(this, ctx, 0);
        this.chatBtn = new TopButton(this, ctx, 1);
        this.listBtn = new TopButton(this, ctx, 2);
        this.chatBox = new LinearLayout(ctx);
        this.chatLog = new ChatLog(this, ctx);
        this.chatOpen = true;
        this.playerListOpen = true;
        this.seenChat = -1;
        setVisibility(8);
        addView(this.layer, new FrameLayout.LayoutParams(-1, -1));
        int dp = dp(8.0f);
        TopButton topButton = this.menuBtn;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dp(40.0f), dp(40.0f));
        layoutParams.leftMargin = dp(12.0f);
        layoutParams.topMargin = dp;
        Unit unit = Unit.INSTANCE;
        addView(topButton, layoutParams);
        TopButton topButton2 = this.chatBtn;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dp(40.0f), dp(40.0f));
        layoutParams2.leftMargin = dp(60.0f);
        layoutParams2.topMargin = dp;
        Unit unit2 = Unit.INSTANCE;
        addView(topButton2, layoutParams2);
        TopButton topButton3 = this.listBtn;
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(dp(40.0f), dp(40.0f), GravityCompat.END);
        layoutParams3.rightMargin = dp(12.0f);
        layoutParams3.topMargin = dp;
        Unit unit3 = Unit.INSTANCE;
        addView(topButton3, layoutParams3);
        this.menuBtn.setOnClickListener(new PlayHud$$ExternalSyntheticLambda4(this));
        this.chatBtn.setOnClickListener(new PlayHud$$ExternalSyntheticLambda5(this));
        this.listBtn.setOnClickListener(new PlayHud$$ExternalSyntheticLambda6(this));
        this.chatBox.setOrientation(1);
        LinearLayout linearLayout = this.chatBox;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(1291845632);
        gradientDrawable.setCornerRadius(dp(8.0f));
        linearLayout.setBackground(gradientDrawable);
        this.chatBox.setPadding(dp(6.0f), dp(6.0f), dp(6.0f), dp(6.0f));
        this.chatBox.addView(this.chatLog, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        EditText editText = new EditText(ctx);
        editText.setHint("Tap here to chat");
        editText.setHintTextColor(-1275068417);
        editText.setTextColor(-1);
        editText.setTextSize(14.0f);
        editText.setTypeface(this.regular);
        editText.setSingleLine(true);
        editText.setImeOptions(268435460);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(1711276032);
        gradientDrawable2.setCornerRadius(dp(6.0f));
        editText.setBackground(gradientDrawable2);
        editText.setPadding(dp(10.0f), dp(7.0f), dp(10.0f), dp(7.0f));
        editText.setOnEditorActionListener(new PlayHud$$ExternalSyntheticLambda7(this));
        editText.setOnFocusChangeListener(new PlayHud$$ExternalSyntheticLambda8(this));
        this.chatBar = editText;
        LinearLayout linearLayout2 = this.chatBox;
        EditText editText2 = this.chatBar;
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = dp(4.0f);
        Unit unit4 = Unit.INSTANCE;
        linearLayout2.addView(editText2, layoutParams4);
        boolean z = getResources().getConfiguration().smallestScreenWidthDp < 600;
        LinearLayout linearLayout3 = this.chatBox;
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(dp(z ? 270.0f : 330.0f), dp(z ? 130.0f : 165.0f));
        layoutParams5.leftMargin = dp(12.0f);
        layoutParams5.topMargin = dp(56.0f);
        Unit unit5 = Unit.INSTANCE;
        addView(linearLayout3, layoutParams5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$3(PlayHud playHud, View view) {
        playHud.toggleMenu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$4(PlayHud playHud, View view) {
        playHud.chatOpen = !playHud.chatOpen;
        if (!playHud.chatOpen) {
            playHud.hideKeyboard();
        }
        playHud.updateChatVisibility();
        playHud.lastChatActivity = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$5(PlayHud playHud, View view) {
        playHud.togglePlayerList();
    }

    public static final /* synthetic */ int access$dp(PlayHud playHud, float f) {
        return playHud.dp(f);
    }

    public static final /* synthetic */ Typeface access$getBold$p(PlayHud playHud) {
        return playHud.bold;
    }

    public static final /* synthetic */ float access$getD$p(PlayHud playHud) {
        return playHud.d;
    }

    public static final /* synthetic */ boolean access$getPlayerListOpen$p(PlayHud playHud) {
        return playHud.playerListOpen;
    }

    public static final /* synthetic */ Typeface access$getRegular$p(PlayHud playHud) {
        return playHud.regular;
    }

    public static final /* synthetic */ Studio access$getStudio$p(PlayHud playHud) {
        return playHud.studio;
    }

    private final void closeMenu() {
        View view = this.menu;
        if (view != null) {
            removeView(view);
        }
        this.menu = null;
    }

    private final void confirmPage(FrameLayout root, String title, String msg, String ok, Function0<Unit> onOk) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setBackgroundColor(-872415232);
        frameLayout.setClickable(true);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setPadding(dp(24.0f), dp(20.0f), dp(24.0f), dp(20.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-14473945);
        gradientDrawable.setCornerRadius(dp(12.0f));
        linearLayout.setBackground(gradientDrawable);
        TextView label$default = label$default(this, title, 20.0f, 0, true, 4, null);
        label$default.setGravity(17);
        linearLayout.addView(label$default);
        TextView label$default2 = label$default(this, msg, 15.0f, -3092272, false, 8, null);
        label$default2.setGravity(17);
        label$default2.setPadding(0, dp(10.0f), 0, dp(16.0f));
        linearLayout.addView(label$default2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        TextView pill = pill(ok, true, new PlayHud$$ExternalSyntheticLambda16(root, frameLayout, onOk));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.rightMargin = dp(8.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout2.addView(pill, layoutParams);
        linearLayout2.addView(pill("Don't " + ok, false, new PlayHud$$ExternalSyntheticLambda17(root, frameLayout)), new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(Math.min(dp(420.0f), (int) (getWidth() * 0.9f)), -2, 17));
        root.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit confirmPage$lambda$45(FrameLayout frameLayout, FrameLayout frameLayout2, Function0 function0) {
        frameLayout.removeView(frameLayout2);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit confirmPage$lambda$47(FrameLayout frameLayout, FrameLayout frameLayout2) {
        frameLayout.removeView(frameLayout2);
        return Unit.INSTANCE;
    }

    private final int dp(float v) {
        return (int) (this.d * v);
    }

    private final View helpPage() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setPadding(dp(6.0f), dp(4.0f), dp(6.0f), dp(4.0f));
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("Move", "Drag the thumbstick (bottom left). Keyboard: WASD or arrow keys"), TuplesKt.to("Look around", "Drag anywhere else on the screen. Keyboard: ← → to turn"), TuplesKt.to("Zoom", "Pinch with two fingers. Keyboard: I / O"), TuplesKt.to("Jump", "Jump button (bottom right). Keyboard: Space"), TuplesKt.to("Shift lock", "Lock button above jump. Keyboard: Shift"), TuplesKt.to("Chat", "Chat button (top left). Keyboard: /"), TuplesKt.to("Tools", "Tap a slot at the bottom. Keyboard: 1–9"), TuplesKt.to("Menu", "Roblox button (top left). Keyboard: Esc")})) {
            String str = (String) pair.component1();
            String str2 = (String) pair.component2();
            TextView label$default = label$default(this, str, 15.0f, 0, true, 4, null);
            label$default.setPadding(0, dp(6.0f), 0, 0);
            linearLayout.addView(label$default);
            linearLayout.addView(label$default(this, str2, 13.0f, -1275068417, false, 8, null));
        }
        ScrollView scrollView = new ScrollView(getContext());
        scrollView.addView(linearLayout);
        return scrollView;
    }

    private final void hideKeyboard() {
        Object systemService = getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(this.chatBar.getWindowToken(), 0);
    }

    private final TextView label(String s, float size, int color, boolean b) {
        TextView textView = new TextView(getContext());
        textView.setText(s);
        textView.setTextSize(size);
        textView.setTextColor(color);
        textView.setTypeface(b ? this.bold : this.regular);
        return textView;
    }

    static /* synthetic */ TextView label$default(PlayHud playHud, String str, float f, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = -1;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        return playHud.label(str, f, i, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$10$lambda$8(PlayHud playHud, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 4 && i != 6) {
            if (!(keyEvent != null && keyEvent.getKeyCode() == 66) || keyEvent.getAction() != 0) {
                return false;
            }
        }
        playHud.send();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$10$lambda$9(PlayHud playHud, View view, boolean z) {
        if (z) {
            playHud.lastChatActivity = System.currentTimeMillis();
        }
    }

    private final void openMenu() {
        hideKeyboard();
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setBackgroundColor(-1291845632);
        boolean z = true;
        frameLayout.setClickable(true);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setPadding(dp(20.0f), dp(14.0f), dp(20.0f), dp(16.0f));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"People", "Settings", "Help"});
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : listOf) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TextView label = label((String) obj, 15.0f, -1, z);
            label.setPadding(dp(18.0f), dp(9.0f), dp(18.0f), dp(9.0f));
            label.setOnClickListener(new PlayHud$$ExternalSyntheticLambda0(i, arrayList, frameLayout2, this));
            arrayList.add(label);
            linearLayout2.addView(label);
            i = i2;
            listOf = listOf;
            z = true;
        }
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        View view = new View(getContext());
        view.setBackgroundColor(872415231);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dp(1.0f));
        layoutParams.topMargin = dp(8.0f);
        layoutParams.bottomMargin = dp(8.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(view, layoutParams);
        linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        LinearLayout linearLayout3 = new LinearLayout(getContext());
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(17);
        TextView pill = pill("Reset Character", false, new PlayHud$$ExternalSyntheticLambda1(this, frameLayout));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.rightMargin = dp(8.0f);
        Unit unit2 = Unit.INSTANCE;
        linearLayout3.addView(pill, layoutParams2);
        TextView pill2 = pill("Leave", false, new PlayHud$$ExternalSyntheticLambda2(this, frameLayout));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams3.rightMargin = dp(8.0f);
        Unit unit3 = Unit.INSTANCE;
        linearLayout3.addView(pill2, layoutParams3);
        linearLayout3.addView(pill("Resume", true, new PlayHud$$ExternalSyntheticLambda3(this)), new LinearLayout.LayoutParams(0, -2, 1.0f));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = dp(10.0f);
        Unit unit4 = Unit.INSTANCE;
        linearLayout.addView(linearLayout3, layoutParams4);
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(Math.min(dp(560.0f), RangesKt.coerceAtLeast((int) (getWidth() * 0.94f), dp(280.0f))), (int) (getHeight() * 0.9f), 17));
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        this.menu = frameLayout;
        openMenu$select(arrayList, frameLayout2, this, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void openMenu$lambda$26$lambda$25$lambda$24(int i, ArrayList arrayList, FrameLayout frameLayout, PlayHud playHud, View view) {
        openMenu$select(arrayList, frameLayout, playHud, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit openMenu$lambda$32(PlayHud playHud, FrameLayout frameLayout) {
        playHud.confirmPage(frameLayout, "Reset Character?", "Are you sure you want to reset your character?", "Reset", new PlayHud$$ExternalSyntheticLambda21(playHud));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit openMenu$lambda$32$lambda$31(PlayHud playHud) {
        synchronized (playHud.studio.getLock()) {
            PlaySession play = playHud.studio.getPlay();
            if (play != null) {
                play.resetCharacter();
                Unit unit = Unit.INSTANCE;
            }
        }
        playHud.closeMenu();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit openMenu$lambda$35(PlayHud playHud, FrameLayout frameLayout) {
        playHud.confirmPage(frameLayout, "Leave Experience?", "Are you sure you want to leave the experience?", "Leave", new PlayHud$$ExternalSyntheticLambda20(playHud));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit openMenu$lambda$35$lambda$34(PlayHud playHud) {
        playHud.closeMenu();
        playHud.studio.stopPlay();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit openMenu$lambda$37(PlayHud playHud) {
        playHud.closeMenu();
        return Unit.INSTANCE;
    }

    private static final void openMenu$select(ArrayList<TextView> arrayList, FrameLayout frameLayout, PlayHud playHud, int i) {
        View peoplePage;
        GradientDrawable gradientDrawable;
        int i2 = 0;
        for (Object obj : arrayList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TextView textView = (TextView) obj;
            textView.setTextColor(i == i2 ? -1 : -1711276033);
            if (i == i2) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setColor(654311423);
                gradientDrawable2.setCornerRadius(playHud.dp(8.0f));
                gradientDrawable = gradientDrawable2;
            } else {
                gradientDrawable = null;
            }
            textView.setBackground(gradientDrawable);
            i2 = i3;
        }
        frameLayout.removeAllViews();
        switch (i) {
            case 0:
                peoplePage = playHud.peoplePage();
                break;
            case 1:
                peoplePage = playHud.settingsPage();
                break;
            default:
                peoplePage = playHud.helpPage();
                break;
        }
        frameLayout.addView(peoplePage);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00e0, code lost:
    
        if (r1 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.view.View peoplePage() {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.PlayHud.peoplePage():android.view.View");
    }

    private final TextView pill(String s, boolean primary, Function0<Unit> onClick) {
        TextView label = label(s, 15.0f, primary ? ViewCompat.MEASURED_STATE_MASK : -1, true);
        label.setGravity(17);
        label.setPadding(dp(18.0f), dp(11.0f), dp(18.0f), dp(11.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(primary ? -1 : 872415231);
        gradientDrawable.setCornerRadius(dp(8.0f));
        label.setBackground(gradientDrawable);
        label.setClickable(true);
        label.setOnClickListener(new PlayHud$$ExternalSyntheticLambda19(onClick));
        return label;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void pill$lambda$18$lambda$17(Function0 function0, View view) {
        function0.invoke();
    }

    private final void send() {
        String obj = this.chatBar.getText().toString();
        this.chatBar.setText("");
        if (!StringsKt.isBlank(obj)) {
            synchronized (this.studio.getLock()) {
                PlaySession play = this.studio.getPlay();
                if (play != null) {
                    play.sendChat(obj);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        hideKeyboard();
        this.chatBar.clearFocus();
        this.lastChatActivity = System.currentTimeMillis();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View settingsPage() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        PlaySession play = this.studio.getPlay();
        Object[] objArr = ((play != null && !play.getShiftLockAllowed()) == true && Settings.INSTANCE.getShiftLockSwitch()) ? false : true;
        Instance findService = this.studio.getModel().findService("StarterPlayer");
        if (!(findService != null ? Intrinsics.areEqual(findService.get("EnableMouseLockOption"), (Object) false) : false)) {
            settingsPage$row(this, linearLayout, "Shift Lock Switch", settingsPage$selector(this, CollectionsKt.listOf((Object[]) new String[]{"Off", "On"}), Settings.INSTANCE.getShiftLockSwitch() ? 1 : 0, new PlayHud$$ExternalSyntheticLambda9(this)));
        }
        if (objArr == false) {
            linearLayout.addView(label$default(this, "This experience turned shift lock off.", 12.0f, -1711276033, false, 8, null));
        }
        settingsPage$row(this, linearLayout, "Camera Mode", settingsPage$selector(this, CollectionsKt.listOf((Object[]) new String[]{"Classic", "Follow"}), !Intrinsics.areEqual(Settings.INSTANCE.getCameraMode(), "Classic") ? 1 : 0, new PlayHud$$ExternalSyntheticLambda10()));
        settingsPage$row(this, linearLayout, "Movement Mode", settingsPage$selector(this, CollectionsKt.listOf((Object[]) new String[]{"Dynamic Thumbstick", "Thumbstick"}), Intrinsics.areEqual(Settings.INSTANCE.getMovementMode(), "Thumbstick") ? 1 : 0, new PlayHud$$ExternalSyntheticLambda11()));
        settingsPage$row(this, linearLayout, "Camera Sensitivity", settingsPage$slider(this, Settings.INSTANCE.getPlayCameraSensitivity(), 0.2f, 4.0f, new PlayHud$$ExternalSyntheticLambda12()));
        settingsPage$row(this, linearLayout, "Volume", settingsPage$slider(this, Settings.INSTANCE.getVolume(), 0.0f, 10.0f, new PlayHud$$ExternalSyntheticLambda13()));
        settingsPage$row(this, linearLayout, "Graphics Quality", settingsPage$slider(this, Settings.INSTANCE.getGraphicsQuality(), 1.0f, 10.0f, new PlayHud$$ExternalSyntheticLambda14(this)));
        settingsPage$row(this, linearLayout, "Performance Stats", settingsPage$selector(this, CollectionsKt.listOf((Object[]) new String[]{"Off", "On"}), Settings.INSTANCE.getShowFps() ? 1 : 0, new PlayHud$$ExternalSyntheticLambda15()));
        ScrollView scrollView = new ScrollView(getContext());
        scrollView.addView(linearLayout);
        return scrollView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit settingsPage$lambda$68(PlayHud playHud, int i) {
        Settings.INSTANCE.setShiftLockSwitch(i == 1);
        if (i == 0) {
            synchronized (playHud.studio.getLock()) {
                PlaySession play = playHud.studio.getPlay();
                if (play != null && play.getShiftLock()) {
                    play.toggleShiftLock();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit settingsPage$lambda$69(int i) {
        Settings.INSTANCE.setCameraMode(i == 0 ? "Classic" : "Follow");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit settingsPage$lambda$70(int i) {
        Settings.INSTANCE.setMovementMode(i == 1 ? "Thumbstick" : "Dynamic Thumbstick");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit settingsPage$lambda$71(float f) {
        Settings.INSTANCE.setPlayCameraSensitivity(f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit settingsPage$lambda$72(float f) {
        Settings.INSTANCE.setVolume((int) f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit settingsPage$lambda$73(PlayHud playHud, float f) {
        Settings.INSTANCE.setGraphicsQuality(RangesKt.coerceIn((int) f, 1, 10));
        playHud.studio.setShadowsEnabled(Settings.INSTANCE.getGraphicsQuality() >= 4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit settingsPage$lambda$74(int i) {
        Settings.INSTANCE.setShowFps(i == 1);
        return Unit.INSTANCE;
    }

    private static final void settingsPage$row(PlayHud playHud, LinearLayout linearLayout, String str, View view) {
        LinearLayout linearLayout2 = new LinearLayout(playHud.getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setPadding(playHud.dp(6.0f), playHud.dp(8.0f), playHud.dp(6.0f), playHud.dp(8.0f));
        linearLayout2.addView(label$default(playHud, str, 15.0f, 0, false, 12, null), new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout2.addView(view);
        linearLayout.addView(linearLayout2);
        View view2 = new View(playHud.getContext());
        view2.setBackgroundColor(452984831);
        linearLayout.addView(view2, new LinearLayout.LayoutParams(-1, 1));
    }

    private static final View settingsPage$selector(PlayHud playHud, List<String> list, int i, Function1<? super Integer, Unit> function1) {
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i;
        LinearLayout linearLayout = new LinearLayout(playHud.getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        TextView label$default = label$default(playHud, list.get(intRef.element), 14.0f, 0, true, 4, null);
        label$default.setGravity(17);
        label$default.setMinWidth(playHud.dp(130.0f));
        linearLayout.addView(settingsPage$selector$arrow(playHud, intRef, list, label$default, function1, "‹", -1));
        linearLayout.addView(label$default);
        linearLayout.addView(settingsPage$selector$arrow(playHud, intRef, list, label$default, function1, "›", 1));
        return linearLayout;
    }

    private static final TextView settingsPage$selector$arrow(PlayHud playHud, Ref.IntRef intRef, List<String> list, TextView textView, Function1<? super Integer, Unit> function1, String str, int i) {
        TextView label$default = label$default(playHud, str, 18.0f, 0, true, 4, null);
        label$default.setPadding(playHud.dp(10.0f), playHud.dp(2.0f), playHud.dp(10.0f), playHud.dp(2.0f));
        label$default.setClickable(true);
        label$default.setOnClickListener(new PlayHud$$ExternalSyntheticLambda18(intRef, i, list, textView, function1));
        return label$default;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void settingsPage$selector$arrow$lambda$64$lambda$63(Ref.IntRef intRef, int i, List list, TextView textView, Function1 function1, View view) {
        intRef.element = Math.floorMod(intRef.element + i, list.size());
        textView.setText((CharSequence) list.get(intRef.element));
        function1.invoke(Integer.valueOf(intRef.element));
    }

    private static final View settingsPage$slider(PlayHud playHud, float f, float f2, float f3, Function1<? super Float, Unit> function1) {
        SeekBar seekBar = new SeekBar(playHud.getContext());
        seekBar.setMax(100);
        seekBar.setProgress(RangesKt.coerceIn((int) (((f - f2) / (f3 - f2)) * 100.0f), 0, 100));
        seekBar.setOnSeekBarChangeListener(new PlayHud$settingsPage$slider$1$1(function1, f2, f3));
        seekBar.setLayoutParams(new LinearLayout.LayoutParams(playHud.dp(170.0f), -2));
        return seekBar;
    }

    private final void updateChatVisibility() {
        PlaySession play = this.studio.getPlay();
        boolean z = !((play == null || play.getCoreChat()) ? false : true);
        this.chatBtn.setVisibility(z ? 0 : 8);
        this.chatBox.setVisibility((z && this.chatOpen) ? 0 : 8);
        this.chatBtn.setActive(this.chatOpen);
        this.chatBtn.invalidate();
    }

    public final void focusChat() {
        PlaySession play = this.studio.getPlay();
        if ((play == null || play.getCoreChat()) ? false : true) {
            return;
        }
        this.chatOpen = true;
        updateChatVisibility();
        this.chatBar.requestFocus();
        Object systemService = getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(this.chatBar, 0);
    }

    public final boolean handleBack() {
        if (this.menu != null) {
            closeMenu();
            return true;
        }
        if (!this.chatBar.hasFocus()) {
            return false;
        }
        hideKeyboard();
        this.chatBar.clearFocus();
        return true;
    }

    public final void onFrame() {
        PlaySession play;
        if (getVisibility() == 0 && (play = this.studio.getPlay()) != null) {
            int chatVersion = play.getChatVersion();
            if (chatVersion != this.seenChat) {
                this.seenChat = chatVersion;
                this.lastChatActivity = System.currentTimeMillis();
                this.chatLog.reload();
            }
            this.chatBox.setAlpha(((System.currentTimeMillis() - this.lastChatActivity) > 12000L ? 1 : ((System.currentTimeMillis() - this.lastChatActivity) == 12000L ? 0 : -1)) > 0 && !this.chatBar.hasFocus() ? 0.35f : 1.0f);
            this.listBtn.setVisibility(play.getCorePlayerList() ? 0 : 8);
            if (this.chatBtn.getVisibility() != (play.getCoreChat() ? 0 : 8)) {
                updateChatVisibility();
            }
            this.layer.invalidate();
        }
    }

    public final void onPlayStateChanged() {
        boolean isPlaying = this.studio.isPlaying();
        setVisibility(isPlaying ? 0 : 8);
        if (isPlaying) {
            this.lastChatActivity = System.currentTimeMillis();
            this.seenChat = -1;
        } else {
            closeMenu();
            hideKeyboard();
            this.chatBar.setText("");
        }
        updateChatVisibility();
    }

    public final void toggleMenu() {
        if (this.menu != null) {
            closeMenu();
        } else {
            openMenu();
        }
    }

    public final void togglePlayerList() {
        this.playerListOpen = !this.playerListOpen;
        this.listBtn.setActive(this.playerListOpen);
        this.listBtn.invalidate();
        this.layer.invalidate();
    }
}
