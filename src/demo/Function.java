package demo;

public class Function {

  private final FunctionArguments arguments;
  private final FunctionBody body;
  private final ExecutionContext context;

  public Function(final FunctionArguments arguments, final FunctionBody body,
      final ExecutionContext context) {
    this.arguments = arguments;
    this.body = body;
    this.context = context;
  }

  public Object execute(final Object... arguments) {
    int i = 0;
    for (final String argumentName : this.arguments.getNames()) {
      if (i < arguments.length) {
        this.context.set(argumentName, arguments[i]);
      } else {
        // TODO: should be undefined
        this.context.set(argumentName, null);
      }
      i++;
    }
    return this.body.execute(this.context);
  }
}
