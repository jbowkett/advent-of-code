package info.bowkett.adventofcode.year2025.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class DialTest {

  @Test
  void ensureItCanParseInstruction() {
    final Dial dial = new Dial();
    final int currentIndex = dial.rotate("L10");
    assertEquals(40, currentIndex);
  }

  @Test
  void quickTest(){
    final Dial dial = new Dial();
    final int currentIndex = dial.rotate("R49");
    dial.rotate("R1");
  }

  @Test
  void ensureItCanCountCorrectlyToTheRight() {
    final Dial dial = new Dial();
    final int currentIndex = dial.rotate("R49");
    assertEquals(99, currentIndex);
    assertEquals(0, dial.getZeroCount());
    assertEquals(0, dial.rotate("R1"));
    assertEquals(1, dial.getZeroCount());

    assertEquals(1, dial.rotate("R1"));

    assertEquals(1, dial.getZeroCount());
    assertEquals(99, dial.rotate("R98"));
    assertEquals(0, dial.rotate("R1"));

    assertEquals(2, dial.getZeroCount());
    assertEquals(0, dial.rotate("100"));
    assertEquals(3, dial.getZeroCount());
    assertEquals(1, dial.rotate("R1"));
    assertEquals(3, dial.getZeroCount());
  }

  @Test
  void ensureItCanRunTheExamples(){
    final Dial dial = new Dial();
    assertEquals(82, dial.rotate("L68"));
    assertEquals(52, dial.rotate("L30"));
    assertEquals(0, dial.rotate("R48"));
    assertEquals(95, dial.rotate("L5"));
    assertEquals(55, dial.rotate("R60"));
    assertEquals(0, dial.rotate("L55"));
    assertEquals(99, dial.rotate("L1"));
    assertEquals(0, dial.rotate("L99"));
    assertEquals(14, dial.rotate("R14"));
    assertEquals(32, dial.rotate("L82"));

    assertEquals(3, dial.getZeroCount());
  }


  @Test
  void ensureItCanCountCorrectlyWithMultipleTurns(){
    assertEquals(99, new Dial().rotate("R49"));
    assertEquals(0, new Dial().rotate("R50"));
    assertEquals(1, new Dial().rotate("R51"));
    assertEquals(51, new Dial().rotate("R101"));
    assertEquals(91, new Dial().rotate("R141"));
    assertEquals(97, new Dial().rotate("R147"));
    assertEquals(98, new Dial().rotate("R148"));
    assertEquals(99, new Dial().rotate("R149"));
  }

  @Test
  void ensureItMaintainsStateBetweenInstructions() {
    final Dial dial = new Dial();
    int currentIndex = dial.rotate("L10");
    assertEquals(40, currentIndex);
    currentIndex = dial.rotate("R20");
    assertEquals(60, currentIndex);
  }

  @Test
  void ensureWhenItGoesPastZeroItWrapsAround() {
    final Dial dial = new Dial();
    int currentIndex = dial.rotate("L60");
    assertEquals(90, currentIndex);
  }

  @Test
  void ensureWhenItGoesPastZeroItKeepsCountInBothDirections() {
    final Dial dial = new Dial();
    dial.rotate("L51");
    dial.rotate("R2");
    dial.rotate("L3");
  }

  @Test
  void ensureWhenItGoesPastZeroMultipleTimesInOneDirectionItKeepsCount() {
    final Dial dial = new Dial();
    dial.rotate("L151");
  }

  @Test
  void ensureWhenItLandsOnZeroItDoesntCountThatUntilItMovesPastZero() {
    final Dial dial = new Dial();
    dial.rotate("L50");
    assertEquals(1, dial.getZeroCount());
    dial.rotate("L1");
    assertEquals(1, dial.getZeroCount());
  }
}
