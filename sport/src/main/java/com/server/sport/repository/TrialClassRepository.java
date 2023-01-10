package com.server.sport.repository;

import com.server.sport.model.TrialClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrialClassRepository extends JpaRepository<TrialClass, Integer> {

}
