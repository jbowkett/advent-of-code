package info.bowkett.adventofcode.year2025.day1;

import static java.lang.Integer.parseInt;

public class Dial {

  private static final int MAX = 99;
  public static final char LEFT = 'L';

  private int currentValue = 50;
  private int zeroCount = 0;

  public int getCurrentPosition() {
    return this.currentValue;
  }


  public int rotate(String instruction) {
    final var distanceStr = instruction.substring(1);
    final int distance = parseInt(distanceStr);

    final char direction = instruction.charAt(0);

    for (int i = 0; i < distance; i++) {
      if(direction == LEFT){
        turnLeft();
      }
      else{
        turnRight();
      }
    }
    //part 1 Vs. Part 2
    if(this.currentValue == 0){
      this.zeroCount++;
    }
    return currentValue;
  }

  private void turnLeft() {
    this.currentValue--;
    if(this.currentValue == -1){
      this.currentValue = MAX;
    }
  }

  private void turnRight() {
    this.currentValue++;
    if(this.currentValue > MAX){
      this.currentValue = 0;
    }
  }

  public int getZeroCount() {
    return this.zeroCount;
  }
}
