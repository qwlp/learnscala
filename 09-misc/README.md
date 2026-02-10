# Lesson 09: Misc

## Lesson

### Import Statements

Scala has flexible import syntax:

```scala
// Import a single class
import scala.collection.immutable.List

// Import everything from a package (wildcard)
import scala.collection.immutable._

// Import multiple classes
import scala.collection.immutable.{List, Map}

// Rename an import
import scala.collection.immutable.{List => ImmutableList}
val myList = ImmutableList(1, 2, 3)

// Import everything EXCEPT certain classes
import scala.collection.immutable.{Map => _, Set => _, _}
// Now Map and Set are not imported, but everything else is

// Java classes work too
import javax.swing.{JFrame, JWindow}
```

### Entry Point

Every Scala program needs an entry point:

```scala
object Application {
  def main(args: Array[String]): Unit = {
    // Your program starts here
    println("Hello, World!")
  }
}
```

Or extend App for a simpler syntax:

```scala
object Application extends App {
  println("Hello, World!")
}
```

### File I/O

**Reading Files:**

```scala
import scala.io.Source

// Read file line by line
for (line <- Source.fromFile("myfile.txt").getLines()) {
  println(line)
}

// Or read all lines
val lines = Source.fromFile("myfile.txt").getLines().toList
```

**Writing Files:**

```scala
import java.io.PrintWriter

val writer = new PrintWriter("myfile.txt")
writer.write("First line" + util.Properties.lineSeparator)
writer.write("Second line" + util.Properties.lineSeparator)
writer.close()
```

**Using try-finally for safety:**

```scala
val writer = new PrintWriter("output.txt")
try {
  writer.write("Important data" + util.Properties.lineSeparator)
  writer.write("More data")
} finally {
  writer.close()
}
```

### Compilation

```bash
# Compile a Scala file
scalac MyProgram.scala

# Run the compiled program
scala MyProgram

# Or run directly (interprets the file)
scala MyProgram.scala
```

### Multiple Classes in One File

A single `.scala` file can contain multiple classes and objects:

```scala
class Person(name: String)
class Dog(breed: String)

object Utils {
  def greet(name: String) = s"Hello, $name!"
}

object Application {
  def main(args: Array[String]): Unit = {
    val p = new Person("Alice")
    println(Utils.greet("World"))
  }
}
```

## Assignment

Complete the exercise in `exercise.scala`. Your tasks:

1. Write a file using PrintWriter with proper resource handling
2. Read the file back and process its contents
3. Create a complete runnable entry point object
4. Practice different import styles

Run with: `scala exercise.scala`

Check your answer against `solution.scala`
