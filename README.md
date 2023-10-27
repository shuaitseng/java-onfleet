# Onfleet Java Wrapper

Official Java Onfleet API Wrapper
Visit our blog post on the  [API wrapper project](https://onfleet.com/blog/api-wrappers-explained/)  to learn more about our initiatives.
If you have any questions, please reach us by submitting an issue [here](https://github.com/onfleet/java-onfleet/issues) or contact 
[support@onfleet.com](mailto:support@onfleet.com).

## Table of Contents
- [Getting Started](#getting-started)
    - [Installation](#installation)
    - [Authentication](#authentication)
- [Usage](#usage)
    - [Initializing the API Client](#initializing-the-api-client)
    - [Making API Calls](#making-api-calls)
    - [Error Handling](#error-handling)
- [API Reference](#api-reference)
    - [Methods](#methods)
- [Examples](#examples)

## Getting Started

### Supported Java Versions

The Onfleet Java Wrapper is compatible with Java 8 and higher.

### Installation

To use this API wrapper, you need to include it in your Java project. Here's how to do it:

#### Maven Installation

To include your API wrapper as a dependency in a Maven project, add the following dependency 
to your `pom.xml` file:

```xml
<dependencies>
    <dependency>
        <groupId>com.onfleet</groupId>
        <artifactId>java-api-wrapper</artifactId>
        <version>1.0.0</version> <!-- Use the latest version -->
    </dependency>
</dependencies>
```

#### Gradle Installation

For Gradle, you can add the following dependency to your `build.gradle` file:

```groovy
dependencies {
    implementation group: 'com.onfleet', name: 'java-api-wrapper', version: '1.0.0' // Use the latest version
}
```

### Authentication

To use the API wrapper, you need to obtain API credentials from [OnFleet's Dashboard](https://onfleet.com/dashboard#/manage).
Once you have your credentials, you can set them as environment variables or directly in your Java code.

### Throttling

The Onfleet API enforces rate limiting with a threshold of 20 requests per second across all your organization's API keys. Rate limiting is crucial to ensure fair usage of the API and to prevent unintentional overuse that could lead to banning.

We have implemented a rate limiter within this library to help you stay within the rate limitations without the need for manual management. The rate limiter automatically controls the rate at which API requests are made, ensuring compliance with the API's rate limits.

## Getting Started
Create an instance of the `OnFleet` class and initialize it with your OnFleet API key:

```java
OnFleet onFleet = new OnFleet("YOUR_API_KEY");
```

### Start Making API Calls
Once you have initialized the OnFleet instance with your API key, 
you are ready to start making API calls. You can refer to the "Usage" and "API Reference" 
for details on how to interact with the Onfleet API using the Java Wrapper.

That's it! You are now set up to use the Onfleet Java Wrapper to integrate Onfleet's 
functionality into your Java application.

```java
try {
    onFleet.getOrganizationApi().getOrgDetails();
} catch (ApiException e) {
    System.out.println("Http Response code: " + e.getStatusCode());
}
```

### Error Handling

Handle API errors gracefully with the Onfleet Java Wrapper. When an API request fails, the wrapper will throw an `ApiException` that you can catch and handle appropriately. To provide better error handling, you can access the following properties of the `ApiException`:

- `e.getStatusCode()`: Retrieve the HTTP response status code to identify the nature of the error.
- `e.getErrorResponse()`: Access the error response message object sent by the API. It has the following fields
  - `errorResponse().getCode()`: Get the error code associated with the API error.
  - `errorResponse().getMessage()`: Retrieve the error message object.
    - `message().getError()`: Get the error code
    - `message().getMessage()`: Get the error description
    - `message().getCause()`: Access the root cause of the error, if available.
    - `message().getRequest()`: Access the request id.


Here's an example of how to handle API errors:

```java
try {
    // Make an API call
    onFleet.getOrganizationApi.getOrgDetails();
} catch (ApiException e) {
    // Handle the error
    System.out.println("API Error: HTTP Response code - " + e.getStatusCode());
    System.out.println("Error Message: " + e.getErrorResponse().getMessage());
}
```

## Examples
You can find usage examples in the [examples](https://github.com/onfleet/java-onfleet/tree/main/src/examples) folder of this repository. These examples demonstrate how to perform common operations using the API wrapper.
