package io.kimmking.cache.controller;

import com.alibaba.fastjson.JSONObject;
import io.kimmking.cache.entity.User;
import io.kimmking.cache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@EnableAutoConfiguration
@Slf4j
public class UserController {

    @Autowired
    UserService userService;


    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/user/find")
    User find(Integer id) {
        return userService.find(id);
        //return new User(1,"KK", 28);
    }

    @RequestMapping("/user/list")
    List<User> list() {
        return userService.list();
//        return Arrays.asList(new User(1,"KK", 28),
//                             new User(2,"CC", 18));
    }

    @RequestMapping(value = "/user/lock", method = RequestMethod.GET)
    String lock(@Param("id") Integer id) throws InterruptedException {

        Boolean id1 = redisTemplate.opsForValue().setIfAbsent("user.update.lock" + id, 0);
        if (id1) {
            try {
                log.info("获取到了锁id{}", id);
                wait(3000);
            } finally {
                redisTemplate.expire("user.update.lock" + id, 0, TimeUnit.MINUTES);
            }
            return "ok";
        } else {
            log.info("");
            return "no";
        }

    }


    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    void add(@Param("id") Integer id) {
        redisTemplate.opsForValue().set("pd.num" + id,1000);
    }
    // 须先设置库存
    @RequestMapping(value = "/user/decr", method = RequestMethod.GET)
    String decr(@Param("id") Integer id) {

        Boolean id1 = redisTemplate.opsForValue().setIfAbsent("pd.decr.lock" + id, 0);
        if (id1) {
            try {
                Long decr = redisTemplate.getConnectionFactory().getConnection().decr(redisTemplate.getKeySerializer().serialize("pd.num" + id));
                if (decr < 0) {
                    return "no";
                }
                // 创建订单

            } finally {
                redisTemplate.expire("pd.decr.lock" + id, 1, TimeUnit.MINUTES);
            }
            return "ok";
        } else {
            log.info("");
            return "no";
        }
    }

    @RequestMapping(value = "/pub", method = RequestMethod.GET)
    public boolean unLock(@RequestParam(value = "name") String name,
                          @RequestParam(value = "age") Integer age) {
        //创建消息任务对象
        User user = new User();
        user.setAge(age);
        user.setName(name);
        redisTemplate.convertAndSend("chat", JSONObject.toJSON(user));
        redisTemplate.convertAndSend("chat22", JSONObject.toJSON(user));
        return true;
    }

}