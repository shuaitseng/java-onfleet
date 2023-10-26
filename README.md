# Onfleet Java Wrapper

Official Java Onfleet API Wrapper
Visit our blog post on the  [API wrapper project](https://onfleet.com/blog/api-wrappers-explained/)  to learn more about our initiatives. If you have any questions, please reach us by submitting an issue  [here](https://github.com/onfleet/java-onfleet/issues)  or contact  [support@onfleet.com](mailto:support@onfleet.com).

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

### Installation

To use this API wrapper, you need to include it in your Java project. Here's how to do it:

#### Maven Installation

To include your API wrapper as a dependency in a Maven project, add the following dependency to your `pom.xml` file:

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

To use the API wrapper, you need to obtain API credentials from [OnFleet's Dashboard](https://onfleet.com/dashboard#/manage). Once you have your credentials, you can set them as environment variables or directly in your Java code.

## Getting Started
Create an instance of the `OnFleet` class and initialize it with your OnFleet API key:

```java
OnFleet onFleet = new OnFleet("YOUR_API_KEY");
```

### Error Handling
Handle API errors gracefully. If an API request fails, the wrapper will throw an `ApiException` that you can catch and handle appropriately.

```java
try {
    // Make an API call
    onFleet.getOrganizationApi.getOrgDetails();
} catch (ApiException e) {
    // Handle the error
    System.out.println("API Error: " + e.getMessage());
}
```

## Examples
You can find usage examples in the examples directory of this repository. These examples demonstrate how to perform common operations using the API wrapper.
