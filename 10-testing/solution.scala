// Lesson 10: Testing - Solution
// Complete working tests with explanations

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

// ==================== TEST CLASSES ====================

class CalculatorTest {
  
  private val calculator = new Calculator()
  
  @Test
  def testAddition(): Unit = {
    val result = calculator.add(5, 3)
    assertEquals(8, result)
  }
  
  @Test
  def testSubtraction(): Unit = {
    val result = calculator.subtract(10, 4)
    assertEquals(6, result)
  }
  
  @Test
  def testMultiplication(): Unit = {
    val result = calculator.multiply(7, 6)
    assertEquals(42, result)
  }
  
  @Test
  def testDivision(): Unit = {
    val result = calculator.divide(15.0, 3.0)
    assertEquals(5.0, result, 0.001) // delta for double comparison
  }
  
  @Test
  def testDivisionByZero(): Unit = {
    assertThrows(classOf[ArithmeticException], () => {
      calculator.divide(10.0, 0.0)
    })
  }
}

class StringUtilsTest {
  
  @Test
  def testReverse(): Unit = {
    assertEquals("olleh", StringUtils.reverse("hello"))
  }
  
  @Test
  def testReverseEmpty(): Unit = {
    assertEquals("", StringUtils.reverse(""))
  }
  
  @Test
  def testIsPalindromeTrue(): Unit = {
    assertTrue(StringUtils.isPalindrome("racecar"))
    assertTrue(StringUtils.isPalindrome("madam"))
    assertTrue(StringUtils.isPalindrome("level"))
  }
  
  @Test
  def testIsPalindromeFalse(): Unit = {
    assertFalse(StringUtils.isPalindrome("hello"))
    assertFalse(StringUtils.isPalindrome("world"))
    assertFalse(StringUtils.isPalindrome("scala"))
  }
  
  @Test
  def testIsPalindromeWithSpacesAndCase(): Unit = {
    assertTrue(StringUtils.isPalindrome("A man a plan a canal Panama"))
    assertTrue(StringUtils.isPalindrome("Was it a car or a cat I saw"))
  }
  
  @Test
  def testWordCount(): Unit = {
    assertEquals(4, StringUtils.wordCount("The quick brown fox"))
    assertEquals(1, StringUtils.wordCount("Hello"))
    assertEquals(5, StringUtils.wordCount("one two three four five"))
  }
  
  @Test
  def testWordCountEmpty(): Unit = {
    assertEquals(0, StringUtils.wordCount(""))
  }
  
  @Test
  def testWordCountMultipleSpaces(): Unit = {
    assertEquals(2, StringUtils.wordCount("hello    world"))
    assertEquals(2, StringUtils.wordCount("hello  world"))
  }
}

class RectangleTest {
  
  @Test
  def testArea(): Unit = {
    val rect = Rectangle(5.0, 3.0)
    assertEquals(15.0, rect.area, 0.001)
  }
  
  @Test
  def testPerimeter(): Unit = {
    val rect = Rectangle(5.0, 3.0)
    assertEquals(16.0, rect.perimeter, 0.001)
  }
  
  @Test
  def testEquality(): Unit = {
    val rect1 = Rectangle(4.0, 6.0)
    val rect2 = Rectangle(4.0, 6.0)
    assertEquals(rect1, rect2)
    
    val rect3 = Rectangle(5.0, 6.0)
    assertNotEquals(rect1, rect3)
  }
  
  @Test
  def testCopy(): Unit = {
    val rect = Rectangle(5.0, 3.0)
    val wider = rect.copy(width = 10.0)
    assertEquals(10.0, wider.width)
    assertEquals(3.0, wider.height)
    assertEquals(30.0, wider.area, 0.001)
  }
}

// To run these tests, use: scala test solution.scala
// Or with sbt: sbt test
