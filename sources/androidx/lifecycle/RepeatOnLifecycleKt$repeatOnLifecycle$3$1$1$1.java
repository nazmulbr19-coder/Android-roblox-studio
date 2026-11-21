package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;

/* compiled from: RepeatOnLifecycle.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 implements LifecycleEventObserver {
    final /* synthetic */ CoroutineScope $$this$coroutineScope;
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Lifecycle.Event $cancelWorkEvent;
    final /* synthetic */ CancellableContinuation<Unit> $cont;
    final /* synthetic */ Ref.ObjectRef<Job> $launchedJob;
    final /* synthetic */ Mutex $mutex;
    final /* synthetic */ Lifecycle.Event $startWorkEvent;

    /* compiled from: RepeatOnLifecycle.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1", f = "RepeatOnLifecycle.kt", i = {0, 1}, l = {166, 110}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"}, v = 1)
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Mutex $mutex;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Mutex mutex, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$mutex = mutex;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$mutex, this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return invoke2(coroutineScope, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:21:0x005f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                switch(r1) {
                    case 0: goto L2a;
                    case 1: goto L1c;
                    case 2: goto L11;
                    default: goto L9;
                }
            L9:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L11:
                r0 = 0
                r1 = 0
                r2 = 0
                java.lang.Object r3 = r9.L$0
                kotlinx.coroutines.sync.Mutex r3 = (kotlinx.coroutines.sync.Mutex) r3
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L6f
                goto L64
            L1c:
                r1 = 0
                java.lang.Object r2 = r9.L$1
                kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
                r3 = 0
                java.lang.Object r4 = r9.L$0
                kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
                kotlin.ResultKt.throwOnFailure(r10)
                goto L48
            L2a:
                kotlin.ResultKt.throwOnFailure(r10)
                kotlinx.coroutines.sync.Mutex r1 = r9.$mutex
                kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r2 = r9.$block
                r3 = 0
                r4 = 0
                r5 = r9
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r9.L$0 = r1
                r9.L$1 = r2
                r6 = 1
                r9.label = r6
                java.lang.Object r5 = r1.lock(r3, r5)
                if (r5 != r0) goto L45
                return r0
            L45:
                r8 = r4
                r4 = r1
                r1 = r8
            L48:
                r5 = 0
                androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 r6 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1     // Catch: java.lang.Throwable -> L71
                r7 = 0
                r6.<init>(r2, r7)     // Catch: java.lang.Throwable -> L71
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch: java.lang.Throwable -> L71
                r9.L$0 = r4     // Catch: java.lang.Throwable -> L71
                r9.L$1 = r7     // Catch: java.lang.Throwable -> L71
                r2 = 2
                r9.label = r2     // Catch: java.lang.Throwable -> L71
                java.lang.Object r2 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r6, r9)     // Catch: java.lang.Throwable -> L71
                if (r2 != r0) goto L60
                return r0
            L60:
                r0 = r1
                r2 = r3
                r3 = r4
                r1 = r5
            L64:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L6f
                r3.unlock(r2)
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L6f:
                r1 = move-exception
                goto L77
            L71:
                r0 = move-exception
                r2 = r1
                r1 = r0
                r0 = r2
                r2 = r3
                r3 = r4
            L77:
                r3.unlock(r2)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1(Lifecycle.Event event, Ref.ObjectRef<Job> objectRef, CoroutineScope coroutineScope, Lifecycle.Event event2, CancellableContinuation<? super Unit> cancellableContinuation, Mutex mutex, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.$startWorkEvent = event;
        this.$launchedJob = objectRef;
        this.$$this$coroutineScope = coroutineScope;
        this.$cancelWorkEvent = event2;
        this.$cont = cancellableContinuation;
        this.$mutex = mutex;
        this.$block = function2;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, kotlinx.coroutines.Job] */
    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == this.$startWorkEvent) {
            this.$launchedJob.element = BuildersKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass1(this.$mutex, this.$block, null), 3, null);
            return;
        }
        if (event == this.$cancelWorkEvent) {
            Job job = this.$launchedJob.element;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.$launchedJob.element = null;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            CancellableContinuation<Unit> cancellableContinuation = this.$cont;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m457constructorimpl(Unit.INSTANCE));
        }
    }
}
