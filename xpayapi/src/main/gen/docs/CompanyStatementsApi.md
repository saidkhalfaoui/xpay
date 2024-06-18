# CompanyStatementsApi

All URIs are relative to */api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**companyStatementsCancel**](CompanyStatementsApi.md#companyStatementsCancel) | **POST** /company_statements/{id}/cancel/ | Cancel a statement generation by ID.
[**companyStatementsCreate**](CompanyStatementsApi.md#companyStatementsCreate) | **POST** /company_statements/ | Schedule a statement generation.
[**companyStatementsList**](CompanyStatementsApi.md#companyStatementsList) | **GET** /company_statements/ | List all generated statements.
[**companyStatementsRead**](CompanyStatementsApi.md#companyStatementsRead) | **GET** /company_statements/{id}/ | Retrieve a statement by ID.


<a name="companyStatementsCancel"></a>
# **companyStatementsCancel**
> CompanyStatement companyStatementsCancel(id)

Cancel a statement generation by ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CompanyStatementsApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
try {
    val result : CompanyStatement = apiInstance.companyStatementsCancel(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CompanyStatementsApi#companyStatementsCancel")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CompanyStatementsApi#companyStatementsCancel")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |

### Return type

[**CompanyStatement**](CompanyStatement.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="companyStatementsCreate"></a>
# **companyStatementsCreate**
> CompanyStatement companyStatementsCreate(companyStatement, from, to, paidFrom, paidTo, updatedFrom, updatedTo, brandId, shopId, q, products, total, currency, paymentMethod, threeDSecure, country, status, product)

Schedule a statement generation.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CompanyStatementsApi()
val companyStatement : CompanyStatement = {"format":"csv","timezone":"UTC"} // CompanyStatement | 
val from : kotlin.Int = 56 // kotlin.Int | Filter result set to only include values older or equal to the provided Unix timestamp
val to : kotlin.Int = 56 // kotlin.Int | Filter result set to only include values younger than the provided Unix timestamp
val paidFrom : kotlin.Int = 56 // kotlin.Int | Filter paid result set to only include values older or equal to the provided Unix timestamp
val paidTo : kotlin.Int = 56 // kotlin.Int | Filter paid result set to only include values younger than the provided Unix timestamp
val updatedFrom : kotlin.Int = 56 // kotlin.Int | Filter result set to only include values older or equal to the provided last modification time Unix timestamp
val updatedTo : kotlin.Int = 56 // kotlin.Int | Filter result set to only include values younger than the provided last modification time Unix timestamp
val brandId : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Filter result set to only include the specified brand UUID(s)
val shopId : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Filter result set to only include the specified shop UUID(s)
val q : kotlin.String = q_example // kotlin.String | Filter result set to only include results including a specified text (search over a ton of text fields)
val products : kotlin.String = products_example // kotlin.String | Filter result set to only include results including a specified text in products
val total : kotlin.Float = 3.4 // kotlin.Float | 
val currency : kotlin.String = currency_example // kotlin.String | Filter result set to only include specified currency(ies)
val paymentMethod : PaymentMethod =  // PaymentMethod | Filter result set to only include specified payment methods(s). See <a href=\"#model-PaymentMethod\">PaymentMethod<a> fro more information.
val threeDSecure : kotlin.String = threeDSecure_example // kotlin.String | Filter result set to only include results with a 3-D verification.
val country : kotlin.String = country_example // kotlin.String | Filter result set to only include specified client country(ies) in ISO 3166-1 alpha-2 format
val status : kotlin.String = status_example // kotlin.String | 
val product : TransactionProduct =  // TransactionProduct | Filter result set to only include specified products(s). See <a href=\"#model-TransactionProduct\">TransactionProduct<a> fro more information.
try {
    val result : CompanyStatement = apiInstance.companyStatementsCreate(companyStatement, from, to, paidFrom, paidTo, updatedFrom, updatedTo, brandId, shopId, q, products, total, currency, paymentMethod, threeDSecure, country, status, product)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CompanyStatementsApi#companyStatementsCreate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CompanyStatementsApi#companyStatementsCreate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **companyStatement** | [**CompanyStatement**](CompanyStatement.md)|  |
 **from** | **kotlin.Int**| Filter result set to only include values older or equal to the provided Unix timestamp | [optional]
 **to** | **kotlin.Int**| Filter result set to only include values younger than the provided Unix timestamp | [optional]
 **paidFrom** | **kotlin.Int**| Filter paid result set to only include values older or equal to the provided Unix timestamp | [optional]
 **paidTo** | **kotlin.Int**| Filter paid result set to only include values younger than the provided Unix timestamp | [optional]
 **updatedFrom** | **kotlin.Int**| Filter result set to only include values older or equal to the provided last modification time Unix timestamp | [optional]
 **updatedTo** | **kotlin.Int**| Filter result set to only include values younger than the provided last modification time Unix timestamp | [optional]
 **brandId** | **java.util.UUID**| Filter result set to only include the specified brand UUID(s) | [optional]
 **shopId** | **java.util.UUID**| Filter result set to only include the specified shop UUID(s) | [optional]
 **q** | **kotlin.String**| Filter result set to only include results including a specified text (search over a ton of text fields) | [optional]
 **products** | **kotlin.String**| Filter result set to only include results including a specified text in products | [optional]
 **total** | **kotlin.Float**|  | [optional]
 **currency** | **kotlin.String**| Filter result set to only include specified currency(ies) | [optional]
 **paymentMethod** | [**PaymentMethod**](.md)| Filter result set to only include specified payment methods(s). See &lt;a href&#x3D;\&quot;#model-PaymentMethod\&quot;&gt;PaymentMethod&lt;a&gt; fro more information. | [optional] [enum: unknown]
 **threeDSecure** | **kotlin.String**| Filter result set to only include results with a 3-D verification. | [optional]
 **country** | **kotlin.String**| Filter result set to only include specified client country(ies) in ISO 3166-1 alpha-2 format | [optional]
 **status** | **kotlin.String**|  | [optional]
 **product** | [**TransactionProduct**](.md)| Filter result set to only include specified products(s). See &lt;a href&#x3D;\&quot;#model-TransactionProduct\&quot;&gt;TransactionProduct&lt;a&gt; fro more information. | [optional] [enum: bank_payment, chargeback, custom_payment, invoice, purchase, refund, subscription]

### Return type

[**CompanyStatement**](CompanyStatement.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="companyStatementsList"></a>
# **companyStatementsList**
> CompanyStatementsList200Response companyStatementsList()

List all generated statements.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CompanyStatementsApi()
try {
    val result : CompanyStatementsList200Response = apiInstance.companyStatementsList()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CompanyStatementsApi#companyStatementsList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CompanyStatementsApi#companyStatementsList")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**CompanyStatementsList200Response**](CompanyStatementsList200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="companyStatementsRead"></a>
# **companyStatementsRead**
> CompanyStatement companyStatementsRead(id)

Retrieve a statement by ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CompanyStatementsApi()
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | Object ID (UUID)
try {
    val result : CompanyStatement = apiInstance.companyStatementsRead(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CompanyStatementsApi#companyStatementsRead")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CompanyStatementsApi#companyStatementsRead")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **java.util.UUID**| Object ID (UUID) |

### Return type

[**CompanyStatement**](CompanyStatement.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

