package com.github.dylanz666.repository;

import com.github.dylanz666.domain.AgentConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : dylanz
 * @since : 09/14/2020
 */
@Repository
public interface AgentConfigRepository extends MongoRepository<AgentConfig, String> {
    @Query("{'_id':?0}")
    Optional<AgentConfig> findById(String _id);
}
