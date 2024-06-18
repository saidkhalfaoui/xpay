# AccountApi

All URIs are relative to */api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**balance**](AccountApi.md#balance) | **GET** /account/json/balance/ | Get company balance.
[**turnover**](AccountApi.md#turnover) | **GET** /account/json/turnover/ | Get company turnover.


<a name="balance"></a>
# **balance**
> kotlin.collections.Map&lt;kotlin.String, Balance&gt; balance(tokenized, from, brand, terminalUid, currency, paymentMethod, product, flow, country)

Get company balance.

Returns the company balance according to the provided query string filters. Multiple values can be provided for all filters except from and to, including all results matching any of these values.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = AccountApi()
val tokenized : kotlin.Boolean = true // kotlin.Boolean | 
val from : kotlin.Int = 56 // kotlin.Int | Retrieve a past balance value at a specific Unix timestamp
val brand : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Filter result set to only include the specified brand UUID(s)
val terminalUid : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Filter result set to only include the specified terminal UUID(s)
val currency : kotlin.String = currency_example // kotlin.String | Filter result set to only include specified currency(ies)
val paymentMethod : PaymentMethod =  // PaymentMethod | Filter result set to only include specified payment methods(s). See <a href=\"#model-PaymentMethod\">PaymentMethod<a> fro more information.
val product : TransactionProduct =  // TransactionProduct | Filter result set to only include specified products(s). See <a href=\"#model-TransactionProduct\">TransactionProduct<a> fro more information.
val flow : TransactionFlow =  // TransactionFlow | Filter result set to only include specified transaction creation or execution flow(s). See <a href=\"#model-TransactionFlow\">TransactionFlow<a> fro more information.
val country : kotlin.String = country_example // kotlin.String | Filter result set to only include specified client country(ies) in ISO 3166-1 alpha-2 format
try {
    val result : kotlin.collections.Map<kotlin.String, Balance> = apiInstance.balance(tokenized, from, brand, terminalUid, currency, paymentMethod, product, flow, country)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountApi#balance")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountApi#balance")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tokenized** | **kotlin.Boolean**|  | [optional]
 **from** | **kotlin.Int**| Retrieve a past balance value at a specific Unix timestamp | [optional]
 **brand** | **java.util.UUID**| Filter result set to only include the specified brand UUID(s) | [optional]
 **terminalUid** | **java.util.UUID**| Filter result set to only include the specified terminal UUID(s) | [optional]
 **currency** | **kotlin.String**| Filter result set to only include specified currency(ies) | [optional]
 **paymentMethod** | [**PaymentMethod**](.md)| Filter result set to only include specified payment methods(s). See &lt;a href&#x3D;\&quot;#model-PaymentMethod\&quot;&gt;PaymentMethod&lt;a&gt; fro more information. | [optional] [enum: unknown]
 **product** | [**TransactionProduct**](.md)| Filter result set to only include specified products(s). See &lt;a href&#x3D;\&quot;#model-TransactionProduct\&quot;&gt;TransactionProduct&lt;a&gt; fro more information. | [optional] [enum: bank_payment, chargeback, custom_payment, invoice, purchase, refund, subscription]
 **flow** | [**TransactionFlow**](.md)| Filter result set to only include specified transaction creation or execution flow(s). See &lt;a href&#x3D;\&quot;#model-TransactionFlow\&quot;&gt;TransactionFlow&lt;a&gt; fro more information. | [optional] [enum: api, direct_post, fluentforms, formidableforms, givewp, gravityforms, hostbill, import, link, magento, opencart, payform, paymattic, prestashop, server_to_server, shopify, web_office, whmcs, woocommerce, woocommerce_subscriptions, wpcharitable, wpfunnels]
 **country** | **kotlin.String**| Filter result set to only include specified client country(ies) in ISO 3166-1 alpha-2 format | [optional]

### Return type

[**kotlin.collections.Map&lt;kotlin.String, Balance&gt;**](Balance.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="turnover"></a>
# **turnover**
> TurnoverPair turnover(tokenized, from, to, brand, terminalUid, currency, paymentMethod, product, flow, country)

Get company turnover.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = AccountApi()
val tokenized : kotlin.Boolean = true // kotlin.Boolean | 
val from : kotlin.Int = 56 // kotlin.Int | Filter result set to only include values older or equal to the provided Unix timestamp
val to : kotlin.Int = 56 // kotlin.Int | Filter result set to only include values younger than the provided Unix timestamp
val brand : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Filter result set to only include the specified brand UUID(s)
val terminalUid : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Filter result set to only include the specified terminal UUID(s)
val currency : kotlin.String = currency_example // kotlin.String | Filter result set to only include specified currency(ies)
val paymentMethod : PaymentMethod =  // PaymentMethod | Filter result set to only include specified payment methods(s). See <a href=\"#model-PaymentMethod\">PaymentMethod<a> fro more information.
val product : TransactionProduct =  // TransactionProduct | Filter result set to only include specified products(s). See <a href=\"#model-TransactionProduct\">TransactionProduct<a> fro more information.
val flow : TransactionFlow =  // TransactionFlow | Filter result set to only include specified transaction creation or execution flow(s). See <a href=\"#model-TransactionFlow\">TransactionFlow<a> fro more information.
val country : kotlin.String = country_example // kotlin.String | Filter result set to only include specified client country(ies) in ISO 3166-1 alpha-2 format
try {
    val result : TurnoverPair = apiInstance.turnover(tokenized, from, to, brand, terminalUid, currency, paymentMethod, product, flow, country)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountApi#turnover")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountApi#turnover")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tokenized** | **kotlin.Boolean**|  | [optional]
 **from** | **kotlin.Int**| Filter result set to only include values older or equal to the provided Unix timestamp | [optional]
 **to** | **kotlin.Int**| Filter result set to only include values younger than the provided Unix timestamp | [optional]
 **brand** | **java.util.UUID**| Filter result set to only include the specified brand UUID(s) | [optional]
 **terminalUid** | **java.util.UUID**| Filter result set to only include the specified terminal UUID(s) | [optional]
 **currency** | **kotlin.String**| Filter result set to only include specified currency(ies) | [optional]
 **paymentMethod** | [**PaymentMethod**](.md)| Filter result set to only include specified payment methods(s). See &lt;a href&#x3D;\&quot;#model-PaymentMethod\&quot;&gt;PaymentMethod&lt;a&gt; fro more information. | [optional] [enum: unknown]
 **product** | [**TransactionProduct**](.md)| Filter result set to only include specified products(s). See &lt;a href&#x3D;\&quot;#model-TransactionProduct\&quot;&gt;TransactionProduct&lt;a&gt; fro more information. | [optional] [enum: bank_payment, chargeback, custom_payment, invoice, purchase, refund, subscription]
 **flow** | [**TransactionFlow**](.md)| Filter result set to only include specified transaction creation or execution flow(s). See &lt;a href&#x3D;\&quot;#model-TransactionFlow\&quot;&gt;TransactionFlow&lt;a&gt; fro more information. | [optional] [enum: api, direct_post, fluentforms, formidableforms, givewp, gravityforms, hostbill, import, link, magento, opencart, payform, paymattic, prestashop, server_to_server, shopify, web_office, whmcs, woocommerce, woocommerce_subscriptions, wpcharitable, wpfunnels]
 **country** | **kotlin.String**| Filter result set to only include specified client country(ies) in ISO 3166-1 alpha-2 format | [optional]

### Return type

[**TurnoverPair**](TurnoverPair.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

