# Lesson 10: Testing with JUnit and ScalaTest

## Lesson

### Why Test?

Testing ensures your code works correctly and helps prevent bugs. In Scala, we can use:
- **JUnit 5**: Standard Java testing framework, works well with Scala
- **ScalaTest**: Scala-native testing framework with more idiomatic syntax

### Setting Up Testing

For this lesson, you'll need to add dependencies. Create a `build.sbt` file:

```scala
// build.sbt
scalaVersion := "3.3.1"

// JUnit 5
libraryDependencies += "org.junit.jupiter" % "junit-jupiter" % "5.10.0" % Test
libraryDependencies += "org.junit.platform" % "junit-platform-console-standalone" % "1.10.0" % Test

// ScalaTest (alternative to JUnit)
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.17" % Test
```

### JUnit 5 Basics

```scala
import org.junit.jupiter.api._
import org.junit.jupiter.api.Assertions._

class CalculatorTest {
  
  @Test
  def testAddition(): Unit = {
    val result = 2 + 2
    assertEquals(4, result, "2 + 2 should equal 4")
  }
  
  @Test
  def testMultiplication(): Unit = {
    assertEquals(6, 2 * 3)
  }
}
```

### Common Assertions

```scala
// Equality
assertEquals(expected, actual)
assertNotEquals(unexpected, actual)

// Boolean
assertTrue(condition)
assertFalse(condition)

// Null checks
assertNull(object)
assertNotNull(object)

// Same object reference
assertSame(expected, actual)

// Exceptions
assertThrows(classOf[IllegalArgumentException], () => {
  throw new IllegalArgumentException("error")
})
```

### Test Lifecycle

```scala
class LifecycleTest {
  
  @BeforeAll
  def setUpClass(): Unit = {
    println("Runs once before all tests")
  }
  
  @BeforeEach
  def setUp(): Unit = {
    println("Runs before each test")
  }
  
  @Test
  def test1(): Unit = { }
  
  @Test
  def test2(): Unit = { }
  
  @AfterEach
  def tearDown(): Unit = {
    println("Runs after each test")
  }
  
  @AfterAll
  def tearDownClass(): Unit = {
    println("Runs once after all tests")
  }
}
```

### Testing Scala Code

**Testing Functions:**

```scala
object MathUtils {
  def factorial(n: Int): Int = {
    if (n < 0) throw new IllegalArgumentException("n must be non-negative")
    if (n == 0) 1 else n * factorial(n - 1)
  }
  
  def isEven(n: Int): Boolean = n % 2 == 0
}

class MathUtilsTest {
  @Test
  def testFactorialOfZero(): Unit = {
    assertEquals(1, MathUtils.factorial(0))
  }
  
  @Test
  def testFactorialOfFive(): Unit = {
    assertEquals(120, MathUtils.factorial(5))
  }
  
  @Test
  def testFactorialNegativeThrows(): Unit = {
    assertThrows(classOf[IllegalArgumentException], () => {
      MathUtils.factorial(-1)
    })
  }
  
  @Test
  def testIsEven(): Unit = {
    assertTrue(MathUtils.isEven(4))
    assertFalse(MathUtils.isEven(5))
  }
}
```

**Testing Collections:**

```scala
class CollectionsTest {
  @Test
  def testListOperations(): Unit = {
    val numbers = List(1, 2, 3, 4, 5)
    
    assertEquals(5, numbers.length)
    assertEquals(List(2, 4, 6, 8, 10), numbers.map(_ * 2))
    assertEquals(List(2, 4), numbers.filter(_ % 2 == 0))
  }
}
```

**Testing Case Classes:**

```scala
case class Person(name: String, age: Int)

class PersonTest {
  @Test
  def testEquality(): Unit = {
    val p1 = Person("Alice", 30)
    val p2 = Person("Alice", 30)
    val p3 = Person("Bob", 30)
    
    assertEquals(p1, p2)
    assertNotEquals(p1, p3)
  }
  
  @Test
  def testCopy(): Unit = {
    val person = Person("Alice", 30)
    val older = person.copy(age = 31)
    
    assertEquals("Alice", older.name)
    assertEquals(31, older.age)
  }
}
```

### ScalaTest Alternative

ScalaTest offers more idiomatic syntax:

```scala
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CalculatorSpec extends AnyFlatSpec with Matchers {
  
  "A Calculator" should "add two numbers" in {
    2 + 2 shouldEqual 4
  }
  
  it should "multiply two numbers" in {
    2 * 3 shouldEqual 6
  }
  
  it should "throw exception for negative factorial" in {
    an [IllegalArgumentException] should be thrownBy {
      MathUtils.factorial(-1)
    }
  }
}
```

### Running Tests

**With sbt:**
```bash
# Run all tests
sbt test

# Run specific test class
sbt "testOnly CalculatorTest"

# Run with continuous testing (reruns on file change)
sbt ~test
```

**With Scala CLI:**
```bash
# Run tests in a file
scala test exercise.scala
```

### Best Practices

1. **Test one thing at a time**: Each test should verify a single behavior
2. **Use descriptive names**: `testAddition` is okay, `addingTwoPositiveNumbersReturnsCorrectSum` is better
3. **Arrange-Act-Assert** pattern:
   - Arrange: Set up test data
   - Act: Execute the code being tested
   - Assert: Verify the results
4. **Test edge cases**: Empty collections, null values, boundary conditions
5. **Keep tests independent**: Tests should not depend on each other

## Assignment

Complete the exercise in `exercise.scala`. Your tasks:

1. Write tests for a `Calculator` class with methods: `add`, `subtract`, `multiply`, `divide`
2. Test edge cases: division by zero, very large numbers
3. Write tests for a `StringUtils` object with methods: `reverse`, `isPalindrome`, `wordCount`
4. Test a case class `Rectangle` with `area` and `perimeter` methods
5. Practice the Arrange-Act-Assert pattern

Run with: `sbt test` or `scala test exercise.scala`

Check your answer against `solution.scala`
