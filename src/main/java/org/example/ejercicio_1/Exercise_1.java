package org.example.ejercicio_1;

import org.example.ejercicio_1.tda.*;

public class Exercise_1 {
    public static int getTrace(IQueueOfStacks queue) {
        queue = invertQueueOfStacks(queue);
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

    private static IQueueOfStacks invertQueueOfStacks(IQueueOfStacks queue) {
        IQueueOfStacks invertedQueue = new QueueOfStacks();
        IStackOfStacks stack = new StackOfStacks();
        while (!queue.isEmpty()) {
            IStack first = queue.getFirst();
            stack.add(first);
            queue.remove();
        }

        while (!stack.isEmpty()) {
            IStack top = stack.getTop();
            invertedQueue.add(top);
            stack.remove();
        }
        return invertedQueue;
    }

    /*
    public static IQueueOfStacks getTranpose(IQueueOfStacks queue) {
        IQueueOfStacks transpose = new QueueOfStacks();

        while (!queue.isEmpty()) {
            IQueueOfStacks aux = new QueueOfStacks();
            IStack stack_transpose = new Stack();

            IStack firstStack = queue.getFirst();
            boolean isTopElement = true;

            while (!firstStack.isEmpty() && isTopElement == true) {
                int top = firstStack.getTop();
                firstStack.remove();
                stack_transpose.add(top); // agrego elemento a la pila de transpues
                isTopElement = false;
            }

            transpose.add(stack_transpose);

            aux.add(firstStack);
            queue.remove();

            while (!aux.isEmpty()) {
                IStack first = aux.getFirst();
                queue.add(first);
                aux.remove();
            }
        }

        return transpose;
    }
     */
}
