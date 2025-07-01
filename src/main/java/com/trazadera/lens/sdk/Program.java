package com.trazadera.lens.sdk;

import java.time.Instant;
import java.util.Map;

public abstract class Program {

  public Program() {}

  public void metric(Map<String, Object> tuples) {
    if (tuples == null || tuples.isEmpty()) {
      System.err.println("Tuples are null or empty");
      return;
    }
    StringBuilder sb = new StringBuilder();
    sb.append(Instant.now().toString());
    for (Map.Entry<String, Object> tuple : tuples.entrySet()) {
      if (tuple.getKey() == null || tuple.getKey().isEmpty()) {
        System.err.println("Invalid null or empty key in tuples");
        continue;
      }
      final String k = tuple.getKey().replaceAll("[^a-zA-Z0-9_-]", "");
      final String v =
          tuple.getValue() == null ? "" : tuple.getValue().toString().replaceAll(" ", "");
      sb.append(" ");
      sb.append(k);
      sb.append("=");
      sb.append(v);
    }
    System.out.println(sb);
  }

  /**
   * This method is called by the Trazadera Lens Agent to run your program.
   *
   * @param context the Context instance for your program, which provides access to the Trazadera
   *     Lens Agent context.
   */
  public abstract void run(Context context);
}
