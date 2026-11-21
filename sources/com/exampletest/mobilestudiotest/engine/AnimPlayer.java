package com.exampletest.mobilestudiotest.engine;

import com.exampletest.mobilestudiotest.model.CFrame;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: KeyframeAnim.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0018\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u000eJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u000eJ\u0006\u0010 \u001a\u00020\u0016R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006#"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/AnimPlayer;", "", "<init>", "()V", "tracks", "Ljava/util/ArrayList;", "Lcom/exampletest/mobilestudiotest/engine/AnimPlayer$Track;", "Lkotlin/collections/ArrayList;", "getTracks", "()Ljava/util/ArrayList;", "play", "clip", "Lcom/exampletest/mobilestudiotest/engine/AnimClip;", "tag", "", "fade", "", "weight", "speed", "priority", "", "stop", "", "t", "stopTag", "step", "dt", "transform", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "joint", "transformOver", "base", "clear", "Companion", "Track", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AnimPlayer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ArrayList<Track> tracks = new ArrayList<>();

    /* compiled from: KeyframeAnim.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/AnimPlayer$Companion;", "", "<init>", "()V", "rank", "", "v", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int rank(int v) {
            if (v >= 1000) {
                return -1;
            }
            return v;
        }
    }

    /* compiled from: KeyframeAnim.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u001a\u0010!\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001a\u0010-\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R\u001a\u00100\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R\u0011\u00103\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b4\u0010'¨\u00065"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/AnimPlayer$Track;", "", "clip", "Lcom/exampletest/mobilestudiotest/engine/AnimClip;", "tag", "", "priority", "", "<init>", "(Lcom/exampletest/mobilestudiotest/engine/AnimClip;Ljava/lang/String;I)V", "getClip", "()Lcom/exampletest/mobilestudiotest/engine/AnimClip;", "getTag", "()Ljava/lang/String;", "getPriority", "()I", "setPriority", "(I)V", "time", "", "getTime", "()F", "setTime", "(F)V", "speed", "getSpeed", "setSpeed", "weight", "getWeight", "setWeight", "targetWeight", "getTargetWeight", "setTargetWeight", "fadeRate", "getFadeRate", "setFadeRate", "stopping", "", "getStopping", "()Z", "setStopping", "(Z)V", "looped", "getLooped", "setLooped", "loops", "getLoops", "setLoops", "ended", "getEnded", "setEnded", "playing", "getPlaying", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Track {
        private final AnimClip clip;
        private boolean ended;
        private float fadeRate;
        private boolean looped;
        private int loops;
        private int priority;
        private float speed;
        private boolean stopping;
        private final String tag;
        private float targetWeight;
        private float time;
        private float weight;

        public Track(AnimClip clip, String tag, int i) {
            Intrinsics.checkNotNullParameter(clip, "clip");
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.clip = clip;
            this.tag = tag;
            this.priority = i;
            this.speed = 1.0f;
            this.targetWeight = 1.0f;
            this.fadeRate = 10.0f;
            this.looped = this.clip.getLooped();
        }

        public final AnimClip getClip() {
            return this.clip;
        }

        public final boolean getEnded() {
            return this.ended;
        }

        public final float getFadeRate() {
            return this.fadeRate;
        }

        public final boolean getLooped() {
            return this.looped;
        }

        public final int getLoops() {
            return this.loops;
        }

        public final boolean getPlaying() {
            return (this.stopping || this.ended) ? false : true;
        }

        public final int getPriority() {
            return this.priority;
        }

        public final float getSpeed() {
            return this.speed;
        }

        public final boolean getStopping() {
            return this.stopping;
        }

        public final String getTag() {
            return this.tag;
        }

        public final float getTargetWeight() {
            return this.targetWeight;
        }

        public final float getTime() {
            return this.time;
        }

        public final float getWeight() {
            return this.weight;
        }

        public final void setEnded(boolean z) {
            this.ended = z;
        }

        public final void setFadeRate(float f) {
            this.fadeRate = f;
        }

        public final void setLooped(boolean z) {
            this.looped = z;
        }

        public final void setLoops(int i) {
            this.loops = i;
        }

        public final void setPriority(int i) {
            this.priority = i;
        }

        public final void setSpeed(float f) {
            this.speed = f;
        }

        public final void setStopping(boolean z) {
            this.stopping = z;
        }

        public final void setTargetWeight(float f) {
            this.targetWeight = f;
        }

        public final void setTime(float f) {
            this.time = f;
        }

        public final void setWeight(float f) {
            this.weight = f;
        }
    }

    public static /* synthetic */ Track play$default(AnimPlayer animPlayer, AnimClip animClip, String str, float f, float f2, float f3, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = 0.1f;
        }
        float f4 = f;
        float f5 = (i2 & 8) != 0 ? 1.0f : f2;
        float f6 = (i2 & 16) != 0 ? 1.0f : f3;
        if ((i2 & 32) != 0) {
            i = animClip.getPriority();
        }
        return animPlayer.play(animClip, str, f4, f5, f6, i);
    }

    public static /* synthetic */ void stop$default(AnimPlayer animPlayer, Track track, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.1f;
        }
        animPlayer.stop(track, f);
    }

    public final void clear() {
        this.tracks.clear();
    }

    public final ArrayList<Track> getTracks() {
        return this.tracks;
    }

    public final Track play(AnimClip clip, String tag, float fade, float weight, float speed, int priority) {
        Intrinsics.checkNotNullParameter(clip, "clip");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Track track = new Track(clip, tag, priority);
        track.setTargetWeight(weight);
        track.setSpeed(speed);
        track.setFadeRate(fade <= 0.001f ? 1000.0f : 1.0f / fade);
        if (fade <= 0.001f) {
            track.setWeight(weight);
        }
        this.tracks.add(track);
        return track;
    }

    public final void step(float dt) {
        Iterator<Track> it = this.tracks.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Track next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            Track track = next;
            if (!track.getEnded() || track.getLooped()) {
                track.setTime(track.getTime() + (track.getSpeed() * dt));
                float length = track.getClip().getLength();
                float f = 0.0f;
                if (length <= 0.0f || track.getTime() < length) {
                    if (track.getTime() < 0.0f) {
                        if (track.getLooped() && length > 0.0f) {
                            f = (track.getTime() % length) + length;
                        }
                        track.setTime(f);
                    }
                } else if (track.getLooped()) {
                    track.setTime(track.getTime() % length);
                    track.setLoops(track.getLoops() + 1);
                } else {
                    track.setTime(length);
                    track.setEnded(true);
                }
            }
            track.setWeight(track.getWeight() + ((track.getTargetWeight() - track.getWeight()) * RangesKt.coerceAtMost(track.getFadeRate() * dt, 1.0f)));
            if (Math.abs(track.getWeight() - track.getTargetWeight()) < 0.002f) {
                track.setWeight(track.getTargetWeight());
            }
            if (track.getStopping() && track.getWeight() <= 0.001f) {
                it.remove();
            }
        }
    }

    public final void stop(Track t, float fade) {
        Intrinsics.checkNotNullParameter(t, "t");
        t.setStopping(true);
        t.setTargetWeight(0.0f);
        t.setFadeRate(fade <= 0.001f ? 1000.0f : 1.0f / fade);
    }

    public final void stopTag(String tag, float fade) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Iterator<Track> it = this.tracks.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Track next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            Track track = next;
            if (Intrinsics.areEqual(track.getTag(), tag) && !track.getStopping()) {
                stop(track, fade);
            }
        }
    }

    public final CFrame transform(String joint) {
        Intrinsics.checkNotNullParameter(joint, "joint");
        return transformOver(null, joint);
    }

    public final CFrame transformOver(CFrame base, String joint) {
        CFrame sample;
        Intrinsics.checkNotNullParameter(joint, "joint");
        if (this.tracks.isEmpty()) {
            return base;
        }
        CFrame cFrame = base;
        ArrayList<Track> arrayList = this.tracks;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(((Track) it.next()).getPriority()));
        }
        Iterator it2 = CollectionsKt.sorted(CollectionsKt.distinct(arrayList2)).iterator();
        while (it2.hasNext()) {
            int intValue = ((Number) it2.next()).intValue();
            CFrame cFrame2 = null;
            float f = 0.0f;
            Iterator<Track> it3 = this.tracks.iterator();
            Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
            while (it3.hasNext()) {
                Track next = it3.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                Track track = next;
                if (track.getPriority() == intValue && track.getWeight() > 5.0E-4f && (sample = track.getClip().sample(joint, track.getTime())) != null) {
                    f += track.getWeight();
                    cFrame2 = cFrame2 == null ? sample : Quat.INSTANCE.lerp(cFrame2, sample, track.getWeight() / f);
                }
            }
            if (cFrame2 != null) {
                cFrame = Quat.INSTANCE.lerp(cFrame == null ? CFrame.INSTANCE.getIDENTITY() : cFrame, cFrame2, RangesKt.coerceAtMost(f, 1.0f));
            }
        }
        return cFrame;
    }
}
