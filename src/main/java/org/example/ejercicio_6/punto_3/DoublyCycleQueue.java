package org.example.ejercicio_6.punto_3;

import org.example.tda.IQueue;

public class DoublyCycleQueue implements IQueue {

    private DoublyNode first;
    private DoublyNode last;
    private int size;
    public DoublyCycleQueue() {
        size = 0;
    }

    @Override
    public void add(int a) {
        if (isEmpty()) {
            first = new DoublyNode(a, null, last);
            last = first;
            size++;
            return;
        }

        DoublyNode newNode = new DoublyNode(a, last, first);
        last.setNext(newNode);
        last = newNode;
        first.setPrevious(last);
        size++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("La cola está vacía");
        }

        first = first.getNext();
        first.setPrevious(last);
        last.setNext(first);
        size--;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getFirst() {
        return first.getValue();
    }
}
