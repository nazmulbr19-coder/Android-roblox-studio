package org.luaj.vm2.parser;

/* loaded from: classes10.dex */
public class TokenMgrError extends Error {
    static final int INVALID_LEXICAL_STATE = 2;
    static final int LEXICAL_ERROR = 0;
    static final int LOOP_DETECTED = 3;
    static final int STATIC_LEXER_ERROR = 1;
    private static final long serialVersionUID = 1;
    int errorCode;

    public TokenMgrError() {
    }

    public TokenMgrError(String str, int i) {
        super(str);
        this.errorCode = i;
    }

    public TokenMgrError(boolean z, int i, int i2, int i3, String str, char c, int i4) {
        this(LexicalError(z, i, i2, i3, str, c), i4);
    }

    protected static String LexicalError(boolean z, int i, int i2, int i3, String str, char c) {
        return new StringBuffer().append("Lexical error at line ").append(i2).append(", column ").append(i3).append(".  Encountered: ").append(z ? "<EOF> " : new StringBuffer().append("\"").append(addEscapes(String.valueOf(c))).append("\"").append(" (").append((int) c).append("), ").toString()).append("after : \"").append(addEscapes(str)).append("\"").toString();
    }

    protected static final String addEscapes(String str) {
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 0:
                    break;
                case '\b':
                    str2 = "\\b";
                    break;
                case '\t':
                    str2 = "\\t";
                    break;
                case '\n':
                    str2 = "\\n";
                    break;
                case '\f':
                    str2 = "\\f";
                    break;
                case '\r':
                    str2 = "\\r";
                    break;
                case '\"':
                    str2 = "\\\"";
                    break;
                case '\'':
                    str2 = "\\'";
                    break;
                case '\\':
                    str2 = "\\\\";
                    break;
                default:
                    char charAt = str.charAt(i);
                    if (charAt < ' ' || charAt > '~') {
                        String stringBuffer2 = new StringBuffer().append("0000").append(Integer.toString(charAt, 16)).toString();
                        str2 = new StringBuffer().append("\\u").append(stringBuffer2.substring(stringBuffer2.length() - 4, stringBuffer2.length())).toString();
                        break;
                    } else {
                        stringBuffer.append(charAt);
                        break;
                    }
                    break;
            }
            stringBuffer.append(str2);
        }
        return stringBuffer.toString();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage();
    }
}
