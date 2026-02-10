# Lesson 06: Pattern Matching

## Lesson

### Basic Pattern Matching on Case Classes

```scala
case class Person(name: String, phoneNumber: String)

def matchPerson(person: Person): String = person match {
  case Person("George", number) => s"We found George! His number is $number"
  case Person("Kate", number)   => s"We found Kate! Her number is $number"
  case Person(name, number)     => s"We matched someone: $name, phone: $number"
}
```

**Note**: Unlike switch statements in other languages, Scala cases don't need `break` - there's no fall-through.

### Matching Different Types

```scala
def matchEverything(obj: Any): String = obj match {
  // Match specific values
  case "Hello world" => "Got the string Hello world"
  
  // Match by type
  case x: Double => s"Got a Double: $x"
  
  // Match with guards (conditions)
  case x: Int if x > 10000 => "Got a pretty big number!"
  
  // Match case classes
  case Person(name, number) => s"Got contact info for $name!"
  
  // Default case (catch-all)
  case _ => "Got unknown object"
}
```

### Regular Expressions

```scala
// Create regex with .r method
val email = "(.*)@(.*)".r

// Pattern match with regex
"user@example.com" match {
  case email(name, domain) => s"Name: $name, Domain: $domain"
  case _ => "Not an email"
}
```

### Matching Tuples

```scala
val tuple = (1, 2.5, "hello")

tuple match {
  case (a: Int, b: Double, c: String) => s"Got: $a, $b, $c"
  case _ => "Different tuple structure"
}
```

### Matching Lists

```scala
val myList = List(1, 2, 3)

myList match {
  case List(1, b, c) => s"Starts with 1: 1, $b, $c"
  case List(a, b, c) => s"Three elements: $a, $b, $c"
  case Nil => "Empty list"
  case _ => "Something else"
}
```

### Nested Patterns

```scala
val nested = List(List((1, 2, "YAY")))

nested match {
  case List(List((1, 2, "YAY"))) => "Matched nested structure!"
  case _ => "No match"
}
```

### Pattern Matching as Functions

You can define functions using pattern matching:

```scala
val patternFunc: Person => String = {
  case Person("George", number) => s"George's number: $number"
  case Person(name, number) => s"Random person's number: $number"
}

patternFunc(Person("George", "1234"))  // "George's number: 1234"
```

## Assignment

Complete the exercise in `exercise.scala`. Your tasks:

1. Match case classes with different patterns
2. Use regular expressions to extract data
3. Match tuples and lists with various structures
4. Handle default cases appropriately

Run with: `scala exercise.scala`

Check your answer against `solution.scala`
