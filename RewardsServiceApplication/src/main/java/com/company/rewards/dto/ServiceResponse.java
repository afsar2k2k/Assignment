package com.company.rewards.dto;

import java.io.Serializable;

public class ServiceResponse implements Serializable {

    private String errorMessage ;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public RewardsDTO getRewards() {
        return rewards;
    }

    public void setRewards(RewardsDTO rewards) {
        this.rewards = rewards;
    }

    private RewardsDTO rewards;


}
