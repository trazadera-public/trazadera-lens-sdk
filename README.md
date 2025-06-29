# trazadera-lens-sdk

The Trazadera Lens Software Development Kit (SDK) is aimed at providing a simple and efficient way to program
code that can be run on top of the Trazadera Lens Agent. It is designed to abstract
as much as possible the underlying operating system and hardware, allowing you to:

- Access specific operating system object, such as Android Context.
- Leverage program configuration.
- Use the Trazadera Lens Agent logging system.
- Understand what is the operating system your program is running on.

## Using the SDK

To use the SDK, you need to add it as a dependency in your project.
Please ensure you have the correct version of the SDK that matches your project requirements.

If using Maven, you can do this by adding the following line to your `pom.xml` file:

```xml

<dependency>
    <groupId>com.trazadera.lens</groupId>
    <artifactId>trazadera-lens-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

If using Gradle, you can add the following line to your `build.gradle` file:

```groovy
dependencies {
    implementation 'com.trazadera.lens:trazadera-lens-sdk:1.0.0'
}
```

Make sure to use Java 8 as the version to ensure compatibility with the Trazadera Lens Agent.

## Creating a program to run on the Trazadera Lens Agent

A Trazadera Lens Agent program is a Java application that can be executed by the Trazadera Lens Agent.
It can be a simple Java class or a more complex application that uses the Trazadera Lens SDK to interact with the
underlying
operating system and surrounding environment.

### Program Requirements

To create a program that can run on the Trazadera Lens Agent, it must adhere to the following requirements:

- It must be a Java application.
- Use Java 8.
- It can extend the `Program` abstract provided by the Trazadera Lens SDK. You just need to implement the `run` method
  and call the `metric` method to generate metrics.
- Alternatively, it can be a standard Java application that defines a `main` method. You can use
  standard output to print metrics in a specific format that the Trazadera Lens Platform can understand.

### Using the context

The Trazadera Lens SDK provides a `Context` class that allows you to access the Trazadera Lens Agent context.
You can use this context to access various resources and services provided by the Trazadera Lens Agent, such as:

- Accessing the configuration of your program.
- Logging messages to the Trazadera Lens Agent logging system.
- Accessing the Android Context if your program is running on an Android device.
- Retrieve the operating system information.

You can obtain the context by calling the `Context.get()` method. This will return an instance of the `Context` class.

If you are extending the `Program` abstract class, you can access the context directly in your `run` method.

### Logging

The Trazadera Lens SDK provides a logging system that allows you to log messages to the Trazadera Lens Agent logging
system.
You can get access to the `Logger` instance by calling `Context.get().getLogger()`. This logger is similar to the
standard Java logging system, but it is designed to work with the Trazadera Lens Agent.

You can use the logger to log messages at different levels, such as:

- `info`: For informational messages.
- `debug`: For debugging messages.
- `error`: For error messages, including optional stack traces.
- `warn`: For warning messages.

The logger will automatically format the messages and send them to the Trazadera Lens Agent for analysis.
It uses the Java String formatting, so you can use placeholders in your log messages, such as

```java
logger.info("This is an info message with a value: %s",value);

Exception exception = new Exception("An error occurred");
logger.

error(exception, "An error occurred: %s",exception.getMessage());
```

The following table contains the usual formatting options for the logger:

| Specifier | Description                        | Example Output |
|-----------|------------------------------------|----------------|
| `%s`      | String                             | `Hello`        |
| `%d`      | Decimal integer                    | `42`           |
| `%f`      | Floating-point (default: 6 digits) | `3.141593`     |
| `%.2f`    | Floating-point with 2 decimals     | `3.14`         |
| `%n`      | Line separator (OS-independent)    | (new line)     |
| `%x`      | Hexadecimal integer                | `2a`           |
| `%e`      | Scientific notation                | `1.23e+03`     |
| `%c`      | Character                          | `A`            |
| `%b`      | Boolean                            | `true`         |

### Configuration

Your program can access its configuration through the Trazadera Lens Agent context.
You can retrieve the configuration by calling `Context.get().configuration()`.
This will return a `Configuration` object that contains the configuration of your program.

The configuration is specific to your program and is defined in the Trazadera Lens Platform.
For example, you can define configuration parameters in the Trazadera Lens Platform such as `wifi_ssid`
or `wifi_db_threshold`, which can be used by your program to access specific values.

Assuming that you have defined the following configuration parameters in the Trazadera Lens Platform:

```properties
wifi_ssid=MyNetwork
wifi_db_threshold=-70
```

You can access these parameters in your program using the `Configuration` object:

```java
String wifiSsid = Context.get().configuration().getProperty("wifi_ssid");
int wifiDbThreshold = Context.get().configuration().getIntProperty("wifi_db_threshold", -80);
```

### Generating Metrics

A program is typically designed to gather metrics, but not limited to. Metrics
are data points that can be collected and analyzed to provide insights into any system.

Metrics can include performance data, resource usage, or any other relevant information. When a program is defined
in the Trazadera Lens Platform, it defines the metrics it will generate.

Your program should be able to generate metrics that match the definitions provided in the Trazadera Lens Platform.
Any metrics generated by your program will be captured and sent to the Trazadera Lens Platform for analysis.
If your program generates unexpected metrics, they will be ignored by the Trazadera Lens Platform.

Metrics should be printed to the standard output in a specific format that the Trazadera Lens Agent can understand:

```
timestamp metric1=value1 metric2=value2 ...
```

Considering the following:

- `timestamp` is the current timestamp UTC ISO 8601 format.
- `metric1`, `metric2`, etc. are the metric keys. Only alphanumeric characters, underscores, and hyphens are allowed.
- `value1`, `value2`, etc. are the corresponding metric values. They can be integers, floating-point numbers, or
  strings.
  Do not include any space.

Example:

```
2023-10-01T12:00:00Z wifi_db=-70 wifi_ssid=MyNetwork cpu_usage=0.75 memory_usage=2048
```

Your metric names and values should not contain spaces or special characters, and should be formatted as key-value
pairs.

