package com.xpay.domainservice.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@ContextConfiguration(classes = {AggregatorEntity.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AggregatorEntityDiffblueTest {
    @Autowired
    private AggregatorEntity aggregatorEntity;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AggregatorEntity#AggregatorEntity()}
     *   <li>{@link AggregatorEntity#setAggregatorAddress(String)}
     *   <li>{@link AggregatorEntity#setAggregatorIban(String)}
     *   <li>{@link AggregatorEntity#setAggregatorId(Long)}
     *   <li>{@link AggregatorEntity#setAggregatorName(String)}
     *   <li>{@link AggregatorEntity#setMetadata(MetadataEntity)}
     *   <li>{@link AggregatorEntity#toString()}
     *   <li>{@link AggregatorEntity#getAggregatorAddress()}
     *   <li>{@link AggregatorEntity#getAggregatorIban()}
     *   <li>{@link AggregatorEntity#getAggregatorId()}
     *   <li>{@link AggregatorEntity#getAggregatorName()}
     *   <li>{@link AggregatorEntity#getMetadata()}
     * </ul>
     */
    @Test
    public void testGettersAndSetters() throws UnsupportedEncodingException {
        // Arrange and Act
        AggregatorEntity actualAggregatorEntity = new AggregatorEntity();
        actualAggregatorEntity.setAggregatorAddress("42 Main St");
        actualAggregatorEntity.setAggregatorIban("Aggregator Iban");
        actualAggregatorEntity.setAggregatorId(1L);
        actualAggregatorEntity.setAggregatorName("Aggregator Name");
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));
        actualAggregatorEntity.setMetadata(metadata);
        actualAggregatorEntity.toString();
        String actualAggregatorAddress = actualAggregatorEntity.getAggregatorAddress();
        String actualAggregatorIban = actualAggregatorEntity.getAggregatorIban();
        Long actualAggregatorId = actualAggregatorEntity.getAggregatorId();
        String actualAggregatorName = actualAggregatorEntity.getAggregatorName();
        MetadataEntity actualMetadata = actualAggregatorEntity.getMetadata();

        // Assert that nothing has changed
        assertEquals("42 Main St", actualAggregatorAddress);
        assertEquals("Aggregator Iban", actualAggregatorIban);
        assertEquals("Aggregator Name", actualAggregatorName);
        assertEquals(1L, actualAggregatorId.longValue());
        assertSame(metadata, actualMetadata);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link AggregatorEntity#AggregatorEntity(Long, String, String, String, MetadataEntity)}
     *   <li>{@link AggregatorEntity#setAggregatorAddress(String)}
     *   <li>{@link AggregatorEntity#setAggregatorIban(String)}
     *   <li>{@link AggregatorEntity#setAggregatorId(Long)}
     *   <li>{@link AggregatorEntity#setAggregatorName(String)}
     *   <li>{@link AggregatorEntity#setMetadata(MetadataEntity)}
     *   <li>{@link AggregatorEntity#toString()}
     *   <li>{@link AggregatorEntity#getAggregatorAddress()}
     *   <li>{@link AggregatorEntity#getAggregatorIban()}
     *   <li>{@link AggregatorEntity#getAggregatorId()}
     *   <li>{@link AggregatorEntity#getAggregatorName()}
     *   <li>{@link AggregatorEntity#getMetadata()}
     * </ul>
     */
    @Test
    public void testGettersAndSetters2() throws UnsupportedEncodingException {
        // Arrange
        MetadataEntity metadata = new MetadataEntity();
        metadata.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata.setMetadataId(1L);
        metadata.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));

        // Act
        AggregatorEntity actualAggregatorEntity = new AggregatorEntity(1L, "Aggregator Name", "42 Main St",
                "Aggregator Iban", metadata);
        actualAggregatorEntity.setAggregatorAddress("42 Main St");
        actualAggregatorEntity.setAggregatorIban("Aggregator Iban");
        actualAggregatorEntity.setAggregatorId(1L);
        actualAggregatorEntity.setAggregatorName("Aggregator Name");
        MetadataEntity metadata2 = new MetadataEntity();
        metadata2.setMetadata("AXAXAXAX".getBytes("UTF-8"));
        metadata2.setMetadataId(1L);
        metadata2.setTransactionFlows("AXAXAXAX".getBytes("UTF-8"));
        actualAggregatorEntity.setMetadata(metadata2);
        actualAggregatorEntity.toString();
        String actualAggregatorAddress = actualAggregatorEntity.getAggregatorAddress();
        String actualAggregatorIban = actualAggregatorEntity.getAggregatorIban();
        Long actualAggregatorId = actualAggregatorEntity.getAggregatorId();
        String actualAggregatorName = actualAggregatorEntity.getAggregatorName();
        MetadataEntity actualMetadata = actualAggregatorEntity.getMetadata();

        // Assert that nothing has changed
        assertEquals("42 Main St", actualAggregatorAddress);
        assertEquals("Aggregator Iban", actualAggregatorIban);
        assertEquals("Aggregator Name", actualAggregatorName);
        assertEquals(1L, actualAggregatorId.longValue());
        assertEquals(metadata, actualMetadata);
        assertSame(metadata2, actualMetadata);
    }

    /**
     * Method under test:
     * {@link AggregatorEntity#AggregatorEntity(AggregatorEntity.AggregatorEntityBuilder)}
     */
    @Test
    public void testNewAggregatorEntity() {
        // Arrange and Act
        AggregatorEntity actualAggregatorEntity = new AggregatorEntity(
                mock(AggregatorEntity.AggregatorEntityBuilder.class));

        // Assert
        assertNull(actualAggregatorEntity.getMetadata());
        assertNull(actualAggregatorEntity.getAggregatorId());
        assertNull(actualAggregatorEntity.getAggregatorAddress());
        assertNull(actualAggregatorEntity.getAggregatorIban());
        assertNull(actualAggregatorEntity.getAggregatorName());
    }
}
