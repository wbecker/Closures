package demo;

public class ExecutionContext {
  private final Activation scope;

  public ExecutionContext() {
    this(null);
  }

  public ExecutionContext(final Activation parentScope) {
    this.scope = new Activation(parentScope);
    this.scope.set("arguments", new Arguments());
  }

  public Activation getScope() {
    return this.scope;
  }

  public Object get(final String key) {
    return this.scope.get(key);
  }

  public void set(final String key, final Object value) {
    this.scope.set(key, value);
  }
}
