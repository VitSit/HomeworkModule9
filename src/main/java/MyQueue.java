import java.util.Arrays;

public class MyQueue<T> {
    private T[] queueArray;
    private int frontIndex;
    private int rearIndex;
    private int size;

    public MyQueue(int capacity) {
        queueArray = (T[]) new Object[capacity];
        frontIndex = 0;
        rearIndex = -1;
        size = 0;
    }

    public MyQueue() {
        this(10);
    }

    public void add(T value) {
        if (size == queueArray.length) {
            T[] newQueueArray = (T[]) new Object[queueArray.length * 2];
            System.arraycopy(queueArray, frontIndex, newQueueArray, 0, size);
            queueArray = newQueueArray;
            frontIndex = 0;
            rearIndex = size - 1;
        }
        rearIndex = (rearIndex + 1) % queueArray.length;
        queueArray[rearIndex] = value;
        size++;
    }

    public void clear() {
        Arrays.fill(queueArray, null); //може це трохи оптимізує clear, було "queueArray = (T[]) new Object[queueArray.length];"
        frontIndex = 0;
        rearIndex = -1;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (size == 0) {
            return null;
        }
        return queueArray[frontIndex];
    }
    // метод poll добре оптимізований, не розумію як можна ще його змінювати, в завданні цього немає
    public T poll() {
        if (size == 0) {
            return null;
        }
        T value = queueArray[frontIndex];
        queueArray[frontIndex] = null;
        frontIndex = (frontIndex + 1) % queueArray.length;
        size--;
        return value;
    }
}