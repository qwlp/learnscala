object Solution04 {
  def main(args: Array[String]): Unit = {
    println("=== SOLUTION 04: Data Structures ===\n")
    
    // Exercise 1: Array operations
    val numbers = Array(10, 20, 30, 40, 50)
    
    val first = numbers(0)
    val third = numbers(2)
    val last = numbers(numbers.length - 1)
    
    println(s"First: $first, Third: $third, Last: $last")
    
    // Exercise 2: Map with safe lookup
    val translations = Map(
      "hello" -> "hola",
      "world" -> "mundo",
      "cat" -> "gato"
    )
    
    // Create safe version with default value
    val safeTranslations = translations.withDefaultValue("unknown")
    val spanishHello = safeTranslations("hello")
    val spanishDog = safeTranslations("dog")
    
    println(s"\nHello in Spanish: $spanishHello")
    println(s"Dog in Spanish: $spanishDog")
    
    // Exercise 3: Set membership
    val primes = Set(2, 3, 5, 7, 11, 13, 17, 19, 23)
    
    val is7Prime = primes(7)
    val is10Prime = primes(10)
    
    println(s"\nIs 7 prime? $is7Prime")
    println(s"Is 10 prime? $is10Prime")
    
    // Exercise 4: Tuple creation and destructuring
    def divide(dividend: Int, divisor: Int): (Int, Int) = {
      (dividend / divisor, dividend % divisor)
    }
    
    val result = divide(17, 5)
    val quotient = result._1
    val remainder = result._2
    
    // Destructure the tuple
    val (q, r) = divide(23, 4)
    
    println(s"\n17 / 5 = $quotient remainder $remainder")
    println(s"23 / 4 = $q remainder $r")
    
    // Exercise 5: Mixed-type tuples
    val personInfo = ("Alice", 30, true)
    
    // Destructure and print
    val (name, age, isActive) = personInfo
    println(s"\nName: $name, Age: $age, Active: $isActive")
    
    println("\n=== Solution 04 complete! ===")
  }
}
