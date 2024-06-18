
# PaymentDetails

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**isOutgoing** | **kotlin.Boolean** | Denotes the direction of payment, e.g. for a paid Purchase, is granted to be &#x60;false&#x60;, &#x60;true&#x60; for payouts. |  [optional]
**paymentType** | [**inline**](#PaymentType) |  |  [optional] [readonly]
**amount** | **kotlin.Int** | Amount of money as the smallest indivisible units of the currency. Examples: 1 cent for EUR and 1 Yen for JPY. |  [optional]
**currency** | **kotlin.String** | Currency code in the ISO 4217 standard (e.g. &#39;EUR&#39;).  Default currency is &#x60;EUR&#x60;. |  [optional]
**netAmount** | **kotlin.Int** |  |  [optional] [readonly]
**feeAmount** | **kotlin.Int** |  |  [optional] [readonly]
**pendingAmount** | **kotlin.Int** |  |  [optional] [readonly]
**pendingUnfreezeOn** | **kotlin.Int** |  |  [optional] [readonly]
**description** | **kotlin.String** |  |  [optional]
**paidOn** | **kotlin.Int** |  |  [optional] [readonly]
**remotePaidOn** | **kotlin.Int** |  |  [optional] [readonly]


<a name="PaymentType"></a>
## Enum: payment_type
Name | Value
---- | -----
paymentType | purchase, purchase_charge, payout, bank_payment, refund, custom



