package com.shop.payment_service.repo;

import com.shop.payment_service.entity.Payement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayementRepo extends JpaRepository<Payement,Integer> {


}
