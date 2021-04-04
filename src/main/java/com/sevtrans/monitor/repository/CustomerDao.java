package com.sevtrans.monitor.repository;

import com.sevtrans.monitor.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, String> {
    Customer findByClientID(int clientID);
}
