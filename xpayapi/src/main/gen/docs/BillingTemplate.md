
# BillingTemplate

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**purchase** | [**PurchaseDetails**](PurchaseDetails.md) |  | 
**isSubscription** | **kotlin.Boolean** |  | 
**companyId** | [**java.util.UUID**](java.util.UUID.md) |  |  [optional] [readonly]
**numberOfBillingCycles** | **kotlin.Int** | Limits number of billing cycles for each client if set to a non-zero value |  [optional]
**isTest** | **kotlin.Boolean** | Indicates this is a test object, created using test API keys or using Billing section of UI while in test mode. |  [optional] [readonly]
**userId** | [**java.util.UUID**](java.util.UUID.md) | ID of user who has created this object in the Billing UI, if applicable. |  [optional] [readonly]
**brandId** | [**java.util.UUID**](java.util.UUID.md) | ID of the brand to create this BillingTemplate for. You can copy it down in the API section, see the specify the ID of the Brand link in answer to How to setup payments on website or in mobile app. |  [optional]
**title** | **kotlin.String** |  |  [optional]
**invoiceIssued** | **kotlin.String** |  |  [optional]
**invoiceDue** | **kotlin.Int** |  |  [optional]
**invoiceSkipCapture** | **kotlin.Boolean** |  |  [optional]
**invoiceSendReceipt** | **kotlin.Boolean** |  |  [optional]
**subscriptionPeriod** | **kotlin.Long** |  |  [optional]
**subscriptionPeriodUnits** | [**PeriodUnits**](PeriodUnits.md) | See &#x60;subscription_period&#x60;. |  [optional]
**subscriptionDuePeriod** | **kotlin.Long** |  |  [optional]
**subscriptionDuePeriodUnits** | [**PeriodUnits**](PeriodUnits.md) | See &#x60;subscription_due_period&#x60;. |  [optional]
**subscriptionChargePeriodEnd** | **kotlin.Boolean** |  |  [optional]
**subscriptionTrialPeriods** | **kotlin.Long** |  |  [optional]
**subscriptionActive** | **kotlin.Boolean** |  |  [optional]
**subscriptionHasActiveClients** | **kotlin.Boolean** |  |  [optional] [readonly]
**forceRecurring** | **kotlin.Boolean** |  |  [optional]
**upsellCampaigns** | [**kotlin.collections.List&lt;java.util.UUID&gt;**](java.util.UUID.md) | Array of IDs of related Upsell campaigns. |  [optional]
**referralCampaignId** | [**java.util.UUID**](java.util.UUID.md) | ID of Referral campaign. |  [optional]
**type** | **kotlin.String** | Object type identifier |  [optional] [readonly]
**id** | [**java.util.UUID**](java.util.UUID.md) |  |  [optional] [readonly]
**createdOn** | **kotlin.Int** | Object creation time |  [optional] [readonly]
**updatedOn** | **kotlin.Int** | Object last modification time |  [optional] [readonly]



