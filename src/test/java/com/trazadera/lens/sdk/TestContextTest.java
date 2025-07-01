package com.trazadera.lens.sdk;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class TestContextTest {

  @Test
  public void configuration() {
    Map<String, Object> config = new HashMap<>();
    config.put("hola", "caracola");
    config.put("signal", 12.0);
    TestContext testContext = new TestContext(null, config);
    Configuration cfg = testContext.configuration();
    assertNotNull(cfg);
    assertEquals("caracola", cfg.getProperty("hola"));
    assertEquals(12.0, cfg.getDoubleProperty("signal", -1.0), 0.001);
  }
}
