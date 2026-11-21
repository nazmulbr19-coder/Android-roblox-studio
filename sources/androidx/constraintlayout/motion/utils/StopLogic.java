package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.core.motion.utils.SpringStopEngine;
import androidx.constraintlayout.core.motion.utils.StopEngine;
import androidx.constraintlayout.core.motion.utils.StopLogicEngine;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

/* loaded from: classes.dex */
public class StopLogic extends MotionInterpolator {
    private SpringStopEngine mSpringStopEngine;
    private StopLogicEngine mStopLogicEngine = new StopLogicEngine();
    private StopEngine mEngine = this.mStopLogicEngine;

    public void config(float f, float f2, float f3, float f4, float f5, float f6) {
        this.mEngine = this.mStopLogicEngine;
        this.mStopLogicEngine.config(f, f2, f3, f4, f5, f6);
    }

    public String debug(String str, float f) {
        return this.mEngine.debug(str, f);
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return this.mEngine.getInterpolation(f);
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public float getVelocity() {
        return this.mEngine.getVelocity();
    }

    public float getVelocity(float f) {
        return this.mEngine.getVelocity(f);
    }

    public boolean isStopped() {
        return this.mEngine.isStopped();
    }

    public void springConfig(float f, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        if (this.mSpringStopEngine == null) {
            this.mSpringStopEngine = new SpringStopEngine();
        }
        this.mEngine = this.mSpringStopEngine;
        this.mSpringStopEngine.springConfig(f, f2, f3, f4, f5, f6, f7, i);
    }
}
