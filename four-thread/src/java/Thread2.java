package java;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author : zhu_huan
 * @createTime : 2021/4/8
 **/
public class Thread2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            return "111";
        });
        String s = future.get();
        System.out.println("返回结果：" + s);
    }
}
