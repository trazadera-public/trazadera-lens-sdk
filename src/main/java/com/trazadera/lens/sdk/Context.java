package com.trazadera.lens.sdk;

/**
 * Context provides access to the Trazadera Lens Agent application context. It is used to access the
 * Android context, logger, and configuration.
 *
 * <p>This class is designed to be used in a thread-local manner, allowing different threads to have
 * their own context without interference. Your application can assume that the context is fully
 * initialized, and it will be available for the duration of the thread's execution.
 *
 * <p>Note: This class is abstract and must be implemented only by the Trazadera Lens Agent.
 */
public abstract class Context {
  static final ThreadLocal<Context> threadLocal = new ThreadLocal<>();

  // Builders
  // ============================================================

  /**
   * Retrieves the current context from the thread local. When your program starts, this context
   * will be set by the Trazadera Lens Agent.
   *
   * @return the current Context instance for the thread, or null if not set.
   */
  public static Context get() {
    return threadLocal.get();
  }

  // Accessors
  // ============================================================

  /**
   * Returns the Android application context. If the application is not running on Android, this
   * method will return null. This context is typically used for accessing Android resources. You
   * should always check if running on Android before using this method using {@link #isAndroid()}.
   *
   * @return the Android application context if available, or null if not set.
   */
  public abstract android.content.Context androidContext();

  /**
   * Returns the logger instance for logging messages. This logger is typically used for debugging
   * and logging information within the Trazadera Lens Agent. This logger is safe to use from any
   * thread, and it is designed to work with the Trazadera Lens Agent's so the logs can be properly
   * captured and displayed in the Trazadera Lens UI.
   *
   * @return the Logger instance for logging. Never null.
   */
  public abstract Logger logger();

  /**
   * Returns the configuration for your program. The configuration depends on your program and is
   * provided when configuring a deployment.
   *
   * @return the Configuration instance for your program. Never null.
   */
  public abstract Configuration configuration();

  /**
   * Returns the operating system on which the application is running. This method is used to
   * determine the platform and can be used to tailor behavior based on the OS.
   *
   * @return the OS enum representing the current operating system.
   */
  public abstract OS os();

  /**
   * Checks if the application is running on Android. This method is used to determine if the
   * context is suitable for Android-specific operations.
   *
   * @return true if the application is running on Android, false otherwise.
   */
  public abstract boolean isAndroid();

  /**
   * Checks if the application is running on a desktop environment. This method is used to determine
   * if the context is suitable for desktop-specific operations. A desktop environment is typically
   * defined as a non-mobile platform, consisting of Windows, Linux, or macOS.
   *
   * @return true if the application is running on a desktop environment, false otherwise.
   */
  public abstract boolean isDesktop();

  /**
   * Represents the operating system on which the application is running.
   *
   * @return the OS enum representing the current operating system. If the OS is not recognized, it
   *     will return OTHER.
   */
  public enum OS {
    ANDROID,
    WINDOWS,
    LINUX,
    MAC,
    OTHER
  }
}
