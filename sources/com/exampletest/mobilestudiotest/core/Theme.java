package com.exampletest.mobilestudiotest.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: Settings.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b1\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b!\b\u0086\b\u0018\u0000 \\2\u00020\u0001:\u0001\\B¿\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u00108\u001a\u000209J\u0018\u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070<0;J\u0016\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0007J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0007HÆ\u0003J\t\u0010C\u001a\u00020\u0007HÆ\u0003J\t\u0010D\u001a\u00020\u0007HÆ\u0003J\t\u0010E\u001a\u00020\u0007HÆ\u0003J\t\u0010F\u001a\u00020\u0007HÆ\u0003J\t\u0010G\u001a\u00020\u0007HÆ\u0003J\t\u0010H\u001a\u00020\u0007HÆ\u0003J\t\u0010I\u001a\u00020\u0007HÆ\u0003J\t\u0010J\u001a\u00020\u0007HÆ\u0003J\t\u0010K\u001a\u00020\u0007HÆ\u0003J\t\u0010L\u001a\u00020\u0007HÆ\u0003J\t\u0010M\u001a\u00020\u0007HÆ\u0003J\t\u0010N\u001a\u00020\u0007HÆ\u0003J\t\u0010O\u001a\u00020\u0007HÆ\u0003J\t\u0010P\u001a\u00020\u0007HÆ\u0003J\t\u0010Q\u001a\u00020\u0007HÆ\u0003J\t\u0010R\u001a\u00020\u0007HÆ\u0003J\t\u0010S\u001a\u00020\u0007HÆ\u0003J\t\u0010T\u001a\u00020\u0007HÆ\u0003J\t\u0010U\u001a\u00020\u0007HÆ\u0003J\t\u0010V\u001a\u00020\u0007HÆ\u0003Jï\u0001\u0010W\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010X\u001a\u00020\u00052\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Z\u001a\u00020\u0007HÖ\u0001J\t\u0010[\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010#R\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010#R\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u0010#R\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010#R\u0011\u0010\u0015\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u0010#R\u0011\u0010\u0016\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u0010#R\u0011\u0010\u0017\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u0010#R\u0011\u0010\u0018\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b4\u0010#R\u0011\u0010\u0019\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b5\u0010#R\u0011\u0010\u001a\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b6\u0010#R\u0011\u0010\u001b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b7\u0010#¨\u0006]"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/Theme;", "", "name", "", "light", "", "bg", "", "panel", "header", "topbar", "ribbon", "border", "text", "dim", "accent", "select", "hover", "input", "rowAlt", "editorBg", "editorGutter", "editorText", "synKeyword", "synString", "synNumber", "synComment", "synBuiltin", "<init>", "(Ljava/lang/String;ZIIIIIIIIIIIIIIIIIIIII)V", "getName", "()Ljava/lang/String;", "getLight", "()Z", "getBg", "()I", "getPanel", "getHeader", "getTopbar", "getRibbon", "getBorder", "getText", "getDim", "getAccent", "getSelect", "getHover", "getInput", "getRowAlt", "getEditorBg", "getEditorGutter", "getEditorText", "getSynKeyword", "getSynString", "getSynNumber", "getSynComment", "getSynBuiltin", "toJson", "Lorg/json/JSONObject;", "colors", "", "Lkotlin/Pair;", "withColor", "slot", "c", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "equals", "other", "hashCode", "toString", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Theme {
    private final int accent;
    private final int bg;
    private final int border;
    private final int dim;
    private final int editorBg;
    private final int editorGutter;
    private final int editorText;
    private final int header;
    private final int hover;
    private final int input;
    private final boolean light;
    private final String name;
    private final int panel;
    private final int ribbon;
    private final int rowAlt;
    private final int select;
    private final int synBuiltin;
    private final int synComment;
    private final int synKeyword;
    private final int synNumber;
    private final int synString;
    private final int text;
    private final int topbar;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Theme DARK = new Theme("Dark", false, -13750738, -13750738, -13290187, -14342875, -13290187, -15066598, -3355444, -7434610, -16033105, -16033105, -12434878, -14342875, -13421773, -14803426, -14342874, -2039584, -496260, -5377643, -14848, -8750470, -8071433);
    private static final Theme LIGHT = new Theme("Light", true, -855310, -1, -1184275, -1842205, -526345, -3158065, -15000805, -9737365, -16033105, -4466185, -1907998, -1, -526345, -1, -789517, -15000805, -16776961, -5415680, -16086422, -16744448, -15044683);
    private static final Theme MIDNIGHT = copy$default(DARK, "Midnight", false, -14999766, -14802384, -14275781, -15394523, -14275781, -15855334, -2762008, -7892824, -10781446, -12890212, -13617590, -15328731, -14538954, -15328731, -14999765, 0, 0, 0, 0, 0, 0, 8257538, null);
    private static final Theme HIGH_CONTRAST = copy$default(DARK, "High Contrast", false, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, -15066598, ViewCompat.MEASURED_STATE_MASK, -15658735, -9803158, -1, -3618616, -14774017, -16756536, -13421773, ViewCompat.MEASURED_STATE_MASK, -15921907, ViewCompat.MEASURED_STATE_MASK, -15921907, -1, 0, 0, 0, 0, 0, 8126466, null);
    private static final List<Theme> builtIn = CollectionsKt.listOf((Object[]) new Theme[]{DARK, LIGHT, MIDNIGHT, HIGH_CONTRAST});

    /* compiled from: Settings.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/Theme$Companion;", "", "<init>", "()V", "DARK", "Lcom/exampletest/mobilestudiotest/core/Theme;", "getDARK", "()Lcom/exampletest/mobilestudiotest/core/Theme;", "LIGHT", "getLIGHT", "MIDNIGHT", "getMIDNIGHT", "HIGH_CONTRAST", "getHIGH_CONTRAST", "builtIn", "", "getBuiltIn", "()Ljava/util/List;", "fromJson", "o", "Lorg/json/JSONObject;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Theme fromJson(JSONObject o) {
            Intrinsics.checkNotNullParameter(o, "o");
            Theme light = o.optBoolean("light") ? getLIGHT() : getDARK();
            String optString = o.optString("name", TypedValues.Custom.NAME);
            Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
            Theme copy$default = Theme.copy$default(light, optString, o.optBoolean("light"), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8388604, null);
            Iterator<Pair<String, Integer>> it = copy$default.colors().iterator();
            while (it.hasNext()) {
                String component1 = it.next().component1();
                if (o.has(component1)) {
                    copy$default = copy$default.withColor(component1, (int) o.getLong(component1));
                }
            }
            return copy$default;
        }

        public final List<Theme> getBuiltIn() {
            return Theme.access$getBuiltIn$cp();
        }

        public final Theme getDARK() {
            return Theme.access$getDARK$cp();
        }

        public final Theme getHIGH_CONTRAST() {
            return Theme.access$getHIGH_CONTRAST$cp();
        }

        public final Theme getLIGHT() {
            return Theme.access$getLIGHT$cp();
        }

        public final Theme getMIDNIGHT() {
            return Theme.access$getMIDNIGHT$cp();
        }
    }

    public Theme(String name, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.light = z;
        this.bg = i;
        this.panel = i2;
        this.header = i3;
        this.topbar = i4;
        this.ribbon = i5;
        this.border = i6;
        this.text = i7;
        this.dim = i8;
        this.accent = i9;
        this.select = i10;
        this.hover = i11;
        this.input = i12;
        this.rowAlt = i13;
        this.editorBg = i14;
        this.editorGutter = i15;
        this.editorText = i16;
        this.synKeyword = i17;
        this.synString = i18;
        this.synNumber = i19;
        this.synComment = i20;
        this.synBuiltin = i21;
    }

    public static final /* synthetic */ List access$getBuiltIn$cp() {
        return builtIn;
    }

    public static final /* synthetic */ Theme access$getDARK$cp() {
        return DARK;
    }

    public static final /* synthetic */ Theme access$getHIGH_CONTRAST$cp() {
        return HIGH_CONTRAST;
    }

    public static final /* synthetic */ Theme access$getLIGHT$cp() {
        return LIGHT;
    }

    public static final /* synthetic */ Theme access$getMIDNIGHT$cp() {
        return MIDNIGHT;
    }

    public static /* synthetic */ Theme copy$default(Theme theme, String str, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, Object obj) {
        int i23;
        int i24;
        String str2 = (i22 & 1) != 0 ? theme.name : str;
        boolean z2 = (i22 & 2) != 0 ? theme.light : z;
        int i25 = (i22 & 4) != 0 ? theme.bg : i;
        int i26 = (i22 & 8) != 0 ? theme.panel : i2;
        int i27 = (i22 & 16) != 0 ? theme.header : i3;
        int i28 = (i22 & 32) != 0 ? theme.topbar : i4;
        int i29 = (i22 & 64) != 0 ? theme.ribbon : i5;
        int i30 = (i22 & 128) != 0 ? theme.border : i6;
        int i31 = (i22 & 256) != 0 ? theme.text : i7;
        int i32 = (i22 & 512) != 0 ? theme.dim : i8;
        int i33 = (i22 & 1024) != 0 ? theme.accent : i9;
        int i34 = (i22 & 2048) != 0 ? theme.select : i10;
        int i35 = (i22 & 4096) != 0 ? theme.hover : i11;
        int i36 = (i22 & 8192) != 0 ? theme.input : i12;
        String str3 = str2;
        int i37 = (i22 & 16384) != 0 ? theme.rowAlt : i13;
        int i38 = (i22 & 32768) != 0 ? theme.editorBg : i14;
        int i39 = (i22 & 65536) != 0 ? theme.editorGutter : i15;
        int i40 = (i22 & 131072) != 0 ? theme.editorText : i16;
        int i41 = (i22 & 262144) != 0 ? theme.synKeyword : i17;
        int i42 = (i22 & 524288) != 0 ? theme.synString : i18;
        int i43 = (i22 & 1048576) != 0 ? theme.synNumber : i19;
        int i44 = (i22 & 2097152) != 0 ? theme.synComment : i20;
        if ((i22 & 4194304) != 0) {
            i24 = i44;
            i23 = theme.synBuiltin;
        } else {
            i23 = i21;
            i24 = i44;
        }
        return theme.copy(str3, z2, i25, i26, i27, i28, i29, i30, i31, i32, i33, i34, i35, i36, i37, i38, i39, i40, i41, i42, i43, i24, i23);
    }

    public final List<Pair<String, Integer>> colors() {
        return CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("Background", Integer.valueOf(this.bg)), TuplesKt.to("Panel", Integer.valueOf(this.panel)), TuplesKt.to("Header", Integer.valueOf(this.header)), TuplesKt.to("Top bar", Integer.valueOf(this.topbar)), TuplesKt.to("Ribbon", Integer.valueOf(this.ribbon)), TuplesKt.to("Border", Integer.valueOf(this.border)), TuplesKt.to("Text", Integer.valueOf(this.text)), TuplesKt.to("Dim text", Integer.valueOf(this.dim)), TuplesKt.to("Accent", Integer.valueOf(this.accent)), TuplesKt.to("Selection", Integer.valueOf(this.select)), TuplesKt.to("Hover", Integer.valueOf(this.hover)), TuplesKt.to("Input", Integer.valueOf(this.input)), TuplesKt.to("Alternate row", Integer.valueOf(this.rowAlt)), TuplesKt.to("Editor background", Integer.valueOf(this.editorBg)), TuplesKt.to("Editor gutter", Integer.valueOf(this.editorGutter)), TuplesKt.to("Editor text", Integer.valueOf(this.editorText)), TuplesKt.to("Keyword", Integer.valueOf(this.synKeyword)), TuplesKt.to("String", Integer.valueOf(this.synString)), TuplesKt.to("Number", Integer.valueOf(this.synNumber)), TuplesKt.to("Comment", Integer.valueOf(this.synComment)), TuplesKt.to("Built-in", Integer.valueOf(this.synBuiltin))});
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component10, reason: from getter */
    public final int getDim() {
        return this.dim;
    }

    /* renamed from: component11, reason: from getter */
    public final int getAccent() {
        return this.accent;
    }

    /* renamed from: component12, reason: from getter */
    public final int getSelect() {
        return this.select;
    }

    /* renamed from: component13, reason: from getter */
    public final int getHover() {
        return this.hover;
    }

    /* renamed from: component14, reason: from getter */
    public final int getInput() {
        return this.input;
    }

    /* renamed from: component15, reason: from getter */
    public final int getRowAlt() {
        return this.rowAlt;
    }

    /* renamed from: component16, reason: from getter */
    public final int getEditorBg() {
        return this.editorBg;
    }

    /* renamed from: component17, reason: from getter */
    public final int getEditorGutter() {
        return this.editorGutter;
    }

    /* renamed from: component18, reason: from getter */
    public final int getEditorText() {
        return this.editorText;
    }

    /* renamed from: component19, reason: from getter */
    public final int getSynKeyword() {
        return this.synKeyword;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getLight() {
        return this.light;
    }

    /* renamed from: component20, reason: from getter */
    public final int getSynString() {
        return this.synString;
    }

    /* renamed from: component21, reason: from getter */
    public final int getSynNumber() {
        return this.synNumber;
    }

    /* renamed from: component22, reason: from getter */
    public final int getSynComment() {
        return this.synComment;
    }

    /* renamed from: component23, reason: from getter */
    public final int getSynBuiltin() {
        return this.synBuiltin;
    }

    /* renamed from: component3, reason: from getter */
    public final int getBg() {
        return this.bg;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPanel() {
        return this.panel;
    }

    /* renamed from: component5, reason: from getter */
    public final int getHeader() {
        return this.header;
    }

    /* renamed from: component6, reason: from getter */
    public final int getTopbar() {
        return this.topbar;
    }

    /* renamed from: component7, reason: from getter */
    public final int getRibbon() {
        return this.ribbon;
    }

    /* renamed from: component8, reason: from getter */
    public final int getBorder() {
        return this.border;
    }

    /* renamed from: component9, reason: from getter */
    public final int getText() {
        return this.text;
    }

    public final Theme copy(String name, boolean light, int bg, int panel, int header, int topbar, int ribbon, int border, int text, int dim, int accent, int select, int hover, int input, int rowAlt, int editorBg, int editorGutter, int editorText, int synKeyword, int synString, int synNumber, int synComment, int synBuiltin) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new Theme(name, light, bg, panel, header, topbar, ribbon, border, text, dim, accent, select, hover, input, rowAlt, editorBg, editorGutter, editorText, synKeyword, synString, synNumber, synComment, synBuiltin);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Theme)) {
            return false;
        }
        Theme theme = (Theme) other;
        return Intrinsics.areEqual(this.name, theme.name) && this.light == theme.light && this.bg == theme.bg && this.panel == theme.panel && this.header == theme.header && this.topbar == theme.topbar && this.ribbon == theme.ribbon && this.border == theme.border && this.text == theme.text && this.dim == theme.dim && this.accent == theme.accent && this.select == theme.select && this.hover == theme.hover && this.input == theme.input && this.rowAlt == theme.rowAlt && this.editorBg == theme.editorBg && this.editorGutter == theme.editorGutter && this.editorText == theme.editorText && this.synKeyword == theme.synKeyword && this.synString == theme.synString && this.synNumber == theme.synNumber && this.synComment == theme.synComment && this.synBuiltin == theme.synBuiltin;
    }

    public final int getAccent() {
        return this.accent;
    }

    public final int getBg() {
        return this.bg;
    }

    public final int getBorder() {
        return this.border;
    }

    public final int getDim() {
        return this.dim;
    }

    public final int getEditorBg() {
        return this.editorBg;
    }

    public final int getEditorGutter() {
        return this.editorGutter;
    }

    public final int getEditorText() {
        return this.editorText;
    }

    public final int getHeader() {
        return this.header;
    }

    public final int getHover() {
        return this.hover;
    }

    public final int getInput() {
        return this.input;
    }

    public final boolean getLight() {
        return this.light;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPanel() {
        return this.panel;
    }

    public final int getRibbon() {
        return this.ribbon;
    }

    public final int getRowAlt() {
        return this.rowAlt;
    }

    public final int getSelect() {
        return this.select;
    }

    public final int getSynBuiltin() {
        return this.synBuiltin;
    }

    public final int getSynComment() {
        return this.synComment;
    }

    public final int getSynKeyword() {
        return this.synKeyword;
    }

    public final int getSynNumber() {
        return this.synNumber;
    }

    public final int getSynString() {
        return this.synString;
    }

    public final int getText() {
        return this.text;
    }

    public final int getTopbar() {
        return this.topbar;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((this.name.hashCode() * 31) + Boolean.hashCode(this.light)) * 31) + Integer.hashCode(this.bg)) * 31) + Integer.hashCode(this.panel)) * 31) + Integer.hashCode(this.header)) * 31) + Integer.hashCode(this.topbar)) * 31) + Integer.hashCode(this.ribbon)) * 31) + Integer.hashCode(this.border)) * 31) + Integer.hashCode(this.text)) * 31) + Integer.hashCode(this.dim)) * 31) + Integer.hashCode(this.accent)) * 31) + Integer.hashCode(this.select)) * 31) + Integer.hashCode(this.hover)) * 31) + Integer.hashCode(this.input)) * 31) + Integer.hashCode(this.rowAlt)) * 31) + Integer.hashCode(this.editorBg)) * 31) + Integer.hashCode(this.editorGutter)) * 31) + Integer.hashCode(this.editorText)) * 31) + Integer.hashCode(this.synKeyword)) * 31) + Integer.hashCode(this.synString)) * 31) + Integer.hashCode(this.synNumber)) * 31) + Integer.hashCode(this.synComment)) * 31) + Integer.hashCode(this.synBuiltin);
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", this.name);
        jSONObject.put("light", this.light);
        Iterator<Pair<String, Integer>> it = colors().iterator();
        while (it.hasNext()) {
            jSONObject.put(it.next().component1(), r4.component2().intValue() & 4294967295L);
        }
        return jSONObject;
    }

    public String toString() {
        return "Theme(name=" + this.name + ", light=" + this.light + ", bg=" + this.bg + ", panel=" + this.panel + ", header=" + this.header + ", topbar=" + this.topbar + ", ribbon=" + this.ribbon + ", border=" + this.border + ", text=" + this.text + ", dim=" + this.dim + ", accent=" + this.accent + ", select=" + this.select + ", hover=" + this.hover + ", input=" + this.input + ", rowAlt=" + this.rowAlt + ", editorBg=" + this.editorBg + ", editorGutter=" + this.editorGutter + ", editorText=" + this.editorText + ", synKeyword=" + this.synKeyword + ", synString=" + this.synString + ", synNumber=" + this.synNumber + ", synComment=" + this.synComment + ", synBuiltin=" + this.synBuiltin + ")";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000b. Please report as an issue. */
    public final Theme withColor(String slot, int c) {
        int i;
        Object obj;
        String str;
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        Theme theme;
        int i22;
        int i23;
        Object obj2;
        String str2;
        boolean z2;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        int i40;
        int i41;
        int i42;
        int i43;
        Theme theme2;
        int i44;
        int i45;
        Object obj3;
        String str3;
        boolean z3;
        int i46;
        int i47;
        int i48;
        int i49;
        int i50;
        int i51;
        int i52;
        int i53;
        int i54;
        int i55;
        int i56;
        int i57;
        int i58;
        int i59;
        int i60;
        int i61;
        int i62;
        int i63;
        int i64;
        int i65;
        Theme theme3;
        int i66;
        int i67;
        Object obj4;
        String str4;
        boolean z4;
        int i68;
        int i69;
        int i70;
        int i71;
        int i72;
        int i73;
        int i74;
        int i75;
        int i76;
        int i77;
        int i78;
        int i79;
        int i80;
        int i81;
        int i82;
        int i83;
        int i84;
        int i85;
        int i86;
        int i87;
        Theme theme4;
        int i88;
        int i89;
        Object obj5;
        String str5;
        boolean z5;
        int i90;
        int i91;
        int i92;
        int i93;
        int i94;
        int i95;
        int i96;
        int i97;
        int i98;
        int i99;
        int i100;
        int i101;
        int i102;
        int i103;
        int i104;
        int i105;
        int i106;
        int i107;
        int i108;
        int i109;
        Theme theme5;
        int i110;
        int i111;
        Object obj6;
        String str6;
        boolean z6;
        int i112;
        int i113;
        int i114;
        int i115;
        int i116;
        int i117;
        int i118;
        int i119;
        int i120;
        int i121;
        int i122;
        int i123;
        int i124;
        int i125;
        int i126;
        int i127;
        int i128;
        int i129;
        int i130;
        int i131;
        Theme theme6;
        int i132;
        Intrinsics.checkNotNullParameter(slot, "slot");
        switch (slot.hashCode()) {
            case -2137403731:
                if (slot.equals("Header")) {
                    i = 8388591;
                    obj = null;
                    str = null;
                    z = false;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                    i6 = 0;
                    i7 = 0;
                    i8 = 0;
                    i9 = 0;
                    i10 = 0;
                    i11 = 0;
                    i12 = 0;
                    i13 = 0;
                    i14 = 0;
                    i15 = 0;
                    i16 = 0;
                    i17 = 0;
                    i18 = 0;
                    i19 = 0;
                    i20 = 0;
                    i21 = 0;
                    theme = this;
                    i22 = c;
                    return copy$default(theme, str, z, i2, i3, i22, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i, obj);
                }
                return this;
            case -1950496919:
                if (slot.equals("Number")) {
                    i23 = 7340031;
                    obj2 = null;
                    str2 = null;
                    z2 = false;
                    i24 = 0;
                    i25 = 0;
                    i26 = 0;
                    i27 = 0;
                    i28 = 0;
                    i29 = 0;
                    i30 = 0;
                    i31 = 0;
                    i32 = 0;
                    i33 = 0;
                    i34 = 0;
                    i35 = 0;
                    i36 = 0;
                    i37 = 0;
                    i38 = 0;
                    i39 = 0;
                    i40 = 0;
                    i41 = 0;
                    i42 = 0;
                    i43 = 0;
                    theme2 = this;
                    i44 = c;
                    return copy$default(theme2, str2, z2, i24, i25, i26, i27, i28, i29, i30, i31, i32, i33, i34, i35, i36, i37, i38, i39, i40, i41, i44, i42, i43, i23, obj2);
                }
                return this;
            case -1847389962:
                if (slot.equals("Ribbon")) {
                    i45 = 8388543;
                    obj3 = null;
                    str3 = null;
                    z3 = false;
                    i46 = 0;
                    i47 = 0;
                    i48 = 0;
                    i49 = 0;
                    i50 = 0;
                    i51 = 0;
                    i52 = 0;
                    i53 = 0;
                    i54 = 0;
                    i55 = 0;
                    i56 = 0;
                    i57 = 0;
                    i58 = 0;
                    i59 = 0;
                    i60 = 0;
                    i61 = 0;
                    i62 = 0;
                    i63 = 0;
                    i64 = 0;
                    i65 = 0;
                    theme3 = this;
                    i66 = c;
                    return copy$default(theme3, str3, z3, i46, i47, i48, i49, i66, i50, i51, i52, i53, i54, i55, i56, i57, i58, i59, i60, i61, i62, i63, i64, i65, i45, obj3);
                }
                return this;
            case -1808118735:
                if (slot.equals("String")) {
                    i67 = 7864319;
                    obj4 = null;
                    str4 = null;
                    z4 = false;
                    i68 = 0;
                    i69 = 0;
                    i70 = 0;
                    i71 = 0;
                    i72 = 0;
                    i73 = 0;
                    i74 = 0;
                    i75 = 0;
                    i76 = 0;
                    i77 = 0;
                    i78 = 0;
                    i79 = 0;
                    i80 = 0;
                    i81 = 0;
                    i82 = 0;
                    i83 = 0;
                    i84 = 0;
                    i85 = 0;
                    i86 = 0;
                    i87 = 0;
                    theme4 = this;
                    i88 = c;
                    return copy$default(theme4, str4, z4, i68, i69, i70, i71, i72, i73, i74, i75, i76, i77, i78, i79, i80, i81, i82, i83, i84, i88, i85, i86, i87, i67, obj4);
                }
                return this;
            case -1679915457:
                if (slot.equals("Comment")) {
                    i23 = 6291455;
                    obj2 = null;
                    str2 = null;
                    z2 = false;
                    i24 = 0;
                    i25 = 0;
                    i26 = 0;
                    i27 = 0;
                    i28 = 0;
                    i29 = 0;
                    i30 = 0;
                    i31 = 0;
                    i32 = 0;
                    i33 = 0;
                    i34 = 0;
                    i35 = 0;
                    i36 = 0;
                    i37 = 0;
                    i38 = 0;
                    i39 = 0;
                    i40 = 0;
                    i41 = 0;
                    i44 = 0;
                    i43 = 0;
                    theme2 = this;
                    i42 = c;
                    return copy$default(theme2, str2, z2, i24, i25, i26, i27, i28, i29, i30, i31, i32, i33, i34, i35, i36, i37, i38, i39, i40, i41, i44, i42, i43, i23, obj2);
                }
                return this;
            case -1365583116:
                if (slot.equals("Built-in")) {
                    i23 = 4194303;
                    obj2 = null;
                    str2 = null;
                    z2 = false;
                    i24 = 0;
                    i25 = 0;
                    i26 = 0;
                    i27 = 0;
                    i28 = 0;
                    i29 = 0;
                    i30 = 0;
                    i31 = 0;
                    i32 = 0;
                    i33 = 0;
                    i34 = 0;
                    i35 = 0;
                    i36 = 0;
                    i37 = 0;
                    i38 = 0;
                    i39 = 0;
                    i40 = 0;
                    i41 = 0;
                    i44 = 0;
                    i42 = 0;
                    theme2 = this;
                    i43 = c;
                    return copy$default(theme2, str2, z2, i24, i25, i26, i27, i28, i29, i30, i31, i32, i33, i34, i35, i36, i37, i38, i39, i40, i41, i44, i42, i43, i23, obj2);
                }
                return this;
            case -319958258:
                if (slot.equals("Editor gutter")) {
                    i89 = 8323071;
                    obj5 = null;
                    str5 = null;
                    z5 = false;
                    i90 = 0;
                    i91 = 0;
                    i92 = 0;
                    i93 = 0;
                    i94 = 0;
                    i95 = 0;
                    i96 = 0;
                    i97 = 0;
                    i98 = 0;
                    i99 = 0;
                    i100 = 0;
                    i101 = 0;
                    i102 = 0;
                    i103 = 0;
                    i104 = 0;
                    i105 = 0;
                    i106 = 0;
                    i107 = 0;
                    i108 = 0;
                    i109 = 0;
                    theme5 = this;
                    i110 = c;
                    return copy$default(theme5, str5, z5, i90, i91, i92, i93, i94, i95, i96, i97, i98, i99, i100, i101, i102, i103, i110, i104, i105, i106, i107, i108, i109, i89, obj5);
                }
                return this;
            case 2603341:
                if (slot.equals("Text")) {
                    i45 = 8388351;
                    obj3 = null;
                    str3 = null;
                    z3 = false;
                    i46 = 0;
                    i47 = 0;
                    i48 = 0;
                    i49 = 0;
                    i66 = 0;
                    i50 = 0;
                    i52 = 0;
                    i53 = 0;
                    i54 = 0;
                    i55 = 0;
                    i56 = 0;
                    i57 = 0;
                    i58 = 0;
                    i59 = 0;
                    i60 = 0;
                    i61 = 0;
                    i62 = 0;
                    i63 = 0;
                    i64 = 0;
                    i65 = 0;
                    theme3 = this;
                    i51 = c;
                    return copy$default(theme3, str3, z3, i46, i47, i48, i49, i66, i50, i51, i52, i53, i54, i55, i56, i57, i58, i59, i60, i61, i62, i63, i64, i65, i45, obj3);
                }
                return this;
            case 69916956:
                if (slot.equals("Hover")) {
                    i111 = 8384511;
                    obj6 = null;
                    str6 = null;
                    z6 = false;
                    i112 = 0;
                    i113 = 0;
                    i114 = 0;
                    i115 = 0;
                    i116 = 0;
                    i117 = 0;
                    i118 = 0;
                    i119 = 0;
                    i120 = 0;
                    i121 = 0;
                    i122 = 0;
                    i123 = 0;
                    i124 = 0;
                    i125 = 0;
                    i126 = 0;
                    i127 = 0;
                    i128 = 0;
                    i129 = 0;
                    i130 = 0;
                    i131 = 0;
                    theme6 = this;
                    i132 = c;
                    return copy$default(theme6, str6, z6, i112, i113, i114, i115, i116, i117, i118, i119, i120, i121, i132, i122, i123, i124, i125, i126, i127, i128, i129, i130, i131, i111, obj6);
                }
                return this;
            case 70805418:
                if (slot.equals("Input")) {
                    i111 = 8380415;
                    obj6 = null;
                    str6 = null;
                    z6 = false;
                    i112 = 0;
                    i113 = 0;
                    i114 = 0;
                    i115 = 0;
                    i116 = 0;
                    i117 = 0;
                    i118 = 0;
                    i119 = 0;
                    i120 = 0;
                    i121 = 0;
                    i132 = 0;
                    i123 = 0;
                    i124 = 0;
                    i125 = 0;
                    i126 = 0;
                    i127 = 0;
                    i128 = 0;
                    i129 = 0;
                    i130 = 0;
                    i131 = 0;
                    theme6 = this;
                    i122 = c;
                    return copy$default(theme6, str6, z6, i112, i113, i114, i115, i116, i117, i118, i119, i120, i121, i132, i122, i123, i124, i125, i126, i127, i128, i129, i130, i131, i111, obj6);
                }
                return this;
            case 76880356:
                if (slot.equals("Panel")) {
                    i = 8388599;
                    obj = null;
                    str = null;
                    z = false;
                    i2 = 0;
                    i22 = 0;
                    i4 = 0;
                    i5 = 0;
                    i6 = 0;
                    i7 = 0;
                    i8 = 0;
                    i9 = 0;
                    i10 = 0;
                    i11 = 0;
                    i12 = 0;
                    i13 = 0;
                    i14 = 0;
                    i15 = 0;
                    i16 = 0;
                    i17 = 0;
                    i18 = 0;
                    i19 = 0;
                    i20 = 0;
                    i21 = 0;
                    theme = this;
                    i3 = c;
                    return copy$default(theme, str, z, i2, i3, i22, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i, obj);
                }
                return this;
            case 104311269:
                if (slot.equals("Dim text")) {
                    i45 = 8388095;
                    obj3 = null;
                    str3 = null;
                    z3 = false;
                    i46 = 0;
                    i47 = 0;
                    i48 = 0;
                    i49 = 0;
                    i66 = 0;
                    i50 = 0;
                    i51 = 0;
                    i53 = 0;
                    i54 = 0;
                    i55 = 0;
                    i56 = 0;
                    i57 = 0;
                    i58 = 0;
                    i59 = 0;
                    i60 = 0;
                    i61 = 0;
                    i62 = 0;
                    i63 = 0;
                    i64 = 0;
                    i65 = 0;
                    theme3 = this;
                    i52 = c;
                    return copy$default(theme3, str3, z3, i46, i47, i48, i49, i66, i50, i51, i52, i53, i54, i55, i56, i57, i58, i59, i60, i61, i62, i63, i64, i65, i45, obj3);
                }
                return this;
            case 288002412:
                if (slot.equals("Selection")) {
                    i111 = 8386559;
                    obj6 = null;
                    str6 = null;
                    z6 = false;
                    i112 = 0;
                    i113 = 0;
                    i114 = 0;
                    i115 = 0;
                    i116 = 0;
                    i117 = 0;
                    i118 = 0;
                    i119 = 0;
                    i120 = 0;
                    i132 = 0;
                    i122 = 0;
                    i123 = 0;
                    i124 = 0;
                    i125 = 0;
                    i126 = 0;
                    i127 = 0;
                    i128 = 0;
                    i129 = 0;
                    i130 = 0;
                    i131 = 0;
                    theme6 = this;
                    i121 = c;
                    return copy$default(theme6, str6, z6, i112, i113, i114, i115, i116, i117, i118, i119, i120, i121, i132, i122, i123, i124, i125, i126, i127, i128, i129, i130, i131, i111, obj6);
                }
                return this;
            case 523218600:
                if (slot.equals("Top bar")) {
                    i = 8388575;
                    obj = null;
                    str = null;
                    z = false;
                    i2 = 0;
                    i3 = 0;
                    i22 = 0;
                    i5 = 0;
                    i6 = 0;
                    i7 = 0;
                    i8 = 0;
                    i9 = 0;
                    i10 = 0;
                    i11 = 0;
                    i12 = 0;
                    i13 = 0;
                    i14 = 0;
                    i15 = 0;
                    i16 = 0;
                    i17 = 0;
                    i18 = 0;
                    i19 = 0;
                    i20 = 0;
                    i21 = 0;
                    theme = this;
                    i4 = c;
                    return copy$default(theme, str, z, i2, i3, i22, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i, obj);
                }
                return this;
            case 616798176:
                if (slot.equals("Editor text")) {
                    i67 = 8257535;
                    obj4 = null;
                    str4 = null;
                    z4 = false;
                    i68 = 0;
                    i69 = 0;
                    i70 = 0;
                    i71 = 0;
                    i72 = 0;
                    i73 = 0;
                    i74 = 0;
                    i75 = 0;
                    i76 = 0;
                    i77 = 0;
                    i78 = 0;
                    i79 = 0;
                    i80 = 0;
                    i81 = 0;
                    i82 = 0;
                    i84 = 0;
                    i88 = 0;
                    i85 = 0;
                    i86 = 0;
                    i87 = 0;
                    theme4 = this;
                    i83 = c;
                    return copy$default(theme4, str4, z4, i68, i69, i70, i71, i72, i73, i74, i75, i76, i77, i78, i79, i80, i81, i82, i83, i84, i88, i85, i86, i87, i67, obj4);
                }
                return this;
            case 651815188:
                if (slot.equals("Alternate row")) {
                    i89 = 8372223;
                    obj5 = null;
                    str5 = null;
                    z5 = false;
                    i90 = 0;
                    i91 = 0;
                    i92 = 0;
                    i93 = 0;
                    i94 = 0;
                    i95 = 0;
                    i96 = 0;
                    i97 = 0;
                    i98 = 0;
                    i99 = 0;
                    i100 = 0;
                    i101 = 0;
                    i103 = 0;
                    i110 = 0;
                    i104 = 0;
                    i105 = 0;
                    i106 = 0;
                    i107 = 0;
                    i108 = 0;
                    i109 = 0;
                    theme5 = this;
                    i102 = c;
                    return copy$default(theme5, str5, z5, i90, i91, i92, i93, i94, i95, i96, i97, i98, i99, i100, i101, i102, i103, i110, i104, i105, i106, i107, i108, i109, i89, obj5);
                }
                return this;
            case 661270862:
                if (slot.equals("Background")) {
                    i = 8388603;
                    obj = null;
                    str = null;
                    z = false;
                    i3 = 0;
                    i22 = 0;
                    i4 = 0;
                    i5 = 0;
                    i6 = 0;
                    i7 = 0;
                    i8 = 0;
                    i9 = 0;
                    i10 = 0;
                    i11 = 0;
                    i12 = 0;
                    i13 = 0;
                    i14 = 0;
                    i15 = 0;
                    i16 = 0;
                    i17 = 0;
                    i18 = 0;
                    i19 = 0;
                    i20 = 0;
                    i21 = 0;
                    theme = this;
                    i2 = c;
                    return copy$default(theme, str, z, i2, i3, i22, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i, obj);
                }
                return this;
            case 850245065:
                if (slot.equals("Keyword")) {
                    i67 = 8126463;
                    obj4 = null;
                    str4 = null;
                    z4 = false;
                    i68 = 0;
                    i69 = 0;
                    i70 = 0;
                    i71 = 0;
                    i72 = 0;
                    i73 = 0;
                    i74 = 0;
                    i75 = 0;
                    i76 = 0;
                    i77 = 0;
                    i78 = 0;
                    i79 = 0;
                    i80 = 0;
                    i81 = 0;
                    i82 = 0;
                    i83 = 0;
                    i88 = 0;
                    i85 = 0;
                    i86 = 0;
                    i87 = 0;
                    theme4 = this;
                    i84 = c;
                    return copy$default(theme4, str4, z4, i68, i69, i70, i71, i72, i73, i74, i75, i76, i77, i78, i79, i80, i81, i82, i83, i84, i88, i85, i86, i87, i67, obj4);
                }
                return this;
            case 861640097:
                if (slot.equals("Editor background")) {
                    i89 = 8355839;
                    obj5 = null;
                    str5 = null;
                    z5 = false;
                    i90 = 0;
                    i91 = 0;
                    i92 = 0;
                    i93 = 0;
                    i94 = 0;
                    i95 = 0;
                    i96 = 0;
                    i97 = 0;
                    i98 = 0;
                    i99 = 0;
                    i100 = 0;
                    i101 = 0;
                    i102 = 0;
                    i110 = 0;
                    i104 = 0;
                    i105 = 0;
                    i106 = 0;
                    i107 = 0;
                    i108 = 0;
                    i109 = 0;
                    theme5 = this;
                    i103 = c;
                    return copy$default(theme5, str5, z5, i90, i91, i92, i93, i94, i95, i96, i97, i98, i99, i100, i101, i102, i103, i110, i104, i105, i106, i107, i108, i109, i89, obj5);
                }
                return this;
            case 1955373290:
                if (slot.equals("Accent")) {
                    i111 = 8387583;
                    obj6 = null;
                    str6 = null;
                    z6 = false;
                    i112 = 0;
                    i113 = 0;
                    i114 = 0;
                    i115 = 0;
                    i116 = 0;
                    i117 = 0;
                    i118 = 0;
                    i119 = 0;
                    i121 = 0;
                    i132 = 0;
                    i122 = 0;
                    i123 = 0;
                    i124 = 0;
                    i125 = 0;
                    i126 = 0;
                    i127 = 0;
                    i128 = 0;
                    i129 = 0;
                    i130 = 0;
                    i131 = 0;
                    theme6 = this;
                    i120 = c;
                    return copy$default(theme6, str6, z6, i112, i113, i114, i115, i116, i117, i118, i119, i120, i121, i132, i122, i123, i124, i125, i126, i127, i128, i129, i130, i131, i111, obj6);
                }
                return this;
            case 1995530316:
                if (slot.equals("Border")) {
                    i45 = 8388479;
                    obj3 = null;
                    str3 = null;
                    z3 = false;
                    i46 = 0;
                    i47 = 0;
                    i48 = 0;
                    i49 = 0;
                    i66 = 0;
                    i51 = 0;
                    i52 = 0;
                    i53 = 0;
                    i54 = 0;
                    i55 = 0;
                    i56 = 0;
                    i57 = 0;
                    i58 = 0;
                    i59 = 0;
                    i60 = 0;
                    i61 = 0;
                    i62 = 0;
                    i63 = 0;
                    i64 = 0;
                    i65 = 0;
                    theme3 = this;
                    i50 = c;
                    return copy$default(theme3, str3, z3, i46, i47, i48, i49, i66, i50, i51, i52, i53, i54, i55, i56, i57, i58, i59, i60, i61, i62, i63, i64, i65, i45, obj3);
                }
                return this;
            default:
                return this;
        }
    }
}
