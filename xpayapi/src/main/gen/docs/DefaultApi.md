# DefaultApi

All URIs are relative to */api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**collectionIdGet**](DefaultApi.md#collectionIdGet) | **GET** /collection/{id} | Retrieve sepadd collection information
[**mandatePost**](DefaultApi.md#mandatePost) | **POST** /mandate/ | create a new mandate


<a name="collectionIdGet"></a>
# **collectionIdGet**
> kotlin.collections.List&lt;Collectioninformation&gt; collectionIdGet(id)

Retrieve sepadd collection information

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
try {
    val result : kotlin.collections.List<Collectioninformation> = apiInstance.collectionIdGet(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#collectionIdGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#collectionIdGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |

### Return type

[**kotlin.collections.List&lt;Collectioninformation&gt;**](Collectioninformation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="mandatePost"></a>
# **mandatePost**
> kotlin.collections.List&lt;kotlin.String&gt; mandatePost(mandateinformation)

create a new mandate

used for Sepa DD to create a new mandate for a merchant

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val mandateinformation : Mandateinformation =  // Mandateinformation | 
try {
    val result : kotlin.collections.List<kotlin.String> = apiInstance.mandatePost(mandateinformation)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#mandatePost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#mandatePost")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **mandateinformation** | [**Mandateinformation**](Mandateinformation.md)|  |

### Return type

**kotlin.collections.List&lt;kotlin.String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

