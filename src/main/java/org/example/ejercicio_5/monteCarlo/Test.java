package org.example.ejercicio_5.monteCarlo;

import org.example.ejercicio_5.Exercise_5;
import org.example.tda.IStack;
import org.example.tda.Stack;

public class Test {
    public static void main(String[] args) {
        IStack stack = new Stack();
        stack.add(1);
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(2);
        stack.add(4);

        IStack result = Exercise_5.sortedUniqueStack(stack);

        while (!result.isEmpty()) {
            System.out.println(result.getTop());
            result.remove();
        }
    }
}
