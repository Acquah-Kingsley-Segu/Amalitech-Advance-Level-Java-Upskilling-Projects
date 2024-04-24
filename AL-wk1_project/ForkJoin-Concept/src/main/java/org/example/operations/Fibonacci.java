package org.example.operations;

import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Integer> {
    private final int number;

    public Fibonacci(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    protected Integer compute() {
        if (this.number > 1){
            Fibonacci subTask1 = new Fibonacci(this.number - 1);
            Fibonacci subTask2 = new Fibonacci(this.number - 2);

            subTask1.fork();
            subTask2.fork();

            return subTask1.join() + subTask2.join();
        }
        return this.number;
    }
}
