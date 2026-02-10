# Lesson 04: Data Structures

## Lesson

### Arrays

Arrays are mutable and zero-indexed:

```scala
val a = Array(1, 2, 3, 5, 8, 13)

a(0)     // 1 - access first element
a(3)     // 5 - access fourth element
// a(21) // Throws IndexOutOfBoundsException
```

### Maps

Maps are immutable key-value stores:

```scala
val m = Map("fork" -> "tenedor", "spoon" -> "cuchara", "knife" -> "cuchillo")

m("fork")    // "tenedor"
m("spoon")   // "cuchara"
// m("bottle") // Throws NoSuchElementException

// Safe access with default values
val safeM = m.withDefaultValue("no lo se")
safeM("bottle")  // "no lo se"
```

### Sets

Sets contain unique elements and support membership testing:

```scala
val s = Set(1, 3, 7)

s(0)   // false - 0 is not in the set
s(1)   // true - 1 is in the set
s(3)   // true
```

### Tuples

Tuples hold fixed-size collections of different types:

```scala
// Creating tuples
(1, 2)
(4, 3, 2)
(1, 2, "three")  // Mixed types
```

**Why use tuples?** Functions can return multiple values:

```scala
val divideInts = (x: Int, y: Int) => (x / y, x % y)

divideInts(10, 3)  // (3, 1) - quotient and remainder
```

**Accessing tuple elements:**

```scala
val d = divideInts(10, 3)  // (3, 1)

d._1   // 3 - first element
d._2   // 1 - second element
```

**Destructuring (preferred):**

```scala
val (div, mod) = divideInts(10, 3)

div    // 3
mod    // 1
```

### Summary Table

| Structure | Mutable? | Key Features |
|-----------|----------|--------------|
| Array | Yes | Zero-indexed, fixed size |
| Map | No | Key-value pairs, fast lookup |
| Set | No | Unique elements, membership testing |
| Tuple | No | Fixed size, mixed types |

## Assignment

Complete the exercise in `exercise.scala`. Your tasks:

1. Access and manipulate array elements
2. Create a Map with safe default value lookup
3. Test membership in a Set
4. Destructure tuples and extract values

Run with: `scala exercise.scala`

Check your answer against `solution.scala`
