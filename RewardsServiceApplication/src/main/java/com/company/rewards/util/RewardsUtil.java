package com.company.rewards.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class RewardsUtil {
    public static final int DAYS_IN_MONTHS = 30;
    public static final int REWARDS_RANGE_1 = 50;
    public static final int REWARDS_RANGE_2 = 100;

    public static boolean isRange1( Double amt ){
        return  (amt > RewardsUtil.REWARDS_RANGE_1 && amt <= RewardsUtil.REWARDS_RANGE_2);
    }

    public static boolean isRange2( Double amt ){
        return (amt > RewardsUtil.REWARDS_RANGE_2);
    }

    public static Timestamp getDate(int days) {
        return Timestamp.valueOf(LocalDateTime.now().minusDays(days));
    }

}
