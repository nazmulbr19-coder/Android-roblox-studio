package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.exampletest.mobilestudiotest.core.Settings;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.core.Theme;
import com.exampletest.mobilestudiotest.lua.LuauTranspiler;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.ui.Autocomplete;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.lib.jse.JsePlatform;

/* compiled from: ScriptEditor.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u0000 H2\u00020\u0001:\u0003HIJB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-H\u0002J \u0010.\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0016H\u0002J\u0010\u00102\u001a\u00020(2\u0006\u0010)\u001a\u00020-H\u0002J\u0010\u00103\u001a\u00020(2\u0006\u00104\u001a\u00020\u0018H\u0002J\u0014\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001606H\u0002J\b\u00107\u001a\u00020(H\u0002J\b\u00108\u001a\u00020(H\u0002J\u001c\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016062\u0006\u0010:\u001a\u00020\u0016H\u0002J\b\u0010;\u001a\u00020(H\u0002J\u0010\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020\u0016H\u0002J\u0010\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020\u0016H\u0002J\b\u0010@\u001a\u00020(H\u0002J\u0006\u0010A\u001a\u00020(J\b\u0010B\u001a\u00020(H\u0002J\u0010\u0010C\u001a\u00020(2\u0006\u0010D\u001a\u00020\u0016H\u0002J\b\u0010E\u001a\u00020(H\u0002J\b\u0010F\u001a\u00020(H\u0002J\b\u0010G\u001a\u00020(H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00060\rR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ScriptEditor;", "Landroid/widget/LinearLayout;", "ctx", "Landroid/content/Context;", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "script", "Lcom/exampletest/mobilestudiotest/model/Instance;", "<init>", "(Landroid/content/Context;Lcom/exampletest/mobilestudiotest/core/Studio;Lcom/exampletest/mobilestudiotest/model/Instance;)V", "getScript", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "editor", "Lcom/exampletest/mobilestudiotest/ui/ScriptEditor$CodeEdit;", "lines", "Landroid/widget/TextView;", NotificationCompat.CATEGORY_STATUS, "scroll", "Landroid/widget/ScrollView;", "hsv", "Landroid/widget/HorizontalScrollView;", "lineCount", "", "highlighting", "", "dirtyText", "highlightRunnable", "Ljava/lang/Runnable;", "commitRunnable", "completeRunnable", "popup", "Landroid/widget/PopupWindow;", "popupList", "Landroid/widget/ListView;", "completion", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$Result;", "selectedIdx", "suppressCompletion", "autoClosedAt", "handleNewline", "", "s", "Landroid/text/Editable;", "unbalancedEnds", "text", "", "handleTypedChar", "c", "", "at", "insert", "updateCompletion", "explicit", "popupSize", "Lkotlin/Pair;", "showPopup", "positionPopup", "cursorScreenPos", "popupH", "hidePopup", "moveSelection", "delta", "acceptCompletion", "index", "updateLines", "commit", "checkSyntax", "goToLine", "line", "find", "highlight", "onDetachedFromWindow", "Companion", "CodeEdit", "CompletionAdapter", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ScriptEditor extends LinearLayout {
    private static final Set<String> builtins;
    private static final Map<Character, Character> pairs;
    private static final Lazy<Globals> syntaxCheck$delegate;
    private int autoClosedAt;
    private final Runnable commitRunnable;
    private final Runnable completeRunnable;
    private Autocomplete.Result completion;
    private boolean dirtyText;
    private final CodeEdit editor;
    private final Runnable highlightRunnable;
    private boolean highlighting;
    private final HorizontalScrollView hsv;
    private int lineCount;
    private final TextView lines;
    private PopupWindow popup;
    private final ListView popupList;
    private final Instance script;
    private final ScrollView scroll;
    private int selectedIdx;
    private final TextView status;
    private final Studio studio;
    private boolean suppressCompletion;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> keywords = SetsKt.setOf((Object[]) new String[]{"and", "break", "do", "else", "elseif", "end", "false", "for", "function", "if", "in", "local", "nil", "not", "or", "repeat", "return", "then", "true", "until", "while", "continue", "export", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "self"});

    /* compiled from: ScriptEditor.kt */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J*\u0010\u0010\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"com/exampletest/mobilestudiotest/ui/ScriptEditor$15", "Landroid/text/TextWatcher;", "autoIndent", "", "typed", "", "Ljava/lang/Character;", "typedAt", "", "beforeTextChanged", "", "s", "", "start", "count", "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.exampletest.mobilestudiotest.ui.ScriptEditor$15, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass15 implements TextWatcher {
        private boolean autoIndent;
        private Character typed;
        private int typedAt = -1;

        AnonymousClass15() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            if (ScriptEditor.access$getHighlighting$p(ScriptEditor.this) || s == null) {
                return;
            }
            if (this.autoIndent && Settings.INSTANCE.getAutoIndent()) {
                this.autoIndent = false;
                ScriptEditor.access$handleNewline(ScriptEditor.this, s);
            } else if (this.typed != null && Settings.INSTANCE.getAutoCloseBrackets()) {
                ScriptEditor scriptEditor = ScriptEditor.this;
                Character ch = this.typed;
                Intrinsics.checkNotNull(ch);
                ScriptEditor.access$handleTypedChar(scriptEditor, s, ch.charValue(), this.typedAt);
            }
            this.typed = null;
            ScriptEditor.access$setDirtyText$p(ScriptEditor.this, true);
            ScriptEditor.access$updateLines(ScriptEditor.this);
            ScriptEditor.this.removeCallbacks(ScriptEditor.access$getHighlightRunnable$p(ScriptEditor.this));
            ScriptEditor.this.postDelayed(ScriptEditor.access$getHighlightRunnable$p(ScriptEditor.this), 250L);
            ScriptEditor.this.removeCallbacks(ScriptEditor.access$getCommitRunnable$p(ScriptEditor.this));
            ScriptEditor.this.postDelayed(ScriptEditor.access$getCommitRunnable$p(ScriptEditor.this), 800L);
            if (!Settings.INSTANCE.getAutocomplete() || ScriptEditor.access$getSuppressCompletion$p(ScriptEditor.this)) {
                return;
            }
            ScriptEditor.this.removeCallbacks(ScriptEditor.access$getCompleteRunnable$p(ScriptEditor.this));
            ScriptEditor.this.postDelayed(ScriptEditor.access$getCompleteRunnable$p(ScriptEditor.this), 70L);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            this.autoIndent = count == 1 && before == 0 && s != null && start < s.length() && s.charAt(start) == '\n';
            this.typed = (count != 1 || before != 0 || s == null || start >= s.length()) ? null : Character.valueOf(s.charAt(start));
            this.typedAt = start;
        }
    }

    /* compiled from: ScriptEditor.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0014J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ScriptEditor$CodeEdit;", "Landroid/widget/EditText;", "c", "Landroid/content/Context;", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ScriptEditor;Landroid/content/Context;)V", "onSelectionChanged", "", "selStart", "", "selEnd", "onKeyDown", "", "keyCode", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private final class CodeEdit extends EditText {
        final /* synthetic */ ScriptEditor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CodeEdit(ScriptEditor scriptEditor, Context c) {
            super(c);
            Intrinsics.checkNotNullParameter(c, "c");
            this.this$0 = scriptEditor;
        }

        @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            PopupWindow access$getPopup$p = ScriptEditor.access$getPopup$p(this.this$0);
            boolean z = false;
            if (access$getPopup$p != null && access$getPopup$p.isShowing()) {
                z = true;
            }
            if (z) {
                switch (keyCode) {
                    case 19:
                        ScriptEditor.access$moveSelection(this.this$0, -1);
                        return true;
                    case 20:
                        ScriptEditor.access$moveSelection(this.this$0, 1);
                        return true;
                    case 61:
                    case 66:
                        ScriptEditor.access$acceptCompletion(this.this$0, ScriptEditor.access$getSelectedIdx$p(this.this$0));
                        return true;
                    case 111:
                        ScriptEditor.access$hidePopup(this.this$0);
                        return true;
                }
            }
            if (keyCode == 62 && event.isCtrlPressed()) {
                ScriptEditor.access$updateCompletion(this.this$0, true);
                return true;
            }
            if (keyCode == 61) {
                ScriptEditor.access$insert(this.this$0, "    ");
                return true;
            }
            return super.onKeyDown(keyCode, event);
        }

        @Override // android.widget.TextView
        protected void onSelectionChanged(int selStart, int selEnd) {
            super.onSelectionChanged(selStart, selEnd);
            Autocomplete.Result access$getCompletion$p = ScriptEditor.access$getCompletion$p(this.this$0);
            if (access$getCompletion$p != null) {
                if (selStart != selEnd || selStart < access$getCompletion$p.getStart() || selStart > access$getCompletion$p.getEnd() + 1) {
                    ScriptEditor.access$hidePopup(this.this$0);
                }
            }
        }
    }

    /* compiled from: ScriptEditor.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\f\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ScriptEditor$Companion;", "", "<init>", "()V", "keywords", "", "", "builtins", "syntaxCheck", "Lorg/luaj/vm2/Globals;", "getSyntaxCheck", "()Lorg/luaj/vm2/Globals;", "syntaxCheck$delegate", "Lkotlin/Lazy;", "pairs", "", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final /* synthetic */ Globals access$getSyntaxCheck(Companion companion) {
            return companion.getSyntaxCheck();
        }

        private final Globals getSyntaxCheck() {
            Object value = ScriptEditor.access$getSyntaxCheck$delegate$cp().getValue();
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Globals) value;
        }
    }

    /* compiled from: ScriptEditor.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005H\u0016J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ScriptEditor$CompletionAdapter;", "Landroid/widget/BaseAdapter;", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ScriptEditor;)V", "getCount", "", "getItem", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$Item;", "p", "getItemId", "", "getView", "Landroid/view/View;", "convert", "parent", "Landroid/view/ViewGroup;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private final class CompletionAdapter extends BaseAdapter {
        public CompletionAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<Autocomplete.Item> items;
            Autocomplete.Result access$getCompletion$p = ScriptEditor.access$getCompletion$p(ScriptEditor.this);
            if (access$getCompletion$p == null || (items = access$getCompletion$p.getItems()) == null) {
                return 0;
            }
            return items.size();
        }

        @Override // android.widget.Adapter
        public Autocomplete.Item getItem(int p) {
            List<Autocomplete.Item> items;
            Autocomplete.Result access$getCompletion$p = ScriptEditor.access$getCompletion$p(ScriptEditor.this);
            if (access$getCompletion$p == null || (items = access$getCompletion$p.getItems()) == null) {
                return null;
            }
            return items.get(p);
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int i) {
            return getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int p) {
            return p;
        }

        @Override // android.widget.Adapter
        public View getView(int p, View convert, ViewGroup parent) {
            List<Autocomplete.Item> items;
            Autocomplete.Item item;
            String str;
            Intrinsics.checkNotNullParameter(parent, "parent");
            Context context = parent.getContext();
            LinearLayout linearLayout = convert instanceof LinearLayout ? (LinearLayout) convert : null;
            if (linearLayout == null) {
                linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(0);
                linearLayout.setGravity(16);
                Ui ui = Ui.INSTANCE;
                Intrinsics.checkNotNull(context);
                linearLayout.setPadding(ui.dp(context, 6.0f), 0, Ui.INSTANCE.dp(context, 8.0f), 0);
                linearLayout.setMinimumHeight(Ui.INSTANCE.dp(context, 30.0f));
                TextView textView = new TextView(context);
                textView.setTextSize(9.0f);
                textView.setGravity(17);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                textView.setTextColor(-14803426);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Ui.INSTANCE.dp(context, 22.0f), Ui.INSTANCE.dp(context, 16.0f));
                layoutParams.rightMargin = Ui.INSTANCE.dp(context, 8.0f);
                Unit unit = Unit.INSTANCE;
                linearLayout.addView(textView, layoutParams);
                TextView textView2 = new TextView(context);
                textView2.setTextSize(13.0f);
                textView2.setTypeface(Typeface.MONOSPACE);
                textView2.setSingleLine(true);
                linearLayout.addView(textView2, new LinearLayout.LayoutParams(0, -2, 1.0f));
                TextView textView3 = new TextView(context);
                textView3.setTextSize(10.0f);
                textView3.setSingleLine(true);
                textView3.setTextColor(Ui.INSTANCE.getDIM());
                linearLayout.addView(textView3);
            }
            Autocomplete.Result access$getCompletion$p = ScriptEditor.access$getCompletion$p(ScriptEditor.this);
            if (access$getCompletion$p == null || (items = access$getCompletion$p.getItems()) == null || (item = (Autocomplete.Item) CollectionsKt.getOrNull(items, p)) == null) {
                return linearLayout;
            }
            View childAt = linearLayout.getChildAt(0);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView4 = (TextView) childAt;
            textView4.setText(item.getKind().getBadge());
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(item.getKind().getColor());
            Ui ui2 = Ui.INSTANCE;
            Intrinsics.checkNotNull(context);
            gradientDrawable.setCornerRadius(ui2.dp(context, 3.0f));
            textView4.setBackground(gradientDrawable);
            View childAt2 = linearLayout.getChildAt(1);
            Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView5 = (TextView) childAt2;
            Autocomplete.Result access$getCompletion$p2 = ScriptEditor.access$getCompletion$p(ScriptEditor.this);
            if (access$getCompletion$p2 == null || (str = access$getCompletion$p2.getPrefix()) == null) {
                str = "";
            }
            SpannableString spannableString = new SpannableString(item.getLabel());
            String lowerCase = item.getLabel().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String str2 = lowerCase;
            String lowerCase2 = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            int indexOf$default = StringsKt.indexOf$default((CharSequence) str2, lowerCase2, 0, false, 6, (Object) null);
            if ((str.length() > 0) && indexOf$default >= 0) {
                spannableString.setSpan(new StyleSpan(1), indexOf$default, str.length() + indexOf$default, 33);
            }
            textView5.setText(spannableString);
            textView5.setTextColor(Ui.INSTANCE.getEDITOR_TEXT());
            View childAt3 = linearLayout.getChildAt(2);
            Intrinsics.checkNotNull(childAt3, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) childAt3).setText(item.getDetail());
            linearLayout.setBackgroundColor(p == ScriptEditor.access$getSelectedIdx$p(ScriptEditor.this) ? Ui.INSTANCE.blend(Ui.INSTANCE.getACCENT(), Ui.INSTANCE.getEDITOR_BG(), 0.55f) : 0);
            return linearLayout;
        }
    }

    static {
        Character valueOf = Character.valueOf(Typography.quote);
        builtins = SetsKt.setOf((Object[]) new String[]{"game", "workspace", "script", "plugin", "Instance", "Vector3", "Vector2", "CFrame", "Color3", "BrickColor", "UDim", "UDim2", "Enum", "TweenInfo", "Ray", "task", "wait", "print", "warn", "error", "pairs", "ipairs", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_TAG_MATH, TypedValues.Custom.S_STRING, "table", "require", "typeof", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "tostring", "tonumber", "pcall", "xpcall", "spawn", "delay", "tick", "time", "os", "coroutine", "setmetatable", "getmetatable", "rawget", "rawset", "select", "next", "unpack", "assert", "shared", "_G", "NumberRange", "NumberSequence", "ColorSequence", "Random", "RaycastParams", "OverlapParams", "utf8", "bit32", "debug", "buffer", "DateTime"});
        syntaxCheck$delegate = LazyKt.lazy(new ScriptEditor$$ExternalSyntheticLambda0());
        pairs = MapsKt.mapOf(TuplesKt.to('(', ')'), TuplesKt.to('[', ']'), TuplesKt.to('{', '}'), TuplesKt.to(valueOf, valueOf), TuplesKt.to('\'', '\''));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptEditor(Context ctx, Studio studio, Instance script) {
        super(ctx);
        String str;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(studio, "studio");
        Intrinsics.checkNotNullParameter(script, "script");
        this.studio = studio;
        this.script = script;
        this.highlightRunnable = new ScriptEditor$$ExternalSyntheticLambda3(this);
        this.commitRunnable = new ScriptEditor$$ExternalSyntheticLambda4(this);
        this.completeRunnable = new ScriptEditor$$ExternalSyntheticLambda5(this);
        this.autoClosedAt = -1;
        setOrientation(1);
        setBackgroundColor(Ui.INSTANCE.getEDITOR_BG());
        LinearLayout linearLayout = new LinearLayout(ctx);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackgroundColor(Ui.INSTANCE.getHEADER());
        TextView text$default = Ui.text$default(Ui.INSTANCE, ctx, "", 11.0f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default.setPadding(Ui.INSTANCE.dp(ctx, 8.0f), 0, Ui.INSTANCE.dp(ctx, 8.0f), 0);
        this.status = text$default;
        ImageView imageView = new ImageView(ctx);
        imageView.setImageDrawable(Ui.INSTANCE.icon(ctx, this.script));
        LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, Ui.INSTANCE.dp(ctx, 16.0f), Ui.INSTANCE.dp(ctx, 16.0f), 0.0f, 4, null);
        lp$default.leftMargin = Ui.INSTANCE.dp(ctx, 8.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(imageView, lp$default);
        TextView text$default2 = Ui.text$default(Ui.INSTANCE, ctx, this.script.fullName(), 12.0f, 0, false, 24, null);
        text$default2.setPadding(Ui.INSTANCE.dp(ctx, 6.0f), 0, 0, 0);
        linearLayout.addView(text$default2, Ui.INSTANCE.lp(0, -2, 1.0f));
        linearLayout.addView(this.status);
        linearLayout.addView(Ui.INSTANCE.iconTextButton(ctx, Icons.INSTANCE.general(ctx, "ScriptAnalysis", "Chk"), "Check", 0, new ScriptEditor$$ExternalSyntheticLambda6(this)));
        linearLayout.addView(Ui.iconButton$default(Ui.INSTANCE, ctx, Icons.INSTANCE.general(ctx, "FindAll", "Find"), 0.0f, new ScriptEditor$$ExternalSyntheticLambda7(this), 4, null));
        addView(linearLayout, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        float editorFontSize = Settings.INSTANCE.getEditorFontSize();
        TextView textView = new TextView(ctx);
        textView.setTypeface(Typeface.MONOSPACE);
        textView.setTextSize(editorFontSize);
        textView.setTextColor(Ui.INSTANCE.blend(Ui.INSTANCE.getEDITOR_GUTTER(), Ui.INSTANCE.getEDITOR_TEXT(), 0.45f));
        textView.setGravity(GravityCompat.END);
        textView.setPadding(Ui.INSTANCE.dp(ctx, 6.0f), Ui.INSTANCE.dp(ctx, 8.0f), Ui.INSTANCE.dp(ctx, 6.0f), Ui.INSTANCE.dp(ctx, 8.0f));
        textView.setBackgroundColor(Ui.INSTANCE.getEDITOR_GUTTER());
        this.lines = textView;
        CodeEdit codeEdit = new CodeEdit(this, ctx);
        codeEdit.setTypeface(Typeface.MONOSPACE);
        codeEdit.setTextSize(editorFontSize);
        codeEdit.setTextColor(Ui.INSTANCE.getEDITOR_TEXT());
        codeEdit.setBackground(null);
        codeEdit.setGravity(8388659);
        codeEdit.setInputType(655361);
        codeEdit.setHorizontallyScrolling(false);
        codeEdit.setPadding(Ui.INSTANCE.dp(ctx, 8.0f), Ui.INSTANCE.dp(ctx, 8.0f), Ui.INSTANCE.dp(ctx, 24.0f), Ui.INSTANCE.dp(ctx, 200.0f));
        codeEdit.setMinWidth(codeEdit.getResources().getDisplayMetrics().widthPixels);
        synchronized (this.studio.getLock()) {
            try {
                Object obj = this.script.get("Source");
                if (obj instanceof String) {
                    try {
                        str = (String) obj;
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } else {
                    str = null;
                }
                codeEdit.setText(str == null ? "" : str);
                this.editor = codeEdit;
                HorizontalScrollView horizontalScrollView = new HorizontalScrollView(ctx);
                horizontalScrollView.setFillViewport(true);
                horizontalScrollView.addView(this.editor);
                this.hsv = horizontalScrollView;
                LinearLayout linearLayout2 = new LinearLayout(ctx);
                linearLayout2.setOrientation(0);
                linearLayout2.addView(this.lines, Ui.lp$default(Ui.INSTANCE, -2, -1, 0.0f, 4, null));
                linearLayout2.addView(this.hsv, Ui.INSTANCE.lp(0, -2, 1.0f));
                ScrollView scrollView = new ScrollView(ctx);
                scrollView.setFillViewport(true);
                scrollView.addView(linearLayout2);
                this.scroll = scrollView;
                addView(this.scroll, Ui.INSTANCE.lp(-1, 0, 1.0f));
                this.scroll.getViewTreeObserver().addOnScrollChangedListener(new ScriptEditor$$ExternalSyntheticLambda8(this));
                LinearLayout linearLayout3 = new LinearLayout(ctx);
                linearLayout3.setOrientation(0);
                linearLayout3.setBackgroundColor(Ui.INSTANCE.getHEADER());
                for (String str2 : CollectionsKt.listOf((Object[]) new String[]{"Tab", "(", ")", "{", "}", "[", "]", "=", "\"", ":", ".", ",", "~", "#", "end", "local", "function", "then"})) {
                    linearLayout3.addView(Ui.INSTANCE.smallIconButton(ctx, str2, new ScriptEditor$$ExternalSyntheticLambda9(this, str2)));
                }
                HorizontalScrollView horizontalScrollView2 = new HorizontalScrollView(ctx);
                horizontalScrollView2.addView(linearLayout3);
                addView(horizontalScrollView2, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
                ListView listView = new ListView(ctx);
                listView.setDivider(null);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Ui.INSTANCE.blend(Ui.INSTANCE.getEDITOR_BG(), Ui.INSTANCE.getLIGHT() ? -16777216 : -1, 0.07f));
                gradientDrawable.setStroke(Ui.INSTANCE.dp(ctx, 1.0f), Ui.INSTANCE.getBORDER());
                gradientDrawable.setCornerRadius(Ui.INSTANCE.dp(ctx, 4.0f));
                listView.setBackground(gradientDrawable);
                listView.setAdapter((ListAdapter) new CompletionAdapter());
                listView.setOnItemClickListener(new ScriptEditor$$ExternalSyntheticLambda10(this));
                this.popupList = listView;
                this.editor.addTextChangedListener(new AnonymousClass15());
                updateLines();
                highlight();
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$16(ScriptEditor scriptEditor) {
        PopupWindow popupWindow = scriptEditor.popup;
        boolean z = false;
        if (popupWindow != null && popupWindow.isShowing()) {
            z = true;
        }
        if (z) {
            scriptEditor.positionPopup();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$18(ScriptEditor scriptEditor, String str, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        scriptEditor.insert(Intrinsics.areEqual(str, "Tab") ? "    " : str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$8(ScriptEditor scriptEditor, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        scriptEditor.checkSyntax();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$9(ScriptEditor scriptEditor, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        scriptEditor.find();
        return Unit.INSTANCE;
    }

    private final void acceptCompletion(int index) {
        Autocomplete.Item item;
        Autocomplete.Result result = this.completion;
        if (result == null || (item = (Autocomplete.Item) CollectionsKt.getOrNull(result.getItems(), index)) == null) {
            return;
        }
        Editable text = this.editor.getText();
        int coerceIn = RangesKt.coerceIn(this.editor.getSelectionStart(), result.getStart(), text.length());
        while (coerceIn < text.length() && (Character.isLetterOrDigit(text.charAt(coerceIn)) || text.charAt(coerceIn) == '_')) {
            coerceIn++;
        }
        removeCallbacks(this.completeRunnable);
        hidePopup();
        this.suppressCompletion = true;
        try {
            text.replace(result.getStart(), coerceIn, item.getInsert());
            this.editor.setSelection(RangesKt.coerceAtMost(result.getStart() + item.getInsert().length(), this.editor.getText().length()));
        } finally {
            this.suppressCompletion = false;
        }
    }

    public static final /* synthetic */ void access$acceptCompletion(ScriptEditor scriptEditor, int i) {
        scriptEditor.acceptCompletion(i);
    }

    public static final /* synthetic */ Runnable access$getCommitRunnable$p(ScriptEditor scriptEditor) {
        return scriptEditor.commitRunnable;
    }

    public static final /* synthetic */ Runnable access$getCompleteRunnable$p(ScriptEditor scriptEditor) {
        return scriptEditor.completeRunnable;
    }

    public static final /* synthetic */ Autocomplete.Result access$getCompletion$p(ScriptEditor scriptEditor) {
        return scriptEditor.completion;
    }

    public static final /* synthetic */ Runnable access$getHighlightRunnable$p(ScriptEditor scriptEditor) {
        return scriptEditor.highlightRunnable;
    }

    public static final /* synthetic */ boolean access$getHighlighting$p(ScriptEditor scriptEditor) {
        return scriptEditor.highlighting;
    }

    public static final /* synthetic */ PopupWindow access$getPopup$p(ScriptEditor scriptEditor) {
        return scriptEditor.popup;
    }

    public static final /* synthetic */ int access$getSelectedIdx$p(ScriptEditor scriptEditor) {
        return scriptEditor.selectedIdx;
    }

    public static final /* synthetic */ boolean access$getSuppressCompletion$p(ScriptEditor scriptEditor) {
        return scriptEditor.suppressCompletion;
    }

    public static final /* synthetic */ Lazy access$getSyntaxCheck$delegate$cp() {
        return syntaxCheck$delegate;
    }

    public static final /* synthetic */ void access$handleNewline(ScriptEditor scriptEditor, Editable editable) {
        scriptEditor.handleNewline(editable);
    }

    public static final /* synthetic */ void access$handleTypedChar(ScriptEditor scriptEditor, Editable editable, char c, int i) {
        scriptEditor.handleTypedChar(editable, c, i);
    }

    public static final /* synthetic */ void access$hidePopup(ScriptEditor scriptEditor) {
        scriptEditor.hidePopup();
    }

    public static final /* synthetic */ void access$insert(ScriptEditor scriptEditor, String str) {
        scriptEditor.insert(str);
    }

    public static final /* synthetic */ void access$moveSelection(ScriptEditor scriptEditor, int i) {
        scriptEditor.moveSelection(i);
    }

    public static final /* synthetic */ void access$setDirtyText$p(ScriptEditor scriptEditor, boolean z) {
        scriptEditor.dirtyText = z;
    }

    public static final /* synthetic */ void access$updateCompletion(ScriptEditor scriptEditor, boolean z) {
        scriptEditor.updateCompletion(z);
    }

    public static final /* synthetic */ void access$updateLines(ScriptEditor scriptEditor) {
        scriptEditor.updateLines();
    }

    private final void checkSyntax() {
        List<String> groupValues;
        String str;
        Integer intOrNull;
        commit();
        try {
            Companion.access$getSyntaxCheck(INSTANCE).load(LuauTranspiler.transpile$default(LuauTranspiler.INSTANCE, this.editor.getText().toString(), false, 2, null), "=" + this.script.getName());
            this.status.setText("No syntax errors");
            this.status.setTextColor(-13726889);
        } catch (LuaError e) {
            TextView textView = this.status;
            String message = e.getMessage();
            if (message == null) {
                message = "Syntax error";
            }
            textView.setText(message);
            this.status.setTextColor(Ui.ERROR);
            Regex regex = new Regex(":(\\d+):");
            String message2 = e.getMessage();
            if (message2 == null) {
                message2 = "";
            }
            MatchResult find$default = Regex.find$default(regex, message2, 0, 2, null);
            if (find$default == null || (groupValues = find$default.getGroupValues()) == null || (str = groupValues.get(1)) == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) {
                return;
            }
            goToLine(intOrNull.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void commitRunnable$lambda$1(ScriptEditor scriptEditor) {
        scriptEditor.commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void completeRunnable$lambda$2(ScriptEditor scriptEditor) {
        scriptEditor.updateCompletion(false);
    }

    private final Pair<Integer, Integer> cursorScreenPos(int popupH) {
        Layout layout = this.editor.getLayout();
        if (layout == null) {
            return TuplesKt.to(0, 0);
        }
        int coerceIn = RangesKt.coerceIn(this.editor.getSelectionStart(), 0, this.editor.getText().length());
        int lineForOffset = layout.getLineForOffset(coerceIn);
        int[] iArr = new int[2];
        this.editor.getLocationOnScreen(iArr);
        int totalPaddingLeft = iArr[0] + this.editor.getTotalPaddingLeft() + ((int) layout.getPrimaryHorizontal(coerceIn));
        int totalPaddingTop = iArr[1] + this.editor.getTotalPaddingTop() + layout.getLineBottom(lineForOffset);
        int totalPaddingTop2 = ((iArr[1] + this.editor.getTotalPaddingTop()) + layout.getLineTop(lineForOffset)) - popupH;
        Rect rect = new Rect();
        this.editor.getWindowVisibleDisplayFrame(rect);
        return TuplesKt.to(Integer.valueOf(RangesKt.coerceIn(totalPaddingLeft, rect.left, Math.max(rect.left, rect.right - popupSize().component1().intValue()))), Integer.valueOf((totalPaddingTop + popupH <= rect.bottom || totalPaddingTop2 <= rect.top) ? totalPaddingTop : totalPaddingTop2));
    }

    private final void find() {
        Dialogs dialogs = Dialogs.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        dialogs.prompt(context, "Find", "", new ScriptEditor$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit find$lambda$35(ScriptEditor scriptEditor, String q) {
        Intrinsics.checkNotNullParameter(q, "q");
        if (q.length() == 0) {
            return Unit.INSTANCE;
        }
        String obj = scriptEditor.editor.getText().toString();
        int indexOf$default = StringsKt.indexOf$default((CharSequence) obj, q, RangesKt.coerceAtLeast(scriptEditor.editor.getSelectionEnd(), 0), false, 4, (Object) null);
        if (indexOf$default < 0) {
            indexOf$default = StringsKt.indexOf$default((CharSequence) obj, q, 0, false, 6, (Object) null);
        }
        if (indexOf$default >= 0) {
            scriptEditor.editor.requestFocus();
            scriptEditor.editor.setSelection(indexOf$default, q.length() + indexOf$default);
        } else {
            scriptEditor.status.setText("\"" + q + "\" not found");
        }
        return Unit.INSTANCE;
    }

    private final void goToLine(int line) {
        Editable text = this.editor.getText();
        int i = line - 1;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Intrinsics.checkNotNull(text);
            int indexOf$default = StringsKt.indexOf$default((CharSequence) text, '\n', i2, false, 4, (Object) null);
            if (indexOf$default >= 0) {
                i2 = indexOf$default + 1;
            }
        }
        this.editor.requestFocus();
        this.editor.setSelection(RangesKt.coerceIn(i2, 0, text.length()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:136:0x02a0, code lost:
    
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r19, (java.lang.CharSequence) "(", false, 2, (java.lang.Object) null) != false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02a5, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0130, code lost:
    
        if (kotlin.text.StringsKt.startsWith$default(r8, "elseif", false, 2, (java.lang.Object) null) != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01e7, code lost:
    
        r5 = r14.substring(0, r4);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "substring(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01ee, code lost:
    
        r14 = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0148 A[Catch: all -> 0x02e8, TRY_ENTER, TryCatch #5 {all -> 0x02e8, blocks: (B:51:0x0126, B:61:0x0148, B:63:0x014e, B:68:0x016a, B:77:0x01b8, B:54:0x0135), top: B:50:0x0126 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01f0 A[LOOP:1: B:79:0x01c7->B:88:0x01f0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01e6 A[EDGE_INSN: B:89:0x01e6->B:90:0x01e6 BREAK  A[LOOP:1: B:79:0x01c7->B:88:0x01f0], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void handleNewline(android.text.Editable r31) {
        /*
            Method dump skipped, instructions count: 765
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.ScriptEditor.handleNewline(android.text.Editable):void");
    }

    private final void handleTypedChar(Editable s, char c, int at) {
        this.suppressCompletion = true;
        try {
            if (this.autoClosedAt == at && at + 1 < s.length() && s.charAt(at + 1) == c && SetsKt.setOf((Object[]) new Character[]{')', ']', '}', Character.valueOf(Typography.quote), '\''}).contains(Character.valueOf(c))) {
                s.delete(at + 1, at + 2);
                this.autoClosedAt = -1;
                return;
            }
            if (this.autoClosedAt >= 0 && at <= this.autoClosedAt) {
                this.autoClosedAt++;
            }
            if (c == '\n') {
                this.autoClosedAt = -1;
            }
            Character ch = pairs.get(Character.valueOf(c));
            if (ch != null) {
                char charValue = ch.charValue();
                char charAt = at + 1 < s.length() ? s.charAt(at + 1) : ' ';
                if (Character.isLetterOrDigit(charAt) || charAt == '_') {
                    return;
                }
                if ((c == '\"' || c == '\'') && at > 0 && (Character.isLetterOrDigit(s.charAt(at - 1)) || s.charAt(at - 1) == c)) {
                    return;
                }
                s.insert(at + 1, String.valueOf(charValue));
                this.editor.setSelection(at + 1);
                this.autoClosedAt = at + 1;
            }
        } finally {
            this.suppressCompletion = false;
        }
    }

    private final void hidePopup() {
        this.completion = null;
        PopupWindow popupWindow = this.popup;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        popupWindow.dismiss();
    }

    private final void highlight() {
        boolean z;
        int i;
        Editable text = this.editor.getText();
        Theme theme = Ui.INSTANCE.getTheme();
        int synKeyword = theme.getSynKeyword();
        int synString = theme.getSynString();
        int synNumber = theme.getSynNumber();
        int synComment = theme.getSynComment();
        int synBuiltin = theme.getSynBuiltin();
        boolean z2 = true;
        this.highlighting = true;
        try {
            Iterator it = ArrayIteratorKt.iterator(text.getSpans(0, text.length(), ForegroundColorSpan.class));
            while (it.hasNext()) {
                text.removeSpan((ForegroundColorSpan) it.next());
            }
            String obj = text.toString();
            int length = obj.length();
            int i2 = 0;
            while (i2 < length) {
                char charAt = obj.charAt(i2);
                if (charAt == '-' && i2 + 1 < length && obj.charAt(i2 + 1) == '-') {
                    int highlight$longLevel = highlight$longLevel(length, obj, i2 + 2);
                    if (highlight$longLevel >= 0) {
                        i = highlight$longClose(obj, length, i2 + 4 + highlight$longLevel, highlight$longLevel);
                    } else {
                        int indexOf$default = StringsKt.indexOf$default((CharSequence) obj, '\n', i2, false, 4, (Object) null);
                        i = indexOf$default < 0 ? length : indexOf$default;
                    }
                    highlight$span(text, length, i2, i, synComment);
                    i2 = i;
                } else {
                    if (charAt == '\"' || charAt == '\'') {
                        z = z2;
                    } else if (charAt == '`') {
                        z = z2;
                    } else if (charAt != '[' || highlight$longLevel(length, obj, i2) < 0) {
                        boolean z3 = z2;
                        if (Character.isDigit(charAt)) {
                            int i3 = i2;
                            while (i3 < length && (Character.isLetterOrDigit(obj.charAt(i3)) || obj.charAt(i3) == '.' || obj.charAt(i3) == '_')) {
                                i3++;
                            }
                            highlight$span(text, length, i2, i3, synNumber);
                            i2 = i3;
                            z2 = z3;
                        } else if (Character.isLetter(charAt) || charAt == '_') {
                            int i4 = i2;
                            while (i4 < length && (Character.isLetterOrDigit(obj.charAt(i4)) || obj.charAt(i4) == '_')) {
                                i4++;
                            }
                            String substring = obj.substring(i2, i4);
                            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                            boolean z4 = (i2 <= 0 || !(obj.charAt(i2 + (-1)) == '.' || obj.charAt(i2 + (-1)) == ':')) ? false : z3;
                            if (!z4 && keywords.contains(substring)) {
                                highlight$span(text, length, i2, i4, synKeyword);
                            } else if (!z4 && builtins.contains(substring)) {
                                highlight$span(text, length, i2, i4, synBuiltin);
                            }
                            i2 = i4;
                            z2 = z3;
                        } else {
                            i2++;
                            z2 = z3;
                        }
                    } else {
                        int highlight$longLevel2 = highlight$longLevel(length, obj, i2);
                        int highlight$longClose = highlight$longClose(obj, length, i2 + 2 + highlight$longLevel2, highlight$longLevel2);
                        highlight$span(text, length, i2, highlight$longClose, synString);
                        i2 = highlight$longClose;
                    }
                    int i5 = i2 + 1;
                    while (i5 < length && obj.charAt(i5) != charAt && obj.charAt(i5) != '\n') {
                        if (obj.charAt(i5) == '\\') {
                            i5++;
                        }
                        i5++;
                    }
                    int min = Math.min(i5 + 1, length);
                    highlight$span(text, length, i2, min, synString);
                    i2 = min;
                    z2 = z;
                }
            }
        } finally {
            this.highlighting = false;
        }
    }

    private static final int highlight$longClose(String str, int i, int i2, int i3) {
        String str2 = "]" + StringsKt.repeat("=", i3) + "]";
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, str2, i2, false, 4, (Object) null);
        return indexOf$default < 0 ? i : str2.length() + indexOf$default;
    }

    private static final int highlight$longLevel(int i, String str, int i2) {
        if (i2 >= i || str.charAt(i2) != '[') {
            return -1;
        }
        int i3 = i2 + 1;
        int i4 = 0;
        while (i3 < i && str.charAt(i3) == '=') {
            i4++;
            i3++;
        }
        if (i3 >= i || str.charAt(i3) != '[') {
            return -1;
        }
        return i4;
    }

    private static final void highlight$span(Editable editable, int i, int i2, int i3, int i4) {
        if (i3 > i2) {
            editable.setSpan(new ForegroundColorSpan(i4), i2, Math.min(i3, i), 33);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void highlightRunnable$lambda$0(ScriptEditor scriptEditor) {
        scriptEditor.highlight();
    }

    private final void insert(String s) {
        int coerceAtLeast = RangesKt.coerceAtLeast(this.editor.getSelectionStart(), 0);
        int coerceAtLeast2 = RangesKt.coerceAtLeast(this.editor.getSelectionEnd(), 0);
        this.editor.getText().replace(Math.min(coerceAtLeast, coerceAtLeast2), Math.max(coerceAtLeast, coerceAtLeast2), s);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$22$lambda$21(ScriptEditor scriptEditor, AdapterView adapterView, View view, int i, long j) {
        scriptEditor.acceptCompletion(i);
    }

    private final void moveSelection(int delta) {
        List<Autocomplete.Item> items;
        Autocomplete.Result result = this.completion;
        if (result == null || (items = result.getItems()) == null) {
            return;
        }
        this.selectedIdx = RangesKt.coerceIn(this.selectedIdx + delta, 0, items.size() - 1);
        ListAdapter adapter = this.popupList.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type android.widget.BaseAdapter");
        ((BaseAdapter) adapter).notifyDataSetChanged();
        this.popupList.smoothScrollToPosition(this.selectedIdx);
    }

    private final Pair<Integer, Integer> popupSize() {
        List<Autocomplete.Item> items;
        Autocomplete.Result result = this.completion;
        int size = (result == null || (items = result.getItems()) == null) ? 0 : items.size();
        Ui ui = Ui.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int dp = ui.dp(context, 30.0f);
        Ui ui2 = Ui.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        Integer valueOf = Integer.valueOf(ui2.dp(context2, 280.0f));
        int min = Math.min(size, 7) * dp;
        Ui ui3 = Ui.INSTANCE;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        return TuplesKt.to(valueOf, Integer.valueOf(min + ui3.dp(context3, 4.0f)));
    }

    private final void positionPopup() {
        PopupWindow popupWindow = this.popup;
        if (popupWindow == null) {
            return;
        }
        Pair<Integer, Integer> popupSize = popupSize();
        int intValue = popupSize.component1().intValue();
        int intValue2 = popupSize.component2().intValue();
        Pair<Integer, Integer> cursorScreenPos = cursorScreenPos(intValue2);
        popupWindow.update(cursorScreenPos.component1().intValue(), cursorScreenPos.component2().intValue(), intValue, intValue2);
    }

    private final void showPopup() {
        Pair<Integer, Integer> popupSize = popupSize();
        int intValue = popupSize.component1().intValue();
        int intValue2 = popupSize.component2().intValue();
        PopupWindow popupWindow = this.popup;
        if (popupWindow == null) {
            popupWindow = new PopupWindow((View) this.popupList, intValue, intValue2, false);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setInputMethodMode(2);
            popupWindow.setElevation(8.0f);
            popupWindow.setOnDismissListener(new ScriptEditor$$ExternalSyntheticLambda2(this));
            this.popup = popupWindow;
        }
        Pair<Integer, Integer> cursorScreenPos = cursorScreenPos(intValue2);
        int intValue3 = cursorScreenPos.component1().intValue();
        int intValue4 = cursorScreenPos.component2().intValue();
        if (popupWindow.isShowing()) {
            popupWindow.update(intValue3, intValue4, intValue, intValue2);
        } else {
            popupWindow.showAtLocation(this.editor, 0, intValue3, intValue4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showPopup$lambda$29$lambda$28(ScriptEditor scriptEditor) {
        scriptEditor.completion = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Globals syntaxCheck_delegate$lambda$37() {
        return JsePlatform.standardGlobals();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x003b. Please report as an issue. */
    private final int unbalancedEnds(String text) {
        int i = 0;
        int i2 = 0;
        Iterator it = Regex.findAll$default(new Regex("\\b(function|do|then|end|repeat|until|elseif)\\b"), new Regex("--\\[(=*)\\[[\\s\\S]*?]\\1]|--[^\\n]*|\"(\\\\.|[^\"\\\\\\n])*\"|'(\\\\.|[^'\\\\\\n])*'|\\[(=*)\\[[\\s\\S]*?]\\5]").replace(text, " "), 0, 2, null).iterator();
        while (it.hasNext()) {
            String value = ((MatchResult) it.next()).getValue();
            switch (value.hashCode()) {
                case -1300156394:
                    if (!value.equals("elseif")) {
                        break;
                    } else {
                        i--;
                        break;
                    }
                case -934531685:
                    if (!value.equals("repeat")) {
                        break;
                    } else {
                        i++;
                        break;
                    }
                case 3211:
                    if (!value.equals("do")) {
                        break;
                    } else {
                        i++;
                        break;
                    }
                case 100571:
                    if (!value.equals("end")) {
                        break;
                    } else {
                        i2++;
                        break;
                    }
                case 3558941:
                    if (!value.equals("then")) {
                        break;
                    } else {
                        i++;
                        break;
                    }
                case 111443806:
                    if (!value.equals("until")) {
                        break;
                    } else {
                        i2++;
                        break;
                    }
                case 1380938712:
                    if (!value.equals("function")) {
                        break;
                    } else {
                        i++;
                        break;
                    }
            }
        }
        return i - i2;
    }

    private final void updateCompletion(boolean explicit) {
        Autocomplete.Result result;
        if (!Settings.INSTANCE.getAutocomplete() && !explicit) {
            hidePopup();
            return;
        }
        int selectionStart = this.editor.getSelectionStart();
        if (selectionStart == this.editor.getSelectionEnd() && selectionStart >= 0) {
            try {
                result = Autocomplete.INSTANCE.complete(this.studio, this.script, this.editor.getText().toString(), selectionStart, explicit);
            } catch (Exception e) {
                result = null;
                if (result != null) {
                }
                hidePopup();
                return;
            }
            if (result != null || result.getItems().isEmpty()) {
                hidePopup();
                return;
            }
            this.completion = result;
            this.selectedIdx = 0;
            ListAdapter adapter = this.popupList.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type android.widget.BaseAdapter");
            ((BaseAdapter) adapter).notifyDataSetChanged();
            this.popupList.setSelection(0);
            showPopup();
            return;
        }
        hidePopup();
    }

    private final void updateLines() {
        Editable text = this.editor.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        Editable editable = text;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= editable.length()) {
                break;
            }
            if (editable.charAt(i2) == '\n') {
                i++;
            }
            i2++;
        }
        int i3 = i + 1;
        if (i3 == this.lineCount) {
            return;
        }
        this.lineCount = i3;
        StringBuilder sb = new StringBuilder();
        int i4 = 1;
        if (1 <= i3) {
            while (true) {
                sb.append(i4);
                if (i4 < i3) {
                    sb.append('\n');
                }
                if (i4 == i3) {
                    break;
                } else {
                    i4++;
                }
            }
        }
        this.lines.setText(sb);
        this.status.setText(i3 + " lines");
    }

    public final void commit() {
        if (this.dirtyText) {
            this.dirtyText = false;
            String obj = this.editor.getText().toString();
            synchronized (this.studio.getLock()) {
                if (!Intrinsics.areEqual(this.script.get("Source"), obj)) {
                    Instance.set$default(this.script, "Source", obj, false, 4, null);
                    this.studio.markDirty();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final Instance getScript() {
        return this.script;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.completeRunnable);
        hidePopup();
        commit();
        super.onDetachedFromWindow();
    }
}
