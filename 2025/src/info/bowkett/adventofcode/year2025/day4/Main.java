package info.bowkett.adventofcode.year2025.day4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;

public class Main {
  public static void main(String[] args) {
    final File f = new File("/Users/jamesbowkett/coding/my-repos/advent-of-code/2025/src/info/bowkett/adventofcode/year2025/day4/input.txt");
    final List<String> linesList = new ArrayList<>();
    try (final Stream<String> lines = lines(f.toPath())) {
      lines.forEach(linesList::add);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    final ElfMap map = new ElfMap(linesList);
    final var count = map.countAvailable();
    System.out.println("count = " + count);

  }
}
