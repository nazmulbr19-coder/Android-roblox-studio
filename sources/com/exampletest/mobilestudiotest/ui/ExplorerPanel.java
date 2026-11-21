package com.exampletest.mobilestudiotest.ui;

import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.model.ClassDb;
import com.exampletest.mobilestudiotest.model.DataModel;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.ui.Ui;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ExplorerPanel.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0004OPQRB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010-\u001a\u0004\u0018\u00010\f2\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u0011H\u0002J\u0018\u00100\u001a\u0002012\u0006\u0010\"\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\fH\u0002J\u0010\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u000205H\u0002J\u001a\u00106\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u00152\b\u00108\u001a\u0004\u0018\u000109H\u0002J\b\u0010:\u001a\u000201H\u0002J\u0006\u0010;\u001a\u000201J\b\u0010<\u001a\u000201H\u0002J\b\u0010=\u001a\u000201H\u0002J\u0016\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00150\u001b2\u0006\u0010?\u001a\u00020\u0015H\u0002J\u0006\u0010@\u001a\u000201J\b\u0010A\u001a\u000201H\u0002J\b\u0010B\u001a\u000201H\u0016J\b\u0010C\u001a\u000201H\u0016J\b\u0010D\u001a\u000201H\u0016J\b\u0010E\u001a\u000201H\u0016J\u0010\u0010F\u001a\u0002012\u0006\u00102\u001a\u00020\fH\u0002J\u0010\u0010G\u001a\u0002012\u0006\u00102\u001a\u00020\fH\u0002J\u0010\u0010H\u001a\u0002012\u0006\u00102\u001a\u00020\fH\u0002J\u0018\u0010I\u001a\u0002012\u0006\u0010J\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\fH\u0002J\u0010\u0010K\u001a\u0002012\u0006\u0010?\u001a\u00020\u0015H\u0002J\u0010\u0010L\u001a\u0002012\u0006\u0010?\u001a\u00020\u0015H\u0002J\u0010\u0010M\u001a\u0002012\b\u0010N\u001a\u0004\u0018\u00010\u0015R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u0016\u001a&\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00150\u0015 \u0018*\u0012\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00190\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00060\u001fR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010#\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020+\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel;", "Landroid/widget/LinearLayout;", "Lcom/exampletest/mobilestudiotest/core/Studio$Listener;", "ctx", "Landroid/content/Context;", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "actions", "Lcom/exampletest/mobilestudiotest/ui/MainActions;", "<init>", "(Landroid/content/Context;Lcom/exampletest/mobilestudiotest/core/Studio;Lcom/exampletest/mobilestudiotest/ui/MainActions;)V", "dragRow", "Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel$Row;", "dragAnchor", "Landroid/view/View;", "dragStart", "Lkotlin/Pair;", "", "dragMoved", "", "dropTarget", "Lcom/exampletest/mobilestudiotest/model/Instance;", "expanded", "", "kotlin.jvm.PlatformType", "", "rows", "", "list", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel$Adapter;", "filter", "", "v", "multiSelect", "getMultiSelect", "()Z", "setMultiSelect", "(Z)V", "multiBtn", "Landroid/widget/ImageView;", "lastClick", "", "rangeAnchor", "rowAt", "x", "y", "startDrag", "", "r", "onDrag", "e", "Landroid/view/DragEvent;", "canDropInto", TypedValues.AttributesType.S_TARGET, "payload", "Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel$DragPayload;", "updateMultiBtn", "refreshIcons", "expandDefaults", "collapseAll", "visibleChildren", "i", "rebuild", "revealSelection", "onTreeChanged", "onSelectionChanged", "onModelReplaced", "onToolChanged", "onRowClick", "selectRange", "toggleExpand", "showContextMenu", "anchor", "expandAll", "rename", "showInsertDialog", "parent", "Row", "DragPayload", "VH", "Adapter", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExplorerPanel extends LinearLayout implements Studio.Listener {
    private final MainActions actions;
    private final Adapter adapter;
    private View dragAnchor;
    private boolean dragMoved;
    private Row dragRow;
    private Pair<Float, Float> dragStart;
    private Instance dropTarget;
    private final Set<Instance> expanded;
    private String filter;
    private Pair<? extends Instance, Long> lastClick;
    private final RecyclerView list;
    private final ImageView multiBtn;
    private Instance rangeAnchor;
    private List<Row> rows;
    private final Studio studio;

    /* compiled from: ExplorerPanel.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"com/exampletest/mobilestudiotest/ui/ExplorerPanel$4", "Landroid/text/TextWatcher;", "beforeTextChanged", "", "s", "", "a", "", "b", "c", "onTextChanged", "afterTextChanged", "Landroid/text/Editable;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.exampletest.mobilestudiotest.ui.ExplorerPanel$4, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass4 implements TextWatcher {
        AnonymousClass4() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            String str;
            String obj;
            ExplorerPanel explorerPanel = ExplorerPanel.this;
            if (s == null || (obj = s.toString()) == null || (str = StringsKt.trim((CharSequence) obj).toString()) == null) {
                str = "";
            }
            ExplorerPanel.access$setFilter$p(explorerPanel, str);
            ExplorerPanel.this.rebuild();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int a, int b, int c) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int a, int b, int c) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExplorerPanel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel$VH;", "Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel;", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel;)V", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "h", "position", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class Adapter extends RecyclerView.Adapter<VH> {
        public Adapter() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void onBindViewHolder$lambda$6(ExplorerPanel explorerPanel, Row row, View view) {
            ExplorerPanel.access$onRowClick(explorerPanel, row);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void onBindViewHolder$lambda$7(ExplorerPanel explorerPanel, Row row, View view) {
            ExplorerPanel.access$toggleExpand(explorerPanel, row);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final boolean onBindViewHolder$lambda$8(ExplorerPanel explorerPanel, VH vh, Row row, View view) {
            ExplorerPanel.access$startDrag(explorerPanel, vh.getRow(), row);
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ExplorerPanel.access$getRows$p(ExplorerPanel.this).size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(VH vh, int i) {
            onBindViewHolder2(vh, i);
        }

        /* renamed from: onBindViewHolder, reason: avoid collision after fix types in other method */
        public void onBindViewHolder2(VH h, int position) {
            boolean z;
            Intrinsics.checkNotNullParameter(h, "h");
            Row row = (Row) ExplorerPanel.access$getRows$p(ExplorerPanel.this).get(position);
            h.getSpacer().setLayoutParams(new LinearLayout.LayoutParams((Ui.INSTANCE.dp(h.getRow(), 14.0f) * row.getDepth()) + Ui.INSTANCE.dp(h.getRow(), 2.0f), 1));
            int i = 0;
            h.getArrow().setImageDrawable(row.getHasChildren() ? new Ui.ArrowDrawable(row.getExpanded(), 0, 2, null) : null);
            ImageView icon = h.getIcon();
            Ui ui = Ui.INSTANCE;
            Context context = h.getRow().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            icon.setImageDrawable(ui.icon(context, row.getInst()));
            TextView name = h.getName();
            String label = row.getLabel();
            if (label.length() == 0) {
                label = " ";
            }
            name.setText(label);
            ArrayList<Instance> selection = ExplorerPanel.access$getStudio$p(ExplorerPanel.this).getSelection();
            if (!(selection instanceof Collection) || !selection.isEmpty()) {
                Iterator<T> it = selection.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else {
                        if (((Instance) it.next()) == row.getInst()) {
                            z = true;
                            break;
                        }
                    }
                }
            } else {
                z = false;
            }
            boolean z2 = ExplorerPanel.access$getDropTarget$p(ExplorerPanel.this) == row.getInst();
            LinearLayout row2 = h.getRow();
            if (z2) {
                i = 1715178475;
            } else if (z) {
                i = Ui.INSTANCE.getSELECT();
            }
            row2.setBackgroundColor(i);
            h.getName().setTextColor((!z || z2) ? Ui.INSTANCE.getTEXT() : Ui.INSTANCE.getSELECT_TEXT());
            h.getRow().setOnClickListener(new ExplorerPanel$Adapter$$ExternalSyntheticLambda0(ExplorerPanel.this, row));
            h.getArrow().setOnClickListener(new ExplorerPanel$Adapter$$ExternalSyntheticLambda1(ExplorerPanel.this, row));
            h.getRow().setOnLongClickListener(new ExplorerPanel$Adapter$$ExternalSyntheticLambda2(ExplorerPanel.this, h, row));
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
            linearLayout.setMinimumHeight(ui.dp(context, 28.0f));
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            View view = new View(context);
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ImageView imageView2 = new ImageView(context);
            imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
            TextView text$default = Ui.text$default(Ui.INSTANCE, context, "", 13.0f, 0, false, 24, null);
            text$default.setPadding(Ui.INSTANCE.dp(context, 6.0f), 0, Ui.INSTANCE.dp(context, 4.0f), 0);
            linearLayout.addView(view, new LinearLayout.LayoutParams(0, 1));
            linearLayout.addView(imageView, new LinearLayout.LayoutParams(Ui.INSTANCE.dp(context, 20.0f), Ui.INSTANCE.dp(context, 28.0f)));
            linearLayout.addView(imageView2, new LinearLayout.LayoutParams(Ui.INSTANCE.dp(context, 16.0f), Ui.INSTANCE.dp(context, 16.0f)));
            linearLayout.addView(text$default, new LinearLayout.LayoutParams(0, -2, 1.0f));
            return new VH(ExplorerPanel.this, linearLayout, view, imageView, imageView2, text$default);
        }
    }

    /* compiled from: ExplorerPanel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel$DragPayload;", "", "items", "", "Lcom/exampletest/mobilestudiotest/model/Instance;", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DragPayload {
        private final List<Instance> items;

        /* JADX WARN: Multi-variable type inference failed */
        public DragPayload(List<? extends Instance> items) {
            Intrinsics.checkNotNullParameter(items, "items");
            this.items = items;
        }

        public final List<Instance> getItems() {
            return this.items;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExplorerPanel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel$Row;", "", "inst", "Lcom/exampletest/mobilestudiotest/model/Instance;", "depth", "", "hasChildren", "", "expanded", "label", "", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Instance;IZZLjava/lang/String;)V", "getInst", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "getDepth", "()I", "getHasChildren", "()Z", "getExpanded", "getLabel", "()Ljava/lang/String;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Row {
        private final int depth;
        private final boolean expanded;
        private final boolean hasChildren;
        private final Instance inst;
        private final String label;

        public Row(Instance inst, int i, boolean z, boolean z2, String label) {
            Intrinsics.checkNotNullParameter(inst, "inst");
            Intrinsics.checkNotNullParameter(label, "label");
            this.inst = inst;
            this.depth = i;
            this.hasChildren = z;
            this.expanded = z2;
            this.label = label;
        }

        public final int getDepth() {
            return this.depth;
        }

        public final boolean getExpanded() {
            return this.expanded;
        }

        public final boolean getHasChildren() {
            return this.hasChildren;
        }

        public final Instance getInst() {
            return this.inst;
        }

        public final String getLabel() {
            return this.label;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExplorerPanel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0082\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "row", "Landroid/widget/LinearLayout;", "spacer", "Landroid/view/View;", "arrow", "Landroid/widget/ImageView;", "icon", "name", "Landroid/widget/TextView;", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel;Landroid/widget/LinearLayout;Landroid/view/View;Landroid/widget/ImageView;Landroid/widget/ImageView;Landroid/widget/TextView;)V", "getRow", "()Landroid/widget/LinearLayout;", "getSpacer", "()Landroid/view/View;", "getArrow", "()Landroid/widget/ImageView;", "getIcon", "getName", "()Landroid/widget/TextView;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class VH extends RecyclerView.ViewHolder {
        private final ImageView arrow;
        private final ImageView icon;
        private final TextView name;
        private final LinearLayout row;
        private final View spacer;
        final /* synthetic */ ExplorerPanel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VH(ExplorerPanel explorerPanel, LinearLayout row, View spacer, ImageView arrow, ImageView icon, TextView name) {
            super(row);
            Intrinsics.checkNotNullParameter(row, "row");
            Intrinsics.checkNotNullParameter(spacer, "spacer");
            Intrinsics.checkNotNullParameter(arrow, "arrow");
            Intrinsics.checkNotNullParameter(icon, "icon");
            Intrinsics.checkNotNullParameter(name, "name");
            this.this$0 = explorerPanel;
            this.row = row;
            this.spacer = spacer;
            this.arrow = arrow;
            this.icon = icon;
            this.name = name;
        }

        public final ImageView getArrow() {
            return this.arrow;
        }

        public final ImageView getIcon() {
            return this.icon;
        }

        public final TextView getName() {
            return this.name;
        }

        public final LinearLayout getRow() {
            return this.row;
        }

        public final View getSpacer() {
            return this.spacer;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExplorerPanel(Context ctx, Studio studio, MainActions actions) {
        super(ctx);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(studio, "studio");
        Intrinsics.checkNotNullParameter(actions, "actions");
        this.studio = studio;
        this.actions = actions;
        this.expanded = Collections.newSetFromMap(new IdentityHashMap());
        this.rows = CollectionsKt.emptyList();
        this.list = new RecyclerView(ctx);
        this.adapter = new Adapter();
        this.filter = "";
        setOrientation(1);
        setBackgroundColor(Ui.INSTANCE.getPANEL());
        LinearLayout header = Ui.INSTANCE.header(ctx, "Explorer", Icons.general$default(Icons.INSTANCE, ctx, "Explorer", null, 4, null));
        this.multiBtn = Ui.iconButton$default(Ui.INSTANCE, ctx, Icons.INSTANCE.general(ctx, "SelectAll", "Multi"), 0.0f, new ExplorerPanel$$ExternalSyntheticLambda3(this), 4, null);
        header.addView(this.multiBtn);
        header.addView(Ui.iconButton$default(Ui.INSTANCE, ctx, Icons.INSTANCE.general(ctx, "InsertObject", "+"), 0.0f, new ExplorerPanel$$ExternalSyntheticLambda4(this), 4, null));
        header.addView(Ui.iconButton$default(Ui.INSTANCE, ctx, Icons.INSTANCE.general(ctx, "CollapseAll", "Col"), 0.0f, new ExplorerPanel$$ExternalSyntheticLambda5(this), 4, null));
        addView(header, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        EditText input$default = Ui.input$default(Ui.INSTANCE, ctx, "", "Filter workspace (name or class)", false, false, 24, null);
        input$default.setTextSize(12.0f);
        input$default.addTextChangedListener(new AnonymousClass4());
        LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
        lp$default.setMargins(Ui.INSTANCE.dp(ctx, 4.0f), Ui.INSTANCE.dp(ctx, 4.0f), Ui.INSTANCE.dp(ctx, 4.0f), Ui.INSTANCE.dp(ctx, 4.0f));
        Unit unit = Unit.INSTANCE;
        addView(input$default, lp$default);
        this.list.setLayoutManager(new LinearLayoutManager(ctx));
        this.list.setAdapter(this.adapter);
        this.list.setItemAnimator(null);
        addView(this.list, Ui.INSTANCE.lp(-1, 0, 1.0f));
        this.list.setOnDragListener(new ExplorerPanel$$ExternalSyntheticLambda6(this));
        expandDefaults();
        rebuild();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$0(ExplorerPanel explorerPanel, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        explorerPanel.setMultiSelect(!explorerPanel.getMultiSelect());
        explorerPanel.updateMultiBtn();
        explorerPanel.studio.toast(explorerPanel.getMultiSelect() ? "Multi-select on: tap objects to add or remove them" : "Multi-select off");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$1(ExplorerPanel explorerPanel, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        explorerPanel.showInsertDialog((Instance) CollectionsKt.firstOrNull((List) explorerPanel.studio.getSelection()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$2(ExplorerPanel explorerPanel, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        explorerPanel.collapseAll();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean _init_$lambda$4(ExplorerPanel explorerPanel, View view, DragEvent dragEvent) {
        Intrinsics.checkNotNull(dragEvent);
        return explorerPanel.onDrag(dragEvent);
    }

    public static final /* synthetic */ Instance access$getDropTarget$p(ExplorerPanel explorerPanel) {
        return explorerPanel.dropTarget;
    }

    public static final /* synthetic */ List access$getRows$p(ExplorerPanel explorerPanel) {
        return explorerPanel.rows;
    }

    public static final /* synthetic */ Studio access$getStudio$p(ExplorerPanel explorerPanel) {
        return explorerPanel.studio;
    }

    public static final /* synthetic */ void access$onRowClick(ExplorerPanel explorerPanel, Row row) {
        explorerPanel.onRowClick(row);
    }

    public static final /* synthetic */ void access$setFilter$p(ExplorerPanel explorerPanel, String str) {
        explorerPanel.filter = str;
    }

    public static final /* synthetic */ void access$startDrag(ExplorerPanel explorerPanel, View view, Row row) {
        explorerPanel.startDrag(view, row);
    }

    public static final /* synthetic */ void access$toggleExpand(ExplorerPanel explorerPanel, Row row) {
        explorerPanel.toggleExpand(row);
    }

    private final boolean canDropInto(Instance target, DragPayload payload) {
        List<Instance> items;
        if (payload == null || (items = payload.getItems()) == null) {
            return false;
        }
        List<Instance> list = items;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        for (Instance instance : list) {
            if (instance == target || target.isDescendantOf(instance)) {
                return false;
            }
        }
        return true;
    }

    private final void collapseAll() {
        this.expanded.clear();
        rebuild();
    }

    private final void expandAll(Instance i) {
        synchronized (this.studio.getLock()) {
            this.expanded.add(i);
            int i2 = 0;
            for (Instance instance : Instance.descendants$default(i, null, 1, null)) {
                if (!instance.getChildren().isEmpty()) {
                    this.expanded.add(instance);
                    i2++;
                    if (i2 > 500) {
                        break;
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        rebuild();
    }

    private final void expandDefaults() {
        this.expanded.clear();
        synchronized (this.studio.getLock()) {
            Instance findService = this.studio.getModel().findService("Workspace");
            if (findService != null) {
                Boolean.valueOf(this.expanded.add(findService));
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final boolean onDrag(DragEvent e) {
        Row rowAt;
        Instance inst;
        Row rowAt2;
        Instance inst2;
        Object localState = e.getLocalState();
        Instance instance = null;
        DragPayload dragPayload = localState instanceof DragPayload ? (DragPayload) localState : null;
        switch (e.getAction()) {
            case 1:
                return dragPayload != null;
            case 2:
                if (this.dragStart == null) {
                    this.dragStart = TuplesKt.to(Float.valueOf(e.getX()), Float.valueOf(e.getY()));
                } else if (((float) Math.hypot(e.getX() - r1.getFirst().floatValue(), e.getY() - r1.getSecond().floatValue())) > getResources().getDisplayMetrics().density * 22.0f) {
                    this.dragMoved = true;
                }
                if (this.dragMoved && (rowAt = rowAt(e.getX(), e.getY())) != null && (inst = rowAt.getInst()) != null && canDropInto(inst, dragPayload)) {
                    instance = inst;
                }
                if (instance != this.dropTarget) {
                    this.dropTarget = instance;
                    this.adapter.notifyDataSetChanged();
                }
                return true;
            case 3:
                if (!this.dragMoved || dragPayload == null || (rowAt2 = rowAt(e.getX(), e.getY())) == null || (inst2 = rowAt2.getInst()) == null || !canDropInto(inst2, dragPayload)) {
                    return false;
                }
                synchronized (this.studio.getLock()) {
                    this.studio.getUndo().begin("Reparent");
                    for (Instance instance2 : dragPayload.getItems()) {
                        if (instance2 != inst2 && !inst2.isDescendantOf(instance2) && instance2.getParent() != inst2) {
                            this.studio.reparent(instance2, inst2);
                        }
                    }
                    this.studio.getUndo().commit();
                    this.expanded.add(inst2);
                }
                this.studio.select(dragPayload.getItems());
                return true;
            case 4:
                if (this.dropTarget != null) {
                    this.dropTarget = null;
                    this.adapter.notifyDataSetChanged();
                }
                Row row = this.dragRow;
                View view = this.dragAnchor;
                if (!this.dragMoved && !e.getResult() && row != null && view != null && view.isAttachedToWindow()) {
                    showContextMenu(view, row);
                }
                this.dragRow = null;
                this.dragAnchor = null;
                return true;
            case 5:
            default:
                return true;
            case 6:
                this.dragMoved = true;
                if (this.dropTarget != null) {
                    this.dropTarget = null;
                    this.adapter.notifyDataSetChanged();
                }
                return true;
        }
    }

    private final void onRowClick(Row r) {
        long currentTimeMillis = System.currentTimeMillis();
        Pair<? extends Instance, Long> pair = this.lastClick;
        if (pair != null && pair.getFirst() == r.getInst() && currentTimeMillis - pair.getSecond().longValue() < 350 && r.getInst().isA("LuaSourceContainer")) {
            this.studio.openScript(r.getInst());
            this.lastClick = null;
            return;
        }
        this.lastClick = TuplesKt.to(r.getInst(), Long.valueOf(currentTimeMillis));
        if (getMultiSelect() || this.studio.getModifierHeld()) {
            this.studio.toggleSelect(r.getInst());
        } else {
            this.studio.select(CollectionsKt.listOf(r.getInst()));
        }
        this.rangeAnchor = r.getInst();
    }

    private static final void rebuild$lambda$19$walk(ExplorerPanel explorerPanel, ArrayList<Row> arrayList, Instance instance, int i) {
        for (Instance instance2 : explorerPanel.visibleChildren(instance)) {
            boolean contains = explorerPanel.expanded.contains(instance2);
            int i2 = i;
            arrayList.add(new Row(instance2, i2, !explorerPanel.visibleChildren(instance2).isEmpty(), contains, instance2.getName()));
            if (contains) {
                rebuild$lambda$19$walk(explorerPanel, arrayList, instance2, i2 + 1);
                i = i2;
            } else {
                i = i2;
            }
        }
    }

    private final void rename(Instance i) {
        Ui ui = Ui.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        EditText input$default = Ui.input$default(ui, context, i.getName(), null, false, false, 28, null);
        Dialogs dialogs = Dialogs.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        dialogs.themed(context2).setTitle("Rename").setView(input$default).setPositiveButton("OK", new ExplorerPanel$$ExternalSyntheticLambda1(this, i, input$default)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
        input$default.requestFocus();
        input$default.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void rename$lambda$52(ExplorerPanel explorerPanel, Instance instance, EditText editText, DialogInterface dialogInterface, int i) {
        explorerPanel.studio.setProp(instance, "Name", editText.getText().toString());
    }

    private final void revealSelection() {
        Instance instance = (Instance) CollectionsKt.firstOrNull((List) this.studio.getSelection());
        if (instance == null) {
            return;
        }
        synchronized (this.studio.getLock()) {
            for (Instance parent = instance.getParent(); parent != null && !(parent instanceof DataModel); parent = parent.getParent()) {
                this.expanded.add(parent);
            }
            Unit unit = Unit.INSTANCE;
        }
        rebuild();
        int i = 0;
        Iterator<Row> it = this.rows.iterator();
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next().getInst() == instance) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            RecyclerView.LayoutManager layoutManager = this.list.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            Ui ui = Ui.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, ui.dp(context, 60.0f));
        }
    }

    private final Row rowAt(float x, float y) {
        View findChildViewUnder = this.list.findChildViewUnder(x, y);
        if (findChildViewUnder == null) {
            return null;
        }
        return (Row) CollectionsKt.getOrNull(this.rows, this.list.getChildAdapterPosition(findChildViewUnder));
    }

    private final void selectRange(Row r) {
        int i;
        List<? extends Instance> list;
        boolean z;
        Instance instance = this.rangeAnchor;
        if (instance == null) {
            this.studio.select(CollectionsKt.listOf(r.getInst()));
            return;
        }
        int i2 = 0;
        Iterator<Row> it = this.rows.iterator();
        while (true) {
            i = -1;
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (it.next().getInst() == instance) {
                break;
            } else {
                i2++;
            }
        }
        int i3 = 0;
        Iterator<Row> it2 = this.rows.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            if (it2.next().getInst() == r.getInst()) {
                i = i3;
                break;
            }
            i3++;
        }
        if (i2 >= 0 && i >= 0) {
            List<Row> subList = this.rows.subList(Math.min(i2, i), Math.max(i2, i) + 1);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subList, 10));
            Iterator<T> it3 = subList.iterator();
            while (it3.hasNext()) {
                arrayList.add(((Row) it3.next()).getInst());
            }
            ArrayList arrayList2 = arrayList;
            Studio studio = this.studio;
            if (getMultiSelect()) {
                List list2 = CollectionsKt.toList(this.studio.getSelection());
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : arrayList2) {
                    Instance instance2 = (Instance) obj;
                    ArrayList<Instance> selection = this.studio.getSelection();
                    Instance instance3 = instance;
                    if ((selection instanceof Collection) && selection.isEmpty()) {
                        z = true;
                    } else {
                        Iterator it4 = selection.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                z = true;
                                break;
                            }
                            Iterator it5 = it4;
                            if (((Instance) it4.next()) == instance2) {
                                z = false;
                                break;
                            }
                            it4 = it5;
                        }
                    }
                    if (z) {
                        arrayList3.add(obj);
                    }
                    instance = instance3;
                }
                list = CollectionsKt.plus((Collection) list2, (Iterable) arrayList3);
            } else {
                list = arrayList2;
            }
            studio.select(list);
            return;
        }
        this.studio.select(CollectionsKt.listOf(r.getInst()));
    }

    private final void showContextMenu(View anchor, Row r) {
        boolean z;
        ArrayList<Instance> selection = this.studio.getSelection();
        if (!(selection instanceof Collection) || !selection.isEmpty()) {
            Iterator<T> it = selection.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((Instance) it.next()) == r.getInst()) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
        } else {
            z = true;
        }
        if (z) {
            this.studio.select(CollectionsKt.listOf(r.getInst()));
        }
        Ui ui = Ui.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        PopupMenu popupMenu = new PopupMenu(ui.popupContext(context), anchor);
        Instance inst = r.getInst();
        ArrayList arrayList = new ArrayList();
        arrayList.add(TuplesKt.to("Insert Object…", new ExplorerPanel$$ExternalSyntheticLambda7(this, inst)));
        Instance instance = this.rangeAnchor;
        if (instance != null && instance != inst) {
            arrayList.add(TuplesKt.to("Select from “" + instance.getName() + "” to here", new ExplorerPanel$$ExternalSyntheticLambda16(this, r)));
        }
        if (!inst.getChildren().isEmpty()) {
            arrayList.add(TuplesKt.to("Select Children", new ExplorerPanel$$ExternalSyntheticLambda17(this, inst)));
        }
        if (this.studio.getSelection().size() > 1) {
            arrayList.add(TuplesKt.to("Select Group (parent Model)", new ExplorerPanel$$ExternalSyntheticLambda18(this)));
        }
        if (inst.isA("LuaSourceContainer")) {
            arrayList.add(TuplesKt.to("Open Script", new ExplorerPanel$$ExternalSyntheticLambda19(this, inst)));
        }
        if (!inst.getIsService()) {
            arrayList.add(TuplesKt.to("Rename", new ExplorerPanel$$ExternalSyntheticLambda20(this, inst)));
            arrayList.add(TuplesKt.to("Duplicate", new ExplorerPanel$$ExternalSyntheticLambda21(this)));
            arrayList.add(TuplesKt.to("Copy", new ExplorerPanel$$ExternalSyntheticLambda22(this)));
            arrayList.add(TuplesKt.to("Cut", new ExplorerPanel$$ExternalSyntheticLambda23(this)));
        }
        if (this.studio.getHasClipboard()) {
            arrayList.add(TuplesKt.to("Paste Into", new ExplorerPanel$$ExternalSyntheticLambda24(this, inst)));
        }
        if (!inst.getIsService()) {
            arrayList.add(TuplesKt.to("Delete", new ExplorerPanel$$ExternalSyntheticLambda8(this)));
            arrayList.add(TuplesKt.to("Group (Model)", new ExplorerPanel$$ExternalSyntheticLambda9(this)));
            if (Intrinsics.areEqual(inst.getClassName(), "Model") || Intrinsics.areEqual(inst.getClassName(), "Folder")) {
                arrayList.add(TuplesKt.to("Ungroup", new ExplorerPanel$$ExternalSyntheticLambda10(this)));
            }
            arrayList.add(TuplesKt.to("Zoom To", new ExplorerPanel$$ExternalSyntheticLambda11(this)));
            arrayList.add(TuplesKt.to("Save to File (.rbxm)…", new ExplorerPanel$$ExternalSyntheticLambda12(this)));
            arrayList.add(TuplesKt.to("Add to Toolbox", new ExplorerPanel$$ExternalSyntheticLambda13(this)));
        }
        if (!inst.getChildren().isEmpty()) {
            arrayList.add(TuplesKt.to("Expand All", new ExplorerPanel$$ExternalSyntheticLambda14(this, inst)));
        }
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            popupMenu.getMenu().add(0, i, i, (String) ((Pair) obj).component1());
            i = i2;
            inst = inst;
        }
        popupMenu.setOnMenuItemClickListener(new ExplorerPanel$$ExternalSyntheticLambda15(arrayList));
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showContextMenu$lambda$29(ExplorerPanel explorerPanel, Instance instance) {
        explorerPanel.showInsertDialog(instance);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showContextMenu$lambda$30(ExplorerPanel explorerPanel, Row row) {
        explorerPanel.selectRange(row);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showContextMenu$lambda$31(ExplorerPanel explorerPanel, Instance instance) {
        explorerPanel.studio.select(explorerPanel.visibleChildren(instance));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x006e, code lost:
    
        if ((r1 != null && r1.getIsService()) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit showContextMenu$lambda$35(com.exampletest.mobilestudiotest.ui.ExplorerPanel r23) {
        /*
            r0 = r23
            com.exampletest.mobilestudiotest.core.Studio r1 = r0.studio
            java.util.ArrayList r1 = r1.getSelection()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            r2 = 0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            r4 = r1
            r5 = 0
            r6 = r4
            r7 = 0
            java.util.Iterator r8 = r6.iterator()
        L1a:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L94
            java.lang.Object r9 = r8.next()
            r10 = r9
            r11 = 0
            r12 = r10
            com.exampletest.mobilestudiotest.model.Instance r12 = (com.exampletest.mobilestudiotest.model.Instance) r12
            r13 = 0
            com.exampletest.mobilestudiotest.model.Instance r14 = r12.getParent()
            com.exampletest.mobilestudiotest.ui.ExplorerPanel$$ExternalSyntheticLambda25 r15 = new com.exampletest.mobilestudiotest.ui.ExplorerPanel$$ExternalSyntheticLambda25
            r15.<init>()
            kotlin.sequences.Sequence r14 = kotlin.sequences.SequencesKt.generateSequence(r14, r15)
            r15 = 0
            r16 = 0
            java.util.Iterator r17 = r14.iterator()
        L3e:
            boolean r18 = r17.hasNext()
            if (r18 == 0) goto L80
            java.lang.Object r18 = r17.next()
            r19 = r18
            com.exampletest.mobilestudiotest.model.Instance r19 = (com.exampletest.mobilestudiotest.model.Instance) r19
            r20 = 0
            r21 = r1
            java.lang.String r1 = r19.getClassName()
            r22 = r2
            java.lang.String r2 = "Model"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 == 0) goto L71
            com.exampletest.mobilestudiotest.model.Instance r1 = r19.getParent()
            r2 = 1
            if (r1 == 0) goto L6d
            boolean r1 = r1.getIsService()
            if (r1 != r2) goto L6d
            r1 = r2
            goto L6e
        L6d:
            r1 = 0
        L6e:
            if (r1 == 0) goto L71
            goto L72
        L71:
            r2 = 0
        L72:
            if (r2 == 0) goto L7b
            r16 = r18
            r1 = r21
            r2 = r22
            goto L3e
        L7b:
            r1 = r21
            r2 = r22
            goto L3e
        L80:
            r21 = r1
            r22 = r2
            r1 = r16
            com.exampletest.mobilestudiotest.model.Instance r1 = (com.exampletest.mobilestudiotest.model.Instance) r1
            if (r1 == 0) goto L8f
            r2 = 0
            r3.add(r1)
        L8f:
            r1 = r21
            r2 = r22
            goto L1a
        L94:
            r21 = r1
            r22 = r2
            r1 = r3
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List r1 = kotlin.collections.CollectionsKt.distinct(r1)
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto Lb1
            com.exampletest.mobilestudiotest.core.Studio r2 = r0.studio
            r2.select(r1)
        Lb1:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.ExplorerPanel.showContextMenu$lambda$35(com.exampletest.mobilestudiotest.ui.ExplorerPanel):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Instance showContextMenu$lambda$35$lambda$34$lambda$32(Instance it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getParent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showContextMenu$lambda$36(ExplorerPanel explorerPanel, Instance instance) {
        explorerPanel.studio.openScript(instance);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showContextMenu$lambda$37(ExplorerPanel explorerPanel, Instance instance) {
        explorerPanel.rename(instance);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showContextMenu$lambda$38(ExplorerPanel explorerPanel) {
        explorerPanel.studio.duplicateSelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showContextMenu$lambda$39(ExplorerPanel explorerPanel) {
        explorerPanel.studio.copySelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showContextMenu$lambda$40(ExplorerPanel explorerPanel) {
        explorerPanel.studio.cutSelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showContextMenu$lambda$41(ExplorerPanel explorerPanel, Instance instance) {
        explorerPanel.studio.paste(instance);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showContextMenu$lambda$42(ExplorerPanel explorerPanel) {
        explorerPanel.studio.deleteSelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showContextMenu$lambda$43(ExplorerPanel explorerPanel) {
        explorerPanel.studio.groupSelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showContextMenu$lambda$44(ExplorerPanel explorerPanel) {
        explorerPanel.studio.ungroupSelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showContextMenu$lambda$45(ExplorerPanel explorerPanel) {
        explorerPanel.studio.focusSelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showContextMenu$lambda$46(ExplorerPanel explorerPanel) {
        explorerPanel.actions.exportSelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showContextMenu$lambda$47(ExplorerPanel explorerPanel) {
        explorerPanel.actions.addSelectionToToolbox();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showContextMenu$lambda$48(ExplorerPanel explorerPanel, Instance instance) {
        explorerPanel.expandAll(instance);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean showContextMenu$lambda$50(ArrayList arrayList, MenuItem menuItem) {
        ((Function0) ((Pair) arrayList.get(menuItem.getItemId())).getSecond()).invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showInsertDialog$lambda$54(ExplorerPanel explorerPanel, Instance instance, String cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        Studio studio = explorerPanel.studio;
        Instance instance2 = null;
        if (instance != null) {
            if ((instance.isA("BasePart") && ClassDb.INSTANCE.isA(cls, "BasePart")) ? false : true) {
                instance2 = instance;
            }
        }
        studio.insertObject(cls, instance2);
        return Unit.INSTANCE;
    }

    private final void startDrag(View v, Row r) {
        ArrayList arrayList;
        ArrayList<Instance> selection = this.studio.getSelection();
        boolean z = true;
        boolean z2 = false;
        if (!(selection instanceof Collection) || !selection.isEmpty()) {
            Iterator<T> it = selection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((Instance) it.next()) == r.getInst()) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            this.studio.select(CollectionsKt.listOf(r.getInst()));
        }
        synchronized (this.studio.getLock()) {
            ArrayList<Instance> selection2 = this.studio.getSelection();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : selection2) {
                if (!((Instance) obj).getIsService()) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        }
        this.dragRow = r;
        this.dragAnchor = v;
        this.dragStart = null;
        this.dragMoved = false;
        if (arrayList.isEmpty()) {
            showContextMenu(v, r);
            return;
        }
        try {
            z2 = v.startDragAndDrop(ClipData.newPlainText("instances", CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, new ExplorerPanel$$ExternalSyntheticLambda2(), 31, null)), new View.DragShadowBuilder(v), new DragPayload(arrayList), 0);
        } catch (Exception e) {
        }
        if (z2) {
            return;
        }
        showContextMenu(v, r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence startDrag$lambda$8(Instance it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getName();
    }

    private final void toggleExpand(Row r) {
        if (r.getHasChildren()) {
            if (this.expanded.contains(r.getInst())) {
                this.expanded.remove(r.getInst());
            } else {
                this.expanded.add(r.getInst());
            }
            rebuild();
        }
    }

    private final void updateMultiBtn() {
        RippleDrawable rippleBg$default;
        ImageView imageView = this.multiBtn;
        if (getMultiSelect()) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(Ui.INSTANCE.getSELECT());
            Ui ui = Ui.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(getContext(), "getContext(...)");
            gradientDrawable.setCornerRadius(ui.dp(r6, 4.0f));
            rippleBg$default = gradientDrawable;
        } else {
            Ui ui2 = Ui.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            rippleBg$default = Ui.rippleBg$default(ui2, context, 0, 0.0f, 4, null);
        }
        imageView.setBackground(rippleBg$default);
    }

    private final List<Instance> visibleChildren(Instance i) {
        if (i instanceof DataModel) {
            List<String> serviceNames = ClassDb.INSTANCE.getServiceNames();
            ArrayList<Instance> children = i.getChildren();
            ArrayList arrayList = new ArrayList();
            for (Object obj : children) {
                Instance instance = (Instance) obj;
                if (instance.getArchivable() || serviceNames.contains(instance.getClassName())) {
                    arrayList.add(obj);
                }
            }
            return CollectionsKt.sortedWith(arrayList, new ExplorerPanel$visibleChildren$$inlined$sortedBy$1(serviceNames));
        }
        if (!i.isA("PartOperation")) {
            return i.getChildren();
        }
        ArrayList<Instance> children2 = i.getChildren();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : children2) {
            if (!((Instance) obj2).isA("BasePart")) {
                arrayList2.add(obj2);
            }
        }
        return arrayList2;
    }

    public final boolean getMultiSelect() {
        return this.studio.getMultiSelect();
    }

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onDirtyChanged() {
        super.onDirtyChanged();
    }

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onModelReplaced() {
        expandDefaults();
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
        super.onPropsChanged();
    }

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onSelectionChanged() {
        revealSelection();
    }

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onToolChanged() {
        updateMultiBtn();
    }

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onTreeChanged() {
        rebuild();
    }

    public final void rebuild() {
        String str;
        ArrayList arrayList = new ArrayList();
        synchronized (this.studio.getLock()) {
            DataModel model = this.studio.getModel();
            if (this.filter.length() > 0) {
                String lowerCase = this.filter.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                for (Instance instance : Instance.descendants$default(model, null, 1, null)) {
                    if (arrayList.size() > 2000) {
                        break;
                    }
                    String lowerCase2 = instance.getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (!StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) lowerCase, false, 2, (Object) null)) {
                        String lowerCase3 = instance.getClassName().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                        if (!Intrinsics.areEqual(lowerCase3, lowerCase)) {
                        }
                    }
                    String name = instance.getName();
                    Instance parent = instance.getParent();
                    if (parent == null || (str = parent.fullName()) == null) {
                        str = "";
                    }
                    arrayList.add(new Row(instance, 0, false, false, name + "  ·  " + str));
                }
            } else {
                rebuild$lambda$19$walk(this, arrayList, model, 0);
            }
            Unit unit = Unit.INSTANCE;
        }
        this.rows = arrayList;
        this.adapter.notifyDataSetChanged();
    }

    public final void refreshIcons() {
        this.adapter.notifyDataSetChanged();
    }

    public final void setMultiSelect(boolean z) {
        this.studio.setMultiSelect(z);
    }

    public final void showInsertDialog(Instance parent) {
        Dialogs dialogs = Dialogs.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        dialogs.pickClass(context, "Insert Object", new ExplorerPanel$$ExternalSyntheticLambda0(this, parent));
    }
}
