# Lesson 07: Functional Programming

## Lesson

### Higher-Order Functions

Functions that take or return other functions:

```scala
// A function taking an Int and returning an Int
val add10: Int => Int = _ + 10

// Pass function to map
List(1, 2, 3).map(add10)  // List(11, 12, 13)
```

### Anonymous Functions

```scala
// With explicit parameter
List(1, 2, 3).map(x => x + 10)  // List(11, 12, 13)

// With underscore shorthand
List(1, 2, 3).map(_ + 10)       // List(11, 12, 13)

// Even shorter when both take one argument
List("Dom", "Bob", "Natalia").foreach(println)
```

### Common Combinators

**map** - transform each element:
```scala
val numbers = Set(1, 2, 3)
numbers.map(x => x * x)  // Set(1, 4, 9)
```

**filter** - keep elements matching a predicate:
```scala
List(1, 2, 3, 4, 5).filter(_ > 2)  // List(3, 4, 5)

case class Person(name: String, age: Int)
List(
  Person("Dom", 23),
  Person("Bob", 30)
).filter(_.age > 25)  // List(Person("Bob", 30))
```

**reduce** - combine all elements:
```scala
val numbers = List(1, 2, 3, 4)
numbers.reduce(_ + _)  // 10 (1+2+3+4)
```

### Chaining Operations

```scala
val result = Set(1, 2, 3, 4, 5)
  .map(x => x * x)      // Square each: Set(1, 4, 9, 16, 25)
  .filter(_ < 10)       // Keep less than 10: Set(1, 4, 9)
  .reduce(_ + _)        // Sum: 14
```

### foreach for Side Effects

```scala
val numbers = List(1, 2, 3, 4, 10, 20, 100)

// With lambda
numbers.foreach(x => println(x))

// Shorthand
numbers.foreach(println)
```

### For Comprehensions

For-comprehensions provide a clean syntax for chains of operations:

```scala
val s = Set(1, 2, 3)

// Equivalent to s.map(x => x * x)
for { n <- s } yield n * n  // Set(1, 4, 9)

// With filter (guard)
for { n <- s if n < 3 } yield n * n  // Set(1, 4)

// Multiple generators
for {
  x <- List(1, 2)
  y <- List("a", "b")
} yield (x, y)
// List((1,"a"), (1,"b"), (2,"a"), (2,"b"))

// With intermediate values
for {
  n <- s
  squared = n * n
  if squared < 10
} yield squared
// Set(1, 4, 9)
```

**Important**: For-comprehensions define relationships between data sets, they're not loops!

## Assignment

Complete the exercise in `exercise.scala`. Your tasks:

1. Chain `map` and `filter` operations
2. Convert for-comprehensions to `map`/`filter` chains
3. Use `reduce` with custom combining functions
4. Practice anonymous function syntax

Run with: `scala exercise.scala`

Check your answer against `solution.scala`
