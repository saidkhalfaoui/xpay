
# CompanyStatement

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**format** | **kotlin.String** | Statement format, available formats: &#x60;csv&#x60;, &#x60;xlsx&#x60;. |  [optional]
**timezone** | **kotlin.String** | Timezone to localize statement-specific timestamps |  [optional]
**isTest** | **kotlin.Boolean** | Indicates this is a test object, created using test API keys or using Billing section of UI while in test mode. |  [optional] [readonly]
**companyUid** | [**java.util.UUID**](java.util.UUID.md) | ID of the Company. |  [optional] [readonly]
**queryString** | **kotlin.String** | Query parameters used to generate statement. |  [optional] [readonly]
**status** | **kotlin.String** | Status of statement generation e.g. &#x60;pending&#x60;, &#x60;processing&#x60;, &#x60;success&#x60;. |  [optional] [readonly]
**downloadUrl** | **kotlin.String** | Download URL of a statement. |  [optional] [readonly]
**beganOn** | **kotlin.Int** | Date and time for the beginning of statement generation process. |  [optional] [readonly]
**finishedOn** | **kotlin.Int** | Date and time for finishing the statement generation process. |  [optional] [readonly]
**createdOn** | **kotlin.Int** | Object creation time |  [optional] [readonly]
**updatedOn** | **kotlin.Int** | Object last modification time |  [optional] [readonly]
**type** | **kotlin.String** | Statement request type |  [optional] [readonly]
**id** | [**java.util.UUID**](java.util.UUID.md) | ID of a statement |  [optional] [readonly]



