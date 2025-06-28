package com.trazadera.lens.sdk;

import java.util.List;

/**
 * Configuration provides access to the configuration properties of your application.
 * It allows you to retrieve various typed of properties such as <code>String</code>,
 * <code>int</code>, <code>long</code>, <code>boolean</code>, and <code>double</code>.
 * <p>
 * When your program starts, the Trazadera Lens Agent will set the configuration
 * for your application. This configuration is typically provided when configuring
 * the deployment.
 * <p>
 * Note: This interface is intended for use with the Trazadera Lens Agent and should not be
 * implemented by applications directly.
 */
public interface Configuration {

    public List<String> getPropertyKeys();

    public String getProperty(String key);

    public int getIntProperty(String key, int defaultValue);

    public long getLongProperty(String key, long defaultValue);

    public boolean getBooleanProperty(String key, boolean defaultValue);

    public double getDoubleProperty(String key, double defaultValue);
}
