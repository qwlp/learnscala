# Lesson 03: Flow Control

## Lesson

### Range Expressions

```scala
1 to 5        // Range(1, 2, 3, 4, 5)
1 until 5     // Range(1, 2, 3, 4) - exclusive
5 to 1 by -1  // Range(5, 4, 3, 2, 1) - descending
```

### foreach Iteration

```scala
val r = 1 to 5

// Standard syntax
r.foreach(println)

// Operator notation (no dots/brackets)
r foreach println

// With lambda
r.foreach(x => println(x * 2))
```

### While Loops

```scala
var i = 0
while (i < 10) {
  println("i = " + i)
  i += 1
}
```

### Do-While Loops

```scala
var i = 0
do {
  println("i is still less than 10")
  i += 1
} while (i < 10)
```

### Recursion (Idiomatic in Scala)

Recursion is the preferred way to repeat actions in functional programming:

```scala
// Recursive functions need explicit return types
def showNumbersInRange(a: Int, b: Int): Unit = {
  print(a + " ")
  if (a < b)
    showNumbersInRange(a + 1, b)
}

showNumbersInRange(1, 5)  // 1 2 3 4 5
```

### Conditionals as Expressions

In Scala, `if/else` is an expression that returns a value:

```scala
val x = 10

// Statement style
if (x == 10) println("yeah")

// Expression style (preferred)
val text = if (x == 10) "yeah" else "nope"

// Can be used directly
println(if (x == 10) "it's ten" else "not ten")
```

### Combining Concepts

```scala
// Process a range with foreach
(1 to 10).foreach { n =>
  val result = if (n % 2 == 0) "even" else "odd"
  println(s"$n is $result")
}
```

## Assignment

Complete the exercise in `exercise.scala`. Your tasks:

1. Convert a while loop to use recursion instead
2. Fix a recursive function with missing base cases
3. Use conditionals as expressions to assign values
4. Iterate over ranges using different methods

Run with: `scala exercise.scala`

Check your answer against `solution.scala`
