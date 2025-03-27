//14 ms Beats 99.70% ;TIME COMPLEXITY:O(1)ForPut,Get,AndRemove
//Memory 48.32 MB Beats 73.20% ;sPACE cOMPLEXITY:O(N)WhereNIsTheNumberOfUniqueKeysStored

class MyHashMap {
    private class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private final int SIZE = 1000;
    private Node[] map;

    public MyHashMap() {
        map = new Node[SIZE];
    }
    
    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (map[index] == null) {
            map[index] = new Node(key, value);
        } else {
            Node curr = map[index];
            while (curr != null) {
                if (curr.key == key) {
                    curr.value = value; // Update existing key
                    return;
                }
                if (curr.next == null) break;
                curr = curr.next;
            }
            curr.next = new Node(key, value);
        }
    }
    
    public int get(int key) {
        int index = hash(key);
        Node curr = map[index];
        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }
        return -1; // Key not found
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node curr = map[index];
        Node prev = null;
        
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    map[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}

/**
 * Usage:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key, value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
