package com.jk.seven.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
 * @since 2021-05-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="JkOrder对象", description="")
public class JkOrder extends Model<JkOrder> {

    private static final long serialVersionUID = 1L;

    private Integer orderId;

    @ApiModelProperty(value = "购买人Id")
    private Integer buyerId;

    @ApiModelProperty(value = "商家id")
    private Integer merchantId;

    @ApiModelProperty(value = "订单状态")
    private String orderStatus;

    @ApiModelProperty(value = "支付金额")
    private BigDecimal money;

    @ApiModelProperty(value = "产品id")
    private Integer productId;

    @ApiModelProperty(value = "支付状态")
    private String payStatus;

    @ApiModelProperty(value = "快递单号")
    private String expressId;

    @ApiModelProperty(value = "客户备注")
    private String buyerRemark;

    @ApiModelProperty(value = "商家备注")
    private String merchantRemark;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人id")
    private Integer createUserId;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "创建人id")
    private Integer updateUserId;


    @Override
    protected Serializable pkVal() {
        return this.orderId;
    }

}
