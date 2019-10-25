import javax.sound.sampled.Line;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.print();
        System.out.println(1 == cache.get(1));
        ;       // 返回  1
        cache.print();
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.print();
        System.out.println(cache.get(2) + "" + (-1 == cache.get(2)));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.print();
        System.out.println(-1 == cache.get(1));       // 返回 -1 (未找到)
        System.out.println(3 == cache.get(3));       // 返回  3
        System.out.println(4 == cache.get(4));       // 返回  4
    }

    private void print() {
        System.out.println(this.map);
    }

    private final _LRUCache<Integer, Integer> map;

    class _LRUCache<K, V> extends LinkedHashMap<K, V> {

        private int capacity; // Maximum number of items in the cache.

        public _LRUCache(int capacity) {
            super(capacity + 1, 1.0f, true); // Pass 'true' for accessOrder.
            this.capacity = capacity;
        }

        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return (size() > this.capacity);
        }
    }

    public LRUCache(int capacity) {
        this.map = new _LRUCache<Integer, Integer>(capacity);
    }

    public int get(int key) {
        Integer value = this.map.get(key);
        return value == null ? -1 : value;
    }

    public void put(int key, int value) {
        this.map.put(key, value);
    }
}
