package com.exampletest.mobilestudiotest.lua;

import com.exampletest.mobilestudiotest.core.OutputLog;
import com.exampletest.mobilestudiotest.model.BinaryString;
import com.exampletest.mobilestudiotest.model.BrickColorV;
import com.exampletest.mobilestudiotest.model.Color3;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.NumberRange;
import com.exampletest.mobilestudiotest.model.Rect;
import com.exampletest.mobilestudiotest.model.UDim;
import com.exampletest.mobilestudiotest.model.UDim2;
import com.exampletest.mobilestudiotest.model.Vector2;
import com.exampletest.mobilestudiotest.model.Vector3;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: InstanceApi.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006R2\u0010\u0004\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/Attributes;", "", "<init>", "()V", "loaded", "", "Lcom/exampletest/mobilestudiotest/model/Instance;", "kotlin.jvm.PlatformType", "", "load", "", "i", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Attributes {
    public static final Attributes INSTANCE = new Attributes();
    private static final Set<Instance> loaded = Collections.newSetFromMap(new WeakHashMap());

    private Attributes() {
    }

    private static final String load$str(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.getInt()];
        byteBuffer.get(bArr);
        return new String(bArr, Charsets.UTF_8);
    }

    public final void load(Instance i) {
        byte[] bytes;
        Object load$str;
        Intrinsics.checkNotNullParameter(i, "i");
        if (loaded.add(i)) {
            Object obj = i.get("AttributesSerialize");
            if (obj instanceof BinaryString) {
                bytes = ((BinaryString) obj).getBytes();
            } else {
                if (!(obj instanceof String)) {
                    return;
                }
                bytes = ((String) obj).getBytes(Charsets.ISO_8859_1);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            }
            if (bytes.length < 4) {
                return;
            }
            try {
                ByteBuffer order = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
                int i2 = order.getInt();
                for (int i3 = 0; i3 < i2; i3++) {
                    String load$str2 = load$str(order);
                    switch (order.get() & UByte.MAX_VALUE) {
                        case 2:
                            load$str = load$str(order);
                            break;
                        case 3:
                            load$str = Boolean.valueOf(order.get() != 0);
                            break;
                        case 5:
                            load$str = Float.valueOf(order.getFloat());
                            break;
                        case 6:
                            load$str = Double.valueOf(order.getDouble());
                            break;
                        case 9:
                            load$str = new UDim(order.getFloat(), order.getInt());
                            break;
                        case 10:
                            load$str = new UDim2(order.getFloat(), order.getInt(), order.getFloat(), order.getInt());
                            break;
                        case 14:
                            load$str = new BrickColorV(order.getInt());
                            break;
                        case 15:
                            load$str = new Color3(order.getFloat(), order.getFloat(), order.getFloat());
                            break;
                        case 16:
                            load$str = new Vector2(order.getFloat(), order.getFloat());
                            break;
                        case 17:
                            load$str = new Vector3(order.getFloat(), order.getFloat(), order.getFloat());
                            break;
                        case 27:
                            load$str = new NumberRange(order.getFloat(), order.getFloat());
                            break;
                        case 28:
                            load$str = new Rect(order.getFloat(), order.getFloat(), order.getFloat(), order.getFloat());
                            break;
                        default:
                            return;
                    }
                    if (!i.getAttributes().containsKey(load$str2)) {
                        i.getAttributes().put(load$str2, load$str);
                    }
                }
            } catch (Exception e) {
                OutputLog.INSTANCE.warn("Could not read attributes of " + i.fullName());
            }
        }
    }
}
