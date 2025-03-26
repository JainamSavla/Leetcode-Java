//Runtime 16 ms Beats 49.76% Time Complexity:O(n)
//Memory 52.54 MB Beats 40.77% Space COmplexity:O(n)
class Bucket {
    private List<Integer> container;

    public Bucket() {
        this.container = new LinkedList<>();
    }

    public void insert(Integer val) {
        if (!this.container.contains(val)) {
            this.container.add(val);
        }
    }

    public void delete(Integer val) {
        this.container.remove(val);
    }

    public boolean exists(Integer val) {
        return this.container.contains(val);
    }
}

class MyHashSet {
    private final int KEY_SPACE = 769; 
    private Bucket[] table;

    public MyHashSet() {
        this.table = new Bucket[KEY_SPACE];
        for (int i = 0; i < KEY_SPACE; i++) {
            table[i] = new Bucket();
        }
    }

    private int hash(int key) {
        return key % KEY_SPACE;
    }

    public void add(int key) {
        int index = hash(key);
        table[index].insert(key);
    }

    public void remove(int key) {
        int index = hash(key);
        table[index].delete(key);
    }

    public boolean contains(int key) {
        int index = hash(key);
        return table[index].exists(key);
    }
}
