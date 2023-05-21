package com.server.sport.repository;

import com.server.sport.model.Coach;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CoachRepository extends JpaRepository<Coach, Integer> {

}
