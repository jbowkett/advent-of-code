package info.bowkett.adventofcode.year2025.day3;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;

public class Main {
  public static void main(String[] args) {
    final File f = new File("/Users/jamesbowkett/coding/my-repos/advent-of-code/2025/src/info/bowkett/adventofcode/year2025/day3/input.txt");

    try (final Stream<String> lines = lines(f.toPath())) {
      final List<Battery> batteries = new ArrayList<>();

      lines.forEach(line -> {
        final List<Integer> ints = new ArrayList<>();
        for (char c : line.toCharArray()) {
          ints.add(Integer.parseInt(""+c));
        }
        batteries.add(new Battery(ints, 12));
      });

      final Bank b = new Bank(batteries.toArray(new Battery[0]));
      final long totalJoltage = b.getTotalJoltage();
      System.out.println("totalJoltage = " + totalJoltage);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
