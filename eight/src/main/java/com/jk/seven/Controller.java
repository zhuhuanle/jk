package com.jk.seven;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jk.seven.entity.JkOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhu_huan
 * @createTime : 2021/5/23
 **/
@RestController
public class Controller {


    @PostMapping()
    public void testInsert(@RequestBody JkOrder jkOrder1){
        for (int i = 0; i < 8; i++) {
            JkOrder jkOrder = new JkOrder();
            jkOrder.setOrderId(i);
            jkOrder.setBuyerId(i);
            jkOrder.insert();
        }


    }

    @GetMapping()
    public JkOrder testInsert(){
        QueryWrapper<JkOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", 1);
        queryWrapper.eq("buyer_id", 1);
        //return jkOrderMapper.selectOne(queryWrapper);
        return null;
    }


}
