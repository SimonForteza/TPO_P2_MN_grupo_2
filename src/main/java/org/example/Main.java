package org.example;

import org.example.ejercicio_1.Exercise_1;
import org.example.ejercicio_1.tda.IQueueOfStacks;
import org.example.ejercicio_1.tda.IStack;
import org.example.ejercicio_1.tda.QueueOfStacks;
import org.example.ejercicio_1.tda.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //main file
        IStack stack1 = new Stack();
        stack1.add(9);
        stack1.add(8);
        stack1.add(7);

        IStack stack2 = new Stack();
        stack2.add(6);
        stack2.add(5);
        stack2.add(4);
        IStack stack3 = new Stack();
        stack3.add(3);
        stack3.add(2);
        stack3.add(100);

        IQueueOfStacks queue = new QueueOfStacks();
        queue.add(stack1);
        queue.add(stack2);
        queue.add(stack3);

        System.out.println(Exercise_1.getTrace(queue));
        //IQueueOfStacks transpose = Exercise_1.getTranpose(queue);
    }
}