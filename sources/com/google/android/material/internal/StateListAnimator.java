package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class StateListAnimator {
    private final ArrayList<Tuple> tuples = new ArrayList<>();
    private Tuple lastMatch = null;
    ValueAnimator runningAnimator = null;
    private final Animator.AnimatorListener animationListener = new AnonymousClass1();

    /* renamed from: com.google.android.material.internal.StateListAnimator$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (StateListAnimator.this.runningAnimator == animator) {
                StateListAnimator.this.runningAnimator = null;
            }
        }
    }

    /* loaded from: classes.dex */
    static class Tuple {
        final ValueAnimator animator;
        final int[] specs;

        Tuple(int[] iArr, ValueAnimator valueAnimator) {
            this.specs = iArr;
            this.animator = valueAnimator;
        }
    }

    private void cancel() {
        if (this.runningAnimator != null) {
            this.runningAnimator.cancel();
            this.runningAnimator = null;
        }
    }

    private void start(Tuple tuple) {
        this.runningAnimator = tuple.animator;
        this.runningAnimator.start();
    }

    public void addState(int[] iArr, ValueAnimator valueAnimator) {
        Tuple tuple = new Tuple(iArr, valueAnimator);
        valueAnimator.addListener(this.animationListener);
        this.tuples.add(tuple);
    }

    public void jumpToCurrentState() {
        if (this.runningAnimator != null) {
            this.runningAnimator.end();
            this.runningAnimator = null;
        }
    }

    public void setState(int[] iArr) {
        Tuple tuple = null;
        int size = this.tuples.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            Tuple tuple2 = this.tuples.get(i);
            if (StateSet.stateSetMatches(tuple2.specs, iArr)) {
                tuple = tuple2;
                break;
            }
            i++;
        }
        if (tuple == this.lastMatch) {
            return;
        }
        if (this.lastMatch != null) {
            cancel();
        }
        this.lastMatch = tuple;
        if (tuple != null) {
            start(tuple);
        }
    }
}
