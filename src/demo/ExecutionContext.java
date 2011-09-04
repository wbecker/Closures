package demo;

import java.util.HashMap;
import java.util.Map;

public class ExecutionContext {
  private final ExecutionContext parent;
  private final Activation activation;
  private final Map<String, Object> variables;

  public ExecutionContext(final ExecutionContext parent) {
    this.variables = new HashMap<String, Object>();
    this.parent = parent;
    this.activation = new Activation();
    this.setVariable("arguments", new Arguments());
  }

  public void setVariable(final String key, final Object value) {
    this.variables.put(key, value);
  }
}
