package com.anvui.ezw.repository.jpa;

import com.anvui.ezw.model.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenJpaRepo extends JpaRepository<TokenEntity, String> {
}
