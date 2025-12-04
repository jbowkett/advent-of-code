package info.bowkett.adventofcode.year2025.day3;

public class Bank {
  private final Battery[] batteries;

  public Bank(Battery[] batteries) {
    this.batteries = batteries;
  }

  public long getTotalJoltage() {
    long total = 0;
    for (Battery battery : batteries) {
      total += battery.getMaxJoltage();
    }
    return total;
  }
}
