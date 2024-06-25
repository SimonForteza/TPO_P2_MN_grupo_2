package org.example.ejercicio_5;


import org.example.ejercicio_5.auxiliarTDA.ISet;
import org.example.ejercicio_5.auxiliarTDA.IStack;
import org.example.ejercicio_5.auxiliarTDA.Set;
import org.example.ejercicio_5.auxiliarTDA.Stack;

public class Exercise_5 {
    //1
    public static IStack sortedUniqueStack(IStack stack) { //O(N^2) + O(N^2) + O(N^2) = O(N^2)
        IStack result = new Stack();

        //delete repeated elements
        ISet set = new Set();
        while (!stack.isEmpty()) { //O(N)
            set.add(stack.getTop()); //O(N)
            stack.remove(); //O(1)
        }

        while (!set.isEmpty()) { //O(N)
            int element = set.choose(); //O(1)
            stack.add(element); //O(1)
            set.remove(element); //O(N)
        }

        //sort stack
        while (!stack.isEmpty()) { //O(N)
            int candidate = stack.getTop();
            stack.remove();

            IStack aux = new Stack();
            while (!stack.isEmpty()) { //O(N)
                if (stack.getTop() >= candidate) {
                    aux.add(candidate);
                    candidate = stack.getTop();
                } else {
                    aux.add(stack.getTop());
                }
                stack.remove();
            }
            while (!aux.isEmpty()) {
                stack.add(aux.getTop());
                aux.remove();

            }
            result.add(candidate);
        }
        return result;
    }
}
