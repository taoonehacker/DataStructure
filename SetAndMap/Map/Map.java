package Map;

public interface Map<K,V> {
    int getSize();
    boolean isEmpty();
    void add(K key,V value);
    V get(K key);
    void set(K key,V newValue);
    boolean contains(K key);
    V remove(K key);
}
