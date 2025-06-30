package com.trazadera.lens.sdk;

public class ProgramExecutionRuntime {

  public String getCurrentWifiNetwork() { return null; }
  public Coordinate getCurrentLocation() { return null; }
  public double getCurrentSignalStrength() { return 0.0; }
  public long getCurrentLatencyMs() { return 0L; }

  public static class Coordinate {
    public double latitude;
    public double longitude;

    public Coordinate(double latitude, double longitude) {
      this.latitude = latitude;
      this.longitude = longitude;
    }

    @Override
    public String toString() {
      return latitude + "," + longitude;
    }
  }

  public void log(String message) {
    System.out.println(message);
  }

  public void logError(String message, Throwable t) {
    System.err.println(message);
    if (t != null) t.printStackTrace(System.err);
  }
}