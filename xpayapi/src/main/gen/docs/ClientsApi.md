# ClientsApi

All URIs are relative to */api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**clientRecurringTokensDelete**](ClientsApi.md#clientRecurringTokensDelete) | **DELETE** /clients/{id}/recurring_tokens2/ | Delete a client recurring token by ID.
[**clientRecurringTokensList**](ClientsApi.md#clientRecurringTokensList) | **GET** /clients/{id}/recurring_tokens/ | List recurring tokens saved for a client.
[**clientRecurringTokensRead**](ClientsApi.md#clientRecurringTokensRead) | **GET** /clients/{id}/recurring_tokens2/ | Retrieve an object by ID.
[**clientsCreate**](ClientsApi.md#clientsCreate) | **POST** /clients/ | Create a new client.
[**clientsDelete**](ClientsApi.md#clientsDelete) | **DELETE** /clients/{id}/ | Delete a client by ID.
[**clientsList**](ClientsApi.md#clientsList) | **GET** /clients/ | List all clients.
[**clientsPartialUpdate**](ClientsApi.md#clientsPartialUpdate) | **PATCH** /clients/{id}/ | Partially update a client by ID.
[**clientsRead**](ClientsApi.md#clientsRead) | **GET** /clients/{id}/ | Retrieve an object by ID.
[**clientsUpdate**](ClientsApi.md#clientsUpdate) | **PUT** /clients/{id}/ | Update a client by ID.


<a name="clientRecurringTokensDelete"></a>
# **clientRecurringTokensDelete**
> clientRecurringTokensDelete(id)

Delete a client recurring token by ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientsApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
try {
    apiInstance.clientRecurringTokensDelete(id)
} catch (e: ClientException) {
    println("4xx response calling ClientsApi#clientRecurringTokensDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientsApi#clientRecurringTokensDelete")
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

<a name="clientRecurringTokensList"></a>
# **clientRecurringTokensList**
> ClientRecurringTokensList200Response clientRecurringTokensList(id)

List recurring tokens saved for a client.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientsApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
try {
    val result : ClientRecurringTokensList200Response = apiInstance.clientRecurringTokensList(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientsApi#clientRecurringTokensList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientsApi#clientRecurringTokensList")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |

### Return type

[**ClientRecurringTokensList200Response**](ClientRecurringTokensList200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clientRecurringTokensRead"></a>
# **clientRecurringTokensRead**
> ClientRecurringToken clientRecurringTokensRead(id)

Retrieve an object by ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientsApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
try {
    val result : ClientRecurringToken = apiInstance.clientRecurringTokensRead(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientsApi#clientRecurringTokensRead")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientsApi#clientRecurringTokensRead")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |

### Return type

[**ClientRecurringToken**](ClientRecurringToken.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clientsCreate"></a>
# **clientsCreate**
> Client clientsCreate(client)

Create a new client.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientsApi()
val client : Client =  // Client | 
try {
    val result : Client = apiInstance.clientsCreate(client)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientsApi#clientsCreate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientsApi#clientsCreate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **client** | [**Client**](Client.md)|  |

### Return type

[**Client**](Client.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="clientsDelete"></a>
# **clientsDelete**
> clientsDelete(id)

Delete a client by ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientsApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
try {
    apiInstance.clientsDelete(id)
} catch (e: ClientException) {
    println("4xx response calling ClientsApi#clientsDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientsApi#clientsDelete")
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

<a name="clientsList"></a>
# **clientsList**
> ClientsList200Response clientsList()

List all clients.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientsApi()
try {
    val result : ClientsList200Response = apiInstance.clientsList()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientsApi#clientsList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientsApi#clientsList")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ClientsList200Response**](ClientsList200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clientsPartialUpdate"></a>
# **clientsPartialUpdate**
> Client clientsPartialUpdate(id, client)

Partially update a client by ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientsApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
val client : Client =  // Client | 
try {
    val result : Client = apiInstance.clientsPartialUpdate(id, client)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientsApi#clientsPartialUpdate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientsApi#clientsPartialUpdate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |
 **client** | [**Client**](Client.md)|  |

### Return type

[**Client**](Client.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="clientsRead"></a>
# **clientsRead**
> Client clientsRead(id)

Retrieve an object by ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientsApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
try {
    val result : Client = apiInstance.clientsRead(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientsApi#clientsRead")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientsApi#clientsRead")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |

### Return type

[**Client**](Client.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clientsUpdate"></a>
# **clientsUpdate**
> Client clientsUpdate(id, client)

Update a client by ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientsApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
val client : Client =  // Client | 
try {
    val result : Client = apiInstance.clientsUpdate(id, client)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientsApi#clientsUpdate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientsApi#clientsUpdate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |
 **client** | [**Client**](Client.md)|  |

### Return type

[**Client**](Client.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

