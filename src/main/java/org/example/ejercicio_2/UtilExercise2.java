package org.example.ejercicio_2;

import org.example.ejercicio_2.genericTDA.ISet;
import org.example.ejercicio_2.genericTDA.IStack;
import org.example.ejercicio_2.genericTDA.Set;
import org.example.ejercicio_2.genericTDA.Stack;

public class UtilExercise2 {

    //1
    public static <T> IStack<T> reverseStack(IStack<T> stack) {
        IStack<T> reverseStack = new Stack<>();
        IStack<T> aux = copyStack(stack);

        while (!stack.isEmpty()) {
            reverseStack.add(stack.getTop());
            aux.add(stack.getTop());
            stack.remove();
        }

        while (!aux.isEmpty()) {
            stack.add(aux.getTop());
            aux.remove();
        }
        return reverseStack;
    }

    private static <T> IStack<T> copyStack(IStack<T> stack) {
        IStack<T> copy = new Stack<>();
        IStack<T> copy2 = new Stack<>();


        while (!stack.isEmpty()) {
            copy.add(stack.getTop());
            copy2.add(stack.getTop());
            stack.remove();
        }

        while (!copy.isEmpty()) {
            stack.add(copy.getTop());
            copy.remove();
        }

        while (!copy2.isEmpty()) {
            copy.add(copy2.getTop());
            copy2.remove();
        }

        return copy;
    }

    //2
    public static <T> ISet<T> copySet(ISet<T> set) {
        ISet<T> copy = new Set<>();
        ISet<T> aux = new Set<>();
        while (!set.isEmpty()) {
            T element = set.choose();
            copy.add(element);
            aux.add(element);
            set.remove(element);
        }

        while (!aux.isEmpty()) {
            T element = aux.choose();
            set.add(element);
            aux.remove(element);
        }
        return copy;
    }
}
