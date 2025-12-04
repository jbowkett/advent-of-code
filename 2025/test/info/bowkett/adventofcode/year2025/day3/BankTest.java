package info.bowkett.adventofcode.year2025.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

  @Test
  void ensureTheOverallExampleWorks(){
    final Battery [] batteries = new Battery[]{
        new Battery(new int[]{9,8,7,6,5,4,3,2,1,1,1,1,1,1,1}, 2),
        new Battery(new int[]{8,1,1,1,1,1,1,1,1,1,1,1,1,1,9}, 2),
        new Battery(new int[]{2,3,4,2,3,4,2,3,4,2,3,4,2,7,8}, 2),
        new Battery(new int[]{8,1,8,1,8,1,9,1,1,1,1,2,1,1,1}, 2)
    };
    final Bank bank = new Bank(batteries);
    assertEquals(357, bank.getTotalJoltage());
  }
}
