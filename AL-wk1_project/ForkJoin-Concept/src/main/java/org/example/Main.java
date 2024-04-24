package org.example;

import org.example.operations.Fibonacci;
import org.example.operations.MatrixMultiplication;
import org.example.operations.SumTask;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();

        Fibonacci fibonacci = new Fibonacci(10);
        int result = pool.invoke(fibonacci);

        System.out.printf("The fibonacci number for %d is: %d%n", 10, result);

        long[] nums = new long[]{4, 9, 3, 9, 7, 5};
        SumTask sumTask = new SumTask(nums);
        long sum = pool.invoke(sumTask);

        System.out.printf("The sum of the numbers %s is: %d%n", Arrays.toString(nums), sum);

        MatrixMultiplication matrixMultiplication = new MatrixMultiplication(new int[][]{{1, 2, 3}, {4, 5, 6,}}, new int[][]{{10, 11}, {20, 21}, {30, 31}}, 0, 2, 2);
        pool.invoke(matrixMultiplication);
    }
}