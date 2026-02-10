# Lesson 01: Basics

## Lesson

### Comments

```scala
// Single-line comment starts with two forward slashes

/*
  Multi-line comments look like this.
  They can span multiple lines.
*/
```

### Printing Output

```scala
// Print with a newline
println("Hello world!")
println(10)

// Print without newline
print("Hello ")
print("World")
// Output: Hello World
```

### Variables: val vs var

```scala
// val - immutable (preferred)
val x = 10
// x = 20  // ERROR: reassignment to val

// var - mutable
var y = 10
y = 20     // OK: y is now 20
```

### Type Declarations

Scala uses **type inference** - the compiler guesses types automatically:

```scala
val x = 10           // Int
val a = 1.0          // Double

// Explicit type declarations
val z: Int = 10
val b: Double = 1.0

// Automatic type conversion
val c: Double = 10   // Int 10 becomes Double 10.0
```

### Boolean Values and Operations

```scala
true
false

!true          // false (not)
!false         // true
true == false  // false (equality)
10 > 5         // true
```

### Math Operators

```scala
1 + 1    // 2
2 - 1    // 1
5 * 3    // 15
6 / 2    // 3
6 / 4    // 1 (integer division)
6.0 / 4  // 1.5 (floating point)
```

### String Operations

```scala
// Basic methods
"hello world".length           // 11
"hello world".substring(2, 6)  // "llo "
"hello world".replace("l", "L") // "heLLo worLd"

// Scala-specific methods
"hello world".take(5)  // "hello"
"hello world".drop(5)  // " world"
```

### String Interpolation

```scala
val n = 45
val apples = 10

// s-interpolator: basic interpolation
s"We have $n apples"                    // "We have 45 apples"
s"Double is ${n * 2}"                   // "Double is 90"

// f-interpolator: formatted strings
f"Value: ${math.pow(5, 2)}%1.0f"        // "Value: 25"
f"Pi: ${math.Pi}%1.4f"                  // "Pi: 3.1416"

// raw-interpolator: ignore escape characters
raw"New line: \n Tab: \t"               // "New line: \n Tab: \t"
```

### Escape Characters and Multi-line Strings

```scala
// Escape characters with backslash
"They stood outside the \"Rose and Crown\""

// Triple quotes for multi-line strings
val html = """<form id="daform">
  <p>Press belo', Joe</p>
  <input type="submit">
</form>"""
```

## Assignment

Complete the exercise in `exercise.scala`. Your tasks:

1. Fix the variable declaration errors
2. Create formatted strings using interpolation
3. Convert between numeric types
4. Practice string operations

Run with: `scala exercise.scala`

Check your answer against `solution.scala`
