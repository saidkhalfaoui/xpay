# PublicKeyApi

All URIs are relative to */api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**publicKey**](PublicKeyApi.md#publicKey) | **GET** /public_key/ | Get a callback public key.


<a name="publicKey"></a>
# **publicKey**
> kotlin.String publicKey()

Get a callback public key.

Returns public key for authenticating company callback payloads

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PublicKeyApi()
try {
    val result : kotlin.String = apiInstance.publicKey()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PublicKeyApi#publicKey")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PublicKeyApi#publicKey")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**kotlin.String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

