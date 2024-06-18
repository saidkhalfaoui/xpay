
# Payment

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**client** | [**ClientDetails**](ClientDetails.md) |  |  [optional] [readonly]
**payment** | [**PaymentDetails**](PaymentDetails.md) |  |  [optional] [readonly]
**transactionData** | [**kotlin.Any**](.md) | Payment method-specific, read-only, internal transaction data. Will contain information about all the transaction attempts, if available. |  [optional] [readonly]
**relatedTo** | [**kotlin.Any**](kotlin.Any.md) |  |  [optional] [readonly]
**referenceGenerated** | **kotlin.String** |  |  [optional] [readonly]
**reference** | **kotlin.String** | Invoice reference. |  [optional] [readonly]
**accountId** | [**java.util.UUID**](java.util.UUID.md) | ID of an account this Payment is associated with. |  [optional] [readonly]
**companyId** | [**java.util.UUID**](java.util.UUID.md) |  |  [optional] [readonly]
**isTest** | **kotlin.Boolean** |  |  [optional] [readonly]
**userId** | [**java.util.UUID**](java.util.UUID.md) | ID of user who has created this object in the Billing UI, if applicable. |  [optional] [readonly]
**brandId** | [**java.util.UUID**](java.util.UUID.md) | ID of the brand this Payment is associated with. |  [optional] [readonly]
**type** | **kotlin.String** | Object type identifier |  [optional] [readonly]
**id** | [**java.util.UUID**](java.util.UUID.md) |  |  [optional] [readonly]
**createdOn** | **kotlin.Int** | Object creation time |  [optional] [readonly]
**updatedOn** | **kotlin.Int** | Object last modification time |  [optional] [readonly]



