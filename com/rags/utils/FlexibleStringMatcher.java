package com.rags.utils;

import com.rags.ds.ISymbolTable;
import com.rags.ds.RwayTrie;

/**
 * Description:
 * <p/> Uses an R-way Trie data-structure to map strings to values, for fast (linear) lookup.
 * Compilation: {@code javac FlexibleStringMatcher.java}
 * <p/>
 * Execution: {@code java FlexibleStringMatcher}
 * <p/>
 * Dependencies:
 * <p/>
 * {@author Raghu Ugare}
 * <p/>
 * Email: raghu.ugare@gmail.com
 * <p/>
 * Date: 04/11/14  12:13
 */
public class FlexibleStringMatcher implements IStringMatcher {

    private ISymbolTable<Integer> lookupTable;

    private FlexibleStringMatcher() {
        this.lookupTable = new RwayTrie<Integer>();
    }

    private FlexibleStringMatcher(ISymbolTable symbolTable) {
        this.lookupTable = symbolTable;
    }

    /**
     * Sort of like a factory method for getting a 'default' instance of StringMatcher...
     * We can add more such methods or a generic factory method which allows for switching the underlying implementations?
     *
     * @return default instance of this StringMatcher
     */
    public static FlexibleStringMatcher getDefaultStringMatcher() {
        return new FlexibleStringMatcher();
    }

    /**
     * Adds a key for 'exact-match' lookup...
     * @param key key key to be added for exact-match
     * @param value value corresponding value
     */
    @Override
    public void add_exact_match(String key, Integer value) {
        lookupTable.put(key, value);
    }

    /**
     * Adds a key for 'prefix_match' look-up...
     * @param key key key to be added for prefix-match
     * @param value value corresponding value
     */
    @Override
    public void add_prefix_match(String key, Integer value) {
        // TODO !!
        lookupTable.put(key, value);
    }

    /**
     * A common look-up function. Returns the value with priority being given to exact match over that of prefix match.
     * Returns {@code -1} if key is not found.
     *
     * @param key the key to be looked-up.
     * @return the value with priority being given to exact match over that of prefix match. Returns {@code -1} if key
     * is not found.
     */
    @Override
    public Integer lookup(String key) {
        Integer value = lookupTable.get(key);
        if (value != null) {
            return value;
        }
        // else...we need to do some checking...!
        // Try matching for a prefix...
        int len = key.length();
        while (len > 0) {
            len--;
            value = lookupTable.get(key.substring(0, len));
            if (value != null) {
                return value; // found a prefix match !!
            }
        }
        return -1;
    }

    /**
     * Deletes the value assigned for exact match of the given key parameter.
     *
     * @param key the key whose 'exact-match' value has to be removed.
     * @return {@code true} if delete successful, {@code false} otherwise
     */
    @Override
    public boolean delete_exact_match(String key) {
        if (!lookupTable.contains(key))
            return false;
        else {
            lookupTable.delete(key);
            return false;
        }
    }

    /**
     * Deletes the value assigned for prefix match of the given key parameter.
     *
     * @param key the key whose 'prefix-match' value has to be removed.
     * @return {@code true} if delete successful, {@code false} otherwise
     */
    @Override
    public boolean delete_prefix_match(String key) {
        // TODO !!
        if (!lookupTable.contains(key))
            return false;
        else {
            lookupTable.delete(key);
            return false;
        }
    }

    /**
     * Driver method for our String matcher...!
     * Also, serves as a sample guide on how to use our API...
     */
    public static void main(String[] args) {

        IStringMatcher myStringMatcher = FlexibleStringMatcher.getDefaultStringMatcher();

        // test add  & look-up for exact match of empty string...
        System.out.println("myStringMatcher.lookup(\"\") = " + myStringMatcher.lookup(""));

        // test add  & look-up for exact match...
        myStringMatcher.add_exact_match("abc", 908);
        System.out.println("myStringMatcher.lookup(\"abc\") = " + myStringMatcher.lookup("abc"));

        // test delete and look-up for exact match...
        myStringMatcher.delete_prefix_match("abc");
        System.out.println("myStringMatcher.lookup(\"abc\") = " + myStringMatcher.lookup("abc"));

        // test add  & look-up for prefix match...
        myStringMatcher.add_prefix_match("fas", 907);
        System.out.println("myStringMatcher.lookup(\"fast\") = " + myStringMatcher.lookup("fast"));

        // test delete and look-up for prefix match...
        myStringMatcher.delete_prefix_match("fas");
        System.out.println("myStringMatcher.lookup(\"fast\") = " + myStringMatcher.lookup("fast"));

    }

}
