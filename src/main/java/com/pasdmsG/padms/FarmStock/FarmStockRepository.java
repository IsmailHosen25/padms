package com.pasdmsG.padms.FarmStock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmStockRepository extends JpaRepository<FarmStock,Long> {
    List<FarmStockFarmerView> findAllByUserPhone(Integer phone);
}
