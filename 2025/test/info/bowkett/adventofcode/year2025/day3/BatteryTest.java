package info.bowkett.adventofcode.year2025.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BatteryTest {

  @Test
  void ensureTheFirstExampleWorks(){
    final Battery Battery = new Battery(new int[]{9,8,7,6,5,4,3,2,1,1,1,1,1,1,1}, 2);
    assertEquals(98, Battery.getMaxJoltage());
  }

  @Test
  void ensureTheSecondExampleWorks(){
    final Battery Battery = new Battery(new int[]{8,1,1,1,1,1,1,1,1,1,1,1,1,1,9}, 2);
    assertEquals(89, Battery.getMaxJoltage());
  }

  @Test
  void ensureTheThirdExampleWorks(){
    final Battery Battery = new Battery(new int[]{2,3,4,2,3,4,2,3,4,2,3,4,2,7,8}, 2);
    assertEquals(78, Battery.getMaxJoltage());
  }

  @Test
  void ensureTheFourthExampleWorks(){
    final Battery Battery = new Battery(new int[]{8,1,8,1,8,1,9,1,1,1,1,2,1,1,1}, 2);
    assertEquals(92, Battery.getMaxJoltage());
  }  @Test
  void ensureTheSecondFirstExampleWorks(){
    final Battery Battery = new Battery(new int[]{9,8,7,6,5,4,3,2,1,1,1,1,1,1,1}, 12);
    assertEquals(987654321111L, Battery.getMaxJoltage());
  }

  @Test
  void ensureTheSecondSecondExampleWorks(){
    final Battery Battery = new Battery(new int[]{8,1,1,1,1,1,1,1,1,1,1,1,1,1,9}, 12);
    assertEquals(811111111119L, Battery.getMaxJoltage());
  }

  @Test
  void ensureTheSecondThirdExampleWorks(){
    final Battery Battery = new Battery(new int[]{2,3,4,2,3,4,2,3,4,2,3,4,2,7,8}, 12);
    assertEquals(434234234278L, Battery.getMaxJoltage());
  }

  @Test
  void ensureTheSecondFourthExampleWorks(){
    final Battery Battery = new Battery(new int[]{8,1,8,1,8,1,9,1,1,1,1,2,1,1,1}, 12);
    assertEquals(888911112111L, Battery.getMaxJoltage());
  }
}
