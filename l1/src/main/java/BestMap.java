import java.util.ArrayList;

class HashChain<K, V> {
    K key;
    V value;

    HashChain<K, V> next;

    public HashChain(K key, V value) {
        this.key = key;
        this.value = value;
    }

}


public class BestMap<K, V> {
    private ArrayList<HashChain<K, V>> chainArray;
    private int capacity;
    private int size;

    public BestMap() {
        chainArray = new ArrayList<>();
        capacity = 10;
        size = 0;
        for (int i = 0; i < capacity; i++)
            chainArray.add(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % capacity;
        return index;
    }

    public void add(K key, V value) {
        int index = getIndex(key);
        HashChain<K, V> head = chainArray.get(index);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = chainArray.get(index);
        HashChain<K, V> chain = new HashChain<K, V>(key, value);
        chainArray.set(index, chain);

        if ((1.0 * size) / capacity >= 0.7) {
            ArrayList<HashChain<K, V>> temp = chainArray;
            chainArray = new ArrayList<>();
            capacity = 2 * capacity;
            size = 0;
            for (int i = 0; i < capacity; i++)
                chainArray.add(null);
            for (HashChain<K, V> headChain : temp) {
                while (headChain != null) {
                    add(headChain.key, headChain.value);
                    headChain = headChain.next;
                }
            }
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        HashChain<K, V> head = chainArray.get(index);

        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = getIndex(key);

        HashChain<K, V> head = chainArray.get(index);


        HashChain<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key))
                break;
            prev = head;
            head = head.next;
        }
        if (head == null)
            return null;
        size--;
        if (prev != null)
            prev.next = head.next;
        else
            chainArray.set(index, head.next);
        return head.value;
    }

}