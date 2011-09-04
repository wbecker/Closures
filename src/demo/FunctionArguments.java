package demo;

import java.util.Collections;
import java.util.List;

public class FunctionArguments {

  private final List<String> names;

  public FunctionArguments(final List<String> names) {
    this.names = Collections.unmodifiableList(names);
  }

  public List<String> getNames() {
    return this.names;
  }

}
