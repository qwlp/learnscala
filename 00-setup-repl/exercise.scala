object Exercise00 {
  def main(args: Array[String]): Unit = {
    // TODO: Complete the following REPL-style exercises
    
    // Exercise 1: Basic arithmetic
    // Calculate the sum, difference, product, and quotient of 15 and 4
    val sum = ???
    val difference = ???
    val product = ???
    val quotient = ???
    
    println(s"Sum: $sum")
    println(s"Difference: $difference")
    println(s"Product: $product")
    println(s"Quotient: $quotient")
    
    // Exercise 2: Type checking
    // What is the type of ("hello", 42, 3.14)?
    // Uncomment and fix:
    // val myTupleType: String = ("hello", 42, 3.14)
    
    // Exercise 3: Result reuse
    // Use the value from Exercise 1 to calculate new expressions
    val doubled = sum * 2
    val tripled = product * 3
    
    println(s"Doubled sum: $doubled")
    println(s"Tripled product: $tripled")
    
    // Exercise 4: Expression exploration
    // What is the result type and value of these expressions?
    val expr1 = true && false
    val expr2 = 10 / 3
    val expr3 = 10 / 3.0
    val expr4 = "Scala" + " is " + "awesome"
    
    println(s"expr1: $expr1")
    println(s"expr2: $expr2")
    println(s"expr3: $expr3")
    println(s"expr4: $expr4")
    
    println("Exercise 00 complete!")
    println("\nNote: In the actual REPL, you would:")
    println("1. Run 'scala' to start the REPL")
    println("2. Type expressions and see results immediately")
    println("3. Use :type to check types without evaluating")
    println("4. Use :save and :load to persist sessions")
  }
}
