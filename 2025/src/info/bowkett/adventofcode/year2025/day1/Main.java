package info.bowkett.adventofcode.year2025.day1;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;

public class Main {
  public static void main(String[] args) {
    final File f = new File("/Users/jamesbowkett/coding/my-repos/advent-of-code/2025/src/info/bowkett/adventofcode/year2025/day1/input.txt");
    final Dial dial = new Dial();

    try (final Stream<String> lines = lines(f.toPath())) {
      lines.forEach(dial::rotate);
      final int currentPosition = dial.getCurrentPosition();
      final int zeroCount = dial.getZeroCount();

      System.out.println("zeroCount = " + zeroCount);
      System.out.println("currentPosition = " + currentPosition);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
