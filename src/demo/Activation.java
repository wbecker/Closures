package demo;

import java.util.HashMap;
import java.util.Map;

public class Activation {
  private final Map<String, Object> variables;
  private final Activation parentScope;

  public Activation(final Activation parentScope) {
    this.variables = new HashMap<String, Object>();
    this.parentScope = parentScope;
  }

  public void set(final String key, final Object value) {
    this.variables.put(key, value);
  }

  public Object get(final String key) {
    if (this.variables.containsKey(key)) {
      return this.variables.get(key);
    } else if (this.parentScope != null) {
      return this.parentScope.get(key);
    } else {
      // TODO: should be undefined
      return null;
    }
  }
}
