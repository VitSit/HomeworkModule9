import java.util.Arrays;

public class MyHashMap<T> {

    private Node<T>[] buckets;
    private int size;

    public MyHashMap() {
        this.buckets = new Node[16];
        this.size = 0;
    }

    private int hash(T key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public void put(T key, T value) {
        int index = hash(key);
        Node<T> head = buckets[index];
        Node<T> node = head;
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        Node<T> newNode = new Node<>(key, value);
        newNode.next = head;
        buckets[index] = newNode;
        size++;
    }

    public T get(T key) {
        int index = hash(key);
        Node<T> node = buckets[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public void remove(T key) {
        int index = hash(key);
        Node<T> head = buckets[index];
        if (head == null) {
            return;
        }
        if (head.key.equals(key)) {
            buckets[index] = head.next;
            size--;
            return;
        }
        Node<T> prev = head;
        Node<T> curr = head.next;
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

    public void clear() {
        Arrays.fill(buckets, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private T key;
        private T value;
        private Node<T> next;

        public Node(T key, T value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}