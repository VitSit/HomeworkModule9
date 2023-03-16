import java.util.Arrays;

public class MyHashMap {

    private Node[] buckets;
    private int size;

    // ініціалізація
    public MyHashMap() {
        this.buckets = new Node[16];
        this.size = 0;
    }
    private int hash(Object key) {
        return Math.abs(key.hashCode() % buckets.length);
    }
    // додає пару ключ + значення
    public void put(Object key, Object value) {
        int index = hash(key);
        Node head = buckets[index];
        Node node = head;
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = head;
        buckets[index] = newNode;
        size++;
    }
    // повертає значення (Object value) за ключем
    public Object get(Object key) {
        int index = hash(key);
        Node node = buckets[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    // видаляє пару за ключем
    public void remove(Object key) {
        int index = hash(key);
        Node head = buckets[index];
        if (head == null) {
            return;
        }
        if (head.key.equals(key)) {
            buckets[index] = head.next;
            size--;
            return;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.key.equals(key)) {
                prev.next = curr.next;
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
    // очищає колекцію
    public void clear() {
        Arrays.fill(buckets, null);
        size = 0;
    }
    // повертає розмір колекції
    public int size() {
        return size;
    }

    private static class Node {
        private Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}