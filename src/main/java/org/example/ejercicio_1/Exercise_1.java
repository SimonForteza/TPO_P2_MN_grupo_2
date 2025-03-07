package org.example.ejercicio_1;

import org.example.ejercicio_1.tda.*;
import org.example.tda.IStack;
import org.example.tda.Stack;

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

    /**
     * Precondition: QueueOfStacks is NxN
    */
    //2 - Complexity: O(N^2)
    public static IQueueOfStacks getTranspose(IQueueOfStacks queue) {
        queue = invertQueueOfStacks(queue); // use invertQueueOfStacks to change que order of the queue - O(N)

        int sizeQueue = sizeQueueOfStacks(queue); //O(N)

        IQueueOfStacks transpose = new QueueOfStacks(); // queue that will be return

        for (int i = 0; i < sizeQueue; i++) { // iterate the size of the queue
            IStack transposeStack = new Stack();

            for (int j = 0; j < sizeQueue; j++) { // iterate each stack (size of stack == size of queue).
                IStack first = queue.getFirst(); //get the first element of the queue
                transposeStack.add(first.getTop()); //add the first element of each stack
                first.remove();
                queue.add(first); // add the rest of element to the queue
                queue.remove();
            }
            transposeStack = invertStack(transposeStack);
            transpose.add(transposeStack);
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

    private static int sizeQueueOfStacks(IQueueOfStacks queue) { //O(N)
        IQueueOfStacks aux = new QueueOfStacks(); //O(1)
        int size = 0; //O(1)
        while (!queue.isEmpty()) {
            size++; //O(1)
            aux.add(queue.getFirst()); //O(1)
            queue.remove(); //O(1)
        }

        while (!aux.isEmpty()) {
            queue.add(aux.getFirst()); //O(1)
            aux.remove(); //O(1)
        }
        return size; //O(1)
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
