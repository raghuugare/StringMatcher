package com.rags.ds;

/**
 * Description:
 * <p/>
 * Compilation: {@code javac MatchValue.java}
 * <p/>
 * Execution: {@code java MatchValue}
 * <p/>
 * Dependencies:
 * <p/>
 * {@author Raghu Ugare}
 * <p/>
 * Email: raghu.ugare@gmail.com
 * <p/>
 * Date: 04/11/14  13:04
 */
public class MatchValue<T> {

    private T exactMatch;
    private T prefixMatch;

    public MatchValue () {
        exactMatch = (T)new Object();
        prefixMatch = (T)new Object();
    }

    public static MatchValue getBlankMatchValue() {
        return new MatchValue();
    }

    public T getExactMatch() {
        return exactMatch;
    }

    public void setExactMatch(T exactMatch) {
        this.exactMatch = exactMatch;
    }

    public T getPrefixMatch() {
        return prefixMatch;
    }

    public void setPrefixMatch(T prefixMatch) {
        this.prefixMatch = prefixMatch;
    }
}
