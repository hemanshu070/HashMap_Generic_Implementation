
public class Entry<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<Entry<K, V>> {
    K key;
    V value;
    Entry<K, V> left;
    Entry<K, V> right;

    public Entry(K key, V value, Entry<K, V> left, Entry<K, V> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Entry(Entry<K, V> entry) {
        this.key = entry.getKey();
        this.value = entry.getValue();
        this.left = entry.getLeft();
        this.right = entry.getRight();
    }

    public K getKey() {
        return this.key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Entry<K, V> getLeft() {
        return this.left;
    }

    public void setLeft(Entry<K, V> left) {
        this.left = left;
    }

    public Entry<K, V> getRight() {
        return this.right;
    }

    public void setRight(Entry<K, V> right) {
        this.right = right;
    }

    public int compareTo(Entry<K, V> o) {
        return this.getKey().compareTo(o.getKey());
    }
}
