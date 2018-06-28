import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

    public final class Hashmap<K extends Comparable<K>, V extends Comparable<V>> {
        private final Entry<K, V>[] table = new Entry[16];
        private static final int CAPACITY = 16;
        private final List<Entry> sequence = new ArrayList();
        static int cur = 1;

        public Hashmap(Entry... entries) {
            Entry[] var2 = entries;
            int var3 = entries.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                Entry<K, V> entry = var2[var4];
                if (entry != null) {
                    K key = entry.getKey();
                    V value = entry.getValue();
                    int hash = Math.abs(key.hashCode() % 16);
                    Entry<K, V> root = this.table[hash];
                    Entry<K, V> data = new Entry(key, value);
                    System.out.println(cur);
                    ++cur;
                    root = this.insertBinaryTree(root, data);
                    this.table[hash] = root;
                    this.sequence.add(entry);
                    Iterator var11 = this.sequence.iterator();

                    while(var11.hasNext()) {
                        Entry ent = (Entry)var11.next();
                        System.out.println(ent.getKey());
                    }
                }
            }

        }

        private Entry<K, V> insertBinaryTree(Entry<K, V> root, Entry<K, V> data) {
            if (root == null) {
                return data;
            } else {
                if (data.compareTo(root) < 0) {
                    root.setLeft(this.insertBinaryTree(root.getLeft(), data));
                } else if (data.compareTo(root) > 0) {
                    root.setRight(this.insertBinaryTree(root.getRight(), data));
                }

                return root;
            }
        }

        public Hashmap<K, V> put(K key, V value) {
            Entry<K, V>[] tempentries = new Entry[this.sequence.size() + 1];
            int currentindex = 0;
            int var7 = currentindex + 1;
            tempentries[currentindex] = new Entry(key, value);
            Iterator var5 = this.sequence.iterator();

            while(var5.hasNext()) {
                Entry<K, V> mapentry = (Entry)var5.next();
                if (mapentry != null && mapentry.getKey().compareTo(key) != 0) {
                    tempentries[var7++] = new Entry(mapentry);
                    System.out.println("inside for");
                }
            }

            return new Hashmap(tempentries);
        }

        public V get(K key) {
            return this.getThelement(key);
        }

        private V getThelement(K key) {
            int hash = Math.abs(key.hashCode() % 16);
            Entry<K, V> root = this.table[hash];
            Entry<K, V> node = this.treeSearch(root, key);
            return node.getValue();
        }

        public boolean containsKey(K key) {
            int hash = Math.abs(key.hashCode() % 16);
            Entry<K, V> rootNode = this.table[hash];
            if (rootNode == null) {
                return false;
            } else {
                Entry<K, V> isKeyPresent = this.treeSearch(rootNode, key);
                return isKeyPresent != null;
            }
        }

        public Hashmap<K, V> remove(K key) {
            Entry<K, V>[] tempEntries = new Entry[this.sequence.size() - 1];
            int currentIndex = 0;
            Iterator var4 = this.sequence.iterator();

            while(var4.hasNext()) {
                Entry<K, V> mapEntry = (Entry)var4.next();
                if (mapEntry.getKey().compareTo(key) != 0) {
                    tempEntries[currentIndex++] = new Entry(mapEntry);
                }
            }

            return new Hashmap(tempEntries);
        }

        public int size() {
            return this.sequence.size();
        }

        private Entry<K, V> treeSearch(Entry<K, V> root, K key) {
            if (root != null && root.getKey().compareTo(key) != 0) {
                return root.getKey().compareTo(key) < 0 ? this.treeSearch(root.getRight(), key) : this.treeSearch(root.getLeft(), key);
            } else {
                return root;
            }
        }

        public Object customiterator() {
            return new cutomeiterator();
        }

        public class cutomeiterator implements Iterator<Entry<K, V>> {
            int current;

            public cutomeiterator() {
            }

            public void cutomiterator() {
                this.current = 0;
            }

            public boolean hasNext() {
                return this.current < Hashmap.this.sequence.size();
            }

            public Entry<K, V> next() {
                if (this.current >= Hashmap.this.sequence.size()) {
                    throw new NoSuchElementException();
                } else {
                    ++this.current;
                    return new Entry((Entry)Hashmap.this.sequence.get(this.current - 1));
                }
            }
        }
    }
