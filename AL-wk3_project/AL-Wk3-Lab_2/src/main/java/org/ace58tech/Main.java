package org.ace58tech;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        StockService.getStockPrice("AAPL")
                        .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Done"));

        Thread.sleep(60000);
    }
}