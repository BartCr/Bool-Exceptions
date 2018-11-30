package atomicity;

import java.util.Arrays;

public class Stack<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private int size = 0;
    private E[] elements;


    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }

    public E pop() {
        E e = elements[--size];
        elements[size] = null;
        return e;
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}
