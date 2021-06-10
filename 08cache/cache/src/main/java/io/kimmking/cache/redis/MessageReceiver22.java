package io.kimmking.cache.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author : zhu_huan
 * @createTime : 2021/6/10
 **/
@Component
public class MessageReceiver22 implements MessageListener {


    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println("MessageReceiver22:::" + message);
    }
}
