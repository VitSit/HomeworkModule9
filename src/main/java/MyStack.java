import java.util.NoSuchElementException;

public class MyStack<T> {
    private T[] stack;
    private int top;

    // ініціалізуємо масив і значення індексу верхнього елементу стеку
    public MyStack() {
        stack = (T[]) new Object[10];
        top = -1;
    }

    // перевіряємо заповненність масиву, створюємо новий, копіюємо елементи, додаємо новий елемент в стек
    public void push(T value) {
        if (top == stack.length - 1) {
            T[] newStack = (T[]) new Object[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[++top] = value;
    }

    // видаляє елемент за індексом, перед цим перевіряємо, чи індекс належить межам стеку і зсуваємо на одну позицію вліво
    public T remove(int index) {
        if (index < 0 || index > top) {
            throw new IndexOutOfBoundsException();
        }
        T removedValue = stack[index];
        for (int i = index; i < top; i++) {
            stack[i] = stack[i + 1];
        }
        stack[top--] = null;
        return removedValue;
    }

    // очищає колекцію
    public void clear() {
        for (int i = 0; i <= top; i++) {
            stack[i] = null;
        }
        top = -1;
    }

    // повертаємо розмір стеку
    public int size() {
        return top + 1;
    }

    // перевірка, чи стек не порожній, потім повертає перший елемент стеку не видаляючи його
    public T peek() {
        if (top < 0) {
            throw new NoSuchElementException();
        }
        return stack[top];
    }

    // повертає перший елемент стеку та видаляє його з колекції
    public T pop() {
        T value = peek();
        stack[top--] = null;
        return value;
    }
}