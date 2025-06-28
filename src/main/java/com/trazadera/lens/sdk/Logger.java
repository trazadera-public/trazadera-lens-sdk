package com.trazadera.lens.sdk;

/**
 * Logger provides a simple interface for logging messages within the Trazadera Lens Agent. It is
 * designed to be used for debugging and logging information in a thread-safe manner.
 *
 * <p>This interface should be implemented by the Trazadera Lens Agent, and it is safe to use from
 * any thread. The logs can be captured and displayed in the Trazadera Lens UI.
 *
 * <p>Note: This interface is intended for use with the Trazadera Lens Agent and should not be
 * implemented by applications directly.
 *
 * <p>Using this logger, you can log messages at different levels:
 *
 * <ul>
 *   <li><strong>debug</strong>: For detailed debugging information.
 *   <li><strong>info</strong>: For general informational messages.
 *   <li><strong>error</strong>: For error messages that indicate a problem.
 *   <li><strong>error with Throwable</strong>: For logging exceptions along with a message.
 * </ul>
 *
 * The methods support variable arguments, allowing you to format messages with additional context.
 * The messages can be formatted using Java String placeholders (e.g., "%s" for strings, "%d" for
 * integers, "%f" for floating-point numbers, etc.).
 *
 * <p>Example usage:
 *
 * <pre>
 *     Logger logger = Context.get().logger();
 *     logger.debug("Debugging information: %s", someVariable);
 *     logger.info("Application started successfully.");
 *     logger.error("An error occurred: %s", errorMessage);
 *     logger.error(new Exception("Something went wrong"), "Exception occurred while processing request: %s", requestId);
 * </pre>
 */
public interface Logger {

  /**
   * Checks if the logger is in debug mode.
   *
   * @return true if debug mode is enabled, false otherwise.
   */
  boolean isDebug();

  /**
   * Logs a debug message with the specified format and arguments.
   *
   * @param message the message format to log, which can include placeholders for arguments.
   * @param args the optional arguments to format the message with.
   */
  void debug(String message, Object... args);

  /**
   * Logs an informational message with the specified format and arguments.
   *
   * @param message the message format to log, which can include placeholders for arguments.
   * @param args the optional arguments to format the message with.
   */
  void info(String message, Object... args);

  /**
   * Logs an error message with the specified format and arguments.
   *
   * @param message the error message format to log, which can include placeholders for arguments.
   * @param args the optional arguments to format the message with.
   */
  void error(String message, Object... args);

  /**
   * Logs a warning message with the specified format and arguments.
   *
   * @param message the warning message format to log, which can include placeholders for arguments.
   * @param args the optional arguments to format the message with.
   */
  void warn(String message, Object... args);

  /**
   * Logs an error message along with a Throwable (exception) with the specified format and
   * arguments.
   *
   * @param t the Throwable to log, which typically represents an exception or error.
   * @param message the error message format to log, which can include placeholders for arguments.
   * @param args the optional arguments to format the message with.
   */
  void error(Throwable t, String message, Object... args);
}
