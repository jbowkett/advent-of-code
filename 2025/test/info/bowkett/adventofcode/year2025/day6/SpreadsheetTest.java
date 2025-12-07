package info.bowkett.adventofcode.year2025.day6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpreadsheetTest {

  @Test
  void ensureTheFirstExampleWorksWithFirstMethod(){
    final var s = """
        123 328  51 64
         45 64  387 23
          6 98  215 314
        *   +   *   +
        """;
      final Spreadsheet sheet = new Spreadsheet(Arrays.asList(s.split("\n")));
      final long result = sheet.getSumTotal(true);
      assertEquals(4277556, result);
  }

  @Test
  void ensureTheFirstExampleWorksWithSecondMethod(){
    final var stringArray = new String [] {
         "123 328 51 64 ",
         " 45 64 387 23 ",
         "  6 98 215 314",
         "*   +  *   +  "
        };
      final Spreadsheet sheet = new Spreadsheet(Arrays.asList(stringArray));
      final long result = sheet.getSumTotal(false);
      assertEquals(3263827, result);
  }
}
