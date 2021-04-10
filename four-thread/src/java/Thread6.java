package java;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author : zhu_huan
 * @createTime : 2021/4/8
 **/
public class Thread6 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 5, 1, TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(6), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        FutureTask<String> future = new FutureTask<String>(()->{return "111";});
        threadPoolExecutor.submit(future);
        System.out.println("输出结果:"+
                future.get(1,TimeUnit.MINUTES));
        try {
            threadPoolExecutor.shutdown();
            if(!threadPoolExecutor.awaitTermination(1, TimeUnit.SECONDS)){
                threadPoolExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("awaitTermination interrupted: " + e);
            threadPoolExecutor.shutdownNow();
        }
    }
}
