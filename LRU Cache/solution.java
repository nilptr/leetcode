public class LRUCache {
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<Integer, Integer>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            return value;
        }
        return -1;
    }

    public void set(int key, int value) {
        cache.put(key, value);
        cache.remove(key);
        cache.put(key, value);
    }
}
