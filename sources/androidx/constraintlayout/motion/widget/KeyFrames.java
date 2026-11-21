package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class KeyFrames {
    private static final String CUSTOM_ATTRIBUTE = "CustomAttribute";
    private static final String CUSTOM_METHOD = "CustomMethod";
    private static final String TAG = "KeyFrames";
    public static final int UNSET = -1;
    static HashMap<String, Constructor<? extends Key>> sKeyMakers = new HashMap<>();
    private HashMap<Integer, ArrayList<Key>> mFramesMap = new HashMap<>();

    static {
        try {
            sKeyMakers.put("KeyAttribute", KeyAttributes.class.getConstructor(new Class[0]));
            sKeyMakers.put(TypedValues.PositionType.NAME, KeyPosition.class.getConstructor(new Class[0]));
            sKeyMakers.put(TypedValues.CycleType.NAME, KeyCycle.class.getConstructor(new Class[0]));
            sKeyMakers.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(new Class[0]));
            sKeyMakers.put(TypedValues.TriggerType.NAME, KeyTrigger.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "unable to load", e);
        }
    }

    public KeyFrames() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x0070. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0017. Please report as an issue. */
    public KeyFrames(Context context, XmlPullParser xmlPullParser) {
        Key keyAttributes;
        Key key = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (true) {
                char c = 1;
                if (eventType == 1) {
                    return;
                }
                switch (eventType) {
                    case 0:
                        eventType = xmlPullParser.next();
                    case 1:
                    default:
                        eventType = xmlPullParser.next();
                    case 2:
                        String name = xmlPullParser.getName();
                        if (sKeyMakers.containsKey(name)) {
                            switch (name.hashCode()) {
                                case -300573030:
                                    if (name.equals("KeyTimeCycle")) {
                                        c = 3;
                                        break;
                                    }
                                    break;
                                case -298435811:
                                    if (name.equals("KeyAttribute")) {
                                        c = 0;
                                        break;
                                    }
                                    break;
                                case 540053991:
                                    if (name.equals(TypedValues.CycleType.NAME)) {
                                        c = 2;
                                        break;
                                    }
                                    break;
                                case 1153397896:
                                    if (name.equals(TypedValues.PositionType.NAME)) {
                                        break;
                                    }
                                    break;
                                case 1308496505:
                                    if (name.equals(TypedValues.TriggerType.NAME)) {
                                        c = 4;
                                        break;
                                    }
                                    break;
                            }
                            c = 65535;
                            switch (c) {
                                case 0:
                                    keyAttributes = new KeyAttributes();
                                    keyAttributes.load(context, Xml.asAttributeSet(xmlPullParser));
                                    addKey(keyAttributes);
                                    key = keyAttributes;
                                    break;
                                case 1:
                                    keyAttributes = new KeyPosition();
                                    keyAttributes.load(context, Xml.asAttributeSet(xmlPullParser));
                                    addKey(keyAttributes);
                                    key = keyAttributes;
                                    break;
                                case 2:
                                    keyAttributes = new KeyCycle();
                                    keyAttributes.load(context, Xml.asAttributeSet(xmlPullParser));
                                    addKey(keyAttributes);
                                    key = keyAttributes;
                                    break;
                                case 3:
                                    keyAttributes = new KeyTimeCycle();
                                    keyAttributes.load(context, Xml.asAttributeSet(xmlPullParser));
                                    addKey(keyAttributes);
                                    key = keyAttributes;
                                    break;
                                case 4:
                                    keyAttributes = new KeyTrigger();
                                    keyAttributes.load(context, Xml.asAttributeSet(xmlPullParser));
                                    addKey(keyAttributes);
                                    key = keyAttributes;
                                    break;
                                default:
                                    throw new NullPointerException("Key " + name + " not found");
                            }
                        } else if (name.equalsIgnoreCase("CustomAttribute")) {
                            if (key != null && key.mCustomConstraints != null) {
                                ConstraintAttribute.parse(context, xmlPullParser, key.mCustomConstraints);
                            }
                        } else if (name.equalsIgnoreCase("CustomMethod") && key != null && key.mCustomConstraints != null) {
                            ConstraintAttribute.parse(context, xmlPullParser, key.mCustomConstraints);
                        }
                        eventType = xmlPullParser.next();
                        break;
                    case 3:
                        if (ViewTransition.KEY_FRAME_SET_TAG.equals(xmlPullParser.getName())) {
                            return;
                        }
                        eventType = xmlPullParser.next();
                }
            }
        } catch (IOException e) {
            Log.e(TAG, "Error parsing XML resource", e);
        } catch (XmlPullParserException e2) {
            Log.e(TAG, "Error parsing XML resource", e2);
        }
    }

    static String name(int i, Context context) {
        return context.getResources().getResourceEntryName(i);
    }

    public void addAllFrames(MotionController motionController) {
        ArrayList<Key> arrayList = this.mFramesMap.get(-1);
        if (arrayList != null) {
            motionController.addKeys(arrayList);
        }
    }

    public void addFrames(MotionController motionController) {
        ArrayList<Key> arrayList = this.mFramesMap.get(Integer.valueOf(motionController.mId));
        if (arrayList != null) {
            motionController.addKeys(arrayList);
        }
        ArrayList<Key> arrayList2 = this.mFramesMap.get(-1);
        if (arrayList2 != null) {
            Iterator<Key> it = arrayList2.iterator();
            while (it.hasNext()) {
                Key next = it.next();
                if (next.matches(((ConstraintLayout.LayoutParams) motionController.mView.getLayoutParams()).constraintTag)) {
                    motionController.addKey(next);
                }
            }
        }
    }

    public void addKey(Key key) {
        if (!this.mFramesMap.containsKey(Integer.valueOf(key.mTargetId))) {
            this.mFramesMap.put(Integer.valueOf(key.mTargetId), new ArrayList<>());
        }
        ArrayList<Key> arrayList = this.mFramesMap.get(Integer.valueOf(key.mTargetId));
        if (arrayList != null) {
            arrayList.add(key);
        }
    }

    public ArrayList<Key> getKeyFramesForView(int i) {
        return this.mFramesMap.get(Integer.valueOf(i));
    }

    public Set<Integer> getKeys() {
        return this.mFramesMap.keySet();
    }
}
