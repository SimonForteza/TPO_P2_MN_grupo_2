package org.example.ejercicio_2;

import org.example.ejercicio_2.genericTDA.ISetGeneric;
import org.example.ejercicio_2.genericTDA.IStackGeneric;
import org.example.ejercicio_2.genericTDA.SetGeneric;
import org.example.ejercicio_2.genericTDA.StackGeneric;

public class UtilExercise2 {

    //1
    public static <T> IStackGeneric<T> reverseStack(IStackGeneric<T> stack) {
        IStackGeneric<T> reverseStack = new StackGeneric<>();
        IStackGeneric<T> aux = copyStack(stack);

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

    private static <T> IStackGeneric<T> copyStack(IStackGeneric<T> stack) {
        IStackGeneric<T> copy = new StackGeneric<>();
        IStackGeneric<T> copy2 = new StackGeneric<>();


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
    public static <T> ISetGeneric<T> copySet(ISetGeneric<T> set) {
        ISetGeneric<T> copy = new SetGeneric<>();
        ISetGeneric<T> aux = new SetGeneric<>();
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
