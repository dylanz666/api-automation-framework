package com.github.dylanz666.service;

import com.github.dylanz666.domain.AgentConfig;
import com.github.dylanz666.repository.AgentConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : dylanz
 * @since : 09/11/2020
 */
@Service
public class AgentConfigService implements AgentConfigRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Optional<AgentConfig> findById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return Optional.ofNullable(mongoTemplate.findOne(query, AgentConfig.class));
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public <S extends AgentConfig> S save(S s) {
        return null;
    }

    @Override
    public <S extends AgentConfig> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public List<AgentConfig> findAll() {
        return null;
    }

    @Override
    public Iterable<AgentConfig> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(AgentConfig agentConfig) {

    }

    @Override
    public void deleteAll(Iterable<? extends AgentConfig> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<AgentConfig> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<AgentConfig> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends AgentConfig> S insert(S s) {
        return null;
    }

    @Override
    public <S extends AgentConfig> List<S> insert(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends AgentConfig> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends AgentConfig> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends AgentConfig> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends AgentConfig> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends AgentConfig> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends AgentConfig> boolean exists(Example<S> example) {
        return false;
    }
}
