package com.elizwy.javatech.concurrent;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadExecutorTest {
    public static void main(String[] args) {
        AtomicInteger count=new AtomicInteger(0);

        final ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 2, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                if (!executor.isShutdown()) {
                    r.run();
                }
            }
        });

        for (int i = 0; i < 10; i++) {
            pool.submit(()->{
                System.out.println("i am ["+count.incrementAndGet()+"] work");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
