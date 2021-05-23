package com.jk.seven.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author zhuhuanle
 * @since 2021-05-23
 */
@Data
@Accessors(chain = true)
public class JkOrder extends Model<JkOrder> {

    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer orderId;

    private Integer buyerId;

    private Integer merchantId;

    private String orderStatus;

    private BigDecimal money;

    private Integer productId;

    private String payStatus;

    private String expressId;

    private String buyerRemark;

    private String merchantRemark;

    private Date createTime;

    private Integer createUserId;

    private Date updateTime;

    private Integer updateUserId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
