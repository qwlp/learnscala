# Lesson 05: Object-Oriented Programming

## Lesson

### Classes

Classes in Scala have constructors and methods:

```scala
class Dog(br: String) {
  // Constructor parameter becomes a field
  var breed: String = br
  
  // Method definition
  def bark: String = "Woof, woof!"
  
  // Private method (only accessible within class)
  private def sleep(hours: Int) =
    println(s"I'm sleeping for $hours hours")
}

// Usage
val mydog = new Dog("greyhound")
println(mydog.breed)  // "greyhound"
println(mydog.bark)   // "Woof, woof!"
```

### Objects (Singletons)

The `object` keyword creates a singleton (one instance only):

```scala
object Dog {
  def allKnownBreeds = List("pitbull", "shepherd", "retriever")
  def createDog(breed: String) = new Dog(breed)
}

// Usage - no 'new' needed for objects
Dog.allKnownBreeds
Dog.createDog("retriever")
```

**Companion Pattern**: A class and object with the same name:
- Class: per-instance behavior
- Object: class-level behavior (like static methods)

### Case Classes

Case classes are ideal for immutable data:

```scala
case class Person(name: String, phoneNumber: String)

// Create instances - no 'new' needed
val george = Person("George", "1234")
val kate = Person("Kate", "4567")

// Free features:
george.phoneNumber                     // Accessor
Person("George", "1234") == george     // Structural equality
val otherGeorge = george.copy(phoneNumber = "9876")  // Copy with changes
```

### Traits

Traits define interfaces with optional implementations:

```scala
trait Dog {
  def breed: String    // Abstract - must be implemented
  def color: String    // Abstract
  def bark: Boolean = true  // Concrete - default implementation
  def bite: Boolean    // Abstract
}

class SaintBernard extends Dog {
  val breed = "Saint Bernard"
  val color = "brown"
  def bite = false
}

val b = new SaintBernard
b.breed  // "Saint Bernard"
b.bark   // true (from trait)
b.bite   // false
```

### Mixins

Combine multiple traits using `with`:

```scala
trait Bark {
  def bark: String = "Woof"
}

trait Dog {
  def breed: String
  def color: String
}

// Extends first trait, mixes in others with 'with'
class SaintBernard extends Dog with Bark {
  val breed = "Saint Bernard"
  val color = "brown"
}

val b = new SaintBernard
b.bark   // "Woof" - from Bark trait
```

## Assignment

Complete the exercise in `exercise.scala`. Your tasks:

1. Implement a class with methods and private members
2. Create a case class and use its auto-generated methods
3. Implement a trait and create a class that extends it
4. Use mixins to combine multiple traits

Run with: `scala exercise.scala`

Check your answer against `solution.scala`
