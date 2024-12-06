package com.mappingfeb2.repository;

import com.mappingfeb2.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
}