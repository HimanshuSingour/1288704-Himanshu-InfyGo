package com.infosys.irs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.irs.entity.CreditCardDetails;

public interface CreditCardRepository extends JpaRepository<CreditCardDetails, String> {

}
