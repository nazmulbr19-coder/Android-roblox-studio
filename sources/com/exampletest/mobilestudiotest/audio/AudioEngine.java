package com.exampletest.mobilestudiotest.audio;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import com.exampletest.mobilestudiotest.core.OutputLog;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.net.AssetFetcher;
import com.github.luben.zstd.BuildConfig;
import java.io.File;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: AudioEngine.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003LMNB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u001eJ\"\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020 H\u0002J\u000e\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\rH\u0002J\u0018\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020 H\u0002J8\u0010.\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\r2\u0006\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020 2\u0006\u0010-\u001a\u00020 2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000202H\u0002J\u0010\u00104\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\rH\u0002J\u0010\u00105\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\rH\u0002J\u0006\u00106\u001a\u00020\u0014J\b\u0010B\u001a\u00020\u0014H\u0002J\u0018\u0010C\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\u00102\b\b\u0002\u0010E\u001a\u00020 J\u0018\u00104\u001a\u00020\u00142\u0006\u0010F\u001a\u0002082\u0006\u0010+\u001a\u00020,H\u0002J\u0006\u0010G\u001a\u00020\u0014J\u0006\u0010H\u001a\u00020\u0014J\u0016\u0010I\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\u00102\u0006\u0010J\u001a\u00020 J\u0006\u0010K\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u00109\u001a\u0004\u0018\u0001082\b\u00107\u001a\u0004\u0018\u000108@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0010\u0010<\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140?0>¢\u0006\b\n\u0000\u001a\u0004\b@\u0010A¨\u0006O"}, d2 = {"Lcom/exampletest/mobilestudiotest/audio/AudioEngine;", "", "<init>", "()V", "thread", "Landroid/os/HandlerThread;", "h", "Landroid/os/Handler;", "MAX_VOICES", "", "voices", "Ljava/util/IdentityHashMap;", "Lcom/exampletest/mobilestudiotest/model/Instance;", "Lcom/exampletest/mobilestudiotest/audio/AudioEngine$Voice;", "missing", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "onLoaded", "Lkotlin/Function1;", "", "getOnLoaded", "()Lkotlin/jvm/functions/Function1;", "setOnLoaded", "(Lkotlin/jvm/functions/Function1;)V", "onEnded", "getOnEnded", "setOnEnded", "soundId", "s", "(Lcom/exampletest/mobilestudiotest/model/Instance;)Ljava/lang/Long;", "num", "", "i", "k", "", "d", "update", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "create", "v", "setSpeed", "mp", "Landroid/media/MediaPlayer;", "speed", "apply", "l", "r", "loop", "", "restart", "tick", BuildConfig.BUILD_TYPE, "stopAll", "value", "Lcom/exampletest/mobilestudiotest/audio/AudioEngine$Preview;", "preview", "getPreview", "()Lcom/exampletest/mobilestudiotest/audio/AudioEngine$Preview;", "previewPlayer", "previewListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function0;", "getPreviewListeners", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "notifyPreview", "togglePreview", "id", "volume", "p", "pausePreview", "resumePreview", "seekPreview", "seconds", "stopPreview", "Voice", "PreviewState", "Preview", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AudioEngine {
    public static final AudioEngine INSTANCE = new AudioEngine();
    private static final int MAX_VOICES = 28;
    private static final Handler h;
    private static final HashSet<Long> missing;
    private static Function1<? super Instance, Unit> onEnded;
    private static Function1<? super Instance, Unit> onLoaded;
    private static volatile Preview preview;
    private static final CopyOnWriteArrayList<Function0<Unit>> previewListeners;
    private static MediaPlayer previewPlayer;
    private static final HandlerThread thread;
    private static final IdentityHashMap<Instance, Voice> voices;

    /* compiled from: AudioEngine.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/exampletest/mobilestudiotest/audio/AudioEngine$Preview;", "", "id", "", "<init>", "(J)V", "getId", "()J", "state", "Lcom/exampletest/mobilestudiotest/audio/AudioEngine$PreviewState;", "getState", "()Lcom/exampletest/mobilestudiotest/audio/AudioEngine$PreviewState;", "setState", "(Lcom/exampletest/mobilestudiotest/audio/AudioEngine$PreviewState;)V", "position", "", "getPosition", "()F", "setPosition", "(F)V", "length", "getLength", "setLength", "error", "", "getError", "()Ljava/lang/String;", "setError", "(Ljava/lang/String;)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Preview {
        private volatile String error;
        private final long id;
        private volatile float length;
        private volatile float position;
        private volatile PreviewState state = PreviewState.LOADING;

        public Preview(long j) {
            this.id = j;
        }

        public final String getError() {
            return this.error;
        }

        public final long getId() {
            return this.id;
        }

        public final float getLength() {
            return this.length;
        }

        public final float getPosition() {
            return this.position;
        }

        public final PreviewState getState() {
            return this.state;
        }

        public final void setError(String str) {
            this.error = str;
        }

        public final void setLength(float f) {
            this.length = f;
        }

        public final void setPosition(float f) {
            this.position = f;
        }

        public final void setState(PreviewState previewState) {
            Intrinsics.checkNotNullParameter(previewState, "<set-?>");
            this.state = previewState;
        }
    }

    /* compiled from: AudioEngine.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/exampletest/mobilestudiotest/audio/AudioEngine$PreviewState;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "PLAYING", "PAUSED", "STOPPED", "ERROR", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public enum PreviewState {
        LOADING,
        PLAYING,
        PAUSED,
        STOPPED,
        ERROR;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<PreviewState> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AudioEngine.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u0006\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001a\u0010!\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001e\u0010$\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010*\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R\u001a\u0010-\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u001a\u00106\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0015\"\u0004\b8\u0010\u0017R\u001a\u00109\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0015\"\u0004\b;\u0010\u0017R\u001a\u0010<\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0015\"\u0004\b>\u0010\u0017R\u001a\u0010?\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00100\"\u0004\bA\u00102R\u001a\u0010B\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00100\"\u0004\bD\u00102R\u001a\u0010E\u001a\u00020FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006K"}, d2 = {"Lcom/exampletest/mobilestudiotest/audio/AudioEngine$Voice;", "", "sound", "Lcom/exampletest/mobilestudiotest/model/Instance;", "id", "", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Instance;J)V", "getSound", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "getId", "()J", "mp", "Landroid/media/MediaPlayer;", "getMp", "()Landroid/media/MediaPlayer;", "setMp", "(Landroid/media/MediaPlayer;)V", "prepared", "", "getPrepared", "()Z", "setPrepared", "(Z)V", "lastL", "", "getLastL", "()F", "setLastL", "(F)V", "lastR", "getLastR", "setLastR", "lastSpeed", "getLastSpeed", "setLastSpeed", "lastLoop", "getLastLoop", "()Ljava/lang/Boolean;", "setLastLoop", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "wantPlay", "getWantPlay", "setWantPlay", "position", "", "getPosition", "()D", "setPosition", "(D)V", "length", "getLength", "setLength", "ended", "getEnded", "setEnded", "loadedNotified", "getLoadedNotified", "setLoadedNotified", "failed", "getFailed", "setFailed", "lastPushedPos", "getLastPushedPos", "setLastPushedPos", "seek", "getSeek", "setSeek", "seq", "", "getSeq", "()I", "setSeq", "(I)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Voice {
        private volatile boolean ended;
        private volatile boolean failed;
        private final long id;
        private float lastL;
        private Boolean lastLoop;
        private double lastPushedPos;
        private float lastR;
        private float lastSpeed;
        private volatile double length;
        private volatile boolean loadedNotified;
        private MediaPlayer mp;
        private volatile double position;
        private boolean prepared;
        private double seek;
        private int seq;
        private final Instance sound;
        private boolean wantPlay;

        public Voice(Instance sound, long j) {
            Intrinsics.checkNotNullParameter(sound, "sound");
            this.sound = sound;
            this.id = j;
            this.lastL = -1.0f;
            this.lastR = -1.0f;
            this.lastSpeed = -1.0f;
            this.seek = -1.0d;
            Object obj = this.sound.getAttributes().get("__playSeq");
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            this.seq = num != null ? num.intValue() : 0;
        }

        public final boolean getEnded() {
            return this.ended;
        }

        public final boolean getFailed() {
            return this.failed;
        }

        public final long getId() {
            return this.id;
        }

        public final float getLastL() {
            return this.lastL;
        }

        public final Boolean getLastLoop() {
            return this.lastLoop;
        }

        public final double getLastPushedPos() {
            return this.lastPushedPos;
        }

        public final float getLastR() {
            return this.lastR;
        }

        public final float getLastSpeed() {
            return this.lastSpeed;
        }

        public final double getLength() {
            return this.length;
        }

        public final boolean getLoadedNotified() {
            return this.loadedNotified;
        }

        public final MediaPlayer getMp() {
            return this.mp;
        }

        public final double getPosition() {
            return this.position;
        }

        public final boolean getPrepared() {
            return this.prepared;
        }

        public final double getSeek() {
            return this.seek;
        }

        public final int getSeq() {
            return this.seq;
        }

        public final Instance getSound() {
            return this.sound;
        }

        public final boolean getWantPlay() {
            return this.wantPlay;
        }

        public final void setEnded(boolean z) {
            this.ended = z;
        }

        public final void setFailed(boolean z) {
            this.failed = z;
        }

        public final void setLastL(float f) {
            this.lastL = f;
        }

        public final void setLastLoop(Boolean bool) {
            this.lastLoop = bool;
        }

        public final void setLastPushedPos(double d) {
            this.lastPushedPos = d;
        }

        public final void setLastR(float f) {
            this.lastR = f;
        }

        public final void setLastSpeed(float f) {
            this.lastSpeed = f;
        }

        public final void setLength(double d) {
            this.length = d;
        }

        public final void setLoadedNotified(boolean z) {
            this.loadedNotified = z;
        }

        public final void setMp(MediaPlayer mediaPlayer) {
            this.mp = mediaPlayer;
        }

        public final void setPosition(double d) {
            this.position = d;
        }

        public final void setPrepared(boolean z) {
            this.prepared = z;
        }

        public final void setSeek(double d) {
            this.seek = d;
        }

        public final void setSeq(int i) {
            this.seq = i;
        }

        public final void setWantPlay(boolean z) {
            this.wantPlay = z;
        }
    }

    /* compiled from: AudioEngine.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PreviewState.values().length];
            try {
                iArr[PreviewState.PLAYING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PreviewState.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PreviewState.STOPPED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PreviewState.LOADING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[PreviewState.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("audio");
        handlerThread.start();
        thread = handlerThread;
        h = new Handler(thread.getLooper());
        voices = new IdentityHashMap<>();
        missing = new HashSet<>();
        previewListeners = new CopyOnWriteArrayList<>();
    }

    private AudioEngine() {
    }

    public static final /* synthetic */ Handler access$getH$p() {
        return h;
    }

    public static final /* synthetic */ MediaPlayer access$getPreviewPlayer$p() {
        return previewPlayer;
    }

    public static final /* synthetic */ void access$notifyPreview(AudioEngine audioEngine) {
        audioEngine.notifyPreview();
    }

    private final void apply(Voice v, float l, float r, float speed, boolean loop, boolean restart) {
        MediaPlayer mp = v.getMp();
        if (mp != null && v.getPrepared()) {
            try {
                mp.setVolume(l, r);
                mp.setLooping(loop);
                setSpeed(mp, speed);
                if (restart || !mp.isPlaying()) {
                    mp.start();
                    tick(v);
                }
            } catch (Exception e) {
            }
        }
    }

    private final void create(Voice v) {
        h.post(new AudioEngine$$ExternalSyntheticLambda12(v));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void create$lambda$12(Voice voice) {
        try {
            String cacheFile = AssetFetcher.INSTANCE.cacheFile(voice.getId());
            if (cacheFile == null) {
                return;
            }
            File file = new File(cacheFile);
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(14).setContentType(4).build());
            mediaPlayer.setDataSource(file.getPath());
            mediaPlayer.setOnPreparedListener(new AudioEngine$$ExternalSyntheticLambda13(voice));
            mediaPlayer.setOnCompletionListener(new AudioEngine$$ExternalSyntheticLambda14(voice));
            mediaPlayer.setOnErrorListener(new AudioEngine$$ExternalSyntheticLambda15(voice));
            voice.setMp(mediaPlayer);
            mediaPlayer.prepareAsync();
        } catch (Exception e) {
            voice.setFailed(true);
            OutputLog.INSTANCE.warn("Sound rbxassetid://" + voice.getId() + ": " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void create$lambda$12$lambda$10(Voice voice, MediaPlayer mediaPlayer) {
        if (mediaPlayer.isLooping()) {
            return;
        }
        voice.setEnded(true);
        voice.setPosition(0.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean create$lambda$12$lambda$11(Voice voice, MediaPlayer mediaPlayer, int i, int i2) {
        voice.setFailed(true);
        OutputLog.INSTANCE.warn("Sound rbxassetid://" + voice.getId() + " can't be played on this device (" + i + "/" + i2 + ")");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void create$lambda$12$lambda$9(Voice voice, MediaPlayer mediaPlayer) {
        voice.setPrepared(true);
        voice.setLength(mediaPlayer.getDuration() / 1000.0d);
        if (voice.getSeek() > 0.0d) {
            try {
                mediaPlayer.seekTo((int) (voice.getSeek() * 1000.0d));
            } catch (Exception e) {
            }
        }
        if (voice.getWantPlay()) {
            mediaPlayer.setVolume(RangesKt.coerceAtLeast(voice.getLastL(), 0.0f), RangesKt.coerceAtLeast(voice.getLastR(), 0.0f));
            mediaPlayer.setLooping(Intrinsics.areEqual((Object) voice.getLastLoop(), (Object) true));
            AudioEngine audioEngine = INSTANCE;
            Intrinsics.checkNotNull(mediaPlayer);
            audioEngine.setSpeed(mediaPlayer, voice.getLastSpeed());
            mediaPlayer.start();
        }
        INSTANCE.tick(voice);
    }

    private final void notifyPreview() {
        Iterator<T> it = previewListeners.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
    }

    private final float num(Instance i, String k, float d) {
        Object obj = i != null ? i.get(k) : null;
        Number number = obj instanceof Number ? (Number) obj : null;
        return number != null ? number.floatValue() : d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void pausePreview$lambda$20(Preview preview2) {
        MediaPlayer mediaPlayer = previewPlayer;
        if (mediaPlayer == null) {
            return;
        }
        AudioEngine audioEngine = INSTANCE;
        if (preview == preview2 && preview2.getState() == PreviewState.PLAYING) {
            try {
                mediaPlayer.pause();
                preview2.setPosition(mediaPlayer.getCurrentPosition() / 1000.0f);
            } catch (Exception e) {
            }
            preview2.setState(PreviewState.PAUSED);
            INSTANCE.notifyPreview();
        }
    }

    private final void release(Voice v) {
        v.setWantPlay(false);
        h.post(new AudioEngine$$ExternalSyntheticLambda8(v));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void release$lambda$13(Voice voice) {
        try {
            MediaPlayer mp = voice.getMp();
            if (mp != null) {
                mp.release();
            }
        } catch (Exception e) {
        }
        voice.setMp(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void resumePreview$lambda$21(Preview preview2) {
        MediaPlayer mediaPlayer = previewPlayer;
        if (mediaPlayer == null) {
            return;
        }
        AudioEngine audioEngine = INSTANCE;
        if (preview != preview2) {
            return;
        }
        try {
            if (preview2.getState() == PreviewState.STOPPED) {
                mediaPlayer.seekTo(0);
                preview2.setPosition(0.0f);
            }
            mediaPlayer.start();
            preview2.setState(PreviewState.PLAYING);
            INSTANCE.notifyPreview();
            INSTANCE.tick(preview2, mediaPlayer);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void seekPreview$lambda$23(Preview preview2, float f) {
        MediaPlayer mediaPlayer = previewPlayer;
        if (mediaPlayer == null) {
            return;
        }
        AudioEngine audioEngine = INSTANCE;
        if (preview != preview2 || preview2.getLength() <= 0.0f) {
            return;
        }
        float coerceIn = RangesKt.coerceIn(f, 0.0f, preview2.getLength());
        try {
            mediaPlayer.seekTo((int) (1000.0f * coerceIn));
            preview2.setPosition(coerceIn);
            if (preview2.getState() == PreviewState.STOPPED) {
                preview2.setState(PreviewState.PAUSED);
            }
            INSTANCE.notifyPreview();
        } catch (Exception e) {
        }
    }

    private final void setSpeed(MediaPlayer mp, float speed) {
        if (speed <= 0.0f || Math.abs(speed - 1.0f) < 0.001f) {
            return;
        }
        try {
            mp.setPlaybackParams(mp.getPlaybackParams().setSpeed(speed).setPitch(speed));
        } catch (Exception e) {
        }
    }

    private final Long soundId(Instance s) {
        return AssetFetcher.INSTANCE.idOf(s.get("SoundId"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void stopPreview$lambda$24() {
        try {
            MediaPlayer mediaPlayer = previewPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        } catch (Exception e) {
        }
        AudioEngine audioEngine = INSTANCE;
        previewPlayer = null;
    }

    private final void tick(Preview p, MediaPlayer mp) {
        h.postDelayed(new AudioEngine$tick$2(p, mp), 150L);
    }

    private final void tick(Voice v) {
        h.postDelayed(new AudioEngine$tick$1(v), 200L);
    }

    public static /* synthetic */ void togglePreview$default(AudioEngine audioEngine, long j, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.5f;
        }
        audioEngine.togglePreview(j, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void togglePreview$lambda$19(long j, Preview preview2, float f) {
        try {
            AssetFetcher.INSTANCE.load(j);
            h.post(new AudioEngine$$ExternalSyntheticLambda9(preview2, j, f));
        } catch (Exception e) {
            preview2.setState(PreviewState.ERROR);
            String message = e.getMessage();
            if (message == null) {
                message = "Couldn't download the audio";
            }
            preview2.setError(message);
            INSTANCE.notifyPreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void togglePreview$lambda$19$lambda$18(Preview preview2, long j, float f) {
        AudioEngine audioEngine = INSTANCE;
        if (preview != preview2) {
            return;
        }
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build());
            String cacheFile = AssetFetcher.INSTANCE.cacheFile(j);
            Intrinsics.checkNotNull(cacheFile);
            mediaPlayer.setDataSource(cacheFile);
            mediaPlayer.setOnPreparedListener(new AudioEngine$$ExternalSyntheticLambda1(preview2, f));
            mediaPlayer.setOnCompletionListener(new AudioEngine$$ExternalSyntheticLambda2(preview2));
            mediaPlayer.setOnErrorListener(new AudioEngine$$ExternalSyntheticLambda3(preview2));
            AudioEngine audioEngine2 = INSTANCE;
            previewPlayer = mediaPlayer;
            mediaPlayer.prepareAsync();
        } catch (Exception e) {
            preview2.setState(PreviewState.ERROR);
            preview2.setError(e.getMessage());
            INSTANCE.notifyPreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void togglePreview$lambda$19$lambda$18$lambda$15(Preview preview2, float f, MediaPlayer mediaPlayer) {
        AudioEngine audioEngine = INSTANCE;
        if (preview != preview2) {
            mediaPlayer.release();
            return;
        }
        preview2.setLength(mediaPlayer.getDuration() / 1000.0f);
        float coerceIn = RangesKt.coerceIn(2.0f * f, 0.05f, 1.0f);
        mediaPlayer.setVolume(coerceIn, coerceIn);
        mediaPlayer.start();
        preview2.setState(PreviewState.PLAYING);
        INSTANCE.notifyPreview();
        AudioEngine audioEngine2 = INSTANCE;
        Intrinsics.checkNotNull(mediaPlayer);
        audioEngine2.tick(preview2, mediaPlayer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void togglePreview$lambda$19$lambda$18$lambda$16(Preview preview2, MediaPlayer mediaPlayer) {
        preview2.setState(PreviewState.STOPPED);
        preview2.setPosition(0.0f);
        INSTANCE.notifyPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean togglePreview$lambda$19$lambda$18$lambda$17(Preview preview2, MediaPlayer mediaPlayer, int i, int i2) {
        preview2.setState(PreviewState.ERROR);
        preview2.setError("This audio can't be played on this device");
        INSTANCE.notifyPreview();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void update$lambda$2(Voice voice, boolean z) {
        try {
            MediaPlayer mp = voice.getMp();
            if (mp != null) {
                if (mp.isPlaying()) {
                    mp.pause();
                }
                if (z && voice.getPrepared()) {
                    mp.seekTo(0);
                }
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void update$lambda$6(Voice voice) {
        MediaPlayer mp;
        try {
            if (!voice.getPrepared() || (mp = voice.getMp()) == null) {
                return;
            }
            mp.seekTo(0);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void update$lambda$7(Voice voice, float f, float f2, float f3, boolean z, boolean z2) {
        INSTANCE.apply(voice, f, f2, f3, z, z2);
    }

    public final Function1<Instance, Unit> getOnEnded() {
        return onEnded;
    }

    public final Function1<Instance, Unit> getOnLoaded() {
        return onLoaded;
    }

    public final Preview getPreview() {
        return preview;
    }

    public final CopyOnWriteArrayList<Function0<Unit>> getPreviewListeners() {
        return previewListeners;
    }

    public final void pausePreview() {
        Preview preview2 = preview;
        if (preview2 == null) {
            return;
        }
        h.post(new AudioEngine$$ExternalSyntheticLambda16(preview2));
    }

    public final void resumePreview() {
        Preview preview2 = preview;
        if (preview2 == null) {
            return;
        }
        h.post(new AudioEngine$$ExternalSyntheticLambda11(preview2));
    }

    public final void seekPreview(long id, float seconds) {
        Preview preview2 = preview;
        if (preview2 != null) {
            if (!(preview2.getId() == id)) {
                preview2 = null;
            }
            if (preview2 != null) {
                h.post(new AudioEngine$$ExternalSyntheticLambda0(preview2, seconds));
            }
        }
    }

    public final void setOnEnded(Function1<? super Instance, Unit> function1) {
        onEnded = function1;
    }

    public final void setOnLoaded(Function1<? super Instance, Unit> function1) {
        onLoaded = function1;
    }

    public final void stopAll() {
        for (Voice voice : voices.values()) {
            Intrinsics.checkNotNull(voice);
            release(voice);
        }
        voices.clear();
        missing.clear();
    }

    public final void stopPreview() {
        Preview preview2 = preview;
        preview = null;
        if (preview2 != null) {
            preview2.setState(PreviewState.STOPPED);
        }
        h.post(new AudioEngine$$ExternalSyntheticLambda7());
        notifyPreview();
    }

    public final void togglePreview(long id, float volume) {
        Preview preview2 = preview;
        if (preview2 != null && preview2.getId() == id) {
            switch (WhenMappings.$EnumSwitchMapping$0[preview2.getState().ordinal()]) {
                case 1:
                    pausePreview();
                    return;
                case 2:
                    resumePreview();
                    return;
                case 3:
                    if (preview2.getLength() > 0.0f) {
                        resumePreview();
                        return;
                    }
                    break;
                case 4:
                    stopPreview();
                    return;
                case 5:
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        stopPreview();
        Preview preview3 = new Preview(id);
        preview = preview3;
        notifyPreview();
        new Thread(new AudioEngine$$ExternalSyntheticLambda10(id, preview3, volume)).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x04a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x047a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void update(com.exampletest.mobilestudiotest.core.Studio r39) {
        /*
            Method dump skipped, instructions count: 1380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.audio.AudioEngine.update(com.exampletest.mobilestudiotest.core.Studio):void");
    }
}
