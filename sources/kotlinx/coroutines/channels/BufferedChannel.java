package kotlinx.coroutines.channels;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

/* compiled from: BufferedChannel.kt */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0004ï\u0001ð\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\"\b\u0002\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020\b2\u0006\u0010\"\u001a\u00028\u0000H\u0082@¢\u0006\u0002\u0010#J4\u0010%\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010)J\"\u0010*\u001a\u00020\b*\u00020+2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u0004H\u0002J#\u0010,\u001a\u00020\b2\u0006\u0010\"\u001a\u00028\u00002\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0.H\u0002¢\u0006\u0002\u0010/J\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\b012\u0006\u0010\"\u001a\u00028\u0000H\u0016¢\u0006\u0004\b2\u00103J\u0018\u00104\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00028\u0000H\u0090@¢\u0006\u0004\b5\u0010#Jê\u0001\u00106\u001a\u0002H7\"\u0004\b\u0001\u001072\u0006\u0010\"\u001a\u00028\u00002\b\u00108\u001a\u0004\u0018\u0001092\f\u0010:\u001a\b\u0012\u0004\u0012\u0002H70;2<\u0010<\u001a8\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001e¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(A\u0012\u0004\u0012\u0002H70=2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H70;2h\b\u0002\u0010C\u001ab\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001e¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(A\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b((\u0012\u0004\u0012\u0002H70DH\u0082\b¢\u0006\u0002\u0010EJ\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020\b012\u0006\u0010\"\u001a\u00028\u0000H\u0004¢\u0006\u0004\bG\u00103JX\u0010H\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\u00112\u0006\u00108\u001a\u00020+2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\b0;2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\b0;H\u0082\b¢\u0006\u0002\u0010IJE\u0010J\u001a\u00020\u00042\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010K\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010LJE\u0010M\u001a\u00020\u00042\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010K\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010LJ\u0010\u0010N\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020\u0011H\u0003J\u0010\u0010P\u001a\u00020\u001a2\u0006\u0010Q\u001a\u00020\u0011H\u0002J\r\u0010N\u001a\u00020\u001aH\u0010¢\u0006\u0002\bRJ\u0019\u0010S\u001a\u00020\u001a*\u0002092\u0006\u0010\"\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u00020\bH\u0014J\b\u0010V\u001a\u00020\bH\u0014J\u000e\u0010W\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010XJ;\u0010Y\u001a\u00118\u0000¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(\"2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010[J\"\u0010\\\u001a\u00020\b*\u00020+2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0016\u0010]\u001a\u00020\b2\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000.H\u0002J\u0016\u0010^\u001a\b\u0012\u0004\u0012\u00028\u000001H\u0096@¢\u0006\u0004\b_\u0010XJ4\u0010`\u001a\b\u0012\u0004\u0012\u00028\u0000012\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u0011H\u0082@¢\u0006\u0004\ba\u0010[J\u001c\u0010b\u001a\u00020\b2\u0012\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000010.H\u0002J\u0015\u0010c\u001a\b\u0012\u0004\u0012\u00028\u000001H\u0016¢\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\b2\u0006\u0010g\u001a\u00020\u0011H\u0004J÷\u0001\u0010h\u001a\u0002H7\"\u0004\b\u0001\u001072\b\u00108\u001a\u0004\u0018\u0001092!\u0010i\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H70\u00072Q\u0010<\u001aM\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001e¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(A\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(Z\u0012\u0004\u0012\u0002H70j2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H70;2S\b\u0002\u0010C\u001aM\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001e¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(A\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(Z\u0012\u0004\u0012\u0002H70jH\u0082\b¢\u0006\u0002\u0010kJ`\u0010l\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00112\u0006\u00108\u001a\u00020+2!\u0010i\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\b0\u00072\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\b0;H\u0082\bJ2\u0010m\u001a\u0004\u0018\u0001092\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u000109H\u0002J2\u0010n\u001a\u0004\u0018\u0001092\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u000109H\u0002J\"\u0010o\u001a\u00020\u001a*\u0002092\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u0004H\u0002J\b\u0010p\u001a\u00020\bH\u0002J&\u0010q\u001a\u00020\u001a2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010r\u001a\u00020\u0011H\u0002J&\u0010s\u001a\u00020\u001a2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010r\u001a\u00020\u0011H\u0002J\u0012\u0010t\u001a\u00020\b2\b\b\u0002\u0010u\u001a\u00020\u0011H\u0002J\u0015\u0010v\u001a\u00020\b2\u0006\u0010w\u001a\u00020\u0011H\u0000¢\u0006\u0002\bxJ \u0010\u007f\u001a\u00020\b2\f\u0010\u0080\u0001\u001a\u0007\u0012\u0002\b\u00030\u0081\u00012\b\u0010\"\u001a\u0004\u0018\u000109H\u0014J%\u0010\u0082\u0001\u001a\u00020\b2\u0006\u0010\"\u001a\u00028\u00002\f\u0010\u0080\u0001\u001a\u0007\u0012\u0002\b\u00030\u0081\u0001H\u0002¢\u0006\u0003\u0010\u0083\u0001J!\u0010\u0084\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0085\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0086\u0001\u001a\u0004\u0018\u000109H\u0002J\"\u0010\u0092\u0001\u001a\u00020\b2\f\u0010\u0080\u0001\u001a\u0007\u0012\u0002\b\u00030\u0081\u00012\t\u0010\u0085\u0001\u001a\u0004\u0018\u000109H\u0002J\u0017\u0010\u0093\u0001\u001a\u00020\b2\f\u0010\u0080\u0001\u001a\u0007\u0012\u0002\b\u00030\u0081\u0001H\u0002J!\u0010\u0094\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0085\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0086\u0001\u001a\u0004\u0018\u000109H\u0002J!\u0010\u0095\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0085\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0086\u0001\u001a\u0004\u0018\u000109H\u0002J!\u0010\u0096\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0085\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0086\u0001\u001a\u0004\u0018\u000109H\u0002J\u0011\u0010\u009f\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000 \u0001H\u0096\u0002J\t\u0010ª\u0001\u001a\u00020\bH\u0014J\u0015\u0010«\u0001\u001a\u00020\u001a2\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0016J\u0013\u0010\u00ad\u0001\u001a\u00020\u001a2\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u009b\u0001J\u0007\u0010\u00ad\u0001\u001a\u00020\bJ \u0010\u00ad\u0001\u001a\u00020\b2\u0011\u0010¬\u0001\u001a\f\u0018\u00010¯\u0001j\u0005\u0018\u0001`®\u0001¢\u0006\u0003\u0010°\u0001J\u001b\u0010±\u0001\u001a\u00020\u001a2\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0010¢\u0006\u0003\b²\u0001J\u001e\u0010³\u0001\u001a\u00020\u001a2\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u009b\u00012\u0007\u0010\u00ad\u0001\u001a\u00020\u001aH\u0014J\t\u0010´\u0001\u001a\u00020\bH\u0002J1\u0010µ\u0001\u001a\u00020\b2&\u0010¶\u0001\u001a!\u0012\u0017\u0012\u0015\u0018\u00010\u009b\u0001¢\u0006\r\b>\u0012\t\b?\u0012\u0005\b\b(¬\u0001\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\t\u0010·\u0001\u001a\u00020\bH\u0002J\t\u0010¸\u0001\u001a\u00020\bH\u0002J\t\u0010¹\u0001\u001a\u00020\bH\u0002J\t\u0010º\u0001\u001a\u00020\bH\u0002J\u0018\u0010¼\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0007\u0010½\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010¾\u0001\u001a\u00020\b2\u0007\u0010½\u0001\u001a\u00020\u0011H\u0002J\u000f\u0010¿\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0002J\u0018\u0010À\u0001\u001a\u00020\u00112\r\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0002J\u0018\u0010Â\u0001\u001a\u00020\b2\r\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0002J \u0010Ã\u0001\u001a\u00020\b2\r\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\r\u0010Ä\u0001\u001a\u00020\b*\u00020+H\u0002J\r\u0010Å\u0001\u001a\u00020\b*\u00020+H\u0002J\u0016\u0010Æ\u0001\u001a\u00020\b*\u00020+2\u0007\u0010Ç\u0001\u001a\u00020\u001aH\u0002J\u001b\u0010Ï\u0001\u001a\u00020\u001a2\u0007\u0010Ð\u0001\u001a\u00020\u00112\u0007\u0010Ì\u0001\u001a\u00020\u001aH\u0002J\u000f\u0010Ó\u0001\u001a\u00020\u001aH\u0000¢\u0006\u0003\bÔ\u0001J'\u0010Õ\u0001\u001a\u00020\u001a2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010w\u001a\u00020\u0011H\u0002J)\u0010Ö\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001e2\u0007\u0010×\u0001\u001a\u00020\u00112\r\u0010Ø\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0002J)\u0010Ù\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001e2\u0007\u0010×\u0001\u001a\u00020\u00112\r\u0010Ø\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0002J2\u0010Ú\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001e2\u0007\u0010×\u0001\u001a\u00020\u00112\r\u0010Ø\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0007\u0010Û\u0001\u001a\u00020\u0011H\u0002J!\u0010Ü\u0001\u001a\u00020\b2\u0007\u0010×\u0001\u001a\u00020\u00112\r\u0010Ø\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0002J\u0012\u0010Ý\u0001\u001a\u00020\b2\u0007\u0010Þ\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010ß\u0001\u001a\u00020\b2\u0007\u0010Þ\u0001\u001a\u00020\u0011H\u0002J\n\u0010à\u0001\u001a\u00030á\u0001H\u0016J\u0010\u0010â\u0001\u001a\u00030á\u0001H\u0000¢\u0006\u0003\bã\u0001J\u0007\u0010ä\u0001\u001a\u00020\bJJ\u0010å\u0001\u001a#\u0012\u0005\u0012\u00030\u009b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000001\u0012\u0005\u0012\u00030\u009c\u0001\u0012\u0004\u0012\u00020\b0æ\u0001*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\u0006H\u0002¢\u0006\u0003\u0010ç\u0001J4\u0010è\u0001\u001a\u00020\b2\b\u0010¬\u0001\u001a\u00030\u009b\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u0000012\b\u0010é\u0001\u001a\u00030\u009c\u0001H\u0002¢\u0006\u0006\bê\u0001\u0010ë\u0001JM\u0010ì\u0001\u001a\u001e\u0012\u0005\u0012\u00030\u009b\u0001\u0012\u0006\u0012\u0004\u0018\u000109\u0012\u0005\u0012\u00030\u009c\u0001\u0012\u0004\u0012\u00020\b0j*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\u00062\u0006\u0010\"\u001a\u00028\u0000H\u0002¢\u0006\u0003\u0010í\u0001JD\u0010ì\u0001\u001a\u001d\u0012\u0005\u0012\u00030\u009b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0005\u0012\u00030\u009c\u0001\u0012\u0004\u0012\u00020\b0æ\u0001*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\u0006H\u0002¢\u0006\u0003\u0010ç\u0001J+\u0010î\u0001\u001a\u00020\b2\b\u0010¬\u0001\u001a\u00030\u009b\u00012\u0006\u0010\"\u001a\u00028\u00002\b\u0010é\u0001\u001a\u00030\u009c\u0001H\u0002¢\u0006\u0003\u0010ë\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00068\u0000X\u0081\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\t\u0010\f\u001a\u00020\rX\u0082\u0004R\t\u0010\u000e\u001a\u00020\rX\u0082\u0004R\t\u0010\u000f\u001a\u00020\rX\u0082\u0004R\u0014\u0010\u0010\u001a\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\t\u0010\u0018\u001a\u00020\rX\u0082\u0004R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001bR\u0015\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e0\u001dX\u0082\u0004R\u0015\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e0\u001dX\u0082\u0004R\u0015\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e0\u001dX\u0082\u0004R,\u0010y\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000z8VX\u0096\u0004¢\u0006\f\u0012\u0004\b{\u0010|\u001a\u0004\b}\u0010~R%\u0010\u0087\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0088\u00018VX\u0096\u0004¢\u0006\u000f\u0012\u0005\b\u0089\u0001\u0010|\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R+\u0010\u008c\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000010\u0088\u00018VX\u0096\u0004¢\u0006\u000f\u0012\u0005\b\u008d\u0001\u0010|\u001a\u0006\b\u008e\u0001\u0010\u008b\u0001R'\u0010\u008f\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0088\u00018VX\u0096\u0004¢\u0006\u000f\u0012\u0005\b\u0090\u0001\u0010|\u001a\u0006\b\u0091\u0001\u0010\u008b\u0001R\u008f\u0001\u0010\u0097\u0001\u001ax\u0012\u0019\u0012\u0017\u0012\u0002\b\u00030\u0081\u0001¢\u0006\r\b>\u0012\t\b?\u0012\u0005\b\b(\u0080\u0001\u0012\u0016\u0012\u0014\u0018\u000109¢\u0006\r\b>\u0012\t\b?\u0012\u0005\b\b(\u0099\u0001\u0012\u0016\u0012\u0014\u0018\u000109¢\u0006\r\b>\u0012\t\b?\u0012\u0005\b\b(\u009a\u0001\u0012 \u0012\u001e\u0012\u0005\u0012\u00030\u009b\u0001\u0012\u0006\u0012\u0004\u0018\u000109\u0012\u0005\u0012\u00030\u009c\u0001\u0012\u0004\u0012\u00020\b0j\u0018\u00010jj\u0005\u0018\u0001`\u0098\u0001X\u0082\u0004¢\u0006\f\n\u0003\u0010\u009e\u0001\u0012\u0005\b\u009d\u0001\u0010|R\u0012\u0010¡\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090\u001dX\u0082\u0004R\u001a\u0010¢\u0001\u001a\u0005\u0018\u00010\u009b\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\b£\u0001\u0010¤\u0001R\u0018\u0010¥\u0001\u001a\u00030\u009b\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\b¦\u0001\u0010¤\u0001R\u0018\u0010§\u0001\u001a\u00030\u009b\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b¨\u0001\u0010¤\u0001R\u0012\u0010©\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090\u001dX\u0082\u0004R\u0016\u0010»\u0001\u001a\u00020\u001a8TX\u0094\u0004¢\u0006\u0007\u001a\u0005\b»\u0001\u0010\u001bR\u001d\u0010È\u0001\u001a\u00020\u001a8VX\u0097\u0004¢\u0006\u000e\u0012\u0005\bÉ\u0001\u0010|\u001a\u0005\bÈ\u0001\u0010\u001bR\u001b\u0010Ê\u0001\u001a\u00020\u001a*\u00020\u00118BX\u0082\u0004¢\u0006\b\u001a\u0006\bÊ\u0001\u0010Ë\u0001R\u001d\u0010Ì\u0001\u001a\u00020\u001a8VX\u0097\u0004¢\u0006\u000e\u0012\u0005\bÍ\u0001\u0010|\u001a\u0005\bÌ\u0001\u0010\u001bR\u001b\u0010Î\u0001\u001a\u00020\u001a*\u00020\u00118BX\u0082\u0004¢\u0006\b\u001a\u0006\bÎ\u0001\u0010Ë\u0001R\u001d\u0010Ñ\u0001\u001a\u00020\u001a8VX\u0097\u0004¢\u0006\u000e\u0012\u0005\bÒ\u0001\u0010|\u001a\u0005\bÑ\u0001\u0010\u001b¨\u0006ñ\u0001"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel;", "E", "Lkotlinx/coroutines/channels/Channel;", "capacity", "", "onUndeliveredElement", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "Lkotlin/Function1;", "", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "sendersAndCloseStatus", "Lkotlinx/atomicfu/AtomicLong;", "receivers", "bufferEnd", "sendersCounter", "", "getSendersCounter$kotlinx_coroutines_core", "()J", "receiversCounter", "getReceiversCounter$kotlinx_coroutines_core", "bufferEndCounter", "getBufferEndCounter", "completedExpandBuffersAndPauseFlag", "isRendezvousOrUnlimited", "", "()Z", "sendSegment", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/channels/ChannelSegment;", "receiveSegment", "bufferEndSegment", "send", "element", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosedSend", "sendOnNoWaiterSuspend", "segment", "index", "s", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareSenderForSuspension", "Lkotlinx/coroutines/Waiter;", "onClosedSendOnNoWaiterSuspend", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "sendImpl", "R", "waiter", "", "onRendezvousOrBuffered", "Lkotlin/Function0;", "onSuspend", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "segm", "i", "onClosed", "onNoWaiterSuspend", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "trySendDropOldest", "trySendDropOldest-JP2dKIU", "sendImplOnNoWaiter", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlinx/coroutines/Waiter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "updateCellSend", "closed", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLjava/lang/Object;Z)I", "updateCellSendSlow", "shouldSendSuspend", "curSendersAndCloseStatus", "bufferOrRendezvousSend", "curSenders", "shouldSendSuspend$kotlinx_coroutines_core", "tryResumeReceiver", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "onReceiveEnqueued", "onReceiveDequeued", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveOnNoWaiterSuspend", "r", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareReceiverForSuspension", "onClosedReceiveOnNoWaiterSuspend", "receiveCatching", "receiveCatching-JP2dKIU", "receiveCatchingOnNoWaiterSuspend", "receiveCatchingOnNoWaiterSuspend-GKJJFZk", "onClosedReceiveCatchingOnNoWaiterSuspend", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "dropFirstElementUntilTheSpecifiedCellIsInTheBuffer", "globalCellIndex", "receiveImpl", "onElementRetrieved", "Lkotlin/Function3;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "receiveImplOnNoWaiter", "updateCellReceive", "updateCellReceiveSlow", "tryResumeSender", "expandBuffer", "updateCellExpandBuffer", "b", "updateCellExpandBufferSlow", "incCompletedExpandBufferAttempts", "nAttempts", "waitExpandBufferCompletion", "globalIndex", "waitExpandBufferCompletion$kotlinx_coroutines_core", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "()V", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "onClosedSelectOnSend", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)V", "processResultSelectSend", "ignoredParam", "selectResult", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive$annotations", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "getOnReceiveCatching$annotations", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull$annotations", "getOnReceiveOrNull", "registerSelectForReceive", "onClosedSelectOnReceive", "processResultSelectReceive", "processResultSelectReceiveOrNull", "processResultSelectReceiveCatching", "onUndeliveredElementReceiveCancellationConstructor", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "param", "internalResult", "", "Lkotlin/coroutines/CoroutineContext;", "getOnUndeliveredElementReceiveCancellationConstructor$annotations", "Lkotlin/jvm/functions/Function3;", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "_closeCause", "closeCause", "getCloseCause", "()Ljava/lang/Throwable;", "sendException", "getSendException", "receiveException", "getReceiveException", "closeHandler", "onClosedIdempotent", "close", "cause", "cancel", "Lkotlinx/coroutines/CancellationException;", "Ljava/util/concurrent/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "closeOrCancelImpl", "invokeCloseHandler", "invokeOnClose", "handler", "markClosed", "markCancelled", "markCancellationStarted", "completeCloseOrCancel", "isConflatedDropOldest", "completeClose", "sendersCur", "completeCancel", "closeLinkedList", "markAllEmptyCellsAsClosed", "lastSegment", "removeUnprocessedElements", "cancelSuspendedReceiveRequests", "resumeReceiverOnClosedChannel", "resumeSenderOnCancelledChannel", "resumeWaiterOnClosedChannel", "receiver", "isClosedForSend", "isClosedForSend$annotations", "isClosedForSend0", "(J)Z", "isClosedForReceive", "isClosedForReceive$annotations", "isClosedForReceive0", "isClosed", "sendersAndCloseStatusCur", "isEmpty", "isEmpty$annotations", "hasElements", "hasElements$kotlinx_coroutines_core", "isCellNonEmpty", "findSegmentSend", "id", "startFrom", "findSegmentReceive", "findSegmentBufferEnd", "currentBufferEndCounter", "moveSegmentBufferEndToSpecifiedOrLast", "updateSendersCounterIfLower", "value", "updateReceiversCounterIfLower", "toString", "", "toStringDebug", "toStringDebug$kotlinx_coroutines_core", "checkSegmentStructureInvariants", "bindCancellationFunResult", "Lkotlin/reflect/KFunction3;", "(Lkotlin/jvm/functions/Function1;)Lkotlin/reflect/KFunction;", "onCancellationChannelResultImplDoNotCall", "context", "onCancellationChannelResultImplDoNotCall-5_sEAP8", "(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", "bindCancellationFun", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Lkotlin/jvm/functions/Function3;", "onCancellationImplDoNotCall", "SendBroadcast", "BufferedChannelIterator", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes10.dex */
public class BufferedChannel<E> implements Channel<E> {
    private volatile /* synthetic */ Object _closeCause$volatile;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private final int capacity;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    public final Function1<E, Unit> onUndeliveredElement;
    private final Function3<SelectInstance<?>, Object, Object, Function3<Throwable, Object, CoroutineContext, Unit>> onUndeliveredElementReceiveCancellationConstructor;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;
    private static final /* synthetic */ AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater receivers$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater bufferEnd$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater sendSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater receiveSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater bufferEndSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _closeCause$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater closeHandler$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler$volatile");

    /* compiled from: BufferedChannel.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\n\u001a\u00020\tH\u0096B¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\tH\u0002J,\u0010\r\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u00162\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\u000e\u0010\u0019\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator;", "Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/Waiter;", "<init>", "(Lkotlinx/coroutines/channels/BufferedChannel;)V", "receiveResult", "", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "", "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosedHasNext", "hasNextOnNoWaiterSuspend", "segment", "Lkotlinx/coroutines/channels/ChannelSegment;", "index", "", "r", "", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnCancellation", "", "Lkotlinx/coroutines/internal/Segment;", "onClosedHasNextNoWaiterSuspend", "next", "()Ljava/lang/Object;", "tryResumeHasNext", "element", "(Ljava/lang/Object;)Z", "tryResumeHasNextOnClosedChannel", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes10.dex */
    private final class BufferedChannelIterator implements ChannelIterator<E>, Waiter {
        private CancellableContinuationImpl<? super Boolean> continuation;
        private Object receiveResult = BufferedChannelKt.access$getNO_RECEIVE_RESULT$p();

        public BufferedChannelIterator() {
        }

        public static final /* synthetic */ Object access$hasNextOnNoWaiterSuspend(BufferedChannelIterator bufferedChannelIterator, ChannelSegment channelSegment, int i, long j, Continuation continuation) {
            return bufferedChannelIterator.hasNextOnNoWaiterSuspend(channelSegment, i, j, continuation);
        }

        public static final /* synthetic */ void access$onClosedHasNextNoWaiterSuspend(BufferedChannelIterator bufferedChannelIterator) {
            bufferedChannelIterator.onClosedHasNextNoWaiterSuspend();
        }

        public static final /* synthetic */ void access$setContinuation$p(BufferedChannelIterator bufferedChannelIterator, CancellableContinuationImpl cancellableContinuationImpl) {
            bufferedChannelIterator.continuation = cancellableContinuationImpl;
        }

        public static final /* synthetic */ void access$setReceiveResult$p(BufferedChannelIterator bufferedChannelIterator, Object obj) {
            bufferedChannelIterator.receiveResult = obj;
        }

        private final Object hasNextOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int i, long j, Continuation<? super Boolean> continuation) {
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            boolean z = false;
            Continuation<? super Boolean> continuation2 = continuation;
            CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation2));
            try {
                access$setContinuation$p(this, orCreateCancellableContinuation);
                Object access$updateCellReceive = BufferedChannel.access$updateCellReceive(bufferedChannel, channelSegment, i, j, this);
                try {
                    if (access$updateCellReceive == BufferedChannelKt.access$getSUSPEND$p()) {
                        try {
                            BufferedChannel.access$prepareReceiverForSuspension(bufferedChannel, this, channelSegment, i);
                        } catch (Throwable th) {
                            th = th;
                            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                            throw th;
                        }
                    } else {
                        try {
                            if (access$updateCellReceive == BufferedChannelKt.access$getFAILED$p()) {
                                if (j < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                                    channelSegment.cleanPrev();
                                }
                                ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.access$getReceiveSegment$volatile$FU().get(bufferedChannel);
                                while (!bufferedChannel.isClosedForReceive()) {
                                    long andIncrement = BufferedChannel.access$getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
                                    long j2 = andIncrement / BufferedChannelKt.SEGMENT_SIZE;
                                    boolean z2 = z;
                                    try {
                                        Continuation<? super Boolean> continuation3 = continuation2;
                                        int i2 = (int) (andIncrement % BufferedChannelKt.SEGMENT_SIZE);
                                        if (channelSegment2.id != j2) {
                                            ChannelSegment access$findSegmentReceive = BufferedChannel.access$findSegmentReceive(bufferedChannel, j2, channelSegment2);
                                            if (access$findSegmentReceive == null) {
                                                z = z2;
                                                continuation2 = continuation3;
                                            } else {
                                                channelSegment2 = access$findSegmentReceive;
                                            }
                                        }
                                        ChannelSegment channelSegment3 = channelSegment2;
                                        Object access$updateCellReceive2 = BufferedChannel.access$updateCellReceive(bufferedChannel, channelSegment3, i2, andIncrement, this);
                                        if (access$updateCellReceive2 == BufferedChannelKt.access$getSUSPEND$p()) {
                                            BufferedChannelIterator bufferedChannelIterator = this instanceof Waiter ? this : null;
                                            if (bufferedChannelIterator != null) {
                                                BufferedChannel.access$prepareReceiverForSuspension(bufferedChannel, bufferedChannelIterator, channelSegment3, i2);
                                            }
                                        } else if (access$updateCellReceive2 == BufferedChannelKt.access$getFAILED$p()) {
                                            if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                                                channelSegment3.cleanPrev();
                                            }
                                            channelSegment2 = channelSegment3;
                                            z = z2;
                                            continuation2 = continuation3;
                                        } else {
                                            if (access$updateCellReceive2 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                                                throw new IllegalStateException("unexpected".toString());
                                            }
                                            channelSegment3.cleanPrev();
                                            access$setReceiveResult$p(this, access$updateCellReceive2);
                                            access$setContinuation$p(this, null);
                                            Boolean boxBoolean = Boxing.boxBoolean(true);
                                            Function1<E, Unit> function1 = bufferedChannel.onUndeliveredElement;
                                            orCreateCancellableContinuation.resume((CancellableContinuationImpl) boxBoolean, (Function3<? super Throwable, ? super CancellableContinuationImpl, ? super CoroutineContext, Unit>) (function1 != null ? BufferedChannel.access$bindCancellationFun(bufferedChannel, function1, access$updateCellReceive2) : null));
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                                        throw th;
                                    }
                                }
                                access$onClosedHasNextNoWaiterSuspend(this);
                            } else {
                                channelSegment.cleanPrev();
                                access$setReceiveResult$p(this, access$updateCellReceive);
                                access$setContinuation$p(this, null);
                                Boolean boxBoolean2 = Boxing.boxBoolean(true);
                                Function1<E, Unit> function12 = bufferedChannel.onUndeliveredElement;
                                orCreateCancellableContinuation.resume((CancellableContinuationImpl) boxBoolean2, (Function3<? super Throwable, ? super CancellableContinuationImpl, ? super CoroutineContext, Unit>) (function12 != null ? BufferedChannel.access$bindCancellationFun(bufferedChannel, function12, access$updateCellReceive) : null));
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    Object result = orCreateCancellableContinuation.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation);
                    }
                    return result;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }

        private final boolean onClosedHasNext() {
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                return false;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(closeCause);
        }

        private final void onClosedHasNextNoWaiterSuspend() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m457constructorimpl(false));
            } else {
                CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl2 = cancellableContinuationImpl;
                Throwable access$recoverFromStackFrame = (DebugKt.getRECOVER_STACK_TRACES() && (cancellableContinuationImpl instanceof CoroutineStackFrame)) ? StackTraceRecoveryKt.access$recoverFromStackFrame(closeCause, cancellableContinuationImpl) : closeCause;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuationImpl2.resumeWith(Result.m457constructorimpl(ResultKt.createFailure(access$recoverFromStackFrame)));
            }
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public Object hasNext(Continuation<? super Boolean> continuation) {
            ChannelSegment<E> channelSegment;
            boolean z = true;
            if (this.receiveResult == BufferedChannelKt.access$getNO_RECEIVE_RESULT$p() || this.receiveResult == BufferedChannelKt.getCHANNEL_CLOSED()) {
                BufferedChannel<E> bufferedChannel = BufferedChannel.this;
                ChannelSegment<E> channelSegment2 = (ChannelSegment) BufferedChannel.access$getReceiveSegment$volatile$FU().get(bufferedChannel);
                while (true) {
                    if (bufferedChannel.isClosedForReceive()) {
                        z = onClosedHasNext();
                        break;
                    }
                    long andIncrement = BufferedChannel.access$getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
                    long j = andIncrement / BufferedChannelKt.SEGMENT_SIZE;
                    int i = (int) (andIncrement % BufferedChannelKt.SEGMENT_SIZE);
                    if (channelSegment2.id != j) {
                        channelSegment = BufferedChannel.access$findSegmentReceive(bufferedChannel, j, channelSegment2);
                        if (channelSegment == null) {
                            continue;
                        }
                    } else {
                        channelSegment = channelSegment2;
                    }
                    Object access$updateCellReceive = BufferedChannel.access$updateCellReceive(bufferedChannel, channelSegment, i, andIncrement, null);
                    BufferedChannel<E> bufferedChannel2 = bufferedChannel;
                    ChannelSegment<E> channelSegment3 = channelSegment;
                    if (access$updateCellReceive == BufferedChannelKt.access$getSUSPEND$p()) {
                        throw new IllegalStateException("unreachable".toString());
                    }
                    if (access$updateCellReceive == BufferedChannelKt.access$getFAILED$p()) {
                        if (andIncrement < bufferedChannel2.getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment3.cleanPrev();
                        }
                        channelSegment2 = channelSegment3;
                        bufferedChannel = bufferedChannel2;
                    } else {
                        if (access$updateCellReceive == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                            return hasNextOnNoWaiterSuspend(channelSegment3, i, andIncrement, continuation);
                        }
                        channelSegment3.cleanPrev();
                        this.receiveResult = access$updateCellReceive;
                    }
                }
            }
            return Boxing.boxBoolean(z);
        }

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(Segment<?> segment, int index) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.invokeOnCancellation(segment, index);
            }
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            E e = (E) this.receiveResult;
            if (!(e != BufferedChannelKt.access$getNO_RECEIVE_RESULT$p())) {
                throw new IllegalStateException("`hasNext()` has not been invoked".toString());
            }
            this.receiveResult = BufferedChannelKt.access$getNO_RECEIVE_RESULT$p();
            if (e != BufferedChannelKt.getCHANNEL_CLOSED()) {
                return e;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(BufferedChannel.access$getReceiveException(BufferedChannel.this));
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public /* synthetic */ Object next(Continuation continuation) {
            return ChannelIterator.DefaultImpls.next(this, continuation);
        }

        public final boolean tryResumeHasNext(E element) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = element;
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl2 = cancellableContinuationImpl;
            Function1<E, Unit> function1 = BufferedChannel.this.onUndeliveredElement;
            return BufferedChannelKt.access$tryResume0(cancellableContinuationImpl2, true, function1 != null ? BufferedChannel.access$bindCancellationFun(BufferedChannel.this, function1, element) : null);
        }

        public final void tryResumeHasNextOnClosedChannel() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m457constructorimpl(false));
            } else {
                CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl2 = cancellableContinuationImpl;
                Throwable access$recoverFromStackFrame = (DebugKt.getRECOVER_STACK_TRACES() && (cancellableContinuationImpl instanceof CoroutineStackFrame)) ? StackTraceRecoveryKt.access$recoverFromStackFrame(closeCause, cancellableContinuationImpl) : closeCause;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuationImpl2.resumeWith(Result.m457constructorimpl(ResultKt.createFailure(access$recoverFromStackFrame)));
            }
        }
    }

    /* compiled from: BufferedChannel.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$SendBroadcast;", "Lkotlinx/coroutines/Waiter;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "<init>", "(Lkotlinx/coroutines/CancellableContinuation;)V", "getCont", "()Lkotlinx/coroutines/CancellableContinuation;", "invokeOnCancellation", "", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes10.dex */
    private static final class SendBroadcast implements Waiter {
        private final /* synthetic */ CancellableContinuationImpl<Boolean> $$delegate_0;
        private final CancellableContinuation<Boolean> cont;

        /* JADX WARN: Multi-variable type inference failed */
        public SendBroadcast(CancellableContinuation<? super Boolean> cancellableContinuation) {
            Intrinsics.checkNotNull(cancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.$$delegate_0 = (CancellableContinuationImpl) cancellableContinuation;
            this.cont = cancellableContinuation;
        }

        public final CancellableContinuation<Boolean> getCont() {
            return this.cont;
        }

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(Segment<?> segment, int index) {
            this.$$delegate_0.invokeOnCancellation(segment, index);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BufferedChannel(int i, Function1<? super E, Unit> function1) {
        ChannelSegment channelSegment;
        this.capacity = i;
        this.onUndeliveredElement = function1;
        if (!(this.capacity >= 0)) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + this.capacity + ", should be >=0").toString());
        }
        this.bufferEnd$volatile = BufferedChannelKt.access$initialBufferEnd(this.capacity);
        this.completedExpandBuffersAndPauseFlag$volatile = getBufferEndCounter();
        ChannelSegment channelSegment2 = new ChannelSegment(0L, null, this, 3);
        this.sendSegment$volatile = channelSegment2;
        this.receiveSegment$volatile = channelSegment2;
        if (isRendezvousOrUnlimited()) {
            channelSegment = BufferedChannelKt.access$getNULL_SEGMENT$p();
            Intrinsics.checkNotNull(channelSegment, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        } else {
            channelSegment = channelSegment2;
        }
        this.bufferEndSegment$volatile = channelSegment;
        this.onUndeliveredElementReceiveCancellationConstructor = this.onUndeliveredElement != null ? new BufferedChannel$$ExternalSyntheticLambda2(this) : null;
        this._closeCause$volatile = BufferedChannelKt.access$getNO_CLOSE_CAUSE$p();
    }

    public /* synthetic */ BufferedChannel(int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : function1);
    }

    public static final /* synthetic */ Function3 access$bindCancellationFun(BufferedChannel bufferedChannel, Function1 function1, Object obj) {
        return bufferedChannel.bindCancellationFun(function1, obj);
    }

    public static final /* synthetic */ KFunction access$bindCancellationFun(BufferedChannel bufferedChannel, Function1 function1) {
        return bufferedChannel.bindCancellationFun(function1);
    }

    public static final /* synthetic */ KFunction access$bindCancellationFunResult(BufferedChannel bufferedChannel, Function1 function1) {
        return bufferedChannel.bindCancellationFunResult(function1);
    }

    public static final /* synthetic */ ChannelSegment access$findSegmentReceive(BufferedChannel bufferedChannel, long j, ChannelSegment channelSegment) {
        return bufferedChannel.findSegmentReceive(j, channelSegment);
    }

    public static final /* synthetic */ ChannelSegment access$findSegmentSend(BufferedChannel bufferedChannel, long j, ChannelSegment channelSegment) {
        return bufferedChannel.findSegmentSend(j, channelSegment);
    }

    public static final /* synthetic */ Throwable access$getReceiveException(BufferedChannel bufferedChannel) {
        return bufferedChannel.getReceiveException();
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater access$getReceiveSegment$volatile$FU() {
        return getReceiveSegment$volatile$FU();
    }

    public static final /* synthetic */ AtomicLongFieldUpdater access$getReceivers$volatile$FU() {
        return getReceivers$volatile$FU();
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater access$getSendSegment$volatile$FU() {
        return getSendSegment$volatile$FU();
    }

    public static final /* synthetic */ AtomicLongFieldUpdater access$getSendersAndCloseStatus$volatile$FU() {
        return getSendersAndCloseStatus$volatile$FU();
    }

    public static final /* synthetic */ boolean access$isClosedForSend0(BufferedChannel bufferedChannel, long j) {
        return bufferedChannel.isClosedForSend0(j);
    }

    /* renamed from: access$onCancellationChannelResultImplDoNotCall-5_sEAP8, reason: not valid java name */
    public static final /* synthetic */ void m1948access$onCancellationChannelResultImplDoNotCall5_sEAP8(BufferedChannel bufferedChannel, Throwable th, Object obj, CoroutineContext coroutineContext) {
        bufferedChannel.m1950onCancellationChannelResultImplDoNotCall5_sEAP8(th, obj, coroutineContext);
    }

    public static final /* synthetic */ void access$onCancellationImplDoNotCall(BufferedChannel bufferedChannel, Throwable th, Object obj, CoroutineContext coroutineContext) {
        bufferedChannel.onCancellationImplDoNotCall(th, obj, coroutineContext);
    }

    public static final /* synthetic */ void access$onClosedReceiveCatchingOnNoWaiterSuspend(BufferedChannel bufferedChannel, CancellableContinuation cancellableContinuation) {
        bufferedChannel.onClosedReceiveCatchingOnNoWaiterSuspend(cancellableContinuation);
    }

    public static final /* synthetic */ void access$onClosedReceiveOnNoWaiterSuspend(BufferedChannel bufferedChannel, CancellableContinuation cancellableContinuation) {
        bufferedChannel.onClosedReceiveOnNoWaiterSuspend(cancellableContinuation);
    }

    public static final /* synthetic */ Object access$onClosedSend(BufferedChannel bufferedChannel, Object obj, Continuation continuation) {
        return bufferedChannel.onClosedSend(obj, continuation);
    }

    public static final /* synthetic */ void access$onClosedSendOnNoWaiterSuspend(BufferedChannel bufferedChannel, Object obj, CancellableContinuation cancellableContinuation) {
        bufferedChannel.onClosedSendOnNoWaiterSuspend(obj, cancellableContinuation);
    }

    public static final /* synthetic */ void access$prepareReceiverForSuspension(BufferedChannel bufferedChannel, Waiter waiter, ChannelSegment channelSegment, int i) {
        bufferedChannel.prepareReceiverForSuspension(waiter, channelSegment, i);
    }

    public static final /* synthetic */ void access$prepareSenderForSuspension(BufferedChannel bufferedChannel, Waiter waiter, ChannelSegment channelSegment, int i) {
        bufferedChannel.prepareSenderForSuspension(waiter, channelSegment, i);
    }

    public static final /* synthetic */ Object access$processResultSelectReceive(BufferedChannel bufferedChannel, Object obj, Object obj2) {
        return bufferedChannel.processResultSelectReceive(obj, obj2);
    }

    public static final /* synthetic */ Object access$processResultSelectReceiveCatching(BufferedChannel bufferedChannel, Object obj, Object obj2) {
        return bufferedChannel.processResultSelectReceiveCatching(obj, obj2);
    }

    public static final /* synthetic */ Object access$processResultSelectReceiveOrNull(BufferedChannel bufferedChannel, Object obj, Object obj2) {
        return bufferedChannel.processResultSelectReceiveOrNull(obj, obj2);
    }

    public static final /* synthetic */ Object access$processResultSelectSend(BufferedChannel bufferedChannel, Object obj, Object obj2) {
        return bufferedChannel.processResultSelectSend(obj, obj2);
    }

    /* renamed from: access$receiveCatchingOnNoWaiterSuspend-GKJJFZk, reason: not valid java name */
    public static final /* synthetic */ Object m1949access$receiveCatchingOnNoWaiterSuspendGKJJFZk(BufferedChannel bufferedChannel, ChannelSegment channelSegment, int i, long j, Continuation continuation) {
        return bufferedChannel.m1952receiveCatchingOnNoWaiterSuspendGKJJFZk(channelSegment, i, j, continuation);
    }

    public static final /* synthetic */ Object access$receiveOnNoWaiterSuspend(BufferedChannel bufferedChannel, ChannelSegment channelSegment, int i, long j, Continuation continuation) {
        return bufferedChannel.receiveOnNoWaiterSuspend(channelSegment, i, j, continuation);
    }

    public static final /* synthetic */ void access$registerSelectForReceive(BufferedChannel bufferedChannel, SelectInstance selectInstance, Object obj) {
        bufferedChannel.registerSelectForReceive(selectInstance, obj);
    }

    public static final /* synthetic */ Object access$sendOnNoWaiterSuspend(BufferedChannel bufferedChannel, ChannelSegment channelSegment, int i, Object obj, long j, Continuation continuation) {
        return bufferedChannel.sendOnNoWaiterSuspend(channelSegment, i, obj, j, continuation);
    }

    public static final /* synthetic */ Object access$updateCellReceive(BufferedChannel bufferedChannel, ChannelSegment channelSegment, int i, long j, Object obj) {
        return bufferedChannel.updateCellReceive(channelSegment, i, j, obj);
    }

    public static final /* synthetic */ int access$updateCellSend(BufferedChannel bufferedChannel, ChannelSegment channelSegment, int i, Object obj, long j, Object obj2, boolean z) {
        return bufferedChannel.updateCellSend(channelSegment, i, obj, j, obj2, z);
    }

    private final Function3<Throwable, Object, CoroutineContext, Unit> bindCancellationFun(Function1<? super E, Unit> function1, E e) {
        return new BufferedChannel$$ExternalSyntheticLambda3(function1, e);
    }

    private final KFunction<Unit> bindCancellationFun(Function1<? super E, Unit> function1) {
        return new BufferedChannel$bindCancellationFun$2(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit bindCancellationFun$lambda$89(Function1 function1, Object obj, Throwable th, Object obj2, CoroutineContext coroutineContext) {
        OnUndeliveredElementKt.callUndeliveredElement(function1, obj, coroutineContext);
        return Unit.INSTANCE;
    }

    private final KFunction<Unit> bindCancellationFunResult(Function1<? super E, Unit> function1) {
        return new BufferedChannel$bindCancellationFunResult$1(this);
    }

    private final boolean bufferOrRendezvousSend(long curSenders) {
        return curSenders < getBufferEndCounter() || curSenders < getReceiversCounter$kotlinx_coroutines_core() + ((long) this.capacity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void cancelSuspendedReceiveRequests(ChannelSegment<E> lastSegment, long sendersCounter) {
        Object m2000constructorimpl$default = InlineList.m2000constructorimpl$default(null, 1, null);
        loop0: for (ChannelSegment<E> channelSegment = lastSegment; channelSegment != null; channelSegment = (ChannelSegment) channelSegment.getPrev()) {
            for (int i = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < i; i--) {
                if ((channelSegment.id * BufferedChannelKt.SEGMENT_SIZE) + i < sendersCounter) {
                    break loop0;
                }
                while (true) {
                    Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
                    if (state$kotlinx_coroutines_core != null && state$kotlinx_coroutines_core != BufferedChannelKt.access$getIN_BUFFER$p()) {
                        if (!(state$kotlinx_coroutines_core instanceof WaiterEB)) {
                            if (!(state$kotlinx_coroutines_core instanceof Waiter)) {
                                break;
                            }
                            if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                m2000constructorimpl$default = InlineList.m2005plusFjFbRPM(m2000constructorimpl$default, state$kotlinx_coroutines_core);
                                channelSegment.onCancelledRequest(i, true);
                                break;
                            }
                        } else {
                            if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                m2000constructorimpl$default = InlineList.m2005plusFjFbRPM(m2000constructorimpl$default, ((WaiterEB) state$kotlinx_coroutines_core).waiter);
                                channelSegment.onCancelledRequest(i, true);
                                break;
                            }
                        }
                    } else {
                        if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            channelSegment.onSlotCleaned();
                            break;
                        }
                    }
                }
            }
        }
        if (m2000constructorimpl$default != null) {
            if (!(m2000constructorimpl$default instanceof ArrayList)) {
                resumeReceiverOnClosedChannel((Waiter) m2000constructorimpl$default);
                return;
            }
            Intrinsics.checkNotNull(m2000constructorimpl$default, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
            ArrayList arrayList = (ArrayList) m2000constructorimpl$default;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                resumeReceiverOnClosedChannel((Waiter) arrayList.get(size));
            }
        }
    }

    private final ChannelSegment<E> closeLinkedList() {
        Object obj = getBufferEndSegment$volatile$FU().get(this);
        ChannelSegment channelSegment = (ChannelSegment) getSendSegment$volatile$FU().get(this);
        if (channelSegment.id > ((ChannelSegment) obj).id) {
            obj = channelSegment;
        }
        ChannelSegment channelSegment2 = (ChannelSegment) getReceiveSegment$volatile$FU().get(this);
        if (channelSegment2.id > ((ChannelSegment) obj).id) {
            obj = channelSegment2;
        }
        return (ChannelSegment) ConcurrentLinkedListKt.close((ConcurrentLinkedListNode) obj);
    }

    private final void completeCancel(long sendersCur) {
        removeUnprocessedElements(completeClose(sendersCur));
    }

    private final ChannelSegment<E> completeClose(long sendersCur) {
        ChannelSegment<E> closeLinkedList = closeLinkedList();
        if (isConflatedDropOldest()) {
            long markAllEmptyCellsAsClosed = markAllEmptyCellsAsClosed(closeLinkedList);
            if (markAllEmptyCellsAsClosed != -1) {
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(markAllEmptyCellsAsClosed);
            }
        }
        cancelSuspendedReceiveRequests(closeLinkedList, sendersCur);
        return closeLinkedList;
    }

    private final void completeCloseOrCancel() {
        isClosedForSend();
    }

    private final void expandBuffer() {
        if (isRendezvousOrUnlimited()) {
            return;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) getBufferEndSegment$volatile$FU().get(this);
        while (true) {
            long andIncrement = getBufferEnd$volatile$FU().getAndIncrement(this);
            long j = andIncrement / BufferedChannelKt.SEGMENT_SIZE;
            if (getSendersCounter$kotlinx_coroutines_core() <= andIncrement) {
                if (channelSegment.id < j && channelSegment.getNext() != 0) {
                    moveSegmentBufferEndToSpecifiedOrLast(j, channelSegment);
                }
                incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            if (channelSegment.id != j) {
                ChannelSegment<E> findSegmentBufferEnd = findSegmentBufferEnd(j, channelSegment, andIncrement);
                if (findSegmentBufferEnd == null) {
                    continue;
                } else {
                    channelSegment = findSegmentBufferEnd;
                }
            }
            if (updateCellExpandBuffer(channelSegment, (int) (andIncrement % BufferedChannelKt.SEGMENT_SIZE), andIncrement)) {
                incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
        }
    }

    private final ChannelSegment<E> findSegmentBufferEnd(long id, ChannelSegment<E> startFrom, long currentBufferEndCounter) {
        Object findSegmentInternal;
        boolean z;
        AtomicReferenceFieldUpdater bufferEndSegment$volatile$FU2 = getBufferEndSegment$volatile$FU();
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        do {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, function2);
            if (SegmentOrClosed.m2017isClosedimpl(findSegmentInternal)) {
                break;
            }
            Segment m2015getSegmentimpl = SegmentOrClosed.m2015getSegmentimpl(findSegmentInternal);
            while (true) {
                Segment segment = (Segment) bufferEndSegment$volatile$FU2.get(this);
                if (segment.id >= m2015getSegmentimpl.id) {
                    z = true;
                    break;
                }
                if (!m2015getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                    z = false;
                    break;
                }
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(bufferEndSegment$volatile$FU2, this, segment, m2015getSegmentimpl)) {
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                    z = true;
                } else if (m2015getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                    m2015getSegmentimpl.remove();
                }
            }
        } while (!z);
        if (SegmentOrClosed.m2017isClosedimpl(findSegmentInternal)) {
            completeCloseOrCancel();
            moveSegmentBufferEndToSpecifiedOrLast(id, startFrom);
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
            return null;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) SegmentOrClosed.m2015getSegmentimpl(findSegmentInternal);
        if (channelSegment.id <= id) {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!(channelSegment.id == id)) {
                    throw new AssertionError();
                }
            }
            return channelSegment;
        }
        if (getBufferEnd$volatile$FU().compareAndSet(this, currentBufferEndCounter + 1, channelSegment.id * BufferedChannelKt.SEGMENT_SIZE)) {
            incCompletedExpandBufferAttempts((channelSegment.id * BufferedChannelKt.SEGMENT_SIZE) - currentBufferEndCounter);
            return null;
        }
        incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
        return null;
    }

    private final ChannelSegment<E> findSegmentReceive(long id, ChannelSegment<E> startFrom) {
        Object findSegmentInternal;
        boolean z;
        AtomicReferenceFieldUpdater receiveSegment$volatile$FU2 = getReceiveSegment$volatile$FU();
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        do {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, function2);
            if (SegmentOrClosed.m2017isClosedimpl(findSegmentInternal)) {
                break;
            }
            Segment m2015getSegmentimpl = SegmentOrClosed.m2015getSegmentimpl(findSegmentInternal);
            while (true) {
                Segment segment = (Segment) receiveSegment$volatile$FU2.get(this);
                if (segment.id >= m2015getSegmentimpl.id) {
                    z = true;
                    break;
                }
                if (!m2015getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                    z = false;
                    break;
                }
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(receiveSegment$volatile$FU2, this, segment, m2015getSegmentimpl)) {
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                    z = true;
                } else if (m2015getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                    m2015getSegmentimpl.remove();
                }
            }
        } while (!z);
        if (SegmentOrClosed.m2017isClosedimpl(findSegmentInternal)) {
            completeCloseOrCancel();
            if (startFrom.id * BufferedChannelKt.SEGMENT_SIZE < getSendersCounter$kotlinx_coroutines_core()) {
                startFrom.cleanPrev();
            }
            return null;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) SegmentOrClosed.m2015getSegmentimpl(findSegmentInternal);
        if (!isRendezvousOrUnlimited() && id <= getBufferEndCounter() / BufferedChannelKt.SEGMENT_SIZE) {
            AtomicReferenceFieldUpdater bufferEndSegment$volatile$FU2 = getBufferEndSegment$volatile$FU();
            while (true) {
                Segment segment2 = (Segment) bufferEndSegment$volatile$FU2.get(this);
                if (segment2.id >= channelSegment.id || !channelSegment.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(bufferEndSegment$volatile$FU2, this, segment2, channelSegment)) {
                    if (segment2.decPointers$kotlinx_coroutines_core()) {
                        segment2.remove();
                    }
                } else if (channelSegment.decPointers$kotlinx_coroutines_core()) {
                    channelSegment.remove();
                }
            }
        }
        if (channelSegment.id > id) {
            updateReceiversCounterIfLower(channelSegment.id * BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment.id * BufferedChannelKt.SEGMENT_SIZE < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            return null;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(channelSegment.id == id)) {
                throw new AssertionError();
            }
        }
        return channelSegment;
    }

    private final ChannelSegment<E> findSegmentSend(long id, ChannelSegment<E> startFrom) {
        Object findSegmentInternal;
        boolean z;
        AtomicReferenceFieldUpdater sendSegment$volatile$FU2 = getSendSegment$volatile$FU();
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        do {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, function2);
            if (SegmentOrClosed.m2017isClosedimpl(findSegmentInternal)) {
                break;
            }
            Segment m2015getSegmentimpl = SegmentOrClosed.m2015getSegmentimpl(findSegmentInternal);
            while (true) {
                Segment segment = (Segment) sendSegment$volatile$FU2.get(this);
                if (segment.id >= m2015getSegmentimpl.id) {
                    z = true;
                    break;
                }
                if (!m2015getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                    z = false;
                    break;
                }
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(sendSegment$volatile$FU2, this, segment, m2015getSegmentimpl)) {
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                    z = true;
                } else if (m2015getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                    m2015getSegmentimpl.remove();
                }
            }
        } while (!z);
        if (SegmentOrClosed.m2017isClosedimpl(findSegmentInternal)) {
            completeCloseOrCancel();
            if (startFrom.id * BufferedChannelKt.SEGMENT_SIZE >= getReceiversCounter$kotlinx_coroutines_core()) {
                return null;
            }
            startFrom.cleanPrev();
            return null;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) SegmentOrClosed.m2015getSegmentimpl(findSegmentInternal);
        if (channelSegment.id <= id) {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!(channelSegment.id == id)) {
                    throw new AssertionError();
                }
            }
            return channelSegment;
        }
        updateSendersCounterIfLower(channelSegment.id * BufferedChannelKt.SEGMENT_SIZE);
        if (channelSegment.id * BufferedChannelKt.SEGMENT_SIZE >= getReceiversCounter$kotlinx_coroutines_core()) {
            return null;
        }
        channelSegment.cleanPrev();
        return null;
    }

    private final /* synthetic */ Object getAndUpdate$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function1) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, obj, obj2, function1.invoke(obj2)));
        return obj2;
    }

    private final /* synthetic */ long getBufferEnd$volatile() {
        return this.bufferEnd$volatile;
    }

    private static final /* synthetic */ AtomicLongFieldUpdater getBufferEnd$volatile$FU() {
        return bufferEnd$volatile$FU;
    }

    private final long getBufferEndCounter() {
        return getBufferEnd$volatile$FU().get(this);
    }

    private final /* synthetic */ Object getBufferEndSegment$volatile() {
        return this.bufferEndSegment$volatile;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater getBufferEndSegment$volatile$FU() {
        return bufferEndSegment$volatile$FU;
    }

    private final /* synthetic */ Object getCloseHandler$volatile() {
        return this.closeHandler$volatile;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater getCloseHandler$volatile$FU() {
        return closeHandler$volatile$FU;
    }

    private final /* synthetic */ long getCompletedExpandBuffersAndPauseFlag$volatile() {
        return this.completedExpandBuffersAndPauseFlag$volatile;
    }

    private static final /* synthetic */ AtomicLongFieldUpdater getCompletedExpandBuffersAndPauseFlag$volatile$FU() {
        return completedExpandBuffersAndPauseFlag$volatile$FU;
    }

    public static /* synthetic */ void getOnReceive$annotations() {
    }

    public static /* synthetic */ void getOnReceiveCatching$annotations() {
    }

    public static /* synthetic */ void getOnReceiveOrNull$annotations() {
    }

    public static /* synthetic */ void getOnSend$annotations() {
    }

    private static /* synthetic */ void getOnUndeliveredElementReceiveCancellationConstructor$annotations() {
    }

    private final Throwable getReceiveException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE) : closeCause;
    }

    private final /* synthetic */ Object getReceiveSegment$volatile() {
        return this.receiveSegment$volatile;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater getReceiveSegment$volatile$FU() {
        return receiveSegment$volatile$FU;
    }

    private final /* synthetic */ long getReceivers$volatile() {
        return this.receivers$volatile;
    }

    private static final /* synthetic */ AtomicLongFieldUpdater getReceivers$volatile$FU() {
        return receivers$volatile$FU;
    }

    private final /* synthetic */ Object getSendSegment$volatile() {
        return this.sendSegment$volatile;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater getSendSegment$volatile$FU() {
        return sendSegment$volatile$FU;
    }

    private final /* synthetic */ long getSendersAndCloseStatus$volatile() {
        return this.sendersAndCloseStatus$volatile;
    }

    private static final /* synthetic */ AtomicLongFieldUpdater getSendersAndCloseStatus$volatile$FU() {
        return sendersAndCloseStatus$volatile$FU;
    }

    private final /* synthetic */ Object get_closeCause$volatile() {
        return this._closeCause$volatile;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater get_closeCause$volatile$FU() {
        return _closeCause$volatile$FU;
    }

    private final void incCompletedExpandBufferAttempts(long nAttempts) {
        if (!((getCompletedExpandBuffersAndPauseFlag$volatile$FU().addAndGet(this, nAttempts) & 4611686018427387904L) != 0)) {
            return;
        }
        do {
        } while ((getCompletedExpandBuffersAndPauseFlag$volatile$FU().get(this) & 4611686018427387904L) != 0);
    }

    static /* synthetic */ void incCompletedExpandBufferAttempts$default(BufferedChannel bufferedChannel, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i & 1) != 0) {
            j = 1;
        }
        bufferedChannel.incCompletedExpandBufferAttempts(j);
    }

    private final void invokeCloseHandler() {
        Object obj;
        AtomicReferenceFieldUpdater closeHandler$volatile$FU2 = getCloseHandler$volatile$FU();
        do {
            obj = closeHandler$volatile$FU2.get(this);
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(closeHandler$volatile$FU2, this, obj, obj == null ? BufferedChannelKt.access$getCLOSE_HANDLER_CLOSED$p() : BufferedChannelKt.access$getCLOSE_HANDLER_INVOKED$p()));
        if (obj == null) {
            return;
        }
        ((Function1) obj).invoke(getCloseCause());
    }

    private final boolean isCellNonEmpty(ChannelSegment<E> segment, int index, long globalIndex) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core != null && state$kotlinx_coroutines_core != BufferedChannelKt.access$getIN_BUFFER$p()) {
                if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                    return true;
                }
                if (state$kotlinx_coroutines_core == BufferedChannelKt.access$getINTERRUPTED_SEND$p() || state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED() || state$kotlinx_coroutines_core == BufferedChannelKt.access$getDONE_RCV$p() || state$kotlinx_coroutines_core == BufferedChannelKt.access$getPOISONED$p()) {
                    return false;
                }
                if (state$kotlinx_coroutines_core == BufferedChannelKt.access$getRESUMING_BY_EB$p()) {
                    return true;
                }
                return state$kotlinx_coroutines_core != BufferedChannelKt.access$getRESUMING_BY_RCV$p() && globalIndex == getReceiversCounter$kotlinx_coroutines_core();
            }
        } while (!segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.access$getPOISONED$p()));
        expandBuffer();
        return false;
    }

    private final boolean isClosed(long sendersAndCloseStatusCur, boolean isClosedForReceive) {
        switch ((int) (sendersAndCloseStatusCur >> 60)) {
            case 0:
                return false;
            case 1:
                return false;
            case 2:
                completeClose(sendersAndCloseStatusCur & 1152921504606846975L);
                return (isClosedForReceive && hasElements$kotlinx_coroutines_core()) ? false : true;
            case 3:
                completeCancel(sendersAndCloseStatusCur & 1152921504606846975L);
                return true;
            default:
                throw new IllegalStateException(("unexpected close status: " + ((int) (sendersAndCloseStatusCur >> 60))).toString());
        }
    }

    public static /* synthetic */ void isClosedForReceive$annotations() {
    }

    private final boolean isClosedForReceive0(long j) {
        return isClosed(j, true);
    }

    public static /* synthetic */ void isClosedForSend$annotations() {
    }

    private final boolean isClosedForSend0(long j) {
        return isClosed(j, false);
    }

    public static /* synthetic */ void isEmpty$annotations() {
    }

    private final boolean isRendezvousOrUnlimited() {
        long bufferEndCounter = getBufferEndCounter();
        return bufferEndCounter == 0 || bufferEndCounter == Long.MAX_VALUE;
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Unit> function1) {
        while (true) {
            function1.invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0041, code lost:
    
        r1 = (kotlinx.coroutines.channels.ChannelSegment) r0.getPrev();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        if (r1 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0049, code lost:
    
        return -1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long markAllEmptyCellsAsClosed(kotlinx.coroutines.channels.ChannelSegment<E> r9) {
        /*
            r8 = this;
            r0 = r9
        L1:
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            int r1 = r1 + (-1)
        L6:
            r2 = -1
            r4 = -1
            if (r4 >= r1) goto L41
            long r4 = r0.id
            int r6 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r6 = (long) r6
            long r4 = r4 * r6
            long r6 = (long) r1
            long r4 = r4 + r6
            long r6 = r8.getReceiversCounter$kotlinx_coroutines_core()
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 >= 0) goto L1c
            return r2
        L1c:
            java.lang.Object r2 = r0.getState$kotlinx_coroutines_core(r1)
            if (r2 == 0) goto L30
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.BufferedChannelKt.access$getIN_BUFFER$p()
            if (r2 == r3) goto L30
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED
            if (r2 != r3) goto L2f
            return r4
        L2f:
            goto L3e
        L30:
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r3 = r0.casState$kotlinx_coroutines_core(r1, r2, r3)
            if (r3 == 0) goto L1c
            r0.onSlotCleaned()
        L3e:
            int r1 = r1 + (-1)
            goto L6
        L41:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r1 = r0.getPrev()
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1
            if (r1 != 0) goto L4a
            return r2
        L4a:
            r0 = r1
            goto L1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.markAllEmptyCellsAsClosed(kotlinx.coroutines.channels.ChannelSegment):long");
    }

    private final void markCancellationStarted() {
        long j;
        AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU2 = getSendersAndCloseStatus$volatile$FU();
        do {
            j = sendersAndCloseStatus$volatile$FU2.get(this);
            if (((int) (j >> 60)) != 0) {
                return;
            }
        } while (!sendersAndCloseStatus$volatile$FU2.compareAndSet(this, j, BufferedChannelKt.access$constructSendersAndCloseStatus(j & 1152921504606846975L, 1)));
    }

    private final void markCancelled() {
        long j;
        AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU2 = getSendersAndCloseStatus$volatile$FU();
        do {
            j = sendersAndCloseStatus$volatile$FU2.get(this);
        } while (!sendersAndCloseStatus$volatile$FU2.compareAndSet(this, j, BufferedChannelKt.access$constructSendersAndCloseStatus(j & 1152921504606846975L, 3)));
    }

    private final void markClosed() {
        long j;
        long access$constructSendersAndCloseStatus;
        AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU2 = getSendersAndCloseStatus$volatile$FU();
        do {
            j = sendersAndCloseStatus$volatile$FU2.get(this);
            switch ((int) (j >> 60)) {
                case 0:
                    access$constructSendersAndCloseStatus = BufferedChannelKt.access$constructSendersAndCloseStatus(j & 1152921504606846975L, 2);
                    break;
                case 1:
                    access$constructSendersAndCloseStatus = BufferedChannelKt.access$constructSendersAndCloseStatus(j & 1152921504606846975L, 3);
                    break;
                default:
                    return;
            }
        } while (!sendersAndCloseStatus$volatile$FU2.compareAndSet(this, j, access$constructSendersAndCloseStatus));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void moveSegmentBufferEndToSpecifiedOrLast(long id, ChannelSegment<E> startFrom) {
        boolean z;
        ChannelSegment<E> channelSegment;
        ChannelSegment<E> channelSegment2;
        ChannelSegment<E> channelSegment3 = startFrom;
        while (channelSegment3.id < id && (channelSegment2 = (ChannelSegment) channelSegment3.getNext()) != null) {
            channelSegment3 = channelSegment2;
        }
        while (true) {
            if (!channelSegment3.isRemoved() || (channelSegment = (ChannelSegment) channelSegment3.getNext()) == null) {
                AtomicReferenceFieldUpdater bufferEndSegment$volatile$FU2 = getBufferEndSegment$volatile$FU();
                while (true) {
                    Segment segment = (Segment) bufferEndSegment$volatile$FU2.get(this);
                    z = true;
                    if (segment.id >= channelSegment3.id) {
                        break;
                    }
                    if (!channelSegment3.tryIncPointers$kotlinx_coroutines_core()) {
                        z = false;
                        break;
                    } else if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(bufferEndSegment$volatile$FU2, this, segment, channelSegment3)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (channelSegment3.decPointers$kotlinx_coroutines_core()) {
                        channelSegment3.remove();
                    }
                }
                if (z) {
                    return;
                }
            } else {
                channelSegment3 = channelSegment;
            }
        }
    }

    /* renamed from: onCancellationChannelResultImplDoNotCall-5_sEAP8, reason: not valid java name */
    private final void m1950onCancellationChannelResultImplDoNotCall5_sEAP8(Throwable cause, Object element, CoroutineContext context) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        Intrinsics.checkNotNull(function1);
        Object m1966getOrNullimpl = ChannelResult.m1966getOrNullimpl(element);
        Intrinsics.checkNotNull(m1966getOrNullimpl);
        OnUndeliveredElementKt.callUndeliveredElement(function1, m1966getOrNullimpl, context);
    }

    private final void onCancellationImplDoNotCall(Throwable cause, E element, CoroutineContext context) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        Intrinsics.checkNotNull(function1);
        OnUndeliveredElementKt.callUndeliveredElement(function1, element, context);
    }

    private final void onClosedReceiveCatchingOnNoWaiterSuspend(CancellableContinuation<? super ChannelResult<? extends E>> cont) {
        Result.Companion companion = Result.INSTANCE;
        cont.resumeWith(Result.m457constructorimpl(ChannelResult.m1961boximpl(ChannelResult.INSTANCE.m1974closedJP2dKIU(getCloseCause()))));
    }

    private final void onClosedReceiveOnNoWaiterSuspend(CancellableContinuation<? super E> cont) {
        Result.Companion companion = Result.INSTANCE;
        cont.resumeWith(Result.m457constructorimpl(ResultKt.createFailure(getReceiveException())));
    }

    private final void onClosedSelectOnReceive(SelectInstance<?> select) {
        select.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    private final void onClosedSelectOnSend(E element, SelectInstance<?> select) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, element, select.getContext());
        }
        select.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    private final Object onClosedSend(E e, Continuation<? super Unit> continuation) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 == null || (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e, null, 2, null)) == null) {
            CancellableContinuationImpl cancellableContinuationImpl3 = cancellableContinuationImpl2;
            Throwable sendException = getSendException();
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl3.resumeWith(Result.m457constructorimpl(ResultKt.createFailure((DebugKt.getRECOVER_STACK_TRACES() && (cancellableContinuationImpl3 instanceof CoroutineStackFrame)) ? StackTraceRecoveryKt.access$recoverFromStackFrame(sendException, cancellableContinuationImpl3) : sendException)));
        } else {
            ExceptionsKt.addSuppressed(callUndeliveredElementCatchingException$default, getSendException());
            CancellableContinuationImpl cancellableContinuationImpl4 = cancellableContinuationImpl2;
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuationImpl4.resumeWith(Result.m457constructorimpl(ResultKt.createFailure((DebugKt.getRECOVER_STACK_TRACES() && (cancellableContinuationImpl4 instanceof CoroutineStackFrame)) ? StackTraceRecoveryKt.access$recoverFromStackFrame(callUndeliveredElementCatchingException$default, cancellableContinuationImpl4) : callUndeliveredElementCatchingException$default)));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    private final void onClosedSendOnNoWaiterSuspend(E element, CancellableContinuation<? super Unit> cont) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, element, cont.getContext());
        }
        CancellableContinuation<? super Unit> cancellableContinuation = cont;
        Throwable sendException = getSendException();
        if (DebugKt.getRECOVER_STACK_TRACES() && (cont instanceof CoroutineStackFrame)) {
            sendException = StackTraceRecoveryKt.access$recoverFromStackFrame(sendException, (CoroutineStackFrame) cont);
        }
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m457constructorimpl(ResultKt.createFailure(sendException)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Function3 onUndeliveredElementReceiveCancellationConstructor$lambda$57$lambda$56(BufferedChannel bufferedChannel, SelectInstance selectInstance, Object obj, Object obj2) {
        return new BufferedChannel$$ExternalSyntheticLambda1(obj2, bufferedChannel, selectInstance);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onUndeliveredElementReceiveCancellationConstructor$lambda$57$lambda$56$lambda$55(Object obj, BufferedChannel bufferedChannel, SelectInstance selectInstance, Throwable th, Object obj2, CoroutineContext coroutineContext) {
        if (obj != BufferedChannelKt.getCHANNEL_CLOSED()) {
            OnUndeliveredElementKt.callUndeliveredElement(bufferedChannel.onUndeliveredElement, obj, selectInstance.getContext());
        }
        return Unit.INSTANCE;
    }

    private final void prepareReceiverForSuspension(Waiter waiter, ChannelSegment<E> channelSegment, int i) {
        onReceiveEnqueued();
        waiter.invokeOnCancellation(channelSegment, i);
    }

    private final void prepareSenderForSuspension(Waiter waiter, ChannelSegment<E> channelSegment, int i) {
        waiter.invokeOnCancellation(channelSegment, BufferedChannelKt.SEGMENT_SIZE + i);
    }

    private final Object processResultSelectReceive(Object ignoredParam, Object selectResult) {
        if (selectResult != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return selectResult;
        }
        throw getReceiveException();
    }

    private final Object processResultSelectReceiveCatching(Object ignoredParam, Object selectResult) {
        return ChannelResult.m1961boximpl(selectResult == BufferedChannelKt.getCHANNEL_CLOSED() ? ChannelResult.INSTANCE.m1974closedJP2dKIU(getCloseCause()) : ChannelResult.INSTANCE.m1976successJP2dKIU(selectResult));
    }

    private final Object processResultSelectReceiveOrNull(Object ignoredParam, Object selectResult) {
        if (selectResult != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return selectResult;
        }
        if (getCloseCause() == null) {
            return null;
        }
        throw getReceiveException();
    }

    private final Object processResultSelectSend(Object ignoredParam, Object selectResult) {
        if (selectResult != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return this;
        }
        throw getSendException();
    }

    static /* synthetic */ <E> Object receive$suspendImpl(BufferedChannel<E> bufferedChannel, Continuation<? super E> continuation) {
        ChannelSegment<E> channelSegment = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = access$getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
            long j = andIncrement / BufferedChannelKt.SEGMENT_SIZE;
            int i = (int) (andIncrement % BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment.id != j) {
                ChannelSegment<E> access$findSegmentReceive = access$findSegmentReceive(bufferedChannel, j, channelSegment);
                if (access$findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = access$findSegmentReceive;
                }
            }
            Object access$updateCellReceive = access$updateCellReceive(bufferedChannel, channelSegment, i, andIncrement, null);
            if (access$updateCellReceive == BufferedChannelKt.access$getSUSPEND$p()) {
                throw new IllegalStateException("unexpected".toString());
            }
            if (access$updateCellReceive != BufferedChannelKt.access$getFAILED$p()) {
                if (access$updateCellReceive == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                    return bufferedChannel.receiveOnNoWaiterSuspend(channelSegment, i, andIncrement, continuation);
                }
                channelSegment.cleanPrev();
                return access$updateCellReceive;
            }
            if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
        }
        throw StackTraceRecoveryKt.recoverStackTrace(bufferedChannel.getReceiveException());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: receiveCatching-JP2dKIU$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ <E> java.lang.Object m1951receiveCatchingJP2dKIU$suspendImpl(kotlinx.coroutines.channels.BufferedChannel<E> r14, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r15) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.m1951receiveCatchingJP2dKIU$suspendImpl(kotlinx.coroutines.channels.BufferedChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* renamed from: receiveCatchingOnNoWaiterSuspend-GKJJFZk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object m1952receiveCatchingOnNoWaiterSuspendGKJJFZk(kotlinx.coroutines.channels.ChannelSegment<E> r26, int r27, long r28, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r30) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.m1952receiveCatchingOnNoWaiterSuspendGKJJFZk(kotlinx.coroutines.channels.ChannelSegment, int, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final <R> R receiveImpl(Object waiter, Function1<? super E, ? extends R> onElementRetrieved, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> onSuspend, Function0<? extends R> onClosed, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> onNoWaiterSuspend) {
        ChannelSegment channelSegment = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(this);
        while (!isClosedForReceive()) {
            long andIncrement = access$getReceivers$volatile$FU().getAndIncrement(this);
            long j = andIncrement / BufferedChannelKt.SEGMENT_SIZE;
            int i = (int) (andIncrement % BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment.id != j) {
                ChannelSegment access$findSegmentReceive = access$findSegmentReceive(this, j, channelSegment);
                if (access$findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = access$findSegmentReceive;
                }
            }
            Symbol symbol = (Object) access$updateCellReceive(this, channelSegment, i, andIncrement, waiter);
            if (symbol == BufferedChannelKt.access$getSUSPEND$p()) {
                Waiter waiter2 = waiter instanceof Waiter ? (Waiter) waiter : null;
                if (waiter2 != null) {
                    access$prepareReceiverForSuspension(this, waiter2, channelSegment, i);
                }
                return onSuspend.invoke(channelSegment, Integer.valueOf(i), Long.valueOf(andIncrement));
            }
            if (symbol != BufferedChannelKt.access$getFAILED$p()) {
                if (symbol == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                    return onNoWaiterSuspend.invoke(channelSegment, Integer.valueOf(i), Long.valueOf(andIncrement));
                }
                channelSegment.cleanPrev();
                return onElementRetrieved.invoke(symbol);
            }
            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
        }
        return onClosed.invoke();
    }

    static /* synthetic */ Object receiveImpl$default(BufferedChannel bufferedChannel, Object obj, Function1 function1, Function3 function3, Function0 function0, Function3 function32, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveImpl");
        }
        Function3 function33 = (i & 16) != 0 ? BufferedChannel$receiveImpl$1.INSTANCE : function32;
        ChannelSegment channelSegment = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = access$getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
            long j = andIncrement / BufferedChannelKt.SEGMENT_SIZE;
            int i2 = (int) (andIncrement % BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment.id != j) {
                ChannelSegment access$findSegmentReceive = access$findSegmentReceive(bufferedChannel, j, channelSegment);
                if (access$findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = access$findSegmentReceive;
                }
            }
            Object access$updateCellReceive = access$updateCellReceive(bufferedChannel, channelSegment, i2, andIncrement, obj);
            if (access$updateCellReceive == BufferedChannelKt.access$getSUSPEND$p()) {
                Waiter waiter = obj instanceof Waiter ? (Waiter) obj : null;
                if (waiter != null) {
                    access$prepareReceiverForSuspension(bufferedChannel, waiter, channelSegment, i2);
                }
                return function3.invoke(channelSegment, Integer.valueOf(i2), Long.valueOf(andIncrement));
            }
            if (access$updateCellReceive != BufferedChannelKt.access$getFAILED$p()) {
                if (access$updateCellReceive == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                    return function33.invoke(channelSegment, Integer.valueOf(i2), Long.valueOf(andIncrement));
                }
                channelSegment.cleanPrev();
                return function1.invoke(access$updateCellReceive);
            }
            if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
        }
        return function0.invoke();
    }

    private final void receiveImplOnNoWaiter(ChannelSegment<E> segment, int index, long r, Waiter waiter, Function1<? super E, Unit> onElementRetrieved, Function0<Unit> onClosed) {
        Symbol symbol = (Object) access$updateCellReceive(this, segment, index, r, waiter);
        if (symbol == BufferedChannelKt.access$getSUSPEND$p()) {
            access$prepareReceiverForSuspension(this, waiter, segment, index);
            return;
        }
        if (symbol != BufferedChannelKt.access$getFAILED$p()) {
            segment.cleanPrev();
            onElementRetrieved.invoke(symbol);
            return;
        }
        if (r < getSendersCounter$kotlinx_coroutines_core()) {
            segment.cleanPrev();
        }
        ChannelSegment channelSegment = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(this);
        while (!isClosedForReceive()) {
            long andIncrement = access$getReceivers$volatile$FU().getAndIncrement(this);
            long j = andIncrement / BufferedChannelKt.SEGMENT_SIZE;
            int i = (int) (andIncrement % BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment.id != j) {
                ChannelSegment access$findSegmentReceive = access$findSegmentReceive(this, j, channelSegment);
                if (access$findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = access$findSegmentReceive;
                }
            }
            Symbol symbol2 = (Object) access$updateCellReceive(this, channelSegment, i, andIncrement, waiter);
            if (symbol2 == BufferedChannelKt.access$getSUSPEND$p()) {
                Waiter waiter2 = waiter instanceof Waiter ? waiter : null;
                if (waiter2 != null) {
                    access$prepareReceiverForSuspension(this, waiter2, channelSegment, i);
                }
                Unit unit = Unit.INSTANCE;
                return;
            }
            if (symbol2 != BufferedChannelKt.access$getFAILED$p()) {
                if (symbol2 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                    throw new IllegalStateException("unexpected".toString());
                }
                channelSegment.cleanPrev();
                onElementRetrieved.invoke(symbol2);
                return;
            }
            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
        }
        onClosed.invoke();
    }

    private final Object receiveOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int i, long j, Continuation<? super E> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl;
        CancellableContinuationImpl cancellableContinuationImpl2;
        boolean z = false;
        Continuation<? super E> continuation2 = continuation;
        boolean z2 = false;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation2));
        try {
            try {
                Object access$updateCellReceive = access$updateCellReceive(this, channelSegment, i, j, orCreateCancellableContinuation);
                try {
                    if (access$updateCellReceive == BufferedChannelKt.access$getSUSPEND$p()) {
                        try {
                            access$prepareReceiverForSuspension(this, orCreateCancellableContinuation, channelSegment, i);
                            cancellableContinuationImpl2 = orCreateCancellableContinuation;
                        } catch (Throwable th) {
                            th = th;
                            cancellableContinuationImpl = orCreateCancellableContinuation;
                            cancellableContinuationImpl.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                            throw th;
                        }
                    } else {
                        try {
                            try {
                                if (access$updateCellReceive == BufferedChannelKt.access$getFAILED$p()) {
                                    if (j < getSendersCounter$kotlinx_coroutines_core()) {
                                        channelSegment.cleanPrev();
                                    }
                                    ChannelSegment channelSegment2 = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(this);
                                    while (!isClosedForReceive()) {
                                        long andIncrement = access$getReceivers$volatile$FU().getAndIncrement(this);
                                        boolean z3 = z;
                                        Continuation<? super E> continuation3 = continuation2;
                                        try {
                                            long j2 = andIncrement / BufferedChannelKt.SEGMENT_SIZE;
                                            boolean z4 = z2;
                                            cancellableContinuationImpl2 = orCreateCancellableContinuation;
                                            int i2 = (int) (andIncrement % BufferedChannelKt.SEGMENT_SIZE);
                                            if (channelSegment2.id != j2) {
                                                ChannelSegment access$findSegmentReceive = access$findSegmentReceive(this, j2, channelSegment2);
                                                if (access$findSegmentReceive == null) {
                                                    z = z3;
                                                    continuation2 = continuation3;
                                                    z2 = z4;
                                                    orCreateCancellableContinuation = cancellableContinuationImpl2;
                                                } else {
                                                    channelSegment2 = access$findSegmentReceive;
                                                }
                                            }
                                            Object access$updateCellReceive2 = access$updateCellReceive(this, channelSegment2, i2, andIncrement, orCreateCancellableContinuation);
                                            if (access$updateCellReceive2 == BufferedChannelKt.access$getSUSPEND$p()) {
                                                CancellableContinuationImpl cancellableContinuationImpl3 = orCreateCancellableContinuation instanceof Waiter ? orCreateCancellableContinuation : null;
                                                if (cancellableContinuationImpl3 != null) {
                                                    access$prepareReceiverForSuspension(this, cancellableContinuationImpl3, channelSegment2, i2);
                                                }
                                            } else if (access$updateCellReceive2 == BufferedChannelKt.access$getFAILED$p()) {
                                                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                                                    channelSegment2.cleanPrev();
                                                }
                                                z = z3;
                                                continuation2 = continuation3;
                                                z2 = z4;
                                                orCreateCancellableContinuation = cancellableContinuationImpl2;
                                            } else {
                                                if (access$updateCellReceive2 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                                                    throw new IllegalStateException("unexpected".toString());
                                                }
                                                channelSegment2.cleanPrev();
                                                Function1<E, Unit> function1 = this.onUndeliveredElement;
                                                orCreateCancellableContinuation.resume((CancellableContinuationImpl) access$updateCellReceive2, (Function3<? super Throwable, ? super CancellableContinuationImpl, ? super CoroutineContext, Unit>) (function1 != null ? access$bindCancellationFun(this, function1) : null));
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            cancellableContinuationImpl = orCreateCancellableContinuation;
                                            cancellableContinuationImpl.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                                            throw th;
                                        }
                                    }
                                    access$onClosedReceiveOnNoWaiterSuspend(this, orCreateCancellableContinuation);
                                    cancellableContinuationImpl2 = orCreateCancellableContinuation;
                                } else {
                                    cancellableContinuationImpl2 = orCreateCancellableContinuation;
                                    channelSegment.cleanPrev();
                                    Function1<E, Unit> function12 = this.onUndeliveredElement;
                                    orCreateCancellableContinuation.resume((CancellableContinuationImpl) access$updateCellReceive, (Function3<? super Throwable, ? super CancellableContinuationImpl, ? super CoroutineContext, Unit>) (function12 != null ? access$bindCancellationFun(this, function12) : null));
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            cancellableContinuationImpl = orCreateCancellableContinuation;
                            cancellableContinuationImpl.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                            throw th;
                        }
                    }
                    Object result = cancellableContinuationImpl2.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation);
                    }
                    return result;
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
                cancellableContinuationImpl = orCreateCancellableContinuation;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    private final void registerSelectForReceive(SelectInstance<?> select, Object ignoredParam) {
        ChannelSegment channelSegment;
        ChannelSegment channelSegment2 = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(this);
        while (!isClosedForReceive()) {
            long andIncrement = access$getReceivers$volatile$FU().getAndIncrement(this);
            long j = andIncrement / BufferedChannelKt.SEGMENT_SIZE;
            int i = (int) (andIncrement % BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment2.id != j) {
                ChannelSegment access$findSegmentReceive = access$findSegmentReceive(this, j, channelSegment2);
                if (access$findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = access$findSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            SelectInstance<?> selectInstance = select;
            Object access$updateCellReceive = access$updateCellReceive(this, channelSegment, i, andIncrement, selectInstance);
            if (access$updateCellReceive == BufferedChannelKt.access$getSUSPEND$p()) {
                Waiter waiter = selectInstance instanceof Waiter ? (Waiter) selectInstance : null;
                if (waiter != null) {
                    access$prepareReceiverForSuspension(this, waiter, channelSegment, i);
                }
                return;
            } else {
                if (access$updateCellReceive != BufferedChannelKt.access$getFAILED$p()) {
                    if (access$updateCellReceive == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                        throw new IllegalStateException("unexpected".toString());
                    }
                    channelSegment.cleanPrev();
                    selectInstance.selectInRegistrationPhase(access$updateCellReceive);
                    return;
                }
                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                channelSegment2 = channelSegment;
                select = selectInstance;
            }
        }
        onClosedSelectOnReceive(select);
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x00b6, code lost:
    
        r5 = (kotlinx.coroutines.channels.ChannelSegment) r4.getPrev();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00bc, code lost:
    
        if (r5 != null) goto L62;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void removeUnprocessedElements(kotlinx.coroutines.channels.ChannelSegment<E> r13) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.removeUnprocessedElements(kotlinx.coroutines.channels.ChannelSegment):void");
    }

    private final void resumeReceiverOnClosedChannel(Waiter waiter) {
        resumeWaiterOnClosedChannel(waiter, true);
    }

    private final void resumeSenderOnCancelledChannel(Waiter waiter) {
        resumeWaiterOnClosedChannel(waiter, false);
    }

    private final void resumeWaiterOnClosedChannel(Waiter waiter, boolean z) {
        if (waiter instanceof SendBroadcast) {
            CancellableContinuation<Boolean> cont = ((SendBroadcast) waiter).getCont();
            Result.Companion companion = Result.INSTANCE;
            cont.resumeWith(Result.m457constructorimpl(false));
            return;
        }
        if (waiter instanceof CancellableContinuation) {
            Continuation continuation = (Continuation) waiter;
            Result.Companion companion2 = Result.INSTANCE;
            continuation.resumeWith(Result.m457constructorimpl(ResultKt.createFailure(z ? getReceiveException() : getSendException())));
        } else if (waiter instanceof ReceiveCatching) {
            CancellableContinuationImpl<ChannelResult<? extends E>> cancellableContinuationImpl = ((ReceiveCatching) waiter).cont;
            Result.Companion companion3 = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m457constructorimpl(ChannelResult.m1961boximpl(ChannelResult.INSTANCE.m1974closedJP2dKIU(getCloseCause()))));
        } else if (waiter instanceof BufferedChannelIterator) {
            ((BufferedChannelIterator) waiter).tryResumeHasNextOnClosedChannel();
        } else {
            if (!(waiter instanceof SelectInstance)) {
                throw new IllegalStateException(("Unexpected waiter: " + waiter).toString());
            }
            ((SelectInstance) waiter).trySelect(this, BufferedChannelKt.getCHANNEL_CLOSED());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0078, code lost:
    
        if (r13 == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007a, code lost:
    
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0049, code lost:
    
        if (r13 != kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L41;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0056. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ <E> java.lang.Object send$suspendImpl(kotlinx.coroutines.channels.BufferedChannel<E> r21, E r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            r0 = 0
            r7 = r0
            r1 = r21
            r0 = 0
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = access$getSendSegment$volatile$FU()
            java.lang.Object r2 = r2.get(r1)
            kotlinx.coroutines.channels.ChannelSegment r2 = (kotlinx.coroutines.channels.ChannelSegment) r2
        L11:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = access$getSendersAndCloseStatus$volatile$FU()
            long r9 = r3.getAndIncrement(r1)
            r3 = r9
            r5 = 0
            r11 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r5 = r3 & r11
            boolean r8 = access$isClosedForSend0(r1, r9)
            int r3 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r3 = (long) r3
            long r11 = r5 / r3
            int r3 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r3 = (long) r3
            long r3 = r5 % r3
            int r3 = (int) r3
            long r13 = r2.id
            int r4 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r4 == 0) goto L50
            kotlinx.coroutines.channels.ChannelSegment r4 = access$findSegmentSend(r1, r11, r2)
            if (r4 != 0) goto L4f
            if (r8 == 0) goto L4e
            r4 = 0
            java.lang.Object r13 = r21.onClosedSend(r22, r23)
            java.lang.Object r14 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r13 == r14) goto L7a
        L4c:
            goto Lcb
        L4e:
            goto L11
        L4f:
            r2 = r4
        L50:
            r4 = r22
            int r13 = access$updateCellSend(r1, r2, r3, r4, r5, r7, r8)
            switch(r13) {
                case 0: goto Lc3;
                case 1: goto Lbe;
                case 2: goto L98;
                case 3: goto L7d;
                case 4: goto L64;
                case 5: goto L5d;
                default: goto L59;
            }
        L59:
            r20 = r0
            goto Lce
        L5d:
            r2.cleanPrev()
            r20 = r0
            goto Lce
        L64:
            long r13 = r1.getReceiversCounter$kotlinx_coroutines_core()
            int r4 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r4 >= 0) goto L6f
            r2.cleanPrev()
        L6f:
            r4 = 0
            java.lang.Object r13 = r21.onClosedSend(r22, r23)
            java.lang.Object r14 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r13 != r14) goto L7b
        L7a:
            return r13
        L7b:
            goto Lcb
        L7d:
            r4 = r2
            r15 = r3
            r14 = r4
            r17 = r5
            r16 = r22
            r4 = 0
            r13 = r21
            r19 = r23
            r20 = r0
            java.lang.Object r0 = r13.sendOnNoWaiterSuspend(r14, r15, r16, r17, r19)
            java.lang.Object r13 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r13) goto L96
            return r0
        L96:
            goto Lcb
        L98:
            r20 = r0
            if (r8 == 0) goto Lad
            r2.onSlotCleaned()
            r0 = 0
            java.lang.Object r4 = r21.onClosedSend(r22, r23)
            java.lang.Object r13 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r13) goto Lab
            return r4
        Lab:
            goto Lcb
        Lad:
            r0 = 0
            boolean r4 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()
            if (r4 != 0) goto Lb6
            goto Lcb
        Lb6:
            r4 = 0
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            throw r4
        Lbe:
            r20 = r0
            r0 = 0
            goto Lcb
        Lc3:
            r20 = r0
            r2.cleanPrev()
            r0 = 0
        Lcb:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        Lce:
            r0 = r20
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.send$suspendImpl(kotlinx.coroutines.channels.BufferedChannel, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x008e. Please report as an issue. */
    static /* synthetic */ <E> Object sendBroadcast$suspendImpl(BufferedChannel<E> bufferedChannel, E e, Continuation<? super Boolean> continuation) {
        boolean z = true;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        if (!(bufferedChannel.onUndeliveredElement == null)) {
            throw new IllegalStateException("the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`".toString());
        }
        SendBroadcast sendBroadcast = new SendBroadcast(cancellableContinuationImpl2);
        ChannelSegment channelSegment = (ChannelSegment) access$getSendSegment$volatile$FU().get(bufferedChannel);
        while (true) {
            long andIncrement = access$getSendersAndCloseStatus$volatile$FU().getAndIncrement(bufferedChannel);
            long j = andIncrement & 1152921504606846975L;
            boolean access$isClosedForSend0 = access$isClosedForSend0(bufferedChannel, andIncrement);
            boolean z2 = z;
            long j2 = j / BufferedChannelKt.SEGMENT_SIZE;
            int i = (int) (j % BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment.id != j2) {
                ChannelSegment access$findSegmentSend = access$findSegmentSend(bufferedChannel, j2, channelSegment);
                if (access$findSegmentSend != null) {
                    channelSegment = access$findSegmentSend;
                } else if (access$isClosedForSend0) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuationImpl2.resumeWith(Result.m457constructorimpl(Boxing.boxBoolean(false)));
                } else {
                    z = z2;
                }
            }
            switch (access$updateCellSend(bufferedChannel, channelSegment, i, e, j, sendBroadcast, access$isClosedForSend0)) {
                case 0:
                    channelSegment.cleanPrev();
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuationImpl2.resumeWith(Result.m457constructorimpl(Boxing.boxBoolean(z2)));
                    break;
                case 1:
                    Result.Companion companion3 = Result.INSTANCE;
                    cancellableContinuationImpl2.resumeWith(Result.m457constructorimpl(Boxing.boxBoolean(z2)));
                    break;
                case 2:
                    if (!access$isClosedForSend0) {
                        SendBroadcast sendBroadcast2 = sendBroadcast instanceof Waiter ? sendBroadcast : null;
                        if (sendBroadcast2 != null) {
                            access$prepareSenderForSuspension(bufferedChannel, sendBroadcast2, channelSegment, i);
                        }
                        break;
                    } else {
                        channelSegment.onSlotCleaned();
                        Result.Companion companion4 = Result.INSTANCE;
                        cancellableContinuationImpl2.resumeWith(Result.m457constructorimpl(Boxing.boxBoolean(false)));
                        break;
                    }
                case 3:
                    throw new IllegalStateException("unexpected".toString());
                case 4:
                    if (j < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    Result.Companion companion5 = Result.INSTANCE;
                    cancellableContinuationImpl2.resumeWith(Result.m457constructorimpl(Boxing.boxBoolean(false)));
                    break;
                case 5:
                    channelSegment.cleanPrev();
                default:
                    z = z2;
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final <R> R sendImpl(E element, Object waiter, Function0<? extends R> onRendezvousOrBuffered, Function2<? super ChannelSegment<E>, ? super Integer, ? extends R> onSuspend, Function0<? extends R> onClosed, Function4<? super ChannelSegment<E>, ? super Integer, ? super E, ? super Long, ? extends R> onNoWaiterSuspend) {
        ChannelSegment channelSegment = (ChannelSegment) access$getSendSegment$volatile$FU().get(this);
        while (true) {
            long andIncrement = access$getSendersAndCloseStatus$volatile$FU().getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean access$isClosedForSend0 = access$isClosedForSend0(this, andIncrement);
            long j2 = j / BufferedChannelKt.SEGMENT_SIZE;
            int i = (int) (j % BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment.id != j2) {
                ChannelSegment access$findSegmentSend = access$findSegmentSend(this, j2, channelSegment);
                if (access$findSegmentSend != null) {
                    channelSegment = access$findSegmentSend;
                } else if (access$isClosedForSend0) {
                    return onClosed.invoke();
                }
            }
            switch (access$updateCellSend(this, channelSegment, i, element, j, waiter, access$isClosedForSend0)) {
                case 0:
                    channelSegment.cleanPrev();
                    return onRendezvousOrBuffered.invoke();
                case 1:
                    return onRendezvousOrBuffered.invoke();
                case 2:
                    if (access$isClosedForSend0) {
                        channelSegment.onSlotCleaned();
                        return onClosed.invoke();
                    }
                    Waiter waiter2 = waiter instanceof Waiter ? (Waiter) waiter : null;
                    if (waiter2 != null) {
                        access$prepareSenderForSuspension(this, waiter2, channelSegment, i);
                    }
                    return onSuspend.invoke(channelSegment, Integer.valueOf(i));
                case 3:
                    return onNoWaiterSuspend.invoke(channelSegment, Integer.valueOf(i), element, Long.valueOf(j));
                case 4:
                    if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    return onClosed.invoke();
                case 5:
                    channelSegment.cleanPrev();
                    break;
            }
        }
    }

    static /* synthetic */ Object sendImpl$default(BufferedChannel bufferedChannel, Object obj, Object obj2, Function0 function0, Function2 function2, Function0 function02, Function4 function4, int i, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImpl");
        }
        Function4 function42 = (i & 32) != 0 ? BufferedChannel$sendImpl$1.INSTANCE : function4;
        ChannelSegment channelSegment = (ChannelSegment) access$getSendSegment$volatile$FU().get(bufferedChannel);
        while (true) {
            long andIncrement = access$getSendersAndCloseStatus$volatile$FU().getAndIncrement(bufferedChannel);
            long j = andIncrement & 1152921504606846975L;
            boolean access$isClosedForSend0 = access$isClosedForSend0(bufferedChannel, andIncrement);
            long j2 = j / BufferedChannelKt.SEGMENT_SIZE;
            int i2 = (int) (j % BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment.id != j2) {
                ChannelSegment access$findSegmentSend = access$findSegmentSend(bufferedChannel, j2, channelSegment);
                if (access$findSegmentSend != null) {
                    channelSegment = access$findSegmentSend;
                } else if (access$isClosedForSend0) {
                    return function02.invoke();
                }
            }
            switch (access$updateCellSend(bufferedChannel, channelSegment, i2, obj, j, obj2, access$isClosedForSend0)) {
                case 0:
                    channelSegment.cleanPrev();
                    return function0.invoke();
                case 1:
                    return function0.invoke();
                case 2:
                    if (access$isClosedForSend0) {
                        channelSegment.onSlotCleaned();
                        return function02.invoke();
                    }
                    Waiter waiter = obj2 instanceof Waiter ? (Waiter) obj2 : null;
                    if (waiter != null) {
                        access$prepareSenderForSuspension(bufferedChannel, waiter, channelSegment, i2);
                    }
                    return function2.invoke(channelSegment, Integer.valueOf(i2));
                case 3:
                    return function42.invoke(channelSegment, Integer.valueOf(i2), obj, Long.valueOf(j));
                case 4:
                    if (j < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    return function02.invoke();
                case 5:
                    channelSegment.cleanPrev();
                    break;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x007b. Please report as an issue. */
    private final void sendImplOnNoWaiter(ChannelSegment<E> segment, int index, E element, long s, Waiter waiter, Function0<Unit> onRendezvousOrBuffered, Function0<Unit> onClosed) {
        Unit unit;
        switch (access$updateCellSend(this, segment, index, element, s, waiter, false)) {
            case 0:
                segment.cleanPrev();
                onRendezvousOrBuffered.invoke();
                return;
            case 1:
                onRendezvousOrBuffered.invoke();
                return;
            case 2:
                access$prepareSenderForSuspension(this, waiter, segment, index);
                return;
            case 3:
            default:
                throw new IllegalStateException("unexpected".toString());
            case 4:
                if (s < getReceiversCounter$kotlinx_coroutines_core()) {
                    segment.cleanPrev();
                }
                onClosed.invoke();
                return;
            case 5:
                segment.cleanPrev();
                ChannelSegment channelSegment = (ChannelSegment) access$getSendSegment$volatile$FU().get(this);
                while (true) {
                    long andIncrement = access$getSendersAndCloseStatus$volatile$FU().getAndIncrement(this);
                    long j = andIncrement & 1152921504606846975L;
                    boolean access$isClosedForSend0 = access$isClosedForSend0(this, andIncrement);
                    long j2 = j / BufferedChannelKt.SEGMENT_SIZE;
                    int i = (int) (j % BufferedChannelKt.SEGMENT_SIZE);
                    if (channelSegment.id != j2) {
                        ChannelSegment access$findSegmentSend = access$findSegmentSend(this, j2, channelSegment);
                        if (access$findSegmentSend != null) {
                            channelSegment = access$findSegmentSend;
                        } else if (access$isClosedForSend0) {
                            unit = onClosed.invoke();
                        }
                    }
                    switch (access$updateCellSend(this, channelSegment, i, element, j, waiter, access$isClosedForSend0)) {
                        case 0:
                            channelSegment.cleanPrev();
                            unit = onRendezvousOrBuffered.invoke();
                            break;
                        case 1:
                            unit = onRendezvousOrBuffered.invoke();
                            break;
                        case 2:
                            if (!access$isClosedForSend0) {
                                Waiter waiter2 = waiter instanceof Waiter ? waiter : null;
                                if (waiter2 != null) {
                                    access$prepareSenderForSuspension(this, waiter2, channelSegment, i);
                                }
                                unit = Unit.INSTANCE;
                                break;
                            } else {
                                channelSegment.onSlotCleaned();
                                unit = onClosed.invoke();
                                break;
                            }
                        case 3:
                            throw new IllegalStateException("unexpected".toString());
                        case 4:
                            if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                                channelSegment.cleanPrev();
                            }
                            unit = onClosed.invoke();
                            break;
                        case 5:
                            channelSegment.cleanPrev();
                    }
                }
                return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x009c. Please report as an issue. */
    private final Object sendOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int i, E e, long j, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        CancellableContinuationImpl cancellableContinuationImpl = orCreateCancellableContinuation;
        try {
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            switch (access$updateCellSend(this, channelSegment, i, e, j, cancellableContinuationImpl, false)) {
                case 0:
                    channelSegment.cleanPrev();
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m457constructorimpl(Unit.INSTANCE));
                    break;
                case 1:
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m457constructorimpl(Unit.INSTANCE));
                    break;
                case 2:
                    access$prepareSenderForSuspension(this, cancellableContinuationImpl, channelSegment, i);
                    break;
                case 3:
                default:
                    throw new IllegalStateException("unexpected".toString());
                case 4:
                    if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    access$onClosedSendOnNoWaiterSuspend(this, e, cancellableContinuationImpl);
                    break;
                case 5:
                    channelSegment.cleanPrev();
                    ChannelSegment channelSegment2 = (ChannelSegment) access$getSendSegment$volatile$FU().get(this);
                    while (true) {
                        long andIncrement = access$getSendersAndCloseStatus$volatile$FU().getAndIncrement(this);
                        long j2 = andIncrement & 1152921504606846975L;
                        boolean access$isClosedForSend0 = access$isClosedForSend0(this, andIncrement);
                        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                        long j3 = j2 / BufferedChannelKt.SEGMENT_SIZE;
                        int i2 = (int) (j2 % BufferedChannelKt.SEGMENT_SIZE);
                        if (channelSegment2.id != j3) {
                            ChannelSegment access$findSegmentSend = access$findSegmentSend(this, j3, channelSegment2);
                            if (access$findSegmentSend != null) {
                                channelSegment2 = access$findSegmentSend;
                            } else if (access$isClosedForSend0) {
                                access$onClosedSendOnNoWaiterSuspend(this, e, cancellableContinuationImpl2);
                                break;
                            } else {
                                cancellableContinuationImpl = cancellableContinuationImpl2;
                            }
                        }
                        switch (access$updateCellSend(this, channelSegment2, i2, e, j2, cancellableContinuationImpl2, access$isClosedForSend0)) {
                            case 0:
                                channelSegment2.cleanPrev();
                                Result.Companion companion3 = Result.INSTANCE;
                                cancellableContinuationImpl2.resumeWith(Result.m457constructorimpl(Unit.INSTANCE));
                                break;
                            case 1:
                                Result.Companion companion4 = Result.INSTANCE;
                                cancellableContinuationImpl2.resumeWith(Result.m457constructorimpl(Unit.INSTANCE));
                                break;
                            case 2:
                                if (!access$isClosedForSend0) {
                                    CancellableContinuationImpl cancellableContinuationImpl3 = cancellableContinuationImpl2 instanceof Waiter ? cancellableContinuationImpl2 : null;
                                    if (cancellableContinuationImpl3 != null) {
                                        access$prepareSenderForSuspension(this, cancellableContinuationImpl3, channelSegment2, i2);
                                    }
                                    break;
                                } else {
                                    channelSegment2.onSlotCleaned();
                                    access$onClosedSendOnNoWaiterSuspend(this, e, cancellableContinuationImpl2);
                                    break;
                                }
                            case 3:
                                throw new IllegalStateException("unexpected".toString());
                            case 4:
                                if (j2 < getReceiversCounter$kotlinx_coroutines_core()) {
                                    channelSegment2.cleanPrev();
                                }
                                access$onClosedSendOnNoWaiterSuspend(this, e, cancellableContinuationImpl2);
                                break;
                            case 5:
                                channelSegment2.cleanPrev();
                                cancellableContinuationImpl = cancellableContinuationImpl2;
                            default:
                                cancellableContinuationImpl = cancellableContinuationImpl2;
                        }
                    }
            }
            Object result = orCreateCancellableContinuation.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
        } catch (Throwable th3) {
            th = th3;
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    private final /* synthetic */ void setBufferEnd$volatile(long j) {
        this.bufferEnd$volatile = j;
    }

    private final /* synthetic */ void setBufferEndSegment$volatile(Object obj) {
        this.bufferEndSegment$volatile = obj;
    }

    private final /* synthetic */ void setCloseHandler$volatile(Object obj) {
        this.closeHandler$volatile = obj;
    }

    private final /* synthetic */ void setCompletedExpandBuffersAndPauseFlag$volatile(long j) {
        this.completedExpandBuffersAndPauseFlag$volatile = j;
    }

    private final /* synthetic */ void setReceiveSegment$volatile(Object obj) {
        this.receiveSegment$volatile = obj;
    }

    private final /* synthetic */ void setReceivers$volatile(long j) {
        this.receivers$volatile = j;
    }

    private final /* synthetic */ void setSendSegment$volatile(Object obj) {
        this.sendSegment$volatile = obj;
    }

    private final /* synthetic */ void setSendersAndCloseStatus$volatile(long j) {
        this.sendersAndCloseStatus$volatile = j;
    }

    private final /* synthetic */ void set_closeCause$volatile(Object obj) {
        this._closeCause$volatile = obj;
    }

    private final boolean shouldSendSuspend(long curSendersAndCloseStatus) {
        if (isClosedForSend0(curSendersAndCloseStatus)) {
            return false;
        }
        return !bufferOrRendezvousSend(curSendersAndCloseStatus & 1152921504606846975L);
    }

    private final boolean tryResumeReceiver(Object obj, E e) {
        if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).trySelect(this, e);
        }
        if (obj instanceof ReceiveCatching) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuationImpl<ChannelResult<? extends E>> cancellableContinuationImpl = ((ReceiveCatching) obj).cont;
            ChannelResult m1961boximpl = ChannelResult.m1961boximpl(ChannelResult.INSTANCE.m1976successJP2dKIU(e));
            Function1<E, Unit> function1 = this.onUndeliveredElement;
            return BufferedChannelKt.access$tryResume0(cancellableContinuationImpl, m1961boximpl, (Function3) (function1 != null ? bindCancellationFunResult(function1) : null));
        }
        if (obj instanceof BufferedChannelIterator) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((BufferedChannelIterator) obj).tryResumeHasNext(e);
        }
        if (!(obj instanceof CancellableContinuation)) {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
        CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
        Function1<E, Unit> function12 = this.onUndeliveredElement;
        return BufferedChannelKt.access$tryResume0(cancellableContinuation, e, (Function3) (function12 != null ? bindCancellationFun(function12) : null));
    }

    private final boolean tryResumeSender(Object obj, ChannelSegment<E> channelSegment, int i) {
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.tryResume0$default((CancellableContinuation) obj, Unit.INSTANCE, null, 2, null);
        }
        if (!(obj instanceof SelectInstance)) {
            if (obj instanceof SendBroadcast) {
                return BufferedChannelKt.tryResume0$default(((SendBroadcast) obj).getCont(), true, null, 2, null);
            }
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        TrySelectDetailedResult trySelectDetailed = ((SelectImplementation) obj).trySelectDetailed(this, Unit.INSTANCE);
        if (trySelectDetailed == TrySelectDetailedResult.REREGISTER) {
            channelSegment.cleanElement$kotlinx_coroutines_core(i);
        }
        return trySelectDetailed == TrySelectDetailedResult.SUCCESSFUL;
    }

    private final /* synthetic */ void update$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function1) {
        while (true) {
            long j = atomicLongFieldUpdater.get(obj);
            Object obj2 = obj;
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = atomicLongFieldUpdater;
            if (atomicLongFieldUpdater2.compareAndSet(obj2, j, function1.invoke(Long.valueOf(j)).longValue())) {
                return;
            }
            atomicLongFieldUpdater = atomicLongFieldUpdater2;
            obj = obj2;
        }
    }

    private final boolean updateCellExpandBuffer(ChannelSegment<E> segment, int index, long b) {
        Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        if (!(state$kotlinx_coroutines_core instanceof Waiter) || b < getReceivers$volatile$FU().get(this) || !segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.access$getRESUMING_BY_EB$p())) {
            return updateCellExpandBufferSlow(segment, index, b);
        }
        if (tryResumeSender(state$kotlinx_coroutines_core, segment, index)) {
            segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.BUFFERED);
            return true;
        }
        segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
        segment.onCancelledRequest(index, false);
        return false;
    }

    private final boolean updateCellExpandBufferSlow(ChannelSegment<E> segment, int index, long b) {
        while (true) {
            Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core instanceof Waiter) {
                if (b < getReceivers$volatile$FU().get(this)) {
                    if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, new WaiterEB((Waiter) state$kotlinx_coroutines_core))) {
                        return true;
                    }
                } else if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.access$getRESUMING_BY_EB$p())) {
                    if (tryResumeSender(state$kotlinx_coroutines_core, segment, index)) {
                        segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.BUFFERED);
                        return true;
                    }
                    segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
                    segment.onCancelledRequest(index, false);
                    return false;
                }
            } else {
                if (state$kotlinx_coroutines_core == BufferedChannelKt.access$getINTERRUPTED_SEND$p()) {
                    return false;
                }
                if (state$kotlinx_coroutines_core == null) {
                    if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.access$getIN_BUFFER$p())) {
                        return true;
                    }
                } else {
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED || state$kotlinx_coroutines_core == BufferedChannelKt.access$getPOISONED$p() || state$kotlinx_coroutines_core == BufferedChannelKt.access$getDONE_RCV$p() || state$kotlinx_coroutines_core == BufferedChannelKt.access$getINTERRUPTED_RCV$p() || state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                        return true;
                    }
                    if (state$kotlinx_coroutines_core != BufferedChannelKt.access$getRESUMING_BY_RCV$p()) {
                        throw new IllegalStateException(("Unexpected cell state: " + state$kotlinx_coroutines_core).toString());
                    }
                }
            }
        }
    }

    private final Object updateCellReceive(ChannelSegment<E> segment, int index, long r, Object waiter) {
        Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        if (state$kotlinx_coroutines_core == null) {
            if (r >= (getSendersAndCloseStatus$volatile$FU().get(this) & 1152921504606846975L)) {
                if (waiter == null) {
                    return BufferedChannelKt.access$getSUSPEND_NO_WAITER$p();
                }
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, waiter)) {
                    expandBuffer();
                    return BufferedChannelKt.access$getSUSPEND$p();
                }
            }
        } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED && segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.access$getDONE_RCV$p())) {
            expandBuffer();
            return segment.retrieveElement$kotlinx_coroutines_core(index);
        }
        return updateCellReceiveSlow(segment, index, r, waiter);
    }

    private final Object updateCellReceiveSlow(ChannelSegment<E> segment, int index, long r, Object waiter) {
        while (true) {
            Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core == null || state$kotlinx_coroutines_core == BufferedChannelKt.access$getIN_BUFFER$p()) {
                if (r < (getSendersAndCloseStatus$volatile$FU().get(this) & 1152921504606846975L)) {
                    if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.access$getPOISONED$p())) {
                        expandBuffer();
                        return BufferedChannelKt.access$getFAILED$p();
                    }
                } else {
                    if (waiter == null) {
                        return BufferedChannelKt.access$getSUSPEND_NO_WAITER$p();
                    }
                    if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, waiter)) {
                        expandBuffer();
                        return BufferedChannelKt.access$getSUSPEND$p();
                    }
                }
            } else {
                if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED) {
                    if (state$kotlinx_coroutines_core != BufferedChannelKt.access$getINTERRUPTED_SEND$p() && state$kotlinx_coroutines_core != BufferedChannelKt.access$getPOISONED$p()) {
                        if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                            expandBuffer();
                            return BufferedChannelKt.access$getFAILED$p();
                        }
                        if (state$kotlinx_coroutines_core != BufferedChannelKt.access$getRESUMING_BY_EB$p() && segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.access$getRESUMING_BY_RCV$p())) {
                            boolean z = state$kotlinx_coroutines_core instanceof WaiterEB;
                            if (tryResumeSender(state$kotlinx_coroutines_core instanceof WaiterEB ? ((WaiterEB) state$kotlinx_coroutines_core).waiter : state$kotlinx_coroutines_core, segment, index)) {
                                segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getDONE_RCV$p());
                                expandBuffer();
                                return segment.retrieveElement$kotlinx_coroutines_core(index);
                            }
                            segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
                            segment.onCancelledRequest(index, false);
                            if (z) {
                                expandBuffer();
                            }
                            return BufferedChannelKt.access$getFAILED$p();
                        }
                    }
                    return BufferedChannelKt.access$getFAILED$p();
                }
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.access$getDONE_RCV$p())) {
                    expandBuffer();
                    return segment.retrieveElement$kotlinx_coroutines_core(index);
                }
            }
        }
    }

    private final int updateCellSend(ChannelSegment<E> segment, int index, E element, long s, Object waiter, boolean closed) {
        segment.storeElement$kotlinx_coroutines_core(index, element);
        if (closed) {
            return updateCellSendSlow(segment, index, element, s, waiter, closed);
        }
        Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        if (state$kotlinx_coroutines_core == null) {
            if (bufferOrRendezvousSend(s)) {
                if (segment.casState$kotlinx_coroutines_core(index, null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else {
                if (waiter == null) {
                    return 3;
                }
                if (segment.casState$kotlinx_coroutines_core(index, null, waiter)) {
                    return 2;
                }
            }
        } else if (state$kotlinx_coroutines_core instanceof Waiter) {
            segment.cleanElement$kotlinx_coroutines_core(index);
            if (tryResumeReceiver(state$kotlinx_coroutines_core, element)) {
                segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getDONE_RCV$p());
                onReceiveDequeued();
                return 0;
            }
            if (segment.getAndSetState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getINTERRUPTED_RCV$p()) != BufferedChannelKt.access$getINTERRUPTED_RCV$p()) {
                segment.onCancelledRequest(index, true);
            }
            return 5;
        }
        return updateCellSendSlow(segment, index, element, s, waiter, closed);
    }

    private final int updateCellSendSlow(ChannelSegment<E> segment, int index, E element, long s, Object waiter, boolean closed) {
        while (true) {
            Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core == null) {
                if (!bufferOrRendezvousSend(s) || closed) {
                    if (closed) {
                        if (segment.casState$kotlinx_coroutines_core(index, null, BufferedChannelKt.access$getINTERRUPTED_SEND$p())) {
                            segment.onCancelledRequest(index, false);
                            return 4;
                        }
                    } else {
                        if (waiter == null) {
                            return 3;
                        }
                        if (segment.casState$kotlinx_coroutines_core(index, null, waiter)) {
                            return 2;
                        }
                    }
                } else if (segment.casState$kotlinx_coroutines_core(index, null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else {
                if (state$kotlinx_coroutines_core != BufferedChannelKt.access$getIN_BUFFER$p()) {
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.access$getINTERRUPTED_RCV$p()) {
                        segment.cleanElement$kotlinx_coroutines_core(index);
                        return 5;
                    }
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.access$getPOISONED$p()) {
                        segment.cleanElement$kotlinx_coroutines_core(index);
                        return 5;
                    }
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                        segment.cleanElement$kotlinx_coroutines_core(index);
                        completeCloseOrCancel();
                        return 4;
                    }
                    if (DebugKt.getASSERTIONS_ENABLED()) {
                        if (!((state$kotlinx_coroutines_core instanceof Waiter) || (state$kotlinx_coroutines_core instanceof WaiterEB))) {
                            throw new AssertionError();
                        }
                    }
                    segment.cleanElement$kotlinx_coroutines_core(index);
                    if (tryResumeReceiver(state$kotlinx_coroutines_core instanceof WaiterEB ? ((WaiterEB) state$kotlinx_coroutines_core).waiter : state$kotlinx_coroutines_core, element)) {
                        segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getDONE_RCV$p());
                        onReceiveDequeued();
                        return 0;
                    }
                    if (segment.getAndSetState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getINTERRUPTED_RCV$p()) != BufferedChannelKt.access$getINTERRUPTED_RCV$p()) {
                        segment.onCancelledRequest(index, true);
                    }
                    return 5;
                }
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            }
        }
    }

    private final void updateReceiversCounterIfLower(long value) {
        AtomicLongFieldUpdater receivers$volatile$FU2 = getReceivers$volatile$FU();
        while (true) {
            long j = receivers$volatile$FU2.get(this);
            if (j >= value) {
                return;
            }
            long j2 = value;
            if (getReceivers$volatile$FU().compareAndSet(this, j, j2)) {
                return;
            } else {
                value = j2;
            }
        }
    }

    private final void updateSendersCounterIfLower(long value) {
        long j;
        long j2;
        AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU2 = getSendersAndCloseStatus$volatile$FU();
        do {
            j = sendersAndCloseStatus$volatile$FU2.get(this);
            j2 = j & 1152921504606846975L;
            if (j2 >= value) {
                return;
            }
        } while (!getSendersAndCloseStatus$volatile$FU().compareAndSet(this, j, BufferedChannelKt.access$constructSendersAndCloseStatus(j2, (int) (j >> 60))));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel() {
        cancelImpl$kotlinx_coroutines_core(null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException cause) {
        cancelImpl$kotlinx_coroutines_core(cause);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean cancel(Throwable cause) {
        return cancelImpl$kotlinx_coroutines_core(cause);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(Throwable cause) {
        return closeOrCancelImpl(cause == null ? new CancellationException("Channel was cancelled") : cause, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0217 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void checkSegmentStructureInvariants() {
        /*
            Method dump skipped, instructions count: 638
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.checkSegmentStructureInvariants():void");
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable cause) {
        return closeOrCancelImpl(cause, false);
    }

    protected boolean closeOrCancelImpl(Throwable cause, boolean cancel) {
        if (cancel) {
            markCancellationStarted();
        }
        boolean m = AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(get_closeCause$volatile$FU(), this, BufferedChannelKt.access$getNO_CLOSE_CAUSE$p(), cause);
        if (cancel) {
            markCancelled();
        } else {
            markClosed();
        }
        completeCloseOrCancel();
        onClosedIdempotent();
        if (m) {
            invokeCloseHandler();
        }
        return m;
    }

    protected final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long globalCellIndex) {
        ChannelSegment<E> channelSegment;
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        if (DebugKt.getASSERTIONS_ENABLED() && !isConflatedDropOldest()) {
            throw new AssertionError();
        }
        ChannelSegment<E> channelSegment2 = (ChannelSegment) getReceiveSegment$volatile$FU().get(this);
        while (true) {
            long j = getReceivers$volatile$FU().get(this);
            if (globalCellIndex < Math.max(this.capacity + j, getBufferEndCounter())) {
                return;
            }
            if (getReceivers$volatile$FU().compareAndSet(this, j, 1 + j)) {
                long j2 = j / BufferedChannelKt.SEGMENT_SIZE;
                int i = (int) (j % BufferedChannelKt.SEGMENT_SIZE);
                if (channelSegment2.id != j2) {
                    ChannelSegment<E> findSegmentReceive = findSegmentReceive(j2, channelSegment2);
                    if (findSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment = findSegmentReceive;
                    }
                } else {
                    channelSegment = channelSegment2;
                }
                Object updateCellReceive = updateCellReceive(channelSegment, i, j, null);
                if (updateCellReceive != BufferedChannelKt.access$getFAILED$p()) {
                    channelSegment.cleanPrev();
                    Function1<E, Unit> function1 = this.onUndeliveredElement;
                    if (function1 != null && (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, updateCellReceive, null, 2, null)) != null) {
                        throw callUndeliveredElementCatchingException$default;
                    }
                } else if (j < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                channelSegment2 = channelSegment;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Throwable getCloseCause() {
        return (Throwable) get_closeCause$volatile$FU().get(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> getOnReceive() {
        BufferedChannel$onReceive$1 bufferedChannel$onReceive$1 = BufferedChannel$onReceive$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$1, 3);
        BufferedChannel$onReceive$2 bufferedChannel$onReceive$2 = BufferedChannel$onReceive$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$1, 3);
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> getOnReceiveOrNull() {
        BufferedChannel$onReceiveOrNull$1 bufferedChannel$onReceiveOrNull$1 = BufferedChannel$onReceiveOrNull$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveOrNull$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveOrNull$1, 3);
        BufferedChannel$onReceiveOrNull$2 bufferedChannel$onReceiveOrNull$2 = BufferedChannel$onReceiveOrNull$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveOrNull$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveOrNull$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2<E, BufferedChannel<E>> getOnSend() {
        BufferedChannel$onSend$1 bufferedChannel$onSend$1 = BufferedChannel$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$1, 3);
        BufferedChannel$onSend$2 bufferedChannel$onSend$2 = BufferedChannel$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause2Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$2, 3), null, 8, null);
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return getReceivers$volatile$FU().get(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Throwable getSendException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE) : closeCause;
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return getSendersAndCloseStatus$volatile$FU().get(this) & 1152921504606846975L;
    }

    public final boolean hasElements$kotlinx_coroutines_core() {
        while (true) {
            ChannelSegment<E> channelSegment = (ChannelSegment) getReceiveSegment$volatile$FU().get(this);
            long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
            if (getSendersCounter$kotlinx_coroutines_core() <= receiversCounter$kotlinx_coroutines_core) {
                return false;
            }
            long j = receiversCounter$kotlinx_coroutines_core / BufferedChannelKt.SEGMENT_SIZE;
            if (channelSegment.id != j) {
                ChannelSegment<E> findSegmentReceive = findSegmentReceive(j, channelSegment);
                if (findSegmentReceive != null) {
                    channelSegment = findSegmentReceive;
                } else if (((ChannelSegment) getReceiveSegment$volatile$FU().get(this)).id < j) {
                    return false;
                }
            }
            channelSegment.cleanPrev();
            if (isCellNonEmpty(channelSegment, (int) (receiversCounter$kotlinx_coroutines_core % BufferedChannelKt.SEGMENT_SIZE), receiversCounter$kotlinx_coroutines_core)) {
                return true;
            }
            getReceivers$volatile$FU().compareAndSet(this, receiversCounter$kotlinx_coroutines_core, 1 + receiversCounter$kotlinx_coroutines_core);
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, Unit> handler) {
        if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(getCloseHandler$volatile$FU(), this, null, handler)) {
            return;
        }
        AtomicReferenceFieldUpdater closeHandler$volatile$FU2 = getCloseHandler$volatile$FU();
        do {
            Object obj = closeHandler$volatile$FU2.get(this);
            if (obj != BufferedChannelKt.access$getCLOSE_HANDLER_CLOSED$p()) {
                if (obj != BufferedChannelKt.access$getCLOSE_HANDLER_INVOKED$p()) {
                    throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
                }
                throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(getCloseHandler$volatile$FU(), this, BufferedChannelKt.access$getCLOSE_HANDLER_CLOSED$p(), BufferedChannelKt.access$getCLOSE_HANDLER_INVOKED$p()));
        handler.invoke(getCloseCause());
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return isClosedForReceive0(getSendersAndCloseStatus$volatile$FU().get(this));
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return isClosedForSend0(getSendersAndCloseStatus$volatile$FU().get(this));
    }

    protected boolean isConflatedDropOldest() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        if (isClosedForReceive() || hasElements$kotlinx_coroutines_core()) {
            return false;
        }
        return !isClosedForReceive();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<E> iterator() {
        return new BufferedChannelIterator();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e) {
        return Channel.DefaultImpls.offer(this, e);
    }

    protected void onClosedIdempotent() {
    }

    protected void onReceiveDequeued() {
    }

    protected void onReceiveEnqueued() {
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    public E poll() {
        return (E) Channel.DefaultImpls.poll(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receive(Continuation<? super E> continuation) {
        return receive$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    public Object mo1953receiveCatchingJP2dKIU(Continuation<? super ChannelResult<? extends E>> continuation) {
        return m1951receiveCatchingJP2dKIU$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public Object receiveOrNull(Continuation<? super E> continuation) {
        return Channel.DefaultImpls.receiveOrNull(this, continuation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x004f. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    public void registerSelectForSend(SelectInstance<?> select, Object element) {
        Object obj = element;
        ChannelSegment channelSegment = (ChannelSegment) access$getSendSegment$volatile$FU().get(this);
        while (true) {
            long andIncrement = access$getSendersAndCloseStatus$volatile$FU().getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean access$isClosedForSend0 = access$isClosedForSend0(this, andIncrement);
            long j2 = j / BufferedChannelKt.SEGMENT_SIZE;
            int i = (int) (j % BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment.id != j2) {
                ChannelSegment access$findSegmentSend = access$findSegmentSend(this, j2, channelSegment);
                if (access$findSegmentSend != null) {
                    channelSegment = access$findSegmentSend;
                } else if (access$isClosedForSend0) {
                    onClosedSelectOnSend(element, select);
                    return;
                }
            }
            switch (access$updateCellSend(this, channelSegment, i, obj, j, select, access$isClosedForSend0)) {
                case 0:
                    channelSegment.cleanPrev();
                    select.selectInRegistrationPhase(Unit.INSTANCE);
                    return;
                case 1:
                    select.selectInRegistrationPhase(Unit.INSTANCE);
                    return;
                case 2:
                    if (access$isClosedForSend0) {
                        channelSegment.onSlotCleaned();
                        onClosedSelectOnSend(element, select);
                        return;
                    } else {
                        Waiter waiter = select instanceof Waiter ? (Waiter) select : null;
                        if (waiter != null) {
                            access$prepareSenderForSuspension(this, waiter, channelSegment, i);
                        }
                        return;
                    }
                case 3:
                    throw new IllegalStateException("unexpected".toString());
                case 4:
                    if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    onClosedSelectOnSend(element, select);
                    return;
                case 5:
                    channelSegment.cleanPrev();
                default:
                    obj = obj;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E e, Continuation<? super Unit> continuation) {
        return send$suspendImpl(this, e, continuation);
    }

    public Object sendBroadcast$kotlinx_coroutines_core(E e, Continuation<? super Boolean> continuation) {
        return sendBroadcast$suspendImpl(this, e, continuation);
    }

    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return shouldSendSuspend(getSendersAndCloseStatus$volatile$FU().get(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String toString() {
        String str;
        BufferedChannel<E> bufferedChannel = this;
        StringBuilder sb = new StringBuilder();
        switch ((int) (getSendersAndCloseStatus$volatile$FU().get(bufferedChannel) >> 60)) {
            case 2:
                sb.append("closed,");
                break;
            case 3:
                sb.append("cancelled,");
                break;
        }
        sb.append("capacity=" + bufferedChannel.capacity + ',');
        sb.append("data=[");
        boolean z = true;
        List listOf = CollectionsKt.listOf((Object[]) new ChannelSegment[]{getReceiveSegment$volatile$FU().get(bufferedChannel), getSendSegment$volatile$FU().get(bufferedChannel), getBufferEndSegment$volatile$FU().get(bufferedChannel)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listOf) {
            if (((ChannelSegment) obj) != BufferedChannelKt.access$getNULL_SEGMENT$p()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j = ((ChannelSegment) next).id;
            while (true) {
                Object next2 = it.next();
                long j2 = ((ChannelSegment) next2).id;
                if (j > j2) {
                    next = next2;
                    j = j2;
                }
                if (it.hasNext()) {
                    bufferedChannel = this;
                }
            }
        }
        long receiversCounter$kotlinx_coroutines_core = bufferedChannel.getReceiversCounter$kotlinx_coroutines_core();
        long sendersCounter$kotlinx_coroutines_core = bufferedChannel.getSendersCounter$kotlinx_coroutines_core();
        ChannelSegment channelSegment = (ChannelSegment) next;
        while (true) {
            int i = 0;
            int i2 = BufferedChannelKt.SEGMENT_SIZE;
            while (true) {
                if (i < i2) {
                    boolean z2 = z;
                    int i3 = i2;
                    long j3 = (channelSegment.id * BufferedChannelKt.SEGMENT_SIZE) + i;
                    if (j3 < sendersCounter$kotlinx_coroutines_core || j3 < receiversCounter$kotlinx_coroutines_core) {
                        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
                        Object element$kotlinx_coroutines_core = channelSegment.getElement$kotlinx_coroutines_core(i);
                        if (state$kotlinx_coroutines_core instanceof CancellableContinuation) {
                            str = (j3 >= receiversCounter$kotlinx_coroutines_core || j3 < sendersCounter$kotlinx_coroutines_core) ? (j3 >= sendersCounter$kotlinx_coroutines_core || j3 < receiversCounter$kotlinx_coroutines_core) ? "cont" : "send" : "receive";
                        } else if (state$kotlinx_coroutines_core instanceof SelectInstance) {
                            str = (j3 >= receiversCounter$kotlinx_coroutines_core || j3 < sendersCounter$kotlinx_coroutines_core) ? (j3 >= sendersCounter$kotlinx_coroutines_core || j3 < receiversCounter$kotlinx_coroutines_core) ? "select" : "onSend" : "onReceive";
                        } else if (state$kotlinx_coroutines_core instanceof ReceiveCatching) {
                            str = "receiveCatching";
                        } else if (state$kotlinx_coroutines_core instanceof SendBroadcast) {
                            str = "sendBroadcast";
                        } else if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                            str = "EB(" + state$kotlinx_coroutines_core + ')';
                        } else if (Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getRESUMING_BY_RCV$p()) || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getRESUMING_BY_EB$p())) {
                            str = "resuming_sender";
                        } else {
                            if (state$kotlinx_coroutines_core != null && !Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getIN_BUFFER$p()) && !Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getDONE_RCV$p()) && !Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getPOISONED$p()) && !Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getINTERRUPTED_RCV$p()) && !Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getINTERRUPTED_SEND$p()) && !Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                str = state$kotlinx_coroutines_core.toString();
                            }
                            i++;
                            i2 = i3;
                            z = z2;
                        }
                        if (element$kotlinx_coroutines_core != null) {
                            sb.append('(' + str + ',' + element$kotlinx_coroutines_core + "),");
                        } else {
                            sb.append(str + ',');
                        }
                        i++;
                        i2 = i3;
                        z = z2;
                    }
                } else {
                    boolean z3 = z;
                    ChannelSegment channelSegment2 = (ChannelSegment) channelSegment.getNext();
                    if (channelSegment2 != null) {
                        channelSegment = channelSegment2;
                        z = z3;
                    }
                }
            }
        }
        if (StringsKt.last(sb) == ',') {
            Intrinsics.checkNotNullExpressionValue(sb.deleteCharAt(sb.length() - 1), "deleteCharAt(...)");
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toStringDebug$kotlinx_coroutines_core() {
        StringBuilder sb = new StringBuilder();
        sb.append("S=" + getSendersCounter$kotlinx_coroutines_core() + ",R=" + getReceiversCounter$kotlinx_coroutines_core() + ",B=" + getBufferEndCounter() + ",B'=" + getCompletedExpandBuffersAndPauseFlag$volatile$FU().get(this) + ",C=" + ((int) (getSendersAndCloseStatus$volatile$FU().get(this) >> 60)) + ',');
        switch ((int) (getSendersAndCloseStatus$volatile$FU().get(this) >> 60)) {
            case 1:
                sb.append("CANCELLATION_STARTED,");
                break;
            case 2:
                sb.append("CLOSED,");
                break;
            case 3:
                sb.append("CANCELLED,");
                break;
        }
        sb.append("SEND_SEGM=" + DebugStringsKt.getHexAddress(getSendSegment$volatile$FU().get(this)) + ",RCV_SEGM=" + DebugStringsKt.getHexAddress(getReceiveSegment$volatile$FU().get(this)));
        if (!isRendezvousOrUnlimited()) {
            sb.append(",EB_SEGM=" + DebugStringsKt.getHexAddress(getBufferEndSegment$volatile$FU().get(this)));
        }
        sb.append("  ");
        List listOf = CollectionsKt.listOf((Object[]) new ChannelSegment[]{getReceiveSegment$volatile$FU().get(this), getSendSegment$volatile$FU().get(this), getBufferEndSegment$volatile$FU().get(this)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listOf) {
            if (((ChannelSegment) obj) != BufferedChannelKt.access$getNULL_SEGMENT$p()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j = ((ChannelSegment) next).id;
            do {
                Object next2 = it.next();
                long j2 = ((ChannelSegment) next2).id;
                if (j > j2) {
                    next = next2;
                    j = j2;
                }
            } while (it.hasNext());
        }
        ChannelSegment channelSegment = (ChannelSegment) next;
        while (true) {
            StringBuilder append = new StringBuilder().append(DebugStringsKt.getHexAddress(channelSegment)).append("=[").append(channelSegment.isRemoved() ? "*" : "").append(channelSegment.id).append(",prev=");
            ChannelSegment channelSegment2 = (ChannelSegment) channelSegment.getPrev();
            sb.append(append.append(channelSegment2 != null ? DebugStringsKt.getHexAddress(channelSegment2) : null).append(',').toString());
            int i = BufferedChannelKt.SEGMENT_SIZE;
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = i2;
                Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i3);
                sb.append('[' + i3 + "]=(" + (state$kotlinx_coroutines_core instanceof CancellableContinuation ? "cont" : state$kotlinx_coroutines_core instanceof SelectInstance ? "select" : state$kotlinx_coroutines_core instanceof ReceiveCatching ? "receiveCatching" : state$kotlinx_coroutines_core instanceof SendBroadcast ? "send(broadcast)" : state$kotlinx_coroutines_core instanceof WaiterEB ? "EB(" + state$kotlinx_coroutines_core + ')' : String.valueOf(state$kotlinx_coroutines_core)) + ',' + channelSegment.getElement$kotlinx_coroutines_core(i3) + "),");
            }
            StringBuilder append2 = new StringBuilder().append("next=");
            ChannelSegment channelSegment3 = (ChannelSegment) channelSegment.getNext();
            sb.append(append2.append(channelSegment3 != null ? DebugStringsKt.getHexAddress(channelSegment3) : null).append("]  ").toString());
            ChannelSegment channelSegment4 = (ChannelSegment) channelSegment.getNext();
            if (channelSegment4 == null) {
                return sb.toString();
            }
            channelSegment = channelSegment4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public Object mo1954tryReceivePtdJZtk() {
        long j = getReceivers$volatile$FU().get(this);
        long j2 = getSendersAndCloseStatus$volatile$FU().get(this);
        if (isClosedForReceive0(j2)) {
            return ChannelResult.INSTANCE.m1974closedJP2dKIU(getCloseCause());
        }
        if (j >= (j2 & 1152921504606846975L)) {
            return ChannelResult.INSTANCE.m1975failurePtdJZtk();
        }
        Object access$getINTERRUPTED_RCV$p = BufferedChannelKt.access$getINTERRUPTED_RCV$p();
        ChannelSegment channelSegment = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(this);
        while (!isClosedForReceive()) {
            long andIncrement = access$getReceivers$volatile$FU().getAndIncrement(this);
            long j3 = andIncrement / BufferedChannelKt.SEGMENT_SIZE;
            int i = (int) (andIncrement % BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment.id != j3) {
                ChannelSegment access$findSegmentReceive = access$findSegmentReceive(this, j3, channelSegment);
                if (access$findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = access$findSegmentReceive;
                }
            }
            Object access$updateCellReceive = access$updateCellReceive(this, channelSegment, i, andIncrement, access$getINTERRUPTED_RCV$p);
            if (access$updateCellReceive == BufferedChannelKt.access$getSUSPEND$p()) {
                Waiter waiter = access$getINTERRUPTED_RCV$p instanceof Waiter ? (Waiter) access$getINTERRUPTED_RCV$p : null;
                if (waiter != null) {
                    access$prepareReceiverForSuspension(this, waiter, channelSegment, i);
                }
                waitExpandBufferCompletion$kotlinx_coroutines_core(andIncrement);
                channelSegment.onSlotCleaned();
                return ChannelResult.INSTANCE.m1975failurePtdJZtk();
            }
            ChannelSegment channelSegment2 = channelSegment;
            if (access$updateCellReceive != BufferedChannelKt.access$getFAILED$p()) {
                if (access$updateCellReceive == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                    throw new IllegalStateException("unexpected".toString());
                }
                channelSegment2.cleanPrev();
                return ChannelResult.INSTANCE.m1976successJP2dKIU(access$updateCellReceive);
            }
            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment2.cleanPrev();
            }
            channelSegment = channelSegment2;
        }
        return ChannelResult.INSTANCE.m1974closedJP2dKIU(getCloseCause());
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x006d. Please report as an issue. */
    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo1947trySendJP2dKIU(E element) {
        ChannelSegment channelSegment;
        if (shouldSendSuspend(getSendersAndCloseStatus$volatile$FU().get(this))) {
            return ChannelResult.INSTANCE.m1975failurePtdJZtk();
        }
        Object access$getINTERRUPTED_SEND$p = BufferedChannelKt.access$getINTERRUPTED_SEND$p();
        ChannelSegment channelSegment2 = (ChannelSegment) access$getSendSegment$volatile$FU().get(this);
        while (true) {
            long andIncrement = access$getSendersAndCloseStatus$volatile$FU().getAndIncrement(this);
            long j = 1152921504606846975L & andIncrement;
            boolean access$isClosedForSend0 = access$isClosedForSend0(this, andIncrement);
            long j2 = j / BufferedChannelKt.SEGMENT_SIZE;
            int i = (int) (j % BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment2.id != j2) {
                channelSegment = access$findSegmentSend(this, j2, channelSegment2);
                if (channelSegment == null) {
                    if (access$isClosedForSend0) {
                        return ChannelResult.INSTANCE.m1974closedJP2dKIU(getSendException());
                    }
                }
            } else {
                channelSegment = channelSegment2;
            }
            switch (access$updateCellSend(this, channelSegment, i, element, j, access$getINTERRUPTED_SEND$p, access$isClosedForSend0)) {
                case 0:
                    channelSegment.cleanPrev();
                    return ChannelResult.INSTANCE.m1976successJP2dKIU(Unit.INSTANCE);
                case 1:
                    return ChannelResult.INSTANCE.m1976successJP2dKIU(Unit.INSTANCE);
                case 2:
                    if (access$isClosedForSend0) {
                        channelSegment.onSlotCleaned();
                        return ChannelResult.INSTANCE.m1974closedJP2dKIU(getSendException());
                    }
                    Waiter waiter = access$getINTERRUPTED_SEND$p instanceof Waiter ? (Waiter) access$getINTERRUPTED_SEND$p : null;
                    if (waiter != null) {
                        access$prepareSenderForSuspension(this, waiter, channelSegment, i);
                    }
                    channelSegment.onSlotCleaned();
                    return ChannelResult.INSTANCE.m1975failurePtdJZtk();
                case 3:
                    throw new IllegalStateException("unexpected".toString());
                case 4:
                    if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    return ChannelResult.INSTANCE.m1974closedJP2dKIU(getSendException());
                case 5:
                    channelSegment.cleanPrev();
                default:
                    channelSegment2 = channelSegment;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00be, code lost:
    
        return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m1976successJP2dKIU(kotlin.Unit.INSTANCE);
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0055. Please report as an issue. */
    /* renamed from: trySendDropOldest-JP2dKIU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m1955trySendDropOldestJP2dKIU(E r20) {
        /*
            r19 = this;
            r0 = r19
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED
            r8 = 0
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = access$getSendSegment$volatile$FU()
            java.lang.Object r1 = r1.get(r0)
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1
        L12:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = access$getSendersAndCloseStatus$volatile$FU()
            long r9 = r2.getAndIncrement(r0)
            r2 = r9
            r4 = 0
            r11 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r4 = r2 & r11
            boolean r7 = access$isClosedForSend0(r0, r9)
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r2 = (long) r2
            long r11 = r4 / r2
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r2 = (long) r2
            long r2 = r4 % r2
            int r2 = (int) r2
            long r13 = r1.id
            int r3 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r3 == 0) goto L4f
            kotlinx.coroutines.channels.ChannelSegment r3 = access$findSegmentSend(r0, r11, r1)
            if (r3 != 0) goto L4e
            if (r7 == 0) goto L4d
            r3 = 0
        L42:
            kotlinx.coroutines.channels.ChannelResult$Companion r13 = kotlinx.coroutines.channels.ChannelResult.INSTANCE
            java.lang.Throwable r14 = r0.getSendException()
            java.lang.Object r13 = r13.m1974closedJP2dKIU(r14)
            return r13
        L4d:
            goto L12
        L4e:
            r1 = r3
        L4f:
            r3 = r20
            int r13 = access$updateCellSend(r0, r1, r2, r3, r4, r6, r7)
            switch(r13) {
                case 0: goto Lbf;
                case 1: goto Lb2;
                case 2: goto L7d;
                case 3: goto L70;
                case 4: goto L63;
                case 5: goto L5d;
                default: goto L58;
            }
        L58:
            r15 = r1
            r16 = r2
            goto Lc7
        L5d:
            r1.cleanPrev()
            r15 = r1
            goto Lc7
        L63:
            long r13 = r0.getReceiversCounter$kotlinx_coroutines_core()
            int r3 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r3 >= 0) goto L6e
            r1.cleanPrev()
        L6e:
            r3 = 0
            goto L42
        L70:
            r3 = 0
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L7d:
            if (r7 == 0) goto L84
            r1.onSlotCleaned()
            r3 = 0
            goto L42
        L84:
            boolean r3 = r6 instanceof kotlinx.coroutines.Waiter
            if (r3 == 0) goto L8c
            r3 = r6
            kotlinx.coroutines.Waiter r3 = (kotlinx.coroutines.Waiter) r3
            goto L8d
        L8c:
            r3 = 0
        L8d:
            if (r3 == 0) goto L92
            access$prepareSenderForSuspension(r0, r3, r1, r2)
        L92:
            r3 = r1
            r13 = r2
            r14 = 0
            r15 = r1
            r16 = r2
            long r1 = r3.id
            r17 = r1
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r1 = (long) r1
            long r1 = r1 * r17
            r17 = r1
            long r1 = (long) r13
            long r1 = r17 + r1
            r0.dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(r1)
            kotlinx.coroutines.channels.ChannelResult$Companion r1 = kotlinx.coroutines.channels.ChannelResult.INSTANCE
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            java.lang.Object r1 = r1.m1976successJP2dKIU(r2)
            return r1
        Lb2:
            r15 = r1
            r16 = r2
            r1 = 0
        Lb6:
            kotlinx.coroutines.channels.ChannelResult$Companion r2 = kotlinx.coroutines.channels.ChannelResult.INSTANCE
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            java.lang.Object r2 = r2.m1976successJP2dKIU(r3)
            return r2
        Lbf:
            r15 = r1
            r16 = r2
            r15.cleanPrev()
            r1 = 0
            goto Lb6
        Lc7:
            r1 = r15
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.m1955trySendDropOldestJP2dKIU(java.lang.Object):java.lang.Object");
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long globalIndex) {
        BufferedChannel<E> bufferedChannel = this;
        if (bufferedChannel.isRendezvousOrUnlimited()) {
            return;
        }
        while (bufferedChannel.getBufferEndCounter() <= globalIndex) {
            bufferedChannel = this;
        }
        int access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p = BufferedChannelKt.access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p();
        int i = 0;
        while (true) {
            long j = DurationKt.MAX_MILLIS;
            if (i < access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p) {
                long bufferEndCounter = bufferedChannel.getBufferEndCounter();
                if (bufferEndCounter == (getCompletedExpandBuffersAndPauseFlag$volatile$FU().get(bufferedChannel) & DurationKt.MAX_MILLIS) && bufferEndCounter == bufferedChannel.getBufferEndCounter()) {
                    return;
                } else {
                    i++;
                }
            } else {
                AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$volatile$FU2 = getCompletedExpandBuffersAndPauseFlag$volatile$FU();
                while (true) {
                    long j2 = completedExpandBuffersAndPauseFlag$volatile$FU2.get(bufferedChannel);
                    if (completedExpandBuffersAndPauseFlag$volatile$FU2.compareAndSet(bufferedChannel, j2, BufferedChannelKt.access$constructEBCompletedAndPauseFlag(j2 & DurationKt.MAX_MILLIS, true))) {
                        break;
                    } else {
                        bufferedChannel = this;
                    }
                }
                while (true) {
                    long bufferEndCounter2 = bufferedChannel.getBufferEndCounter();
                    long j3 = getCompletedExpandBuffersAndPauseFlag$volatile$FU().get(bufferedChannel);
                    long j4 = j3 & j;
                    boolean z = (4611686018427387904L & j3) != 0;
                    if (bufferEndCounter2 == j4 && bufferEndCounter2 == bufferedChannel.getBufferEndCounter()) {
                        break;
                    }
                    long j5 = j;
                    if (z) {
                        bufferedChannel = this;
                        j = j5;
                    } else {
                        bufferedChannel = this;
                        getCompletedExpandBuffersAndPauseFlag$volatile$FU().compareAndSet(bufferedChannel, j3, BufferedChannelKt.access$constructEBCompletedAndPauseFlag(j4, true));
                        j = j5;
                    }
                }
                AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$volatile$FU3 = getCompletedExpandBuffersAndPauseFlag$volatile$FU();
                while (true) {
                    long j6 = completedExpandBuffersAndPauseFlag$volatile$FU3.get(bufferedChannel);
                    long j7 = j;
                    if (completedExpandBuffersAndPauseFlag$volatile$FU3.compareAndSet(bufferedChannel, j6, BufferedChannelKt.access$constructEBCompletedAndPauseFlag(j6 & j7, false))) {
                        return;
                    }
                    bufferedChannel = this;
                    j = j7;
                }
            }
        }
    }
}
