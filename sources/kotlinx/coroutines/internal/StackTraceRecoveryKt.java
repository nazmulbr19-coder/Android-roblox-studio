package kotlinx.coroutines.internal;

import _COROUTINE.ArtificialStackFrames;
import _COROUTINE.CoroutineDebuggingKt;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;

/* compiled from: StackTraceRecovery.kt */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u001a\u001f\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\nH\u0000¢\u0006\u0002\u0010\r\u001a\u001b\u0010\u000e\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b*\u0002H\nH\u0002¢\u0006\u0002\u0010\r\u001a,\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\n2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0080\b¢\u0006\u0002\u0010\u0011\u001a+\u0010\u0012\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\n2\n\u0010\u000f\u001a\u00060\u0014j\u0002`\u0013H\u0002¢\u0006\u0002\u0010\u0015\u001a9\u0010\u0016\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\u0017\u001a\u0002H\n2\u0006\u0010\u0018\u001a\u0002H\n2\u0010\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u001b0\u001aH\u0002¢\u0006\u0002\u0010\u001c\u001a1\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u0002H\n\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0004j\u0002`\u001b0\u001f0\u001e\"\b\b\u0000\u0010\n*\u00020\u000b*\u0002H\nH\u0002¢\u0006\u0002\u0010 \u001a1\u0010!\u001a\u00020\"2\u0010\u0010#\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u001b0\u001f2\u0010\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u001b0\u001aH\u0002¢\u0006\u0002\u0010$\u001a\u0016\u0010%\u001a\u00020&2\u0006\u0010\f\u001a\u00020\u000bH\u0080H¢\u0006\u0002\u0010'\u001a \u0010(\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\nH\u0081\b¢\u0006\u0002\u0010\r\u001a\u001f\u0010)\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\nH\u0001¢\u0006\u0002\u0010\r\u001a#\u0010*\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u001b0\u001a2\n\u0010\u000f\u001a\u00060\u0014j\u0002`\u0013H\u0002¢\u0006\u0002\u0010+\u001a\u0015\u0010,\u001a\u00020-*\u00060\u0004j\u0002`\u001bH\u0000¢\u0006\u0002\u0010.\u001a#\u0010/\u001a\u000200*\f\u0012\b\u0012\u00060\u0004j\u0002`\u001b0\u001f2\u0006\u00101\u001a\u00020\u0001H\u0002¢\u0006\u0002\u00102\u001a!\u00103\u001a\u00020-*\u00060\u0004j\u0002`\u001b2\n\u00104\u001a\u00060\u0004j\u0002`\u001bH\u0002¢\u0006\u0002\u00105\u001a\u0014\u00108\u001a\u00020\"*\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0018\u0010\b\u001a\n \u0006*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007*\f\b\u0000\u00106\"\u00020\u00142\u00020\u0014*\f\b\u0000\u00107\"\u00020\u00042\u00020\u0004¨\u00069"}, d2 = {"baseContinuationImplClass", "", "stackTraceRecoveryClass", "ARTIFICIAL_FRAME", "Ljava/lang/StackTraceElement;", "baseContinuationImplClassName", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "stackTraceRecoveryClassName", "recoverStackTrace", "E", "", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "sanitizeStackTrace", "continuation", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "recoverFromStackFrame", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "createFinalException", "cause", "result", "resultStackTrace", "Ljava/util/ArrayDeque;", "Lkotlinx/coroutines/internal/StackTraceElement;", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "causeAndStacktrace", "Lkotlin/Pair;", "", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "mergeRecoveredTraces", "", "recoveredStacktrace", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "recoverAndThrow", "", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unwrap", "unwrapImpl", "createStackTrace", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/util/ArrayDeque;", "isArtificial", "", "(Ljava/lang/StackTraceElement;)Z", "firstFrameIndex", "", "methodName", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "elementWiseEquals", "e", "(Ljava/lang/StackTraceElement;Ljava/lang/StackTraceElement;)Z", "CoroutineStackFrame", "StackTraceElement", "initCause", "kotlinx-coroutines-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes10.dex */
public final class StackTraceRecoveryKt {
    private static final StackTraceElement ARTIFICIAL_FRAME;
    private static final String baseContinuationImplClass = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    private static final String baseContinuationImplClassName;
    private static final String stackTraceRecoveryClass = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    private static final String stackTraceRecoveryClassName;

    static {
        Object obj;
        Object obj2;
        Object obj3 = stackTraceRecoveryClass;
        Object obj4 = baseContinuationImplClass;
        ARTIFICIAL_FRAME = new ArtificialStackFrames().coroutineBoundary();
        try {
            Result.Companion companion = Result.INSTANCE;
            obj = Result.m457constructorimpl(Class.forName(baseContinuationImplClass).getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            obj = Result.m457constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m460exceptionOrNullimpl(obj) == null) {
            obj4 = obj;
        }
        baseContinuationImplClassName = (String) obj4;
        try {
            Result.Companion companion3 = Result.INSTANCE;
            obj2 = Result.m457constructorimpl(Class.forName(stackTraceRecoveryClass).getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            obj2 = Result.m457constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m460exceptionOrNullimpl(obj2) == null) {
            obj3 = obj2;
        }
        stackTraceRecoveryClassName = (String) obj3;
    }

    public static /* synthetic */ void CoroutineStackFrame$annotations() {
    }

    public static /* synthetic */ void StackTraceElement$annotations() {
    }

    public static final /* synthetic */ Throwable access$recoverFromStackFrame(Throwable th, CoroutineStackFrame coroutineStackFrame) {
        return recoverFromStackFrame(th, coroutineStackFrame);
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> causeAndStacktrace(E e) {
        boolean z;
        Throwable cause = e.getCause();
        if (cause == null || !Intrinsics.areEqual(cause.getClass(), e.getClass())) {
            return TuplesKt.to(e, new StackTraceElement[0]);
        }
        StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            if (isArtificial(stackTrace[i])) {
                z = true;
                break;
            }
            i++;
        }
        return z ? TuplesKt.to(cause, stackTrace) : TuplesKt.to(e, new StackTraceElement[0]);
    }

    private static final <E extends Throwable> E createFinalException(E e, E e2, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(ARTIFICIAL_FRAME);
        StackTraceElement[] stackTrace = e.getStackTrace();
        int firstFrameIndex = firstFrameIndex(stackTrace, baseContinuationImplClassName);
        int i = 0;
        if (firstFrameIndex == -1) {
            e2.setStackTrace((StackTraceElement[]) arrayDeque.toArray(new StackTraceElement[0]));
            return e2;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + firstFrameIndex];
        for (int i2 = 0; i2 < firstFrameIndex; i2++) {
            stackTraceElementArr[i2] = stackTrace[i2];
        }
        Iterator<T> it = arrayDeque.iterator();
        while (it.hasNext()) {
            int i3 = i;
            i++;
            stackTraceElementArr[firstFrameIndex + i3] = (StackTraceElement) it.next();
        }
        e2.setStackTrace(stackTraceElementArr);
        return e2;
    }

    private static final ArrayDeque<StackTraceElement> createStackTrace(CoroutineStackFrame coroutineStackFrame) {
        CoroutineStackFrame callerFrame;
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        CoroutineStackFrame coroutineStackFrame2 = coroutineStackFrame;
        while (true) {
            CoroutineStackFrame coroutineStackFrame3 = coroutineStackFrame2 instanceof CoroutineStackFrame ? coroutineStackFrame2 : null;
            if (coroutineStackFrame3 == null || (callerFrame = coroutineStackFrame3.getCallerFrame()) == null) {
                break;
            }
            coroutineStackFrame2 = callerFrame;
            StackTraceElement stackTraceElement2 = coroutineStackFrame2.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
        return arrayDeque;
    }

    private static final boolean elementWiseEquals(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && Intrinsics.areEqual(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && Intrinsics.areEqual(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && Intrinsics.areEqual(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    private static final int firstFrameIndex(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (Intrinsics.areEqual(str, stackTraceElementArr[i].getClassName())) {
                return i;
            }
        }
        return -1;
    }

    public static final void initCause(Throwable th, Throwable th2) {
        th.initCause(th2);
    }

    public static final boolean isArtificial(StackTraceElement stackTraceElement) {
        return StringsKt.startsWith$default(stackTraceElement.getClassName(), CoroutineDebuggingKt.getARTIFICIAL_FRAME_PACKAGE_NAME(), false, 2, (Object) null);
    }

    private static final void mergeRecoveredTraces(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int i = 0;
        int length = stackTraceElementArr.length;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (isArtificial(stackTraceElementArr[i])) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (i2 > length2) {
            return;
        }
        while (true) {
            if (elementWiseEquals(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i2) {
                return;
            } else {
                length2--;
            }
        }
    }

    public static final Object recoverAndThrow(Throwable th, Continuation<?> continuation) {
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
            throw th;
        }
        if (continuation instanceof CoroutineStackFrame) {
            throw access$recoverFromStackFrame(th, (CoroutineStackFrame) continuation);
        }
        throw th;
    }

    private static final Object recoverAndThrow$$forInline(Throwable th, Continuation<?> continuation) {
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
            throw th;
        }
        Continuation<?> continuation2 = continuation;
        if (continuation2 instanceof CoroutineStackFrame) {
            throw access$recoverFromStackFrame(th, (CoroutineStackFrame) continuation2);
        }
        throw th;
    }

    private static final <E extends Throwable> E recoverFromStackFrame(E e, CoroutineStackFrame coroutineStackFrame) {
        Pair causeAndStacktrace = causeAndStacktrace(e);
        Throwable th = (Throwable) causeAndStacktrace.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) causeAndStacktrace.component2();
        Throwable tryCopyException = ExceptionsConstructorKt.tryCopyException(th);
        if (tryCopyException == null) {
            return e;
        }
        ArrayDeque<StackTraceElement> createStackTrace = createStackTrace(coroutineStackFrame);
        if (createStackTrace.isEmpty()) {
            return e;
        }
        if (th != e) {
            mergeRecoveredTraces(stackTraceElementArr, createStackTrace);
        }
        return (E) createFinalException(th, tryCopyException, createStackTrace);
    }

    public static final <E extends Throwable> E recoverStackTrace(E e) {
        Throwable tryCopyException;
        return (DebugKt.getRECOVER_STACK_TRACES() && (tryCopyException = ExceptionsConstructorKt.tryCopyException(e)) != null) ? (E) sanitizeStackTrace(tryCopyException) : e;
    }

    public static final <E extends Throwable> E recoverStackTrace(E e, Continuation<?> continuation) {
        return (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) ? (E) access$recoverFromStackFrame(e, (CoroutineStackFrame) continuation) : e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
    
        if (r3 != (-1)) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
    
        r7 = (r1 - r6) - r5;
        r8 = new java.lang.StackTraceElement[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        if (r4 >= r7) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        if (r4 != 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        r9 = kotlinx.coroutines.internal.StackTraceRecoveryKt.ARTIFICIAL_FRAME;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0043, code lost:
    
        r8[r4] = r9;
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
    
        r9 = r0[(r2 + r4) - 1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
    
        r11.setStackTrace(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002f, code lost:
    
        r5 = r1 - r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0020, code lost:
    
        r6 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x000a, code lost:
    
        if (r4 >= 0) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
    
        r6 = r4;
        r4 = r4 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001b, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(kotlinx.coroutines.internal.StackTraceRecoveryKt.stackTraceRecoveryClassName, r0[r6].getClassName()) == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001e, code lost:
    
        if (r4 >= 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        r2 = r6 + 1;
        r3 = firstFrameIndex(r0, kotlinx.coroutines.internal.StackTraceRecoveryKt.baseContinuationImplClassName);
        r4 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final <E extends java.lang.Throwable> E sanitizeStackTrace(E r11) {
        /*
            java.lang.StackTraceElement[] r0 = r11.getStackTrace()
            int r1 = r0.length
            r2 = r0
            r3 = 0
            int r4 = r2.length
            r5 = -1
            int r4 = r4 + r5
            if (r4 < 0) goto L20
        Lc:
            r6 = r4
            int r4 = r4 + r5
            r7 = r2[r6]
            r8 = 0
            java.lang.String r9 = kotlinx.coroutines.internal.StackTraceRecoveryKt.stackTraceRecoveryClassName
            java.lang.String r10 = r7.getClassName()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r10)
            if (r7 == 0) goto L1e
            goto L21
        L1e:
            if (r4 >= 0) goto Lc
        L20:
            r6 = r5
        L21:
            int r2 = r6 + 1
            java.lang.String r3 = kotlinx.coroutines.internal.StackTraceRecoveryKt.baseContinuationImplClassName
            int r3 = firstFrameIndex(r0, r3)
            r4 = 0
            if (r3 != r5) goto L2f
            r5 = r4
            goto L31
        L2f:
            int r5 = r1 - r3
        L31:
            int r7 = r1 - r6
            int r7 = r7 - r5
            java.lang.StackTraceElement[] r8 = new java.lang.StackTraceElement[r7]
        L36:
            if (r4 >= r7) goto L48
            if (r4 != 0) goto L3d
            java.lang.StackTraceElement r9 = kotlinx.coroutines.internal.StackTraceRecoveryKt.ARTIFICIAL_FRAME
            goto L43
        L3d:
            int r9 = r2 + r4
            int r9 = r9 + (-1)
            r9 = r0[r9]
        L43:
            r8[r4] = r9
            int r4 = r4 + 1
            goto L36
        L48:
            r11.setStackTrace(r8)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.StackTraceRecoveryKt.sanitizeStackTrace(java.lang.Throwable):java.lang.Throwable");
    }

    public static final <E extends Throwable> E unwrap(E e) {
        return !DebugKt.getRECOVER_STACK_TRACES() ? e : (E) unwrapImpl(e);
    }

    public static final <E extends Throwable> E unwrapImpl(E e) {
        E e2 = (E) e.getCause();
        if (e2 == null || !Intrinsics.areEqual(e2.getClass(), e.getClass())) {
            return e;
        }
        StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (isArtificial(stackTrace[i])) {
                z = true;
                break;
            }
            i++;
        }
        return z ? e2 : e;
    }
}
