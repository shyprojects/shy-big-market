package cn.shy.domain.strategy.service.armory;

/**
 * 策略装配库(兵工厂)，负责初始化策略计算
 * @author shy
 * @since 2024/3/23 22:17
 */
public interface IStrategyArmory {
    /**
     * 装配抽奖策略配置「触发的时机可以为活动审核通过后进行调用」
     *
     * @param strategyId 策略ID
     * @return 装配结果
     */
    boolean assembleLotteryStrategy(Long strategyId);
    
    /**
     * 根据活动id缓存策略
     * @param activityId
     * @return
     */
    boolean assembleLotteryStrategyByActivityId(Long activityId);
}
