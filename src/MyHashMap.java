import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class MyHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {

    private static int DEFAULT_ELEMENTS = 10;
    private static double MAX_LOAD = .75;
    //    private double load;
    private HashEntry<K, V>[] elements;
    private int size;

    static class HashEntry<K, V> implements Entry<K, V> {
        K key;
        V value;
        HashEntry<K, V> next;

        public HashEntry(K key, V value) {
            this(key, value, null);
        }

        public HashEntry(K key, V value, HashEntry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public HashEntry<K, V> setNext(HashEntry<K, V> next) {
            this.next = next;
            return next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public HashEntry<K, V> getNext() {
            return next;
        }

        public boolean hasNext() {
            return next != null;
        }

        public V setValue(V value) {
            this.value = value;
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            HashEntry<?, ?> hashEntry = (HashEntry<?, ?>) o;
            return Objects.equals(key, hashEntry.key) &&
                    Objects.equals(value, hashEntry.value) &&
                    Objects.equals(next, hashEntry.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value, next);
        }

        @Override
        public String toString() {
            return "HashEntry{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    protected MyHashMap() {
        this(DEFAULT_ELEMENTS);
    }

    @SuppressWarnings("unchecked")
    public MyHashMap(int size) {
        this.size = 0;
        elements = new HashEntry[size];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsValue(Object o) {
        for (HashEntry<K, V> element : elements) {
            HashEntry<K, V> current = element;
            while (current != null) {
                if (current.getValue().equals(o)) {
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
    }

    @Override
    public boolean containsKey(Object o) {
        return get(o) != null;
    }

    @Override
    public V get(Object o) {
        int hashed = hash(o);
        int location = hashed % elements.length;
        HashEntry<K, V> element = elements[location];
        while (element != null) {
            if (element.getKey().equals(o)) {
                return element.getValue();
            }
            element = element.getNext();
        }
        return null;
    }

    @Override
    public V put(K k, V v) {
        double load = (double) size / (double) elements.length;
        if (load > MAX_LOAD) {
            doubleArray();
        }
        int hashed = hash(k);
        int location = hashed % elements.length;
        HashEntry<K, V> elementList = elements[location];
        if (elementList != null) {
            if (elementList.getKey().equals(k)) {
                elementList.setValue(v);
                return v;
            }
            while (elementList.hasNext()) {
                if (elementList.getKey().equals(k)) {
                    elementList.setValue(v);
                    return v;
                }
                elementList = elementList.getNext();
            }
            elementList = elementList.setNext(new HashEntry<K, V>(k, v));
            size++;
        } else {
            elements[location] = new HashEntry<K, V>(k, v);
            elementList = elements[location];
            size++;
        }
        return elementList.getValue();
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
        for (HashEntry<K, V> element : elements) {
            while (element != null) {
                keys.add(element.getKey());
                element = element.getNext();
            }
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new ArrayList<V>(elements.length);
        for (HashEntry<K, V> element : elements) {
            while (element != null) {
                values.add(element.getValue());
                element = element.getNext();
            }
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entries = new HashSet<Entry<K, V>>();
        for (HashEntry<K, V> element : elements) {
            while (element != null) {
                entries.add(element);
                element = element.getNext();
            }
        }
        return entries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MyHashMap<?, ?> myHashMap = (MyHashMap<?, ?>) o;
        return size == myHashMap.size &&
                Arrays.equals(elements, myHashMap.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), elements, size);
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private int hash(Object o) {
        return 31 * o.hashCode();
    }

    @SuppressWarnings("unchecked")
    private void doubleArray() {
        HashEntry<K, V>[] replacementElements = new HashEntry[elements.length * 2];
        //rehash
        elements = replacementElements;
    }

}
