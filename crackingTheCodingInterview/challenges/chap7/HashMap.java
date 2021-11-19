package chap7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class HashMap<K, V> implements Map61BL<K, V> {

    /* TODO: Instance variables here */
    private int size;
    private LinkedList<Entry>[] nameArray;
    private static double MAXLOAD;

    public HashMap() {
        // TODO: YOUR CODE HERE
        nameArray = (LinkedList<Entry>[]) new LinkedList[16];
        size = 0;
        MAXLOAD = 0.75;
    }
    public HashMap(int initialCapacity) {
        nameArray = (LinkedList<Entry>[]) new LinkedList[initialCapacity];
        size = 0;
        MAXLOAD = 0.75;
    }
    public HashMap(int initialCapacity, double loadFactor) {
        nameArray = (LinkedList<Entry>[]) new LinkedList[initialCapacity];
        size = 0;
        MAXLOAD = loadFactor;
    }

    public int capacity() {
        return nameArray.length;
    }

    /* Returns the number of items contained in this map. */
    public int size() {
        // TODO: YOUR CODE HERE
        return this.size;
    }

    /* Returns true if the map contains the KEY. */
    public boolean containsKey(K key) {
        // TODO: YOUR CODE HERE
        int hashV = hash(key);
        LinkedList<Entry> pointer = nameArray[hashV];
        if (pointer == null) {
            return false;
        }
        for (int index = 0; index < pointer.size(); index++) {
            Entry currEntry = pointer.get(index);
            if (currEntry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    /* Returns the value for the specified KEY. If KEY is not found, return
       null. */
    public V get(K key) {
        // TODO: YOUR CODE HERE
        int hashV = hash(key);
        V name = null;
        if (!containsKey(key)) {
            return null;
        }
        LinkedList<Entry> pointer = nameArray[hashV];
        for (int index = 0; index < pointer.size(); index++) {
            Entry currEntry = pointer.get(index);
            if (currEntry.key.equals(key)) {
                name = currEntry.value;
                break;
            }
        }
        return name;
    }

    /* Puts a (KEY, VALUE) pair into this map. If the KEY already exists in the
       SimpleNameMap, replace the current corresponding value with VALUE. */
    public void put(K key, V value) {
        // TODO: YOUR CODE HERE
        Entry newEntry = new Entry(key, value);
        int hashV = hash(key);
        LinkedList<Entry> pointer = nameArray[hashV];
        if (containsKey(key)) {
            for (int index = 0; index < pointer.size(); index++) {
                if (pointer.get(index).key.equals(key)) {
                    pointer.get(index).value = value;
                    break;
                }
            }
            return;
        }
        if ( (double) (size() + 1) / nameArray.length > MAXLOAD) {
            resize();
        }

        hashV = hash(key);
        pointer = nameArray[hashV];

        if (pointer == null) {
            nameArray[hashV] = new LinkedList<>();
            pointer = nameArray[hashV];
            nameArray[hashV].add(newEntry);
            size++;
            return;
        }
        nameArray[hashV].add(newEntry);
        size++;
    }

    /* Removes a single entry, KEY, from this table and return the VALUE if
       successful or NULL otherwise. */
    public V remove(K key) {
        // TODO: YOUR CODE HERE
        int hashV = hash(key);
        if (!containsKey(key)) {
            return null;
        }
        V val = null;
        LinkedList<Entry> pointer = nameArray[hashV];
        int ind = 0;
        for (int index = 0; index < pointer.size(); index++) {
            Entry currEntry = pointer.get(index);
            if (currEntry.key.equals(key)) {
                ind = index;
                val = currEntry.value;
                break;
            }
        }
        pointer.remove(ind);
        size--;
        return val;

    }

    public boolean remove(K key, V value) {
        if (!containsKey(key)) {
            return false;
        }
        if (!get(key).equals(value)) {
            return false;
        }
        else{
            remove(key);
        }
        return true;
    }


    public int hash(K key) {
        return Math.floorMod(key.hashCode(),  nameArray.length);
    }

    public void resize(){
        ArrayList<Entry> entriesList = new ArrayList<Entry>();
        for (int index = 0; index < nameArray.length; index++) {
            LinkedList<Entry> pointer = nameArray[index];
            if (pointer == null) {
                continue;
            }
            for (int j = 0; j < pointer.size(); j++) {
                entriesList.add(pointer.get(j));
            }
        }
        size = 0;
        LinkedList<Entry>[] resizeArray = (LinkedList<Entry>[]) new LinkedList[nameArray.length * 2];
        nameArray = resizeArray;
        for (Entry entry : entriesList){
            K key = entry.key;
            V value = entry.value;
            put(key, value);
        }
    }

    public Iterator<K> iterator(){
        throw new UnsupportedOperationException();
    }


    public void clear() {
        nameArray = (LinkedList<Entry>[]) new LinkedList[nameArray.length];
        size = 0;
    }

    private class Entry {

        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /* Returns true if this key matches with the OTHER's key. */
        public boolean keyEquals(Entry other) {
            return key.equals(other.key);
        }

        /* Returns true if both the KEY and the VALUE match. */
        @Override
        public boolean equals(Object other) {
            return (other instanceof HashMap.Entry
                    && key.equals(((HashMap.Entry) other).key)
                    && value.equals(((HashMap.Entry) other).value));
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

    }
//finally finished chapter 7!!!
}

