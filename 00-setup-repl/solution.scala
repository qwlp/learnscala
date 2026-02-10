object Solution00 {
  def main(args: Array[String]): Unit = {
    println("=== SOLUTION 00: Setup & REPL ===\n")
    
    // Exercise 1: Basic arithmetic
    val sum = 15 + 4          // 19
    val difference = 15 - 4   // 11
    val product = 15 * 4      // 60
    val quotient = 15 / 4     // 3 (integer division)
    
    println(s"Sum: $sum")
    println(s"Difference: $difference")
    println(s"Product: $product")
    println(s"Quotient: $quotient")
    
    // Exercise 2: Type checking
    // The type of ("hello", 42, 3.14) is (String, Int, Double)
    val myTupleType: (String, Int, Double) = ("hello", 42, 3.14)
    println(s"\nTuple type: ${myTupleType.getClass.getSimpleName}")
    
    // Exercise 3: Result reuse
    val doubled = sum * 2      // 38
    val tripled = product * 3  // 180
    
    println(s"\nDoubled sum: $doubled")
    println(s"Tripled product: $tripled")
    
    // Exercise 4: Expression exploration
    val expr1 = true && false    // false (Boolean)
    val expr2 = 10 / 3           // 3 (Int, integer division)
    val expr3 = 10 / 3.0         // 3.333... (Double)
    val expr4 = "Scala" + " is " + "awesome"  // "Scala is awesome" (String)
    
    println(s"\nexpr1 (true && false): $expr1 (type: Boolean)")
    println(s"expr2 (10 / 3): $expr2 (type: Int)")
    println(s"expr3 (10 / 3.0): $expr3 (type: Double)")
    println(s"expr4 (string concat): $expr4 (type: String)")
    
    println("\n=== Solution 00 complete! ===")
    println("\nNote: In the actual REPL, you would:")
    println("1. Run 'scala' to start the REPL")
    println("2. Type expressions and see results immediately")
    println("3. Use :type to check types without evaluating")
    println("4. Use :save and :load to persist sessions")
  }
}
