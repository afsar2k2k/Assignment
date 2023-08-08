package com.company.rewards.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.company.rewards.entity.PurchaseEntity;

@Repository
@Transactional
public interface PurchaseInfoRepo extends CrudRepository<PurchaseEntity,Long> {
    public List<PurchaseEntity> findAllPersons(Long id);

    public List<PurchaseEntity> findAllPurchasesByDateRange(Long personId, Timestamp fromDate, Timestamp toDate);
}
