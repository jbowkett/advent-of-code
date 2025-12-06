package info.bowkett.adventofcode.year2025.day4;

import java.util.Arrays;
import java.util.List;

public class ElfMap {
  private final List<String> lines;
  private final char [][] linesArray;
  public ElfMap(List<String> lines) {
    this.lines = lines;
    linesArray = new char[lines.size()][];
    int index = 0;
    for (String line : lines) {
      linesArray[index] = line.toCharArray();
      index++;
    }
  }

  public String getAvailableMap() {
    final StringBuilder buffer = new StringBuilder();
    for (int lineIndex = 0; lineIndex < linesArray.length; lineIndex++) {
      final char[] line = linesArray[lineIndex];
      for (int columnIndex = 0; columnIndex < line.length; columnIndex++) {
        final char c = line[columnIndex];
        if (c == '@') {
          final Character [] adjacentCells = getAdjacentCells(lineIndex, columnIndex);
          final long adjacentRolls = count(adjacentCells, '@');
          if(adjacentRolls < 4){
            buffer.append('x');
          }
          else{
            buffer.append('@');
          }
        } else {
          buffer.append('.');
        }
      }
      buffer.append("\n");
    }
    return buffer.toString();
  }



  public long count(Character[] adjacentCells, char characterToCount) {
    return Arrays.stream(adjacentCells).filter( c -> c != null && c == characterToCount).count();
  }

  private Character[] getAdjacentCells(int lineIndex, int columnIndex) {
    final boolean hasLineAbove = lineIndex > 0;
    final boolean hasLineBelow = lineIndex < linesArray.length -1;
    final boolean hasLeft = columnIndex > 0;
    final boolean hasRight = columnIndex < linesArray.length -1;
    final int aboveIndex = lineIndex - 1;
    final int leftIndex = columnIndex - 1;
    final int rightIndex = columnIndex + 1;
    final int bottomIndex = lineIndex + 1;
    final Character aboveLeft = hasLineAbove && hasLeft ? linesArray[aboveIndex][leftIndex] : null;
    final Character aboveMiddle = hasLineAbove ? linesArray[aboveIndex][columnIndex] : null;
    final Character aboveRight = hasLineAbove && hasRight ? linesArray[aboveIndex][rightIndex] : null;
    final Character right = hasRight ? linesArray[lineIndex][rightIndex] : null;
    final Character bottomRight = hasLineBelow && hasRight ? linesArray[bottomIndex][rightIndex]:null;
    final Character bottom = hasLineBelow ? linesArray[bottomIndex][columnIndex] : null;
    final Character bottomLeft = hasLineBelow && hasLeft ? linesArray[bottomIndex][leftIndex] : null;
    final Character left = hasLeft ? linesArray[lineIndex][leftIndex] : null;
    return new Character[]{aboveLeft, aboveMiddle, aboveRight, right, bottomRight, bottom, bottomLeft, left};
  }

  public long countAvailable() {
    final String availableMap = getAvailableMap();
    long count = 0;
    for (char c : availableMap.toCharArray()) {
      if(c == 'x'){
        count++;
      }
    }
    return count;
  }
}
