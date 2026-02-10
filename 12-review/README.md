# Lesson 12: Consolidation and Review

## Course Review

### Key Concepts Recap

#### Lesson 00-01: Scala Basics
- **REPL**: Interactive shell for experimentation (`:type`, `:save`, `:load`)
- **Variables**: `val` (immutable) vs `var` (mutable) - prefer `val`
- **Type inference**: Scala infers types, but explicit types improve readability
- **Type conversions**: `.toInt`, `.toDouble`, `.toString`
- **String interpolation**: `s"Hello $name"` and `raw"No escape \n"`

#### Lesson 02: Functions
- **Syntax**: `def name(param: Type): ReturnType = body`
- **Named parameters**: `greet(name = "Alice", greeting = "Hi")`
- **Default values**: `def repeat(s: String, times: Int = 1)`
- **Anonymous functions**: `(x: Int) => x * 2`
- **Underscore shorthand**: `List(1,2,3).map(_ * 2)`

#### Lesson 03: Flow Control
- **Ranges**: `1 to 5`, `1 until 5`, `1 to 10 by 2`
- **Foreach**: `numbers.foreach(println)`
- **Recursion**: Preferred over loops in functional Scala
- **Conditionals as expressions**: `val result = if (x > 0) "positive" else "negative"`

#### Lesson 04: Data Structures
- **Arrays**: Mutable, indexed collections `Array(1, 2, 3)`
- **Maps**: Key-value stores `Map("a" -> 1, "b" -> 2)`
- **Sets**: Unordered, unique elements `Set(1, 2, 3)`
- **Tuples**: Fixed-size, mixed types `(1, "hello", true)`
- **Destructuring**: `val (x, y) = point`

#### Lesson 05: Object-Oriented Programming
- **Classes**: Blueprint with fields and methods
- **Objects**: Singletons - one instance only
- **Case classes**: Immutable data with auto-generated methods
- **Traits**: Interfaces with optional implementations
- **Mixins**: Combine multiple traits with `extends Trait1 with Trait2`

#### Lesson 06: Pattern Matching
- **Match expressions**: `x match { case 1 => "one" case _ => "other" }`
- **Case class matching**: Extract fields automatically
- **Type matching**: `case s: String => s.length`
- **Guards**: `case n if n > 0 => "positive"`
- **Regular expressions**: Extract groups with pattern matching

#### Lesson 07: Functional Programming
- **Higher-order functions**: Functions that take/return functions
- **Map**: Transform each element `list.map(_ * 2)`
- **Filter**: Keep elements matching predicate `list.filter(_ > 5)`
- **Reduce/Fold**: Combine elements `list.reduce(_ + _)`
- **For-comprehensions**: Sugar for map/flatMap/filter

#### Lesson 08: Implicits
- **Implicit values**: Automatically provided parameters
- **Type classes**: Add behavior to existing types
- **Implicit conversions**: Transform types automatically (use sparingly)

#### Lesson 09: Miscellaneous
- **Import styles**: `import pkg._`, `import pkg.{Class => Alias}`
- **Entry points**: `def main(args: Array[String])` or `extends App`
- **File I/O**: `Source.fromFile()` and `PrintWriter`
- **Resource management**: Use try-finally for cleanup

#### Lesson 10: Testing
- **JUnit 5**: Java testing framework with Scala
- **Assertions**: `assertEquals`, `assertTrue`, `assertThrows`
- **Test lifecycle**: `@BeforeEach`, `@AfterEach`, `@BeforeAll`
- **Testing pattern**: Arrange - Act - Assert

#### Lesson 11: Case Studies
- **Data processing**: Parse, transform, aggregate
- **State management**: Classes with mutable state
- **Functional trees**: Recursive data structure processing

## Idiomatic Scala Best Practices

### DO ✅
- Use `val` over `var` (immutability by default)
- Prefer pattern matching over if-else chains
- Use Option for potentially missing values
- Leverage type inference, but add explicit types for public APIs
- Write pure functions (no side effects)
- Use for-comprehensions for sequential operations
- Handle errors gracefully with Try/Success/Failure

### DON'T ❌
- Use null (use Option instead)
- Use return keyword (Scala returns last expression)
- Write Java-style code in Scala
- Overuse implicits (they can make code hard to understand)
- Ignore warnings and deprecation notices

## Capstone Project: Student Grade Management System

### Requirements

Build a complete student grade management system that demonstrates all concepts learned.

**Features:**
1. **Data Models**: Student, Course, Grade (case classes)
2. **Data Loading**: Read student data from CSV file
3. **CRUD Operations**: Add, remove, update students and grades
4. **Statistics**: Calculate averages, find top performers
5. **Reporting**: Generate formatted reports
6. **Persistence**: Save and load data
7. **Testing**: Unit tests for core functionality

### Architecture

```
StudentGradeSystem/
├── models/
│   ├── Student.scala
│   ├── Course.scala
│   └── Grade.scala
├── services/
│   ├── DataService.scala    # File I/O
│   ├── GradeService.scala   # Business logic
│   └── ReportService.scala  # Reporting
└── Main.scala               # Entry point
```

### Starter Code Structure

The `exercise.scala` file provides:
- Data models with TODOs for methods
- Service classes with method stubs
- Main application with integration points
- Comments indicating what to implement

### Evaluation Criteria

Your solution should demonstrate:
- ✅ Proper use of case classes and pattern matching
- ✅ Functional programming techniques (map, filter, reduce)
- ✅ File I/O with proper resource management
- ✅ Error handling with Option/Try
- ✅ Clean separation of concerns
- ✅ Working unit tests
- ✅ Idiomatic Scala style

## Advanced Topics (Optional)

### Error Handling with Either
```scala
def parseInt(s: String): Either[String, Int] = 
  try Right(s.toInt)
  catch case _: NumberFormatException => Left(s"'$s' is not a number")

parseInt("123")  // Right(123)
parseInt("abc")  // Left("'abc' is not a number")
```

### Variance
```scala
trait Container[+A]  // Covariant: Container[Dog] is Container[Animal]
trait Processor[-A]  // Contravariant: Processor[Animal] is Processor[Dog]
trait Storage[A]     // Invariant: No relationship
```

### Futures (Async Programming)
```scala
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

val result: Future[Int] = Future {
  // Long computation
  42
}

result.map(_ * 2)  // Transform result when ready
```

## Resources for Continued Learning

- **Scala 3 Book**: https://docs.scala-lang.org/scala3/book/introduction.html
- **Scala API Docs**: https://www.scala-lang.org/api/current/
- **Scala Exercises**: https://www.scala-exercises.org/
- **Effective Scala**: Twitter's Scala best practices
- **Functional Programming in Scala** (book by Chiusano and Bjarnason)

## Assignment

Complete the capstone project in `exercise.scala`:

1. Implement all TODO methods in the data models
2. Complete the GradeService with business logic
3. Finish the ReportService for generating reports
4. Add File I/O operations in DataService
5. Create a working main application
6. Write tests in `solution.scala` (reference only)

This is a comprehensive project that ties together everything you've learned. Take your time and refer back to previous lessons as needed.

Run with: `scala exercise.scala`

Check your answer against `solution.scala` for reference
