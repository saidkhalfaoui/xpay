package com.henripay.domainservice.repository;

import com.henripay.domainservice.entity.AggregatorEntity;
import com.henripay.domainservice.entity.MetadataEntity;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.mockito.Mockito.mock;

@ContextConfiguration(classes = {AggregatorRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.henripay.domainservice.entity"})
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
public class AggregatorRepositoryDiffblueTest {
    @Autowired
    private AggregatorRepository aggregatorRepository;

    /**
     * Method under test: {@link AggregatorRepository#flush()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testFlush() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        // Act
        aggregatorRepository.flush();
    }

    /**
     * Method under test:
     * {@link AggregatorRepository#saveAndFlush(AggregatorEntity)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSaveAndFlush() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.saveAndFlush(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.saveAndFlush(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.saveAndFlush(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        // Act
        aggregatorRepository.saveAndFlush(aggregatorEntity);
    }

    /**
     * Method under test: {@link AggregatorRepository#saveAllAndFlush(Iterable)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSaveAllAndFlush() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.saveAllAndFlush(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.saveAllAndFlush(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.saveAllAndFlush(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(1L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("42 Main St");
        aggregatorEntity2.setAggregatorIban("Aggregator Iban");
        aggregatorEntity2.setAggregatorName("Aggregator Name");
        aggregatorEntity2.setMetadata(metadata2);

        MetadataEntity metadata3 = new MetadataEntity();
        metadata3.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata3.setMetadataId(1L);
        metadata3.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity3 = new AggregatorEntity();
        aggregatorEntity3.setAggregatorAddress("42 Main St");
        aggregatorEntity3.setAggregatorIban("Aggregator Iban");
        aggregatorEntity3.setAggregatorName("Aggregator Name");
        aggregatorEntity3.setMetadata(metadata3);
        List<AggregatorEntity> entities = Arrays.asList(aggregatorEntity, aggregatorEntity2, aggregatorEntity3);

        // Act
        aggregatorRepository.saveAllAndFlush(entities);
    }

    /**
     * Method under test: {@link AggregatorRepository#deleteInBatch(Iterable)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDeleteInBatch() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        MetadataEntity metadata3 = new MetadataEntity();
        metadata3.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata3.setMetadataId(1L);
        metadata3.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity3 = new AggregatorEntity();
        aggregatorEntity3.setAggregatorAddress("42 Main St");
        aggregatorEntity3.setAggregatorIban("Aggregator Iban");
        aggregatorEntity3.setAggregatorName("Aggregator Name");
        aggregatorEntity3.setMetadata(metadata3);
        AggregatorEntity saveResult = aggregatorRepository.save(aggregatorEntity3);

        MetadataEntity metadata4 = new MetadataEntity();
        metadata4.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata4.setMetadataId(1L);
        metadata4.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity4 = new AggregatorEntity();
        aggregatorEntity4.setAggregatorAddress("42 Main St");
        aggregatorEntity4.setAggregatorIban("Aggregator Iban");
        aggregatorEntity4.setAggregatorName("Aggregator Name");
        aggregatorEntity4.setMetadata(metadata4);
        AggregatorEntity saveResult2 = aggregatorRepository.save(aggregatorEntity4);

        MetadataEntity metadata5 = new MetadataEntity();
        metadata5.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata5.setMetadataId(1L);
        metadata5.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity5 = new AggregatorEntity();
        aggregatorEntity5.setAggregatorAddress("42 Main St");
        aggregatorEntity5.setAggregatorIban("Aggregator Iban");
        aggregatorEntity5.setAggregatorName("Aggregator Name");
        aggregatorEntity5.setMetadata(metadata5);
        List<AggregatorEntity> entities = Arrays.asList(saveResult, saveResult2,
                aggregatorRepository.save(aggregatorEntity5));

        // Act
        aggregatorRepository.deleteInBatch(entities);
    }

    /**
     * Method under test: {@link AggregatorRepository#deleteAllInBatch()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDeleteAllInBatch() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        // Act
        aggregatorRepository.deleteAllInBatch();
    }

    /**
     * Method under test: {@link AggregatorRepository#deleteAllInBatch(Iterable)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDeleteAllInBatch2() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        MetadataEntity metadata3 = new MetadataEntity();
        metadata3.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata3.setMetadataId(1L);
        metadata3.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity3 = new AggregatorEntity();
        aggregatorEntity3.setAggregatorAddress("42 Main St");
        aggregatorEntity3.setAggregatorIban("Aggregator Iban");
        aggregatorEntity3.setAggregatorName("Aggregator Name");
        aggregatorEntity3.setMetadata(metadata3);
        AggregatorEntity saveResult = aggregatorRepository.save(aggregatorEntity3);

        MetadataEntity metadata4 = new MetadataEntity();
        metadata4.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata4.setMetadataId(1L);
        metadata4.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity4 = new AggregatorEntity();
        aggregatorEntity4.setAggregatorAddress("42 Main St");
        aggregatorEntity4.setAggregatorIban("Aggregator Iban");
        aggregatorEntity4.setAggregatorName("Aggregator Name");
        aggregatorEntity4.setMetadata(metadata4);
        AggregatorEntity saveResult2 = aggregatorRepository.save(aggregatorEntity4);

        MetadataEntity metadata5 = new MetadataEntity();
        metadata5.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata5.setMetadataId(1L);
        metadata5.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity5 = new AggregatorEntity();
        aggregatorEntity5.setAggregatorAddress("42 Main St");
        aggregatorEntity5.setAggregatorIban("Aggregator Iban");
        aggregatorEntity5.setAggregatorName("Aggregator Name");
        aggregatorEntity5.setMetadata(metadata5);
        List<AggregatorEntity> entities = Arrays.asList(saveResult, saveResult2,
                aggregatorRepository.save(aggregatorEntity5));

        // Act
        aggregatorRepository.deleteAllInBatch(entities);
    }

    /**
     * Method under test: {@link AggregatorRepository#getOne(Long)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testGetOne() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        // Act
        aggregatorRepository.getOne(1L);
    }

    /**
     * Method under test: {@link AggregatorRepository#getById(Long)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testGetById() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        MetadataEntity metadata3 = new MetadataEntity();
        metadata3.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata3.setMetadataId(1L);
        metadata3.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity3 = new AggregatorEntity();
        aggregatorEntity3.setAggregatorAddress("42 Main St");
        aggregatorEntity3.setAggregatorIban("Aggregator Iban");
        aggregatorEntity3.setAggregatorName("Aggregator Name");
        aggregatorEntity3.setMetadata(metadata3);

        // Act
        aggregatorRepository.getById(aggregatorRepository.save(aggregatorEntity3).getAggregatorId());
    }

    /**
     * Method under test: {@link AggregatorRepository#getReferenceById(Long)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testGetReferenceById() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        MetadataEntity metadata3 = new MetadataEntity();
        metadata3.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata3.setMetadataId(1L);
        metadata3.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity3 = new AggregatorEntity();
        aggregatorEntity3.setAggregatorAddress("42 Main St");
        aggregatorEntity3.setAggregatorIban("Aggregator Iban");
        aggregatorEntity3.setAggregatorName("Aggregator Name");
        aggregatorEntity3.setMetadata(metadata3);

        // Act
        aggregatorRepository.getReferenceById(aggregatorRepository.save(aggregatorEntity3).getAggregatorId());
    }

    /**
     * Method under test: {@link AggregatorRepository#findAll()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testFindAll() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        // Act
        aggregatorRepository.findAll();
    }

    /**
     * Method under test: {@link AggregatorRepository#findAll(Example)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testFindAll2() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        MetadataEntity metadata3 = new MetadataEntity();
        metadata3.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata3.setMetadataId(1L);
        metadata3.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity3 = new AggregatorEntity();
        aggregatorEntity3.setAggregatorAddress("42 Main St");
        aggregatorEntity3.setAggregatorIban("Aggregator Iban");
        aggregatorEntity3.setAggregatorName("Aggregator Name");
        aggregatorEntity3.setMetadata(metadata3);
        Example<AggregatorEntity> example = Example.of(aggregatorEntity3);

        // Act
        aggregatorRepository.findAll(example);
    }

    /**
     * Method under test: {@link AggregatorRepository#findAll(Example, Pageable)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testFindAll3() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        MetadataEntity metadata3 = new MetadataEntity();
        metadata3.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata3.setMetadataId(1L);
        metadata3.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity3 = new AggregatorEntity();
        aggregatorEntity3.setAggregatorAddress("42 Main St");
        aggregatorEntity3.setAggregatorIban("Aggregator Iban");
        aggregatorEntity3.setAggregatorName("Aggregator Name");
        aggregatorEntity3.setMetadata(metadata3);
        Example<AggregatorEntity> example = Example.of(aggregatorEntity3);

        // Act
        aggregatorRepository.findAll(example, Pageable.unpaged());
    }

    /**
     * Method under test: {@link AggregatorRepository#findAll(Example, Sort)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testFindAll4() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        MetadataEntity metadata3 = new MetadataEntity();
        metadata3.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata3.setMetadataId(1L);
        metadata3.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity3 = new AggregatorEntity();
        aggregatorEntity3.setAggregatorAddress("42 Main St");
        aggregatorEntity3.setAggregatorIban("Aggregator Iban");
        aggregatorEntity3.setAggregatorName("Aggregator Name");
        aggregatorEntity3.setMetadata(metadata3);
        Example<AggregatorEntity> example = Example.of(aggregatorEntity3);

        // Act
        aggregatorRepository.findAll(example, Sort.unsorted());
    }

    /**
     * Method under test: {@link AggregatorRepository#findAll(Pageable)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testFindAll5() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        // Act
        aggregatorRepository.findAll(Pageable.unpaged());
    }

    /**
     * Method under test: {@link AggregatorRepository#findAll(Sort)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testFindAll6() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        // Act
        aggregatorRepository.findAll(Sort.unsorted());
    }

    /**
     * Method under test: {@link AggregatorRepository#saveAll(Iterable)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSaveAll() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.saveAll(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.saveAll(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.saveAll(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(1L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("42 Main St");
        aggregatorEntity2.setAggregatorIban("Aggregator Iban");
        aggregatorEntity2.setAggregatorName("Aggregator Name");
        aggregatorEntity2.setMetadata(metadata2);

        MetadataEntity metadata3 = new MetadataEntity();
        metadata3.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata3.setMetadataId(1L);
        metadata3.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity3 = new AggregatorEntity();
        aggregatorEntity3.setAggregatorAddress("42 Main St");
        aggregatorEntity3.setAggregatorIban("Aggregator Iban");
        aggregatorEntity3.setAggregatorName("Aggregator Name");
        aggregatorEntity3.setMetadata(metadata3);
        List<AggregatorEntity> entities = Arrays.asList(aggregatorEntity, aggregatorEntity2, aggregatorEntity3);

        // Act
        aggregatorRepository.saveAll(entities);
    }

    /**
     * Method under test: {@link AggregatorRepository#findOne(Example)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testFindOne() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        MetadataEntity metadata3 = new MetadataEntity();
        metadata3.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata3.setMetadataId(1L);
        metadata3.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity3 = new AggregatorEntity();
        aggregatorEntity3.setAggregatorAddress("42 Main St");
        aggregatorEntity3.setAggregatorIban("Aggregator Iban");
        aggregatorEntity3.setAggregatorName("Aggregator Name");
        aggregatorEntity3.setMetadata(metadata3);
        Example<AggregatorEntity> example = Example.of(aggregatorEntity3);

        // Act
        aggregatorRepository.findOne(example);
    }

    /**
     * Method under test: {@link AggregatorRepository#findAllById(Iterable)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testFindAllById() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        MetadataEntity metadata3 = new MetadataEntity();
        metadata3.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata3.setMetadataId(1L);
        metadata3.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity3 = new AggregatorEntity();
        aggregatorEntity3.setAggregatorAddress("42 Main St");
        aggregatorEntity3.setAggregatorIban("Aggregator Iban");
        aggregatorEntity3.setAggregatorName("Aggregator Name");
        aggregatorEntity3.setMetadata(metadata3);
        Long aggregatorId = aggregatorRepository.save(aggregatorEntity3).getAggregatorId();

        MetadataEntity metadata4 = new MetadataEntity();
        metadata4.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata4.setMetadataId(1L);
        metadata4.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity4 = new AggregatorEntity();
        aggregatorEntity4.setAggregatorAddress("42 Main St");
        aggregatorEntity4.setAggregatorIban("Aggregator Iban");
        aggregatorEntity4.setAggregatorName("Aggregator Name");
        aggregatorEntity4.setMetadata(metadata4);
        Long aggregatorId2 = aggregatorRepository.save(aggregatorEntity4).getAggregatorId();

        MetadataEntity metadata5 = new MetadataEntity();
        metadata5.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata5.setMetadataId(1L);
        metadata5.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity5 = new AggregatorEntity();
        aggregatorEntity5.setAggregatorAddress("42 Main St");
        aggregatorEntity5.setAggregatorIban("Aggregator Iban");
        aggregatorEntity5.setAggregatorName("Aggregator Name");
        aggregatorEntity5.setMetadata(metadata5);
        List<Long> longs = Arrays.asList(aggregatorId, aggregatorId2,
                aggregatorRepository.save(aggregatorEntity5).getAggregatorId());

        // Act
        aggregatorRepository.findAllById(longs);
    }

    /**
     * Method under test: {@link AggregatorRepository#save(AggregatorEntity)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSave() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        // Act
        aggregatorRepository.save(aggregatorEntity);
    }

    /**
     * Method under test: {@link AggregatorRepository#findById(Long)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testFindById() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        MetadataEntity metadata3 = new MetadataEntity();
        metadata3.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata3.setMetadataId(1L);
        metadata3.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity3 = new AggregatorEntity();
        aggregatorEntity3.setAggregatorAddress("42 Main St");
        aggregatorEntity3.setAggregatorIban("Aggregator Iban");
        aggregatorEntity3.setAggregatorName("Aggregator Name");
        aggregatorEntity3.setMetadata(metadata3);

        // Act
        aggregatorRepository.findById(aggregatorRepository.save(aggregatorEntity3).getAggregatorId());
    }

    /**
     * Method under test: {@link AggregatorRepository#existsById(Long)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testExistsById() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        MetadataEntity metadata3 = new MetadataEntity();
        metadata3.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata3.setMetadataId(1L);
        metadata3.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity3 = new AggregatorEntity();
        aggregatorEntity3.setAggregatorAddress("42 Main St");
        aggregatorEntity3.setAggregatorIban("Aggregator Iban");
        aggregatorEntity3.setAggregatorName("Aggregator Name");
        aggregatorEntity3.setMetadata(metadata3);

        // Act
        aggregatorRepository.existsById(aggregatorRepository.save(aggregatorEntity3).getAggregatorId());
    }

    /**
     * Method under test:
     * {@link AggregatorRepository#deleteAllByIdInBatch(Iterable)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDeleteAllByIdInBatch() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        // Act
        aggregatorRepository.deleteAllByIdInBatch(new ArrayList<>());
    }

    /**
     * Method under test: {@link AggregatorRepository#count()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testCount() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        // Act
        aggregatorRepository.count();
    }

    /**
     * Method under test: {@link AggregatorRepository#count(Example)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testCount2() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        MetadataEntity metadata3 = new MetadataEntity();
        metadata3.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata3.setMetadataId(1L);
        metadata3.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity3 = new AggregatorEntity();
        aggregatorEntity3.setAggregatorAddress("42 Main St");
        aggregatorEntity3.setAggregatorIban("Aggregator Iban");
        aggregatorEntity3.setAggregatorName("Aggregator Name");
        aggregatorEntity3.setMetadata(metadata3);
        Example<AggregatorEntity> example = Example.of(aggregatorEntity3);

        // Act
        aggregatorRepository.count(example);
    }

    /**
     * Method under test: {@link AggregatorRepository#exists(Example)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testExists() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        MetadataEntity metadata3 = new MetadataEntity();
        metadata3.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata3.setMetadataId(1L);
        metadata3.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity3 = new AggregatorEntity();
        aggregatorEntity3.setAggregatorAddress("42 Main St");
        aggregatorEntity3.setAggregatorIban("Aggregator Iban");
        aggregatorEntity3.setAggregatorName("Aggregator Name");
        aggregatorEntity3.setMetadata(metadata3);
        Example<AggregatorEntity> example = Example.of(aggregatorEntity3);

        // Act
        aggregatorRepository.exists(example);
    }

    /**
     * Method under test: {@link AggregatorRepository#findBy(Example, Function)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testFindBy() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        MetadataEntity metadata3 = new MetadataEntity();
        metadata3.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata3.setMetadataId(1L);
        metadata3.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity3 = new AggregatorEntity();
        aggregatorEntity3.setAggregatorAddress("42 Main St");
        aggregatorEntity3.setAggregatorIban("Aggregator Iban");
        aggregatorEntity3.setAggregatorName("Aggregator Name");
        aggregatorEntity3.setMetadata(metadata3);
        Example<AggregatorEntity> example = Example.of(aggregatorEntity3);

        // Act
        aggregatorRepository.<AggregatorEntity, Object>findBy(example, mock(Function.class));
    }

    /**
     * Method under test: {@link AggregatorRepository#deleteById(Long)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDeleteById() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        MetadataEntity metadata3 = new MetadataEntity();
        metadata3.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata3.setMetadataId(1L);
        metadata3.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity3 = new AggregatorEntity();
        aggregatorEntity3.setAggregatorAddress("42 Main St");
        aggregatorEntity3.setAggregatorIban("Aggregator Iban");
        aggregatorEntity3.setAggregatorName("Aggregator Name");
        aggregatorEntity3.setMetadata(metadata3);

        // Act
        aggregatorRepository.deleteById(aggregatorRepository.save(aggregatorEntity3).getAggregatorId());
    }

    /**
     * Method under test: {@link AggregatorRepository#delete(AggregatorEntity)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDelete() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);

        MetadataEntity metadata3 = new MetadataEntity();
        metadata3.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata3.setMetadataId(1L);
        metadata3.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity3 = new AggregatorEntity();
        aggregatorEntity3.setAggregatorAddress("42 Main St");
        aggregatorEntity3.setAggregatorIban("Aggregator Iban");
        aggregatorEntity3.setAggregatorName("Aggregator Name");
        aggregatorEntity3.setMetadata(metadata3);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        // Act
        aggregatorRepository.delete(aggregatorRepository.save(aggregatorEntity3));
    }

    /**
     * Method under test: {@link AggregatorRepository#deleteAllById(Iterable)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDeleteAllById() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        MetadataEntity metadata3 = new MetadataEntity();
        metadata3.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata3.setMetadataId(1L);
        metadata3.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity3 = new AggregatorEntity();
        aggregatorEntity3.setAggregatorAddress("42 Main St");
        aggregatorEntity3.setAggregatorIban("Aggregator Iban");
        aggregatorEntity3.setAggregatorName("Aggregator Name");
        aggregatorEntity3.setMetadata(metadata3);
        Long aggregatorId = aggregatorRepository.save(aggregatorEntity3).getAggregatorId();

        MetadataEntity metadata4 = new MetadataEntity();
        metadata4.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata4.setMetadataId(1L);
        metadata4.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity4 = new AggregatorEntity();
        aggregatorEntity4.setAggregatorAddress("42 Main St");
        aggregatorEntity4.setAggregatorIban("Aggregator Iban");
        aggregatorEntity4.setAggregatorName("Aggregator Name");
        aggregatorEntity4.setMetadata(metadata4);
        Long aggregatorId2 = aggregatorRepository.save(aggregatorEntity4).getAggregatorId();

        MetadataEntity metadata5 = new MetadataEntity();
        metadata5.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata5.setMetadataId(1L);
        metadata5.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity5 = new AggregatorEntity();
        aggregatorEntity5.setAggregatorAddress("42 Main St");
        aggregatorEntity5.setAggregatorIban("Aggregator Iban");
        aggregatorEntity5.setAggregatorName("Aggregator Name");
        aggregatorEntity5.setMetadata(metadata5);
        List<Long> longs = Arrays.asList(aggregatorId, aggregatorId2,
                aggregatorRepository.save(aggregatorEntity5).getAggregatorId());

        // Act
        aggregatorRepository.deleteAllById(longs);
    }

    /**
     * Method under test: {@link AggregatorRepository#deleteAll()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDeleteAll() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        // Act
        aggregatorRepository.deleteAll();
    }

    /**
     * Method under test: {@link AggregatorRepository#deleteAll(Iterable)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDeleteAll2() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; SQL [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]; constraint [FKER4NMUL6168E83CCGVU8QRX91]
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement [Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]] [insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:62)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation: "FKER4NMUL6168E83CCGVU8QRX91: PUBLIC.AGGREGATOR FOREIGN KEY(AGGREGATOR_META_DATA) REFERENCES PUBLIC.METADATA(METADATA_ID) (CAST(1 AS BIGINT))"; SQL statement:
        //   insert into aggregator (aggregator_address,aggregator_iban,aggregator_name,aggregator_meta_data,aggregator_id) values (?,?,?,?,default) [23506-224]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:520)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:489)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.constraint.ConstraintReferential.checkRowOwnTable(ConstraintReferential.java:311)
        //       at org.h2.constraint.ConstraintReferential.checkRow(ConstraintReferential.java:252)
        //       at org.h2.table.Table.fireConstraints(Table.java:1200)
        //       at org.h2.table.Table.fireAfterRow(Table.java:1218)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:188)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:256)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:216)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:174)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:194)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:107)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:175)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:113)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2868)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:670)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:754)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:738)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy161.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorAddress("42 Main St");
        aggregatorEntity.setAggregatorIban("Aggregator Iban");
        aggregatorEntity.setAggregatorName("Aggregator Name");
        aggregatorEntity.setMetadata(metadata);

        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(2L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity2 = new AggregatorEntity();
        aggregatorEntity2.setAggregatorAddress("17 High St");
        aggregatorEntity2.setAggregatorIban("42");
        aggregatorEntity2.setAggregatorName("42");
        aggregatorEntity2.setMetadata(metadata2);
        aggregatorRepository.save(aggregatorEntity);
        aggregatorRepository.save(aggregatorEntity2);

        MetadataEntity metadata3 = new MetadataEntity();
        metadata3.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata3.setMetadataId(1L);
        metadata3.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity3 = new AggregatorEntity();
        aggregatorEntity3.setAggregatorAddress("42 Main St");
        aggregatorEntity3.setAggregatorIban("Aggregator Iban");
        aggregatorEntity3.setAggregatorName("Aggregator Name");
        aggregatorEntity3.setMetadata(metadata3);
        AggregatorEntity saveResult = aggregatorRepository.save(aggregatorEntity3);

        MetadataEntity metadata4 = new MetadataEntity();
        metadata4.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata4.setMetadataId(1L);
        metadata4.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity4 = new AggregatorEntity();
        aggregatorEntity4.setAggregatorAddress("42 Main St");
        aggregatorEntity4.setAggregatorIban("Aggregator Iban");
        aggregatorEntity4.setAggregatorName("Aggregator Name");
        aggregatorEntity4.setMetadata(metadata4);
        AggregatorEntity saveResult2 = aggregatorRepository.save(aggregatorEntity4);

        MetadataEntity metadata5 = new MetadataEntity();
        metadata5.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata5.setMetadataId(1L);
        metadata5.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        AggregatorEntity aggregatorEntity5 = new AggregatorEntity();
        aggregatorEntity5.setAggregatorAddress("42 Main St");
        aggregatorEntity5.setAggregatorIban("Aggregator Iban");
        aggregatorEntity5.setAggregatorName("Aggregator Name");
        aggregatorEntity5.setMetadata(metadata5);
        List<AggregatorEntity> entities = Arrays.asList(saveResult, saveResult2,
                aggregatorRepository.save(aggregatorEntity5));

        // Act
        aggregatorRepository.deleteAll(entities);
    }
}
