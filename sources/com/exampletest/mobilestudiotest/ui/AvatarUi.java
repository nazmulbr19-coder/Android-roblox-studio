package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.exampletest.mobilestudiotest.core.OutputLog;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.engine.Avatar;
import com.exampletest.mobilestudiotest.engine.Geometry;
import com.exampletest.mobilestudiotest.engine.PlaySession;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.DataTypesKt;
import com.exampletest.mobilestudiotest.model.EnumValue;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.NumberRange;
import com.exampletest.mobilestudiotest.model.PartData;
import com.exampletest.mobilestudiotest.model.Vector3;
import com.exampletest.mobilestudiotest.net.CloudPlace;
import com.exampletest.mobilestudiotest.net.RobloxApi;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: AvatarUi.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J>\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J \u0010\u001f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0002JJ\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00192\u0006\u0010\t\u001a\u00020\n2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0#2\u0006\u0010-\u001a\u00020\u000e2\u0014\b\u0002\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0/H\u0002J\u0016\u00100\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cJ\u001e\u00101\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00102\u001a\u000203J\u0016\u00104\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cJ \u00105\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00106\u001a\u00020!H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020(0&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/AvatarUi;", "", "<init>", "()V", "net", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "toast", "", "act", "Landroid/app/Activity;", "s", "", "dp", "", "v", "", "optionRow", "Landroid/view/View;", "icon", "title", "sub", "current", "", "onClick", "Lkotlin/Function0;", "playtestAvatar", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "characterChooser", "pickFromWorkspace", "saveCharacter", "inst", "Lcom/exampletest/mobilestudiotest/model/Instance;", "scaleKeys", "", "Lkotlin/Pair;", "scaleLabels", "", "scaleDefaults", "Lcom/exampletest/mobilestudiotest/model/NumberRange;", "segmented", "parent", "Landroid/widget/LinearLayout;", "options", "initial", "onChange", "Lkotlin/Function1;", "gameSettings", "syncFromCloud", "cloud", "Lcom/exampletest/mobilestudiotest/net/CloudPlace;", "rigBuilder", "insertRig", "m", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AvatarUi {
    public static final AvatarUi INSTANCE = new AvatarUi();
    private static final ExecutorService net = Executors.newSingleThreadExecutor();
    private static final List<Pair<String, String>> scaleKeys = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("Height", "height"), TuplesKt.to("Width", "width"), TuplesKt.to("Head", "head"), TuplesKt.to("BodyType", "bodyType"), TuplesKt.to("Proportion", "proportion")});
    private static final Map<String, String> scaleLabels = MapsKt.mapOf(TuplesKt.to("Height", "Height"), TuplesKt.to("Width", "Width"), TuplesKt.to("Head", "Head"), TuplesKt.to("BodyType", "Body type"), TuplesKt.to("Proportion", "Proportions"));
    private static final Map<String, NumberRange> scaleDefaults = MapsKt.mapOf(TuplesKt.to("Height", new NumberRange(0.9f, 1.05f)), TuplesKt.to("Width", new NumberRange(0.7f, 1.0f)), TuplesKt.to("Head", new NumberRange(0.95f, 1.0f)), TuplesKt.to("BodyType", new NumberRange(0.0f, 1.0f)), TuplesKt.to("Proportion", new NumberRange(0.0f, 1.0f)));

    private AvatarUi() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit characterChooser$lambda$25(Activity activity, Studio studio, Instance instance) {
        INSTANCE.saveCharacter(activity, studio, instance);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit characterChooser$lambda$26(Activity activity, Studio studio) {
        INSTANCE.pickFromWorkspace(activity, studio);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit characterChooser$lambda$28(Activity activity) {
        Avatar.setMode$default(Avatar.INSTANCE, activity, Avatar.Mode.CHARACTER, 0L, null, 12, null);
        INSTANCE.toast(activity, "Playing as " + Avatar.INSTANCE.characterName(activity));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit characterChooser$lambda$30(Activity activity) {
        Avatar.INSTANCE.clearCharacter(activity);
        INSTANCE.toast(activity, "Back to your avatar");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void characterChooser$lambda$32(ArrayList arrayList, DialogInterface dialogInterface, int i) {
        ((Function0) ((Pair) arrayList.get(i)).getSecond()).invoke();
    }

    private final int dp(Activity act, float v) {
        return Ui.INSTANCE.dp(act, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit gameSettings$lambda$55(LinearLayout linearLayout, int i) {
        linearLayout.setVisibility(i == 0 ? 8 : 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01f2, code lost:
    
        r7.put((java.lang.String) ((kotlin.Pair) r24).getSecond(), ((java.util.Map.Entry) r17).getValue());
        r5 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x02d4, code lost:
    
        r7.put((java.lang.String) ((kotlin.Pair) r24).getSecond(), ((java.util.Map.Entry) r17).getValue());
        r1 = r36;
        r6 = r37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void gameSettings$lambda$77(kotlin.jvm.functions.Function0 r27, kotlin.jvm.functions.Function0 r28, java.util.HashMap r29, com.exampletest.mobilestudiotest.core.Studio r30, com.exampletest.mobilestudiotest.net.CloudPlace r31, android.widget.CheckBox r32, android.app.Activity r33, com.exampletest.mobilestudiotest.model.Instance r34, android.widget.Switch r35, android.content.DialogInterface r36, int r37) {
        /*
            Method dump skipped, instructions count: 917
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.AvatarUi.gameSettings$lambda$77(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, java.util.HashMap, com.exampletest.mobilestudiotest.core.Studio, com.exampletest.mobilestudiotest.net.CloudPlace, android.widget.CheckBox, android.app.Activity, com.exampletest.mobilestudiotest.model.Instance, android.widget.Switch, android.content.DialogInterface, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit gameSettings$lambda$77$lambda$74(Activity activity, CloudPlace cloudPlace, RobloxCloud.AvatarSettings avatarSettings) {
        RobloxCloud.INSTANCE.setAvatarSettings(activity, cloudPlace.getUniverseId(), avatarSettings);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit gameSettings$lambda$77$lambda$75(Activity activity, String str, Unit it) {
        Intrinsics.checkNotNullParameter(it, "it");
        INSTANCE.toast(activity, "Avatar settings saved (" + str + ")");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean gameSettings$lambda$77$lambda$76(Activity activity, String str, Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        OutputLog.INSTANCE.warn("Couldn't save avatar settings to Roblox: " + e.getMessage());
        Dialogs.INSTANCE.themed(activity).setTitle("Saved in the place only").setMessage("The place now uses " + str + ", but Roblox didn't accept the change for the game:\n\n" + e.getMessage()).setPositiveButton("OK", (DialogInterface.OnClickListener) null).show();
        return true;
    }

    private static final void gameSettings$section(LinearLayout linearLayout, Activity activity, String str, String str2) {
        TextView text = Ui.INSTANCE.text(activity, str, 14.0f, Ui.INSTANCE.getTEXT(), true);
        text.setPadding(0, INSTANCE.dp(activity, 14.0f), 0, INSTANCE.dp(activity, str2 != null ? 2.0f : 8.0f));
        linearLayout.addView(text);
        if (str2 != null) {
            TextView text$default = Ui.text$default(Ui.INSTANCE, activity, str2, 11.5f, Ui.INSTANCE.getDIM(), false, 16, null);
            text$default.setSingleLine(false);
            text$default.setPadding(0, 0, 0, INSTANCE.dp(activity, 8.0f));
            linearLayout.addView(text$default);
        }
    }

    static /* synthetic */ void gameSettings$section$default(LinearLayout linearLayout, Activity activity, String str, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        gameSettings$section(linearLayout, activity, str, str2);
    }

    private final void insertRig(Activity act, Studio studio, Instance m) {
        synchronized (studio.getLock()) {
            boolean z = true;
            List descendants$default = Instance.descendants$default(m, null, 1, null);
            ArrayList arrayList = new ArrayList();
            for (Object obj : descendants$default) {
                if (((Instance) obj).isA("BasePart")) {
                    arrayList.add(obj);
                }
            }
            ArrayList<Instance> arrayList2 = arrayList;
            Pair<Vector3, Vector3> boundsOf = Geometry.INSTANCE.boundsOf(arrayList2);
            if (boundsOf == null) {
                return;
            }
            Vector3 spawnPoint = studio.spawnPoint(new Vector3(4.0f, 0.0f, 2.0f));
            Vector3 forward = studio.getCamera().getForward();
            CFrame times = CFrame.INSTANCE.at(new Vector3(spawnPoint.getX(), spawnPoint.getY() - boundsOf.getFirst().getY(), spawnPoint.getZ())).times(CFrame.INSTANCE.ry((float) Math.atan2(forward.getX(), forward.getZ())));
            for (Instance instance : arrayList2) {
                instance.set("CFrame", times.times(PartData.INSTANCE.cframe(instance)), false);
                z = z;
            }
            boolean z2 = z;
            Instance findFirstChild$default = Instance.findFirstChild$default(m, "HumanoidRootPart", false, 2, null);
            if (findFirstChild$default != null) {
                findFirstChild$default.set("Anchored", Boolean.valueOf(z2), false);
            }
            studio.getUndo().begin("Insert Rig");
            studio.reparent(m, studio.getModel().getWorkspace());
            studio.getUndo().commit();
            studio.getSelection().clear();
            studio.getSelection().add(m);
            Iterator<T> it = studio.getListeners().iterator();
            while (it.hasNext()) {
                ((Studio.Listener) it.next()).onSelectionChanged();
            }
            studio.markDirty();
            toast(act, "Inserted " + m.getName());
        }
    }

    private final View optionRow(Activity act, String icon, String title, String sub, boolean current, Function0<Unit> onClick) {
        int card;
        LinearLayout linearLayout = new LinearLayout(act);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(INSTANCE.dp(act, 10.0f), INSTANCE.dp(act, 9.0f), INSTANCE.dp(act, 12.0f), INSTANCE.dp(act, 9.0f));
        Ui ui = Ui.INSTANCE;
        Activity activity = act;
        Ui ui2 = Ui.INSTANCE;
        if (current) {
            card = ui2.blend(Ui.INSTANCE.getPANEL(), Ui.INSTANCE.getACCENT(), Ui.INSTANCE.getLIGHT() ? 0.14f : 0.28f);
        } else {
            card = ui2.getCARD();
        }
        linearLayout.setBackground(ui.rippleBg(activity, card, 10.0f));
        linearLayout.setClickable(true);
        linearLayout.setOnClickListener(new AvatarUi$$ExternalSyntheticLambda21(onClick));
        ImageView imageView = new ImageView(act);
        imageView.setImageDrawable(Icons.general$default(Icons.INSTANCE, act, icon, null, 4, null));
        LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, dp(act, 28.0f), dp(act, 28.0f), 0.0f, 4, null);
        lp$default.rightMargin = INSTANCE.dp(act, 12.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(imageView, lp$default);
        LinearLayout linearLayout2 = new LinearLayout(act);
        linearLayout2.setOrientation(1);
        linearLayout2.addView(Ui.INSTANCE.text(act, title, 14.0f, Ui.INSTANCE.getTEXT(), true));
        TextView text$default = Ui.text$default(Ui.INSTANCE, act, sub, 11.5f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default.setSingleLine(false);
        linearLayout2.addView(text$default);
        linearLayout.addView(linearLayout2, Ui.INSTANCE.lp(0, -2, 1.0f));
        if (current) {
            linearLayout.addView(Ui.INSTANCE.text(act, "✓", 17.0f, Ui.INSTANCE.getLIGHT() ? Ui.INSTANCE.getACCENT() : Ui.INSTANCE.blend(Ui.INSTANCE.getACCENT(), -1, 0.4f), true));
        }
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void optionRow$lambda$1$lambda$0(Function0 function0, View view) {
        function0.invoke();
    }

    private final void pickFromWorkspace(Activity act, Studio studio) {
        ArrayList arrayList;
        synchronized (studio.getLock()) {
            Instance workspace = studio.getModel().getWorkspace();
            arrayList = new ArrayList();
            pickFromWorkspace$lambda$33$visit(arrayList, workspace, 0);
        }
        if (arrayList.isEmpty()) {
            toast(act, "Workspace has no models or parts");
            return;
        }
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(act).setTitle("Play as…");
        ArrayList<Instance> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (Instance instance : arrayList2) {
            arrayList3.add((instance.isA("BasePart") ? "▫ " : "▣ ") + instance.getName());
        }
        title.setItems((CharSequence[]) arrayList3.toArray(new String[0]), new AvatarUi$$ExternalSyntheticLambda14(act, studio, arrayList)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    private static final void pickFromWorkspace$lambda$33$visit(ArrayList<Instance> arrayList, Instance instance, int i) {
        Iterator<Instance> it = instance.getChildren().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Instance next = it.next();
            if (arrayList.size() >= 200) {
                return;
            }
            if (!Intrinsics.areEqual(next.getClassName(), "Terrain") && !Intrinsics.areEqual(next.getClassName(), "Camera")) {
                if (next.isA("Model") || next.isA("BasePart")) {
                    arrayList.add(next);
                } else if (Intrinsics.areEqual(next.getClassName(), "Folder") && i < 2) {
                    pickFromWorkspace$lambda$33$visit(arrayList, next, i + 1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void pickFromWorkspace$lambda$35(Activity activity, Studio studio, ArrayList arrayList, DialogInterface dialogInterface, int i) {
        AvatarUi avatarUi = INSTANCE;
        Object obj = arrayList.get(i);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        avatarUi.saveCharacter(activity, studio, (Instance) obj);
    }

    private static final void playtestAvatar$add(LinearLayout linearLayout, Activity activity, Ref.ObjectRef<AlertDialog> objectRef, String str, String str2, String str3, boolean z, Function0<Unit> function0) {
        View optionRow = INSTANCE.optionRow(activity, str, str2, str3, z, new AvatarUi$$ExternalSyntheticLambda12(objectRef, function0));
        LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
        lp$default.bottomMargin = INSTANCE.dp(activity, 6.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(optionRow, lp$default);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit playtestAvatar$add$lambda$7(Ref.ObjectRef objectRef, Function0 function0) {
        AlertDialog alertDialog = (AlertDialog) objectRef.element;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit playtestAvatar$lambda$10(boolean z, Activity activity) {
        if (z) {
            AccountUi.INSTANCE.signIn(activity, new AvatarUi$$ExternalSyntheticLambda5(activity));
        } else {
            Avatar.setMode$default(Avatar.INSTANCE, activity, Avatar.Mode.ACCOUNT, 0L, null, 12, null);
            INSTANCE.toast(activity, "Using your avatar");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit playtestAvatar$lambda$10$lambda$9(Activity activity) {
        Avatar.setMode$default(Avatar.INSTANCE, activity, Avatar.Mode.ACCOUNT, 0L, null, 12, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit playtestAvatar$lambda$14(Activity activity, String str) {
        Dialogs.INSTANCE.prompt(activity, "Roblox username", str, new AvatarUi$$ExternalSyntheticLambda22(activity));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit playtestAvatar$lambda$14$lambda$13(Activity activity, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        AccountUi.INSTANCE.background(activity, "Looking up @" + name + "…", new AvatarUi$$ExternalSyntheticLambda7(name), new AvatarUi$$ExternalSyntheticLambda8(activity));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final RobloxCloud.User playtestAvatar$lambda$14$lambda$13$lambda$11(String str) {
        RobloxCloud.User userByName = RobloxCloud.INSTANCE.userByName(str);
        if (userByName != null) {
            return userByName;
        }
        throw new Exception("No Roblox user named \"" + str + "\".");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit playtestAvatar$lambda$14$lambda$13$lambda$12(Activity activity, RobloxCloud.User u) {
        Intrinsics.checkNotNullParameter(u, "u");
        Avatar.INSTANCE.setMode(activity, Avatar.Mode.USER, u.getId(), u.getName());
        INSTANCE.toast(activity, "Wearing @" + u.getName() + "'s avatar");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit playtestAvatar$lambda$15(Activity activity) {
        AccountUi.INSTANCE.customAvatar(activity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit playtestAvatar$lambda$16(Activity activity) {
        Avatar.setMode$default(Avatar.INSTANCE, activity, Avatar.Mode.CLASSIC, 0L, null, 12, null);
        INSTANCE.toast(activity, "Using the classic avatar");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit playtestAvatar$lambda$18(Activity activity, Studio studio) {
        INSTANCE.characterChooser(activity, studio);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void playtestAvatar$lambda$21(Activity activity, Studio studio, DialogInterface dialogInterface, int i) {
        INSTANCE.gameSettings(activity, studio);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit rigBuilder$lambda$83(Activity activity, Studio studio) {
        INSTANCE.insertRig(activity, studio, PlaySession.INSTANCE.buildR6Rig("Rig"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit rigBuilder$lambda$84(Activity activity, Studio studio) {
        if (RobloxApi.INSTANCE.isGuest(activity)) {
            INSTANCE.toast(activity, "R15 body meshes download from Roblox; sign in to see them (they show as boxes until then)");
        }
        INSTANCE.insertRig(activity, studio, Avatar.INSTANCE.buildR15("Rig", new Avatar.Spec(Avatar.INSTANCE.getCLASSIC_COLORS(), null, null, null, null, CollectionsKt.emptyList(), "Rig", true, null, null, null, null, 3840, null)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit rigBuilder$lambda$85(Avatar.Spec spec, Activity activity, Studio studio) {
        Instance buildR6Rig = PlaySession.INSTANCE.buildR6Rig(StringsKt.removePrefix(spec.getLabel(), (CharSequence) "@"));
        Avatar.INSTANCE.applyTo(buildR6Rig, Avatar.Spec.forRig$default(spec, false, null, 2, null));
        INSTANCE.insertRig(activity, studio, buildR6Rig);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit rigBuilder$lambda$86(Activity activity, Studio studio, Avatar.Spec spec) {
        INSTANCE.insertRig(activity, studio, Avatar.INSTANCE.buildR15(StringsKt.removePrefix(spec.getLabel(), (CharSequence) "@"), Avatar.Spec.forRig$default(spec, true, null, 2, null)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void rigBuilder$lambda$88(ArrayList arrayList, DialogInterface dialogInterface, int i) {
        ((Function0) ((Pair) arrayList.get(i)).getSecond()).invoke();
    }

    private final void saveCharacter(Activity act, Studio studio, Instance inst) {
        boolean z;
        boolean z2;
        synchronized (studio.getLock()) {
            z = true;
            if (!inst.isA("BasePart")) {
                List descendants$default = Instance.descendants$default(inst, null, 1, null);
                if (!(descendants$default instanceof Collection) || !descendants$default.isEmpty()) {
                    Iterator it = descendants$default.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = false;
                            break;
                        } else if (((Instance) it.next()).isA("BasePart")) {
                            z2 = true;
                            break;
                        }
                    }
                } else {
                    z2 = false;
                }
                if (!z2) {
                    z = false;
                }
            }
        }
        if (!z) {
            toast(act, inst.getName() + " has no parts to play as");
            return;
        }
        byte[] serializeInstances = studio.serializeInstances(CollectionsKt.listOf(inst));
        if (serializeInstances == null) {
            toast(act, "Couldn't save " + inst.getName());
            return;
        }
        Avatar.INSTANCE.setCharacter(act, serializeInstances, inst.getName());
        OutputLog.INSTANCE.info("Playtest avatar: you'll spawn as " + inst.getName() + " in every place (File → Playtest Avatar to change)");
        toast(act, "You'll play as " + inst.getName() + " in every place");
    }

    private final Function0<Integer> segmented(Activity act, LinearLayout parent, List<String> options, int initial, Function1<? super Integer, Unit> onChange) {
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = initial;
        LinearLayout linearLayout = new LinearLayout(act);
        linearLayout.setOrientation(0);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : options) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int i3 = i;
            TextView text = Ui.INSTANCE.text(act, (String) obj, 13.0f, Ui.INSTANCE.getTEXT(), true);
            text.setGravity(17);
            text.setPadding(INSTANCE.dp(act, 12.0f), INSTANCE.dp(act, 8.0f), INSTANCE.dp(act, 12.0f), INSTANCE.dp(act, 8.0f));
            intRef = intRef;
            text.setOnClickListener(new AvatarUi$$ExternalSyntheticLambda0(intRef, i3, onChange, arrayList, act));
            arrayList.add(text);
            TextView textView = text;
            LinearLayout.LayoutParams lp = Ui.INSTANCE.lp(0, -2, 1.0f);
            lp.rightMargin = i3 < options.size() + (-1) ? INSTANCE.dp(act, 6.0f) : 0;
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(textView, lp);
            i = i2;
        }
        segmented$paint(arrayList, intRef, act);
        parent.addView(linearLayout, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        return new AvatarUi$$ExternalSyntheticLambda1(intRef);
    }

    static /* synthetic */ Function0 segmented$default(AvatarUi avatarUi, Activity activity, LinearLayout linearLayout, List list, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            function1 = new AvatarUi$$ExternalSyntheticLambda6();
        }
        return avatarUi.segmented(activity, linearLayout, list, i, function1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit segmented$lambda$39(int i) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void segmented$lambda$45$lambda$43$lambda$42(Ref.IntRef intRef, int i, Function1 function1, ArrayList arrayList, Activity activity, View view) {
        intRef.element = i;
        segmented$paint(arrayList, intRef, activity);
        function1.invoke(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int segmented$lambda$46(Ref.IntRef intRef) {
        return intRef.element;
    }

    private static final void segmented$paint(ArrayList<TextView> arrayList, Ref.IntRef intRef, Activity activity) {
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TextView textView = (TextView) obj;
            boolean z = i == intRef.element;
            textView.setTextColor(z ? -1 : Ui.INSTANCE.getTEXT());
            Ui ui = Ui.INSTANCE;
            Activity activity2 = activity;
            Ui ui2 = Ui.INSTANCE;
            textView.setBackground(ui.rippleBg(activity2, z ? ui2.getACCENT() : ui2.getCARD(), 16.0f));
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void syncFromCloud$lambda$81(Context context, CloudPlace cloudPlace, Studio studio) {
        RobloxCloud.AvatarSettings avatarSettings;
        try {
            RobloxCloud robloxCloud = RobloxCloud.INSTANCE;
            Intrinsics.checkNotNull(context);
            avatarSettings = robloxCloud.avatarSettings(context, cloudPlace.getUniverseId());
        } catch (Exception e) {
            avatarSettings = null;
        }
        if (avatarSettings == null) {
            return;
        }
        studio.getMain().post(new AvatarUi$$ExternalSyntheticLambda13(studio, cloudPlace, avatarSettings));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void syncFromCloud$lambda$81$lambda$80(Studio studio, CloudPlace cloudPlace, RobloxCloud.AvatarSettings avatarSettings) {
        CloudPlace cloud = studio.getCloud();
        if (!(cloud != null && cloud.getUniverseId() == cloudPlace.getUniverseId()) || studio.isPlaying()) {
            return;
        }
        synchronized (studio.getLock()) {
            Instance service = studio.getModel().getService("StarterPlayer");
            service.set("GameSettingsAvatar", new EnumValue(avatarSettings.getType()), false);
            Integer collision = avatarSettings.getCollision();
            if (collision != null) {
                service.set("GameSettingsR15Collision", new EnumValue(collision.intValue()), false);
            }
            for (Pair<String, String> pair : scaleKeys) {
                String component1 = pair.component1();
                String component2 = pair.component2();
                Float f = avatarSettings.getMin().get(component2);
                Float f2 = avatarSettings.getMax().get(component2);
                if (f != null && f2 != null) {
                    service.set("GameSettingsScaleRange" + component1, new NumberRange(f.floatValue(), f2.floatValue()), false);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        OutputLog.INSTANCE.info("Game Settings: avatar type " + CollectionsKt.listOf((Object[]) new String[]{"R6", "R15", "Player Choice"}).get(avatarSettings.getType()) + " (from the game on Roblox)");
    }

    private final void toast(Activity act, String s) {
        Toast.makeText(act, s, 0).show();
    }

    public final void characterChooser(Activity act, Studio studio) {
        Instance instance;
        Object obj;
        Intrinsics.checkNotNullParameter(act, "act");
        ArrayList arrayList = new ArrayList();
        if (studio != null) {
            synchronized (studio.getLock()) {
                Iterator<T> it = studio.getSelection().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    Instance instance2 = (Instance) obj;
                    if ((instance2.isA("Model") || instance2.isA("BasePart")) && !instance2.getIsService()) {
                        break;
                    }
                }
                instance = (Instance) obj;
            }
        } else {
            instance = null;
        }
        if (studio != null && instance != null) {
            arrayList.add(TuplesKt.to("Use the selection (" + instance.getName() + ")", new AvatarUi$$ExternalSyntheticLambda28(act, studio, instance)));
        }
        if (studio != null) {
            arrayList.add(TuplesKt.to("Pick from Workspace…", new AvatarUi$$ExternalSyntheticLambda29(act, studio)));
        }
        if (Avatar.INSTANCE.hasCharacter(act)) {
            if (Avatar.INSTANCE.mode(act) != Avatar.Mode.CHARACTER) {
                String characterName = Avatar.INSTANCE.characterName(act);
                if (characterName.length() == 0) {
                    characterName = "saved model";
                }
                arrayList.add(TuplesKt.to("Use “" + ((Object) characterName) + "” again", new AvatarUi$$ExternalSyntheticLambda30(act)));
            }
            String characterName2 = Avatar.INSTANCE.characterName(act);
            if (characterName2.length() == 0) {
                characterName2 = "saved model";
            }
            arrayList.add(TuplesKt.to("Stop using “" + ((Object) characterName2) + "”", new AvatarUi$$ExternalSyntheticLambda31(act)));
        }
        if (arrayList.isEmpty()) {
            toast(act, "Open a place and select a model or part first");
            return;
        }
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(act).setTitle("Custom character");
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add((String) ((Pair) it2.next()).getFirst());
        }
        title.setItems((CharSequence[]) arrayList3.toArray(new String[0]), new AvatarUi$$ExternalSyntheticLambda32(arrayList)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    public final void gameSettings(Activity act, Studio studio) {
        Instance service;
        EnumValue enumValue;
        EnumValue enumValue2;
        boolean z;
        LinearLayout linearLayout;
        NumberRange numberRange;
        Intrinsics.checkNotNullParameter(act, "act");
        Studio studio2 = studio;
        Intrinsics.checkNotNullParameter(studio2, "studio");
        if (studio2.isPlaying()) {
            toast(act, "Stop the playtest to change Game Settings");
            return;
        }
        synchronized (studio2.getLock()) {
            service = studio2.getModel().getService("StarterPlayer");
        }
        Instance instance = service;
        synchronized (studio2.getLock()) {
            try {
                Object obj = instance.get("GameSettingsAvatar");
                if (obj instanceof EnumValue) {
                    try {
                        enumValue = (EnumValue) obj;
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } else {
                    enumValue = null;
                }
                int value = enumValue != null ? enumValue.getValue() : 2;
                synchronized (studio2.getLock()) {
                    try {
                        Object obj2 = instance.get("GameSettingsR15Collision");
                        if (obj2 instanceof EnumValue) {
                            try {
                                enumValue2 = (EnumValue) obj2;
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                        } else {
                            enumValue2 = null;
                        }
                        int value2 = enumValue2 != null ? enumValue2.getValue() : 0;
                        synchronized (studio2.getLock()) {
                            try {
                                z = !Intrinsics.areEqual(instance.get("LoadCharacterAppearance"), (Object) false);
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                        LinearLayout linearLayout2 = new LinearLayout(act);
                        linearLayout2.setOrientation(1);
                        linearLayout2.setPadding(INSTANCE.dp(act, 20.0f), INSTANCE.dp(act, 8.0f), INSTANCE.dp(act, 20.0f), INSTANCE.dp(act, 4.0f));
                        gameSettings$section(linearLayout2, act, "Avatar Type", "Which body players get in this place. Player Choice uses each player's own setting.");
                        LinearLayout linearLayout3 = new LinearLayout(act);
                        linearLayout3.setOrientation(1);
                        Function0<Integer> segmented = segmented(act, linearLayout2, CollectionsKt.listOf((Object[]) new String[]{"R6", "R15", "Player Choice"}), value, new AvatarUi$$ExternalSyntheticLambda2(linearLayout3));
                        int i = value;
                        linearLayout2.addView(linearLayout3);
                        TextView text = Ui.INSTANCE.text(act, "Collision", 14.0f, Ui.INSTANCE.getTEXT(), true);
                        text.setPadding(0, INSTANCE.dp(act, 14.0f), 0, INSTANCE.dp(act, 8.0f));
                        linearLayout3.addView(text);
                        Function0 segmented$default = segmented$default(this, act, linearLayout3, CollectionsKt.listOf((Object[]) new String[]{"Outer Box", "Inner Box"}), value2, null, 16, null);
                        linearLayout3.setVisibility(i == 0 ? 8 : 0);
                        gameSettings$section$default(linearLayout2, act, "Player appearance", null, 8, null);
                        LinearLayout linearLayout4 = new LinearLayout(act);
                        linearLayout4.setOrientation(0);
                        linearLayout4.setGravity(16);
                        TextView text$default = Ui.text$default(Ui.INSTANCE, act, "Load each player's avatar (clothing, accessories, body)", 13.0f, 0, false, 24, null);
                        text$default.setSingleLine(false);
                        linearLayout4.addView(text$default, Ui.INSTANCE.lp(0, -2, 1.0f));
                        Switch r4 = new Switch(act);
                        r4.setChecked(z);
                        linearLayout4.addView(r4);
                        linearLayout2.addView(linearLayout4);
                        gameSettings$section(linearLayout2, act, "Body scales (R15)", "Players' body scales are kept between these values.");
                        HashMap hashMap = new HashMap();
                        Iterator<Pair<String, String>> it = scaleKeys.iterator();
                        while (it.hasNext()) {
                            String component1 = it.next().component1();
                            synchronized (studio2.getLock()) {
                                try {
                                    linearLayout = linearLayout4;
                                    try {
                                        Object obj3 = instance.get("GameSettingsScaleRange" + component1);
                                        if (obj3 instanceof NumberRange) {
                                            try {
                                                numberRange = (NumberRange) obj3;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                throw th;
                                            }
                                        } else {
                                            numberRange = null;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            }
                            if (numberRange == null) {
                                NumberRange numberRange2 = scaleDefaults.get(component1);
                                Intrinsics.checkNotNull(numberRange2);
                                numberRange = numberRange2;
                            }
                            NumberRange numberRange3 = numberRange;
                            LinearLayout linearLayout5 = new LinearLayout(act);
                            linearLayout5.setOrientation(0);
                            linearLayout5.setGravity(16);
                            Switch r29 = r4;
                            HashMap hashMap2 = hashMap;
                            linearLayout5.setPadding(0, INSTANCE.dp(act, 2.0f), 0, INSTANCE.dp(act, 2.0f));
                            String str = scaleLabels.get(component1);
                            Intrinsics.checkNotNull(str);
                            Function0 function0 = segmented$default;
                            linearLayout5.addView(Ui.text$default(Ui.INSTANCE, act, str, 13.0f, 0, false, 24, null), Ui.INSTANCE.lp(0, -2, 1.0f));
                            EditText input$default = Ui.input$default(Ui.INSTANCE, act, DataTypesKt.fmtNum(numberRange3.getMin()), "min", true, false, 16, null);
                            EditText input$default2 = Ui.input$default(Ui.INSTANCE, act, DataTypesKt.fmtNum(numberRange3.getMax()), "max", true, false, 16, null);
                            linearLayout5.addView(input$default, Ui.lp$default(Ui.INSTANCE, dp(act, 72.0f), -2, 0.0f, 4, null));
                            TextView text$default2 = Ui.text$default(Ui.INSTANCE, act, "–", 13.0f, Ui.INSTANCE.getDIM(), false, 16, null);
                            text$default2.setPadding(INSTANCE.dp(act, 6.0f), 0, INSTANCE.dp(act, 6.0f), 0);
                            linearLayout5.addView(text$default2);
                            linearLayout5.addView(input$default2, Ui.lp$default(Ui.INSTANCE, dp(act, 72.0f), -2, 0.0f, 4, null));
                            linearLayout2.addView(linearLayout5);
                            hashMap2.put(component1, TuplesKt.to(input$default, input$default2));
                            studio2 = studio;
                            segmented$default = function0;
                            linearLayout4 = linearLayout;
                            r4 = r29;
                            hashMap = hashMap2;
                            instance = instance;
                        }
                        Switch r292 = r4;
                        HashMap hashMap3 = hashMap;
                        Function0 function02 = segmented$default;
                        Instance instance2 = instance;
                        CloudPlace cloud = studio.getCloud();
                        CheckBox checkBox = new CheckBox(act);
                        checkBox.setText("Also save to “" + (cloud != null ? cloud.getName() : null) + "” on Roblox");
                        checkBox.setTextColor(Ui.INSTANCE.getTEXT());
                        checkBox.setChecked(true);
                        checkBox.setVisibility((cloud == null || RobloxApi.INSTANCE.isGuest(act)) ? 8 : 0);
                        LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
                        lp$default.topMargin = INSTANCE.dp(act, 12.0f);
                        Unit unit = Unit.INSTANCE;
                        linearLayout2.addView(checkBox, lp$default);
                        TextView text$default3 = Ui.text$default(Ui.INSTANCE, act, "Saved in the place (StarterPlayer), so playtests here use it." + (cloud != null ? " Roblox games keep these settings on the game itself, so they're synced when you open it." : ""), 11.5f, Ui.INSTANCE.getDIM(), false, 16, null);
                        text$default3.setSingleLine(false);
                        text$default3.setPadding(0, INSTANCE.dp(act, 6.0f), 0, INSTANCE.dp(act, 4.0f));
                        linearLayout2.addView(text$default3);
                        AlertDialog.Builder title = Dialogs.INSTANCE.themed(act).setTitle("Game Settings — Avatar");
                        ScrollView scrollView = new ScrollView(act);
                        scrollView.addView(linearLayout2);
                        title.setView(scrollView).setPositiveButton("Save", new AvatarUi$$ExternalSyntheticLambda3(segmented, function02, hashMap3, studio, cloud, checkBox, act, instance2, r292)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
                    } catch (Throwable th7) {
                        th = th7;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v31, types: [android.app.AlertDialog, T] */
    public final void playtestAvatar(Activity act, Studio studio) {
        String str;
        Intrinsics.checkNotNullParameter(act, "act");
        LinearLayout linearLayout = new LinearLayout(act);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(INSTANCE.dp(act, 16.0f), INSTANCE.dp(act, 8.0f), INSTANCE.dp(act, 16.0f), INSTANCE.dp(act, 4.0f));
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Avatar.Mode mode = Avatar.INSTANCE.mode(act);
        boolean isGuest = RobloxApi.INSTANCE.isGuest(act);
        playtestAvatar$add(linearLayout, act, objectRef, "Account", "My Roblox avatar", isGuest ? "Sign in first to wear your avatar" : "@" + RobloxApi.INSTANCE.userName(act) + ", as it looks on Roblox", mode == Avatar.Mode.ACCOUNT, new AvatarUi$$ExternalSyntheticLambda15(isGuest, act));
        String second = Avatar.INSTANCE.otherUser(act).getSecond();
        playtestAvatar$add(linearLayout, act, objectRef, "Shared", "Another user's avatar…", second.length() > 0 ? "Now: @" + second : "Wear any Roblox user's avatar", mode == Avatar.Mode.USER, new AvatarUi$$ExternalSyntheticLambda16(act, second));
        playtestAvatar$add(linearLayout, act, objectRef, "Color", "Create my own…", "Body colors, clothing, face and accessories", mode == Avatar.Mode.CUSTOM, new AvatarUi$$ExternalSyntheticLambda17(act));
        playtestAvatar$add(linearLayout, act, objectRef, "Part_Block", "Classic", "The yellow, blue and green blocky avatar", mode == Avatar.Mode.CLASSIC, new AvatarUi$$ExternalSyntheticLambda18(act));
        String characterName = Avatar.INSTANCE.characterName(act);
        if (Avatar.INSTANCE.hasCharacter(act)) {
            String str2 = characterName;
            if (str2.length() == 0) {
                str2 = "Saved model";
            }
            str = "“" + ((Object) str2) + "” — you spawn as it in every place";
        } else {
            str = "Play as any model or part, in every place you edit";
        }
        playtestAvatar$add(linearLayout, act, objectRef, "Model", "Custom character (model or part)…", str, mode == Avatar.Mode.CHARACTER, new AvatarUi$$ExternalSyntheticLambda19(act, studio));
        TextView text$default = Ui.text$default(Ui.INSTANCE, act, "Whether your avatar is R6 or R15 in a playtest follows each place's Game Settings → Avatar, like on Roblox.", 11.5f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default.setSingleLine(false);
        text$default.setPadding(INSTANCE.dp(act, 2.0f), INSTANCE.dp(act, 6.0f), 0, INSTANCE.dp(act, 4.0f));
        linearLayout.addView(text$default);
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(act).setTitle("Playtest Avatar");
        ScrollView scrollView = new ScrollView(act);
        scrollView.addView(linearLayout);
        AlertDialog.Builder negativeButton = title.setView(scrollView).setNegativeButton("Close", (DialogInterface.OnClickListener) null);
        if (studio != null) {
            negativeButton.setNeutralButton("Game Settings…", new AvatarUi$$ExternalSyntheticLambda20(act, studio));
        }
        objectRef.element = negativeButton.show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
    
        if ((r2.getCharacter() == null) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void rigBuilder(android.app.Activity r19, com.exampletest.mobilestudiotest.core.Studio r20) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.AvatarUi.rigBuilder(android.app.Activity, com.exampletest.mobilestudiotest.core.Studio):void");
    }

    public final void syncFromCloud(Activity act, Studio studio, CloudPlace cloud) {
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(studio, "studio");
        Intrinsics.checkNotNullParameter(cloud, "cloud");
        if (cloud.getUniverseId() == 0 || RobloxApi.INSTANCE.isGuest(act)) {
            return;
        }
        net.execute(new AvatarUi$$ExternalSyntheticLambda4(act.getApplicationContext(), cloud, studio));
    }
}
