
# PaymentMethods200Response

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**availablePaymentMethods** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional]
**byCountry** | [**PaymentMethods200ResponseByCountry**](PaymentMethods200ResponseByCountry.md) |  |  [optional]
**countryNames** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** | Human-readable names corresponding to country codes as returned by &#x60;by_country&#x60; property. &#x60;any&#x60; code is also decoded to &#x60;Other&#x60;. |  [optional]
**names** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** | Human-readable names of payment methods as returned by &#x60;available_payment_methods&#x60; property. |  [optional]
**logos** | [**kotlin.collections.Map&lt;kotlin.String, PaymentMethods200ResponseLogosValue&gt;**](PaymentMethods200ResponseLogosValue.md) | Mapping of payment method names to respective logo file paths (relative to the hostname of API host). Some methods can be displayed as an array of logos. |  [optional]
**cardMethods** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional]



