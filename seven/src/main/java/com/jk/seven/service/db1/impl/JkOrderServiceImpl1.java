package com.jk.seven.service.db1.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jk.seven.entity.JkOrder;
import com.jk.seven.mapper.JkOrderMapper;
import com.jk.seven.service.db1.JkOrderService1;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuhuanle
 * @since 2021-05-09
 */
@Service
@DS("db2")
public class JkOrderServiceImpl1 extends ServiceImpl<JkOrderMapper, JkOrder> implements JkOrderService1 {


}
