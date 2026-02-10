# Lesson 08: Implicits

## Lesson

**WARNING**: Implicits are powerful but easy to abuse. Understand them well before using them in your own code.

### Implicit Values

Declare values as implicit to make them eligible for automatic use:

```scala
implicit val myImplicitInt = 100
implicit val greeting = "Hello"

// Can still use normally
myImplicitInt + 2  // 102
```

### Implicit Function Parameters

Functions can have implicit parameter lists:

```scala
def sendGreetings(toWhom: String)(implicit howMany: Int) =
  s"Hello $toWhom, $howMany blessings to you!"

// Explicit call
sendGreetings("John")(1000)  // "Hello John, 1000 blessings to you!"

// With implicit value in scope
implicit val myImplicitInt = 100
sendGreetings("Jane")  // "Hello Jane, 100 blessings to you!"
```

The compiler finds and supplies the implicit value automatically.

### Implicit Conversions

Implicit functions can automatically convert types:

```scala
case class Dog(breed: String) {
  def bark = "Woof, woof!"
}

implicit def stringToDog(breed: String) = Dog("Golden " + breed)

// String is automatically converted to Dog
"Retriever".breed  // "Golden Retriever"
"Shepherd".bark    // "Woof, woof!"
```

**Note**: The compiler should warn you about defining implicit conversions - use with caution!

### Type Classes Pattern

Implicits enable type classes (common in Scala libraries):

```scala
// These two are equivalent:
def foo[T](implicit c: C[T]) = ...
def foo[T : C] = ...  // Context bound syntax
```

The `implicitly` method retrieves implicit values:

```scala
def max[T](a: T, b: T)(implicit ord: Ordering[T]): T =
  if (ord.gt(a, b)) a else b

// Or using implicitly:
def max[T : Ordering](a: T, b: T): T = {
  val ord = implicitly[Ordering[T]]
  if (ord.gt(a, b)) a else b
}
```

### Implicit Scope

The compiler looks for implicits in:
1. Local scope
2. Imported scope
3. Companion objects of types involved

```scala
// In companion object - always available
object Dog {
  implicit val defaultDog = Dog("Unknown")
}
```

### Best Practices

1. **Don't overuse implicits** - they make code harder to understand
2. **Use implicit parameters** for type classes and configuration
3. **Avoid implicit conversions** unless absolutely necessary
4. **Keep implicit values close** - don't scatter them across files
5. **Use explicit imports** for implicits from libraries

## Assignment

Complete the exercise in `exercise.scala`. Your tasks:

1. Define and use implicit parameters
2. Create an implicit conversion (with caution)
3. Use implicit scope for automatic value injection
4. Understand when NOT to use implicits

Run with: `scala exercise.scala`

Check your answer against `solution.scala`
