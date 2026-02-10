object Solution06 {
  def main(args: Array[String]): Unit = {
    println("=== SOLUTION 06: Pattern Matching ===\n")
    
    // Exercise 1: Pattern match on case classes
    case class Person(name: String, age: Int, city: String)
    
    def describePerson(person: Person): String = person match {
      case Person("Alice", _, city) => s"Found Alice from $city"
      case Person(name, age, _) if age < 18 => s"$name is a minor"
      case Person(name, age, _) if age >= 65 => s"$name is a senior"
      case Person(name, age, city) => s"$name ($age years old) from $city"
    }
    
    val alice = Person("Alice", 30, "NYC")
    val bob = Person("Bob", 15, "LA")
    val carol = Person("Carol", 70, "Chicago")
    val dave = Person("Dave", 25, "Miami")
    
    println("Pattern matching on case classes:")
    println(s"  ${describePerson(alice)}")
    println(s"  ${describePerson(bob)}")
    println(s"  ${describePerson(carol)}")
    println(s"  ${describePerson(dave)}")
    
    // Exercise 2: Pattern match with regular expressions
    val emailPattern = "(.*)@(.*)\\.(.*)".r
    val phonePattern = "(\\d{3})-(\\d{3})-(\\d{4})".r
    
    def extractInfo(text: String): String = text match {
      case emailPattern(user, domain, tld) => s"Email: $user at $domain.$tld"
      case phonePattern(area, prefix, line) => s"Phone: ($area) $prefix-$line"
      case _ => s"Unknown format: $text"
    }
    
    println("\nPattern matching with regex:")
    println(s"  ${extractInfo("user@example.com")}")
    println(s"  ${extractInfo("555-123-4567")}")
    println(s"  ${extractInfo("random text")}")
    
    // Exercise 3: Pattern match on tuples
    def analyzeTuple(t: Any): String = t match {
      case (a: Int, b: Int) => s"Pair of ints: $a, $b"
      case (name: String, age: Int) => s"$name is $age years old"
      case (a, b, c) => s"Triple: $a, $b, $c"
      case _ => s"Something else: $t"
    }
    
    println("\nPattern matching on tuples:")
    println(s"  ${analyzeTuple((1, 2))}")
    println(s"  ${analyzeTuple(("Alice", 30))}")
    println(s"  ${analyzeTuple((1, 2, 3))}")
    println(s"  ${analyzeTuple("just a string")}")
    
    // Exercise 4: Pattern match on lists
    def analyzeList(lst: List[Int]): String = lst match {
      case Nil => "Empty list"
      case List(x) => s"Single element: $x"
      case List(a, b) => s"Two elements: $a, $b"
      case 1 :: rest => s"Starts with 1: $rest"
      case h :: t => s"Head: $h, Tail: $t"
      case _ => s"Unknown list: $lst"
    }
    
    println("\nPattern matching on lists:")
    println(s"  ${analyzeList(Nil)}")
    println(s"  ${analyzeList(List(42))}")
    println(s"  ${analyzeList(List(1, 2))}")
    println(s"  ${analyzeList(List(1, 2, 3, 4))}")
    println(s"  ${analyzeList(List(5, 6, 7))}")
    
    println("\n=== Solution 06 complete! ===")
  }
}
