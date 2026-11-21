package kotlinx.coroutines.debug.internal;

import _COROUTINE.ArtificialStackFrames;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* compiled from: DebugProbesImpl.kt */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u007fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0002J\r\u0010*\u001a\u00020%H\u0000¢\u0006\u0002\b+J\r\u0010,\u001a\u00020%H\u0000¢\u0006\u0002\b-J\b\u0010.\u001a\u00020%H\u0002J\b\u0010/\u001a\u00020%H\u0002J\u0015\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0000¢\u0006\u0002\b4J9\u00105\u001a\u00020%*\u0002032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020)072\n\u00108\u001a\u00060:j\u0002`92\u0006\u0010;\u001a\u000201H\u0002¢\u0006\u0002\u0010<J9\u0010B\u001a\b\u0012\u0004\u0012\u0002HD0C\"\b\b\u0000\u0010D*\u00020\u00012\u001e\b\u0004\u0010E\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u0002HD0FH\u0082\bJ\u0011\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00010I¢\u0006\u0002\u0010JJ\u000e\u0010K\u001a\u0002012\u0006\u0010L\u001a\u00020MJ\f\u0010N\u001a\u000201*\u00020\u0001H\u0002J\f\u0010O\u001a\b\u0012\u0004\u0012\u00020M0CJ\f\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0CJ\u0010\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020TH\u0001J\u0010\u0010U\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\fH\u0002J\u0010\u0010V\u001a\u00020%2\u0006\u0010S\u001a\u00020TH\u0002J\u001e\u0010W\u001a\u00020%2\u0006\u0010S\u001a\u00020T2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00050CH\u0002J\"\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00050C2\u0006\u0010L\u001a\u00020M2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00050CJ.\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00050C2\u0006\u0010\\\u001a\u0002012\b\u0010]\u001a\u0004\u0018\u00010\t2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00050CH\u0002J=\u0010^\u001a\u000e\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020`0_2\u0006\u0010a\u001a\u00020`2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00050I2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00050CH\u0002¢\u0006\u0002\u0010cJ1\u0010d\u001a\u00020`2\u0006\u0010e\u001a\u00020`2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00050I2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00050CH\u0002¢\u0006\u0002\u0010fJ\u0019\u0010g\u001a\u00020%2\n\u0010h\u001a\u0006\u0012\u0002\b\u00030iH\u0000¢\u0006\u0002\bjJ\u0019\u0010k\u001a\u00020%2\n\u0010h\u001a\u0006\u0012\u0002\b\u00030iH\u0000¢\u0006\u0002\blJ\u001c\u0010m\u001a\u00020%2\n\u0010h\u001a\u0006\u0012\u0002\b\u00030i2\u0006\u0010\\\u001a\u000201H\u0002J\u0018\u0010n\u001a\u00020%2\u0006\u0010h\u001a\u00020(2\u0006\u0010\\\u001a\u000201H\u0002J\u000f\u0010o\u001a\u0004\u0018\u00010(*\u00020(H\u0082\u0010J(\u0010m\u001a\u00020%2\n\u0010p\u001a\u0006\u0012\u0002\b\u00030\f2\n\u0010h\u001a\u0006\u0012\u0002\b\u00030i2\u0006\u0010\\\u001a\u000201H\u0002J\u0016\u0010p\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f*\u0006\u0012\u0002\b\u00030iH\u0002J\u0013\u0010p\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f*\u00020(H\u0082\u0010J'\u0010q\u001a\b\u0012\u0004\u0012\u0002Hr0i\"\u0004\b\u0000\u0010r2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002Hr0iH\u0000¢\u0006\u0002\btJ\u0012\u0010u\u001a\u00020v*\b\u0012\u0004\u0012\u00020\u00050CH\u0002J,\u0010w\u001a\b\u0012\u0004\u0012\u0002Hr0i\"\u0004\b\u0000\u0010r2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002Hr0i2\b\u0010h\u001a\u0004\u0018\u00010vH\u0002J\u0014\u0010x\u001a\u00020%2\n\u0010p\u001a\u0006\u0012\u0002\b\u00030\fH\u0002J%\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00050C\"\b\b\u0000\u0010r*\u00020z2\u0006\u0010{\u001a\u0002HrH\u0002¢\u0006\u0002\u0010|R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\t\u0010\u0012\u001a\u00020\u0013X\u0082\u0004R\u0011\u0010\u0014\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\t\u0010\u0017\u001a\u00020\u0018X\u0082\u0004R\u001a\u0010\u0019\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u001cR\u001c\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010=\u001a\u000201*\u0002038BX\u0082\u0004¢\u0006\f\u0012\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0018\u0010}\u001a\u00020\r*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b}\u0010~¨\u0006\u0080\u0001"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", "", "<init>", "()V", "ARTIFICIAL_FRAME", "Ljava/lang/StackTraceElement;", "dateFormat", "Ljava/text/SimpleDateFormat;", "weakRefCleanerThread", "Ljava/lang/Thread;", "capturedCoroutinesMap", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "", "capturedCoroutines", "", "getCapturedCoroutines", "()Ljava/util/Set;", "installations", "Lkotlinx/atomicfu/AtomicInt;", "isInstalled", "isInstalled$kotlinx_coroutines_debug", "()Z", "sequenceNumber", "Lkotlinx/atomicfu/AtomicLong;", "sanitizeStackTraces", "getSanitizeStackTraces$kotlinx_coroutines_core", "setSanitizeStackTraces$kotlinx_coroutines_core", "(Z)V", "enableCreationStackTraces", "getEnableCreationStackTraces$kotlinx_coroutines_core", "setEnableCreationStackTraces$kotlinx_coroutines_core", "ignoreCoroutinesWithEmptyContext", "getIgnoreCoroutinesWithEmptyContext", "setIgnoreCoroutinesWithEmptyContext", "dynamicAttach", "Lkotlin/Function1;", "", "getDynamicAttach", "callerInfoCache", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "install", "install$kotlinx_coroutines_core", "uninstall", "uninstall$kotlinx_coroutines_core", "startWeakRefCleanerThread", "stopWeakRefCleanerThread", "hierarchyToString", "", "job", "Lkotlinx/coroutines/Job;", "hierarchyToString$kotlinx_coroutines_core", "build", "map", "", "builder", "Lkotlin/text/StringBuilder;", "Ljava/lang/StringBuilder;", "indent", "(Lkotlinx/coroutines/Job;Ljava/util/Map;Ljava/lang/StringBuilder;Ljava/lang/String;)V", "debugString", "getDebugString$annotations", "(Lkotlinx/coroutines/Job;)V", "getDebugString", "(Lkotlinx/coroutines/Job;)Ljava/lang/String;", "dumpCoroutinesInfoImpl", "", "R", "create", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "dumpCoroutinesInfoAsJsonAndReferences", "", "()[Ljava/lang/Object;", "enhanceStackTraceWithThreadDumpAsJson", "info", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "toStringRepr", "dumpCoroutinesInfo", "dumpDebuggerInfo", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "dumpCoroutines", "out", "Ljava/io/PrintStream;", "isFinished", "dumpCoroutinesSynchronized", "printStackTrace", "frames", "enhanceStackTraceWithThreadDump", "coroutineTrace", "enhanceStackTraceWithThreadDumpImpl", "state", "thread", "findContinuationStartIndex", "Lkotlin/Pair;", "", "indexOfResumeWith", "actualTrace", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)Lkotlin/Pair;", "findIndexOfFrame", "frameIndex", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "probeCoroutineResumed", TypedValues.AttributesType.S_FRAME, "Lkotlin/coroutines/Continuation;", "probeCoroutineResumed$kotlinx_coroutines_core", "probeCoroutineSuspended", "probeCoroutineSuspended$kotlinx_coroutines_core", "updateState", "updateRunningState", "realCaller", "owner", "probeCoroutineCreated", "T", "completion", "probeCoroutineCreated$kotlinx_coroutines_core", "toStackTraceFrame", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "createOwner", "probeCoroutineCompleted", "sanitizeStackTrace", "", "throwable", "(Ljava/lang/Throwable;)Ljava/util/List;", "isInternalMethod", "(Ljava/lang/StackTraceElement;)Z", "CoroutineOwner", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes10.dex */
public final class DebugProbesImpl {
    private static boolean enableCreationStackTraces;
    private static Thread weakRefCleanerThread;
    public static final DebugProbesImpl INSTANCE = new DebugProbesImpl();
    private static final StackTraceElement ARTIFICIAL_FRAME = new ArtificialStackFrames().coroutineCreation();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final ConcurrentWeakMap<CoroutineOwner<?>, Boolean> capturedCoroutinesMap = new ConcurrentWeakMap<>(false, 1, null);
    private static boolean sanitizeStackTraces = true;
    private static boolean ignoreCoroutinesWithEmptyContext = true;
    private static final Function1<Boolean, Unit> dynamicAttach = INSTANCE.getDynamicAttach();
    private static final ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfo> callerInfoCache = new ConcurrentWeakMap<>(true);
    private static final /* synthetic */ DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private debugProbesImpl$VolatileWrapper$atomicfu$private = new DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private(null);

    /* compiled from: DebugProbesImpl.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u001f\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001b\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\t\u0010\u0019\u001a\u00020\u001aX\u0096\u0005¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "info", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;)V", TypedValues.AttributesType.S_FRAME, "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "getFrame", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "context", "Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class CoroutineOwner<T> implements Continuation<T>, CoroutineStackFrame {
        public final Continuation<T> delegate;
        public final DebugCoroutineInfo info;

        /* JADX WARN: Multi-variable type inference failed */
        public CoroutineOwner(Continuation<? super T> continuation, DebugCoroutineInfo debugCoroutineInfo) {
            this.delegate = continuation;
            this.info = debugCoroutineInfo;
        }

        private final StackTraceFrame getFrame() {
            return this.info.getCreationStackBottom();
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public CoroutineStackFrame getCallerFrame() {
            StackTraceFrame frame = getFrame();
            if (frame != null) {
                return frame.getCallerFrame();
            }
            return null;
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.delegate.getContext();
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public StackTraceElement getStackTraceElement() {
            StackTraceFrame frame = getFrame();
            if (frame != null) {
                return frame.getStackTraceElement();
            }
            return null;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object result) {
            DebugProbesImpl.access$probeCoroutineCompleted(DebugProbesImpl.INSTANCE, this);
            this.delegate.resumeWith(result);
        }

        public String toString() {
            return this.delegate.toString();
        }
    }

    private DebugProbesImpl() {
    }

    public static final /* synthetic */ boolean access$isFinished(DebugProbesImpl debugProbesImpl, CoroutineOwner coroutineOwner) {
        return debugProbesImpl.isFinished(coroutineOwner);
    }

    public static final /* synthetic */ void access$probeCoroutineCompleted(DebugProbesImpl debugProbesImpl, CoroutineOwner coroutineOwner) {
        debugProbesImpl.probeCoroutineCompleted(coroutineOwner);
    }

    private final void build(Job job, Map<Job, DebugCoroutineInfo> map, StringBuilder sb, String str) {
        String str2;
        DebugCoroutineInfo debugCoroutineInfo = map.get(job);
        if (debugCoroutineInfo != null) {
            sb.append(str + getDebugString(job) + ", continuation is " + debugCoroutineInfo.get_state() + " at line " + ((StackTraceElement) CollectionsKt.firstOrNull((List) debugCoroutineInfo.lastObservedStackTrace$kotlinx_coroutines_core())) + '\n');
            str2 = str + '\t';
        } else if (job instanceof ScopeCoroutine) {
            str2 = str;
        } else {
            sb.append(str + getDebugString(job) + '\n');
            str2 = str + '\t';
        }
        Iterator<Job> it = job.getChildren().iterator();
        while (it.hasNext()) {
            build(it.next(), map, sb, str2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> Continuation<T> createOwner(Continuation<? super T> completion, StackTraceFrame frame) {
        if (!isInstalled$kotlinx_coroutines_debug()) {
            return completion;
        }
        CoroutineOwner<?> coroutineOwner = new CoroutineOwner<>(completion, new DebugCoroutineInfo(completion.getContext(), frame, DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private.access$getSequenceNumber$volatile$FU().incrementAndGet(getDebugProbesImpl$VolatileWrapper$atomicfu$private())));
        capturedCoroutinesMap.put(coroutineOwner, true);
        if (!isInstalled$kotlinx_coroutines_debug()) {
            capturedCoroutinesMap.clear();
        }
        return coroutineOwner;
    }

    private final <R> List<R> dumpCoroutinesInfoImpl(Function2<? super CoroutineOwner<?>, ? super CoroutineContext, ? extends R> create) {
        if (isInstalled$kotlinx_coroutines_debug()) {
            return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$$inlined$sortedBy$1()), new DebugProbesImpl$dumpCoroutinesInfoImpl$3(create)));
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    private final void dumpCoroutinesSynchronized(PrintStream out) {
        if (!isInstalled$kotlinx_coroutines_debug()) {
            throw new IllegalStateException("Debug probes are not installed".toString());
        }
        out.print("Coroutines dump " + dateFormat.format(Long.valueOf(System.currentTimeMillis())));
        for (CoroutineOwner coroutineOwner : SequencesKt.sortedWith(SequencesKt.filter(CollectionsKt.asSequence(getCapturedCoroutines()), new DebugProbesImpl$$ExternalSyntheticLambda0()), new DebugProbesImpl$dumpCoroutinesSynchronized$$inlined$sortedBy$1())) {
            DebugCoroutineInfo debugCoroutineInfo = coroutineOwner.info;
            List<StackTraceElement> lastObservedStackTrace$kotlinx_coroutines_core = debugCoroutineInfo.lastObservedStackTrace$kotlinx_coroutines_core();
            List<StackTraceElement> enhanceStackTraceWithThreadDumpImpl = INSTANCE.enhanceStackTraceWithThreadDumpImpl(debugCoroutineInfo.get_state(), debugCoroutineInfo.lastObservedThread, lastObservedStackTrace$kotlinx_coroutines_core);
            out.print("\n\nCoroutine " + coroutineOwner.delegate + ", state: " + ((Intrinsics.areEqual(debugCoroutineInfo.get_state(), DebugCoroutineInfoImplKt.RUNNING) && enhanceStackTraceWithThreadDumpImpl == lastObservedStackTrace$kotlinx_coroutines_core) ? debugCoroutineInfo.get_state() + " (Last suspension stacktrace, not an actual stacktrace)" : debugCoroutineInfo.get_state()));
            if (lastObservedStackTrace$kotlinx_coroutines_core.isEmpty()) {
                out.print("\n\tat " + ARTIFICIAL_FRAME);
                INSTANCE.printStackTrace(out, debugCoroutineInfo.getCreationStackTrace());
            } else {
                INSTANCE.printStackTrace(out, enhanceStackTraceWithThreadDumpImpl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean dumpCoroutinesSynchronized$lambda$14(CoroutineOwner coroutineOwner) {
        return !INSTANCE.isFinished(coroutineOwner);
    }

    private final List<StackTraceElement> enhanceStackTraceWithThreadDumpImpl(String state, Thread thread, List<StackTraceElement> coroutineTrace) {
        Object m457constructorimpl;
        if (!Intrinsics.areEqual(state, DebugCoroutineInfoImplKt.RUNNING) || thread == null) {
            return coroutineTrace;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            DebugProbesImpl debugProbesImpl = this;
            m457constructorimpl = Result.m457constructorimpl(thread.getStackTrace());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m457constructorimpl = Result.m457constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m463isFailureimpl(m457constructorimpl)) {
            m457constructorimpl = null;
        }
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) m457constructorimpl;
        if (stackTraceElementArr == null) {
            return coroutineTrace;
        }
        int i = 0;
        int length = stackTraceElementArr.length;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i];
            if (Intrinsics.areEqual(stackTraceElement.getClassName(), "kotlin.coroutines.jvm.internal.BaseContinuationImpl") && Intrinsics.areEqual(stackTraceElement.getMethodName(), "resumeWith") && Intrinsics.areEqual(stackTraceElement.getFileName(), "ContinuationImpl.kt")) {
                break;
            }
            i++;
        }
        Pair<Integer, Integer> findContinuationStartIndex = findContinuationStartIndex(i, stackTraceElementArr, coroutineTrace);
        int intValue = findContinuationStartIndex.component1().intValue();
        int intValue2 = findContinuationStartIndex.component2().intValue();
        if (intValue == -1) {
            return coroutineTrace;
        }
        ArrayList arrayList = new ArrayList((((coroutineTrace.size() + i) - intValue) - 1) - intValue2);
        int i2 = i - intValue2;
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(stackTraceElementArr[i3]);
        }
        int size = coroutineTrace.size();
        for (int i4 = intValue + 1; i4 < size; i4++) {
            arrayList.add(coroutineTrace.get(i4));
        }
        return arrayList;
    }

    private final Pair<Integer, Integer> findContinuationStartIndex(int indexOfResumeWith, StackTraceElement[] actualTrace, List<StackTraceElement> coroutineTrace) {
        for (int i = 0; i < 3; i++) {
            int i2 = i;
            int findIndexOfFrame = INSTANCE.findIndexOfFrame((indexOfResumeWith - 1) - i2, actualTrace, coroutineTrace);
            if (findIndexOfFrame != -1) {
                return TuplesKt.to(Integer.valueOf(findIndexOfFrame), Integer.valueOf(i2));
            }
        }
        return TuplesKt.to(-1, 0);
    }

    private final int findIndexOfFrame(int frameIndex, StackTraceElement[] actualTrace, List<StackTraceElement> coroutineTrace) {
        StackTraceElement stackTraceElement = (StackTraceElement) ArraysKt.getOrNull(actualTrace, frameIndex);
        if (stackTraceElement == null) {
            return -1;
        }
        int i = 0;
        for (StackTraceElement stackTraceElement2 : coroutineTrace) {
            if (Intrinsics.areEqual(stackTraceElement2.getFileName(), stackTraceElement.getFileName()) && Intrinsics.areEqual(stackTraceElement2.getClassName(), stackTraceElement.getClassName()) && Intrinsics.areEqual(stackTraceElement2.getMethodName(), stackTraceElement.getMethodName())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private final Set<CoroutineOwner<?>> getCapturedCoroutines() {
        return capturedCoroutinesMap.keySet();
    }

    private static final /* synthetic */ DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private getDebugProbesImpl$VolatileWrapper$atomicfu$private() {
        return debugProbesImpl$VolatileWrapper$atomicfu$private;
    }

    private final String getDebugString(Job job) {
        return job instanceof JobSupport ? ((JobSupport) job).toDebugString() : job.toString();
    }

    private static /* synthetic */ void getDebugString$annotations(Job job) {
    }

    private final Function1<Boolean, Unit> getDynamicAttach() {
        Object m457constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            DebugProbesImpl debugProbesImpl = this;
            Object newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
            m457constructorimpl = Result.m457constructorimpl((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(newInstance, 1));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m457constructorimpl = Result.m457constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m463isFailureimpl(m457constructorimpl)) {
            m457constructorimpl = null;
        }
        return (Function1) m457constructorimpl;
    }

    private final boolean isFinished(CoroutineOwner<?> coroutineOwner) {
        Job job;
        CoroutineContext context = coroutineOwner.info.getContext();
        if (context == null || (job = (Job) context.get(Job.INSTANCE)) == null || !job.isCompleted()) {
            return false;
        }
        capturedCoroutinesMap.remove(coroutineOwner);
        return true;
    }

    private final boolean isInternalMethod(StackTraceElement stackTraceElement) {
        return StringsKt.startsWith$default(stackTraceElement.getClassName(), "kotlinx.coroutines", false, 2, (Object) null);
    }

    private final CoroutineOwner<?> owner(Continuation<?> continuation) {
        CoroutineStackFrame coroutineStackFrame = continuation instanceof CoroutineStackFrame ? (CoroutineStackFrame) continuation : null;
        if (coroutineStackFrame != null) {
            return owner(coroutineStackFrame);
        }
        return null;
    }

    private final CoroutineOwner<?> owner(CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof CoroutineOwner)) {
            CoroutineStackFrame callerFrame = coroutineStackFrame.getCallerFrame();
            if (callerFrame == null) {
                return null;
            }
            coroutineStackFrame = callerFrame;
        }
        return (CoroutineOwner) coroutineStackFrame;
    }

    private final void printStackTrace(PrintStream out, List<StackTraceElement> frames) {
        Iterator<T> it = frames.iterator();
        while (it.hasNext()) {
            out.print("\n\tat " + ((StackTraceElement) it.next()));
        }
    }

    private final void probeCoroutineCompleted(CoroutineOwner<?> owner) {
        CoroutineStackFrame realCaller;
        capturedCoroutinesMap.remove(owner);
        CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = owner.info.getLastObservedFrame$kotlinx_coroutines_core();
        if (lastObservedFrame$kotlinx_coroutines_core == null || (realCaller = realCaller(lastObservedFrame$kotlinx_coroutines_core)) == null) {
            return;
        }
        callerInfoCache.remove(realCaller);
    }

    private final CoroutineStackFrame realCaller(CoroutineStackFrame coroutineStackFrame) {
        while (true) {
            CoroutineStackFrame callerFrame = coroutineStackFrame.getCallerFrame();
            if (callerFrame == null) {
                return null;
            }
            if (callerFrame.getStackTraceElement() != null) {
                return callerFrame;
            }
            coroutineStackFrame = callerFrame;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if (kotlinx.coroutines.debug.internal.DebugProbesImpl.sanitizeStackTraces != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
    
        r2 = r1 - r5;
        r3 = new java.util.ArrayList(r2);
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
    
        if (r4 >= r2) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
    
        r3.add(r0[r4 + r5]);
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        r3 = new java.util.ArrayList((r1 - r5) + 1);
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
    
        if (r2 >= r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
    
        if (isInternalMethod(r0[r2]) == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0094, code lost:
    
        r3.add(r0[r2]);
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r3.add(r0[r2]);
        r4 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
    
        if (r4 >= r1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x000a, code lost:
    
        if (r4 >= 0) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
    
        if (isInternalMethod(r0[r4]) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
    
        r6 = r4 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006d, code lost:
    
        if (r6 <= r2) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0075, code lost:
    
        if (r0[r6].getFileName() != null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0077, code lost:
    
        r6 = r6 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
    
        r6 = r4;
        r4 = r4 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007a, code lost:
    
        if (r6 <= r2) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007e, code lost:
    
        if (r6 >= (r4 - 1)) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0080, code lost:
    
        r3.add(r0[r6]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0088, code lost:
    
        r3.add(r0[r4 - 1]);
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001b, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0[r6].getClassName(), "kotlin.coroutines.jvm.internal.DebugProbesKt") == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a2, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001f, code lost:
    
        if (r4 >= 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        r5 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final <T extends java.lang.Throwable> java.util.List<java.lang.StackTraceElement> sanitizeStackTrace(T r12) {
        /*
            r11 = this;
            java.lang.StackTraceElement[] r0 = r12.getStackTrace()
            int r1 = r0.length
            r2 = r0
            r3 = 0
            int r4 = r2.length
            r5 = -1
            int r4 = r4 + r5
            if (r4 < 0) goto L21
        Lc:
            r6 = r4
            int r4 = r4 + r5
            r7 = r2[r6]
            r8 = 0
            java.lang.String r9 = r7.getClassName()
            java.lang.String r10 = "kotlin.coroutines.jvm.internal.DebugProbesKt"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r10)
            if (r7 == 0) goto L1f
            r5 = r6
            goto L22
        L1f:
            if (r4 >= 0) goto Lc
        L21:
        L22:
            r2 = 1
            int r5 = r5 + r2
            boolean r3 = kotlinx.coroutines.debug.internal.DebugProbesImpl.sanitizeStackTraces
            if (r3 != 0) goto L41
            int r2 = r1 - r5
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r2)
            r4 = 0
        L30:
            if (r4 >= r2) goto L3e
            r6 = r4
            r7 = 0
            int r8 = r6 + r5
            r6 = r0[r8]
            r3.add(r6)
            int r4 = r4 + 1
            goto L30
        L3e:
            java.util.List r3 = (java.util.List) r3
            return r3
        L41:
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = r1 - r5
            int r4 = r4 + r2
            r3.<init>(r4)
            r2 = r5
        L4a:
            if (r2 >= r1) goto L9f
            r4 = r0[r2]
            boolean r4 = r11.isInternalMethod(r4)
            if (r4 == 0) goto L94
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            r6 = r0[r2]
            r4.add(r6)
            int r4 = r2 + 1
        L5e:
            if (r4 >= r1) goto L6b
            r6 = r0[r4]
            boolean r6 = r11.isInternalMethod(r6)
            if (r6 == 0) goto L6b
            int r4 = r4 + 1
            goto L5e
        L6b:
            int r6 = r4 + (-1)
        L6d:
            if (r6 <= r2) goto L7a
            r7 = r0[r6]
            java.lang.String r7 = r7.getFileName()
            if (r7 != 0) goto L7a
            int r6 = r6 + (-1)
            goto L6d
        L7a:
            if (r6 <= r2) goto L88
            int r7 = r4 + (-1)
            if (r6 >= r7) goto L88
            r7 = r3
            java.util.Collection r7 = (java.util.Collection) r7
            r8 = r0[r6]
            r7.add(r8)
        L88:
            r7 = r3
            java.util.Collection r7 = (java.util.Collection) r7
            int r8 = r4 + (-1)
            r8 = r0[r8]
            r7.add(r8)
            r2 = r4
            goto L4a
        L94:
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            r6 = r0[r2]
            r4.add(r6)
            int r2 = r2 + 1
            goto L4a
        L9f:
            r4 = r3
            java.util.List r4 = (java.util.List) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.sanitizeStackTrace(java.lang.Throwable):java.util.List");
    }

    private final void startWeakRefCleanerThread() {
        weakRefCleanerThread = ThreadsKt.thread$default(false, true, null, "Coroutines Debugger Cleaner", 0, new DebugProbesImpl$$ExternalSyntheticLambda1(), 21, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit startWeakRefCleanerThread$lambda$2() {
        callerInfoCache.runWeakRefQueueCleaningLoopUntilInterrupted();
        return Unit.INSTANCE;
    }

    private final void stopWeakRefCleanerThread() {
        Thread thread = weakRefCleanerThread;
        if (thread == null) {
            return;
        }
        weakRefCleanerThread = null;
        thread.interrupt();
        thread.join();
    }

    private final StackTraceFrame toStackTraceFrame(List<StackTraceElement> list) {
        StackTraceFrame stackTraceFrame = null;
        if (!list.isEmpty()) {
            ListIterator<StackTraceElement> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                stackTraceFrame = new StackTraceFrame(stackTraceFrame, listIterator.previous());
            }
        }
        return new StackTraceFrame(stackTraceFrame, ARTIFICIAL_FRAME);
    }

    private final String toStringRepr(Object obj) {
        return DebugProbesImplKt.access$repr(obj.toString());
    }

    private final void updateRunningState(CoroutineStackFrame frame, String state) {
        DebugCoroutineInfo debugCoroutineInfo;
        DebugCoroutineInfo debugCoroutineInfo2;
        boolean z;
        if (isInstalled$kotlinx_coroutines_debug()) {
            DebugCoroutineInfo remove = callerInfoCache.remove(frame);
            if (remove != null) {
                debugCoroutineInfo2 = remove;
                z = false;
            } else {
                CoroutineOwner<?> owner = owner(frame);
                if (owner == null || (debugCoroutineInfo = owner.info) == null) {
                    return;
                }
                debugCoroutineInfo2 = debugCoroutineInfo;
                z = true;
                CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = debugCoroutineInfo2.getLastObservedFrame$kotlinx_coroutines_core();
                CoroutineStackFrame realCaller = lastObservedFrame$kotlinx_coroutines_core != null ? realCaller(lastObservedFrame$kotlinx_coroutines_core) : null;
                if (realCaller != null) {
                    callerInfoCache.remove(realCaller);
                }
            }
            Intrinsics.checkNotNull(frame, "null cannot be cast to non-null type kotlin.coroutines.Continuation<*>");
            debugCoroutineInfo2.updateState$kotlinx_coroutines_core(state, (Continuation) frame, z);
            CoroutineStackFrame realCaller2 = realCaller(frame);
            if (realCaller2 == null) {
                return;
            }
            callerInfoCache.put(realCaller2, debugCoroutineInfo2);
        }
    }

    private final void updateState(Continuation<?> frame, String state) {
        if (isInstalled$kotlinx_coroutines_debug()) {
            if (ignoreCoroutinesWithEmptyContext && frame.getContext() == EmptyCoroutineContext.INSTANCE) {
                return;
            }
            if (Intrinsics.areEqual(state, DebugCoroutineInfoImplKt.RUNNING)) {
                CoroutineStackFrame coroutineStackFrame = frame instanceof CoroutineStackFrame ? (CoroutineStackFrame) frame : null;
                if (coroutineStackFrame == null) {
                    return;
                }
                updateRunningState(coroutineStackFrame, state);
                return;
            }
            CoroutineOwner<?> owner = owner(frame);
            if (owner == null) {
                return;
            }
            updateState(owner, frame, state);
        }
    }

    private final void updateState(CoroutineOwner<?> owner, Continuation<?> frame, String state) {
        if (isInstalled$kotlinx_coroutines_debug()) {
            owner.info.updateState$kotlinx_coroutines_core(state, frame, true);
        }
    }

    public final void dumpCoroutines(PrintStream out) {
        synchronized (out) {
            INSTANCE.dumpCoroutinesSynchronized(out);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final List<DebugCoroutineInfo> dumpCoroutinesInfo() {
        if (isInstalled$kotlinx_coroutines_debug()) {
            return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$$inlined$sortedBy$1()), new DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1()));
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    public final Object[] dumpCoroutinesInfoAsJsonAndReferences() {
        String name;
        List<DebugCoroutineInfo> dumpCoroutinesInfo = dumpCoroutinesInfo();
        int size = dumpCoroutinesInfo.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        ArrayList arrayList3 = new ArrayList(size);
        for (DebugCoroutineInfo debugCoroutineInfo : dumpCoroutinesInfo) {
            CoroutineContext context = debugCoroutineInfo.getContext();
            CoroutineName coroutineName = (CoroutineName) context.get(CoroutineName.INSTANCE);
            Long l = null;
            String stringRepr = (coroutineName == null || (name = coroutineName.getName()) == null) ? null : toStringRepr(name);
            CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) context.get(CoroutineDispatcher.INSTANCE);
            String stringRepr2 = coroutineDispatcher != null ? toStringRepr(coroutineDispatcher) : null;
            StringBuilder append = new StringBuilder().append("\n                {\n                    \"name\": ").append(stringRepr).append(",\n                    \"id\": ");
            CoroutineId coroutineId = (CoroutineId) context.get(CoroutineId.INSTANCE);
            if (coroutineId != null) {
                l = Long.valueOf(coroutineId.getId());
            }
            arrayList3.add(StringsKt.trimIndent(append.append(l).append(",\n                    \"dispatcher\": ").append(stringRepr2).append(",\n                    \"sequenceNumber\": ").append(debugCoroutineInfo.getSequenceNumber()).append(",\n                    \"state\": \"").append(debugCoroutineInfo.getState()).append("\"\n                } \n                ").toString()));
            arrayList2.add(debugCoroutineInfo.getLastObservedFrame());
            arrayList.add(debugCoroutineInfo.getLastObservedThread());
        }
        return new Object[]{'[' + CollectionsKt.joinToString$default(arrayList3, null, null, null, 0, null, null, 63, null) + ']', arrayList.toArray(new Thread[0]), arrayList2.toArray(new CoroutineStackFrame[0]), dumpCoroutinesInfo.toArray(new DebugCoroutineInfo[0])};
    }

    public final List<DebuggerInfo> dumpDebuggerInfo() {
        if (isInstalled$kotlinx_coroutines_debug()) {
            return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$$inlined$sortedBy$1()), new DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1()));
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    public final List<StackTraceElement> enhanceStackTraceWithThreadDump(DebugCoroutineInfo info, List<StackTraceElement> coroutineTrace) {
        return enhanceStackTraceWithThreadDumpImpl(info.getState(), info.getLastObservedThread(), coroutineTrace);
    }

    public final String enhanceStackTraceWithThreadDumpAsJson(DebugCoroutineInfo info) {
        List<StackTraceElement> enhanceStackTraceWithThreadDump = enhanceStackTraceWithThreadDump(info, info.lastObservedStackTrace());
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : enhanceStackTraceWithThreadDump) {
            StringBuilder append = new StringBuilder().append("\n                {\n                    \"declaringClass\": \"").append(stackTraceElement.getClassName()).append("\",\n                    \"methodName\": \"").append(stackTraceElement.getMethodName()).append("\",\n                    \"fileName\": ");
            String fileName = stackTraceElement.getFileName();
            arrayList.add(StringsKt.trimIndent(append.append(fileName != null ? toStringRepr(fileName) : null).append(",\n                    \"lineNumber\": ").append(stackTraceElement.getLineNumber()).append("\n                }\n                ").toString()));
        }
        return '[' + CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null) + ']';
    }

    public final boolean getEnableCreationStackTraces$kotlinx_coroutines_core() {
        return enableCreationStackTraces;
    }

    public final boolean getIgnoreCoroutinesWithEmptyContext() {
        return ignoreCoroutinesWithEmptyContext;
    }

    public final boolean getSanitizeStackTraces$kotlinx_coroutines_core() {
        return sanitizeStackTraces;
    }

    public final String hierarchyToString$kotlinx_coroutines_core(Job job) {
        if (!isInstalled$kotlinx_coroutines_debug()) {
            throw new IllegalStateException("Debug probes are not installed".toString());
        }
        Set<CoroutineOwner<?>> capturedCoroutines = getCapturedCoroutines();
        ArrayList arrayList = new ArrayList();
        for (Object obj : capturedCoroutines) {
            if (((CoroutineOwner) obj).delegate.getContext().get(Job.INSTANCE) != null) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Object obj2 : arrayList2) {
            linkedHashMap.put(JobKt.getJob(((CoroutineOwner) obj2).delegate.getContext()), ((CoroutineOwner) obj2).info);
        }
        StringBuilder sb = new StringBuilder();
        INSTANCE.build(job, linkedHashMap, sb, "");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final void install$kotlinx_coroutines_core() {
        Function1<Boolean, Unit> function1;
        if (DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private.access$getInstallations$volatile$FU().incrementAndGet(getDebugProbesImpl$VolatileWrapper$atomicfu$private()) > 1) {
            return;
        }
        startWeakRefCleanerThread();
        if (AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core() || (function1 = dynamicAttach) == null) {
            return;
        }
        function1.invoke(true);
    }

    public final boolean isInstalled$kotlinx_coroutines_debug() {
        return DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private.access$getInstallations$volatile$FU().get(getDebugProbesImpl$VolatileWrapper$atomicfu$private()) > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Continuation<T> probeCoroutineCreated$kotlinx_coroutines_core(Continuation<? super T> completion) {
        if (!isInstalled$kotlinx_coroutines_debug()) {
            return completion;
        }
        if (!(ignoreCoroutinesWithEmptyContext && completion.getContext() == EmptyCoroutineContext.INSTANCE) && owner(completion) == null) {
            return createOwner(completion, enableCreationStackTraces ? toStackTraceFrame(sanitizeStackTrace(new Exception())) : null);
        }
        return completion;
    }

    public final void probeCoroutineResumed$kotlinx_coroutines_core(Continuation<?> frame) {
        updateState(frame, DebugCoroutineInfoImplKt.RUNNING);
    }

    public final void probeCoroutineSuspended$kotlinx_coroutines_core(Continuation<?> frame) {
        updateState(frame, DebugCoroutineInfoImplKt.SUSPENDED);
    }

    public final void setEnableCreationStackTraces$kotlinx_coroutines_core(boolean z) {
        enableCreationStackTraces = z;
    }

    public final void setIgnoreCoroutinesWithEmptyContext(boolean z) {
        ignoreCoroutinesWithEmptyContext = z;
    }

    public final void setSanitizeStackTraces$kotlinx_coroutines_core(boolean z) {
        sanitizeStackTraces = z;
    }

    public final void uninstall$kotlinx_coroutines_core() {
        Function1<Boolean, Unit> function1;
        if (!isInstalled$kotlinx_coroutines_debug()) {
            throw new IllegalStateException("Agent was not installed".toString());
        }
        if (DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private.access$getInstallations$volatile$FU().decrementAndGet(getDebugProbesImpl$VolatileWrapper$atomicfu$private()) != 0) {
            return;
        }
        stopWeakRefCleanerThread();
        capturedCoroutinesMap.clear();
        callerInfoCache.clear();
        if (AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core() || (function1 = dynamicAttach) == null) {
            return;
        }
        function1.invoke(false);
    }
}
