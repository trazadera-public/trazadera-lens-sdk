package com.trazadera.lens.sdk;

import java.util.List;

/**
 * Configuration provides access to the configuration properties of your application. It allows you
 * to retrieve various typed of properties such as <code>String</code>, <code>int</code>, <code>long
 * </code>, <code>boolean</code>, and <code>double</code>.
 *
 * <p>When your program starts, the Trazadera Lens Agent will set the configuration for your
 * application. This configuration is typically provided when configuring the deployment.
 *
 * <p>Note: This interface is intended for use with the Trazadera Lens Agent and should not be
 * implemented by applications directly.
 */
public interface Configuration {

  /**
   * Returns a list of all property keys available in the configuration.
   *
   * @return a list of property keys, never null.
   */
  List<String> getPropertyKeys();

  /**
   * Returns the value of a property as a <code>String</code>. If the property does not exist, it
   * returns null;
   *
   * @param key The key of the property.
   * @return The property value as a <code>String</code>, or null if the property does not exist.
   */
  String getProperty(String key);

  /**
   * Returns the value of a property as a <code>String</code>. If the property does not exist, it
   * returns the default value.
   *
   * @param key The key of the property.
   * @param defaultValue The default value to return if the property does not exist.
   * @return The property value as a <code>String</code>, or the default value if the property does
   *     not exist.
   */
  String getStringProperty(String key, String defaultValue);

  /**
   * Returns the value of a property as an <code>int</code>. If the property does not exist, it
   * returns the default value.
   *
   * @param key The key of the property.
   * @param defaultValue The default value to return if the property does not exist.
   * @return The property value as an <code>int</code>, or the default value if the property does
   *     not exist.
   */
  int getIntProperty(String key, int defaultValue);

  /**
   * Returns the value of a property as a <code>long</code>. If the property does not exist, it
   * returns the default value.
   *
   * @param key The key of the property.
   * @param defaultValue The default value to return if the property does not exist.
   * @return The property value as a <code>long</code>, or the default value if the property does
   *     not exist.
   */
  long getLongProperty(String key, long defaultValue);

  /**
   * Returns the value of a property as a <code>boolean</code>. If the property does not exist, it
   * returns the default value.
   *
   * @param key The key of the property.
   * @param defaultValue The default value to return if the property does not exist.
   * @return The property value as a <code>boolean</code>, or the default value if the property does
   *     not exist.
   */
  boolean getBooleanProperty(String key, boolean defaultValue);

  /**
   * Returns the value of a property as a <code>double</code>. If the property does not exist, it
   * returns the default value.
   *
   * @param key The key of the property.
   * @param defaultValue The default value to return if the property does not exist.
   * @return The property value as a <code>double</code>, or the default value if the property does
   *     not exist.
   */
  double getDoubleProperty(String key, double defaultValue);
}
