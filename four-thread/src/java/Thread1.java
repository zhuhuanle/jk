package java;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author : zhu_huan
 * @createTime : 2021/4/8
 **/
public class Thread1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("主线程启动");
        FutureTask<String> futureTask = new FutureTask<>(()->{
            return "1111";
        });

        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("返回值:" + futureTask.get());
    }
}
