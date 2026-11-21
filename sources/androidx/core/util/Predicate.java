package androidx.core.util;

import java.util.Objects;

/* loaded from: classes.dex */
public interface Predicate<T> {
    static <T> Predicate<T> isEqual(Object obj) {
        return obj == null ? new Predicate$$ExternalSyntheticLambda1() : new Predicate$$ExternalSyntheticLambda2(obj);
    }

    static /* synthetic */ boolean lambda$and$0(Predicate predicate, Predicate predicate2, Object obj) {
        return predicate.test(obj) && predicate2.test(obj);
    }

    static /* synthetic */ boolean lambda$isEqual$3(Object obj) {
        return Objects.isNull(obj);
    }

    static /* synthetic */ boolean lambda$isEqual$4(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    static /* synthetic */ boolean lambda$negate$1(Predicate predicate, Object obj) {
        return !predicate.test(obj);
    }

    static /* synthetic */ boolean lambda$or$2(Predicate predicate, Predicate predicate2, Object obj) {
        return predicate.test(obj) || predicate2.test(obj);
    }

    static <T> Predicate<T> not(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }

    default Predicate<T> and(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return new Predicate$$ExternalSyntheticLambda3(this, predicate);
    }

    default Predicate<T> negate() {
        return new Predicate$$ExternalSyntheticLambda4(this);
    }

    default Predicate<T> or(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return new Predicate$$ExternalSyntheticLambda0(this, predicate);
    }

    boolean test(T t);
}
