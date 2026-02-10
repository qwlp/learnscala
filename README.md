# Learn Scala - Tutorial Lessons

A comprehensive Scala tutorial structured into 10 progressive lessons, each with detailed explanations, hands-on exercises, and complete solutions.

## Course Overview

This course transforms the monolithic Scala tutorial into structured, digestible lessons that build upon each other. Each lesson includes:
- **README.md** - Detailed lesson content with code examples
- **exercise.scala** - Hands-on exercises with TODOs to complete
- **solution.scala** - Complete working solutions with explanations

## Prerequisites

- Scala 3.x installed on your system
- Basic programming knowledge (helpful but not required)
- Terminal/Command line familiarity

## Getting Started

```bash
# Clone or navigate to this directory
cd learn-scala-lessons

# Run any solution to see the output
scala 01-basics/solution.scala

# Work on an exercise
# Edit 01-basics/exercise.scala and fill in the ??? sections
# Then run it to test your solution
scala 01-basics/exercise.scala
```

## Lesson Structure

### Lesson 00: Setup & REPL
Learn to use Scala's interactive shell (REPL) for experimentation.
- Installing Scala
- REPL commands (`:type`, `:save`, `:load`, `:h`)
- Basic expressions and type checking
- Session management

### Lesson 01: Basics
Master the fundamental building blocks of Scala.
- Comments and printing
- Variables: `val` vs `var`
- Type inference and explicit types
- Type conversions
- Boolean operations and math
- String operations and interpolation
- Escape characters

### Lesson 02: Functions
Learn to define and use functions effectively.
- Function syntax and return types
- Named parameters and default values
- Anonymous functions (lambdas)
- Underscore shorthand
- The `return` keyword (and why to avoid it)

### Lesson 03: Flow Control
Control the flow of your programs.
- Range expressions
- `foreach` iteration
- While and do-while loops
- Recursion (idiomatic Scala)
- Conditionals as expressions

### Lesson 04: Data Structures
Work with Scala's essential data structures.
- Arrays (mutable, zero-indexed)
- Maps (key-value stores)
- Sets (membership testing)
- Tuples (fixed-size, mixed types)
- Destructuring

### Lesson 05: Object-Oriented Programming
Understand Scala's OOP features.
- Classes and constructors
- Methods and access modifiers
- Objects (singletons)
- Case classes (immutable data)
- Traits and mixins

### Lesson 06: Pattern Matching
Harness the power of pattern matching.
- Case class matching
- Type matching
- Guards and conditions
- Regular expressions
- Tuple and list patterns

### Lesson 07: Functional Programming
Embrace the functional paradigm.
- Higher-order functions
- `map`, `filter`, `reduce`
- Anonymous functions
- For-comprehensions
- Chaining operations

### Lesson 08: Implicits
Understand Scala's implicit system.
- Implicit values
- Implicit parameters
- Type classes
- Implicit conversions (with caution!)
- Best practices

### Lesson 09: Misc
Practical topics for real-world programming.
- Import statements (various styles)
- Entry points (`main` method)
- File I/O (reading and writing)
- Resource management

## Exercise Difficulty

| Lesson | Easy (Fill-in) | Medium (Write) | Hard (Combine) |
|--------|----------------|-----------------|----------------|
| 00 Setup | 60% | 30% | 10% |
| 01 Basics | 40% | 40% | 20% |
| 02 Functions | 30% | 50% | 20% |
| 03 Flow Control | 30% | 40% | 30% |
| 04 Data Structures | 40% | 40% | 20% |
| 05 OOP | 30% | 40% | 30% |
| 06 Pattern Matching | 30% | 50% | 20% |
| 07 Functional Programming | 20% | 50% | 30% |
| 08 Implicits | 40% | 40% | 20% |
| 09 Misc | 50% | 30% | 20% |

## Recommended Learning Path

1. **Start with Lesson 00** - Get familiar with the REPL
2. **Complete lessons in order** - Each builds on the previous
3. **Read the README first** - Understand the concepts
4. **Try the exercises** - Fill in the `???` sections
5. **Check your work** - Compare with the solutions
6. **Experiment** - Modify the code and see what happens

## Tips for Success

- **Use the REPL**: Test small code snippets interactively
- **Type everything**: Don't just copy-paste; type the code yourself
- **Make mistakes**: Errors are learning opportunities
- **Experiment**: Change the code and observe the results
- **Build projects**: Apply what you learn to small projects

## Original Source

This course is based on the [learnscala.scala](learnscala.scala) file (731 lines), reorganized into a structured learning experience.

## Additional Resources

- [Scala Official Documentation](https://docs.scala-lang.org/)
- [Scala 3 Book](https://docs.scala-lang.org/scala3/book/introduction.html)
- [Scala API](https://www.scala-lang.org/api/current/)

## License

This tutorial is for educational purposes. Feel free to use and modify it for learning.

Happy coding! 🚀
