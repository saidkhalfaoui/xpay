
# Purchase

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**client** | [**ClientDetails**](ClientDetails.md) | Either this or &#x60;.client_id&#x60; is required. | 
**purchase** | [**PurchaseDetails**](PurchaseDetails.md) |  | 
**brandId** | [**java.util.UUID**](java.util.UUID.md) | ID of the brand to create this Purchase for. You can copy it down in the API section, see the \&quot;specify the ID of the Brand\&quot; link in answer to \&quot;How to setup payments on website or in mobile app?\&quot;. | 
**payment** | [**PaymentDetails**](PaymentDetails.md) |  |  [optional] [readonly]
**issuerDetails** | [**IssuerDetails**](IssuerDetails.md) |  |  [optional] [readonly]
**transactionData** | [**kotlin.Any**](kotlin.Any.md) | Payment method-specific, read-only transaction data. Will contain information about all the transaction attempts and possible errors, if available. |  [optional] [readonly]
**status** | [**PurchaseStatus**](PurchaseStatus.md) |  |  [optional]
**statusHistory** | [**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md) | History of status changes, latest last. Might contain entry about a related object, e.g. status change to &#x60;refunded&#x60; will contain a reference to the refund Payment. |  [optional] [readonly]
**viewedOn** | **kotlin.Int** | Time the payment form or invoice page was first viewed on |  [optional] [readonly]
**companyId** | [**java.util.UUID**](java.util.UUID.md) |  |  [optional] [readonly]
**isTest** | **kotlin.Boolean** | Indicates this is a test object, created using test API keys or using Billing section of UI while in test mode. |  [optional] [readonly]
**userId** | [**java.util.UUID**](java.util.UUID.md) | ID of user who has created this object in the Billing UI, if applicable. |  [optional] [readonly]
**billingTemplateId** | [**java.util.UUID**](java.util.UUID.md) | ID of a BillingTemplate that has spawned this Purchase, if any. |  [optional] [readonly]
**clientId** | [**java.util.UUID**](java.util.UUID.md) |  |  [optional]
**sendReceipt** | **kotlin.Boolean** | Whether to send receipt email for this Purchase when it&#39;s paid. |  [optional]
**isRecurringToken** | **kotlin.Boolean** |  |  [optional] [readonly]
**recurringToken** | [**java.util.UUID**](java.util.UUID.md) |  |  [optional] [readonly]
**skipCapture** | **kotlin.Boolean** |  |  [optional]
**forceRecurring** | **kotlin.Boolean** |  |  [optional]
**referenceGenerated** | **kotlin.String** |  |  [optional] [readonly]
**reference** | **kotlin.String** | Invoice reference. |  [optional]
**issued** | **kotlin.String** |  |  [optional]
**due** | **kotlin.Int** |  |  [optional]
**refundAvailability** | [**inline**](#RefundAvailability) |  |  [optional] [readonly]
**refundableAmount** | **kotlin.Int** |  |  [optional] [readonly]
**currencyConversion** | [**kotlin.Any**](kotlin.Any.md) |  |  [optional] [readonly]
**paymentMethodWhitelist** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional]
**successRedirect** | **kotlin.String** |  |  [optional]
**failureRedirect** | **kotlin.String** |  |  [optional]
**cancelRedirect** | **kotlin.String** |  |  [optional]
**successCallback** | **kotlin.String** | When Purchase is paid for successfully, the &#x60;success_callback&#x60; URL will receive a POST request with the Purchase object&#39;s data in body. |  [optional]
**creatorAgent** | **kotlin.String** | Identification of software (e.g. an ecommerce module and version) used to create this purchase, if any. |  [optional]
**platform** | [**inline**](#Platform) | Platform this Purchase was created on. |  [optional]
**product** | [**inline**](#Product) | Defines which gateway product was used to create this Purchase. |  [optional] [readonly]
**createdFromIp** | **kotlin.String** | IP the Purchase was created from. |  [optional] [readonly]
**invoiceUrl** | **kotlin.String** | URL you will be able to access invoice for this Purchase at, if applicable |  [optional] [readonly]
**checkoutUrl** | **kotlin.String** |  |  [optional] [readonly]
**directPostUrl** | **kotlin.String** |  |  [optional] [readonly]
**markedAsPaid** | **kotlin.Boolean** | True if a purchase was manually marked as paid. |  [optional] [readonly]
**orderId** | **kotlin.String** | ID of corresponding order. |  [optional] [readonly]
**upsellCampaigns** | [**kotlin.collections.List&lt;java.util.UUID&gt;**](java.util.UUID.md) | Array of IDs of related Upsell campaigns. |  [optional]
**referralCampaignId** | [**java.util.UUID**](java.util.UUID.md) | ID of Referral campaign. |  [optional]
**referralCode** | **kotlin.String** | Referral code used with purchase. |  [optional] [readonly]
**referralCodeGenerated** | **kotlin.String** | Referral code created by purchase. |  [optional] [readonly]
**referralCodeDetails** | [**kotlin.Any**](kotlin.Any.md) | Referral code detailed information for purchase. |  [optional] [readonly]
**retainLevelDetails** | [**kotlin.Any**](kotlin.Any.md) | Retain level detailed information for purchase. |  [optional] [readonly]
**type** | **kotlin.String** | Object type identifier |  [optional] [readonly]
**id** | [**java.util.UUID**](java.util.UUID.md) |  |  [optional] [readonly]
**createdOn** | **kotlin.Int** | Object creation time |  [optional] [readonly]
**updatedOn** | **kotlin.Int** | Object last modification time |  [optional] [readonly]


<a name="RefundAvailability"></a>
## Enum: refund_availability
Name | Value
---- | -----
refundAvailability | all, full_only, partial_only, pis_all, pis_partial, none


<a name="Platform"></a>
## Enum: platform
Name | Value
---- | -----
platform | web, api, ios, android, macos, windows


<a name="Product"></a>
## Enum: product
Name | Value
---- | -----
product | purchases, billing_invoices, billing_subscriptions, billing_subscriptions_invoice



