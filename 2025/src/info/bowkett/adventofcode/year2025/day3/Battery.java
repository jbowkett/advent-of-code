package info.bowkett.adventofcode.year2025.day3;

import java.util.Arrays;
import java.util.List;

public class Battery {
  private final int[] joltageValues;
  private final int maxCells;

  public Battery(int [] joltageValues, int maxCells) {
    this.joltageValues = joltageValues;
    this.maxCells = maxCells;
  }

  public Battery(List<Integer> joltageValues, int maxCells){
    this(getInts(joltageValues), maxCells);
  }

  private static int[] getInts(List<Integer> joltageValues) {
    final int [] vals = new int[joltageValues.size()];
    for (int i = 0; i < vals.length; i++) {
      vals[i] = joltageValues.get(i);
    }
    return vals;
  }


  public long getMaxJoltage() {
    final StringBuilder values = new StringBuilder();
    int[] nextSectionOfArray = joltageValues;
    for (int i = (maxCells - 1); i >= 0; i--) {
      int leftmostIndex = getLeftmostIndex(values, nextSectionOfArray, i);
      nextSectionOfArray = Arrays.copyOfRange(nextSectionOfArray, leftmostIndex+1, nextSectionOfArray.length);
    }


    return Long.parseLong(values.toString());
  }

  private int getLeftmostIndex(StringBuilder values, int[] joltageValuesArray, int amountOfSpaceToLeaveAtEnd) {
    int maxLeftMost = joltageValuesArray[0];
    int leftmostIndex = 0;
    for (int i = 1; i < joltageValuesArray.length ; i++) {
      final int amountOfSpaceLeftAtEnd = joltageValuesArray.length - i;
      if(amountOfSpaceLeftAtEnd <= amountOfSpaceToLeaveAtEnd){
        break;
      }
      if(joltageValuesArray[i] > maxLeftMost){
        maxLeftMost = joltageValuesArray[i];
        leftmostIndex = i;
      }
    }

    values.append(maxLeftMost);
    return leftmostIndex;
  }
}
