package com.company.rewards.service;

import com.company.rewards.dto.RewardsDTO;
import com.company.rewards.exception.MissingDataException;
import com.company.rewards.exception.NoDataFoundException;


public interface RewardsServiceIF {
    public RewardsDTO getRewardsByCustomerId(Long customerId) throws MissingDataException, NoDataFoundException;
}
