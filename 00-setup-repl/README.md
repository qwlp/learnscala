# Lesson 00: Setup & REPL

## Lesson

### Setting Up Scala

Before you start coding in Scala, you need to install it:

1. Download Scala from http://www.scala-lang.org/downloads
2. Unzip/untar to your favorite location
3. Put the `bin` subdirectory in your `PATH` environment variable

### The REPL

Scala has a tool called the **REPL** (Read-Eval-Print Loop) - an interactive shell where you can type expressions and see results immediately.

**Starting the REPL:**

```bash
$ scala
scala>
```

### Basic REPL Usage

**Evaluating expressions:**
```scala
scala> 2 + 2
res0: Int = 4
```

**Reusing results:**
```scala
scala> res0 + 2
res1: Int = 6
```

**Checking types without evaluation:**
```scala
scala> :type (true, 2.0)
(Boolean, Double)
```

### REPL Commands

| Command | Description |
|---------|-------------|
| `:type <expr>` | Show the type of an expression without evaluating it |
| `:save <file>` | Save the current REPL session to a file |
| `:load <file>` | Load and execute a Scala file |
| `:h` or `:history` | Show command history |
| `:h?` | Show history with line numbers |
| `:quit` or `:q` | Exit the REPL |

### Example Session

```scala
scala> :save /tmp/my-session.scala
scala> :load /tmp/my-session.scala
Loading /tmp/my-session.scala...
res2: Int = 4
res3: Int = 6
scala> :h?
1  2 + 2
2  res0 + 2
3  :save /tmp/my-session.scala
4  :load /tmp/my-session.scala
5  :h?
```

## Assignment

Complete the exercise in `exercise.scala`. Your tasks:

1. Practice basic arithmetic operations in the REPL
2. Use `:type` to inspect the types of various expressions
3. Save your session and reload it
4. Explore the command history

Run with: `scala exercise.scala`

Check your answer against `solution.scala`
