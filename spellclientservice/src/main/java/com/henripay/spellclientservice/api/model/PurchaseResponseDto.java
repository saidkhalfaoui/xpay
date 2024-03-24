package com.henripay.spellclientservice.api.model;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PurchaseResponseDto {
    private String status;
    private String companyId;
    private String userId;
    private String brandId;
    private String clientId;
    private boolean isRecurringToken;
    private String recurringToken;
    private String issued;
    private Long due;
    private String refundAvailability;
    private String successRedirect;
    private String failureRedirect;
    private boolean markedAsPaid;
    private String platform;
    private String product;
    private String invoiceUrl;
    private String checkoutUrl;
    private String directPostUrl;
    private Long createdOn;
    private Long updatedOn;
    private String type;
    private String id;
}