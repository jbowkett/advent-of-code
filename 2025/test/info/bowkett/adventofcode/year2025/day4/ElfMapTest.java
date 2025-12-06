package info.bowkett.adventofcode.year2025.day4;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class ElfMapTest {

  public static final String INPUT_MAP = """
      ..@@.@@@@.
      @@@.@.@.@@
      @@@@@.@.@@
      @.@@@@..@.
      @@.@@@@.@@
      .@@@@@@@.@
      .@.@.@.@@@
      @.@@@.@@@@
      .@@@@@@@@.
      @.@.@@@.@.
      """;
  public static final String EXPECTED = """
      ..xx.xx@x.
      x@@.@.@.@@
      @@@@@.x.@@
      @.@@@@..@.
      x@.@@@@.@x
      .@@@@@@@.@
      .@.@.@.@@@
      x.@@@.@@@@
      .@@@@@@@@.
      x.x.@@@.x.
      """;

  @Test
  void ensureTheFirstExampleWorks() {

    final String[] linesArray = INPUT_MAP.split("\n");
    final List<String> lines = Arrays.asList(linesArray);

    final ElfMap map = new ElfMap(lines);
    final String availableMap = map.getAvailableMap();
    assertEquals(EXPECTED, availableMap);

  }

  @Test
  void ensureTheCountWorks(){
    final String[] linesArray = INPUT_MAP.split("\n");
    final List<String> lines = Arrays.asList(linesArray);

    final ElfMap map = new ElfMap(lines);
    final long countAvailable = map.countAvailable();
    assertEquals(13, countAvailable);
  }

  @Test
  void ensureIterationWorks(){
    final String[] linesArray = INPUT_MAP.split("\n");
    final List<String> lines = Arrays.asList(linesArray);
    ElfMap map = new ElfMap(lines);
    String currentMap = INPUT_MAP;
    String previousMap;
    do{
      previousMap = currentMap;
      currentMap = map.getAvailableMap();
      map = new ElfMap(Arrays.asList(currentMap.split("\n")));

    }while(!currentMap.equals(previousMap));


    System.out.println("currentMap = " + currentMap);
    final var countBefore = getCount(INPUT_MAP);
    final var countAfter = getCount(currentMap);
    System.out.println("count = " + (countBefore  - countAfter));
  }

  @Test
  void ensureIterationWorksWithTheInputFile(){

    final File f = new File("/Users/jamesbowkett/coding/my-repos/advent-of-code/2025/src/info/bowkett/adventofcode/year2025/day4/input.txt");
    final List<String> linesList = new ArrayList<>();
    final StringBuilder inputBuffer = new StringBuilder();
    try (final Stream<String> lines = lines(f.toPath())) {
      lines.forEach(e -> {
        linesList.add(e);
        inputBuffer.append(e).append("\n");
      });
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    ElfMap map = new ElfMap(linesList);
    String currentMap = INPUT_MAP;
    String previousMap;
    do{
      previousMap = currentMap;
      currentMap = map.getAvailableMap();
      map = new ElfMap(Arrays.asList(currentMap.split("\n")));

    }while(!currentMap.equals(previousMap));


    System.out.println("currentMap = " + currentMap);
    final var countBefore = getCount(inputBuffer.toString());
    final var countAfter = getCount(currentMap);
    System.out.println("count = " + (countBefore  - countAfter));
  }

  private static long getCount(String currentMap) {
    long count = 0;
    for (char c : currentMap.toCharArray()) {
      if(c == '@'){
        count++;
      }
    }
    return count;
  }


}
