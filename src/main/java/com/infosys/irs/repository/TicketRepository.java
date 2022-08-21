package com.infosys.irs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.irs.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Double> {

}
