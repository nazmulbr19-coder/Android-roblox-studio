package com.exampletest.mobilestudiotest.format;

import com.exampletest.mobilestudiotest.model.BinaryString;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Vector3;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CodingErrorAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: RbxBinary.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\"\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\f"}, d2 = {"bytesToStringValue", "", "b", "", "NORMALS", "", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "[Lcom/exampletest/mobilestudiotest/model/Vector3;", "rotationFromId", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "id", "", "app"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RbxBinaryKt {
    private static final Vector3[] NORMALS = {Vector3.INSTANCE.getX(), Vector3.INSTANCE.getY(), Vector3.INSTANCE.getZ(), Vector3.INSTANCE.getX().unaryMinus(), Vector3.INSTANCE.getY().unaryMinus(), Vector3.INSTANCE.getZ().unaryMinus()};

    public static final /* synthetic */ Object access$bytesToStringValue(byte[] bArr) {
        return bytesToStringValue(bArr);
    }

    public static final /* synthetic */ CFrame access$rotationFromId(int i) {
        return rotationFromId(i);
    }

    private static final Object bytesToStringValue(byte[] bArr) {
        try {
            String charBuffer = Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bArr)).toString();
            Intrinsics.checkNotNull(charBuffer);
            return charBuffer;
        } catch (CharacterCodingException e) {
            return new BinaryString(bArr);
        }
    }

    private static final CFrame rotationFromId(int i) {
        int i2 = i - 1;
        Vector3 vector3 = NORMALS[i2 / 6];
        Vector3 vector32 = NORMALS[i2 % 6];
        return CFrame.INSTANCE.fromColumns(Vector3.INSTANCE.getZERO(), vector3, vector32, vector3.cross(vector32));
    }
}
