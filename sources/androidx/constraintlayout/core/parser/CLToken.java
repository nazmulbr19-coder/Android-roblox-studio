package androidx.constraintlayout.core.parser;

/* loaded from: classes.dex */
public class CLToken extends CLElement {
    int mIndex;
    char[] mTokenFalse;
    char[] mTokenNull;
    char[] mTokenTrue;
    Type mType;

    /* loaded from: classes.dex */
    enum Type {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    public CLToken(char[] cArr) {
        super(cArr);
        this.mIndex = 0;
        this.mType = Type.UNKNOWN;
        this.mTokenTrue = "true".toCharArray();
        this.mTokenFalse = "false".toCharArray();
        this.mTokenNull = "null".toCharArray();
    }

    public static CLElement allocate(char[] cArr) {
        return new CLToken(cArr);
    }

    public boolean getBoolean() throws CLParsingException {
        if (this.mType == Type.TRUE) {
            return true;
        }
        if (this.mType == Type.FALSE) {
            return false;
        }
        throw new CLParsingException("this token is not a boolean: <" + content() + ">", this);
    }

    public Type getType() {
        return this.mType;
    }

    public boolean isNull() throws CLParsingException {
        if (this.mType == Type.NULL) {
            return true;
        }
        throw new CLParsingException("this token is not a null: <" + content() + ">", this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i);
        sb.append(content());
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        return CLParser.sDebug ? "<" + content() + ">" : content();
    }

    public boolean validate(char c, long j) {
        boolean z = false;
        switch (this.mType) {
            case UNKNOWN:
                if (this.mTokenTrue[this.mIndex] != c) {
                    if (this.mTokenFalse[this.mIndex] != c) {
                        if (this.mTokenNull[this.mIndex] == c) {
                            this.mType = Type.NULL;
                            z = true;
                            break;
                        }
                    } else {
                        this.mType = Type.FALSE;
                        z = true;
                        break;
                    }
                } else {
                    this.mType = Type.TRUE;
                    z = true;
                    break;
                }
                break;
            case TRUE:
                z = this.mTokenTrue[this.mIndex] == c;
                if (z && this.mIndex + 1 == this.mTokenTrue.length) {
                    setEnd(j);
                    break;
                }
                break;
            case FALSE:
                z = this.mTokenFalse[this.mIndex] == c;
                if (z && this.mIndex + 1 == this.mTokenFalse.length) {
                    setEnd(j);
                    break;
                }
                break;
            case NULL:
                z = this.mTokenNull[this.mIndex] == c;
                if (z && this.mIndex + 1 == this.mTokenNull.length) {
                    setEnd(j);
                    break;
                }
                break;
        }
        this.mIndex++;
        return z;
    }
}
