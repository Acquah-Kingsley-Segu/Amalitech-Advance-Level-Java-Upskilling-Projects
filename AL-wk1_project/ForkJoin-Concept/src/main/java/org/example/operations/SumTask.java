package org.example.operations;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {
    private final long[] nums;

    public SumTask(long[] nums) {
        this.nums = nums;
    }

    public long[] getNums() {
        return nums;
    }

    @Override
    protected Long compute() {
        if (this.nums.length > 10){
            SumTask subTask1 = new SumTask(subArray(0, this.nums.length / 2));
            SumTask sumTask2 = new SumTask(subArray(this.nums.length / 2 + 1, this.nums.length - 1));

            subTask1.fork();
            sumTask2.fork();

            return subTask1.join() + sumTask2.join();
        }

        return Arrays.stream(this.nums).sum();
    }

    private long[] subArray(int startIdx, int endIdx) {
        long[] newArray = new long[(endIdx - startIdx) + 1];
        System.arraycopy(this.nums, startIdx, newArray, 0, (endIdx - startIdx) + 1);

        return newArray;
    }
}
