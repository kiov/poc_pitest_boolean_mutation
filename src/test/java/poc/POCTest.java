package poc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.Test;

class POCTest {

  @Test
  void badTrueTest() {
    List<String> l = new ArrayList<>();
    l.add("A");
    l.add("B");
    l.add("C");
    assertTrue(new POC().bad(l, x -> {}));
  }

  @Test
  void badFalseTest1() {
    List<String> l = new ArrayList<>();
    l.add("A");
    l.add("B");
    l.add("C");
    assertFalse(
        new POC()
            .bad(
                l,
                x -> {
                  if ("B".equals(x)) throw new RuntimeException("error");
                }));
  }

  @Test
  void badFalseTest2() {
    List<String> l = new ArrayList<>();
    l.add("A");
    l.add("B");
    l.add("C");
    assertFalse(
        new POC()
            .bad(
                l,
                x -> {
                  throw new RuntimeException("error");
                }));
  }


  @Test
  void goodTrueTest() {
    List<String> l = new ArrayList<>();
    l.add("A");
    l.add("B");
    l.add("C");
    assertTrue(new POC().good(l, x -> {}));
  }

  @Test
  void goodFalseTest1() {
    List<String> l = new ArrayList<>();
    l.add("A");
    l.add("B");
    l.add("C");
    assertFalse(
        new POC()
            .good(
                l,
                x -> {
                  if ("B".equals(x)) throw new RuntimeException("error");
                }));
  }

  @Test
  void goodFalseTest2() {
    List<String> l = new ArrayList<>();
    l.add("A");
    l.add("B");
    l.add("C");
    assertFalse(
        new POC()
            .good(
                l,
                x -> {
                  throw new RuntimeException("error");
                }));
  }

  @Test
  void goodInnerTrue() {
    AtomicBoolean b = new AtomicBoolean(false);
    assertTrue(new POC().goodInner("A", x->{b.set(true);}));
    assertTrue(b.get());
  }

  @Test
  void goodInnerFalse() {
    assertFalse(new POC().goodInner("A", x->{throw new RuntimeException();}));
  }
}
