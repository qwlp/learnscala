// Lesson 10: Testing - Exercise
// Complete the tests below by filling in the ??? sections

import org.junit.jupiter.api._
import org.junit.jupiter.api.Assertions._

// ==================== CLASSES TO TEST ====================

class Calculator {
  def add(a: Int, b: Int): Int = a + b
  def subtract(a: Int, b: Int): Int = a - b
  def multiply(a: Int, b: Int): Int = a * b
  def divide(a: Double, b: Double): Double = {
    if (b == 0) throw new ArithmeticException("Cannot divide by zero")
    a / b
  }
}

object StringUtils {
  def reverse(s: String): String = s.reverse
  
  def isPalindrome(s: String): Boolean = {
    val cleaned = s.toLowerCase.replaceAll("[^a-z0-9]", "")
    cleaned == cleaned.reverse
  }
  
  def wordCount(s: String): Int = {
    if (s.trim.isEmpty) 0
    else s.trim.split("\\s+").length
  }
}

case class Rectangle(width: Double, height: Double) {
  def area: Double = width * height
  def perimeter: Double = 2 * (width + height)
}

// ==================== YOUR TASK ====================
// Complete the test classes below

class CalculatorTest {
  
  // TODO 1: Create a Calculator instance as a field
  private val calculator = new Calculator()
  
  @Test
  def testAddition(): Unit = {
    // TODO 2: Test that 5 + 3 equals 8
    val result = calculator.add(5, 3)
    assertEquals(???, result)
  }
  
  @Test
  def testSubtraction(): Unit = {
    // TODO 3: Test that 10 - 4 equals 6
    ???
  }
  
  @Test
  def testMultiplication(): Unit = {
    // TODO 4: Test that 7 * 6 equals 42
    ???
  }
  
  @Test
  def testDivision(): Unit = {
    // TODO 5: Test that 15.0 / 3.0 equals 5.0
    val result = calculator.divide(15.0, 3.0)
    assertEquals(???, result, 0.001) // delta for double comparison
  }
  
  @Test
  def testDivisionByZero(): Unit = {
    // TODO 6: Test that dividing by zero throws ArithmeticException
    assertThrows(classOf[???], () => {
      calculator.divide(10.0, 0.0)
    })
  }
}

class StringUtilsTest {
  
  @Test
  def testReverse(): Unit = {
    // TODO 7: Test that "hello" reversed is "olleh"
    assertEquals(???, StringUtils.reverse("hello"))
  }
  
  @Test
  def testReverseEmpty(): Unit = {
    // TODO 8: Test that reversing empty string returns empty string
    ???
  }
  
  @Test
  def testIsPalindromeTrue(): Unit = {
    // TODO 9: Test that "racecar" is recognized as a palindrome
    assertTrue(StringUtils.isPalindrome(???))
  }
  
  @Test
  def testIsPalindromeFalse(): Unit = {
    // TODO 10: Test that "hello" is NOT a palindrome
    ???
  }
  
  @Test
  def testIsPalindromeWithSpacesAndCase(): Unit = {
    // TODO 11: Test that "A man a plan a canal Panama" is a palindrome
    // (ignoring spaces and case)
    assertTrue(StringUtils.isPalindrome(???))
  }
  
  @Test
  def testWordCount(): Unit = {
    // TODO 12: Test word count for "The quick brown fox"
    assertEquals(???, StringUtils.wordCount("The quick brown fox"))
  }
  
  @Test
  def testWordCountEmpty(): Unit = {
    // TODO 13: Test that empty string has 0 words
    assertEquals(???, StringUtils.wordCount(""))
  }
  
  @Test
  def testWordCountMultipleSpaces(): Unit = {
    // TODO 14: Test that "hello    world" (with multiple spaces) counts as 2 words
    assertEquals(???, StringUtils.wordCount("hello    world"))
  }
}

class RectangleTest {
  
  @Test
  def testArea(): Unit = {
    // TODO 15: Test area of rectangle 5.0 x 3.0 equals 15.0
    val rect = Rectangle(5.0, 3.0)
    assertEquals(???, rect.area, 0.001)
  }
  
  @Test
  def testPerimeter(): Unit = {
    // TODO 16: Test perimeter of rectangle 5.0 x 3.0 equals 16.0
    ???
  }
  
  @Test
  def testEquality(): Unit = {
    // TODO 17: Test that two rectangles with same dimensions are equal
    val rect1 = Rectangle(4.0, 6.0)
    val rect2 = Rectangle(???, ???)
    assertEquals(rect1, rect2)
  }
  
  @Test
  def testCopy(): Unit = {
    // TODO 18: Test that copy creates a new rectangle with modified values
    val rect = Rectangle(5.0, 3.0)
    val wider = rect.copy(width = 10.0)
    assertEquals(???, wider.width)
    assertEquals(???, wider.height) // height should remain unchanged
  }
}

// To run these tests, use: scala test exercise.scala
// Or with sbt: sbt test
