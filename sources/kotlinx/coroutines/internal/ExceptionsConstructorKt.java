package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;

/* compiled from: ExceptionsConstructor.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a!\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00042\u0006\u0010\t\u001a\u0002H\bH\u0000¢\u0006\u0002\u0010\n\u001a7\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\u0002`\f\"\b\b\u0000\u0010\b*\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\b0\u000eH\u0002¢\u0006\u0002\u0010\u000f\u001a3\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\u0002`\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0002\u0010\u0012\u001a\u0018\u0010\u0013\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0014\u001a\u00020\u0001H\u0002\u001a\u001b\u0010\u0015\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u0001H\u0082\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u0002\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¨\u0006\u0017"}, d2 = {"throwableFields", "", "Ctor", "Lkotlin/Function1;", "", "ctorCache", "Lkotlinx/coroutines/internal/CtorCache;", "tryCopyException", "E", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "createConstructor", "Lkotlinx/coroutines/internal/Ctor;", "clz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lkotlin/jvm/functions/Function1;", "safeCtor", "block", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "fieldsCountOrDefault", "defaultValue", "fieldsCount", "accumulator", "kotlinx-coroutines-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes10.dex */
public final class ExceptionsConstructorKt {
    private static final CtorCache ctorCache;
    private static final int throwableFields = fieldsCountOrDefault(Throwable.class, -1);

    static {
        ClassValueCtorCache classValueCtorCache;
        try {
            classValueCtorCache = FastServiceLoaderKt.getANDROID_DETECTED() ? WeakMapCtorCache.INSTANCE : ClassValueCtorCache.INSTANCE;
        } catch (Throwable th) {
            classValueCtorCache = WeakMapCtorCache.INSTANCE;
        }
        ctorCache = classValueCtorCache;
    }

    public static final /* synthetic */ Function1 access$createConstructor(Class cls) {
        return createConstructor(cls);
    }

    private static final <E extends Throwable> Function1<Throwable, Throwable> createConstructor(Class<E> cls) {
        Function1<Throwable, Throwable> function1;
        int i;
        Pair pair;
        ExceptionsConstructorKt$createConstructor$nullResult$1 exceptionsConstructorKt$createConstructor$nullResult$1 = ExceptionsConstructorKt$createConstructor$nullResult$1.INSTANCE;
        int i2 = 0;
        if (throwableFields != fieldsCountOrDefault(cls, 0)) {
            return exceptionsConstructorKt$createConstructor$nullResult$1;
        }
        Constructor<?>[] constructors = cls.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.length);
        int length = constructors.length;
        int i3 = 0;
        while (true) {
            Object obj = null;
            if (i3 >= length) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    obj = it.next();
                    if (it.hasNext()) {
                        int intValue = ((Number) ((Pair) obj).getSecond()).intValue();
                        do {
                            Object next = it.next();
                            int intValue2 = ((Number) ((Pair) next).getSecond()).intValue();
                            if (intValue < intValue2) {
                                intValue = intValue2;
                                obj = next;
                            }
                        } while (it.hasNext());
                    }
                }
                Pair pair2 = (Pair) obj;
                return (pair2 == null || (function1 = (Function1) pair2.getFirst()) == null) ? exceptionsConstructorKt$createConstructor$nullResult$1 : function1;
            }
            Constructor<?> constructor = constructors[i3];
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            switch (parameterTypes.length) {
                case 0:
                    i = i2;
                    pair = TuplesKt.to(safeCtor(new ExceptionsConstructorKt$$ExternalSyntheticLambda4(constructor)), Integer.valueOf(i));
                    break;
                case 1:
                    i = i2;
                    Class<?> cls2 = parameterTypes[i];
                    if (!Intrinsics.areEqual(cls2, String.class)) {
                        if (!Intrinsics.areEqual(cls2, Throwable.class)) {
                            pair = TuplesKt.to(null, -1);
                            break;
                        } else {
                            pair = TuplesKt.to(safeCtor(new ExceptionsConstructorKt$$ExternalSyntheticLambda3(constructor)), 1);
                            break;
                        }
                    } else {
                        pair = TuplesKt.to(safeCtor(new ExceptionsConstructorKt$$ExternalSyntheticLambda2(constructor)), 2);
                        break;
                    }
                case 2:
                    i = i2;
                    if (!Intrinsics.areEqual(parameterTypes[i2], String.class) || !Intrinsics.areEqual(parameterTypes[1], Throwable.class)) {
                        pair = TuplesKt.to(null, -1);
                        break;
                    } else {
                        pair = TuplesKt.to(safeCtor(new ExceptionsConstructorKt$$ExternalSyntheticLambda1(constructor)), 3);
                        break;
                    }
                default:
                    i = i2;
                    pair = TuplesKt.to(null, -1);
                    break;
            }
            arrayList.add(pair);
            i3++;
            i2 = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Throwable createConstructor$lambda$7$lambda$1(Constructor constructor, Throwable th) {
        Object newInstance = constructor.newInstance(th.getMessage(), th);
        Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Throwable");
        return (Throwable) newInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Throwable createConstructor$lambda$7$lambda$3(Constructor constructor, Throwable th) {
        Object newInstance = constructor.newInstance(th.getMessage());
        Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Throwable");
        Throwable th2 = (Throwable) newInstance;
        th2.initCause(th);
        return th2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Throwable createConstructor$lambda$7$lambda$4(Constructor constructor, Throwable th) {
        Object newInstance = constructor.newInstance(th);
        Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Throwable");
        return (Throwable) newInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Throwable createConstructor$lambda$7$lambda$6(Constructor constructor, Throwable th) {
        Object newInstance = constructor.newInstance(new Object[0]);
        Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Throwable");
        Throwable th2 = (Throwable) newInstance;
        th2.initCause(th);
        return th2;
    }

    private static final int fieldsCount(Class<?> cls, int i) {
        while (true) {
            int i2 = 0;
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i2++;
                }
            }
            int i3 = i + i2;
            Class<? super Object> superclass = cls.getSuperclass();
            if (superclass == null) {
                return i3;
            }
            cls = superclass;
            i = i3;
        }
    }

    static /* synthetic */ int fieldsCount$default(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return fieldsCount(cls, i);
    }

    private static final int fieldsCountOrDefault(Class<?> cls, int i) {
        Object m457constructorimpl;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.INSTANCE;
            m457constructorimpl = Result.m457constructorimpl(Integer.valueOf(fieldsCount$default(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m457constructorimpl = Result.m457constructorimpl(ResultKt.createFailure(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (Result.m463isFailureimpl(m457constructorimpl)) {
            m457constructorimpl = valueOf;
        }
        return ((Number) m457constructorimpl).intValue();
    }

    private static final Function1<Throwable, Throwable> safeCtor(Function1<? super Throwable, ? extends Throwable> function1) {
        return new ExceptionsConstructorKt$$ExternalSyntheticLambda0(function1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Throwable safeCtor$lambda$9(Function1 function1, Throwable th) {
        Object m457constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Throwable th2 = (Throwable) function1.invoke(th);
            if (!Intrinsics.areEqual(th.getMessage(), th2.getMessage()) && !Intrinsics.areEqual(th2.getMessage(), th.toString())) {
                th2 = null;
            }
            m457constructorimpl = Result.m457constructorimpl(th2);
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.INSTANCE;
            m457constructorimpl = Result.m457constructorimpl(ResultKt.createFailure(th3));
        }
        return (Throwable) (Result.m463isFailureimpl(m457constructorimpl) ? null : m457constructorimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E extends Throwable> E tryCopyException(E e) {
        Object m457constructorimpl;
        if (!(e instanceof CopyableThrowable)) {
            return (E) ctorCache.get(e.getClass()).invoke(e);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m457constructorimpl = Result.m457constructorimpl(((CopyableThrowable) e).createCopy());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m457constructorimpl = Result.m457constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m463isFailureimpl(m457constructorimpl)) {
            m457constructorimpl = null;
        }
        return (E) m457constructorimpl;
    }
}
