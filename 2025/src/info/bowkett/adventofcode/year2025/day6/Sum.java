package info.bowkett.adventofcode.year2025.day6;

import java.util.ArrayList;
import java.util.List;

import static info.bowkett.adventofcode.year2025.day6.Type.Addition;
import static info.bowkett.adventofcode.year2025.day6.Type.Multiply;

enum Type {
  Addition("+") , Multiply("*");

  private final String s;

  Type(String s) {
    this.s = s;
  }
  public String toString() {
    return this.s;
  }
}

public class Sum {
  Type type = null;
  protected final List<Integer> values = new ArrayList<>();

  public void setMultiply() {
    this.type = Multiply;
  }

  public void setAdd() {
    this.type = Addition;
  }

  public void addValue(int partOfSum) {
    values.add(partOfSum);
  }

  public long getResult() {
    long accumulator = values.get(0);
    for (int i = 1; i < values.size(); i++) {
      Integer value = values.get(i);
      if (this.type == Multiply) {
        accumulator *= value;
      } else if (this.type == Addition) {
        accumulator += value;
      }
    }
    return accumulator;
  }
  public String toString(){
    final StringBuilder buffer = new StringBuilder();
    buffer.append(values.get(0));
    for (int i = 1; i < values.size(); i++) {
      buffer.append(type).append(values.get(i));
    }
    return buffer.toString();
  }
}
