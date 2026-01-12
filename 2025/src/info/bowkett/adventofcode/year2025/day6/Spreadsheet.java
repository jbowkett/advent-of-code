package info.bowkett.adventofcode.year2025.day6;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;

public class Spreadsheet {
  private final List<String> allLines;

  public Spreadsheet(List<String> allLines) {
    this.allLines = allLines;
  }

  public long getSumTotal(boolean useFirstMethod) {
    final var sums = getSums(useFirstMethod);
    long result = 0;
    for (Sum sum : sums) {
      System.out.println(sum);
      result += sum.getResult();
    }
    return result;
  }

  private List<Sum> getSums(boolean useFirstMethod) {
    if (useFirstMethod) {
      return firtstMethod();
    } else {
      return secondMethod();
    }
  }

  private List<Sum> firtstMethod() {
    List<Sum> sums = null;
    for (String line : allLines) {
      final String[] values = line.trim().split("\\s+");
      if (sums == null) {
        sums = new ArrayList<>(values.length);
        for (String _ignored : values) {
          sums.add(new Sum());
        }
      }
      for (int j = 0; j < values.length; j++) {
        final var value = values[j];
        var sum = sums.get(j);

        if (value.equals("*")) {
          sum.setMultiply();
        } else if (value.equals("+")) {
          sum.setAdd();
        } else {
          final var partOfSum = parseInt(value);
          sum.addValue(partOfSum);
        }
      }
    }
    return sums;
  }

  private List<Sum> secondMethod() {
    final var lastLineIndex = allLines.size() - 1;
    final var last = this.allLines.get(lastLineIndex);
    this.allLines.set(lastLineIndex, null);
    char[] charArray = last.toCharArray();
    final List<Integer> indexes = new ArrayList<>();
    final List<Sum> sums = new ArrayList<>();
    for (int i = 0; i < charArray.length; i++) {
      char c = charArray[i];
      if (c == '+') {
        indexes.add(i);
        final var sum = new Sum();
        sum.setAdd();
        sums.add(sum);
      } else if (c == '*') {
        indexes.add(i);
        final var sum = new Sum();
        sum.setMultiply();
        sums.add(sum);
      }
    }
    // add the last index
    indexes.add(charArray.length);

    for (int i = 0; i < indexes.size() - 1; i++) {
      int startIndex = indexes.get(i);
      int nextIndex = indexes.get(i + 1);
      final var sum = sums.get(i);

      for (int j = startIndex; j < nextIndex; j++) {
        final StringBuilder buffer = new StringBuilder();
        for (String line : allLines) {
          if (line != null)
            buffer.append(line.charAt(j));
        }
        final var number = buffer.toString().trim();
        if (!number.isEmpty()) {
          sum.addValue(parseInt(number));
        }
      }
    }
    return sums;
  }
}
