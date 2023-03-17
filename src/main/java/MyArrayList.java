public class MyArrayList<T> {
    private T[] data;
    private int size;

    public MyArrayList() {
        data = (T[]) new Object[10];
        size = 0;
    }
    //add додає елемент в кінець
    public void add(T value) {
        if (size == data.length) {
            grow();
        }
        data[size] = value;
        size++;
    }
    //get повертає елемент за індексом
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }
    //remove видаляє елемент із вказаним індексом(оптимізований)
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T value = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return value;
    }
    //clear очищає колекцію
    public void clear() {
        size = 0;
    }
    //size повертає розмір колекції
    public int size() {
        return size;
    }
    //grow подвоює розмір масиву, якщо він повний
    private void grow() {
        T[] newData = (T[]) new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}