package java;

import java.util.Hashtable;
import java.util.concurrent.CyclicBarrier;

/**
 * @author : zhu_huan
 * @createTime : 2021/4/10
 **/
public class Test implements Runnable {

    private int code;
    private CyclicBarrier cyclicBarrier;

    public Test(int code, CyclicBarrier cyclicBarrier) {
        this.code = code;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("编号:" + code + "的学员已经就位");
        try {
            cyclicBarrier.await();//阻塞,直到去除屏障
            System.out.println("编号:" + code + "的学员已经出发");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Thread(() -> {
            System.out.println("人员到齐,出发");
        }));
        Hashtable<String, String> hashMap = new Hashtable<>();
        new Thread(new Test(1, cyclicBarrier)).start();
        new Thread(new Test(2, cyclicBarrier)).start();
        new Thread(new Test(3, cyclicBarrier)).start();
    }


}
