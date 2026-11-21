package com.exampletest.mobilestudiotest.engine;

import com.exampletest.mobilestudiotest.core.OutputLog;
import com.exampletest.mobilestudiotest.engine.AnimPlayer;
import com.exampletest.mobilestudiotest.model.CFrame;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: KeyframeAnim.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\nH\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#H\u0002J8\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\n2\u0006\u0010*\u001a\u00020#J\u0010\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006/"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/DefaultAnimate;", "", "r15", "", "<init>", "(Z)V", "player", "Lcom/exampletest/mobilestudiotest/engine/AnimPlayer;", "sets", "", "", "", "Lcom/exampletest/mobilestudiotest/engine/DefaultAnimate$Entry;", "rnd", "Ljava/util/Random;", "current", "currentTracks", "Ljava/util/ArrayList;", "Lcom/exampletest/mobilestudiotest/engine/AnimPlayer$Track;", "Lkotlin/collections/ArrayList;", "toolTrack", "emoteTrack", "emoteName", "idleLoops", "", "reported", "ready", "getReady", "()Z", "pick", "Lcom/exampletest/mobilestudiotest/engine/AnimClip;", "name", "playCore", "", "fade", "", "step", "dt", "pose", "speed", "tool", "emote", "jumpAnimTime", "transform", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "part1Name", "Entry", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DefaultAnimate {
    private String current;
    private ArrayList<AnimPlayer.Track> currentTracks;
    private String emoteName;
    private AnimPlayer.Track emoteTrack;
    private int idleLoops;
    private final AnimPlayer player = new AnimPlayer();
    private final boolean r15;
    private boolean reported;
    private final Random rnd;
    private final Map<String, List<Entry>> sets;
    private AnimPlayer.Track toolTrack;

    /* compiled from: KeyframeAnim.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/DefaultAnimate$Entry;", "", "id", "", "weight", "", "<init>", "(JI)V", "getId", "()J", "getWeight", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    private static final /* data */ class Entry {
        private final long id;
        private final int weight;

        public Entry(long j, int i) {
            this.id = j;
            this.weight = i;
        }

        public static /* synthetic */ Entry copy$default(Entry entry, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = entry.id;
            }
            if ((i2 & 2) != 0) {
                i = entry.weight;
            }
            return entry.copy(j, i);
        }

        /* renamed from: component1, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final int getWeight() {
            return this.weight;
        }

        public final Entry copy(long id, int weight) {
            return new Entry(id, weight);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) other;
            return this.id == entry.id && this.weight == entry.weight;
        }

        public final long getId() {
            return this.id;
        }

        public final int getWeight() {
            return this.weight;
        }

        public int hashCode() {
            return (Long.hashCode(this.id) * 31) + Integer.hashCode(this.weight);
        }

        public String toString() {
            return "Entry(id=" + this.id + ", weight=" + this.weight + ")";
        }
    }

    public DefaultAnimate(boolean z) {
        this.r15 = z;
        this.sets = this.r15 ? MapsKt.mapOf(TuplesKt.to("idle", CollectionsKt.listOf((Object[]) new Entry[]{new Entry(507766666L, 9), new Entry(507766951L, 1)})), TuplesKt.to("walk", CollectionsKt.listOf(new Entry(913402848L, 10))), TuplesKt.to("run", CollectionsKt.listOf(new Entry(913376220L, 10))), TuplesKt.to("jump", CollectionsKt.listOf(new Entry(507765000L, 10))), TuplesKt.to("fall", CollectionsKt.listOf(new Entry(507767968L, 10))), TuplesKt.to("climb", CollectionsKt.listOf(new Entry(507765644L, 10))), TuplesKt.to("sit", CollectionsKt.listOf(new Entry(2506281703L, 10))), TuplesKt.to("toolnone", CollectionsKt.listOf(new Entry(507768375L, 10))), TuplesKt.to("wave", CollectionsKt.listOf(new Entry(507770239L, 10))), TuplesKt.to("point", CollectionsKt.listOf(new Entry(507770453L, 10))), TuplesKt.to("dance", CollectionsKt.listOf((Object[]) new Entry[]{new Entry(507771019L, 10), new Entry(507771955L, 10), new Entry(507772104L, 10)})), TuplesKt.to("dance2", CollectionsKt.listOf((Object[]) new Entry[]{new Entry(507776043L, 10), new Entry(507776720L, 10), new Entry(507776879L, 10)})), TuplesKt.to("dance3", CollectionsKt.listOf((Object[]) new Entry[]{new Entry(507777268L, 10), new Entry(507777451L, 10), new Entry(507777623L, 10)})), TuplesKt.to("laugh", CollectionsKt.listOf(new Entry(507770818L, 10))), TuplesKt.to("cheer", CollectionsKt.listOf(new Entry(507770677L, 10)))) : MapsKt.mapOf(TuplesKt.to("idle", CollectionsKt.listOf((Object[]) new Entry[]{new Entry(180435571L, 9), new Entry(180435792L, 1)})), TuplesKt.to("walk", CollectionsKt.listOf(new Entry(180426354L, 10))), TuplesKt.to("run", CollectionsKt.listOf(new Entry(180426354L, 10))), TuplesKt.to("jump", CollectionsKt.listOf(new Entry(125750702L, 10))), TuplesKt.to("fall", CollectionsKt.listOf(new Entry(180436148L, 10))), TuplesKt.to("climb", CollectionsKt.listOf(new Entry(180436334L, 10))), TuplesKt.to("sit", CollectionsKt.listOf(new Entry(178130996L, 10))), TuplesKt.to("toolnone", CollectionsKt.listOf(new Entry(182393478L, 10))), TuplesKt.to("wave", CollectionsKt.listOf(new Entry(128777973L, 10))), TuplesKt.to("point", CollectionsKt.listOf(new Entry(128853357L, 10))), TuplesKt.to("dance", CollectionsKt.listOf((Object[]) new Entry[]{new Entry(182435998L, 10), new Entry(182491037L, 10), new Entry(182491065L, 10)})), TuplesKt.to("dance2", CollectionsKt.listOf((Object[]) new Entry[]{new Entry(182436842L, 10), new Entry(182491248L, 10), new Entry(182491277L, 10)})), TuplesKt.to("dance3", CollectionsKt.listOf((Object[]) new Entry[]{new Entry(182436935L, 10), new Entry(182491368L, 10), new Entry(182491423L, 10)})), TuplesKt.to("laugh", CollectionsKt.listOf(new Entry(129423131L, 10))), TuplesKt.to("cheer", CollectionsKt.listOf(new Entry(129423030L, 10))));
        this.rnd = new Random();
        this.current = "";
        this.currentTracks = new ArrayList<>();
        Iterator<List<Entry>> it = this.sets.values().iterator();
        while (it.hasNext()) {
            Iterator<Entry> it2 = it.next().iterator();
            while (it2.hasNext()) {
                AnimLibrary.INSTANCE.get(it2.next().getId());
            }
        }
    }

    private final AnimClip pick(String name) {
        List<Entry> list = this.sets.get(name);
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Entry) it.next()).getWeight();
        }
        int nextInt = this.rnd.nextInt(RangesKt.coerceAtLeast(i, 1));
        for (Entry entry : list) {
            nextInt -= entry.getWeight();
            if (nextInt < 0) {
                return AnimLibrary.INSTANCE.get(entry.getId());
            }
        }
        return AnimLibrary.INSTANCE.get(((Entry) CollectionsKt.first((List) list)).getId());
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a3, code lost:
    
        if (r14.equals("jump") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b7, code lost:
    
        r0.setLooped(!kotlin.jvm.internal.Intrinsics.areEqual(r14, "jump"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ac, code lost:
    
        if (r14.equals("fall") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b5, code lost:
    
        if (r14.equals("sit") != false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void playCore(java.lang.String r14, float r15) {
        /*
            r13 = this;
            java.lang.String r0 = r13.current
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r14, r0)
            if (r0 == 0) goto L9
            return
        L9:
            java.util.ArrayList<com.exampletest.mobilestudiotest.engine.AnimPlayer$Track> r0 = r13.currentTracks
            java.util.Iterator r0 = r0.iterator()
            java.lang.String r1 = "iterator(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
        L14:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L2c
            java.lang.Object r1 = r0.next()
            java.lang.String r3 = "next(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            com.exampletest.mobilestudiotest.engine.AnimPlayer$Track r1 = (com.exampletest.mobilestudiotest.engine.AnimPlayer.Track) r1
            com.exampletest.mobilestudiotest.engine.AnimPlayer r3 = r13.player
            r7 = r15
            r3.stop(r1, r15)
            goto L14
        L2c:
            r7 = r15
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r13.currentTracks = r0
            r13.current = r14
            boolean r0 = r13.r15
            if (r0 == 0) goto L7c
            java.lang.String r0 = "walk"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r14, r0)
            if (r1 == 0) goto L7c
            com.exampletest.mobilestudiotest.engine.AnimClip r5 = r13.pick(r0)
            if (r5 == 0) goto L5c
            r0 = 0
            java.util.ArrayList<com.exampletest.mobilestudiotest.engine.AnimPlayer$Track> r1 = r13.currentTracks
            com.exampletest.mobilestudiotest.engine.AnimPlayer r4 = r13.player
            r11 = 24
            r12 = 0
            java.lang.String r6 = "walk"
            r8 = 0
            r9 = 0
            r10 = 0
            com.exampletest.mobilestudiotest.engine.AnimPlayer$Track r3 = com.exampletest.mobilestudiotest.engine.AnimPlayer.play$default(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r1.add(r3)
        L5c:
            java.lang.String r0 = "run"
            com.exampletest.mobilestudiotest.engine.AnimClip r5 = r13.pick(r0)
            if (r5 == 0) goto L7b
            r0 = 0
            java.util.ArrayList<com.exampletest.mobilestudiotest.engine.AnimPlayer$Track> r1 = r13.currentTracks
            com.exampletest.mobilestudiotest.engine.AnimPlayer r4 = r13.player
            r11 = 16
            r12 = 0
            java.lang.String r6 = "run"
            r8 = 953267991(0x38d1b717, float:1.0E-4)
            r9 = 0
            r10 = 0
            r7 = r15
            com.exampletest.mobilestudiotest.engine.AnimPlayer$Track r3 = com.exampletest.mobilestudiotest.engine.AnimPlayer.play$default(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r1.add(r3)
        L7b:
            return
        L7c:
            com.exampletest.mobilestudiotest.engine.AnimClip r1 = r13.pick(r14)
            if (r1 != 0) goto L83
            return
        L83:
            java.util.ArrayList<com.exampletest.mobilestudiotest.engine.AnimPlayer$Track> r9 = r13.currentTracks
            com.exampletest.mobilestudiotest.engine.AnimPlayer r0 = r13.player
            r7 = 24
            r8 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r2 = r14
            r3 = r15
            com.exampletest.mobilestudiotest.engine.AnimPlayer$Track r0 = com.exampletest.mobilestudiotest.engine.AnimPlayer.play$default(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r3 = r0
            r4 = 0
            int r5 = r14.hashCode()
            java.lang.String r6 = "jump"
            switch(r5) {
                case 113886: goto Laf;
                case 3135355: goto La6;
                case 3273774: goto L9f;
                default: goto L9e;
            }
        L9e:
            goto Lc0
        L9f:
            boolean r5 = r14.equals(r6)
            if (r5 != 0) goto Lb7
            goto Lc0
        La6:
            java.lang.String r5 = "fall"
            boolean r5 = r14.equals(r5)
            if (r5 != 0) goto Lb7
            goto Lc0
        Laf:
            java.lang.String r5 = "sit"
            boolean r5 = r14.equals(r5)
            if (r5 == 0) goto Lc0
        Lb7:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r14, r6)
            r5 = r5 ^ 1
            r3.setLooped(r5)
        Lc0:
            r9.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.engine.DefaultAnimate.playCore(java.lang.String, float):void");
    }

    public final boolean getReady() {
        boolean z = true;
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"idle", "walk", "jump", "fall"});
        if ((listOf instanceof Collection) && listOf.isEmpty()) {
            return true;
        }
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            List<Entry> list = this.sets.get((String) it.next());
            Intrinsics.checkNotNull(list);
            List<Entry> list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = true;
                        break;
                    }
                    if (!(AnimLibrary.INSTANCE.get(((Entry) it2.next()).getId()) != null)) {
                        z = false;
                        break;
                    }
                }
            }
            if (!z) {
                return false;
            }
            z = true;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void step(float dt, String pose, float speed, boolean tool, String emote, float jumpAnimTime) {
        AnimClip pick;
        AnimPlayer.Track track;
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(pose, "pose");
        if (getReady()) {
            if (!this.reported) {
                this.reported = true;
                OutputLog.INSTANCE.info("Character animations: using Roblox's default " + (this.r15 ? "R15" : "R6") + " animations");
            }
            switch (pose.hashCode()) {
                case -1822467708:
                    if (pose.equals("Seated")) {
                        playCore("sit", 0.5f);
                        break;
                    }
                    playCore("idle", 0.2f);
                    break;
                case -1474121689:
                    if (pose.equals("FreeFall")) {
                        if (jumpAnimTime <= 0.0f) {
                            playCore("fall", this.r15 ? 0.2f : 0.3f);
                            break;
                        }
                    }
                    playCore("idle", 0.2f);
                    break;
                case -1079530081:
                    if (pose.equals("Running")) {
                        if (speed <= 0.75f) {
                            playCore("idle", 0.2f);
                            break;
                        } else {
                            playCore("walk", 0.2f);
                            break;
                        }
                    }
                    playCore("idle", 0.2f);
                    break;
                case 409511124:
                    if (pose.equals("Jumping")) {
                        playCore("jump", 0.1f);
                        break;
                    }
                    playCore("idle", 0.2f);
                    break;
                case 980073773:
                    if (pose.equals("Climbing")) {
                        playCore("climb", 0.1f);
                        break;
                    }
                    playCore("idle", 0.2f);
                    break;
                default:
                    playCore("idle", 0.2f);
                    break;
            }
            String str = this.current;
            AnimPlayer.Track track2 = null;
            switch (str.hashCode()) {
                case 3227604:
                    if (str.equals("idle") && (track = (AnimPlayer.Track) CollectionsKt.firstOrNull((List) this.currentTracks)) != null && track.getLoops() > this.idleLoops) {
                        this.idleLoops = track.getLoops();
                        AnimClip pick2 = pick("idle");
                        if (pick2 != null && pick2 != track.getClip()) {
                            this.player.stop(track, 0.2f);
                            this.currentTracks = CollectionsKt.arrayListOf(AnimPlayer.play$default(this.player, pick2, "idle", 0.2f, 0.0f, 0.0f, 0, 24, null));
                            this.idleLoops = 0;
                            break;
                        }
                    }
                    break;
                case 3641801:
                    if (str.equals("walk")) {
                        if (!this.r15) {
                            Iterator<T> it = this.currentTracks.iterator();
                            while (it.hasNext()) {
                                ((AnimPlayer.Track) it.next()).setSpeed(speed / 14.5f);
                            }
                            break;
                        } else {
                            float f = (speed / 16.0f) * 1.25f;
                            Iterator<T> it2 = this.currentTracks.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    obj = it2.next();
                                    if (Intrinsics.areEqual(((AnimPlayer.Track) obj).getTag(), "walk")) {
                                    }
                                } else {
                                    obj = null;
                                }
                            }
                            AnimPlayer.Track track3 = (AnimPlayer.Track) obj;
                            Iterator<T> it3 = this.currentTracks.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    obj2 = it3.next();
                                    if (Intrinsics.areEqual(((AnimPlayer.Track) obj2).getTag(), "run")) {
                                    }
                                } else {
                                    obj2 = null;
                                }
                            }
                            AnimPlayer.Track track4 = (AnimPlayer.Track) obj2;
                            float f2 = 1.0E-4f;
                            float f3 = 1.0E-4f;
                            if (f <= 0.5f) {
                                f2 = 1.0f;
                            } else if (f < 1.0f) {
                                float f4 = (f - 0.5f) / 0.5f;
                                f2 = 1.0f - f4;
                                f3 = f4;
                            } else {
                                f3 = 1.0f;
                            }
                            if (track3 != null) {
                                track3.setTargetWeight(f2);
                                track3.setSpeed(f / 0.5f);
                            }
                            if (track4 != null) {
                                track4.setTargetWeight(f3);
                                track4.setSpeed(f / 1.0f);
                                break;
                            }
                        }
                    }
                    break;
                case 94750389:
                    if (str.equals("climb")) {
                        Iterator<T> it4 = this.currentTracks.iterator();
                        while (it4.hasNext()) {
                            ((AnimPlayer.Track) it4.next()).setSpeed(speed / (this.r15 ? 5.0f : 12.0f));
                        }
                        break;
                    }
                    break;
            }
            if (tool && this.toolTrack == null) {
                AnimClip pick3 = pick("toolnone");
                this.toolTrack = pick3 != null ? AnimPlayer.play$default(this.player, pick3, "toolnone", 0.1f, 0.0f, 0.0f, 1, 24, null) : null;
            } else if (!tool && this.toolTrack != null) {
                AnimPlayer animPlayer = this.player;
                AnimPlayer.Track track5 = this.toolTrack;
                Intrinsics.checkNotNull(track5);
                animPlayer.stop(track5, 0.1f);
                this.toolTrack = null;
            }
            if (!Intrinsics.areEqual(emote, this.emoteName)) {
                AnimPlayer.Track track6 = this.emoteTrack;
                if (track6 != null) {
                    this.player.stop(track6, 0.1f);
                }
                if (emote != null && (pick = pick(emote)) != null) {
                    track2 = AnimPlayer.play$default(this.player, pick, emote, 0.1f, 0.0f, 0.0f, 2, 24, null);
                }
                this.emoteTrack = track2;
                this.emoteName = emote;
            }
            this.player.step(dt);
        }
    }

    public final CFrame transform(String part1Name) {
        Intrinsics.checkNotNullParameter(part1Name, "part1Name");
        if (!getReady()) {
            return null;
        }
        CFrame transform = this.player.transform(part1Name);
        return transform == null ? CFrame.INSTANCE.getIDENTITY() : transform;
    }
}
