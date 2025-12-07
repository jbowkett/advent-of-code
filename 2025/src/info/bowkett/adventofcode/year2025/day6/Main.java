package info.bowkett.adventofcode.year2025.day6;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;

public class Main {
  public static void main(String[] args) {
    final File f = new File("/Users/jamesbowkett/coding/my-repos/advent-of-code/2025/src/info/bowkett/adventofcode/year2025/day6/input.txt");

    final List<String> allLines = new ArrayList<>();
    try (final Stream<String> lines = lines(f.toPath())) {
      lines.forEach(allLines::add);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    final Spreadsheet sheet = new Spreadsheet(allLines);
    final var sumTotal = sheet.getSumTotal(false);
    System.out.println("sumTotal = " + sumTotal);
  }
}
