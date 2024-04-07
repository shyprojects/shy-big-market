package cn.shy.domain.activity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shy
 * @since 2024/4/6 15:14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityAccountDayEntity {
    
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 日期（yyyy-mm-dd）
     */
    private String day;
    /**
     * 日次数
     */
    private Integer dayCount;
    /**
     * 日次数-剩余
     */
    private Integer dayCountSurplus;
}
