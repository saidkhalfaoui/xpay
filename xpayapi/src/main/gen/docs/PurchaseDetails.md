
# PurchaseDetails

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**products** | [**kotlin.collections.List&lt;Product&gt;**](Product.md) | Line items of the invoice. In case of a transaction with no invoice sent, specify a single Product forming the cost of transaction. | 
**currency** | **kotlin.String** | Currency code in the ISO 4217 standard (e.g. &#39;EUR&#39;).  Default currency is &#x60;EUR&#x60;. |  [optional]
**total** | **kotlin.Int** |  |  [optional] [readonly]
**language** | **kotlin.String** | Language code in the ISO 639-1 format (e.g. &#39;en&#39;) |  [optional]
**notes** | **kotlin.String** |  |  [optional]
**debt** | **kotlin.Int** |  |  [optional]
**subtotalOverride** | **kotlin.Int** |  |  [optional]
**totalTaxOverride** | **kotlin.Int** |  |  [optional]
**totalDiscountOverride** | **kotlin.Int** |  |  [optional]
**totalOverride** | **kotlin.Int** |  |  [optional]
**requestClientDetails** | [**inline**](#kotlin.collections.Set&lt;RequestClientDetails&gt;) | ClientDetails fields to request from the client before the payment. If a value is passed for a field in ClientDetails, it will be automatically removed from this list. |  [optional]
**timezone** | **kotlin.String** | Timezone to localize invoice-specific timestamps in, e.g. to display a concrete date for a &#x60;due&#x60; timestamp on the invoice. |  [optional]
**dueStrict** | **kotlin.Boolean** |  |  [optional]
**emailMessage** | **kotlin.String** | An optional message to display to your customer in invoice email, e.g. \&quot;Your invoice for June\&quot;. |  [optional] [readonly]


<a name="kotlin.collections.Set<RequestClientDetails>"></a>
## Enum: request_client_details
Name | Value
---- | -----
requestClientDetails | email, phone, full_name, personal_code, brand_name, legal_name, registration_number, tax_number, bank_account, bank_code, billing_address, shipping_address



