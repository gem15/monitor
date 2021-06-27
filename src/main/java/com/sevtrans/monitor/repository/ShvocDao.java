package com.sevtrans.monitor.repository;

import com.sevtrans.monitor.model.Shvoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShvocDao extends JpaRepository<Shvoc, String> {
}
