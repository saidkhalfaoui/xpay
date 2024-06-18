
# BillingTemplateClient

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**clientId** | [**java.util.UUID**](java.util.UUID.md) | ID of the Client object to add to the BillingTemplate. Read-only after the BillingTemplateClient has been created. Note that the same Client can be added to a BillingTemplate several times. | 
**numberOfBillingCyclesPassed** | **kotlin.Int** | Only used together with number_of_billing_cycles on BillingTemplate. Shows number of billing cycles passed when number of cycles is limited |  [optional] [readonly]
**invoiceReference** | **kotlin.String** | When present overrides reference for invoices generated for this client |  [optional]
**status** | [**inline**](#Status) |  |  [optional]
**subscriptionBillingScheduledOn** | **kotlin.String** | If not null, reports the date when the next billing is scheduled for this client. |  [optional] [readonly]
**paymentMethodWhitelist** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional]
**sendInvoiceOnChargeFailure** | **kotlin.Boolean** | Sends invoice when subscription charge fails if this is &#x60;true&#x60; |  [optional]
**sendInvoiceOnAddSubscriber** | **kotlin.Boolean** |  |  [optional]
**sendReceipt** | **kotlin.Boolean** | Sends receipt when subscription charge succeeds if this is &#x60;true&#x60; |  [optional]
**type** | **kotlin.String** | Object type identifier |  [optional] [readonly]
**id** | [**java.util.UUID**](java.util.UUID.md) |  |  [optional] [readonly]
**createdOn** | **kotlin.Int** | Object creation time |  [optional] [readonly]
**updatedOn** | **kotlin.Int** | Object last modification time |  [optional] [readonly]


<a name="Status"></a>
## Enum: status
Name | Value
---- | -----
status | pending, inactive, active, subscription_paused



