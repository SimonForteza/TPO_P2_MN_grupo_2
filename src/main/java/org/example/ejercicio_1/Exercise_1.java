package org.example.ejercicio_1;

import org.example.ejercicio_1.tda.IQueueOfStacks;
import org.example.ejercicio_1.tda.IStack;

public class Exercise_1 {
    public static int getTrace(IQueueOfStacks queue) {
        int trace = 0;
        int count = 1;

        while (!queue.isEmpty()){
            IStack stack = queue.getFirst();

            int candidate = 0;
            for (int i = 0; i < count; i++) {
                candidate = stack.getTop();
                stack.remove();
            }
            trace += candidate;
            queue.remove();
            count++;
        }
        return trace;
    }
}
