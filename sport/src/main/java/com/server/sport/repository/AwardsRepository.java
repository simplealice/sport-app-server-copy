package com.server.sport.repository;

import com.server.sport.model.Awards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardsRepository extends JpaRepository<Awards, Integer> {

}
