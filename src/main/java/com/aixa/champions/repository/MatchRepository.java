package com.aixa.champions.repository;
import com.aixa.champions.model.Match; import org.springframework.data.jpa.repository.JpaRepository;
public interface MatchRepository extends JpaRepository<Match,Long>{boolean existsByExternalId(String externalId);}
