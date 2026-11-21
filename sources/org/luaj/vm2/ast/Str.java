package org.luaj.vm2.ast;

import androidx.core.location.LocationRequestCompat;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.parser.LuaParserConstants;

/* loaded from: classes10.dex */
public class Str {
    private Str() {
    }

    public static LuaString charString(String str) {
        return LuaString.valueUsing(unquote(str.substring(1, str.length() - 1)));
    }

    public static byte[] iso88591bytes(String str) {
        try {
            return str.getBytes("ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("ISO8859-1 not supported");
        }
    }

    public static LuaString longString(String str) {
        int indexOf = str.indexOf(91, str.indexOf(91) + 1) + 1;
        return LuaString.valueUsing(iso88591bytes(str.substring(indexOf, str.length() - indexOf)));
    }

    public static LuaString quoteString(String str) {
        return LuaString.valueUsing(unquote(str.substring(1, str.length() - 1)));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x001a. Please report as an issue. */
    public static byte[] unquote(String str) {
        char c;
        byte b;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        while (i < length) {
            if (charArray[i] != '\\' || i >= length) {
                c = charArray[i];
            } else {
                i++;
                switch (charArray[i]) {
                    case '\"':
                        b = 34;
                        byteArrayOutputStream.write(b);
                        break;
                    case '\'':
                        b = 39;
                        byteArrayOutputStream.write(b);
                        break;
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case LuaParserConstants.EXP /* 56 */:
                    case LuaParserConstants.HEX /* 57 */:
                        int i2 = i + 1;
                        int i3 = charArray[i] - '0';
                        for (int i4 = 0; i2 < length && i4 < 2 && charArray[i2] >= '0' && charArray[i2] <= '9'; i4++) {
                            i3 = (i3 * 10) + (charArray[i2] - '0');
                            i2++;
                        }
                        byteArrayOutputStream.write((byte) i3);
                        i = i2 - 1;
                        break;
                    case '\\':
                        byteArrayOutputStream.write(92);
                        break;
                    case 'a':
                        b = 7;
                        byteArrayOutputStream.write(b);
                        break;
                    case 'b':
                        b = 8;
                        byteArrayOutputStream.write(b);
                        break;
                    case LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY /* 102 */:
                        b = 12;
                        byteArrayOutputStream.write(b);
                        break;
                    case 'n':
                        b = 10;
                        byteArrayOutputStream.write(b);
                        break;
                    case 'r':
                        b = 13;
                        byteArrayOutputStream.write(b);
                        break;
                    case 't':
                        b = 9;
                        byteArrayOutputStream.write(b);
                        break;
                    case 'v':
                        b = 11;
                        byteArrayOutputStream.write(b);
                        break;
                    default:
                        c = charArray[i];
                        break;
                }
                i++;
            }
            b = (byte) c;
            byteArrayOutputStream.write(b);
            i++;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
