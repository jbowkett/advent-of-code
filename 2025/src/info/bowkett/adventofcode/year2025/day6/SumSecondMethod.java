package info.bowkett.adventofcode.year2025.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static info.bowkett.adventofcode.year2025.day6.Type.Addition;
import static info.bowkett.adventofcode.year2025.day6.Type.Multiply;
import static java.lang.Math.max;


public class SumSecondMethod extends Sum {

  public long getResult() {
    long accumulator = 0;

    final var list = values.stream().map(Object::toString).toList();
//    final List<Sum> sums = new ArrayList<>();
    int maxLength = 0; //gives stopping case below
    for (String linesOfNumbers : list) {
      maxLength = max(maxLength, linesOfNumbers.length());
    }

    final List<NumberHolder> numbers = new ArrayList<>();
    for (int i = 0; i < maxLength; i++) {
       numbers.add(new NumberHolder());
    }

    for (int numberIndexInMax = 0; numberIndexInMax < maxLength; numberIndexInMax++) {
      for (String number : list) {
        final int length = number.length();

      }
    }







    return accumulator;
  }
  private static class NumberHolder{

  }
}
