package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import com.exampletest.mobilestudiotest.ui.StartScreen;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen;", method = "groupGames$lambda$150$lambda$144", proto = "(Ljava/util/concurrent/atomic/AtomicReference;ILcom/exampletest/mobilestudiotest/ui/StartScreen;Ljava/util/concurrent/ConcurrentHashMap;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Group;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$GroupList;Ljava/util/concurrent/ConcurrentHashMap$KeySetView;Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/List;Ljava/util/Map;Lkotlin/Pair;Lcom/exampletest/mobilestudiotest/ui/StartScreen$GroupsView;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$$ExternalSyntheticLambda27 implements Runnable {
    public final /* synthetic */ AtomicReference f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ Pair f$10;
    public final /* synthetic */ StartScreen.GroupsView f$11;
    public final /* synthetic */ StartScreen f$2;
    public final /* synthetic */ ConcurrentHashMap f$3;
    public final /* synthetic */ RobloxCloud.Group f$4;
    public final /* synthetic */ RobloxCloud.GroupList f$5;
    public final /* synthetic */ ConcurrentHashMap.KeySetView f$6;
    public final /* synthetic */ AtomicInteger f$7;
    public final /* synthetic */ List f$8;
    public final /* synthetic */ Map f$9;

    public /* synthetic */ StartScreen$$ExternalSyntheticLambda27(AtomicReference atomicReference, int i, StartScreen startScreen, ConcurrentHashMap concurrentHashMap, RobloxCloud.Group group, RobloxCloud.GroupList groupList, ConcurrentHashMap.KeySetView keySetView, AtomicInteger atomicInteger, List list, Map map, Pair pair, StartScreen.GroupsView groupsView) {
        this.f$0 = atomicReference;
        this.f$1 = i;
        this.f$2 = startScreen;
        this.f$3 = concurrentHashMap;
        this.f$4 = group;
        this.f$5 = groupList;
        this.f$6 = keySetView;
        this.f$7 = atomicInteger;
        this.f$8 = list;
        this.f$9 = map;
        this.f$10 = pair;
        this.f$11 = groupsView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StartScreen.groupGames$lambda$150$lambda$144(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11);
    }
}
