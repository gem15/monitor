package com.sevtrans.monitor.repository;

import com.sevtrans.monitor.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,String> {
}
