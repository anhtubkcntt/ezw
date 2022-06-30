package com.anvui.ezw.repository.jpa;

import com.anvui.ezw.model.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffJpaRepo extends JpaRepository<StaffEntity, String> {

    Optional<StaffEntity> findByUserName(String userName);
}
