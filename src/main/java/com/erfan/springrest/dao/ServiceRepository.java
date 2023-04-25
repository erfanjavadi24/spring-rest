package com.erfan.springrest.dao;

import com.erfan.springrest.entity.ServiceCallLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceCallLog,Integer> {
}