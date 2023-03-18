import java.util.Arrays;
import java.util.Queue;
import java.util.StringJoiner;

public class MyQueue <E> {
    private static final int DEFAULT_CAPACITY = 10;
    private  Object [] data;
    private int size;
    public MyQueue(){
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public MyQueue(int size){
        this.data = new Object[size];
        this.size = 0;
    }
    public void add(E value){
        if(size == data.length){
            int newSize = (data.length * 3)/2 + 1;
            Object[] tempData;
            tempData = Arrays.copyOf(data, newSize);
            data = tempData;
        }
        data[size]=value;
        size = size + 1;
    }
    public void clear(){
        for (int i =0; i < size; i++) {
            data[i] = null;
        }
        size = 0;

    }
    public int size(){
        return size;
    }
    private Object get(int index){
        return  data[index];
    }
    public E peek(){
        if (size==0){
            return null;
        } else {
            return (E) get(0);
        }
    }
    private void remove(int index){
        int newSize = size - 1;
        if (newSize > index){
            System.arraycopy(data, index + 1, data, index, newSize - index);
        } else {
            data[index] = null;
        }
        data[newSize] = null;

        size = newSize;
    }
    public E poll(){
        if (size==0){
            return null;
        } else {
            Object firstElement = data[0];
            data[0] = null;
            remove(0);
            size--;
            return (E) firstElement ;
        }

    }
    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(",");

        for (Object element:data) {
            if(element!=null) {
                result.add(element.toString());
            }
        }
        return "{"+result+"}";
    }
}