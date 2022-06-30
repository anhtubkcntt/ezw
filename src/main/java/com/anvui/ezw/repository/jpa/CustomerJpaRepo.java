package com.anvui.ezw.repository.jpa;

import com.anvui.ezw.model.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepo extends JpaRepository<CustomerEntity, String> {
}
