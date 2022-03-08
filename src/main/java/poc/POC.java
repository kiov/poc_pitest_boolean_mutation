package poc;

import java.util.List;
import java.util.function.Consumer;

public class POC {

  public Boolean bad(List<String> data, Consumer<String> operation) {
    return data.stream()
        .map(
            x -> {
              try {
                operation.accept(x);
                return true;
              } catch (RuntimeException e) {
                return false;
              }
            })
        .reduce(true, Boolean::logicalAnd);
  }


  public Boolean good(List<String> data, Consumer<String> operation) {
    return data.stream()
        .map(
            x -> this.goodInner(x, operation))
        .reduce(true, Boolean::logicalAnd);
  }


  public boolean goodInner(String x, Consumer<String> operation) {
    try {
      operation.accept(x);
      return true;
    } catch (RuntimeException e) {
      return false;
    }
  }
}
