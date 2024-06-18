# PaymentMethodsApi

All URIs are relative to */api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**paymentMethods**](PaymentMethodsApi.md#paymentMethods) | **GET** /payment_methods/ | Get the list of payment methods available for your purchase.


<a name="paymentMethods"></a>
# **paymentMethods**
> PaymentMethods200Response paymentMethods(brandId, currency, country, recurring, skipCapture, preauthorization, language)

Get the list of payment methods available for your purchase.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PaymentMethodsApi()
val brandId : kotlin.String = brandId_example // kotlin.String | Which brand would you like to lookup the available payment methods for. Use the same value (UUID) you'd set the `Purchase.brand_id` to.
val currency : kotlin.String = currency_example // kotlin.String | Currency you'd use in your Purchase in ISO 4217 format, e.g. `EUR`.
val country : kotlin.String = country_example // kotlin.String | Country code in the ISO 3166-1 alpha-2 format (e.g. `GB`). Optional.
val recurring : kotlin.Boolean = true // kotlin.Boolean | If provided in the format of `recurring=true`, will filter out the methods that don't support recurring charges (see `POST /purchases/{id}/charge/`).
val skipCapture : kotlin.Boolean = true // kotlin.Boolean | If provided in the format of `skip_capture=true`, will filter out the methods that don't support `skip_capture` functionality (see the description for `Purchase.skip_capture field`).
val preauthorization : kotlin.Boolean = true // kotlin.Boolean | If provided in the format of `preauthorization=true`, will filter out the methods that don't support preauthorization functionality (see the description for `Purchase.skip_capture field`).
val language : kotlin.String = language_example // kotlin.String | Language code in the ISO 639-1 format (e.g. 'en'). Optional.
try {
    val result : PaymentMethods200Response = apiInstance.paymentMethods(brandId, currency, country, recurring, skipCapture, preauthorization, language)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PaymentMethodsApi#paymentMethods")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PaymentMethodsApi#paymentMethods")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **brandId** | **kotlin.String**| Which brand would you like to lookup the available payment methods for. Use the same value (UUID) you&#39;d set the &#x60;Purchase.brand_id&#x60; to. |
 **currency** | **kotlin.String**| Currency you&#39;d use in your Purchase in ISO 4217 format, e.g. &#x60;EUR&#x60;. |
 **country** | **kotlin.String**| Country code in the ISO 3166-1 alpha-2 format (e.g. &#x60;GB&#x60;). Optional. | [optional]
 **recurring** | **kotlin.Boolean**| If provided in the format of &#x60;recurring&#x3D;true&#x60;, will filter out the methods that don&#39;t support recurring charges (see &#x60;POST /purchases/{id}/charge/&#x60;). | [optional]
 **skipCapture** | **kotlin.Boolean**| If provided in the format of &#x60;skip_capture&#x3D;true&#x60;, will filter out the methods that don&#39;t support &#x60;skip_capture&#x60; functionality (see the description for &#x60;Purchase.skip_capture field&#x60;). | [optional]
 **preauthorization** | **kotlin.Boolean**| If provided in the format of &#x60;preauthorization&#x3D;true&#x60;, will filter out the methods that don&#39;t support preauthorization functionality (see the description for &#x60;Purchase.skip_capture field&#x60;). | [optional]
 **language** | **kotlin.String**| Language code in the ISO 639-1 format (e.g. &#39;en&#39;). Optional. | [optional]

### Return type

[**PaymentMethods200Response**](PaymentMethods200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

