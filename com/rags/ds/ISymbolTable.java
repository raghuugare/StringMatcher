package com.rags.ds;

/**
 * Description:
 * <p/>
 * Symbol Table interface for for {@link java.lang.String} based keys & generic values.
 * Compilation: {@code javac ISymbolTable.java}
 * <p/>
 * Execution: {@code java ISymbolTable}
 * <p/>
 * Dependencies:
 * <p/>
 * {@author Raghu Ugare}
 * <p/>
 * Email: raghu.ugare@gmail.com
 * <p/>
 * Date: 04/11/14  12:46
 */
public interface ISymbolTable<Value> {

    /**
     * Checks for existence of the key param in the Symbol table
     * @param key the key whose presence is to be checked
     * @return {@code true} if key is found in the table; {@code false} otherwise.
     */
    boolean contains(String key);

    /**
     *
     * @param key
     * @param value
     */
    void put(String key, Value value);

    /**
     *
     * @param key
     */
    void delete(String key);

    /**
     *
     * @param key
     * @return the value corresponding to the key param
     */
    Value get(String key);
}
