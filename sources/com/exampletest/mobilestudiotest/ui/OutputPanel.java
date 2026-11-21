package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.exampletest.mobilestudiotest.core.OutputLog;
import com.exampletest.mobilestudiotest.core.Studio;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: OutputPanel.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\b\u0010\u001c\u001a\u00020\u001aH\u0014J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00060\u000fR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00150\tj\b\u0012\u0004\u0012\u00020\u0015`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/OutputPanel;", "Landroid/widget/LinearLayout;", "ctx", "Landroid/content/Context;", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "<init>", "(Landroid/content/Context;Lcom/exampletest/mobilestudiotest/core/Studio;)V", "entries", "Ljava/util/ArrayList;", "Lcom/exampletest/mobilestudiotest/core/OutputLog$Entry;", "Lkotlin/collections/ArrayList;", "list", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/exampletest/mobilestudiotest/ui/OutputPanel$Adapter;", "fmt", "Ljava/text/SimpleDateFormat;", "pending", "", "history", "", "historyIdx", "", "listener", "Lkotlin/Function1;", "", "onAttachedToWindow", "onDetachedFromWindow", "schedule", "reload", "Adapter", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OutputPanel extends LinearLayout {
    private final Adapter adapter;
    private final ArrayList<OutputLog.Entry> entries;
    private final SimpleDateFormat fmt;
    private final ArrayList<String> history;
    private int historyIdx;
    private final RecyclerView list;
    private final Function1<OutputLog.Entry, Unit> listener;
    private boolean pending;
    private final Studio studio;

    /* compiled from: OutputPanel.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/OutputPanel$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/OutputPanel;)V", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "h", "position", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private final class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* compiled from: OutputPanel.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[OutputLog.Level.values().length];
                try {
                    iArr[OutputLog.Level.PRINT.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[OutputLog.Level.INFO.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[OutputLog.Level.WARN.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[OutputLog.Level.ERROR.ordinal()] = 4;
                } catch (NoSuchFieldError e4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public Adapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return OutputPanel.access$getEntries$p(OutputPanel.this).size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder h, int position) {
            int text;
            Intrinsics.checkNotNullParameter(h, "h");
            Object obj = OutputPanel.access$getEntries$p(OutputPanel.this).get(position);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            OutputLog.Entry entry = (OutputLog.Entry) obj;
            View view = h.itemView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) view;
            textView.setText(OutputPanel.access$getFmt$p(OutputPanel.this).format(new Date(entry.getTime())) + "  " + entry.getText());
            switch (WhenMappings.$EnumSwitchMapping$0[entry.getLevel().ordinal()]) {
                case 1:
                    text = Ui.INSTANCE.getTEXT();
                    break;
                case 2:
                    text = Ui.INFO;
                    break;
                case 3:
                    text = Ui.WARN;
                    break;
                case 4:
                    text = Ui.ERROR;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            textView.setTextColor(text);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Ui ui = Ui.INSTANCE;
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            TextView text$default = Ui.text$default(ui, context, "", 12.0f, 0, false, 24, null);
            text$default.setSingleLine(false);
            text$default.setTypeface(Typeface.MONOSPACE);
            Ui ui2 = Ui.INSTANCE;
            Context context2 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            int dp = ui2.dp(context2, 8.0f);
            Ui ui3 = Ui.INSTANCE;
            Context context3 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            int dp2 = ui3.dp(context3, 1.0f);
            Ui ui4 = Ui.INSTANCE;
            Context context4 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
            int dp3 = ui4.dp(context4, 8.0f);
            Ui ui5 = Ui.INSTANCE;
            Context context5 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
            text$default.setPadding(dp, dp2, dp3, ui5.dp(context5, 1.0f));
            text$default.setTextIsSelectable(true);
            text$default.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new OutputPanel$Adapter$onCreateViewHolder$1(text$default);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutputPanel(Context ctx, Studio studio) {
        super(ctx);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(studio, "studio");
        this.studio = studio;
        this.entries = new ArrayList<>();
        this.list = new RecyclerView(ctx);
        this.adapter = new Adapter();
        this.fmt = new SimpleDateFormat("HH:mm:ss.SSS", Locale.US);
        this.history = new ArrayList<>();
        this.listener = new OutputPanel$$ExternalSyntheticLambda1(this);
        setOrientation(1);
        setBackgroundColor(Ui.INSTANCE.getPANEL());
        LinearLayout header = Ui.INSTANCE.header(ctx, "Output", Icons.general$default(Icons.INSTANCE, ctx, "Output", null, 4, null));
        header.addView(Ui.iconButton$default(Ui.INSTANCE, ctx, Icons.INSTANCE.general(ctx, "Cleanup", "Clr"), 0.0f, new OutputPanel$$ExternalSyntheticLambda2(), 4, null));
        addView(header, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        RecyclerView recyclerView = this.list;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ctx);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        this.list.setAdapter(this.adapter);
        this.list.setItemAnimator(null);
        addView(this.list, Ui.INSTANCE.lp(-1, 0, 1.0f));
        LinearLayout linearLayout = new LinearLayout(ctx);
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(Ui.INSTANCE.getHEADER());
        EditText input$default = Ui.input$default(Ui.INSTANCE, ctx, "", "Run a command (Lua)", false, false, 24, null);
        input$default.setTypeface(Typeface.MONOSPACE);
        input$default.setTextSize(12.0f);
        input$default.setImeOptions(2);
        input$default.setOnEditorActionListener(new OutputPanel$$ExternalSyntheticLambda3(input$default, this));
        linearLayout.addView(input$default, Ui.INSTANCE.lp(0, -2, 1.0f));
        linearLayout.addView(Ui.iconButton$default(Ui.INSTANCE, ctx, Icons.INSTANCE.general(ctx, "Back", "Prev"), 0.0f, new OutputPanel$$ExternalSyntheticLambda4(this, input$default), 4, null));
        linearLayout.addView(Ui.iconButton$default(Ui.INSTANCE, ctx, Icons.INSTANCE.general(ctx, "RunScript", "Run"), 0.0f, new OutputPanel$$ExternalSyntheticLambda5(input$default, this), 4, null));
        addView(linearLayout, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        reload();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$1(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        OutputLog.INSTANCE.clear();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean _init_$lambda$4(EditText editText, OutputPanel outputPanel, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 2) {
            if (!(keyEvent != null && keyEvent.getKeyCode() == 66) || keyEvent.getAction() != 0) {
                return false;
            }
        }
        _init_$run(editText, outputPanel);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$5(OutputPanel outputPanel, EditText editText, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!outputPanel.history.isEmpty()) {
            outputPanel.historyIdx = RangesKt.coerceAtLeast(outputPanel.historyIdx - 1, 0);
            editText.setText(outputPanel.history.get(outputPanel.historyIdx));
            editText.setSelection(editText.getText().length());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$6(EditText editText, OutputPanel outputPanel, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        _init_$run(editText, outputPanel);
        return Unit.INSTANCE;
    }

    private static final void _init_$run(EditText editText, OutputPanel outputPanel) {
        String obj = editText.getText().toString();
        if (StringsKt.isBlank(obj)) {
            return;
        }
        outputPanel.history.add(obj);
        outputPanel.historyIdx = outputPanel.history.size();
        editText.setText("");
        outputPanel.studio.runCommand(obj);
    }

    public static final /* synthetic */ ArrayList access$getEntries$p(OutputPanel outputPanel) {
        return outputPanel.entries;
    }

    public static final /* synthetic */ SimpleDateFormat access$getFmt$p(OutputPanel outputPanel) {
        return outputPanel.fmt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit listener$lambda$0(OutputPanel outputPanel, OutputLog.Entry entry) {
        outputPanel.schedule();
        return Unit.INSTANCE;
    }

    private final void reload() {
        this.entries.clear();
        this.entries.addAll(OutputLog.INSTANCE.snapshot());
        this.adapter.notifyDataSetChanged();
        if (this.entries.isEmpty()) {
            return;
        }
        this.list.scrollToPosition(this.entries.size() - 1);
    }

    private final void schedule() {
        if (this.pending) {
            return;
        }
        this.pending = true;
        postDelayed(new OutputPanel$$ExternalSyntheticLambda0(this), 100L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void schedule$lambda$7(OutputPanel outputPanel) {
        outputPanel.pending = false;
        outputPanel.reload();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        OutputLog.INSTANCE.getListeners().add(this.listener);
        reload();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OutputLog.INSTANCE.getListeners().remove(this.listener);
    }
}
