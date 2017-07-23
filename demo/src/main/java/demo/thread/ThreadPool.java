package demo.thread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * 给线程池增加一些特性
 * 1.当有有空闲线程时,添加任务不新增线程
 * 2.线程数能够有3种状态:
 * 保留线程数:初始化保留的线程数量
 * 默认线程数:
 * 最大线程数
 * 3.
 */

/**
 * 1.线程数支持3种类型:
 * 保留线程数:不会被回收的线程数量
 * 默认线程数:回收比较慢的线程数量
 * 最大线程数:回收比较快的线程数量
 * 2.不同类型的线程数之间回收的时间不同
 * 3.超过30秒没有空闲线程,自动增加线程数,避免死锁导致的问题
 * 4.有空闲线程时,不创建新线程,重新利用现有的线程工作
 */
public class ThreadPool {
    public void produce() throws Exception {
        final Depot<Integer> depot = new Depot<Integer>(100);
        ProductFuture<Integer> future = depot.produce(1);

        //start a thread
        ExecutorService consumerExecutor = Executors.newSingleThreadExecutor();
        consumerExecutor.submit(new Runnable() {
            public void run() {
                List<ProductFuture<Integer>> productFutures = depot.consume(10);
                for (ProductFuture<Integer> productFuture : productFutures) {
                    Integer tVal = productFuture.getContent();

                    System.out.println(tVal);

                    try {
                        Thread.sleep(2 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    productFuture.setDone(123456);
                }
            }
        });

        //等待完成通知
        future.await();
        System.out.println(String.format("productFuture.await() complete result : %d", (Integer) future.getResult()));
        consumerExecutor.shutdown();
        consumerExecutor.awaitTermination(10, TimeUnit.SECONDS);
    }
}
