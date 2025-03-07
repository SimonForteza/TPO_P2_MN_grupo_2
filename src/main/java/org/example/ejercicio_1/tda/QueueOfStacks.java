package org.example.ejercicio_1.tda;

import org.example.tda.IStack;
import org.example.tda.Stack;

public class QueueOfStacks implements IQueueOfStacks{

    private final int MAX_VAlUE = 10000;
    private IStack[] array;
    int count;

    public QueueOfStacks() {
        array = new Stack[MAX_VAlUE];
        count = 0;
    }

    @Override
    public void add(IStack stack) {
        if (count == MAX_VAlUE) {
            throw new RuntimeException("The Queue is full");
        }
        array[count] = stack;
        count++;

    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("The Queue is empty");
        }
        for(int i = 0; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;

    }

    @Override
    public IStack getFirst() {
        return array[0];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}
