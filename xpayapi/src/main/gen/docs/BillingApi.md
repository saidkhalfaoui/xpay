# BillingApi

All URIs are relative to */api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**billingTemplatesAddSubscriber**](BillingApi.md#billingTemplatesAddSubscriber) | **POST** /billing_templates/{id}/add_subscriber/ | Add a billing template client and activate recurring billing (is_subscription: true).
[**billingTemplatesClientsList**](BillingApi.md#billingTemplatesClientsList) | **GET** /billing_templates/{id}/clients/ | List all billing template clients for this billing template.
[**billingTemplatesClientsPartialUpdate**](BillingApi.md#billingTemplatesClientsPartialUpdate) | **PATCH** /billing_templates/clients/{id}/ | Partially update a billing template client by clients ID.
[**billingTemplatesClientsRead**](BillingApi.md#billingTemplatesClientsRead) | **GET** /billing_templates/clients/{id}/ | Retrieve a billing template client by clients ID.
[**billingTemplatesCreate**](BillingApi.md#billingTemplatesCreate) | **POST** /billing_templates/ | Create a template to issue repeated invoices from in the future, with or without a subscription.
[**billingTemplatesDelete**](BillingApi.md#billingTemplatesDelete) | **DELETE** /billing_templates/{id}/ | Delete a billing template by ID.
[**billingTemplatesList**](BillingApi.md#billingTemplatesList) | **GET** /billing_templates/ | List all billing templates.
[**billingTemplatesOneTimeInvoices**](BillingApi.md#billingTemplatesOneTimeInvoices) | **POST** /billing/ | Send an invoice to one or several clients.
[**billingTemplatesRead**](BillingApi.md#billingTemplatesRead) | **GET** /billing_templates/{id}/ | Retrieve a billing template by ID.
[**billingTemplatesSendInvoice**](BillingApi.md#billingTemplatesSendInvoice) | **POST** /billing_templates/{id}/send_invoice/ | Send an invoice, generating a purchase from billing template data.
[**billingTemplatesUpdate**](BillingApi.md#billingTemplatesUpdate) | **PUT** /billing_templates/{id}/ | Update a billing template by ID.


<a name="billingTemplatesAddSubscriber"></a>
# **billingTemplatesAddSubscriber**
> BillingTemplatesAddSubscriber200Response billingTemplatesAddSubscriber(id, billingTemplateClient)

Add a billing template client and activate recurring billing (is_subscription: true).

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = BillingApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
val billingTemplateClient : BillingTemplateClient = {"client_id":"b79d3df6-2f69-4426-acee-eda049d83e18"} // BillingTemplateClient | 
try {
    val result : BillingTemplatesAddSubscriber200Response = apiInstance.billingTemplatesAddSubscriber(id, billingTemplateClient)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillingApi#billingTemplatesAddSubscriber")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillingApi#billingTemplatesAddSubscriber")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |
 **billingTemplateClient** | [**BillingTemplateClient**](BillingTemplateClient.md)|  |

### Return type

[**BillingTemplatesAddSubscriber200Response**](BillingTemplatesAddSubscriber200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="billingTemplatesClientsList"></a>
# **billingTemplatesClientsList**
> BillingTemplatesClientsList200Response billingTemplatesClientsList(id)

List all billing template clients for this billing template.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = BillingApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
try {
    val result : BillingTemplatesClientsList200Response = apiInstance.billingTemplatesClientsList(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillingApi#billingTemplatesClientsList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillingApi#billingTemplatesClientsList")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |

### Return type

[**BillingTemplatesClientsList200Response**](BillingTemplatesClientsList200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="billingTemplatesClientsPartialUpdate"></a>
# **billingTemplatesClientsPartialUpdate**
> BillingTemplateClient billingTemplatesClientsPartialUpdate(id, billingTemplateClient)

Partially update a billing template client by clients ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = BillingApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
val billingTemplateClient : BillingTemplateClient = {"status":"active"} // BillingTemplateClient | 
try {
    val result : BillingTemplateClient = apiInstance.billingTemplatesClientsPartialUpdate(id, billingTemplateClient)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillingApi#billingTemplatesClientsPartialUpdate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillingApi#billingTemplatesClientsPartialUpdate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |
 **billingTemplateClient** | [**BillingTemplateClient**](BillingTemplateClient.md)|  |

### Return type

[**BillingTemplateClient**](BillingTemplateClient.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="billingTemplatesClientsRead"></a>
# **billingTemplatesClientsRead**
> BillingTemplateClient billingTemplatesClientsRead(id)

Retrieve a billing template client by clients ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = BillingApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
try {
    val result : BillingTemplateClient = apiInstance.billingTemplatesClientsRead(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillingApi#billingTemplatesClientsRead")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillingApi#billingTemplatesClientsRead")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |

### Return type

[**BillingTemplateClient**](BillingTemplateClient.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="billingTemplatesCreate"></a>
# **billingTemplatesCreate**
> BillingTemplate billingTemplatesCreate(billingTemplate)

Create a template to issue repeated invoices from in the future, with or without a subscription.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = BillingApi()
val billingTemplate : BillingTemplate =  // BillingTemplate | 
try {
    val result : BillingTemplate = apiInstance.billingTemplatesCreate(billingTemplate)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillingApi#billingTemplatesCreate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillingApi#billingTemplatesCreate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **billingTemplate** | [**BillingTemplate**](BillingTemplate.md)|  |

### Return type

[**BillingTemplate**](BillingTemplate.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="billingTemplatesDelete"></a>
# **billingTemplatesDelete**
> billingTemplatesDelete(id)

Delete a billing template by ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = BillingApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
try {
    apiInstance.billingTemplatesDelete(id)
} catch (e: ClientException) {
    println("4xx response calling BillingApi#billingTemplatesDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillingApi#billingTemplatesDelete")
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

<a name="billingTemplatesList"></a>
# **billingTemplatesList**
> BillingTemplatesList200Response billingTemplatesList()

List all billing templates.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = BillingApi()
try {
    val result : BillingTemplatesList200Response = apiInstance.billingTemplatesList()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillingApi#billingTemplatesList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillingApi#billingTemplatesList")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BillingTemplatesList200Response**](BillingTemplatesList200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="billingTemplatesOneTimeInvoices"></a>
# **billingTemplatesOneTimeInvoices**
> kotlin.collections.List&lt;kotlin.String&gt; billingTemplatesOneTimeInvoices(billingTemplatesOneTimeInvoicesRequest)

Send an invoice to one or several clients.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = BillingApi()
val billingTemplatesOneTimeInvoicesRequest : BillingTemplatesOneTimeInvoicesRequest =  // BillingTemplatesOneTimeInvoicesRequest | 
try {
    val result : kotlin.collections.List<kotlin.String> = apiInstance.billingTemplatesOneTimeInvoices(billingTemplatesOneTimeInvoicesRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillingApi#billingTemplatesOneTimeInvoices")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillingApi#billingTemplatesOneTimeInvoices")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **billingTemplatesOneTimeInvoicesRequest** | [**BillingTemplatesOneTimeInvoicesRequest**](BillingTemplatesOneTimeInvoicesRequest.md)|  |

### Return type

**kotlin.collections.List&lt;kotlin.String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="billingTemplatesRead"></a>
# **billingTemplatesRead**
> BillingTemplate billingTemplatesRead(id)

Retrieve a billing template by ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = BillingApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
try {
    val result : BillingTemplate = apiInstance.billingTemplatesRead(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillingApi#billingTemplatesRead")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillingApi#billingTemplatesRead")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |

### Return type

[**BillingTemplate**](BillingTemplate.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="billingTemplatesSendInvoice"></a>
# **billingTemplatesSendInvoice**
> Purchase billingTemplatesSendInvoice(id, billingTemplateClient)

Send an invoice, generating a purchase from billing template data.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = BillingApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
val billingTemplateClient : BillingTemplateClient = {"client_id":"b79d3df6-2f69-4426-acee-eda049d83e18"} // BillingTemplateClient | 
try {
    val result : Purchase = apiInstance.billingTemplatesSendInvoice(id, billingTemplateClient)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillingApi#billingTemplatesSendInvoice")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillingApi#billingTemplatesSendInvoice")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |
 **billingTemplateClient** | [**BillingTemplateClient**](BillingTemplateClient.md)|  |

### Return type

[**Purchase**](Purchase.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="billingTemplatesUpdate"></a>
# **billingTemplatesUpdate**
> BillingTemplate billingTemplatesUpdate(id, billingTemplate)

Update a billing template by ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = BillingApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
val billingTemplate : BillingTemplate =  // BillingTemplate | 
try {
    val result : BillingTemplate = apiInstance.billingTemplatesUpdate(id, billingTemplate)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillingApi#billingTemplatesUpdate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillingApi#billingTemplatesUpdate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |
 **billingTemplate** | [**BillingTemplate**](BillingTemplate.md)|  |

### Return type

[**BillingTemplate**](BillingTemplate.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

