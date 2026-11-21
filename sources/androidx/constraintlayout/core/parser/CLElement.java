package androidx.constraintlayout.core.parser;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public class CLElement implements Cloneable {
    protected CLContainer mContainer;
    private final char[] mContent;
    private int mLine;
    protected static int sMaxLine = 80;
    protected static int sBaseIndent = 2;
    protected long mStart = -1;
    protected long mEnd = Long.MAX_VALUE;

    public CLElement(char[] cArr) {
        this.mContent = cArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addIndent(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(' ');
        }
    }

    public CLElement clone() {
        try {
            return (CLElement) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo37clone() throws CloneNotSupportedException {
        return clone();
    }

    public String content() {
        String str = new String(this.mContent);
        return str.length() < 1 ? "" : (this.mEnd == Long.MAX_VALUE || this.mEnd < this.mStart) ? str.substring((int) this.mStart, ((int) this.mStart) + 1) : str.substring((int) this.mStart, ((int) this.mEnd) + 1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CLElement)) {
            return false;
        }
        CLElement cLElement = (CLElement) obj;
        if (this.mStart == cLElement.mStart && this.mEnd == cLElement.mEnd && this.mLine == cLElement.mLine && Arrays.equals(this.mContent, cLElement.mContent)) {
            return Objects.equals(this.mContainer, cLElement.mContainer);
        }
        return false;
    }

    public CLElement getContainer() {
        return this.mContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getDebugName() {
        return CLParser.sDebug ? getStrClass() + " -> " : "";
    }

    public long getEnd() {
        return this.mEnd;
    }

    public float getFloat() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).getFloat();
        }
        return Float.NaN;
    }

    public int getInt() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).getInt();
        }
        return 0;
    }

    public int getLine() {
        return this.mLine;
    }

    public long getStart() {
        return this.mStart;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getStrClass() {
        String cls = getClass().toString();
        return cls.substring(cls.lastIndexOf(46) + 1);
    }

    public boolean hasContent() {
        return this.mContent != null && this.mContent.length >= 1;
    }

    public int hashCode() {
        return (((((((Arrays.hashCode(this.mContent) * 31) + ((int) (this.mStart ^ (this.mStart >>> 32)))) * 31) + ((int) (this.mEnd ^ (this.mEnd >>> 32)))) * 31) + (this.mContainer != null ? this.mContainer.hashCode() : 0)) * 31) + this.mLine;
    }

    public boolean isDone() {
        return this.mEnd != Long.MAX_VALUE;
    }

    public boolean isStarted() {
        return this.mStart > -1;
    }

    public boolean notStarted() {
        return this.mStart == -1;
    }

    public void setContainer(CLContainer cLContainer) {
        this.mContainer = cLContainer;
    }

    public void setEnd(long j) {
        if (this.mEnd != Long.MAX_VALUE) {
            return;
        }
        this.mEnd = j;
        if (CLParser.sDebug) {
            System.out.println("closing " + hashCode() + " -> " + this);
        }
        if (this.mContainer != null) {
            this.mContainer.add(this);
        }
    }

    public void setLine(int i) {
        this.mLine = i;
    }

    public void setStart(long j) {
        this.mStart = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String toFormattedJSON(int i, int i2) {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String toJSON() {
        return "";
    }

    public String toString() {
        if (this.mStart > this.mEnd || this.mEnd == Long.MAX_VALUE) {
            return getClass() + " (INVALID, " + this.mStart + "-" + this.mEnd + ")";
        }
        return getStrClass() + " (" + this.mStart + " : " + this.mEnd + ") <<" + new String(this.mContent).substring((int) this.mStart, ((int) this.mEnd) + 1) + ">>";
    }
}
