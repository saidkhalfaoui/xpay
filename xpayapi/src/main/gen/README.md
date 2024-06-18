# org.openapitools.client - Kotlin client library for Public REST API

## Requires

* Kotlin 1.4.30
* Gradle 6.8.3

## Build

First, create the gradle wrapper script:

```
gradle wrapper
```

Then, run:

```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs, File inputs, and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in OpenAPI definitions.
* Implementation of ApiClient is intended to reduce method counts, specifically to benefit Android targets.

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to */api/v1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AccountApi* | [**balance**](docs/AccountApi.md#balance) | **GET** /account/json/balance/ | Get company balance.
*AccountApi* | [**turnover**](docs/AccountApi.md#turnover) | **GET** /account/json/turnover/ | Get company turnover.
*BillingApi* | [**billingTemplatesAddSubscriber**](docs/BillingApi.md#billingtemplatesaddsubscriber) | **POST** /billing_templates/{id}/add_subscriber/ | Add a billing template client and activate recurring billing (is_subscription: true).
*BillingApi* | [**billingTemplatesClientsList**](docs/BillingApi.md#billingtemplatesclientslist) | **GET** /billing_templates/{id}/clients/ | List all billing template clients for this billing template.
*BillingApi* | [**billingTemplatesClientsPartialUpdate**](docs/BillingApi.md#billingtemplatesclientspartialupdate) | **PATCH** /billing_templates/clients/{id}/ | Partially update a billing template client by clients ID.
*BillingApi* | [**billingTemplatesClientsRead**](docs/BillingApi.md#billingtemplatesclientsread) | **GET** /billing_templates/clients/{id}/ | Retrieve a billing template client by clients ID.
*BillingApi* | [**billingTemplatesCreate**](docs/BillingApi.md#billingtemplatescreate) | **POST** /billing_templates/ | Create a template to issue repeated invoices from in the future, with or without a subscription.
*BillingApi* | [**billingTemplatesDelete**](docs/BillingApi.md#billingtemplatesdelete) | **DELETE** /billing_templates/{id}/ | Delete a billing template by ID.
*BillingApi* | [**billingTemplatesList**](docs/BillingApi.md#billingtemplateslist) | **GET** /billing_templates/ | List all billing templates.
*BillingApi* | [**billingTemplatesOneTimeInvoices**](docs/BillingApi.md#billingtemplatesonetimeinvoices) | **POST** /billing/ | Send an invoice to one or several clients.
*BillingApi* | [**billingTemplatesRead**](docs/BillingApi.md#billingtemplatesread) | **GET** /billing_templates/{id}/ | Retrieve a billing template by ID.
*BillingApi* | [**billingTemplatesSendInvoice**](docs/BillingApi.md#billingtemplatessendinvoice) | **POST** /billing_templates/{id}/send_invoice/ | Send an invoice, generating a purchase from billing template data.
*BillingApi* | [**billingTemplatesUpdate**](docs/BillingApi.md#billingtemplatesupdate) | **PUT** /billing_templates/{id}/ | Update a billing template by ID.
*ClientsApi* | [**clientRecurringTokensDelete**](docs/ClientsApi.md#clientrecurringtokensdelete) | **DELETE** /clients/{id}/recurring_tokens2/ | Delete a client recurring token by ID.
*ClientsApi* | [**clientRecurringTokensList**](docs/ClientsApi.md#clientrecurringtokenslist) | **GET** /clients/{id}/recurring_tokens/ | List recurring tokens saved for a client.
*ClientsApi* | [**clientRecurringTokensRead**](docs/ClientsApi.md#clientrecurringtokensread) | **GET** /clients/{id}/recurring_tokens2/ | Retrieve an object by ID.
*ClientsApi* | [**clientsCreate**](docs/ClientsApi.md#clientscreate) | **POST** /clients/ | Create a new client.
*ClientsApi* | [**clientsDelete**](docs/ClientsApi.md#clientsdelete) | **DELETE** /clients/{id}/ | Delete a client by ID.
*ClientsApi* | [**clientsList**](docs/ClientsApi.md#clientslist) | **GET** /clients/ | List all clients.
*ClientsApi* | [**clientsPartialUpdate**](docs/ClientsApi.md#clientspartialupdate) | **PATCH** /clients/{id}/ | Partially update a client by ID.
*ClientsApi* | [**clientsRead**](docs/ClientsApi.md#clientsread) | **GET** /clients/{id}/ | Retrieve an object by ID.
*ClientsApi* | [**clientsUpdate**](docs/ClientsApi.md#clientsupdate) | **PUT** /clients/{id}/ | Update a client by ID.
*CompanyStatementsApi* | [**companyStatementsCancel**](docs/CompanyStatementsApi.md#companystatementscancel) | **POST** /company_statements/{id}/cancel/ | Cancel a statement generation by ID.
*CompanyStatementsApi* | [**companyStatementsCreate**](docs/CompanyStatementsApi.md#companystatementscreate) | **POST** /company_statements/ | Schedule a statement generation.
*CompanyStatementsApi* | [**companyStatementsList**](docs/CompanyStatementsApi.md#companystatementslist) | **GET** /company_statements/ | List all generated statements.
*CompanyStatementsApi* | [**companyStatementsRead**](docs/CompanyStatementsApi.md#companystatementsread) | **GET** /company_statements/{id}/ | Retrieve a statement by ID.
*DefaultApi* | [**collectionIdGet**](docs/DefaultApi.md#collectionidget) | **GET** /collection/{id} | Retrieve sepadd collection information
*DefaultApi* | [**mandatePost**](docs/DefaultApi.md#mandatepost) | **POST** /mandate/ | create a new mandate
*PaymentMethodsApi* | [**paymentMethods**](docs/PaymentMethodsApi.md#paymentmethods) | **GET** /payment_methods/ | Get the list of payment methods available for your purchase.
*PublicKeyApi* | [**publicKey**](docs/PublicKeyApi.md#publickey) | **GET** /public_key/ | Get a callback public key.
*PurchasesApi* | [**purchasesCancel**](docs/PurchasesApi.md#purchasescancel) | **POST** /purchases/{id}/cancel/ | Cancel a pending purchase.
*PurchasesApi* | [**purchasesCapture**](docs/PurchasesApi.md#purchasescapture) | **POST** /purchases/{id}/capture/ | Capture a previously authorized payment.
*PurchasesApi* | [**purchasesCharge**](docs/PurchasesApi.md#purchasescharge) | **POST** /purchases/{id}/charge/ | Charge a purchase using a saved token.
*PurchasesApi* | [**purchasesCreate**](docs/PurchasesApi.md#purchasescreate) | **POST** /purchases/ | Create a purchase – the main request for any e-commerce integration.
*PurchasesApi* | [**purchasesDeleteRecurringToken**](docs/PurchasesApi.md#purchasesdeleterecurringtoken) | **POST** /purchases/{id}/delete_recurring_token/ | Delete a recurring token associated with a purchase.
*PurchasesApi* | [**purchasesMarkAsPaid**](docs/PurchasesApi.md#purchasesmarkaspaid) | **POST** /purchases/{id}/mark_as_paid/ | Mark a purchase as paid.
*PurchasesApi* | [**purchasesRead**](docs/PurchasesApi.md#purchasesread) | **GET** /purchases/{id}/ | Retrieve an object by ID.
*PurchasesApi* | [**purchasesRefund**](docs/PurchasesApi.md#purchasesrefund) | **POST** /purchases/{id}/refund/ | Refund a paid purchase.
*PurchasesApi* | [**purchasesRelease**](docs/PurchasesApi.md#purchasesrelease) | **POST** /purchases/{id}/release/ | Release funds on hold.
*PurchasesApi* | [**purchasesResendInvoice**](docs/PurchasesApi.md#purchasesresendinvoice) | **POST** /purchases/{id}/resend_invoice/ | Re-sends invoice
*SepaDDApi* | [**collectionPost**](docs/SepaDDApi.md#collectionpost) | **POST** /collection/ | create a new mandate
*SepaDDApi* | [**mandateIdGet**](docs/SepaDDApi.md#mandateidget) | **GET** /mandate/{id} | Retrieve mandate information
*WebhooksApi* | [**webhooksCreate**](docs/WebhooksApi.md#webhookscreate) | **POST** /webhooks/ | Create a new webhook.
*WebhooksApi* | [**webhooksDelete**](docs/WebhooksApi.md#webhooksdelete) | **DELETE** /webhooks/{id}/ | Delete a webhook by ID.
*WebhooksApi* | [**webhooksList**](docs/WebhooksApi.md#webhookslist) | **GET** /webhooks/ | List all webhooks.
*WebhooksApi* | [**webhooksPartialUpdate**](docs/WebhooksApi.md#webhookspartialupdate) | **PATCH** /webhooks/{id}/ | Partially update a webhook by ID.
*WebhooksApi* | [**webhooksRead**](docs/WebhooksApi.md#webhooksread) | **GET** /webhooks/{id}/ | Retrieve an object by ID.
*WebhooksApi* | [**webhooksUpdate**](docs/WebhooksApi.md#webhooksupdate) | **PUT** /webhooks/{id}/ | Update a webhook by ID.


<a name="documentation-for-models"></a>
## Documentation for Models

 - [org.openapitools.client.models.Accountinformation](docs/Accountinformation.md)
 - [org.openapitools.client.models.AccountinformationRequest](docs/AccountinformationRequest.md)
 - [org.openapitools.client.models.Address](docs/Address.md)
 - [org.openapitools.client.models.Balance](docs/Balance.md)
 - [org.openapitools.client.models.BankAccount](docs/BankAccount.md)
 - [org.openapitools.client.models.BaseModel](docs/BaseModel.md)
 - [org.openapitools.client.models.BillingTemplate](docs/BillingTemplate.md)
 - [org.openapitools.client.models.BillingTemplateClient](docs/BillingTemplateClient.md)
 - [org.openapitools.client.models.BillingTemplatesAddSubscriber200Response](docs/BillingTemplatesAddSubscriber200Response.md)
 - [org.openapitools.client.models.BillingTemplatesAddSubscriber200ResponsePurchase](docs/BillingTemplatesAddSubscriber200ResponsePurchase.md)
 - [org.openapitools.client.models.BillingTemplatesClientsList200Response](docs/BillingTemplatesClientsList200Response.md)
 - [org.openapitools.client.models.BillingTemplatesList200Response](docs/BillingTemplatesList200Response.md)
 - [org.openapitools.client.models.BillingTemplatesOneTimeInvoicesRequest](docs/BillingTemplatesOneTimeInvoicesRequest.md)
 - [org.openapitools.client.models.BillingTemplatesOneTimeInvoicesRequestAllOf](docs/BillingTemplatesOneTimeInvoicesRequestAllOf.md)
 - [org.openapitools.client.models.Client](docs/Client.md)
 - [org.openapitools.client.models.ClientDetails](docs/ClientDetails.md)
 - [org.openapitools.client.models.ClientRecurringToken](docs/ClientRecurringToken.md)
 - [org.openapitools.client.models.ClientRecurringTokensList200Response](docs/ClientRecurringTokensList200Response.md)
 - [org.openapitools.client.models.ClientsList200Response](docs/ClientsList200Response.md)
 - [org.openapitools.client.models.Collectioninformation](docs/Collectioninformation.md)
 - [org.openapitools.client.models.CompanyStatement](docs/CompanyStatement.md)
 - [org.openapitools.client.models.CompanyStatementsList200Response](docs/CompanyStatementsList200Response.md)
 - [org.openapitools.client.models.CreditTransferRequest](docs/CreditTransferRequest.md)
 - [org.openapitools.client.models.CreditTransferRequestAllOf](docs/CreditTransferRequestAllOf.md)
 - [org.openapitools.client.models.DirectDebitRequest](docs/DirectDebitRequest.md)
 - [org.openapitools.client.models.DirectDebitRequestAllOf](docs/DirectDebitRequestAllOf.md)
 - [org.openapitools.client.models.Error](docs/Error.md)
 - [org.openapitools.client.models.Event](docs/Event.md)
 - [org.openapitools.client.models.FeeSell](docs/FeeSell.md)
 - [org.openapitools.client.models.IssuerDetails](docs/IssuerDetails.md)
 - [org.openapitools.client.models.MandateDTO](docs/MandateDTO.md)
 - [org.openapitools.client.models.Mandateinformation](docs/Mandateinformation.md)
 - [org.openapitools.client.models.MandateinformationRequest](docs/MandateinformationRequest.md)
 - [org.openapitools.client.models.Payment](docs/Payment.md)
 - [org.openapitools.client.models.PaymentDetails](docs/PaymentDetails.md)
 - [org.openapitools.client.models.PaymentMethod](docs/PaymentMethod.md)
 - [org.openapitools.client.models.PaymentMethods200Response](docs/PaymentMethods200Response.md)
 - [org.openapitools.client.models.PaymentMethods200ResponseByCountry](docs/PaymentMethods200ResponseByCountry.md)
 - [org.openapitools.client.models.PaymentMethods200ResponseLogosValue](docs/PaymentMethods200ResponseLogosValue.md)
 - [org.openapitools.client.models.Payout](docs/Payout.md)
 - [org.openapitools.client.models.PayoutStatus](docs/PayoutStatus.md)
 - [org.openapitools.client.models.PeriodUnits](docs/PeriodUnits.md)
 - [org.openapitools.client.models.Processingstatusenum](docs/Processingstatusenum.md)
 - [org.openapitools.client.models.Product](docs/Product.md)
 - [org.openapitools.client.models.Purchase](docs/Purchase.md)
 - [org.openapitools.client.models.PurchaseDetails](docs/PurchaseDetails.md)
 - [org.openapitools.client.models.PurchaseStatus](docs/PurchaseStatus.md)
 - [org.openapitools.client.models.PurchasesCaptureRequest](docs/PurchasesCaptureRequest.md)
 - [org.openapitools.client.models.PurchasesChargeRequest](docs/PurchasesChargeRequest.md)
 - [org.openapitools.client.models.PurchasesMarkAsPaidRequest](docs/PurchasesMarkAsPaidRequest.md)
 - [org.openapitools.client.models.PurchasesRefundRequest](docs/PurchasesRefundRequest.md)
 - [org.openapitools.client.models.Statusenum](docs/Statusenum.md)
 - [org.openapitools.client.models.TransactionFlow](docs/TransactionFlow.md)
 - [org.openapitools.client.models.TransactionProduct](docs/TransactionProduct.md)
 - [org.openapitools.client.models.TransactionRequest](docs/TransactionRequest.md)
 - [org.openapitools.client.models.TransactionResponse](docs/TransactionResponse.md)
 - [org.openapitools.client.models.TransactionStatusResponse](docs/TransactionStatusResponse.md)
 - [org.openapitools.client.models.Transactiontype](docs/Transactiontype.md)
 - [org.openapitools.client.models.Turnover](docs/Turnover.md)
 - [org.openapitools.client.models.TurnoverCount](docs/TurnoverCount.md)
 - [org.openapitools.client.models.TurnoverPair](docs/TurnoverPair.md)
 - [org.openapitools.client.models.UserDTO](docs/UserDTO.md)
 - [org.openapitools.client.models.Webhook](docs/Webhook.md)
 - [org.openapitools.client.models.WebhooksList200Response](docs/WebhooksList200Response.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

All endpoints do not require authorization.
