package com.jk.seven.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jk.seven.entity.JkOrder;
import com.jk.seven.mapper.JkOrderMapper;
import com.jk.seven.service.JkOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuhuanle
 * @since 2021-05-09
 */
@RestController
@RequestMapping("/jk-order")
@Slf4j
public class JkOrderController {

    @Autowired
    JkOrderService jkOrderService;

    @Autowired
    JkOrderMapper jkOrderMapper;


    @GetMapping("/test1")
    public void test1() {
        Date date = new Date();
        long l1 = System.currentTimeMillis();
        List<JkOrder> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            JkOrder jkOrder = new JkOrder();
            jkOrder.setBuyerId(11);
            jkOrder.setOrderId(i);
            jkOrder.setCreateTime(date);
            jkOrder.setBuyerRemark("你好你好");
            list.add(jkOrder);
        }
        jkOrderService.saveBatch(list);
        long l2 = System.currentTimeMillis();
        log.info("批量插入耗时{}" , l2-l1);
        // 耗时5分钟 可能与我的网络有关
    }

    @GetMapping("/delete")
    public void delete() {
        jkOrderMapper.delete(new QueryWrapper<>());
    }

    @GetMapping("/test2")
    public void test2() {
        Date date = new Date();
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            JkOrder jkOrder = new JkOrder();
            jkOrder.setBuyerId(11);
            jkOrder.setOrderId(i);
            jkOrder.setCreateTime(date);
            jkOrder.setBuyerRemark("你好你好");
            jkOrder.insert();
        }
        long l2 = System.currentTimeMillis();
        log.info("单个插入耗时{}" , l2-l1);
        // 耗时20分钟  可能与我的网络有关
    }

}

