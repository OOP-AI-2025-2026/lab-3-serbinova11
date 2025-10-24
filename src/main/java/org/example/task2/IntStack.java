package org.example.task2;

public class IntStack {

    private int[] elements;
    private int count;
    private static final int INITIAL_CAPACITY = 5;

    public IntStack() {
        this.elements = new int[INITIAL_CAPACITY];
        this.count = 0;
    }

    public void push(int value) {
        if (count == elements.length) {
            expandArray();
        }
        elements[count++] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек порожній. Неможливо виконати pop.");
        }
        return elements[--count];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек порожній. Неможливо виконати peek.");
        }
        return elements[count - 1];
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void clear() {
        count = 0;
    }

    private void expandArray() {
        int[] newArray = new int[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }
}
