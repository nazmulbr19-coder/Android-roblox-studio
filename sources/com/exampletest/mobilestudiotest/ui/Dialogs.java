package com.exampletest.mobilestudiotest.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.exampletest.mobilestudiotest.model.BrickColorV;
import com.exampletest.mobilestudiotest.model.BrickColors;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.ClassDb;
import com.exampletest.mobilestudiotest.model.Color3;
import com.exampletest.mobilestudiotest.model.DataTypesKt;
import com.exampletest.mobilestudiotest.model.EnumValue;
import com.exampletest.mobilestudiotest.model.NumberRange;
import com.exampletest.mobilestudiotest.model.UDim;
import com.exampletest.mobilestudiotest.model.UDim2;
import com.exampletest.mobilestudiotest.model.Vector2;
import com.exampletest.mobilestudiotest.model.Vector3;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.text.StringsKt;

/* compiled from: Dialogs.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\rJ,\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u0014H\u0002JH\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\t0\rJ4\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!2\u0014\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\t0\rJ4\u0010\"\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0&J2\u0010'\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\rJ\u000e\u0010(\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006)"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Dialogs;", "", "<init>", "()V", "theme", "Landroid/app/AlertDialog$Builder;", "ctx", "Landroid/content/Context;", "pickClass", "", "title", "", "onPick", "Lkotlin/Function1;", "numField", "Lkotlin/Pair;", "Landroid/widget/LinearLayout;", "Landroid/widget/EditText;", "label", "v", "", "f", "e", "d", "editValue", "name", "value", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "", "enumType", "onSet", "colorPicker", "initial", "Lcom/exampletest/mobilestudiotest/model/Color3;", "confirm", NotificationCompat.CATEGORY_MESSAGE, "ok", "onOk", "Lkotlin/Function0;", "prompt", "themed", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Dialogs {
    public static final Dialogs INSTANCE = new Dialogs();

    private Dialogs() {
    }

    public static final /* synthetic */ void access$colorPicker$refresh(View view, EditText editText, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3, Context context, boolean z) {
        colorPicker$refresh(view, editText, intRef, intRef2, intRef3, context, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void colorPicker$lambda$41$lambda$40(Ref.IntRef intRef, Color3 color3, Ref.IntRef intRef2, Ref.IntRef intRef3, ArrayList arrayList, View view, EditText editText, Context context, View view2) {
        intRef.element = (int) ((color3.getR() * 255.0f) + 0.5f);
        intRef2.element = (int) ((color3.getG() * 255.0f) + 0.5f);
        intRef3.element = (int) ((color3.getB() * 255.0f) + 0.5f);
        ((SeekBar) arrayList.get(0)).setProgress(intRef.element);
        ((SeekBar) arrayList.get(1)).setProgress(intRef2.element);
        ((SeekBar) arrayList.get(2)).setProgress(intRef3.element);
        colorPicker$refresh$default(view, editText, intRef, intRef2, intRef3, context, false, 64, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void colorPicker$lambda$44(Function1 function1, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3, DialogInterface dialogInterface, int i) {
        function1.invoke(Color3.INSTANCE.fromRGB(intRef.element, intRef2.element, intRef3.element));
    }

    private static final void colorPicker$refresh(View view, EditText editText, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3, Context context, boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color3.INSTANCE.fromRGB(intRef.element, intRef2.element, intRef3.element).toArgb());
        gradientDrawable.setCornerRadius(Ui.INSTANCE.dp(context, 4.0f));
        view.setBackground(gradientDrawable);
        if (z) {
            editText.setText(Color3.INSTANCE.fromRGB(intRef.element, intRef2.element, intRef3.element).toHex());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void colorPicker$refresh$default(View view, EditText editText, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3, Context context, boolean z, int i, Object obj) {
        if ((i & 64) != 0) {
            z = true;
        }
        colorPicker$refresh(view, editText, intRef, intRef2, intRef3, context, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void confirm$lambda$45(Function0 function0, DialogInterface dialogInterface, int i) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Vector3 editValue$lambda$10(List list) {
        return new Vector3(f$default(INSTANCE, (EditText) list.get(0), 0.0f, 2, null), f$default(INSTANCE, (EditText) list.get(1), 0.0f, 2, null), f$default(INSTANCE, (EditText) list.get(2), 0.0f, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Vector2 editValue$lambda$13(List list) {
        return new Vector2(f$default(INSTANCE, (EditText) list.get(0), 0.0f, 2, null), f$default(INSTANCE, (EditText) list.get(1), 0.0f, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final UDim2 editValue$lambda$16(List list) {
        return new UDim2(f$default(INSTANCE, (EditText) list.get(0), 0.0f, 2, null), (int) f$default(INSTANCE, (EditText) list.get(1), 0.0f, 2, null), f$default(INSTANCE, (EditText) list.get(2), 0.0f, 2, null), (int) f$default(INSTANCE, (EditText) list.get(3), 0.0f, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final UDim editValue$lambda$19(List list) {
        return new UDim(f$default(INSTANCE, (EditText) list.get(0), 0.0f, 2, null), (int) f$default(INSTANCE, (EditText) list.get(1), 0.0f, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CFrame editValue$lambda$24(List list, List list2) {
        return CFrame.INSTANCE.fromOrientation(f$default(INSTANCE, (EditText) list.get(0), 0.0f, 2, null) * 0.017453292f, f$default(INSTANCE, (EditText) list.get(1), 0.0f, 2, null) * 0.017453292f, f$default(INSTANCE, (EditText) list.get(2), 0.0f, 2, null) * 0.017453292f).withPosition(new Vector3(f$default(INSTANCE, (EditText) list2.get(0), 0.0f, 2, null), f$default(INSTANCE, (EditText) list2.get(1), 0.0f, 2, null), f$default(INSTANCE, (EditText) list2.get(2), 0.0f, 2, null)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final NumberRange editValue$lambda$27(List list) {
        return new NumberRange(f$default(INSTANCE, (EditText) list.get(0), 0.0f, 2, null), f$default(INSTANCE, (EditText) list.get(1), 0.0f, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final EnumValue editValue$lambda$28(EditText editText) {
        return new EnumValue((int) f$default(INSTANCE, editText, 0.0f, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object editValue$lambda$29(EditText editText, Object obj) {
        Double doubleOrNull = StringsKt.toDoubleOrNull(StringsKt.trim((CharSequence) editText.getText().toString()).toString());
        double doubleValue = doubleOrNull != null ? doubleOrNull.doubleValue() : 0.0d;
        return obj instanceof Float ? Float.valueOf((float) doubleValue) : obj instanceof Double ? Double.valueOf(doubleValue) : obj instanceof Integer ? Integer.valueOf((int) doubleValue) : Long.valueOf((long) doubleValue);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String editValue$lambda$30(EditText editText) {
        return editText.getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void editValue$lambda$32(Function1 function1, Function0 function0, DialogInterface dialogInterface, int i) {
        function1.invoke(function0.invoke());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void editValue$lambda$5(Function1 function1, List list, DialogInterface dialogInterface, int i) {
        Object value = ((Map.Entry) list.get(i)).getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-value>(...)");
        function1.invoke(new EnumValue(((Number) value).intValue()));
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit editValue$lambda$6(Function1 function1, Object obj) {
        BrickColors brickColors = BrickColors.INSTANCE;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.exampletest.mobilestudiotest.model.Color3");
        function1.invoke(new BrickColorV(brickColors.closest((Color3) obj)));
        return Unit.INSTANCE;
    }

    private final float f(EditText e, float d) {
        Float floatOrNull = StringsKt.toFloatOrNull(StringsKt.trim((CharSequence) e.getText().toString()).toString());
        return floatOrNull != null ? floatOrNull.floatValue() : d;
    }

    static /* synthetic */ float f$default(Dialogs dialogs, EditText editText, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return dialogs.f(editText, f);
    }

    private final Pair<LinearLayout, EditText> numField(Context ctx, String label, float v) {
        LinearLayout linearLayout = new LinearLayout(ctx);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.addView(Ui.text$default(Ui.INSTANCE, ctx, label, 13.0f, Ui.INSTANCE.getDIM(), false, 16, null), Ui.lp$default(Ui.INSTANCE, Ui.INSTANCE.dp(ctx, 28.0f), -2, 0.0f, 4, null));
        EditText input$default = Ui.input$default(Ui.INSTANCE, ctx, DataTypesKt.fmtNum(v), null, true, false, 20, null);
        linearLayout.addView(input$default, Ui.INSTANCE.lp(0, -2, 1.0f));
        return TuplesKt.to(linearLayout, input$default);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void pickClass$lambda$1(Function1 function1, ArrayList arrayList, AlertDialog alertDialog, AdapterView adapterView, View view, int i, long j) {
        Object obj = arrayList.get(i);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        function1.invoke(obj);
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void prompt$lambda$47(Function1 function1, EditText editText, DialogInterface dialogInterface, int i) {
        function1.invoke(editText.getText().toString());
    }

    private final AlertDialog.Builder theme(Context ctx) {
        return new AlertDialog.Builder(ctx, Ui.INSTANCE.getDialogTheme());
    }

    public final void colorPicker(Context ctx, String title, Color3 initial, Function1<Object, Unit> onSet) {
        Context ctx2 = ctx;
        Intrinsics.checkNotNullParameter(ctx2, "ctx");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(onSet, "onSet");
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = (int) (initial.getR() * 255.0f);
        Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = (int) (initial.getG() * 255.0f);
        Ref.IntRef intRef3 = new Ref.IntRef();
        intRef3.element = (int) (initial.getB() * 255.0f);
        LinearLayout linearLayout = new LinearLayout(ctx2);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(Ui.INSTANCE.dp(ctx2, 16.0f), Ui.INSTANCE.dp(ctx2, 8.0f), Ui.INSTANCE.dp(ctx2, 16.0f), 0);
        int i = 0;
        int i2 = 1;
        View view = new View(ctx2);
        EditText input$default = Ui.input$default(Ui.INSTANCE, ctx2, initial.toHex(), "Hex", false, false, 24, null);
        linearLayout.addView(view, Ui.lp$default(Ui.INSTANCE, -1, Ui.INSTANCE.dp(ctx2, 40.0f), 0.0f, 4, null));
        ArrayList arrayList = new ArrayList();
        char c = 2;
        int i3 = 0;
        for (String str : CollectionsKt.listOf((Object[]) new String[]{"R", "G", "B"})) {
            int i4 = i3;
            LinearLayout linearLayout2 = new LinearLayout(ctx2);
            linearLayout2.setOrientation(i);
            linearLayout2.setGravity(16);
            ArrayList arrayList2 = arrayList;
            View view2 = view;
            linearLayout2.addView(Ui.text$default(Ui.INSTANCE, ctx2, str, 13.0f, Ui.INSTANCE.getDIM(), false, 16, null), Ui.lp$default(Ui.INSTANCE, Ui.INSTANCE.dp(ctx2, 20.0f), -2, 0.0f, 4, null));
            SeekBar seekBar = new SeekBar(ctx2);
            seekBar.setMax(255);
            seekBar.setProgress(((Number) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(intRef.element), Integer.valueOf(intRef2.element), Integer.valueOf(intRef3.element)}).get(i4)).intValue());
            Ref.IntRef intRef4 = intRef;
            Ref.IntRef intRef5 = intRef2;
            Ref.IntRef intRef6 = intRef3;
            seekBar.setOnSeekBarChangeListener(new Dialogs$colorPicker$1(i4, intRef4, intRef5, intRef6, view2, input$default, ctx2));
            arrayList2.add(seekBar);
            linearLayout2.addView(seekBar, Ui.INSTANCE.lp(0, -2, 1.0f));
            linearLayout.addView(linearLayout2);
            intRef = intRef4;
            intRef2 = intRef5;
            intRef3 = intRef6;
            view = view2;
            arrayList = arrayList2;
            c = 2;
            i3++;
            i = 0;
            ctx2 = ctx;
        }
        ArrayList arrayList3 = arrayList;
        Ref.IntRef intRef7 = intRef2;
        Ref.IntRef intRef8 = intRef3;
        linearLayout.addView(input$default);
        Dialogs$colorPicker$2 dialogs$colorPicker$2 = new Dialogs$colorPicker$2(intRef, intRef7, intRef8, arrayList3, view, input$default, ctx);
        Ref.IntRef intRef9 = intRef7;
        Ref.IntRef intRef10 = intRef8;
        EditText editText = input$default;
        editText.addTextChangedListener(dialogs$colorPicker$2);
        Context context = ctx;
        TextView text$default = Ui.text$default(Ui.INSTANCE, context, "BrickColor palette", 12.0f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default.setPadding(0, Ui.INSTANCE.dp(context, 8.0f), 0, Ui.INSTANCE.dp(context, 4.0f));
        linearLayout.addView(text$default);
        GridLayout gridLayout = new GridLayout(context);
        gridLayout.setColumnCount(11);
        Iterator<Integer> it = BrickColors.INSTANCE.getAll().iterator();
        while (it.hasNext()) {
            Color3 color = BrickColors.INSTANCE.color(it.next().intValue());
            View view3 = new View(context);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(color.toArgb());
            Ref.IntRef intRef11 = intRef9;
            gradientDrawable.setStroke(i2, ViewCompat.MEASURED_STATE_MASK);
            view3.setBackground(gradientDrawable);
            Ref.IntRef intRef12 = intRef;
            Context context2 = context;
            EditText editText2 = editText;
            View view4 = view;
            Ref.IntRef intRef13 = intRef10;
            context = context2;
            view3.setOnClickListener(new Dialogs$$ExternalSyntheticLambda2(intRef12, color, intRef11, intRef13, arrayList3, view4, editText2, context2));
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
            layoutParams.width = Ui.INSTANCE.dp(context, 22.0f);
            layoutParams.height = Ui.INSTANCE.dp(context, 22.0f);
            layoutParams.setMargins(2, 2, 2, 2);
            Unit unit = Unit.INSTANCE;
            gridLayout.addView(view3, layoutParams);
            intRef = intRef12;
            intRef10 = intRef13;
            view = view4;
            editText = editText2;
            i2 = 1;
            intRef9 = intRef11;
        }
        Ref.IntRef intRef14 = intRef;
        Ref.IntRef intRef15 = intRef9;
        Ref.IntRef intRef16 = intRef10;
        linearLayout.addView(gridLayout);
        Context context3 = context;
        colorPicker$refresh$default(view, editText, intRef14, intRef15, intRef16, context3, false, 64, null);
        AlertDialog.Builder title2 = theme(ctx).setTitle(title);
        ScrollView scrollView = new ScrollView(context3);
        scrollView.addView(linearLayout);
        title2.setView(scrollView).setPositiveButton("Set", new Dialogs$$ExternalSyntheticLambda3(onSet, intRef14, intRef15, intRef16)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    public final void confirm(Context ctx, String title, String msg, String ok, Function0<Unit> onOk) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(ok, "ok");
        Intrinsics.checkNotNullParameter(onOk, "onOk");
        theme(ctx).setTitle(title).setMessage(msg).setPositiveButton(ok, new Dialogs$$ExternalSyntheticLambda16(onOk)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x002a, code lost:
    
        if (r33 == 18) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:132:0x070b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0716  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x071d  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x072d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x071a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void editValue(android.content.Context r30, java.lang.String r31, java.lang.Object r32, int r33, java.lang.String r34, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r35) {
        /*
            Method dump skipped, instructions count: 1981
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.Dialogs.editValue(android.content.Context, java.lang.String, java.lang.Object, int, java.lang.String, kotlin.jvm.functions.Function1):void");
    }

    public final void pickClass(Context ctx, String title, Function1<? super String, Unit> onPick) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(onPick, "onPick");
        LinearLayout linearLayout = new LinearLayout(ctx);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(Ui.INSTANCE.dp(ctx, 12.0f), Ui.INSTANCE.dp(ctx, 8.0f), Ui.INSTANCE.dp(ctx, 12.0f), 0);
        EditText input$default = Ui.input$default(Ui.INSTANCE, ctx, "", "Search objects", false, false, 24, null);
        linearLayout.addView(input$default);
        List<String> insertable = ClassDb.INSTANCE.getInsertable();
        ArrayList arrayList = new ArrayList(insertable);
        ListView listView = new ListView(ctx);
        Dialogs$pickClass$adapter$1 dialogs$pickClass$adapter$1 = new Dialogs$pickClass$adapter$1(ctx, arrayList);
        listView.setAdapter((ListAdapter) dialogs$pickClass$adapter$1);
        linearLayout.addView(listView, Ui.lp$default(Ui.INSTANCE, -1, Ui.INSTANCE.dp(ctx, 380.0f), 0.0f, 4, null));
        AlertDialog create = theme(ctx).setTitle(title).setView(linearLayout).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create();
        input$default.addTextChangedListener(new Dialogs$pickClass$1(arrayList, insertable, dialogs$pickClass$adapter$1));
        listView.setOnItemClickListener(new Dialogs$$ExternalSyntheticLambda1(onPick, arrayList, create));
        create.show();
    }

    public final void prompt(Context ctx, String title, String initial, Function1<? super String, Unit> onOk) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(onOk, "onOk");
        EditText input$default = Ui.input$default(Ui.INSTANCE, ctx, initial, null, false, false, 28, null);
        LinearLayout linearLayout = new LinearLayout(ctx);
        linearLayout.setPadding(Ui.INSTANCE.dp(ctx, 16.0f), Ui.INSTANCE.dp(ctx, 8.0f), Ui.INSTANCE.dp(ctx, 16.0f), 0);
        linearLayout.addView(input$default, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        theme(ctx).setTitle(title).setView(linearLayout).setPositiveButton("OK", new Dialogs$$ExternalSyntheticLambda0(onOk, input$default)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    public final AlertDialog.Builder themed(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return theme(ctx);
    }
}
