object Exercise04 {
  def main(args: Array[String]): Unit = {
    // TODO: Complete the exercises below
    
    // Exercise 1: Array operations
    val numbers = Array(10, 20, 30, 40, 50)
    
    // Access specific elements
    val first = ???  // Get first element
    val third = ???  // Get third element
    val last = ???   // Get last element
    
    println(s"First: $first, Third: $third, Last: $last")
    
    // Exercise 2: Map with safe lookup
    val translations = Map(
      "hello" -> "hola",
      "world" -> "mundo",
      "cat" -> "gato"
    )
    
    // These should throw exceptions - fix them
    // val spanishHello = translations("hello")
    // val spanishDog = translations("dog")  // This will fail!
    
    // Create a safe version with default value "unknown"
    val safeTranslations = ???
    val spanishHello = safeTranslations("hello")
    val spanishDog = safeTranslations("dog")
    
    println(s"Hello in Spanish: $spanishHello")
    println(s"Dog in Spanish: $spanishDog")
    
    // Exercise 3: Set membership
    val primes = Set(2, 3, 5, 7, 11, 13, 17, 19, 23)
    
    val is7Prime = ???   // Check if 7 is in the set
    val is10Prime = ???  // Check if 10 is in the set
    
    println(s"Is 7 prime? $is7Prime")
    println(s"Is 10 prime? $is10Prime")
    
    // Exercise 4: Tuple creation and destructuring
    // Create a function that returns quotient and remainder
    def divide(dividend: Int, divisor: Int) = {
      // Return a tuple (quotient, remainder)
      ???
    }
    
    val result = divide(17, 5)
    val quotient = result._1
    val remainder = result._2
    
    // Destructure the tuple
    val (q, r) = divide(23, 4)
    
    println(s"17 / 5 = $quotient remainder $remainder")
    println(s"23 / 4 = $q remainder $r")
    
    // Exercise 5: Mixed-type tuples
    // Create a tuple with (String, Int, Boolean)
    val personInfo = ("Alice", 30, true)
    
    // Destructure and print
    // val (name, age, isActive) = personInfo
    // println(s"Name: $name, Age: $age, Active: $isActive")
    
    println("Exercise 04 complete!")
  }
}
