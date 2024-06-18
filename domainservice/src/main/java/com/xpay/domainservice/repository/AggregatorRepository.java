package com.xpay.domainservice.repository;

import com.xpay.domainservice.entity.AggregatorEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface AggregatorRepository extends JpaRepository<AggregatorEntity, Long> {
    @Override
    void flush();

    @Override
    <S extends AggregatorEntity> S saveAndFlush(S entity);

    @Override
    <S extends AggregatorEntity> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    default void deleteInBatch(Iterable<AggregatorEntity> entities) {
        JpaRepository.super.deleteInBatch(entities);
    }

    @Override
    void deleteAllInBatch(Iterable<AggregatorEntity> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    AggregatorEntity getOne(Long aLong);

    @Override
    AggregatorEntity getById(Long aLong);

    @Override
    AggregatorEntity getReferenceById(Long aLong);

    @Override
    <S extends AggregatorEntity> List<S> findAll(Example<S> example);

    @Override
    <S extends AggregatorEntity> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends AggregatorEntity> List<S> saveAll(Iterable<S> entities);

    @Override
    List<AggregatorEntity> findAll();

    @Override
    List<AggregatorEntity> findAllById(Iterable<Long> longs);

    @Override
    <S extends AggregatorEntity> S save(S entity);

    @Override
    Optional<AggregatorEntity> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(AggregatorEntity entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends AggregatorEntity> entities);

    @Override
    void deleteAll();

    @Override
    List<AggregatorEntity> findAll(Sort sort);

    @Override
    Page<AggregatorEntity> findAll(Pageable pageable);

    @Override
    <S extends AggregatorEntity> Optional<S> findOne(Example<S> example);

    @Override
    <S extends AggregatorEntity> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends AggregatorEntity> long count(Example<S> example);

    @Override
    <S extends AggregatorEntity> boolean exists(Example<S> example);

    @Override
    <S extends AggregatorEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
