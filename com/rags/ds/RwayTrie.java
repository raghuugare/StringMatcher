package com.rags.ds;

/**
 * Description:
 * <p/> An R-way Trie Symbol Table (ST) implementation...
 * Consists of {@link com.rags.ds.RwayTrie.Node} objects, each of which can have up to {@code R} child {@code Node} objects...
 * Compilation: {@code javac RwayTrie.java}
 * <p/>
 * Execution: {@code java RwayTrieST}
 * <p/>
 * Dependencies:
 * <p/>
 * {@author Raghu Ugare}
 * <p/>
 * Email: raghu.ugare@gmail.com
 * <p/>
 * Date: 04/11/14  11:59
 */
public class RwayTrie<Value> implements ISymbolTable<Value> {

    /*
    * 'R' denotes the 'radix' or the total number of different characters allowed...
    * Supports any of the characters in the range '0' to '255' (ASCII)
    */
    private static final int R = 256;

    private static class Node {
        Object value;
        Node next[] = new Node[R];
    }

    /* The 'root' node of our Trie structure... */
    private Node root = new Node();

    public boolean contains(String key) {
        return get(key) != null;
    }

    public void put(String key, Value value) {
        if(contains(key)) {
            ; // No need to add...
        }
        // else we need to add...
        root = put(root, key, value, 0);
    }

    public Node put(Node x, String key, Value value, int depth) {
        /* first time? create a new, empty node...we'll populate it below suitably... */
        if (x == null) {
            x = new Node();
        }
        /* Reached the end of the key? Now, "put" the value here... */
        if (depth == key.length()) {
            x.value = value;
            return x;
        }
        /* Now, take the link given by next['current-char']...and ...recur */
        char c = key.charAt(depth);
        x.next[c] = put(x.next[c], key, value, depth + 1);

        return x;
    }


    public Value get(String key) {
        Node x = get(root, key, 0);
        return (x == null ? null : (Value) x.value);
    }

    public Node get(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        /* If at all found, the value will be found at this point... */
        if (d == key.length()) {
            return x;
        }

        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {

        if (x == null) {
            return null;
        }

        /* Reached the end of the Key ?? Clear the value at the 'end' of the key'
        * It may or may not exist...
        */
        if (d == key.length()) {
           x.value = null;
        }
        else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }

        // remove the sub-tree rooted at node 'x' if it has no children links...
        /* If x has some 'value', stop, & return... */
        if (x.value != null) {
            return x;
        }
        // else...
        // Check ALL of x's child links in x.next[ ] to ensure each is null/empty...
        for (int i = 0; i < R; i++)
            if (x.next[i] != null)
                return x;
        return null; // i.e., if ALL of the next[ ] links are null, then, we can remove this current Node itself!
    }


    /*
    * =======================================
    * Driver method to test some of our API... :)
    * ========================================
    * */
    public static void main(String[] args) {
        RwayTrie<Integer> rt = new RwayTrie<Integer>();

        rt.put("raghu", 1);
        rt.put("xyz", 2);
        rt.put("vijay", 3);

        System.out.println("raghu = " + rt.get("raghu"));
        System.out.println("xyz = " + rt.get("xyz"));
        System.out.println("vijay = " + rt.get("vijay"));

        rt.delete("xyz");

        System.out.println("xyz = " + rt.get("xyz"));

    }
}
