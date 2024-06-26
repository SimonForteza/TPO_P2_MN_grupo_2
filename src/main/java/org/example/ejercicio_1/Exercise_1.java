package org.example.ejercicio_1;

import org.example.ejercicio_1.tda.*;

public class Exercise_1 {

    //1 - complexity: O(N^2)
    public static int getTrace(IQueueOfStacks queue) { //O(N^2)
        queue = invertQueueOfStacks(queue); //O(N)
        int trace = 0; //O(1)
        int count = 1; //O(1)

        while (!queue.isEmpty()){ //O(N)
            IStack stack = queue.getFirst();

            int candidate = 0;
            for (int i = 0; i < count; i++) {
                candidate = stack.getTop(); //O(1)
                stack.remove(); //O(1)
            }
            trace += candidate; //O(1)
            queue.remove(); //O(1)
            count++; //O(1)
        }
        return trace;
    }

    //2 - Complexity: O(N^2)
    public static IQueueOfStacks getTranspose(IQueueOfStacks queue) {
        queue = invertQueueOfStacks(queue); // use invertQueueOfStacks to change que order of the queue

        IQueueOfStacks transpose = new QueueOfStacks(); // queue that will be return

        while (!queue.isEmpty()) {

            IStack first = queue.getFirst(); // first element of the queue
            boolean isTopElement = true; // flag to know if the top element

            IStack aux = new Stack();
            while (!first.isEmpty() && isTopElement) {
                int top = first.getTop(); // top element of the stack
                aux.add(top);
                first.remove();
                isTopElement = false;
            }
            aux = invertStack(aux);
            transpose.add(aux);

            if (!first.isEmpty()) {
                queue.add(first);
            }

            queue.remove();
        }
        return transpose;
    }

    //3 - Complexity: O(N^2)
    public static IQueueOfStacks matrixSum(IQueueOfStacks queue1, IQueueOfStacks queue2) {

        IQueueOfStacks sum = new QueueOfStacks(); // this queue is the return of the matrix sum

        while (!queue1.isEmpty()) {
            IStack first1 = queue1.getFirst();
            IStack first2 = queue2.getFirst();

            IStack aux = new Stack();
            while (!first1.isEmpty()) {
                int sumTops = first1.getTop() + first2.getTop(); // sum the two tops
                aux.add(sumTops);
                first1.remove();
                first2.remove();
            }

            aux = invertStack(aux);
            sum.add(aux);

            queue1.remove();
            queue2.remove();
        }
        return sum;
    }


    //Auxiliary function
    private static IQueueOfStacks invertQueueOfStacks(IQueueOfStacks queue) { //O(N)
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

    private static IStack invertStack(IStack stack) { //O(N)
        IStack inverted = new Stack(); //O(1)
        while (!stack.isEmpty()) { //O(N)
            int top = stack.getTop(); //O(1)
            inverted.add(top); //O(1)
            stack.remove(); //O(1)
        }
        return inverted;
    }

    public static void printQueueOfStack(IQueueOfStacks queue) { //O(N^2)
        while (!queue.isEmpty()) { //O(N)
            IStack first = queue.getFirst(); //O(1)
            while (!first.isEmpty()) { //O(N)
                System.out.println(first.getTop()); //O(1)
                first.remove(); //O(1)
            }
            queue.remove(); //O(1)
        }
    }
}
