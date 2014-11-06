package com.rags.utils;

/**
 * Description:
 * <p/>
 * Compilation: {@code javac IStringMatcher.java}
 * <p/>
 * Execution: {@code java IStringMatcher}
 * <p/>
 * Dependencies:
 * <p/>
 * {@author Raghu Ugare}
 * <p/>
 * Email: raghu.ugare@gmail.com
 * <p/>
 * Date: 04/11/14  11:52
 */
public interface IStringMatcher {

    /**
     * Adds a key for 'exact-match' lookup...
     * @param key key key to be added for exact-match
     * @param value value corresponding value
     */
    void add_exact_match(String key, Integer value);

    /**
     * Adds a key for 'prefix_match' look-up...
     * @param key key key to be added for prefix-match
     * @param value value corresponding value
     */
    void add_prefix_match(String key, Integer value);

    /**
     * A common look-up function. Returns the value with priority being given to exact match over that of prefix match.
     * Returns {@code -1} if key is not found.
     * @param key the key to be looked-up.
     * @return the value with priority being given to exact match over that of prefix match. Returns {@code -1} if key
     * is not found.
     */
    Integer lookup(String key);

    /**
     * Deletes the value assigned for exact match of the given key parameter.
     * @param key the key whose 'exact-match' value has to be removed.
     * @return {@code true} if delete successful, {@code false} otherwise
     */
    boolean delete_exact_match(String key);

    /**
     * Deletes the value assigned for prefix match of the given key parameter.
     * @param key the key whose 'prefix-match' value has to be removed.
     * @return {@code true} if delete successful, {@code false} otherwise
     */
    boolean delete_prefix_match(String key);

}
