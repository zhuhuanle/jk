package io.kimmking.cache.redis;

import org.springframework.stereotype.Component;

/**
 * @author : zhu_huan
 * @createTime : 2021/6/10
 **/
@Component
public class MessageReceiver {
    /**接收消息的方法*/
    public void receiveMessage(String message){
        System.out.println(message);
    }
}
