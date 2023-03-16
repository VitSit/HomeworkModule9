public class MyQueue {
    private Object[] queueArray;
    private int frontIndex;
    private int rearIndex;
    private int size;

    public MyQueue(int capacity) {
        queueArray = new Object[capacity];
        frontIndex = 0;
        rearIndex = -1;
        size = 0;
    }
    //add додає елемент в кінець
    public void add(Object value) {
        if (size == queueArray.length) {
            throw new IllegalStateException("Queue is full");
        }
        rearIndex = (rearIndex + 1) % queueArray.length;
        queueArray[rearIndex] = value;
        size++;
    }
    //clear очищає колекцію
    public void clear() {
        queueArray = new Object[queueArray.length];
        frontIndex = 0;
        rearIndex = -1;
        size = 0;
    }
    //size повертає розмір колекції
    public int size() {
        return size;
    }
    //peek повертає перший елемент з черги, якщо черга порожня - null
    public Object peek() {
        if (size == 0) {
            return null;
        }
        return queueArray[frontIndex];
    }
    //poll повертає перший елемент в черзі і видаляє його
    public Object poll() {
        if (size == 0) {
            return null;
        }
        Object value = queueArray[frontIndex];
        queueArray[frontIndex] = null;
        frontIndex = (frontIndex + 1) % queueArray.length;
        size--;
        return value;
    }
}