package cn.shy.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @description 抽奖策略
 * @create 2023-12-16 13:12
 */
@Data
public class Strategy {

    /** 自增ID */
    private Long id;
    /** 抽奖策略ID */
    private Long strategyId;
    /** 抽奖策略描述 */
    private String strategyDesc;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

}
