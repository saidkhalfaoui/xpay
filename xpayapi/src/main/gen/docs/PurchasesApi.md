# PurchasesApi

All URIs are relative to */api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**purchasesCancel**](PurchasesApi.md#purchasesCancel) | **POST** /purchases/{id}/cancel/ | Cancel a pending purchase.
[**purchasesCapture**](PurchasesApi.md#purchasesCapture) | **POST** /purchases/{id}/capture/ | Capture a previously authorized payment.
[**purchasesCharge**](PurchasesApi.md#purchasesCharge) | **POST** /purchases/{id}/charge/ | Charge a purchase using a saved token.
[**purchasesCreate**](PurchasesApi.md#purchasesCreate) | **POST** /purchases/ | Create a purchase – the main request for any e-commerce integration.
[**purchasesDeleteRecurringToken**](PurchasesApi.md#purchasesDeleteRecurringToken) | **POST** /purchases/{id}/delete_recurring_token/ | Delete a recurring token associated with a purchase.
[**purchasesMarkAsPaid**](PurchasesApi.md#purchasesMarkAsPaid) | **POST** /purchases/{id}/mark_as_paid/ | Mark a purchase as paid.
[**purchasesRead**](PurchasesApi.md#purchasesRead) | **GET** /purchases/{id}/ | Retrieve an object by ID.
[**purchasesRefund**](PurchasesApi.md#purchasesRefund) | **POST** /purchases/{id}/refund/ | Refund a paid purchase.
[**purchasesRelease**](PurchasesApi.md#purchasesRelease) | **POST** /purchases/{id}/release/ | Release funds on hold.
[**purchasesResendInvoice**](PurchasesApi.md#purchasesResendInvoice) | **POST** /purchases/{id}/resend_invoice/ | Re-sends invoice


<a name="purchasesCancel"></a>
# **purchasesCancel**
> Purchase purchasesCancel(id)

Cancel a pending purchase.

If you have a Purchase that payment is possible for, using this request you can guarantee that it won&#39;t be paid.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PurchasesApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
try {
    val result : Purchase = apiInstance.purchasesCancel(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PurchasesApi#purchasesCancel")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PurchasesApi#purchasesCancel")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |

### Return type

[**Purchase**](Purchase.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="purchasesCapture"></a>
# **purchasesCapture**
> Purchase purchasesCapture(id, purchasesCaptureRequest)

Capture a previously authorized payment.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PurchasesApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
val purchasesCaptureRequest : PurchasesCaptureRequest =  // PurchasesCaptureRequest | 
try {
    val result : Purchase = apiInstance.purchasesCapture(id, purchasesCaptureRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PurchasesApi#purchasesCapture")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PurchasesApi#purchasesCapture")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |
 **purchasesCaptureRequest** | [**PurchasesCaptureRequest**](PurchasesCaptureRequest.md)|  | [optional]

### Return type

[**Purchase**](Purchase.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="purchasesCharge"></a>
# **purchasesCharge**
> Purchase purchasesCharge(id, purchasesChargeRequest)

Charge a purchase using a saved token.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PurchasesApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
val purchasesChargeRequest : PurchasesChargeRequest = {"recurring_token":"ea582899-78ec-4c3a-9cb3-08f922e556b6"} // PurchasesChargeRequest | 
try {
    val result : Purchase = apiInstance.purchasesCharge(id, purchasesChargeRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PurchasesApi#purchasesCharge")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PurchasesApi#purchasesCharge")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |
 **purchasesChargeRequest** | [**PurchasesChargeRequest**](PurchasesChargeRequest.md)|  |

### Return type

[**Purchase**](Purchase.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="purchasesCreate"></a>
# **purchasesCreate**
> Purchase purchasesCreate(purchase)

Create a purchase – the main request for any e-commerce integration.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PurchasesApi()
val purchase : Purchase = {"client":{"email":"test@test.com"},"purchase":{"products":[{"name":"test","price":100}]},"brand_id":"409eb80e-3782-4b1d-afa8-b779759266a5"} // Purchase | 
try {
    val result : Purchase = apiInstance.purchasesCreate(purchase)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PurchasesApi#purchasesCreate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PurchasesApi#purchasesCreate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **purchase** | [**Purchase**](Purchase.md)|  |

### Return type

[**Purchase**](Purchase.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="purchasesDeleteRecurringToken"></a>
# **purchasesDeleteRecurringToken**
> Purchase purchasesDeleteRecurringToken(id)

Delete a recurring token associated with a purchase.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PurchasesApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
try {
    val result : Purchase = apiInstance.purchasesDeleteRecurringToken(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PurchasesApi#purchasesDeleteRecurringToken")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PurchasesApi#purchasesDeleteRecurringToken")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |

### Return type

[**Purchase**](Purchase.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="purchasesMarkAsPaid"></a>
# **purchasesMarkAsPaid**
> Purchase purchasesMarkAsPaid(id, purchasesMarkAsPaidRequest)

Mark a purchase as paid.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PurchasesApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
val purchasesMarkAsPaidRequest : PurchasesMarkAsPaidRequest = {"paid_on":1635162311} // PurchasesMarkAsPaidRequest | 
try {
    val result : Purchase = apiInstance.purchasesMarkAsPaid(id, purchasesMarkAsPaidRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PurchasesApi#purchasesMarkAsPaid")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PurchasesApi#purchasesMarkAsPaid")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |
 **purchasesMarkAsPaidRequest** | [**PurchasesMarkAsPaidRequest**](PurchasesMarkAsPaidRequest.md)|  | [optional]

### Return type

[**Purchase**](Purchase.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="purchasesRead"></a>
# **purchasesRead**
> Purchase purchasesRead(id)

Retrieve an object by ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PurchasesApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
try {
    val result : Purchase = apiInstance.purchasesRead(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PurchasesApi#purchasesRead")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PurchasesApi#purchasesRead")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |

### Return type

[**Purchase**](Purchase.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="purchasesRefund"></a>
# **purchasesRefund**
> Payment purchasesRefund(id, purchasesRefundRequest)

Refund a paid purchase.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PurchasesApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
val purchasesRefundRequest : PurchasesRefundRequest = {"amount":120} // PurchasesRefundRequest | 
try {
    val result : Payment = apiInstance.purchasesRefund(id, purchasesRefundRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PurchasesApi#purchasesRefund")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PurchasesApi#purchasesRefund")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |
 **purchasesRefundRequest** | [**PurchasesRefundRequest**](PurchasesRefundRequest.md)|  | [optional]

### Return type

[**Payment**](Payment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="purchasesRelease"></a>
# **purchasesRelease**
> Purchase purchasesRelease(id)

Release funds on hold.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PurchasesApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
try {
    val result : Purchase = apiInstance.purchasesRelease(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PurchasesApi#purchasesRelease")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PurchasesApi#purchasesRelease")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |

### Return type

[**Purchase**](Purchase.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="purchasesResendInvoice"></a>
# **purchasesResendInvoice**
> Purchase purchasesResendInvoice(id)

Re-sends invoice

Will re-send the invoice.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PurchasesApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
try {
    val result : Purchase = apiInstance.purchasesResendInvoice(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PurchasesApi#purchasesResendInvoice")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PurchasesApi#purchasesResendInvoice")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |

### Return type

[**Purchase**](Purchase.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

