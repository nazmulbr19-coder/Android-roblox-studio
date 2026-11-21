package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.Constraints;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.exampletest.mobilestudiotest.audio.AudioEngine;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.lua.Attributes;
import com.exampletest.mobilestudiotest.model.BrickColorV;
import com.exampletest.mobilestudiotest.model.BrickColors;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Color3;
import com.exampletest.mobilestudiotest.model.DataTypesKt;
import com.exampletest.mobilestudiotest.model.EnumValue;
import com.exampletest.mobilestudiotest.model.Enums;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.PartData;
import com.exampletest.mobilestudiotest.model.PropNames;
import com.exampletest.mobilestudiotest.model.PropType;
import com.exampletest.mobilestudiotest.model.Vector3;
import com.exampletest.mobilestudiotest.net.AssetFetcher;
import com.exampletest.mobilestudiotest.ui.Ui;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PropertiesPanel.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0004+,-.B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0019\u001a\u00020\u0018H\u0014J\b\u0010\u001a\u001a\u00020\u0018H\u0014J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0016J \u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#H\u0002J\u0006\u0010$\u001a\u00020\u0018J\u001a\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u001a\u0010'\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u000bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00060\u000fR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/PropertiesPanel;", "Landroid/widget/LinearLayout;", "Lcom/exampletest/mobilestudiotest/core/Studio$Listener;", "ctx", "Landroid/content/Context;", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "<init>", "(Landroid/content/Context;Lcom/exampletest/mobilestudiotest/core/Studio;)V", "rows", "", "Lcom/exampletest/mobilestudiotest/ui/PropertiesPanel$Row;", "list", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/exampletest/mobilestudiotest/ui/PropertiesPanel$Adapter;", "title", "Landroid/widget/TextView;", "collapsed", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "previewListener", "Lkotlin/Function0;", "", "onAttachedToWindow", "onDetachedFromWindow", "onSelectionChanged", "onPropsChanged", "onModelReplaced", "categoryOf", "inst", "Lcom/exampletest/mobilestudiotest/model/Instance;", "disp", "t", "", "rebuild", "valueText", "r", "applyEdit", "newValue", "", "edit", "Row", "Companion", "VH", "Adapter", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PropertiesPanel extends LinearLayout implements Studio.Listener {
    private static final Map<String, String> CATEGORY;
    private static final float DEG = 57.29578f;
    private static final float RAD = 0.017453292f;
    private static final Set<String> skip;
    private static final List<String> surfaceProps;
    private final Adapter adapter;
    private final HashSet<String> collapsed;
    private final RecyclerView list;
    private final Function0<Unit> previewListener;
    private List<Row> rows;
    private final Studio studio;
    private final TextView title;
    private static final List<String> ORDER = CollectionsKt.listOf((Object[]) new String[]{"Appearance", "Data", "Text", "Image", "Behavior", "Transform", "Pivot", "Collision", "Part", "Surface", "Assembly", "Playback", "Emitter", "Character", "Health", "Movement", "Rigging", "Camera", "Controls", "Mobile", "Shape", "Emission", TypedValues.MotionType.NAME, "Particles", "Light", "Scripting", "Model", "Physics", "Attachments", Constraints.TAG, "Input", "Layout", "State", "Teams", "Game", "Other"});

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PropertiesPanel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/PropertiesPanel$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/exampletest/mobilestudiotest/ui/PropertiesPanel$VH;", "Lcom/exampletest/mobilestudiotest/ui/PropertiesPanel;", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/PropertiesPanel;)V", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "h", "position", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class Adapter extends RecyclerView.Adapter<VH> {
        public Adapter() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void onBindViewHolder$lambda$5(PropertiesPanel propertiesPanel, Row row, View view) {
            if (!PropertiesPanel.access$getCollapsed$p(propertiesPanel).add(row.getTitle())) {
                PropertiesPanel.access$getCollapsed$p(propertiesPanel).remove(row.getTitle());
            }
            propertiesPanel.rebuild();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void onBindViewHolder$lambda$8(PropertiesPanel propertiesPanel, Row row, View view) {
            PropertiesPanel.access$edit(propertiesPanel, row);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return PropertiesPanel.access$getRows$p(PropertiesPanel.this).size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(VH vh, int i) {
            onBindViewHolder2(vh, i);
        }

        /* renamed from: onBindViewHolder, reason: avoid collision after fix types in other method */
        public void onBindViewHolder2(VH h, int position) {
            boolean z;
            Intrinsics.checkNotNullParameter(h, "h");
            Row row = (Row) PropertiesPanel.access$getRows$p(PropertiesPanel.this).get(position);
            Context context = h.getRow().getContext();
            Ui ui = Ui.INSTANCE;
            Intrinsics.checkNotNull(context);
            int dp = ui.dp(context, 14.0f);
            if (row.getProp() == null) {
                h.getName().setText(row.getTitle());
                h.getName().setPadding(Ui.INSTANCE.dp(context, 6.0f), 0, Ui.INSTANCE.dp(context, 4.0f), 0);
                TextView name = h.getName();
                Ui.ArrowDrawable arrowDrawable = new Ui.ArrowDrawable(!PropertiesPanel.access$getCollapsed$p(PropertiesPanel.this).contains(row.getTitle()), Ui.INSTANCE.getTEXT());
                arrowDrawable.setBounds(0, 0, dp, dp);
                name.setCompoundDrawables(arrowDrawable, null, null, null);
                h.getName().setCompoundDrawablePadding(Ui.INSTANCE.dp(context, 4.0f));
                h.getValue().setCompoundDrawables(null, null, null, null);
                h.getName().setTextColor(Ui.INSTANCE.getTEXT());
                h.getName().setTypeface(null, 1);
                h.getName().setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
                h.getValue().setVisibility(8);
                h.getSwatch().setVisibility(8);
                h.getRow().getChildAt(1).setVisibility(8);
                h.getRow().setBackgroundColor(Ui.INSTANCE.getHEADER());
                h.getRow().setOnClickListener(new PropertiesPanel$Adapter$$ExternalSyntheticLambda0(PropertiesPanel.this, row));
                return;
            }
            h.getRow().getChildAt(1).setVisibility(0);
            h.getName().setPadding(Ui.INSTANCE.dp(context, 22.0f), 0, Ui.INSTANCE.dp(context, 4.0f), 0);
            h.getName().setLayoutParams(new LinearLayout.LayoutParams(0, -2, 0.45f));
            h.getName().setTypeface(null, 0);
            h.getName().setCompoundDrawables(null, null, null, null);
            h.getName().setText(row.getDisplay());
            h.getName().setTextColor((row.getEditable() || row.getAction() != null) ? Ui.INSTANCE.getTEXT() : Ui.INSTANCE.getDIM());
            h.getValue().setVisibility(0);
            h.getRow().setBackgroundColor(Ui.INSTANCE.getPANEL());
            Instance instance = (Instance) CollectionsKt.firstOrNull((List) PropertiesPanel.access$getStudio$p(PropertiesPanel.this).getSelection());
            Object value = row.getValue();
            Color3 color = value instanceof Color3 ? (Color3) value : value instanceof BrickColorV ? ((BrickColorV) value).getColor() : null;
            if (color != null) {
                h.getSwatch().setVisibility(0);
                View swatch = h.getSwatch();
                GradientDrawable gradientDrawable = new GradientDrawable();
                z = true;
                gradientDrawable.setColor(color.toArgb());
                gradientDrawable.setStroke(Ui.INSTANCE.dp(context, 1.0f), -7829368);
                swatch.setBackground(gradientDrawable);
            } else {
                z = true;
                h.getSwatch().setVisibility(8);
            }
            if (row.getType() == 2) {
                h.getValue().setText("");
                TextView value2 = h.getValue();
                Ui.CheckBoxDrawable checkBoxDrawable = new Ui.CheckBoxDrawable(Intrinsics.areEqual(row.getValue(), Boolean.valueOf(z)), context.getResources().getDisplayMetrics().density);
                checkBoxDrawable.setBounds(0, 0, dp, dp);
                value2.setCompoundDrawables(checkBoxDrawable, null, null, null);
                h.getValue().setCompoundDrawablePadding(Ui.INSTANCE.dp(context, 6.0f));
            } else {
                h.getValue().setCompoundDrawables(null, null, null, null);
                h.getValue().setText(PropertiesPanel.access$valueText(PropertiesPanel.this, row, instance));
            }
            TextView value3 = h.getValue();
            Function0<Unit> action = row.getAction();
            int i = Ui.INFO;
            if (action == null && row.getType() != 19) {
                i = Ui.INSTANCE.getTEXT();
            }
            value3.setTextColor(i);
            h.getRow().setOnClickListener(new PropertiesPanel$Adapter$$ExternalSyntheticLambda1(PropertiesPanel.this, row));
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
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            Ui ui = Ui.INSTANCE;
            Intrinsics.checkNotNull(context);
            linearLayout.setMinimumHeight(ui.dp(context, 27.0f));
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            TextView text$default = Ui.text$default(Ui.INSTANCE, context, "", 12.0f, Ui.INSTANCE.getTEXT(), false, 16, null);
            text$default.setPadding(Ui.INSTANCE.dp(context, 22.0f), 0, Ui.INSTANCE.dp(context, 4.0f), 0);
            text$default.setEllipsize(TextUtils.TruncateAt.END);
            View view = new View(context);
            TextView text$default2 = Ui.text$default(Ui.INSTANCE, context, "", 12.0f, Ui.INSTANCE.getTEXT(), false, 16, null);
            text$default2.setPadding(Ui.INSTANCE.dp(context, 6.0f), 0, Ui.INSTANCE.dp(context, 6.0f), 0);
            text$default2.setEllipsize(TextUtils.TruncateAt.END);
            linearLayout.addView(text$default, new LinearLayout.LayoutParams(0, -2, 0.45f));
            linearLayout.addView(Ui.INSTANCE.divider(context, true));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Ui.INSTANCE.dp(context, 14.0f), Ui.INSTANCE.dp(context, 14.0f));
            layoutParams.leftMargin = Ui.INSTANCE.dp(context, 6.0f);
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(view, layoutParams);
            linearLayout.addView(text$default2, new LinearLayout.LayoutParams(0, -2, 0.55f));
            return new VH(PropertiesPanel.this, linearLayout, text$default, view, text$default2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PropertiesPanel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/PropertiesPanel$Row;", "", "title", "", "prop", "display", "value", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "", "editable", "", "action", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;IZLkotlin/jvm/functions/Function0;)V", "getTitle", "()Ljava/lang/String;", "getProp", "getDisplay", "getValue", "()Ljava/lang/Object;", "getType", "()I", "getEditable", "()Z", "getAction", "()Lkotlin/jvm/functions/Function0;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Row {
        private final Function0<Unit> action;
        private final String display;
        private final boolean editable;
        private final String prop;
        private final String title;
        private final int type;
        private final Object value;

        public Row(String title, String str, String display, Object obj, int i, boolean z, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(display, "display");
            this.title = title;
            this.prop = str;
            this.display = display;
            this.value = obj;
            this.type = i;
            this.editable = z;
            this.action = function0;
        }

        public /* synthetic */ Row(String str, String str2, String str3, Object obj, int i, boolean z, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, obj, i, z, (i2 & 64) != 0 ? null : function0);
        }

        public final Function0<Unit> getAction() {
            return this.action;
        }

        public final String getDisplay() {
            return this.display;
        }

        public final boolean getEditable() {
            return this.editable;
        }

        public final String getProp() {
            return this.prop;
        }

        public final String getTitle() {
            return this.title;
        }

        public final int getType() {
            return this.type;
        }

        public final Object getValue() {
            return this.value;
        }
    }

    /* compiled from: PropertiesPanel.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0082\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/PropertiesPanel$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "row", "Landroid/widget/LinearLayout;", "name", "Landroid/widget/TextView;", "swatch", "Landroid/view/View;", "value", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/PropertiesPanel;Landroid/widget/LinearLayout;Landroid/widget/TextView;Landroid/view/View;Landroid/widget/TextView;)V", "getRow", "()Landroid/widget/LinearLayout;", "getName", "()Landroid/widget/TextView;", "getSwatch", "()Landroid/view/View;", "getValue", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private final class VH extends RecyclerView.ViewHolder {
        private final TextView name;
        private final LinearLayout row;
        private final View swatch;
        final /* synthetic */ PropertiesPanel this$0;
        private final TextView value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VH(PropertiesPanel propertiesPanel, LinearLayout row, TextView name, View swatch, TextView value) {
            super(row);
            Intrinsics.checkNotNullParameter(row, "row");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(swatch, "swatch");
            Intrinsics.checkNotNullParameter(value, "value");
            this.this$0 = propertiesPanel;
            this.row = row;
            this.name = name;
            this.swatch = swatch;
            this.value = value;
        }

        public final TextView getName() {
            return this.name;
        }

        public final LinearLayout getRow() {
            return this.row;
        }

        public final View getSwatch() {
            return this.swatch;
        }

        public final TextView getValue() {
            return this.value;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        CATEGORY$lambda$14$c(hashMap, "Appearance", "BrickColor", "CastShadow", "Color", "Material", "MaterialVariant", "Reflectance", "Transparency", "BackgroundColor3", "BackgroundTransparency", "BorderColor3", "BorderMode", "BorderSizePixel", "Visible", "Texture", "Face", "Color3", "ZIndex", "TextureID", "DoubleSided", "RenderFidelity", "SmoothingAngle", "UsePartColor", "FillColor", "FillTransparency", "OutlineColor", "OutlineTransparency", "DepthMode", "LineThickness", "SurfaceColor3", "SurfaceTransparency", "StudsPerTileU", "StudsPerTileV", "OffsetStudsU", "OffsetStudsV", "LightInfluence", "Brightness", "Shadows", "Range", "Angle", "Thickness", "LineJoinMode", "CornerRadius", "Rotation", "Offset", "VertexColor", "Scale", "MeshType", "TextureId");
        CATEGORY$lambda$14$c(hashMap, "Data", "ClassName", "Name", "Parent", "Source", "LinkedSource", "SoundId", "MeshId", "AnimationId", "Value", "Adornee", "PrimaryPart", "Part0", "Part1", "Attachment0", "Attachment1", "LayoutOrder", "SoundGroup", "TimeLength", "DisplayName", "Tags", "PlaceholderText", "Title", "Graphic", "ShirtTemplate", "PantsTemplate", "Tool", "ToolTip");
        CATEGORY$lambda$14$c(hashMap, "Text", "Font", "FontFace", "LineHeight", "MaxVisibleGraphemes", "RichText", "Text", "TextColor3", "TextScaled", "TextSize", "TextStrokeColor3", "TextStrokeTransparency", "TextTransparency", "TextTruncate", "TextWrapped", "TextXAlignment", "TextYAlignment", "TextEditable", "ClearTextOnFocus", "MultiLine", "PlaceholderColor3", "ShowNativeInput");
        CATEGORY$lambda$14$c(hashMap, "Image", "Image", "ImageColor3", "ImageRectOffset", "ImageRectSize", "ImageTransparency", "ResampleMode", "ScaleType", "SliceCenter", "SliceScale", "TileSize", "HoverImage", "PressedImage");
        CATEGORY$lambda$14$c(hashMap, "Behavior", "Archivable", "Locked", "Active", "AutoButtonColor", "ClipsDescendants", "Draggable", "Interactable", "Selectable", "Disabled", "Enabled", "RunContext", "ResetOnSpawn", "IgnoreGuiInset", "ZIndexBehavior", "DisplayOrder", "AlwaysOnTop", "Modal", "Selected", "AutoLocalize", "ScreenInsets", "SafeAreaCompatibility", "CanBeDropped", "ManualActivationOnly", "RequiresHandle", "MaxActivationDistance", "HoldDuration", "KeyboardKeyCode", "ActionText", "ObjectText", "RequiresLineOfSight", "Exclusivity", "Style");
        CATEGORY$lambda$14$c(hashMap, "Transform", "Size", "Position", "Orientation", "CFrame", "AnchorPoint", "SizeConstraint", "AutomaticSize");
        CATEGORY$lambda$14$c(hashMap, "Pivot", "PivotOffset", "WorldPivot", "Pivot Offset", "Origin");
        CATEGORY$lambda$14$c(hashMap, "Collision", "CanCollide", "CanQuery", "CanTouch", "CollisionGroup", "CollisionGroupId", "CollisionFidelity", "AudioCanCollide");
        CATEGORY$lambda$14$c(hashMap, "Part", "Anchored", "CustomPhysicalProperties", "Massless", "RootPriority", "Shape", "EnableFluidForces", "FormFactor");
        CATEGORY$lambda$14$c(hashMap, "Surface", "BackSurface", "BottomSurface", "FrontSurface", "LeftSurface", "RightSurface", "TopSurface", "BackSurfaceInput", "BottomSurfaceInput", "FrontSurfaceInput", "LeftSurfaceInput", "RightSurfaceInput", "TopSurfaceInput");
        CATEGORY$lambda$14$c(hashMap, "Assembly", "AssemblyLinearVelocity", "AssemblyAngularVelocity", "Velocity", "RotVelocity");
        CATEGORY$lambda$14$c(hashMap, "Playback", "Looped", "PlaybackSpeed", "Playing", "TimePosition", "Volume", "PlayOnRemove", "PlaybackRegionsEnabled", "Pitch");
        CATEGORY$lambda$14$c(hashMap, "Emitter", "RollOffMaxDistance", "RollOffMinDistance", "RollOffMode", "EmitterSize", "MaxDistance", "MinDistance");
        CATEGORY$lambda$14$c(hashMap, "Health", "Health", "MaxHealth", "BreakJointsOnDeath", "HealthDisplayDistance", "HealthDisplayType");
        CATEGORY$lambda$14$c(hashMap, "Movement", "WalkSpeed", "HipHeight", "MaxSlopeAngle", "AutoRotate", "AutoJumpEnabled", "JumpPower", "JumpHeight", "UseJumpPower", "PlatformStand", "Sit");
        CATEGORY$lambda$14$c(hashMap, "Rigging", "RigType", "RequiresNeck", "AutomaticScalingEnabled");
        CATEGORY$lambda$14$c(hashMap, "Camera", "CameraType", "FieldOfView", "FieldOfViewMode", "CameraSubject", "Focus", "HeadLocked", "HeadScale", "DiagonalFieldOfView", "MaxAxisFieldOfView");
        CATEGORY$lambda$14$c(hashMap, "Emission", "Rate", "Lifetime", "Speed", "SpreadAngle", "EmissionDirection", "Drag", "Acceleration", "LockedToPart", "VelocityInheritance", "ZOffset", "Squash", "TimeScale");
        CATEGORY$lambda$14$c(hashMap, "Light", "Ambient", "OutdoorAmbient", "ClockTime", "GeographicLatitude", "TimeOfDay", "ExposureCompensation", "GlobalShadows", "FogColor", "FogEnd", "FogStart", "EnvironmentDiffuseScale", "EnvironmentSpecularScale", "ColorShift_Bottom", "ColorShift_Top", "Technology", "ShadowSoftness");
        CATEGORY$lambda$14$c(hashMap, "Game", "Gravity", "FallenPartsDestroyHeight", "StreamingEnabled", "RespawnTime", "MaxPlayers", "CharacterAutoLoads");
        CATEGORY$lambda$14$c(hashMap, "Teams", "TeamColor", "AutoAssignable", "Neutral", "AllowTeamChangeOnTouch", "Duration");
        CATEGORY$lambda$14$c(hashMap, "Layout", "Padding", "FillDirection", "HorizontalAlignment", "VerticalAlignment", "SortOrder", "CellSize", "CellPadding", "PaddingTop", "PaddingBottom", "PaddingLeft", "PaddingRight", "AspectRatio", "AspectType", "DominantAxis", "MinSize", "MaxSize", "Wraps");
        CATEGORY$lambda$14$c(hashMap, "Model", "LevelOfDetail", "ModelStreamingMode", "WorldPivotData");
        CATEGORY = hashMap;
        surfaceProps = CollectionsKt.listOf((Object[]) new String[]{"TopSurface", "BottomSurface", "FrontSurface", "BackSurface", "LeftSurface", "RightSurface"});
        skip = SetsKt.setOf((Object[]) new String[]{"AttributesSerialize", "Tags", "SourceAssetId", "HistoryId", "UniqueId", "ScriptGuid", "Capabilities", "DefinesCapabilities", "MeshContent", "TextureContent", "PhysicsData", "PhysicalConfigData", "ChildData", "MeshData", "InitialSize", "ModelMeshData", "ModelMeshSize", "ModelMeshCFrame", "LevelOfDetail"});
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PropertiesPanel(Context ctx, Studio studio) {
        super(ctx);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(studio, "studio");
        this.studio = studio;
        this.rows = CollectionsKt.emptyList();
        this.list = new RecyclerView(ctx);
        this.adapter = new Adapter();
        this.collapsed = new HashSet<>();
        this.previewListener = new PropertiesPanel$$ExternalSyntheticLambda5(this);
        setOrientation(1);
        setBackgroundColor(Ui.INSTANCE.getPANEL());
        LinearLayout header = Ui.INSTANCE.header(ctx, "Properties", Icons.general$default(Icons.INSTANCE, ctx, "Properties", null, 4, null));
        this.title = Ui.text$default(Ui.INSTANCE, ctx, "", 11.0f, Ui.INSTANCE.getDIM(), false, 16, null);
        header.addView(this.title);
        addView(header, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        this.list.setLayoutManager(new LinearLayoutManager(ctx));
        this.list.setAdapter(this.adapter);
        this.list.setItemAnimator(null);
        addView(this.list, Ui.INSTANCE.lp(-1, 0, 1.0f));
        rebuild();
    }

    private static final void CATEGORY$lambda$14$c(HashMap<String, String> hashMap, String str, String... strArr) {
        for (String str2 : strArr) {
            hashMap.put(str2, str);
        }
    }

    public static final /* synthetic */ void access$edit(PropertiesPanel propertiesPanel, Row row) {
        propertiesPanel.edit(row);
    }

    public static final /* synthetic */ HashSet access$getCollapsed$p(PropertiesPanel propertiesPanel) {
        return propertiesPanel.collapsed;
    }

    public static final /* synthetic */ List access$getRows$p(PropertiesPanel propertiesPanel) {
        return propertiesPanel.rows;
    }

    public static final /* synthetic */ Studio access$getStudio$p(PropertiesPanel propertiesPanel) {
        return propertiesPanel.studio;
    }

    public static final /* synthetic */ String access$valueText(PropertiesPanel propertiesPanel, Row row, Instance instance) {
        return propertiesPanel.valueText(row, instance);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0051. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01d6 A[Catch: all -> 0x026c, TryCatch #0 {, blocks: (B:9:0x000f, B:10:0x003f, B:12:0x0045, B:13:0x0051, B:17:0x01cc, B:19:0x01d6, B:21:0x01e4, B:24:0x01ee, B:26:0x01f9, B:28:0x01fd, B:29:0x0208, B:31:0x0210, B:33:0x0214, B:34:0x021f, B:36:0x0227, B:39:0x022f, B:42:0x023b, B:45:0x023f, B:154:0x0056, B:157:0x005e, B:160:0x0066, B:58:0x0080, B:61:0x0088, B:64:0x0090, B:67:0x00a9, B:70:0x00c9, B:77:0x00d2, B:80:0x00e4, B:90:0x00ec, B:93:0x00fd, B:83:0x0104, B:86:0x010e, B:99:0x00dc, B:104:0x0115, B:107:0x011d, B:110:0x0123, B:115:0x012c, B:118:0x0134, B:121:0x013c, B:126:0x0174, B:129:0x017c, B:132:0x0182, B:137:0x0190, B:140:0x0199, B:143:0x01a1, B:145:0x01af, B:147:0x01b5, B:148:0x01bb, B:165:0x0256), top: B:8:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01f9 A[Catch: all -> 0x026c, TryCatch #0 {, blocks: (B:9:0x000f, B:10:0x003f, B:12:0x0045, B:13:0x0051, B:17:0x01cc, B:19:0x01d6, B:21:0x01e4, B:24:0x01ee, B:26:0x01f9, B:28:0x01fd, B:29:0x0208, B:31:0x0210, B:33:0x0214, B:34:0x021f, B:36:0x0227, B:39:0x022f, B:42:0x023b, B:45:0x023f, B:154:0x0056, B:157:0x005e, B:160:0x0066, B:58:0x0080, B:61:0x0088, B:64:0x0090, B:67:0x00a9, B:70:0x00c9, B:77:0x00d2, B:80:0x00e4, B:90:0x00ec, B:93:0x00fd, B:83:0x0104, B:86:0x010e, B:99:0x00dc, B:104:0x0115, B:107:0x011d, B:110:0x0123, B:115:0x012c, B:118:0x0134, B:121:0x013c, B:126:0x0174, B:129:0x017c, B:132:0x0182, B:137:0x0190, B:140:0x0199, B:143:0x01a1, B:145:0x01af, B:147:0x01b5, B:148:0x01bb, B:165:0x0256), top: B:8:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0210 A[Catch: all -> 0x026c, TryCatch #0 {, blocks: (B:9:0x000f, B:10:0x003f, B:12:0x0045, B:13:0x0051, B:17:0x01cc, B:19:0x01d6, B:21:0x01e4, B:24:0x01ee, B:26:0x01f9, B:28:0x01fd, B:29:0x0208, B:31:0x0210, B:33:0x0214, B:34:0x021f, B:36:0x0227, B:39:0x022f, B:42:0x023b, B:45:0x023f, B:154:0x0056, B:157:0x005e, B:160:0x0066, B:58:0x0080, B:61:0x0088, B:64:0x0090, B:67:0x00a9, B:70:0x00c9, B:77:0x00d2, B:80:0x00e4, B:90:0x00ec, B:93:0x00fd, B:83:0x0104, B:86:0x010e, B:99:0x00dc, B:104:0x0115, B:107:0x011d, B:110:0x0123, B:115:0x012c, B:118:0x0134, B:121:0x013c, B:126:0x0174, B:129:0x017c, B:132:0x0182, B:137:0x0190, B:140:0x0199, B:143:0x01a1, B:145:0x01af, B:147:0x01b5, B:148:0x01bb, B:165:0x0256), top: B:8:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0227 A[Catch: all -> 0x026c, TryCatch #0 {, blocks: (B:9:0x000f, B:10:0x003f, B:12:0x0045, B:13:0x0051, B:17:0x01cc, B:19:0x01d6, B:21:0x01e4, B:24:0x01ee, B:26:0x01f9, B:28:0x01fd, B:29:0x0208, B:31:0x0210, B:33:0x0214, B:34:0x021f, B:36:0x0227, B:39:0x022f, B:42:0x023b, B:45:0x023f, B:154:0x0056, B:157:0x005e, B:160:0x0066, B:58:0x0080, B:61:0x0088, B:64:0x0090, B:67:0x00a9, B:70:0x00c9, B:77:0x00d2, B:80:0x00e4, B:90:0x00ec, B:93:0x00fd, B:83:0x0104, B:86:0x010e, B:99:0x00dc, B:104:0x0115, B:107:0x011d, B:110:0x0123, B:115:0x012c, B:118:0x0134, B:121:0x013c, B:126:0x0174, B:129:0x017c, B:132:0x0182, B:137:0x0190, B:140:0x0199, B:143:0x01a1, B:145:0x01af, B:147:0x01b5, B:148:0x01bb, B:165:0x0256), top: B:8:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x023b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x003f A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x022f A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ee A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0104 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ec A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void applyEdit(com.exampletest.mobilestudiotest.ui.PropertiesPanel.Row r13, java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 658
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.PropertiesPanel.applyEdit(com.exampletest.mobilestudiotest.ui.PropertiesPanel$Row, java.lang.Object):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0040, code lost:
    
        if (r7.isA("BasePart") != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return "Data";
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
    
        return "Transform";
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
    
        if (r8.equals("Rotation") != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
    
        if (r8.equals("Size") == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001d, code lost:
    
        if (r8.equals("Position") == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0038, code lost:
    
        if (r7.isA("GuiObject") != false) goto L21;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0013. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String categoryOf(com.exampletest.mobilestudiotest.model.Instance r7, java.lang.String r8, int r9) {
        /*
            r6 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = com.exampletest.mobilestudiotest.ui.PropertiesPanel.CATEGORY
            java.lang.Object r0 = r0.get(r8)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "Data"
            java.lang.String r2 = "Appearance"
            if (r0 == 0) goto L91
            r3 = 0
            int r4 = r8.hashCode()
            switch(r4) {
                case 2577441: goto L29;
                case 24343454: goto L20;
                case 812449097: goto L17;
                default: goto L16;
            }
        L16:
            goto L31
        L17:
            java.lang.String r4 = "Position"
            boolean r4 = r8.equals(r4)
            if (r4 != 0) goto L32
            goto L31
        L20:
            java.lang.String r4 = "Rotation"
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L31
            goto L32
        L29:
            java.lang.String r4 = "Size"
            boolean r4 = r8.equals(r4)
            if (r4 != 0) goto L32
        L31:
            goto L46
        L32:
            java.lang.String r2 = "GuiObject"
            boolean r2 = r7.isA(r2)
            if (r2 != 0) goto L43
            java.lang.String r2 = "BasePart"
            boolean r2 = r7.isA(r2)
            if (r2 != 0) goto L43
            goto L45
        L43:
            java.lang.String r1 = "Transform"
        L45:
            return r1
        L46:
            java.lang.String r1 = "Brightness"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r1)
            java.lang.String r4 = "Light"
            if (r1 == 0) goto L5d
            java.lang.String r1 = r7.getClassName()
            java.lang.String r5 = "Lighting"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r5)
            if (r1 == 0) goto L5d
            return r4
        L5d:
            java.lang.String r1 = "Color"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r1)
            if (r1 == 0) goto L6c
            boolean r1 = r7.isA(r4)
            if (r1 == 0) goto L6c
            return r2
        L6c:
            java.lang.String r1 = "Enabled"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r1)
            if (r1 == 0) goto L7b
            boolean r1 = r7.isA(r4)
            if (r1 == 0) goto L7b
            return r2
        L7b:
            java.lang.String r1 = "Texture"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r1)
            if (r1 == 0) goto L90
            java.lang.String r1 = r7.getClassName()
            java.lang.String r4 = "Decal"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r4)
            if (r1 == 0) goto L90
            return r2
        L90:
            return r0
        L91:
            java.lang.String r0 = "ParticleEmitter"
            boolean r0 = r7.isA(r0)
            if (r0 != 0) goto Lba
            java.lang.String r0 = r7.getClassName()
            java.lang.String r3 = "Trail"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r0 != 0) goto Lba
            java.lang.String r0 = r7.getClassName()
            java.lang.String r3 = "Beam"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r0 != 0) goto Lba
            switch(r9) {
                case 1: goto Lb8;
                case 2: goto Lb5;
                case 19: goto Lb8;
                case 34: goto Lb8;
                default: goto Lb4;
            }
        Lb4:
            goto Lb9
        Lb5:
            java.lang.String r1 = "Behavior"
            goto Lb9
        Lb8:
        Lb9:
            return r1
        Lba:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.PropertiesPanel.categoryOf(com.exampletest.mobilestudiotest.model.Instance, java.lang.String, int):java.lang.String");
    }

    private final void edit(Row r) {
        Function0<Unit> action = r.getAction();
        if (action != null) {
            action.invoke();
            rebuild();
            return;
        }
        Instance instance = (Instance) CollectionsKt.firstOrNull((List) this.studio.getSelection());
        if (instance == null) {
            return;
        }
        if (Intrinsics.areEqual(r.getProp(), "@Source")) {
            this.studio.openScript(instance);
            return;
        }
        if (r.getType() == 19) {
            Object value = r.getValue();
            Instance instance2 = value instanceof Instance ? (Instance) value : null;
            if (instance2 != null) {
                this.studio.select(CollectionsKt.listOf(instance2));
                return;
            }
            return;
        }
        if (r.getEditable()) {
            if (r.getType() == 2) {
                applyEdit(r, Boolean.valueOf(!Intrinsics.areEqual(r.getValue(), (Object) true)));
                return;
            }
            String str = "Material";
            if (!Intrinsics.areEqual(r.getDisplay(), "Material")) {
                if (StringsKt.endsWith$default(r.getDisplay(), "Surface", false, 2, (Object) null) && instance.isA("BasePart")) {
                    str = "SurfaceType";
                } else if (Intrinsics.areEqual(r.getDisplay(), "Shape") && instance.isA("BasePart")) {
                    str = "PartType";
                } else {
                    Enums enums = Enums.INSTANCE;
                    String className = instance.getClassName();
                    String prop = r.getProp();
                    if (prop == null) {
                        prop = "";
                    }
                    str = enums.typeForProp(className, prop);
                }
            }
            Dialogs dialogs = Dialogs.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            dialogs.editValue(context, r.getDisplay(), r.getValue(), r.getType(), str, new PropertiesPanel$$ExternalSyntheticLambda0(this, r));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit edit$lambda$13(PropertiesPanel propertiesPanel, Row row, Object obj) {
        propertiesPanel.applyEdit(row, obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit previewListener$lambda$1(PropertiesPanel propertiesPanel) {
        propertiesPanel.post(new PropertiesPanel$$ExternalSyntheticLambda1(propertiesPanel));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void previewListener$lambda$1$lambda$0(PropertiesPanel propertiesPanel) {
        propertiesPanel.adapter.notifyDataSetChanged();
    }

    private static final boolean rebuild$lambda$9$add(LinkedHashMap<String, ArrayList<Row>> linkedHashMap, String str, Row row) {
        ArrayList<Row> arrayList;
        LinkedHashMap<String, ArrayList<Row>> linkedHashMap2 = linkedHashMap;
        ArrayList<Row> arrayList2 = linkedHashMap2.get(str);
        if (arrayList2 == null) {
            arrayList = new ArrayList<>();
            linkedHashMap2.put(str, arrayList);
        } else {
            arrayList = arrayList2;
        }
        return arrayList.add(row);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit rebuild$lambda$9$lambda$4(Long l, Instance instance) {
        AudioEngine audioEngine = AudioEngine.INSTANCE;
        long longValue = l.longValue();
        Object obj = instance.get("Volume");
        Number number = obj instanceof Number ? (Number) obj : null;
        audioEngine.togglePreview(longValue, number != null ? number.floatValue() : 0.5f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Comparable rebuild$lambda$9$lambda$6(Row it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Integer.valueOf(Intrinsics.areEqual(it.getProp(), "@Preview") ? 0 : 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Comparable rebuild$lambda$9$lambda$7(Row it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String lowerCase = it.getDisplay().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private final String valueText(Row r, Instance inst) {
        String str;
        Object value = r.getValue();
        if (value == null) {
            return r.getType() != 19 ? "nil" : "";
        }
        if (value instanceof Instance) {
            return ((Instance) value).getName();
        }
        if (!(value instanceof EnumValue)) {
            if (value instanceof BrickColorV) {
                return ((BrickColorV) value).getName();
            }
            if (value instanceof Color3) {
                return "[" + ((int) (((Color3) value).getR() * 255.0f)) + ", " + ((int) (((Color3) value).getG() * 255.0f)) + ", " + ((int) (((Color3) value).getB() * 255.0f)) + "]";
            }
            if (value instanceof Float) {
                return DataTypesKt.fmtNum(((Number) value).floatValue());
            }
            if (value instanceof Double) {
                return DataTypesKt.fmtNum(((Number) value).doubleValue());
            }
            if (value instanceof Vector3) {
                return DataTypesKt.fmtNum(((Vector3) value).getX()) + ", " + DataTypesKt.fmtNum(((Vector3) value).getY()) + ", " + DataTypesKt.fmtNum(((Vector3) value).getZ());
            }
            return value instanceof CFrame ? ((CFrame) value).getPosition().toString() : value instanceof String ? StringsKt.take(StringsKt.replace$default((String) value, '\n', ' ', false, 4, (Object) null), 120) : value.toString();
        }
        Enums enums = Enums.INSTANCE;
        Enums enums2 = Enums.INSTANCE;
        if (inst == null || (str = inst.getClassName()) == null) {
            str = "";
        }
        String prop = r.getProp();
        String itemName = enums.itemName(enums2.typeForProp(str, prop != null ? prop : ""), ((EnumValue) value).getValue());
        if (itemName != null) {
            return itemName;
        }
        String itemName2 = Intrinsics.areEqual(r.getDisplay(), "Material") ? Enums.INSTANCE.itemName("Material", ((EnumValue) value).getValue()) : null;
        if (itemName2 != null) {
            return itemName2;
        }
        String itemName3 = StringsKt.endsWith$default(r.getDisplay(), "Surface", false, 2, (Object) null) ? Enums.INSTANCE.itemName("SurfaceType", ((EnumValue) value).getValue()) : null;
        if (itemName3 != null) {
            return itemName3;
        }
        String itemName4 = Intrinsics.areEqual(r.getDisplay(), "Shape") ? Enums.INSTANCE.itemName("PartType", ((EnumValue) value).getValue()) : null;
        return itemName4 == null ? String.valueOf(((EnumValue) value).getValue()) : itemName4;
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

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onDirtyChanged() {
        super.onDirtyChanged();
    }

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onModelReplaced() {
        rebuild();
    }

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onPlayStateChanged() {
        super.onPlayStateChanged();
    }

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onPluginsChanged() {
        super.onPluginsChanged();
    }

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onPropsChanged() {
        rebuild();
    }

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onSelectionChanged() {
        rebuild();
    }

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onToolChanged() {
        super.onToolChanged();
    }

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onTreeChanged() {
        super.onTreeChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v20 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r22v6 */
    /* JADX WARN: Type inference failed for: r22v7 */
    public final void rebuild() {
        StringBuilder append;
        String str;
        int i;
        ?? r16;
        boolean z;
        Vector3 zero;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        synchronized (this.studio.getLock()) {
            Instance instance = (Instance) CollectionsKt.firstOrNull((List) this.studio.getSelection());
            if (instance == null) {
                this.title.setText("");
            } else {
                TextView textView = this.title;
                boolean z3 = true;
                if (this.studio.getSelection().size() > 1) {
                    append = new StringBuilder().append(this.studio.getSelection().size());
                    str = " selected  ";
                } else {
                    append = new StringBuilder().append(instance.getClassName()).append(" \"").append(instance.getName());
                    str = "\"  ";
                }
                textView.setText(append.append(str).toString());
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                HashSet hashSet = new HashSet();
                boolean isA = instance.isA("BasePart");
                if (Intrinsics.areEqual(instance.getClassName(), "Sound")) {
                    Long idOf = AssetFetcher.INSTANCE.idOf(instance.get("SoundId"));
                    if (idOf != null) {
                        AudioEngine.Preview preview = AudioEngine.INSTANCE.getPreview();
                        i = 0;
                        rebuild$lambda$9$add(linkedHashMap, "Data", new Row("", "@Preview", "Preview", preview != null && (preview.getId() > idOf.longValue() ? 1 : (preview.getId() == idOf.longValue() ? 0 : -1)) == 0 && (preview.getState() == AudioEngine.PreviewState.PLAYING || preview.getState() == AudioEngine.PreviewState.LOADING) ? "■ Stop" : "▶ Play", 1, true, new PropertiesPanel$$ExternalSyntheticLambda2(idOf, instance)));
                    } else {
                        i = 0;
                    }
                } else {
                    i = 0;
                }
                rebuild$lambda$9$add(linkedHashMap, "Data", new Row("", "Name", "Name", instance.getName(), 1, !instance.getIsService() ? true : i, null, 64, null));
                hashSet.add("Name");
                rebuild$lambda$9$add(linkedHashMap, "Data", new Row("", "ClassName", "ClassName", instance.getClassName(), 1, false, null, 64, null));
                rebuild$lambda$9$add(linkedHashMap, "Data", new Row("", "Parent", "Parent", instance.getParent(), 19, false, null, 64, null));
                rebuild$lambda$9$add(linkedHashMap, "Behavior", new Row("", "@Archivable", "Archivable", Boolean.valueOf(instance.getArchivable()), 2, !instance.getIsService() ? true : i, null, 64, null));
                if (instance.isA("LuaSourceContainer")) {
                    rebuild$lambda$9$add(linkedHashMap, "Data", new Row("", "@Source", "Source", "Open in editor…", 1, true, null, 64, null));
                    hashSet.add("Source");
                }
                if (isA) {
                    CFrame cframe = PartData.INSTANCE.cframe(instance);
                    rebuild$lambda$9$add(linkedHashMap, "Transform", new Row("", "@Position", "Position", cframe.getPosition(), 14, true, null, 64, null));
                    rebuild$lambda$9$add(linkedHashMap, "Transform", new Row("", "@Orientation", "Orientation", cframe.toOrientation().times(DEG), 14, true, null, 64, null));
                    rebuild$lambda$9$add(linkedHashMap, "Transform", new Row("", instance.getProps().containsKey("size") ? "size" : "Size", "Size", PartData.INSTANCE.size(instance), 14, true, null, 64, null));
                    String[] strArr = new String[5];
                    strArr[i] = "CFrame";
                    strArr[1] = "size";
                    strArr[2] = "Size";
                    strArr[3] = "Position";
                    strArr[4] = "Orientation";
                    CollectionsKt.addAll(hashSet, CollectionsKt.listOf((Object[]) strArr));
                    Color3 color = PartData.INSTANCE.color(instance);
                    Object obj = instance.get("BrickColor");
                    BrickColorV brickColorV = obj instanceof BrickColorV ? (BrickColorV) obj : null;
                    if (brickColorV == null) {
                        brickColorV = new BrickColorV(BrickColors.INSTANCE.closest(color));
                    }
                    rebuild$lambda$9$add(linkedHashMap, "Appearance", new Row("", "@BrickColor", "BrickColor", brickColorV, 11, true, null, 64, null));
                    rebuild$lambda$9$add(linkedHashMap, "Appearance", new Row("", instance.getProps().containsKey("Color") ? "Color" : "Color3uint8", "Color", color, 26, true, null, 64, null));
                    Object obj2 = instance.get("Material");
                    if (obj2 == null) {
                        obj2 = new EnumValue(256);
                    }
                    rebuild$lambda$9$add(linkedHashMap, "Appearance", new Row("", "Material", "Material", obj2, 18, true, null, 64, null));
                    String str2 = instance.getProps().containsKey("MaterialVariantSerialized") ? "MaterialVariantSerialized" : "MaterialVariant";
                    Object obj3 = instance.get(str2);
                    if (obj3 == null) {
                        obj3 = "";
                    }
                    rebuild$lambda$9$add(linkedHashMap, "Appearance", new Row("", str2, "MaterialVariant", obj3, 1, true, null, 64, null));
                    Object obj4 = instance.get("Reflectance");
                    if (obj4 == null) {
                        obj4 = Float.valueOf(0.0f);
                    }
                    rebuild$lambda$9$add(linkedHashMap, "Appearance", new Row("", "Reflectance", "Reflectance", obj4, 4, true, null, 64, null));
                    Object obj5 = instance.get("Transparency");
                    if (obj5 == null) {
                        obj5 = Float.valueOf(0.0f);
                    }
                    rebuild$lambda$9$add(linkedHashMap, "Appearance", new Row("", "Transparency", "Transparency", obj5, 4, true, null, 64, null));
                    Object obj6 = instance.get("CastShadow");
                    if (obj6 == null) {
                        obj6 = true;
                    }
                    rebuild$lambda$9$add(linkedHashMap, "Appearance", new Row("", "CastShadow", "CastShadow", obj6, 2, true, null, 64, null));
                    String[] strArr2 = new String[9];
                    strArr2[i] = "BrickColor";
                    strArr2[1] = "Color";
                    strArr2[2] = "Color3uint8";
                    strArr2[3] = "Material";
                    strArr2[4] = "MaterialVariant";
                    strArr2[5] = "MaterialVariantSerialized";
                    strArr2[6] = "Reflectance";
                    strArr2[7] = "Transparency";
                    strArr2[8] = "CastShadow";
                    CollectionsKt.addAll(hashSet, CollectionsKt.listOf((Object[]) strArr2));
                    Object obj7 = instance.get("Locked");
                    if (obj7 == null) {
                        obj7 = Boolean.valueOf((boolean) i);
                    }
                    rebuild$lambda$9$add(linkedHashMap, "Behavior", new Row("", "Locked", "Locked", obj7, 2, true, null, 64, null));
                    Object obj8 = instance.get("CanCollide");
                    if (obj8 == null) {
                        obj8 = true;
                    }
                    rebuild$lambda$9$add(linkedHashMap, "Collision", new Row("", "CanCollide", "CanCollide", obj8, 2, true, null, 64, null));
                    Object obj9 = instance.get("CanQuery");
                    if (obj9 == null) {
                        obj9 = true;
                    }
                    rebuild$lambda$9$add(linkedHashMap, "Collision", new Row("", "CanQuery", "CanQuery", obj9, 2, true, null, 64, null));
                    Object obj10 = instance.get("CanTouch");
                    if (obj10 == null) {
                        obj10 = true;
                    }
                    rebuild$lambda$9$add(linkedHashMap, "Collision", new Row("", "CanTouch", "CanTouch", obj10, 2, true, null, 64, null));
                    Object obj11 = instance.get("CollisionGroup");
                    if (obj11 == null) {
                        obj11 = "Default";
                    }
                    rebuild$lambda$9$add(linkedHashMap, "Collision", new Row("", "CollisionGroup", "CollisionGroup", obj11, 1, true, null, 64, null));
                    Object obj12 = instance.get("Anchored");
                    if (obj12 == null) {
                        obj12 = Boolean.valueOf((boolean) i);
                    }
                    rebuild$lambda$9$add(linkedHashMap, "Part", new Row("", "Anchored", "Anchored", obj12, 2, true, null, 64, null));
                    Object obj13 = instance.get("Massless");
                    if (obj13 == null) {
                        obj13 = Boolean.valueOf((boolean) i);
                    }
                    rebuild$lambda$9$add(linkedHashMap, "Part", new Row("", "Massless", "Massless", obj13, 2, true, null, 64, null));
                    Object obj14 = instance.get("RootPriority");
                    if (obj14 == null) {
                        obj14 = Integer.valueOf(i);
                    }
                    rebuild$lambda$9$add(linkedHashMap, "Part", new Row("", "RootPriority", "RootPriority", obj14, 3, true, null, 64, null));
                    if (Intrinsics.areEqual(instance.getClassName(), "Part") || Intrinsics.areEqual(instance.getClassName(), "SpawnLocation") || Intrinsics.areEqual(instance.getClassName(), "Seat")) {
                        String str3 = instance.getProps().containsKey("Shape") ? "Shape" : "shape";
                        Object obj15 = instance.get("shape");
                        if (obj15 == null && (obj15 = instance.get("Shape")) == null) {
                            obj15 = new EnumValue(1);
                        }
                        rebuild$lambda$9$add(linkedHashMap, "Part", new Row("", str3, "Shape", obj15, 18, true, null, 64, null));
                    }
                    String[] strArr3 = new String[10];
                    strArr3[i] = "Locked";
                    strArr3[1] = "CanCollide";
                    strArr3[2] = "CanQuery";
                    strArr3[3] = "CanTouch";
                    strArr3[4] = "CollisionGroup";
                    strArr3[5] = "Anchored";
                    strArr3[6] = "Massless";
                    strArr3[7] = "RootPriority";
                    strArr3[8] = "shape";
                    strArr3[9] = "Shape";
                    CollectionsKt.addAll(hashSet, CollectionsKt.listOf((Object[]) strArr3));
                    if ((instance.isA("PartOperation") && !Intrinsics.areEqual(instance.getClassName(), "NegateOperation")) || Intrinsics.areEqual(instance.getClassName(), "MeshPart")) {
                        Object obj16 = instance.get("CollisionFidelity");
                        if (obj16 == null) {
                            obj16 = new EnumValue(i);
                        }
                        rebuild$lambda$9$add(linkedHashMap, "Collision", new Row("", "CollisionFidelity", "CollisionFidelity", obj16, 18, true, null, 64, null));
                        Object obj17 = instance.get("RenderFidelity");
                        if (obj17 == null) {
                            obj17 = new EnumValue(0);
                        }
                        rebuild$lambda$9$add(linkedHashMap, "Appearance", new Row("", "RenderFidelity", "RenderFidelity", obj17, 18, true, null, 64, null));
                        CollectionsKt.addAll(hashSet, CollectionsKt.listOf((Object[]) new String[]{"CollisionFidelity", "RenderFidelity"}));
                    }
                    if (instance.isA("PartOperation") || Intrinsics.areEqual(instance.getClassName(), "MeshPart") || Intrinsics.areEqual(instance.getClassName(), "Terrain")) {
                        z = true;
                    } else {
                        for (String str4 : surfaceProps) {
                            Object obj18 = instance.get(str4);
                            if (obj18 == null) {
                                z2 = z3;
                                obj18 = new EnumValue(0);
                            } else {
                                z2 = z3;
                            }
                            rebuild$lambda$9$add(linkedHashMap, "Surface", new Row("", str4, str4, obj18, 18, true, null, 64, null));
                            z3 = z2;
                        }
                        z = z3;
                    }
                    CollectionsKt.addAll(hashSet, surfaceProps);
                    Object obj19 = instance.get("PivotOffset");
                    CFrame cFrame = obj19 instanceof CFrame ? (CFrame) obj19 : null;
                    if (cFrame == null || (zero = cFrame.getPosition()) == null) {
                        zero = Vector3.INSTANCE.getZERO();
                    }
                    rebuild$lambda$9$add(linkedHashMap, "Pivot", new Row("", "PivotOffset", "Pivot Offset", zero, 14, true, null, 64, null));
                    hashSet.add("PivotOffset");
                    r16 = z;
                } else {
                    r16 = 1;
                }
                for (Map.Entry<String, Object> entry : instance.getProps().entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (!hashSet.contains(key) && !skip.contains(key) && (!StringsKt.startsWith$default(key, "xmlRead", false, 2, (Object) null) || value != null)) {
                        Integer num = instance.getPropTypes().get(key);
                        int intValue = num != null ? num.intValue() : PropType.INSTANCE.infer(value);
                        if (!PropType.INSTANCE.hidden(intValue, value)) {
                            String display = PropNames.INSTANCE.display(key);
                            if (!hashSet.contains(display)) {
                                rebuild$lambda$9$add(linkedHashMap, categoryOf(instance, display, intValue), new Row("", key, display, value, intValue, true, null, 64, null));
                            }
                        }
                    }
                }
                List<String> list = ORDER;
                Set keySet = linkedHashMap.keySet();
                Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
                ArrayList arrayList2 = new ArrayList();
                for (Object obj20 : keySet) {
                    if (!ORDER.contains((String) obj20)) {
                        arrayList2.add(obj20);
                    }
                }
                for (String str5 : CollectionsKt.plus((Collection) list, (Iterable) arrayList2)) {
                    ArrayList arrayList3 = (ArrayList) linkedHashMap.get(str5);
                    if (arrayList3 != null && !arrayList3.isEmpty()) {
                        arrayList.add(new Row(str5, null, str5, null, 0, false, null, 64, null));
                        if (!this.collapsed.contains(str5)) {
                            Function1[] function1Arr = new Function1[2];
                            function1Arr[0] = new PropertiesPanel$$ExternalSyntheticLambda3();
                            function1Arr[r16] = new PropertiesPanel$$ExternalSyntheticLambda4();
                            arrayList.addAll(CollectionsKt.sortedWith(arrayList3, ComparisonsKt.compareBy(function1Arr)));
                        }
                    }
                }
                if (!instance.getAttributes().isEmpty() || instance.getProps().containsKey("AttributesSerialize")) {
                    Attributes.INSTANCE.load(instance);
                    if (!instance.getAttributes().isEmpty()) {
                        arrayList.add(new Row("Attributes", null, "Attributes", null, 0, false, null, 64, null));
                        if (!this.collapsed.contains("Attributes")) {
                            Set<Map.Entry<String, Object>> entrySet = instance.getAttributes().entrySet();
                            Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
                            for (Object obj21 : CollectionsKt.sortedWith(entrySet, new PropertiesPanel$rebuild$lambda$9$$inlined$sortedBy$1())) {
                                Intrinsics.checkNotNullExpressionValue(obj21, "next(...)");
                                Map.Entry entry2 = (Map.Entry) obj21;
                                Object key2 = entry2.getKey();
                                Intrinsics.checkNotNullExpressionValue(key2, "component1(...)");
                                String str6 = (String) key2;
                                Object value2 = entry2.getValue();
                                if (!StringsKt.startsWith$default(str6, "__", false, 2, (Object) null)) {
                                    arrayList.add(new Row("", "@attr:" + str6, str6, value2, PropType.INSTANCE.infer(value2), false, null, 64, null));
                                }
                            }
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        this.rows = arrayList;
        this.adapter.notifyDataSetChanged();
    }
}
