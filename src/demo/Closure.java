package demo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Closure {
  static ExecutionContext global;
  static {
    Closure.global = new ExecutionContext();
  }

  public static void main(final String[] args) {
    Closure.simple();
    Closure.withClosure();
    Closure.curry();
  }

  public static void simple() {
    final Function f = Closure.createMultiplier();
    System.out.println(f.execute(5, 6));
  }

  public static void curry() {
    final Function f = Closure.createMultiplier();
    final Function c = Closure.curry(f, 5);
    System.out.println(c.execute(6));
  }

  private static Function curry(final Function f, final Object value) {
    final List<String> remaining = new LinkedList<String>(f.getArguments()
        .getNames());
    final String name = remaining.remove(0);
    final Function c = new Function(new FunctionArguments(remaining),
        new FunctionBody() {
          @Override
          public Object execute(final ExecutionContext context) {
            context.set(name, value);
            return f.getBody().execute(context);
          }
        }, f.getContext());
    return c;
  }

  private static Function createMultiplier() {
    return new Function(new FunctionArguments(Arrays.asList(new String[] { "x",
        "y" })), new FunctionBody() {

      @Override
      public Object execute(final ExecutionContext context) {
        return (Integer) context.get("x") * (Integer) context.get("y");
      }
    }, Closure.global);

  }

  public static void withClosure() {
    final Function f = new Function(new FunctionArguments(
        Arrays.asList(new String[] { "x" })), new FunctionBody() {

      @Override
      public Object execute(final ExecutionContext context) {
        return new Function(new FunctionArguments(
            Arrays.asList(new String[] { "y" })), new FunctionBody() {

          @Override
          public Object execute(final ExecutionContext context) {

            return (Integer) context.get("x") * (Integer) context.get("y");
          }
        }, context);
      }
    }, Closure.global);
    System.out.println(((Function) f.execute(5)).execute(6));
  }

}
