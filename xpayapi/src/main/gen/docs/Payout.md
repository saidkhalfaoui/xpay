
# Payout

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**payment** | [**PaymentDetails**](PaymentDetails.md) |  | 
**client** | [**ClientDetails**](ClientDetails.md) |  | 
**brandId** | [**java.util.UUID**](java.util.UUID.md) | ID of the brand to create this Payout for. You can copy it down in the API section, see the \&quot;specify the ID of the Brand\&quot; link in answer to \&quot;How to setup payments on website or in mobile app?\&quot;. | 
**transactionData** | [**kotlin.Any**](kotlin.Any.md) |  |  [optional] [readonly]
**referenceGenerated** | **kotlin.String** | If you don&#39;t provide an invoice &#x60;reference&#x60; yourself, this autogenerated value will be used as a reference instead. |  [optional] [readonly]
**reference** | **kotlin.String** | Payout reference. |  [optional]
**status** | [**PayoutStatus**](PayoutStatus.md) |  |  [optional]
**statusHistory** | [**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md) | History of status changes, latest last. |  [optional] [readonly]
**senderName** | **kotlin.String** | Name of payout sender. |  [optional]
**recipientCardCountry** | **kotlin.String** | Recipient&#39;s card&#39;s registration country. Country code in the ISO 3166-1 alpha-2 format (e.g. &#x60;GB&#x60;). |  [optional] [readonly]
**recipientCardBrand** | **kotlin.String** | Recipient&#39;s card&#39;s brand, e.g. &#x60;visa&#x60; or &#x60;mastercard&#x60;. |  [optional] [readonly]
**executionUrl** | **kotlin.String** | URL that must be used for payout execution. See details in description. |  [optional] [readonly]
**companyId** | [**java.util.UUID**](java.util.UUID.md) |  |  [optional] [readonly]
**isTest** | **kotlin.Boolean** | Indicates this is a test object, created using test API keys or using Billing section of UI while in test mode. |  [optional] [readonly]
**userId** | [**java.util.UUID**](java.util.UUID.md) | ID of user who has created this object in the Billing UI, if applicable. |  [optional] [readonly]
**type** | **kotlin.String** | Object type identifier |  [optional] [readonly]
**id** | [**java.util.UUID**](java.util.UUID.md) |  |  [optional] [readonly]
**createdOn** | **kotlin.Int** | Object creation time |  [optional] [readonly]
**updatedOn** | **kotlin.Int** | Object last modification time |  [optional] [readonly]


