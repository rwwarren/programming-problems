import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {

    private static int DEFAULT_ELEMENTS = 10;
    private double load;
    private Entry<K, V>[] elements;

    protected MyHashMap() {
        this(DEFAULT_ELEMENTS);
    }

//    static class Entry<K, V> {
//        K key;
//        V value;
//        Entry<K, V> next;
//
//        public Entry(K key, V value, Entry<K, V> next) {
//            this.key = key;
//            this.value = value;
//            this.next = next;
//        }
//    }

    @SuppressWarnings("unchecked")
    public MyHashMap(int size) {
        elements = new Entry[size];
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean containsValue(Object o) {
        return super.containsValue(o);
    }

    @Override
    public boolean containsKey(Object o) {
        return super.containsKey(o);
    }

    @Override
    public V get(Object o) {
        return super.get(o);
    }

    @Override
    public V put(K k, V v) {
        return super.put(k, v);
    }

    @Override
    public V remove(Object o) {
        return super.remove(o);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        super.putAll(map);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<K>(elements.length);
        for (Entry<K, V> element : elements) {
            keys.add(element.getKey());
        }

        return keys;
    }

    @Override
    public Collection<V> values() {
        return super.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private int hash(){
        return 0;
    }
}
