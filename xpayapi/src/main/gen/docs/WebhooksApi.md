# WebhooksApi

All URIs are relative to */api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**webhooksCreate**](WebhooksApi.md#webhooksCreate) | **POST** /webhooks/ | Create a new webhook.
[**webhooksDelete**](WebhooksApi.md#webhooksDelete) | **DELETE** /webhooks/{id}/ | Delete a webhook by ID.
[**webhooksList**](WebhooksApi.md#webhooksList) | **GET** /webhooks/ | List all webhooks.
[**webhooksPartialUpdate**](WebhooksApi.md#webhooksPartialUpdate) | **PATCH** /webhooks/{id}/ | Partially update a webhook by ID.
[**webhooksRead**](WebhooksApi.md#webhooksRead) | **GET** /webhooks/{id}/ | Retrieve an object by ID.
[**webhooksUpdate**](WebhooksApi.md#webhooksUpdate) | **PUT** /webhooks/{id}/ | Update a webhook by ID.


<a name="webhooksCreate"></a>
# **webhooksCreate**
> Webhook webhooksCreate(webhook)

Create a new webhook.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = WebhooksApi()
val webhook : Webhook =  // Webhook | 
try {
    val result : Webhook = apiInstance.webhooksCreate(webhook)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WebhooksApi#webhooksCreate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WebhooksApi#webhooksCreate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **webhook** | [**Webhook**](Webhook.md)|  |

### Return type

[**Webhook**](Webhook.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="webhooksDelete"></a>
# **webhooksDelete**
> webhooksDelete(id)

Delete a webhook by ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = WebhooksApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
try {
    apiInstance.webhooksDelete(id)
} catch (e: ClientException) {
    println("4xx response calling WebhooksApi#webhooksDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WebhooksApi#webhooksDelete")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="webhooksList"></a>
# **webhooksList**
> WebhooksList200Response webhooksList()

List all webhooks.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = WebhooksApi()
try {
    val result : WebhooksList200Response = apiInstance.webhooksList()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WebhooksApi#webhooksList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WebhooksApi#webhooksList")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**WebhooksList200Response**](WebhooksList200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="webhooksPartialUpdate"></a>
# **webhooksPartialUpdate**
> Webhook webhooksPartialUpdate(id, webhook)

Partially update a webhook by ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = WebhooksApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
val webhook : Webhook =  // Webhook | 
try {
    val result : Webhook = apiInstance.webhooksPartialUpdate(id, webhook)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WebhooksApi#webhooksPartialUpdate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WebhooksApi#webhooksPartialUpdate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |
 **webhook** | [**Webhook**](Webhook.md)|  |

### Return type

[**Webhook**](Webhook.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="webhooksRead"></a>
# **webhooksRead**
> Webhook webhooksRead(id)

Retrieve an object by ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = WebhooksApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
try {
    val result : Webhook = apiInstance.webhooksRead(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WebhooksApi#webhooksRead")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WebhooksApi#webhooksRead")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |

### Return type

[**Webhook**](Webhook.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="webhooksUpdate"></a>
# **webhooksUpdate**
> Webhook webhooksUpdate(id, webhook)

Update a webhook by ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = WebhooksApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
val webhook : Webhook =  // Webhook | 
try {
    val result : Webhook = apiInstance.webhooksUpdate(id, webhook)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WebhooksApi#webhooksUpdate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WebhooksApi#webhooksUpdate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |
 **webhook** | [**Webhook**](Webhook.md)|  |

### Return type

[**Webhook**](Webhook.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

