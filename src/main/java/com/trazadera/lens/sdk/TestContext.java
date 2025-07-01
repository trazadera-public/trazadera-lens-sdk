package com.trazadera.lens.sdk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** A reference context implementation to be used when testing your programs. */
public class TestContext extends Context {

  private final android.content.Context androidContext;
  private final Logger logger = new SimpleLogger();
  private final Configuration configuration;

  public TestContext(android.content.Context androidContext, Map<String, Object> configuration) {
    this.androidContext = androidContext;
    this.configuration = new SimpleConfiguration(configuration);
  }

  @Override
  public android.content.Context androidContext() {
    return androidContext;
  }

  @Override
  public Logger logger() {
    return logger;
  }

  @Override
  public Configuration configuration() {
    return configuration;
  }

  @Override
  public OS os() {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public boolean isAndroid() {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public boolean isDesktop() {
    throw new RuntimeException("Not implemented");
  }

  // Private classes
  // =========================================================================================================

  private class SimpleLogger implements Logger {

    @Override
    public boolean isDebug() {
      return true;
    }

    @Override
    public void debug(String message, Object... args) {
      print("DEBUG", message, args);
    }

    @Override
    public void info(String message, Object... args) {
      print("INFO", message, args);
    }

    @Override
    public void error(String message, Object... args) {
      print("ERROR", message, args);
    }

    @Override
    public void warn(String message, Object... args) {
      print("WARN", message, args);
    }

    @Override
    public void error(Throwable t, String message, Object... args) {
      print("ERROR", message, args);
      t.printStackTrace();
    }

    private void print(String level, String message, Object... args) {
      String m = String.format(message, args);
      System.out.println(level + ": " + m);
    }
  }

  private class SimpleConfiguration implements Configuration {
    private final Map<String, Object> configuration;

    SimpleConfiguration(Map<String, Object> configuration) {
      this.configuration = configuration;
    }

    @Override
    public List<String> getPropertyKeys() {
      List<String> keys = new ArrayList<>();
      keys.addAll(configuration.keySet());
      return keys;
    }

    @Override
    public String getProperty(String key) {
      return configuration.get(key).toString();
    }

    @Override
    public String getStringProperty(String key, String defaultValue) {
      return configuration.getOrDefault(key, defaultValue).toString();
    }

    @Override
    public int getIntProperty(String key, int defaultValue) {
      return Integer.parseInt(
          configuration.getOrDefault(key, Integer.toString(defaultValue)).toString());
    }

    @Override
    public long getLongProperty(String key, long defaultValue) {
      return Long.parseLong(
          configuration.getOrDefault(key, Long.toString(defaultValue)).toString());
    }

    @Override
    public boolean getBooleanProperty(String key, boolean defaultValue) {
      return Boolean.parseBoolean(
          configuration.getOrDefault(key, Boolean.toString(defaultValue)).toString());
    }

    @Override
    public double getDoubleProperty(String key, double defaultValue) {
      return Double.parseDouble(
          configuration.getOrDefault(key, Double.toString(defaultValue)).toString());
    }
  }
}
