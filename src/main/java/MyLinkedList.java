public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    //add додає елемент в кінець
    public void add(Object value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }

        tail = newNode;
        size++;
    }
    //remove видаляє елемент із вказаним індексом
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        if (current.prev == null) {
            head = current.next;
        } else {
            current.prev.next = current.next;
        }

        if (current.next == null) {
            tail = current.prev;
        } else {
            current.next.prev = current.prev;
        }

        size--;
    }
    //clear очищає колекцію
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    //size повертає розмір колекції
    public int size() {
        return size;
    }
    //get повертає елемент за індексом
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    private class Node {
        private Object value;
        private Node prev;
        private Node next;

        public Node(Object value) {
            this.value = value;
        }
    }
}