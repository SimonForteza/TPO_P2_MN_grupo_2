package org.example;

import org.example.ejercicio_1.Exercise_1;
import org.example.ejercicio_1.tda.IQueueOfStacks;
import org.example.ejercicio_1.tda.QueueOfStacks;
import org.example.tda.IStack;
import org.example.tda.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //main file
        IStack stack1 = new Stack();
        stack1.add(1);
        stack1.add(2);
        stack1.add(9);

        IStack stack2 = new Stack();
        stack2.add(7);
        stack2.add(5);
        stack2.add(10);
        
        IStack stack3 = new Stack();
        stack3.add(8);
        stack3.add(4);
        stack3.add(2);

        IQueueOfStacks queue = new QueueOfStacks();
        queue.add(stack1);
        queue.add(stack2);
        queue.add(stack3);

        //Queue number 2

        IStack stack4 = new Stack();
        stack4.add(3);
        stack4.add(2);
        stack4.add(1);

        IStack stack5 = new Stack();
        stack5.add(5);
        stack5.add(3);
        stack5.add(7);

        IStack stack6 = new Stack();
        stack6.add(9);
        stack6.add(6);
        stack6.add(4);

        IQueueOfStacks queue2 = new QueueOfStacks();
        queue2.add(stack4);
        queue2.add(stack5);
        queue2.add(stack6);

        IQueueOfStacks sum = Exercise_1.matrixSum(queue, queue2);
        Exercise_1.printQueueOfStack(sum);
    }
}