package com.exampletest.mobilestudiotest.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.exampletest.mobilestudiotest.core.Settings;
import com.exampletest.mobilestudiotest.core.Theme;
import com.exampletest.mobilestudiotest.model.Color3;
import com.exampletest.mobilestudiotest.model.DataTypesKt;
import com.exampletest.mobilestudiotest.net.WebPermissions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: SettingsDialog.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J \u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013H\u0002J.\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0002J*\u0010 \u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u0013H\u0002JF\u0010#\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u00132\u0006\u0010$\u001a\u00020\u001e2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\n0&H\u0002JV\u0010'\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u00062\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0&H\u0002JV\u0010+\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00132\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\b\u0010-\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010.\u001a\u00020/2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\n0&H\u0002J&\u00100\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000eJ\u001c\u00103\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0\u0010J\u0018\u0010!\u001a\u0002042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00105\u001a\u00020\u0013H\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u00066"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/SettingsDialog;", "", "<init>", "()V", "flySpeeds", "", "", "getFlySpeeds", "()Ljava/util/List;", "show", "", "ctx", "Landroid/content/Context;", "actions", "Lcom/exampletest/mobilestudiotest/ui/MainActions;", "onImportIcons", "Lkotlin/Function0;", "onRemoveIcons", "uniqueName", "", "base", "section", "box", "Landroid/widget/LinearLayout;", "title", "themeChip", "Landroid/view/View;", "t", "Lcom/exampletest/mobilestudiotest/core/Theme;", "selected", "", "onClick", "row", "label", "hint", "toggle", "value", "onSet", "Lkotlin/Function1;", "slider", "min", "max", "step", "choice", "items", "customLabel", "current", "", "editTheme", "start", "isNew", "pickFlySpeed", "Landroid/widget/TextView;", "s", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsDialog {
    public static final SettingsDialog INSTANCE = new SettingsDialog();
    private static final List<Float> flySpeeds = CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(0.1f), Float.valueOf(0.25f), Float.valueOf(0.5f), Float.valueOf(1.0f), Float.valueOf(2.0f), Float.valueOf(4.0f), Float.valueOf(8.0f), Float.valueOf(16.0f), Float.valueOf(32.0f), Float.valueOf(64.0f)});

    private SettingsDialog() {
    }

    private final void choice(Context ctx, LinearLayout box, String label, List<String> items, String customLabel, int current, Function1<? super Integer, Unit> onSet) {
        List<String> list;
        String str;
        LinearLayout row = row(ctx, box, label, null);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = current;
        Ui ui = Ui.INSTANCE;
        if (customLabel == null) {
            list = items;
            str = (String) CollectionsKt.getOrNull(list, intRef.element);
            if (str == null && (str = (String) CollectionsKt.firstOrNull((List) list)) == null) {
                str = "";
            }
        } else {
            list = items;
            str = customLabel;
        }
        TextView button$default = Ui.button$default(ui, ctx, str, 0, new SettingsDialog$$ExternalSyntheticLambda35(), 4, null);
        button$default.setOnClickListener(new SettingsDialog$$ExternalSyntheticLambda36(ctx, label, list, intRef, button$default, onSet));
        row.addView(button$default);
    }

    static /* synthetic */ void choice$default(SettingsDialog settingsDialog, Context context, LinearLayout linearLayout, String str, List list, String str2, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            i = -1;
        }
        settingsDialog.choice(context, linearLayout, str, list, str2, i, function1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit choice$lambda$57(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void choice$lambda$59(Context context, String str, List list, Ref.IntRef intRef, TextView textView, Function1 function1, View view) {
        Dialogs.INSTANCE.themed(context).setTitle(str).setSingleChoiceItems((CharSequence[]) list.toArray(new String[0]), intRef.element, new SettingsDialog$$ExternalSyntheticLambda6(intRef, textView, list, function1)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void choice$lambda$59$lambda$58(Ref.IntRef intRef, TextView textView, List list, Function1 function1, DialogInterface dialogInterface, int i) {
        intRef.element = i;
        textView.setText((CharSequence) list.get(i));
        function1.invoke(Integer.valueOf(i));
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.exampletest.mobilestudiotest.core.Theme, T] */
    public static final void editTheme$lambda$63$lambda$62(Ref.ObjectRef objectRef, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        objectRef.element = Theme.copy$default((Theme) objectRef.element, null, z, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8388605, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.exampletest.mobilestudiotest.core.Theme, T] */
    public static final Unit editTheme$lambda$73(Ref.ObjectRef objectRef, Theme theme, EditText editText, LinearLayout linearLayout, Context context, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String obj = editText.getText().toString();
        if (StringsKt.isBlank(obj)) {
            obj = ((Theme) objectRef.element).getName();
        }
        objectRef.element = Theme.copy$default(theme, obj, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8388606, null);
        editTheme$refresh(linearLayout, objectRef, context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void editTheme$lambda$81(EditText editText, Context context, Ref.ObjectRef objectRef, MainActions mainActions, String str, DialogInterface dialogInterface, int i) {
        boolean z;
        String obj = StringsKt.trim((CharSequence) editText.getText().toString()).toString();
        if (StringsKt.isBlank(obj)) {
            obj = TypedValues.Custom.NAME;
        }
        String str2 = obj;
        List<Theme> builtIn = Theme.INSTANCE.getBuiltIn();
        if (!(builtIn instanceof Collection) || !builtIn.isEmpty()) {
            Iterator<T> it = builtIn.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(((Theme) it.next()).getName(), str2)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
        } else {
            z = false;
        }
        if (z) {
            Toast.makeText(context, "\"" + str2 + "\" is a built-in theme name; pick another", 0).show();
            return;
        }
        List<Theme> customThemes = Settings.INSTANCE.customThemes();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : customThemes) {
            Theme theme = (Theme) obj2;
            if ((Intrinsics.areEqual(theme.getName(), str) || Intrinsics.areEqual(theme.getName(), str2)) ? false : true) {
                arrayList.add(obj2);
            }
        }
        List<Theme> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        mutableList.add(Theme.copy$default((Theme) objectRef.element, str2, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8388606, null));
        Settings.INSTANCE.saveCustomThemes(mutableList);
        Settings.INSTANCE.setThemeName(str2);
        mainActions.applyThemeChange();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void editTheme$lambda$83(String str, MainActions mainActions, DialogInterface dialogInterface, int i) {
        Settings settings = Settings.INSTANCE;
        List<Theme> customThemes = Settings.INSTANCE.customThemes();
        ArrayList arrayList = new ArrayList();
        for (Object obj : customThemes) {
            if (!Intrinsics.areEqual(((Theme) obj).getName(), str)) {
                arrayList.add(obj);
            }
        }
        settings.saveCustomThemes(arrayList);
        if (Intrinsics.areEqual(Settings.INSTANCE.getThemeName(), str)) {
            Settings.INSTANCE.setThemeName("Dark");
        }
        mainActions.applyThemeChange();
    }

    private static final void editTheme$refresh(LinearLayout linearLayout, Ref.ObjectRef<Theme> objectRef, Context context) {
        Context context2 = context;
        linearLayout.removeAllViews();
        Ref.ObjectRef<Theme> objectRef2 = objectRef;
        for (Pair<String, Integer> pair : objectRef2.element.colors()) {
            String component1 = pair.component1();
            int intValue = pair.component2().intValue();
            LinearLayout linearLayout2 = new LinearLayout(context2);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(16);
            linearLayout2.setPadding(0, Ui.INSTANCE.dp(context2, 4.0f), 0, Ui.INSTANCE.dp(context2, 4.0f));
            linearLayout2.setBackground(Ui.rippleBg$default(Ui.INSTANCE, context2, 0, 0.0f, 4, null));
            View view = new View(context2);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(intValue);
            gradientDrawable.setStroke(Ui.INSTANCE.dp(context2, 1.0f), -7829368);
            gradientDrawable.setCornerRadius(Ui.INSTANCE.dp(context2, 3.0f));
            view.setBackground(gradientDrawable);
            LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, Ui.INSTANCE.dp(context2, 26.0f), Ui.INSTANCE.dp(context2, 20.0f), 0.0f, 4, null);
            lp$default.rightMargin = Ui.INSTANCE.dp(context2, 10.0f);
            Unit unit = Unit.INSTANCE;
            linearLayout2.addView(view, lp$default);
            linearLayout2.addView(Ui.text$default(Ui.INSTANCE, context2, component1, 13.0f, 0, false, 24, null), Ui.INSTANCE.lp(0, -2, 1.0f));
            Ui ui = Ui.INSTANCE;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & intValue)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            context2 = context;
            linearLayout2.addView(Ui.text$default(ui, context2, format, 12.0f, Ui.INSTANCE.getDIM(), false, 16, null));
            linearLayout2.setOnClickListener(new SettingsDialog$$ExternalSyntheticLambda37(context2, component1, intValue, objectRef2, linearLayout));
            linearLayout.addView(linearLayout2);
            objectRef2 = objectRef;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void editTheme$refresh$lambda$71(Context context, String str, int i, Ref.ObjectRef objectRef, LinearLayout linearLayout, View view) {
        Dialogs.INSTANCE.colorPicker(context, str, new Color3(((i >> 16) & 255) / 255.0f, ((i >> 8) & 255) / 255.0f, (i & 255) / 255.0f), new SettingsDialog$$ExternalSyntheticLambda7(objectRef, str, linearLayout, context));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.exampletest.mobilestudiotest.core.Theme, T] */
    public static final Unit editTheme$refresh$lambda$71$lambda$70(Ref.ObjectRef objectRef, String str, LinearLayout linearLayout, Context context, Object obj) {
        Theme theme = (Theme) objectRef.element;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.exampletest.mobilestudiotest.model.Color3");
        objectRef.element = theme.withColor(str, ((Color3) obj).toArgb() | ViewCompat.MEASURED_STATE_MASK);
        editTheme$refresh(linearLayout, objectRef, context);
        return Unit.INSTANCE;
    }

    private final TextView label(Context ctx, String s) {
        return Ui.text$default(Ui.INSTANCE, ctx, s, 13.0f, 0, false, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void pickFlySpeed$lambda$88(Function0 function0, Context context, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        SettingsDialog settingsDialog = INSTANCE;
        if (i >= flySpeeds.size()) {
            Dialogs.INSTANCE.prompt(context, "Fly speed multiplier (0.05 – 200)", DataTypesKt.fmtNum(Settings.INSTANCE.getFlySpeed()), new SettingsDialog$$ExternalSyntheticLambda0(function0));
            return;
        }
        Settings settings = Settings.INSTANCE;
        SettingsDialog settingsDialog2 = INSTANCE;
        settings.setFlySpeed(flySpeeds.get(i).floatValue());
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit pickFlySpeed$lambda$88$lambda$87(Function0 function0, String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        Float floatOrNull = StringsKt.toFloatOrNull(StringsKt.trim((CharSequence) s).toString());
        if (floatOrNull != null) {
            Settings.INSTANCE.setFlySpeed(RangesKt.coerceIn(floatOrNull.floatValue(), 0.05f, 200.0f));
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    private final LinearLayout row(Context ctx, LinearLayout box, String label, String hint) {
        LinearLayout linearLayout = new LinearLayout(ctx);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, Ui.INSTANCE.dp(ctx, 5.0f), 0, Ui.INSTANCE.dp(ctx, 5.0f));
        LinearLayout linearLayout2 = new LinearLayout(ctx);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        TextView text$default = Ui.text$default(Ui.INSTANCE, ctx, label, 14.0f, Ui.INSTANCE.getTEXT(), false, 16, null);
        text$default.setSingleLine(false);
        linearLayout2.addView(text$default, Ui.INSTANCE.lp(0, -2, 1.0f));
        linearLayout.addView(linearLayout2);
        if (hint != null) {
            TextView text$default2 = Ui.text$default(Ui.INSTANCE, ctx, hint, 11.0f, Ui.INSTANCE.getDIM(), false, 16, null);
            text$default2.setSingleLine(false);
            linearLayout.addView(text$default2);
        }
        box.addView(linearLayout);
        return linearLayout2;
    }

    private final void section(Context ctx, LinearLayout box, String title) {
        Ui ui = Ui.INSTANCE;
        String upperCase = title.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        TextView text = ui.text(ctx, upperCase, 11.0f, Ui.INSTANCE.getLIGHT() ? Ui.INSTANCE.getACCENT() : -10834689, true);
        text.setPadding(0, Ui.INSTANCE.dp(ctx, 14.0f), 0, Ui.INSTANCE.dp(ctx, 4.0f));
        box.addView(text);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$11(int i) {
        Settings settings = Settings.INSTANCE;
        SettingsDialog settingsDialog = INSTANCE;
        settings.setFlySpeed(flySpeeds.get(i).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$12(float f) {
        Settings.INSTANCE.setCameraSensitivity(f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$13(boolean z) {
        Settings.INSTANCE.setCameraSmoothing(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$14(float f) {
        Settings.INSTANCE.setEditorFontSize(f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$15(boolean z) {
        Settings.INSTANCE.setAutocomplete(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$16(boolean z) {
        Settings.INSTANCE.setAutoIndent(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$17(boolean z) {
        Settings.INSTANCE.setAutoCloseBrackets(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$18(boolean z) {
        Settings.INSTANCE.setShowFps(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$19(int i) {
        Settings.INSTANCE.setModernMaterials(i == 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$20(List list, int i) {
        Settings.INSTANCE.setRenderDistance((String) list.get(i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$21(boolean z) {
        Settings.INSTANCE.setGuiSmartGuides(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$23(List list, int i) {
        Settings.INSTANCE.setGuiGrid(((Number) list.get(i)).intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$25(List list, int i) {
        Settings.INSTANCE.setPluginUiScale(((Number) list.get(i)).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$26(boolean z) {
        Settings.INSTANCE.setHideWindowsInPlaytest(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$27(boolean z) {
        Settings.INSTANCE.setShiftLockSwitch(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$28(int i) {
        Settings.INSTANCE.setCameraMode(i == 0 ? "Classic" : "Follow");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$29(int i) {
        Settings.INSTANCE.setMovementMode(i == 1 ? "Thumbstick" : "Dynamic Thumbstick");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit show$lambda$3(Theme theme, Ref.BooleanRef booleanRef, Ref.ObjectRef objectRef) {
        Settings.INSTANCE.setThemeName(theme.getName());
        booleanRef.element = true;
        AlertDialog alertDialog = (AlertDialog) objectRef.element;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit show$lambda$30(float f) {
        Settings.INSTANCE.setPlayCameraSensitivity(f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence show$lambda$33(Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "<destruct>");
        return (((Boolean) entry.getValue()).booleanValue() ? "Allowed: " : "Blocked: ") + ((String) entry.getKey());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit show$lambda$35(Context context, Ref.ObjectRef objectRef, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        WebPermissions.INSTANCE.forgetAll(context);
        AlertDialog alertDialog = (AlertDialog) objectRef.element;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit show$lambda$39(Ref.ObjectRef objectRef, Function0 function0, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AlertDialog alertDialog = (AlertDialog) objectRef.element;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit show$lambda$41(Ref.ObjectRef objectRef, Function0 function0, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AlertDialog alertDialog = (AlertDialog) objectRef.element;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void show$lambda$43(Ref.BooleanRef booleanRef, MainActions mainActions, DialogInterface dialogInterface) {
        Settings.INSTANCE.changed();
        if (booleanRef.element) {
            mainActions.applyThemeChange();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit show$lambda$5(Ref.ObjectRef objectRef, Context context, MainActions mainActions, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AlertDialog alertDialog = (AlertDialog) objectRef.element;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        INSTANCE.editTheme(context, Theme.copy$default(Settings.INSTANCE.getTheme(), INSTANCE.uniqueName("My Theme"), false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8388606, null), true, mainActions);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit show$lambda$8(Ref.ObjectRef objectRef, Context context, MainActions mainActions, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AlertDialog alertDialog = (AlertDialog) objectRef.element;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        INSTANCE.editTheme(context, Settings.INSTANCE.getTheme(), false, mainActions);
        return Unit.INSTANCE;
    }

    private final void slider(Context ctx, LinearLayout box, String label, float min, float max, float value, float step, Function1<? super Float, Unit> onSet) {
        LinearLayout row = row(ctx, box, label, null);
        TextView text$default = Ui.text$default(Ui.INSTANCE, ctx, DataTypesKt.fmtNum(value), 13.0f, Ui.INSTANCE.getDIM(), false, 16, null);
        row.addView(text$default);
        int i = (int) ((max - min) / step);
        SeekBar seekBar = new SeekBar(ctx);
        seekBar.setMax(i);
        seekBar.setProgress(RangesKt.coerceIn((int) ((value - min) / step), 0, i));
        seekBar.setOnSeekBarChangeListener(new SettingsDialog$slider$sb$1$1(min, step, text$default, onSet));
        box.addView(seekBar, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
    }

    static /* synthetic */ void slider$default(SettingsDialog settingsDialog, Context context, LinearLayout linearLayout, String str, float f, float f2, float f3, float f4, Function1 function1, int i, Object obj) {
        settingsDialog.slider(context, linearLayout, str, f, f2, f3, (i & 64) != 0 ? 0.1f : f4, function1);
    }

    private final View themeChip(Context ctx, Theme t, boolean selected, Function0<Unit> onClick) {
        LinearLayout linearLayout = new LinearLayout(ctx);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setPadding(Ui.INSTANCE.dp(ctx, 6.0f), Ui.INSTANCE.dp(ctx, 6.0f), Ui.INSTANCE.dp(ctx, 6.0f), Ui.INSTANCE.dp(ctx, 4.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(Ui.INSTANCE.dp(ctx, 6.0f));
        gradientDrawable.setStroke(Ui.INSTANCE.dp(ctx, 2.0f), selected ? Ui.INSTANCE.getACCENT() : 0);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setOnClickListener(new SettingsDialog$$ExternalSyntheticLambda38(onClick));
        linearLayout.addView(new SettingsDialog$themeChip$preview$1(ctx, t), new LinearLayout.LayoutParams(Ui.INSTANCE.dp(ctx, 84.0f), Ui.INSTANCE.dp(ctx, 54.0f)));
        TextView text$default = Ui.text$default(Ui.INSTANCE, ctx, t.getName(), 11.0f, Ui.INSTANCE.getTEXT(), false, 16, null);
        text$default.setGravity(17);
        text$default.setPadding(0, Ui.INSTANCE.dp(ctx, 3.0f), 0, 0);
        linearLayout.addView(text$default);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void themeChip$lambda$48$lambda$47(Function0 function0, View view) {
        function0.invoke();
    }

    private final void toggle(Context ctx, LinearLayout box, String label, String hint, boolean value, Function1<? super Boolean, Unit> onSet) {
        LinearLayout row = row(ctx, box, label, hint);
        Switch r1 = new Switch(ctx);
        r1.setChecked(value);
        r1.setOnCheckedChangeListener(new SettingsDialog$$ExternalSyntheticLambda8(onSet));
        row.addView(r1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void toggle$lambda$55$lambda$54(Function1 function1, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        function1.invoke(Boolean.valueOf(z));
    }

    private final String uniqueName(String base) {
        List<Theme> allThemes = Settings.INSTANCE.allThemes();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(allThemes, 10));
        Iterator<T> it = allThemes.iterator();
        while (it.hasNext()) {
            arrayList.add(((Theme) it.next()).getName());
        }
        Set set = CollectionsKt.toSet(arrayList);
        if (!set.contains(base)) {
            return base;
        }
        int i = 2;
        while (set.contains(base + " " + i)) {
            i++;
        }
        return base + " " + i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void editTheme(Context ctx, Theme start, boolean isNew, MainActions actions) {
        Context ctx2 = ctx;
        Intrinsics.checkNotNullParameter(ctx2, "ctx");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = start;
        String name = start.getName();
        LinearLayout linearLayout = new LinearLayout(ctx2);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(Ui.INSTANCE.dp(ctx2, 18.0f), Ui.INSTANCE.dp(ctx2, 6.0f), Ui.INSTANCE.dp(ctx2, 18.0f), Ui.INSTANCE.dp(ctx2, 8.0f));
        EditText input$default = Ui.input$default(Ui.INSTANCE, ctx2, ((Theme) objectRef.element).getName(), "Theme name", false, false, 24, null);
        linearLayout.addView(input$default);
        LinearLayout linearLayout2 = new LinearLayout(ctx2);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setPadding(0, Ui.INSTANCE.dp(ctx2, 6.0f), 0, Ui.INSTANCE.dp(ctx2, 6.0f));
        linearLayout2.addView(Ui.text$default(Ui.INSTANCE, ctx2, "Light theme (dark text, light dialogs)", 13.0f, 0, false, 24, null), Ui.INSTANCE.lp(0, -2, 1.0f));
        Switch r0 = new Switch(ctx2);
        r0.setChecked(((Theme) objectRef.element).getLight());
        r0.setOnCheckedChangeListener(new SettingsDialog$$ExternalSyntheticLambda2(objectRef));
        linearLayout2.addView(r0);
        linearLayout.addView(linearLayout2);
        LinearLayout linearLayout3 = new LinearLayout(ctx2);
        linearLayout3.setOrientation(0);
        LinearLayout linearLayout4 = new LinearLayout(ctx2);
        linearLayout4.setOrientation(1);
        for (Theme theme : Theme.INSTANCE.getBuiltIn()) {
            Ui ui = Ui.INSTANCE;
            String str = "From " + theme.getName();
            SettingsDialog$$ExternalSyntheticLambda3 settingsDialog$$ExternalSyntheticLambda3 = new SettingsDialog$$ExternalSyntheticLambda3(objectRef, theme, input$default, linearLayout4, ctx2);
            ctx2 = ctx;
            TextView button$default = Ui.button$default(ui, ctx2, str, 0, settingsDialog$$ExternalSyntheticLambda3, 4, null);
            button$default.setTextSize(11.0f);
            LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, -2, -2, 0.0f, 4, null);
            lp$default.rightMargin = Ui.INSTANCE.dp(ctx2, 4.0f);
            Unit unit = Unit.INSTANCE;
            linearLayout3.addView(button$default, lp$default);
            linearLayout4 = linearLayout4;
        }
        LinearLayout linearLayout5 = linearLayout4;
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(ctx2);
        horizontalScrollView.addView(linearLayout3);
        linearLayout.addView(horizontalScrollView);
        linearLayout.addView(linearLayout5);
        editTheme$refresh(linearLayout5, objectRef, ctx2);
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(ctx2).setTitle(isNew ? "New Theme" : "Edit Theme");
        ScrollView scrollView = new ScrollView(ctx2);
        scrollView.addView(linearLayout);
        AlertDialog.Builder negativeButton = title.setView(scrollView).setPositiveButton("Save & use", new SettingsDialog$$ExternalSyntheticLambda4(input$default, ctx2, objectRef, actions, name)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null);
        if (!isNew) {
            negativeButton.setNeutralButton("Delete", new SettingsDialog$$ExternalSyntheticLambda5(name, actions));
        }
        negativeButton.show();
    }

    public final List<Float> getFlySpeeds() {
        return flySpeeds;
    }

    public final void pickFlySpeed(Context ctx, Function0<Unit> onSet) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(onSet, "onSet");
        List<Float> list = flySpeeds;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add("x" + DataTypesKt.fmtNum(((Number) it.next()).floatValue()));
        }
        List plus = CollectionsKt.plus((Collection<? extends String>) arrayList, "Custom…");
        int i = 0;
        Iterator<Float> it2 = flySpeeds.iterator();
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            } else {
                if (it2.next().floatValue() == Settings.INSTANCE.getFlySpeed()) {
                    break;
                } else {
                    i++;
                }
            }
        }
        Dialogs.INSTANCE.themed(ctx).setTitle("Fly speed").setSingleChoiceItems((CharSequence[]) plus.toArray(new String[0]), i, new SettingsDialog$$ExternalSyntheticLambda1(onSet, ctx)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v76, types: [android.app.AlertDialog, T] */
    /* JADX WARN: Type inference failed for: r1v60 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r26v2 */
    /* JADX WARN: Type inference failed for: r26v3 */
    /* JADX WARN: Type inference failed for: r26v6 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    public final void show(Context ctx, MainActions actions, Function0<Unit> onImportIcons, Function0<Unit> onRemoveIcons) {
        ?? r1;
        float f;
        int i;
        char c;
        String str;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(onImportIcons, "onImportIcons");
        LinearLayout linearLayout = new LinearLayout(ctx);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(Ui.INSTANCE.dp(ctx, 18.0f), Ui.INSTANCE.dp(ctx, 4.0f), Ui.INSTANCE.dp(ctx, 18.0f), Ui.INSTANCE.dp(ctx, 12.0f));
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        section(ctx, linearLayout, "Appearance");
        List<Theme> allThemes = Settings.INSTANCE.allThemes();
        LinearLayout linearLayout2 = new LinearLayout(ctx);
        linearLayout2.setOrientation(0);
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(ctx);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.addView(linearLayout2);
        for (Theme theme : allThemes) {
            linearLayout2.addView(themeChip(ctx, theme, Intrinsics.areEqual(theme.getName(), Settings.INSTANCE.getThemeName()), new SettingsDialog$$ExternalSyntheticLambda9(theme, booleanRef, objectRef)));
        }
        linearLayout.addView(horizontalScrollView, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        LinearLayout linearLayout3 = new LinearLayout(ctx);
        linearLayout3.setOrientation(0);
        linearLayout3.setPadding(0, Ui.INSTANCE.dp(ctx, 6.0f), 0, 0);
        TextView button$default = Ui.button$default(Ui.INSTANCE, ctx, "New custom theme…", 0, new SettingsDialog$$ExternalSyntheticLambda20(objectRef, ctx, actions), 4, null);
        LinearLayout.LayoutParams lp = Ui.INSTANCE.lp(0, -2, 1.0f);
        lp.rightMargin = Ui.INSTANCE.dp(ctx, 6.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout3.addView(button$default, lp);
        List<Theme> customThemes = Settings.INSTANCE.customThemes();
        if (!(customThemes instanceof Collection) || !customThemes.isEmpty()) {
            Iterator it = customThemes.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(((Theme) it.next()).getName(), Settings.INSTANCE.getThemeName())) {
                        r1 = true;
                        break;
                    }
                } else {
                    r1 = false;
                    break;
                }
            }
        } else {
            r1 = false;
        }
        if (r1 == true) {
            f = 1.0f;
            linearLayout3.addView(Ui.button$default(Ui.INSTANCE, ctx, "Edit current…", 0, new SettingsDialog$$ExternalSyntheticLambda27(objectRef, ctx, actions), 4, null), Ui.INSTANCE.lp(0, -2, 1.0f));
        } else {
            f = 1.0f;
        }
        linearLayout.addView(linearLayout3);
        section(ctx, linearLayout, "Camera");
        int i2 = 0;
        Iterator<Float> it2 = flySpeeds.iterator();
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            if ((it2.next().floatValue() == Settings.INSTANCE.getFlySpeed()) == true) {
                i = i2;
                break;
            }
            i2++;
        }
        List<Float> list = flySpeeds;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            arrayList.add("x" + DataTypesKt.fmtNum(((Number) it3.next()).floatValue()));
        }
        choice(ctx, linearLayout, "Fly speed", arrayList, i < 0 ? "x" + DataTypesKt.fmtNum(Settings.INSTANCE.getFlySpeed()) : null, i, new SettingsDialog$$ExternalSyntheticLambda28());
        float f2 = f;
        slider$default(this, ctx, linearLayout, "Look sensitivity", 0.2f, 3.0f, Settings.INSTANCE.getCameraSensitivity(), 0.0f, new SettingsDialog$$ExternalSyntheticLambda29(), 64, null);
        toggle(ctx, linearLayout, "Smooth camera movement", "Eases the camera in and out instead of starting and stopping instantly.", Settings.INSTANCE.getCameraSmoothing(), new SettingsDialog$$ExternalSyntheticLambda30());
        section(ctx, linearLayout, "Script Editor");
        slider(ctx, linearLayout, "Font size", 9.0f, 24.0f, Settings.INSTANCE.getEditorFontSize(), 1.0f, new SettingsDialog$$ExternalSyntheticLambda31());
        toggle(ctx, linearLayout, "Autocomplete", "Suggests keywords, globals, services, members and names from your place as you type.", Settings.INSTANCE.getAutocomplete(), new SettingsDialog$$ExternalSyntheticLambda32());
        toggle(ctx, linearLayout, "Auto indent", null, Settings.INSTANCE.getAutoIndent(), new SettingsDialog$$ExternalSyntheticLambda33());
        toggle(ctx, linearLayout, "Auto-close brackets and quotes", null, Settings.INSTANCE.getAutoCloseBrackets(), new SettingsDialog$$ExternalSyntheticLambda34());
        section(ctx, linearLayout, "Viewport & GUI Editing");
        toggle(ctx, linearLayout, "Show FPS", null, Settings.INSTANCE.getShowFps(), new SettingsDialog$$ExternalSyntheticLambda10());
        choice(ctx, linearLayout, "Materials", CollectionsKt.listOf((Object[]) new String[]{"2022 (Modern)", "Pre-2022"}), "Which Roblox material textures parts use. A place can also ask for the old ones (MaterialService.Use2022Materials).", !Settings.INSTANCE.getModernMaterials() ? 1 : 0, new SettingsDialog$$ExternalSyntheticLambda11());
        char c2 = 5;
        List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{"Automatic", "Low", "Medium", "High", "Ultra"});
        choice(ctx, linearLayout, "Render distance", listOf, "How far away small parts keep being drawn on big maps. Automatic adjusts to your device's frame rate (fast devices keep more loaded); Low helps slow tablets.", RangesKt.coerceAtLeast(listOf.indexOf(Settings.INSTANCE.getRenderDistance()), 0), new SettingsDialog$$ExternalSyntheticLambda12(listOf));
        toggle(ctx, linearLayout, "Smart guides when dragging GUIs", "Snaps GUI objects to the edges and centers of their parent and siblings.", Settings.INSTANCE.getGuiSmartGuides(), new SettingsDialog$$ExternalSyntheticLambda13());
        List listOf2 = CollectionsKt.listOf((Object[]) new Integer[]{0, 1, 2, 4, 5, 8, 10, 16});
        List list2 = listOf2;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it4 = list2.iterator();
        while (it4.hasNext()) {
            int intValue = ((Number) it4.next()).intValue();
            if (intValue == 0) {
                c = c2;
                str = "Off";
            } else {
                c = c2;
                str = intValue + " px";
            }
            arrayList2.add(str);
            c2 = c;
        }
        choice(ctx, linearLayout, "GUI drag grid", arrayList2, null, listOf2.indexOf(Integer.valueOf(Settings.INSTANCE.getGuiGrid())), new SettingsDialog$$ExternalSyntheticLambda14(listOf2));
        Float[] fArr = new Float[6];
        float f3 = 0.0f;
        fArr[0] = Float.valueOf(0.0f);
        fArr[1] = Float.valueOf(0.5f);
        fArr[2] = Float.valueOf(0.6f);
        fArr[3] = Float.valueOf(0.75f);
        fArr[4] = Float.valueOf(0.85f);
        fArr[c2] = Float.valueOf(f2);
        List listOf3 = CollectionsKt.listOf((Object[]) fArr);
        List list3 = listOf3;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        Iterator it5 = list3.iterator();
        while (it5.hasNext()) {
            float floatValue = ((Number) it5.next()).floatValue();
            arrayList3.add(((floatValue > f3 ? 1 : (floatValue == f3 ? 0 : -1)) == 0) != false ? "Auto (fit screen)" : ((int) (floatValue * 100.0f)) + "%");
            f3 = 0.0f;
        }
        choice(ctx, linearLayout, "Plugin UI size", arrayList3, null, RangesKt.coerceAtLeast(listOf3.indexOf(Float.valueOf(Settings.INSTANCE.getPluginUiScale())), 0), new SettingsDialog$$ExternalSyntheticLambda15(listOf3));
        section(ctx, linearLayout, "Playtest");
        toggle(ctx, linearLayout, "Hide windows while playtesting", "Gives the game the whole screen; your layout comes back when you stop.", Settings.INSTANCE.getHideWindowsInPlaytest(), new SettingsDialog$$ExternalSyntheticLambda16());
        toggle(ctx, linearLayout, "Shift Lock Switch", "Shows the shift lock button on mobile (also in the in-game Roblox menu).", Settings.INSTANCE.getShiftLockSwitch(), new SettingsDialog$$ExternalSyntheticLambda17());
        choice(ctx, linearLayout, "Camera mode", CollectionsKt.listOf((Object[]) new String[]{"Classic", "Follow"}), null, !Intrinsics.areEqual(Settings.INSTANCE.getCameraMode(), "Classic") ? 1 : 0, new SettingsDialog$$ExternalSyntheticLambda18());
        choice(ctx, linearLayout, "Movement mode", CollectionsKt.listOf((Object[]) new String[]{"Dynamic Thumbstick", "Thumbstick"}), null, Intrinsics.areEqual(Settings.INSTANCE.getMovementMode(), "Thumbstick") ? 1 : 0, new SettingsDialog$$ExternalSyntheticLambda19());
        slider$default(this, ctx, linearLayout, "Camera sensitivity", 0.2f, 4.0f, Settings.INSTANCE.getPlayCameraSensitivity(), 0.0f, new SettingsDialog$$ExternalSyntheticLambda21(), 64, null);
        section(ctx, linearLayout, "Privacy");
        TextView text$default = Ui.text$default(Ui.INSTANCE, ctx, "Your Roblox sign-in and API key stay on this device: they're only ever sent to Roblox's own servers (over HTTPS), are left out of Android backups, and scripts and plugins can't read them. Scripts and plugins must ask before connecting to any website.", 12.0f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default.setSingleLine(false);
        linearLayout.addView(text$default);
        Map<String, Boolean> remembered = WebPermissions.INSTANCE.remembered(ctx);
        TextView text$default2 = Ui.text$default(Ui.INSTANCE, ctx, remembered.isEmpty() ? "No websites allowed or blocked yet." : CollectionsKt.joinToString$default(CollectionsKt.sortedWith(remembered.entrySet(), new SettingsDialog$show$$inlined$sortedBy$1()), "\n", null, null, 0, null, new SettingsDialog$$ExternalSyntheticLambda22(), 30, null), 12.0f, Ui.INSTANCE.getTEXT(), false, 16, null);
        text$default2.setSingleLine(false);
        text$default2.setPadding(0, Ui.INSTANCE.dp(ctx, 6.0f), 0, 0);
        linearLayout.addView(text$default2);
        if (!remembered.isEmpty()) {
            TextView button$default2 = Ui.button$default(Ui.INSTANCE, ctx, "Forget website choices (ask again)", 0, new SettingsDialog$$ExternalSyntheticLambda23(ctx, objectRef), 4, null);
            LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
            lp$default.topMargin = Ui.INSTANCE.dp(ctx, 6.0f);
            Unit unit2 = Unit.INSTANCE;
            linearLayout.addView(button$default2, lp$default);
        }
        section(ctx, linearLayout, "Icons");
        TextView text$default3 = Ui.text$default(Ui.INSTANCE, ctx, Icons.INSTANCE.getInstalled() ? "Using your imported icon pack." : "Using the built-in icons.", 12.0f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default3.setSingleLine(false);
        linearLayout.addView(text$default3);
        LinearLayout linearLayout4 = new LinearLayout(ctx);
        linearLayout4.setOrientation(0);
        linearLayout4.setPadding(0, Ui.INSTANCE.dp(ctx, 6.0f), 0, 0);
        TextView button$default3 = Ui.button$default(Ui.INSTANCE, ctx, "Import icon pack (optional)…", 0, new SettingsDialog$$ExternalSyntheticLambda24(objectRef, onImportIcons), 4, null);
        LinearLayout.LayoutParams lp2 = Ui.INSTANCE.lp(0, -2, f2);
        lp2.rightMargin = Ui.INSTANCE.dp(ctx, 6.0f);
        Unit unit3 = Unit.INSTANCE;
        linearLayout4.addView(button$default3, lp2);
        if (onRemoveIcons != null && Icons.INSTANCE.getInstalled()) {
            linearLayout4.addView(Ui.button$default(Ui.INSTANCE, ctx, "Use built-in icons", 0, new SettingsDialog$$ExternalSyntheticLambda25(objectRef, onRemoveIcons), 4, null), Ui.INSTANCE.lp(0, -2, 1.0f));
        }
        linearLayout.addView(linearLayout4);
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(ctx).setTitle("Studio Settings");
        ScrollView scrollView = new ScrollView(ctx);
        scrollView.addView(linearLayout);
        Unit unit4 = Unit.INSTANCE;
        objectRef.element = title.setView(scrollView).setPositiveButton("Done", (DialogInterface.OnClickListener) null).create();
        ((AlertDialog) objectRef.element).setOnDismissListener(new SettingsDialog$$ExternalSyntheticLambda26(booleanRef, actions));
        ((AlertDialog) objectRef.element).show();
    }
}
