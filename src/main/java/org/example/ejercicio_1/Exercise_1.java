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
        private static IQueueOfStacks invertQueueOfStacks (IQueueOfStacks queue){
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

        private static IStack invertStack (IStack stack){
            IStack inverted = new Stack();
            while (!stack.isEmpty()) {
                int top = stack.getTop();
                inverted.add(top);
                stack.remove();
            }
            return inverted;
        }

        public static void printQueueOfStack(IQueueOfStacks queue) {
            while (!queue.isEmpty()) {
                IStack first = queue.getFirst();
                while (!first.isEmpty()) {
                    System.out.println(first.getTop());
                    first.remove();
                }
                queue.remove();
            }



        }


}
