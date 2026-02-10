# Lesson 02: Functions

## Lesson

### Function Definition Syntax

```scala
// Basic syntax: def name(args): ReturnType = { body }
def sumOfSquares(x: Int, y: Int): Int = {
  val x2 = x * x
  val y2 = y * y
  x2 + y2  // Last expression is the return value (no 'return' keyword needed)
}

// Single expression: braces can be omitted
def sumOfSquaresShort(x: Int, y: Int): Int = x * x + y * y

// Type inference works for return types too
def square(x: Int) = x * x  // Compiler infers Int return type
```

### Calling Functions

```scala
sumOfSquares(3, 4)  // 25
```

### Named Parameters

Use parameter names to specify them in different order:

```scala
def subtract(x: Int, y: Int): Int = x - y

subtract(10, 3)       // 7
subtract(y = 10, x = 3)  // -7 (named parameters)
```

### Default Parameters

```scala
def addWithDefault(x: Int, y: Int = 5) = x + y

addWithDefault(1, 2)  // 3 (y = 2)
addWithDefault(1)     // 6 (y = 5, the default)
```

### Anonymous Functions (Lambda Syntax)

```scala
// Full syntax with parameter type
(x: Int) => x * x

// Type can be inferred from context
val sq: Int => Int = x => x * x

// Call anonymous functions
sq(10)  // 100
```

### Underscore Shorthand

When each argument is used only once:

```scala
val addOne: Int => Int = _ + 1        // equivalent to x => x + 1
val weirdSum: (Int, Int) => Int = (_ * 2 + _ * 3)

addOne(5)       // 6
weirdSum(2, 4)  // 16 (2*2 + 4*3)
```

### Function Type Declarations

```scala
// Int => Int      : function taking Int, returning Int
// (Int, Int) => Int : function taking two Ints, returning Int

val multiply: (Int, Int) => Int = (a, b) => a * b
```

### The Return Keyword (Use with Caution!)

The `return` keyword exists but should generally be avoided:

```scala
// WARNING: Using return in Scala is error-prone!
def foo(x: Int): Int = {
  val anonFunc: Int => Int = { z =>
    if (z > 5)
      return z  // Returns from foo, not anonFunc!
    else
      z + 2
  }
  anonFunc(x) + 10
}

foo(7)  // Returns 7, not 17!
```

**Best practice**: Omit `return` and let the last expression be the return value.

## Assignment

Complete the exercise in `exercise.scala`. Your tasks:

1. Implement missing function bodies
2. Convert anonymous functions to named `def` functions
3. Add default parameters to existing functions
4. Avoid using the `return` keyword

Run with: `scala exercise.scala`

Check your answer against `solution.scala`
