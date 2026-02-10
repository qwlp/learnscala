object Exercise06 {
  def main(args: Array[String]): Unit = {
    // TODO: Complete the pattern matching exercises
    
    // Exercise 1: Pattern match on case classes
    case class Person(name: String, age: Int, city: String)
    
    def describePerson(person: Person): String = person match {
      // TODO: Add pattern for "Alice" - return "Found Alice from [city]"
      // case Person("Alice", _, city) => ???
      
      // TODO: Add pattern for minors (age < 18) - return "[name] is a minor"
      // case Person(name, age, _) if age < 18 => ???
      
      // TODO: Add pattern for seniors (age >= 65) - return "[name] is a senior"
      // case Person(name, age, _) if age >= 65 => ???
      
      // Default case
      case Person(name, age, city) => s"$name ($age years old) from $city"
    }
    
    val alice = Person("Alice", 30, "NYC")
    val bob = Person("Bob", 15, "LA")
    val carol = Person("Carol", 70, "Chicago")
    val dave = Person("Dave", 25, "Miami")
    
    println(describePerson(alice))
    println(describePerson(bob))
    println(describePerson(carol))
    println(describePerson(dave))
    
    // Exercise 2: Pattern match with regular expressions
    val emailPattern = "(.*)@(.*)\\.(.*)".r
    val phonePattern = "(\\d{3})-(\\d{3})-(\\d{4})".r
    
    def extractInfo(text: String): String = text match {
      // TODO: Match email pattern and return "Email: [user] at [domain].[tld]"
      // case emailPattern(user, domain, tld) => ???
      
      // TODO: Match phone pattern and return "Phone: ([area]) [prefix]-[line]"
      // case phonePattern(area, prefix, line) => ???
      
      case _ => s"Unknown format: $text"
    }
    
    println(extractInfo("user@example.com"))
    println(extractInfo("555-123-4567"))
    println(extractInfo("random text"))
    
    // Exercise 3: Pattern match on tuples
    def analyzeTuple(t: Any): String = t match {
      // TODO: Match tuple of 2 Ints - return "Pair of ints: [a], [b]"
      // case (a: Int, b: Int) => ???
      
      // TODO: Match tuple of (String, Int) - return "[name] is [age] years old"
      // case (name: String, age: Int) => ???
      
      // TODO: Match tuple of 3 elements - return "Triple: [a], [b], [c]"
      // case (a, b, c) => ???
      
      case _ => s"Something else: $t"
    }
    
    println(analyzeTuple((1, 2)))
    println(analyzeTuple(("Alice", 30)))
    println(analyzeTuple((1, 2, 3)))
    println(analyzeTuple("just a string"))
    
    // Exercise 4: Pattern match on lists
    def analyzeList(lst: List[Int]): String = lst match {
      // TODO: Match empty list - return "Empty list"
      // case Nil => ???
      
      // TODO: Match single element - return "Single element: [x]"
      // case List(x) => ???
      
      // TODO: Match exactly 2 elements - return "Two elements: [a], [b]"
      // case List(a, b) => ???
      
      // TODO: Match list starting with 1 - return "Starts with 1: [rest]"
      // case 1 :: rest => ???
      
      // TODO: Match any list with head and tail - return "Head: [h], Tail: [t]"
      // case h :: t => ???
      
      case _ => s"Unknown list: $lst"
    }
    
    println(analyzeList(Nil))
    println(analyzeList(List(42)))
    println(analyzeList(List(1, 2)))
    println(analyzeList(List(1, 2, 3, 4)))
    println(analyzeList(List(5, 6, 7)))
    
    println("Exercise 06 complete!")
  }
}
