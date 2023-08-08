package com.company.rewards.service;

import com.company.rewards.dto.RewardsDTO;
import com.company.rewards.entity.CustomerEntity;
import com.company.rewards.entity.PurchaseEntity;
import com.company.rewards.exception.MissingDataException;
import com.company.rewards.exception.NoDataFoundException;
import com.company.rewards.repository.CustomerRepository;
import com.company.rewards.repository.PurchaseInfoRepo;
import com.company.rewards.util.RewardsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RewardsServiceImpl implements RewardsServiceIF {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	PurchaseInfoRepo purchaseInfoRepo;

	public RewardsDTO getRewardsByCustomerId(Long customerId) throws MissingDataException, NoDataFoundException {

		if(customerId == null)
		{
			throw new MissingDataException("Missing required customerId ");
		}

		CustomerEntity customerEntity = customerRepository.findByCustomerId(customerId);
		if(customerEntity == null)
		{
			throw new NoDataFoundException("Invalid Customer Id ");
		}

		Timestamp lastMonthTimestamp = RewardsUtil.getDate(RewardsUtil.DAYS_IN_MONTHS);
		Timestamp lastSecondMonthTimestamp = RewardsUtil.getDate(2* RewardsUtil.DAYS_IN_MONTHS);
		Timestamp lastThirdMonthTimestamp = RewardsUtil.getDate(3* RewardsUtil.DAYS_IN_MONTHS);

		List<PurchaseEntity> lastMonthTransactions = purchaseInfoRepo.findAllPurchasesByDateRange(
				customerId, lastMonthTimestamp, Timestamp.from(Instant.now()));
		List<PurchaseEntity> lastSecondMonthTransactions = purchaseInfoRepo
				.findAllPurchasesByDateRange(customerId, lastSecondMonthTimestamp, lastMonthTimestamp);
		List<PurchaseEntity> lastThirdMonthTransactions = purchaseInfoRepo
				.findAllPurchasesByDateRange(customerId, lastThirdMonthTimestamp,
						lastSecondMonthTimestamp);

		Long lastMonthRewardPoints = calculateRewardsPerMonth(lastMonthTransactions);
		Long lastSecondMonthRewardPoints = calculateRewardsPerMonth(lastSecondMonthTransactions);
		Long lastThirdMonthRewardPoints = calculateRewardsPerMonth(lastThirdMonthTransactions);

		RewardsDTO customerRewards = new RewardsDTO();
		customerRewards.setCustomerId(customerId);
		customerRewards.setLastMonthRewardPoints(lastMonthRewardPoints);
		customerRewards.setLastSecondMonthRewardPoints(lastSecondMonthRewardPoints);
		customerRewards.setLastThirdMonthRewardPoints(lastThirdMonthRewardPoints);
		customerRewards.setTotalRewards(lastMonthRewardPoints + lastSecondMonthRewardPoints + lastThirdMonthRewardPoints);

		return customerRewards;

	}

	private Long calculateRewardsPerMonth(List<PurchaseEntity> purchases) {
		return purchases.stream()
				.map(purchase -> calculate(purchase))
				.collect(Collectors.summingLong(r -> r.longValue()));
	}

	private Long calculate(PurchaseEntity purchaseEntity) {
		if ( RewardsUtil.isRange1 (purchaseEntity.getPurchaseAmount() ) ) {
			return Math.round(purchaseEntity.getPurchaseAmount() - RewardsUtil.REWARDS_RANGE_1);
		} else if ( RewardsUtil.isRange2(  purchaseEntity.getPurchaseAmount() )) {
			return Math.round(purchaseEntity.getPurchaseAmount() - RewardsUtil.REWARDS_RANGE_2) * 2
					+ (RewardsUtil.REWARDS_RANGE_2 - RewardsUtil.REWARDS_RANGE_1);
		} else
			return 0l;

	}


}
