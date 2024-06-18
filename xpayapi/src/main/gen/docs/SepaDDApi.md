# SepaDDApi

All URIs are relative to */api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**collectionPost**](SepaDDApi.md#collectionPost) | **POST** /collection/ | create a new mandate
[**mandateIdGet**](SepaDDApi.md#mandateIdGet) | **GET** /mandate/{id} | Retrieve mandate information


<a name="collectionPost"></a>
# **collectionPost**
> Collectioninformation collectionPost(collectioninformation)

create a new mandate

used for Sepa DD to create a new mandate for a merchant

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = SepaDDApi()
val collectioninformation : Collectioninformation =  // Collectioninformation | 
try {
    val result : Collectioninformation = apiInstance.collectionPost(collectioninformation)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SepaDDApi#collectionPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SepaDDApi#collectionPost")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **collectioninformation** | [**Collectioninformation**](Collectioninformation.md)|  |

### Return type

[**Collectioninformation**](Collectioninformation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="mandateIdGet"></a>
# **mandateIdGet**
> kotlin.collections.List&lt;Mandateinformation&gt; mandateIdGet(id)

Retrieve mandate information

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = SepaDDApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
try {
    val result : kotlin.collections.List<Mandateinformation> = apiInstance.mandateIdGet(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SepaDDApi#mandateIdGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SepaDDApi#mandateIdGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |

### Return type

[**kotlin.collections.List&lt;Mandateinformation&gt;**](Mandateinformation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

