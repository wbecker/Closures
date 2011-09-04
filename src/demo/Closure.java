package demo;

import java.util.Arrays;

public class Closure {
  static ExecutionContext global;
  static {
    Closure.global = new ExecutionContext();
  }

  public static void main(final String[] args) {
    final Function f = new Function(new FunctionArguments(
        Arrays.asList(new String[] { "x", "y" })), new FunctionBody() {

      @Override
      public Object execute(final ExecutionContext context) {
        return (Integer) context.get("x") * (Integer) context.get("y");
      }
    }, Closure.global);
    System.out.println(f.execute(5, 6));
  }

}
