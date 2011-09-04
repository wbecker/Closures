package demo;

public class Closure {
  public static void main(final String[] args) {

  }

  ExecutionContext ec;

  public void execute(final ExecutionContext parent) {
    this.ec = new ExecutionContext(parent);
  }
}
